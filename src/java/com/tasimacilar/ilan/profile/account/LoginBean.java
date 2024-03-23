package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.common.AccountActivationDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.*;
import static com.tasimacilar.ilan.system.SessionUtil.getSession;
import com.tasimacilar.ilan.system.loging.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    private String  account_EmailAddress;
    private String  account_MobilePhoneNumber;
    private String  account_Password;
    private boolean account_RememberMe;
    private boolean passwordChangeRequired;
    public LoginBean() {   }
    public LoginBean(String account_EmailAddress, String account_MobilePhoneNumber, String account_Password) {
        this.account_EmailAddress = account_EmailAddress;
        this.account_MobilePhoneNumber = account_MobilePhoneNumber;
        this.account_Password = account_Password;
    }
    public String getAccount_EmailAddress() {return account_EmailAddress;}
    public void setAccount_EmailAddress(String account_EmailAddress) {this.account_EmailAddress = account_EmailAddress;}
    public String getAccount_MobilePhoneNumber() {return account_MobilePhoneNumber;}
    public void setAccount_MobilePhoneNumber(String account_MobilePhoneNumber) {this.account_MobilePhoneNumber = account_MobilePhoneNumber;} 
    public String getAccount_Password() {return account_Password;}
    public void setAccount_Password(String account_Password) {this.account_Password = account_Password;}
    public boolean isAccount_RememberMe() {return account_RememberMe;}
    public void setAccount_RememberMe(boolean account_RememberMe) {this.account_RememberMe = account_RememberMe;}
    public boolean isPasswordChangeRequired() { return passwordChangeRequired;}
    public void setPasswordChangeRequired(boolean passwordChangeRequired) { this.passwordChangeRequired = passwordChangeRequired;}
    public String login() { 
        String returnPage=null;
        passwordChangeRequired = false;
        
        LoginDao ld = new LoginDao();
        boolean userIsActive = ld.accountIsActive(this.account_MobilePhoneNumber);
         if(IsExist.isExistMobilePhoneNumber(this.account_MobilePhoneNumber)){
             AccountBean accountDetail = null;
            accountDetail = getAccountDetail(this.account_MobilePhoneNumber);
             if(AccountActivationDao.isActivatedMobilePhoneNumberWithGsmNo(account_MobilePhoneNumber)){
 if(userIsActive){ passwordChangeRequired = accountDetail.getAccount_passwordChangeRequired();
if(!passwordChangeRequired){ AccountDao ad = new AccountDao();
Subject currentUser = SecurityUtils.getSubject();
                                UsernamePasswordToken token = new UsernamePasswordToken(account_MobilePhoneNumber, new Sha256Hash(account_Password).toHex());
                                token.setRememberMe(this.account_RememberMe);
 try {currentUser.login(token);insertUserLastLoginInfo(accountDetail.getAccount_Id(), accountDetail.getAccount_EmailAddress());
Session session = currentUser.getSession();
                                    session.setAttribute("accountId", accountDetail.getAccount_Id());
                                    session.setAttribute("accountFirstName", accountDetail.getAccount_FirstName());
                                    session.setAttribute("accountLastName", accountDetail.getAccount_LastName());
                                    session.setAttribute("accountEmailAddress", accountDetail.getAccount_EmailAddress());
                                    session.setAttribute("accountMobilePhoneNumber", accountDetail.getAccount_MobilePhoneNumber());
                                    session.setAttribute("accountMembershipType", accountDetail.getAccount_MembershipType());
                                    session.setAttribute("AccountType", accountDetail.getAccount_Type());
                                    session.setAttribute("userLastLoginTime", ad.getUserLastLoginTime(accountDetail.getAccount_Id()));
                                    session.setAttribute("accountCompanyId", accountDetail.getCompany_Id());
                                    session.setAttribute("accountActivityArea", accountDetail.getAccount_ActivityArea());
 LogManagerDao.createLog("info", this.getClass().getName(), "Login işlemi BAŞARILI [Kullanıcı Id: "+accountDetail.getAccount_Id()+", Kullanıcı:"+accountDetail.getAccount_FirstName()+" "+accountDetail.getAccount_LastName()+"] ","system" );
                                    System.err.println(":::INFO::: Time=["+new Date()
                                            +"] Class=["+this.getClass().getName()
                                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                            +"] Message=[Login işlemi BAŞARILI. Kullanıcı Id: "+accountDetail.getAccount_Id()+", Kullanıcı:"+accountDetail.getAccount_FirstName()+" "+accountDetail.getAccount_LastName()+"]:::"); 
if (currentUser.hasRole("corporate")) {returnPage = "/index.xhtml?faces-redirect=true";}
                                    else if(currentUser.hasRole("personal")) {returnPage = "/index.xhtml?faces-redirect=true";}
                                    else if(currentUser.hasRole("director")) {returnPage = "/index.xhtml?faces-redirect=true";}
                 else{ returnPage = "/index.xhtml?faces-redirect=true";}

                                }

                                catch (UnknownAccountException uae) {   
                                    Messages.dynMsg(null, "error", "Login işlemi BAŞARISIZ. Girilen kullanıcı adı hatalı. ");
                                    LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. Girilen kullanıcı adı hatalı. "+uae, "system");
                                    System.err.println(":::ERROR::: Time=["+new Date()
                                            +"] Class=["+this.getClass().getName()
                                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                            +"] Message=[Login işlemi BAŞARISIZ. Girilen kullanıcı adı hatalı. "+uae+".]:::"); 
                                    return null;
                                }

                                catch (IncorrectCredentialsException ice) { 
                                    Messages.dynMsg(null, "error", "Login işlemi BAŞARISIZ. Girilen parola hatalı. ");
                                    LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. Girilen parola hatalı. "+ice, "system");
                                    System.err.println(":::ERROR::: Time=["+new Date()
                                            +"] Class=["+this.getClass().getName()
                                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                            +"] Message=[Login işlemi BAŞARISIZ. Girilen parola hatalı. "+ice+".]:::"); 
                                    return null;
                                }

                                catch (LockedAccountException lae) {    
                                    Messages.dynMsg(null, "error", "Login işlemi BAŞARISIZ. Bu hesap kilitli."+lae);
                                    LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. Bu hesap kilitli. "+lae, "system");
                                    System.err.println(":::ERROR::: Time=["+new Date()
                                            +"] Class=["+this.getClass().getName()
                                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                            +"] Message=[Login işlemi BAŞARISIZ. Bu hesap kilitli. "+lae+".]:::"); 
                                    return null;
                                }

                                catch (AuthenticationException aex) {   
                                    Messages.dynMsg(null, "error", "Login işlemi BAŞARISIZ. Bu hesap kilitli."+aex);
                                    LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. "+aex, "system");
                                    System.err.println(":::ERROR::: Time=["+new Date()
                                            +"] Class=["+this.getClass().getName()
                                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                            +"] Message=[Login işlemi BAŞARISIZ. "+aex+".]:::"); 
                                    return null;
                                }



                        }

                        else{LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi öncesi şifre değiştirme gerekli. ", "system");
                            System.err.println(":::ERROR::: Time=["+new Date()
                                    +"] Class=["+this.getClass().getName()
                                    +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                    +"] Message=[Login işlemi öncesi şifre değiştirme gerekli.]:::"); 
                            UrlRedirect.redirect("reset-password?msg=1");                          
                        }
                    }
 else{
                        Messages.dynMsg(null, "error", "Bu hesap kapalıdır. Bilgi için bizimle iletişime geçiniz.");
                        LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. Bu hesap kilitli. ", "system");
                        System.err.println(":::ERROR::: Time=["+new Date()
                                +"] Class=["+this.getClass().getName()
                                +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                +"] Message=[Login işlemi BAŞARISIZ. Bu hesap("+accountDetail.getAccount_EmailAddress()+")..]:::"); 
                    }

                }
                 else{
                    
                    Messages.dynMsg(null, "error", "<b>!! GSM AKTİVASYONU GEREKİYOR </b><br/><a style='color: red' href='/activation'><b>buradan</b></a> GSM aktivasyonu yapabilirsiniz ");
                    LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi öncesi GSM No aktivasyonu gerekli. ", "system");
                    System.err.println(":::ERROR::: Time=["+new Date()
                            +"] Class=["+this.getClass().getName()
                            +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                            +"] Message=[Login işlemi öncesi GSM No adresi aktivasyonu gerekli.]:::"); 
                    return null;
                }
                
         
            
        } else{
            Messages.dynMsg(null, "error", "Kayıtlı böyle bir Gsm numarası yok");
            LogManagerDao.createLog("error", this.getClass().getName(), "Login işlemi BAŞARISIZ. Kayıtlı böyle bir ("+this.account_MobilePhoneNumber+") Gsm numarası yok.", "system");
            System.err.println(":::ERROR::: Time=["+new Date()
                    +"] Class=["+this.getClass().getName()
                    +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                    +"] Message=[Login işlemi BAŞARISIZ. Kayıtlı böyle bir ("+this.account_MobilePhoneNumber+") Gsm numarası yok yok.]:::"); 
        }
        
        return returnPage;
    }
public void authorizedUserControl() {

        if (null != SecurityUtils.getSubject().getPrincipal()) {

            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/member/main_.xhtml?faces-redirect=true");
        }
    }
 public static String logout() {
       Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout(); return "/index.xhtml?faces-redirect=true";
    }
public boolean accountIsAuthenticated() {
       Subject currentUser = SecurityUtils.getSubject();  
 return  currentUser.isAuthenticated();
    }
    public  AccountBean getAccountDetail (String accountGSM){
    
        AccountDao ad = new AccountDao();
        AccountBean ab = new AccountBean();
        ab.setAccount_MobilePhoneNumber(accountGSM);
        
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(ab);
    
        return ad.getAccountDetailWithParam(pab, "getAllWithMobilePhoneNumber").getAccountBean();
    }
    public void insertUserLastLoginInfo(String accountId, String userEmail){
        if(accountId!= null){
         int sonuc;
 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String currentTime = dateFormat.format(date);  
            HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
            HttpServletRequest httpServletRequest2 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String userOs = GetUserEnvironment.getOsHeader(httpServletRequest2);
             HttpServletRequest httpServletRequest3 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String userBrowser = GetUserEnvironment.getBrowserHeader(httpServletRequest3);
           AccountDao ad= new AccountDao();
            sonuc = ad.insertAccountLastLoginInfo(accountId, currentTime, userInternetIp, userOs, userBrowser);

            if(sonuc ==1){    }
            else{ LogManagerDao.createLog("error", this.getClass().getName(), "Kullanıcı ortam bilgileri güncellenirken hata olustu. accountId(accountId="+accountId+"). ", userEmail);
                  System.err.println(":::ERROR::: Time=["+new Date()
                                           +"] Class=["+this.getClass().getName()
                                          +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                         +"] Message=[Kullanıcı ortam bilgileri güncellenirken hata olustu. accountId(accountId="+accountId+").]:::"); 
            
                }
        }
        
        else{   LogManagerDao.createLog("error", this.getClass().getName(), "User login time guncellemesi için gerekli accountId(accountId="+accountId+") gelmedi", userEmail);
                System.err.println(":::ERROR::: Time=["+new Date()
                                           +"] Class=["+this.getClass().getName()
                                          +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                         +"] Message=[User login time guncellemesi için gerekli accountId(accountId="+accountId+") gelmedi.]:::"); 
            }
    } public String userType() { return SessionUtil.getUserType(); }
}
