package com.EXTRAJEET.parse;

import java.util.HashMap;
import java.util.Scanner;

public class ChaseISO {
			public static StringBuilder hextoascii(String hex) {
				StringBuilder output = new StringBuilder();
				try {				
		for (int i = 0; i < hex.length(); i+=2) {
		    String str = hex.substring(i, i+2);
		    output.append((char)Integer.parseInt(str, 16));
		}
			}catch(Exception e) {
				System.out.print("Anaylst is on Leave");
			}
		return output;
			}
		public static String hexToBinary(String hex)
			{

				// variable to store the converted
				// Binary Sequence
				String binary = "";

				// converting the accepted Hexadecimal
				// string to upper case
				hex = hex.toUpperCase();

				// initializing the HashMap class
				HashMap<Character, String> hashMap
					= new HashMap<Character, String>();

				// storing the key value pairs
				hashMap.put('0', "0000");
				hashMap.put('1', "0001");
				hashMap.put('2', "0010");
				hashMap.put('3', "0011");
				hashMap.put('4', "0100");
				hashMap.put('5', "0101");
				hashMap.put('6', "0110");
				hashMap.put('7', "0111");
				hashMap.put('8', "1000");
				hashMap.put('9', "1001");
				hashMap.put('A', "1010");
				hashMap.put('B', "1011");
				hashMap.put('C', "1100");
				hashMap.put('D', "1101");
				hashMap.put('E', "1110");
				hashMap.put('F', "1111");

				int i;
				char ch;

				// loop to iterate through the length
				// of the Hexadecimal String
				for (i = 0; i < hex.length(); i++) {
					// extracting each character
					ch = hex.charAt(i);

					// checking if the character is
					// present in the keys
					if (hashMap.containsKey(ch))

						// adding to the Binary Sequence
						// the corresponding value of
						// the key
						binary += hashMap.get(ch);

					// returning Invalid Hexadecimal
					// String if the character is
					// not present in the keys
					else {
						binary = "Invalid Hexadecimal String";
						return binary;
					}
				}

				// returning the converted Binary
				return binary;
			}
			
			public static String asciiToBinary(String text) {
		        StringBuilder binaryString = new StringBuilder();
		        
		        for (char c : text.toCharArray()) {
		            // Convert each character to its ASCII representation
		            int asciiValue = (int) c;
		            // Convert ASCII value to binary and append to the binary string
		            String binaryValue = Integer.toBinaryString(asciiValue);
		            // Ensure 8-bit representation by appending leading zeros if necessary
		            binaryString.append(String.format("%8s", binaryValue).replace(' ', '0'));
		        }
		        
		        return binaryString.toString();
		    }
			
			public static void main(String args[]) {

				String isoreq="31323130303230323434303030656331383230343031323532303235323033373339303132353535343230313130323630383931333837333635333532323730303030313537373030303332343232383034394d313137414d4448413843474c56303132354e4e204d35303242315138303330304e533130324d435332303530303030323834303033323931304139323030453036463935394131383444303031323841303233303330303231483130313630323530303030313531303030303131"; 			
				
				System.out.println("return:"+parse(isoreq));
			}
				
			public static String parse(String request) {
				
				try {								
				String isoreq=hextoascii(request).toString();
				String Bithex=request.substring(48,64);
				
				String header=isoreq.substring(0, 20);
				request="\n Header    :"+header;
				String Mti=isoreq.substring(20, 24);
				request+="\n MTI    :"+Mti;
				request+="\n Bithex    :"+Bithex;
				String bitbi= hexToBinary(Bithex);
				request+="\n BinaryBit    :"+bitbi;				
				
//				System.out.print(Bithex+"  ====>"+bitbi);
//				String secbit="";
//				String secbitbi="";
				isoreq=isoreq.substring(32);

				System.out.println("Client  :-  "+header+"\nMTI:-"+Mti+"\nHeader:-"+Bithex+"\nBinary bitmap:-"+bitbi);
				bitbi="N"+bitbi;
		        
				for (int i=0;i<bitbi.length();i++) {
					if(bitbi.charAt(i)=='1') {
						System.out.print(i+"  ");
					}
				}
				System.out.println();
//				if (bitbi.charAt(1) == '1') {
//		            secbit=isoreq.substring(0, 16);
//		            secbitbi=pa.hexToBinary(secbit);
//		            isoreq=isoreq.substring(16, isoreq.length());
//		            System.out.println("1 Secondary bitmap Hex:- "+secbit+"\n Secondary Bitmap:- "+secbitbi);
//		            
//		        }
		        if (bitbi.charAt(2) == '1') {
		            String panlen = isoreq.substring(0, 2);
		            String pan = isoreq.substring(2, Integer.parseInt(panlen)+2);
		            isoreq=isoreq.substring(Integer.parseInt(panlen)+2,isoreq.length());
		            System.out.println("2 panlen :-"+panlen+"\n Pan :- "+pan);
		            request+="\n2 PANLen :-"+panlen+"\n PAN :- "+pan;
		        }
		        if (bitbi.charAt(3) == '1') {
		            String processingCode = isoreq.substring(0, 6);
		            isoreq=isoreq.substring(6, isoreq.length());
		            System.out.println("3 Processing code :-"+processingCode);
		            request+="\n3 Processing code :-"+processingCode;
		            
		        }
		        if (bitbi.charAt(4) == '1') {
		            String transactionAmount = isoreq.substring( 0, 12);
		            isoreq=isoreq.substring(12, isoreq.length());
		            System.out.println("4 Transaction Amount :"+transactionAmount.substring(0,10)+"."+transactionAmount.substring(10,12));
		            request+="\n4 Transaction Amount :"+transactionAmount.substring(0,10)+"."+transactionAmount.substring(10,12);
		        }

		        String cardBillingAmount = "";
		        if (bitbi.charAt(8) == '1') {
		            cardBillingAmount = isoreq.substring(0, 12);
		            isoreq=isoreq.substring(12, isoreq.length());
		            System.out.println("8 cardBillingAmount :-"+cardBillingAmount);
		            request+="\n8 cardBillingAmount :-"+cardBillingAmount;
		        }
		        if (bitbi.charAt(10) == '1') {
		            String conversionRateCardBilling = isoreq.substring( 0, 8);
		            isoreq=isoreq.substring(8, isoreq.length());
		            System.out.println("10 conversionRateCardBilling :-"+conversionRateCardBilling);
		            request+="\n10 conversionRateCardBilling :-"+conversionRateCardBilling;
		        }
		        if (bitbi.charAt(11) == '1') {
		            String systemtraceNumber = isoreq.substring(0, 6);
		            isoreq=isoreq.substring(6, isoreq.length());
		            System.out.println("11 systemtraceNumber :-"+systemtraceNumber);
		            request+="\n11 systemtraceNumber :-"+systemtraceNumber;
		        }
		        if (bitbi.charAt(12) == '1') {
		            String localTime = isoreq.substring( 0, 6);
		            isoreq=isoreq.substring(6, isoreq.length());
		            System.out.println("12 Local time :-"+localTime);
		            request+="\n12 Local time :-"+localTime;
		        }
		        if (bitbi.charAt(13) == '1') {
		            String localDate = isoreq.substring(0, 8);
		            isoreq=isoreq.substring(8, isoreq.length());
		            System.out.println("13 LocalDate :-"+localDate);
		            request+="\n13 LocalDate :-"+localDate;
		        }
		        if (bitbi.charAt(14) == '1') {
		            String ExpiryDate = isoreq.substring(0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("14 ExpiryDate :-"+ExpiryDate);
		            request+="\n14 ExpiryDate :-"+ExpiryDate;
		        }
		        if (bitbi.charAt(15) == '1') {
		            String DateofSettle = isoreq.substring(0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("14 DateofSettle :-"+DateofSettle);
		            request+="\n14 DateofSettle :-"+DateofSettle;
		        }
		        if (bitbi.charAt(18) == '1') {
		            String Merchantcatcode = isoreq.substring(0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("18 Merchantcatcode :-"+Merchantcatcode);

		        }
		        if (bitbi.charAt(22) == '1') {
		            String posEntryMode = isoreq.substring(0, 3);
		            isoreq=isoreq.substring(3, isoreq.length());
		            System.out.println("22 posEntryMode :-"+posEntryMode);
		            request+="\n22 posEntryMode :-"+posEntryMode;
		        }
		        if (bitbi.charAt(23) == '1') {
		            String cardSeqnumber = isoreq.substring(0, 2);
		            isoreq=isoreq.substring(2, isoreq.length());
		            System.out.println("23 cardSeqnumber :-"+cardSeqnumber);
		            request+="\n23 cardSeqnumber :-"+cardSeqnumber;
		        }
		        if (bitbi.charAt(24) == '1') {
		            String networkInternationalID = isoreq.substring(0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("24 networkInternationalID :-"+networkInternationalID);
		            request+="\n24 networkInternationalID :-"+networkInternationalID;

		        }
		        if (bitbi.charAt(25) == '1') {
		            String posCondition = isoreq.substring(0, 2);
		            isoreq=isoreq.substring(2, isoreq.length());
		            System.out.println("25 posCondition :-"+posCondition);
		            request+="\n25 posCondition :-"+posCondition;

		        }
		        
		        if (bitbi.charAt(32) == '1') {
		           
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 2));
		            String acqInstiIdCode = isoreq.substring(2,idLength);
		            isoreq=isoreq.substring(2, isoreq.length());
		            System.out.println("32 length :-"+idLength+"\tacqInstiIdCode"+acqInstiIdCode);
		            request+="\n32 length :-"+idLength+"\tacqInstiIdCode"+acqInstiIdCode;

		        }
		        if (bitbi.charAt(35) == '1') {
		            
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 2));
		            String Track2Data = isoreq.substring(2,idLength+2);
		            isoreq=isoreq.substring(idLength+2, isoreq.length());
		            System.out.println("35 len of track2Data"+idLength+"\tTrack2Data :-"+Track2Data);
		            request+="\n35 len of track2Data"+idLength+"\tTrack2Data :-"+Track2Data;
		        }
		        if (bitbi.charAt(37) == '1') {
		            String retrievalRefNo = isoreq.substring(0, 12);
		            isoreq=isoreq.substring(12, isoreq.length());
		            System.out.println("37 retrievalRefNo :-"+retrievalRefNo);
		            request+="\n37 retrievalRefNo :-"+retrievalRefNo;

		        }
		        if (bitbi.charAt(38) == '1') {
		            String authIdResponse = isoreq.substring( 0, 6);
		            isoreq=isoreq.substring(6, isoreq.length());
		            System.out.println("bit 38 :"+authIdResponse);
		            request+="\nbit 38"+authIdResponse;
		        }
		        if (bitbi.charAt(39) == '1') {
		            String responseCode = isoreq.substring( 0, 2);
		            isoreq=isoreq.substring(2, isoreq.length());
		            
		            
		                        
		            
		            
		           
		        }
		        if (bitbi.charAt(41) == '1') {
		           
		            String terminalId = isoreq.substring( 0, 3);
		            isoreq=isoreq.substring(3, isoreq.length());
		            System.out.println("41 terminalId :-"+terminalId);
		            request+="\n41 terminalId :-"+terminalId;

		            
		        }
		        if (bitbi.charAt(42) == '1') {
		            
		            String cardAcquirerid = isoreq.substring( 0, 12);
		            isoreq=isoreq.substring(12, isoreq.length());
		            System.out.println("42 cardAcquirerid :-"+cardAcquirerid);
		            request+="\n42 cardAcquirerid :-"+cardAcquirerid;

		            
		        }
		        if (bitbi.charAt(44) == '1') {
		            
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 4));
		            String Track2Data = isoreq.substring(4,idLength+4);
		            isoreq=isoreq.substring(idLength+4, isoreq.length());
		            System.out.println("44 len of Additional RES Data "+idLength+"\tAditional data :-"+Track2Data);
		            request+="\n44 len of Additional RES Data "+idLength+"\tAditional data :-"+Track2Data;

		        }
		        	if (bitbi.charAt(45) == '1') {
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 2));
		            String Track1Data = isoreq.substring(2,idLength);
		            isoreq=isoreq.substring(idLength, isoreq.length());
		            System.out.println("45 len of track1Data"+idLength+"\nTrack1Data :-"+Track1Data);
		            request+="\n45 len of track1Data"+idLength+"\nTrack1Data :-"+Track1Data;

		        }
		        	if (bitbi.charAt(46) == '1') {
			            
			            int idLength = 0;
			            idLength = Integer.parseInt(isoreq.substring( 0, 3));
			            String Track2Data = isoreq.substring(3,idLength+3);
			            isoreq=isoreq.substring(idLength+3, isoreq.length());
			            System.out.println("46 len of aditionaldata"+idLength+"\tAditionaldata :-"+Track2Data);
			            request+="\n46 len of aditionaldata"+idLength+"\tAditionaldata :-"+Track2Data;

			        }
		        	if (bitbi.charAt(48) == '1') {
			            
			            int idLength = 0;
			            idLength = Integer.parseInt(isoreq.substring( 0, 3));
			            String Track2Data = isoreq.substring(3,idLength+3);
			            isoreq=isoreq.substring(idLength+3, isoreq.length());
			            System.out.println("48 len of aditionaldatapv"+idLength+"\tAditionaldata Pri use :-"+Track2Data);
			            request+="\n48 len of aditionaldatapv"+idLength+"\tAditionaldata Pri use :-"+Track2Data;

			        }
		        
		        	
		        if (bitbi.charAt(49) == '1') {
		            String currencyCode = isoreq.substring( 0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("49 currencyCode :-"+currencyCode);
		            request+="\n49 currencyCode :-"+currencyCode;

		        }

		        if (bitbi.charAt(51) == '1') {
		            String currencyCodec = isoreq.substring( 0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());
		            System.out.println("51 currencyCodec :-"+currencyCodec);
		            request+="\n51 currencyCodec :-"+currencyCodec;
		        }
		        if (bitbi.charAt(52) == '1') {
		            String PIN = isoreq.substring( 0, 16);
		            isoreq=isoreq.substring(16, isoreq.length());
		            System.out.println("52 PIN :-"+PIN);
		            request+="\n52 PIN :-"+PIN;

		        }

		        // Code for [Bit 54] Additional Amounts**
		        if (bitbi.charAt(54) == '1') {
		            String length = isoreq.substring( 0, 4);
		            isoreq=isoreq.substring(4, isoreq.length());

		            
//		           
		        }

		        // Code for [Bit 55] ICC System Related Data
		        if (bitbi.charAt(55) == '1') {
		            int dataLength = 0;
		            String icCardData = "";
		            dataLength = Integer.parseInt(isoreq.substring( 0, 3));
		           
		                icCardData = isoreq.substring( 3, dataLength);
		                System.out.println("55 length:-"+dataLength+"\tIcCardAtata:-"+icCardData);
		                request+="\n55 length:-"+dataLength+"\tIcCardAtata:-"+icCardData;
		                isoreq=isoreq.substring(dataLength+3, isoreq.length());
		       
		        }
		        
		        if (bitbi.charAt(60) == '1') {
		            
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 3));
		            String Track2Data = isoreq.substring(3,idLength+3);
		            isoreq=isoreq.substring(idLength+3, isoreq.length());
		            System.out.println("60 len of Reserved National 1"+idLength+"\tMerchant Services Defined Point of Service Data :-"+Track2Data);
		            request+="\n60 len of Reserved National 1"+idLength+"\tMerchant Services Defined Point of Service Data :-"+Track2Data;

		        }
		        if (bitbi.charAt(62) == '1') {
		            
		            int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 3));
		            String Track2Data = isoreq.substring(3,idLength+3);
		            isoreq=isoreq.substring(idLength+3, isoreq.length());
		            System.out.println("62 len of Reserved Private "+idLength+"\t Reserved Private 2 :-"+Track2Data);
		            request+="\n62 len of Reserved Private "+idLength+"\t Reserved Private 2 :-"+Track2Data;

		        }
		        

		        // Code for [Bit 63] Private Data
		        if (bitbi.charAt(63) == '1') {
		        	 int idLength = 0;
		            idLength = Integer.parseInt(isoreq.substring( 0, 3));
		            String Track2Data = isoreq.substring(3,idLength);
		            isoreq=isoreq.substring(idLength+3);
		            System.out.println("63 len of Reserved  Private3 "+idLength+"\t Reserved Private 3 :-"+Track2Data);
		            request+="\n63 len of Reserved Private3 "+idLength+"\t Reserved Private 3 :-"+Track2Data;

		           System.out.println(isoreq);
		        }
		        if (bitbi.charAt(64) == '1') {
		            String messageAuthCode = isoreq.substring( 0, 16);
		            isoreq=isoreq.substring(16, isoreq.length());

		        }
				}catch(Exception e) {
					System.out.print("Anaylst is on Leave"+e);
				}
				return request;
		}

			


	}


