package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.*;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name = "accountActivationBean")
@ViewScoped
public class AccountActivationBean implements Serializable{
    private String      account_EmailActivationId;                
    private String      account_MobilePhoneNumberActivationId;    
    public AccountActivationBean() {  }
    public AccountActivationBean(String account_EmailActivationId, String account_MobilePhoneNumberActivationId) {
        this.account_EmailActivationId = account_EmailActivationId;
        this.account_MobilePhoneNumberActivationId = account_MobilePhoneNumberActivationId;
    }   public String getAccount_EmailActivationId() {return account_EmailActivationId;}
    public void setAccount_EmailActivationId(String account_EmailActivationId) {this.account_EmailActivationId = account_EmailActivationId;}
    public String getAccount_MobilePhoneNumberActivationId() {return account_MobilePhoneNumberActivationId;}
    public void setAccount_MobilePhoneNumberActivationId(String account_MobilePhoneNumberActivationId) {this.account_MobilePhoneNumberActivationId = account_MobilePhoneNumberActivationId;}
public void emailActivationIdCheck(){    
        int sonuc = 0;   boolean isExistEmailActivationId;  isExistEmailActivationId = IsExist.isExistEmailActivationId(this.account_EmailActivationId);        
        if(isExistEmailActivationId){  boolean isActivatedEmail; isActivatedEmail = AccountActivationDao.isActivatedEmail(this.account_EmailActivationId);           
            if(isActivatedEmail){ System.err.println(":::HATA:::" + this.getClass().getName() + ":::Aktivasyon işlemi zaten yapılmış:::");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Aktivasyon işlemi zaten yapılmış");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();       
            }else { AccountActivationDao pa = new AccountActivationDao(); sonuc = pa.updateEmailActivation(this.account_EmailActivationId);
if (sonuc == 1) {System.out.println(":::BILGI:::" + this.getClass().getName() + ":::Email Aktivasyon işlemi BAŞARILI:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARILI","Aktivasyon işlemi BAŞŞARILI");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                } else { System.err.println(":::HATA:::" + this.getClass().getName() + ":::Email Aktivasyon işlemi sırasında sorun oluştu:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Email Aktivasyon işlemi sırasında sorun oluştu");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse(); } }   } else{
            System.err.println(":::HATA:::" + this.getClass().getName() + ":::Yanlış Email Aktivasyon Kodu:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Girilen aktivasyon kodu yanlış.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse(); }  } 
    public void mobilePhoneNumberActivationIdCheck(){   
        int sonuc = 0;boolean isExistMobilePhoneNumberActivationId;  isExistMobilePhoneNumberActivationId = IsExist.isExistMobilePhoneNumberActivationId(this.account_MobilePhoneNumberActivationId);
        if (isExistMobilePhoneNumberActivationId) { boolean isActivatedMobilePhoneNumber;  isActivatedMobilePhoneNumber = AccountActivationDao.isActivatedMobilePhoneNumber(this.account_MobilePhoneNumberActivationId); 
            if (isActivatedMobilePhoneNumber) { Messages.dynMsg(null, "error", "Aktivasyon işlemi zaten yapılmış");}
            else{     AccountActivationDao pa = new AccountActivationDao();
                sonuc = pa.updatemobilePhoneNumberActivation(this.account_MobilePhoneNumberActivationId);
                if(sonuc==1){UrlRedirect.redirect("/login");  } else{ Messages.dynMsg(null, "error", "Mobil telefon numarası aktivasyon işlemi sırasında sorun oluştu"); }
            }           
        } else{ Messages.dynMsg(null, "error", "Girilen aktivasyon kodu yanlış.");} }
    

    
}
