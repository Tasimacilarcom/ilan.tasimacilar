package com.tasimacilar.ilan.ad.hostesimİsAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.hostess.HostessReferencesBean;
import com.tasimacilar.ilan.hostess.HostessReferencesDao;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "AdHostesimIsAriyorumBean")
@ViewScoped
public class Ad_HostesimİsAriyorum_Bean implements Serializable{    
    private String                          Ad_HostesimIsAriyorum_Id;            
    private String                          ad_Id;                          
    private String                          param1;
    private String                          aId;
    private List<HostessReferencesBean>     HostessReferencesList = new ArrayList<HostessReferencesBean>();
    private Part                            hostessPhotoFile;
    private String                          pAdId = null;
    private String                          AdComment = null;
    private List<Ad_CommentsBean>           adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                          googleMapMarkers;
    private Hostess                         hostess;
    private List<Ad_Bean>                   adList;
    @ManagedProperty(value="#{hostessReferencesBean}")
    private HostessReferencesBean hostessReferencesBean;
    public HostessReferencesBean getHostessReferencesBean() {return hostessReferencesBean;}
    public void setHostessReferencesBean(HostessReferencesBean hostessReferencesBean) {this.hostessReferencesBean = hostessReferencesBean;}
    @ManagedProperty(value="#{adBean}")
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
        hostess = new Hostess();
        adList = new ArrayList<Ad_Bean>();   
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1");   
        pAdId = req.getParameter("adId");    
        aId = req.getParameter("aId");      
        try {
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);         
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_hostesim-is-ariyorum")  ){ 
                if (param1.equals("ekle")) {                  
                    adBean.setAd_Id(UniqueId.RandomString(12)); 
                    hostess.setHostess_Id(UniqueId.RandomString(12)); }
            }          
            if(pAdId != null && !pAdId.equals("")){ 
                getAdFullDetailWithAdId(pAdId);
            }          
        }  catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }      
    }
    public Ad_HostesimİsAriyorum_Bean() { }
    public String getAd_HostesimIsAriyorum_Id() {return Ad_HostesimIsAriyorum_Id;}
    public void setAd_HostesimIsAriyorum_Id(String Ad_HostesimIsAriyorum_Id) {this.Ad_HostesimIsAriyorum_Id = Ad_HostesimIsAriyorum_Id;}
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() {return aId; }
    public void setaId(String aId) {  this.aId = aId; }
    public List<HostessReferencesBean> getHostessReferencesList() {return HostessReferencesList;}
    public void setHostessReferencesList(List<HostessReferencesBean> HostessReferencesList) {this.HostessReferencesList = HostessReferencesList;}
    public Part getHostessPhotoFile() {return hostessPhotoFile; }
    public void setHostessPhotoFile(Part hostessPhotoFile) {this.hostessPhotoFile = hostessPhotoFile;}
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public String getGoogleMapMarkers() {return googleMapMarkers; }
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public Hostess getHostess() {return hostess;}
    public void setHostess(Hostess hostess) {this.hostess = hostess;} 
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }
    public void createHostesimIsAriyorumAd() { 
        hostess.setHostess_Modified(new Date());
        hostess.setHostess_Modifier(SessionUtil.getUserId());
        hostess.setHostess_Created(new Date());
        hostess.setHostess_creator(SessionUtil.getUserId());              
        if(hostess.getHostess_ForeignLanguagesList() != null && hostess.getHostess_ForeignLanguagesList().length > 0){ 
            String ForeignLanguagesx = "";
            for (String dl :hostess.getHostess_ForeignLanguagesList()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            hostess.setHostess_ForeignLanguages(ForeignLanguagesx);System.out.println("****"+ForeignLanguagesx);
        }
        Ad_Bean adb = new Ad_Bean();     
        adb.setAd_Id(this.adBean.getAd_Id());           
        adb.setAd_Category_Id(5);                               
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
        Ad_HostesimİsAriyorum_Bean adl = new Ad_HostesimİsAriyorum_Bean();  
        adl.setAd_HostesimIsAriyorum_Id(UniqueId.RandomString(12));
        adl.setAd_Id(this.adBean.getAd_Id());
        adl.setAdBean(adb);
        adl.setHostess(hostess);    
        if(locationInfoFromMap.getLocationList().size()>0){                  
            int sonuc = 0;       
            if( adl.getAd_Id() != null ){
                Ad_HostesimİsAriyorum_Dao a = new Ad_HostesimİsAriyorum_Dao(); 
                sonuc = a.createHostesimIsAriyorumAd(adl);
            }
            else { System.err.println(":::HATA:::: AdId veya HostessId null Geldi bu yuzden ılan kaydedilmedi.");}
            if(sonuc == 1){          
                if(SessionUtil.getUserType().equals("director")){  UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=hostesim-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                else{ UrlRedirect.redirect( "/ad/sonuc/hostesim-is-ariyorum/"+this.adBean.getAd_Id() ); }
            } else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }       
        }else{  Messages.dynMsg(null, "error", "Güzergah bilgisi girilmedi, lütfen güzergah bilgisi giriniz."); }
   }
    public void updateHostesimIsAriyorumAd() { 
        hostess.setHostess_Modified(new Date());
        hostess.setHostess_Modifier(SessionUtil.getUserId());
        hostess.setHostess_Created(new Date());
        hostess.setHostess_creator(SessionUtil.getUserId());
        if(hostess.getHostess_ForeignLanguagesList() != null && hostess.getHostess_ForeignLanguagesList().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : hostess.getHostess_ForeignLanguagesList()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            hostess.setHostess_ForeignLanguages(ForeignLanguagesx);
        }
        Ad_Bean adb = new Ad_Bean(); 
        adb.setAd_Id(this.pAdId);                                         
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());         
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());  
        Ad_HostesimİsAriyorum_Bean adl = new Ad_HostesimİsAriyorum_Bean();  
        adl.setAd_HostesimIsAriyorum_Id(UniqueId.RandomString(12));
        adl.setAd_Id(this.adBean.getAd_Id());
        adl.setAdBean(adb);
        adl.setHostess(hostess);      
        int sonuc = 0;       
        if( adl.getAd_Id() != null ){    
            Ad_HostesimİsAriyorum_Dao a = new Ad_HostesimİsAriyorum_Dao(); 
            sonuc = a.updateHostesimIsAriyorumAd(adl);
        }
        else { System.err.println(":::HATA:::: AdId veya HostessId null Geldi bu yuzden ılan kaydedilmedi.");}   
        if(sonuc == 1){
            if(SessionUtil.getUserType().equals("director")){
                UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=hostesim-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
            }
            else{ UrlRedirect.redirect("/ad/sonuc2/hostesim-is-ariyorum/"+this.adBean.getAd_Id()); }
        }
        else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu"); }
   }
    public void getAdFullDetailWithAdId(String adId) {
        Ad_HostesimİsAriyorum_Bean al = new Ad_HostesimİsAriyorum_Bean();
        Ad_HostesimİsAriyorum_Dao ad = new Ad_HostesimİsAriyorum_Dao();
        al = ad.getHostesimIsAriyorumAdWithAdId(adId);
        this.setAd_HostesimIsAriyorum_Id(al.getAd_HostesimIsAriyorum_Id());
        this.setAd_Id(al.getAd_Id());
        this.setAdBean(al.getAdBean());
        setHostess(al.getHostess());
        HostessReferencesDao vd = new HostessReferencesDao();
        this.HostessReferencesList = vd.getAllHostessReferenceWithHostessId(al.getHostess().getHostess_Id());
        AdRouteDao a = new AdRouteDao();
        locationInfoFromMap.setLocationList(a.getAllAdRouteWithAdId(this.adBean.getAd_Id())) ;
        setLocationToGMAP();
        AccountBean acb = new AccountBean();
        acb.setAccount_Id(al.adBean.getAd_OvnerAccountId());      
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(acb);
        AccountDao ado = new AccountDao();
        this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
        CorporateAccountDao cod = new CorporateAccountDao();
        if(this.accountBean != null){this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());}
        Ad_CommentsDao adxx = new Ad_CommentsDao();
        this.adCommentsList = adxx.getAllCommentWithItemId(this.adBean.getAd_Id());             
        Ad_Dao adda = new Ad_Dao();
        this.adList = adda.getUserTopTenAdWithPublish(al.adBean.getAd_OvnerAccountId());        
    }
    public void createHostessReference() {   
        if( this.hostessReferencesBean.getHostessReferences_Company() != null && 
            this.hostessReferencesBean.getHostessReferences_Project() != null ){        
                if( ! this.hostessReferencesBean.getHostessReferences_Company().equals("") && 
                    ! this.hostessReferencesBean.getHostessReferences_Project().equals("") && 
                    this.hostessReferencesBean.getHostessReferences_ProjectWorkingYear() != 0){
                        int sonuc = 0;
                        String ovnerAccountIdx = SessionUtil.getUserId();
                        HostessReferencesBean h = new HostessReferencesBean();
                        h.setHostessReferences_Id(UniqueId.RandomString(12));
                        h.setHostessReferences_Company(this.hostessReferencesBean.getHostessReferences_Company());
                        h.setHostessReferences_Project(this.hostessReferencesBean.getHostessReferences_Project());
                        h.setHostessReferences_ProjectStartDate(new Date());
                        h.setHostessReferences_ProjectEndDate(new Date());
                        h.setHostessReferences_ProjectWorkingYear(this.hostessReferencesBean.getHostessReferences_ProjectWorkingYear());
                        h.setHostessReferences_Modified(new Date());
                        h.setHostessReferences_Modifier(ovnerAccountIdx);
                        h.setHostessReferences_Created(new Date());
                        h.setHostessReferences_creator(ovnerAccountIdx);
                        h.setHostess_Id(hostess.getHostess_Id());
                        HostessReferencesDao vd = new HostessReferencesDao();
                        sonuc = vd.createHostessReference(h);
                        if(sonuc == 1){
                            this.HostessReferencesList.clear();
                            getAllHostessReferenceWithHostessId(hostess.getHostess_Id());
                            this.hostessReferencesBean.setHostessReferences_Company(null);
                            this.hostessReferencesBean.setHostessReferences_Project(null);
                            this.hostessReferencesBean.setHostessReferences_ProjectStartDate(null);
                            this.hostessReferencesBean.setHostessReferences_ProjectEndDate(null);
                            this.hostessReferencesBean.setHostessReferences_ProjectWorkingYear(0);
                        }
                        else{ System.out.println(":::: HOSTES REFERAS EKLEME BASARISIZ"); }

            } else{Messages.dynMsg(null, "error", "Lütfen önceden çalıştığınız işe ait bilgileri giriniz."); }   
        } else{Messages.dynMsg(null, "error", "Lütfen önceden çalıştığınız işe ait bilgileri giriniz."); }
    }
    public void getAllHostessReferenceWithHostessId(String hostessId) {
        HostessReferencesDao vd = new HostessReferencesDao();
        this.HostessReferencesList = vd.getAllHostessReferenceWithHostessId(hostessId);
    }
    public void deleteHostessReference(String hostessReferencesId) {  
        int sonuc = 0;
        HostessReferencesDao vd = new HostessReferencesDao();
        sonuc = vd.deleteHostessReference(hostessReferencesId);
        if(sonuc==1){ this.HostessReferencesList.clear();
            getAllHostessReferenceWithHostessId(hostess.getHostess_Id()); } else{  System.out.println("::: SİLME İŞLEMİ BAŞARISIZ"); }
    } public void fileUpload(String fileType) {  
        try {     if(fileType.equals("hostess")){
                if(hostessPhotoFile != null){
                    hostess.setHostess_ProfilePictureUrl("/resources/media/" + FileUpload.uploadFile(this.hostessPhotoFile));
                }
                else{System.out.println(":::HATA:::Hostes resim file null geldi.");}
            }
        } 
        catch (IOException ex) { System.out.println(":::HATA:::" + ex);  }
    }
    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {    Functions.validateFile(ctx, comp, value); }  
    public void createFavoritesAd(){ FavoritesBean f = new FavoritesBean(); f.createFavoritesAd(pAdId);   } 
    public void createAdComment(){
        int sonuc = 0;
        Ad_CommentsBean ac = new Ad_CommentsBean();
        sonuc = ac.createAdComment(this.pAdId,this.AdComment );
        
        if(sonuc == 1){this.AdComment = null;}
    }public void setLocationToGMAP(){
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
                              "', p_content:'<b>Hostesim İş Arıyorum</b><br><p>"+isSayisi+".İş - Hostes in boş olduğu yer<br/><br/> Saat: "+stTime+" - "+enTime+" <br/>Yer : "+a.getAdRoute_StartPosition_Neighborhood()+" - "+a.getAdRoute_StartPosition_Town()+" - "+a.getAdRoute_StartPosition_City()+"</p>' },";
        }
        markers = markers+" ]";
        this.googleMapMarkers= markers;
        
    }}
