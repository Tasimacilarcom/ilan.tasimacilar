package com.tasimacilar.ilan.system.map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.json.JSONObject;
@ManagedBean(name = "geoBean")
@ViewScoped
public class Geo implements Serializable{
    
    private static final  String  apiKey = "AIzaSyCWCIe9mZhHfVnmwpEDOOKTqOkUgBjtmbE";
    
    private String geo_STREET_NUMBER_KAPINO;                   
    private String geo_ROUTE_SOKAK;                            
    private String geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;    
    private String geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;        
    private String geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;       
    private String geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;        
    private String geo_COUNTRY;                                 
    private String geo_POSTAL_CODE;                            
    private double geo_latitude;                                
    private double geo_longitude;                              
    private String geo_FORMATED_ADDRESS;                      

    private String  STREET_ADDRESS, INTERSECTION, CONTINENT, POLITICAL, ADMINISTRATIVE_AREA_LEVEL_5, 
                    COLLOQUIAL_AREA, LOCALITY, WARD, SUBLOCALITY, SUBLOCALITY_LEVEL_1, SUBLOCALITY_LEVEL_2, 
                    SUBLOCALITY_LEVEL_3, SUBLOCALITY_LEVEL_4, SUBLOCALITY_LEVEL_5, NEIGHBORHOOD, 
                    PREMISE, SUBPREMISE, POSTAL_CODE_PREFIX, POSTAL_CODE_SUFFIX, NATURAL_FEATURE, AIRPORT, 
                    PARK, POINT_OF_INTEREST, FLOOR, ESTABLISHMENT, PARKING, POST_BOX, POSTAL_TOWN, 
                    ROOM, BUS_STATION, TRAIN_STATION, SUBWAY_STATION, TRANSIT_STATION, 
                    LIGHT_RAIL_STATION, GENERAL_CONTRACTOR, FOOD, REAL_ESTATE_AGENCY, CAR_RENTAL, 
                    TRAVEL_AGENCY, ELECTRONICS_STORE, HOME_GOODS_STORE, SCHOOL, STORE, SHOPPING_MALL, 
                    LODGING, ART_GALLERY, LAWYER, RESTAURANT, BAR, MEAL_TAKEAWAY, CLOTHING_STORE, 
                    LOCAL_GOVERNMENT_OFFICE, FINANCE, MOVING_COMPANY, STORAGE, CAFE, CAR_REPAIR, 
                    HEALTH, INSURANCE_AGENCY, PAINTER, UNKNOWN;

    public Geo() {  }
    public String getGeo_STREET_NUMBER_KAPINO() {return geo_STREET_NUMBER_KAPINO;}
    public void setGeo_STREET_NUMBER_KAPINO(String geo_STREET_NUMBER_KAPINO) {this.geo_STREET_NUMBER_KAPINO = geo_STREET_NUMBER_KAPINO;}
    public String getGeo_ROUTE_SOKAK() {return geo_ROUTE_SOKAK;}
    public void setGeo_ROUTE_SOKAK(String geo_ROUTE_SOKAK) {this.geo_ROUTE_SOKAK = geo_ROUTE_SOKAK;}
    public String getGeo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() {return geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setGeo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) {this.geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getGeo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() {return geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setGeo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) {this.geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getGeo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() {return geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setGeo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) {this.geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getGeo_ADMINISTRATIVE_AREA_LEVEL_1_IL() {return geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setGeo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) {this.geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getGeo_COUNTRY() {return geo_COUNTRY;}
    public void setGeo_COUNTRY(String geo_COUNTRY) {this.geo_COUNTRY = geo_COUNTRY;}
    public String getGeo_POSTAL_CODE() {return geo_POSTAL_CODE;}
    public void setGeo_POSTAL_CODE(String geo_POSTAL_CODE) {this.geo_POSTAL_CODE = geo_POSTAL_CODE;}
    public double getGeo_latitude() {return geo_latitude;}
    public void setGeo_latitude(double geo_latitude) {this.geo_latitude = geo_latitude;}
    public double getGeo_longitude() {return geo_longitude;}
    public void setGeo_longitude(double geo_longitude) {this.geo_longitude = geo_longitude;}
    public String getGeo_FORMATED_ADDRESS() {return geo_FORMATED_ADDRESS;}
    public void setGeo_FORMATED_ADDRESS(String geo_FORMATED_ADDRESS) { this.geo_FORMATED_ADDRESS = geo_FORMATED_ADDRESS;}
      
    @Override
    public String toString() {
        return "Geo{" + "geo_STREET_NUMBER=" + geo_STREET_NUMBER_KAPINO 
                      + ", geo_ROUTE=" + geo_ROUTE_SOKAK 
                      + ", geo_ADMINISTRATIVE_AREA_LEVEL_4=" + geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE 
                      + ", geo_ADMINISTRATIVE_AREA_LEVEL_3=" + geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY 
                      + ", geo_ADMINISTRATIVE_AREA_LEVEL_2=" + geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE 
                      + ", geo_ADMINISTRATIVE_AREA_LEVEL_1=" + geo_ADMINISTRATIVE_AREA_LEVEL_1_IL 
                      + ", geo_COUNTRY=" + geo_COUNTRY 
                      + ", geo_POSTAL_CODE=" + geo_POSTAL_CODE 
                      + ", geo_latitude=" + geo_latitude 
                      + ", geo_longitude=" + geo_longitude + '}';
    }
    public static String geoFormattedAddressFromLatLng(double latitude, double longitude){
    
        String address = "Tanımsız";
        
        try {
            GeoApiContext contextx;
            contextx = new GeoApiContext.Builder().apiKey(apiKey).build();

            LatLng latlng = new LatLng(latitude, longitude);
            GeocodingResult[] results = GeocodingApi.newRequest(contextx).latlng(latlng).await();

            if (results.length > 0) {
                address = results[0].formattedAddress.toString();
                System.out.println("geoFormattedAddress : "+results[0].formattedAddress);
            }
        }
        catch (ApiException ex) { System.err.println(":::HATA::: ApiException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (InterruptedException ex) { System.err.println(":::HATA::: InterruptedException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (IOException ex) { System.err.println(":::HATA::: IOException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); }
    
    return address;
    
    }
    public static Geo geoAddressFromLatLng(double latitude, double longitude){
    
        Geo g = new Geo();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try {
            GeoApiContext contextx;
            contextx = new GeoApiContext.Builder().apiKey(apiKey).build();

            LatLng latlng = new LatLng(latitude, longitude);
            GeocodingResult[] results = GeocodingApi.newRequest(contextx).latlng(latlng).await();

            if (results != null && results.length > 0) {

               
                for (AddressComponent addressComponent : results[0].addressComponents) {
                    switch (addressComponent.types[0]) {
                        
                        case POSTAL_CODE:                           
                            String postalCode = addressComponent.longName.replaceAll("\\s+", ""); 
                            g.setGeo_POSTAL_CODE(postalCode);
                            break;
                            
                        case STREET_NUMBER:
                            g.setGeo_STREET_NUMBER_KAPINO(addressComponent.longName);
                            break;
                            
                        case ROUTE:
                            g.setGeo_ROUTE_SOKAK(addressComponent.longName);
                            break;
                            
                        case ADMINISTRATIVE_AREA_LEVEL_1:
                            g.setGeo_ADMINISTRATIVE_AREA_LEVEL_1_IL(addressComponent.longName);
                            break;
                            
                        case ADMINISTRATIVE_AREA_LEVEL_2:
                            g.setGeo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(addressComponent.longName);
                            break;
                            
                        case ADMINISTRATIVE_AREA_LEVEL_3:
                            g.setGeo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(addressComponent.longName);
                            break;
                            
                        case ADMINISTRATIVE_AREA_LEVEL_4:
                            g.setGeo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(addressComponent.longName);
                            break;
                            
                        case COUNTRY:
                            g.setGeo_COUNTRY(addressComponent.shortName);
                            break;
                            
                        default:
                            break;
                    }
                }
              
            }
        }
        catch (ApiException ex) { System.err.println(":::HATA::: ApiException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (InterruptedException ex) { System.err.println(":::HATA::: InterruptedException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (IOException ex) { System.err.println(":::HATA::: IOException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); }
    
    return g;
    
    } public static Geo geoLatLngFromFormattedAddress(Geo geoAdress){
       
        Geo g = new Geo();
        
        try {
            GeoApiContext contextq = new GeoApiContext.Builder().apiKey("AIzaSyCWCIe9mZhHfVnmwpEDOOKTqOkUgBjtmbE").build();
            GeocodingResult[] results = GeocodingApi.geocode(contextq,"Yeni Mahalle Mahallesi, Birkandan Sk. No:29, 34815 Beykoz/İstanbul, Turkey").await();
            
            String latLong = "";
            if (results != null && results.length > 0) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                latLong = gson.toJson(results[0].geometry);
                String latitude = "";
                String longitude = "";
                JSONObject jsonObject = new JSONObject(latLong);
                JSONObject location = jsonObject.getJSONObject("location");
                latitude = location.get("lat").toString();
                longitude = location.get("lng").toString();

                latLong = latitude + "," + longitude;
                System.out.println("latLong : "+latLong);
            }
          
        }
        catch (ApiException ex) { System.err.println(":::HATA::: ApiException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (InterruptedException ex) { System.err.println(":::HATA::: InterruptedException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); } 
        catch (IOException ex) { System.err.println(":::HATA::: IOException ::: ClassName:com.tasimacilar.ilan.ad.Geo :::"+ex.toString()+":::"); }
        
        
        return g;
    }
    
    
    
    
    
}
