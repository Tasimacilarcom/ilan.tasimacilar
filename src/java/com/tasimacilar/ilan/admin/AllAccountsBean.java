package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.common.AccountActivationBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "allAccountsBean")
@ViewScoped
public class AllAccountsBean implements Serializable{
    private String aId;                                 //account Id
    private List<AllAccountsBean> AllAccountsList;
    private String page = "userInfo";
    private String email;
    private String phone;
    private String name;
    private List<AllAccountsBean> searchedAccount;
    @ManagedProperty(value="#{personalAccountBean}")
    private PersonalAccountBean personalAccountBean;
    public PersonalAccountBean getPersonalAccountBean() {return personalAccountBean;}
    public void setPersonalAccountBean(PersonalAccountBean personalAccountBean) {this.personalAccountBean = personalAccountBean;}
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;
    public CorporateAccountBean getCorporateAccountBean() { return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) { this.corporateAccountBean = corporateAccountBean;}
    @ManagedProperty(value="#{accountActivationBean}")
    private AccountActivationBean accountActivationBean;
    public AccountActivationBean getAccountActivationBean() {return accountActivationBean;}
    public void setAccountActivationBean(AccountActivationBean accountActivationBean) {this.accountActivationBean = accountActivationBean;}
    @PostConstruct
    public void init() { 
    
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        aId = req.getParameter("aId");        
        page = req.getParameter("p"); 
        try {
            
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            String urlBaseName = FilenameUtils.getBaseName(urlx.getPath());

            if(urlBaseName.equals("kullanici_yonetimi") ){ 
               collectAllAccounts();
            }
            if(urlBaseName.equals("kullanici_detay_userInfo") || 
               urlBaseName.equals("kullanici_detay_userInfoEdit") || 
               urlBaseName.equals("kullanici_detay_companyInfoEdit") ||   
               urlBaseName.equals("kullanici_detay_userActivation") || 
               urlBaseName.equals("kullanici_detay_userEnableDisable") || 
               urlBaseName.equals("kullanici_detay_userBlackList") || 
               urlBaseName.equals("kullanici_detay_yeni_arac_ekle_s1") ||   
               urlBaseName.equals("kullanici_detay_yeni_arac_ekle_s2") ||  
               urlBaseName.equals("kullanici_detay_yeni_arac_ekle_s3") ||  
               urlBaseName.equals("kullanici_detay_yeni_arac_ekle_s4") ||  
               urlBaseName.equals("kullanici_detay_yeni_arac_ekle_SonucSayfasi") ||       
               urlBaseName.equals("kullanici_detay_edit_vehicle_s1") ||  
               urlBaseName.equals("kullanici_detay_edit_vehicle_s2") ||   
               urlBaseName.equals("kullanici_detay_edit_vehicle_s3") ||   
               urlBaseName.equals("kullanici_detay_edit_vehicle_s4") ||      
               urlBaseName.equals("kullanici_detay_userVehicle") || 
               urlBaseName.equals("kullanici_detay_addAd") ||      
               urlBaseName.equals("kullanici_detay_addAd_aracim-var-hostes-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_aracim-var-is-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_aracim-var-sofor-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_hostesim-is-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_isim-var-arac-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_soforum-is-ariyorum") || 
               urlBaseName.equals("kullanici_detay_addAd_plakami-satiyorum") ||    
               urlBaseName.equals("kullanici_detay_addAd_sonucSayfasi") ||      
               urlBaseName.equals("kullanici_detay_userAds") || 
               urlBaseName.equals("kullanici_detay_userComments")){ 
               accountWithIdGet(aId);
               
               
            }
            

        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }  
        
       
    }  
    public AllAccountsBean() {  }
     public List<AllAccountsBean> getAllAccountsList() { return AllAccountsList;}
    public void setAllAccountsList(List<AllAccountsBean> AllAccountsList) { this.AllAccountsList = AllAccountsList;}
    public String getPage() {return page;}
    public void setPage(String page) { this.page = page;}
    public String getEmail() { return email;}
   public void setEmail(String email) { this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) { this.phone = phone;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public List<AllAccountsBean> getSearchedAccount() { return searchedAccount;}
    public void setSearchedAccount(List<AllAccountsBean> searchedAccount) { this.searchedAccount = searchedAccount;}
    public String getaId() { return aId;}
    public void setaId(String aId) {  this.aId = aId;}
    public void collectAllAccounts(){
        AllAccountsDao ad = new AllAccountsDao();
        this.AllAccountsList = ad.getAllAccounts();
    }  
    public void accountWithIdGet(String aIdx){    
        if(aIdx != null ){
            if( !aIdx.equals("")){
            
                AllAccountsBean ab = new AllAccountsBean();      
                AllAccountsDao ad = new AllAccountsDao();
                ab = ad.getAccountWithId(aIdx);

                this.personalAccountBean = ab.getPersonalAccountBean();
                this.corporateAccountBean = ab.getCorporateAccountBean();
                this.accountActivationBean.setAccount_EmailActivationId(ab.getPersonalAccountBean().getAccountBean().getAccount_EmailActivationId());
                this.accountActivationBean.setAccount_MobilePhoneNumberActivationId(ab.getPersonalAccountBean().getAccountBean().getAccount_MobilePhoneNumberActivationId());
            }
            else {System.err.println(":::HATA:::Account Id  bos geldi");}
        }    
        else {System.err.println(":::HATA:::Account Id null  geldi");}
    }
public String pageName(String pageName){       
        String yonlen = null; 
        if(pageName != null ){
            if( !pageName.equals("")){
                
                this.page = pageName;
            
                if (page.equals("userActivation")) {
                    this.accountActivationBean.setAccount_EmailActivationId(this.personalAccountBean.getAccountBean().getAccount_EmailActivationId());
                    this.accountActivationBean.setAccount_MobilePhoneNumberActivationId(this.personalAccountBean.getAccountBean().getAccount_MobilePhoneNumberActivationId());
                }

                if(page.equals("userInfo")){yonlen = "/private/director/users/kullanici_detay_userInfo.xhtml?p=userInfo&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("userInfoEdit")){yonlen = "/private/director/users/kullanici_detay_userInfoEdit.xhtml?p=userInfoEdit&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("conpanyInfoEdit")){yonlen = "/private/director/users/kullanici_detay_companyInfoEdit.xhtml?p=conpanyInfoEdit&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("userActivation")){yonlen = "/private/director/users/kullanici_detay_userActivation.xhtml?p=userActivation&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("disableAccount")){yonlen = "/private/director/users/kullanici_detay_userEnableDisable.xhtml?p=disableAccount&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("blackListAccount")){yonlen = "/private/director/users/kullanici_detay_userBlackList.xhtml?p=blackListAccount&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("addVehicle_s1")){yonlen = "/private/director/users/kullanici_detay_yeni_arac_ekle_s1.xhtml?p=addVehicle_s1&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("userVehicle")){yonlen = "/private/director/users/kullanici_detay_userVehicle.xhtml?p=userVehicle&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("addAd")){yonlen = "/private/director/users/kullanici_detay_addAd.xhtml?p=addAd&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("userAds")){yonlen = "/private/director/users/kullanici_detay_userAds.xhtml?p=userAds&amp;aId="+aId+"&amp;faces-redirect=true";}
                if(page.equals("userComments")){yonlen = "/private/director/users/kullanici_detay_userComments.xhtml?p=userComments&amp;aId="+aId+"&amp;faces-redirect=true";}
            }
            else {System.err.println(":::HATA:::PageName  bos geldi");}
        }
        else {System.err.println(":::HATA:::PageName null geldi");}
        
        return yonlen;
    } 
  public void enableDisableAccout(String param){
        
        int sonuc = 0;
        
          if(this.aId != null && param != null){
            if(!this.aId.equals("") && !param.equals("")){   
                AllAccountsDao ad  = new AllAccountsDao();
                sonuc = ad.enableDisableAccounts(param, this.aId);
            }
            else{
                System.err.println(":::HATA:: Kullanıcı hesabı aktif/pasif yapılırken sorun oluştu. accountId veya param boş geldi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı aktif/pasif yapılırken sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
        }
        else{
            System.err.println(":::HATA:: Kullanıcı hesabı aktif/pasif yapılırken sorun oluştu. accountId veya param null geldi");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı aktif/pasif yapılırken sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        
        
        
        if(sonuc == 1){
            if(param.equals("enable")){
                
                accountWithIdGet(this.aId);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı etkinleştirilmiştir.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            if(param.equals("disable")){
                
                accountWithIdGet(this.aId);
                 FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı pasif hale getirilmiştir.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            } 
        }
        else{
            System.err.println(":::HATA:::Kullanıcı hesabını aktif/pasif yapma sırasında sorun oluştu.");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kullanıcı hesabını aktif/pasif yapma sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } 
    }
  public String deleteAccount(){
    
        int sonuc = 0;
        String yonlen ="";
        
        if(this.aId != null){
            if(!this.aId.equals("")){
                AllAccountsDao ad = new AllAccountsDao();
                sonuc = ad.deleteAccount(this.aId);      
            }
            else{
                System.err.println(":::HATA:: Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu. accountId boş geldi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
        }
        else{
            System.err.println(":::HATA:: Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu. accountId null geldi");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        
        if(sonuc == 1){
            yonlen = "/private/director/users/kullanici_yonetimi.xhtml?faces-redirect=true";
            
            System.out.println(":::BILGI:: Kullanıcı hesabı kalıcı olarak silindi");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kalıcı olarak silindi");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else{
            System.err.println(":::HATA:: Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı hesabı kalıcı olarak silinirken sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }  
        
        return yonlen;
    }
    
public void searchAccountWithPhoneOrName(){
    
        if(this.email == null){this.email = "";}
        if(this.phone == null){this.phone = "";}
        if(this.name == null){this.name = "";}
        
        AllAccountsDao ad = new AllAccountsDao();
        this.searchedAccount = ad.getAccountWithPhoneOrName(this.email, this.phone, this.name);
        
    }
    

    
}
