
package com.tasimacilar.ilan.vehicle;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


public class VehicleProperties implements Serializable{
    
    
    private String      vehicleProperties_Id;                       
    private boolean     vehicleProperties_TvAndSatellite;          
    private boolean     vehicleProperties_CoffeeAndTeaMachine;     
    private boolean     vehicleProperties_AirConditioner;         
    private boolean     vehicleProperties_Abs;                  
    private boolean     vehicleProperties_LeatherUpholstery;       
    private boolean     vehicleProperties_CentralLocking;           
    private boolean     vehicleProperties_AlarmSystem;        
    private boolean     vehicleProperties_CarCamera;            
    private boolean     vehicleProperties_CDPlayer;               
    private boolean     vehicleProperties_AudioMP3Player;         
    private boolean     vehicleProperties_Gps;                    
    private boolean     vehicleProperties_Navigation;              
    private boolean     vehicleProperties_Sunroof;              
    private boolean     vehicleProperties_Internet;              
    private boolean     vehicleProperties_Refrigerator;      
    private boolean     vehicleProperties_Telephone;            
    private boolean     vehicleProperties_TribuneCeiling;         
    private boolean     vehicleProperties_DisabledEquipment;      
    private boolean     vehicleProperties_CompanyLogo;             
    private boolean     vehicleProperties_VipHardware;             
    private boolean     vehicleProperties_Diesel;                  
    private boolean     vehicleProperties_Other;                 
    private String      vehicleProperties_OtherComment;            
    private Date        vehicleProperties_Modified;               
    private String      vehicleProperties_Modifier;               
    private Date        vehicleProperties_Created;               
    private String      vehicleProperties_creator;                 
    private String      vehicle_Id;                              
public VehicleProperties() {  }
public VehicleProperties(   String vehicleProperties_Id, 
                                    boolean vehicleProperties_TvAndSatellite, 
                                    boolean vehicleProperties_CoffeeAndTeaMachine, 
                                    boolean vehicleProperties_AirConditioner, 
                                    boolean vehicleProperties_Abs, 
                                    boolean vehicleProperties_LeatherUpholstery, 
                                    boolean vehicleProperties_CentralLocking, 
                                    boolean vehicleProperties_AlarmSystem, 
                                    boolean vehicleProperties_CarCamera, 
                                    boolean vehicleProperties_CDPlayer, 
                                    boolean vehicleProperties_AudioMP3Player, 
                                    boolean vehicleProperties_Gps, 
                                    boolean vehicleProperties_Navigation, 
                                    boolean vehicleProperties_Sunroof, 
                                    boolean vehicleProperties_Internet, 
                                    boolean vehicleProperties_Refrigerator, 
                                    boolean vehicleProperties_Telephone, 
                                    boolean vehicleProperties_TribuneCeiling, 
                                    boolean vehicleProperties_DisabledEquipment, 
                                    boolean vehicleProperties_CompanyLogo, 
                                    boolean vehicleProperties_VipHardware, 
                                    boolean vehicleProperties_Diesel, 
                                    boolean vehicleProperties_Other, 
                                    String vehicleProperties_OtherComment, 
                                    Date vehicleProperties_Modified, 
                                    String vehicleProperties_Modifier, 
                                    Date vehicleProperties_Created, 
                                    String vehicleProperties_creator, 
                                    String vehicle_Id) {
        this.vehicleProperties_Id = vehicleProperties_Id;
        this.vehicleProperties_TvAndSatellite = vehicleProperties_TvAndSatellite;
        this.vehicleProperties_CoffeeAndTeaMachine = vehicleProperties_CoffeeAndTeaMachine;
        this.vehicleProperties_AirConditioner = vehicleProperties_AirConditioner;
        this.vehicleProperties_Abs = vehicleProperties_Abs;
        this.vehicleProperties_LeatherUpholstery = vehicleProperties_LeatherUpholstery;
        this.vehicleProperties_CentralLocking = vehicleProperties_CentralLocking;
        this.vehicleProperties_AlarmSystem = vehicleProperties_AlarmSystem;
        this.vehicleProperties_CarCamera = vehicleProperties_CarCamera;
        this.vehicleProperties_CDPlayer = vehicleProperties_CDPlayer;
        this.vehicleProperties_AudioMP3Player = vehicleProperties_AudioMP3Player;
        this.vehicleProperties_Gps = vehicleProperties_Gps;
        this.vehicleProperties_Navigation = vehicleProperties_Navigation;
        this.vehicleProperties_Sunroof = vehicleProperties_Sunroof;
        this.vehicleProperties_Internet = vehicleProperties_Internet;
        this.vehicleProperties_Refrigerator = vehicleProperties_Refrigerator;
        this.vehicleProperties_Telephone = vehicleProperties_Telephone;
        this.vehicleProperties_TribuneCeiling = vehicleProperties_TribuneCeiling;
        this.vehicleProperties_DisabledEquipment = vehicleProperties_DisabledEquipment;
        this.vehicleProperties_CompanyLogo = vehicleProperties_CompanyLogo;
        this.vehicleProperties_VipHardware = vehicleProperties_VipHardware;
        this.vehicleProperties_Diesel = vehicleProperties_Diesel;
        this.vehicleProperties_Other = vehicleProperties_Other;
        this.vehicleProperties_OtherComment = vehicleProperties_OtherComment;
        this.vehicleProperties_Modified = vehicleProperties_Modified;
        this.vehicleProperties_Modifier = vehicleProperties_Modifier;
        this.vehicleProperties_Created = vehicleProperties_Created;
        this.vehicleProperties_creator = vehicleProperties_creator;
        this.vehicle_Id = vehicle_Id;
    }
    public String getVehicleProperties_Id() {return vehicleProperties_Id;}
    public void setVehicleProperties_Id(String vehicleProperties_Id) {this.vehicleProperties_Id = vehicleProperties_Id;}
    public boolean isVehicleProperties_TvAndSatellite() {return vehicleProperties_TvAndSatellite;}
    public void setVehicleProperties_TvAndSatellite(boolean vehicleProperties_TvAndSatellite) {this.vehicleProperties_TvAndSatellite = vehicleProperties_TvAndSatellite;}
    public boolean isVehicleProperties_CoffeeAndTeaMachine() {return vehicleProperties_CoffeeAndTeaMachine;}
    public void setVehicleProperties_CoffeeAndTeaMachine(boolean vehicleProperties_CoffeeAndTeaMachine) {this.vehicleProperties_CoffeeAndTeaMachine = vehicleProperties_CoffeeAndTeaMachine;}
    public boolean isVehicleProperties_AirConditioner() {return vehicleProperties_AirConditioner;}
    public void setVehicleProperties_AirConditioner(boolean vehicleProperties_AirConditioner) {this.vehicleProperties_AirConditioner = vehicleProperties_AirConditioner;}
    public boolean isVehicleProperties_Abs() {return vehicleProperties_Abs;}
    public void setVehicleProperties_Abs(boolean vehicleProperties_Abs) {this.vehicleProperties_Abs = vehicleProperties_Abs;}
    public boolean isVehicleProperties_LeatherUpholstery() {return vehicleProperties_LeatherUpholstery;}
    public void setVehicleProperties_LeatherUpholstery(boolean vehicleProperties_LeatherUpholstery) {this.vehicleProperties_LeatherUpholstery = vehicleProperties_LeatherUpholstery;}
    public boolean isVehicleProperties_CentralLocking() {return vehicleProperties_CentralLocking;}
    public void setVehicleProperties_CentralLocking(boolean vehicleProperties_CentralLocking) {this.vehicleProperties_CentralLocking = vehicleProperties_CentralLocking;}
    public boolean isVehicleProperties_AlarmSystem() {return vehicleProperties_AlarmSystem;}
    public void setVehicleProperties_AlarmSystem(boolean vehicleProperties_AlarmSystem) {this.vehicleProperties_AlarmSystem = vehicleProperties_AlarmSystem;}
    public boolean isVehicleProperties_CarCamera() {return vehicleProperties_CarCamera;}
    public void setVehicleProperties_CarCamera(boolean vehicleProperties_CarCamera) {this.vehicleProperties_CarCamera = vehicleProperties_CarCamera;}
    public boolean isVehicleProperties_CDPlayer() {return vehicleProperties_CDPlayer;}
    public void setVehicleProperties_CDPlayer(boolean vehicleProperties_CDPlayer) {this.vehicleProperties_CDPlayer = vehicleProperties_CDPlayer;}
    public boolean isVehicleProperties_AudioMP3Player() {return vehicleProperties_AudioMP3Player;}
    public void setVehicleProperties_AudioMP3Player(boolean vehicleProperties_AudioMP3Player) {this.vehicleProperties_AudioMP3Player = vehicleProperties_AudioMP3Player;}
    public boolean isVehicleProperties_Gps() {return vehicleProperties_Gps;}
    public void setVehicleProperties_Gps(boolean vehicleProperties_Gps) {this.vehicleProperties_Gps = vehicleProperties_Gps;}
    public boolean isVehicleProperties_Navigation() {return vehicleProperties_Navigation;}
    public void setVehicleProperties_Navigation(boolean vehicleProperties_Navigation) {this.vehicleProperties_Navigation = vehicleProperties_Navigation;}
    public boolean isVehicleProperties_Sunroof() {return vehicleProperties_Sunroof;}
    public void setVehicleProperties_Sunroof(boolean vehicleProperties_Sunroof) {this.vehicleProperties_Sunroof = vehicleProperties_Sunroof;}
    public boolean isVehicleProperties_Internet() {return vehicleProperties_Internet;}
    public void setVehicleProperties_Internet(boolean vehicleProperties_Internet) {this.vehicleProperties_Internet = vehicleProperties_Internet;}
    public boolean isVehicleProperties_Refrigerator() {return vehicleProperties_Refrigerator;}
    public void setVehicleProperties_Refrigerator(boolean vehicleProperties_Refrigerator) {this.vehicleProperties_Refrigerator = vehicleProperties_Refrigerator;}
    public boolean isVehicleProperties_Telephone() {return vehicleProperties_Telephone;}
    public void setVehicleProperties_Telephone(boolean vehicleProperties_Telephone) {this.vehicleProperties_Telephone = vehicleProperties_Telephone;}
    public boolean isVehicleProperties_TribuneCeiling() {return vehicleProperties_TribuneCeiling;}
    public void setVehicleProperties_TribuneCeiling(boolean vehicleProperties_TribuneCeiling) {this.vehicleProperties_TribuneCeiling = vehicleProperties_TribuneCeiling;}
    public boolean isVehicleProperties_DisabledEquipment() {return vehicleProperties_DisabledEquipment;}
    public void setVehicleProperties_DisabledEquipment(boolean vehicleProperties_DisabledEquipment) {this.vehicleProperties_DisabledEquipment = vehicleProperties_DisabledEquipment;}
    public boolean isVehicleProperties_CompanyLogo() {return vehicleProperties_CompanyLogo;}
    public void setVehicleProperties_CompanyLogo(boolean vehicleProperties_CompanyLogo) {this.vehicleProperties_CompanyLogo = vehicleProperties_CompanyLogo;}
    public boolean isVehicleProperties_VipHardware() {return vehicleProperties_VipHardware;}
    public void setVehicleProperties_VipHardware(boolean vehicleProperties_VipHardware) {this.vehicleProperties_VipHardware = vehicleProperties_VipHardware;}
    public boolean isVehicleProperties_Diesel() {return vehicleProperties_Diesel;}
    public void setVehicleProperties_Diesel(boolean vehicleProperties_Diesel) { this.vehicleProperties_Diesel = vehicleProperties_Diesel;}
    public boolean isVehicleProperties_Other() {return vehicleProperties_Other;}
    public void setVehicleProperties_Other(boolean vehicleProperties_Other) {this.vehicleProperties_Other = vehicleProperties_Other;}
    public String getVehicleProperties_OtherComment() {return vehicleProperties_OtherComment;}
    public void setVehicleProperties_OtherComment(String vehicleProperties_OtherComment) {this.vehicleProperties_OtherComment = vehicleProperties_OtherComment;}
    public Date getVehicleProperties_Modified() {return vehicleProperties_Modified;}
    public void setVehicleProperties_Modified(Date vehicleProperties_Modified) {this.vehicleProperties_Modified = vehicleProperties_Modified;}
    public String getVehicleProperties_Modifier() {return vehicleProperties_Modifier;}
    public void setVehicleProperties_Modifier(String vehicleProperties_Modifier) {this.vehicleProperties_Modifier = vehicleProperties_Modifier;}
    public Date getVehicleProperties_Created() {return vehicleProperties_Created;}
    public void setVehicleProperties_Created(Date vehicleProperties_Created) {this.vehicleProperties_Created = vehicleProperties_Created;}
    public String getVehicleProperties_creator() {return vehicleProperties_creator;}
    public void setVehicleProperties_creator(String vehicleProperties_creator) {this.vehicleProperties_creator = vehicleProperties_creator;}
    public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}
    

    
    
    
    

    
    
    
}
