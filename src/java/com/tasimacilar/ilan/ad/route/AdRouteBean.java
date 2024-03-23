package com.tasimacilar.ilan.ad.route;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "adRouteBean")
@ViewScoped
public class AdRouteBean implements Serializable{
    private String  adRoute_Id;                             
    private String  adRoute_StartPosition_Country;           
    private String  adRoute_StartPosition_City;               
    private String  adRoute_StartPosition_Town;               
    private String  adRoute_StartPosition_District;          
    private String  adRoute_StartPosition_Neighborhood;      
    private double  adRoute_StartPosition__Latitude;          
    private double  adRoute_StartPosition__Longitude;        
    private Date    adRoute_StartTime;                       
    private String  adRoute_StartPositionFormattedAddress;   
    private String  adRoute_EndPosition_Country;             
    private String  adRoute_EndPosition_City;                
    private String  adRoute_EndPosition_Town;               
    private String  adRoute_EndPosition_District;           
    private String  adRoute_EndPosition_Neighborhood;       
    private double  adRoute_EndPosition__Latitude;         
    private double  adRoute_EndPosition__Longitude;         
    private Date    adRoute_EndTime;                          
    private String  adRoute_EndPositionFormattedAddress;     
    private String  adRoute_destinationTown;                 
    private String  ad_Id;                                   
    private List<AdRouteStations> AdRouteStationsLists = new ArrayList<AdRouteStations>();
    @PostConstruct
    public void init() {  }
    public AdRouteBean() { }
    public String getAdRoute_Id() {return adRoute_Id;}
    public void setAdRoute_Id(String adRoute_Id) {this.adRoute_Id = adRoute_Id;}
    public String getAdRoute_StartPosition_Country() {return adRoute_StartPosition_Country;}
    public void setAdRoute_StartPosition_Country(String adRoute_StartPosition_Country) {this.adRoute_StartPosition_Country = adRoute_StartPosition_Country;}
    public String getAdRoute_StartPosition_City() {return adRoute_StartPosition_City;}
    public void setAdRoute_StartPosition_City(String adRoute_StartPosition_City) {this.adRoute_StartPosition_City = adRoute_StartPosition_City;}
    public String getAdRoute_StartPosition_Town() {return adRoute_StartPosition_Town;}
    public void setAdRoute_StartPosition_Town(String adRoute_StartPosition_Town) {this.adRoute_StartPosition_Town = adRoute_StartPosition_Town;}
    public String getAdRoute_StartPosition_District() {return adRoute_StartPosition_District;}
    public void setAdRoute_StartPosition_District(String adRoute_StartPosition_District) {this.adRoute_StartPosition_District = adRoute_StartPosition_District;}
    public String getAdRoute_StartPosition_Neighborhood() {return adRoute_StartPosition_Neighborhood;}
    public void setAdRoute_StartPosition_Neighborhood(String adRoute_StartPosition_Neighborhood) {this.adRoute_StartPosition_Neighborhood = adRoute_StartPosition_Neighborhood;}
    public double getAdRoute_StartPosition__Latitude() {return adRoute_StartPosition__Latitude;}
    public void setAdRoute_StartPosition__Latitude(double adRoute_StartPosition__Latitude) {this.adRoute_StartPosition__Latitude = adRoute_StartPosition__Latitude;}
    public double getAdRoute_StartPosition__Longitude() {return adRoute_StartPosition__Longitude;}
    public void setAdRoute_StartPosition__Longitude(double adRoute_StartPosition__Longitude) {this.adRoute_StartPosition__Longitude = adRoute_StartPosition__Longitude;}
    public Date getAdRoute_StartTime() {return adRoute_StartTime;}
    public void setAdRoute_StartTime(Date adRoute_StartTime) {this.adRoute_StartTime = adRoute_StartTime;}
    public String getAdRoute_StartPositionFormattedAddress() {return adRoute_StartPositionFormattedAddress;}
    public void setAdRoute_StartPositionFormattedAddress(String adRoute_StartPositionFormattedAddress) {this.adRoute_StartPositionFormattedAddress = adRoute_StartPositionFormattedAddress;}
    public String getAdRoute_EndPosition_Country() {return adRoute_EndPosition_Country;}
    public void setAdRoute_EndPosition_Country(String adRoute_EndPosition_Country) {this.adRoute_EndPosition_Country = adRoute_EndPosition_Country;}
    public String getAdRoute_EndPosition_City() {return adRoute_EndPosition_City;}
    public void setAdRoute_EndPosition_City(String adRoute_EndPosition_City) {this.adRoute_EndPosition_City = adRoute_EndPosition_City;}
    public String getAdRoute_EndPosition_Town() {return adRoute_EndPosition_Town;}
    public void setAdRoute_EndPosition_Town(String adRoute_EndPosition_Town) {this.adRoute_EndPosition_Town = adRoute_EndPosition_Town;}
    public String getAdRoute_EndPosition_District() {return adRoute_EndPosition_District;}
    public void setAdRoute_EndPosition_District(String adRoute_EndPosition_District) {this.adRoute_EndPosition_District = adRoute_EndPosition_District;}
    public String getAdRoute_EndPosition_Neighborhood() {return adRoute_EndPosition_Neighborhood;}
    public void setAdRoute_EndPosition_Neighborhood(String adRoute_EndPosition_Neighborhood) {this.adRoute_EndPosition_Neighborhood = adRoute_EndPosition_Neighborhood;}
    public double getAdRoute_EndPosition__Latitude() { return adRoute_EndPosition__Latitude;}
    public void setAdRoute_EndPosition__Latitude(double adRoute_EndPosition__Latitude) { this.adRoute_EndPosition__Latitude = adRoute_EndPosition__Latitude;}
    public double getAdRoute_EndPosition__Longitude() {return adRoute_EndPosition__Longitude;}
    public void setAdRoute_EndPosition__Longitude(double adRoute_EndPosition__Longitude) {this.adRoute_EndPosition__Longitude = adRoute_EndPosition__Longitude;}
    public Date getAdRoute_EndTime() {return adRoute_EndTime;}
    public void setAdRoute_EndTime(Date adRoute_EndTime) {this.adRoute_EndTime = adRoute_EndTime;}
    public String getAdRoute_EndPositionFormattedAddress() { return adRoute_EndPositionFormattedAddress;}
    public void setAdRoute_EndPositionFormattedAddress(String adRoute_EndPositionFormattedAddress) {this.adRoute_EndPositionFormattedAddress = adRoute_EndPositionFormattedAddress;}
    public String getAdRoute_destinationTown() {return adRoute_destinationTown;}
    public void setAdRoute_destinationTown(String adRoute_destinationTown) {this.adRoute_destinationTown = adRoute_destinationTown;}
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}
    public List<AdRouteStations> getAdRouteStationsLists() {return AdRouteStationsLists; }
    public void setAdRouteStationsLists(List<AdRouteStations> AdRouteStationsLists) {this.AdRouteStationsLists = AdRouteStationsLists;} 
    @Override
    public String toString() {
        return "AdRouteBean{"   + "adRoute_Id=" + adRoute_Id 
                                + ", adRoute_StartPosition_Country=" + adRoute_StartPosition_Country 
                                + ", adRoute_StartPosition_City=" + adRoute_StartPosition_City 
                                + ", adRoute_StartPosition_Town=" + adRoute_StartPosition_Town 
                                + ", adRoute_StartPosition_District=" + adRoute_StartPosition_District 
                                + ", adRoute_StartPosition_Neighborhood=" + adRoute_StartPosition_Neighborhood 
                                + ", adRoute_StartPosition__Latitude=" + adRoute_StartPosition__Latitude 
                                + ", adRoute_StartPosition__Longitude=" + adRoute_StartPosition__Longitude 
                                + ", adRoute_StartTime=" + adRoute_StartTime 
                                + ", adRoute_EndPosition_Country=" + adRoute_EndPosition_Country 
                                + ", adRoute_EndPosition_City=" + adRoute_EndPosition_City 
                                + ", adRoute_EndPosition_Town=" + adRoute_EndPosition_Town 
                                + ", adRoute_EndPosition_District=" + adRoute_EndPosition_District 
                                + ", adRoute_EndPosition_Neighborhood=" + adRoute_EndPosition_Neighborhood 
                                + ", adRoute_EndPosition__Latitude=" + adRoute_EndPosition__Latitude 
                                + ", adRoute_EndPosition__Longitude=" + adRoute_EndPosition__Longitude 
                                + ", adRoute_EndTime=" + adRoute_EndTime 
                                + ", adRoute_destinationTown=" + adRoute_destinationTown 
                                + ", ad_Id=" + ad_Id 
                                + ", AdRouteStationsLists=" + AdRouteStationsLists + '}';
    }}
