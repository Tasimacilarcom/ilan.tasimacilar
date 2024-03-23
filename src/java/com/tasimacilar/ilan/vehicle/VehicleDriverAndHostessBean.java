
package com.tasimacilar.ilan.vehicle;


import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.fileUpload.FileUpload;
import com.tasimacilar.ilan.system.fileUpload.Functions;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

@ManagedBean(name = "vehicleDriverAndHostessBean")
@ViewScoped
public class VehicleDriverAndHostessBean implements Serializable{
 
   
    private String      vehicleDriverAndHostess_Id;                     
    private String      vehicleDriverAndHostess_DriverInfo;           
    private String      vehicleDriverAndHostess_DriverId;              
    private String      vehicleDriverAndHostess_HostessInfo;          
    private String      vehicleDriverAndHostess_HostessId;             
    private boolean     vehicleDriverAndHostess_IsActive;           
    private String      vehicleDriverAndHostess_Commnet;              
    private Date        vehicleDriverAndHostess_Modified;              
    private String      vehicleDriverAndHostess_Modifier;             
    private Date        vehicleDriverAndHostess_Created;               
    private String      vehicleDriverAndHostess_creator;              
    private String      vehicle_Id;                                
    
    private Part        driverPhotoFile;
    private Part        hostessPhotoFile;  
    private String      pageNo;
    private String      vParam2 = "";
    private String      urlPath="";
    private String      pvId;
    private String      aId;
    
    private Driver      driver;
    private Hostess     hostess;
    
    @PostConstruct
    public void init() { 
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        aId = req.getParameter("aId");
        String url = req.getRequestURL().toString();
        
        try {    URL urlx = new URL(url);  
                this.urlPath = FilenameUtils.getBaseName(urlx.getPath());
        
                if( this.urlPath.equals("add_vehicle_s1") || 
                    this.urlPath.equals("yeni_arac_ekle_s1") || 
                    this.urlPath.equals("kullanici_detay_yeni_arac_ekle_s1") || 
                    this.urlPath.equals("kullanici_detay_edit_vehicle_s1") ||   
                    this.urlPath.equals("edit_vehicle_s1")){ this.pageNo = "s1";  }
                
        } 
        catch (MalformedURLException ex) {     Logger.getLogger(VehicleBean.class.getName()).log(Level.SEVERE, null, ex);     }
        
        
    
        String vId = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(facesContext != null){
            
            this.vehicle_Id = facesContext.getExternalContext().getRequestParameterMap().get("vId");
            vParam2 = facesContext.getExternalContext().getRequestParameterMap().get("vParam2");
                    
            this.vehicleDriverAndHostess_Id = UniqueId.RandomString(12);
            ;
            
             if(vParam2 != null && vParam2.equals("ad") && pageNo != null && pageNo.equals("s3")){
                getVehicleDriverAndHostessWithVehicleId(this.vehicle_Id );
            }
            
        }
    
    }
    public VehicleDriverAndHostessBean() {  }
    public String getVehicleDriverAndHostess_Id() {return vehicleDriverAndHostess_Id;}
    public void setVehicleDriverAndHostess_Id(String vehicleDriverAndHostess_Id) { this.vehicleDriverAndHostess_Id = vehicleDriverAndHostess_Id;}
    public String getVehicleDriverAndHostess_DriverInfo() {return vehicleDriverAndHostess_DriverInfo;}
    public void setVehicleDriverAndHostess_DriverInfo(String vehicleDriverAndHostess_DriverInfo) {this.vehicleDriverAndHostess_DriverInfo = vehicleDriverAndHostess_DriverInfo;}
    public String getVehicleDriverAndHostess_DriverId() {return vehicleDriverAndHostess_DriverId;}
    public void setVehicleDriverAndHostess_DriverId(String vehicleDriverAndHostess_DriverId) {this.vehicleDriverAndHostess_DriverId = vehicleDriverAndHostess_DriverId;}
    public String getVehicleDriverAndHostess_HostessInfo() {return vehicleDriverAndHostess_HostessInfo;}
    public void setVehicleDriverAndHostess_HostessInfo(String vehicleDriverAndHostess_HostessInfo) {this.vehicleDriverAndHostess_HostessInfo = vehicleDriverAndHostess_HostessInfo;}
    public String getVehicleDriverAndHostess_HostessId() {return vehicleDriverAndHostess_HostessId;}
    public void setVehicleDriverAndHostess_HostessId(String vehicleDriverAndHostess_HostessId) {this.vehicleDriverAndHostess_HostessId = vehicleDriverAndHostess_HostessId;}
    public boolean isVehicleDriverAndHostess_IsActive() {return vehicleDriverAndHostess_IsActive;}
    public void setVehicleDriverAndHostess_IsActive(boolean vehicleDriverAndHostess_IsActive) {this.vehicleDriverAndHostess_IsActive = vehicleDriverAndHostess_IsActive;}
    public String getVehicleDriverAndHostess_Commnet() {return vehicleDriverAndHostess_Commnet;}
    public void setVehicleDriverAndHostess_Commnet(String vehicleDriverAndHostess_Commnet) {this.vehicleDriverAndHostess_Commnet = vehicleDriverAndHostess_Commnet;}
    public Date getVehicleDriverAndHostess_Modified() {return vehicleDriverAndHostess_Modified;}
    public void setVehicleDriverAndHostess_Modified(Date vehicleDriverAndHostess_Modified) {this.vehicleDriverAndHostess_Modified = vehicleDriverAndHostess_Modified;}
    public String getVehicleDriverAndHostess_Modifier() {return vehicleDriverAndHostess_Modifier;}
    public void setVehicleDriverAndHostess_Modifier(String vehicleDriverAndHostess_Modifier) {this.vehicleDriverAndHostess_Modifier = vehicleDriverAndHostess_Modifier;}
    public Date getVehicleDriverAndHostess_Created() {return vehicleDriverAndHostess_Created;}
    public void setVehicleDriverAndHostess_Created(Date vehicleDriverAndHostess_Created) {this.vehicleDriverAndHostess_Created = vehicleDriverAndHostess_Created;}
    public String getVehicleDriverAndHostess_creator() {return vehicleDriverAndHostess_creator;}
    public void setVehicleDriverAndHostess_creator(String vehicleDriverAndHostess_creator) {this.vehicleDriverAndHostess_creator = vehicleDriverAndHostess_creator;}
    public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}
    public Part getDriverPhotoFile() {return driverPhotoFile; }
    public void setDriverPhotoFile(Part driverPhotoFile) { this.driverPhotoFile = driverPhotoFile;}
    public Part getHostessPhotoFile() { return hostessPhotoFile;  }
    public void setHostessPhotoFile(Part hostessPhotoFile) { this.hostessPhotoFile = hostessPhotoFile;}
    public String getvParam2() { return vParam2;}
    public void setvParam2(String vParam2) { this.vParam2 = vParam2;}
    public String getPvId() {return pvId;}
    public void setPvId(String pvId) { this.pvId = pvId;}
    public String getaId() { return aId;}
    public void setaId(String aId) { this.aId = aId;}
    public Driver getDriver() { return driver;}
    public void setDriver(Driver driver) { this.driver = driver;}
    public Hostess getHostess() { return hostess;}
    public void setHostess(Hostess hostess) { this.hostess = hostess;} 
    public String createvehicleDriverAndHostess(){
        
        String  yonlen = null;
        String  creatorxAndmodifier = SessionUtil.getUserId();
        String  driverIdx = UniqueId.RandomString(12);
        String  hostessIdx = UniqueId.RandomString(12);
        
        VehicleDriverAndHostessBean vb = new VehicleDriverAndHostessBean();        
        vb.setVehicleDriverAndHostess_Id( this.vehicleDriverAndHostess_Id);
     
        if(this.vehicleDriverAndHostess_DriverInfo.equals("kendim-kullaniyorum")){
                  
            Driver dbx = new Driver();
            dbx.setDriver_Id(driverIdx);  
      
            vb.setVehicleDriverAndHostess_DriverInfo("kendim-kullaniyorum");
            vb.setVehicleDriverAndHostess_DriverId(driverIdx);
            vb.setDriver(dbx);
        }     
        else if (this.vehicleDriverAndHostess_DriverInfo.equals("sofor-yok")) {
                                 
            Driver db = new Driver();
            db.setDriver_Id(driverIdx);
       
            vb.setVehicleDriverAndHostess_DriverInfo("sofor-yok");
            vb.setVehicleDriverAndHostess_DriverId(driverIdx);
            vb.setDriver(db);
        }
        else if (this.vehicleDriverAndHostess_DriverInfo.equals("sofor-kullaniyor")) {
            
            Driver db = new Driver();
            db.setDriver_Id(driverIdx);
            db.setDriver_FirstName(driver.getDriver_FirstName());
            db.setDriver_LastName(driver.getDriver_LastName());
            db.setDriver_EmailAddress(driver.getDriver_EmailAddress());
            db.setDriver_MobilePhoneNumber(driver.getDriver_MobilePhoneNumber());
            db.setDriver_Gender(driver.getDriver_Gender());
            db.setDriver_BirthDate(driver.getDriver_BirthDate());
            db.setDriver_PlaceOfBirth(driver.getDriver_PlaceOfBirth());
            db.setDriver_Education(driver.getDriver_Education());
            db.setDriver_DriversLicenseYear(driver.getDriver_DriversLicenseYear());
            db.setDriver_Fee(driver.getDriver_Fee());
            db.setDriver_ServiceTransportationExperience(driver.isDriver_ServiceTransportationExperience());
            db.setDriver_Experience(driver.getDriver_Experience());
            db.setDriver_ProfilePictureUrl(driver.getDriver_ProfilePictureUrl());
            db.setDriver_ProfilePicturePublish(driver.isDriver_ProfilePicturePublish());
            db.setDriver_Retired(driver.isDriver_Retired());
            db.setDriver_CriminalRecord(driver.isDriver_CriminalRecord());
            db.setDriver_CertificateOfProfessionalCompetence(driver.isDriver_CertificateOfProfessionalCompetence());
            db.setDriver_IsActive(true);
            db.setDriver_Commnet(null);
            db.setDriver_Modified(new Date());
            db.setDriver_Modifier(creatorxAndmodifier);
            db.setDriver_Created(new Date());
            db.setDriver_creator(creatorxAndmodifier);
            
            if (driver.getDriver_DriversLicenses() != null && driver.getDriver_DriversLicenses().length > 0) {
                String DriversLicensesx = "";
                for (String dl : driver.getDriver_DriversLicenses()) { DriversLicensesx = DriversLicensesx + ',' + dl.toString();  };
                DriversLicensesx.substring(1);
                db.setDriver_DriversLicense(DriversLicensesx);
            }
            
            if (driver.getDriver_RequestedDocumentesList() != null && driver.getDriver_RequestedDocumentesList().length > 0) {
                String RequestedDocumentesListx = "";
                for (String dl : driver.getDriver_RequestedDocumentesList()) { RequestedDocumentesListx = RequestedDocumentesListx + ',' + dl.toString();  };
                RequestedDocumentesListx.substring(1);
                db.setDriver_RequestedDocumentes(RequestedDocumentesListx);
            }
            
            if (driver.getDriver_ForeignLanguagesList() != null && driver.getDriver_ForeignLanguagesList().length > 0) {
                String ForeignLanguagesListx = "";
                for (String dl : driver.getDriver_ForeignLanguagesList()) { ForeignLanguagesListx = ForeignLanguagesListx + ',' + dl.toString();  };
                ForeignLanguagesListx.substring(1);
                db.setDriver_ForeignLanguages(ForeignLanguagesListx);
            }
            
            if (driver.getDriver_VehicleTypesList()!= null && driver.getDriver_VehicleTypesList().length > 0) {
                String VehicleTypesListx = "";
                for (String dl : driver.getDriver_VehicleTypesList()) { VehicleTypesListx = VehicleTypesListx + ',' + dl.toString();  };
                VehicleTypesListx.substring(1);
                db.setDriver_VehicleTypes(VehicleTypesListx);
            }
            
            vb.setVehicleDriverAndHostess_DriverInfo("sofor-kullaniyor");
            vb.setVehicleDriverAndHostess_DriverId(driverIdx);
            vb.setDriver(db);
            
        }
        if(this.vehicleDriverAndHostess_HostessInfo.equals("hostes-yok")){
            
            Hostess hb = new Hostess();
            hb.setHostess_Id(hostessIdx);
         
            vb.setVehicleDriverAndHostess_HostessInfo("hostes-yok");
            vb.setVehicleDriverAndHostess_HostessId(hostessIdx);
            vb.setHostess(hb);
        }  
        else if (this.vehicleDriverAndHostess_HostessInfo.equals("hostes-var")) {
            
            Hostess hb = new Hostess();
            hb.setHostess_Id(hostessIdx);
            hb.setHostess_FirstName(hostess.getHostess_FirstName());
            hb.setHostess_LastName(hostess.getHostess_LastName());
            hb.setHostess_EmailAddress(hostess.getHostess_EmailAddress());
            hb.setHostess_MobilePhoneNumber(hostess.getHostess_MobilePhoneNumber());
            hb.setHostess_Gender(hostess.getHostess_Gender());
            hb.setHostess_BirthDate(hostess.getHostess_BirthDate());
            hb.setHostess_PlaceOfBirth(hostess.getHostess_PlaceOfBirth());
            hb.setHostess_Proximity(hostess.getHostess_Proximity());
            hb.setHostess_Education(hostess.getHostess_Education());
            hb.setHostess_CriminalRecord(hostess.isHostess_CriminalRecord());
            hb.setHostess_ServiceTransportationExperience(hostess.isHostess_ServiceTransportationExperience());
            hb.setHostess_Experience(hostess.getHostess_Experience());
            hb.setHostess_ProfilePictureUrl(hostess.getHostess_ProfilePictureUrl());
            hb.setHostess_ProfilePicturePublish(hostess.isHostess_ProfilePicturePublish());
            hb.setHostess_IsActive(true);
            hb.setHostess_Commnet(null);
            hb.setHostess_Modified(new Date());
            hb.setHostess_Modifier(creatorxAndmodifier);
            hb.setHostess_Created(new Date());
            hb.setHostess_creator(creatorxAndmodifier);
            
            if (hostess.getHostess_ForeignLanguagesList() != null && hostess.getHostess_ForeignLanguagesList().length > 0) {
                String ForeignLanguagesListx = "";
                for (String dl : hostess.getHostess_ForeignLanguagesList()) { ForeignLanguagesListx = ForeignLanguagesListx + ',' + dl.toString();  };
                ForeignLanguagesListx.substring(1);
                hb.setHostess_ForeignLanguages(ForeignLanguagesListx);
            }
            
            
            vb.setVehicleDriverAndHostess_HostessInfo("hostes-var");
            vb.setVehicleDriverAndHostess_HostessId(hostessIdx);
            vb.setHostess(hb);          
        }
        vb.setVehicleDriverAndHostess_IsActive(true);
        vb.setVehicleDriverAndHostess_Commnet(null);
        vb.setVehicleDriverAndHostess_Modified(new Date());
        vb.setVehicleDriverAndHostess_Modifier(creatorxAndmodifier);
        vb.setVehicleDriverAndHostess_Created(new Date());
        vb.setVehicleDriverAndHostess_creator(creatorxAndmodifier);
        vb.setVehicle_Id(this.vehicle_Id);
        
        int sonuc = 0;
        
        VehicleDriverAndHostessDao vdo = new VehicleDriverAndHostessDao();
        sonuc = vdo.createvehicleDriverAndHostess(vb);
        
        if(sonuc == 1){
            if( this.urlPath.equals("add_vehicle_s3") ){ 
                if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/personal/vehicle/add_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
                if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/corporate/vehicle/add_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
            }
            else if( this.urlPath.equals("kullanici_detay_yeni_arac_ekle_s3") ){ yonlen = "/private/director/users/kullanici_detay_yeni_arac_ekle_s4.xhtml?p=addVehicle_s1&aId="+this.aId+"&vId="+this.vehicle_Id+"&faces-redirect=true"; }         
         
            else{
                if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/personal/vehicle/add_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
                if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/corporate/vehicle/add_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
                if(SessionUtil.getUserType().equals("director")){ yonlen = "/private/director/users/kullanici_detay_yeni_arac_ekle_s4.xhtml?p=addVehicle_s1&aId="+this.aId+"&vId="+this.vehicle_Id+"&faces-redirect=true"; }         
         
                }
        }
        
        return yonlen;
    } public String updateVehicleDriverAndHostess(){
        
        String  yonlen = null;
        String  creatorxAndmodifier = SessionUtil.getUserId();
                
        VehicleDriverAndHostessBean vb = new VehicleDriverAndHostessBean();
        vb.setVehicleDriverAndHostess_Id( this.vehicleDriverAndHostess_Id);
             
        if(this.vehicleDriverAndHostess_DriverInfo.equals("kendim-kullaniyorum")){
                  
            Driver dbx = new Driver();
            dbx.setDriver_Id(this.vehicleDriverAndHostess_DriverId);  
      
            vb.setVehicleDriverAndHostess_DriverInfo("kendim-kullaniyorum");
            vb.setVehicleDriverAndHostess_DriverId(this.vehicleDriverAndHostess_DriverId);
            vb.setDriver(dbx);
        }     
        
        else if (this.vehicleDriverAndHostess_DriverInfo.equals("sofor-yok")) {
                                 
            Driver db = new Driver(); 
            db.setDriver_Id(this.vehicleDriverAndHostess_DriverId);
           
            vb.setVehicleDriverAndHostess_DriverInfo("sofor-yok");
            vb.setVehicleDriverAndHostess_DriverId(this.vehicleDriverAndHostess_DriverId);
            vb.setDriver(db); 
        }
        else if (this.vehicleDriverAndHostess_DriverInfo.equals("sofor-kullaniyor")) {
            
            Driver db = new Driver();
            db.setDriver_Id(this.vehicleDriverAndHostess_DriverId);
            db.setDriver_FirstName(driver.getDriver_FirstName());
            db.setDriver_LastName(driver.getDriver_LastName());
            db.setDriver_EmailAddress(driver.getDriver_EmailAddress());
            db.setDriver_MobilePhoneNumber(driver.getDriver_MobilePhoneNumber());
            db.setDriver_Gender(driver.getDriver_Gender());
            db.setDriver_BirthDate(driver.getDriver_BirthDate());
            db.setDriver_PlaceOfBirth(driver.getDriver_PlaceOfBirth());
            db.setDriver_Education(driver.getDriver_Education());
            db.setDriver_DriversLicenseYear(driver.getDriver_DriversLicenseYear());
            db.setDriver_Fee(driver.getDriver_Fee());
            db.setDriver_ServiceTransportationExperience(driver.isDriver_ServiceTransportationExperience());
            db.setDriver_Experience(driver.getDriver_Experience());
            db.setDriver_ProfilePictureUrl(driver.getDriver_ProfilePictureUrl());
            db.setDriver_ProfilePicturePublish(driver.isDriver_ProfilePicturePublish());
            db.setDriver_Retired(driver.isDriver_Retired());
            db.setDriver_CriminalRecord(driver.isDriver_CriminalRecord());
            db.setDriver_CertificateOfProfessionalCompetence(driver.isDriver_CertificateOfProfessionalCompetence());
            db.setDriver_IsActive(true);
            db.setDriver_Commnet(null);
            db.setDriver_Modified(new Date());
            db.setDriver_Modifier(creatorxAndmodifier);
            db.setDriver_Created(new Date());
            db.setDriver_creator(creatorxAndmodifier);
            
            if (driver.getDriver_DriversLicenses() != null && driver.getDriver_DriversLicenses().length > 0) {
                String DriversLicensesx = "";
                for (String dl : driver.getDriver_DriversLicenses()) { DriversLicensesx = DriversLicensesx + ',' + dl.toString();  };
                DriversLicensesx.substring(1);
                db.setDriver_DriversLicense(DriversLicensesx);
            }
            
            if (driver.getDriver_RequestedDocumentesList() != null && driver.getDriver_RequestedDocumentesList().length > 0) {
                String RequestedDocumentesListx = "";
                for (String dl : driver.getDriver_RequestedDocumentesList()) { RequestedDocumentesListx = RequestedDocumentesListx + ',' + dl.toString();  };
                RequestedDocumentesListx.substring(1);
                db.setDriver_RequestedDocumentes(RequestedDocumentesListx);
            }
            
            if (driver.getDriver_ForeignLanguagesList() != null && driver.getDriver_ForeignLanguagesList().length > 0) {
                String ForeignLanguagesListx = "";
                for (String dl : driver.getDriver_ForeignLanguagesList()) { ForeignLanguagesListx = ForeignLanguagesListx + ',' + dl.toString();  };
                ForeignLanguagesListx.substring(1);
                db.setDriver_ForeignLanguages(ForeignLanguagesListx);
            }
            
            if (driver.getDriver_VehicleTypesList()!= null && driver.getDriver_VehicleTypesList().length > 0) {
                String VehicleTypesListx = "";
                for (String dl : driver.getDriver_VehicleTypesList()) { VehicleTypesListx = VehicleTypesListx + ',' + dl.toString();  };
                VehicleTypesListx.substring(1);
                db.setDriver_VehicleTypes(VehicleTypesListx);
            }
            
            vb.setVehicleDriverAndHostess_DriverInfo("sofor-kullaniyor");
            vb.setVehicleDriverAndHostess_DriverId(this.vehicleDriverAndHostess_DriverId);
            vb.setDriver(db);
            
        }
        
        if(this.vehicleDriverAndHostess_HostessInfo.equals("hostes-yok")){
            
            Hostess hb = new Hostess();
            hb.setHostess_Id(this.vehicleDriverAndHostess_HostessId);
         
            vb.setVehicleDriverAndHostess_HostessInfo("hostes-yok");
            vb.setVehicleDriverAndHostess_HostessId(this.vehicleDriverAndHostess_HostessId);
            vb.setHostess(hb);
        }  
        
        else if (this.vehicleDriverAndHostess_HostessInfo.equals("hostes-var")) {
            
            Hostess hb = new Hostess();
            hb.setHostess_Id(this.vehicleDriverAndHostess_HostessId);
            hb.setHostess_FirstName(hostess.getHostess_FirstName());
            hb.setHostess_LastName(hostess.getHostess_LastName());
            hb.setHostess_EmailAddress(hostess.getHostess_EmailAddress());
            hb.setHostess_MobilePhoneNumber(hostess.getHostess_MobilePhoneNumber());
            hb.setHostess_Gender(hostess.getHostess_Gender());
            hb.setHostess_BirthDate(hostess.getHostess_BirthDate());
            hb.setHostess_PlaceOfBirth(hostess.getHostess_PlaceOfBirth());
            hb.setHostess_Proximity(hostess.getHostess_Proximity());
            hb.setHostess_Education(hostess.getHostess_Education());
            hb.setHostess_CriminalRecord(hostess.isHostess_CriminalRecord());
            hb.setHostess_ServiceTransportationExperience(hostess.isHostess_ServiceTransportationExperience());
            hb.setHostess_Experience(hostess.getHostess_Experience());
            hb.setHostess_ProfilePictureUrl(hostess.getHostess_ProfilePictureUrl());
            hb.setHostess_ProfilePicturePublish(hostess.isHostess_ProfilePicturePublish());
            hb.setHostess_IsActive(true);
            hb.setHostess_Commnet(null);
            hb.setHostess_Modified(new Date());
            hb.setHostess_Modifier(creatorxAndmodifier);
            hb.setHostess_Created(new Date());
            hb.setHostess_creator(creatorxAndmodifier);
            
            if (hostess.getHostess_ForeignLanguagesList() != null && hostess.getHostess_ForeignLanguagesList().length > 0) {
                String ForeignLanguagesListx = "";
                for (String dl : hostess.getHostess_ForeignLanguagesList()) { ForeignLanguagesListx = ForeignLanguagesListx + ',' + dl.toString();  };
                ForeignLanguagesListx.substring(1);
                hb.setHostess_ForeignLanguages(ForeignLanguagesListx);
            }
            
            
            vb.setVehicleDriverAndHostess_HostessInfo("hostes-var");
            vb.setVehicleDriverAndHostess_HostessId(this.vehicleDriverAndHostess_HostessId);
            vb.setHostess(hb);          
        }
        
        vb.setVehicleDriverAndHostess_Modified(new Date());
        vb.setVehicleDriverAndHostess_Modifier(creatorxAndmodifier);
        vb.setVehicle_Id(this.vehicle_Id);
       
        int sonuc = 0;
       
        if(this.vehicleDriverAndHostess_Id != null ){
            if(this.vehicleDriverAndHostess_DriverInfo != null && this.vehicleDriverAndHostess_HostessInfo != null){
                if(!this.vehicleDriverAndHostess_DriverInfo.equals("") && !this.vehicleDriverAndHostess_HostessInfo.equals("") ){
                    VehicleDriverAndHostessDao vdo = new VehicleDriverAndHostessDao();
                    sonuc = vdo.updateVehicleDriverAndHostess(vb);
                }
                else{System.err.println(":::HATA:::Surucu veya hostes bilgisi boş geldi");}
            }
            else{System.err.println(":::HATA:::Surucu veya hostes bilgisi null geldi");}
        }
        else{          
            if(this.vehicleDriverAndHostess_Id == null){  this.vehicleDriverAndHostess_Id = UniqueId.RandomString(12); }
            else{ if(this.vehicleDriverAndHostess_Id.equals("")){  this.vehicleDriverAndHostess_Id = UniqueId.RandomString(12); } }

            if(this.vehicleDriverAndHostess_DriverId == null){this.vehicleDriverAndHostess_DriverId = UniqueId.RandomString(12);  }
            else{ if(this.vehicleDriverAndHostess_DriverId.equals("")){ this.vehicleDriverAndHostess_DriverId = UniqueId.RandomString(12); }  }

            if(this.vehicleDriverAndHostess_HostessId == null){this.vehicleDriverAndHostess_HostessId = UniqueId.RandomString(12); }   
            else{ if(this.vehicleDriverAndHostess_HostessId.equals("")){ this.vehicleDriverAndHostess_HostessId = UniqueId.RandomString(12);  }  }
            
            String Snc ="";
            Snc = createvehicleDriverAndHostess();
            if(Snc != null){
                if(!Snc.equals("")){yonlen = Snc;}
            }
            
        }
        
        if(sonuc == 1){
            
            if( this.urlPath.equals("edit_vehicle_s3") ){ 
                if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/personal/vehicle/edit_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&vParam2=ad&faces-redirect=true";}
                if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/corporate/vehicle/edit_vehicle_s4.xhtml?vId="+this.vehicle_Id+"&vParam2=ad&faces-redirect=true";}
                if(SessionUtil.getUserType().equals("director")){ yonlen = "/private/director/vehicles/edit_vehicle_s4.xhtml?vParam3=ad3&vParam2=ad&vId="+this.vehicle_Id+"&faces-redirect=true"; }
            }
            if( this.urlPath.equals("kullanici_detay_edit_vehicle_s3") ){yonlen = "/private/director/users/kullanici_detay_edit_vehicle_s4.xhtml?p=addVehicle_s1&vParam2=ad&aId="+this.aId+"&vId="+this.vehicle_Id+"&faces-redirect=true";}
           
        }
        
        return yonlen;
    } 
    public void fileUpload(String fileType) {
        
        try {
            
            if(fileType.equals("driver")){
                driver.setDriver_ProfilePictureUrl("/resources/media/" + FileUpload.uploadFile(this.driverPhotoFile));
            }
            else if (fileType.equals("hostess")) {
                hostess.setHostess_ProfilePictureUrl("/resources/media/" + FileUpload.uploadFile(this.hostessPhotoFile));
            }
            
        } 
        catch (IOException ex) { System.out.println(":::HATA:::" + ex);  }
    }

   public void validateFile(FacesContext ctx, UIComponent comp, Object value) {

       Functions.validateFile(ctx, comp, value);
    }  public void getVehicleDriverAndHostessWithVehicleId(String vId){
    
        
        VehicleDriverAndHostessDao vd = new VehicleDriverAndHostessDao();
        VehicleDriverAndHostessBean vbx = vd.getvehicleDriverAndHostessWithVehicleId(this.vehicle_Id);
         
        this.vehicleDriverAndHostess_Id = vbx.getVehicleDriverAndHostess_Id();
        this.vehicleDriverAndHostess_DriverInfo = vbx.getVehicleDriverAndHostess_DriverInfo();
        this.vehicleDriverAndHostess_DriverId = vbx.getVehicleDriverAndHostess_DriverId();
        this.vehicleDriverAndHostess_HostessInfo = vbx.getVehicleDriverAndHostess_HostessInfo();
        this.vehicleDriverAndHostess_HostessId = vd.getvehicleDriverAndHostessWithVehicleId(this.vehicle_Id).getVehicleDriverAndHostess_HostessId();
        this.vehicleDriverAndHostess_IsActive = vbx.isVehicleDriverAndHostess_IsActive();
        this.vehicleDriverAndHostess_Commnet = vbx.getVehicleDriverAndHostess_Commnet();
        this.vehicleDriverAndHostess_Modified = vbx.getVehicleDriverAndHostess_Modified();
        this.vehicleDriverAndHostess_Modifier = vbx.getVehicleDriverAndHostess_Modifier();
        this.vehicleDriverAndHostess_Created = vbx.getVehicleDriverAndHostess_Created();
        this.vehicleDriverAndHostess_creator = vbx.getVehicleDriverAndHostess_creator();
        driver = vbx.getDriver();
        hostess = vbx.getHostess();
        
       
}
    
        
        
        
        
}
