package com.tasimacilar.ilan.ad;
import com.tasimacilar.ilan.ad.aracimVarHostesAriyorum.Ad_AracimVarHostesAriyorum;
import com.tasimacilar.ilan.ad.aracimVarIsAriyorum.Ad_AracimVarIsAriyorum;
import com.tasimacilar.ilan.ad.aracimVarSoforAriyorum.Ad_AracimVarSoforAriyorum;
import com.tasimacilar.ilan.ad.hostesimİsAriyorum.Ad_HostesimİsAriyorum_Bean;
import com.tasimacilar.ilan.ad.isimvarAracAriyorum.Ad_IsimVarAracAriyorum;
import com.tasimacilar.ilan.ad.plakamiSatiyorum.Ad_PlakamiSatiyorum;
import com.tasimacilar.ilan.ad.route.*;
import com.tasimacilar.ilan.ad.search.Ad_Search_Bean;
import com.tasimacilar.ilan.ad.search.Ad_Search_Dao;
import com.tasimacilar.ilan.ad.search.Ad_Search_InputEntity;
import com.tasimacilar.ilan.ad.soforumİsAriyorum.Ad_SoforumİsAriyorum_Bean;
import com.tasimacilar.ilan.admin.DashboardDao;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.profile.account.*;
import com.tasimacilar.ilan.profile.account.corporate.*;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.vehicle.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.*;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
@ManagedBean(name = "adBean")@ViewScoped
public class Ad_Bean implements Serializable{ 
    private String      ad_Id;                     
    private String      ad_Id2;                    
    private int         ad_Category_Id;           
    private String      ad_Category_Name;           
    private String      ad_Title;                   
    private String      ad_Comment;             
    private String      ad_CommentFormated;         
    private String      ad_Type;                    
    private String      ad_OvnerAccountId;         
    private boolean     ad_IsActive;               
    private Date        ad_EndTime;               
    private String      ad_Notes;                 
    private Date        ad_CreateTime;             
    private String      ad_CreatedIp;           
    private String      ad_CreatedAccountId;        
    private String      ad_LastModifyIp;          
    private Date        ad_LastModifyTime;       
    private String      ad_LastChangerAccountId; 
    private boolean     ad_IsPublish;             
    private boolean     ad_UserEnableDisable;
    private Date        ad_PublishDate;                
    private RepeatPaginator paginator;
    private List<Ad_Bean> adList = new ArrayList<Ad_Bean>();  
    private RepeatPaginator paginator2;
    private List<Ad_Bean> adList2 = new ArrayList<Ad_Bean>();  
    private RepeatPaginatorForMobile paginatorForMobile;
    private List<Ad_Bean> adListForMobile = new ArrayList<Ad_Bean>(); 
    private List<Ad_Bean> notPublishAdList;
    private List<Ad_Bean> filteredNotPublishAdList;
    private String      selectedAdId;                     
    private Ad_Bean     selectedAd;                    
    private String      selectedImagesUrl;
    private String      selectedVideoUrl;   
    private List<Ad_Bean> PublishAdList;
    private List<Ad_Bean> filteredPublishAdList;
    private List<Ad_Bean> userPublishAdList;
    private List<Ad_Bean> userFilteredPublishAdList;
    private String aIdx; 
    private List<Ad_Bean> myAdsList;
    private List<Ad_Bean> selectedMyAdsList;
    private List<Ad_Bean> filteredMyAdsList;
    private Ad_IsimVarAracAriyorum      adIsimVarAracAriyorum;             
    private Vehicle                     adIsimVarAracAriyorum_vehicle;      
    private Ad_AracimVarSoforAriyorum   ad_AracimVarSoforAriyorum;       
    private Vehicle                     adAracimVarSoforAriyorum_vehicle;  
    private Ad_AracimVarHostesAriyorum  adAracimVarHostesAriyorum;        
    private Ad_AracimVarIsAriyorum      adAracimVarIsAriyorum;            
    private Vehicle                     adAracimVarIsAriyorum_vehicle;     
    private Ad_PlakamiSatiyorum         adPlakamiSatiyorum;                
    private Ad_HostesimİsAriyorum_Bean  adHostesimIsAriyorumBean;         
    private Ad_SoforumİsAriyorum_Bean   adSoforumIsAriyorumBean;         
    private AdRouteBean adrb = new AdRouteBean(); 
    private int         adSize_ToDay_ForUser;
    private int         adSize_All_ForUser;
    private String      adSortType;
    private String      filterCategory;
    private boolean     filterCategory_IsimVarAracAriyorum;
    private boolean     filterCategory_AracimVarIsAriyorum;
    private boolean     filterCategory_AracimVarSoforAriyorum;
    private boolean     filterCategory_AracimVarHostesAriyorum;
    private boolean     filterCategory_HostesimIsAriyorum;
    private boolean     filterCategory_SoforumIsAriyorum;
    private boolean     filterCategory_PlakamiSatiyorum;
    private String      lastTime;
    private String      company;
    private String[]    selected_ServiceTypes;  
    private int         selected_cityPlateNo;
    private String          vehicle_Brand;               
    private String          vehicle_Model;                 
    private String          vehicle_ModelYear = "farketmez";             
    private boolean         Vehicle_ModelYearAndOver;     
    private int             VehicleBrandId;
    private List<String>    vehicleModelsList = new ArrayList<String>();
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
    private String  startTime;                                              
    private String  startFrmAdd;   
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
    private String  endTime;                                          
    private String  endFrmAdd; 
    private Map<String,Boolean> checkMap = new HashMap<String,Boolean>(); 
    private int pCatId;
    private int toplamKullaniciSayisi; 
    private int ilanId_old;  
    private boolean leftSidebarShow;
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}  
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;
    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    @ManagedProperty(value="#{vehicleBean}")
    private VehicleBean vehicleBean;
    public VehicleBean getVehicleBean() {return vehicleBean;}
    public void setVehicleBean(VehicleBean vehicleBean) {this.vehicleBean = vehicleBean;}
    @ManagedProperty(value="#{adSearchBean}")
    private Ad_Search_Bean adSearchBean;
    public Ad_Search_Bean getAdSearchBean() {return adSearchBean;  }
    public void setAdSearchBean(Ad_Search_Bean adSearchBean) { this.adSearchBean = adSearchBean;  }
    @PostConstruct public void init() {   adSortType = "DESC";
    HttpServletRequest req33 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String pCatIdx = req33.getParameter("pCatId");                 
        String pBrandx = req33.getParameter("pBrand");                       
        String pCapasityx = req33.getParameter("pCapacity");           
        String pCompanyName = req33.getParameter("companyName");     
        String pCompanyId = req33.getParameter("companyId");        
        String pUserId = req33.getParameter("userId");                
        if(pCompanyName != null){
            CorporateAccountBean cb = new CorporateAccountBean();
            CorporateAccountDao cd = new CorporateAccountDao();
            cb = cd.getCompanyWithUrlName(pCompanyName);
            this.adList = adSearchBean.findAllForCompany(cb.getCompany_Id());      
            paginator = new RepeatPaginator(this.adList);   
            paginatorForMobile = new RepeatPaginatorForMobile(this.adList);     }
        else if(pCompanyId != null){
            this.adList = adSearchBean.findAllForCompany(pCompanyId);
            paginator = new RepeatPaginator(this.adList); 
            paginatorForMobile = new RepeatPaginatorForMobile(this.adList);    }
        else if(pUserId != null){ Ad_Dao ad = new Ad_Dao();
            this.adList = ad.getUserAdWithPublish2(pUserId);
            paginator = new RepeatPaginator(this.adList);   
            paginatorForMobile = new RepeatPaginatorForMobile(this.adList);   }
        else if(pCapasityx != null){      
            if(!pCapasityx.equals("")){       
                try { pCapasityx = java.net.URLEncoder.encode(pCapasityx,"UTF-8");} 
                catch (UnsupportedEncodingException ex) {System.err.println(":::HATA:::"+ex); }   
                filterGetAllAdWithVehicleBrandAndCapacity("capasity", pCapasityx);
             }       }
        else if (pCatIdx != null ){  if (!pCatIdx.equals("") ){   this.pCatId = Integer.parseInt(pCatIdx);  clearFilter();            
                this.adList =  this.adSearchBean.findAllForCategory(pCatId);             
                if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
                if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
                if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
                if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
                if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek4", "reklam"));}             
                paginator = new RepeatPaginator(this.adList); 
                paginatorForMobile = new RepeatPaginatorForMobile(this.adList); 
            }  }
        else if(pBrandx != null){
            if(!pBrandx.equals("")){
                filterGetAllAdWithVehicleBrandAndCapacity("brand", pBrandx);  } } else{ getAllAd ();
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            aIdx = req.getParameter("aId");
 String url = req.getRequestURL().toString();
            try {    URL urlx = new URL(url);   if( FilenameUtils.getBaseName(urlx.getPath()).equals("personal_my_ads") || 
                        FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_my_ads") ){
                        getAllAdWithOvnerAccountId (SessionUtil.getUserId());
                        paginator2 = new RepeatPaginator(this.adList2);  } if(FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_userAds")){
                         if(aIdx != null && !aIdx.equals("")){  getUserPublishedAd(aIdx); }
                    } } 
            catch (MalformedURLException ex) {System.err.println(":::HATA::: "+ex); } }
        HttpServletRequest req2 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();   
        String param1 = null;  param1 = req2.getParameter("p1"); 
        if (param1 != null && param1.equals("getAllNotPublishedAd")){   getAllNotPublishedAd(); }
        HttpServletRequest req3 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
        String param2 = null;
        param2 = req3.getParameter("p2");    
        if (param2 != null && param2.equals("getAllPublishedAd")){  getAllPublishedAd(); }
    }  public Ad_Bean() {  }public Ad_Bean(String ad_Id, String ad_Category_Name ) {
        this.ad_Id = ad_Id;
        this.ad_Category_Name = ad_Category_Name;
        this.ad_PublishDate = new Date();
    }  public RepeatPaginator getPaginator() { return paginator;  }
    public RepeatPaginator getPaginator2() { return paginator2;  }
    public RepeatPaginatorForMobile getPaginatorForMobile() { return paginatorForMobile; }   
    public String getAd_Id2() {return ad_Id2;}
    public void setAd_Id2(String ad_Id2) { this.ad_Id2 = ad_Id2; }   
    public String getAd_Id() {return ad_Id; }
    public void setAd_Id(String ad_Id) { this.ad_Id = ad_Id;}
    public int getAd_Category_Id() {return ad_Category_Id;}
    public void setAd_Category_Id(int ad_Category_Id) {this.ad_Category_Id = ad_Category_Id;}
    public String getAd_Category_Name() {return ad_Category_Name;}
    public void setAd_Category_Name(String ad_Category_Name) {this.ad_Category_Name = ad_Category_Name;}
    public String getAd_Title() {return ad_Title;}
    public void setAd_Title(String ad_Title) {this.ad_Title = ad_Title;}
    public String getAd_Comment() {return ad_Comment;}
    public void setAd_Comment(String ad_Comment) {this.ad_Comment = ad_Comment;}
    public String getAd_CommentFormated() {return ad_CommentFormated;}
    public void setAd_CommentFormated(String ad_CommentFormated) {this.ad_CommentFormated = ad_CommentFormated;}
    public String getAd_Type() { return ad_Type;}
    public void setAd_Type(String ad_Type) {this.ad_Type = ad_Type;}
    public String getAd_OvnerAccountId() {return ad_OvnerAccountId;}
    public void setAd_OvnerAccountId(String ad_OvnerAccountId) { this.ad_OvnerAccountId = ad_OvnerAccountId;}
    public boolean isAd_IsActive() {return ad_IsActive;}
    public void setAd_IsActive(boolean ad_IsActive) {this.ad_IsActive = ad_IsActive;}
    public Date getAd_EndTime() {return ad_EndTime;}
    public void setAd_EndTime(Date ad_EndTime) {this.ad_EndTime = ad_EndTime;}
    public String getAd_Notes() {return ad_Notes;}
    public void setAd_Notes(String ad_Notes) {this.ad_Notes = ad_Notes;}
    public Date getAd_CreateTime() { return ad_CreateTime;}
    public void setAd_CreateTime(Date ad_CreateTime) {this.ad_CreateTime = ad_CreateTime;}
    public String getAd_CreatedIp() {return ad_CreatedIp;}
    public void setAd_CreatedIp(String ad_CreatedIp) {this.ad_CreatedIp = ad_CreatedIp;}
    public String getAd_CreatedAccountId() {return ad_CreatedAccountId;}
    public void setAd_CreatedAccountId(String ad_CreatedAccountId) {this.ad_CreatedAccountId = ad_CreatedAccountId;}
    public String getAd_LastModifyIp() {return ad_LastModifyIp;}
    public void setAd_LastModifyIp(String ad_LastModifyIp) {this.ad_LastModifyIp = ad_LastModifyIp;}
    public Date getAd_LastModifyTime() {return ad_LastModifyTime;}
    public void setAd_LastModifyTime(Date ad_LastModifyTime) {this.ad_LastModifyTime = ad_LastModifyTime;}
    public String getAd_LastChangerAccountId() {return ad_LastChangerAccountId;}
    public void setAd_LastChangerAccountId(String ad_LastChangerAccountId) {this.ad_LastChangerAccountId = ad_LastChangerAccountId;}
    public boolean isAd_IsPublish() { return ad_IsPublish;}
    public void setAd_IsPublish(boolean ad_IsPublish) {this.ad_IsPublish = ad_IsPublish;}
    public Date getAd_PublishDate() {return ad_PublishDate;  }
    public void setAd_PublishDate(Date ad_PublishDate) {this.ad_PublishDate = ad_PublishDate; }
    public boolean isAd_UserEnableDisable() {  return ad_UserEnableDisable;}
    public void setAd_UserEnableDisable(boolean ad_UserEnableDisable) { this.ad_UserEnableDisable = ad_UserEnableDisable;}       
    public List<Ad_Bean> getAdList() {return adList;}
    public void setAdList(List<Ad_Bean> adList) {this.adList = adList;}
    public List<Ad_Bean> getNotPublishAdList() { return notPublishAdList;}
    public void setNotPublishAdList(List<Ad_Bean> notPublishAdList) { this.notPublishAdList = notPublishAdList;}
    public List<Ad_Bean> getFilteredNotPublishAdList() { return filteredNotPublishAdList;}
    public void setFilteredNotPublishAdList(List<Ad_Bean> filteredNotPublishAdList) { this.filteredNotPublishAdList = filteredNotPublishAdList;}
    public List<Ad_Bean> getPublishAdList() {return PublishAdList;}
    public void setPublishAdList(List<Ad_Bean> PublishAdList) { this.PublishAdList = PublishAdList;}
    public List<Ad_Bean> getFilteredPublishAdList() { return filteredPublishAdList;}
    public void setFilteredPublishAdList(List<Ad_Bean> filteredPublishAdList) { this.filteredPublishAdList = filteredPublishAdList;}
    public List<Ad_Bean> getUserPublishAdList() {return userPublishAdList;}
    public void setUserPublishAdList(List<Ad_Bean> userPublishAdList) {this.userPublishAdList = userPublishAdList;}
    public List<Ad_Bean> getUserFilteredPublishAdList() {return userFilteredPublishAdList;}
    public void setUserFilteredPublishAdList(List<Ad_Bean> userFilteredPublishAdList) {this.userFilteredPublishAdList = userFilteredPublishAdList;}
    public List<Ad_Bean> getMyAdsList() {return myAdsList;}
    public void setMyAdsList(List<Ad_Bean> myAdsList) {this.myAdsList = myAdsList;}
    public List<Ad_Bean> getSelectedMyAdsList() {return selectedMyAdsList;}
    public void setSelectedMyAdsList(List<Ad_Bean> selectedMyAdsList) {this.selectedMyAdsList = selectedMyAdsList;}
    public List<Ad_Bean> getFilteredMyAdsList() {return filteredMyAdsList;}
    public void setFilteredMyAdsList(List<Ad_Bean> filteredMyAdsList) {this.filteredMyAdsList = filteredMyAdsList;}
    public String getSelectedAdId() {return selectedAdId;}
    public void setSelectedAdId(String selectedAdId) { this.selectedAdId = selectedAdId;}
    public Ad_Bean getSelectedAd() { return selectedAd;}
    public void setSelectedAd(Ad_Bean selectedAd) { this.selectedAd = selectedAd;}
    public String getSelectedImagesUrl() { return selectedImagesUrl;}
    public void setSelectedImagesUrl(String selectedImagesUrl) { this.selectedImagesUrl = selectedImagesUrl;}
    public String getSelectedVideoUrl() { return selectedVideoUrl;}
    public void setSelectedVideoUrl(String selectedVideoUrl) { this.selectedVideoUrl = selectedVideoUrl;}
    public Ad_IsimVarAracAriyorum getAdIsimVarAracAriyorum() { return adIsimVarAracAriyorum;  }
    public void setAdIsimVarAracAriyorum(Ad_IsimVarAracAriyorum adIsimVarAracAriyorum) { this.adIsimVarAracAriyorum = adIsimVarAracAriyorum; }
    public Vehicle getAdIsimVarAracAriyorum_vehicle() {return adIsimVarAracAriyorum_vehicle;}
    public void setAdIsimVarAracAriyorum_vehicle(Vehicle adIsimVarAracAriyorum_vehicle) {this.adIsimVarAracAriyorum_vehicle = adIsimVarAracAriyorum_vehicle;}
    public Ad_AracimVarSoforAriyorum getAd_AracimVarSoforAriyorum() { return ad_AracimVarSoforAriyorum; }
    public void setAd_AracimVarSoforAriyorum(Ad_AracimVarSoforAriyorum ad_AracimVarSoforAriyorum) {this.ad_AracimVarSoforAriyorum = ad_AracimVarSoforAriyorum; }
    public Vehicle getAdAracimVarSoforAriyorum_vehicle() {return adAracimVarSoforAriyorum_vehicle;}
    public void setAdAracimVarSoforAriyorum_vehicle(Vehicle adAracimVarSoforAriyorum_vehicle) {  this.adAracimVarSoforAriyorum_vehicle = adAracimVarSoforAriyorum_vehicle;}   
    public Ad_AracimVarHostesAriyorum getAdAracimVarHostesAriyorum() {return adAracimVarHostesAriyorum; }
    public void setAdAracimVarHostesAriyorum(Ad_AracimVarHostesAriyorum adAracimVarHostesAriyorum) { this.adAracimVarHostesAriyorum = adAracimVarHostesAriyorum; }
    public Ad_AracimVarIsAriyorum getAdAracimVarIsAriyorum() {return adAracimVarIsAriyorum; }
    public void setAdAracimVarIsAriyorum(Ad_AracimVarIsAriyorum adAracimVarIsAriyorum) {this.adAracimVarIsAriyorum = adAracimVarIsAriyorum; }
    public Vehicle getAdAracimVarIsAriyorum_vehicle() {return adAracimVarIsAriyorum_vehicle;}
    public void setAdAracimVarIsAriyorum_vehicle(Vehicle adAracimVarIsAriyorum_vehicle) { this.adAracimVarIsAriyorum_vehicle = adAracimVarIsAriyorum_vehicle;} 
    public Ad_PlakamiSatiyorum getAdPlakamiSatiyorum() {return adPlakamiSatiyorum;}
    public void setAdPlakamiSatiyorum(Ad_PlakamiSatiyorum adPlakamiSatiyorum) { this.adPlakamiSatiyorum = adPlakamiSatiyorum;}
    public Ad_HostesimİsAriyorum_Bean getAdHostesimIsAriyorumBean() {return adHostesimIsAriyorumBean;}
    public void setAdHostesimIsAriyorumBean(Ad_HostesimİsAriyorum_Bean adHostesimIsAriyorumBean) {this.adHostesimIsAriyorumBean = adHostesimIsAriyorumBean; }
    public Ad_SoforumİsAriyorum_Bean getAdSoforumIsAriyorumBean() {return adSoforumIsAriyorumBean; }
    public void setAdSoforumIsAriyorumBean(Ad_SoforumİsAriyorum_Bean adSoforumIsAriyorumBean) {this.adSoforumIsAriyorumBean = adSoforumIsAriyorumBean;}
    public AdRouteBean getAdrb() { return adrb;}
    public int getAdSize_ToDay_ForUser() {return adSize_ToDay_ForUser;}
    public void setAdSize_ToDay_ForUser(int adSize_ToDay_ForUser) {this.adSize_ToDay_ForUser = adSize_ToDay_ForUser;}
    public int getAdSize_All_ForUser() { return adSize_All_ForUser;}
    public void setAdSize_All_ForUser(int adSize_All_ForUser) { this.adSize_All_ForUser = adSize_All_ForUser;}
    public String getAdSortType() { return adSortType;  }
    public void setAdSortType(String adSortType) { this.adSortType = adSortType;  }
    public String getFilterCategory() { return filterCategory; }
    public void setFilterCategory(String filterCategory) {  this.filterCategory = filterCategory;}
    public boolean getFilterCategory_IsimVarAracAriyorum() {return filterCategory_IsimVarAracAriyorum; }
    public void setFilterCategory_IsimVarAracAriyorum(boolean filterCategory_IsimVarAracAriyorum) { this.filterCategory_IsimVarAracAriyorum = filterCategory_IsimVarAracAriyorum;}
    public boolean getFilterCategory_AracimVarIsAriyorum() { return filterCategory_AracimVarIsAriyorum;}
    public void setFilterCategory_AracimVarIsAriyorum(boolean filterCategory_AracimVarIsAriyorum) { this.filterCategory_AracimVarIsAriyorum = filterCategory_AracimVarIsAriyorum;}
    public boolean getFilterCategory_AracimVarSoforAriyorum() { return filterCategory_AracimVarSoforAriyorum;}
    public void setFilterCategory_AracimVarSoforAriyorum(boolean filterCategory_AracimVarSoforAriyorum) { this.filterCategory_AracimVarSoforAriyorum = filterCategory_AracimVarSoforAriyorum;}
    public boolean getFilterCategory_AracimVarHostesAriyorum() {return filterCategory_AracimVarHostesAriyorum;}
    public void setFilterCategory_AracimVarHostesAriyorum(boolean filterCategory_AracimVarHostesAriyorum) { this.filterCategory_AracimVarHostesAriyorum = filterCategory_AracimVarHostesAriyorum;}
    public boolean getFilterCategory_HostesimIsAriyorum() { return filterCategory_HostesimIsAriyorum;}
    public void setFilterCategory_HostesimIsAriyorum(boolean filterCategory_HostesimIsAriyorum) { this.filterCategory_HostesimIsAriyorum = filterCategory_HostesimIsAriyorum;}
    public boolean getFilterCategory_SoforumIsAriyorum() { return filterCategory_SoforumIsAriyorum;}
    public void setFilterCategory_SoforumIsAriyorum(boolean filterCategory_SoforumIsAriyorum) { this.filterCategory_SoforumIsAriyorum = filterCategory_SoforumIsAriyorum;}
    public boolean isFilterCategory_PlakamiSatiyorum() { return filterCategory_PlakamiSatiyorum;   }
    public void setFilterCategory_PlakamiSatiyorum(boolean filterCategory_PlakamiSatiyorum) { this.filterCategory_PlakamiSatiyorum = filterCategory_PlakamiSatiyorum;  }
    public String getLastTime() {return lastTime;}
    public void setLastTime(String lastTime) { this.lastTime = lastTime;}
    public String getCompany() {return company;}
    public void setCompany(String company) { this.company = company;}
    public String[] getSelected_ServiceTypes() {return selected_ServiceTypes;}
    public void setSelected_ServiceTypes(String[] selected_ServiceTypes) { this.selected_ServiceTypes = selected_ServiceTypes;}
    public int getSelected_cityPlateNo() {return selected_cityPlateNo;}
    public void setSelected_cityPlateNo(int selected_cityPlateNo) {this.selected_cityPlateNo = selected_cityPlateNo;}
    public String getVehicle_Brand() { return vehicle_Brand;}
    public void setVehicle_Brand(String vehicle_Brand) { this.vehicle_Brand = vehicle_Brand;}
    public String getVehicle_Model() { return vehicle_Model;}
    public void setVehicle_Model(String vehicle_Model) {this.vehicle_Model = vehicle_Model;}
    public String getVehicle_ModelYear() {return vehicle_ModelYear;}
    public void setVehicle_ModelYear(String vehicle_ModelYear) {this.vehicle_ModelYear = vehicle_ModelYear;}
    public boolean isVehicle_ModelYearAndOver() { return Vehicle_ModelYearAndOver;}
    public void setVehicle_ModelYearAndOver(boolean Vehicle_ModelYearAndOver) { this.Vehicle_ModelYearAndOver = Vehicle_ModelYearAndOver;}
    public int getVehicleBrandId() { return VehicleBrandId;}
    public void setVehicleBrandId(int VehicleBrandId) { this.VehicleBrandId = VehicleBrandId;}
    public List<String> getVehicleModelsList() { return vehicleModelsList;}
    public void setVehicleModelsList(List<String> vehicleModelsList) { this.vehicleModelsList = vehicleModelsList;}
    public String getStartPoint_geo_STREET_NUMBER_KAPINO() { return startPoint_geo_STREET_NUMBER_KAPINO;}
    public void setStartPoint_geo_STREET_NUMBER_KAPINO(String startPoint_geo_STREET_NUMBER_KAPINO) { this.startPoint_geo_STREET_NUMBER_KAPINO = startPoint_geo_STREET_NUMBER_KAPINO;}
    public String getStartPoint_geo_ROUTE_SOKAK() { return startPoint_geo_ROUTE_SOKAK;}
    public void setStartPoint_geo_ROUTE_SOKAK(String startPoint_geo_ROUTE_SOKAK) { this.startPoint_geo_ROUTE_SOKAK = startPoint_geo_ROUTE_SOKAK;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) { this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) {  this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) { this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL() { return startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setStartPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) { this.startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = startPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getStartPoint_geo_COUNTRY() { return startPoint_geo_COUNTRY;}
    public void setStartPoint_geo_COUNTRY(String startPoint_geo_COUNTRY) { this.startPoint_geo_COUNTRY = startPoint_geo_COUNTRY;}
    public String getStartPoint_geo_POSTAL_CODE() {  return startPoint_geo_POSTAL_CODE;}
    public void setStartPoint_geo_POSTAL_CODE(String startPoint_geo_POSTAL_CODE) { this.startPoint_geo_POSTAL_CODE = startPoint_geo_POSTAL_CODE;}
    public double getStartPoint_geo_latitude() {  return startPoint_geo_latitude;}
    public void setStartPoint_geo_latitude(double startPoint_geo_latitude) {  this.startPoint_geo_latitude = startPoint_geo_latitude;}
    public double getStartPoint_geo_longitude() { return startPoint_geo_longitude;}
    public void setStartPoint_geo_longitude(double startPoint_geo_longitude) {  this.startPoint_geo_longitude = startPoint_geo_longitude;}
    public String getStartPoint_geo_FORMATED_ADDRESS() {  return startPoint_geo_FORMATED_ADDRESS;}
    public void setStartPoint_geo_FORMATED_ADDRESS(String startPoint_geo_FORMATED_ADDRESS) { this.startPoint_geo_FORMATED_ADDRESS = startPoint_geo_FORMATED_ADDRESS;}
    public String getStartTime() { return startTime;}
    public void setStartTime(String startTime) { this.startTime = startTime;}
    public String getStartFrmAdd() { return startFrmAdd;}
    public void setStartFrmAdd(String startFrmAdd) { this.startFrmAdd = startFrmAdd;}
    public String getEndPoint_geo_STREET_NUMBER_KAPINO() { return endPoint_geo_STREET_NUMBER_KAPINO;}
    public void setEndPoint_geo_STREET_NUMBER_KAPINO(String endPoint_geo_STREET_NUMBER_KAPINO) { this.endPoint_geo_STREET_NUMBER_KAPINO = endPoint_geo_STREET_NUMBER_KAPINO;}
    public String getEndPoint_geo_ROUTE_SOKAK() { return endPoint_geo_ROUTE_SOKAK;}
    public void setEndPoint_geo_ROUTE_SOKAK(String endPoint_geo_ROUTE_SOKAK) { this.endPoint_geo_ROUTE_SOKAK = endPoint_geo_ROUTE_SOKAK;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE() { return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE) { this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_4_MAHALLE;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY() { return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY) { this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_3_KOY;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE() {return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE) { this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_2_ILCE;}
    public String getEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL() { return endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public void setEndPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL(String endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL) {this.endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL = endPoint_geo_ADMINISTRATIVE_AREA_LEVEL_1_IL;}
    public String getEndPoint_geo_COUNTRY() { return endPoint_geo_COUNTRY;}
    public void setEndPoint_geo_COUNTRY(String endPoint_geo_COUNTRY) { this.endPoint_geo_COUNTRY = endPoint_geo_COUNTRY;}
    public String getEndPoint_geo_POSTAL_CODE() { return endPoint_geo_POSTAL_CODE;}
    public void setEndPoint_geo_POSTAL_CODE(String endPoint_geo_POSTAL_CODE) {this.endPoint_geo_POSTAL_CODE = endPoint_geo_POSTAL_CODE;}
    public double getEndPoint_geo_latitude() {return endPoint_geo_latitude;}
    public void setEndPoint_geo_latitude(double endPoint_geo_latitude) { this.endPoint_geo_latitude = endPoint_geo_latitude;}
    public double getEndPoint_geo_longitude() { return endPoint_geo_longitude;}
    public void setEndPoint_geo_longitude(double endPoint_geo_longitude) { this.endPoint_geo_longitude = endPoint_geo_longitude;}
    public String getEndPoint_geo_FORMATED_ADDRESS() { return endPoint_geo_FORMATED_ADDRESS;}
    public void setEndPoint_geo_FORMATED_ADDRESS(String endPoint_geo_FORMATED_ADDRESS) {  this.endPoint_geo_FORMATED_ADDRESS = endPoint_geo_FORMATED_ADDRESS;}
    public String getEndTime() { return endTime;}
    public void setEndTime(String endTime) { this.endTime = endTime;}
    public String getEndFrmAdd() { return endFrmAdd;}
    public void setEndFrmAdd(String endFrmAdd) { this.endFrmAdd = endFrmAdd;}
    public Map<String, Boolean> getCheckMap() {return checkMap; }
    public void setCheckMap(Map<String, Boolean> checkMap) { this.checkMap = checkMap; }
    public int getToplamKullaniciSayisi() { return toplamKullaniciSayisi;}
    public void setToplamKullaniciSayisi(int toplamKullaniciSayisi) { this.toplamKullaniciSayisi = toplamKullaniciSayisi;}
    public int getIlanId_old() {return ilanId_old;}
    public void setIlanId_old(int ilanId_old) { this.ilanId_old = ilanId_old;}
    public boolean isLeftSidebarShow() {return leftSidebarShow;  }
    public void setLeftSidebarShow(boolean leftSidebarShow) { this.leftSidebarShow = leftSidebarShow;   }
    @Overridepublic String toString (){ return "Ad_Bean{"   + "ad_Id=" + ad_Id 
                            + ", ad_Category_Id=" + ad_Category_Id 
                            + ", ad_Category_Name=" + ad_Category_Name 
                            + ", ad_Title=" + ad_Title 
                            + ", ad_Comment=" + ad_Comment 
                            + ", ad_CommentFormated=" + ad_CommentFormated 
                            + ", ad_Type=" + ad_Type 
                            + ", ad_OvnerAccountId=" + ad_OvnerAccountId 
                            + ", ad_IsActive=" + ad_IsActive 
                            + ", ad_EndTime=" + ad_EndTime 
                            + ", ad_Notes=" + ad_Notes 
                            + ", ad_CreateTime=" + ad_CreateTime 
                            + ", ad_CreatedIp=" + ad_CreatedIp 
                            + ", ad_CreatedAccountId=" + ad_CreatedAccountId 
                            + ", ad_LastModifyIp=" + ad_LastModifyIp 
                            + ", ad_LastModifyTime=" + ad_LastModifyTime 
                            + ", ad_LastChangerAccountId=" + ad_LastChangerAccountId 
                            + ", ad_IsPublish=" + ad_IsPublish 
                            + ", ad_UserEnableDisable=" + ad_UserEnableDisable 
                            + ", vehicleBean=" + vehicleBean 
                            + ", ad_PublishDate=" + ad_PublishDate + '}';
        
    }
    public void getAllAd() {    this.adList = adSearchBean.findAd("All");   
        if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
        if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
        if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
        if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
        if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek5", "reklam"));}
        paginator = new RepeatPaginator(this.adList); 
        paginatorForMobile = new RepeatPaginatorForMobile(this.adList);  } public void filterGetAllAd (){   this.adList = adSearchBean.findAd("DetailedSearch");
        if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
        if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
        if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
        if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
        if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek5", "reklam"));}
      paginator = new RepeatPaginator(this.adList); 
        paginatorForMobile = new RepeatPaginatorForMobile(this.adList);  this.leftSidebarShow = true;
    } public void leftSidebarShowHide(){    
        if(this.leftSidebarShow){this.leftSidebarShow = false;}
        else{this.leftSidebarShow = true;}
    
    }  public void clearFilter (){
        this.adSearchBean.clearadSearchInputEntity();
        this.adList.clear();
        getAllAd();      } public void getAllAdWithOvnerAccountId (String OvnerAccountId){     
        Ad_Dao ad = new Ad_Dao();
        this.adList2 = ad.getAllAdWithOvnerAccountId(OvnerAccountId);
        this.myAdsList = ad.getAllAdWithOvnerAccountId(OvnerAccountId);      
    }public AccountBean getAccount(String AccountId) {
 AccountBean acb = new AccountBean();
        acb.setAccount_Id(AccountId);   
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(acb);      
        AccountDao ado = new AccountDao();      
        return ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean();
    }  public CorporateAccountBean getCorporateAccount(String CompanyId) {
 CorporateAccountDao cod = new CorporateAccountDao();
        return cod.getOneCorporateAccountWithId(CompanyId); } public List<AdRouteBean> allAdRouteList(String AdId) {
        AdRouteDao a = new AdRouteDao();
        return a.getAllAdRouteWithAdId(AdId);
    } public void getAllNotPublishedAd() { Ad_Dao ad = new Ad_Dao();
        this.notPublishAdList = ad.getAllAdWithNotPublish(); } public void getAllPublishedAd() { 
        Ad_Dao ad = new Ad_Dao();
        this.PublishAdList = ad.getAllAdWithPublish(); }  public void getUserPublishedAd(String ovnerId) {   Ad_Dao ad = new Ad_Dao();
        this.userPublishAdList = ad.getUserAllAd(ovnerId); }  public void adConfirmAndPublish(String adId) {
        int sonuc = 0;  
        Ad_Dao a = new Ad_Dao();
        sonuc = a.publishAd(adId);  
        if(sonuc == 1){  int sonuc2 = 0;
            Ad_Dao add = new Ad_Dao();
            sonuc2 = add.addPublishDate(adId); if(sonuc2 == 1){           
                getAllNotPublishedAd();
                getAllPublishedAd();} else{System.out.println(":::ILAN ONAYLANMADI:::");}} public void adAdminNotes() { 
        
        int sonuc = 0;  Ad_Dao a = new Ad_Dao();
        sonuc = a.addAdminNotes(this.ad_Notes,  this.selectedAdId); if(sonuc == 1){ FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Notunuz başarıyla eklendi");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage("dgfrd654re", facesMessage);
            facesContext.renderResponse();  this.selectedAdId = null;  getAllNotPublishedAd();
            getAllPublishedAd();
            getUserPublishedAd(this.aIdx);  }  } public void selectedAdIdSet(String adId){  this.selectedAdId= adId; } public void handleCloseSector(CloseEvent event) {

        this.ad_Notes = null;
        this.selectedAdId = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage();
        facesContext.renderResponse();
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("dfwer3wq:fdyt45e");
        
    } public void disableAd(String adId) {  int sonuc = 0;  Ad_Dao a = new Ad_Dao(); sonuc = a.disableAd(adId);
        
        if(sonuc == 1){
            
            getAllNotPublishedAd();
            getAllPublishedAd();
            getUserPublishedAd(this.aIdx);
           
            getAllAdWithOvnerAccountId (SessionUtil.getUserId());
                    paginator2 = new RepeatPaginator(this.adList2); 
        } } public void disableAd() { 
    
        int sonuc = 0;
        
        Ad_Dao a = new Ad_Dao();
        sonuc = a.disableAd(this.selectedAdId);
        
        if(sonuc == 1){
            getAllNotPublishedAd();
            getAllPublishedAd();
            getUserPublishedAd(this.aIdx);
           
            getAllAdWithOvnerAccountId (SessionUtil.getUserId());
            paginator2 = new RepeatPaginator(this.adList2); 
            
            Messages.dynMsg(null, "info", "İlanınız başarılı bir şekilde silinmiştir");
        }
        else{ Messages.dynMsg(null, "error", "İlanı silme sırasında sorun oluştu");}
    }  public void enableAd(String adId) {  int sonuc = 0;  Ad_Dao a = new Ad_Dao();
        sonuc = a.enableAd(adId);  if(sonuc == 1){ getAllNotPublishedAd();
            getAllPublishedAd();
            getUserPublishedAd(this.aIdx);   }  } public void disableSelectedAds() {
        for (Entry<String,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) { disableAd(entry.getKey()); }     }  checkMap = new HashMap<String,Boolean>();  } public void disableSelectedAds2(){
        int sonuc = 0;       
        for (Entry<String,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                Ad_Dao a = new Ad_Dao();
                sonuc=a.enableDisableAdFromUser(entry.getKey(), "disable");
            }
        } getAllNotPublishedAd();  getAllPublishedAd();  getUserPublishedAd(this.aIdx);
        getAllAdWithOvnerAccountId (SessionUtil.getUserId());
        paginator2 = new RepeatPaginator(this.adList2);  checkMap = new HashMap<String,Boolean>();
    } public List<VehicleBrandAndModelBean> vehicleBrandNamesListx() { VehicleBrandAndModelDao v = new VehicleBrandAndModelDao();  return v.getAllVehicleBrand();  }
 public List<String> vehicleCapasityNamesListx() {   Ad_Search_Dao asd = new Ad_Search_Dao();
        return asd.getAdSearch_DetailedSearch_AracKApasiteleri(this.adSearchBean.getAdSearchInputEntity().getFltr_Ad_CategoryId());  } public void vehicleModelsListx() {     
        this.vehicleModelsList = new ArrayList<String>();  if(this.adSearchBean.getAdSearchInputEntity().getFltr_Vehicle_BrandIds().length ==1){
         VehicleBrandAndModelDao v = new VehicleBrandAndModelDao();
            List<String> lst =Arrays.asList(this.adSearchBean.getAdSearchInputEntity().getFltr_Vehicle_BrandIds());
            this.vehicleModelsList = v.getAllVehicleModels(Integer.parseInt(lst.get(0)));
        } } public void enableDisableAdFromUser(String adId, String comment){  int sonuc = 0;
   Ad_Dao a = new Ad_Dao();sonuc = a.enableDisableAdFromUser(adId, comment); if(sonuc == 1){ 
            getAllAdWithOvnerAccountId (SessionUtil.getUserId());         
            if(comment.equals("enable")){ Messages.dynMsg(null, "info", "İlanınız yayına açılmıştır"); }
            if(comment.equals("disable")){ Messages.dynMsg(null, "info", "İlanınız yayından kaldırılmıştır"); }          
        } else {System.out.println("yoookk");}  } public void fastEditAd(){  int Sonuc = 0;
        Ad_Dao add = new Ad_Dao();   Sonuc = add.fastUpdateAd(this.selectedAd); if(Sonuc == 1){
            this.notPublishAdList.clear(); getAllNotPublishedAd(); Messages.dynMsg(null, "info", "İlan güncellendi.");    }
        else{Messages.dynMsg(null, "error", "İlan güncelleme sırasında sorun oluştu"); }  }  public List<String> startPositionCityList() {
  ArrayList<String> TownList = new ArrayList();  Ad_Dao ad = new Ad_Dao(); return TownList = ad.getAdRouteStartPositionCityList(getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId());   }
 public List<String> endPositionCityList() { ArrayList<String> TownList = new ArrayList();  Ad_Dao ad = new Ad_Dao();
        return TownList = ad.getAdRouteEndPositionCityList(getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId());   }     
    public List<String> startPositionTownList() {String[] aa = null; Ad_Dao ad = new Ad_Dao();    
        if(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_City() != null &&  getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_City().length >0    ){
         List t = Arrays.asList(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_City());
 if(t.contains("İSTANBUL")){  CityList = ad.getAdRouteStartPositionTownList(  getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),   getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_City()  ); 
                        CityList.add(0, "ANADOLU YAKASI"); CityList.add(0, "AVRUPA YAKASI");  } else{   CityList = ad.getAdRouteStartPositionTownList(  getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(), 
                                                                    getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_City()  ); 

                }

        } else{CityList = ad.getAdRouteStartPositionTownList(getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(), aa); 
        } return CityList;  } public List<String> endPositionTownList() { 
        ArrayList<String> TownList = new ArrayList();
        Ad_Dao ad = new Ad_Dao();
        String[] aa = null;
     if(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_Town() != null && getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_Town().length >0){ 
      List t = Arrays.asList(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City());
     if(t.contains("İSTANBUL")){
      TownList = ad.getAdRouteEndPositionTownList(    getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),   getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_Town(), getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City());
                TownList.add(0, "ANADOLU YAKASI"); TownList.add(0, "AVRUPA YAKASI");
                
            } else{ TownList = ad.getAdRouteEndPositionTownList(    getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),  getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_StartPosition_Town(),  getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City());
            } } else{ if(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City() != null &&  getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City().length >0    ){
         List t = Arrays.asList(getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City());if(t.contains("İSTANBUL")){
  TownList = ad.getAdRouteEndPositionTownList(    getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),    aa,    getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City());
                    TownList.add(0, "ANADOLU YAKASI");  TownList.add(0, "AVRUPA YAKASI");  }
                else{  TownList = ad.getAdRouteEndPositionTownList(    getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),   aa,     getAdSearchBean().getAdSearchInputEntity().getFltr_AdRoute_EndPosition_City()); 
                } } else{ TownList = ad.getAdRouteEndPositionTownList(    getAdSearchBean().getAdSearchInputEntity().getFltr_Ad_CategoryId(),    aa,   aa);  }  }     return TownList;   }

    public void catFilterListener(){       }public List<Ad_Bean> dublicatedAds(int categoryId,  String adOvnerAccountId, String startCity, String startTown, String endCity, String endTown){
        List<Ad_Bean> dublicatedAdList = new ArrayList<Ad_Bean>(); 
        Ad_Dao add = new Ad_Dao();  
        if(categoryId == 1){ dublicatedAdList = add.getDublicatedAd( true, false,false, false, false, false, false,   "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        }
        else if(categoryId == 2){ dublicatedAdList = add.getDublicatedAd( false, true,false, false, false, false, false, "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        }
        else if(categoryId == 3){ dublicatedAdList = add.getDublicatedAd( false, false,true, false, false, false, false,  "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        }
        else if(categoryId == 4){ dublicatedAdList = add.getDublicatedAd( false, false,false, true, false, false, false, "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        }  
        else if(categoryId == 5){ dublicatedAdList = add.getDublicatedAd( false, false,false, false, true, false, false,  "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        } 
        else if(categoryId == 6){ dublicatedAdList = add.getDublicatedAd( false, false,false, false, false, true, false,  "last7Days","farketmez","farketmez","farketmez","farketmez",false,
                                                startCity,startTown,"",endCity,endTown,"","DESC","",adOvnerAccountId);
        }  return dublicatedAdList;
    }  public List<Ad_Bean> dublicatedAds_PlakamiSatiyorum(int PlateProvinceCode,  String PlateLatterCode, int PlateNumberCode, String adOvnerAccountId){
        List<Ad_Bean> dublicatedAdList = new ArrayList<Ad_Bean>();        
        Ad_Dao add = new Ad_Dao();
        dublicatedAdList = add.getDublicatedAdPlate(PlateProvinceCode, PlateLatterCode, PlateNumberCode, adOvnerAccountId);
     
        return dublicatedAdList;  } public void secilenIlanlariUsteTasi(){
        int sonuc = 0; int MovedUpLimit = 5;  Ad_Dao add = new Ad_Dao(); for (Entry<String,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                System.out.println("ID::"+entry.getKey());
                
                int ilanKacDefaYukariTasinmis = 0;
                ilanKacDefaYukariTasinmis = add.adHowManyTimesMovedUp(entry.getKey(), add.getAdDetailWithId(entry.getKey()).getAd_OvnerAccountId());
             
                if(ilanKacDefaYukariTasinmis < MovedUpLimit){ 
                    
                    if(ilanKacDefaYukariTasinmis ==0){
                        int snc1 = 0;
                        snc1 = add.createAdMoveUp( UniqueId.RandomString(9)+UniqueId.RandomString(9)+ilanKacDefaYukariTasinmis+1, 
                                                            ilanKacDefaYukariTasinmis+1, 
                                                        entry.getKey(), 
                                                            add.getAdDetailWithId(entry.getKey()).getAd_OvnerAccountId()
                                                  );
                        if(snc1==1){ 
                            int snc11 = 0;
                            snc11 = add.updateAdPublishDate(entry.getKey());
                            if(snc11==1){Messages.dynMsg(null, "info", "İlanınız listelemede ust siraya cikarilmistir."); }
                            else{Messages.dynMsg(null, "error", "İlanınızı listelemede ust siraya cikarma sırasında bir sorun oluştu"); }   
                        }
                        else{Messages.dynMsg(null, "error", "İlanınızı listelemede ust siraya cikarma sırasında bir sorun oluştu"); }                  
                    }
                    
                    else{ 
                        int snc2 = 0;
                        snc2 = add.updateAdMoveUp(  add.getAdMoveUpId(entry.getKey(), add.getAdDetailWithId(entry.getKey()).getAd_OvnerAccountId()), 
                                                             ilanKacDefaYukariTasinmis+1
                                                 );
                        if(snc2==1){ 
                            int snc22 = 0;
                            snc22 = add.updateAdPublishDate(entry.getKey());
                            if(snc22==1){Messages.dynMsg(null, "info", "İlanınız listelemede ust siraya cikarilmistir."); }
                            else{Messages.dynMsg(null, "error", "İlanınızı listelemede ust siraya cikarma sırasında bir sorun oluştu"); } 
                        }
                        else{Messages.dynMsg(null, "error", "İlanınızı listelemede ust siraya cikarma sırasında bir sorun oluştu"); } 
                    }          
                }
                else {Messages.dynMsg(null, "warn", "Bu ilanı listelemede üst sıraya çıkarma limitini doldurdunuz"); }
                
            }
        }
        
                    
        checkMap = new HashMap<String,Boolean>();
        
    }public void filterGetAllAdWithVehicleBrandAndCapacity(String param, String value){ 
        Ad_Dao ad = new Ad_Dao();
        VehicleBrandAndModelDao vd = new VehicleBrandAndModelDao();
        
        if(param.equals("brand")){
            this.adList = ad.getAllAdWithVehicleBrandAndCapacity("brand", String.valueOf(vd.getVehicleBrandWithName(value).getVehicleBrand_Id()));
        } else if(param.equals("capasity")){
            this.adList = ad.getAllAdWithVehicleBrandAndCapacity("capacity", value);
        }  paginator = new RepeatPaginator(this.adList); 
    }public void sortAdList (){        
        
        if(this.adList != null){
            if(this.adList.size() >0){
                
                if(this.adList.size()>5){this.adList.remove(5);}
                if(this.adList.size()>11){this.adList.remove(10);}
                if(this.adList.size()>17){this.adList.remove(15);}
                if(this.adList.size()>23){this.adList.remove(20);}
                if(this.adList.size()>29){this.adList.remove(25);}
                if(this.adSortType.equals("DESC")){
                  this.adList.sort(Comparator.comparing(Ad_Bean::getAd_PublishDate).reversed());
                    if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
                    if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
                    if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
                    if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
                    if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek4", "reklam"));}
 paginator = new RepeatPaginator(this.adList); 
                }else if(this.adSortType.equals("ASC")){ this.adList.sort(Comparator.comparing(Ad_Bean::getAd_PublishDate));
                    if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
                    if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
                    if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
                    if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
                    if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek4", "reklam"));}
 paginator = new RepeatPaginator(this.adList); 
                }  else{ this.adList.sort(Comparator.comparing(Ad_Bean::getAd_PublishDate).reversed());
                    if(this.adList.size()>5){this.adList.add(5, new Ad_Bean("rek1", "reklam"));}
                    if(this.adList.size()>11){this.adList.add(11, new Ad_Bean("rek2", "reklam"));}
                    if(this.adList.size()>17){this.adList.add(17, new Ad_Bean("rek3", "reklam"));}
                    if(this.adList.size()>23){this.adList.add(23, new Ad_Bean("rek4", "reklam"));}
                    if(this.adList.size()>29){this.adList.add(29, new Ad_Bean("rek4", "reklam"));}
                      paginator = new RepeatPaginator(this.adList);
                }  }  }  }
    

}
