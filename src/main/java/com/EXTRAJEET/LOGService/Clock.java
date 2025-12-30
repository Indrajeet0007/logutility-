package com.EXTRAJEET.LOGService;

import java.util.Date;
import java.util.TimeZone;
/**
 * This Class is used to get Date and Time from Transaction Id file  
 * 
 * 
 * @author Indrajeet Kandhare
 */

public class Clock {
	public static String getDateANDTime(String txnid) {		
		int year =Integer.parseInt(txnid.substring(3,5))+2000;
		String DateANDTime="";
        int dof=Integer.parseInt(txnid.substring(5,8));
        int month=1;
        int day=1;
       boolean leapYear=year%4==0 || year%100==0;
        while(dof>0) {
           
            if(month <=7) {
            	 if((month==2)&&(dof>28)){
            		dof-=leapYear==true?29:28;
//                    dof-=28;
            		
                    month++;
                }else if(((month%2!=0)&&(dof>31))) {
                    dof-=31;
                    month++;
                }else if ((month%2==0)&&(dof>30)) {
                    dof-=30;
                    month++;
                }else {
                    day=dof;
                    break;
                }
            }else {
                
                if(((month%2==0)&&(dof>31))) {
                    dof-=31;
                    month++;
                }else if ((month%2!=0)&&(dof>30)) {
                    dof-=30;
                    month++;
                }else {
                    day=dof;
                    break;
                }
            }  
        }
        System.out.println(leapYear+"Txn DATE and Time\n"
        		+ "DATE :-     Year  "+year+"    Month  "+month+"  Day  "+day);
        
        int mili=Integer.parseInt(txnid.substring(8,16));
        int hr=(mili)/(60*60*1000);
        mili=mili-(hr*60*60*1000);
        int min=mili/60000;
        mili-=min*60000;
        int sec=(mili/1000);
        mili-=sec*1000;
        System.out.println("TIME          "+hr+":"+min+":"+sec+":"+mili);
        
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-4"));
        int ESTH =new Date().getHours();
        int ESTD =new Date().getDate();
        int ESTY =new Date().getYear()+1900;
        int ESTM =new Date().getMonth()+1;
System.out.println("CURRENT UTC TIME :>"+ESTY+"   "+ESTM+"   "+ESTD+"     "+ESTH+"    "+new Date());
        if(!(ESTY==year && ESTD==day && ESTH==hr)) {
        	if((day<10)&&(month<10)) {
            	DateANDTime="0"+month+"-0"+day;
            }
            else if((month<10)&&(day>=10)) {
            	DateANDTime="0"+month+"-"+day;
            }else if((month>=10)&&(day<10)) {
            	DateANDTime=month+"-0"+day;
            }else {
            	DateANDTime=month+"-"+day;
            }
         
            if(hr<10) {DateANDTime+="-0"+hr;}else {DateANDTime+="-"+hr;}
            DateANDTime=year+"-"+DateANDTime;   	
           
        }else {
        	DateANDTime="";
        }
        
      /*  if (!(( day ==5)||(day==4))) {
        	DateANDTime="VALID FOR  4-5 MARCH only \n get lastest checkout";
        }*/
        return DateANDTime;
		
	}
}
