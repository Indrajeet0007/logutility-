
package com.EXTRAJEET.LOGService;

import java.awt.Desktop;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.EXTRAJEET.constants.Constants;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
import com.EXTRAJEET.repository.ServerRepository;
import com.EXTRAJEET.server.BackUpServer;
import com.EXTRAJEET.server.ProdServerAcces;
import com.EXTRAJEET.server.Server;
import com.jcraft.jsch.Session;

/**
 * This Class is Business class used to gets Credentials from EXTRAJEET.XML file
 * And Calls other methods
 * 
 * 
 * @author Indrajeet Kandhare
 */

public class LogUtility {
	private Logger logger = LoggerFactory.getLogger(LogUtility.class);

	@Autowired
	ServerRepository serverRepository;

	@Autowired
	XmlReader xmlReader;

	public Logs getlogs(String txnId) {
		Logs log = serverRepository.getIpDetails(txnId);
		boolean MAIL = xmlReader.isMAIL();
		boolean prod = xmlReader.isProd();

		String logs = "";
		String backup = "";
		String txncmd = "";
		String server = "";
		String analysis = "";

		server = "ssh " + xmlReader.getUserName() + "@" + log.getIp();
		String DateANDTime = Clock.getDateANDTime(txnId);
		log.setDateANDTime(DateANDTime);
		if (DateANDTime.length() > 2) {

			txncmd = "zgrep --color --text \"" + txnId + "\" /opt/auruspay_switch/log/auruspay/auruspay.log-"
					+ DateANDTime + ".zip";
		} else {
			txncmd = "grep --color --text \"" + txnId + "\" /opt/auruspay_switch/log/auruspay/auruspay.log";
		}
		log.setCmd(txncmd);
		logger.info(txncmd);

		if (DateANDTime.length() > 2 && xmlReader.isBackupFlag()) {
			if (log.getAppName().equalsIgnoreCase("ldnd")) {
				backup = "cd /logbackup/Auruspay/vwldnd42app01/Auruspay && " + "zgrep --color --text \"" + txnId
						+ "\" auruspay.log-" + DateANDTime + ".zip";
			} else if (log.getAppName().equalsIgnoreCase("4")) {
				backup = "cd /logbackup/Auruspay/" + "CHAAUS42UATAPP000" + log.getAppNo() + "/CHAAUS42UATAPP000"
						+ log.getAppNo() + "/" + Integer.parseInt(DateANDTime.substring(0, 4)) + "/"
						+ Integer.parseInt(DateANDTime.substring(5, 7)) + "/" + " && " + "zgrep --color --text \""
						+ txnId + "\" auruspay.log-" + DateANDTime + ".zip";
			} else {
				backup = "cd /logbackup/Auruspay/" + "CHAAUS42UATAPP000" + log.getAppNo() + "/CHAAUS42UATAPP000"
						+ log.getAppNo() + "/" + Integer.parseInt(DateANDTime.substring(0, 4)) + "/"
						+ Integer.parseInt(DateANDTime.substring(5, 7)) + "/"
						+ Integer.parseInt(DateANDTime.substring(8, 10)) + "/" + "Auruspay && "
						+ "zgrep --color --text \"" + txnId + "\" auruspay.log-" + DateANDTime + ".zip";
			}
			log.setBackup(backup);
		}
		/*
		 * if((Integer.parseInt(txnid.substring(1, 3))==97)) {
		 * 
		 * } else
		 */ if ((Integer.parseInt(txnId.substring(1, 3)) >= 01) || prod
				|| ((Integer.parseInt(txnId.substring(1, 3)) >= 91) && (Integer.parseInt(txnId.substring(1, 3)) <= 99)
						&& !prod)) {
			if (!prod) {
				txncmd = server + " '" + txncmd + "'";
			} else {
				xmlReader.setHost(log.getIp());
			}
			log.setTxncmd(txncmd);
			logger.info(txncmd);
			logs = Server.getLogs(xmlReader, log);
//                	 logger.info(logs+logs.length());
			if (logs.equalsIgnoreCase("404") && txncmd.contains("zgrep")) {
				txncmd = txncmd.replace("zip", "gz");
				log.setTxncmd(txncmd);
				logger.info("************[RETRYING SAME gz]***************\n" + txncmd);
				logs = Server.getLogs(xmlReader, log);
			}
			if (logs.equals("404") && xmlReader.isBackupFlag()) {
				logger.info("************[RETRYING SAME IN BACKUP with ZIP]***************\n");
				logs = BackUpServer.getLogs(xmlReader, log, false);
				if (logs.length() < 25) {
					logger.info("************[RETRYING SAME IN BACKUP with GZ]***************\n");
					log.setBackup(backup.replace("zip", "gz"));
					logs = BackUpServer.getLogs(xmlReader, log, false);
				}
			}

		} else if (System.getenv("USERNAME").contains("ikandhare")) {

			logs = ProdServerAcces.getLog(xmlReader, log);
//	logger.info(log.getIp()+"  "+log.getCmd());
			if (logs.length() < 23 && xmlReader.isBackupFlag()) {
				logger.info("************[RETRYING SAME IN BACKUP]***************\n");
				logs = BackUpServer.getLogs(xmlReader, log, true);
			}

		}

		if (logs.length() < 25) {

			logger.info("HEY Buddy ! U r Doing Something Wrosng \n" + "Please check manualy or Search in Backup\n "
					+ "Use below commands to get logs from backup server " + "ssh -l backup 192.168.13.101\n"
					+ "password-M@r!on_567$\n" + backup);
		} else {
			log.setLogs(logs);
			try {
				if (xmlReader.isAnalystFlag()) {
					analysis = Analyst.getAnalysis(logs, log);
				}

			} catch (Exception e) {
				logger.info("EXCEPTION IN " + e);
			}

		}
		return log;
	}

}
