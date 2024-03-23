package com.tasimacilar.ilan.profile.account.corporate;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.admin.AllAccountsDao;
import org.apache.commons.io.FilenameUtils;
import com.tasimacilar.ilan.common.*;
import com.tasimacilar.ilan.profile.account.*;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.email.*;
import com.tasimacilar.ilan.system.fileUpload.FileUpload;
import com.tasimacilar.ilan.system.fileUpload.Functions;
import com.tasimacilar.ilan.system.sms.SmsBean;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
@ManagedBean(name = "corporateAccountBean")
@ViewScoped
public class CorporateAccountBean implements Serializable{
    private String  company_Id;                         
    private String  company_Type;                       
    private String  company_ActivityArea;               
    private String  company_Name;                      
    private String  company_FullName;                  
    private String  company_UrlName;                   
    private String  company_TaxOffice;                 
    private String  company_TaxNumber;                  
    private String  company_Email;                    
    private String  company_Web;                       
    private String  company_LogoUrl;                  
    private Date    company_create_time;               
    private Date    company_last_change_time;           
    private String  company_last_Changer_account_id;  
    private boolean company_IsActive;                   
    private String  address_id;                        
    private String  address_;                           
    private String  SocialMedia_Id;                    
    private String  phone_id;
    private boolean company_IsPublish;                
    private boolean addCompany;                    
    private AccountBean dbAccount;
    private boolean gsmChanged = false; 
    private boolean emailChanged = false; 
    private String urlPath = "";
    private Part   company_LogoFile;                  
    private String CompId;                             
    private String CompName;                        
    private String aId;
    private List<CompanyReferencesBean> CompanyReferencesList = new ArrayList<CompanyReferencesBean>();
    private List<CorporateAccountBean>   companyList;
    private List<CorporateAccountBean>   filteredCompanyList; 
    private List<CorporateAccountBean>   waitCompanyList;
    private List<CorporateAccountBean>   waitFilteredCompanyList;
    private List<CorporateAccountBean>   waitChangedCompanyList;
    private List<CorporateAccountBean>   waitChangedFilteredCompanyList; 
    private String  company_tmp_Id;                       
    private int     company_tmp_Version;                    
    private Date    company_tmp_last_change_time;           
    private String  company_tmp_last_Changer_account_id;  
    private String  company_Id_2;                         
    private String  company_Type_2;                      
    private String  company_ActivityArea_2;               
    private String  company_Name_2;                       
    private String  company_FullName_2;                   
    private String  company_TaxOffice_2;                  
    private String  company_TaxNumber_2;                  
    private String  company_Email_2;                     
    private String  company_Web_2;                        
    private String  company_LogoUrl_2;                    
    private Date    company_create_time_2;                
    private Date    company_last_change_time_2;           
    private String  company_last_Changer_account_id_2;    
    private boolean company_IsActive_2;                   
    private String  address_id_2;                         
    private String  address_2;                           
    private String  SocialMedia_Id_2;    
    private String  phone_id_2;
    private String  selectedCompanyTmpId;  
    private String  company_last_Changer_account_strng;
    private String  company_tmp_last_Changer_account_strng;
    private boolean companyChanged;
    private boolean companyChangedOK;
    private String      account_EmailActivationId;     
    private CorporateAccountBean selectedCompany;
    private List<Ad_Bean>   adList;
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}
    @ManagedProperty(value="#{addressBean}")
    private AddressBean addressBean;
    public AddressBean getAddressBean() {return addressBean;}
    public void setAddressBean(AddressBean addressBean) {this.addressBean = addressBean;}
    @ManagedProperty(value="#{addressBean2}")
    private AddressBean addressBean2; public AddressBean getAddressBean2() {return addressBean2; }
    public void setAddressBean2(AddressBean addressBean2) { this.addressBean2 = addressBean2;  }
    @ManagedProperty(value="#{companyReferencesBean}")
    private CompanyReferencesBean companyReferencesBean;
    public CompanyReferencesBean getCompanyReferencesBean() { return companyReferencesBean;}
    public void setCompanyReferencesBean(CompanyReferencesBean companyReferencesBean) { this.companyReferencesBean = companyReferencesBean;}
    @ManagedProperty(value="#{companyReferencesBean2}")
    private CompanyReferencesBean companyReferencesBean2;
    public CompanyReferencesBean getCompanyReferencesBean2() {return companyReferencesBean2;}
    public void setCompanyReferencesBean2(CompanyReferencesBean companyReferencesBean2) {this.companyReferencesBean2 = companyReferencesBean2;}
    @ManagedProperty(value="#{phonesBean}")
    private PhonesBean phonesBean;
    public PhonesBean getPhonesBean() { return phonesBean; }
    public void setPhonesBean(PhonesBean phonesBean) {this.phonesBean = phonesBean; }
    @ManagedProperty(value="#{phonesBean2}")
    private PhonesBean phonesBean2;
    public PhonesBean getPhonesBean2() {return phonesBean2;}
    public void setPhonesBean2(PhonesBean phonesBean2) {this.phonesBean2 = phonesBean2;}
    @ManagedProperty(value="#{socialMediaBean}")
    private SocialMediaBean socialMediaBean;
    public SocialMediaBean getSocialMediaBean() {return socialMediaBean;}
    public void setSocialMediaBean(SocialMediaBean socialMediaBean) {this.socialMediaBean = socialMediaBean;}  
    @ManagedProperty(value="#{socialMediaBean2}")
    private SocialMediaBean socialMediaBean2;
    public SocialMediaBean getSocialMediaBean2() {return socialMediaBean2;}
    public void setSocialMediaBean2(SocialMediaBean socialMediaBean2) {this.socialMediaBean2 = socialMediaBean2;}
    @PostConstruct
    public void init() {
        adList = new ArrayList<Ad_Bean>();
        selectedCompany = new CorporateAccountBean();
        HttpServletRequest reqxx = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
  selectedCompanyTmpId = reqxx.getParameter("TmpCompId");
        CompId = reqxx.getParameter("CompId");        
        CompName = reqxx.getParameter("CompName");  
        aId = reqxx.getParameter("aId");        
         try {  HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url); urlPath = FilenameUtils.getBaseName(urlx.getPath());
             if(urlPath.equals("profile_settings_s1")){    accountDetailWithId(SessionUtil.getUserId());  }
            if(urlPath.equals("profile_settings_s2")){    accountDetailWithId(SessionUtil.getUserId()); getCompanyFullDetailWithCompId(this.accountBean.getCompany_Id());  }
            if(urlPath.equals("profile_settings_s3")){    accountDetailWithId(SessionUtil.getUserId()); getCompanyFullDetailWithCompId(this.accountBean.getCompany_Id());  }
            if(urlPath.equals("profile_settings_s4")){    accountDetailWithId(SessionUtil.getUserId()); getCompanyFullDetailWithCompId(this.accountBean.getCompany_Id()); }
            if (urlPath.equals("firma_yonetimi")) {  getallCompany();  }
            if (urlPath.equals("onay_bekleyen_yeni_firmalar")) {  onayBekleyenler(); }
            if (urlPath.equals("onay_bekleyen_revizeli_firmalar")) {  onayBekleyenler2(); }
            if (urlPath.equals("kullanici_detay_companyInfoEdit")) { accountDetailWithId(aId); getCompanyFullDetailWithCompId(this.accountBean.getCompany_Id());  }
             if(CompId != null && !CompId.equals("")){ getCompanyFullDetailWithCompId(CompId);
                 if(selectedCompanyTmpId != null && !selectedCompanyTmpId.equals("")){
                    getCompanyFullDetailWithCompId2(selectedCompanyTmpId); }    
                  Ad_Dao ad = new Ad_Dao(); this.adList = ad.getCompanyTopFiftyAdWithId(CompId);  }
            else if(CompName != null && !CompName.equals("")){ CorporateAccountDao coad = new CorporateAccountDao();
               getCompanyFullDetailWithCompId(coad.getCompanyWithUrlName(CompName).getCompany_Id());
                getCompanyFullDetailWithCompId2(coad.getCompanyWithUrlName(CompName).getCompany_Id());
                Ad_Dao ad = new Ad_Dao();
                this.adList = ad.getCompanyTopFiftyAdWithName(CompName); }
            else { CompId = UniqueId.RandomString(12); }
          } catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi"); }      }
    public CorporateAccountBean() { }
    public String getCompany_Id() {return company_Id;}
    public void setCompany_Id(String company_Id) {this.company_Id = company_Id;}  
    public String getCompany_Type() {return company_Type;}
    public void setCompany_Type(String company_Type) {this.company_Type = company_Type;}
    public String getCompany_ActivityArea() {return company_ActivityArea;}
    public void setCompany_ActivityArea(String company_ActivityArea) {this.company_ActivityArea = company_ActivityArea;}
    public String getCompany_Name() {return company_Name;}
    public void setCompany_Name(String company_Name) {this.company_Name = company_Name;}
    public String getCompany_FullName() { return company_FullName;}
    public void setCompany_FullName(String company_FullName) { this.company_FullName = company_FullName;}
    public String getCompany_UrlName() {return company_UrlName;}
    public void setCompany_UrlName(String company_UrlName) {this.company_UrlName = company_UrlName;} 
    public String getCompany_TaxOffice() {return company_TaxOffice;}
    public void setCompany_TaxOffice(String company_TaxOffice) {this.company_TaxOffice = company_TaxOffice;}
    public String getCompany_TaxNumber() {return company_TaxNumber;}
    public void setCompany_TaxNumber(String company_TaxNumber) {this.company_TaxNumber = company_TaxNumber;}
    public String getCompany_Email() {return company_Email;}
    public void setCompany_Email(String company_Email) {this.company_Email = company_Email;}
    public String getCompany_Web() {return company_Web;}
    public void setCompany_Web(String company_Web) {this.company_Web = company_Web;}
    public String getCompany_LogoUrl() {return company_LogoUrl;}
    public void setCompany_LogoUrl(String company_LogoUrl) {this.company_LogoUrl = company_LogoUrl;}
    public Date getCompany_create_time() {return company_create_time;}
    public void setCompany_create_time(Date company_create_time) {this.company_create_time = company_create_time;}
    public Date getCompany_last_change_time() {return company_last_change_time;}
    public void setCompany_last_change_time(Date company_last_change_time) {this.company_last_change_time = company_last_change_time;}
    public String getCompany_last_Changer_account_id() {return company_last_Changer_account_id;}
    public void setCompany_last_Changer_account_id(String company_last_Changer_account_id) {this.company_last_Changer_account_id = company_last_Changer_account_id;}
    public boolean isAddCompany() {return addCompany;}
    public void setAddCompany(boolean addCompany) {this.addCompany = addCompany;}
    public boolean isGsmChanged() {return gsmChanged;}
    public void setGsmChanged(boolean gsmChanged) {this.gsmChanged = gsmChanged;}
    public boolean isEmailChanged() {return emailChanged;}
    public void setEmailChanged(boolean emailChanged) {this.emailChanged = emailChanged;}
    public Part getCompany_LogoFile() {return company_LogoFile;}
    public void setCompany_LogoFile(Part company_LogoFile) {  this.company_LogoFile = company_LogoFile;}
    public boolean isCompany_IsActive() { return company_IsActive;}
    public void setCompany_IsActive(boolean company_IsActive) { this.company_IsActive = company_IsActive;}
    public String getAddress_id() { return address_id;}
    public void setAddress_id(String address_id) {this.address_id = address_id;}
    public String getAddress_() { return address_;}
    public void setAddress_(String address_) {this.address_ = address_;}
    public String getSocialMedia_Id() { return SocialMedia_Id;}
    public void setSocialMedia_Id(String SocialMedia_Id) { this.SocialMedia_Id = SocialMedia_Id;}
    public String getPhone_id() {return phone_id;}
    public void setPhone_id(String phone_id) {this.phone_id = phone_id;}
    public boolean isCompany_IsPublish() { return company_IsPublish;}
    public void setCompany_IsPublish(boolean company_IsPublish) { this.company_IsPublish = company_IsPublish;} 
    public List<CompanyReferencesBean> getCompanyReferencesList() {  return CompanyReferencesList;}
    public void setCompanyReferencesList(List<CompanyReferencesBean> CompanyReferencesList) { this.CompanyReferencesList = CompanyReferencesList;}
    public String getUrlPath() { return urlPath;  }
    public void setUrlPath(String urlPath) {   this.urlPath = urlPath;}
    public List<CorporateAccountBean> getCompanyList() { return companyList;}
    public void setCompanyList(List<CorporateAccountBean> companyList) { this.companyList = companyList;}
    public List<CorporateAccountBean> getFilteredCompanyList() { return filteredCompanyList;}
    public void setFilteredCompanyList(List<CorporateAccountBean> filteredCompanyList) {  this.filteredCompanyList = filteredCompanyList;}
    public List<CorporateAccountBean> getWaitCompanyList() { return waitCompanyList;}
    public void setWaitCompanyList(List<CorporateAccountBean> waitCompanyList) { this.waitCompanyList = waitCompanyList;}
    public List<CorporateAccountBean> getWaitFilteredCompanyList() { return waitFilteredCompanyList;}
    public void setWaitFilteredCompanyList(List<CorporateAccountBean> waitFilteredCompanyList) { this.waitFilteredCompanyList = waitFilteredCompanyList;}
    public List<CorporateAccountBean> getWaitChangedCompanyList() {return waitChangedCompanyList;}
    public void setWaitChangedCompanyList(List<CorporateAccountBean> waitChangedCompanyList) {this.waitChangedCompanyList = waitChangedCompanyList;}
    public List<CorporateAccountBean> getWaitChangedFilteredCompanyList() {return waitChangedFilteredCompanyList;}
    public void setWaitChangedFilteredCompanyList(List<CorporateAccountBean> waitChangedFilteredCompanyList) {this.waitChangedFilteredCompanyList = waitChangedFilteredCompanyList;} 
    public String getCompany_tmp_Id() {return company_tmp_Id;}
    public void setCompany_tmp_Id(String company_tmp_Id) { this.company_tmp_Id = company_tmp_Id;}
    public int getCompany_tmp_Version() {return company_tmp_Version;}
    public void setCompany_tmp_Version(int company_tmp_Version) { this.company_tmp_Version = company_tmp_Version;}
    public Date getCompany_tmp_last_change_time() { return company_tmp_last_change_time;}
    public void setCompany_tmp_last_change_time(Date company_tmp_last_change_time) {this.company_tmp_last_change_time = company_tmp_last_change_time;}
    public String getCompany_tmp_last_Changer_account_id() {return company_tmp_last_Changer_account_id;}
    public void setCompany_tmp_last_Changer_account_id(String company_tmp_last_Changer_account_id) {this.company_tmp_last_Changer_account_id = company_tmp_last_Changer_account_id;}
    public String getCompany_Id_2() {return company_Id_2;}
    public void setCompany_Id_2(String company_Id_2) {this.company_Id_2 = company_Id_2;}
    public String getCompany_Type_2() {return company_Type_2;}
    public void setCompany_Type_2(String company_Type_2) {this.company_Type_2 = company_Type_2;}
    public String getCompany_ActivityArea_2() {return company_ActivityArea_2;}
    public void setCompany_ActivityArea_2(String company_ActivityArea_2) {this.company_ActivityArea_2 = company_ActivityArea_2;}
    public String getCompany_Name_2() {return company_Name_2;}
    public void setCompany_Name_2(String company_Name_2) {this.company_Name_2 = company_Name_2;}
    public String getCompany_FullName_2() {return company_FullName_2;}
    public void setCompany_FullName_2(String company_FullName_2) { this.company_FullName_2 = company_FullName_2;}
    public String getCompany_TaxOffice_2() {return company_TaxOffice_2;}
    public void setCompany_TaxOffice_2(String company_TaxOffice_2) {this.company_TaxOffice_2 = company_TaxOffice_2;}
    public String getCompany_TaxNumber_2() {return company_TaxNumber_2;}
    public void setCompany_TaxNumber_2(String company_TaxNumber_2) {this.company_TaxNumber_2 = company_TaxNumber_2;}
    public String getCompany_Email_2() {return company_Email_2;}
    public void setCompany_Email_2(String company_Email_2) {this.company_Email_2 = company_Email_2;}
    public String getCompany_Web_2() {return company_Web_2;}
    public void setCompany_Web_2(String company_Web_2) {this.company_Web_2 = company_Web_2;}
    public String getCompany_LogoUrl_2() {return company_LogoUrl_2;}
    public void setCompany_LogoUrl_2(String company_LogoUrl_2) {this.company_LogoUrl_2 = company_LogoUrl_2;}
    public Date getCompany_create_time_2() {return company_create_time_2;}
    public void setCompany_create_time_2(Date company_create_time_2) {this.company_create_time_2 = company_create_time_2;}
    public Date getCompany_last_change_time_2() {return company_last_change_time_2;}
    public void setCompany_last_change_time_2(Date company_last_change_time_2) {this.company_last_change_time_2 = company_last_change_time_2;}
    public String getCompany_last_Changer_account_id_2() {return company_last_Changer_account_id_2;}
    public void setCompany_last_Changer_account_id_2(String company_last_Changer_account_id_2) { this.company_last_Changer_account_id_2 = company_last_Changer_account_id_2;}
    public boolean isCompany_IsActive_2() { return company_IsActive_2;}
    public void setCompany_IsActive_2(boolean company_IsActive_2) { this.company_IsActive_2 = company_IsActive_2;}
    public String getAddress_id_2() {return address_id_2;}
    public void setAddress_id_2(String address_id_2) {this.address_id_2 = address_id_2;}
    public String getAddress_2() {return address_2;}
    public void setAddress_2(String address_2) {this.address_2 = address_2;}
    public String getSocialMedia_Id_2() {return SocialMedia_Id_2;}
    public void setSocialMedia_Id_2(String SocialMedia_Id_2) {this.SocialMedia_Id_2 = SocialMedia_Id_2;}
    public String getPhone_id_2() { return phone_id_2;}
    public void setPhone_id_2(String phone_id_2) {this.phone_id_2 = phone_id_2;}
    public String getCompany_last_Changer_account_strng() {return company_last_Changer_account_strng;}
    public void setCompany_last_Changer_account_strng(String company_last_Changer_account_strng) {this.company_last_Changer_account_strng = company_last_Changer_account_strng;}
    public String getCompany_tmp_last_Changer_account_strng() {return company_tmp_last_Changer_account_strng;}
    public void setCompany_tmp_last_Changer_account_strng(String company_tmp_last_Changer_account_strng) {this.company_tmp_last_Changer_account_strng = company_tmp_last_Changer_account_strng;}
    public boolean isCompanyChanged() {return companyChanged;}
    public void setCompanyChanged(boolean companyChanged) { this.companyChanged = companyChanged;}
    public boolean isCompanyChangedOK() { return companyChangedOK;}
    public void setCompanyChangedOK(boolean companyChangedOK) { this.companyChangedOK = companyChangedOK;}
    public String getAccount_EmailActivationId() {return account_EmailActivationId;}
    public void setAccount_EmailActivationId(String account_EmailActivationId) {  this.account_EmailActivationId = account_EmailActivationId;}
    public CorporateAccountBean getSelectedCompany() { return selectedCompany;  }
    public void setSelectedCompany(CorporateAccountBean selectedCompany) { this.selectedCompany = selectedCompany; }  
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }
   public void passwordMatch(ComponentSystemEvent event) {
        Match pm = new Match();
        pm.passwordMatch(event, "corporateAccountPassword", "corporateAccountConfirmPassword");
    }public List<CityListsBean> allCityWithDetail () { CityListsDao cd = new CityListsDao();      
        return  cd.getAllCityWithDetail();
    }public List<CityListsBean> allTownDetailWithCity () { CityListsDao cd = new CityListsDao();         
        return  cd.getTownDetailWithCity(this.addressBean.getAddress_CityId());       
    } public void addCompanyStatusChange(boolean param){
        this.setAddCompany(param);  }public String createCorporateAccount() {
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest); String accountIdx = null;
        accountIdx = UniqueId.RandomString(12);
 String emailActivationIdx = null; emailActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
          String addressIdx = null; addressIdx = UniqueId.RandomString(12); String mobilePhoneNumberActivationIdx = null;
        mobilePhoneNumberActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
      boolean mobilePhoneNumberIsExist;
        mobilePhoneNumberIsExist = IsExist.isExistMobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
        String go = null; int sonuc = 0;
         if(urlPath.equals("kurumsal_kullanici")){  if (company_Id != null && this.addCompany==false) {
              PersonalAccountBean pab = new PersonalAccountBean();  AccountBean ab = new AccountBean();
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
                ab.setAccount_MembershipType("corporate");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("corporate");
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
                ab.setAccount_LastLoginTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastModifyIp(userInternetIp);
                ab.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastChangerAccountId(null);
                ab.setCompany_Id(company_Id);
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
              AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_create_time(new Timestamp(new Date().getTime()));
                adb.setAddress_CountryId(212); 
  if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId()); 
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId()); 
                }   else { adb.setAddress_CityId(0); 
                    adb.setAddress_TownId(0);    }
                pab.setAccountBean(ab);
                pab.setAddressBean(adb);       
                if (mobilePhoneNumberIsExist) { 
                    Messages.dynMsg("corporateAccountMobilePhoneNumberInput", "info", "Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");  
                } else { AccountDao ad = new AccountDao();
                    sonuc = ad.createAccount(pab);
if (sonuc == 1) {      AccountActivationDao pa = new AccountActivationDao();
                        int sonucx = pa.updateEmailActivation(emailActivationIdx);
                        if (sonucx == 1){   System.out.println(":::BİLGİ::: Kullanıcı Email aktivasyonu yapıldı");  }
                        else { Messages.dynMsg(null, "info", "Email aktivasyonu sırasında hata olustu");  }
  AccountActivationDao pax = new AccountActivationDao();
                        int sonucxx = pax.updatemobilePhoneNumberActivation(mobilePhoneNumberActivationIdx);
                        if (sonucx == 1){ System.out.println(":::BİLGİ::: Kullanıcı SMS aktivasyonu yapıldı");  }
                        else { Messages.dynMsg(null, "info", "SMS aktivasyonu sırasında hata olustu.");  }
  Messages.dynMsg(null, "info", "Yeni Kullanıcı oluşturma başarılı."); 
                        this.accountBean = new AccountBean();
                        go = null;
                    }
                }    
      
            }
            else{ int sonuc1 = 0;  int sonuc2 = 0;
 String companyIdx = null;  companyIdx = UniqueId.RandomString(12);
                String addressIdxx = null;
                addressIdxx = UniqueId.RandomString(12);
 String socialMediaIdx = null;
                socialMediaIdx = UniqueId.RandomString(12);
                String phoneIdx = null;
                phoneIdx = UniqueId.RandomString(12);
 AddressBean adbxx = new AddressBean();
                adbxx.setAddress_Id(addressIdxx);
                adbxx.setAddress_TypeId(2);
                adbxx.setAddress_Name("Corporate Profile Company Address");
                adbxx.setAddress(this.addressBean.getAddress());
                adbxx.setAddress_create_time(new Timestamp(new Date().getTime()));
                adbxx.setAddress_CountryId(212); 
 if (this.addressBean.getAddress_CityId() != 0) {
                    adbxx.setAddress_CityId(this.addressBean.getAddress_CityId());
                    adbxx.setAddress_TownId(this.addressBean.getAddress_TownId()); 
                }   else { adbxx.setAddress_CityId(0);
                    adbxx.setAddress_TownId(0);   }
  SocialMediaBean sbxx = new SocialMediaBean();
                sbxx.setSocialMedia_Id(socialMediaIdx);
                sbxx.setCreate_time(new Timestamp(new Date().getTime()));
                  PhonesBean ph = new PhonesBean();
                ph.setPhone_id(phoneIdx);
                ph.setPhone_type_id(1);
                ph.setPhone_Created(new Timestamp(new Date().getTime()));
  CorporateAccountBean cb = new CorporateAccountBean();
                cb.setCompany_Id(companyIdx);
                cb.setCompany_Type(this.company_Type);
                cb.setCompany_ActivityArea(this.company_ActivityArea);
                cb.setCompany_Name(this.company_Name);
                cb.setCompany_FullName(this.company_FullName);
                 String urlName = this.company_Name.toLowerCase();;
                cb.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
                cb.setCompany_TaxOffice(this.company_TaxOffice);
                cb.setCompany_TaxNumber(this.company_TaxNumber);
                cb.setCompany_IsActive(true);
                cb.setCompany_create_time(new Timestamp(new Date().getTime()));
                cb.setAddress_id(addressIdxx);
                cb.setSocialMedia_Id(socialMediaIdx);
                cb.setPhone_id(phoneIdx);
                cb.setAddressBean(adbxx);
                cb.setSocialMediaBean(sbxx);
                cb.setPhonesBean(ph);
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
                ab.setAccount_MembershipType("corporate");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("corporate");
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
                ab.setCompany_Id(companyIdx);
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
                  PersonalAccountBean pab = new PersonalAccountBean();
                AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_create_time(new Timestamp(new Date().getTime()));
                adb.setAddress_CountryId(212); 
if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId()); 
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId()); 
                } else {  adb.setAddress_CityId(0);
                    adb.setAddress_TownId(0);   }
                 pab.setAccountBean(ab);  pab.setAddressBean(adb);
                 if (mobilePhoneNumberIsExist) { Messages.dynMsg("corporateAccountMobilePhoneNumberInput", "error", "Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");  } 
                    else {  boolean taxIdIsExist;
                        taxIdIsExist = IsExist.isExistTaxIdActivationId(this.company_TaxNumber);
 if(taxIdIsExist){ Messages.dynMsg("corporateAccountTaxNumberInput", "error", "Girilen bu vergi Numarasi ile bir firma zaten kaydedilmiş.");   }
                        else{ sonuc1 = cd.createCompany(cb);
  AccountDao ad = new AccountDao();
                            sonuc2 = ad.createAccount(pab);
  if (sonuc1 == 1 && sonuc2 == 1) { AccountActivationDao pa = new AccountActivationDao();
                                int sonucx = pa.updateEmailActivation(emailActivationIdx);
                                if (sonucx == 1){ System.out.println(":::BİLGİ::: Kullanıcı Email aktivasyonu yapıldı"); }
                                else {Messages.dynMsg(null, "error", "E-Mail aktivasyonu sırasında hata olustu");   }
  AccountActivationDao pax = new AccountActivationDao();
                                int sonucxx = pax.updatemobilePhoneNumberActivation(mobilePhoneNumberActivationIdx);
                              if (sonucx == 1){  System.out.println(":::BİLGİ::: Kullanıcı SMS aktivasyonu yapıldı"); }
                                else { Messages.dynMsg(null, "error", "SMS aktivasyonu sırasında hata olustu"); }
  Messages.dynMsg(null, "info", "Bilgileriniz BAŞARILI bir şekilde girilmiştir.");
                                this.accountBean = new AccountBean();
                                this.setCompany_Id(null);
                                this.setCompany_Type(null);
                                this.setCompany_ActivityArea(null);
                                this.setCompany_Name(null);
                                this.setCompany_FullName(null);
                                this.setCompany_TaxOffice(null);
                                this.setCompany_TaxNumber(null);
                                go = null;
                            } 
                            else {  Messages.dynMsg(null, "error", "Kurumsal üyelik işlemleri sırasında bir sorun oluşmuştur, lütfen daha sonra yeniden deneyiniz."); }
                        }
                    } }  }
         else {   if (selectedCompany.getCompany_Id() != null && this.addCompany==false) {
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
                ab.setAccount_MembershipType("corporate");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("corporate");
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
                ab.setAccount_LastLoginTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastModifyIp(userInternetIp);
                ab.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                ab.setAccount_LastChangerAccountId(null);
                ab.setCompany_Id(selectedCompany.getCompany_Id());
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
                PersonalAccountBean pab = new PersonalAccountBean();
                AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_create_time(new Timestamp(new Date().getTime()));
                adb.setAddress_CountryId(212); //ülke kodu 212=TR 
 if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId()); //İl
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId()); //İlçe
                }  else {
                    adb.setAddress_CityId(0); //İl
                    adb.setAddress_TownId(0); //İlçe
                }  pab.setAccountBean(ab);
                pab.setAddressBean(adb);
                    if (mobilePhoneNumberIsExist) { Messages.dynMsg("corporateAccountMobilePhoneNumberInput", "error", "Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin."); } 
                    else {
                        AccountDao ad = new AccountDao();
                        sonuc = ad.createAccount(pab);
  if (sonuc == 1) { SmsBean.sendSms(this.accountBean.getAccount_MobilePhoneNumber(),mobilePhoneNumberActivationIdx);
                         this.accountBean = new AccountBean();
                            go = "account_activation?faces-redirect=true";
                        }  else { Messages.dynMsg(null, "error", "Kurumsal üyelik işlemleri sırasında bir sorun oluşmuştur, lütfen daha sonra yeniden deneyiniz."); }
                    } } 
            else {  int sonuc1 = 0;              int sonuc2 = 0;
 String companyIdx = null;
                companyIdx = UniqueId.RandomString(12);
 String addressIdxx = null;
                addressIdxx = UniqueId.RandomString(12);
 String socialMediaIdx = null;
                socialMediaIdx = UniqueId.RandomString(12);
 String phoneIdx = null;
                phoneIdx = UniqueId.RandomString(12);
                  AddressBean adbxx = new AddressBean();
                adbxx.setAddress_Id(addressIdxx);
                adbxx.setAddress_TypeId(2);
                adbxx.setAddress_Name("Corporate Profile Company Address");
                adbxx.setAddress(this.addressBean.getAddress());
                adbxx.setAddress_create_time(new Timestamp(new Date().getTime()));
                adbxx.setAddress_CountryId(212); 
   if (this.addressBean.getAddress_CityId() != 0) {
                    adbxx.setAddress_CityId(this.addressBean.getAddress_CityId());
                    adbxx.setAddress_TownId(this.addressBean.getAddress_TownId()); 
                }  else { adbxx.setAddress_CityId(0); 
                    adbxx.setAddress_TownId(0); 
                }SocialMediaBean sbxx = new SocialMediaBean();
                sbxx.setSocialMedia_Id(socialMediaIdx);
                sbxx.setCreate_time(new Timestamp(new Date().getTime()));
 PhonesBean ph = new PhonesBean();
                ph.setPhone_id(phoneIdx);
                ph.setPhone_type_id(1);
                ph.setPhone_Created(new Timestamp(new Date().getTime()));
                ph.setPhone_isActive(true);
                 CorporateAccountBean cb = new CorporateAccountBean();
                cb.setCompany_Id(companyIdx);
                cb.setCompany_Type(this.company_Type);
                cb.setCompany_ActivityArea(this.company_ActivityArea);
                cb.setCompany_Name(this.company_Name);
                cb.setCompany_FullName(this.company_FullName);
                 String urlName = this.company_Name.toLowerCase();;
                cb.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
                  cb.setCompany_TaxOffice(this.company_TaxOffice);
                cb.setCompany_TaxNumber(this.company_TaxNumber);
                cb.setCompany_IsActive(true);
                cb.setCompany_create_time(new Timestamp(new Date().getTime()));
                cb.setAddress_id(addressIdxx);
                cb.setSocialMedia_Id(socialMediaIdx);
                cb.setPhone_id(phoneIdx);
                cb.setAddressBean(adbxx);
                cb.setSocialMediaBean(sbxx);
                cb.setPhonesBean(ph);
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
                ab.setAccount_MembershipType("corporate");
                ab.setAccount_ActivityArea(this.accountBean.getAccount_ActivityArea());
                ab.setAccount_Type("corporate");
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
                ab.setCompany_Id(companyIdx);
                ab.setAddress_id(addressIdx);
                ab.setAccount_passwordNotChange(false);
                 PersonalAccountBean pab = new PersonalAccountBean();
                 AddressBean adb = new AddressBean();
                adb.setAddress_Id(addressIdx);
                adb.setAddress_TypeId(1);
                adb.setAddress_Name("Personal Profile Address");
                adb.setAddress(this.addressBean.getAddress());
                adb.setAddress_create_time(new Timestamp(new Date().getTime()));
                adb.setAddress_CountryId(212); 
 if (this.addressBean.getAddress_CityId() != 0) {
                    adb.setAddress_CityId(this.addressBean.getAddress_CityId());
                    adb.setAddress_TownId(this.addressBean.getAddress_TownId());
                }  else { adb.setAddress_CityId(0);
                    adb.setAddress_TownId(0); 
                } pab.setAccountBean(ab);
                pab.setAddressBean(adb);
 if (mobilePhoneNumberIsExist) { Messages.dynMsg("corporateAccountMobilePhoneNumberInput", "error", "Girilen GSM Numarasi kullanılmaktadır, farklı bir GSM Numarasi deneyin.");  } 
                    else {   boolean taxIdIsExist;
                        taxIdIsExist = IsExist.isExistTaxIdActivationId(this.company_TaxNumber);
  if(taxIdIsExist){ Messages.dynMsg("corporateAccountTaxNumberInput", "error", "Girilen bu vergi Numarasi ile bir firma zaten kaydedilmiş."); }   
                        else{
                            CorporateAccountDao cd = new CorporateAccountDao();
                            sonuc1 = cd.createCompany(cb);
   AccountDao ad = new AccountDao();
                            sonuc2 = ad.createAccount(pab);
 if (sonuc1 == 1 && sonuc2 == 1) {
                                 SmsBean.sendSms(this.accountBean.getAccount_MobilePhoneNumber(),mobilePhoneNumberActivationIdx);
String emailBody = EmailBodyes.userRegisterEmailBody(this.accountBean.getAccount_FirstName(), this.accountBean.getAccount_LastName(), emailActivationIdx);
                                EmailBean eb = new EmailBean();
                                eb.sendMailNow(this.accountBean.getAccount_EmailAddress(), "", "", emailBody, "Yeni kullanıcı e-mail etkinleştirme - tasimacilar.com", "");

                                Messages.dynMsg(null, "info", "Bilgileriniz BAŞARILI bir şekilde girilmiştir.");
                                this.accountBean = new AccountBean();
                                this.setCompany_Id(null);
                                this.setCompany_Type(null);
                                this.setCompany_ActivityArea(null);
                                this.setCompany_Name(null);
                                this.setCompany_FullName(null);
                                this.setCompany_TaxOffice(null);
                                this.setCompany_TaxNumber(null);
                                go = "account_activation?faces-redirect=true";
                        } 
                        else { Messages.dynMsg(null, "error", "Kurumsal üyelik işlemleri sırasında bir sorun oluşmuştur, lütfen daha sonra yeniden deneyiniz.");}
  }       } }  } return go;
    }
        public List<CorporateAccountBean> allCorporateAccountWithDetail() {
CorporateAccountDao cd = new CorporateAccountDao();
 return cd.getAllCorporateAccountWithDetail();  }
    public List<CorporateAccountBean> allCorporateAccountWithDetailForAutoComplete(String query) {
  List<CorporateAccountBean> eslesenFirmalar = new ArrayList<CorporateAccountBean>();
         List<CorporateAccountBean> tmpFirmalar = new ArrayList<CorporateAccountBean>();
        CorporateAccountDao cad = new CorporateAccountDao();
        tmpFirmalar= cad.getAllCorporateAccountWithDetail();
       for (CorporateAccountBean c : tmpFirmalar) { 
            if(c.company_Name != null && !c.company_Name.equals("")){
                if (c.company_Name.toUpperCase().startsWith(query.toUpperCase())) {
                    eslesenFirmalar.add(c);
                }
            }   
        }
 return eslesenFirmalar;
    }
    public void accountDetailWithId(String accoundId){
    AccountBean abx = new  AccountBean();
        abx.setAccount_Id(accoundId);
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(abx);
        AccountDao ad = new AccountDao();       
        this.dbAccount = ad.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
        this.accountBean = ad.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
        this.addressBean = ad.getAccountDetailWithParam(pab, "getAllWithId").getAddressBean();
        CorporateAccountDao cd = new CorporateAccountDao();
        selectedCompany =cd.getOneCorporateAccountWithId(this.accountBean.getCompany_Id()) ;
   }public void updateAccount(){ 
  PersonalAccountBean acb = new PersonalAccountBean();
        int sonuc = 0;
        boolean onError = false;
       if(this.accountBean.getAccount_EmailAddress() != null && !this.accountBean.getAccount_EmailAddress().equals("")){
         if(!this.dbAccount.getAccount_EmailAddress().equals(this.accountBean.getAccount_EmailAddress())){
           boolean emailIsExist;
                emailIsExist = IsExist.isExistEmail(this.accountBean.getAccount_EmailAddress());
 if (emailIsExist) {
                    System.err.println(":::HATA:::" + this.getClass().getName() + ":::Girilen E-Mail adresi kullanılmaktadır:::");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("Girdiğiniz E-Mail adresi kullanılmaktadır, farklı bir E-Mail deneyin.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage("corporateAccountEmailAddressInput", facesMessage);
                    facesContext.renderResponse();
                    
                    this.accountBean.setAccount_EmailAddress(this.dbAccount.getAccount_EmailAddress());
                    onError = true;
                }
               else{  emailChanged = true;    }
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
                    facesContext.addMessage("corporateAccountMobilePhoneNumberInput", facesMessage);
                    facesContext.renderResponse();
                    
                    this.accountBean.setAccount_MobilePhoneNumber(this.dbAccount.getAccount_MobilePhoneNumber());
                    onError = true;
                }
                 else{  gsmChanged = true;   }
            }
        }if ( this.accountBean.getAccount_newPassword() != null && !this.accountBean.getAccount_newPassword().equals("")) {
          if(!onError){ this.accountBean.setAccount_Password_1(new PasswordHashing().shaPasswordHashing(this.accountBean.getAccount_newPassword()));
                 HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                    String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
 this.accountBean.setAccount_LastModifyIp(userInternetIp);
                    this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                    this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                    this.accountBean.setCompany_Id(selectedCompany.getCompany_Id());
                    acb.setAccountBean(this.accountBean);
                    acb.setAddressBean(this.addressBean);
if(this.dbAccount.getCompany_Id().equals(this.selectedCompany.getCompany_Id())){
                        if (emailChanged) { emailChange();   }
                        if (gsmChanged) {  gsmChange(this.accountBean.getAccount_MobilePhoneNumber());  }
                        AccountDao ad = new AccountDao();
                        sonuc = ad.updateAccount(acb);
                        if(sonuc==1){ getCompanyFullDetailWithCompId(this.selectedCompany.getCompany_Id()); 
                            Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız.");  }
                        else{ Messages.dynMsg(null, "error", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştu."); }
                    } else {  companyChanged = true; if (companyChangedOK) {                       
                           Ad_Dao adx = new Ad_Dao();
                            adx.disableAdForOvnerChange(acb.getAccountBean().getAccount_Id(),this.dbAccount.getCompany_Id() );
                         if (emailChanged) {  emailChange();   }
                            if (gsmChanged) {
                                gsmChange(this.accountBean.getAccount_MobilePhoneNumber());  }
  AccountDao ad = new AccountDao(); sonuc= ad.updateAccount(acb);
                        if(sonuc==1){ getCompanyFullDetailWithCompId(this.selectedCompany.getCompany_Id()); 
                                Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız."); 
  try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                                      ec.redirect(ec.getRequestContextPath() +  "/login"); }
                                catch (IOException ex) {System.out.println(":::HATA:::"+ex); }
                            } else{ Messages.dynMsg(null, "error", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştu."); } 
  } } }  }else {           
            if(!onError){ HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
  this.accountBean.setAccount_LastModifyIp(userInternetIp);
                this.accountBean.setAccount_LastModifyTime(new Timestamp(new Date().getTime()));
                this.accountBean.setAccount_LastChangerAccountId(SessionUtil.getUserId());
                this.accountBean.setCompany_Id(selectedCompany.getCompany_Id());
                acb.setAccountBean(this.accountBean);
                acb.setAddressBean(this.addressBean); if(this.dbAccount.getCompany_Id().equals(this.selectedCompany.getCompany_Id())){
                    if (emailChanged) {emailChange();     }
                    if (gsmChanged) {    gsmChange(this.accountBean.getAccount_MobilePhoneNumber());    }
                    AccountDao ad = new AccountDao();
                    sonuc = ad.updateAccount(acb);
                     if(sonuc==1){  getCompanyFullDetailWithCompId(this.selectedCompany.getCompany_Id()); 
                            Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız.");    }
                        else{ Messages.dynMsg(null, "error", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştu."); }
                } else { 
                    companyChanged = true;
                    if (companyChangedOK) {   Ad_Dao adx = new Ad_Dao();
                        adx.disableAdForOvnerChange(acb.getAccountBean().getAccount_Id(), this.dbAccount.getCompany_Id());
  if (emailChanged) {  emailChange(); }
                        if (gsmChanged) {  gsmChange(this.accountBean.getAccount_MobilePhoneNumber());   }
                        AccountDao ad = new AccountDao(); sonuc= ad.updateAccount(acb);
                        if(sonuc==1){getCompanyFullDetailWithCompId(this.selectedCompany.getCompany_Id()); 
                            Messages.dynMsg(null, "info", "Hesabınız güncellenmiştir, lütfen yeniden giriş yapınız."); 
                        } else{Messages.dynMsg(null, "error", "Kullanıcı hesabınızı güncelleme sırasında bir hata oluşmuştu."); }

                    }
                }              
                
            }           
        }
    }
    public void updateAccount2(){ 
        this.companyChangedOK = true;
        updateAccount();
    
    } public void gsmChange(String gsmNo){String mobilePhoneNumberActivationIdx = null;
        mobilePhoneNumberActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
          AccountDao ad = new AccountDao();
        ad.updateAccountGsmActivationId(SessionUtil.getUserId(), mobilePhoneNumberActivationIdx);
 SmsBean.sendSms(gsmNo, mobilePhoneNumberActivationIdx);
        LoginBean.logout();
    }public void emailChange(){  String emailActivationIdx = null;
        emailActivationIdx = String.valueOf(UniqueId.RandomInt(1001, 9999)) ;
          AccountDao ad = new AccountDao();
        ad.updateAccountEmailActivationId(SessionUtil.getUserId(), emailActivationIdx);
 Messages.dynMsg("dfdsf", "info", " E-Mail doğrulama kodunuz girdiğiniz E-Mail adresine gönderilmiştir.");
        System.out.println(":::E-Mail Aktivasyon Id for "+this.accountBean.getAccount_EmailAddress()+" = "+emailActivationIdx);
        String emailBody = EmailBodyes.userRegisterEmailBody(this.accountBean.getAccount_FirstName(), this.accountBean.getAccount_LastName(), emailActivationIdx);
        EmailBean eb = new EmailBean();
        eb.sendMailNow(this.accountBean.getAccount_EmailAddress(), "", "", emailBody, "Kullanıcı e-mail etkinleştirme - tasimacilar.com", "");   
    } public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
       Functions.validateFile(ctx, comp, value);
    } public void fileUpload() {try {      this.setCompany_LogoUrl("/resources/media/" + FileUpload.uploadFile(this.company_LogoFile)); } 
        catch (IOException ex) { System.out.println(":::HATA:::" + ex);  }
    } public void fileUpload2() { try {            
        this.setCompany_LogoUrl_2("/resources/media/" + FileUpload.uploadFile(this.company_LogoFile)); } 
        catch (IOException ex) { System.out.println(":::HATA:::" + ex);  } }
    public String addCorporateCompany(){
          int sonuc = 0;
        String yonlen = "";
         String addressIdx = null;
        addressIdx = UniqueId.RandomString(12);
         String socialMediaIdx = null;
        socialMediaIdx = UniqueId.RandomString(12);
        String phoneIdx = null;
        phoneIdx = UniqueId.RandomString(12);
         AddressBean adb = new AddressBean();
        adb.setAddress_Id(addressIdx);
        adb.setAddress_TypeId(2);
        adb.setAddress_Name("Corporate Profile Address");
        adb.setAddress(this.addressBean.getAddress());
 if (this.addressBean.getAddress_CityId() != 0) {
            adb.setAddress_CityId(this.addressBean.getAddress_CityId()); 
            adb.setAddress_TownId(this.addressBean.getAddress_TownId());
        } 
        else { adb.setAddress_CityId(0);
            adb.setAddress_TownId(0);  }  
        SocialMediaBean sb = new SocialMediaBean();
        sb.setSocialMedia_Id(socialMediaIdx);
        sb.setFacebook_profileUrl(this.socialMediaBean.getFacebook_profileUrl());
        sb.setTwitter_profileUrl(this.socialMediaBean.getTwitter_profileUrl());
        sb.setLinkedin_profileUrl(this.socialMediaBean.getLinkedin_profileUrl());
        sb.setInstagram_profileUrl(this.socialMediaBean.getInstagram_profileUrl());
         PhonesBean phb = new PhonesBean();
        phb.setPhone_id(phoneIdx);
        phb.setPhone_type_id(1);
        phb.setPhone_1(this.phonesBean.getPhone_1());
        phb.setPhone_2(this.phonesBean.getPhone_2());
        phb.setPhone_gsm1(this.phonesBean.getPhone_gsm1());
        phb.setPhone_gsm2(this.phonesBean.getPhone_gsm2());
        phb.setPhone_fax1(this.phonesBean.getPhone_fax1());
        phb.setPhone_Modified(new Date());
        phb.setPhone_Modifier(SessionUtil.getUserId());
        phb.setPhone_Created(new Date());
        phb.setPhone_creator(SessionUtil.getUserId());
        CorporateAccountBean c = new CorporateAccountBean();
        c.setCompany_Id(this.CompId);
        c.setCompany_Type(this.company_Type);
        c.setCompany_ActivityArea(this.company_ActivityArea);
        c.setCompany_Name(this.company_Name);
        c.setCompany_FullName(this.company_FullName);
        String urlName = company_Name.toLowerCase();
        c.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
         c.setCompany_TaxOffice(this.company_TaxOffice);
        c.setCompany_TaxNumber(this.company_TaxNumber);
        c.setCompany_Email(this.company_Email);
        c.setCompany_Web(this.company_Web);
        c.setCompany_LogoUrl(this.company_LogoUrl);
        c.setCompany_create_time(new Date());
        c.setCompany_last_change_time(null);
        c.setCompany_last_Changer_account_id(SessionUtil.getUserId());
        c.setCompany_IsActive(true);
        c.setAddress_id(addressIdx);
        c.setSocialMedia_Id(socialMediaIdx);
        c.setPhone_id(phoneIdx);
        c.setAddressBean(adb);
        c.setSocialMediaBean(sb);
        c.setPhonesBean(phb);
       boolean taxIdIsExist;
        taxIdIsExist = IsExist.isExistTaxIdActivationId(this.company_TaxNumber);
if (taxIdIsExist) {
            System.err.println(":::HATA:::" + this.getClass().getName() + ":::Girilen Vergi Numarasi ile bir firma zaten kaydedilmiş.:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Girilen bu vergi Numarasi ile bir firma zaten kaydedilmiş.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage("corporateAccountTaxNumberInput", facesMessage);
            facesContext.renderResponse();

        }  else { CorporateAccountDao cd = new CorporateAccountDao();
            sonuc = cd.createCompany(c);
            if(sonuc == 1){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Yeni firma başarılı bir şekilde kaydedilmiştir");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
                
                try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                          ec.redirect(ec.getRequestContextPath() +  "/private/director/companies/onay_bekleyen_yeni_firmalar.xhtml");  } 
                catch (IOException ex) {System.out.println(":::HATA:::"+ex); }
            }
            else{
                System.err.println(":::HATA:::" + this.getClass().getName() + ":::Yeni firmayı kaydetme sırasında sorun oluştu.:::");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Yeni firmayı kaydetme sırasında sorun oluştu.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
        }
    
        return yonlen;
    }public void updateCorporateCompany(){
         int sonuc = 0; AddressBean adb = new AddressBean();
        adb.setAddress_Id(this.address_id);
        adb.setAddress(this.addressBean.getAddress());
 if (this.addressBean.getAddress_CityId() != 0) {
            adb.setAddress_CityId(this.addressBean.getAddress_CityId());
            adb.setAddress_TownId(this.addressBean.getAddress_TownId()); 
        }  else {  adb.setAddress_CityId(0); 
            adb.setAddress_TownId(0); 
        } SocialMediaBean sb = new SocialMediaBean();
        sb.setSocialMedia_Id(this.SocialMedia_Id);
        sb.setFacebook_profileUrl(this.socialMediaBean.getFacebook_profileUrl());
        sb.setTwitter_profileUrl(this.socialMediaBean.getTwitter_profileUrl());
        sb.setLinkedin_profileUrl(this.socialMediaBean.getLinkedin_profileUrl());
        sb.setInstagram_profileUrl(this.socialMediaBean.getInstagram_profileUrl());
         PhonesBean phb = new PhonesBean();
        phb.setPhone_id(this.phonesBean.getPhone_id());
        phb.setPhone_type_id(this.phonesBean.getPhone_type_id());
        phb.setPhone_1(this.phonesBean.getPhone_1());
        phb.setPhone_2(this.phonesBean.getPhone_2());
        phb.setPhone_gsm1(this.phonesBean.getPhone_gsm1());
        phb.setPhone_gsm2(this.phonesBean.getPhone_gsm2());
        phb.setPhone_fax1(this.phonesBean.getPhone_fax1());
        phb.setPhone_Modified(new Date());
        phb.setPhone_Modifier(SessionUtil.getUserId());
        CorporateAccountBean c = new CorporateAccountBean();
        c.setCompany_Id(this.CompId);
        c.setCompany_Type(this.company_Type);
        c.setCompany_ActivityArea(this.company_ActivityArea);
        c.setCompany_Name(this.company_Name);
        c.setCompany_FullName(this.company_FullName);
         String urlName = this.company_Name.toLowerCase();;
        c.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
        c.setCompany_TaxOffice(this.company_TaxOffice);
        c.setCompany_TaxNumber(this.company_TaxNumber);
        c.setCompany_Email(this.company_Email);
        c.setCompany_Web(this.company_Web);
        c.setCompany_LogoUrl(this.company_LogoUrl);
        c.setCompany_last_change_time(null);
        c.setCompany_last_Changer_account_id(SessionUtil.getUserId());
        c.setCompany_IsActive(true);
        c.setAddress_id(this.address_id);
        c.setSocialMedia_Id(this.SocialMedia_Id);
        c.setPhone_id(this.phone_id);
        c.setAddressBean(adb);
        c.setSocialMediaBean(sb);
        c.setPhonesBean(phb);
        CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.updateCompany(c);
if(sonuc == 1){FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Firma bilgileri başarılı bir şekilde güncellenmiştir");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();}
        else{   System.err.println(":::HATA:::" + this.getClass().getName() + ":::Firma güncelleme sırasında sorun oluştu.:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Firmayı güncelleme sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } } public void disableTmpCompany(String companyTmpId){
        
        int sonuc = 0; CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.disableTmpCompany(companyTmpId);
         if(sonuc == 1 ){  this.waitChangedCompanyList.clear();
            onayBekleyenler2(); FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Geçici firma kaydı silinmiştir.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
         }  else{ System.err.println(":::HATA:::" + this.getClass().getName() + ":::Geçici firma kaydını silme sırasında sorun oluştu:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Geçici firma kaydını silme sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } }public void updateCorporateCompany1(){
          int sonuc = 0;  int sonuc1 = 0;
          AddressBean adb = new AddressBean();
        adb.setAddress_Id(this.address_id);adb.setAddress(this.addressBean2.getAddress());
  if (this.addressBean2.getAddress_CityId() != 0) {
            adb.setAddress_CityId(this.addressBean2.getAddress_CityId());
            adb.setAddress_TownId(this.addressBean2.getAddress_TownId());
        }  else {adb.setAddress_CityId(0); 
            adb.setAddress_TownId(0);    }
        SocialMediaBean sb = new SocialMediaBean();
        sb.setSocialMedia_Id(this.SocialMedia_Id);
        sb.setFacebook_profileUrl(this.socialMediaBean2.getFacebook_profileUrl());
        sb.setTwitter_profileUrl(this.socialMediaBean2.getTwitter_profileUrl());
        sb.setLinkedin_profileUrl(this.socialMediaBean2.getLinkedin_profileUrl());
        sb.setInstagram_profileUrl(this.socialMediaBean2.getInstagram_profileUrl());
        PhonesBean phb = new PhonesBean();
        phb.setPhone_id(this.phonesBean.getPhone_id());
        phb.setPhone_type_id(this.phonesBean2.getPhone_type_id());
        phb.setPhone_1(this.phonesBean2.getPhone_1());
        phb.setPhone_2(this.phonesBean2.getPhone_2());
        phb.setPhone_gsm1(this.phonesBean2.getPhone_gsm1());
        phb.setPhone_gsm2(this.phonesBean2.getPhone_gsm2());
        phb.setPhone_fax1(this.phonesBean2.getPhone_fax1());
        phb.setPhone_Modified(new Date());
        phb.setPhone_Modifier(SessionUtil.getUserId());
        CorporateAccountBean c = new CorporateAccountBean();
        c.setCompany_Id(this.CompId);
        c.setCompany_Type(this.company_Type);
        c.setCompany_ActivityArea(this.company_ActivityArea);
        c.setCompany_Name(this.company_Name);
        c.setCompany_FullName(this.company_FullName);
        
        String urlName = this.company_Name.toLowerCase();;
        c.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
              
        c.setCompany_TaxOffice(this.company_TaxOffice);
        c.setCompany_Email(this.company_Email_2);
        c.setCompany_Web(this.company_Web_2);
        c.setCompany_LogoUrl(this.company_LogoUrl_2);
        c.setCompany_last_change_time(new Date());
        c.setCompany_last_Changer_account_id(SessionUtil.getUserId());
        c.setCompany_IsActive(true);
        c.setAddress_id(this.address_id);
        c.setSocialMedia_Id(this.SocialMedia_Id);
        c.setPhone_id(this.phone_id);
        c.setAddressBean(adb);
        c.setSocialMediaBean(sb);
        c.setPhonesBean(phb);
        CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.updateCompany(c);
        sonuc1 = cd.updateTmpCompany(this.CompId); 
        
        if(sonuc == 1 && sonuc1 >= 1){
            try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() +  "/private/director/companies/firma_detay-ve-onay-sonuc.xhtml?CompId="+this.CompId); }
            catch (IOException ex) {System.out.println(":::HATA:::"+ex); }
} else{ System.err.println(":::HATA:::" + this.getClass().getName() + ":::Firma güncelleme sırasında sorun oluştu.:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Firmayı güncelleme sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse(); } }
    public void updateCorporateCompany2(){
         int sonuc = 0;
        String SocialMediaId_ = UniqueId.RandomString(12);
        String addressId_ = UniqueId.RandomString(12);
        String phoneId_ = UniqueId.RandomString(12);
        AddressBean adb = new AddressBean();
        adb.setAddress_TypeId(1);
        adb.setAddress_Name("Personal Profile Address");
        adb.setAddress_Id(addressId_);
        adb.setAddress_CountryId(212); 
       adb.setAddress(this.addressBean.getAddress());
 if (this.addressBean.getAddress_CityId() != 0) {
            adb.setAddress_CityId(this.addressBean.getAddress_CityId());
            adb.setAddress_TownId(this.addressBean.getAddress_TownId()); 
        } 
        else {
            adb.setAddress_CityId(0);
            adb.setAddress_TownId(0); 
        } 
        SocialMediaBean sb = new SocialMediaBean();
        sb.setSocialMedia_Id(SocialMediaId_);
        sb.setFacebook_profileUrl(this.socialMediaBean.getFacebook_profileUrl());
        sb.setTwitter_profileUrl(this.socialMediaBean.getTwitter_profileUrl());
        sb.setLinkedin_profileUrl(this.socialMediaBean.getLinkedin_profileUrl());
        sb.setInstagram_profileUrl(this.socialMediaBean.getInstagram_profileUrl());
        PhonesBean phb = new PhonesBean();
        phb.setPhone_id(phoneId_);
        phb.setPhone_type_id(this.phonesBean.getPhone_type_id());
        phb.setPhone_1(this.phonesBean.getPhone_1());
        phb.setPhone_2(this.phonesBean.getPhone_2());
        phb.setPhone_gsm1(this.phonesBean.getPhone_gsm1());
        phb.setPhone_gsm2(this.phonesBean.getPhone_gsm2());
        phb.setPhone_fax1(this.phonesBean.getPhone_fax1());
        phb.setPhone_Modified(new Date());
        phb.setPhone_Modifier(SessionUtil.getUserId());
         CorporateAccountBean c = new CorporateAccountBean();
        c.setCompany_Id(this.accountBean.getCompany_Id());
        c.setCompany_Type(this.company_Type);
        c.setCompany_ActivityArea(this.company_ActivityArea);
        c.setCompany_Name(this.company_Name);
        c.setCompany_FullName(this.company_FullName);
        
        String urlName = this.company_Name.toLowerCase();;
        c.setCompany_UrlName(com.tasimacilar.ilan.system.ReplaiceTurkishLetters.replaice(urlName).replace(" ", "-") );
                
        c.setCompany_TaxNumber(this.company_TaxNumber);
        c.setCompany_TaxOffice(this.company_TaxOffice);
        c.setCompany_Email(this.company_Email);
        c.setCompany_Web(this.company_Web);
        c.setCompany_LogoUrl(this.company_LogoUrl);
        c.setCompany_last_change_time(null);
        c.setCompany_last_Changer_account_id(SessionUtil.getUserId());
        c.setCompany_IsActive(true);
        c.setAddress_id(addressId_);
        c.setSocialMedia_Id(SocialMediaId_);
        c.setPhone_id(phoneId_);
        c.setAddressBean(adb);
        c.setSocialMediaBean(sb);
        c.setPhonesBean(phb);
        c.setCompany_tmp_Id(UniqueId.RandomString(12));
        
        CorporateAccountDao cad = new CorporateAccountDao();
        c.setCompany_tmp_Version(cad.getTmpCompanyVerId(this.accountBean.getCompany_Id())+1);
        c.setCompany_tmp_last_Changer_account_id(SessionUtil.getUserId());
        c.setCompany_tmp_last_change_time(new Date());
        CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.createCompany_tmp(c);
 if(sonuc == 1){FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Firma bilgileri başarılı bir şekilde güncellenmiştir. Bilgiler incelendikten sonra yayınlanacaktır.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();}
        else{
            System.err.println(":::HATA:::" + this.getClass().getName() + ":::Firma güncelleme sırasında sorun oluştu.:::");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Firmayı güncelleme sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse(); }  } private void getCompanyFullDetailWithCompId(String CompId) {
        
        CorporateAccountBean cb = new CorporateAccountBean();
        CorporateAccountDao cd = new CorporateAccountDao();
        cb = cd.getOneCorporateAccountWithId(CompId);
        
        AccountDao acd = new AccountDao();
        String fn = acd.getAccountDetailWithAccountId(cb.getCompany_last_Changer_account_id()).getAccount_FirstName();
        String ln = acd.getAccountDetailWithAccountId(cb.getCompany_last_Changer_account_id()).getAccount_LastName();
        String ph = acd.getAccountDetailWithAccountId(cb.getCompany_last_Changer_account_id()).getAccount_MobilePhoneNumber();
        this.company_last_Changer_account_strng = fn+" "+ln+" [ "+ph+" ] ";
        
        this.company_Id  = cb.getCompany_Id();
        this.company_Type = cb.getCompany_Type();
        this.company_ActivityArea = cb.getCompany_ActivityArea();
        this.company_Name =  cb.getCompany_Name();
        this.company_FullName =  cb.getCompany_FullName();
        this.company_TaxOffice = cb.getCompany_TaxOffice();
        this.company_TaxNumber = cb.getCompany_TaxNumber();
        this.company_Email =  cb.getCompany_Email();
        this.company_Web =   cb.getCompany_Web();
        this.company_LogoUrl =  cb.getCompany_LogoUrl();
        this.company_create_time =  cb.getCompany_create_time();
        this.company_last_change_time =  cb.getCompany_last_change_time();
        this.company_last_Changer_account_id = cb.getCompany_last_Changer_account_id();
        this.company_IsActive  = cb.isCompany_IsActive();
        this.address_id =   cb.getAddress_id();
        this.SocialMedia_Id = cb.getSocialMedia_Id();
        this.addressBean = cb.getAddressBean();
        this.socialMediaBean = cb.getSocialMediaBean();
        this.phonesBean = cb.getPhonesBean();
        this.address_ = cb.getAddress_();
          getAllCompanyReferenceWithCompanyId(CompId);
    } private void getCompanyFullDetailWithCompId2(String TmpCompId) {
        
        CorporateAccountBean cb = new CorporateAccountBean();
        CorporateAccountDao cd = new CorporateAccountDao();
        cb = cd.getOneCorporateAccountWithId2(TmpCompId);
        
        AccountDao acd = new AccountDao();
        String fn = acd.getAccountDetailWithAccountId(cb.getCompany_tmp_last_Changer_account_id()).getAccount_FirstName();
        String ln = acd.getAccountDetailWithAccountId(cb.getCompany_tmp_last_Changer_account_id()).getAccount_LastName();
        String ph = acd.getAccountDetailWithAccountId(cb.getCompany_tmp_last_Changer_account_id()).getAccount_MobilePhoneNumber();
        this.company_tmp_last_Changer_account_strng = fn+" "+ln+" [ "+ph+" ] ";
           
        this.company_tmp_Id = cb.getCompany_tmp_Id();
        this.company_tmp_Version = cb.getCompany_tmp_Version();
        this.company_tmp_last_change_time = cb.getCompany_tmp_last_change_time();
        this.company_tmp_last_Changer_account_id = cb.getCompany_tmp_last_Changer_account_id();
        this.company_Id_2  = cb.getCompany_Id_2();
        this.company_Type_2 = cb.getCompany_Type_2();
        this.company_ActivityArea_2 = cb.getCompany_ActivityArea_2();
        this.company_Name_2 =  cb.getCompany_Name_2();
        this.company_FullName_2 =  cb.getCompany_FullName_2();
        this.company_TaxOffice_2 = cb.getCompany_TaxOffice_2();
        this.company_TaxNumber_2 = cb.getCompany_TaxNumber_2();
        this.company_Email_2 =  cb.getCompany_Email_2();
        this.company_Web_2 =   cb.getCompany_Web_2();
        this.company_LogoUrl_2 =  cb.getCompany_LogoUrl_2();
        this.company_create_time_2 =  cb.getCompany_create_time_2();
        this.company_last_change_time_2 =  cb.getCompany_last_change_time_2();
        this.company_last_Changer_account_id_2 = cb.getCompany_last_Changer_account_id_2();
        this.company_IsActive_2  = cb.isCompany_IsActive_2();
        this.address_id_2 =   cb.getAddress_id_2();
        this.SocialMedia_Id_2 = cb.getSocialMedia_Id_2();
        this.addressBean2 = cb.getAddressBean2();
        this.socialMediaBean2 = cb.getSocialMediaBean2();
        this.phonesBean2 = cb.getPhonesBean2();
        this.address_2 = cb.getAddress_2();  } public void createcompanyReference() { 
        int sonuc = 0;
        String ovnerAccountIdx = SessionUtil.getUserId();
        
        CompanyReferencesBean cb = new CompanyReferencesBean();
        cb.setCompanyReferences_Id(UniqueId.RandomString(12));
        cb.setCompanyReferences_Company(this.companyReferencesBean.getCompanyReferences_Company());
        cb.setCompanyReferences_Project(this.companyReferencesBean.getCompanyReferences_Project());
        cb.setCompanyReferences_ProjectStartDate(this.companyReferencesBean.getCompanyReferences_ProjectStartDate());
        cb.setCompanyReferences_ProjectEndDate(this.companyReferencesBean.getCompanyReferences_ProjectEndDate());
        cb.setCompanyReferences_ProjectWorkingYear(this.companyReferencesBean.getCompanyReferences_ProjectWorkingYear());
        cb.setCompanyReferences_Modified(Calendar.getInstance().getTime());
        cb.setCompanyReferences_Modifier(SessionUtil.getUserId());
        cb.setCompanyReferences_Created(Calendar.getInstance().getTime());
        cb.setCompanyReferences_creator(SessionUtil.getUserId());
        cb.setCompany_Id(this.CompId);
        
        CompanyReferencesDao vd = new CompanyReferencesDao();
        sonuc = vd.createCompanyReference(cb);
        
        if(sonuc == 1){
            System.out.println(":::: FİRMA REFERAS EKLEME BASARILI");
            this.CompanyReferencesList.clear();
            getAllCompanyReferenceWithCompanyId(this.CompId);  }
        else{
             System.out.println(":::: HOSTES REFERAS EKLEME BASARISIZ");
        } } public void getAllCompanyReferenceWithCompanyId(String CompId) {
    
        CompanyReferencesDao vd = new CompanyReferencesDao();
        this.CompanyReferencesList = vd.getAllCompanyReferenceWithCompanyId(CompId);
    } public void deleteHostessReference(String compReferencesId) {
        
        int sonuc = 0;
        CompanyReferencesDao vd = new CompanyReferencesDao();
        sonuc = vd.deleteCompanyReference(compReferencesId);
         if(sonuc==1){
            System.out.println("::: SİLME İŞLEMİ BAŞARILI");
            this.CompanyReferencesList.clear();
            getAllCompanyReferenceWithCompanyId(this.CompId);
        }  else{
            System.out.println("::: SİLME İŞLEMİ BAŞARISIZ");
        }
    } public void getallCompany() { CorporateAccountDao cd = new CorporateAccountDao();
         this.companyList = cd.getAllCorporateAccountWithDetail2(); }    public void onayBekleyenler() {
       CorporateAccountDao cd = new CorporateAccountDao();
    this.waitCompanyList = cd.onayBekleyenler(); }   
    public void onayBekleyenler2() { CorporateAccountDao cd = new CorporateAccountDao();
     this.waitChangedCompanyList = cd.onayBekleyenlerTMP(); }  public void enableDisableCompany(String param, String cId) {
       int sonuc = 0;
        CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.enableDisableCompany(param, cId);
        if (sonuc == 1){  getallCompany();
            System.out.println(":::BILGI:: Firma enable/disable basarılı");
        } }  public void publishCompany(String cId) {
      int sonuc = 0; CorporateAccountDao cd = new CorporateAccountDao();
        sonuc = cd.publishCompany(cId);
      if (sonuc == 1){
            getallCompany();
            onayBekleyenler();
            System.out.println(":::BILGI:: Firma yayınlama basarılı");
        } } public void disableAccout(){
        int sonuc = 0;
        AllAccountsDao ad  = new AllAccountsDao();
        sonuc = ad.disableAccountsFromUser(SessionUtil.getUserId(), SessionUtil.getUserEmail(), SessionUtil.getUserMobilePhoneNumber() );
 if(sonuc == 1){ FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kapatılmıştır.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
             LoginBean.logout();
        } else{ System.err.println(":::HATA:::Kullanıcı hesabı kapatılırken sorun oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kullanıcı hesabı kapatılırken sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } 
    } public void emailActivationIdCheck(){
        
        int sonuc = 0;
        boolean isExistEmailActivationId;
        isExistEmailActivationId = IsExist.isExistEmailActivationId(this.account_EmailActivationId);
                
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
