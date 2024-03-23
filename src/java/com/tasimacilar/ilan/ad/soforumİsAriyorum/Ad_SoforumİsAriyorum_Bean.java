package com.tasimacilar.ilan.ad.soforumİsAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.driver.DriverReferences;
import com.tasimacilar.ilan.driver.DriverReferencesDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.AdUtils;
import com.tasimacilar.ilan.system.ExpiryDates;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.UrlRedirect;
import com.tasimacilar.ilan.system.fileUpload.FileUpload;
import com.tasimacilar.ilan.system.fileUpload.Functions;
import com.tasimacilar.ilan.system.map.LocationInfoFromMap;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "AdSoforumIsAriyorumBean")
@ViewScoped
public class Ad_SoforumİsAriyorum_Bean implements Serializable{
    private String                  Ad_SoforumIsAriyorum_Id;            
    private String                  ad_Id;                              
    private String                  driver_Id;                         
    private String                  Hostess_Id;                      
    private String                  param1;
    private String                  aId;
    private Part                    driverPhotoFile;
    private Part                    hostessPhotoFile;
    private List<DriverReferences>  DriverReferencesList = new ArrayList<DriverReferences>();
    private String                  pAdId = null;
    private String                  AdComment = null;
    private List<Ad_CommentsBean>   adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                  adIdx;      
    private String                  googleMapMarkers;
    private Driver                  driver;
    private DriverReferences        driverReferences;
    private Hostess                 hostess;
    private UIInput                 inputBox;
    private UIInput                 inputBox2;
    private List<Ad_Bean>           adList;
    private Ad_Bean adBean;
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}  
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;
    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    @ManagedProperty(value="#{locationInfoFromMap}")
    private LocationInfoFromMap locationInfoFromMap;
    public LocationInfoFromMap getLocationInfoFromMap() { return locationInfoFromMap;}
    public void setLocationInfoFromMap(LocationInfoFromMap locationInfoFromMap) {  this.locationInfoFromMap = locationInfoFromMap;}
    @PostConstruct
    public void init() {      
        driver = new Driver();
        adBean = new Ad_Bean();
        adList = new ArrayList<Ad_Bean>();       
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1"); 
        pAdId = req.getParameter("adId");      
        aId = req.getParameter("aId");         
        try {
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
                 FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_soforum-is-ariyorum")    ){ 
                if (param1.equals("ekle")) {
                    adIdx = UniqueId.RandomString(12);
                    adBean.setAd_Id(adIdx); 
                    String drvIdxx = UniqueId.RandomString(12);
                    driver.setDriver_Id(drvIdxx);
                    this.driver_Id = drvIdxx;
                    this.Hostess_Id = UniqueId.RandomString(12);                            
                }
            }        
            if(pAdId != null && !pAdId.equals("")){      getAdFullDetailWithAdId(pAdId);  } 
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }         
    }
    public Ad_SoforumİsAriyorum_Bean() {  }
 public String getAd_SoforumIsAriyorum_Id() {return Ad_SoforumIsAriyorum_Id;}
    public void setAd_SoforumIsAriyorum_Id(String Ad_SoforumIsAriyorum_Id) {this.Ad_SoforumIsAriyorum_Id = Ad_SoforumIsAriyorum_Id;} 
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}
    public String getDriver_Id() {return driver_Id;}
    public void setDriver_Id(String driver_Id) {this.driver_Id = driver_Id;}
    public String getHostess_Id() {return Hostess_Id;}
    public void setHostess_Id(String Hostess_Id) { this.Hostess_Id = Hostess_Id;}
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() {return aId;}
    public void setaId(String aId) {this.aId = aId;}
    public List<DriverReferences> getDriverReferencesList() {return DriverReferencesList;}
    public void setDriverReferencesList(List<DriverReferences> DriverReferencesList) { this.DriverReferencesList = DriverReferencesList;}
    public Part getDriverPhotoFile() {return driverPhotoFile;}
    public void setDriverPhotoFile(Part driverPhotoFile) { this.driverPhotoFile = driverPhotoFile;}
    public Part getHostessPhotoFile() {return hostessPhotoFile; }
    public void setHostessPhotoFile(Part hostessPhotoFile) {this.hostessPhotoFile = hostessPhotoFile;}
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public String getGoogleMapMarkers() {return googleMapMarkers; }
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public Driver getDriver() {return driver;}
    public void setDriver(Driver driver) {this.driver = driver;}
    public DriverReferences getDriverReferences() {return driverReferences;}
    public void setDriverReferences(DriverReferences driverReferences) {this.driverReferences = driverReferences;}
    public Hostess getHostess() {return hostess;}
    public void setHostess(Hostess hostess) {this.hostess = hostess;}   
    public UIInput getInputBox() {return inputBox; }
    public void setInputBox(UIInput inputBox) {this.inputBox = inputBox; }
    public UIInput getInputBox2() { return inputBox2;}
    public void setInputBox2(UIInput inputBox2) {this.inputBox2 = inputBox2; }    
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }  
    public void preRenderInput() {
 
    }
    public void preRenderInput2() {
        if(this.driver.getDriver_Fee() == 0){inputBox2.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox2.setValue("");
            }
        }
    }

    public void createSoforumIsAriyorumAd() {
        AccountBean acb = new AccountBean();
        acb.setAccount_Id(SessionUtil.getUserId());      
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(acb);        
        AccountDao ado = new AccountDao();
        this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
        Hostess h = new Hostess();
        h.setHostess_Id(this.Hostess_Id);
        h.setHostess_Modified(new Date());
        h.setHostess_Modifier(SessionUtil.getUserId());
        h.setHostess_Created(new Date());
        h.setHostess_creator(SessionUtil.getUserId());
        Driver d = new Driver();
        d.setDriver_Id(this.driver_Id);
        d.setDriver_FirstName(this.accountBean.getAccount_FirstName());
        d.setDriver_LastName(this.accountBean.getAccount_LastName());
        d.setDriver_EmailAddress(this.accountBean.getAccount_EmailAddress());
        d.setDriver_MobilePhoneNumber(this.accountBean.getAccount_MobilePhoneNumber());
        d.setDriver_Gender(this.accountBean.getAccount_Gender());
        d.setDriver_BirthDate(driver.getDriver_BirthDate());
        d.setDriver_PlaceOfBirth(driver.getDriver_PlaceOfBirth());
        d.setDriver_Education(null);
        String rs = "";
        for (String dl : driver.getDriver_DriversLicenses()) { rs = rs + ',' + dl.toString();  };
        rs.substring(1); 
        d.setDriver_DriversLicense(rs);      
        d.setDriver_DriversLicenseYear(driver.getDriver_DriversLicenseYear());
        d.setDriver_Fee(driver.getDriver_Fee());
        d.setDriver_ServiceTransportationExperience(driver.isDriver_ServiceTransportationExperience());
        d.setDriver_Experience(driver.getDriver_Experience());
        d.setDriver_ProfilePictureUrl(driver.getDriver_ProfilePictureUrl());
        d.setDriver_ProfilePicturePublish(driver.isDriver_ProfilePicturePublish());
        d.setDriver_Retired(driver.isDriver_Retired());
        d.setDriver_CriminalRecord(driver.isDriver_CriminalRecord());
        d.setDriver_CertificateOfProfessionalCompetence(driver.isDriver_CertificateOfProfessionalCompetence());
        d.setDriver_BusinessPreference("");
        d.setDriver_DoYouHaveHostess(driver.isDriver_DoYouHaveHostess());
        d.setDriver_ExtraJobs(driver.isDriver_ExtraJobs());
        d.setDriver_IsActive(driver.isDriver_IsActive());
        d.setDriver_Commnet(driver.getDriver_Commnet());
        d.setDriver_Modified(new Date());
        d.setDriver_Modifier(SessionUtil.getUserId());
        d.setDriver_Created(new Date());
        d.setDriver_creator(SessionUtil.getUserId());       
        if(driver.getDriver_ForeignLanguagesList()!= null && driver.getDriver_ForeignLanguagesList().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : driver.getDriver_ForeignLanguagesList()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            d.setDriver_ForeignLanguages(ForeignLanguagesx);  }      
        if(driver.getDriver_RequestedDocumentesList()!= null && driver.getDriver_RequestedDocumentesList().length > 0){
            String RequestedDocumentesx = "";
            for (String dl : driver.getDriver_RequestedDocumentesList()) { RequestedDocumentesx = RequestedDocumentesx + ',' + dl.toString();  };
            RequestedDocumentesx.substring(1); 
            d.setDriver_RequestedDocumentes(RequestedDocumentesx); }       
         if(driver.getDriver_VehicleTypesList() != null && driver.getDriver_VehicleTypesList().length > 0){
            String VehicleTypesx = "";
            for (String dl : driver.getDriver_VehicleTypesList()) { VehicleTypesx = VehicleTypesx + ',' + dl.toString();  };
            VehicleTypesx.substring(1); 
            d.setDriver_VehicleTypes(VehicleTypesx); }
        Ad_Bean adb = new Ad_Bean();
        adb.setAd_Id(this.adBean.getAd_Id());  
        adb.setAd_Category_Id(6);
        adb.setAd_Title("");
        adb.setAd_Comment(this.adBean.getAd_Comment());
        adb.setAd_IsActive(true); 
        adb.setAd_EndTime(ExpiryDates.AdExpiryDate(7)); 
        adb.setAd_Notes(null);                          
        adb.setAd_CreateTime(new Date()); 
        adb.setAd_CreatedIp(GetUserEnvironment.getInternetIp());
        adb.setAd_CreatedAccountId(SessionUtil.getUserId());
        adb.setAd_LastModifyIp(null);
        adb.setAd_LastModifyTime(null);
        adb.setAd_LastChangerAccountId(null);
        adb.setAd_Type(AdUtils.getAdTyp(aId)); 
        adb.setAd_OvnerAccountId(AdUtils.getOvnerAccountId(aId));
        adl.setAd_SoforumIsAriyorum_Id(UniqueId.RandomString(12));
        adl.setAd_Id(this.adBean.getAd_Id());
        adl.setDriver_Id(this.driver_Id);
        adl.setHostess_Id(this.Hostess_Id);
        adl.setAdBean(adb);
        adl.setDriver(d);
        adl.setHostess(h);       
        if(locationInfoFromMap.getLocationList().size()>0){          
            int sonuc = 0; if( adl.getAd_Id() != null && adl.getDriver_Id() != null && adl.getHostess_Id() != null){
                Ad_SoforumİsAriyorum_Dao a = new Ad_SoforumİsAriyorum_Dao(); 
                sonuc = a.createSoforumIsAriyorumAd(adl);
            } else { System.err.println(":::HATA:::: AdId veya DriverId veya HostessId null Geldi bu yuzden ılan kaydedilmedi.");}
 if(sonuc == 1){
                if(SessionUtil.getUserType().equals("director")){  UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=soforum-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                else{ UrlRedirect.redirect( "/ad/sonuc/soforum-is-ariyorum/"+this.adBean.getAd_Id() ); }              
            }  else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }   
        } else{  Messages.dynMsg(null, "error", "Güzergah bilgisi girilmedi, lütfen güzergah bilgisi giriniz."); }   }  public void updateSoforumIsAriyorumAd() { 
  Hostess h = new Hostess();
        h.setHostess_Id(hostess.getHostess_Id());
        h.setHostess_Modified(new Date());
        h.setHostess_Modifier(SessionUtil.getUserId());Driver d = new Driver();
        d.setDriver_Id(driver.getDriver_Id());      
        d.setDriver_BirthDate(driver.getDriver_BirthDate());
        d.setDriver_PlaceOfBirth(driver.getDriver_PlaceOfBirth());
        d.setDriver_Education(null); String rs = "";
        for (String dl : driver.getDriver_DriversLicenses()) { rs = rs + ',' + dl.toString();  };
        rs.substring(1); 
        d.setDriver_DriversLicense(rs); d.setDriver_DriversLicenseYear(driver.getDriver_DriversLicenseYear());
        d.setDriver_Fee(driver.getDriver_Fee());
        d.setDriver_ServiceTransportationExperience(driver.isDriver_ServiceTransportationExperience());
        d.setDriver_Experience(driver.getDriver_Experience());
        d.setDriver_ProfilePictureUrl(driver.getDriver_ProfilePictureUrl());
        d.setDriver_ProfilePicturePublish(driver.isDriver_ProfilePicturePublish());
        d.setDriver_Retired(driver.isDriver_Retired());
        d.setDriver_CriminalRecord(driver.isDriver_CriminalRecord());
        d.setDriver_CertificateOfProfessionalCompetence(driver.isDriver_CertificateOfProfessionalCompetence());
        d.setDriver_BusinessPreference("");
        d.setDriver_DoYouHaveHostess(driver.isDriver_DoYouHaveHostess());
        d.setDriver_ExtraJobs(driver.isDriver_ExtraJobs());
        d.setDriver_IsActive(driver.isDriver_IsActive());
        d.setDriver_Commnet(driver.getDriver_Commnet());
        d.setDriver_Modified(new Date());
        d.setDriver_Modifier(SessionUtil.getUserId());if(driver.getDriver_ForeignLanguagesList()!= null && driver.getDriver_ForeignLanguagesList().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : driver.getDriver_ForeignLanguagesList()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            d.setDriver_ForeignLanguages(ForeignLanguagesx);
        }  if(driver.getDriver_RequestedDocumentesList()!= null && driver.getDriver_RequestedDocumentesList().length > 0){
            String RequestedDocumentesx = "";
            for (String dl : driver.getDriver_RequestedDocumentesList()) { RequestedDocumentesx = RequestedDocumentesx + ',' + dl.toString();  };
            RequestedDocumentesx.substring(1); 
            d.setDriver_RequestedDocumentes(RequestedDocumentesx);
        } if(driver.getDriver_VehicleTypesList() != null && driver.getDriver_VehicleTypesList().length > 0){
            String VehicleTypesx = "";
            for (String dl : driver.getDriver_VehicleTypesList()) { VehicleTypesx = VehicleTypesx + ',' + dl.toString();  };
            VehicleTypesx.substring(1); 
            d.setDriver_VehicleTypes(VehicleTypesx);
        } Ad_Bean adb = new Ad_Bean(); 
        adb.setAd_Id(this.pAdId);                                         
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());         
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());      Ad_SoforumİsAriyorum_Bean adl = new Ad_SoforumİsAriyorum_Bean();  
        adl.setAd_SoforumIsAriyorum_Id(UniqueId.RandomString(12));
        adl.setAd_Id(this.adBean.getAd_Id());
        adl.setDriver_Id(this.driver_Id);
        adl.setHostess_Id(this.Hostess_Id);
        adl.setAdBean(adb);
        adl.setDriver(d);
        adl.setHostess(h);   int sonuc = 0; if( adl.getAd_Id() != null && adl.getDriver_Id() != null && adl.getHostess_Id() != null){           
            Ad_SoforumİsAriyorum_Dao a = new Ad_SoforumİsAriyorum_Dao(); 
            sonuc = a.updateSoforumIsAriyorumAd(adl);
        } else { System.err.println(":::HATA:::: AdId veya DriverId veya HostessId null Geldi bu yuzden ılan kaydedilmedi.");}  if(sonuc == 1){
            if(SessionUtil.getUserType().equals("director")){
                UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=soforum-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
            } else{ UrlRedirect.redirect("/ad/sonuc2/soforum-is-ariyorum/"+this.adBean.getAd_Id()); }
                  
        } else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu"); }
    }  public void getAdFullDetailWithAdId(String adId) {  Ad_SoforumİsAriyorum_Bean al = new Ad_SoforumİsAriyorum_Bean();
        Ad_SoforumİsAriyorum_Dao ad = new Ad_SoforumİsAriyorum_Dao();
        al = ad.getSoforumIsAriyorumAdWithAdId(adId);   if(al.getAdBean() != null){  this.setAd_SoforumIsAriyorum_Id(al.getAd_SoforumIsAriyorum_Id());
            this.setAd_Id(al.getAd_Id());
            adBean=al.getAdBean();
            this.setDriver_Id(al.getDriver_Id());
            setDriver(al.getDriver());
            setHostess_Id(al.getHostess_Id());
            setHostess(al.getHostess());      DriverReferencesDao vd = new DriverReferencesDao();
            this.DriverReferencesList = vd.getAllVehicleReferenceWithDriverId(al.getDriver_Id()); AdRouteDao a = new AdRouteDao();
            locationInfoFromMap.setLocationList(a.getAllAdRouteWithAdId(adBean.getAd_Id())) ;
            setLocationToGMAP(); AccountBean acb = new AccountBean();
            acb.setAccount_Id(al.adBean.getAd_OvnerAccountId());  PersonalAccountBean pab = new PersonalAccountBean();
            pab.setAccountBean(acb);  AccountDao ado = new AccountDao();
            this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean(); CorporateAccountDao cod = new CorporateAccountDao();
            if(this.accountBean != null){this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());}
             Ad_CommentsDao adxx = new Ad_CommentsDao();
            this.adCommentsList = adxx.getAllCommentWithItemId(this.adBean.getAd_Id());
             Ad_Dao adda = new Ad_Dao();
            this.adList = adda.getUserTopTenAdWithPublish(al.adBean.getAd_OvnerAccountId());   }
        else{  Ad_Bean a = new Ad_Bean();
            a.setAd_IsActive(false);
            this.adBean = a;  }   }public void fileUpload(String fileType) {   try {      if(fileType.equals("driver")){
                if(driverPhotoFile != null){
                    driver.setDriver_ProfilePictureUrl("/resources/media/" + FileUpload.uploadFile(this.driverPhotoFile));
                } else{System.out.println(":::HATA:::Driver resim file null geldi.");}
            }
        }  catch (IOException ex) { System.out.println(":::HATA:::" + ex);  }  } public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
       Functions.validateFile(ctx, comp, value);
    }     
        FavoritesBean f = new FavoritesBean();
        f.createFavoritesAd(pAdId); } public void createAdComment(){
        int sonuc = 0;
        Ad_CommentsBean ac = new Ad_CommentsBean();
        sonuc = ac.createAdComment(this.pAdId,this.AdComment );
        
        if(sonuc == 1){this.AdComment = null;}  }  public void setLocationToGMAP(){
    
        String markers ="[ ";
        int isSayisi = 0;
        for (AdRouteBean a : locationInfoFromMap.getLocationList()) {
            SimpleDateFormat DtFrm = new SimpleDateFormat("HH:mm");
            String stTime= DtFrm.format(a.getAdRoute_StartTime());
            String enTime= DtFrm.format(a.getAdRoute_EndTime());
            isSayisi = isSayisi+1;
            markers = markers+"{ iconResim:'/resources/img/kırmızı_pin.png' ,  addressx:'"+a.getAdRoute_StartPosition_Neighborhood()+
                              ", "+a.getAdRoute_StartPosition_Town()+
                              ", "+a.getAdRoute_StartPosition_City()+
                              "', p_content:'<b>Şöförüm İş Arıyorum</b><br><p>"+isSayisi+".İş - Şöförün boş olduğu yer<br/><br/> Saat: "+stTime+" - "+enTime+" <br/>Yer : "+a.getAdRoute_StartPosition_Neighborhood()+" - "+a.getAdRoute_StartPosition_Town()+" - "+a.getAdRoute_StartPosition_City()+"</p>' },";
        }
        markers = markers+" ]";
        this.googleMapMarkers= markers;
        
    }
    
    
}
