/**
 * @author  Yasin KALAYCI (yasin@supforce.com)
 * @since   01-01-2019 
 * @version 1.0.0
 */
package com.tasimacilar.ilan.system.email;


import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail_Core {


    public int sendMail(final String   username,      
                        final String   password,           
                              String   gorunenAd,          
                              String   gorunenEposta,     
                              String   transportProtocol,  
                              String   mime_,              
                              String   smtpHost,           
                              String   smtpPort,           
                              String   smtpAuth,           
                              String   smtpTls,            
                              String   mailBody,           
                              String   mailSubject,        
                              String   attachmentFiles,    
                              String[] mailToList,         
                              String[] mailCcList,        
                              String[] mailBccList ){
        int sonuc = 0;
        
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", transportProtocol);
        properties.put("mail.mineTyp", mime_);
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", smtpAuth);
        properties.put("mail.smtp.starttls.enable", smtpTls);
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Authenticator aut =new Authenticator() { 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}
        };Session session = Session.getInstance( properties, aut); MimeMessage message = new MimeMessage(session);
         InternetAddress mail_From = null;
        String   mailSender= gorunenAd+"<"+gorunenEposta+">";

        try {mail_From = new InternetAddress(mailSender);} 
        catch (AddressException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için FROM Kişisi oluşturma hatası. "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için FROM Kişisi oluşturma hatası.:::"+ex);}
        
        try {message.setFrom(mail_From);} 
        catch (MessagingException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için FROM Kişisi ekleme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için FROM Kişisi ekleme hatası:::"+ex);}
         boolean a = mailToList[0].equals("");
        if (a != true) 
            {   InternetAddress[] mail_To = new InternetAddress[mailToList.length];
                for (int i = 0; i < mailToList.length; i++) 
                    { try {mail_To[i] = new InternetAddress(mailToList[i]);} 
                      catch (AddressException ex) 
                            { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için TO Kişi listesi oluşturma hatası. "+ex.toString(), "system");
                              System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için TO Kişi listesi oluşturma hatası.:::"+ex);}
                    }

               try {message.setRecipients(Message.RecipientType.TO, mail_To);} 
               catch (MessagingException ex) 
                     { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için TO Kişi ekleme hatası "+ex.toString(), "system");
                       System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için TO Kişi ekleme hatası:::"+ex);}
            } 
        else {System.err.println(":::BİLGİ:::"+SendMail_Core.class.getName()+":::Email için TO Kişi listesi boş:::");}
        boolean b = mailCcList[0].equals("");
        if (b != true) 
            {   InternetAddress[] mail_Cc = new InternetAddress[mailCcList.length];
                for (int i = 0; i < mailCcList.length; i++) 
                    { try {mail_Cc[i] = new InternetAddress(mailCcList[i]);} 
                      catch (AddressException ex) 
                            { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için CC Kişi listesi oluşturma hatası. "+ex.toString(), "system");
                              System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için CC Kişi listesi oluşturma hatası:::"+ex);}
                    }

                try {message.setRecipients(Message.RecipientType.CC, mail_Cc);} 
                catch (MessagingException ex) 
                      { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için CC Kişi ekleme hatası "+ex.toString(), "system");
                       System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için CC Kişi ekleme hatası:::"+ex);}
            } 
        else {} boolean c = mailBccList[0].equals("");
        if (c != true) 
            {   InternetAddress[] mail_Bcc = new InternetAddress[mailBccList.length];
                for ( int i = 0; i < mailBccList.length; i++) 
                    { try {mail_Bcc[i] = new InternetAddress(mailBccList[i]);} 
                      catch (AddressException ex) 
                            { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için BCC Kişi listesi oluşturma hatası. "+ex.toString(), "system");
                              System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için BCC Kişi listesi oluşturma hatası:::"+ex);}
                    }

                try { message.setRecipients(Message.RecipientType.BCC, mail_Bcc);} 
                catch (MessagingException ex) 
                      { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email için BCC Kişi ekleme hatası "+ex.toString(), "system");
                       System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email için BCC Kişi ekleme hatası:::"+ex);}
            } 
        else {  }
         try { message.setSubject(mailSubject, "UTF-8"); } 
        catch (MessagingException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email'a Konu ekleme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email'a Konu ekleme hatası:::"+ex);}
 MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart bodyPartMessage = new MimeBodyPart();
        
        try {bodyPartMessage.setContent(mailBody, mime_ + "; charset=utf-8");
             multipart.addBodyPart(bodyPartMessage);
             
                if (attachmentFiles != null && attachmentFiles.trim().length() > 0) 
                    {
                        String attachment[] = attachmentFiles.split(";");
                        for (int i = 0; i < attachment.length; i++) 
                            {
                                MimeBodyPart fileBody = new MimeBodyPart();
                                fileBody.attachFile(attachment[i]);
                                multipart.addBodyPart(fileBody);
                            }
                    }    
            } 
        catch (MessagingException ex ) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email'a ek ekleme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email'a ek ekleme hatası:::"+ex);} 
        catch (IOException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email'a ek ekleme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email'a ek ekleme hatası:::"+ex);}
                
        try { message.setContent(multipart); } 
        catch (MessagingException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email'a ek ekleme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email'a ek ekleme hatası:::"+ex);}
        try { Transport.send(message); 
                sonuc = 1;
                System.out.println(":::BILGI:::"+SendMail_Core.class.getName()+":::Email gonderimi BASARILI:::");
            } 
        catch (MessagingException ex) 
              { LogManagerDao.createLog("error", SendMail_Core.class.getName(), "Email gönderme hatası "+ex.toString(), "system");
                System.err.println(":::HATA:::"+SendMail_Core.class.getName()+":::Email gönderme hatası :::"+ex);}
        
        / return sonuc;
    }  
    
}
