
package com.EXTRAJEET.LOGService;
import java.awt.Desktop;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
import com.EXTRAJEET.server.BackUpServer;
import com.EXTRAJEET.server.ProdServerAcces;
import com.EXTRAJEET.server.Server;
import com.jcraft.jsch.Session;




/**
 * This Class is Business class used to gets Credentials from EXTRAJEET.XML file And Calls other methods  
 * 
 * 
 * @author Indrajeet Kandhare
 */

public class LogUtility {
 
    public static Logs getlogs(String txnid, XmlReader xmlReader, Logs log) { 
    	
    	log.setTxnID(txnid);
    	String TxnID=txnid;
    	
    	boolean MAIL=xmlReader.isMAIL();
    	boolean prod=xmlReader.isProd();
    	String backup="";
        String txncmd="";      
        String logs="";
        String server="";
        
        String appName="";
        String app="";
        String appNo="";
        String ip="";
        String nodeid="";
        String pass="";
        
                
        String local=System.getProperty("user.dir").replace("EXTRAJEET","");
        String dPath=local+"/DOWNLOAD/";
        String analysis="";               
        boolean rootUser=local.contains("ikandhare");
        String Copyright="\n*************************************************************************************COPYRIGHT © 2024 Indrajeet_Kandhare. All Right Reserved*****************************************************************************\n";

        if(txnid.length()==19) {
            nodeid=txnid.substring(1,2);
            txnid=txnid.substring(0,1)+txnid.substring(2);            
        }else if (txnid.length()==18) {
        	
        }else {
        	System.out.println("INVALID TXN ID");
        	return log;
        }
       
        
        try   
        {  
        //creating a constructor of file class and parsing an XML file  
        File file = new File(local+"/EXTRAJEET.xml");  
        //an instance of factory that gives a document builder  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        //an instance of builder to parse the specified xml file  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);  
        doc.getDocumentElement().normalize();  
  
        
        NodeList nodeList = doc.getElementsByTagName("node"+nodeid+txnid.substring(1, 3));  
        Node node = nodeList.item(0);   
        if (node.getNodeType() == Node.ELEMENT_NODE)   
        {  
        Element eElement = (Element) node;  
        System.out.println("AppName"+ (appName=eElement.getElementsByTagName("name").item(0).getTextContent()));  
        System.out.println("App :" + (app=eElement.getElementsByTagName("app").item(0).getTextContent()));  
        System.out.println("App :"+ (appNo=eElement.getElementsByTagName("appno").item(0).getTextContent()));  
        System.out.println("IP :"+ (ip=eElement.getElementsByTagName("address").item(0).getTextContent()));  
        System.out.println("Password : "+(pass=eElement.getElementsByTagName("password").item(0).getTextContent()));
        System.out.println("NODE ID : "+nodeid+txnid.substring(1, 3));
        log.setAppName(appName);
        log.setApp(app);
        log.setAppNo(appNo);
        log.setIp(ip);   
        log.setPass(pass);
        }                
        }   
        catch (Exception e)   
        {  
        e.printStackTrace();  
        }
        	 
        	server="ssh "+xmlReader.getUserName()+"@"+ip;                               
            String DateANDTime= Clock.getDateANDTime(txnid);   
            log.setDateANDTime(DateANDTime);
            if(DateANDTime.length()>2) {
            	 
            	 txncmd="zgrep --color --text \""+TxnID+"\" /opt/auruspay_switch/log/auruspay/auruspay.log-"+DateANDTime+".zip";
             }else {
            	 txncmd="grep --color --text \""+TxnID+"\" /opt/auruspay_switch/log/auruspay/auruspay.log";
             }
            log.setCmd(txncmd);
            System.out.println(txncmd);
            
            if(DateANDTime.length()>2 && xmlReader.isBackupFlag()) {
         	   if(appName.equalsIgnoreCase("ldnd")) {
         		   backup= "cd /logbackup/Auruspay/vwldnd42app01/Auruspay && "
         				   + "zgrep --color --text \""+TxnID+"\" auruspay.log-"+DateANDTime+".zip";
         	   }else if(appNo.equalsIgnoreCase("4")) {
         		  backup= "cd /logbackup/Auruspay/"+"CHAAUS42UATAPP000"+appNo+"/CHAAUS42UATAPP000"+appNo+"/"+Integer.parseInt(DateANDTime.substring(0,4))+"/"+Integer.parseInt(DateANDTime.substring(5,7))+"/"+" && "
        				   + "zgrep --color --text \""+TxnID+"\" auruspay.log-"+DateANDTime+".zip";
         	   }else {		   
         		   backup= "cd /logbackup/Auruspay/"+"CHAAUS42UATAPP000"+appNo+"/CHAAUS42UATAPP000"+appNo+"/"+Integer.parseInt(DateANDTime.substring(0,4))+"/"+Integer.parseInt(DateANDTime.substring(5,7))+"/"+Integer.parseInt(DateANDTime.substring(8,10))+"/"+"Auruspay && "
         				   + "zgrep --color --text \""+TxnID+"\" auruspay.log-"+DateANDTime+".zip";
         	   }
         	   log.setBackup(backup);
            }
            /*if((Integer.parseInt(txnid.substring(1, 3))==97)) {
            	
            }
            else*/ if((Integer.parseInt(txnid.substring(1, 3))>=01) || prod || ((Integer.parseInt(txnid.substring(1, 3))>=91) && (Integer.parseInt(txnid.substring(1, 3))<=99) && !prod))  {
	   if(!prod) {
		   txncmd=server+" '"+txncmd+"'";		   
	   }else {
		   xmlReader.setHost(ip);
	   }
	   				 log.setTxncmd(txncmd);
	   				 System.out.println(txncmd);
                	 logs=Server.getLogs( xmlReader,log);
//                	 System.out.println(logs+logs.length());
   if(logs.equalsIgnoreCase("404")&&txncmd.contains("zgrep") ) {
                		 txncmd=txncmd.replace("zip","gz");
                		 log.setTxncmd(txncmd);
                		 System.out.println("************[RETRYING SAME gz]***************\n"+txncmd);
                		 logs=Server.getLogs(xmlReader,log);
                		 }   
   if(logs.equals("404") && xmlReader.isBackupFlag()) {	   
	   System.out.println("************[RETRYING SAME IN BACKUP with ZIP]***************\n");	   
		   logs= BackUpServer.getLogs(xmlReader, log,false);	  
		   if (logs.length()<25) {
			   System.out.println("************[RETRYING SAME IN BACKUP with GZ]***************\n");	   
			   log.setBackup(backup.replace("zip","gz"));
			   logs= BackUpServer.getLogs(xmlReader, log,false);
		   }
   } 
   
   
   }else if(System. getenv("USERNAME").contains("ikandhare")){
	   
	 logs=  ProdServerAcces.getLog(xmlReader,log);
//	System.out.println(log.getIp()+"  "+log.getCmd());
	   if(logs.length()<23 && xmlReader.isBackupFlag()) {	   
		   System.out.println("************[RETRYING SAME IN BACKUP]***************\n");	   
			   logs= BackUpServer.getLogs(xmlReader, log,true);	  	  
	   } 
	 
	}  
   
   if(logs.length()<25) {
	   
	   System.out.println("HEY Buddy ! U r Doing Something Wrosng \n"
               + "Please check manualy or Search in Backup\n "
               + "Use below commands to get logs from backup server "
               + "ssh -l backup 192.168.13.101\n"
               + "password-M@r!on_567$\n"
               +backup);
   }else{ 
	   log.setLogs(logs);
	   try {
		   if(xmlReader.isAnalystFlag() ) {			
			   analysis = Analyst.getAnalysis(logs,log);			   			   
		   }
		   if(xmlReader.isDownload()) {	
			   dPath+=log.getFileName();
			   dPath+=TxnID+".txt";		  
			   Path path = Paths.get(dPath);
			   // string -> bytes
			   Files.write(path, (analysis+logs+Copyright).getBytes(StandardCharsets.UTF_8));
			  //Opening file
			   File file = new File(dPath);
			   Desktop desktop = Desktop.getDesktop();  
			   desktop.open(file);              
			   System.out.println("Downloaded file path :\t"+dPath);
		   }

		   if(MAIL) {
//			   new MailAlertGenerator().sendMailWithAttachment(analysis+logs+Copyright,log);
		   }
	   	}catch(Exception e){
		   System.out.println("EXCEPTION IN "+e);
	   	}
            
   	} 
	return log;
    }
     

}
