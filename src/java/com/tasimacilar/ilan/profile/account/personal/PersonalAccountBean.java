package com.tasimacilar.ilan.profile.account.personal;
import com.tasimacilar.ilan.admin.AllAccountsDao;
import com.tasimacilar.ilan.common.AccountActivationDao;
import com.tasimacilar.ilan.system.email.EmailBean;
import com.tasimacilar.ilan.system.email.EmailBodyes;
import com.tasimacilar.ilan.common.AddressBean;
import com.tasimacilar.ilan.common.AddressDao;
import com.tasimacilar.ilan.common.CityListsBean;
import com.tasimacilar.ilan.common.CityListsDao;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.LoginBean;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.sms.SmsBean;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
@ManagedBean(name = "personalAccountBean")
@ViewScoped
public class PersonalAccountBean implements Serializable{
      private AccountBean dbAccount;
    private boolean gsmChanged = false; 
    private boolean emailChanged = false;
     private String urlPath = "";
    private String aId;
    private String      account_EmailActivationId;                 
    private boolean     account_EmailActivationEmailSend;       
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}
    @ManagedProperty(value="#{addressBean}")
    private AddressBean addressBean;
    public AddressBean getAddressBean() {return addressBean;}
    public void setAddressBean(AddressBean addressBean) {this.addressBean = addressBean;}
    @PostConstruct
    public void init() { 
        try {
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String paId = req.getParameter("aId");  
            this.aId = paId;
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            urlPath = FilenameUtils.getBaseName(urlx.getPath());
            if(urlPath.equals("profile_settings")){ accountDetailWithId(SessionUtil.getUserId());  }
            if(urlPath.equals("kullanici_detay_userInfoEdit")){ accountDetailWithId(paId);  }
          }  catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi"); }     
    
    } public PersonalAccountBean() {  }
    public boolean isGsmChanged() {return gsmChanged;}
    public void setGsmChanged(boolean gsmChanged) {this.gsmChanged = gsmChanged;}
    public boolean isEmailChanged() {return emailChanged;}
    public void setEmailChanged(boolean emailChanged) {this.emailChanged = emailChanged;}
    public String getAccount_EmailActivationId() { return account_EmailActivationId;}
    public void setAccount_EmailActivationId(String account_EmailActivationId) { this.account_EmailActivationId = account_EmailActivationId;}
    public boolean isAccount_EmailActivationEmailSend() {return account_EmailActivationEmailSend;}
    public void setAccount_EmailActivationEmailSend(boolean account_EmailActivationEmailSend) { this.account_EmailActivationEmailSend = account_EmailActivationEmailSend;}
    @Override
    public String toString() {
        return "PersonalAccountBean{"   + "dbAccount=" + dbAccount 
                                        + ", gsmChanged=" + gsmChanged 
                                        + ", emailChanged=" + emailChanged 
                                        + ", urlPath=" + urlPath 
                                        + ", accountBean=" + accountBean 
                                        + ", addressBean=" + addressBean + '}';
    }   
    public void passwordMatch(ComponentSystemEvent event) {
        Match pm = new Match();
        pm.passwordMatch(event, "personalAccountPassword", "personalAccountConfirmPassword");
    } public String createPersonalAccount() {
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
        String accountIdx = null;
        accountIdx = UniqueId.RandomString(12);
        String emailActivationIdx = null;
        emailActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
 String mobilePhoneNumberActivationIdx = null;
        mobilePhoneNumberActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
          String addressIdx = null;
        addressIdx = UniqueId.RandomString(12);
        boolean mobilePhoneNumberIsExist;
        mobilePhoneNumberIsExist=IsExist.isExistMobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
        String go = null;
        int sonuc = 0;
        if (urlPath.equals("bireysel_kullanici")) { 
              PersonalAccountBean pab = new PersonalAccountBean();
                AccountBean ab = new AccountBean();
                ab.setAccount_Id(accountIdx);
                ab.setAccount_TC_Id(0L);
                ab.setAccount_EmailActivationId(emailActivationIdx);
                ab.setAccount_MobilePhoneNumberActivationId(mobilePhoneNumberActivationIdx);
                ab.setAccount_FirstName(this.accountBean.getAccount_FirstName());
                ab.setAccount_LastName(this.accountBean.getAccount_LastName());
                ab.setAccount_EmailAddress(this.accountBean.getAccount_EmailAddress());
                ab.setAccount_MobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
                ab.setAccount_Password_1(new PasswordHashing().shaPasswordHashing(this.accountBean.getAccount_Password_1()));
                ab.setAccount_Gender(null);
                ab.setAccount_BirthDate(null);
                ab.setAccount_RememberMe(false);
                ab.setAccount_MembershipType("personal");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("personal");
                ab.setAccount_SecretQuestion(null);
                ab.setAccount_SecretQuestionAnswer(null);
                ab.setAccount_MailSubscription(true);
                ab.setAccount_TermsAccepted(true);
                ab.setAccount_TermsAcceptedIp(userInternetIp);
                ab.setAccount_TermsAcceptedTime(new Timestamp(new Date().getTime()));
                ab.setAccount_IsActive(true);
                ab.setAccount_CreatedIp(userInternetIp);
                ab.setAccount_CreateTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastLoginIp(userInternetIp);
                ab.setAccount_LastLoginTime(null);
                ab.setAccount_LastModifyIp(userInternetIp);
                ab.setAccount_LastModifyTime(null);
                ab.setAccount_LastChangerAccountId(null);
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
                AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_CountryId(212);

                if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId());
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId());
                }   else { adb.setAddress_CityId(0); 
                    adb.setAddress_TownId(0); 
                }  pab.setAccountBean(ab);
                pab.setAddressBean(adb);
                  if(mobilePhoneNumberIsExist){
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Girilen GSM Numarasi kullanılmaktadır:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage("personalAccountMobilePhoneNumberInput", facesMessage);
                            facesContext.renderResponse();
                        }   else {
                                AccountDao ad = new AccountDao();
                                sonuc = ad.createAccount(pab);
                          if (sonuc == 1) {
                                   AccountActivationDao pa = new AccountActivationDao();
                                    int sonucx = pa.updateEmailActivation(emailActivationIdx);
                                    if (sonucx == 1){  }
                                    else {  System.out.println(":::HATA::: Kullanıcı Email aktivasyonu sırasında hata olustu"); }
                                       AccountActivationDao pax = new AccountActivationDao();
                                    int sonucxx = pax.updatemobilePhoneNumberActivation(mobilePhoneNumberActivationIdx);
                                    if (sonucx == 1){   }
                                    else {    System.out.println(":::HATA::: Kullanıcı SMS aktivasyonu sırasında hata olustu");  }
                                   FacesContext facesContext = FacesContext.getCurrentInstance();
                                    FacesMessage facesMessage = new FacesMessage("Yeni Kullanıcı oluşturma başarılı.");
                                    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                                    facesContext.addMessage(null, facesMessage);
                                    facesContext.renderResponse();
                                      this.accountBean.setAccount_Id(null);
                                    this.accountBean.setAccount_TC_Id(null);
                                    this.accountBean.setAccount_EmailActivationId(null);
                                    this.accountBean.setAccount_MobilePhoneNumberActivationId(null);
                                    this.accountBean.setAccount_FirstName(null);
                                    this.accountBean.setAccount_LastName(null);
                                    this.accountBean.setAccount_EmailAddress(null);
                                    this.accountBean.setAccount_MobilePhoneNumber(null);
                                    this.accountBean.setAccount_Password_1(null);
                                    this.accountBean.setAccount_Gender(null);
                                    this.accountBean.setAccount_BirthDate(null);
                                    this.accountBean.setAccount_RememberMe(false);
                                    this.accountBean.setAccount_MembershipType(null);
                                    this.accountBean.setAccount_ActivityArea(null);
                                    this.accountBean.setAccount_Type(null);
                                    this.accountBean.setAccount_SecretQuestion(null);
                                    this.accountBean.setAccount_SecretQuestionAnswer(null);
                                    this.accountBean.setAccount_MailSubscription(true);
                                    this.accountBean.setAccount_TermsAccepted(false);
                                    this.accountBean.setAccount_TermsAcceptedIp(null);
                                    this.accountBean.setAccount_TermsAcceptedTime(null);
                                    this.accountBean.setAccount_IsActive(false);
                                    this.accountBean.setAccount_CreatedIp(null);
                                    this.accountBean.setAccount_CreateTime(null);
                                    this.accountBean.setAccount_LastLoginIp(null);
                                    this.accountBean.setAccount_LastLoginTime(null);
                                    this.accountBean.setAccount_LastModifyIp(null);
                                    this.accountBean.setAccount_LastModifyTime(null);
                                    this.accountBean.setAccount_LastChangerAccountId(null);
  go = null;
                                }
                        
                        }  }  else {  PersonalAccountBean pab = new PersonalAccountBean();
                
                AccountBean ab = new AccountBean();
                ab.setAccount_Id(accountIdx);
                ab.setAccount_TC_Id(0L);
                ab.setAccount_EmailActivationId(emailActivationIdx);
                ab.setAccount_MobilePhoneNumberActivationId(mobilePhoneNumberActivationIdx);
                ab.setAccount_FirstName(this.accountBean.getAccount_FirstName());
                ab.setAccount_LastName(this.accountBean.getAccount_LastName());
                ab.setAccount_EmailAddress(this.accountBean.getAccount_EmailAddress());
                ab.setAccount_MobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
                ab.setAccount_Password_1(new PasswordHashing().shaPasswordHashing(this.accountBean.getAccount_Password_1()));
                ab.setAccount_Gender(null);
                ab.setAccount_BirthDate(null);
                ab.setAccount_RememberMe(false);
                ab.setAccount_MembershipType("personal");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("personal");
                ab.setAccount_SecretQuestion(null);
                ab.setAccount_SecretQuestionAnswer(null);
                ab.setAccount_MailSubscription(true);
                ab.setAccount_TermsAccepted(true);
                ab.setAccount_TermsAcceptedIp(userInternetIp);
                ab.setAccount_TermsAcceptedTime(new Timestamp(new Date().getTime()));
                ab.setAccount_IsActive(false);
                ab.setAccount_CreatedIp(userInternetIp);
                ab.setAccount_CreateTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastLoginIp(userInternetIp);
                ab.setAccount_LastLoginTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastModifyIp(userInternetIp);
                ab.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastChangerAccountId(null);
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
                 AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_CountryId(212); 
 if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId());
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId()); 
                } 
                else {
                    adb.setAddress_CityId(0);   adb.setAddress_TownId(0); 
                }
                
                pab.setAccountBean(ab);
                pab.setAddressBean(adb);

                        if(mobilePhoneNumberIsExist){
                            System.err.println(":::HATA:::"+this.getClass().getName()+":::Girilen GSM Numarasi kullanılmaktadır:::");          
                            FacesContext facesContext = FacesContext.getCurrentInstance();
                            FacesMessage facesMessage = new FacesMessage("Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");
                            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                            facesContext.addMessage("personalAccountMobilePhoneNumberInput", facesMessage);
                            facesContext.renderResponse();
                        }

                        else {
                            AccountDao ad = new AccountDao();
                            sonuc = ad.createAccount(pab);

                            if (sonuc == 1) {  SmsBean.sendSms(this.accountBean.getAccount_MobilePhoneNumber(),mobilePhoneNumberActivationIdx);

                                this.accountBean.setAccount_Id(null);
                                this.accountBean.setAccount_TC_Id(null);
                                this.accountBean.setAccount_EmailActivationId(null);
                                this.accountBean.setAccount_MobilePhoneNumberActivationId(null);
                                this.accountBean.setAccount_FirstName(null);
                                this.accountBean.setAccount_LastName(null);
                                this.accountBean.setAccount_EmailAddress(null);
                                this.accountBean.setAccount_MobilePhoneNumber(null);
                                this.accountBean.setAccount_Password_1(null);
                                this.accountBean.setAccount_Gender(null);
                                this.accountBean.setAccount_BirthDate(null);
                                this.accountBean.setAccount_RememberMe(false);
                                this.accountBean.setAccount_MembershipType(null);
                                this.accountBean.setAccount_ActivityArea(null);
                                this.accountBean.setAccount_Type(null);
                                this.accountBean.setAccount_SecretQuestion(null);
                                this.accountBean.setAccount_SecretQuestionAnswer(null);
                                this.accountBean.setAccount_MailSubscription(true);
                                this.accountBean.setAccount_TermsAccepted(false);
                                this.accountBean.setAccount_TermsAcceptedIp(null);
                                this.accountBean.setAccount_TermsAcceptedTime(null);
                                this.accountBean.setAccount_IsActive(false);
                                this.accountBean.setAccount_CreatedIp(null);
                                this.accountBean.setAccount_CreateTime(null);
                                this.accountBean.setAccount_LastLoginIp(null);
                                this.accountBean.setAccount_LastLoginTime(null);
                                this.accountBean.setAccount_LastModifyIp(null);
                                this.accountBean.setAccount_LastModifyTime(null);
                                this.accountBean.setAccount_LastChangerAccountId(null);

                                go = "account_activation?faces-redirect=true";
                            }

                        } }  return go;
    
    } 
    public List<CityListsBean> allCityWithDetail () {   CityListsDao cd = new CityListsDao();      
        return  cd.getAllCityWithDetail();
    }public List<CityListsBean> allTownDetailWithCity () {
        CityListsDao cd = new CityListsDao();       
        return  cd.getTownDetailWithCity(this.addressBean.getAddress_CityId());       
    } public void accountDetailWithId(String accoundId){  if (accoundId != null && !accoundId.equals("")) {
            AccountBean abx = new AccountBean();
            abx.setAccount_Id(accoundId);  PersonalAccountBean pab = new PersonalAccountBean();
            pab.setAccountBean(abx);

            AccountDao ad = new AccountDao();
            this.dbAccount = ad.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
            this.accountBean = ad.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
            this.addressBean = ad.getAccountDetailWithParam(pab, "getAllWithId").getAddressBean();
        }
        else {System.out.println(":::HATA:::accoundId null veya bos geldi");}      
    } public void updateAccount(){ 
        
        PersonalAccountBean acb = new PersonalAccountBean();
        int sonuc = 0;
        boolean onError = false;if(this.accountBean.getAccount_EmailAddress() != null && !this.accountBean.getAccount_EmailAddress().equals("")){
         if(!this.dbAccount.getAccount_EmailAddress().equals(this.accountBean.getAccount_EmailAddress())){
               boolean emailIsExist;
                emailIsExist = IsExist.isExistEmail(this.accountBean.getAccount_EmailAddress());
 if (emailIsExist) {
                    Messages.dynMsg("personalAccountEmailAddressInput", "error", "Girdiğiniz E-Mail adresi kullanılmaktadır, farklı bir E-Mail deneyin."); 
                    this.accountBean.setAccount_EmailAddress(this.dbAccount.getAccount_EmailAddress());
                    onError = true;
                }else{ emailChanged = true;   }
            }
        }if(this.accountBean.getAccount_MobilePhoneNumber() != null && !this.accountBean.getAccount_MobilePhoneNumber().equals("")){
         if(!this.dbAccount.getAccount_MobilePhoneNumber().equals(this.accountBean.getAccount_MobilePhoneNumber())){
               boolean mobilePhoneNumberIsExist;
                mobilePhoneNumberIsExist = IsExist.isExistMobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
 if (mobilePhoneNumberIsExist) {
                    Messages.dynMsg("personalAccountMobilePhoneNumberInput", "error", "Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin."); 
                    this.accountBean.setAccount_MobilePhoneNumber(this.dbAccount.getAccount_MobilePhoneNumber());
                    onError = true;
                }else{ gsmChanged = true;   }
            }
        }if ( this.accountBean.getAccount_newPassword() != null && !this.accountBean.getAccount_newPassword().equals("")) {
           if(!onError){this.accountBean.setAccount_Password_1(new PasswordHashing().shaPasswordHashing(this.accountBean.getAccount_newPassword()));
                   HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                    String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);

                    this.accountBean.setAccount_LastModifyIp(userInternetIp);
                    this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                    this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                    acb.setAccountBean(this.accountBean);
                    acb.setAddressBean(this.addressBean);

                    if(emailChanged){  emailChange();  }
                    if(gsmChanged){   gsmChange(this.accountBean.getAccount_MobilePhoneNumber());  }
                    
                    AccountDao ad = new AccountDao();
                    sonuc = ad.updateAccount(acb);
                   
                    if (sonuc == 1 ) { Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız.");  }
                    else{ Messages.dynMsg(null, "info", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştur.");  } 
                
                }        } else {           
            if(!onError){  HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);

                this.accountBean.setAccount_LastModifyIp(userInternetIp);
                this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                acb.setAccountBean(this.accountBean);
                acb.setAddressBean(this.addressBean);
                
                if (emailChanged) {   emailChange();    }
                if (gsmChanged) {  gsmChange(this.accountBean.getAccount_MobilePhoneNumber());  }

                AccountDao ad = new AccountDao();
                sonuc = ad.updateAccount(acb);       if (sonuc == 1) {  Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız.");   }
                else{ Messages.dynMsg(null, "error", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştu."); }
            }           
        }
    }public void updateAccountForAdmin(){ 
        PersonalAccountBean acb = new PersonalAccountBean();
        int sonuc = 0;
        boolean onError = false;
          if(this.accountBean.getAccount_EmailAddress() != null && !this.accountBean.getAccount_EmailAddress().equals("")){
        if(!this.dbAccount.getAccount_EmailAddress().equals(this.accountBean.getAccount_EmailAddress())){
                 boolean emailIsExist;
                emailIsExist = IsExist.isExistEmail(this.accountBean.getAccount_EmailAddress());
  if (emailIsExist) {  System.err.println(":::HATA:::" + this.getClass().getName() + ":::Girilen E-Mail adresi kullanılmaktadır:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("Girdiğiniz E-Mail adresi kullanılmaktadır, farklı bir E-Mail deneyin.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage("personalAccountEmailAddressInput", facesMessage);
                    facesContext.renderResponse();
                    
                    this.accountBean.setAccount_EmailAddress(this.dbAccount.getAccount_EmailAddress());
                    onError = true;
                } else{  emailChanged = true;  emailChangeForAdmin(this.aId);   
                    }
            }
        }if(this.accountBean.getAccount_MobilePhoneNumber() != null && !this.accountBean.getAccount_MobilePhoneNumber().equals("")){
         if(!this.dbAccount.getAccount_MobilePhoneNumber().equals(this.accountBean.getAccount_MobilePhoneNumber())){
                boolean mobilePhoneNumberIsExist;
                mobilePhoneNumberIsExist = IsExist.isExistMobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
 if (mobilePhoneNumberIsExist) {
                    System.err.println(":::HATA:::" + this.getClass().getName() + ":::Girilen GSM Numarasi kullanılmaktadır:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage("personalAccountMobilePhoneNumberInput", facesMessage);
                    facesContext.renderResponse();
                    
                    this.accountBean.setAccount_MobilePhoneNumber(this.dbAccount.getAccount_MobilePhoneNumber());
                    onError = true;
                } else{ gsmChanged = true;  gsmChangeForAdmin(this.accountBean.getAccount_MobilePhoneNumber(),this.aId);   
                }
            }
        }if ( this.accountBean.getAccount_newPassword() != null && !this.accountBean.getAccount_newPassword().equals("")) {
                            
                if(!onError){
                    
                    this.accountBean.setAccount_Password_1(new PasswordHashing().shaPasswordHashing(this.accountBean.getAccount_newPassword()));
                     HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                    String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);

                    this.accountBean.setAccount_LastModifyIp(userInternetIp);
                    this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                    this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                    acb.setAccountBean(this.accountBean);
                    acb.setAddressBean(this.addressBean);

                    AccountDao ad = new AccountDao();
                    sonuc = ad.updateAccount(acb);
                   
                    if (sonuc == 1 ) {
                        System.err.println(":::BILGI:::" + this.getClass().getName() + ":::Hesabınız güncellenmiştir..:::");
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        FacesMessage facesMessage = new FacesMessage("Hesabınız güncellenmiştir.");
                        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                        facesContext.addMessage(null, facesMessage);
                        facesContext.renderResponse();
                    }
                    else{
                        System.err.println(":::HATA:::" + this.getClass().getName() + ":::Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştur.:::");
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        FacesMessage facesMessage = new FacesMessage("Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştur.");
                        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                        facesContext.addMessage(null, facesMessage);
                        facesContext.renderResponse();
                    } 
                
                } }else {           
            if(!onError){HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);

                this.accountBean.setAccount_LastModifyIp(userInternetIp);
                this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                acb.setAccountBean(this.accountBean);
                acb.setAddressBean(this.addressBean);
               
                AccountDao ad = new AccountDao();
                sonuc = ad.updateAccount(acb);             

                if (sonuc == 1) {
                    
                    System.err.println(":::BILGI:::" + this.getClass().getName() + ":::Hesabınız güncellenmiştir..:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("Hesabınız güncellenmiştir.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();

                }
                else{
                    System.err.println(":::HATA:::" + this.getClass().getName() + ":::Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştur.:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştur.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                }
            }           
        }
    } public void gsmChange(String gsmNo){
         String mobilePhoneNumberActivationIdx = null;
        mobilePhoneNumberActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
        AccountDao ad = new AccountDao();
        ad.updateAccountGsmActivationId(SessionUtil.getUserId(), mobilePhoneNumberActivationIdx);
 SmsBean.sendSms(gsmNo, mobilePhoneNumberActivationIdx);
         LoginBean.logout();
    }public void gsmChangeForAdmin(String gsmNo, String userId){
         String mobilePhoneNumberActivationIdx = null;
        mobilePhoneNumberActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
         AccountDao ad = new AccountDao();
        ad.updateAccountGsmActivationId(userId, mobilePhoneNumberActivationIdx);
 SmsBean.sendSms(gsmNo, mobilePhoneNumberActivationIdx);
        
       
    }    public void emailChange(){
        String emailActivationIdx = null;
        emailActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
 AccountDao ad = new AccountDao();
        ad.updateAccountEmailActivationId(SessionUtil.getUserId(), emailActivationIdx);
 Messages.dynMsg("dfdsf", "info", " E-Mail doğrulama kodunuz girdiğiniz E-Mail adresine gönderilmiştir.");
        System.out.println(":::E-Mail Aktivasyon Id for "+this.accountBean.getAccount_EmailAddress()+" = "+emailActivationIdx);
        String emailBody = EmailBodyes.userRegisterEmailBody(this.accountBean.getAccount_FirstName(), this.accountBean.getAccount_LastName(), emailActivationIdx);
        EmailBean eb = new EmailBean();
        eb.sendMailNow(this.accountBean.getAccount_EmailAddress(), "", "", emailBody, "Kullanıcı e-mail aktivasyonu - tasimacilar.com", "");   
         
    } public void emailChangeForAdmin(String userId){
        String emailActivationIdx = null;
        emailActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
 AccountDao ad = new AccountDao();
        ad.updateAccountEmailActivationId(userId, emailActivationIdx);
 Messages.dynMsg("dfdsf", "info", " E-Mail doğrulama kodunuz girdiğiniz E-Mail adresine gönderilmiştir.");
        System.out.println(":::E-Mail Aktivasyon Id for "+this.accountBean.getAccount_EmailAddress()+" = "+emailActivationIdx);
        String emailBody = EmailBodyes.userRegisterEmailBody(this.accountBean.getAccount_FirstName(), this.accountBean.getAccount_LastName(), emailActivationIdx);
        EmailBean eb = new EmailBean();
        eb.sendMailNow(this.accountBean.getAccount_EmailAddress(), "", "", emailBody, "Kullanıcı e-mail etkinleştirme - tasimacilar.com", "");   
    }public void disableAccout(){
        
        int sonuc = 0;
           
        AllAccountsDao ad  = new AllAccountsDao();
         sonuc = ad.disableAccountsFromUser(SessionUtil.getUserId(), SessionUtil.getUserEmail(), SessionUtil.getUserMobilePhoneNumber() );

        if(sonuc == 1){ FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kapatılmıştır.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse(); LoginBean.logout();
        }
        else{
            System.err.println(":::HATA:::Kullanıcı hesabı kapatılırken sorun oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kullanıcı hesabı kapatılırken sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } 
    } public void emailActivationIdCheck(){
         int sonuc = 0;boolean isExistEmailActivationId;   isExistEmailActivationId = IsExist.isExistEmailActivationId(this.account_EmailActivationId);
        if(isExistEmailActivationId){            
            boolean isActivatedEmail;
            isActivatedEmail = AccountActivationDao.isActivatedEmail(this.account_EmailActivationId);
            
            if(isActivatedEmail){ Messages.dynMsg(null, "error", " Email doğrulama işlemi zaten yapılmış");}           
            else {
                AccountActivationDao pa = new AccountActivationDao();
                sonuc = pa.updateEmailActivation(this.account_EmailActivationId);

                if (sonuc == 1) {
                    accountDetailWithId(SessionUtil.getUserId()); 
                    Messages.dynMsg(null, "info", "Email doğrulama işlemi BAŞARILI");                  
                } 
                else { Messages.dynMsg(null, "error", "Email doğrulama işlemi sırasında sorun oluştu");}
            }               
        }      
        else{Messages.dynMsg(null, "error", " Yanlış Email doğrulama kodu");}
    } 
    
}
