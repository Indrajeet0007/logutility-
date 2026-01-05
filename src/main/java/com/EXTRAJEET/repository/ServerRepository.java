package com.EXTRAJEET.repository;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.EXTRAJEET.constants.Constants;
import com.EXTRAJEET.entities.Logs;

@Component
public class ServerRepository {


	Logger logger = LoggerFactory.getLogger(ServerRepository.class);

	public void getIpDetails(Logs logs ) {

		String appName = "";
		String app = "";
		String appNo = "";
		String ip = "";
		String pass = "";

		try {


			// creating a constructor of file class and parsing an XML file
			File file = new File(Constants.XMLPATH);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("node" + logs.getNodeid());
			Node node = nodeList.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				logger.info("AppName" + (appName = eElement.getElementsByTagName("name").item(0).getTextContent()));
				logger.info("App :" + (app = eElement.getElementsByTagName("app").item(0).getTextContent()));
				logger.info("App :" + (appNo = eElement.getElementsByTagName("appno").item(0).getTextContent()));
				logger.info("IP :" + (ip = eElement.getElementsByTagName("address").item(0).getTextContent()));
				logger.info(
						"Password : " + (pass = eElement.getElementsByTagName("password").item(0).getTextContent()));
				logger.info("NODE ID : " + logs.getNodeid());
				logs.setAppName(appName);
				logs.setApp(app);
				logs.setAppNo(appNo);
				logs.setIp(ip);
				logs.setPass(pass);
			}
		} catch (Exception e) {
			logger.error("Exception thrown inside ServerRepository. ", e);
		}

	}
}
