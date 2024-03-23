package com.tasimacilar.ilan.ad.route;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "adRouteStationsBean")
@ViewScoped
public class AdRouteStations implements Serializable{
    private String  adRouteStation_Id;              // durak id
    private String  adRouteStation_Comment;         // durakla ilgili acıklama
    private String  adRouteStation_Country;         // Duragın bulundugu yer. Ulke
    private String  adRouteStation_City;            // Duragın bulundugu yer. Il
    private String  adRouteStation_Town;            // Duragın bulundugu yer. Ilce
    private String  adRouteStation_District;        // Duragın bulundugu yer. Semt/koy
    private String  adRouteStation_Neighborhood;    // Duragın bulundugu yer. mahalle
    private double  adRouteStation_Latitude;        // Duragın bulundugu yer. Enlem
    private double  adRouteStation_Longitude;       // Duragın bulundugu yer. Boylam
    private Date    adRouteStation_Time;            // Durakta bulundugu-bulununacak zaman
    private Boolean adRouteStation_TimeEditable;    // Zaman değiştirilebilirmi 
    private String  adRoute_Id;                     // Guzergah id
    public AdRouteStations() { }
    public String getAdRouteStation_Id() {return adRouteStation_Id;}
    public void setAdRouteStation_Id(String adRouteStation_Id) {this.adRouteStation_Id = adRouteStation_Id;}
    public String getAdRouteStation_Comment() {return adRouteStation_Comment;}
    public void setAdRouteStation_Comment(String adRouteStation_Comment) {this.adRouteStation_Comment = adRouteStation_Comment;}
    public String getAdRouteStation_Country() {return adRouteStation_Country;}
    public void setAdRouteStation_Country(String adRouteStation_Country) {this.adRouteStation_Country = adRouteStation_Country;}
    public String getAdRouteStation_City() { return adRouteStation_City;}
    public void setAdRouteStation_City(String adRouteStation_City) {this.adRouteStation_City = adRouteStation_City;}
    public String getAdRouteStation_Town() {return adRouteStation_Town;}
    public void setAdRouteStation_Town(String adRouteStation_Town) {this.adRouteStation_Town = adRouteStation_Town;}
    public String getAdRouteStation_District() {return adRouteStation_District;}
    public void setAdRouteStation_District(String adRouteStation_District) {this.adRouteStation_District = adRouteStation_District;}
    public String getAdRouteStation_Neighborhood() {return adRouteStation_Neighborhood;}
    public void setAdRouteStation_Neighborhood(String adRouteStation_Neighborhood) {this.adRouteStation_Neighborhood = adRouteStation_Neighborhood;}
    public double getAdRouteStation_Latitude() {return adRouteStation_Latitude;}
    public void setAdRouteStation_Latitude(double adRouteStation_Latitude) {this.adRouteStation_Latitude = adRouteStation_Latitude;}
    public double getAdRouteStation_Longitude() {return adRouteStation_Longitude;}
    public void setAdRouteStation_Longitude(double adRouteStation_Longitude) {this.adRouteStation_Longitude = adRouteStation_Longitude;}
    public Date getAdRouteStation_Time() {return adRouteStation_Time;}
    public void setAdRouteStation_Time(Date adRouteStation_Time) {this.adRouteStation_Time = adRouteStation_Time;}
    public Boolean getAdRouteStation_TimeEditable() {return adRouteStation_TimeEditable;}
    public void setAdRouteStation_TimeEditable(Boolean adRouteStation_TimeEditable) {this.adRouteStation_TimeEditable = adRouteStation_TimeEditable;}
    public String getAdRoute_Id() { return adRoute_Id;}
    public void setAdRoute_Id(String adRoute_Id) {this.adRoute_Id = adRoute_Id;}
    @Override
    public String toString() {
        return "AdRouteStations{"   + "adRouteStation_Id=" + adRouteStation_Id 
                                    + ", adRouteStation_Comment=" + adRouteStation_Comment 
                                    + ", adRouteStation_Country=" + adRouteStation_Country 
                                    + ", adRouteStation_City=" + adRouteStation_City 
                                    + ", adRouteStation_Town=" + adRouteStation_Town 
                                    + ", adRouteStation_District=" + adRouteStation_District 
                                    + ", adRouteStation_Neighborhood=" + adRouteStation_Neighborhood 
                                    + ", adRouteStation_Latitude=" + adRouteStation_Latitude 
                                    + ", adRouteStation_Longitude=" + adRouteStation_Longitude 
                                    + ", adRouteStation_Time=" + adRouteStation_Time 
                                    + ", adRoute_Id=" + adRoute_Id + '}';
    }}
