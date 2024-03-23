package com.tasimacilar.ilan.common.lists;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "serviceTypeBean")
@ViewScoped
public class ServiceTypeBean implements Serializable {

    private String  serviceType_Id;
    private boolean serviceType_School;            
    private boolean serviceType_Staff;              
    private boolean serviceType_Tourism;           
    private boolean serviceType_Intercity;        
    private boolean serviceType_Minibus;            
    private boolean serviceType_PublicTransport;   
    private boolean serviceType_Ambulance;         
    private boolean serviceType_Taxi;             
    private String  serviceType_Other;              
    private String  ad_Id;                          
public ServiceTypeBean() {  }
    public String getServiceType_Id() {return serviceType_Id;}
    public void setServiceType_Id(String serviceType_Id) {this.serviceType_Id = serviceType_Id;}
    public boolean isServiceType_School() {return serviceType_School;}
    public void setServiceType_School(boolean serviceType_School) {this.serviceType_School = serviceType_School;}
    public boolean isServiceType_Staff() {return serviceType_Staff;}
    public void setServiceType_Staff(boolean serviceType_Staff) {this.serviceType_Staff = serviceType_Staff;}
    public boolean isServiceType_Tourism() {return serviceType_Tourism;}
    public void setServiceType_Tourism(boolean serviceType_Tourism) {this.serviceType_Tourism = serviceType_Tourism;}
    public boolean isServiceType_Intercity() {return serviceType_Intercity;}
    public void setServiceType_Intercity(boolean serviceType_Intercity) {this.serviceType_Intercity = serviceType_Intercity;}
    public boolean isServiceType_Minibus() {return serviceType_Minibus;}
    public void setServiceType_Minibus(boolean serviceType_Minibus) { this.serviceType_Minibus = serviceType_Minibus;}
    public boolean isServiceType_PublicTransport() {return serviceType_PublicTransport;}
    public void setServiceType_PublicTransport(boolean serviceType_PublicTransport) { this.serviceType_PublicTransport = serviceType_PublicTransport;}
    public boolean isServiceType_Ambulance() {return serviceType_Ambulance;}
    public void setServiceType_Ambulance(boolean serviceType_Ambulance) {this.serviceType_Ambulance = serviceType_Ambulance;}
    public boolean isServiceType_Taxi() {return serviceType_Taxi;}
    public void setServiceType_Taxi(boolean serviceType_Taxi) {this.serviceType_Taxi = serviceType_Taxi;}
    public String getServiceType_Other() { return serviceType_Other;}
    public void setServiceType_Other(String serviceType_Other) {this.serviceType_Other = serviceType_Other;}
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}

   
}
