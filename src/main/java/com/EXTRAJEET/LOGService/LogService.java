package com.EXTRAJEET.LOGService;

import org.springframework.beans.factory.annotation.Autowired;

import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;

public class LogService {
	@Autowired
	LogUtility logUtility;

	public  Logs getlogs (String txnID ) {
		return logUtility.getlogs(txnID.trim());
	}
}
