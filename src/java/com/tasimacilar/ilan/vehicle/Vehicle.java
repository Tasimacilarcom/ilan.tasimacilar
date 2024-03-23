package com.tasimacilar.ilan.vehicle;
import java.io.Serializable;
import java.util.Date;
public class Vehicle implements Serializable{
    
    private String      vehicle_Id;                     
    private int         vehicle_PlateProvinceCode;      
    private int         vehicle_PlateProvinceCode2;    
    private String      vehicle_PlateLatterCode;        
    private String      vehicle_PlateLatterCode2;       
    private int         vehicle_PlateNumberCode;     
    private int         vehicle_PlateNumberCode2;       
    private Boolean     vehicle_PlateLicense;           
    private String      vehicle_Brand;                
    private String      vehicle_BrandId;              
    private String[]    Vehicle_Brands;               
    private boolean     vehicle_BrandNotMatter;        
    private String      vehicle_Model;                
    private String      vehicle_ModelYear;            
    private boolean     vehicle_ModelYearAndOver;      
    private boolean     vehicle_ModelYearNotMatter;     
    private String      vehicle_NumberOfSeats;        
    private int         vehicle_Km;                  
    private String      vehicle_Color;                  
    private Boolean     vehicle_CompanyLogo;           
    private String      vehicle_CompanyLogoText;       
    private String      vehicle_OvnerAccountId;         
    private boolean     vehicle_IsActive;              
    private String      vehicle_Commnet;              
    private Date        vehicle_Modified;               
    private String      vehicle_Modifier;             
    private Date        vehicle_Created;               
    private String      vehicle_creator;             
    private String      vehicle_ServiceTypes;          
    private String[]    vehicle_ServiceTypesList;       
    private String      vehicle_AuthorityDocuments;     
    private String[]    vehicle_AuthorityDocumentsList; 
    private String      vehicle_VehicleProperties;      
    private String[]    vehicle_VehiclePropertiesList;  
    private String      vehicle_Typ;                    
    private String[]    vehicle_Types;                  
    private String      vehicle_DriverInfo;             
    private String      vehicle_HostessInfo;           
    private VehicleImages   vehicleImages;           
    private int      ilanId_old;    
    private int      uyeId_old;    
      public Vehicle() {  }
     public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}
    public int getVehicle_PlateProvinceCode() {return vehicle_PlateProvinceCode;}
    public void setVehicle_PlateProvinceCode(int vehicle_PlateProvinceCode) {this.vehicle_PlateProvinceCode = vehicle_PlateProvinceCode;}
    public int getVehicle_PlateProvinceCode2() {return vehicle_PlateProvinceCode2;}
    public void setVehicle_PlateProvinceCode2(int vehicle_PlateProvinceCode2) {this.vehicle_PlateProvinceCode2 = vehicle_PlateProvinceCode2;}
    public String getVehicle_PlateLatterCode() { return vehicle_PlateLatterCode;}
    public void setVehicle_PlateLatterCode(String vehicle_PlateLatterCode) { this.vehicle_PlateLatterCode = vehicle_PlateLatterCode;}
    public String getVehicle_PlateLatterCode2() { return vehicle_PlateLatterCode2;}
    public void setVehicle_PlateLatterCode2(String vehicle_PlateLatterCode2) { this.vehicle_PlateLatterCode2 = vehicle_PlateLatterCode2;}
    public int getVehicle_PlateNumberCode() {return vehicle_PlateNumberCode;}
    public void setVehicle_PlateNumberCode(int vehicle_PlateNumberCode) { this.vehicle_PlateNumberCode = vehicle_PlateNumberCode;}
    public int getVehicle_PlateNumberCode2() {return vehicle_PlateNumberCode2;}
    public void setVehicle_PlateNumberCode2(int vehicle_PlateNumberCode2) {this.vehicle_PlateNumberCode2 = vehicle_PlateNumberCode2;}
    public Boolean getVehicle_PlateLicense() {return vehicle_PlateLicense;}
    public void setVehicle_PlateLicense(Boolean vehicle_PlateLicense) {this.vehicle_PlateLicense = vehicle_PlateLicense;}
    public String getVehicle_Brand() {return vehicle_Brand;}
    public void setVehicle_Brand(String vehicle_Brand) {this.vehicle_Brand = vehicle_Brand;}
    public String getVehicle_BrandId() {return vehicle_BrandId;}
    public void setVehicle_BrandId(String vehicle_BrandId) {this.vehicle_BrandId = vehicle_BrandId;}
    public String[] getVehicle_Brands() {return Vehicle_Brands;}
    public void setVehicle_Brands(String[] Vehicle_Brands) {this.Vehicle_Brands = Vehicle_Brands;}
    public boolean isVehicle_BrandNotMatter() {return vehicle_BrandNotMatter;}
    public void setVehicle_BrandNotMatter(boolean vehicle_BrandNotMatter) {this.vehicle_BrandNotMatter = vehicle_BrandNotMatter;}
    public String getVehicle_Model() {return vehicle_Model;}
    public void setVehicle_Model(String vehicle_Model) {this.vehicle_Model = vehicle_Model;}
    public String getVehicle_ModelYear() { return vehicle_ModelYear;}
    public void setVehicle_ModelYear(String vehicle_ModelYear) {this.vehicle_ModelYear = vehicle_ModelYear;}
    public boolean isVehicle_ModelYearAndOver() {return vehicle_ModelYearAndOver;}
    public void setVehicle_ModelYearAndOver(boolean vehicle_ModelYearAndOver) {this.vehicle_ModelYearAndOver = vehicle_ModelYearAndOver;}
    public boolean isVehicle_ModelYearNotMatter() {return vehicle_ModelYearNotMatter;}
    public void setVehicle_ModelYearNotMatter(boolean vehicle_ModelYearNotMatter) {this.vehicle_ModelYearNotMatter = vehicle_ModelYearNotMatter;}
    public String getVehicle_NumberOfSeats() {return vehicle_NumberOfSeats;}
    public void setVehicle_NumberOfSeats(String vehicle_NumberOfSeats) { this.vehicle_NumberOfSeats = vehicle_NumberOfSeats;}
    public int getVehicle_Km() {return vehicle_Km;}
    public void setVehicle_Km(int vehicle_Km) {this.vehicle_Km = vehicle_Km;}
    public String getVehicle_Color() { return vehicle_Color;}
    public void setVehicle_Color(String vehicle_Color) {this.vehicle_Color = vehicle_Color;}
    public Boolean getVehicle_CompanyLogo() {return vehicle_CompanyLogo;}
    public void setVehicle_CompanyLogo(Boolean vehicle_CompanyLogo) {this.vehicle_CompanyLogo = vehicle_CompanyLogo;}
    public String getVehicle_CompanyLogoText() {return vehicle_CompanyLogoText;}
    public void setVehicle_CompanyLogoText(String vehicle_CompanyLogoText) {this.vehicle_CompanyLogoText = vehicle_CompanyLogoText;}
    public String getVehicle_OvnerAccountId() {return vehicle_OvnerAccountId;}
    public void setVehicle_OvnerAccountId(String vehicle_OvnerAccountId) {this.vehicle_OvnerAccountId = vehicle_OvnerAccountId;}
    public boolean isVehicle_IsActive() {return vehicle_IsActive;}
    public void setVehicle_IsActive(boolean vehicle_IsActive) {this.vehicle_IsActive = vehicle_IsActive;}
    public String getVehicle_Commnet() {return vehicle_Commnet;}
    public void setVehicle_Commnet(String vehicle_Commnet) {this.vehicle_Commnet = vehicle_Commnet;}
    public Date getVehicle_Modified() {return vehicle_Modified;}
    public void setVehicle_Modified(Date vehicle_Modified) {this.vehicle_Modified = vehicle_Modified;}
    public String getVehicle_Modifier() {return vehicle_Modifier;}
    public void setVehicle_Modifier(String vehicle_Modifier) {this.vehicle_Modifier = vehicle_Modifier;}
    public Date getVehicle_Created() {return vehicle_Created;}
    public void setVehicle_Created(Date vehicle_Created) {this.vehicle_Created = vehicle_Created;}
    public String getVehicle_creator() {return vehicle_creator;}
    public void setVehicle_creator(String vehicle_creator) {this.vehicle_creator = vehicle_creator;}
    public String getVehicle_ServiceTypes() {return vehicle_ServiceTypes;}
    public void setVehicle_ServiceTypes(String vehicle_ServiceTypes) {this.vehicle_ServiceTypes = vehicle_ServiceTypes;}
    public String[] getVehicle_ServiceTypesList() {return vehicle_ServiceTypesList;}
    public void setVehicle_ServiceTypesList(String[] vehicle_ServiceTypesList) {this.vehicle_ServiceTypesList = vehicle_ServiceTypesList;}
    public String getVehicle_AuthorityDocuments() {return vehicle_AuthorityDocuments;}
    public void setVehicle_AuthorityDocuments(String vehicle_AuthorityDocuments) { this.vehicle_AuthorityDocuments = vehicle_AuthorityDocuments;}
    public String[] getVehicle_AuthorityDocumentsList() {return vehicle_AuthorityDocumentsList;}
    public void setVehicle_AuthorityDocumentsList(String[] vehicle_AuthorityDocumentsList) {this.vehicle_AuthorityDocumentsList = vehicle_AuthorityDocumentsList;}
    public String getVehicle_VehicleProperties() {return vehicle_VehicleProperties;}
    public void setVehicle_VehicleProperties(String vehicle_VehicleProperties) {this.vehicle_VehicleProperties = vehicle_VehicleProperties;}
    public String[] getVehicle_VehiclePropertiesList() {return vehicle_VehiclePropertiesList;}
    public void setVehicle_VehiclePropertiesList(String[] vehicle_VehiclePropertiesList) {this.vehicle_VehiclePropertiesList = vehicle_VehiclePropertiesList;}
    public String getVehicle_Typ() {return vehicle_Typ;}
    public void setVehicle_Typ(String vehicle_Typ) {this.vehicle_Typ = vehicle_Typ;}
    public String[] getVehicle_Types() {return vehicle_Types;}
    public void setVehicle_Types(String[] vehicle_Types) {this.vehicle_Types = vehicle_Types;}
    public String getVehicle_DriverInfo() {return vehicle_DriverInfo;}
    public void setVehicle_DriverInfo(String vehicle_DriverInfo) {this.vehicle_DriverInfo = vehicle_DriverInfo;}
    public String getVehicle_HostessInfo() {return vehicle_HostessInfo;}
    public void setVehicle_HostessInfo(String vehicle_HostessInfo) {this.vehicle_HostessInfo = vehicle_HostessInfo;}
    public VehicleImages getVehicleImages() {return vehicleImages;}
    public void setVehicleImages(VehicleImages vehicleImages) {this.vehicleImages = vehicleImages;}
    public int getIlanId_old() {return ilanId_old;}
    public void setIlanId_old(int ilanId_old) { this.ilanId_old = ilanId_old;}
    public int getUyeId_old() { return uyeId_old;}
    public void setUyeId_old(int uyeId_old) { this.uyeId_old = uyeId_old;}

    
    
    
    
    
    
}
