package com.EXTRAJEET.server;



import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;



import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BackUpServer {



    public static String getLogs(XmlReader xmlReader,Logs log ,boolean root) {
    	String jumpServerHost=xmlReader.getHost();
    	String jumpServerUsername=xmlReader.getUserName();
    	String jumpServerPassword=xmlReader.getHostPass();
    	String targetServerHost=xmlReader.getBackupip();
    	String targetServerUsername =xmlReader.getBackupuser();
    	String targetServerPassword=xmlReader.getBKpassword();
    	String commandToRun=log.getBackup();
    	String txn =log.getTxnID();
    	Session jumpSession =null;
    	Session targetSession =null;
    	
        String uniqueId="";
        String txnLog="";
        
        if(log.getAppName().contains("mk")) {
        	  targetServerHost = xmlReader.getPRODBackupip();
              targetServerUsername = xmlReader.getPRODbackupuser();
              targetServerPassword = xmlReader.getPRODBKpassword();
        }        
        
     try {
       System.out.println("Start of Connection ");
       if(xmlReader.isProd()) {    
    	   targetSession=jumpSession = connectToServer(targetServerHost, targetServerUsername, targetServerPassword);
       }else if(root){
    	   jumpSession = ProdServerAcces.getSession(xmlReader,log);
    	  targetSession = connectToServerThroughJumpServer(jumpSession, targetServerHost, targetServerUsername, targetServerPassword);
       }else {
    	   jumpSession = connectToServer(jumpServerHost, jumpServerUsername, jumpServerPassword);
    	   targetSession = connectToServerThroughJumpServer(jumpSession, targetServerHost, targetServerUsername, targetServerPassword);
    	   
       }

           txnLog=  runCommandOnServer(targetSession, commandToRun);
//            runCommandOnServer(targetSession, "ls");
            
            
            String [] txnLogArray =txnLog.split(" - ");
        	for(int i =0;i<txnLogArray.length;i++) {
        		if(txnLogArray[i].contains("Generated Aurus Transaction ID")) {
        			System.out.println("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(1,37)));
        		}
        	}        	
            if(uniqueId.length()!=36) {
            	
       		 txnLogArray =txnLog.split("[\\[\\]]");
         	for(int i =0;i<txnLogArray.length;i++) {
         		if(txnLogArray[i].contains("SO.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,3).equals("SO.")))) {
         			System.out.println("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
         			break;
         		}else if(txnLogArray[i].contains("SM.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,3).equals("SM.")))) {
         			System.out.println("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
         			break;
         		}else if(txnLogArray[i].contains("SPO.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,4).equals("SPO.")))) {
         			System.out.println("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
         			break;
         		}
         	
         	}
         	 if(uniqueId.length()!=36) {
            	
            	return "";
            }    
            }
            commandToRun=commandToRun.replaceFirst(txn,uniqueId);
             txnLog=  runCommandOnServer(targetSession, commandToRun);
             
            
            disconnectFromServer(targetSession);
            disconnectFromServer(jumpSession);

        } catch (Exception e) {
        	disconnectFromServer(targetSession);
            disconnectFromServer(jumpSession);
            e.printStackTrace();
        }
       log.setUniqueId(uniqueId);
		return uniqueId+"\n"+txnLog;
    }

    private static Session connectToServer(String host, String username, String password) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, 22);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        System.out.println("SFTP Connection ::: "+session.isConnected());
        return session;
    }

    public static Session connectToServerThroughJumpServer(Session jumpSession, String host, String username, String password) throws Exception {
    	
    	int startingPort = 8080; 

        int forwardedPort = findAvailablePort(startingPort);
        System.out.println("Available Port on Laptop : " + forwardedPort);
    	
        jumpSession.setPortForwardingL(forwardedPort, host, 22);

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, "127.0.0.1", forwardedPort);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        //session.setConfig("PreferredAuthentications", "password");
        session.connect();
        System.out.println("SFTP Connection Jump Serever ::: "+session.isConnected());
        return session;
    }

    private static String runCommandOnServer(Session session, String command) throws Exception {
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);

        channel.connect();
        InputStream commandOutput = channel.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(commandOutput));
        channel.connect();
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
           
        }

      
        System.out.println("result ::: "+result.toString());
        channel.disconnect();
        return result.toString();
    }

    private static void disconnectFromServer(Session session) {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }
    
    
    
    public static int findAvailablePort(int startingPort) {
        int maxPort = 65535; // Maximum port number
        for (int port = startingPort; port <= maxPort; port++) {
            if (isPortAvailable(port)) {
                return port;
            }
        }
        throw new RuntimeException("No available port found in the range.");
    }

    private static boolean isPortAvailable(int port) {
        try (ServerSocket ignored = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}