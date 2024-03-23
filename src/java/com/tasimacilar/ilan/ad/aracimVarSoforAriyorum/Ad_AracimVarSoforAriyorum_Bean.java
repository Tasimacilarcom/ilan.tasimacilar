package com.tasimacilar.ilan.ad.aracimVarSoforAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.profile.account.*;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.map.LocationInfoFromMap;
import com.tasimacilar.ilan.vehicle.*;
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
@ManagedBean(name = "adAracimVarSoforAriyorumBean")
@ViewScoped
public class Ad_AracimVarSoforAriyorum_Bean implements Serializable{ 
    private Ad_AracimVarSoforAriyorum   ad_AracimVarSoforAriyorum;
    private AccountBean                 accountBean;  
    private CorporateAccountBean        corporateAccountBean;
    private String                      aId;                // kullanıcı id
    private String                      param1;
    private int                         VehicleBrandId;
    private List<String>                vehicleModelsList = new ArrayList<String>(); 
    private String                      pAdId = null;    
    private String                      AdComment = null;
    private List<Ad_CommentsBean>       adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                      adIdx;       // ilan id
    private String                      googleMapMarkers;   
    private Vehicle                     vehicle;                     // araç bilgileri
    private String                      selectedVehicle;
    private UIInput                     inputBox;
    private UIInput                     inputBox2;
    private List<Ad_Bean>               adList;
    @ManagedProperty(value="#{locationInfoFromMap}")
    private LocationInfoFromMap locationInfoFromMap;
    public LocationInfoFromMap getLocationInfoFromMap() { return locationInfoFromMap;}
    public void setLocationInfoFromMap(LocationInfoFromMap locationInfoFromMap) {  this.locationInfoFromMap = locationInfoFromMap;}
    @PostConstruct
    public void init() {   
        vehicle = new Vehicle();
        Ad_Bean ax = new Ad_Bean();
        adList = new ArrayList<Ad_Bean>();
        ad_AracimVarSoforAriyorum = new Ad_AracimVarSoforAriyorum();
        ad_AracimVarSoforAriyorum.setAdBean(ax);
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
        try {String url = req.getRequestURL().toString();
            URL urlx = new URL(url);          
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-sofor-ariyorum")  ){               
                if (param1.equals("ekle")) {                   
                    adIdx = UniqueId.RandomString(12);
                    String vcIdx = UniqueId.RandomString(12);                  
                    ad_AracimVarSoforAriyorum.getAdBean().setAd_Id(adIdx);
                }
            }
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("duzenle") ||
                FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-sofor-ariyorum") ){               
                if(param1!= null && !param1.equals("")){
                    if (param1.equals("duzenle")) {}
                }                
            }          
            if(pAdId != null && !pAdId.equals("")){            
                getAdFullDetailWithAdId(pAdId);               
                if(this.ad_AracimVarSoforAriyorum != null && this.ad_AracimVarSoforAriyorum.getVehicleSelection() != null){ 
                    if(this.ad_AracimVarSoforAriyorum.getVehicleSelection().equals("oldVehicle")){
                        aracSecildi();
                    }
                }
            }
            
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }    
    }
    public Ad_AracimVarSoforAriyorum_Bean() { }
	public Ad_AracimVarSoforAriyorum getAd_AracimVarSoforAriyorum() { return ad_AracimVarSoforAriyorum;  }
    public void setAd_AracimVarSoforAriyorum(Ad_AracimVarSoforAriyorum ad_AracimVarSoforAriyorum) { this.ad_AracimVarSoforAriyorum = ad_AracimVarSoforAriyorum;   }
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}    
    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    public String getAId() { return aId;}
    public void setAId(String aId) { this.aId = aId;}
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public int getVehicleBrandId() { return VehicleBrandId;}
    public void setVehicleBrandId(int VehicleBrandId) {this.VehicleBrandId = VehicleBrandId;}
    public List<String> getVehicleModelsList() {return vehicleModelsList;}
    public void setVehicleModelsList(List<String> vehicleModelsList) { this.vehicleModelsList = vehicleModelsList;}  
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}   
    public String getGoogleMapMarkers() {return googleMapMarkers; }
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public Vehicle getVehicle() { return vehicle;}
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle;}
    public String getSelectedVehicle() {return selectedVehicle;}
    public void setSelectedVehicle(String selectedVehicle) { this.selectedVehicle = selectedVehicle;}
    public UIInput getInputBox() {return inputBox; }
    public void setInputBox(UIInput inputBox) {this.inputBox = inputBox; }
    public UIInput getInputBox2() { return inputBox2;}
    public void setInputBox2(UIInput inputBox2) {this.inputBox2 = inputBox2; }
    public List<Ad_Bean> getAdList() { return adList;  }
    public void setAdList(List<Ad_Bean> adList) {  this.adList = adList;  }
    public void preRenderInput() {
        if(this.ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_NumberOfPassengers()==0){inputBox.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox.setValue("");
            }
        }    
    }
    public void preRenderInput2() {
        if(this.ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_Cost()==0){inputBox2.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox2.setValue("");
            }
        }
    }
    public void createLookingForVehicleForWorkAd() {        
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(ad_AracimVarSoforAriyorum.getAdBean().getAd_Id());           
        adb.setAd_Category_Id(3);                               
        adb.setAd_Title("");     
        adb.setAd_Comment(ad_AracimVarSoforAriyorum.getAdBean().getAd_Comment()); 
        adb.setAd_Type(AdUtils.getAdTyp(aId)); 
        adb.setAd_OvnerAccountId(AdUtils.getOvnerAccountId(aId));   
        adb.setAd_IsActive(true);   
        adb.setAd_EndTime(ExpiryDates.AdExpiryDate(7));       
        adb.setAd_Notes(null);                          
        adb.setAd_CreateTime(new Date());                       
        adb.setAd_CreatedIp(GetUserEnvironment.getInternetIp());            
        adb.setAd_CreatedAccountId(SessionUtil.getUserId()); 
        ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_Id(UniqueId.RandomString(12));      
        if(ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes() != null && ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes().length > 0){
            String ServiceTypesx = "";
            for (String dl : ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes()) { ServiceTypesx = ServiceTypesx + ',' + dl.toString();  };
            ServiceTypesx.substring(1); 
            ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_ServiceType(ServiceTypesx);
        }       
        if(ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages() != null && ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_ForeignLanguage(ForeignLanguagesx);
        }        
        ad_AracimVarSoforAriyorum.setAd_Id(ad_AracimVarSoforAriyorum.getAdBean().getAd_Id());
        ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_vehicle_Id(this.vehicle.getVehicle_Id());
        ad_AracimVarSoforAriyorum.setAdBean(adb);     
        Ad_AracimVarSoforAriyorum_Dao a = new Ad_AracimVarSoforAriyorum_Dao();                 
        Ad_AracimVarSoforAriyorum_Bean adsax = new Ad_AracimVarSoforAriyorum_Bean();
        adsax.setAd_AracimVarSoforAriyorum(ad_AracimVarSoforAriyorum);       
        int sonuc = 0;
        if(this.ad_AracimVarSoforAriyorum.getVehicleSelection().equals("oldVehicle")){         
            if(this.vehicle.getVehicle_Id() != null && !this.vehicle.getVehicle_Id().equals("")){
                if(locationInfoFromMap.getLocationList().size()>0){
                    sonuc = a.createAracimVarSoforAriyorumAd(adsax);
                    if(sonuc == 1){ 
                        if(SessionUtil.getUserType().equals("director")){ UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=aracim-var-sofor-ariyorum&aId="+this.aId+"&adId="+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()); }
                        else{ UrlRedirect.redirect("/ad/sonuc/aracim-var-sofor-ariyorum/"+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()); }
                    }else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu");}
                }else{ Messages.dynMsg(null, "error", "Lütfen güzergah bilgisi giriniz"); }
            } else{ Messages.dynMsg(null, "error", "Lütfen araç seçiniz veya yeni ekleyiniz"); } 
        } else if(this.ad_AracimVarSoforAriyorum.getVehicleSelection().equals("newVehicle")){           
            if(locationInfoFromMap.getLocationList().size()>0){
                sonuc = a.createAracimVarSoforAriyorumAd(adsax);
                if(sonuc == 1){ 
                    if(SessionUtil.getUserType().equals("director")){ UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=aracim-var-sofor-ariyorum&aId="+this.aId+"&adId="+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()); }
                    else{ UrlRedirect.redirect("/ad/sonuc/aracim-var-sofor-ariyorum/"+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()); }
                }else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu");}
            }else{ Messages.dynMsg(null, "error", "Lütfen güzergah bilgisi giriniz"); 
        }    
       } else{ Messages.dynMsg(null, "error", "Lütfen araç bilgisi seçiniz");}
   }
    public void updateLookingForVehicleForWorkAd() { 
        Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(ad_AracimVarSoforAriyorum.getAdBean().getAd_Id());                                        
        adb.setAd_Title("");     
        adb.setAd_Comment(ad_AracimVarSoforAriyorum.getAdBean().getAd_Comment());                          
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());
        if(ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes() != null && ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes().length > 0){
            String ServiceTypesx = "";
            for (String dl : ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ServiceTypes()) { ServiceTypesx = ServiceTypesx + ',' + dl.toString();  };
            ServiceTypesx.substring(1); 
            ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_ServiceType(ServiceTypesx);
        }        
        if(ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages() != null && ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages().length > 0){
            String ForeignLanguagesx = "";
            for (String dl : ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_ForeignLanguages()) { ForeignLanguagesx = ForeignLanguagesx + ',' + dl.toString();  };
            ForeignLanguagesx.substring(1); 
            ad_AracimVarSoforAriyorum.setAd_AracimVarSoforAriyorum_ForeignLanguage(ForeignLanguagesx);
        }      
        int sonuc = 0;
        if(locationInfoFromMap.getLocationList().size()>0){
            Ad_AracimVarSoforAriyorum_Bean adsaxxx = new Ad_AracimVarSoforAriyorum_Bean();
            adsaxxx.setAd_AracimVarSoforAriyorum(ad_AracimVarSoforAriyorum);
            Ad_AracimVarSoforAriyorum_Dao a = new Ad_AracimVarSoforAriyorum_Dao();
            sonuc = a.updateAracimVarSoforAriyorumAd(adsaxxx);
            if(sonuc == 1){ 
                if(SessionUtil.getUserType().equals("director")){
                    UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=aracim-var-sofor-ariyorum&aId="+this.aId+"&adId="+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id());
                }else{ UrlRedirect.redirect("/ad/sonuc2/aracim-var-sofor-ariyorum/"+ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()); }
            }else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu");}
        }else{ Messages.dynMsg(null, "error", "Lütfen güzergah bilgisi giriniz"); }              
   }    
    public void getAdFullDetailWithAdId(String adId)       
        if(adId != null){
            if(!adId.equals("")){           
                Ad_AracimVarSoforAriyorum_Dao ad = new Ad_AracimVarSoforAriyorum_Dao();
                this.ad_AracimVarSoforAriyorum = ad.getAracimVarSoforAriyorumWithAdId(adId).getAd_AracimVarSoforAriyorum();
             if(this.ad_AracimVarSoforAriyorum.getVehicleSelection().equals("oldVehicle")){
                    VehicleDao vdo = new VehicleDao();
                    this.setVehicle(vdo.getVehicleWithAdId(this.ad_AracimVarSoforAriyorum.getAd_AracimVarSoforAriyorum_vehicle_Id()).getVehicle());
                }
                if(this.ad_AracimVarSoforAriyorum.getVehicleSelection().equals("newVehicle")){
                    VehicleBrandAndModelBean vb = new VehicleBrandAndModelBean();
                    VehicleBrandAndModelDao bbd = new VehicleBrandAndModelDao();
                    vb = bbd.getVehicleBrandWithId(Integer.parseInt(this.ad_AracimVarSoforAriyorum.getFast_vehicle_BrandId()));
                    this.ad_AracimVarSoforAriyorum.setFast_vehicle_BrandName(vb.getVehicleBrand_Name());
                    
                    VehicleBrandAndModelDao vx = new VehicleBrandAndModelDao();
                    this.vehicleModelsList = vx.getAllVehicleModels(Integer.parseInt( this.ad_AracimVarSoforAriyorum.getFast_vehicle_BrandId()));
            
                }
                AdRouteDao a = new AdRouteDao();
                locationInfoFromMap.setLocationList(a.getAllAdRouteWithAdId(ad_AracimVarSoforAriyorum.getAdBean().getAd_Id()));
                setLocationToGMAP();
				AccountBean acb = new AccountBean();
                acb.setAccount_Id(ad_AracimVarSoforAriyorum.getAdBean().getAd_OvnerAccountId());
                PersonalAccountBean pab = new PersonalAccountBean();
                pab.setAccountBean(acb);
                AccountDao ado = new AccountDao();
                this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
				CorporateAccountDao cod = new CorporateAccountDao();
                if(this.accountBean != null){this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());}
                Ad_CommentsDao adxx = new Ad_CommentsDao();
                this.adCommentsList = adxx.getAllCommentWithItemId(ad_AracimVarSoforAriyorum.getAdBean().getAd_Id());
                Ad_Dao adda = new Ad_Dao();
                this.adList = adda.getUserTopTenAdWithPublish(ad_AracimVarSoforAriyorum.getAdBean().getAd_OvnerAccountId());             
            }else{System.out.println(":::HATA:::ilan id gecersiz");}
        }else{System.out.println(":::HATA:::ilan id gecersiz");}  
    }
    public List<VehicleBrandAndModelBean> vehicleBrandNamesListx(){   
        VehicleBrandAndModelDao v= new VehicleBrandAndModelDao(); 
        return v.getAllVehicleBrand(); 
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
               markers = markers+"{ iconResim:'/resources/img/kırmızı_pin.png' ,  addressx:'"+a.getAdRoute_StartPosition_Neighborhood()+
                              ", "+a.getAdRoute_StartPosition_Town()+
                              ", "+a.getAdRoute_StartPosition_City()+
                              "', p_content:'<b>Aracım Var Şöför Arıyorum</b><br><p>"+isSayisi+".İş - Aracın boş olduğu yer: </br></br>Başlangıç noktası : "+stTime+" "+spNeighborhood+a.getAdRoute_StartPosition_Town()+"-"+a.getAdRoute_StartPosition_City()+"</p>' },";
            
            markersEnd = markersEnd+"{  iconResim:'/resources/img/turuncu_pin.png' , addressx:'"+a.getAdRoute_EndPosition_Neighborhood()+
                              ", "+a.getAdRoute_EndPosition_Town()+
                              ", "+a.getAdRoute_EndPosition_City()+
                              "', p_content:'<b>Aracım Var Şöför Arıyorum</b><br><p>"+isSayisi+".İş - Aracın boş olduğu yer: </br></br>Bitiş noktası : "+enTime+" "+epNeighborhood+a.getAdRoute_EndPosition_Town()+"-"+a.getAdRoute_EndPosition_City()+"</p>' },";
        
        }
        markers = markers+markersEnd+" ]";
        this.googleMapMarkers= markers;     
    }
public void aracSecildi(){
        VehicleDao vd = new VehicleDao();
        VehicleBean v = new VehicleBean();
        v = vd.getVehicleWithAdId(vehicle.getVehicle_Id());
        selectedVehicle = String.valueOf(v.getVehicle().getVehicle_PlateProvinceCode())+" "+v.getVehicle().getVehicle_PlateLatterCode().toUpperCase()+" "+String.valueOf(v.getVehicle().getVehicle_PlateNumberCode());
    }
public void vehicleModelsListx() { 
        VehicleBrandAndModelDao v = new VehicleBrandAndModelDao();
        this.vehicleModelsList = v.getAllVehicleModels(Integer.parseInt(getAd_AracimVarSoforAriyorum().getFast_vehicle_BrandId()));
    }}
