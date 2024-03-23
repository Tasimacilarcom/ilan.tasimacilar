package com.tasimacilar.ilan.ad.isimvarAracAriyorum;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.profile.account.*;
import com.tasimacilar.ilan.profile.account.corporate.*;
import com.tasimacilar.ilan.profile.account.personal.*;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.map.LocationInfoFromMap;
import com.tasimacilar.ilan.vehicle.*;
import java.io.Serializable;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "adLookingForVehicleForWorkBean")
@ViewScoped
public class Ad_IsimVarAracAriyorum_Bean implements Serializable{
    private Ad_IsimVarAracAriyorum  adIsimVarAracAriyorum;
    private Ad_Bean                 adBean;
    private Vehicle                 vehicle;
    private String                  param1;
    private String                  aId;
    private int                     VehicleBrandId;
    private int                     VehicleBrandsLength;
    private List<String>            vehicleModelsList = new ArrayList<String>(); 
    private String                  pAdId = null;
    private String                  AdComment = null;
    private List<Ad_CommentsBean>   adCommentsList = new ArrayList<Ad_CommentsBean>();
    private String                  adIdx;       // ilan id
    private String                  googleMapMarkers;
    private UIInput                 inputBox;
    private UIInput                 inputBox2;
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
        adIsimVarAracAriyorum = new Ad_IsimVarAracAriyorum();
        adBean = new Ad_Bean();       
        vehicle = new Vehicle();
        adList = new ArrayList<Ad_Bean>();      
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1");   
        pAdId = req.getParameter("adId");       
        aId = req.getParameter("aId");          
        try {String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
                FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_isim-var-arac-ariyorum") ){              
                if(param1!= null && !param1.equals("")){
                    if (param1.equals("ekle")) {
                        adIdx = UniqueId.RandomString(12);
                        adBean.setAd_Id(adIdx);                 
                    }
                }                
            }
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("duzenle") ||
                FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_isim-var-arac-ariyorum") ){               
                if(param1!= null && !param1.equals("")){
                    if (param1.equals("duzenle")) { } }   }         
            if(pAdId != null && !pAdId.equals("")){
               getAdFullDetailWithAdId(pAdId);           
            }
            
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }   
    }
    public Ad_IsimVarAracAriyorum_Bean() {  }
    public Ad_IsimVarAracAriyorum getAdIsimVarAracAriyorum() {return adIsimVarAracAriyorum;}
    public void setAdIsimVarAracAriyorum(Ad_IsimVarAracAriyorum adIsimVarAracAriyorum) {this.adIsimVarAracAriyorum = adIsimVarAracAriyorum;}
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}   
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() { return aId;}
    public void setaId(String aId) { this.aId = aId;}   
    public List<String> getVehicleModelsList() { return vehicleModelsList;   }
    public void setVehicleModelsList(List<String> vehicleModelsList) {  this.vehicleModelsList = vehicleModelsList;}
    public int getVehicleBrandId() { return VehicleBrandId;}
    public void setVehicleBrandId(int VehicleBrandId) {this.VehicleBrandId = VehicleBrandId;}
    public int getVehicleBrandsLength() { return VehicleBrandsLength;}
    public void setVehicleBrandsLength(int VehicleBrandsLength) { this.VehicleBrandsLength = VehicleBrandsLength;}
    public String getAdComment() { return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public String getGoogleMapMarkers() { return googleMapMarkers;}
    public void setGoogleMapMarkers(String googleMapMarkers) { this.googleMapMarkers = googleMapMarkers;}
    public Vehicle getVehicle() {return vehicle;}
    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}
    public UIInput getInputBox() {return inputBox; }
    public void setInputBox(UIInput inputBox) { this.inputBox = inputBox;  }
    public UIInput getInputBox2() {return inputBox2;  }
    public void setInputBox2(UIInput inputBox2) { this.inputBox2 = inputBox2;}
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }
    public void preRenderInput2() {
        if(this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_Cost()==0){
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox2.setValue("");
            }
        }
    }public void createLookingForVehicleForWorkAd() {   Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(adBean.getAd_Id());           
        adb.setAd_Category_Id(1);                               
        adb.setAd_Title("");     
        adb.setAd_Comment(adBean.getAd_Comment());  
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
        adb.setAd_OvnerAccountId(AdUtils.getOvnerAccountId(aId));if(vehicle.getVehicle_Types() != null && vehicle.getVehicle_Types().length > 0){ 
            String VehicleTypesx = "";
            for (String dl : vehicle.getVehicle_Types()) { VehicleTypesx = VehicleTypesx+ ',' + dl.toString();  };
            VehicleTypesx.substring(1); 
            vehicle.setVehicle_Typ(VehicleTypesx);
        }
        if(vehicle.getVehicle_Brands() != null && vehicle.getVehicle_Brands().length > 0){ 
            String VehicleBrandsx = "";
            for (String dl : vehicle.getVehicle_Brands()) { VehicleBrandsx = VehicleBrandsx + ',' + dl.toString();  };
            VehicleBrandsx.substring(1); 
            vehicle.setVehicle_Brand(VehicleBrandsx);
        }   
        if(vehicle.getVehicle_Brands()[0].equals("0")){ vehicle.setVehicle_BrandNotMatter(true);}
        if(vehicle.getVehicle_ModelYear().equals(0)){vehicle.setVehicle_ModelYearNotMatter(true);}
        switch (vehicle.getVehicle_NumberOfSeats()) {
          case "4+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "5+1": vehicle.setVehicle_Typ("Otomobil"); break;
          case "6+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "7+1": vehicle.setVehicle_Typ("Otomobil"); break;
          case "8+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "9+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "10+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "11+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "12+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "13+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "14+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "15+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "16+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "17+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "18+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "19+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "20+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "21+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "22+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "23+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "24+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "25+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "26+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "27+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "28+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "29+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "30+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "31+1": vehicle.setVehicle_Typ("Midibüs"); break;
          default: vehicle.setVehicle_Typ("Otobüs");
        }Ad_IsimVarAracAriyorum_Bean adl = new Ad_IsimVarAracAriyorum_Bean(); 
        adl.adIsimVarAracAriyorum = this.adIsimVarAracAriyorum;
        adl.adIsimVarAracAriyorum.setAd_LookingForVehicleForWork_Id(UniqueId.RandomString(12));
        if(this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes() != null && this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes().length > 0){
            String ServiceTypesx = "";
            for (String dl : this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes()) { ServiceTypesx = ServiceTypesx + ',' + dl.toString();  };
            ServiceTypesx.substring(1); 
            adl.adIsimVarAracAriyorum.setAd_LookingForVehicleForWork_ServiceType(ServiceTypesx);
        } adl.setVehicle(vehicle);
        adl.setAdBean(adb); int sonuc = 0; if(vehicle.isVehicle_BrandNotMatter() == false){
            if(vehicle.getVehicle_Brand() != null && !vehicle.getVehicle_Brand().equals("") ){
                if(locationInfoFromMap.getLocationList().size()>0){
                    Ad_IsimVarAracAriyorum_Dao a = new Ad_IsimVarAracAriyorum_Dao();
                    sonuc = a.createLookingForVehicleForWorkAd(adl);
                    if(sonuc==1){ if(SessionUtil.getUserType().equals("director")){  UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=isim-var-arac-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                        else{ UrlRedirect.redirect( "/ad/sonuc/isim-var-arac-ariyorum/"+this.adBean.getAd_Id() ); }
                    } else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }
                }else{  Messages.dynMsg(null, "error", "Güzergah bilgisi girilmedi, lütfen güzergah bilgisi giriniz."); }
            } else{   Messages.dynMsg(null, "error", "Araç markası seçilmedi, lütfen arac markası seçin."); }
        } else{
            if(locationInfoFromMap.getLocationList().size()>0){
                Ad_IsimVarAracAriyorum_Dao a = new Ad_IsimVarAracAriyorum_Dao();
                sonuc = a.createLookingForVehicleForWorkAd(adl);
                if(sonuc==1){ if(SessionUtil.getUserType().equals("director")){  UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=isim-var-arac-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                        else{ UrlRedirect.redirect( "/ad/sonuc/isim-var-arac-ariyorum/"+this.adBean.getAd_Id() ); }
                } else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }
            } else{  Messages.dynMsg(null, "error", "Güzergah bilgisi girilmedi, lütfen güzergah bilgisi giriniz."); }
        } 
   }
    public void updateLookingForVehicleForWorkAd() {  Ad_Bean adb = new Ad_Bean();                            
        adb.setAd_Id(this.pAdId);                                         
        adb.setAd_Title("");     
        adb.setAd_Comment(this.adBean.getAd_Comment());         
        adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
        adb.setAd_LastModifyTime(new Date());
        adb.setAd_LastChangerAccountId(SessionUtil.getUserId());if(vehicle.getVehicle_Types() != null && vehicle.getVehicle_Types().length > 0){
            String VehicleTypesx = "";
            for (String dl : vehicle.getVehicle_Types()) { VehicleTypesx = VehicleTypesx+ ',' + dl.toString();  };
            VehicleTypesx.substring(1); 
            vehicle.setVehicle_Typ(VehicleTypesx);
        }
        if(vehicle.getVehicle_Brands() != null && vehicle.getVehicle_Brands().length > 0){
            String VehicleBrandsx = "";
            for (String dl : vehicle.getVehicle_Brands()) { VehicleBrandsx = VehicleBrandsx + ',' + dl.toString();  };
            VehicleBrandsx.substring(1); 
            vehicle.setVehicle_Brand(VehicleBrandsx);
        } switch (vehicle.getVehicle_NumberOfSeats()) {
          case "4+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "5+1": vehicle.setVehicle_Typ("Otomobil"); break;
          case "6+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "7+1": vehicle.setVehicle_Typ("Otomobil"); break;
          case "8+1": vehicle.setVehicle_Typ("Otomobil"); break;    case "9+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "10+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "11+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "12+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "13+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "14+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "15+1": vehicle.setVehicle_Typ("Minibüs"); break;
          case "16+1": vehicle.setVehicle_Typ("Minibüs"); break;    case "17+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "18+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "19+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "20+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "21+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "22+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "23+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "24+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "25+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "26+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "27+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "28+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "29+1": vehicle.setVehicle_Typ("Midibüs"); break;
          case "30+1": vehicle.setVehicle_Typ("Midibüs"); break;    case "31+1": vehicle.setVehicle_Typ("Midibüs"); break;
          default: vehicle.setVehicle_Typ("Otobüs");
        } Ad_IsimVarAracAriyorum_Bean adl = new Ad_IsimVarAracAriyorum_Bean();   
        adl.adIsimVarAracAriyorum = this.adIsimVarAracAriyorum;
         if(this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes() != null && this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes().length > 0){
            String ServiceTypesx = "";
            for (String dl : this.adIsimVarAracAriyorum.getAd_LookingForVehicleForWork_ServiceTypes()) { ServiceTypesx = ServiceTypesx + ',' + dl.toString();  };
            ServiceTypesx.substring(1); 
            adl.adIsimVarAracAriyorum.setAd_LookingForVehicleForWork_ServiceType(ServiceTypesx);
        }adl.setVehicle(vehicle);
        adl.setAdBean(adb);
        int sonuc = 0;
        Ad_IsimVarAracAriyorum_Dao a = new Ad_IsimVarAracAriyorum_Dao();
        sonuc = a.updateLookingForVehicleForWorkAd(adl);     
        if(sonuc==1){ if(SessionUtil.getUserType().equals("director")){
                UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=isim-var-arac-ariyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
            }  else{ UrlRedirect.redirect("/ad/sonuc2/isim-var-arac-ariyorum/"+this.adBean.getAd_Id()); }           
        } else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu"); }
   }  public void getAdFullDetailWithAdId(String adId) { 
        Ad_IsimVarAracAriyorum_Bean al = new Ad_IsimVarAracAriyorum_Bean();
        Ad_IsimVarAracAriyorum_Dao ad = new Ad_IsimVarAracAriyorum_Dao();
        al = ad.getLookingForVehicleForWorkAdWithAdId(adId);this.adIsimVarAracAriyorum = al.getAdIsimVarAracAriyorum();    
        if(al.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceType() != null){
            String ServiceTypexx = al.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceType().substring(1);
            String[] ServiceTypexxx = ServiceTypexx.split(",");     
            this.adIsimVarAracAriyorum.setAd_LookingForVehicleForWork_ServiceTypes(ServiceTypexxx);
        }
        this.adBean = al.adBean;
        this.vehicle = al.vehicle;    
        this.VehicleBrandsLength = al.vehicle.getVehicle_Brands().length;  
        if(this.VehicleBrandsLength ==1 ){ 
            VehicleBrandAndModelDao v= new VehicleBrandAndModelDao();
            this.vehicleModelsList = v.getAllVehicleModels(Integer.parseInt(vehicle.getVehicle_Brands()[0])); 
        }  
        AdRouteDao a = new AdRouteDao();
        locationInfoFromMap.setLocationList(a.getAllAdRouteWithAdId(this.adBean.getAd_Id()));
        setLocationToGMAP(); AccountBean acb = new AccountBean();
        acb.setAccount_Id(al.adBean.getAd_OvnerAccountId());      
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(acb);       
        AccountDao ado = new AccountDao();
        this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
        CorporateAccountDao cod = new CorporateAccountDao();
        if(this.accountBean != null){ this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());}
        Ad_CommentsDao adxx = new Ad_CommentsDao();
        this.adCommentsList = adxx.getAllCommentWithItemId(this.adBean.getAd_Id());              
        Ad_Dao adda = new Ad_Dao();
        this.adList = adda.getUserTopTenAdWithPublish(al.adBean.getAd_OvnerAccountId());     
    }    public List<VehicleBrandAndModelBean> vehicleBrandNamesListx(){ 
        VehicleBrandAndModelDao v= new VehicleBrandAndModelDao();     
        return v.getAllVehicleBrand();  }  public void vehicleModelsListx(){ 
        VehicleBrandAndModelDao vd = new VehicleBrandAndModelDao();      
        this.setVehicleBrandsLength(vehicle.getVehicle_Brands().length);    
        if(this.VehicleBrandsLength ==1 ){   VehicleBrandAndModelDao v= new VehicleBrandAndModelDao();
            this.vehicleModelsList = v.getAllVehicleModels(Integer.parseInt(vehicle.getVehicle_Brands()[0]));       
            if(vehicle.isVehicle_BrandNotMatter()){vehicle.setVehicle_Brand("Farketmez");}
            else{vehicle.setVehicle_Brand(vd.getVehicleBrandWithId(Integer.parseInt(vehicle.getVehicle_Brands()[0])).getVehicleBrand_Name());  }
        } if (vehicle.getVehicle_Brands() != null && vehicle.getVehicle_Brands().length > 1) {
            String vx = "";
            for (String v : vehicle.getVehicle_Brands()) {  vx = vx + " , " + vd.getVehicleBrandWithId(Integer.parseInt(v)).getVehicleBrand_Name();}         
            if(vehicle.isVehicle_BrandNotMatter()){vehicle.setVehicle_Brand("Farketmez");}
            else{vehicle.setVehicle_Brand(vx.substring(2));}
        }
    }  public void createFavoritesAd(){ FavoritesBean f = new FavoritesBean();  f.createFavoritesAd(pAdId);  } 
    public void createAdComment(){ 
        int sonuc = 0;
        Ad_CommentsBean ac = new Ad_CommentsBean();
        sonuc = ac.createAdComment(this.pAdId,this.AdComment );   
        if(sonuc == 1){this.AdComment = null;}
    }public void setLocationToGMAP(){
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
               markers = markers+"{  iconResim:'/resources/img/kırmızı_pin.png' ,  addressx:'"+a.getAdRoute_StartPosition_Neighborhood()+
                              ", "+a.getAdRoute_StartPosition_Town()+
                              ", "+a.getAdRoute_StartPosition_City()+
                              "', p_content:'<b>İşim Var Araç Arıyorum</b><br><p>"+isSayisi+".İş </br></br>Başlangıç noktası : "+stTime+" "+spNeighborhood+a.getAdRoute_StartPosition_Town()+"-"+a.getAdRoute_StartPosition_City()+"</p>' },";
            
            markersEnd = markersEnd+"{  iconResim:'/resources/img/turuncu_pin.png' , addressx:'"+a.getAdRoute_EndPosition_Neighborhood()+
                              ", "+a.getAdRoute_EndPosition_Town()+
                              ", "+a.getAdRoute_EndPosition_City()+
                              "', p_content:'<b>İşim Var Araç Arıyorum</b><br><p>"+isSayisi+".İş </br></br>Bitiş noktası : "+enTime+" "+epNeighborhood+a.getAdRoute_EndPosition_Town()+"-"+a.getAdRoute_EndPosition_City()+"</p>' },";
        
        }
        markers = markers+markersEnd+" ]";
        this.googleMapMarkers= markers;   
    }}
