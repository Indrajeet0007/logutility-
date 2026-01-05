package com.EXTRAJEET.encryption;


import java.io.File;
import java.util.Scanner;

import org.json.JSONObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
import com.EXTRAJEET.server.Server;

public class Authenticator {
	
	public static void main(String[] args) {
		XmlReader xmlReader = new XmlReader();
		authenticate(xmlReader);
		 System.out.println("DONE ");
		 
	}
	
	
	public static void authenticate (XmlReader xmlReader) {		
	String pass="";
    String host="";
    int port=0;
    String userName="";
    String USERNAMES =""; 
    String username=System. getenv("USERNAME").replaceAll("@offaurusinc.com", "");
    if(username.equalsIgnoreCase("ikandhare")) {return ;};
    String Upload="";
    boolean MAIL=xmlReader.isMAIL();
    boolean prod=xmlReader.isProd();

     
     
    Logs log= new Logs();
     try   
     {  
    
	Scanner sc=new Scanner(System.in);
	 
    if(prod && MAIL) {
    	System.out.println("IF YOU WANT LOG COPY ON MAIL PLEASE ENTER THE USERNAME OF EMAIL OR JUST HIT ENTER & WAIT");
    	log.setMailID(sc.nextLine().replace("@aurusinc.com",""));
    	
    	System.out.println("Thank you  "+log.getMailID());
    	xmlReader.setMAIL(log.getMailID().length()>2);
    }else {    	
    	log.setMailID(username);
    }
	if(prod) {
		xmlReader.setHost("192.168.50.53");
	}     
     } catch (Exception e)   
     {  
    	 System.err.println(e);
         //e.printStackTrace();  
         }
  log.setTxncmd("cat EXTRAJEET/USERNAME.txt");
  log.setTxnID("USER");
  USERNAMES=Server.getLogs(xmlReader, log);
   JSONObject USER_ACCESS = new JSONObject(USERNAMES);
//     	System.out.println(USER_ACCESS+""+USER_ACCESS.has(username)+"Enter the TXN ID "+Integer.parseInt((String) USER_ACCESS.get("ikandhare")));
   try {
   if (USER_ACCESS.has(username)) {
        
        int accessLevel = Integer.parseInt((String) USER_ACCESS.get(username));
//        int accessLevel=1;
       if (accessLevel<=0) {
//            System.out.println("PRIME " + username);
            
        }  else if (accessLevel<0) {
        	 System.out.println("TRY LATER");
        	 System.exit(1);
        }

//        System.out.println("User: " + username);
    } else {
    	USER_ACCESS.put(username, "1");

        
//        System.out.println(USER_ACCESS + " User: " + username);
    }
   }catch(Exception e) {
	   System.err.println(e);
   }
//    System.out.println(USER_ACCESS + " User: " + username);
    Upload=USER_ACCESS.toString();
    
//    System.out.println(Upload + " User: " + username);
    log.setTxncmd("cd EXTRAJEET/ && echo \'"+Upload+"\' > USERNAME.txt");
    USERNAMES=Server.getLogs(xmlReader, log);
    
	}
	
}
