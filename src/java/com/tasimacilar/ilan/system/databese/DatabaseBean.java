package com.tasimacilar.ilan.system.databese;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

@ManagedBean(name = "dbBean")
@ViewScoped
public class DatabaseBean  implements Serializable{
  private String dbTyp;
  private String serverName;
  private String serverPort;
  private String dbName;
  private String dbUserName;
  private String dbUserPassword;
    public DatabaseBean() {
           
        CompositeConfiguration config = new CompositeConfiguration();

        config.addConfiguration(new SystemConfiguration());
        
        try {config.addConfiguration(new PropertiesConfiguration("ConMan_Cfg.properties"));} 
        catch (ConfigurationException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                            System.out.println(":::HATA:::properties dosyasından veri alınamadı:::"+ex);
                                          }

        this.dbTyp = (String) (config.getProperty("Db_Tur"));
        this.serverName = (String) (config.getProperty("Db_Adres"));
        this.serverPort = (String) (config.getProperty("Db_Port"));
        this.dbName = (String) (config.getProperty("Db_Adi"));
        this.dbUserName = (String) (config.getProperty("Db_KullaniciAdi"));
        this.dbUserPassword = (String) (config.getProperty("Db_KullaniciSifre"));
    }
    public DatabaseBean(String dbTyp, 
                        String serverName, 
                        String serverPort, 
                        String dbName, 
                        String dbUserName, 
                        String dbUserPassword) {
        this.dbTyp = dbTyp;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.dbName = dbName;
        this.dbUserName = dbUserName;
        this.dbUserPassword = dbUserPassword;
    }  

    public String getDbTyp() {return dbTyp;}
    public void setDbTyp(String dbTyp) {this.dbTyp = dbTyp;}
    public String getServerName() {return serverName;}
    public void setServerName(String serverName) {this.serverName = serverName;}
    public String getServerPort() {return serverPort;}
    public void setServerPort(String serverPort) {this.serverPort = serverPort;}
    public String getDbName() {return dbName;}
    public void setDbName(String dbName) {this.dbName = dbName;}
    public String getDbUserName() {return dbUserName;}
    public void setDbUserName(String dbUserName) {this.dbUserName = dbUserName;}
    public String getDbUserPassword() {return dbUserPassword;}
    public void setDbUserPassword(String dbUserPassword) {this.dbUserPassword = dbUserPassword;}
    public void dbSettingsSave() {   
        PropertiesConfiguration config = null;
        
        try {config = new PropertiesConfiguration("ConMan_Cfg.properties");} 
        catch (ConfigurationException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                            System.err.println(":::HATA:::properties dosyasından veri yazılamadı:::"+ex);
                                            Messages.insErrMsg(ex.toString());
                                          }

        config.setProperty("Db_Adres", this.serverName);
        config.setProperty("Db_Port", this.serverPort);
        config.setProperty("Db_Adi", this.dbName);
        config.setProperty("Db_Tur", this.dbTyp);
        config.setProperty("Db_KullaniciAdi", this.dbUserName);
        config.setProperty("Db_KullaniciSifre", this.dbUserPassword);
        
        try {config.save();} 
        catch (ConfigurationException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                            System.err.println(":::HATA:::properties dosyasından veri yazılamadı:::"+ex);
                                            Messages.insErrMsg(ex.toString());
                                          }
        Messages.insSuccMsg();
    }


}
