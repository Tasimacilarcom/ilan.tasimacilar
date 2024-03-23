package com.tasimacilar.ilan.system.email;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.loging.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;


@ManagedBean(name = "emailBean")
@ViewScoped
public class EmailBean implements Serializable{
    
    private String serverEmailTyp = "";                       
    private String serverIncomingMailServer = "";             
    private String serverOutgoingMailServer = "";             
    private String serverIncomingMailServerPort = "";         
    private String serverOutgoingMailServerPort = "";         
    private boolean serverOutgoingMailServerReqAuth = false; 
    private String serverMineTyp = "";                       
    private String userDisplayName = "";                      
    private String userEmailAdres = "";                    
    private String userUserName = "";                        
    private String userPassword = "";                         
    private String mailFromAdres = "";                       
    private String mailToLists = "";                         
    private String mailCcLists = "";                        
    private String mailBccLists = "";                        
    private String mailSubject = "";                      
    private String mailBody = "";                           
    private String mailAttachmentFiles = "";              
    private String filePath = "";

    public EmailBean() { 
        
        try {   CompositeConfiguration config = new CompositeConfiguration();

                config.addConfiguration(new SystemConfiguration());
                config.addConfiguration(new PropertiesConfiguration("EmailSettings_Cfg.properties"));

                this.serverEmailTyp = (String) (config.getProperty("mail.transport.protocol"));
                this.serverIncomingMailServer = (String) (config.getProperty("mail.pop3.host"));
                this.serverOutgoingMailServer = (String) (config.getProperty("mail.smtp.host"));
                this.serverIncomingMailServerPort = (String) (config.getProperty("mail.pop3.port"));
                this.serverOutgoingMailServerPort = (String) (config.getProperty("mail.smtp.port"));
                this.serverMineTyp = (String) (config.getProperty("mail.mineTyp"));
                this.serverOutgoingMailServerReqAuth = Boolean.parseBoolean((String) (config.getProperty("mail.smtp.auth")));
                this.userDisplayName = (String) (config.getProperty("gorunenAd"));
                this.userEmailAdres = (String) (config.getProperty("ePostaAdresi"));
                this.userUserName = (String) (config.getProperty("kullaniciAdi"));
                this.userPassword = (String) (config.getProperty("sifre"));
                this.mailFromAdres = userDisplayName+"<"+userEmailAdres+">";
            } 
        catch (ConfigurationException ex) { System.out.println(":::HATA:::"+this.getClass().getName()+ex);}
    }

    public String getServerEmailTyp() {return serverEmailTyp;}
    public void setServerEmailTyp(String serverEmailTyp) {this.serverEmailTyp = serverEmailTyp;}
    public String getServerIncomingMailServer() {return serverIncomingMailServer;}
    public void setServerIncomingMailServer(String serverIncomingMailServer) {this.serverIncomingMailServer = serverIncomingMailServer; }
    public String getServerOutgoingMailServer() {return serverOutgoingMailServer;}
    public void setServerOutgoingMailServer(String serverOutgoingMailServer) {this.serverOutgoingMailServer = serverOutgoingMailServer; }
    public String getServerIncomingMailServerPort() {return serverIncomingMailServerPort;}
    public void setServerIncomingMailServerPort(String serverIncomingMailServerPort) {this.serverIncomingMailServerPort = serverIncomingMailServerPort; }
    public String getServerOutgoingMailServerPort() {return serverOutgoingMailServerPort; }
    public void setServerOutgoingMailServerPort(String serverOutgoingMailServerPort) {this.serverOutgoingMailServerPort = serverOutgoingMailServerPort;}
    public String getServerMineTyp() {return serverMineTyp; }
    public void setServerMineTyp(String serverMineTyp) {this.serverMineTyp = serverMineTyp;}
    public boolean isServerOutgoingMailServerReqAuth() {return serverOutgoingMailServerReqAuth; }
    public void setServerOutgoingMailServerReqAuth(boolean serverOutgoingMailServerReqAuth) {this.serverOutgoingMailServerReqAuth = serverOutgoingMailServerReqAuth; }
    public String getUserDisplayName() {return userDisplayName;}
    public void setUserDisplayName(String userDisplayName) {this.userDisplayName = userDisplayName;}
    public String getEPostaAdresi() {return userEmailAdres;}
    public void setEPostaAdresi(String ePostaAdresi) {this.userEmailAdres = ePostaAdresi;}
    public String getUserUserName() {return userUserName;}
    public void setUserUserName(String userUserName) {this.userUserName = userUserName;}
    public String getUserPassword() {return userPassword;}
    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
    public String getUserEmailAdres() {return userEmailAdres;}
    public void setUserEmailAdres(String userEmailAdres) {this.userEmailAdres = userEmailAdres;}
    public String getMailSubject() {return mailSubject;}
    public void setMailSubject(String mailSubject) {this.mailSubject = mailSubject;}
    public String getMailBody() {return mailBody;}
    public void setMailBody(String mailBody) {this.mailBody = mailBody;}
    public String getMailToLists() {return mailToLists;}
    public void setMailToLists(String mailToLists) {this.mailToLists = mailToLists;}
    public String getMailCcLists() { return mailCcLists;}
    public void setMailCcLists(String mailCcLists) {this.mailCcLists = mailCcLists;}
    public String getMailBccLists() {return mailBccLists;}
    public void setMailBccLists(String mailBccLists) {this.mailBccLists = mailBccLists;}
    public String getMailAttachmentFiles() {return mailAttachmentFiles;}
    public void setMailAttachmentFiles(String mailAttachmentFiles) {this.mailAttachmentFiles = mailAttachmentFiles;}
    public String getFilePath() {return filePath;}
    public void setFilePath(String filePath) {this.filePath = filePath;}
    public String getMailFromAdres() {return mailFromAdres;}
    public void setMailFromAdres(String mailFromAdres) {this.mailFromAdres = mailFromAdres;}
    @Override
    public String toString() {
        return "EmailBean{" + "serverEmailTyp=" + serverEmailTyp 
                            + ", serverIncomingMailServer=" + serverIncomingMailServer 
                            + ", serverOutgoingMailServer=" + serverOutgoingMailServer 
                            + ", serverIncomingMailServerPort=" + serverIncomingMailServerPort 
                            + ", serverOutgoingMailServerPort=" + serverOutgoingMailServerPort 
                            + ", serverOutgoingMailServerReqAuth=" + serverOutgoingMailServerReqAuth 
                            + ", serverMineTyp=" + serverMineTyp 
                            + ", userDisplayName=" + userDisplayName 
                            + ", userEmailAdres=" + userEmailAdres 
                            + ", userUserName=" + userUserName 
                            + ", userPassword=" + userPassword 
                            + ", mailFromAdres=" + mailFromAdres 
                            + ", mailToLists=" + mailToLists 
                            + ", mailCcLists=" + mailCcLists 
                            + ", mailBccLists=" + mailBccLists 
                            + ", mailSubject=" + mailSubject 
                            + ", mailBody=" + mailBody 
                            + ", mailAttachmentFiles=" + mailAttachmentFiles 
                            + ", filePath=" + filePath + '}';
    } public void emailSettingsSave()  {
        PropertiesConfiguration config = null;
     
        try {   config = new PropertiesConfiguration("EmailSettings_Cfg.properties");
                config.setProperty("mail.transport.protocol", this.serverEmailTyp);
                config.setProperty("mail.smtp.host", this.serverOutgoingMailServer);
                config.setProperty("mail.smtp.port", this.serverOutgoingMailServerPort);
                config.setProperty("mail.mineTyp", this.serverMineTyp);
                config.setProperty("mail.smtp.auth", this.serverOutgoingMailServerReqAuth);
                config.setProperty("gorunenAd", this.userDisplayName);
                config.setProperty("ePostaAdresi", this.userEmailAdres);
                config.setProperty("kullaniciAdi", this.userUserName);
                config.setProperty("sifre", this.userPassword);
                config.save();
            } 
        catch (ConfigurationException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                            System.err.println(":::HATA:::properties dosyasından veri yazılamadı:::"+ex);
                                            Messages.insErrMsg(ex.toString());
                                          }
        Messages.insSuccMsg(); 
    }
public void sendMailNow(String to, String cc, String bcc, String govde, String konu, String ekler){
        
        int sonuc;
        
        String to_List = to;
        String[] toList = to_List.split(";");

        String cc_List = cc;
        String[] ccList = cc_List.split(";");

        String bcc_List = bcc;
        String[] bccList = bcc_List.split(";");
        
        String ServerReqAuth="false";
        if(this.serverOutgoingMailServerReqAuth){ServerReqAuth="true";}
        
        
        SendMail_Core sm = new SendMail_Core();
        sonuc = sm.sendMail(this.userUserName, 
                            this.userPassword, 
                            this.userDisplayName, 
                            this.userEmailAdres,
                            this.serverEmailTyp, 
                            this.serverMineTyp, 
                            this.serverOutgoingMailServer, 
                            this.serverOutgoingMailServerPort,
                            ServerReqAuth, 
                            "true", 
                            govde, 
                            konu, 
                            ekler, 
                            toList, 
                            ccList,  
                            bccList);
    
    
    }
    

   
    
}
