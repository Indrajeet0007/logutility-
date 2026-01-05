package com.EXTRAJEET.entities;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jcraft.jsch.Session;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Component
public class XmlReader {
	   boolean DualAuth = false;
	   String hostPass="";
	   String uatPass="";
       String host="";
       int port=0;
       String userName="";
       boolean download=false;
       boolean analystFlag=false;
       boolean feildFlag=false;
       boolean backupFlag=false;
       boolean SearchKEY=false;
       String[] SearchKeys= {};
       String[] SearchKeysEncryption= {};

       String Backupip=""; 
       String backupuser="";
       String BKpassword="";        
       String PRODBackupip=""; 
       String PRODbackupuser="";
       String PRODBKpassword="";
    
       boolean MAIL;
       boolean prod;
       String local=System.getProperty("user.dir");
       String dPath=local+"/DOWNLOAD/";
       
       private Session uat42Session = null;
       private Session uatAppSession = null;
       private Session uatTempSession = null;
       private Session prodTempSession = null;
       
	public XmlReader() {
		  try   
	        {  
	        //creating a constructor of file class and parsing an XML file  
	        File file = new File(local+"/src/main/resources/EXTRAJEET.xml");  
	        //an instance of factory that gives a document builder  
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	        //an instance of builder to parse the specified xml file  
	        DocumentBuilder db = dbf.newDocumentBuilder();  
	        Document doc = db.parse(file);  
	        doc.getDocumentElement().normalize();  

	        NodeList nodeList = doc.getElementsByTagName("Credentials");  
	        Node node = nodeList.item(0);   
	        if (node.getNodeType() == Node.ELEMENT_NODE)   
	        {  
	        Element eElement = (Element) node;  
	        System.out.println("HOST: "+(host= eElement.getElementsByTagName("HOST").item(0).getTextContent()));  
	        System.out.println("USERNAME: "+(userName= eElement.getElementsByTagName("USERNAME").item(0).getTextContent()));  
	        System.out.println("PORT: "+(port= Integer.parseInt(eElement.getElementsByTagName("PORT").item(0).getTextContent())));
	        System.out.println("HOSTPASSWORD: "+(hostPass= eElement.getElementsByTagName("HOSTPASSWORD").item(0).getTextContent()));  
	        System.out.println("UATPASSWORD: "+(uatPass= eElement.getElementsByTagName("UATPASSWORD").item(0).getTextContent()));
	        System.out.println("DualAuth: "+(DualAuth= eElement.getElementsByTagName("DualAuth").item(0).getTextContent().equalsIgnoreCase("Y")));
	        
	        System.out.println("DOWNLOAD: "+(download= eElement.getElementsByTagName("DOWNLOAD").item(0).getTextContent().equalsIgnoreCase("Y")));
	        System.out.println("backupFlag: "+(backupFlag=( eElement.getElementsByTagName("Backup").item(0).getTextContent().equalsIgnoreCase("1"))));  
	        System.out.println("field: "+(feildFlag= (eElement.getElementsByTagName("field").item(0).getTextContent().equalsIgnoreCase("1"))));
	        System.out.println("Analyst: "+(analystFlag=(eElement.getElementsByTagName("Analyst").item(0).getTextContent().equalsIgnoreCase("1"))));
	        System.out.println("SearchKEY: "+(SearchKEY=(eElement.getElementsByTagName("SearchKEY").item(0).getTextContent().equalsIgnoreCase("1"))));
	        
	        System.out.println("BACKUPIP: "+(Backupip= (eElement.getElementsByTagName("BACKUPIP").item(0).getTextContent())));
	        System.out.println("BACKUPUSER: "+(backupuser=(eElement.getElementsByTagName("BACKUPUSER").item(0).getTextContent())));
	        System.out.println("BKPASSWORD: "+(BKpassword=(eElement.getElementsByTagName("BKPASSWORD").item(0).getTextContent())));
	        
	        System.out.println("PROD: "+(prod=(eElement.getElementsByTagName("PROD").item(0).getTextContent().equalsIgnoreCase("Y"))));
	        System.out.println("MAIL: "+(MAIL=(eElement.getElementsByTagName("MAIL").item(0).getTextContent().equalsIgnoreCase("Y"))));
	        
	        System.out.println("PRODBACKUPIP: "+(PRODBackupip= (eElement.getElementsByTagName("PRODBACKUPIP").item(0).getTextContent())));
	        System.out.println("PRODBACKUPUSER: "+(PRODbackupuser=(eElement.getElementsByTagName("PRODBACKUPUSER").item(0).getTextContent())));
	        System.out.println("PRODBACKUPPASS: "+(PRODBKpassword=(eElement.getElementsByTagName("PRODBACKUPPASS").item(0).getTextContent())));
	        
	        
	        System.out.println("SearchKeys"+(SearchKeys= (eElement.getElementsByTagName("SearchKeys").item(0).getTextContent()).split(",")));
	        System.out.println("SearchKeysEncryption"+(SearchKeysEncryption= (eElement.getElementsByTagName("EncyrptionFlag").item(0).getTextContent()).split(",")));
	        if(prod) {
	        	host="192.168.50.53";
	        }
	        }   
	        
	        
	                
	        }   
	        catch (Exception e)   
	        {  
	        e.printStackTrace();  
	        }
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAnalystFlag() {
		return analystFlag;
	}

	public void setAnalystFlag(boolean analystFlag) {
		this.analystFlag = analystFlag;
	}

	public boolean isFeildFlag() {
		return feildFlag;
	}

	public void setFeildFlag(boolean feildFlag) {
		this.feildFlag = feildFlag;
	}

	public boolean isBackupFlag() {
		return backupFlag;
	}

	public void setBackupFlag(boolean backupFlag) {
		this.backupFlag = backupFlag;
	}

	public boolean isSearchKEY() {
		return SearchKEY;
	}

	public void setSearchKEY(boolean searchKEY) {
		SearchKEY = searchKEY;
	}

	public String[] getSearchKeys() {
		return SearchKeys;
	}

	public void setSearchKeys(String[] searchKeys) {
		SearchKeys = searchKeys;
	}

	public String[] getSearchKeysEncryption() {
		return SearchKeysEncryption;
	}

	public void setSearchKeysEncryption(String[] searchKeysEncryption) {
		SearchKeysEncryption = searchKeysEncryption;
	}


	public String getBackupip() {
		return Backupip;
	}

	public void setBackupip(String backupip) {
		Backupip = backupip;
	}

	public String getBackupuser() {
		return backupuser;
	}

	public void setBackupuser(String backupuser) {
		this.backupuser = backupuser;
	}

	public String getBKpassword() {
		return BKpassword;
	}

	public void setBKpassword(String bKpassword) {
		BKpassword = bKpassword;
	}

	public String getPRODBackupip() {
		return PRODBackupip;
	}

	public void setPRODBackupip(String pRODBackupip) {
		PRODBackupip = pRODBackupip;
	}

	public String getPRODbackupuser() {
		return PRODbackupuser;
	}

	public void setPRODbackupuser(String pRODbackupuser) {
		PRODbackupuser = pRODbackupuser;
	}

	public String getPRODBKpassword() {
		return PRODBKpassword;
	}

	public void setPRODBKpassword(String pRODBKpassword) {
		PRODBKpassword = pRODBKpassword;
	}


	public boolean isMAIL() {
		return MAIL;
	}


	public void setMAIL(boolean mAIL) {
		MAIL = mAIL;
	}


	public boolean isProd() {
		return prod;
	}


	public void setProd(boolean prod) {
		this.prod = prod;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getdPath() {
		return dPath;
	}


	public void setdPath(String dPath) {
		this.dPath = dPath;
	}


	public boolean isDownload() {
		return download;
	}


	public void setDownload(boolean download) {
		this.download = download;
	}


	public String getHostPass() {
		return hostPass;
	}


	public void setHostPass(String hostPass) {
		this.hostPass = hostPass;
	}


	public String getUatPass() {
		return uatPass;
	}


	public void setUatPass(String uatPass) {
		this.uatPass = uatPass;
	}


	public boolean isDualAuth() {
		return DualAuth;
	}


	public void setDualAuth(boolean dualAuth) {
		DualAuth = dualAuth;
	}


	public Session getUat42Session() {
		return uat42Session;
	}


	public void setUat42Session(Session uat42Session) {
		this.uat42Session = uat42Session;
	}


	public Session getUatAppSession() {
		return uatAppSession;
	}


	public void setUatAppSession(Session uatAppSession) {
		this.uatAppSession = uatAppSession;
	}


	public Session getUatTempSession() {
		return uatTempSession;
	}


	public void setUatTempSession(Session uatTempSession) {
		this.uatTempSession = uatTempSession;
	}


	public Session getProdTempSession() {
		return prodTempSession;
	}


	public void setProdTempSession(Session prodTempSession) {
		this.prodTempSession = prodTempSession;
	}



}