package com.tasimacilar.ilan.ad.aracimVarHostesAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
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
import com.tasimacilar.ilan.system.map.LocationInfoFromMap;
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
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "adAracimVarHostesAriyorumBean")
@ViewScoped
public class Ad_AracimVarHostesAriyorum_Bean implements Serializable{  
    private Ad_AracimVarHostesAriyorum  adAracimVarHostesAriyorum;
    private Ad_Bean                     adBean;                                                    
    private String                      param1;
    private String                      aId;      
    private String                      pAdId = null;
    private String                      AdComment = null;
    private List<Ad_CommentsBean>       adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                      googleMapMarkers;
    private int                         ad_ViewCount;                                         
    private UIInput                     inputBox;
    private UIInput                     inputBox2;
    private List<Ad_Bean>               adList;
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
        adAracimVarHostesAriyorum = new Ad_AracimVarHostesAriyorum();
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
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-hostes-ariyorum")){            
                 if (param1.equals("ekle")) {  adBean.setAd_Id(UniqueId.RandomString(12));    }
            }                      
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("duzenle") ||
                FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-hostes-ariyorum") ){                
                if(param1!= null && !param1.equals("")){  if (param1.equals("duzenle")) {}}                
            }          
            if(pAdId != null && !pAdId.equals("")){ getAdFullDetailWithAdId(pAdId); }          
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }        
    }
    public Ad_AracimVarHostesAriyorum_Bean() { }   
    public Ad_AracimVarHostesAriyorum getAdAracimVarHostesAriyorum() {return adAracimVarHostesAriyorum;}
    public void setAdAracimVarHostesAriyorum(Ad_AracimVarHostesAriyorum adAracimVarHostesAriyorum) { this.adAracimVarHostesAriyorum = adAracimVarHostesAriyorum;}
    public Ad_Bean getAdBean() { return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() { return aId;}
    public void setaId(String aId) { this.aId = aId;}
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public String getGoogleMapMarkers() {return googleMapMarkers; }
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public int getAd_ViewCount() {return ad_ViewCount;}
    public void setAd_ViewCount(int ad_ViewCount) {this.ad_ViewCount = ad_ViewCount;}  
    public UIInput getInputBox() {return inputBox; }
    public void setInputBox(UIInput inputBox) {this.inputBox = inputBox; }
    public UIInput getInputBox2() { return inputBox2;}
    public void setInputBox2(UIInput inputBox2) {this.inputBox2 = inputBox2; }
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }
    public void preRenderInput() { }
    public void preRenderInput2() {
        if(this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_Cost()==0){inputBox2.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) { inputBox2.setValue(""); }
        }
    }       
    @Override
    public String toString() {
        return "Ad_AracimVarHostesAriyorum_Bean{" + "adAracimVarHostesAriyorum=" + adAracimVarHostesAriyorum + ", adBean=" + adBean + ", param1=" + param1 + ", aId=" + aId + ", pAdId=" + pAdId + ", AdComment=" + AdComment + ", adCommentsList=" + adCommentsList + ", googleMapMarkers=" + googleMapMarkers + ", ad_ViewCount=" + ad_ViewCount + ", accountBean=" + accountBean + ", corporateAccountBean=" + corporateAccountBean + ", locationInfoFromMap=" + locationInfoFromMap + '}';
    }   
    public void createLookingForVehicleForWorkAd() { 
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(this.adBean.getAd_Id());           
        adb.setAd_Category_Id(4);                               
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());     
        adb.setAd_Type(AdUtils.getAdTyp(aId)); 
        adb.setAd_OvnerAccountId(AdUtils.getOvnerAccountId(aId));  
        adb.setAd_IsActive(true);  
        adb.setAd_EndTime(ExpiryDates.AdExpiryDate(7));   
        adb.setAd_Notes(null);                          
        adb.setAd_CreateTime(new Date());                       
        adb.setAd_CreatedIp(GetUserEnvironment.getInternetIp());
        adb.setAd_CreatedAccountId(SessionUtil.getUserId()); 
       Ad_AracimVarHostesAriyorum_Bean adl = new Ad_AracimVarHostesAriyorum_Bean();   
       adl.adAracimVarHostesAriyorum = this.adAracimVarHostesAriyorum;
       adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_Id(UniqueId.RandomString(12));
       if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul1")){adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(true);}
       if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul2")){adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(true);}
       if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul3")){adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_highSchool(true);}    
        if(this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages() != null && this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_ForeignLanguage(ForeignLanguagesx);
        }       
       adl.setAdBean(adb);
        if(locationInfoFromMap.getLocationList().size()>0){
            int sonuc = 0;
            Ad_AracimVarHostesAriyorum_Dao a = new Ad_AracimVarHostesAriyorum_Dao();
            sonuc = a.createAracimVarHostesAriyorumAd(adl);
            if(sonuc == 1){             
                if(SessionUtil.getUserType().equals("director")){ UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=aracim-var-hostes-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                else{ UrlRedirect.redirect("/ad/sonuc/aracim-var-hostes-ariyorum/"+this.adBean.getAd_Id()); } 
            }
            else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu");}
        }
        else{ Messages.dynMsg(null, "error", "Lütfen güzergah bilgisi giriniz"); }  
   }
    public void updateLookingForVehicleForWorkAd() { 
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(this.adBean.getAd_Id());           
        adb.setAd_Category_Id(4);                               
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());                          
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());
        Ad_AracimVarHostesAriyorum_Bean adl = new Ad_AracimVarHostesAriyorum_Bean();   
        adl.adAracimVarHostesAriyorum = this.adAracimVarHostesAriyorum;
        if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul1")){ adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(true);  }
        if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul2")){ adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(true); }
        if(adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_schoolType().equals("okul3")){ adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType_highSchool(true);  }      
        if(this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages() != null && this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : this.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguages()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            adl.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_ForeignLanguage(ForeignLanguagesx);
        }       
        adl.setAdBean(adb);       
        int sonuc = 0;
        Ad_AracimVarHostesAriyorum_Dao a = new Ad_AracimVarHostesAriyorum_Dao();
        sonuc = a.updateAracimVarHostesAriyorumAd(adl);       
        if(sonuc == 1){
            if(SessionUtil.getUserType().equals("director")){
                UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=aracim-var-hostes-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
            }
            else{ UrlRedirect.redirect("/ad/sonuc2/aracim-var-hostes-ariyorum/"+this.adBean.getAd_Id()); }           
        }
        else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu");}
   }
    public void getAdFullDetailWithAdId(String adId) {     
        Ad_AracimVarHostesAriyorum_Bean al = new Ad_AracimVarHostesAriyorum_Bean();
        Ad_AracimVarHostesAriyorum_Dao ad = new Ad_AracimVarHostesAriyorum_Dao();
        al = ad.getAracimVarHostesAriyorumWithAdId(adId);
        this.adAracimVarHostesAriyorum = al.getAdAracimVarHostesAriyorum();
        if(al.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_highSchool()){ this.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType( "okul3");   }
        if(al.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_kindergarten()){ this.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType("okul1");  }
        if(al.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_primarySchool()){  this.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_schoolType("okul2"); } 
        if(al.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguage() != null){
            String ForeignLanguagexx = al.adAracimVarHostesAriyorum.getAd_AracimVarHostesAriyorum_ForeignLanguage().substring(1);
            String[] ForeignLanguagexxx = ForeignLanguagexx.split(",");
            this.adAracimVarHostesAriyorum.setAd_AracimVarHostesAriyorum_ForeignLanguages(ForeignLanguagexxx);
        }
        this.adBean.setAd_Id(al.adBean.getAd_Id());
        this.adBean.setAd_Id2(al.adBean.getAd_Id2());
        this.adBean.setAd_Category_Id(al.adBean.getAd_Category_Id());
        this.adBean.setAd_Title(al.adBean.getAd_Title());
        this.adBean.setAd_Comment(al.adBean.getAd_Comment());
        this.adBean.setAd_Type(al.adBean.getAd_Type());
        this.adBean.setAd_OvnerAccountId(al.adBean.getAd_OvnerAccountId());
        this.adBean.setAd_IsActive(al.adBean.isAd_IsActive());
        this.adBean.setAd_EndTime(al.adBean.getAd_EndTime());
        this.adBean.setAd_Notes(al.adBean.getAd_Notes());
        this.adBean.setAd_CreateTime(al.adBean.getAd_CreateTime());
        this.adBean.setAd_CreatedIp(al.adBean.getAd_CreatedIp());
        this.adBean.setAd_CreatedAccountId(al.adBean.getAd_CreatedAccountId());
        this.adBean.setAd_LastModifyIp(al.adBean.getAd_LastModifyIp());
        this.adBean.setAd_LastModifyTime(al.adBean.getAd_LastModifyTime());
        this.adBean.setAd_LastChangerAccountId(al.adBean.getAd_LastChangerAccountId());                                               
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
    public void createFavoritesAd(){      
        FavoritesBean f = new FavoritesBean();
        f.createFavoritesAd(pAdId);
    } 
    public void createAdComment(){
        int sonuc = 0;
        Ad_CommentsBean ac = new Ad_CommentsBean();
        sonuc = ac.createAdComment(this.pAdId,this.AdComment );        
        if(sonuc == 1){this.AdComment = null;}     
    }
   public void setLocationToGMAP(){
        String markers ="[ ";
        String markersEnd ="";
        int isSayisi = 0;
        for (AdRouteBean a : locationInfoFromMap.getLocationList()) {
            SimpleDateFormat DtFrm = new SimpleDateFormat("HH:mm");
            String stTime= DtFrm.format(a.getAdRoute_StartTime());
            String enTime= DtFrm.format(a.getAdRoute_EndTime());
            String spNeighborhood = a.getAdRoute_StartPosition_Neighborhood() ==null ? "":a.getAdRoute_StartPosition_Neighborhood()+"-";
            String epNeighborhood =  a.getAdRoute_EndPosition_Neighborhood() ==null ? "":a.getAdRoute_EndPosition_Neighborhood()+"-";
            isSayisi = isSayisi+1;
               markers = markers+"{ iconResim:'/resources/img/kırmızı_pin.png' , addressx:'"+a.getAdRoute_StartPosition_Neighborhood()+
                              ", "+a.getAdRoute_StartPosition_Town()+
                              ", "+a.getAdRoute_StartPosition_City()+
                              "', p_content:'<b>Aracım Var Hostes Arıyorum</b><br><p>"+isSayisi+".İş - Aracın boş olduğu yer: </br></br>Başlangıç noktası : "+stTime+" "+spNeighborhood+a.getAdRoute_StartPosition_Town()+"-"+a.getAdRoute_StartPosition_City()+"</p>' },";
            
            markersEnd = markersEnd+"{ iconResim:'/resources/img/turuncu_pin.png' ,  addressx:'"+a.getAdRoute_EndPosition_Neighborhood()+
                              ", "+a.getAdRoute_EndPosition_Town()+
                              ", "+a.getAdRoute_EndPosition_City()+
                              "', p_content:'<b>Aracım Var Hostes Arıyorum</b><br><p>"+isSayisi+".İş - Aracın boş olduğu yer: </br></br>Bitiş noktası : "+enTime+" "+epNeighborhood+a.getAdRoute_EndPosition_Town()+"-"+a.getAdRoute_EndPosition_City()+"</p>' },";
        
        }
        markers = markers+markersEnd+" ]";
        this.googleMapMarkers= markers;       
    }
}
