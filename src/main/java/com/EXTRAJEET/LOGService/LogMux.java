package com.EXTRAJEET.LOGService;

import java.lang.reflect.Array;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EXTRAJEET.encryption.Authenticator;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.TransactionDetails;
import com.EXTRAJEET.entities.XmlReader;

@Component
public class LogMux {
	
	@Autowired
	LogUtility logUtility;
	@Autowired
	Logs logs;

	public Logs getlogs(String txnID) {
		logs.setTxnID(txnID);
		return logUtility.getlogs(logs);
	}

	public Logs getlogs(TransactionDetails transactionDetails) {
		logs.setTxnID(transactionDetails.getTransactionId());
		logs.setLines(transactionDetails.getLines());
		logs.setMailID(transactionDetails.getMail());
		return logUtility.getlogs(logs);
	}

}
