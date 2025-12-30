package com.EXTRAJEET.mail;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Date;
//import java.util.Properties;
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.Authenticator;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.Message.RecipientType;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import com.EXTRAJEET.entities.Logs;





public class MailAlertGenerator {
//	
//	public static void main(String[] args) {
//		Logs log =new Logs();
//		new MailAlertGenerator().sendMailWithAttachment("_--_--_-_--_--___191240652551833467",log);
//	}
//	
//	
////   public static XmlReader xmlReader = XmlReader.getInstance();
//
//   public boolean sendMailWithAttachment(String attachment, Logs log) {
//      System.out.println("Entry into com.auruspay.monro.mail.sendMailWithAttachment()");
//      System.out.println("The email subject is   :" + log.getTxnID());
//      boolean emailStatus = false;
//
//      try {
//         Authenticator auth = new MailAlertGenerator.SMTPAuthenticator((MailAlertGenerator.SMTPAuthenticator)null);
//         Properties mailprops = new Properties();
//         mailprops.setProperty("mail.debug", "true");
//         mailprops.put("mail.host", "mail.aurusinc.com");
//         mailprops.put("mail.transport.protocol", "smtp");
//         mailprops.put("mail.smtp.port", "587");
//         mailprops.put("mail.smtp.auth", "true");
//         Session mailSession = Session.getInstance(mailprops, auth);
//         Transport transport = mailSession.getTransport();
//         Message message = new MimeMessage(Session.getInstance(mailprops, auth));
//         message.setFrom(new InternetAddress("extrajeet@aurusinc.com"));
//         message.setSubject(log.getTxnID());
//         String strEmailIdTo = log.getMailID()+"@aurusinc.com";
//         System.out.println("Email To :: " + strEmailIdTo);
//         String strEmailIdCc = "ikandhare@aurusinc.com";
//         System.out.println("Email CC :: " + strEmailIdCc);
//         String[] recipientsCC;
//         InternetAddress[] addressCC;
//         int i;
//         if (strEmailIdTo != null && strEmailIdTo.trim().length() > 0) {
//            if (!strEmailIdTo.contains(",")) {
//               message.setRecipient(RecipientType.TO, new InternetAddress(strEmailIdTo));
//            } else {
//               recipientsCC = strEmailIdTo.split(",");
//               addressCC = new InternetAddress[recipientsCC.length];
//
//               for(i = 0; i < recipientsCC.length; ++i) {
//                  addressCC[i] = new InternetAddress(recipientsCC[i]);
//               }
//
//               message.setRecipients(RecipientType.TO, addressCC);
//            }
//         }
//
//         if (strEmailIdCc != null && strEmailIdCc.trim().length() > 0) {
//            if (!strEmailIdCc.contains(",")) {
//               message.setRecipient(RecipientType.CC, new InternetAddress(strEmailIdCc));
//            } else {
//               recipientsCC = strEmailIdCc.split(",");
//               addressCC = new InternetAddress[recipientsCC.length];
//
//               for(i = 0; i < recipientsCC.length; ++i) {
//                  addressCC[i] = new InternetAddress(recipientsCC[i]);
//               }
//
//               message.setRecipients(RecipientType.CC, addressCC);
//            }
//         }
//
//         new StringBuffer();
//         StringBuffer sb = this.mailSend(log.getMailID());
//         message.setContent(sb.toString(), "text/html");
//         message.setSentDate(new Date());
//         if (attachment != null && attachment.length() > 0) {
//             BodyPart messageBodyPart1 = new MimeBodyPart();
//             messageBodyPart1.setContent(sb.toString(), "text/html");
//             BodyPart messageBodyPart = new MimeBodyPart();
//             Multipart multipart = new MimeMultipart();
//
//
//             byte[] byteArr = attachment.getBytes();
//             
//             File newfile = new File(log.getTxnID());
//             FileOutputStream fout = new FileOutputStream(newfile);
//             fout.write(byteArr);
//             fout.close();
//             fout.toString();
//             DataSource source = new FileDataSource(newfile);
//             messageBodyPart.setDataHandler(new DataHandler(source));
//             messageBodyPart.setFileName(log.getTxnID());
//             multipart.addBodyPart(messageBodyPart1);
//             multipart.addBodyPart(messageBodyPart);
//             // Put parts in message
//             message.setContent(multipart);
//             System.out.println("filename::::"+log.getTxnID());
//         }
//         try {
//            Transport.send(message);
//            emailStatus = true;
//         } catch (Exception var16) {
//            emailStatus = false;
//         }
//      } catch (Exception var17) {
//         System.out.println("Exception in Entry into com.auruspay.maurices.mail.sendMailWithAttachment() :: " + var17.toString());
//      }
//
//      System.out.println("Exit from Entry into com.auruspay.maurices.mail.sendMailWithAttachment() ");
//      return emailStatus;
//   }
//
//   public StringBuffer mailSend(String userName) {
//      StringBuffer sb = new StringBuffer();
//
//      try {
//         sb.append(" <html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n"
//         		+ "\n"
//         		+ "<head>\n"
//         		+ "	<title></title>\n"
//         		+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
//         		+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]--><!--[if !mso]><!--><!--<![endif]-->\n"
//         		+ "	<style>\n"
//         		+ "		* {\n"
//         		+ "			box-sizing: border-box;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		body {\n"
//         		+ "			margin: 0;\n"
//         		+ "			padding: 0;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		a[x-apple-data-detectors] {\n"
//         		+ "			color: inherit !important;\n"
//         		+ "			text-decoration: inherit !important;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		#MessageViewBody a {\n"
//         		+ "			color: inherit;\n"
//         		+ "			text-decoration: none;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		p {\n"
//         		+ "			line-height: inherit\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		.desktop_hide,\n"
//         		+ "		.desktop_hide table {\n"
//         		+ "			mso-hide: all;\n"
//         		+ "			display: none;\n"
//         		+ "			max-height: 0px;\n"
//         		+ "			overflow: hidden;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		.image_block img+div {\n"
//         		+ "			display: none;\n"
//         		+ "		}\n"
//         		+ "\n"
//         		+ "		@media (max-width:768px) {\n"
//         		+ "\n"
//         		+ "			.desktop_hide table.icons-inner,\n"
//         		+ "			.social_block.desktop_hide .social-table {\n"
//         		+ "				display: inline-block !important;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.icons-inner {\n"
//         		+ "				text-align: center;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.icons-inner td {\n"
//         		+ "				margin: 0 auto;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.mobile_hide {\n"
//         		+ "				display: none;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.row-content {\n"
//         		+ "				width: 100% !important;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.stack .column {\n"
//         		+ "				width: 100%;\n"
//         		+ "				display: block;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.mobile_hide {\n"
//         		+ "				min-height: 0;\n"
//         		+ "				max-height: 0;\n"
//         		+ "				max-width: 0;\n"
//         		+ "				overflow: hidden;\n"
//         		+ "				font-size: 0px;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.desktop_hide,\n"
//         		+ "			.desktop_hide table {\n"
//         		+ "				display: table !important;\n"
//         		+ "				max-height: none !important;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.reverse {\n"
//         		+ "				display: table;\n"
//         		+ "				width: 100%;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.reverse .column.first {\n"
//         		+ "				display: table-footer-group !important;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.reverse .column.last {\n"
//         		+ "				display: table-header-group !important;\n"
//         		+ "			}\n"
//         		+ "\n"
//         		+ "			.row-4 td.column.first .border,\n"
//         		+ "			.row-4 td.column.last .border {\n"
//         		+ "				padding: 5px 20px;\n"
//         		+ "				border-top: 0;\n"
//         		+ "				border-right: 0px;\n"
//         		+ "				border-bottom: 0;\n"
//         		+ "				border-left: 0;\n"
//         		+ "			}\n"
//         		+ "		}\n"
//         		+ "	</style>\n"
//         		+ "</head>\n"
//         		+ "\n"
//         		+ "<body style=\"background-color: #000000; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n"
//         		+ "	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #000000;\">\n"
//         		+ "		<tbody>\n"
//         		+ "			<tr>\n"
//         		+ "				<td>\n"
//         		+ "					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #000000; background-size: auto;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #000000; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"width:100%;\">\n"
//         		+ "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n"
//         		+ "																	<div style=\"max-width: 678px;\"><a href=\"http://www.example.com\" target=\"_blank\" style=\"outline:none\" tabindex=\"-1\"><img src=\"https://348e61c5f3.imgdist.com/pub/bfra/wv7ss5vr/anq/lcp/lbl/Screenshot__97_-removebg-preview.png\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"678\" alt=\"Your Logo\" title=\"Your Logo\" height=\"auto\"></a></div>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:5px;text-align:center;width:100%;\">\n"
//         		+ "																<h3 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 24px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 28.799999999999997px;\"><span class=\"tinyMce-placeholder\">Hey "+userName+" please find below the attachment of logs that you have requested...&nbsp;</span></h3>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:20px;\">\n"
//         		+ "																<div style=\"color:#ffffff;direction:ltr;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:150%;text-align:left;mso-line-height-alt:24px;\">\n"
//         		+ "																	<p style=\"margin: 0;\">╔═════════════════════════════════════════════════════════════════════════════╗<br>║&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;🌟 Fetch Logs from Server Using Transaction ID &nbsp;🌟&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;║<br>╚═════════════════════════════════════════════════════════════════════════════╝<br>📂 Step-by-Step Setup:<br><br>(1) Download Zip: Command: scp -r vchavan@uat42.auruspay.com:EXTRAJEET/LOG_(LATEST VERSION).zip ./<br><br>(2) Extract the contents of \"LOG_(LATEST VERSION).zip\" to your preferred location for saving logs.<br><br>(3) Open the \"EXTRAJEET.xml\" file to customize configuration settings such as Host, Username, Password, Port, Download (Y for download, N to skip), PROD (Y for PROD logs, N to TEST), copy on mail (Y for mail, N to skip), and C (e.g., 10, 5, 0 for the number of nearby lines).<br><br>✨ That's it for the setup!<br><br>🚀 How to Run:<br><br>(1️) Double-click on the \"RUN.bat\" file, or open a terminal at the JAR location and execute the command: `java -jar EXTRAJEET.jar`.<br><br>(2) For PROD logs, enter the username on the console to get logs copied over the mail. Else, just hit enter.<br><br>(3) Enter the Transaction ID and patiently await the logs. You can enter multiple Transaction IDs in a single row, separated by commas, or input them one by one after successful execution.<br><br>(4) Type \"Exit\" to gracefully exit the program.<br><br>🌐 Modes of Operation (Test/Production/Backup):<br><br>🌈 UAT/STAG/BACKUP: Logs are readily available.<br><br>🌈 PROD: Logs are readily available on your mail.<br><br>Enjoy your log-fetching adventure! If you have any questions or need further assistance, feel free to ask. 🚀</p>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"heading_block block-4\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:5px;text-align:center;width:100%;\">\n"
//         		+ "																<h3 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 24px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 28.799999999999997px;\"><span class=\"tinyMce-placeholder\">Hello Users,<br>I hope you're doing well. Please feel free to suggest any required changes or report any bugs you may encounter. Your feedback is valuable to us and helps us improve our platform for everyone's benefit. Thank you for your cooperation!&nbsp; &nbsp;</span></h3>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"button_block block-5\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:15px;text-align:center;\">\n"
//         		+ "																<div class=\"alignment\" align=\"center\"><!--[if mso]>\n"
//         		+ "<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://www.indrajeetkandhare@gamil.com\" style=\"height:52px;width:196px;v-text-anchor:middle;\" arcsize=\"0%\" stroke=\"false\" fillcolor=\"#ffffff\">\n"
//         		+ "<w:anchorlock/>\n"
//         		+ "<v:textbox inset=\"0px,0px,0px,0px\">\n"
//         		+ "<center style=\"color:#000000; font-family:Arial, sans-serif; font-size:16px\">\n"
//         		+ "<![endif]--><a href=\"http://www.indrajeetkandhare@gamil.com\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#000000;background-color:#ffffff;border-radius:0px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:10px;padding-bottom:10px;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:25px;padding-right:25px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"word-break: break-word; line-height: 32px;\">Know more about us</span></span></a><!--[if mso]></center></v:textbox></v:roundrect><![endif]--></div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #000000; border-radius: 0; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"social_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:left;padding-right:0px;padding-left:0px;\">\n"
//         		+ "																<div class=\"alignment\" align=\"left\">\n"
//         		+ "																	<table class=\"social-table\" width=\"36px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\">\n"
//         		+ "																		<tr>\n"
//         		+ "																			<td style=\"padding:0 4px 0 0;\"><a href=\"mailto:\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/mail@2x.png\" width=\"32\" height=\"auto\" alt=\"E-Mail\" title=\"E-Mail\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																		</tr>\n"
//         		+ "																	</table>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:center;width:100%;\">\n"
//         		+ "																<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 45.6px;\"><span class=\"tinyMce-placeholder\">Contact us on mail</span></h1>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:20px;\">\n"
//         		+ "																<div style=\"color:#ffffff;direction:ltr;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:150%;text-align:left;mso-line-height-alt:24px;\">\n"
//         		+ "																	<p style=\"margin: 0;\">We are highly active here</p>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"button_block block-4\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:left;\">\n"
//         		+ "																<div class=\"alignment\" align=\"left\"><!--[if mso]>\n"
//         		+ "<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://www.indrajeetkandhare@gmail.com\" style=\"height:52px;width:117px;v-text-anchor:middle;\" arcsize=\"0%\" stroke=\"false\" fillcolor=\"#ffffff\">\n"
//         		+ "<w:anchorlock/>\n"
//         		+ "<v:textbox inset=\"0px,0px,0px,0px\">\n"
//         		+ "<center style=\"color:#000000; font-family:Arial, sans-serif; font-size:16px\">\n"
//         		+ "<![endif]--><a href=\"http://www.indrajeetkandhare@gmail.com\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#000000;background-color:#ffffff;border-radius:0px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:10px;padding-bottom:10px;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:25px;padding-right:25px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"word-break: break-word; line-height: 32px;\">Follow us</span></span></a><!--[if mso]></center></v:textbox></v:roundrect><![endif]--></div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "												<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"width:100%;\">\n"
//         		+ "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n"
//         		+ "																	<div style=\"max-width: 410px;\"><img src=\"https://348e61c5f3.imgdist.com/pub/bfra/wv7ss5vr/12o/hry/7z4/pngegg.png\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"410\" alt=\"Facebook\" title=\"Facebook\" height=\"auto\"></div>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #000000; border-radius: 0; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"width:100%;\">\n"
//         		+ "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n"
//         		+ "																	<div style=\"max-width: 410px;\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7466/link1.png\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"410\" alt=\"LinkedIn\" title=\"LinkedIn\" height=\"auto\"></div>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "												<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"social_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:left;padding-right:0px;padding-left:0px;\">\n"
//         		+ "																<div class=\"alignment\" align=\"left\">\n"
//         		+ "																	<table class=\"social-table\" width=\"36px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\">\n"
//         		+ "																		<tr>\n"
//         		+ "																			<td style=\"padding:0 4px 0 0;\"><a href=\"https://www.linkedin.com\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/linkedin@2x.png\" width=\"32\" height=\"auto\" alt=\"LinkedIn\" title=\"LinkedIn\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																		</tr>\n"
//         		+ "																	</table>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:center;width:100%;\">\n"
//         		+ "																<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 45.6px;\"><span class=\"tinyMce-placeholder\">Connect us on LinkedIn</span></h1>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:20px;\">\n"
//         		+ "																<div style=\"color:#ffffff;direction:ltr;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:150%;text-align:left;mso-line-height-alt:24px;\">\n"
//         		+ "																	<p style=\"margin: 0;\">Here we repost informative content</p>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"button_block block-4\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:left;\">\n"
//         		+ "																<div class=\"alignment\" align=\"left\"><!--[if mso]>\n"
//         		+ "<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://www.examplehttps://in.linkedin.com/in/indrajeet-kandhare-4777b6161.com\" style=\"height:52px;width:117px;v-text-anchor:middle;\" arcsize=\"0%\" stroke=\"false\" fillcolor=\"#ffffff\">\n"
//         		+ "<w:anchorlock/>\n"
//         		+ "<v:textbox inset=\"0px,0px,0px,0px\">\n"
//         		+ "<center style=\"color:#000000; font-family:Arial, sans-serif; font-size:16px\">\n"
//         		+ "<![endif]--><a href=\"http://www.examplehttps://in.linkedin.com/in/indrajeet-kandhare-4777b6161.com\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#000000;background-color:#ffffff;border-radius:0px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:10px;padding-bottom:10px;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:25px;padding-right:25px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"word-break: break-word; line-height: 32px;\">Follow us</span></span></a><!--[if mso]></center></v:textbox></v:roundrect><![endif]--></div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #000000; border-radius: 0; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr class=\"reverse\">\n"
//         		+ "												<td class=\"column column-1 first\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<div class=\"border\">\n"
//         		+ "														<table class=\"social_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "															<tr>\n"
//         		+ "																<td class=\"pad\" style=\"text-align:left;padding-right:0px;padding-left:0px;\">\n"
//         		+ "																	<div class=\"alignment\" align=\"left\">\n"
//         		+ "																		<table class=\"social-table\" width=\"36px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\">\n"
//         		+ "																			<tr>\n"
//         		+ "																				<td style=\"padding:0 4px 0 0;\"><a href=\"https://www.instagram.com\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/instagram@2x.png\" width=\"32\" height=\"auto\" alt=\"Instagram\" title=\"Instagram\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																			</tr>\n"
//         		+ "																		</table>\n"
//         		+ "																	</div>\n"
//         		+ "																</td>\n"
//         		+ "															</tr>\n"
//         		+ "														</table>\n"
//         		+ "														<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "															<tr>\n"
//         		+ "																<td class=\"pad\" style=\"text-align:center;width:100%;\">\n"
//         		+ "																	<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 45.6px;\"><span class=\"tinyMce-placeholder\">Follow us on Instagram</span></h1>\n"
//         		+ "																</td>\n"
//         		+ "															</tr>\n"
//         		+ "														</table>\n"
//         		+ "														<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
//         		+ "															<tr>\n"
//         		+ "																<td class=\"pad\" style=\"padding-bottom:20px;\">\n"
//         		+ "																	<div style=\"color:#ffffff;direction:ltr;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:150%;text-align:left;mso-line-height-alt:24px;\">\n"
//         		+ "																		<p style=\"margin: 0;\">Here we share informative content with reels</p>\n"
//         		+ "																	</div>\n"
//         		+ "																</td>\n"
//         		+ "															</tr>\n"
//         		+ "														</table>\n"
//         		+ "														<table class=\"button_block block-4\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "															<tr>\n"
//         		+ "																<td class=\"pad\" style=\"text-align:left;\">\n"
//         		+ "																	<div class=\"alignment\" align=\"left\"><!--[if mso]>\n"
//         		+ "<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.instagram.com/extrajeet.exe/\" style=\"height:52px;width:117px;v-text-anchor:middle;\" arcsize=\"0%\" stroke=\"false\" fillcolor=\"#ffffff\">\n"
//         		+ "<w:anchorlock/>\n"
//         		+ "<v:textbox inset=\"0px,0px,0px,0px\">\n"
//         		+ "<center style=\"color:#000000; font-family:Arial, sans-serif; font-size:16px\">\n"
//         		+ "<![endif]--><a href=\"https://www.instagram.com/extrajeet.exe/\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#000000;background-color:#ffffff;border-radius:0px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:10px;padding-bottom:10px;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:25px;padding-right:25px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"word-break: break-word; line-height: 32px;\">Follow us</span></span></a><!--[if mso]></center></v:textbox></v:roundrect><![endif]--></div>\n"
//         		+ "																</td>\n"
//         		+ "															</tr>\n"
//         		+ "														</table>\n"
//         		+ "													</div>\n"
//         		+ "												</td>\n"
//         		+ "												<td class=\"column column-2 last\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 20px; padding-right: 20px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<div class=\"border\">\n"
//         		+ "														<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "															<tr>\n"
//         		+ "																<td class=\"pad\" style=\"width:100%;\">\n"
//         		+ "																	<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n"
//         		+ "																		<div style=\"max-width: 410px;\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7466/insta3.png\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"410\" alt=\"Instagram\" title=\"Instagram\" height=\"auto\"></div>\n"
//         		+ "																	</div>\n"
//         		+ "																</td>\n"
//         		+ "															</tr>\n"
//         		+ "														</table>\n"
//         		+ "													</div>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #000000; border-radius: 0; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<div class=\"spacer_block block-1\" style=\"height:35px;line-height:35px;font-size:1px;\">&#8202;</div>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-6\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #000000; border-radius: 0; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"social_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"text-align:center;padding-right:0px;padding-left:0px;\">\n"
//         		+ "																<div class=\"alignment\" align=\"center\">\n"
//         		+ "																	<table class=\"social-table\" width=\"108px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\">\n"
//         		+ "																		<tr>\n"
//         		+ "																			<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.facebook.com\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/facebook@2x.png\" width=\"32\" height=\"auto\" alt=\"Facebook\" title=\"facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																			<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.linkedin.com\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/linkedin@2x.png\" width=\"32\" height=\"auto\" alt=\"Linkedin\" title=\"linkedin\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																			<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.instagram.com\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-only-logo-white/instagram@2x.png\" width=\"32\" height=\"auto\" alt=\"Instagram\" title=\"instagram\" style=\"display: block; height: auto; border: 0;\"></a></td>\n"
//         		+ "																		</tr>\n"
//         		+ "																	</table>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "													<table class=\"paragraph_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"padding-bottom:5px;\">\n"
//         		+ "																<div style=\"color:#ffffff;direction:ltr;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:150%;text-align:center;mso-line-height-alt:24px;\">\n"
//         		+ "																	<p style=\"margin: 0;\">2024 © All rights reserved</p>\n"
//         		+ "																</div>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "					<table class=\"row row-7\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff;\">\n"
//         		+ "						<tbody>\n"
//         		+ "							<tr>\n"
//         		+ "								<td>\n"
//         		+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 900px; margin: 0 auto;\" width=\"900\">\n"
//         		+ "										<tbody>\n"
//         		+ "											<tr>\n"
//         		+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
//         		+ "													<table class=\"icons_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;\">\n"
//         		+ "														<tr>\n"
//         		+ "															<td class=\"pad\" style=\"vertical-align: middle; color: #1e0e4b; font-family: 'Inter', sans-serif; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n"
//         		+ "																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
//         		+ "																	<tr>\n"
//         		+ "																		<td class=\"alignment\" style=\"vertical-align: middle; text-align: center;\"><!--[if vml]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n"
//         		+ "																			<!--[if !vml]><!-->\n"
//         		+ "																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><!--<![endif]-->\n"
//         		+ "																				<tr>\n"
//         		+ "																					<td style=\"vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\"><a href=\"http://designedwithbeefree.com/\" target=\"_blank\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Beefree Logo\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/assets/Beefree-logo.png\" height=\"auto\" width=\"34\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n"
//         		+ "																					<td style=\"font-family: 'Inter', sans-serif; font-size: 15px; font-weight: undefined; color: #1e0e4b; vertical-align: middle; letter-spacing: undefined; text-align: center;\"><a href=\"http://designedwithbeefree.com/\" target=\"_blank\" style=\"color: #1e0e4b; text-decoration: none;\">Designed with Beefree</a></td>\n"
//         		+ "																				</tr>\n"
//         		+ "																			</table>\n"
//         		+ "																		</td>\n"
//         		+ "																	</tr>\n"
//         		+ "																</table>\n"
//         		+ "															</td>\n"
//         		+ "														</tr>\n"
//         		+ "													</table>\n"
//         		+ "												</td>\n"
//         		+ "											</tr>\n"
//         		+ "										</tbody>\n"
//         		+ "									</table>\n"
//         		+ "								</td>\n"
//         		+ "							</tr>\n"
//         		+ "						</tbody>\n"
//         		+ "					</table>\n"
//         		+ "				</td>\n"
//         		+ "			</tr>\n"
//         		+ "		</tbody>\n"
//         		+ "	</table><!-- End -->\n"
//         		+ "</body>\n"
//         		+ "\n"
//         		+ "</html>");
//           
//      } catch (Exception var6) {
//         System.out.println("Exception in com.auruspay.monro.mail.mailSend() :: " + var6);
//      }
//
//      return sb;
//   }
//
//   private class SMTPAuthenticator extends Authenticator {
//      private SMTPAuthenticator() {
//      }
//
//      public PasswordAuthentication getPasswordAuthentication() {
//         String username = "support@aurusinc.com";
////         String password = "Pass#123";
//         
//          
//          String password = "VVffrr4$123";
//         return new PasswordAuthentication(username, password);
//      }
//
//      // $FF: synthetic method
//      SMTPAuthenticator(MailAlertGenerator.SMTPAuthenticator var2) {
//         this();
//      }
   }

