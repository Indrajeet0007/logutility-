package com.EXTRAJEET.LOGService;


import java.util.Scanner;

import org.json.JSONObject;

import com.EXTRAJEET.constants.Constants;
import com.EXTRAJEET.constants.FieldName;
import com.EXTRAJEET.encryption.TestEncrypter;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.parse.ChaseISO;



public class Analyst {


public static void main(String[] args) {
	Logs logs = new Logs();
	getAnalysis("[vchavan@mkms03app04 ~]$ zgrep --color --text \"254240850824472520\" /opt/auruspay_switch/log/auruspay/auruspay.log-2024-03-25-02.gz\r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.addSingleTransDetail(2280)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]:Generated Aurus Transaction ID : 254240850824472520 \r\n"
			+ "2024-03-25 02:17:25,196 INFO  [2595:3222] [SCMariaDBLiveProcessor.process(72)] - [SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,275 INFO  [2595:14850] [PMPostgresLiveProcessor.process(72)] - [SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,289 INFO  [2595:113] [PMMariaDBLiveProcessor.process(72)] - [SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,303 INFO  [2595:611] [SCHpccDBLiveProcessor.process(71)] - [HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_2_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,498 INFO  [2595:8159] [SCPostgresLiveProcessor.process(72)] - [SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,766 INFO  [2595:609] [PMHpccDBLiveProcessor.process(71)] - [HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_2_0_0_0.txt \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ zgrep --color --te^C/opt/auruspay_switch/log/auruspay/auruspay.log-2024-03-25-02.gz\r\n"
			+ "[vchavan@mkms03app04 ~]$ ^C\r\n"
			+ "[vchavan@mkms03app04 ~]$ ^C\r\n"
			+ "[vchavan@mkms03app04 ~]$ zgrep --color --text \"3de3b29c-48c3-48dc-ba80-f4dcd54073b3\" /opt/auruspay_switch/log/auruspay/auruspay.log-2024-03-25-02.gz\r\n"
			+ "2024-03-25 02:17:24,635 INFO  [2595:23] [AuruspayRESTService.auruspayREST(71)] - Auruspay Rest Service Type(3de3b29c-48c3-48dc-ba80-f4dcd54073b3): transactionService \r\n"
			+ "2024-03-25 02:17:24,636 INFO  [2595:23] [ProcessAurusTransaction.validateAurusRestRequest(84)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:NA:NA:48220782]ENCODED/ENCRYPTED REQUEST : TransactionRequestBO [FormFactorId=48220782, FailoverFlag=null, TxnDateTime=03252024021724, EncryptionFlag=00, Payload=eqoafXoyGYoRWKJVYMQK9A1SUAN9e6+G7WZDd77/oVTU/GgDre0g55u3tABG8L0pdygS05gxyejdVPOAVJ6Kt6xLjkRAzDLS5EjGlRr9l1olIw0cbndBK4tmnDbapGxZssCoSn793xWhedy/3qaTACrRYC+zz6E2KS7hBXd+Gyamw8exuI6Hx2LZ/CIu0jgYB4N4xNyiA4yD0BvDnST9oYqpva4gYAzrOz57GyH08lrFvD6yCgmYwp4OKzxlWr2GOA6BUr5JQHloqD0WaSB8YzzL8f4AYAfbaoql/DCKhDKB5zwn4BjAwp8Ayc/IfEnLk7oNrlIo6JB9VLnjsAphk3GZvjOW8xTfBLzwl2plOYUfafsQQCW8oRfnjxfn6aC4FlBupctG/N6Oglluxo6cWMcWc1fS4bRMZldOyZO6N7tJrFMqPVwqkkSkWc+ftHD+NRg4mM194JKxDf37vgSaYIcBmBZNPdQ/Xa7uSOCMgRMnXSdMDCms/qFCTqzPAggM3H+f4Ge/c0eyvVo+FmI7pRkyeJJZsOP7gaoJxfQMRSqPadB1jTNpp4DoIvdTfcd3rK8nrAVZ16QkBeQ7GW29LlgM9bn51UnGdlOKjqPmj0KqKwkgeC/9hegE+xnYsuM1peoRQ3iv198yTzrXjxjAi+SH+Thb+IYN9rWr1vPPW2bzlBQGcEOMAxJIvIKf76Nnm31sRwu3dTgSokK8zU97SarJLh/seH2ETRICYXcQ9ldImQ6ZRH8luXF9Z/c/FIQu8s1kjtRK1R+qBBhdx4ww/Ry9ESh5xJjGHJvEz4QNqHK4hp1ArJRldWFRQ2MjnAfFJyLi41GcRJXRUVNwBgDh6dTsNZRqBCUyJNfDF0WqtPOuOg/dMt4K1tNkWa0RwCzaKN2bihLdR8vDGq6zEv/8IjT/EQQk2nKDHIuO0LA6CfMv9+icdFSjXaVuQUMshAmDDW/zckqOe6Mqdl3xm+sJMGF5cFD1L+8Xo+/BaeG+hO/uRV5x24OdJx7Pv5kgrfSxvIz+ziyxff4fdZ8eGdw1Dc7ugKNyJ/l5jVTj57ljAYZf4+hmyGKU5wkLPaHN6t50eIYwqTGd5PLJ+fGTTmuWhaUiWfMeBeEAcWJYzTl9yKg=, uniqueId=null] \r\n"
			+ "2024-03-25 02:17:24,636 INFO  [2595:23] [ProcessAurusTransaction.validateAurusRestRequest(110)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:::]INFINISPAN'S VIEW : (MID: ,SID: ,TID: ,SERIAL NO: ,ENCRYPTION KEY: ,AES DYN ENCRYPTION KEY: ) \r\n"
			+ "2024-03-25 02:17:24,636 INFO  [2595:23] [ProcessAurusTransaction.validateAurusRestRequest(134)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:::]-[STPL-GRAY-STREAM]-AURUSPAY ENCRYPTED REQUEST : q+5ETePC7zOO06cRFXWebshPqiJGPZxcX84v2iyFDOVMQkzLc6UYE/nN8333tvZYFp/il/3wLYWzjk0V5hIFxfZ/qqVjJTNMWICcbwShN+Nlw+3KbgfJvzkJv3yJlM/9yEGK9tSEjLPr6BeMtbRdqwnWhobJ9hTFHC73rNUdKp8EcxaffB7YEHPIOqe6TZlGU3is0IYU8oZuiImG4dYsFIRasGhGIsUbf6OP34c4iaQwRuFHBZLfMLKbAqk90MvzFV2jGXViCwBPk++WJgmYfAlBjXDCy1iL19zsAhufCG65SRAF7FuXI78voNX6IasfidIuwRoH3dQTgy9J9ftUTDz2oO3lOCTzYkYs4lF19fAoRr1OGeC+hDBpg43H22DpP+aibRvy/zAv77hv/BA2KeJyU+fyvgjBvsMSUD1hhszlFEEjHlmkt5yl/2M96Xzh9E3nIf3K8D9Lvnw90VmgHmV4zrp1DOtV7wiscBOdF4osKIoc8Buu/WNAKWwqPds3hBQv6/FnPEWB4h1X5Y76b2CBFtnpL/IbDyreKLQDthERrkww7LFFolaBUYhza0s/ \r\n"
			+ "2024-03-25 02:17:24,636 INFO  [2595:23] [AurusISOMux.sendMsg(89)] - Sending Request To Q2 Server(3de3b29c-48c3-48dc-ba80-f4dcd54073b3)...     1800 null \r\n"
			+ "2024-03-25 02:17:24,638 INFO  [2595:236] [ContextMapper.createContext(103)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CONTEXT CREATED FOR REQUEST ID: 3de3b29c-48c3-48dc-ba80-f4dcd54073b3 \r\n"
			+ "2024-03-25 02:17:24,638 INFO  [2595:236] [ISOUtility.injectRequestToAcquirerSpace(264)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Injected Context Into Manager Space : 3de3b29c-48c3-48dc-ba80-f4dcd54073b3 \r\n"
			+ "2024-03-25 02:17:24,638 INFO  [2595:305] [SchemaValidationParticipant.getRequestValidationSchemaBO(212)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [SchemaValidationParticipant.prepare(91)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]SCHEMA VALIDATION SUCCESS................. \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [TxnRequestTypeSelector.prepare(104)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CURRENT REQUEST COUNTER : 0 TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [TxnRequestTypeSelector.setUniversalApiVersion(435)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]WE ARE IN setUniversalApiVersion() method:   \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [TxnRequestTypeSelector.setUniversalApiVersion(437)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Set the ecom universal api version \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [ValidateTransactionParticipant.prepare(111)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Checking Faurd rule for WFC 1 \r\n"
			+ "2024-03-25 02:17:24,639 INFO  [2595:305] [ValidateTransactionParticipant.prepare(633)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]GOING FOR TRACK DATA VALIDATION \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.validateTrackData(1085)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]: MANUAL ENTRY DATA \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.validateTrackData(1091)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]2 \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.validateTrackData(1323)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]AccountNumber  : +xgKk9QInbBCqnDXJ7/ms7uofVBXK61R5pEEW3pJ7+M= \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.validateTrackData(1349)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] EXPIRY VALIDATION \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.validateTrackData(1384)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][ENTRY DATA SOURCE  : 3]  \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.prepare(638)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]RESPONSE CODE : null \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.prepare(797)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]**** P2PE FLAG is NOT 05 or 06 ....!!! **** \r\n"
			+ "2024-03-25 02:17:24,640 INFO  [2595:305] [ValidateTransactionParticipant.prepare(808)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][APPROVAL CODE IN REQUEST  : null] [SUB TRANS TYPE  : null] [POS ACCOUNT TYPE  : null] [AVS AUTH INDICATOR : null]  \r\n"
			+ "2024-03-25 02:17:24,641 INFO  [2595:305] [InfinispanParticipant.prepare(47)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CCT ADITIONAL DATA : null \r\n"
			+ "2024-03-25 02:17:24,641 INFO  [2595:305] [InfinispanParticipant.prepare(48)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CCT ADITIONAL DATA DECODE :  \r\n"
			+ "2024-03-25 02:17:24,648 INFO  [2595:305] [Infinispan.getMerchantDetails(145)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]merchantDetailsBo : MerchantStoreDetails [merchantSequenceNumber=101231281685, merchantId=MRC188282, storeId=00001, corporateId=24021, storeName=BO TEST, deleted=0, doingBusinessAs=BO TEST, phoneticName=BO TEST, phoneNumber=null, contactPerson=BO Team, email=mailbo@aurusinc.com, franchiseName=null, brandName=Lululemon OAUTH Test Corp, rfLevelOne=0, rfLevelTwo=0, rfLevelThree=0, rfLevelFour=0, rfLevelFive=0, address1=Pune, address2=null, city=Pune, state=AL, country=United States, countryCode=840, zipCode=12345, timeZoneValue=2, latitude=null, longitude=null, storeType=4, isCreditPresent=1, isDebitPresent=1, isStoredValuePresent=1, isEbtPresent=0, isFleetPresent=0, isFsaPresent=0, isCheckPresent=0, isPlccPresent=0, isPrepaidPresent=0, isNetBankingPresent=0, supportPeripheralDevice=0, isTestStore=1, isInheritGold=1, isDummyStore=0, isNewNodeStore=1, isCreditOnDebitFailure=0, isRefundWithoutSale=1, storeIdentifierType=0, ecrType=0, isStateTax=0, stateTaxId=null, isFederalTax=0, federalTax=null, isOtherTax=0, otherTax=null, isVarFilePresent=0, crmCaiTokenFlag=null, crmCuiTookenFlag=null, crmMerchantTokenFlag=null, departmentType=null, corpName=Lululemon OAUTH Test Corp, cmCorporateId=24021, refundWoSale=1, cmCrmCaiTokenFlag=0, cmCrmCuiTokenFlag=0, lowerAmountLimit=0, upperAmountLimit=99999999, autoDowloadStartTime=2300, autoDownloadEndTime=0659, names=CST, javaZoneId=America/Chicago, applicationFileName=null, applicationFileSize=null, fileType=null, downloadMode=null, applicationName=null, downloadIp=null, downloadPort=null, softwareVersion=null, cellPhone=, templatePath=null, hostUserName=null, hostPassword=null, startDateTime=null, endDateTime=null, appTerminalID=null, triggeredBy=0, expiryContentFlag=null, terminalId=48220782, settlementTypeMenu=0, updateTemplate=0, favouriteFlag=0, terminalType=3, binrangeFlag=0, charityFlag=0, paymentechTerId=null, systemPasswordFlag=0, serialNumber=null, status=0, encryptionKey=iqzQQM+/DnA/lTsbNmlJBg==, creditPLCCTerminalId=null, debitPLCCTerminalId=null, macAddress=null, bdkType=null, initAutoDownload=N, SecEncryptionKey=null, tpimTerminalId=, processorTerminalId1=, processorTerminalId2=, surveyFlag=0, timeBoundUpgradeFlag=0, triggerId=null, encryptionKeySlot=null, hostIP1=ms03.auruspay.com, hostIP2=ms04.auruspay.com, modifiedSource=AbstractQuartzJobSupport-%s/192.168.122.1/2024-03-24 08:05:48:644, successRedirectURL=null, failureRedirectURL=null, MerchantPhoneNumber=1111111111, setupType=1, taveRegistrationFlag=0, ticketNumLength=18, ecMerchantSequenceNumber=0, ecStoreId=null, ecTerminalId=0, giftBinProfileReference=3, digitalEncryptionType=null, checkDupTransaction=1:0~3:0~4:0~5:0~6:0~7:0~8:0~9:0~10:0~11:0, storeWiseRefund=null, franchiseStoreBilling=0, keyKsnDetails=null, ebtBifurcateConfiguration=0, aesdynencryptionKey=null, aesdynencryptionKeyflag=null, isDebugLogEnable=null, debugLogConfiguration=null, ecommSupportFlag=0, cardIdentifier=null, cardIdentifierLength=null, reAuth=null, refundMoreThanPostauthAmt=null, singleUrlForEcst=null, processorToken=null, plainCardPlcc=null, maskCardNumberFormat=null, ottTimeout=null, cvvTimeout=null, sessionIdTimeout=null, aurusTimeout=null, creditFailOver=null, debittFailOver=null, giftFailOver=null, ebtFailOver=null, fleetFailOver=null, fsaFailOver=null, preparedTerminal=null, httpApplicationFileName=null] \r\n"
			+ "2024-03-25 02:17:24,648 INFO  [2595:305] [Infinispan.getMerchantDetails(272)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]HOST ADDRESS : ms03.auruspay.com \r\n"
			+ "2024-03-25 02:17:24,648 INFO  [2595:305] [InfinispanParticipant.prepare(89)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TERMINAL STATUS : 0 \r\n"
			+ "2024-03-25 02:17:24,648 INFO  [2595:305] [HSMUtility.getHsmToken(70)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]SEND TO HSM FOR TOKEN... \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(75)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DEK RECEIVED FOR REVERSIBLE TOKEN GENERATION : K6BmuE8bCBaPNhv4OSGyZrq8L28ETGxFdORh56PfDK/RWmm7+UPT9u01qhRwSpS/ \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(87)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]KEY ID IS : 1 \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(103)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]KEYBLOCK MODE IN CONFIG : DISABLED \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(105)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]VARIENT MODE DEK KEY : K6BmuE8bCBaPNhv4OSGyZrq8L28ETGxFdORh56PfDK/RWmm7+UPT9u01qhRwSpS/ \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(120)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]THE MESSGE ENTER FOR PADDING :16 \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.getReversibleToken(150)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]-[STPL-GRAY-STREAM]-The Request :cSdrDkuqxFdrn5kOcnroNdcwZ1QXFHHafetBaDJQ4PQW3+KwoAvUXT0tLVJW4/cumbvTZLegFXoNZirAPxnjAjcAs1yuylPzwKGsmwYiRVqRcyTuziwxg564cJ4eD0crY8RtJCDwfdool9kR1a2+FrjDyotK6tXjpc7myAdtIgfaQ8vVrn/6jtB6geRSRXF5 \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMDecryption.hsmCommunication(1409)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]attempt number ::1:: hsm id ::Socket[addr=/172.22.132.235,port=1500,localport=56888] \r\n"
			+ "2024-03-25 02:17:24,649 INFO  [2595:305] [HSMConnection.sendRequest(39)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] Entry into  sendRequest : Socket[addr=/172.22.132.235,port=1500,localport=56888] \r\n"
			+ "2024-03-25 02:17:24,650 INFO  [2595:305] [HSMDecryption.hsmCommunication(1419)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]-[STPL-GRAY-STREAM]-Response received from HSM ::bpfLfRndEuQReSYLvJlP09OgU1WClCvF0caT0Q3pfJqEKHVEYRkjFs0wdCEV2w9HppUJ/ohSC5zFWMXS6079zKXaHrgxUQkeZovpSyQhhDs07OamM4cbMJghj/2oQxio:: from HSM ID ::Socket[addr=/172.22.132.235,port=1500,localport=56888] \r\n"
			+ "2024-03-25 02:17:24,650 INFO  [2595:305] [HSMDecryption.validateResponsePersistentSocket(970)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][SPLIT RESPONSE  : bpfLfRndEuQReSYLvJlP09OgU1WClCvF0caT0Q3pfJqEKHVEYRkjFs0wdCEV2w9HppUJ/ohSC5zFWMXS6079zKXaHrgxUQkeZovpSyQhhDs07OamM4cbMJghj/2oQxio] [RESPONSE CODE  : 00] [RESPONSE COMMAND  : M1]  \r\n"
			+ "2024-03-25 02:17:24,650 INFO  [2595:305] [HSMDecryption.responseParsingPersistentSocket(864)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][RESPONSE LENGTH IS  : 56] [RESPONSE CODE  : M1] [THE IV  : 5A678262A56BBC82] [ERROR CODE  : 00] [MESSAGE LENGTH HEX  : 0020] [MESSAGE  : 9D+wKk3KewBdiZNbHh2ZIRxVGmL+7bHFFNSZzjQEeBm7qH1QVyutUeaRBFt6Se/j] [MESSAGE LENGTH DECIMAL  : 32] [RESPONSE MESSAGE  : 9D+wKk3KewBdiZNbHh2ZIRxVGmL+7bHFFNSZzjQEeBm7qH1QVyutUeaRBFt6Se/j]  \r\n"
			+ "2024-03-25 02:17:24,650 INFO  [2595:305] [HSMUtility.getHsmToken(81)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]HSM CARD TOKEN : 50201591EC06050D5A678262A56BBC82 \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.getCardType(1286)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CLIENT IS NOT USING THIS METHOD \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.getCardType(1291)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CARD TYPE : null \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.getCardType(1292)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] SUB CARD TYPE : null \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.getCardType(1293)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CARD HOLDER ID CODE : 1 \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.prepare(160)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]P2PE FLAG : null \r\n"
			+ "2024-03-25 02:17:24,651 INFO  [2595:305] [BinValidationParticipant.prepare(161)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CORPORATE ID : 24021 \r\n"
			+ "2024-03-25 02:17:24,692 INFO  [2595:305] [GlobalEMVCreditProcessor.validateChinaUnionPay(1902)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]NOT A CHINA UNION PAY...... \r\n"
			+ "2024-03-25 02:17:24,692 INFO  [2595:305] [BinValidationParticipant.prepare(447)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CARD INFO FROM INFI : PanBinRangeDetails [lowBinRange=60114975, highBinRange=60114999, cardDetailsProduct=D, issuingNetwork=00, cardType=NV, panLengthMin=16, panLengthMax=19, rowSequenceNumber=457568, issuerBankName=null, countryCode=USA, prepaidIndicator= , modifiedSource=AbstractQuartzJobSupport-%s/192.168.122.1/2024-03-24 08:10:17:357, binLength=08, cardDetailIndicator=X, debitNwPinLessIndicator=                                                            , fsaIndicator= , productID=007, accountFundSource=C, cardClass=C, tokenIndicator= , ebtState=  , recordType=D, regulatorIndicator=N, visaProductSubType=  , visaLargeTicketIndicator= , accountLevelProcessing=Y, reservedField=null, binDetailPan=16, issuerUpdateYear=19, issuerUpdateMonth=4, issuerUpdateDay=13, debitSignatureNetwork=  , cardholderBillingCur=null, b2bprogramId=null, moneySendIndicator=null, oriCreditMoneyTransInd=null, oriCreditogInd=null, fastFunds=null, oriCrTransInd=null, accFundSourceSubType=null, anonymousPrepaidInd=null] \r\n"
			+ "2024-03-25 02:17:24,692 INFO  [2595:305] [BinValidationParticipant.prepare(485)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CARD TYPE : NV \r\n"
			+ "2024-03-25 02:17:24,695 INFO  [2595:305] [ProcessorInfinispan.fillCreditProcessorDetails(117)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CREDIT PROCESSOR DETAILS :: CreditProcessorDetails [merchantId=MRC188282, creditId=, merchantSequenceNumber=101231281685, processorId=47, processorName=Chase ISO Processor, corporateId=24021, deleted=0, updatedDate=null, updatedDatePrev=null, settlementType=0, isTestProcessor=0, accountName=null, accountPassword=null, storeNumber=null, clientId=null, processorTerminalId1=1:100, processorTerminalId2=null, ecommerceId=null, agentBankNumber=null, processorMerchantId=720000982801, datawireMerchantId=null, merchantCategoryCode=null, applicationId=null, serviceId=null, did=null, securityCode=null, accountNumber=null, developerId=null, developerName=null, merchantNumber=null, acquirerBin=null, agentChainNumber=null, merchantAbaNumber=null, settlementAgentNumber=null, merchantWarehouseName=null, merchantSiteId=null, merchantKey=null, routingData=null, bankId=null, clerkId=null, refreshToken=null, sic=null, checkDigit=null, hardwareType=null, merchantSecretKey=null, publicKey=null, privateKey=null, sharingGroup=null, settlementMerchantId=null, financialId=null, accountTypeId=null, tppId=null, tokenType=null, isTraditionalMerchant=0, subTerminalId=null, uniqueCode=null, subMccCode=null, connectivityType=1, ecommerceFlag=0, cardType=3, transactionPermissionDetails=1:1~2:1~3:1~4:1~5:1~7:1~8:1~9:1~119:1~10:1~11:1~12:1~13:1~14:1, accountType=1, processorSettlementFlag=0, keyId=null, partialTransactionFlag=0, encryptionType=null, rsaType=null, merchantVerfificationValue=null, ecommerceUrl=null, draftLocatorID=null, processorTid1Support=1, processorTid2Support=0, msKeyID=null, safetechToken=0, deviceId=null, versionNumber=null, licenseId=null, uuID=null, secMccCode=null, smMerchantId=MRC188282, smDeleted=0, smMerchantSequenceNumber=101231281685, modifiedSource=AbstractQuartzJobSupport-%s/192.168.122.1/2024-03-24 08:07:45:362] \r\n"
			+ "2024-03-25 02:17:24,698 INFO  [2595:305] [ProcessorInfinispan.fillMultipleTimernalDetails(562)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PROCESSOR TERMINAL DETAILS :: TerminalProcessorIDDetails [terminalId=48220782, processorId=47, merchantSequenceNumber=101231281685, processorTerminalId1=100, processorTerminalId2=null, processorTerminalId3=null, tenderType=1, accountType=1, cardType=3, deleted=0, smMerchantId=MRC188282, smDeleted=0, smMerchantSequenceNumber=101231281685, tmTerminalId=48220782, tmMerchantId=MRC188282, tmStatus=0, modifiedSource=AbstractQuartzJobSupport-%s/192.168.122.1/2024-03-24 08:08:31:932] \r\n"
			+ "2024-03-25 02:17:24,699 INFO  [2595:305] [FillProcessorInfinispanParticipant.prepare(617)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_PAYMENT_TYPE_IND : 0 \r\n"
			+ "2024-03-25 02:17:24,699 INFO  [2595:305] [FillProcessorInfinispanParticipant.prepare(641)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][CARD TYPE ID  : 3] [TERMINAL ID  : 48220782] [POS ACCOUNT TYPE : 1] [PROCESSOR ID  : 47] [CARD TYPE  : NV] [PROCESSOR TEST STATUS  : N] [TRANSACTION PERMISSIONS  : 1:1~2:1~3:1~4:1~5:1~7:1~8:1~9:1~119:1~10:1~11:1~12:1~13:1~14:1] [TRANSACTION PERMISSION FLAG  : true] [PARTIAL AUTH FLAG  : 0] [PAYMENT TYPE  : 0]  \r\n"
			+ "2024-03-25 02:17:24,699 INFO  [2595:305] [RequestAuthorizationParticipant.prepare(227)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782][TRANSACTION TYPE  : 1] [CARD HOLDER ID CODE  : 1] [ENTRY DATA SOURCE  : 3] [TRANSACTION SEQ NUMBER  : 000022] [TRANSACTION AMOUNT  : 0.01] [TIP AMOUNT  : null] [TAX AMOUNT  : null] [CASH BACK AMOUNT  : null] [TOTAL TRANS AMOUNT  : 0.01] [CURRENCY CODE  : 840] [COUNTRY CODE  : 840] [TICKET NUMBER  : null] [P2PE FLAG  : 00] [P2PE FAIL CODE  : null] [SUB TXN TYPE  : null] [ECOM INDICATOR  : null] [API VERSION  : 1.80] [INF MERCHANT TYPE  : 4] [PAY WALLET IDENTIFIER : null] [REVERSAL IDENTIFIER  : null] [REVERSAL REASON  : null] [MERCHANT TYPE : 4] [REQUEST BATCH NUMBER  : 101001] [GENERATED BATCH NUMBER : 085001] [RECEIPT TOKEN  : WK3hiJl6JmoLjjpL5k2PNbuofVBXK61R5pEEW3pJ7+M=] [ACCOUNT NUMBER  : +xgKk9QInbBCqnDXJ7/ms7uofVBXK61R5pEEW3pJ7+M=] [CARD TYPE SUPPORTED FLAG  : true]  \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [RnfFirstLevelParticipant.prepare(56)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]::::::::::::::IN RNF FIRST LEVEL PARTICIPANT::::::::: \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [RnfFirstLevelParticipant.prepare(57)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] API VERSION : 1.80 CORPORATE ID : 24021 INF_MERCHANT_TYPE : 4  TRANSACTION_TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [RnfFirstLevelParticipant.prepare(58)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] KOUNT CORPRATE ID: false \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [RnfFirstLevelParticipant.prepare(83)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] RISK INQUIRY FLAG IS :: null \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [ProcessorTypeSelector.getGroupSelector(166)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IS TEST PROCESSOR : N IMF PROCESSOR ID : 47 \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [ProcessorTypeSelector.getGroupSelector(237)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] INF_CREDIT_PAYMENT_TYPE : 0 \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [ProcessorTypeSelector.getGroupSelector(346)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]SELECTGROUPS     :    Chase_Iso_CREDIT \r\n"
			+ "2024-03-25 02:17:24,700 INFO  [2595:305] [ProcessorQueryParticipant.prepare(82)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]API_VERSION  : 1.80 \r\n"
			+ "2024-03-25 02:17:24,701 INFO  [2595:305] [ProcessorQueryParticipant.prepare(127)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CORPORATE ID LIST :: [22517, 22515, 794, 1955, 2095, 2054, 2096, 2097, 1954, 1674, 22511, 22512, 1234] \r\n"
			+ "2024-03-25 02:17:24,701 INFO  [2595:305] [ProcessorQueryParticipant.prepare(128)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUEST CORPORATE ID :: 24021 \r\n"
			+ "2024-03-25 02:17:24,704 INFO  [2595:305] [SequenceFactory.getDBSequenceNumber(38)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MariaDBDB Sequence Query :SELECT NEXT VALUE FOR CHASE_ISO_SEQUENCE_NUMBER AS SEQ_NUMBER FROM SYSIBM.SYSDUMMY1 \r\n"
			+ "2024-03-25 02:17:24,705 INFO  [2595:305] [TransactionDAOImpl.getChaseIsoTransSequenceNumber(8723)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CHASE ISO SEQUENCE NUMBER : 1241218 \r\n"
			+ "2024-03-25 02:17:24,705 INFO  [2595:305] [ProcessorQueryParticipant.getSequenceNo(1528)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION SEQUENCE NO : 1241218 \r\n"
			+ "2024-03-25 02:17:24,705 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(90)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PIN_BLOCK before : null \r\n"
			+ "2024-03-25 02:17:24,705 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(91)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IMF_ORIGINAL_PIN_BLOCK  : null \r\n"
			+ "2024-03-25 02:17:24,705 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(102)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PIN_BLOCK after : null \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(122)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP TRANSACTION TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ProcessChaseIsoTORRequest.run(42)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_PROCESSOR_ID : 47 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(77)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Processor Id : 47 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(79)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_TRANSACTION_TYPE          : 1 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(80)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]ALT_TRANSACTION_TYPE          : 1 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(81)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]   iTransType       : 1 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(128)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_3D_SECURE_DATA           : null \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(129)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] INF_MERCHANT_TYPE            : 4 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(130)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PAY WALLET INDENTIFIER       : null \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(131)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] INF_CREDIT_CONNECTIVITY_TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(132)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_TIMEOUT_FLAG             : null \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(145)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]::::::::::: SALE TRANSACTION TYPE  :::::  \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(256)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]!!! Customer Initiated Transaction !!!!  \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(298)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_CARD_NUMBER : +xgKk9QInbBCqnDXJ7/ms7uofVBXK61R5pEEW3pJ7+M= \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(301)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MANUAL CARD DATA : +xgKk9QInbBCqnDXJ7/ms7uofVBXK61R5pEEW3pJ7+M= \r\n"
			+ "2024-03-25 02:17:24,706 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(345)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION AMOUNT : 0.01 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(346)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_AMOUNT :null \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(363)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]SURCHARGE  AMOUNT : null \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(373)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION TIME  ::021724 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(380)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION DATE  :: 03252024 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(384)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUEST EXPIRY DATE : 5GkPL4fke47YbFVHYFZSNw== \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(396)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]EXPIRY DATE : 5GkPL4fke47YbFVHYFZSNw== \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(426)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]ENTRY DATA SOURCE : 3 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(457)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]POS ENTRY MODE :011 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(488)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]POS CONDITION CODE (BIT 25): 00 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(532)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]NODE ID : 054 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(534)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IMF_TRANS_SEQ_NUMBER : 001241218 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(543)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]*DBP_TR_RETRIEVAL_REFERENCE_NUM : 054001241218 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(544)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]**IMF_PROC_RESPONSE_KEY : 054001241218 \r\n"
			+ "2024-03-25 02:17:24,707 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(577)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TERMINAL ID : 100 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(580)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MERCHANT ID 720000982801 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(591)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRACK 1 DATA ::  \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(614)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] BILLING_ADDRESS1 :  \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(615)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] BILLING_ZIP_CODE :  \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(778)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CHECK COMMERCIAL CARD TYPE : CARD IS NOT COMMERCIAL \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(779)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAX AMOUNT : null \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(795)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] TAX_AMOUNT : null \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1027)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] 9F6E value - null \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1068)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]BIT 48 LENGTH : 32 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1069)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]BIT 48 DATA : D10246E20800000000P2040001P80200 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1104)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CASHBACK AMOUNT : null \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1130)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]POS DATA : 026A102100000010007           \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1157)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG 62 Data : 074P102801E10208                    P20367EAC0000000000000C80FD54801002448010 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1161)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MERCHANT TYPE : 4 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1316)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] TRANSACTION SOURCEnull \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1317)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MOBILE_DEVICE_IDENTIFIER null \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1318)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] REQ_PROCESSOR_UNIQUE_IDnull \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1339)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRIMARY BIT MAP IN BITS : 0111000000011100000001001000000000001000110000010000000000010110 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1341)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRIMARY BIT MAP : 701c048008c10016 \r\n"
			+ "2024-03-25 02:17:24,708 INFO  [2595:4709] [ChaseISOCreditProcessor.saleAndAuthRequest(1349)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]        HEADER VALUE : 1200 \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseISOCreditProcessor.buildRequest(196)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PROCESSOR REQUEST :: UKCNJ+XZuBBEynMbS6dqsnsXj3vUQUua/u9AV2iNl76Zl5bZaPN6DU4IYXltGY54naeFlQld6k/BKod8ytT94qfcn2CHjSOBQFOnAocy/ykT62SJax6WlM4+4DJaZigpYRbc859RcYbl/tsKFPxz3GH9z/oPLwW8DguwavkQkHuXHdTHlZSaOsl+k0xB6Ee/OpZPBHN7mmt7O41FhaSFD4DYNQ6SU+WAtUkHwCcyIQSYqqmdwuEeO5vLYRHfi4m3GSge4Hm8joUv1sCqt+0kG/FLoDko8kMIgn67hLLY86BAjSmivUrcOTt2QqH2mSpA++naUF/0El8q/bYIZR/h7yDESJH1jPo8K90o09NBMD0yeYdDI+yKeh30DjY/W/EWF6+HQqD08xU/fsjVOPzZ3bWM+7cmDYj+YSgsJv1TRZRCO3zP2wIJuPL7JeMTUPj6eScb04OtstqqhadHsB5UiBdI6cEqbZxqXMrVXxBcRVt/GXaKKiNktaoT8zu6iSSozPFdus/KBjPRV3g9xGJACtt4N1WHgN0G9sVz2zGUxEPbeDdVh4DdBvbFc9sxlMRDS0vM5OAixMxKcdulExmjS7NBxOun7v/gHxayUxtqQrVh/c/6Dy8FvA4LsGr5EJB7AdD3O9ONZ2Nf9K2TeWFI7VO3Ovm4cj0JF6vw0itq3r521opHvhnjgdWx7copnlwkh0cZ/cUhedqm05QwxODScpdTugufkB2QNfwIIKPQkINh/c/6Dy8FvA4LsGr5EJB7S4jotqVciP+EariNv8giRA== \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(95)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]INF_CREDIT_CONNECTIVITY_TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(96)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]INF_DEBIT_CONNECTIVITY_TYPE  : null \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(97)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]INF_EBT_CONNECTIVITY_TYPE    : null \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(98)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]INF_FSA_CONNECTIVITY_TYPE    : null \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ProcessChaseIsoTORRequest.processTransaction(99)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]INF_FLEET_CONNECTIVITY_TYPE    : null \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseIsoPersistentCartridge.connect(76)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUEST KEY ..............!!! :  054001241218 \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseISOUtility.buildRequestbyteArry(46)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]     REQUEST LENGTH : 586 \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseISOUtility.buildRequestbyteArry(47)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]   VA : false 3D SECURE  :  \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseISOUtility.buildRequestbyteArry(120)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]EXIT FROM BUILDREQUESTBYTEARRY \r\n"
			+ "2024-03-25 02:17:24,709 INFO  [2595:4709] [ChaseIsoPersistentCartridge.connect(88)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]: IS TEST PROCESSOR : N FINAL REQUEST KEY  :  054001241218 \r\n"
			+ "2024-03-25 02:17:24,710 INFO  [2595:4709] [ChaseIsoPersistentCartridge.sendRequest(135)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRIMARY PROD SOCKET CONNECTED : true \r\n"
			+ "2024-03-25 02:17:24,710 INFO  [2595:4709] [ChaseIsoPersistentCartridge.sendRequest(136)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRIMARY PROD IP CONNECTED : /206.253.180.141    /15350 \r\n"
			+ "2024-03-25 02:17:24,710 INFO  [2595:4709] [ChaseIsoPersistentCartridge.sendRequest(151)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]LENGTH OF FINALREQUESTARRY:592 \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseIsoPersistentCartridge.connect(91)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]-[STPL-GRAY-STREAM]- FINAL RESPONSE : IgxNsYoSEoGwM8sZIhnoLUYKeXWd3wJbbCNQml9/ygnK1VUKeDZgOHrgkdBa0ohBpn7V7xLAwYVuhOFc1BAavgDP3LFdrJ7HgNx4kUsXjdMh2OYtQFJEcP5muneijV9n5E4nHP3aKcQaNa8u2A112fJHFQimc3xa0xXuPJLbLpzzl58AxlkkpV0K28sVLekns/wmq+h8i0KLYxOg98g7xyxd+ThMTU3IbdzQwmuC7sz9Lh/AaJnIQ4/nD8nX3YXk \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(60)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]RESPONSE MESSAGE TYPE :1210 \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(63)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Bitmap : 020004000ac18004 \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(65)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PRIMARY BITMAP IN BINARY : 0000001000000000000001000000000000001010110000011000000000000100 \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(85)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSMISSOIN DATE AND TIME : 03252024021724 \r\n"
			+ "2024-03-25 02:17:24,721 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(107)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]POS ENTRY MODE : 011 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(114)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]RETRIEVAL REFERENCE NUMBER : 054001241218 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(116)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] DBP_TR_RETRIEVAL_REFERENCE_NUM : 054001241218 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(141)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PROCESSOR RESPONSE CODE :  97 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(157)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CARD ACQUIRER TERMINAL ID : 100 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(163)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CARD ACQUIRER MERCHANT ID : 720000982801 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(173)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]BIT 48 DATA Q80303NS102  S205   00 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(446)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG Q8 INFORMATION : 03N \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(472)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG S2 ACTUAL RESPONSE CODE   :     \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(474)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG S2 ACTUAL AUTH NETWORK ID   : 00 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(604)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CURRENCY CODE : 840 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(771)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG H1 HOST TXN REF INFORMATION  : 0000000003000000 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(773)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] DBP_TA_POS_DATA : 0000000003000000 \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(789)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG H2 HOST TXN TERMINAL RESPONSE  : PROC ERROR 15                    \r\n"
			+ "2024-03-25 02:17:24,722 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(806)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG H3 HOST TXN ERROR NO : 52015 \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(824)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PROCESSOR TOKEN : null \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(828)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] RESPONSE PROCESSOR TOKEN : null \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:4709] [ChaseISOResponseParser.parseCreditResponse(830)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION AMOUNT FROM DB : 0.01 \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(189)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PRES_TA_PROCESSOR_RESPONSE_CODE  :   97 \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(191)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]RESPONSE :: 006 \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:25136] [PauseChaseISOCreditProcessor.run(227)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_RESP_CODE : 006 \r\n"
			+ "2024-03-25 02:17:24,723 INFO  [2595:25136] [ISOUtility.resumeContext(692)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Resuming Paused Transaction... \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ProcessorFailOverParticipant.prepare(54)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_PROCESSOR_ID : 47 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ProcessorFailOverParticipant.prepare(55)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PRES_RESPONSE_CODE :   006 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ProcessorFailOverParticipant.prepare(56)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PRES_TA_PROCESSOR_RESPONSE_CODE      :   97 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ProcessorFailOverParticipant.prepare(57)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] TRANSACTION_TYPE     :   1 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ProcessorFailOverParticipant.prepare(106)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]********** NO NEED OF PROCESSOR FAILOVER ************* \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [RnfSecondLevelParticipant.prepare(76)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]::::::::::::::IN RNF SECOND LEVEL PARTICIPANT::::::::: \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [RnfSecondLevelParticipant.prepare(91)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]:::::::::::::: RISK INQUIRY :::::::: null \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [RnfSecondLevelParticipant.prepare(126)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRES RESPONSE CODE   :   006 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [RnfSecondLevelParticipant.prepare(133)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] API VERSION : 1.80 CORPORATE ID : 24021 INF_MERCHANT_TYPE : 4  TRANSACTION_TYPE : 1 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(113)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IMF_PROCESSOR_IDE            : 47 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(114)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRANSACTION_AMOUNT           : 0.01 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(115)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]ENTRY_DATA_SOURCE            : 3 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(116)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUESTED_TRANSACTION_AMOUNT : 0.01 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(117)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]CURRENCY_CODE                : 840 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(118)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]COUNTRY_CODE                 : 840 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(144)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] : TOTAL TIME TAKEN FOR PROCESSOR :  19 \r\n"
			+ "2024-03-25 02:17:24,724 INFO  [2595:305] [BuildISOResponseParticipant.addCardType(3105)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_CT_CARD_TYPE_ID : NV \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.addCardType(3115)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IMF_CARD_TYPE : NV \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.addSingleTransDetail(2280)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]:Generated Aurus Transaction ID : 254240850824472520 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(426)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]===================================================================== \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(427)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]API_VERSION                     : 1.80 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(428)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]IMF_PROCESSOR_ID                : 47 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(429)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PRES_TA_PROCESSOR_RESPONSE_CODE : 97 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(431)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PROCESSOR_SNF_INDICATOR        : 1 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(432)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]===================================================================== \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(593)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]  PROCESSOR_UNIQUE_ID          : null \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(768)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]STARTING LANGUAGE CONVERSION... \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [MessageConvertor.messageConvertor(39)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]ENGLISH RESPONSE TEXT:PROC ERROR 15                    LANGUAGE INDICATOR : 00 \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [MessageConvertor.messageConvertor(48)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TAG LANGUAGE INDICATOR :  \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [MessageConvertor.messageConvertor(175)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]ENGLISH NO CONVERSION REQUIRED.. \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(772)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TRIMED MESSAGE : PROC ERROR 15                    \r\n"
			+ "2024-03-25 02:17:24,725 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(804)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IMF_PROCESSOR_ID : 47 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [CommonUtility.getConfigFlag(853)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]UPDATE TEMPLATE :0 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(1176)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]API VERSION : 1.80 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(1310)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REFUND WITHOUT SALE FLAG : 1 API VERSION   : 1.80 ORIGINAL TRANSACTION IDENTIFIER   :  TRANSACTION TYPE    : 1 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.buildResponse(1334)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_CT_CARD_TYPE_ID   : NV \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BinValidationParticipant.getCardType(1286)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CLIENT IS NOT USING THIS METHOD \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BinValidationParticipant.getCardType(1291)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CARD TYPE : NV \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BinValidationParticipant.getCardType(1292)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] SUB CARD TYPE : null \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BinValidationParticipant.getCardType(1293)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CARD HOLDER ID CODE : 1 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(925)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] MASKED_CARD_DATA : null \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(926)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PROCESSOR_TOKEN  : null \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(927)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] RESPONSE CODE    : 006 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(928)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] PRES RESPONSE CODE : null \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [BuildISOResponseParticipant.issuerTransactionResponse(937)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]GOT THE WRONG RESPONSE CODE, HENCE, WE ARE NOT GOING FOR ACCERTIFY TOKENIZATION CALL:  \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [AutoDownloadManager.getAutodownloadInfo(50)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUEST SOFTWARE VERSION : 6.07 \r\n"
			+ "2024-03-25 02:17:24,726 INFO  [2595:305] [AutoDownloadManager.getDateTime(482)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DATE BEFORE CONVERSION : null \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(178)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MERCHANT LANGUAGE INDICATORnull \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(381)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]MASKED CARD : 3FXv3auoIfi+uL1KomvYgLuofVBXK61R5pEEW3pJ7+M= \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [VaultTokenUtility.enableCardIdentifierFlag(36)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CARD IDENTIFIER :  \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [VaultTokenUtility.enableCardIdentifierFlag(65)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] CREDIT CI TOKEN FLAG : 1 \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(448)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV MERCHANT TOKEN FLAG : null \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(449)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV CAI TOKEN FLAG : 1 \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(450)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV API FLAG       : null \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(451)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV OPERATION FLAG : null \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [VaultTokenGeneration.getCrmTokens(48)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Enter Inside getCrmTokens()..... \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [VaultTokenGeneration.connectToAurusVault(833)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]-[STPL-GRAY-STREAM]- AURUS-VAULT ENCRYPTED REQUEST : YE88g6fLa4AIaA4yS2z+3he25IyS/JPYEBnh7FABHFAQMEZJ/9vbvGsiiq8cExVkqwqE+WiTQtqCajj25cWaPMFqWSjlkw6kOvAR4xNI+9qbw6QwzMrOYS9brwpHjANbmZH7ZI5JTy/IdshD4e4u4N+bA2VTsTMm2aRUgL0uiHwuhXIrQnba4Fg7XJjIc5c6hDOvbPqqxr56hCaI8NIzEcunYz4rsIkuXZu3YKC9ni8sJKrNcTuzrDHfHmUBjX0cVa9CtL7I/5NSRHbdJ4BPc4B/kgGrkNZEmBZW/57DaaDrwlj73WdbOxOA2jgH7gEwsimgr6tpuHAW929oGeawnJ1mxivRwMrz29AQ/pYKfqNMfye8Nb8Qg/pY7e5AsiINZM0PV5Kd851I2HPJc2QMg5MCDb3n4EYTK/4ke4LYiE2H+WX3Dz6hy+MhoXc6lMAPOBJQMlg4Cq50adLlVx5WuNynp9R4rCf2Jh55A+RCWTEGU1ym2RbHX0s9eTGE/hEPtb+w3OVZ5awOifueg3/AXBwzL94unMgE3w+X7K6J6NAnAQ6rZtZrKOrVBRf+hMuwQ02Cd99EKkHWR1WRdh9UN4AU2ZPrzag9ZaG3tvT/jvw= \r\n"
			+ "2024-03-25 02:17:24,727 INFO  [2595:305] [AurusVaultCartridge.vaultMUXConnector(247)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] SEND TO PRIMARY AURUS-VAULT SYSTEM.... \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultTokenGeneration.connectToAurusVault(839)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] AURUS VAULT REQUEST PROCESS TIME IN MILLI'S : 54 \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultTokenGeneration.connectToAurusVault(854)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]-[STPL-GRAY-STREAM]- AURUS-VAULT ENCRYPTED RESPONSE : YE88g6fLa4AIaA4yS2z+3qCJIDkwa6UXpVDsYQU2f8WQ4QXGn/AU4exx+ohR0UElTRmvwOykTrxjv3Xxj6zEr4pc2sHRjj+6SfFwsZJKvVwCPMzZy+jC3c5vhGQQBNtEW7XcghVve9xSl6IVKQGL/KOaWha5v1bnvox4teCNqFehQnAmPDKrJ+WxCOGpPN3DtG9rLaDkCf/VzHrrgsNBKnI73Yg7k1Vs7A4uzQBIGSfCJVrO2ipi+Jdj9pMd+LmMpU88Li9mTEDSyDQrTVFfH0yfbLw7HBKKU3x1rbPYcdbjHnEBRfemlkbEIK7TyDX9pnCpKtFDXufkPkCeatGW9HyK7Wg4FYpAi0cWRWAKANyR+ZL//lyqm94QS6Y7KEWLgH/Dj/CmN78XUzZFLUfegqbagWBr2cxCiE1EWnbL8eMaARYPZVh4CV4PqLlO1QQEgBTZk+vNqD1lobe29P+O/A== \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(31)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] Entry Inside parseGetCrmTokenResponse()... \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(36)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV RESPONSE CODE     : 000 \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(37)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV RESPONSE MESSAGE  : ATV-APPROVAL \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(38)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] AURUS-VAULT TOKEN RESPONSE PARSING....... \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(54)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV AURUS CI TOKEN  : 1000000000000283 \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(72)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV EXPIRY DATE      :  \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(73)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV CARD HOLDER ID CODE :  \r\n"
			+ "2024-03-25 02:17:24,781 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(74)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV PARTIAL CARD     : null \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(75)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV CARD HOLDER NAME :  \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(76)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV MASKED CARD DATA : 601149XXXXXX3964 \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(77)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV CARD TYPE       : 8 \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(78)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV PREFERRED CARD FLAG :  \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [VaultResponseParser.parseGetCrmTokenResponse(79)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] ATV PROCESSOR TOKEN :  \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(496)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP TR CARD IDENTIFIER : 1000000000000283 \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [IssuerPatchParticipant.buildResponse(585)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] RESPONSE EXPIRY DATE : 5GkPL4fke47YbFVHYFZSNw== \r\n"
			+ "2024-03-25 02:17:24,782 INFO  [2595:305] [ISOUtility.validateISOMsgUnicodeChars(602)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] Sending UTF-8 charset for 00 encryption flag... \r\n"
			+ "2024-03-25 02:17:24,783 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:24,783 INFO  [2595:305] [IssuerDirPollParticipant.buildTransQuery(198)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]PROCESSOR ID 47 \r\n"
			+ "2024-03-25 02:17:24,783 INFO  [2595:305] [IssuerDirPollParticipant.buildTransQuery(289)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]GOING TO INSERT INTO HITMAP && MULTI-TENDER FLAG: false \r\n"
			+ "2024-03-25 02:17:24,783 INFO  [2595:305] [IssuerDirPollParticipant.buildDeclineTransQuery(2393)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]DBP_TR_ENTRYDATA_SOURCE  : 3 DBP_TA_PROCESSOR_TOKEN   : null \r\n"
			+ "2024-03-25 02:17:24,783 INFO  [2595:23] [AurusISOMux.sendMsg(117)] - 3de3b29c-48c3-48dc-ba80-f4dcd54073b3Total Time Taken For Sending Request To Q2 : 0:0:2 \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:23] [AurusISOMux.sendMsg(129)] - Receiving Response From Q2 Server(3de3b29c-48c3-48dc-ba80-f4dcd54073b3)... In: 1810 null \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:305] [IssuerDirPollParticipant.buildDeclineTransQuery(2613)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]POS_ID :: null \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:305] [IssuerDirPollParticipant.buildDeclineTransQuery(2614)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REGISTRATION_NUMBER :: null \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:23] [AuruspayServiceHandler.parseISOMessageResponse(144)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:::]Sending UTF-8 charset for 00 encryption flag... \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:305] [CommonUtility.isTimedOutTransaction(1796)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]REQUEST TIME    : 1711347444638 CURRENT TIME    : 1711347444784 TOTAL TIME TAKEN   : 146 AURUSPAY TIMEOUT   : 18000 \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:23] [ProcessAurusTransaction.responseBuilder(548)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:::]-[STPL-GRAY-STREAM]-AURUSPAY ENCRYPTED RESPONSE : IJbYhasfVRnftzdGxiSjb2McS1M64OnSO8HiHqz0QaX+mfoDruB1U6UdyzwBhMJVyinhHuchRZ4/KSDbNvUks4xqtAaJ1I7p4u/JdO0nIayn04d7SXg6s2swX/ZaS8TnxXczRaWRk9I0X9HJ73TU0stEEWK+3DD2JyPWuV/PdkIig/X6Z1pi8OsiH67im7Vi8Nl9PWwOKJAa1Cw2cLNas5kOtZaN/PZNf+Hgf5vaqo7ekg86caVWvNj6Y4KkMYIOHcgPd2tCJuzC+PdH5PwU5cKT1qrLaPa3s4v+GPlVjcJxd9wQNFBVDKeXbbqo6tbcqhZcbNx3b/9YtxNMPpnY9msMxDXA1PUaWEmRAoJu7DzrBezkLqW4HCF/Cx/AejXpkoCyA0OXP461tZQpK2kwYeMbfsO/A8VqB7LWRfiCMCzX88iP3F8w3oSZV4bgC+pQwlATwpdZ77j4HB7ioQh2mchGAr1GXXF5x1yqmtyXEHjjDc639oBafu1mSNltZ/+Ba5g3KjMNJ5U4v5AVVDl0neZppXhWG+uhQ/2cu6vjo5PJ+VNJPjMlof0ZcUMd2BFvyMqwf7/vFv+myjFz54ma2s6dE7iTHuKyx8/lT7BRMmGE2g6/Kncejw5foJ46f679dCHwRqTKet2rscWv0xxe6ZUiBICrow/iUzIUSFRvWfWDJWkg9vcCwHU/h1oSORnXFVVlOVfEqk/nZVwtHWSdTSBuUibpnd84iLfJg26O6SqgXDOb1hqd3LbuCEjDRwy6B+Xe/GMHgWoPXNiEcu0BB1VbZFRS+jZxENy60voY67b895NzsNUBIfhgj70mnmVOXwLTmEvMlePZckdqyHU42SHy8yd562x14wPlaBjHf5+8PuJufLoWA6YvmmYbaGzmDu3ppfyjx0+9IqJXzYDNmkJzqNwwzPXmGoQ1+Z6SJt89ljf5v8K8Z/BhfEUBz1SaYGjzia6PcliwRzvphPMF02htSKQL7HU9fj68gaxSRTc2KREdZ1TQOJyzNI3xTg+RcE82aNrVF7Bp/1+2d7p203kHmxq15/vwulQ5J2MRELQ= \r\n"
			+ "2024-03-25 02:17:24,784 INFO  [2595:23] [ProcessAurusTransaction.processAurusRestRequest(437)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:::]ENCODED/ENCRYPTED RESPONSE : TransactionResponseBO [encryptionFlag=00, response=CtUmVoOAn0HeMAsCioHI7rn/JHQfIziJLEgMftTQWsrU8KsJ/QnMCVsgLwLWnBc0R6RU4tjJ3nK+q6W4EgoaKyTU1kZkHoRTPa/HHWL8isi/cqyxlFZqLNjP7kxxWAk4Zf5yydWKS80fph0QBqUCIgTkmck4ICjOSC3s7EQsHEHptf9h+IBcRRLAYXVwX4IeKqKutvSBDSOWK+0bd6/dBLsoHXOdiiKD7o2U3e3ADK1hf7hKYY3fMecLMOCgAwO7gL64L+ULdw7b/ZNsAZ+3LzV2OCxk/eNqEasF3FRumR3tfGKJhG67vRKLiZ584MIUlc14gUvdrCYCi29LHqBDEcuFdx3N6H23TW7+2YCyhsd6F/K/cxSDDr5L83xKWWSu1C07X3cCwEr/FuCB8caORLLqr0R5jHXRsjTwndP/QKohIeUkEQmhxFcepUGQmv58Tzh8tBQ7gHOfndYB24jVqhtaOOwBqJ0o1Ynsxm7iIVssLtvQE3Z0jwQjZ1SJI822HktQ5ivVL70IzQkQJfYXAoX3P4IRgZhuP9KQmbDLrQ19W1LZCXdkgBULCfQ0UuFUf8PjXCrc4wXtgP1pkVs5WpSFMt5QCTbGs+AuTEVoOQtajG6B++tHkuGXiqsrfP/DXvzrD4ZJq1jftgsMywvRdbEQ/WX7gDM11WTzwgcHjouR18/VOcWC6xmBcARWnIrZLnmEifyN0rT+xLLR6g1wwYFeVjlUTOkXMLN5g6lXOPel4H6jyCxTpGrcka6cK9GGtEv+5xegXPN46Y/AT7RWuvgGRPzfnNtyAienwm8bC8UTsaNkwguKOvvXL2S/I8exZ+SLAWtyBxEkOGN5n8imVwTi2oXtLhkqXMJeA6OtYtCHCVwTtey2OKyyNTfB2BdR/1IrwO6DcoxookQea/Qtx0C28GqCfzeiIGEr3LnWyrw7b5OztvDbXJmfeTlqf5E3sQj0WDWRTlkBe30oJ5chQm9P8nu/BJSwBgk1vqfUv2OXuxbJ/0yKDzcJ+ikRZPI+UEDaVGkekz5ERgX+++A2DuwCwNKR3Ngd0UN0KtDNeAto+3n5ok2XZE7XL2QVv4vnyuUMpmrTZCi5klrskOOtQqcFf6mRgn7mxEImPaGNme39plJoWdPovuUS+uz/j1Bnaty28dmDi371ECbSCi2nHUpY8VFDyO4H7R1O7CO8kVuk0uQ+uxd0PQwrW9MJ0DC13dAc4awOg/wUTpkZd8r9sWQG2wncVn91s9S+Ewe6clJIfKfguNzoRB6SiyI62WUBklr7PXzMaBp/4QlV2mPISCwzVdp0VSuAWr9Ljsh5lPBTcGjszz4mm1AxIec3VTUCQ6MnXgno2Y5GM/MhhOazh4Rw6kmec0e2R6EC543KWnk9WjCx91TZ4BNf8hZxsPV6DOCSI0eoUMAtK2istQNVxTCP0EvFwjPFzgs4pE/BgD0P1+B04slaKpUOUFRcyRLE8Ajx5WLoWHjXk74GSpDMme0HOCAeXhoHKVONgbw0h/iwqOmalccs3Uozv7bTpJFULkUx6C+KTzoryGVCCuV14TN+Fs3TZix77I5Vox7va4vGWxcOkF5eq3aQOhKtOEDuj0fO19evn89hQcCzPhGQhX675t7WiP7edOpnIf3Yqb1+W+2Sk0DasQc78KgSUkxE36ss35/uFIcNZ7QrEh/iH1zmwXWd46Dnz27hJy8KgJjaN2Es0DcT2C221motUAz1clTfBEkyM1zYW9Gd3Ummt92sus+EJuVHsKAY0BrapWZW3gORjaPYajW33kiCuzsEAaoRsWAwuOD5U/xP2cNLAZllz96vxquA0zjiAUeqMYjxtQymjI8udPBuUBhYL3poWGfxTHcIC4l7j+C5rkqf5uJ05rX8bzjbryUmcDOGQlA0Oa+RR+PaLYX4Dix91+We6r/IL6uimLqOPtv7yAdC5NyawdZbcjD/WXXG1ghrglUs3Bt7uhZjYPpRpfX5N5MKJ4FuEf43CT5+vH/jDB3kEZKG2+TKgCa+MF1ziRbZ3ikO376HBIOwVQZSAQUpatG5ru5mJdaEdZYzXfjS/MSFc1Ugl0boWSW/ijQhtmsp/JrUlH61IiphO808ePnNysCjHqGT5NneUfoiWUBm9IKXNFEE8fpU1zrMVD6klHaPuXA=, txnDateTime=03252024021724, formFactorId=48220782, responseCode=006] \r\n"
			+ "2024-03-25 02:17:24,788 INFO  [2595:305] [WalletCallBackParticipant.prepare(62)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] IN prepare \r\n"
			+ "2024-03-25 02:17:24,788 INFO  [2595:305] [IssuerStplDirPollParticipant.produceIssuerSTPLDirPoll(59)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]GOING TO INSERT INTO TRANSACTIONS ANALYTICS \r\n"
			+ "2024-03-25 02:17:24,788 INFO  [2595:305] [CommonDirPollUtility.transactionsAnalyticsDataInsertion(759)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782] INSIDE INTO transactionsAnalyticsDataInsertion():::  \r\n"
			+ "2024-03-25 02:17:24,788 INFO  [2595:305] [ISOUtility.getProcessedISORequestResponseList(231)] - [3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]TOTAL REQUEST COUNTER : 1 \r\n"
			+ "2024-03-25 02:17:25,196 INFO  [2595:3222] [SCMariaDBLiveProcessor.process(72)] - [SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,275 INFO  [2595:14850] [PMPostgresLiveProcessor.process(72)] - [SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,289 INFO  [2595:113] [PMMariaDBLiveProcessor.process(72)] - [SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SM.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,303 INFO  [2595:611] [SCHpccDBLiveProcessor.process(71)] - [HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_2_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,498 INFO  [2595:8159] [SCPostgresLiveProcessor.process(72)] - [SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : SPO.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_1_0_0_0.txt \r\n"
			+ "2024-03-25 02:17:25,766 INFO  [2595:609] [PMHpccDBLiveProcessor.process(71)] - [HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3:101231281685:00001:48220782]Received File : HPCC.3de3b29c-48c3-48dc-ba80-f4dcd54073b3_254240850824472520_1_101231281685_00001_48220782_2_0_0_0.txt \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "[vchavan@mkms03app04 ~]$ \r\n"
			+ "\r\n"
			+ "",logs);
}


	public static String getAnalysis(String logs ,Logs log) {
		
		
		String proID="-";
		String Api ="-";
		String cardType="--";
		String entryDataSource="--";
		String tender="--";
		String TXNtype="--";
		String UNIQEID=log.getUniqueId();
		Scanner sc1=new Scanner(logs); 
    	
    	String format="";
    	String [] db= {};
    	String [] pro= {};
    	String dateTime="";
    	String MID="";
    	String TID="";
    	String CardNo="";
    	String amount="";
    	String RNN="";
    	String resCode="";
    	String MSG="";
    	
    	String CONtype="";
    	String CCT="";
    	JSONObject CCTRESJSON = new JSONObject();
    	String analysis = "";
    	
    	try {
    	String PROREQ ="";
    	String PRORES="";
    	String parse ="";	
    	String additionalData="";
    	String cctReq="";
    	String cctRes="";
    	
		while(sc1.hasNextLine())  
    	{  
    	String s11=sc1.nextLine(); 
    	
    	if(s11.contains(UNIQEID)) {    	
    	if(s11.contains("ProcessorInfinispan") && s11.contains("processorTerminalId1") && s11.contains("processorMerchantId")) {
    		System.out.println("processorTerminalId1 : "+(TID=s11.substring( s11.indexOf("processorTerminalId1")+21,s11.indexOf("processorTerminalId1")+21+6 )));
    		System.out.println("processorMerchantId : "+(MID=s11.substring( s11.indexOf("processorMerchantId")+20,s11.indexOf("processorMerchantId")+20+12 )));
    		System.out.println("processorId : "+(proID=s11.substring( s11.indexOf("processorId")+12,s11.indexOf("processorId")+12+2 )));
    		System.out.println("DATE & TIME : "+(dateTime=s11.substring(0, 19)));
    	}else if(s11.contains("FillProcessorInfinispanParticipant") && s11.contains("CARD TYPE  :")){
    		System.out.println(s11+"\nCARD TYPE : "+(cardType=s11.substring( s11.indexOf("CARD TYPE  :")+13,s11.indexOf("CARD TYPE  :")+13+2 )));
    	}else if(s11.contains("RequestAuthorizationParticipant") && s11.contains("TOTAL TRANS AMOUNT  :") && s11.contains("API VERSION  :") && s11.contains("ACCOUNT NUMBER  :")) {
    		System.out.println("API VERSION  : "+(Api=s11.substring( s11.indexOf("API VERSION  :")+15,s11.indexOf("API VERSION  :")+15+4 )));
    		System.out.println("ENTRY DATA SOURCE : "+(entryDataSource=s11.substring( s11.indexOf("ENTRY DATA SOURCE  :")+21,s11.indexOf("ENTRY DATA SOURCE  :")+21+1 )));
    		System.out.println("CARD HOLDER ID CODE  : "+(tender=s11.substring( s11.indexOf("CARD HOLDER ID CODE  :")+23,s11.indexOf("CARD HOLDER ID CODE  :")+23+1 )));
    		System.out.println("TOTAL TRANS AMOUNT  : "+(amount=s11.substring(s11.indexOf("TOTAL TRANS AMOUNT  :")+21 , s11.indexOf("TOTAL TRANS AMOUNT  :")+s11.substring(s11.indexOf("TOTAL TRANS AMOUNT  :")).indexOf("]"))   ));
    		System.out.println("ACCOUNT NUMBER  : "+(CardNo=new TestEncrypter().decrypt(s11.substring(s11.indexOf("ACCOUNT NUMBER  :")+18 , s11.indexOf("ACCOUNT NUMBER  :")+s11.substring(s11.indexOf("ACCOUNT NUMBER  :")).indexOf("]"))   ).trim()));
    	}else if(s11.contains("MessageConvertor") && s11.contains("ENGLISH RESPONSE TEXT:")) {
    		System.out.println("ENGLISH RESPONSE TEXT : "+(MSG=s11.substring( s11.indexOf("ENGLISH RESPONSE TEXT:")+22,s11.indexOf("LANGUAGE INDICATOR :") )));
    	}
    	else if(s11.contains("INSERT INTO DECLINED_TRANSACTIONS")) {  
    		 db=(s11.substring( s11.indexOf("INSERT INTO DECLINED_TRANSACTIONS(")+34)).replaceAll("VALUES", ",").replaceAll(",'yyyy", "'yyyy") .replaceAll("'", "")    .split(",");
    		 for(int i=0; i<db.length/2; i++) {
    			 if(db[i].equalsIgnoreCase("DTR_PROCESSOR_RESPONSE_CODE")) {
    				 System.out.println(db[i]+"   :"+(resCode=db[(db.length/2)+i]));    			 
    			 }
    			 if(db[i].equalsIgnoreCase("DTR_RETRIEVAL_REFERENCE_NUM")) {
    				 System.out.println(db[i]+"   :"+(RNN=db[(db.length/2)+i]));    			 
    			 }
    		 }
    	 }
    	
    	
    	if((s11.contains("[STPL-GRAY-STREAM]-AURUSPAY ENCRYPTED REQUEST")) || (s11.contains("[STPL-GRAY-STREAM]-AURUSPAY ENCRYPTED RESPONSE")) ) {
    	 for(int i=134;i<s11.length()-11;i++) {
    		 if( (s11.substring(i,i+7).equalsIgnoreCase("REQUEST")) || (s11.substring(i,i+8).equalsIgnoreCase("RESPONSE"))) {
    	CCT=new TestEncrypter().decrypt((s11.substring(i+10).replaceAll(":", "")).trim());
    	  if(CCT.contains("1.1")&&CCT.contains("1.2")&&CCT.contains("1.3") ) {
          	if(CCT.contains("72.9")&&CCT.contains("72.6")) {
          		
          		cctRes="\n**********************************************************[CCT RESPONSE]************************************************************************\n"
          				+s11+"\n"+CCT+"\n"+FieldName.getparse(CCT)+"\n";
          		 CCTRESJSON = new JSONObject(CCT);
          		CardNo=CCTRESJSON.optString("72.18");
          		amount=CCTRESJSON.optString("72.4",CCTRESJSON.optString("4.11"));
          		TXNtype=CCTRESJSON.optString("4.1");
          		MSG=CCTRESJSON.optString("72.6");
          		resCode=CCTRESJSON.optString("72.2");
          		TID=CCTRESJSON.optString("72.127");
          		MID=CCTRESJSON.optString("72.28");
          		RNN=CCTRESJSON.optString("72.22");
          	}else {
          	cctReq=   "\n**********************************************************[CCT REQUEST]************************************************************************\n"
          			+s11+"\n"+CCT+"\n"+FieldName.getparse(CCT)+"\n";
          	}
          	break;
          }
    	 }
    	 }
  
    	}
    	if((s11.contains("[STPL-GRAY-STREAM]") && !(s11.contains("HSM"))&& !(s11.contains("Vault")))||(s11.contains("PROCESSOR REQUEST")) ) {
    		for(int i=134;i<s11.length()-11;i++) {
    			if( (s11.substring(i,i+9).equalsIgnoreCase("REQUEST :")) || (s11.substring(i,i+10).equalsIgnoreCase("RESPONSE :"))) {    				    				
    				if((s11.contains("PROCESSOR REQUEST :"))||(s11.contains("FINAL REQUEST :"))){
    					PROREQ=new TestEncrypter().decrypt((s11.substring(i+10).replaceAll(":", "")).trim());
    				}else if(s11.contains("FINAL RESPONSE :")) {
    					PRORES=new TestEncrypter().decrypt((s11.substring(i+10).replaceAll(":", "")).trim());    					
    				}    				    				
    			}
    		}
    	}
    	
    	
    	}
    }
    	if(proID.equalsIgnoreCase("47")||proID.equalsIgnoreCase("22") && PROREQ.length()>10) {
    		parse=ChaseISO.parse(PROREQ);
    		PROREQ=ChaseISO.hextoascii(PROREQ).toString();
    	}else if((proID.equalsIgnoreCase("33")||(proID.equalsIgnoreCase("30") ))&& PROREQ.length()>10) {
    		if(PROREQ.contains("&lt;") && PROREQ.contains("&gt;")) {
    			PROREQ=PROREQ.replaceAll("&lt;", "<").replaceAll("&gt;", ">");    			
    		}    		
    	}
    	 additionalData ="\nProID        			:     "+proID
     			+"\nTender        			:     "+tender
     			+"\nEntryDataSource       	:     "+entryDataSource
     			+"\nCardType     			:     "+cardType
     			+"\nAPI        				:     "+Api;
    	format="Aurus Transaction ID             : "+log.getTxnID()+" \r\n"
    			+ "Transaction Type                :  "+TXNtype+"   \r\n"
    			+ "Transaction Date & Time         : "+dateTime+" EST\r\n"
    			+ "Merchant ID                     : "+MID+"\r\n"
    			+ "Terminal ID                     : "+TID+"\r\n"
    			+ "Card Number                     : "+CardNo+"\r\n"
    			+ "Transaction Amount              : $"+amount+"\r\n"
    			+ "URL/IP and Port                 : "+CONtype+"\r\n"
    			+ "Reference Number                : "+RNN+"\r\n"
    			+ "Processor Response Code         :  "+resCode+"\r\n"
    			+ "Response Message                : "+MSG+"\r\n"
//    			+ "Card Type                       : "+cardType+"\r\n"
    			+"Processor Request     :"+PROREQ+"\r\n"
    			+"Processor Response     :"+PRORES+"\r\n"
    			+ "\r\n";
    	 
    	
    	log.setPROREQ(PROREQ);
    	log.setPRORES(PRORES);
    	log.setParse(parse);
    	log.setRaisingFormat(format);
    	log.setAdditionalData(additionalData);
    	log.setCctReq(cctReq);
    	log.setCctRes(cctRes);
    	log.setFileName(proID+"_"+TXNtype+"_"+tender+"_"+entryDataSource+"_"+cardType+"_"+Api+"_");
		System.out.println(analysis=(cctReq+Constants.border+cctRes+Constants.border+UNIQEID+Constants.border+additionalData+Constants.border+format+Constants.border+parse+Constants.border));
		}catch(Exception e) {
			System.out.print("Anaylst is on Leave"+e);
		}
    	
		return analysis;
	}
	

}
