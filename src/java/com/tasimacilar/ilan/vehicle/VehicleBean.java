package com.tasimacilar.ilan.vehicle;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.UrlRedirect;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "vehicleBean")
@ViewScoped
public class VehicleBean implements Serializable{

    private Vehicle         vehicle;            
    
    private String      vId;          
    private String      pvId;           
    private String      vParam1="";  
    private String      vParam2="";    
    private String      vParam3="";      
    private String      urlPath="";
    private int         from;       
  
    private String      logedUserType;
    private List<String>    vehicleModelsList = new ArrayList<String>();   
    private List<VehicleBean>   vehicleList;
    private List<VehicleBean>   filteredvehicleList; 
    private List<VehicleBean>   userVehicleList;
    private List<VehicleBean>   userFilteredvehicleList;
    private String aId = null;
    private String selectedVehicle_Id;

    private Map<String,Boolean> checkMap = new HashMap<String,Boolean>();
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}  
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;
    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    @ManagedProperty(value="#{vehicleImagesBean}")
    private VehicleImagesBean vehicleImagesBean;
    public VehicleImagesBean getVehicleImagesBean() {return vehicleImagesBean; }
    public void setVehicleImagesBean(VehicleImagesBean vehicleImagesBean) { this.vehicleImagesBean = vehicleImagesBean;}
    @PostConstruct
    public void init() { 
       
        vehicle = new Vehicle();
        
        this.logedUserType = SessionUtil.getUserType();
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();   
        aId = req.getParameter("aId");
        String url = req.getRequestURL().toString();
        
        try {    URL urlx = new URL(url);  
            
                this.urlPath = FilenameUtils.getBaseName(urlx.getPath());
                if(FilenameUtils.getBaseName(urlx.getPath()).equals("arac_yonetimi")){             
                    getallVehicle();
                }
                if(FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_userVehicle")){  
                    if(aId != null && !aId.equals("")){ getuserVehicle(aId); }
                }
        } 
        catch (MalformedURLException ex) { System.out.println(":::HATA:::"+ex);   }    
        
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        if(facesContext != null){
            vId = facesContext.getExternalContext().getRequestParameterMap().get("vId");            // arac id
            pvId = facesContext.getExternalContext().getRequestParameterMap().get("vId");           // arac id
            vParam1 = facesContext.getExternalContext().getRequestParameterMap().get("vParam1");    // sayfa no
            vParam2 = facesContext.getExternalContext().getRequestParameterMap().get("vParam2");    // komut 
            vParam3 = facesContext.getExternalContext().getRequestParameterMap().get("vParam3");    // komut 
            
            if(facesContext.getExternalContext().getRequestParameterMap().get("frm") != null){
                if(!facesContext.getExternalContext().getRequestParameterMap().get("frm").equals("")){
                    from = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("frm"));    // arac ekleme talebi hangi sayfa uzerınden geldi. sonucta nereye yonlenecek 
                }
            }
            
            
            if (vId==null || vId.equals("")){ 
                vehicle.setVehicle_Id(UniqueId.RandomString(12)); // vId yok ise gelen bir arac id si olmadigi icin yeni bir arac icin id atanir.               
            }
            else{  
                getVehicleDetail(vId);  //vId var ise ozaman arac bilgileri alınıp gosterılecek             
            }
        }
        
    
    }

    public VehicleBean() {
        
    }
    public Vehicle getVehicle() {return vehicle;}
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle;}
    public String getaId() {return aId;}
    public void setaId(String aId) { this.aId = aId;}  
    public String getvId() { return vId;}
    public void setvId(String vId) { this.vId = vId;}
    public String getPvId() {  return pvId;}
    public void setPvId(String pvId) { this.pvId = pvId;}
    public String getvParam1() { return vParam1;}
    public void setvParam1(String vParam1) { this.vParam1 = vParam1;}
    public String getvParam2() {  return vParam2;}
    public void setvParam2(String vParam2) { this.vParam2 = vParam2;}
    public String getvParam3() {return vParam3;}
    public void setvParam3(String vParam3) {this.vParam3 = vParam3;}
    public String getLogedUserType() { return logedUserType;}
    public void setLogedUserType(String logedUserType) {this.logedUserType = logedUserType;}
    public List<String> getVehicleModelsList() {return vehicleModelsList;}
    public void setVehicleModelsList(List<String> vehicleModelsList) {this.vehicleModelsList = vehicleModelsList;}
    public List<VehicleBean> getVehicleList() {return vehicleList;}
    public void setVehicleList(List<VehicleBean> vehicleList) { this.vehicleList = vehicleList;}
    public List<VehicleBean> getFilteredvehicleList() { return filteredvehicleList;}
    public void setFilteredvehicleList(List<VehicleBean> filteredvehicleList) { this.filteredvehicleList = filteredvehicleList;}
    public List<VehicleBean> getUserVehicleList() {return userVehicleList;}
    public void setUserVehicleList(List<VehicleBean> userVehicleList) {this.userVehicleList = userVehicleList;}
    public List<VehicleBean> getUserFilteredvehicleList() {return userFilteredvehicleList;}
    public void setUserFilteredvehicleList(List<VehicleBean> userFilteredvehicleList) {this.userFilteredvehicleList = userFilteredvehicleList;}
    public String getSelectedVehicle_Id() { return selectedVehicle_Id;}
    public void setSelectedVehicle_Id(String selectedVehicle_Id) { this.selectedVehicle_Id = selectedVehicle_Id;}
    public Map<String, Boolean> getCheckMap() {return checkMap; }
    public void setCheckMap(Map<String, Boolean> checkMap) { this.checkMap = checkMap; }
    public int getFrom() { return from;  }
    public void setFrom(int from) {this.from = from; }
     public int createVehicle() {
        int snc = 0;
        snc = createVehicle(this.vehicle);
        return snc;
    }
    public int createVehicle(Vehicle vc) {      
        int snc = 0;
        
        if(vc.getVehicle_PlateProvinceCode() != 0){
            if(vc.getVehicle_PlateLatterCode() !=null && !vc.getVehicle_PlateLatterCode().equals("")){
                if(vc.getVehicle_PlateNumberCode() != 0){
                    
                    if(VehicleDao.isExistvehiclePlateForUser(vc.getVehicle_PlateProvinceCode(), 
                                                              vc.getVehicle_PlateLatterCode(), 
                                                              vc.getVehicle_PlateNumberCode(), 
                                                              SessionUtil.getUserId())){
                        
                        Messages.dynMsg(null, "error", vc.getVehicle_PlateProvinceCode()+" "
                                                                     +vc.getVehicle_PlateLatterCode()+" "
                                                                     +vc.getVehicle_PlateNumberCode()+" Plakalı araç zaten araçlarınız arasında bulunmakta. "
                                                                     + "Lütfen yazdığınız plakayı değiştirin veya araçlarınız arasından seçim yapın.");
                    }
                    else{
                        
                        if(VehicleDao.isExistvehiclePlate(vc.getVehicle_PlateProvinceCode(), 
                                                           vc.getVehicle_PlateLatterCode(), 
                                                           vc.getVehicle_PlateNumberCode())){
                            Messages.dynMsg(null, "warn", "Bu plakada bir araç daha önceden sisteme kaydedilmiş, site yönetimi incelemede bulunacak.");
                        }

                            int sonuc = 0; 
                            String ovnerAccountIdx = SessionUtil.getUserId();

                            Vehicle v = new Vehicle();
                            v.setVehicle_Id(vc.getVehicle_Id());
                            v.setVehicle_PlateProvinceCode(vc.getVehicle_PlateProvinceCode());
                            v.setVehicle_PlateLatterCode(vc.getVehicle_PlateLatterCode());
                            v.setVehicle_PlateNumberCode(vc.getVehicle_PlateNumberCode());
                            v.setVehicle_PlateLicense(false);
v.setVehicle_Brand(String.valueOf(vc.getVehicle_BrandId()));
                            v.setVehicle_Model(vc.getVehicle_Model());
                            v.setVehicle_ModelYear(vc.getVehicle_ModelYear());
                            v.setVehicle_NumberOfSeats(vc.getVehicle_NumberOfSeats());
                            v.setVehicle_Km(0);
                            v.setVehicle_Color("");
                            v.setVehicle_CompanyLogo(false);
                            v.setVehicle_CompanyLogoText("");
                            v.setVehicle_DriverInfo(vc.getVehicle_DriverInfo());
                            v.setVehicle_HostessInfo(vc.getVehicle_HostessInfo());


                            if(this.aId != null){
                                if(!this.aId.equals("")){ v.setVehicle_OvnerAccountId(this.aId); }
                                else{v.setVehicle_OvnerAccountId(ovnerAccountIdx);}
                            }
                            else{v.setVehicle_OvnerAccountId(ovnerAccountIdx);}


                            v.setVehicle_IsActive(true);
                            v.setVehicle_Commnet("");
                            v.setVehicle_Modified(new Date());
                            v.setVehicle_Modifier(ovnerAccountIdx);
                            v.setVehicle_Created(new Date());
                            v.setVehicle_creator(ovnerAccountIdx);

                            if(vc.getVehicle_ServiceTypesList() != null && vc.getVehicle_ServiceTypesList().length > 0){
                                String ServiceTypesListx = "";
                                for (String dl : vc.getVehicle_ServiceTypesList()) { ServiceTypesListx = ServiceTypesListx + ',' + dl.toString();  };
                                ServiceTypesListx.substring(1); 
                                v.setVehicle_ServiceTypes(ServiceTypesListx);
                            }
                            else{v.setVehicle_ServiceTypes("");}

                            if(vc.getVehicle_AuthorityDocumentsList() != null && vc.getVehicle_AuthorityDocumentsList().length > 0){
                                String AuthorityDocumentsListx = "";
                                for (String dl : vc.getVehicle_AuthorityDocumentsList()) { AuthorityDocumentsListx = AuthorityDocumentsListx + ',' + dl.toString();  };
                                AuthorityDocumentsListx.substring(1); 
                                v.setVehicle_AuthorityDocuments(AuthorityDocumentsListx);
                            }
                            else{v.setVehicle_AuthorityDocuments("");}

                            if(vc.getVehicle_VehiclePropertiesList() != null && vc.getVehicle_VehiclePropertiesList().length > 0){
                                String vehicle_VehiclePropertiesListx = "";
                                for (String dl : vc.getVehicle_VehiclePropertiesList()) { vehicle_VehiclePropertiesListx = vehicle_VehiclePropertiesListx + ',' + dl.toString();  };
                                vehicle_VehiclePropertiesListx.substring(1); 
                                v.setVehicle_VehicleProperties(vehicle_VehiclePropertiesListx);
                            }
                            else{v.setVehicle_VehicleProperties("");}

                            switch (vc.getVehicle_NumberOfSeats()) {
                                case "4+1": v.setVehicle_Typ("Otomobil"); break;    case "5+1": v.setVehicle_Typ("Otomobil"); break;
                                case "6+1": v.setVehicle_Typ("Otomobil"); break;    case "7+1": v.setVehicle_Typ("Otomobil"); break;
                                case "8+1": v.setVehicle_Typ("Otomobil"); break;    case "9+1": v.setVehicle_Typ("Minibüs"); break;
                                case "10+1": v.setVehicle_Typ("Minibüs"); break;    case "11+1": v.setVehicle_Typ("Minibüs"); break;
                                case "12+1": v.setVehicle_Typ("Minibüs"); break;    case "13+1": v.setVehicle_Typ("Minibüs"); break;
                                case "14+1": v.setVehicle_Typ("Minibüs"); break;    case "15+1": v.setVehicle_Typ("Minibüs"); break;
                                case "16+1": v.setVehicle_Typ("Minibüs"); break;    case "17+1": v.setVehicle_Typ("Midibüs"); break;
                                case "18+1": v.setVehicle_Typ("Midibüs"); break;    case "19+1": v.setVehicle_Typ("Midibüs"); break;
                                case "20+1": v.setVehicle_Typ("Midibüs"); break;    case "21+1": v.setVehicle_Typ("Midibüs"); break;
                                case "22+1": v.setVehicle_Typ("Midibüs"); break;    case "23+1": v.setVehicle_Typ("Midibüs"); break;
                                case "24+1": v.setVehicle_Typ("Midibüs"); break;    case "25+1": v.setVehicle_Typ("Midibüs"); break;
                                case "26+1": v.setVehicle_Typ("Midibüs"); break;    case "27+1": v.setVehicle_Typ("Midibüs"); break;
                                case "28+1": v.setVehicle_Typ("Midibüs"); break;    case "29+1": v.setVehicle_Typ("Midibüs"); break;
                                case "30+1": v.setVehicle_Typ("Midibüs"); break;    case "31+1": v.setVehicle_Typ("Midibüs"); break;
                                default: v.setVehicle_Typ("Otobüs");
                            }

                            VehicleDao vd = new VehicleDao();
                            sonuc = vd.createVehicle(v);

                            if(sonuc==1){

                                VehicleImages vi = new VehicleImages();        
                                vi.setVehicleImage_Id(UniqueId.RandomString(12));
                                vi.setVehicleImage_ProfilePhotoUrl(vehicleImagesBean.getVehicleImages().getVehicleImage_ProfilePhotoUrl());
                                vi.setVehicleImage_ProfilePhotoPublish(vehicleImagesBean.getVehicleImages().isVehicleImage_ProfilePhotoPublish());
                                vi.setVehicleImage_GalleryPtoho_1_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_1_Url());
                                vi.setVehicleImage_GalleryPtoho_2_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_2_Url());
                                vi.setVehicleImage_GalleryPtoho_3_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_3_Url());
                                vi.setVehicleImage_GalleryPtoho_4_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_4_Url());
                                vi.setVehicleImage_GalleryPtoho_5_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_5_Url());
                                vi.setVehicleImage_GalleryPtoho_6_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_6_Url());
                                vi.setVehicleImage_GalleryPtoho_7_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_7_Url());
                                vi.setVehicleImage_GalleryPtoho_8_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_8_Url());
                                vi.setVehicleImage_GalleryPtoho_9_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_9_Url());
                                vi.setVehicleImage_GalleryPtoho_10_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_10_Url());
                                vi.setVehicleVideoUrl("");
                                vi.setVehicleImage_Commnet(null);
                                vi.setVehicleImage_Modified(new Date());
                                vi.setVehicleImage_Modifier(SessionUtil.getUserId());
                                vi.setVehicleImage_Created(new Date());
                                vi.setVehicleImage_creator(SessionUtil.getUserId());
                                vi.setVehicle_Id(vc.getVehicle_Id());


                                int sncx = 0;
                                VehicleImagesDao vid = new VehicleImagesDao();
                                sncx = vid.createVehicleImages(vi);

                                if(sncx == 1){
                                    snc = 1;
                                        if(from==0){
                                            if(SessionUtil.getUserType().equals("personal")){UrlRedirect.redirect( "/private/common/vehicle/sonucSayfasi.xhtml?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                            if(SessionUtil.getUserType().equals("corporate")){UrlRedirect.redirect("/private/common/vehicle/sonucSayfasi.xhtml?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                            if(SessionUtil.getUserType().equals("director")){UrlRedirect.redirect( "/private/director/users/kullanici_detay_yeni_arac_ekle_SonucSayfasi.xhtml?vParam2=ad&vId="+vc.getVehicle_Id()+"&&aId="+this.aId+"&faces-redirect=true");}
                                        }
                                        else{
                                            if(from==2){
                                                if(SessionUtil.getUserType().equals("personal")){UrlRedirect.redirect( "/private/bireysel/ilanlar/aracim-var-is-ariyorum/yeni/ekle?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                                if(SessionUtil.getUserType().equals("corporate")){UrlRedirect.redirect("/private/kurumsal/ilanlar/aracim-var-is-ariyorum/yeni/ekle?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                            }
                                            else if(from==3){
                                                if(SessionUtil.getUserType().equals("personal")){UrlRedirect.redirect( "/private/bireysel/ilanlar/aracim-var-sofor-ariyorum/yeni/ekle?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                                if(SessionUtil.getUserType().equals("corporate")){UrlRedirect.redirect("/private/kurumsal/ilanlar/aracim-var-sofor-ariyorum/yeni/ekle?vId="+vc.getVehicle_Id()+"&faces-redirect=true");}
                                            }
                                        }

                                }
                                else{ System.out.println(":::HATA:::Hızlı araç ekleme hatası");}



                            }
                    }
                }
                else{ Messages.dynMsg(null, "error", "Araç plakasındaki rakam kodu geçersiz"); }
            }
            else{ Messages.dynMsg(null, "error", "Araç plakasındaki harf kodu geçersiz"); }
        }
        else{ Messages.dynMsg(null, "error", "Araç plakasındaki il kodu geçersiz"); }
        
        
       return snc;
   }  public int updateFastVehicle(Vehicle vc) {
        int snc = 0;
        snc = updateFastVehicle(this.vehicle);

        return snc;
    }   public int updateFastVehicle() {
        boolean save = false;
        String yonlen = null;
        int sonuc = 0; 
        String ovnerAccountIdx = SessionUtil.getUserId();
         
        Vehicle v = new Vehicle();
        v.setVehicle_Id(vehicle.getVehicle_Id());if( vehicle.getVehicle_PlateProvinceCode() != vehicle.getVehicle_PlateProvinceCode2() || 
            !vehicle.getVehicle_PlateLatterCode().equals(vehicle.getVehicle_PlateLatterCode2()) || 
            vehicle.getVehicle_PlateNumberCode() != vehicle.getVehicle_PlateNumberCode2()){
      
            if(vehicle.getVehicle_PlateProvinceCode() != 0){
                if(vehicle.getVehicle_PlateLatterCode() !=null && !vehicle.getVehicle_PlateLatterCode().equals("")){
                    if(vehicle.getVehicle_PlateNumberCode() != 0){      
                        
                        if(VehicleDao.isExistvehiclePlateForUser(vehicle.getVehicle_PlateProvinceCode(), 
                                                                    vehicle.getVehicle_PlateLatterCode(), 
                                                                    vehicle.getVehicle_PlateNumberCode(), 
                                                                    SessionUtil.getUserId())){

                              Messages.dynMsg(null, "error", vehicle.getVehicle_PlateProvinceCode()+" "
                                                                           +vehicle.getVehicle_PlateLatterCode()+" "
                                                                           +vehicle.getVehicle_PlateNumberCode()+" Plakalı araç zaten araçlarınız arasında bulunmakta. "
                                                                           + "Lütfen yazdığınız plakayı değiştirin veya araçlarınız arasından seçim yapın.");
                        }
                        else{        
                                                    
                             if(VehicleDao.isExistvehiclePlate(vehicle.getVehicle_PlateProvinceCode(), vehicle.getVehicle_PlateLatterCode(), vehicle.getVehicle_PlateNumberCode())){
                                Messages.dynMsg(null, "error", "Bu plakada bir araç daha önceden sisteme kaydedilmiş, site yönetimi incelemede bulunacak.");
                            }

                            v.setVehicle_PlateProvinceCode(vehicle.getVehicle_PlateProvinceCode());
                            v.setVehicle_PlateLatterCode(vehicle.getVehicle_PlateLatterCode());
                            v.setVehicle_PlateNumberCode(vehicle.getVehicle_PlateNumberCode());
                            save=true;  
                            
                        }
                       
                    }
                    else{ Messages.dynMsg(null, "error", "Araç plaka rakam kodu geçersiz");}
                }
                else{ Messages.dynMsg(null, "error", "Araç plaka harf kodu geçersiz"); }
            }
            else{Messages.dynMsg(null, "error", "Araç plaka il kodu geçersiz");}
        
        } else{      
            v.setVehicle_PlateProvinceCode(vehicle.getVehicle_PlateProvinceCode());
            v.setVehicle_PlateLatterCode(vehicle.getVehicle_PlateLatterCode());
            v.setVehicle_PlateNumberCode(vehicle.getVehicle_PlateNumberCode());
            save = true;
        }
        v.setVehicle_PlateLicense(vehicle.getVehicle_PlateLicense());
 v.setVehicle_Brand(String.valueOf(vehicle.getVehicle_BrandId()));
        v.setVehicle_Model(vehicle.getVehicle_Model());
        v.setVehicle_ModelYear(vehicle.getVehicle_ModelYear());
        v.setVehicle_NumberOfSeats(vehicle.getVehicle_NumberOfSeats());
        v.setVehicle_Km(vehicle.getVehicle_Km());
        v.setVehicle_Color(vehicle.getVehicle_Color());
        v.setVehicle_CompanyLogo(vehicle.getVehicle_CompanyLogo());
        v.setVehicle_CompanyLogoText(vehicle.getVehicle_CompanyLogoText());
        v.setVehicle_Modified(new Date());
        v.setVehicle_Modifier(ovnerAccountIdx);
        v.setVehicle_DriverInfo(vehicle.getVehicle_DriverInfo());
        v.setVehicle_HostessInfo(vehicle.getVehicle_HostessInfo());
        
        if(vehicle.getVehicle_ServiceTypesList() != null && vehicle.getVehicle_ServiceTypesList().length > 0){
            String ServiceTypesListx = "";
            for (String dl : vehicle.getVehicle_ServiceTypesList()) { ServiceTypesListx = ServiceTypesListx + ',' + dl.toString();  };
            ServiceTypesListx.substring(1); 
            v.setVehicle_ServiceTypes(ServiceTypesListx);
        }
         
        if(vehicle.getVehicle_AuthorityDocumentsList() != null && vehicle.getVehicle_AuthorityDocumentsList().length > 0){
            String AuthorityDocumentsListx = "";
            for (String dl : vehicle.getVehicle_AuthorityDocumentsList()) { AuthorityDocumentsListx = AuthorityDocumentsListx + ',' + dl.toString();  };
            AuthorityDocumentsListx.substring(1); 
            v.setVehicle_AuthorityDocuments(AuthorityDocumentsListx);
        }
        
         if(vehicle.getVehicle_VehiclePropertiesList() != null && vehicle.getVehicle_VehiclePropertiesList().length > 0){
            String vehicle_VehiclePropertiesListx = "";
            for (String dl : vehicle.getVehicle_VehiclePropertiesList()) { vehicle_VehiclePropertiesListx = vehicle_VehiclePropertiesListx + ',' + dl.toString();  };
            vehicle_VehiclePropertiesListx.substring(1); 
            v.setVehicle_VehicleProperties(vehicle_VehiclePropertiesListx);
        }
        
         if(save){
            VehicleDao vd = new VehicleDao();
            sonuc = vd.updateVehicle(v);
         }
      
        if(sonuc==1){       
            VehicleImages vi = new VehicleImages();        
            vi.setVehicleImage_Id(UniqueId.RandomString(12));
            vi.setVehicleImage_ProfilePhotoUrl(vehicleImagesBean.getVehicleImages().getVehicleImage_ProfilePhotoUrl());
            vi.setVehicleImage_ProfilePhotoPublish(vehicleImagesBean.getVehicleImages().isVehicleImage_ProfilePhotoPublish());
            vi.setVehicleImage_GalleryPtoho_1_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_1_Url());
            vi.setVehicleImage_GalleryPtoho_2_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_2_Url());
            vi.setVehicleImage_GalleryPtoho_3_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_3_Url());
            vi.setVehicleImage_GalleryPtoho_4_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_4_Url());
            vi.setVehicleImage_GalleryPtoho_5_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_5_Url());
            vi.setVehicleImage_GalleryPtoho_6_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_6_Url());
            vi.setVehicleImage_GalleryPtoho_7_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_7_Url());
            vi.setVehicleImage_GalleryPtoho_8_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_8_Url());
            vi.setVehicleImage_GalleryPtoho_9_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_9_Url());
            vi.setVehicleImage_GalleryPtoho_10_Url(vehicleImagesBean.getVehicleImages().getVehicleImage_GalleryPtoho_10_Url());
            vi.setVehicleVideoUrl("");
            vi.setVehicleImage_Commnet(null);
            vi.setVehicleImage_Modified(new Date());
            vi.setVehicleImage_Modifier(SessionUtil.getUserId());
            vi.setVehicleImage_Created(new Date());
            vi.setVehicleImage_creator(SessionUtil.getUserId());
            vi.setVehicle_Id(vehicle.getVehicle_Id());

            int sncx = 0;
            VehicleImagesDao vid = new VehicleImagesDao();
            sncx = vid.updateVehicleImages(vi);
 
            if(sncx == 1){
                getVehicleDetail(vehicle.getVehicle_Id());           

                if( this.urlPath.equals("edit_vehicle_s1") ){                            
                    if(SessionUtil.getUserType().equals("personal")){UrlRedirect.redirect( "/private/common/vehicle/sonucSayfasi2.xhtml?vId="+vehicle.getVehicle_Id()+"&faces-redirect=true");}
                    if(SessionUtil.getUserType().equals("corporate")){UrlRedirect.redirect("/private/common/vehicle/sonucSayfasi2.xhtml?vId="+vehicle.getVehicle_Id()+"&faces-redirect=true");}
                    if(SessionUtil.getUserType().equals("director")){UrlRedirect.redirect( "/private/director/vehicles/edit_vehicle_sonucSayfasi.xhtml?vParam2=ad&vId="+vehicle.getVehicle_Id()+"&faces-redirect=true");}
                }
                else if( this.urlPath.equals("kullanici_detay_edit_vehicle_s4") ){UrlRedirect.redirect("/private/director/users/kullanici_detay_edit_vehicle_s4.xhtml?p=addVehicle_s1&vParam2=ad&aId="+this.aId+"&vId="+vehicle.getVehicle_Id()+"&faces-redirect=true");}
                else{Messages.dynMsg(null, "info", "Araç bilgileri güncellenmiştir"); }

            }
            else{ System.out.println(":::HATA");}           
        }
       return sonuc;
    }public void getVehicleDetail(String vehicleId){ 
    
        VehicleDao vd = new VehicleDao();
        VehicleBean vb = new VehicleBean();
        vb = vd.getVehicleWithAdId(vehicleId);
        
        
        if(vb.getVehicle().isVehicle_IsActive()){
         setVehicle(vb.getVehicle());
            VehicleImagesBean vib = new VehicleImagesBean();
            vib.setVehicleImages(vb.getVehicle().getVehicleImages());
            setVehicleImagesBean(vib);
            
            if(vParam2 == null ){
                String s =String.valueOf(vb.getVehicle().getVehicle_PlateNumberCode()) ;
                if(s.length() > 2){ s = s.replaceFirst(".{2}$", "");}
                vehicle.setVehicle_PlateNumberCode(Integer.parseInt(s));   
            }
            else { vehicle.setVehicle_PlateNumberCode(vb.getVehicle().getVehicle_PlateNumberCode()); 
                   vehicle.setVehicle_PlateNumberCode2(vb.getVehicle().getVehicle_PlateNumberCode()); }
            VehicleBrandAndModelDao vx = new VehicleBrandAndModelDao();
            this.vehicleModelsList = vx.getAllVehicleModels(Integer.parseInt( vb.getVehicle().getVehicle_BrandId()));
             AccountBean acb = new AccountBean();
            acb.setAccount_Id(vb.getVehicle().getVehicle_OvnerAccountId());
            PersonalAccountBean pab = new PersonalAccountBean();
            pab.setAccountBean(acb);
            
            AccountDao ado = new AccountDao();
            this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
CorporateAccountDao cod = new CorporateAccountDao();
            this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());   
            
        }
        else{ System.out.println(":::HATA::: Böyle bir arac yok"); }
        
    }public List<Vehicle> getVehiclesWithvehicleOvnerAccountId(String vehicleOvnerAccountId) {
       
        VehicleDao vd = new VehicleDao();
        
        return  vd.getVehiclesWithvehicleOvnerAccountId(vehicleOvnerAccountId);
    
    }public void getallVehicle() {
       
        VehicleDao vd = new VehicleDao();
        
        this.vehicleList = vd.getAllVehicle();
        
        
    
    }   public void getuserVehicle(String ownerId) {
       
        VehicleDao vd = new VehicleDao();
        this.userVehicleList = vd.getUserVehicle(ownerId);
    }  public List<VehicleBrandAndModelBean> vehicleBrandNamesListx() {

        VehicleBrandAndModelDao v = new VehicleBrandAndModelDao();

        return v.getAllVehicleBrand();
    } public void vehicleModelsListx() { 

        VehicleBrandAndModelDao v = new VehicleBrandAndModelDao();
        this.vehicleModelsList = v.getAllVehicleModels(Integer.parseInt(getVehicle().getVehicle_BrandId()));
    } public void disableSelectedVehicle() {
        
        int sonuc = 0;
        for (Map.Entry<String,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {     
                VehicleDao v = new VehicleDao();
                sonuc = v.enableDisableVehicle("disable", entry.getKey());  
                
                if (sonuc == 1){          
                    int sonuc2 = 0;
                    VehicleDao vd = new VehicleDao();
                    sonuc2 = vd.disableVehicleLinkedAds(entry.getKey());

                 }
                else{ Messages.dynMsg(null, "error", "Araç silme sırasında sorun oluştu");}
            }           
        }
        
        checkMap = new HashMap<String,Boolean>();
    }public void enableDisableVehicle(String param) {
        
        int sonuc = 0;
        
        if(param != null && this.selectedVehicle_Id != null){
            if(!param.equals("") && !this.selectedVehicle_Id.equals("")){
                VehicleDao v = new VehicleDao();
                sonuc = v.enableDisableVehicle(param, this.selectedVehicle_Id);                
            }
            else{ System.out.println(":::HATA:: param veya arac boş null geldi");}
        }
        else{ System.out.println(":::HATA:: param veya arac id null geldi");}
        
        if (sonuc == 1){         
            if(param.equals("enable")){Messages.dynMsg(null, "info", "Araç kullanıma açıldı");} 
            if(param.equals("disable")){ 
                
                int sonuc2 = 0;
                VehicleDao vd = new VehicleDao();
                sonuc2 = vd.disableVehicleLinkedAds(this.selectedVehicle_Id);

                if(sonuc2 >= 1){ Messages.dynMsg(null, "info", "Seçtiğiniz araç silinmiştir"); }
                else{Messages.dynMsg(null, "error", "Seçtiğiniz aracı silme sırasında sorun oluştu");}
            } 
        }
        else{ Messages.dynMsg(null, "error", "Araç enable/disable etme sırasında sorun oluştu");}
    
    }
     public void enableDisableVehicle2(String param, String vId ) {
        
        int sonuc = 0;
        
        if(param != null && vId != null){
            if(!param.equals("") && !vId.equals("")){
                VehicleDao v = new VehicleDao();
                sonuc = v.enableDisableVehicle(param, vId);                
            }
            else{ System.out.println(":::HATA:: param veya arac boş null geldi");}
        }
        else{ System.out.println(":::HATA:: param veya arac id null geldi");}
        
        
        
        if (sonuc == 1){ 
            getallVehicle();
            getuserVehicle(this.aId);
                       
            if(param.equals("disable")){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Seçtiğiniz araç silinmiştir");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            } 
            if(param.equals("enable")){
                System.out.println(":::BİLGİ:: Araç enable edildi");
            } 
        }
        else{
            System.out.println(":::BİLGİ:: Araç enable/disable etme sırasında sorun oluştu");
        }
    
    }public void selectedAdIdSet(String vehicleIdx) {
        
        this.selectedVehicle_Id = vehicleIdx;
    }
    
    
    
}
