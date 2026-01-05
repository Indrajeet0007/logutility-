package com.EXTRAJEET.LOGService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
import com.EXTRAJEET.repository.ServerRepository;
import com.EXTRAJEET.server.BackUpServer;
import com.EXTRAJEET.server.ProdServerAcces;
import com.EXTRAJEET.server.Server;

/**
 * This Class is Business class used to gets Credentials from EXTRAJEET.XML file
 * And Calls other methods
 * 
 * 
 * @author Indrajeet_Kandhare
 */
@Component
public class LogUtility {

	private ServerRepository serverRepository;
	private XmlReader xmlReader;
	private CommandBuilder builder;
	private Logger logger = LoggerFactory.getLogger(LogUtility.class);

	@Autowired
	public LogUtility(ServerRepository serverRepository, CommandBuilder builder) {
		this.serverRepository = serverRepository;
		this.builder = builder;
	}

	public Logs getlogs(Logs log) {
		String logs = "";
		String txnId = log.getTxnID();
		try {
			if (txnId.length() == 19) {
				log.setNodeid(txnId.substring(1, 4));
			} else if (txnId.length() == 18) {
				log.setNodeid(txnId.substring(1, 3));
			} else {
				logger.info("INVALID TXN ID");
				return log;
			}
			logger.info(log.getNodeid());

			serverRepository.getIpDetails(log);

			log.setDateANDTime(Clock.getDateANDTime(txnId));

			xmlReader = builder.buildCommand(log);
			logs = Server.getLogs(xmlReader, log);
			if (logs.equals("404") && xmlReader.isBackupFlag()) {
				logger.info("************[RETRYING SAME IN BACKUP with ZIP]***************\n");
				logs = BackUpServer.getLogs(xmlReader, log, false);
			}

			if (System.getenv("USERNAME").contains("ikandhare")  && false) {

				logs = ProdServerAcces.getLog(xmlReader, log);
				if (logs.length() < 23 && xmlReader.isBackupFlag()) {
					logger.info("************[RETRYING SAME IN BACKUP]***************\n");
					logs = BackUpServer.getLogs(xmlReader, log, true);
				}

			}

			if (logs.length() > 25) {
				log.setLogs(logs);
				Analyst.getAnalysis(logs, log);
			}
		} catch (Exception e) {
			logger.error("Exception in LogUtility", e);
		}
		return log;
	}

}
