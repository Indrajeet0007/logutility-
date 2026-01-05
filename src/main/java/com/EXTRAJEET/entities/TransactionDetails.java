package com.EXTRAJEET.entities;

import org.springframework.stereotype.Component;

@Component
public class TransactionDetails {
	String transactionId;
	String mail;
	int lines;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	} 
}
