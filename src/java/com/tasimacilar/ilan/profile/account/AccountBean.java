package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.system.Match;
import com.tasimacilar.ilan.system.SessionUtil;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
@ManagedBean(name = "accountBean")
@ViewScoped
public class AccountBean implements Serializable{  
    private String      account_Id;                             
    private Long        account_TC_Id;                         
    private String      account_EmailActivationId;             
    private String      account_MobilePhoneNumberActivationId;  
    private String      account_FirstName;                     
    private String      account_LastName;                      
    private String      account_EmailAddress;                 
    private boolean     account_EmailAddressActivated;          
    private String      account_MobilePhoneNumber;            
    private boolean     account_MobilePhoneNumberActivated;    
    private String      account_Password_1;                    
    private String      account_Password_2;                     
    private String      account_Gender;                       
    private Date        account_BirthDate;                     
    private boolean     account_RememberMe;                   
    private String      account_MembershipType;                 
    private String      account_ActivityArea;                  
    private String      account_Type;                          
    private String      account_SecretQuestion;               
    private String      account_SecretQuestionAnswer;          
    private boolean     account_MailSubscription;             
    private boolean     account_TermsAccepted ;                 
    private String      account_TermsAcceptedIp;             
    private Date        account_TermsAcceptedTime;         
    private boolean     account_IsActive;                    
    private String      account_CreatedIp;                    
    private Date        account_CreateTime;                 
    private String      account_LastLoginIp;                  
    private Date        account_LastLoginTime;              
    private String      account_LastModifyIp;                
    private Date        account_LastModifyTime;              
    private String      account_LastChangerAccountId;       
    private String      company_Id;                          
    private String      address_id;                            
    private String      address_;                       
    private String      account_oldPassword;  
    private String      account_newPassword; 
    private Boolean     account_passwordNotChange;          
    private Boolean     account_passwordChangeRequired;     
    private int uyeId_Old; 
    @PostConstruct
    public void init() {   account_TermsAccepted=true; }
    public AccountBean() {  }
   public AccountBean( String account_Id, Long account_TC_Id, 
                        String account_EmailActivationId, String account_MobilePhoneNumberActivationId, 
                        String account_FirstName, String account_LastName, 
                        String account_EmailAddress, String account_MobilePhoneNumber, 
                        String account_Password_1, String account_Password_2, 
                        String account_Gender, Date account_BirthDate, 
                        boolean account_RememberMe, String account_MembershipType, String account_ActivityArea,  
                        String account_Type, String account_SecretQuestion, String account_SecretQuestionAnswer, 
                        boolean account_MailSubscription, boolean account_TermsAccepted, 
                        String account_TermsAcceptedIp, Date account_TermsAcceptedTime, 
                        boolean account_IsActive, String account_CreatedIp, 
                        Date account_CreateTime, String account_LastLoginIp, 
                        Date account_LastLoginTime, String account_LastModifyIp, 
                        Date account_LastModifyTime, String account_LastChangerAccountId) {
        this.account_Id = account_Id;
        this.account_TC_Id = account_TC_Id;
        this.account_EmailActivationId = account_EmailActivationId;
        this.account_MobilePhoneNumberActivationId = account_MobilePhoneNumberActivationId;
        this.account_FirstName = account_FirstName;
        this.account_LastName = account_LastName;
        this.account_EmailAddress = account_EmailAddress;
        this.account_MobilePhoneNumber = account_MobilePhoneNumber;
        this.account_Password_1 = account_Password_1;
        this.account_Password_2 = account_Password_2;
        this.account_Gender = account_Gender;
        this.account_BirthDate = account_BirthDate;
        this.account_RememberMe = account_RememberMe;
        this.account_MembershipType = account_MembershipType;
        this.account_ActivityArea = account_ActivityArea;
        this.account_Type = account_Type;
        this.account_SecretQuestion = account_SecretQuestion;
        this.account_SecretQuestionAnswer = account_SecretQuestionAnswer;
        this.account_MailSubscription = account_MailSubscription;
        this.account_TermsAccepted = account_TermsAccepted;
        this.account_TermsAcceptedIp = account_TermsAcceptedIp;
        this.account_TermsAcceptedTime = account_TermsAcceptedTime;
        this.account_IsActive = account_IsActive;
        this.account_CreatedIp = account_CreatedIp;
        this.account_CreateTime = account_CreateTime;
        this.account_LastLoginIp = account_LastLoginIp;
        this.account_LastLoginTime = account_LastLoginTime;
        this.account_LastModifyIp = account_LastModifyIp;
        this.account_LastModifyTime = account_LastModifyTime;
        this.account_LastChangerAccountId = account_LastChangerAccountId;
    }
    public String getAccount_Id() {return account_Id;}
    public void setAccount_Id(String account_Id) {this.account_Id = account_Id;}
    public Long getAccount_TC_Id() {return account_TC_Id;}
    public void setAccount_TC_Id(Long account_TC_Id) {this.account_TC_Id = account_TC_Id;}
    public String getAccount_EmailActivationId() {return account_EmailActivationId;}
    public void setAccount_EmailActivationId(String account_EmailActivationId) {this.account_EmailActivationId = account_EmailActivationId;}
    public String getAccount_MobilePhoneNumberActivationId() {return account_MobilePhoneNumberActivationId;}
    public void setAccount_MobilePhoneNumberActivationId(String account_MobilePhoneNumberActivationId) {this.account_MobilePhoneNumberActivationId = account_MobilePhoneNumberActivationId;}
    public String getAccount_FirstName() {return account_FirstName;}
    public void setAccount_FirstName(String account_FirstName) {this.account_FirstName = account_FirstName;}
    public String getAccount_LastName() {return account_LastName;}
    public void setAccount_LastName(String account_LastName) {this.account_LastName = account_LastName;}
    public String getAccount_EmailAddress() {return account_EmailAddress;}
    public void setAccount_EmailAddress(String account_EmailAddress) {this.account_EmailAddress = account_EmailAddress;}
    public boolean isAccount_EmailAddressActivated() {return account_EmailAddressActivated;}
    public void setAccount_EmailAddressActivated(boolean account_EmailAddressActivated) {this.account_EmailAddressActivated = account_EmailAddressActivated;}
    public String getAccount_MobilePhoneNumber() {return account_MobilePhoneNumber;}
    public void setAccount_MobilePhoneNumber(String account_MobilePhoneNumber) {this.account_MobilePhoneNumber = account_MobilePhoneNumber;}
    public boolean isAccount_MobilePhoneNumberActivated() {return account_MobilePhoneNumberActivated;}
    public void setAccount_MobilePhoneNumberActivated(boolean account_MobilePhoneNumberActivated) {this.account_MobilePhoneNumberActivated = account_MobilePhoneNumberActivated;}
    public String getAccount_Password_1() {return account_Password_1;}
    public void setAccount_Password_1(String account_Password_1) {this.account_Password_1 = account_Password_1;}
    public String getAccount_Password_2() {return account_Password_2;}
    public void setAccount_Password_2(String account_Password_2) {this.account_Password_2 = account_Password_2;}
    public String getAccount_Gender() {return account_Gender;}
    public void setAccount_Gender(String account_Gender) {this.account_Gender = account_Gender;}
    public Date getAccount_BirthDate() { return account_BirthDate;}
    public void setAccount_BirthDate(Date account_BirthDate) {this.account_BirthDate = account_BirthDate;}
    public boolean isAccount_RememberMe() {return account_RememberMe;}
    public void setAccount_RememberMe(boolean account_RememberMe) {this.account_RememberMe = account_RememberMe;}
    public String getAccount_MembershipType() {return account_MembershipType;}
    public void setAccount_MembershipType(String account_MembershipType) {this.account_MembershipType = account_MembershipType;}
    public String getAccount_ActivityArea() {return account_ActivityArea;}
    public void setAccount_ActivityArea(String account_ActivityArea) {this.account_ActivityArea = account_ActivityArea;}      
    public String getAccount_Type() {return account_Type;}
    public void setAccount_Type(String account_Type) {this.account_Type = account_Type;}
    public String getAccount_SecretQuestion() {return account_SecretQuestion;}
    public void setAccount_SecretQuestion(String account_SecretQuestion) {this.account_SecretQuestion = account_SecretQuestion;}
    public String getAccount_SecretQuestionAnswer() {return account_SecretQuestionAnswer;}
    public void setAccount_SecretQuestionAnswer(String account_SecretQuestionAnswer) {this.account_SecretQuestionAnswer = account_SecretQuestionAnswer;}
    public boolean isAccount_MailSubscription() {return account_MailSubscription;}
    public void setAccount_MailSubscription(boolean account_MailSubscription) {this.account_MailSubscription = account_MailSubscription;}
    public boolean isAccount_TermsAccepted() {return account_TermsAccepted;}
    public void setAccount_TermsAccepted(boolean account_TermsAccepted) {this.account_TermsAccepted = account_TermsAccepted;}
    public String getAccount_TermsAcceptedIp() {return account_TermsAcceptedIp;}
    public void setAccount_TermsAcceptedIp(String account_TermsAcceptedIp) {this.account_TermsAcceptedIp = account_TermsAcceptedIp;}
    public Date getAccount_TermsAcceptedTime() {return account_TermsAcceptedTime;}
    public void setAccount_TermsAcceptedTime(Date account_TermsAcceptedTime) {this.account_TermsAcceptedTime = account_TermsAcceptedTime;}
    public boolean isAccount_IsActive() {return account_IsActive;}
    public void setAccount_IsActive(boolean account_IsActive) {this.account_IsActive = account_IsActive;}
    public String getAccount_CreatedIp() {return account_CreatedIp;}
    public void setAccount_CreatedIp(String account_CreatedIp) {this.account_CreatedIp = account_CreatedIp;}
    public Date getAccount_CreateTime() {return account_CreateTime;}
    public void setAccount_CreateTime(Date account_CreateTime) {this.account_CreateTime = account_CreateTime;}
    public String getAccount_LastLoginIp() {return account_LastLoginIp;}
    public void setAccount_LastLoginIp(String account_LastLoginIp) {this.account_LastLoginIp = account_LastLoginIp;}
    public Date getAccount_LastLoginTime() {return account_LastLoginTime;}
    public void setAccount_LastLoginTime(Date account_LastLoginTime) {this.account_LastLoginTime = account_LastLoginTime;}
    public String getAccount_LastModifyIp() {return account_LastModifyIp;}
    public void setAccount_LastModifyIp(String account_LastModifyIp) {this.account_LastModifyIp = account_LastModifyIp;}
    public Date getAccount_LastModifyTime() {return account_LastModifyTime;}
    public void setAccount_LastModifyTime(Date account_LastModifyTime) {this.account_LastModifyTime = account_LastModifyTime;}
    public String getAccount_LastChangerAccountId() {return account_LastChangerAccountId;}
    public void setAccount_LastChangerAccountId(String account_LastChangerAccountId) {this.account_LastChangerAccountId = account_LastChangerAccountId;}
    public String getCompany_Id() {return company_Id;}
    public void setCompany_Id(String company_Id) { this.company_Id = company_Id;}
    public String getAddress_id() {return address_id;}
    public void setAddress_id(String address_id) {this.address_id = address_id;}
    public String getAddress_() {return address_;}
    public void setAddress_(String address_) {this.address_ = address_;}
    public String getAccount_oldPassword() {return account_oldPassword; }
    public void setAccount_oldPassword(String account_oldPassword) {this.account_oldPassword = account_oldPassword;}
    public String getAccount_newPassword() { return account_newPassword;}
    public void setAccount_newPassword(String account_newPassword) {this.account_newPassword = account_newPassword;}
    public Boolean getAccount_passwordNotChange() {return account_passwordNotChange;}
    public void setAccount_passwordNotChange(Boolean account_passwordNotChange) {this.account_passwordNotChange = account_passwordNotChange;}
    public Boolean getAccount_passwordChangeRequired() { return account_passwordChangeRequired;}
    public void setAccount_passwordChangeRequired(Boolean account_passwordChangeRequired) {this.account_passwordChangeRequired = account_passwordChangeRequired;}
    public int getUyeId_Old() {return uyeId_Old;}
    public void setUyeId_Old(int uyeId_Old) {this.uyeId_Old = uyeId_Old;}
    public void accountMembershipTypeListener(){
        if(this.account_MembershipType.equals("personal")){
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("personalPanel");  }
         if(this.account_MembershipType.equals("corporate")){
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("corporatePanel");   } }
     public boolean isExistUserSupportNotification(){ AccountDao a = new AccountDao();
        return a.getUserSupportNotification(SessionUtil.getUserId()); }
    public boolean isExistUserMessageNotification(){
      AccountDao a = new AccountDao();
        return a.getUserMessageNotification(SessionUtil.getUserId()); }
    public static void updateUserSupportNotification(boolean value, String userId){
     int sonuc = 0;
        AccountDao a = new AccountDao();
        sonuc = a.updateUserSupportNotification(value, userId);
        if(sonuc == 1){ System.out.println(":::Notifikasyon basarılı duzenlendi:::");} }
    public static void updateUserMessageNotification(boolean value, String userId){
        int sonuc = 0;
        AccountDao a = new AccountDao();
        sonuc = a.updateUserMessageNotification(value, userId);
        if(sonuc == 1){  }
     }  
     
    
}
