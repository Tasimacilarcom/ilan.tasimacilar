package com.tasimacilar.ilan.ad.search;
import java.io.Serializable;
import java.util.Date;
public class Ad_Search_InputEntity implements Serializable{
    String      fltr_SearchTyp;                             
    String      fltr_SortType;                                
    String      fltr_Ad_Id;                                
    int         fltr_Ad_CategoryId;                         
    String      fltr_Ad_Comment;                            
    String[]    fltr_Ad_Type;                              
    String      fltr_Ad_OvnerAccountId;                    
    boolean     fltr_Ad_IsActive;                           
    Date        fltr_Ad_EndTime;                            
    Date        fltr_Ad_CreateTime;                         
    boolean     fltr_Ad_IsPublish;                         
    Date        fltr_Ad_PublishDate;                        
    String      fltr_Ad_WhatTime;                                
    String      fltr_CompanyId;                                            
    int         fltr_Vehicle_PlateProvinceCode;                
    String[]    fltr_Vehicle_BrandIds;                       
    String[]    fltr_Vehicle_Model;                              
    String      fltr_Vehicle_ModelYear;                     
    boolean     fltr_Vehicle_ModelYearAndOver;              
    String[]    fltr_Vehicle_NumberOfSeats;                 
    String[]    fltr_Vehicle_ServiceTypes;                  
    String[]    fltr_Vehicle_AuthorityDocuments;            
    String[]    fltr_Vehicle_Properties;                    
    String      fltr_Vehicle_DriverInfo;                   
    String      fltr_Vehicle_HostessInfo;                     
    String      fltr_AdRoute_StartTime;                    
    String      fltr_AdRoute_StartPosition_Country;         
    String[]    fltr_AdRoute_StartPosition_City;          
    String[]    fltr_AdRoute_StartPosition_Town;           
    String[]    fltr_AdRoute_StartPosition_District;        
    String[]    fltr_AdRoute_StartPosition_Neighborhood;   
    String      fltr_AdRoute_EndTime;                     
    String      fltr_AdRoute_EndPosition_Country;           
    String[]    fltr_AdRoute_EndPosition_City;             
    String[]    fltr_AdRoute_EndPosition_Town;              
    String[]    fltr_AdRoute_EndPosition_District;          
    String[]    fltr_AdRoute_EndPosition_Neighborhood;     
    public Ad_Search_InputEntity() { }
 public Ad_Search_InputEntity(   String fltr_SearchTyp, 
                                    String fltr_SortType, 
                                    String fltr_Ad_Id, 
                                    int fltr_Ad_CategoryId, 
                                    String fltr_Ad_Comment, 
                                    String[] fltr_Ad_Type, 
                                    String fltr_Ad_OvnerAccountId, 
                                    boolean fltr_Ad_IsActive, 
                                    Date fltr_Ad_EndTime, 
                                    Date fltr_Ad_CreateTime, 
                                    boolean fltr_Ad_IsPublish, 
                                    Date fltr_Ad_PublishDate, 
                                    String fltr_Ad_WhatTime,
                                    String fltr_CompanyId, 
                                    int fltr_Vehicle_PlateProvinceCode, 
                                    String[] fltr_Vehicle_BrandIds, 
                                    String[] fltr_Vehicle_Model, 
                                    String fltr_Vehicle_ModelYear, 
                                    boolean fltr_Vehicle_ModelYearAndOver, 
                                    String[] fltr_Vehicle_NumberOfSeats, 
                                    String[] fltr_Vehicle_ServiceTypes, 
                                    String[] fltr_Vehicle_AuthorityDocuments, 
                                    String[] fltr_Vehicle_Properties, 
                                    String fltr_vehicle_DriverInfo, 
                                    String fltr_vehicle_HostessInfo, 
                                    String fltr_adRoute_StartTime, 
                                    String fltr_adRoute_StartPosition_Country, 
                                    String[] fltr_adRoute_StartPosition_City, 
                                    String[] fltr_adRoute_StartPosition_Town, 
                                    String[] fltr_adRoute_StartPosition_District, 
                                    String[] fltr_adRoute_StartPosition_Neighborhood, 
                                    String fltr_adRoute_EndTime, 
                                    String fltr_adRoute_EndPosition_Country, 
                                    String[] fltr_adRoute_EndPosition_City, 
                                    String[] fltr_adRoute_EndPosition_Town, 
                                    String[] fltr_adRoute_EndPosition_District, 
                                    String[] fltr_adRoute_EndPosition_Neighborhood) {
        this.fltr_SearchTyp = fltr_SearchTyp;
        this.fltr_SortType = fltr_SortType;
        this.fltr_Ad_Id = fltr_Ad_Id;
        this.fltr_Ad_CategoryId = fltr_Ad_CategoryId;
        this.fltr_Ad_Comment = fltr_Ad_Comment;
        this.fltr_Ad_Type = fltr_Ad_Type;
        this.fltr_Ad_OvnerAccountId = fltr_Ad_OvnerAccountId;
        this.fltr_Ad_IsActive = fltr_Ad_IsActive;
        this.fltr_Ad_EndTime = fltr_Ad_EndTime;
        this.fltr_Ad_CreateTime = fltr_Ad_CreateTime;
        this.fltr_Ad_IsPublish = fltr_Ad_IsPublish;
        this.fltr_Ad_PublishDate = fltr_Ad_PublishDate;
        this.fltr_Ad_WhatTime = fltr_Ad_WhatTime;
        this.fltr_CompanyId = fltr_CompanyId;
        this.fltr_Vehicle_PlateProvinceCode = fltr_Vehicle_PlateProvinceCode;
        this.fltr_Vehicle_BrandIds = fltr_Vehicle_BrandIds;
        this.fltr_Vehicle_Model = fltr_Vehicle_Model;
        this.fltr_Vehicle_ModelYear = fltr_Vehicle_ModelYear;
        this.fltr_Vehicle_ModelYearAndOver = fltr_Vehicle_ModelYearAndOver;
        this.fltr_Vehicle_NumberOfSeats = fltr_Vehicle_NumberOfSeats;
        this.fltr_Vehicle_ServiceTypes = fltr_Vehicle_ServiceTypes;
        this.fltr_Vehicle_AuthorityDocuments = fltr_Vehicle_AuthorityDocuments;
        this.fltr_Vehicle_Properties = fltr_Vehicle_Properties;
        this.fltr_Vehicle_DriverInfo = fltr_vehicle_DriverInfo;
        this.fltr_Vehicle_HostessInfo = fltr_vehicle_HostessInfo;
        this.fltr_AdRoute_StartTime = fltr_adRoute_StartTime;
        this.fltr_AdRoute_StartPosition_Country = fltr_adRoute_StartPosition_Country;
        this.fltr_AdRoute_StartPosition_City = fltr_adRoute_StartPosition_City;
        this.fltr_AdRoute_StartPosition_Town = fltr_adRoute_StartPosition_Town;
        this.fltr_AdRoute_StartPosition_District = fltr_adRoute_StartPosition_District;
        this.fltr_AdRoute_StartPosition_Neighborhood = fltr_adRoute_StartPosition_Neighborhood;
        this.fltr_AdRoute_EndTime = fltr_adRoute_EndTime;
        this.fltr_AdRoute_EndPosition_Country = fltr_adRoute_EndPosition_Country;
        this.fltr_AdRoute_EndPosition_City = fltr_adRoute_EndPosition_City;
        this.fltr_AdRoute_EndPosition_Town = fltr_adRoute_EndPosition_Town;
        this.fltr_AdRoute_EndPosition_District = fltr_adRoute_EndPosition_District;
        this.fltr_AdRoute_EndPosition_Neighborhood = fltr_adRoute_EndPosition_Neighborhood;
    }
    public String getFltr_SearchTyp() { return fltr_SearchTyp;   }
    public void setFltr_SearchTyp(String fltr_SearchTyp) {  this.fltr_SearchTyp = fltr_SearchTyp;  }   
    public String getFltr_SortType() { return fltr_SortType;}
    public void setFltr_SortType(String fltr_SortType) {this.fltr_SortType = fltr_SortType;}
    public String getFltr_Ad_Id() {return fltr_Ad_Id;}
    public void setFltr_Ad_Id(String fltr_Ad_Id) {this.fltr_Ad_Id = fltr_Ad_Id;}
    public int getFltr_Ad_CategoryId() {return fltr_Ad_CategoryId;}
    public void setFltr_Ad_CategoryId(int fltr_Ad_CategoryId) {this.fltr_Ad_CategoryId = fltr_Ad_CategoryId;}
    public String getFltr_Ad_Comment() {return fltr_Ad_Comment;}
    public void setFltr_Ad_Comment(String fltr_Ad_Comment) {this.fltr_Ad_Comment = fltr_Ad_Comment;}
    public String[] getFltr_Ad_Type() {return fltr_Ad_Type;}
    public void setFltr_Ad_Type(String[] fltr_Ad_Type) {this.fltr_Ad_Type = fltr_Ad_Type;}
    public String getFltr_Ad_OvnerAccountId() {return fltr_Ad_OvnerAccountId;}
    public void setFltr_Ad_OvnerAccountId(String fltr_Ad_OvnerAccountId) {this.fltr_Ad_OvnerAccountId = fltr_Ad_OvnerAccountId;}
    public boolean isFltr_Ad_IsActive() { return fltr_Ad_IsActive;}
    public void setFltr_Ad_IsActive(boolean fltr_Ad_IsActive) { this.fltr_Ad_IsActive = fltr_Ad_IsActive;}
    public Date getFltr_Ad_EndTime() { return fltr_Ad_EndTime;}
    public void setFltr_Ad_EndTime(Date fltr_Ad_EndTime) {this.fltr_Ad_EndTime = fltr_Ad_EndTime;}
    public Date getFltr_Ad_CreateTime() {return fltr_Ad_CreateTime;}
    public void setFltr_Ad_CreateTime(Date fltr_Ad_CreateTime) { this.fltr_Ad_CreateTime = fltr_Ad_CreateTime;}
    public boolean isFltr_Ad_IsPublish() { return fltr_Ad_IsPublish;}
    public void setFltr_Ad_IsPublish(boolean fltr_Ad_IsPublish) {this.fltr_Ad_IsPublish = fltr_Ad_IsPublish;}
    public Date getFltr_Ad_PublishDate() {return fltr_Ad_PublishDate;}
    public void setFltr_Ad_PublishDate(Date fltr_Ad_PublishDate) { this.fltr_Ad_PublishDate = fltr_Ad_PublishDate;}
    public String getFltr_Ad_WhatTime() { return fltr_Ad_WhatTime; }
    public void setFltr_Ad_WhatTime(String fltr_Ad_WhatTime) { this.fltr_Ad_WhatTime = fltr_Ad_WhatTime; }
    public String getFltr_CompanyId() { return fltr_CompanyId;}
    public void setFltr_CompanyId(String fltr_CompanyId) {this.fltr_CompanyId = fltr_CompanyId;}
    public int getFltr_Vehicle_PlateProvinceCode() { return fltr_Vehicle_PlateProvinceCode;}
    public void setFltr_Vehicle_PlateProvinceCode(int fltr_Vehicle_PlateProvinceCode) {  this.fltr_Vehicle_PlateProvinceCode = fltr_Vehicle_PlateProvinceCode;}
    public String[] getFltr_Vehicle_BrandIds() {    return fltr_Vehicle_BrandIds;}
    public void setFltr_Vehicle_BrandIds(String[] fltr_Vehicle_BrandIds) { this.fltr_Vehicle_BrandIds = fltr_Vehicle_BrandIds;}
    public String[] getFltr_Vehicle_Model() {  return fltr_Vehicle_Model;}
    public void setFltr_Vehicle_Model(String[] fltr_Vehicle_Model) { this.fltr_Vehicle_Model = fltr_Vehicle_Model;}
    public String getFltr_Vehicle_ModelYear() { return fltr_Vehicle_ModelYear;}
    public void setFltr_Vehicle_ModelYear(String fltr_Vehicle_ModelYear) { this.fltr_Vehicle_ModelYear = fltr_Vehicle_ModelYear;}
    public boolean isFltr_Vehicle_ModelYearAndOver() { return fltr_Vehicle_ModelYearAndOver;}
    public void setFltr_Vehicle_ModelYearAndOver(boolean fltr_Vehicle_ModelYearAndOver) {  this.fltr_Vehicle_ModelYearAndOver = fltr_Vehicle_ModelYearAndOver;}
    public String[] getFltr_Vehicle_NumberOfSeats() { return fltr_Vehicle_NumberOfSeats;}
    public void setFltr_Vehicle_NumberOfSeats(String[] fltr_Vehicle_NumberOfSeats) { this.fltr_Vehicle_NumberOfSeats = fltr_Vehicle_NumberOfSeats;}
    public String[] getFltr_Vehicle_ServiceTypes() {  return fltr_Vehicle_ServiceTypes;}
    public void setFltr_Vehicle_ServiceTypes(String[] fltr_Vehicle_ServiceTypes) { this.fltr_Vehicle_ServiceTypes = fltr_Vehicle_ServiceTypes;}
    public String[] getFltr_Vehicle_AuthorityDocuments() { return fltr_Vehicle_AuthorityDocuments;}
    public void setFltr_Vehicle_AuthorityDocuments(String[] fltr_Vehicle_AuthorityDocuments) { this.fltr_Vehicle_AuthorityDocuments = fltr_Vehicle_AuthorityDocuments;}
    public String[] getFltr_Vehicle_Properties() { return fltr_Vehicle_Properties;}
    public void setFltr_Vehicle_Properties(String[] fltr_Vehicle_Properties) {this.fltr_Vehicle_Properties = fltr_Vehicle_Properties;}
    public String getFltr_Vehicle_DriverInfo() {return fltr_Vehicle_DriverInfo;}
    public void setFltr_Vehicle_DriverInfo(String fltr_vehicle_DriverInfo) {this.fltr_Vehicle_DriverInfo = fltr_vehicle_DriverInfo;}
    public String getFltr_Vehicle_HostessInfo() { return fltr_Vehicle_HostessInfo;}
    public void setFltr_Vehicle_HostessInfo(String fltr_vehicle_HostessInfo) { this.fltr_Vehicle_HostessInfo = fltr_vehicle_HostessInfo;}
    public String getFltr_AdRoute_StartTime() {return fltr_AdRoute_StartTime;}
    public void setFltr_AdRoute_StartTime(String fltr_adRoute_StartTime) { this.fltr_AdRoute_StartTime = fltr_adRoute_StartTime;}
    public String getFltr_AdRoute_StartPosition_Country() { return fltr_AdRoute_StartPosition_Country;}
    public void setFltr_AdRoute_StartPosition_Country(String fltr_adRoute_StartPosition_Country) { this.fltr_AdRoute_StartPosition_Country = fltr_adRoute_StartPosition_Country;}
    public String[] getFltr_AdRoute_StartPosition_City() { return fltr_AdRoute_StartPosition_City;}
    public void setFltr_AdRoute_StartPosition_City(String[] fltr_adRoute_StartPosition_City) { this.fltr_AdRoute_StartPosition_City = fltr_adRoute_StartPosition_City;}
    public String[] getFltr_AdRoute_StartPosition_Town() { return fltr_AdRoute_StartPosition_Town;}
    public void setFltr_AdRoute_StartPosition_Town(String[] fltr_adRoute_StartPosition_Town) {this.fltr_AdRoute_StartPosition_Town = fltr_adRoute_StartPosition_Town;}
    public String[] getFltr_AdRoute_StartPosition_District() { return fltr_AdRoute_StartPosition_District;}
    public void setFltr_AdRoute_StartPosition_District(String[] fltr_adRoute_StartPosition_District) {  this.fltr_AdRoute_StartPosition_District = fltr_adRoute_StartPosition_District;}
    public String[] getFltr_AdRoute_StartPosition_Neighborhood() { return fltr_AdRoute_StartPosition_Neighborhood;}
    public void setFltr_AdRoute_StartPosition_Neighborhood(String[] fltr_adRoute_StartPosition_Neighborhood) { this.fltr_AdRoute_StartPosition_Neighborhood = fltr_adRoute_StartPosition_Neighborhood;}
    public String getFltr_AdRoute_EndTime() { return fltr_AdRoute_EndTime;}
    public void setFltr_AdRoute_EndTime(String fltr_adRoute_EndTime) {this.fltr_AdRoute_EndTime = fltr_adRoute_EndTime;}
    public String getFltr_AdRoute_EndPosition_Country() { return fltr_AdRoute_EndPosition_Country;}
    public void setFltr_AdRoute_EndPosition_Country(String fltr_adRoute_EndPosition_Country) { this.fltr_AdRoute_EndPosition_Country = fltr_adRoute_EndPosition_Country;}
    public String[] getFltr_AdRoute_EndPosition_City() { return fltr_AdRoute_EndPosition_City;}
    public void setFltr_AdRoute_EndPosition_City(String[] fltr_adRoute_EndPosition_City) { this.fltr_AdRoute_EndPosition_City = fltr_adRoute_EndPosition_City;}
    public String[] getFltr_AdRoute_EndPosition_Town() { return fltr_AdRoute_EndPosition_Town;}
    public void setFltr_AdRoute_EndPosition_Town(String[] fltr_adRoute_EndPosition_Town) {  this.fltr_AdRoute_EndPosition_Town = fltr_adRoute_EndPosition_Town;}
    public String[] getFltr_AdRoute_EndPosition_District() { return fltr_AdRoute_EndPosition_District;}
    public void setFltr_AdRoute_EndPosition_District(String[] fltr_adRoute_EndPosition_District) { this.fltr_AdRoute_EndPosition_District = fltr_adRoute_EndPosition_District;}
    public String[] getFltr_AdRoute_EndPosition_Neighborhood() { return fltr_AdRoute_EndPosition_Neighborhood;}
    public void setFltr_AdRoute_EndPosition_Neighborhood(String[] fltr_adRoute_EndPosition_Neighborhood) { this.fltr_AdRoute_EndPosition_Neighborhood = fltr_adRoute_EndPosition_Neighborhood;}
    
    
}
