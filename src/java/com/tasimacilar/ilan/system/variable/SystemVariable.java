
package com.tasimacilar.ilan.system.variable;

import com.tasimacilar.ilan.system.sms.SmsBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;


@ManagedBean(name = "SystemVariable")
@ViewScoped
public class SystemVariable implements Serializable{
    
    private String  supforceAppLicenseKey = "dE3-d%2mfTy5dGh2*fGr3ws2f%wRy7800";
    private String  documentUploadPath = "";
    private String  googleMapApiKey = "AIzaSyCWCIe9mZhHfVnmwpEDOOKTqOkUgBjtmbE";
    private String  KULNO = "";
    private String  KULAD = "";
    private String  KULSIFRE = "";
    private String  ORJINATOR = "";
    private String  Adres = "";
    
    @PostConstruct
    public void init() {
        try {   CompositeConfiguration config = new CompositeConfiguration();

                config.addConfiguration(new SystemConfiguration());
                config.addConfiguration(new PropertiesConfiguration("Settings.properties"));
                
                this.documentUploadPath  = (String) (config.getProperty("documentUploadPath"));
                this.KULNO = (String) (config.getProperty("sms_kullaniciNo"));
                this.KULAD = (String) (config.getProperty("sms_kullaniciAdi"));
                this.KULSIFRE = (String) (config.getProperty("sms_kullaniciSifre"));
                this.ORJINATOR = (String) (config.getProperty("sms_orjinator"));
                this.Adres = (String) (config.getProperty("sms_postUrl"));
            } 
        catch (ConfigurationException ex) {System.out.println(":::HATA:::"+ex);}
        
        
    }public String getSupforceAppLicenseKey() {return supforceAppLicenseKey;}
    public void setSupforceAppLicenseKey(String supforceAppLicenseKey) {this.supforceAppLicenseKey = supforceAppLicenseKey;}   
    public String getDocumentUploadPath() {return documentUploadPath;}
    public void setDocumentUploadPath(String documentUploadPath) {this.documentUploadPath = documentUploadPath;}
    public String getGoogleMapApiKey() {return googleMapApiKey;}
    public void setGoogleMapApiKey(String googleMapApiKey) {this.googleMapApiKey = googleMapApiKey;}
    public String getKULNO() { return KULNO;}
    public void setKULNO(String KULNO) {this.KULNO = KULNO;}
    public String getKULAD() {return KULAD;}
    public void setKULAD(String KULAD) {this.KULAD = KULAD;}
    public String getKULSIFRE() {return KULSIFRE;}
    public void setKULSIFRE(String KULSIFRE) {this.KULSIFRE = KULSIFRE;}
    public String getORJINATOR() {return ORJINATOR;}
    public void setORJINATOR(String ORJINATOR) {this.ORJINATOR = ORJINATOR;}
    public String getAdres() {return Adres;}
    public void setAdres(String Adres) {this.Adres = Adres;}

        
    
}
