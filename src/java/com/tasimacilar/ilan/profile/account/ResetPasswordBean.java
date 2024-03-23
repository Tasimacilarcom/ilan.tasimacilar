package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.IsExist;
import com.tasimacilar.ilan.system.Match;
import com.tasimacilar.ilan.system.PasswordHashing;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.sms.SmsBean;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
@ManagedBean(name = "resetPasswordBean")
@SessionScoped
public class ResetPasswordBean implements Serializable{ 
    private String      resetPassword_Id;
    private String      resetPassword_GsmNo;                      
    private Date        resetPassword_SmsOnayKodu_RequestTime;     
    private String      resetPassword_SmsOnayKodu_RequestIp;       
    private int         resetPassword_SmsOnayKodu_RequestSize;  
    private String      resetPassword_SmsOnayKodu;               
    private String      resetPassword_Password;                    
    private String      resetPassword_PasswordAgain;               
    private Date        resetPassword_ChangeTime;                  
    private String      resetPassword_ChangeIp;                  
    private boolean     resetPassword_IsActive;                     
    @PostConstruct
    public void init() {   }    
    public ResetPasswordBean() { }
public ResetPasswordBean(   String gsmNo, String smsOnayKodu, String sife, 
                                String sifreTekrar, Date sifre_CreateTime, String sifre_CreatedIp) {
        this.resetPassword_GsmNo = gsmNo;
        this.resetPassword_SmsOnayKodu = smsOnayKodu;
        this.resetPassword_Password = sife;
        this.resetPassword_PasswordAgain = sifreTekrar;
        this.resetPassword_ChangeTime = sifre_CreateTime;
        this.resetPassword_ChangeIp = sifre_CreatedIp;
    }public String getResetPassword_Id() {return resetPassword_Id;}
    public void setResetPassword_Id(String resetPassword_Id) { this.resetPassword_Id = resetPassword_Id;}
    public String getResetPassword_GsmNo() {return resetPassword_GsmNo;}
    public void setResetPassword_GsmNo(String resetPassword_GsmNo) {this.resetPassword_GsmNo = resetPassword_GsmNo;}
    public Date getResetPassword_SmsOnayKodu_RequestTime() {return resetPassword_SmsOnayKodu_RequestTime;}
    public void setResetPassword_SmsOnayKodu_RequestTime(Date resetPassword_SmsOnayKodu_RequestTime) {this.resetPassword_SmsOnayKodu_RequestTime = resetPassword_SmsOnayKodu_RequestTime;}
    public String getResetPassword_SmsOnayKodu_RequestIp() {return resetPassword_SmsOnayKodu_RequestIp;}
    public void setResetPassword_SmsOnayKodu_RequestIp(String resetPassword_SmsOnayKodu_RequestIp) {this.resetPassword_SmsOnayKodu_RequestIp = resetPassword_SmsOnayKodu_RequestIp;}
    public int getResetPassword_SmsOnayKodu_RequestSize() { return resetPassword_SmsOnayKodu_RequestSize;}
    public void setResetPassword_SmsOnayKodu_RequestSize(int resetPassword_SmsOnayKodu_RequestSize) {this.resetPassword_SmsOnayKodu_RequestSize = resetPassword_SmsOnayKodu_RequestSize;}
    public String getResetPassword_SmsOnayKodu() {return resetPassword_SmsOnayKodu;}
    public void setResetPassword_SmsOnayKodu(String resetPassword_SmsOnayKodu) {this.resetPassword_SmsOnayKodu = resetPassword_SmsOnayKodu;}
    public String getResetPassword_Password() {return resetPassword_Password;}
    public void setResetPassword_Password(String resetPassword_Password) {this.resetPassword_Password = resetPassword_Password;}
    public String getResetPassword_PasswordAgain() {return resetPassword_PasswordAgain;}
    public void setResetPassword_PasswordAgain(String resetPassword_PasswordAgain) {this.resetPassword_PasswordAgain = resetPassword_PasswordAgain;}
    public Date getResetPassword_ChangeTime() {return resetPassword_ChangeTime;}
    public void setResetPassword_ChangeTime(Date resetPassword_ChangeTime) {this.resetPassword_ChangeTime = resetPassword_ChangeTime;}
    public String getResetPassword_ChangeIp() {return resetPassword_ChangeIp;}
    public void setResetPassword_ChangeIp(String resetPassword_ChangeIp) {this.resetPassword_ChangeIp = resetPassword_ChangeIp;}
    public boolean isResetPassword_IsActive() {return resetPassword_IsActive;}
    public void setResetPassword_IsActive(boolean resetPassword_IsActive) {this.resetPassword_IsActive = resetPassword_IsActive;}
 @Override
    public String toString() {
        return "ResetPasswordBean{" + "resetPassword_Id=" + resetPassword_Id 
                                    + ", resetPassword_GsmNo=" + resetPassword_GsmNo 
                                    + ", resetPassword_SmsOnayKodu_RequestTime=" + resetPassword_SmsOnayKodu_RequestTime 
                                    + ", resetPassword_SmsOnayKodu_RequestIp=" + resetPassword_SmsOnayKodu_RequestIp 
                                    + ", resetPassword_SmsOnayKodu_RequestSize=" + resetPassword_SmsOnayKodu_RequestSize 
                                    + ", resetPassword_SmsOnayKodu=" + resetPassword_SmsOnayKodu 
                                    + ", resetPassword_Password=" + resetPassword_Password 
                                    + ", resetPassword_PasswordAgain=" + resetPassword_PasswordAgain 
                                    + ", resetPassword_ChangeTime=" + resetPassword_ChangeTime 
                                    + ", resetPassword_ChangeIp=" + resetPassword_ChangeIp 
                                    + ", resetPassword_IsActive=" + resetPassword_IsActive + '}';
    } public void sendResetPasswordSmsCode(){
  if(this.resetPassword_GsmNo != null && !this.resetPassword_GsmNo.equals("")){
         boolean mobilePhoneNumberIsExist;
            mobilePhoneNumberIsExist=IsExist.isExistMobilePhoneNumber(this.resetPassword_GsmNo);
           boolean canNotChangeUserPassword;
            canNotChangeUserPassword=IsExist.canNotChangeUserPassword(this.resetPassword_GsmNo);
  if(mobilePhoneNumberIsExist){
               if(!canNotChangeUserPassword){
                    ResetPasswordDao rpdx = new ResetPasswordDao();
                    reqSize = rpdx.getPasswordChangeRequestSize(this.resetPassword_GsmNo);
                  if(reqSize <= 10){
                      int sonuc = 0;
                     HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                        String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
String resetPasswordSmsCode = null;
                        resetPasswordSmsCode = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
ResetPasswordBean r = new ResetPasswordBean();
                        r.setResetPassword_Id(UniqueId.RandomString(10));
                        r.setResetPassword_GsmNo(this.resetPassword_GsmNo);
                        r.setResetPassword_SmsOnayKodu_RequestTime(new Date());
                        r.setResetPassword_SmsOnayKodu_RequestIp(userInternetIp);
                        r.setResetPassword_SmsOnayKodu_RequestSize(0);
                        r.setResetPassword_SmsOnayKodu(resetPasswordSmsCode);
                        r.setResetPassword_Password(null);
                        r.setResetPassword_PasswordAgain(null);
                        r.setResetPassword_ChangeTime(null);
                        r.setResetPassword_ChangeIp(null);
                        r.setResetPassword_IsActive(true);
  ResetPasswordDao rpd = new ResetPasswordDao();
                        sonuc = rpd.createPasswordChangeRecord(r);
 if(sonuc == 1){         SmsBean.sendSms(this.resetPassword_GsmNo, resetPasswordSmsCode);
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("BAŞARILI","SMS onay kodunuz gönderilmiştir");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                            facesContext.addMessage(null, facesMessage);
                            facesContext.renderResponse();
                        }
                        else {
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Parola yenileme için sms onay kodu olusturulamadı:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","SMS onay kodu olusturulamadı");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage(null, facesMessage);
                            facesContext.renderResponse();
                        } 
                    
                    }
                    else{
                        
                        int sonuc=0;
                        ResetPasswordDao rs = new ResetPasswordDao();
                        sonuc = rs.updateAccountPasswordNotChange(this.resetPassword_GsmNo);
                        
                        if(sonuc == 1){
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Çok fazla şifre değiştirme talebinde bulunuldu.Hesap kısıtlandı:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Çok fazla şifre değiştirme talebinde bulundunuz.Bu özellik artık size kapatılmıştır");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage(null, facesMessage);
                            facesContext.renderResponse();
                        }
                        else{
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Çok fazla şifre değiştirme talebinde bulunuldu.Hesap kısıtlama sırasında sorun olustu:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Teknik bir sorun oluştu");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage(null, facesMessage);
                            facesContext.renderResponse();
                        }
                    
                    
                    }
                             
                }
                 else{
                    System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama engellenmiş:::");          
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Bu hesabın şifre değiştirmesi site yöneticisi tarafından engellenmiş");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                }
            }
             else{
                System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama için girilen gsm no sistemde yok:::");          
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Girilen GSM Numarasi sistemimizde yok");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
       }
       else{System.err.println(":::HATA:::Sifre sifirlamak icin gsm no bos veya null geldi");}
       
   
   }public void resetPassword(){ if(  this.resetPassword_SmsOnayKodu != null && this.resetPassword_GsmNo != null &&
            !this.resetPassword_SmsOnayKodu.equals("") && !this.resetPassword_GsmNo.equals("")){ 
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
 boolean smsOnayKoduIsExist;
            smsOnayKoduIsExist=IsExist.isExistSmsOnayKodu(this.resetPassword_SmsOnayKodu, this.resetPassword_GsmNo );
 if(smsOnayKoduIsExist){
 long toTime = new Date().getTime();
                long reqTime = 0;
                ResetPasswordDao r = new ResetPasswordDao();
                boolean resetPasswordIsActive = r.getSmsOnayKoduDetay(this.resetPassword_SmsOnayKodu, this.resetPassword_GsmNo).isResetPassword_IsActive();
                reqTime = r.getSmsOnayKoduDetay(this.resetPassword_SmsOnayKodu, this.resetPassword_GsmNo).getResetPassword_SmsOnayKodu_RequestTime().getTime();
                
                long farkMS = toTime - reqTime;   
                long farkSN = farkMS / 1000;        
                long farkDAK = farkSN / 60;     
                
                if(farkDAK <= 3600000){
                    if(resetPasswordIsActive){
                   
                        int sonuc = 0;
                        ResetPasswordDao rpd = new ResetPasswordDao();       
                        sonuc = rpd.updateAccountPassword(r.getSmsOnayKoduDetay(this.resetPassword_SmsOnayKodu, this.resetPassword_GsmNo).getResetPassword_GsmNo(), new PasswordHashing().shaPasswordHashing(this.resetPassword_Password) );

                        if (sonuc == 1){

                            int sonuc2 = 0;
HttpServletRequest httpServletRequestx = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                            String userInternetIpx = GetUserEnvironment.getInternetIp(httpServletRequestx);

                            ResetPasswordBean rp = new ResetPasswordBean();
                            rp.setResetPassword_Id(null);
                            rp.setResetPassword_GsmNo(this.resetPassword_GsmNo);
                            rp.setResetPassword_SmsOnayKodu_RequestTime(null);
                            rp.setResetPassword_SmsOnayKodu_RequestIp(null);
                            rp.setResetPassword_SmsOnayKodu_RequestSize(0);
                            rp.setResetPassword_SmsOnayKodu(this.resetPassword_SmsOnayKodu);
                            rp.setResetPassword_Password(null);
                            rp.setResetPassword_PasswordAgain(null);
                            rp.setResetPassword_ChangeTime(new Date());
                            rp.setResetPassword_ChangeIp(userInternetIpx);
                            rp.setResetPassword_IsActive(false);

                            ResetPasswordDao rpdx = new ResetPasswordDao();
                            sonuc2 = rpdx.updatePasswordChangeRecord(rp);

                            if(sonuc2 == 1){
                                System.out.println(":::HATA:::"+this.getClass().getName()+":::Sifre degistirildi:::");          
                                FacesContext facesContext = FacesContext.getCurrentInstance();
                                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Şifreniz değiştirildi");
                                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                                facesContext.addMessage(null, facesMessage);
                                facesContext.renderResponse();                       
                            }
                            else {
                                System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama, updatePasswordChangeRecord sırasında sorun olustu:::");          
                                FacesContext facesContext = FacesContext.getCurrentInstance();
                                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Şifre yenileme işleminiz sırasında sorun oluştu");
                                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                                facesContext.addMessage(null, facesMessage);
                                facesContext.renderResponse();
                            } 
                        }
                        else {
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama sırasında sorun olustu:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Şifre yenileme işleminiz sırasında sorun oluştu");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage(null, facesMessage);
                            facesContext.renderResponse();
                        }
                    
                    }
                    else{
                        System.err.println(":::HATA:::"+this.getClass().getName()+":::Bu SMS onay kodu kullanılarak şifre zaten değişmiş.:::");          
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Bu SMS kodu kullanılarak şifreniz zaten değimiş.");
                        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                        facesContext.addMessage(null, facesMessage);
                        facesContext.renderResponse();
                    }            
                }
                else{
                    System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama için girilen sms onay kodunun süresi gecmiş:::");          
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Girilen SMS onay kodunun geçerlilik süresi dolmuş");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();                    
                } 
            }
 else{
                System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama için girilen sms onay kodu sistemde yok:::");          
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Girilen SMS onay kodu geçersiz");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();   
            }
       }
       else{
                System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama için girilen sms onay kodu bos veya null:::");          
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Girilen SMS onay kodu geçersiz");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();   
            }

        
   } public void passwordMatch(ComponentSystemEvent event) {
        Match pm = new Match();
        pm.passwordMatch(event, "inputSecretPassword", "inputSecretPasswordAgain");
        
    }public void resetPasswordForAdmin(String gsm, String password){
        
        int sonuc = 0;
        ResetPasswordDao rpd = new ResetPasswordDao();       
        sonuc = rpd.updateAccountPassword(gsm, new PasswordHashing().shaPasswordHashing(password) );

        if (sonuc == 1){
            System.out.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlandı, aksivasyon kaldırıldı:::");          
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Aktivasyon kaldırıldı ve şifre sıfırlandı");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else {
            System.err.println(":::HATA:::"+this.getClass().getName()+":::Sifre sıfırlama sırasında sorun olustu:::");          
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Şifre yenileme işleminiz sırasında sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        
   }
    
    
    
}
