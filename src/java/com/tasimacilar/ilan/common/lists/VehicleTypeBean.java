package com.tasimacilar.ilan.common.lists;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "vehicleTypeBean")
@ViewScoped
public class VehicleTypeBean implements Serializable{ 
    private String      vehicleType_Id;             
    private String      vehicleType_RelationId;     
    private boolean     vehicleType_Bus;            
    private boolean     vehicleType_Midibuses;     
    private boolean     vehicleType_Minibus;       
    private boolean     vehicleType_Car;         
    private boolean     vehicleType_Truck;         
    private boolean     vehicleType_Vip;         
    private boolean     vehicleType_Other;        
    private String      vehicleType_OtherComment; 
    private boolean     vehicleType_IsActive;     
    private Date        vehicleType_Modified;       
    private String      vehicleType_Modifier;      
    private Date        vehicleType_Created;       
    private String      vehicleType_creator;       
    private String      vehicle_Id;             
    @PostConstruct
    public void init() {  
    } public VehicleTypeBean() {     }
    public VehicleTypeBean( String vehicleType_Id, boolean vehicleType_Bus, boolean vehicleType_Midibuses, 
                            boolean vehicleType_Minibus, boolean vehicleType_Car, boolean vehicleType_Truck, 
                            boolean vehicleType_Vip, boolean vehicleType_Other, String vehicleType_OtherComment, 
                            boolean vehicleType_IsActive, Date vehicleType_Modified, String vehicleType_Modifier, 
                            Date vehicleType_Created, String vehicleType_creator) {
        this.vehicleType_Id = vehicleType_Id;
        this.vehicleType_Bus = vehicleType_Bus;
        this.vehicleType_Midibuses = vehicleType_Midibuses;
        this.vehicleType_Minibus = vehicleType_Minibus;
        this.vehicleType_Car = vehicleType_Car;
        this.vehicleType_Truck = vehicleType_Truck;
        this.vehicleType_Vip = vehicleType_Vip;
        this.vehicleType_Other = vehicleType_Other;
        this.vehicleType_OtherComment = vehicleType_OtherComment;
        this.vehicleType_IsActive = vehicleType_IsActive;
        this.vehicleType_Modified = vehicleType_Modified;
        this.vehicleType_Modifier = vehicleType_Modifier;
        this.vehicleType_Created = vehicleType_Created;
        this.vehicleType_creator = vehicleType_creator;
}    public String getVehicleType_Id() {return vehicleType_Id;}
    public void setVehicleType_Id(String vehicleType_Id) {this.vehicleType_Id = vehicleType_Id;}
    public String getVehicleType_RelationId() { return vehicleType_RelationId; }
    public void setVehicleType_RelationId(String vehicleType_RelationId) {  this.vehicleType_RelationId = vehicleType_RelationId;}
    public boolean isVehicleType_Bus() {return vehicleType_Bus;}
    public void setVehicleType_Bus(boolean vehicleType_Bus) {this.vehicleType_Bus = vehicleType_Bus;}
    public boolean isVehicleType_Midibuses() {return vehicleType_Midibuses;}
    public void setVehicleType_Midibuses(boolean vehicleType_Midibuses) {this.vehicleType_Midibuses = vehicleType_Midibuses;}
    public boolean isVehicleType_Minibus() {return vehicleType_Minibus;}
    public void setVehicleType_Minibus(boolean vehicleType_Minibus) {this.vehicleType_Minibus = vehicleType_Minibus;}
    public boolean isVehicleType_Car() {return vehicleType_Car;}
    public void setVehicleType_Car(boolean vehicleType_Car) { this.vehicleType_Car = vehicleType_Car;}
    public boolean isVehicleType_Truck() {return vehicleType_Truck;}
    public void setVehicleType_Truck(boolean vehicleType_Truck) {this.vehicleType_Truck = vehicleType_Truck;}
    public boolean isVehicleType_Vip() { return vehicleType_Vip;}
    public void setVehicleType_Vip(boolean vehicleType_Vip) {this.vehicleType_Vip = vehicleType_Vip;}
    public boolean isVehicleType_Other() { return vehicleType_Other;}
    public void setVehicleType_Other(boolean vehicleType_Other) {this.vehicleType_Other = vehicleType_Other;}
    public String getVehicleType_OtherComment() {return vehicleType_OtherComment;}
    public void setVehicleType_OtherComment(String vehicleType_OtherComment) {this.vehicleType_OtherComment = vehicleType_OtherComment;}
    public boolean isVehicleType_IsActive() {return vehicleType_IsActive;}
    public void setVehicleType_IsActive(boolean vehicleType_IsActive) {this.vehicleType_IsActive = vehicleType_IsActive;}
    public Date getVehicleType_Modified() {return vehicleType_Modified;}
    public void setVehicleType_Modified(Date vehicleType_Modified) {this.vehicleType_Modified = vehicleType_Modified;}
    public String getVehicleType_Modifier() {return vehicleType_Modifier;}
    public void setVehicleType_Modifier(String vehicleType_Modifier) {this.vehicleType_Modifier = vehicleType_Modifier;}
    public Date getVehicleType_Created() {return vehicleType_Created;}
    public void setVehicleType_Created(Date vehicleType_Created) {this.vehicleType_Created = vehicleType_Created;}
    public String getVehicleType_creator() {return vehicleType_creator;}
    public void setVehicleType_creator(String vehicleType_creator) {this.vehicleType_creator = vehicleType_creator;}
    public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}
    @Override
    public String toString() {
        return "VehicleTypeBean{"   + "vehicleType_Id=" + vehicleType_Id 
                                    + ", vehicleType_Bus=" + vehicleType_Bus 
                                    + ", vehicleType_Midibuses=" + vehicleType_Midibuses 
                                    + ", vehicleType_Minibus=" + vehicleType_Minibus 
                                    + ", vehicleType_Car=" + vehicleType_Car 
                                    + ", vehicleType_Truck=" + vehicleType_Truck 
                                    + ", vehicleType_Vip=" + vehicleType_Vip 
                                    + ", vehicleType_Other=" + vehicleType_Other 
                                    + ", vehicleType_OtherComment=" + vehicleType_OtherComment 
                                    + ", vehicleType_IsActive=" + vehicleType_IsActive 
                                    + ", vehicleType_Modified=" + vehicleType_Modified 
                                    + ", vehicleType_Modifier=" + vehicleType_Modifier 
                                    + ", vehicleType_Created=" + vehicleType_Created 
                                    + ", vehicleType_creator=" + vehicleType_creator + '}';
    }


    
    
    
}
