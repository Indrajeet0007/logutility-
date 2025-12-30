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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdServerAcces {
	
	private static Session uat42Session = null;
	private static Session uatAppSession = null;
    private static Session uatTempSession = null;
    private static Session prodTempSession = null;     
    private static Session prodSession = null;

    private static final Logger LOGGER = Logger.getLogger(ProdServerAcces.class.getName());

    public static void main(String[] args) {
    	
    	    
}
    @Override 
    protected void finalize()   
    {   
        System.out.println("finalize method called");       
        disconnectFromServer(uat42Session);
        disconnectFromServer(uatAppSession);
        disconnectFromServer(uatTempSession);
        disconnectFromServer(prodTempSession);
        disconnectFromServer(prodSession);    
    	
    }
    public static Session getSession(XmlReader xmlReader , Logs log) {         
        try {     
        if(uat42Session==null||(uat42Session!=null && !uat42Session.isConnected())) {        	
        	uat42Session = connectToServer(xmlReader.getHost(), xmlReader.getUserName(), xmlReader.getHostPass());	
        	System.out.println("Main Method uat42Session : "+uat42Session);
        }
        if(uatAppSession==null||(uatAppSession!=null && !uatAppSession.isConnected())) {
		if(uat42Session!=null && uat42Session.isConnected()) {
    	uatAppSession = connectToServerThroughJumpServer(uat42Session, "192.168.50.152", xmlReader.getUserName(), xmlReader.getHostPass());
    	System.out.println("Main Method uatAppSession : "+uatAppSession);
		  }
        }
        if(uatTempSession==null||(uatTempSession!=null && !uatTempSession.isConnected())) {
        if(uatAppSession!=null && uatAppSession.isConnected()) {
        uatTempSession = connectToServerThroughJumpServer(uatAppSession, "192.168.41.124", xmlReader.getUserName(), xmlReader.getHostPass());
        System.out.println("Main Method uatTempSession : "+uatTempSession);
        }
        }
        if(prodTempSession==null||(prodTempSession!=null && !prodTempSession.isConnected())) {
        if(uatTempSession!=null && uatTempSession.isConnected()) {
        prodTempSession = connectToServerThroughJumpServer(uatTempSession, "172.22.133.123", xmlReader.getUserName(), xmlReader.getHostPass());        
        System.out.println("Main Method uatTempSession : "+uatTempSession);
        } 
        }                
         
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        return prodTempSession;
    }
    
    public static String getLog(XmlReader xmlReader, Logs log) {
    	String txn=log.getTxnID();
    	String txnLog="";
    	String uniqueId="";
    	String commandToRun=log.getCmd();
    	try {
    		prodTempSession = ProdServerAcces.getSession(xmlReader,log);
			prodSession = connectToServerThroughJumpServer(prodTempSession, log.getIp(), xmlReader.getUserName(), log.getPass());

         if(prodSession!=null && prodSession.isConnected()) {
                    try {
						txnLog = runCommandOnServer(prodSession, commandToRun);
					
                     uniqueId = extractUniqueId(txnLog);
                     System.out.println("Unique Id : "+uniqueId);
                     if (uniqueId.isEmpty()) {
                         return "";
                     }
                     System.out.println("Main Method Command : "+commandToRun);
                     
                     commandToRun = commandToRun.replaceFirst(txn, uniqueId);
                     System.out.println("Command To Run : "+commandToRun);
                     txnLog = runCommandOnServer(prodSession, commandToRun);
                     
                    } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         }else {
         LOGGER.info("Unable to Connect to Prod Session");
         }
    	
    	} catch (Exception e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	        }
    	return txnLog;
    }
    private static Session connectToServer(String host, String username, String password) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, 22);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        LOGGER.info("SFTP Connection : "+ ""+ " : "+ session.isConnected());
        return session;
    }

    public static Session connectToServerThroughJumpServer(Session jumpSession, String host, String username, String password) throws Exception {
        int startingPort = 8080;
        int forwardedPort = findAvailablePort(startingPort);
        LOGGER.info("Available Port on Laptop : " + forwardedPort);
        jumpSession.setPortForwardingL(forwardedPort, host, 22);
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, "127.0.0.1", forwardedPort);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        LOGGER.info("SFTP Connection through Jump Server: "+""+" : " + session.isConnected());
        return session;
    }

    private static String runCommandOnServer(Session session, String command) throws Exception {
    System.out.println("Command is : "+command);
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);
        channel.connect();

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } finally {
            channel.disconnect();
        }
        LOGGER.info("Command result: " + result.toString());
        return result.toString();
    }

    private static void disconnectFromServer(Session session) {
        if (session != null && session.isConnected()) {
            session.disconnect();
            System.out.println("Session Disconnect : "+session);
        }else {
        System.out.println("Session Not Avaliabe for Disconnect : "+session);
        }
    }

    private static int findAvailablePort(int startingPort) {
        int maxPort = 65535;
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

    private static String extractUniqueId(String txnLog) {
      LOGGER.info("Entry into extractUniqueId()");
        String uniqueId = "";
        try {
        String[] txnLogArray = txnLog.split(" - ");
            for (String logEntry : txnLogArray) {
                if (logEntry.contains("Generated Aurus Transaction ID")) {
                    uniqueId = logEntry.substring(1, 37);
                    LOGGER.info("uniqueId: " + uniqueId);
                    break;
                }
            }

            if (uniqueId.length() != 36) {
                txnLogArray = txnLog.split("[\\[\\]]");
                for (String logEntry : txnLogArray) {
                    if ((logEntry.contains("SO.") || logEntry.contains("SM.") || logEntry.contains("SPO."))
                        && logEntry.length() > 36) {
                        uniqueId = logEntry.substring(3, 39);
                        LOGGER.info("UniqueId: " + uniqueId);
                        break;
                    }
                }
            }

            if (uniqueId.length() != 36) {
                uniqueId = "";
            }
        }catch (Exception e) {
        LOGGER.log(Level.SEVERE, "Error during operation extractUniqueId()", e);
}
        LOGGER.info("Exit from extractUniqueId()");
        return uniqueId;
    }
}