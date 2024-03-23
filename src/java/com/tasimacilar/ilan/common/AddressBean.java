package com.tasimacilar.ilan.common;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "addressBean")
@ViewScoped
public class AddressBean implements Serializable {  
    private String  address_Id;                     
    private int     address_TypeId;                 
    private String  address_Name;                  
    private String  address;                        
    private int     address_CountryId;           
    private int     address_CityId;                
    private int     address_TownId;               
    private int     address_DistrictId;             
    private int     address_NeighborhoodId;        
    private String  address_PostCode;               
    private String  address_location_Latitude;     
    private String  address_location_Longitude;   
    private Date    address_create_time;            
    private Date    address_last_change_time;     
    private String  address_last_Changer_account_id;
    @PostConstruct
    public void init() {  }
    public AddressBean() { }
    public AddressBean( String address_Id, int address_TypeId, 
                        String address_Name, String address, int address_CountryId, 
                        int address_CityId, int address_TownId, int address_DistrictId, 
                        int address_NeighborhoodId, String address_PostCode, 
                        String address_location_Latitude, String address_location_Longitude) {
        this.address_Id = address_Id;    
        this.address_TypeId = address_TypeId;
        this.address_Name = address_Name;
        this.address = address;
        this.address_CountryId = address_CountryId;
        this.address_CityId = address_CityId;
        this.address_TownId = address_TownId;
        this.address_DistrictId = address_DistrictId;
        this.address_NeighborhoodId = address_NeighborhoodId;
        this.address_PostCode = address_PostCode;
        this.address_location_Latitude = address_location_Latitude;
        this.address_location_Longitude = address_location_Longitude;
}  public String getAddress_Id() {return address_Id;}
    public void setAddress_Id(String address_Id) {this.address_Id = address_Id;}
    public int getAddress_TypeId() {return address_TypeId;}
    public void setAddress_TypeId(int address_TypeId) {this.address_TypeId = address_TypeId;}
    public String getAddress_Name() {return address_Name;}
    public void setAddress_Name(String address_Name) {this.address_Name = address_Name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public int getAddress_CountryId() {return address_CountryId;}
    public void setAddress_CountryId(int address_CountryId) {this.address_CountryId = address_CountryId;}  
    public int getAddress_CityId() {return address_CityId;}
    public void setAddress_CityId(int address_CityId) {this.address_CityId = address_CityId;}  
    public int getAddress_TownId() {return address_TownId;}
    public void setAddress_TownId(int address_TownId) {this.address_TownId = address_TownId;}
    public int getAddress_DistrictId() {return address_DistrictId;}
    public void setAddress_DistrictId(int address_DistrictId) {this.address_DistrictId = address_DistrictId;}
    public int getAddress_NeighborhoodId() {return address_NeighborhoodId;}
    public void setAddress_NeighborhoodId(int address_NeighborhoodId) {this.address_NeighborhoodId = address_NeighborhoodId;}
    public String getAddress_PostCode() {return address_PostCode;}
    public void setAddress_PostCode(String address_PostCode) {this.address_PostCode = address_PostCode;}
    public String getAddress_location_Latitude() {return address_location_Latitude;}
    public void setAddress_location_Latitude(String address_location_Latitude) {this.address_location_Latitude = address_location_Latitude;}
    public String getAddress_location_Longitude() {return address_location_Longitude;}
    public void setAddress_location_Longitude(String address_location_Longitude) {this.address_location_Longitude = address_location_Longitude;}  
    public Date getAddress_create_time() {return address_create_time;}
    public void setAddress_create_time(Date address_create_time) {this.address_create_time = address_create_time;}
    public Date getAddress_last_change_time() {return address_last_change_time;}
    public void setAddress_last_change_time(Date address_last_change_time) {this.address_last_change_time = address_last_change_time;}
    public String getAddress_last_Changer_account_id() {return address_last_Changer_account_id;}
    public void setAddress_last_Changer_account_id(String address_last_Changer_account_id) {this.address_last_Changer_account_id = address_last_Changer_account_id;}

    
    
    
}
