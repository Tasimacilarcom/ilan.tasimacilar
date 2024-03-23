package com.tasimacilar.ilan.system.map;

import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.route.AdRouteDao;
import com.tasimacilar.ilan.ad.route.AdRouteStations;
import com.tasimacilar.ilan.ad.route.AdRouteStationsDao;
import com.tasimacilar.ilan.common.CityListsBean;
import com.tasimacilar.ilan.common.CityListsDao;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean(name = "locationInfoFromMap")
@ViewScoped
public class LocationInfoFromMap implements Serializable{
  
    private Boolean locationInfoFromMap;                                   
    private String  startPoint_geo_STREET_NUMBER_KAPINO;                    
    private String  startPoint_geo_ROUTE_SOKAK;                            
    private String  startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;     
    private String  startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;         
    private String  startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;      
    private String  startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;          
    private String  startPoint_geo_COUNTRY;                                
    private String  startPoint_geo_POSTAL_CODE;                             
    private double  startPoint_geo_latitude;                              
    private double  startPoint_geo_longitude;                              
    private String  startPoint_geo_FORMATED_ADDRESS;                     
    private Date    startPoint_Time;                                          
    private Boolean endPoint_locationInfoFromMap;                           
    private String  endPoint_geo_STREET_NUMBER_KAPINO;                     
    private String  endPoint_geo_ROUTE_SOKAK;                              
    private String  endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;       
    private String  endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;           
    private String  endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;         
    private String  endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;          
    private String  endPoint_geo_COUNTRY;                                  
    private String  endPoint_geo_POSTAL_CODE;                             
    private double  endPoint_geo_latitude;                                 
    private double  endPoint_geo_longitude;                                 
    private String  endPoint_geo_FORMATED_ADDRESS;                         
    private Date    endPoint_Time;                                    
    private Boolean station_locationInfoFromMap;                            
    private String  station_geo_STREET_NUMBER_KAPINO;                       
    private String  station_geo_ROUTE_SOKAK;                               
    private String  station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;       
    private String  station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;          
    private String  station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;          
    private String  station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;             
    private String  station_geo_COUNTRY;                                 
    private String  station_geo_POSTAL_CODE;                               
    private double  station_geo_latitude;                                  
    private double  station_geo_longitude;                                 
    private String  station_geo_FORMATED_ADDRESS;                         
    private Date    station_Time;                                         
    private String  destinationTown;                                     
    private List<AdRouteBean>       locationList = new ArrayList<AdRouteBean>();
    private List<AdRouteStations>   locationStationList = new ArrayList<AdRouteStations>();
    private AdRouteBean adr; 
    @ManagedProperty(value="#{cityListsBean}")
    private CityListsBean cityListsBean;
    public CityListsBean getCityListsBean() { return cityListsBean;}
    public void setCityListsBean(CityListsBean cityListsBean) {this.cityListsBean = cityListsBean;}
    @PostConstruct
    public void init() { 
        adr = new AdRouteBean();
        adr.setAdRoute_Id(UniqueId.RandomString(12));
    
    }  public LocationInfoFromMap() {  }
    public Boolean getLocationInfoFromMap() {return locationInfoFromMap;}
    public void setLocationInfoFromMap(Boolean locationInfoFromMap) {this.locationInfoFromMap = locationInfoFromMap;}   
    public String getStartPoint_geo_STREET_NUMBER_KAPINO() { return startPoint_geo_STREET_NUMBER_KAPINO;}
    public void setStartPoint_geo_STREET_NUMBER_KAPINO(String startPoint_geo_STREET_NUMBER_KAPINO) {this.startPoint_geo_STREET_NUMBER_KAPINO = startPoint_geo_STREET_NUMBER_KAPINO;}
    public String getStartPoint_geo_ROUTE_SOKAK() {return startPoint_geo_ROUTE_SOKAK;}
    public void setStartPoint_geo_ROUTE_SOKAK(String startPoint_geo_ROUTE_SOKAK) {this.startPoint_geo_ROUTE_SOKAK = startPoint_geo_ROUTE_SOKAK;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) {this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) {this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) { this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) {this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getStartPoint_geo_COUNTRY() { return startPoint_geo_COUNTRY;}
    public void setStartPoint_geo_COUNTRY(String startPoint_geo_COUNTRY) { this.startPoint_geo_COUNTRY = startPoint_geo_COUNTRY;}
    public String getStartPoint_geo_POSTAL_CODE() {return startPoint_geo_POSTAL_CODE;}
    public void setStartPoint_geo_POSTAL_CODE(String startPoint_geo_POSTAL_CODE) { this.startPoint_geo_POSTAL_CODE = startPoint_geo_POSTAL_CODE;}
    public double getStartPoint_geo_latitude() {return startPoint_geo_latitude;}
    public void setStartPoint_geo_latitude(double startPoint_geo_latitude) { this.startPoint_geo_latitude = startPoint_geo_latitude;}
    public double getStartPoint_geo_longitude() { return startPoint_geo_longitude;}
    public void setStartPoint_geo_longitude(double startPoint_geo_longitude) {this.startPoint_geo_longitude = startPoint_geo_longitude;}
    public String getStartPoint_geo_FORMATED_ADDRESS() { return startPoint_geo_FORMATED_ADDRESS;}
    public void setStartPoint_geo_FORMATED_ADDRESS(String startPoint_geo_FORMATED_ADDRESS) { this.startPoint_geo_FORMATED_ADDRESS = startPoint_geo_FORMATED_ADDRESS;}
    public Date getStartPoint_Time() {return startPoint_Time;}
    public void setStartPoint_Time(Date startPoint_Time) {this.startPoint_Time = startPoint_Time;}
    public Boolean getEndPoint_locationInfoFromMap() { return endPoint_locationInfoFromMap;}
    public void setEndPoint_locationInfoFromMap(Boolean endPoint_locationInfoFromMap) { this.endPoint_locationInfoFromMap = endPoint_locationInfoFromMap;}
    public String getEndPoint_geo_STREET_NUMBER_KAPINO() { return endPoint_geo_STREET_NUMBER_KAPINO;}
    public void setEndPoint_geo_STREET_NUMBER_KAPINO(String endPoint_geo_STREET_NUMBER_KAPINO) {this.endPoint_geo_STREET_NUMBER_KAPINO = endPoint_geo_STREET_NUMBER_KAPINO;}
    public String getEndPoint_geo_ROUTE_SOKAK() {return endPoint_geo_ROUTE_SOKAK;}
    public void setEndPoint_geo_ROUTE_SOKAK(String endPoint_geo_ROUTE_SOKAK) {  this.endPoint_geo_ROUTE_SOKAK = endPoint_geo_ROUTE_SOKAK;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() {return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) {this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() { return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) { this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() {return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) {this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL() {return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) {this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getEndPoint_geo_COUNTRY() { return endPoint_geo_COUNTRY;}
    public void setEndPoint_geo_COUNTRY(String endPoint_geo_COUNTRY) { this.endPoint_geo_COUNTRY = endPoint_geo_COUNTRY;}
    public String getEndPoint_geo_POSTAL_CODE() {return endPoint_geo_POSTAL_CODE;}
    public void setEndPoint_geo_POSTAL_CODE(String endPoint_geo_POSTAL_CODE) {this.endPoint_geo_POSTAL_CODE = endPoint_geo_POSTAL_CODE;}
    public double getEndPoint_geo_latitude() {return endPoint_geo_latitude;}
    public void setEndPoint_geo_latitude(double endPoint_geo_latitude) { this.endPoint_geo_latitude = endPoint_geo_latitude;}
    public double getEndPoint_geo_longitude() {return endPoint_geo_longitude;}
    public void setEndPoint_geo_longitude(double endPoint_geo_longitude) { this.endPoint_geo_longitude = endPoint_geo_longitude;}
    public String getEndPoint_geo_FORMATED_ADDRESS() {return endPoint_geo_FORMATED_ADDRESS;}
    public void setEndPoint_geo_FORMATED_ADDRESS(String endPoint_geo_FORMATED_ADDRESS) { this.endPoint_geo_FORMATED_ADDRESS = endPoint_geo_FORMATED_ADDRESS;}
    public Date getEndPoint_Time() {return endPoint_Time;}
    public void setEndPoint_Time(Date endPoint_Time) {this.endPoint_Time = endPoint_Time;}
    public Boolean getStation_locationInfoFromMap() { return station_locationInfoFromMap;}
    public void setStation_locationInfoFromMap(Boolean station_locationInfoFromMap) { this.station_locationInfoFromMap = station_locationInfoFromMap;}
    public String getStation_geo_STREET_NUMBER_KAPINO() { return station_geo_STREET_NUMBER_KAPINO;}
    public void setStation_geo_STREET_NUMBER_KAPINO(String station_geo_STREET_NUMBER_KAPINO) {this.station_geo_STREET_NUMBER_KAPINO = station_geo_STREET_NUMBER_KAPINO;}
    public String getStation_geo_ROUTE_SOKAK() {return station_geo_ROUTE_SOKAK;}
    public void setStation_geo_ROUTE_SOKAK(String station_geo_ROUTE_SOKAK) {this.station_geo_ROUTE_SOKAK = station_geo_ROUTE_SOKAK;}
    public String getStation_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() {return station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setStation_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) {this.station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getStation_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() { return station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setStation_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) {this.station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getStation_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() { return station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setStation_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) {this.station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getStation_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL() { return station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setStation_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) { this.station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getStation_geo_COUNTRY() { return station_geo_COUNTRY;}
    public void setStation_geo_COUNTRY(String station_geo_COUNTRY) {this.station_geo_COUNTRY = station_geo_COUNTRY;}
    public String getStation_geo_POSTAL_CODE() { return station_geo_POSTAL_CODE;}
    public void setStation_geo_POSTAL_CODE(String station_geo_POSTAL_CODE) { this.station_geo_POSTAL_CODE = station_geo_POSTAL_CODE;}
    public double getStation_geo_latitude() { return station_geo_latitude;}
    public void setStation_geo_latitude(double station_geo_latitude) { this.station_geo_latitude = station_geo_latitude;}
    public double getStation_geo_longitude() { return station_geo_longitude;}
    public void setStation_geo_longitude(double station_geo_longitude) {this.station_geo_longitude = station_geo_longitude;}
    public String getStation_geo_FORMATED_ADDRESS() { return station_geo_FORMATED_ADDRESS;}
    public void setStation_geo_FORMATED_ADDRESS(String station_geo_FORMATED_ADDRESS) { this.station_geo_FORMATED_ADDRESS = station_geo_FORMATED_ADDRESS;}
    public Date getStation_Time() { return station_Time;}
    public void setStation_Time(Date station_Time) {this.station_Time = station_Time;}
    public String getDestinationTown() { return destinationTown;}
    public void setDestinationTown(String destinationTown) {this.destinationTown = destinationTown;}
    public List<AdRouteBean> getLocationList() { return locationList;   }
    public void setLocationList(List<AdRouteBean> locationList) { this.locationList = locationList;  }
    public List<AdRouteStations> getLocationStationList() {return locationStationList;}
    public void setLocationStationList(List<AdRouteStations> locationStationList) {this.locationStationList = locationStationList;}
     @Override
    public String toString() {
        return "GetLocationFromMap{" +  "startPoint_geo_STREET_NUMBER_KAPINO=" + startPoint_geo_STREET_NUMBER_KAPINO +
                                        ", startPoint_geo_ROUTE_SOKAK=" + startPoint_geo_ROUTE_SOKAK + 
                                        ", startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=" + startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE + 
                                        ", startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=" + startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY + 
                                        ", startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=" + startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE + 
                                        ", startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=" + startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL + 
                                        ", startPoint_geo_COUNTRY=" + startPoint_geo_COUNTRY + 
                                        ", startPoint_geo_POSTAL_CODE=" + startPoint_geo_POSTAL_CODE + 
                                        ", startPoint_geo_latitude=" + startPoint_geo_latitude + 
                                        ", startPoint_geo_longitude=" + startPoint_geo_longitude + 
                                        ", startPoint_geo_FORMATED_ADDRESS=" + startPoint_geo_FORMATED_ADDRESS + 
                                        ", startPoint_Time=" + startPoint_Time + 
                                        ", endPoint_geo_STREET_NUMBER_KAPINO=" + endPoint_geo_STREET_NUMBER_KAPINO + 
                                        ", endPoint_geo_ROUTE_SOKAK=" + endPoint_geo_ROUTE_SOKAK + 
                                        ", endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=" + endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE + 
                                        ", endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=" + endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY + 
                                        ", endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=" + endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE + 
                                        ", endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=" + endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL + 
                                        ", endPoint_geo_COUNTRY=" + endPoint_geo_COUNTRY + 
                                        ", endPoint_geo_POSTAL_CODE=" + endPoint_geo_POSTAL_CODE + 
                                        ", endPoint_geo_latitude=" + endPoint_geo_latitude + 
                                        ", endPoint_geo_longitude=" + endPoint_geo_longitude + 
                                        ", endPoint_geo_FORMATED_ADDRESS=" + endPoint_geo_FORMATED_ADDRESS + 
                                        ", endPoint_Time=" + endPoint_Time +       
                                        ", station_locationInfoFromMap=" + station_locationInfoFromMap +                             
                                        ", station_geo_STREET_NUMBER_KAPINO=" + station_geo_STREET_NUMBER_KAPINO +                         
                                        ", station_geo_ROUTE_SOKAK=" + station_geo_ROUTE_SOKAK +                                
                                        ", station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=" + station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE +     
                                        ", station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=" + station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY +         
                                        ", station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=" + station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE +        
                                        ", station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=" + station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL +           
                                        ", station_geo_COUNTRY=" + station_geo_COUNTRY +                                  
                                        ", station_geo_POSTAL_CODE=" + station_geo_POSTAL_CODE +                             
                                        ", station_geo_latitude=" + station_geo_latitude +                               
                                        ", station_geo_longitude=" + station_geo_longitude +                             
                                        ", station_geo_FORMATED_ADDRESS=" + station_geo_FORMATED_ADDRESS +                         
                                        ", station_Time=" + station_Time +                                        
                                        ", destinationTown=" + destinationTown +  '}';                                      
                
    }public void locationSave(String adId, int locationQuantity) {
        int sonuc = 0;
        Date datex = null;

        try {   SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String dateInString = "00:00:00";
                datex = formatter.parse(dateInString);} 
        catch (ParseException ex) { System.err.println(":::HATA:::"+ex);  }
            adr.setAdRoute_StartPosition_Country("Türkiye");
            
            if(this.locationInfoFromMap!= true ){              
                if(this.cityListsBean.getSelectedCityID()==40){adr.setAdRoute_StartPosition_City("İSTANBUL");}
                if(this.cityListsBean.getSelectedCityID()==52){adr.setAdRoute_StartPosition_City("KOCAELİ");}
                if(this.cityListsBean.getSelectedCityID()==66){adr.setAdRoute_StartPosition_City("SAKARYA");}
                if(this.cityListsBean.getSelectedCityID()==73){adr.setAdRoute_StartPosition_City("TEKİRDAĞ");}
                
                CityListsDao cldz = new CityListsDao();
                adr.setAdRoute_StartPosition_Town( cldz.getTownDetailWithTownId(this.cityListsBean.getSelectedTownId()).getTownName());
                
                CityListsDao cld = new CityListsDao();
                adr.setAdRoute_StartPosition_Neighborhood(cld.getNeighborhoodDetailWithNeighborhoodId(this.cityListsBean.getSelectedNeighborhoodId()).getNeighborhoodName()           );
            }
            else{ 
                adr.setAdRoute_StartPosition_City(startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL); 
                adr.setAdRoute_StartPosition_Town(startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE);
                adr.setAdRoute_StartPosition_District(startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY);
                adr.setAdRoute_StartPosition_Neighborhood(startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE);
                adr.setAdRoute_StartPosition__Latitude(startPoint_geo_latitude);
                adr.setAdRoute_StartPosition__Longitude(startPoint_geo_longitude);
            }
            if(startPoint_Time == null){ adr.setAdRoute_StartTime(datex); } else{ adr.setAdRoute_StartTime(startPoint_Time); }         
      
            adr.setAdRoute_EndPosition_Country("Türkiye");
            
            if(this.locationInfoFromMap!= true ){              
                if(this.cityListsBean.getEndSelectedCityID()==40){adr.setAdRoute_EndPosition_City("İSTANBUL");}
                if(this.cityListsBean.getEndSelectedCityID()==52){adr.setAdRoute_EndPosition_City("KOCAELİ");}
                if(this.cityListsBean.getEndSelectedCityID()==66){adr.setAdRoute_EndPosition_City("SAKARYA");}
                if(this.cityListsBean.getEndSelectedCityID()==73){adr.setAdRoute_EndPosition_City("TEKİRDAĞ");}
                
                CityListsDao cldz = new CityListsDao();
                adr.setAdRoute_EndPosition_Town( cldz.getTownDetailWithTownId(this.cityListsBean.getEndSelectedTownId()).getTownName());
                
                CityListsDao cldx = new CityListsDao();
                adr.setAdRoute_EndPosition_Neighborhood(cldx.getNeighborhoodDetailWithNeighborhoodId(this.cityListsBean.getEndSelectedNeighborhoodId()).getNeighborhoodName()        );
                
            }
            else{ 
                adr.setAdRoute_EndPosition_City(endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL); 
                adr.setAdRoute_EndPosition_Town(endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE);
                adr.setAdRoute_EndPosition_District(endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY);
                adr.setAdRoute_EndPosition_Neighborhood(endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE);
                adr.setAdRoute_EndPosition__Latitude(endPoint_geo_latitude);
                adr.setAdRoute_EndPosition__Longitude(endPoint_geo_longitude);
            }
            if(endPoint_Time == null){ adr.setAdRoute_EndTime(datex); } else{ adr.setAdRoute_EndTime(endPoint_Time); }   
           
            adr.setAdRoute_destinationTown(destinationTown);
            adr.setAd_Id(adId);

            if (locationQuantity ==1 ){
                if(adr.getAdRoute_StartPosition_City() !=null && adr.getAdRoute_StartPosition_Town() != null){
                    if(!adr.getAdRoute_StartPosition_City().equals("") && !adr.getAdRoute_StartPosition_Town().equals("")){
                        AdRouteDao adrd = new AdRouteDao();
                        sonuc = adrd.createAdRoute(adr);
                    }
                    else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}
                }
                else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}
            }
            if (locationQuantity ==2 ){
                if(adr.getAdRoute_StartPosition_City() !=null && adr.getAdRoute_StartPosition_Town() != null){
                    if(adr.getAdRoute_EndPosition_City() !=null && adr.getAdRoute_EndPosition_Town() != null){
                        if(!adr.getAdRoute_StartPosition_City().equals("") && !adr.getAdRoute_StartPosition_Town().equals("")){
                            if(!adr.getAdRoute_EndPosition_City().equals("") && !adr.getAdRoute_EndPosition_Town().equals("")){
                                AdRouteDao adrd = new AdRouteDao();
                                sonuc = adrd.createAdRoute(adr);
                            }
                            else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}    
                        }
                        else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}
                    }
                    else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}    
                }
                else{Messages.dynMsg(null, "error", "Lütfen konum seçiniz");}
            }
            
            
            if(sonuc == 1){
                getAllLocationList(adId);
                
                locationStationList.clear();

                adr = null;
                adr = new AdRouteBean();
                adr.setAdRoute_Id(UniqueId.RandomString(12));
                adr.setAd_Id(adId);
                
                startPoint_geo_COUNTRY=null; 
                startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=null;
                startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=null;
                startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=null;
                startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=null;
                startPoint_geo_latitude=0;
                startPoint_geo_longitude=0;  
                startPoint_geo_FORMATED_ADDRESS=null;
                startPoint_Time=null;
                endPoint_geo_COUNTRY=null; 
                endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=null;
                endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=null;
                endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=null;
                endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=null;
                endPoint_geo_latitude=0;
                endPoint_geo_longitude=0; 
                endPoint_geo_FORMATED_ADDRESS=null;
                endPoint_Time=null;

                this.cityListsBean.resetAllPoint();
                
              
                PrimeFaces.current().executeScript("document.getElementById('SP_ADMINISTRATIVE_AREA_LEVEL_1').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('frdsr43e').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('autocomplete').value = '';");
      
                Messages.dynMsg(null, "info", "Seçtiğiniz konum Kaydedilmiştir");
            }  
    } public void addPassenger(){ 
        Date datex = null;
        try {   SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String dateInString = "00:00:00";           
                datex = formatter.parse(dateInString); }             
        catch (ParseException ex) { System.out.println(":::HATA:::"+ex);}
        
        int sonuc = 0;
        AdRouteStations adrs = new AdRouteStations();
        adrs.setAdRouteStation_Id(UniqueId.RandomString(12));
        adrs.setAdRoute_Id(adr.getAdRoute_Id());
        adrs.setAdRouteStation_Time(datex);
        adrs.setAdRouteStation_Comment(null);
        adrs.setAdRouteStation_Country(station_geo_COUNTRY);
        adrs.setAdRouteStation_City(station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL);
        adrs.setAdRouteStation_Town(station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE);
        adrs.setAdRouteStation_District(station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY);
        adrs.setAdRouteStation_Neighborhood(station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE);
        adrs.setAdRouteStation_Latitude(station_geo_latitude);
        adrs.setAdRouteStation_Longitude(station_geo_longitude);
        adrs.setAdRouteStation_Time(station_Time); 

            
        if(adrs.getAdRouteStation_City() != null && !adrs.getAdRouteStation_City().equals("")){
            AdRouteStationsDao adrd = new AdRouteStationsDao();
            sonuc = adrd.createAdRouteStation(adrs);

            if(sonuc == 1){
                Messages.dynMsg(null, "info", "Yeni bir yolcu/durak oluşturuldu"); 
                getAllLocationStationWithAdRouteId (adr.getAdRoute_Id()); // yeni durak-yolcu eklendikten sonra durak listesi yenileniyor.   

                startPoint_geo_COUNTRY=null;
                station_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=null;
                station_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=null;
                station_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=null;
                station_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=null;
                station_geo_latitude=0;
                station_geo_longitude=0;
                station_Time = null;
                startPoint_geo_FORMATED_ADDRESS=null;    
                
                PrimeFaces.current().executeScript("document.getElementById('autocomplete_3').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('SP_ADMINISTRATIVE_AREA_LEVEL_1xx').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('SP_ADMINISTRATIVE_AREA_LEVEL_2xx').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('SP_ADMINISTRATIVE_AREA_LEVEL_3xx').value = '';");
                PrimeFaces.current().executeScript("document.getElementById('SP_ADMINISTRATIVE_AREA_LEVEL_4xx').value = '';");
            }
            else{ Messages.dynMsg(null, "error", "Yeni bir yolcu/durak oluşturma sırasında sorun oluştu"); }
        }
        else { Messages.dynMsg(null, "error", "Yolcunun konumu seçilmedi, lütfen yolcunuzun konumunu seçiniz");}   
     } public void getAllLocationList(String adId){
        
        AdRouteDao ll = new AdRouteDao();
        this.locationList = ll.getAllAdRouteWithAdId(adId);
    
    }  public void getAllLocationStationWithAdRouteId(String adRouteId) {
        
        this.locationStationList.clear();

        AdRouteStationsDao a = new AdRouteStationsDao();
        this.locationStationList = a.getAllAdRouteStationWithAdRouteId(adRouteId); 
    }  public List<AdRouteStations> getAllLocationStationWithAdRouteId2(String adRouteId) {
        
        this.locationStationList.clear();
        
        List<AdRouteStations> al = new ArrayList<AdRouteStations>();
        AdRouteStationsDao a = new AdRouteStationsDao();
        al = a.getAllAdRouteStationWithAdRouteId(adRouteId); 
        
        return al;
    }    public void deleteLocationWithAdId(String adRouteId, String adId){
    
        int sonuc = 0;
        
        AdRouteDao adr = new AdRouteDao();
        sonuc = adr.deleteAdRouteWithAdId(adRouteId);
        
        if(sonuc == 1){
            getAllLocationList(adId);
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Seçtiğiniz konum SİLİNMİŞTİR");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    
    } public void deleteLocationStationWithAdId(String stationId){
    
        if(stationId != null){
            
            int sonuc = 0;

            AdRouteStationsDao adrx = new AdRouteStationsDao();
            sonuc = adrx.deleteAdRouteStationWithAdId(stationId);

            if(sonuc == 1){ 
                getAllLocationStationWithAdRouteId (adr.getAdRoute_Id()); // yeni durak-yolcu eklendikten sonra durak listesi yenileniyor.  
                Messages.dynMsg(null, "info", "Seçtiğiniz Yolcu/Durak SİLİNMİŞTİR");}       
        }
        else{System.err.println(":::HATA::: Durak Id null geldi");}
    }  public void mapClose() { 
    
        startPoint_geo_COUNTRY=null; 
        startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=null;
        startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=null;
        startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=null;
        startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=null;
        startPoint_geo_latitude=0;
        startPoint_geo_longitude=0;
        startPoint_Time = null;
        endPoint_geo_COUNTRY=null;
        endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL=null;
        endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE=null;
        endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY=null;
        endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE=null;
        endPoint_geo_latitude=0;
        endPoint_geo_longitude=0;
        endPoint_Time = null;
    
    }
    
    
    
}
