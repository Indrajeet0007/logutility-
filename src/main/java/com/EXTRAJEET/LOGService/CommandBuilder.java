package com.EXTRAJEET.LOGService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EXTRAJEET.constants.Constants;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;
@Service
public class CommandBuilder {
	XmlReader xmlReader;

	@Autowired
	public CommandBuilder(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
	}

	private final Logger logger = LoggerFactory.getLogger(CommandBuilder.class);

	public XmlReader buildCommand (Logs log) {
		String backup = "";
		String txncmd = "";
		String server = "";
		String txnId = log.getTxnID();
		boolean prod = xmlReader.isProd();

		server = "ssh " + xmlReader.getUserName() + "@" + log.getIp();
		if (log.getDateANDTime().length() > 2) {
			txncmd = "z" + Constants.txnCommand.replace("txnId", log.getTxnID()) + "-" + log.getDateANDTime() + ".zip";
		} else {
			txncmd = Constants.txnCommand.replace("txnId", log.getTxnID());
		}
		log.setCmd(txncmd);
		logger.info(log.getCmd());

		if (log.getDateANDTime().length() > 2 && xmlReader.isBackupFlag()) {
			if (log.getAppName().equalsIgnoreCase("ldnd")) {
				backup = "cd /logbackup/Auruspay/vwldnd42app01/Auruspay && " + txncmd;
			} else if (log.getAppName().equalsIgnoreCase("4")) {
				backup = "cd /logbackup/Auruspay/" + "CHAAUS42UATAPP000" + log.getAppNo() + "/CHAAUS42UATAPP000"
						+ log.getAppNo() + "/" + Integer.parseInt(log.getDateANDTime().substring(0, 4)) + "/"
						+ Integer.parseInt(log.getDateANDTime().substring(5, 7)) + "/" + " && " + txncmd;
			} else {
				backup = "cd /logbackup/Auruspay/" + "CHAAUS42UATAPP000" + log.getAppNo() + "/CHAAUS42UATAPP000"
						+ log.getAppNo() + "/" + Integer.parseInt(log.getDateANDTime().substring(0, 4)) + "/"
						+ Integer.parseInt(log.getDateANDTime().substring(5, 7)) + "/"
						+ Integer.parseInt(log.getDateANDTime().substring(8, 10)) + "/" + "Auruspay && " + txncmd;
			}
			log.setBackup(backup);
		}

		if ((Integer.parseInt(txnId.substring(1, 3)) >= 01) || prod || ((Integer.parseInt(txnId.substring(1, 3)) >= 91)
				&& (Integer.parseInt(txnId.substring(1, 3)) <= 99) && !prod)) {
			if (prod) {
				xmlReader.setHost(log.getIp());
			} else {
				txncmd = server + " '" + txncmd + "'";
			}
			log.setTxncmd(txncmd);
			logger.info(txncmd);

		}

		return xmlReader;
	}

}
