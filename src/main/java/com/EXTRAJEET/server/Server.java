package com.EXTRAJEET.server;


import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static Logger LOG= LoggerFactory.getLogger(Server.class);
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
            LOG.info(xmlReader.toString() );
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
                    	LOG.info(new String(buffer, 0, bytesRead));
                    }
                    txnLog+=new String(buffer, 0, bytesRead);
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    LOG.info("Exit status: " + channel.getExitStatus());
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
                LOG.info(xmlReader.getUserName()+"Available Port on Laptop : " + forwardedPort);
                
                LOG.info("Connected host --------------> "+session.getHost());
            	
                session.setPortForwardingL(forwardedPort, log.getIp(), 22);

                 jsch = new JSch();
                 session = jsch.getSession(xmlReader.getUserName(), "127.0.0.1", forwardedPort);
                session.setPassword(xmlReader.getUatPass());
                           
                session.setConfig("StrictHostKeyChecking", "no");
         
                session.connect();
                LOG.info("SFTP Connection Jump Serever ::: "+session.isConnected());
               
                 channel = session.openChannel("exec");
                 txncmd=log.getCmd();
                 LOG.info(log.getIp()+"Command "+txncmd);
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
                        LOG.info(new String(buffer, 0, bytesRead));
                        txnLog+=new String(buffer, 0, bytesRead);
                    }
                    if (channel.isClosed()) {
                        if (in.available() > 0) continue;
                        LOG.info("Exit status: " + channel.getExitStatus());
                        break;
                    }
                }            
            }
            
            if(txnLog.length()>25 || channel.getExitStatus()==0) {
            	
            //UniqueId Logic----             
            String [] txnLogArray =txnLog.split(" - ");
        	for(int i =0;i<txnLogArray.length;i++) {
        		if(txnLogArray[i].contains("Generated Aurus Transaction ID")) {
        			LOG.info("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(1,37)));
        		}
        	}        	
            if(uniqueId.length()!=36) {
            	
       		 txnLogArray =txnLog.split("[\\[\\]]");
         	for(int i =0;i<txnLogArray.length;i++) {
         		if(txnLogArray[i].contains("SO.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,3).equals("SO.")))) {
         			LOG.info("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
         			break;
         		}else if(txnLogArray[i].contains("SM.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,3).equals("SM.")))) {
         			LOG.info("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
         			break;
         		}else if(txnLogArray[i].contains("SPO.") && (txnLogArray[i].length()>36) && ((txnLogArray[i].substring(0,4).equals("SPO.")))) {
         			LOG.info("uniqueId  :  "+(uniqueId=txnLogArray[i].substring(3,39)));
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
            LOG.info("Command"+txncmd);
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
                    LOG.info(new String(buffer, 0, bytesRead));
                    txnLog+=new String(buffer, 0, bytesRead);
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
//                    LOG.infoln("Exit status: " + channel.getExitStatus());
                    break;
                }
            }
            }else {
            	LOG.info("ERROR CODE 404 : NOTFOUND\n");
            	txnLog="404";
            	 channel.disconnect();
                 session.disconnect();
            	return txnLog;
            }
            //closing             
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
        	LOG.info("ERROR CODE 404 : NOT FOUND\n"+e);
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