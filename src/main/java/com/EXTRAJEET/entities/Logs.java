package com.EXTRAJEET.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Logs {
	
//	 @Override
//	public String toString() {
//		return "Logs [mailID=" + mailID + ", TxnID=" + TxnID + ", uniqueId=" + uniqueId + ", PROREQ=" + PROREQ
//				+ ", PRORES=" + PRORES + ", cctReq=" + cctReq + ", cctRes=" + cctRes + ", logs=" + logs + ", parse="
//				+ parse + ", fieldsName=" + fieldsName + ", raisingFormat=" + raisingFormat + ", additionalData="
//				+ additionalData + ", fileName=" + fileName + ", txncmd=" + txncmd + ", backup=" + backup + ", appName="
//				+ appName + ", app=" + app + ", appNo=" + appNo + ", ip=" + ip + ", DateANDTime=" + DateANDTime
//				+ ", nodeid=" + nodeid + ", cmd=" + cmd + "]";
//	}
	

	 String mailID="";
     String TxnID="";
     String uniqueId="";
     String PROREQ="";
     String PRORES="";
     String cctReq="";
     String cctRes="";
     String logs="";
     String parse="";
     String fieldsName="";
     String raisingFormat="";
     String additionalData="";
     String fileName="";
     String txncmd="";
     String backup="";
     String appName="";
     String app="";
     String appNo="";
     String ip ="";
     String DateANDTime ="";
     String nodeid="";
     String cmd="";
     String pass="";
     
     public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
     
     
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getTxnID() {
		return TxnID;
	}
	public void setTxnID(String txnID) {
		TxnID = txnID;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getPROREQ() {
		return PROREQ;
	}
	public void setPROREQ(String pROREQ) {
		PROREQ = pROREQ;
	}
	public String getPRORES() {
		return PRORES;
	}
	public void setPRORES(String pRORES) {
		PRORES = pRORES;
	}
	public String getCctReq() {
		return cctReq;
	}
	public void setCctReq(String cctReq) {
		this.cctReq = cctReq;
	}
	public String getCctRes() {
		return cctRes;
	}
	public void setCctRes(String cctRes) {
		this.cctRes = cctRes;
	}
	public String getLogs() {
		return logs;
	}
	public void setLogs(String logs) {
		this.logs = logs;
	}
	public String getParse() {
		return parse;
	}
	public void setParse(String parse) {
		this.parse = parse;
	}
	public String getFieldsName() {
		return fieldsName;
	}
	public void setFieldsName(String fieldsName) {
		this.fieldsName = fieldsName;
	}
	public String getRaisingFormat() {
		return raisingFormat;
	}
	public void setRaisingFormat(String raisingFormat) {
		this.raisingFormat = raisingFormat;
	}
	public String getAdditionalData() {
		return additionalData;
	}
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTxncmd() {
		return txncmd;
	}
	public void setTxncmd(String txncmd) {
		this.txncmd = txncmd;
	}
	public String getBackup() {
		return backup;
	}
	public void setBackup(String backup) {
		this.backup = backup;
	}
	public String getDateANDTime() {
		return DateANDTime;
	}
	public void setDateANDTime(String dateANDTime) {
		DateANDTime = dateANDTime;
	}
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
    
    
}
