package com.EXTRAJEET.LOGService;

import java.lang.reflect.Array;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EXTRAJEET.encryption.Authenticator;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;

@Component
public class LogMux {
	
	@Autowired
	LogUtility logUtility;

	public Logs getlogs(String txnID) {
		return logUtility.getlogs(txnID.trim());
	}

	public Logs getlogs(String txnID, String mailID) {
		log.setMailID(mailID);
		return logUtility.getlogs(txnID.trim());
	}

}
