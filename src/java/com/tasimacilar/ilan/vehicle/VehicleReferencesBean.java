
package com.tasimacilar.ilan.vehicle;

import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;


@ManagedBean(name = "vehicleReferencesBean")
@ViewScoped
public class VehicleReferencesBean implements Serializable{
  
    
    private String      vehicleReferences_Id;
    private String      vehicleReferences_Company;                 
    private String      vehicleReferences_Project;                 
    private Date        vehicleReferences_ProjectStartDate;        
    private Date        vehicleReferences_ProjectEndDate;           
    private int         vehicleReferences_ProjectDate;             
    private Date        vehicleReferences_Modified;                
    private String      vehicleReferences_Modifier;               
    private Date        vehicleReferences_Created;               
    private String      vehicleReferences_creator;                
    private String      vehicle_Id;                               
    
    private List<VehicleReferencesBean> VehicleReferencesList = new ArrayList<VehicleReferencesBean>();
    
    private String      urlPath="";
    private String      aId;
    @PostConstruct
    public void init() {   
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        aId = req.getParameter("aId");
        String url = req.getRequestURL().toString();
        
        try {    URL urlx = new URL(url);  
            
                this.urlPath = FilenameUtils.getBaseName(urlx.getPath());
            } 
        catch (MalformedURLException ex) { System.out.println(":::HATA:::"+ex);   }
               
        String vId = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(facesContext != null){
            this.vehicle_Id = facesContext.getExternalContext().getRequestParameterMap().get("vId");
            getAllVehicleReferenceWithVehicleId(this.vehicle_Id);
        }
        
    }
    public VehicleReferencesBean() { }
 
    public VehicleReferencesBean(   String vehicleReferences_Id, 
                                    String vehicleReferences_Company, 
                                    String vehicleReferences_Project, 
                                    Date vehicleReferences_ProjectStartDate, 
                                    Date vehicleReferences_ProjectEndDate, 
                                    Date vehicleReferences_Modified, 
                                    String vehicleReferences_Modifier, 
                                    Date vehicleReferences_Created, 
                                    String vehicleReferences_creator, 
                                    String vehicle_Id) {
        this.vehicleReferences_Id = vehicleReferences_Id;
        this.vehicleReferences_Company = vehicleReferences_Company;
        this.vehicleReferences_Project = vehicleReferences_Project;
        this.vehicleReferences_ProjectStartDate = vehicleReferences_ProjectStartDate;
        this.vehicleReferences_ProjectEndDate = vehicleReferences_ProjectEndDate;
        this.vehicleReferences_Modified = vehicleReferences_Modified;
        this.vehicleReferences_Modifier = vehicleReferences_Modifier;
        this.vehicleReferences_Created = vehicleReferences_Created;
        this.vehicleReferences_creator = vehicleReferences_creator;
        this.vehicle_Id = vehicle_Id;
    }
    public String getVehicleReferences_Id() {return vehicleReferences_Id;}
    public void setVehicleReferences_Id(String vehicleReferences_Id) {this.vehicleReferences_Id = vehicleReferences_Id;}
    public String getVehicleReferences_Company() {return vehicleReferences_Company;}
    public void setVehicleReferences_Company(String vehicleReferences_Company) {this.vehicleReferences_Company = vehicleReferences_Company;}
    public String getVehicleReferences_Project() {return vehicleReferences_Project;}
    public void setVehicleReferences_Project(String vehicleReferences_Project) {this.vehicleReferences_Project = vehicleReferences_Project;}
    public Date getVehicleReferences_ProjectStartDate() {return vehicleReferences_ProjectStartDate;}
    public void setVehicleReferences_ProjectStartDate(Date vehicleReferences_ProjectStartDate) {this.vehicleReferences_ProjectStartDate = vehicleReferences_ProjectStartDate;}
    public Date getVehicleReferences_ProjectEndDate() {return vehicleReferences_ProjectEndDate;}
    public void setVehicleReferences_ProjectEndDate(Date vehicleReferences_ProjectEndDate) {this.vehicleReferences_ProjectEndDate = vehicleReferences_ProjectEndDate;}
    public int getVehicleReferences_ProjectDate() {return vehicleReferences_ProjectDate;}
    public void setVehicleReferences_ProjectDate(int vehicleReferences_ProjectDate) {this.vehicleReferences_ProjectDate = vehicleReferences_ProjectDate;}
    public Date getVehicleReferences_Modified() {return vehicleReferences_Modified;}
    public void setVehicleReferences_Modified(Date vehicleReferences_Modified) {this.vehicleReferences_Modified = vehicleReferences_Modified;}
    public String getVehicleReferences_Modifier() {return vehicleReferences_Modifier;}
    public void setVehicleReferences_Modifier(String vehicleReferences_Modifier) {this.vehicleReferences_Modifier = vehicleReferences_Modifier;}
    public Date getVehicleReferences_Created() {return vehicleReferences_Created;}
    public void setVehicleReferences_Created(Date vehicleReferences_Created) {this.vehicleReferences_Created = vehicleReferences_Created;}
    public String getVehicleReferences_creator() {return vehicleReferences_creator;}
    public void setVehicleReferences_creator(String vehicleReferences_creator) {this.vehicleReferences_creator = vehicleReferences_creator;}
    public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}    
    public List<VehicleReferencesBean> getVehicleReferencesList() {return VehicleReferencesList;}
    public void setVehicleReferencesList(List<VehicleReferencesBean> VehicleReferencesList) {this.VehicleReferencesList = VehicleReferencesList;}
    public String getaId() { return aId;}
    public void setaId(String aId) { this.aId = aId;}
public void createVehicleReference() { 
        
        if( this.vehicleReferences_Company != null && 
            !this.vehicleReferences_Company.equals("") ){
        
                int sonuc = 0;
                String ovnerAccountIdx = SessionUtil.getUserId();

                VehicleReferencesBean v = new VehicleReferencesBean();
                v.setVehicleReferences_Id(UniqueId.RandomString(12));
                v.setVehicleReferences_Company(this.vehicleReferences_Company);
                v.setVehicleReferences_Project(this.vehicleReferences_Project);
                v.setVehicleReferences_ProjectStartDate(new Date());
                v.setVehicleReferences_ProjectEndDate(new Date());
                v.setVehicleReferences_ProjectDate(this.vehicleReferences_ProjectDate);
                v.setVehicleReferences_Modified(new Date());
                v.setVehicleReferences_Modifier(ovnerAccountIdx);
                v.setVehicleReferences_Created(new Date());
                v.setVehicleReferences_creator(ovnerAccountIdx);
                v.setVehicle_Id(this.vehicle_Id );

                if(this.vehicle_Id != null && !this.vehicle_Id.equals("")){
                    VehicleReferencesDao vd = new VehicleReferencesDao();
                    sonuc = vd.createVehicleReference(v);
                }
                
                if(sonuc == 1){
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARILI","Referans ekleme başarılı");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    facesContext.addMessage(null, facesMessage);
                    
                    facesContext.renderResponse();
                    this.VehicleReferencesList.clear();
                    getAllVehicleReferenceWithVehicleId(this.vehicle_Id);

                    this.vehicleReferences_Company=null;
                    this.vehicleReferences_Project=null;
                    this.vehicleReferences_ProjectStartDate=null;
                    this.vehicleReferences_ProjectEndDate = null;
                    this.vehicleReferences_ProjectDate = 0;
                }
                else{
                    System.err.println(":::HATA:::Referans ekleme sırasında sorun oluştu");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Referans ekleme sırasında sorun oluştu");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                }
        }
        else{
            System.err.println(":::HATA:::Tüm Araç referans bilgilerini gelmedi");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Tüm Araç referans bilgilerini doldurmalısınız");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        
     
        
    
    }public void getAllVehicleReferenceWithVehicleId(String vehicleId) {
        
        VehicleReferencesDao vd = new VehicleReferencesDao();
        this.VehicleReferencesList = vd.getAllVehicleReferenceWithVehicleId(vehicleId);
    }public List<VehicleReferencesBean> getAllVehicleReferenceWithVehicleId2(String vehicleId) {
        
        VehicleReferencesDao vd = new VehicleReferencesDao();
        return  vd.getAllVehicleReferenceWithVehicleId(vehicleId);
    }public void deleteVehicleReference(String vehicleReferencesId) {
        
        int sonuc = 0;
        VehicleReferencesDao vd = new VehicleReferencesDao();
        sonuc = vd.deleteVehicleReference(vehicleReferencesId);
        
        if(sonuc==1){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Referans silme başarılı");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
            
            this.VehicleReferencesList.clear();
            getAllVehicleReferenceWithVehicleId(this.vehicle_Id);
        }
        else{
            System.err.println(":::HATA:::Referans silme sırasında sorun oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Referans silme sırasında sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    } public String govehicleDriverAndHostessPage (){
        
        String yonlen="";
        
        if( this.urlPath.equals("add_vehicle_s2") ){  
            if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/personal/vehicle/add_vehicle_s3.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
            if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/corporate/vehicle/add_vehicle_s3.xhtml?vId="+this.vehicle_Id+"&faces-redirect=true";}
        }
        if( this.urlPath.equals("kullanici_detay_yeni_arac_ekle_s2") ){ yonlen = "/private/director/users/kullanici_detay_yeni_arac_ekle_s3.xhtml?p=addVehicle_s1&aId="+this.aId+"&vId="+this.vehicle_Id+"&faces-redirect=true"; }         
                        
        
        return yonlen;
    }public String govehicleDriverAndHostessPage2 (){
        
        String yonlen = "";
        
        if( this.urlPath.equals("edit_vehicle_s2") ){ 
            if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/personal/vehicle/edit_vehicle_s3.xhtml?vId="+this.vehicle_Id+"&vParam2=ad&faces-redirect=true"; }
            if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/corporate/vehicle/edit_vehicle_s3.xhtml?vId="+this.vehicle_Id+"&vParam2=ad&faces-redirect=true";}
            if(SessionUtil.getUserType().equals("director")){yonlen = "/private/director/vehicles/edit_vehicle_s3.xhtml?vParam3=ad3&vParam2=ad&vId="+this.vehicle_Id+"&faces-redirect=true";  }
        }
        if( this.urlPath.equals("kullanici_detay_edit_vehicle_s2") ){ yonlen = "/private/director/users/kullanici_detay_edit_vehicle_s3.xhtml?p=addVehicle_s1&vParam2=ad&aId="+this.aId+"&vId="+this.vehicle_Id+"&faces-redirect=true";  }
       
        
        return yonlen;
    }
    
}
