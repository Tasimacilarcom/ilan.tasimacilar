package com.tasimacilar.ilan.ad.search;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.aracimVarHostesAriyorum.Ad_AracimVarHostesAriyorum;
import com.tasimacilar.ilan.ad.aracimVarIsAriyorum.Ad_AracimVarIsAriyorum;
import com.tasimacilar.ilan.ad.aracimVarSoforAriyorum.Ad_AracimVarSoforAriyorum;
import com.tasimacilar.ilan.ad.hostesimİsAriyorum.Ad_HostesimİsAriyorum_Bean;
import com.tasimacilar.ilan.ad.isimvarAracAriyorum.Ad_IsimVarAracAriyorum;
import com.tasimacilar.ilan.ad.plakamiSatiyorum.Ad_PlakamiSatiyorum;
import com.tasimacilar.ilan.ad.soforumİsAriyorum.Ad_SoforumİsAriyorum_Bean;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.Vehicle;
import com.tasimacilar.ilan.vehicle.VehicleBrandAndModelDao;
import com.tasimacilar.ilan.vehicle.VehicleImages;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jsoup.Jsoup;
public class Ad_Search_Dao implements Serializable{ public List<Ad_Bean> getAdSearch_DetailedSearch_IsimVarAracAriyorum(Ad_Search_InputEntity adSearchInputEntity) {
int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;  PreparedStatement ps = null; con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());
                     
                        
                        if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");} 
                        ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());
                        if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }
                        else{ps.setString(16, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }
                        else{ps.setString(17, "Farketmez");}
                        ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + ',' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }
                        else{ps.setString(20, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }
                        else{ps.setString(21, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }
                        else{ps.setString(22, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }
                        else{ps.setString(23, "FarkEtmez");}
                        ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() );
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());                       
                        if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }
                        else{ps.setString(28, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }
                        else{ps.setString(29, "FarkEtmez");}                    
                        if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }
                        else{ps.setString(30, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }
                        else{ps.setString(31, "FarkEtmez");}
                        ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());
                        if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }
                        else{ps.setString(34, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }
                        else{ps.setString(35, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }
                        else{ps.setString(36, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }
                        else{ps.setString(37, "FarkEtmez");}  
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) { Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type")); ab.setAccountBean(abx); CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));  ab.setCorporateAccountBean(cb); Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));    
                                            ab.setAdIsimVarAracAriyorum(iar); Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType"));if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand")!=null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){
                                                    String[] vbs = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = ""; 
                                                        for (String x : vbs) {
                                                            if(x != null){
                                                                if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                }else{vbx=", 0";}  }  }
                                                    vbx = vbx.substring(1);                                           
                                                    vcxx.setVehicle_Brand(vbx);
                                                }    
                                            }
                                            else{vcxx.setVehicle_Brand("");} vcxx.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vcxx.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("Ad_LookingForVehicleForWork_VehicleYear"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx); adList.add(ab); }   } 
                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList;  }  public List<Ad_Bean> getAdSearch_DetailedSearch_AracimVarIsAriyorum(Ad_Search_InputEntity adSearchInputEntity) {
        
        int sonuc = 0;   List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}    
        else{   try {  ps = con.prepareCall("{call pro_ad_Find_Cat2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");    ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());
                      if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");}
                        ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());
                         if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }
                        else{ps.setString(16, "FarkEtmez");}
                         if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");}  ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver()); if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + ',' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        } else{ps.setString(20, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }  else{ps.setString(21, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }  else{ps.setString(22, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }  else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());   if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }  else{ps.setString(28, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }   else{ps.setString(29, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }   else{ps.setString(30, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }   else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }  else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        } else{ps.setString(37, "FarkEtmez");}  ResultSet rs = ps.executeQuery(); while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));  ab.setAccountBean(abx);  CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));   ab.setCorporateAccountBean(cb);  Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id")); aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);                                       
                                      
                                            adList.add(ab);
                                            
                                           }  
            
                    } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList;  } public List<Ad_Bean> getAdSearch_DetailedSearch_AracimVarSoforAriyorum(Ad_Search_InputEntity adSearchInputEntity) {    
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat3(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment()); if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        } else{ps.setString(6, "FarkEtmez");} ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());  if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        } else{ps.setString(16, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }   else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());  if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + ',' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }  else{ps.setString(20, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }   else{ps.setString(21, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }   else{ps.setString(22, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }   else{ps.setString(23, "FarkEtmez");} ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() );
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        } else{ps.setString(28, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }  else{ps.setString(30, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }   else{ps.setString(31, "FarkEtmez");} ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }   else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }  else{ps.setString(35, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery();  while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));  ab.setAccountBean(abx);  CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));  ab.setCorporateAccountBean(cb); Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Id(rs.getString("Ad_AracimVarSoforAriyorum_Id"));
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("Ad_AracimVarSoforAriyorum_Cost"));    
                                            asax.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("Ad_AracimVarSoforAriyorum_ServiceTime"));                
                                            asax.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("Ad_AracimVarSoforAriyorum_NumberOfPassengers"));    
                                            asax.setAd_AracimVarSoforAriyorum_Km(rs.getString("Ad_AracimVarSoforAriyorum_Km"));                        
                                            asax.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("Ad_AracimVarSoforAriyorum_DayToWork"));                    
                                            asax.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("Ad_AracimVarSoforAriyorum_PaymentMethod"));               
                                            asax.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("fast_vehicle_ServiceTypes"));                    
                                            ab.setAd_AracimVarSoforAriyorum(asax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id")); aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarSoforAriyorum_vehicle(aiaxx);  adList.add(ab); }    } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList;    } public List<Ad_Bean> getAdSearch_DetailedSearch_AracimVarHostesAriyorum(Ad_Search_InputEntity adSearchInputEntity) {
        
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat4(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());  if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        } else{ps.setString(6, "FarkEtmez");} ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode()); if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }   else{ps.setString(16, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());  if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        } else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }  else{ps.setString(21, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }  else{ps.setString(22, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }  else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() );
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        } else{ps.setString(28, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        } else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }  else{ps.setString(30, "FarkEtmez");}if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }  else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        } else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        } else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery(); while (rs.next()) {  Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate"));AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type")); ab.setAccountBean(abx);  CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl")); ab.setCorporateAccountBean(cb); Ad_AracimVarHostesAriyorum ahax = new Ad_AracimVarHostesAriyorum();
                                            ahax.setAd_AracimVarHostesAriyorum_Id(rs.getString("Ad_AracimVarHostesAriyorum_Id"));                                 
                                            ahax.setAd_AracimVarHostesAriyorum_Cost(rs.getFloat("Ad_AracimVarHostesAriyorum_Cost"));                           
                                            ahax.setAd_AracimVarHostesAriyorum_school(rs.getString("Ad_AracimVarHostesAriyorum_School"));                      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_kindergarten"));       
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_primarySchool"));      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_highSchool(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_highSchool"));       
                                            ab.setAdAracimVarHostesAriyorum(ahax);         adList.add(ab);  }   }  catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList;} public List<Ad_Bean> getAdSearch_DetailedSearch_HostesimIsAriyorum(Ad_Search_InputEntity adSearchInputEntity) {       
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;   PreparedStatement ps = null;   con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat5(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment()); if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");}
                        ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());
                        if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }
                        else{ps.setString(16, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");}   ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());   if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }  else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }  else{ps.setString(21, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }   else{ps.setString(22, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }  else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }   else{ps.setString(28, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }   else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        } else{ps.setString(30, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }   else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }  else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        } else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery(); while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));  ab.setAccountBean(abx);  CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl")); ab.setCorporateAccountBean(cb); Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("Ad_HostesimIsAriyorum_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("hostess_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("hostess_BirthDate"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth"));if(rs.getDate("hostess_BirthDate") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("hostess_BirthDate"));
                                                int year = cal.get(Calendar.YEAR);
                                                 Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);
                                                 if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            }
                                            else{hostess.setHostess_yasi(0);}
                                            hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);                                
                                       adList.add(ab); }    } 
  catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList;  } public List<Ad_Bean> getAdSearch_DetailedSearch_SoforumIsAriyorum(Ad_Search_InputEntity adSearchInputEntity) { int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();  Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat6(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());
                     
                        
                        if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");}
                         ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());
                         if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }else{ps.setString(16, "FarkEtmez");}
                         if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        } else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                         if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        } else{ps.setString(20, "FarkEtmez");}
                         if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        } else{ps.setString(21, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }  else{ps.setString(22, "FarkEtmez");}if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }  else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }else{ps.setString(28, "FarkEtmez");}if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }   else{ps.setString(29, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }  else{ps.setString(30, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }   else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());   if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }   else{ps.setString(34, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }  else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery();  while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));  ab.setAccountBean(abx); CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));  ab.setCorporateAccountBean(cb);  Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("driver_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("driver_BirthDate"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));                
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));     if(rs.getDate("driver_BirthDate") != null){  Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("driver_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR); if(year2-year >= 18){ drv.setDriver_yasi(year2-year); 
                                                }  else{drv.setDriver_yasi(0);} }  else{drv.setDriver_yasi(0);}  sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);    adList.add(ab);  }   } 
                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        } return adList; } public List<Ad_Bean> getAdSearch_DetailedSearch_PlakamiSatiyorum(Ad_Search_InputEntity adSearchInputEntity) {
        
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}    
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_Cat7(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());
                        if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");}
                        ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9, new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10,  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());
                        if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }else{ps.setString(16, "FarkEtmez");}if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        } else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver()); if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }  else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }  else{ps.setString(21, "FarkEtmez");}if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        } else{ps.setString(22, "FarkEtmez");}if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        } else{ps.setString(28, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        } else{ps.setString(30, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(31, "FarkEtmez");} ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }  else{ps.setString(34, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        } else{ps.setString(35, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        } else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }    else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery(); while (rs.next()) {   Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type")); ab.setAccountBean(abx);   CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl")); ab.setCorporateAccountBean(cb);  Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);          adList.add(ab);   }     }   catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }  return adList;   } public List<Ad_Bean> getAdSearch_AllForCatZero(Ad_Search_InputEntity adSearchInputEntity) {   int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();  Connection con = null;  PreparedStatement ps = null; con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_AllForCatZero(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());  if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        } else{ps.setString(6, "FarkEtmez");} ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9,adSearchInputEntity.getFltr_Ad_EndTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10, adSearchInputEntity.getFltr_Ad_CreateTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode()); if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }   else{ps.setString(16, "FarkEtmez");}   if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");}   ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());  if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }  else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        } else{ps.setString(21, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }  else{ps.setString(22, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }   else{ps.setString(23, "FarkEtmez");} ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }  else{ps.setString(28, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        } else{ps.setString(30, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        } else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }  else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }   else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }  else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        } else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery();   while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));  ab.setAccountBean(abx); CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl")); ab.setCorporateAccountBean(cb); Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));    
                                            ab.setAdIsimVarAracAriyorum(iar); Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType"));  if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand")!=null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){
                                                    String[] vbs = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = ""; 
                                                        for (String x : vbs) { if(x != null){  if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                } else{vbx=", 0";} } } vbx = vbx.substring(1);       vcxx.setVehicle_Brand(vbx);  }      }
                                            else{vcxx.setVehicle_Brand("");}  vcxx.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vcxx.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("Ad_LookingForVehicleForWork_VehicleYear"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx); Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id"));aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);  Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("Ad_HostesimIsAriyorum_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("hostess_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("hostess_BirthDate"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth")); if(rs.getDate("hostess_BirthDate") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("hostess_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR); if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}}
                                            else{hostess.setHostess_yasi(0);} hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);     Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("driver_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("driver_BirthDate"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));                
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));    if(rs.getDate("driver_BirthDate") != null){  Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("driver_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);  if(year2-year >= 18){  drv.setDriver_yasi(year2-year);   } else{drv.setDriver_yasi(0);}   }
                                            else{drv.setDriver_yasi(0);}  sia.setDriver(drv);  ab.setAdSoforumIsAriyorumBean(sia);           Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);    adList.add(ab); }  
            
                    } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        } }  return adList; }
    public List<Ad_Bean> getAdSearch_All(Ad_Search_InputEntity adSearchInputEntity) {   
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_All(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment()); if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        }
                        else{ps.setString(6, "FarkEtmez");}  ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9,adSearchInputEntity.getFltr_Ad_EndTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10, adSearchInputEntity.getFltr_Ad_CreateTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());  if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }   else{ps.setString(16, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver()); if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }  else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }  else{ps.setString(21, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }  else{ps.setString(22, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }  else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }   else{ps.setString(28, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }   else{ps.setString(30, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(31, "FarkEtmez");}   ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country());  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }   else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }   else{ps.setString(35, "FarkEtmez");}   if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        } else{ps.setString(36, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }   else{ps.setString(37, "FarkEtmez");} ResultSet rs = ps.executeQuery();   while (rs.next()) {  Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate")); AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type")); ab.setAccountBean(abx);CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl")); ab.setCorporateAccountBean(cb); Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));    
                                            ab.setAdIsimVarAracAriyorum(iar);  Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType"));  if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand")!=null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){
                                                    String[] vbs = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = ""; 
                                                        for (String x : vbs) {if(x != null){  if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                }  else{vbx=", 0";}  }  } vbx = vbx.substring(1);     vcxx.setVehicle_Brand(vbx);  }     }  else{vcxx.setVehicle_Brand("");}
                                            vcxx.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vcxx.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("Ad_LookingForVehicleForWork_VehicleYear"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx); Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id"));
                                            aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);                                       
                                      Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("Ad_HostesimIsAriyorum_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("hostess_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("hostess_BirthDate"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth")); if(rs.getDate("hostess_BirthDate") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("hostess_BirthDate"));
                                                int year = cal.get(Calendar.YEAR);Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            } else{hostess.setHostess_yasi(0);}
                                            hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);     Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("driver_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("driver_BirthDate"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));                
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));     if(rs.getDate("driver_BirthDate") != null){  Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("driver_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR); if(year2-year >= 18){  drv.setDriver_yasi(year2-year);  }
                                                else{drv.setDriver_yasi(0);} }  else{drv.setDriver_yasi(0);}  sia.setDriver(drv); ab.setAdSoforumIsAriyorumBean(sia);                                
                                      Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);      adList.add(ab); }     } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }   return adList;  } public List<Ad_Bean> getAdSearch_AllForCompany(Ad_Search_InputEntity adSearchInputEntity) {
        
        int sonuc = 0;  List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
   if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_AllForCompany(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment()); if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = ""; for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));  }  else{ps.setString(6, "FarkEtmez");} ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9,adSearchInputEntity.getFltr_Ad_EndTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10, adSearchInputEntity.getFltr_Ad_CreateTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode());  if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        } else{ps.setString(16, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        } else{ps.setString(17, "Farketmez");} ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver()); if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = ""; for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1)); }  else{ps.setString(20, "FarkEtmez");}
                        if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = ""; for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        } else{ps.setString(21, "FarkEtmez");}if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = ""; for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        } else{ps.setString(22, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = ""; for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        } else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));  }  else{ps.setString(28, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }  else{ps.setString(30, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }  else{ps.setString(34, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }    else{ps.setString(35, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }   else{ps.setString(36, "FarkEtmez");} if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }  else{ps.setString(37, "FarkEtmez");}  ResultSet rs = ps.executeQuery();  while (rs.next()) {  Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate"));  AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type")); ab.setAccountBean(abx);CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));    ab.setCorporateAccountBean(cb);  Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));    
                                            ab.setAdIsimVarAracAriyorum(iar); Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType"));  if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand")!=null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){
                                                    String[] vbs = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = ""; 
                                                        for (String x : vbs) { if(x != null){ if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                } else{vbx=", 0";}  } }
                                                    vbx = vbx.substring(1);                                           
                                                    vcxx.setVehicle_Brand(vbx); }    
                                            }else{vcxx.setVehicle_Brand("");}vcxx.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vcxx.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("Ad_LookingForVehicleForWork_VehicleYear"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx); Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id"));
                                           aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);    Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("Ad_HostesimIsAriyorum_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("hostess_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("hostess_BirthDate"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth")); if(rs.getDate("hostess_BirthDate") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("hostess_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            } else{hostess.setHostess_yasi(0);} hiab.setHostess(hostess); ab.setAdHostesimIsAriyorumBean(hiab);     Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("driver_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("driver_BirthDate"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));                
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));    if(rs.getDate("driver_BirthDate") != null){
                                      
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("driver_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR); if(year2-year >= 18){ drv.setDriver_yasi(year2-year);  }
                                                else{drv.setDriver_yasi(0);}  }
                                            else{drv.setDriver_yasi(0);}  sia.setDriver(drv);  ab.setAdSoforumIsAriyorumBean(sia);    Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);        adList.add(ab);  }  
            
                    } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return adList; } public List<Ad_Bean> getAdSearch_AllForCategory(Ad_Search_InputEntity adSearchInputEntity) {
        
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>(); Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_Find_AllForCategory(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                 
                        ps.setString(1, adSearchInputEntity.getFltr_SearchTyp());
                        ps.setString(2, adSearchInputEntity.getFltr_SortType());
                        ps.setString(3, adSearchInputEntity.getFltr_Ad_Id());
                        ps.setInt(4, adSearchInputEntity.getFltr_Ad_CategoryId());
                        ps.setString(5, adSearchInputEntity.getFltr_Ad_Comment());   if(adSearchInputEntity.getFltr_Ad_Type() != null && adSearchInputEntity.getFltr_Ad_Type().length > 0){
                            String AdTypeListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Ad_Type()) { AdTypeListx = AdTypeListx + '|' + dl.toString();  };
                            ps.setString(6, AdTypeListx.substring(1));
                        } else{ps.setString(6, "FarkEtmez");} ps.setString(7, adSearchInputEntity.getFltr_Ad_OvnerAccountId());
                        ps.setBoolean(8, adSearchInputEntity.isFltr_Ad_IsActive());
                        ps.setTimestamp(9,adSearchInputEntity.getFltr_Ad_EndTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_EndTime().getTime()) );
                        ps.setTimestamp(10, adSearchInputEntity.getFltr_Ad_CreateTime() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_CreateTime().getTime())  );
                        ps.setBoolean(11, adSearchInputEntity.isFltr_Ad_IsPublish());
                        ps.setTimestamp(12, adSearchInputEntity.getFltr_Ad_PublishDate() == null ? null :  new java.sql.Timestamp(adSearchInputEntity.getFltr_Ad_PublishDate().getTime())    );
                        ps.setString(13, adSearchInputEntity.getFltr_Ad_WhatTime());
                        ps.setString(14, adSearchInputEntity.getFltr_CompanyId());
                        ps.setInt(15, adSearchInputEntity.getFltr_Vehicle_PlateProvinceCode()); if(adSearchInputEntity.getFltr_Vehicle_BrandIds()!= null && adSearchInputEntity.getFltr_Vehicle_BrandIds().length > 0){
                            String VehicleBrandIdsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_BrandIds()) { VehicleBrandIdsListx = VehicleBrandIdsListx + '|' + dl.toString();  };
                            ps.setString(16, VehicleBrandIdsListx.substring(1));
                        }  else{ps.setString(16, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_Model()!= null && adSearchInputEntity.getFltr_Vehicle_Model().length > 0){
                            String VehicleModelListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Model()) { VehicleModelListx = VehicleModelListx + '|' + dl.toString();  };
                            ps.setString(17, VehicleModelListx.substring(1));
                        }  else{ps.setString(17, "Farketmez");}  ps.setString(18, adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        ps.setBoolean(19, adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver()); if(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats() != null && adSearchInputEntity.getFltr_Vehicle_NumberOfSeats().length > 0){
                            String VehicleNumberOfSeatsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_NumberOfSeats()) { VehicleNumberOfSeatsListx = VehicleNumberOfSeatsListx + '|' + dl.toString();  };
                            ps.setString(20, VehicleNumberOfSeatsListx.substring(1));
                        }   else{ps.setString(20, "FarkEtmez");} if(adSearchInputEntity.getFltr_Vehicle_ServiceTypes() != null && adSearchInputEntity.getFltr_Vehicle_ServiceTypes().length > 0){
                            String ServiceTypesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_ServiceTypes()) { ServiceTypesListx = ServiceTypesListx + '|' + dl.toString();  };
                            ps.setString(21, ServiceTypesListx.substring(1));
                        }     else{ps.setString(21, "FarkEtmez");}   if(adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()!= null && adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments().length > 0){
                            String AuthorityDocumentsListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_AuthorityDocuments()) { AuthorityDocumentsListx = AuthorityDocumentsListx + '|' + dl.toString();  };
                            ps.setString(22, AuthorityDocumentsListx.substring(1));
                        }   else{ps.setString(22, "FarkEtmez");}  if(adSearchInputEntity.getFltr_Vehicle_Properties()!= null && adSearchInputEntity.getFltr_Vehicle_Properties().length > 0){
                            String VehiclePropertiesListx = "";
                            for (String dl : adSearchInputEntity.getFltr_Vehicle_Properties()) { VehiclePropertiesListx = VehiclePropertiesListx + '|' + dl.toString();  };
                            ps.setString(23, VehiclePropertiesListx.substring(1));
                        }    else{ps.setString(23, "FarkEtmez");}  ps.setString(24, adSearchInputEntity.getFltr_Vehicle_DriverInfo());
                        ps.setString(25, adSearchInputEntity.getFltr_Vehicle_HostessInfo());
                        ps.setString(26,adSearchInputEntity.getFltr_AdRoute_StartTime() ); 
                        ps.setString(27, adSearchInputEntity.getFltr_AdRoute_StartPosition_Country());   if(adSearchInputEntity.getFltr_AdRoute_StartPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_City().length > 0){
                            String StartPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_City()) { StartPositionCityListx = StartPositionCityListx + '|' + dl.toString();  };                          
                            ps.setString(28, StartPositionCityListx.substring(1));
                        }    else{ps.setString(28, "FarkEtmez");}    if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Town().length > 0){
                            String StartPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()) { StartPositionTownListx = StartPositionTownListx + '|' + dl.toString();  };                          
                            ps.setString(29, StartPositionTownListx.substring(1));
                        }  else{ps.setString(29, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_District().length > 0){
                            String StartPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_District()) { StartPositionDistrictListx = StartPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(30, StartPositionDistrictListx.substring(1));
                        }   else{ps.setString(30, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()!= null && adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood().length > 0){
                            String StartPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_StartPosition_Neighborhood()) { StartPositionNeighborhoodListx = StartPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(31, StartPositionNeighborhoodListx.substring(1));
                        }    else{ps.setString(31, "FarkEtmez");}  ps.setString(32,adSearchInputEntity.getFltr_AdRoute_EndTime()  );
                        ps.setString(33, adSearchInputEntity.getFltr_AdRoute_EndPosition_Country()); if(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_City().length > 0){
                            String EndPositionCityListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_City()) { EndPositionCityListx = EndPositionCityListx + '|' + dl.toString();  };
                            ps.setString(34, EndPositionCityListx.substring(1));
                        }   else{ps.setString(34, "FarkEtmez");}  if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Town().length > 0){
                            String EndPositionTownListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Town()) { EndPositionTownListx = EndPositionTownListx + '|' + dl.toString();  };
                            ps.setString(35, EndPositionTownListx.substring(1));
                        }    else{ps.setString(35, "FarkEtmez");}   if(adSearchInputEntity.getFltr_AdRoute_EndPosition_District()!= null && adSearchInputEntity.getFltr_AdRoute_EndPosition_District().length > 0){
                            String EndPositionDistrictListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_District()) { EndPositionDistrictListx = EndPositionDistrictListx + '|' + dl.toString();  };
                            ps.setString(36, EndPositionDistrictListx.substring(1));
                        }    else{ps.setString(36, "FarkEtmez");}    if(adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood() != null && adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood().length > 0){
                            String EndPositionNeighborhoodListx = "";
                            for (String dl : adSearchInputEntity.getFltr_AdRoute_EndPosition_Neighborhood()) { EndPositionNeighborhoodListx = EndPositionNeighborhoodListx + '|' + dl.toString();  };
                            ps.setString(37, EndPositionNeighborhoodListx.substring(1));
                        }     else{ps.setString(37, "FarkEtmez");}  ResultSet rs = ps.executeQuery(); while (rs.next()) { // Ilan
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAd_PublishDate(rs.getTimestamp("ad_PublishDate"));  AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("account_Id"));
                                            abx.setAccount_FirstName(rs.getString("account_FirstName"));
                                            abx.setAccount_LastName(rs.getString("account_LastName"));
                                            abx.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            abx.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            abx.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            abx.setAccount_Type(rs.getString("account_Type"));   ab.setAccountBean(abx);   CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            cb.setCompany_Name(rs.getString("company_Name"));
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));  ab.setCorporateAccountBean(cb);  Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));    
                                            ab.setAdIsimVarAracAriyorum(iar);  Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType")); if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand")!=null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){
                                                    String[] vbs = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = "";   for (String x : vbs) { if(x != null){ if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                } else{vbx=", 0";} }   }
                                                    vbx = vbx.substring(1);                                           
                                                    vcxx.setVehicle_Brand(vbx); }     }  else{vcxx.setVehicle_Brand("");} vcxx.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vcxx.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("Ad_LookingForVehicleForWork_VehicleYear"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx); Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax); Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("vehicle_Id"));
                                            aiaxx.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            aiaxx.setVehicle_Model(rs.getString("vehicle_Model"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            aiaxx.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            aiaxx.setVehicle_Color(rs.getString("vehicle_Color"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vimgx.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);   Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("Ad_HostesimIsAriyorum_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("hostess_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("hostess_BirthDate"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth")); if(rs.getDate("hostess_BirthDate") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("hostess_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);  if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            }  else{hostess.setHostess_yasi(0);} hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);     Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("driver_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("driver_BirthDate"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));                
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));    if(rs.getDate("driver_BirthDate") != null){
                                      Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("driver_BirthDate"));
                                                int year = cal.get(Calendar.YEAR); Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);  if(year2-year >= 18){  drv.setDriver_yasi(year2-year);  }
                                                else{drv.setDriver_yasi(0);}
                                                
                                            } else{drv.setDriver_yasi(0);} sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);        Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);    adList.add(ab); }  
            
                    } catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        } return adList; } public List<String> getAdSearch_DetailedSearch_AracKApasiteleri(int catId) {
        
        int sonuc = 0;  List<String> lst = new ArrayList<String>();  Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();
  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   String query1 ="";
                
                        
                        if(catId ==1){
                            query1 =  "SELECT iaa.Ad_LookingForVehicleForWork_VehicleCapacity "
                                    + "FROM ad_ a "
                                    + "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id "
                                    + "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id "
                                    + "LEFT JOIN ad_lookingforvehicleforwork iaa ON a.ad_Id = iaa.Ad_Id "
                                    + "WHERE  a.ad_Category_Id =1 "
                                    + "AND a.ad_PublishDate >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) "
                                    + "AND a.ad_IsActive = 1 "
                                    + "AND a.ad_IsPublish = 1 "
                                    + "AND a.ad_UserEnableDisable = 1 "
                                    + "AND ac.account_IsActive = 1 "
                                    + "GROUP BY iaa.Ad_LookingForVehicleForWork_VehicleCapacity "
                                    + "ORDER BY iaa.Ad_LookingForVehicleForWork_VehicleCapacity ASC ";
                        }
                        else if(catId ==2){
                            query1 =  "SELECT v2.vehicle_NumberOfSeats "
                                    + "FROM ad_ a "
                                    + "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id "
                                    + "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id "
                                    + "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id "
                                    + "LEFT JOIN vehicle_ v2 ON aia.vehicle_Id = v2.vehicle_Id "
                                    + "WHERE  a.ad_Category_Id =2 "
                                    + "AND a.ad_PublishDate >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) "
                                    + "AND a.ad_IsActive = 1 "
                                    + "AND a.ad_IsPublish = 1 "
                                    + "AND a.ad_UserEnableDisable = 1 "
                                    + "AND ac.account_IsActive = 1 "
                                    + "GROUP BY v2.vehicle_NumberOfSeats "
                                    + "ORDER BY v2.vehicle_NumberOfSeats ASC ";
                        
                        }
                        else if(catId ==3){
                            query1 =  "SELECT  COALESCE(asa.fast_vehicle_NumberOfSeats , v2.vehicle_NumberOfSeats) AS VehicleCapacity "
                                    + "FROM ad_ a "
                                    + "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id "
                                    + "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id "
                                    + "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id "
                                    + "LEFT JOIN vehicle_ v2 ON asa.vehicle_Id = v2.vehicle_Id "
                                    + "WHERE  a.ad_Category_Id =3 "
                                    + "AND a.ad_PublishDate >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) "
                                    + "AND a.ad_IsActive = 1 "
                                    + "AND a.ad_IsPublish = 1 "
                                    + "AND a.ad_UserEnableDisable = 1 "
                                    + "AND ac.account_IsActive = 1 "
                                    + "GROUP BY VehicleCapacity "
                                    + "ORDER BY VehicleCapacity ASC";
                        }
                        
                    
                        ps = con.prepareStatement(query1);           
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) {  
                            if(catId ==1){                            
                                if(rs.getString("Ad_LookingForVehicleForWork_VehicleCapacity") != null){ 
                                    if(!rs.getString("Ad_LookingForVehicleForWork_VehicleCapacity").equals("")){
                                        lst.add(rs.getString("Ad_LookingForVehicleForWork_VehicleCapacity")); 
                                    } 
                                } 
                            } if(catId ==2){  
                                if(rs.getString("vehicle_NumberOfSeats") != null){ 
                                    if(!rs.getString("vehicle_NumberOfSeats").equals("")){
                                        lst.add(rs.getString("vehicle_NumberOfSeats")); 
                                    } 
                                } 
                            } if(catId ==3){  
                                if(rs.getString("VehicleCapacity") != null){ 
                                    if(!rs.getString("VehicleCapacity").equals("")){
                                        lst.add(rs.getString("VehicleCapacity")); 
                                    } 
                                } 
                            }
                        } 
            
                    } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+this.getClass().getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+this.getClass().getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");}
                        }
        }
        
        return lst;
    }
        
    
        
      
}
