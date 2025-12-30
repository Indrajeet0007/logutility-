package com.EXTRAJEET.LOGService;


import java.lang.reflect.Array;
import java.util.Scanner;

import com.EXTRAJEET.encryption.Authenticator;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.XmlReader;


public class LogMux {
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
	        String[] list= {};
	        String txnid="";
	        XmlReader xmlReader=new XmlReader();
	        Authenticator.authenticate(xmlReader);
	        while(true) {	        	
	        	System.out.println("\n\nEnter the TXN ID OR Type EXIT\n[FOR MULTIPLE TXN ID USE (,) COMA AS SEPRATOR ]");
	        	txnid=sc.nextLine();
	        	if(txnid.equalsIgnoreCase("EXIT")) {
	        		break;
	        	}
	        	if(txnid.length()>36) {
					list=txnid.split(",");
					for (int i=0; i<list.length;i++) {
						System.out.println(i+1+") "+list[i]);
						Logs log = new Logs();
						LogUtility.getlogs(list[i].trim(),xmlReader,log);
					}
				}else if(txnid.length()<18) {
					System.out.println("INVALID TXN ID");
				}else if (txnid.length()<=19) {  
					Logs log = new Logs();
					LogUtility.getlogs(txnid.trim(),xmlReader,log);
				}
	        }	
	}
	public static String getlogs (String txnID ) {
		XmlReader xmlReader=new XmlReader();
		Logs log = new Logs();
		return LogUtility.getlogs(txnID.trim(),xmlReader,log).toString();
	}
	
	public static String getlogs (String txnID, String mailID) {
		XmlReader xmlReader=new XmlReader();
		Logs log = new Logs();
		log.setMailID(mailID);
		return LogUtility.getlogs(txnID.trim(),xmlReader,log).toString();
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr= new int [m+n];
        for(int i=0; i<(m+n); i++){
        	if (nums1.toString().contains((i+1)+"")){
                arr[i]=i+1;
            }
            if (nums2.toString().contains((i+1)+"")){
                arr[i]=i+1;
            }
        }
    }
}
