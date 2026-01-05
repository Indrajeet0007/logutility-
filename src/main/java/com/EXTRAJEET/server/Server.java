package com.EXTRAJEET.server;


import java.io.InputStream;

import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
/**
 * This Class is used to connect with server and perform Commands on server  
 * 
 * 
 * @author Indrajeet Kandhare
 */
import com.jcraft.jsch.*;


public class Server {
    public static String getLogs(XmlReader xmlReader ,Logs log) {
    	String txncmd=log.getTxncmd();
    	String txn=log.getTxnID();
    	int  c=log.getLines();
    	String txnLog="";
        String uniqueId="";
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(xmlReader.getUserName(), xmlReader.getHost(), xmlReader.getPort());
            session.setPassword(xmlReader.getHostPass());
            session.setConfig("StrictHostKeyChecking", "no"); // Disable host key checking (not recommended for production)
            
            session.connect();
            byte[] buffer = null;
            InputStream in = null;
            
            Channel channel = session.openChannel("exec");
            if(!xmlReader.isDualAuth()||txn.equals("USER")) {
            	
            
            ((ChannelExec) channel).setCommand(txncmd);
          
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

             in = channel.getInputStream();
            channel.connect();

             buffer = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int bytesRead = in.read(buffer, 0, 1024);
                    if (bytesRead < 0) {
                        break;
                    }
                    if(!txn.equalsIgnoreCase("USER")) {                    	
                    	System.out.print(new String(buffer, 0, bytesRead));
                    }
                    txnLog+=new String(buffer, 0, bytesRead);
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("Exit status: " + channel.getExitStatus());
                    break;
                }
            }            
            if(txn.equalsIgnoreCase("USER")) {
            	channel.disconnect();
            	session.disconnect();
            	return txnLog;
            }
            }
            if(channel.getExitStatus()==255 || xmlReader.isDualAuth()) {
            	int startingPort = 8080; 

                int forwardedPort = BackUpServer.findAvailablePort(startingPort);
                System.out.println(xmlReader.getUserName()+"Available Port on Laptop : " + forwardedPort);
                
                System.out.println("Connected host --------------> "+session.getHost());
            	
                session.setPortForwardingL(forwardedPort, log.getIp(), 22);

                 jsch = new JSch();
                 session = jsch.getSession(xmlReader.getUserName(), "127.0.0.1", forwardedPort);
                session.setPassword(xmlReader.getUatPass());
                           
                session.setConfig("StrictHostKeyChecking", "no");
         
                session.connect();
                System.out.println("SFTP Connection Jump Serever ::: "+session.isConnected());
               
                 channel = session.openChannel("exec");
                 txncmd=log.getCmd();
                 System.out.println(log.getIp()+"Command "+txncmd);
                ((ChannelExec) channel).setCommand(txncmd);
              
                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(System.err);

                 in = channel.getInputStream();
                channel.connect();

                 buffer = new byte[1024];
                while (true) {
                    while (in.available() > 0) {
                        int bytesRead = in.read(buffer, 0, 1024);
                        if (bytesRead < 0) {
                            break;
                        }
                        System.out.print(new String(buffer, 0, bytesRead));
                        txnLog+=new String(buffer, 0, bytesRead);
                    }
                    if (channel.isClosed()) {
                        if (in.available() > 0) continue;
                        System.out.println("Exit status: " + channel.getExitStatus());
                        break;
                    }
                }            
            }
            
            if(txnLog.length()>25 || channel.getExitStatus()==0) {
            	
            //UniqueId Logic----             
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
            txncmd=txncmd.replaceFirst(txn,uniqueId);
            if(c>0) {            	
            	txncmd=txncmd.replaceFirst("--text","--text -C"+c);
            }
            System.out.println("Command"+txncmd);
            //UNIQUE=-=-=-=-
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(txncmd);
          
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

             in = channel.getInputStream();
            channel.connect();

             buffer = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int bytesRead = in.read(buffer, 0, 1024);
                    if (bytesRead < 0) {
                        break;
                    }
                    System.out.print(new String(buffer, 0, bytesRead));
                    txnLog+=new String(buffer, 0, bytesRead);
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
//                    System.out.println("Exit status: " + channel.getExitStatus());
                    break;
                }
            }
            }else {
            	System.out.print("ERROR CODE 404 : NOTFOUND\n");
            	txnLog="404";
            	 channel.disconnect();
                 session.disconnect();
            	return txnLog;
            }
            //closing             
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
        	System.out.print("ERROR CODE 404 : NOT FOUND\n"+e);
            e.printStackTrace();
            if(txnLog.length()<25) {
            	txnLog="404";           
           	return txnLog;
            }
        }
        
        log.setUniqueId(uniqueId);
        return txnLog;
    }
}