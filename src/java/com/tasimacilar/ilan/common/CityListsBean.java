package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.vehicle.VehicleBrandAndModelDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "cityListsBean")
@ViewScoped
public class CityListsBean implements Serializable{
    private int     CountryID;              
    private String  CountryBinaryCode;      
    private String  CountryTripleCode;      
    private String  CountryName;           
    private String  CountryPhoneCode;       
    private int     CityID;               
    private String  CityName;              
    private String  CityPlateNo;           
    private String  CityPhoneCode;         
    private int     TownID;               
    private String  TownName;              
    private int     DistrictID;           
    private String  DistrictName;          
    private int     NeighborhoodID;        
    private String  NeighborhoodName;      
    private String  NeighborhoodZipCode;   
    private List<CityListsBean> townListStart = new ArrayList<CityListsBean>();
    private List<CityListsBean> townListEnd = new ArrayList<CityListsBean>();
    private List<CityListsBean> neighborhoodListStart = new ArrayList<CityListsBean>();
    private List<CityListsBean> neighborhoodListEnd = new ArrayList<CityListsBean>();
    private int         selectedCityID;               
    private int         endSelectedCityID;            
    private int         selectedTownId;                
    private int         endSelectedTownId;                   
    private int         selectedNeighborhoodId;        
    private int         endSelectedNeighborhoodId;    
     @PostConstruct
    public void init() {  
        CityListsDao cd = new CityListsDao();
        this.townListStart = cd.getTownDetailWithCity(40);
        CityListsDao cdx = new CityListsDao();
        this.townListEnd = cdx.getTownDetailWithCity(40);
    } public CityListsBean() {  }
    public CityListsBean(   int CountryID, String CountryBinaryCode, String CountryTripleCode, 
                            String CountryName, String CountryPhoneCode, int CityID, String CityName, 
                            String CityPlateNo, String CityPhoneCode, int TownID, String TownName, 
                            int DistrictID, String DistrictName, int NeighborhoodID, 
                            String NeighborhoodName, String NeighborhoodZipCode) {
        this.CountryID = CountryID;
        this.CountryBinaryCode = CountryBinaryCode;
        this.CountryTripleCode = CountryTripleCode;
        this.CountryName = CountryName;
        this.CountryPhoneCode = CountryPhoneCode;
        this.CityID = CityID;
        this.CityName = CityName;
        this.CityPlateNo = CityPlateNo;
        this.CityPhoneCode = CityPhoneCode;
        this.TownID = TownID;
        this.TownName = TownName;
        this.DistrictID = DistrictID;
        this.DistrictName = DistrictName;
        this.NeighborhoodID = NeighborhoodID;
        this.NeighborhoodName = NeighborhoodName;
        this.NeighborhoodZipCode = NeighborhoodZipCode;
    }
    public int getCountryID() {return CountryID;}
    public void setCountryID(int CountryID) {this.CountryID = CountryID;}
    public String getCountryBinaryCode() {return CountryBinaryCode;}
    public void setCountryBinaryCode(String CountryBinaryCode) {this.CountryBinaryCode = CountryBinaryCode;}
    public String getCountryTripleCode() {return CountryTripleCode;}
    public void setCountryTripleCode(String CountryTripleCode) {this.CountryTripleCode = CountryTripleCode;}
    public String getCountryName() {return CountryName;}
    public void setCountryName(String CountryName) {this.CountryName = CountryName;}
    public String getCountryPhoneCode() {return CountryPhoneCode;}
    public void setCountryPhoneCode(String CountryPhoneCode) {this.CountryPhoneCode = CountryPhoneCode;}
    public int getCityID() {return CityID;}
   public void setCityID(int CityID) {this.CityID = CityID;}
    public String getCityName() {return CityName;}
    public void setCityName(String CityName) {this.CityName = CityName;}
    public String getCityPlateNo() {return CityPlateNo;}
    public void setCityPlateNo(String CityPlateNo) {this.CityPlateNo = CityPlateNo;}
    public String getCityPhoneCode() {return CityPhoneCode;}
    public void setCityPhoneCode(String CityPhoneCode) {this.CityPhoneCode = CityPhoneCode;}
    public int getTownID() {return TownID;}
    public void setTownID(int TownID) {this.TownID = TownID;}
    public String getTownName() {return TownName;}
    public void setTownName(String TownName) {this.TownName = TownName;}
    public int getDistrictID() {return DistrictID;}
    public void setDistrictID(int DistrictID) {this.DistrictID = DistrictID;}
    public String getDistrictName() {return DistrictName;}
    public void setDistrictName(String DistrictName) {this.DistrictName = DistrictName;}
    public int getNeighborhoodID() { return NeighborhoodID;}
    public void setNeighborhoodID(int NeighborhoodID) {this.NeighborhoodID = NeighborhoodID;}
    public String getNeighborhoodName() {return NeighborhoodName;}
    public void setNeighborhoodName(String NeighborhoodName) {this.NeighborhoodName = NeighborhoodName;}
    public String getNeighborhoodZipCode() {return NeighborhoodZipCode;}
    public void setNeighborhoodZipCode(String NeighborhoodZipCode) {this.NeighborhoodZipCode = NeighborhoodZipCode;}
    public List<CityListsBean> getTownListStart() { return townListStart;}
    public void setTownListStart(List<CityListsBean> townListStart) { this.townListStart = townListStart;}
    public List<CityListsBean> getTownListEnd() { return townListEnd;}
    public void setTownListEnd(List<CityListsBean> townListEnd) { this.townListEnd = townListEnd;}
    public List<CityListsBean> getNeighborhoodListStart() {return neighborhoodListStart;}
    public void setNeighborhoodListStart(List<CityListsBean> neighborhoodListStart) {this.neighborhoodListStart = neighborhoodListStart;}
    public List<CityListsBean> getNeighborhoodListEnd() {return neighborhoodListEnd;}
    public void setNeighborhoodListEnd(List<CityListsBean> neighborhoodListEnd) {this.neighborhoodListEnd = neighborhoodListEnd;}
    public int getSelectedCityID() {return selectedCityID;}
    public void setSelectedCityID(int selectedCityID) { this.selectedCityID = selectedCityID;}
    public int getEndSelectedCityID() { return endSelectedCityID;}
    public void setEndSelectedCityID(int endSelectedCityID) { this.endSelectedCityID = endSelectedCityID;}
    public int getSelectedTownId() { return selectedTownId;}
    public void setSelectedTownId(int selectedTownId) { this.selectedTownId = selectedTownId;}
    public int getEndSelectedTownId() {return endSelectedTownId;}
    public void setEndSelectedTownId(int endSelectedTownId) { this.endSelectedTownId = endSelectedTownId;}
    public int getSelectedNeighborhoodId() {return selectedNeighborhoodId;}
    public void setSelectedNeighborhoodId(int selectedNeighborhoodId) {this.selectedNeighborhoodId = selectedNeighborhoodId;}
    public int getEndSelectedNeighborhoodId() {return endSelectedNeighborhoodId;}
    public void setEndSelectedNeighborhoodId(int endSelectedNeighborhoodId) {this.endSelectedNeighborhoodId = endSelectedNeighborhoodId;}
public List<CityListsBean> cityList() { CityListsDao cd = new CityListsDao();
return cd.getAllCityWithDetail();  }
public void townListxStartPoint() { CityListsDao cd = new CityListsDao();
        this.townListStart = cd.getTownDetailWithCity(this.selectedCityID);}
public void townListxEndPoint() {  CityListsDao cd = new CityListsDao();
        this.townListEnd = cd.getTownDetailWithCity(this.endSelectedCityID);
    }public void neighborhoodListxStartPoint() { 
CityListsDao cd = new CityListsDao(); this.neighborhoodListStart = cd.getNeighborhoodDetailWithTown(this.selectedTownId);  }
 public void neighborhoodListxEndPoint() {  CityListsDao cd = new CityListsDao();
        this.neighborhoodListEnd = cd.getNeighborhoodDetailWithTown(this.endSelectedTownId);
    }public void resetAllPoint() { 
        this.townListStart.clear();
        this.townListEnd.clear();
        this.neighborhoodListStart.clear();
        this.neighborhoodListEnd.clear();
        this.selectedCityID = 0; 
        this.endSelectedCityID = 0; 
        this.selectedTownId  = 0; 
        this.endSelectedTownId  = 0;        
        this.selectedNeighborhoodId  = 0; 
        this.endSelectedNeighborhoodId = 0; 
    }  
}
