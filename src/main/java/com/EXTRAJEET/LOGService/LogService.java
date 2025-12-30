package com.EXTRAJEET.LOGService;

import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;

public class LogService {

	public static String getlogs (String txnID ) {
		XmlReader xmlReader=new XmlReader();
		Logs log = new Logs();
		return LogUtility.getlogs(txnID.trim(),xmlReader,log).toString();
	}
}
