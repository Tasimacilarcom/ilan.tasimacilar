
package com.tasimacilar.ilan.vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "VehicleBrandAndModelBean")
@ViewScoped
public class VehicleBrandAndModelBean implements Serializable{
 
    
    private int         vehicleBrand_Id;
    private String      vehicleBrand_Name;

    public VehicleBrandAndModelBean() {
    }
  public int getVehicleBrand_Id() {return vehicleBrand_Id;}
    public void setVehicleBrand_Id(int vehicleBrand_Id) {this.vehicleBrand_Id = vehicleBrand_Id;}

    public String getVehicleBrand_Name() {return vehicleBrand_Name;}
    public void setVehicleBrand_Name(String vehicleBrand_Name) {this.vehicleBrand_Name = vehicleBrand_Name;}
    
/  
     
     
     
     
     
     
     
     
     
     
    
}
