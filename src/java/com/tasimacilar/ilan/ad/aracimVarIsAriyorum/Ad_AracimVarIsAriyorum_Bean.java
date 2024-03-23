package com.tasimacilar.ilan.ad.aracimVarIsAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.profile.account.*;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.*;
import com.tasimacilar.ilan.profile.account.personal.*;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.map.LocationInfoFromMap;
import com.tasimacilar.ilan.vehicle.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "adAracimVarIsAriyorumBean")
@ViewScoped
public class Ad_AracimVarIsAriyorum_Bean implements Serializable{
    private Ad_AracimVarIsAriyorum  adAracimVarIsAriyorum;
    private Ad_Bean                 adBean;
    private Vehicle                 vehicle;                     
    private String                  param1;
    private String                  aId; 
    public  String                  pAdId = null;
    private String                  AdComment = null;
    private List<Ad_CommentsBean>   adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                  googleMapMarkers;
    private String                  selectedVehicle;
    private List<Ad_Bean>           adList;
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
        adAracimVarIsAriyorum = new Ad_AracimVarIsAriyorum();
        adBean = new Ad_Bean();
        vehicle = new Vehicle();
        adList = new ArrayList<Ad_Bean>();       
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1");    
        pAdId = req.getParameter("adId");       
        aId = req.getParameter("aId");                
        if(req.getParameter("vId") != null){
          if(!req.getParameter("vId").equals("")){
              vehicle.setVehicle_Id(req.getParameter("vId"));
              aracSecildi();
          }  
        }       
        try {
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-is-ariyorum")    ){ 
                if (param1.equals("ekle")) {
                    this.adBean.setAd_Id(UniqueId.RandomString(12));            
                }
            }          
            if(pAdId != null && !pAdId.equals("")){       
               getAdFullDetailWithAdId(pAdId);
               aracSecildi();
            } 
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }        
    }
    public Ad_AracimVarIsAriyorum_Bean() { }
    public Ad_AracimVarIsAriyorum getAdAracimVarIsAriyorum() { return adAracimVarIsAriyorum;}
    public void setAdAracimVarIsAriyorum(Ad_AracimVarIsAriyorum adAracimVarIsAriyorum) {this.adAracimVarIsAriyorum = adAracimVarIsAriyorum;}
    public Ad_Bean getAdBean() { return adBean;  }
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;  }
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() {return aId;}
    public void setaId(String aId) { this.aId = aId;}
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() { return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public String getGoogleMapMarkers() {return googleMapMarkers; }
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public Vehicle getVehicle() {return vehicle;}
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle;}
    public String getSelectedVehicle() {return selectedVehicle;}
    public void setSelectedVehicle(String selectedVehicle) {this.selectedVehicle = selectedVehicle;}
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }
    public void createadAracimVarIsAriyorumAd() { 
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(this.adBean.getAd_Id());           
        adb.setAd_Category_Id(2);                               
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
        Ad_AracimVarIsAriyorum_Bean adl = new Ad_AracimVarIsAriyorum_Bean();
        adl.adAracimVarIsAriyorum = this.adAracimVarIsAriyorum;
        adl.adAracimVarIsAriyorum.setAd_AracimVarIsAriyorum_Id(UniqueId.RandomString(12));
        adl.setVehicle(this.vehicle);
        adl.setAdBean(adb);     
        if(this.vehicle.getVehicle_Id() != null && !this.vehicle.getVehicle_Id().equals("")){
            if(locationInfoFromMap.getLocationList().size()>0){
                int sonuc = 0;
                Ad_AracimVarIsAriyorum_Dao a = new Ad_AracimVarIsAriyorum_Dao();
               sonuc = a.createAracimVarIsAriyorumAd(adl);
                if(sonuc == 1){                   
                    if(SessionUtil.getUserType().equals("director")){
                        UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=aracim-var-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
                    }else{ UrlRedirect.redirect("/ad/sonuc/aracim-var-is-ariyorum/"+this.adBean.getAd_Id()); }
                }else{  Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }
            }else{  Messages.dynMsg(null, "error", "Konum bilgisi girilmedi,lütfen konum bilgisi giriniz ");}
        }else{ Messages.dynMsg(null, "error", "Lütfen araç seçiniz veya yeni ekleyiniz");}      
   }
    public void updateAracimVarIsAriyorumAd() { 
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(this.adBean.getAd_Id());           
        adb.setAd_Category_Id(2);                               
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());                          
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());
        Ad_AracimVarIsAriyorum_Bean adl = new Ad_AracimVarIsAriyorum_Bean();
        adl.adAracimVarIsAriyorum = this.adAracimVarIsAriyorum;
        adl.setVehicle(this.vehicle);
        adl.setAdBean(adb);  
       if(this.vehicle.getVehicle_Id() != null && !this.vehicle.getVehicle_Id().equals("")){
            if(locationInfoFromMap.getLocationList().size()>0){       
                int sonuc = 0;
                Ad_AracimVarIsAriyorum_Dao a = new Ad_AracimVarIsAriyorum_Dao();
                sonuc = a.updateAracimVarIsAriyorumAd(adl);
                
                if(sonuc == 1){
                    if(SessionUtil.getUserType().equals("director")){
                        UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=aracim-var-is-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
                    }else{ UrlRedirect.redirect("/ad/sonuc2/aracim-var-is-ariyorum/"+this.adBean.getAd_Id()); }
                }else{  Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }    
         }else{  Messages.dynMsg(null, "error", "Konum bilgisi girilmedi,lütfen konum bilgisi giriniz ");}
        }else{ Messages.dynMsg(null, "error", "Lütfen araç seçiniz veya yeni ekleyiniz");}   
    }
    public void getAdFullDetailWithAdId(String adId) {       
        Ad_AracimVarIsAriyorum_Bean al = new Ad_AracimVarIsAriyorum_Bean();
        Ad_AracimVarIsAriyorum_Dao ad = new Ad_AracimVarIsAriyorum_Dao();
        al = ad.getAracimVarIsAriyorumWithAdId(adId);
        this.adAracimVarIsAriyorum = al.getAdAracimVarIsAriyorum();      
        VehicleDao vdo = new VehicleDao();
        this.setVehicle(vdo.getVehicleWithAdId(al.getVehicle().getVehicle_Id()).getVehicle());
        this.adBean.setAd_Id(al.adBean.getAd_Id());
        this.adBean.setAd_Id2(al.adBean.getAd_Id2());
        this.adBean.setAd_Category_Id(al.adBean.getAd_Category_Id());
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
    public List<VehicleBrandAndModelBean> vehicleBrandNamesListx(){  
        VehicleBrandAndModelDao v= new VehicleBrandAndModelDao();
        return v.getAllVehicleBrand(); 
    }  
   public void setLocationToGMAP(){    
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
                              "', p_content:'<b>Aracım Var İş Arıyorum</b><br><p>"+isSayisi+".İş - Aracın boş olduğu yer<br/><br/> Saat: "+stTime+" - "+enTime+" <br/>Yer : "+a.getAdRoute_StartPosition_Neighborhood()+" - "+a.getAdRoute_StartPosition_Town()+" - "+a.getAdRoute_StartPosition_City()+"</p>' },";
        }
        markers = markers+" ]";
        this.googleMapMarkers= markers;    
    }
    public void aracSecildi(){
        VehicleDao vd = new VehicleDao();
        VehicleBean v = new VehicleBean();
        if (vehicle.getVehicle_Id() != null) {
            v = vd.getVehicleWithAdId(vehicle.getVehicle_Id());
            selectedVehicle = String.valueOf(v.getVehicle().getVehicle_PlateProvinceCode()) + " " + v.getVehicle().getVehicle_PlateLatterCode().toUpperCase() + " " + String.valueOf(v.getVehicle().getVehicle_PlateNumberCode());
        }
    }   
}
