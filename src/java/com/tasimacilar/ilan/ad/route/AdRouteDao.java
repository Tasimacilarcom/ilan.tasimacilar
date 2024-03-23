package com.tasimacilar.ilan.ad.route;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.VehicleBrandAndModelBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class AdRouteDao { public int createAdRoute(AdRouteBean adRoute) { int sonuc = 0;
        java.sql.Time StartTime = adRoute.getAdRoute_StartTime() == null ? null : new java.sql.Time(adRoute.getAdRoute_StartTime().getTime());
        java.sql.Time EndTime = adRoute.getAdRoute_EndTime() == null ? null : new java.sql.Time(adRoute.getAdRoute_EndTime().getTime());
 Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Route(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, adRoute.getAdRoute_Id());
                        ps.setString(3, adRoute.getAdRoute_StartPosition_Country());
                        ps.setString(4, adRoute.getAdRoute_StartPosition_City());
                        ps.setString(5, adRoute.getAdRoute_StartPosition_Town());
                        ps.setString(6, adRoute.getAdRoute_StartPosition_District());
                        ps.setString(7, adRoute.getAdRoute_StartPosition_Neighborhood());
                        ps.setDouble(8, adRoute.getAdRoute_StartPosition__Latitude());
                        ps.setDouble(9, adRoute.getAdRoute_StartPosition__Longitude());
                        ps.setTime(10, StartTime);
                        ps.setString(11, adRoute.getAdRoute_EndPosition_Country());
                        ps.setString(12, adRoute.getAdRoute_EndPosition_City());
                        ps.setString(13, adRoute.getAdRoute_EndPosition_Town());
                        ps.setString(14, adRoute.getAdRoute_EndPosition_District());
                        ps.setString(15, adRoute.getAdRoute_EndPosition_Neighborhood());
                        ps.setDouble(16, adRoute.getAdRoute_EndPosition__Latitude());
                        ps.setDouble(17, adRoute.getAdRoute_EndPosition__Longitude());
                        ps.setTime(18, EndTime);
                        ps.setString(19, adRoute.getAdRoute_destinationTown());
                        ps.setString(20, adRoute.getAd_Id());
                        ps.setInt(21, getRouteJobNumber(adRoute.getAd_Id())+1 );
                      
                        sonuc = ps.executeUpdate();  
                         LogManagerDao.createLog("info", this.getClass().getName(), "Yeni guzergah olusturuldı olusturuldu. [AdRoute_Id:"+adRoute.getAdRoute_Id()
                                                                                                            +" Ad_Id:"+adRoute.getAd_Id()+"]", "system");
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
        
        return sonuc;  } public List<AdRouteBean> getAllAdRouteWithAdId(String adId) {    
        int sonuc = 0;  List<AdRouteBean> al = new ArrayList<AdRouteBean>();  Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Route(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithAdId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setDouble(8, 0.0);
                        ps.setDouble(9, 0.0);
                        ps.setTime(10, null);
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setDouble(16, 0.0);
                        ps.setDouble(17, 0.0);
                        ps.setTime(18, null);
                        ps.setString(19, null);
                        ps.setString(20, adId);
                        ps.setInt(21, 0);
                      
    
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) {     AdRouteBean adrb = new AdRouteBean();
                                                adrb.setAdRoute_Id(rs.getString("adRoute_Id"));
                                                adrb.setAdRoute_StartPosition_Country(rs.getString("adRoute_StartPosition_Country"));
                                                adrb.setAdRoute_StartPosition_City(rs.getString("adRoute_StartPosition_City"));
                                                adrb.setAdRoute_StartPosition_Town(rs.getString("adRoute_StartPosition_Town"));
                                                adrb.setAdRoute_StartPosition_District(rs.getString("adRoute_StartPosition_District"));
                                                adrb.setAdRoute_StartPosition_Neighborhood(rs.getString("adRoute_StartPosition_Neighborhood"));
                                                adrb.setAdRoute_StartPosition__Latitude(rs.getDouble("adRoute_StartPosition__Latitude"));
                                                adrb.setAdRoute_StartPosition__Longitude(rs.getDouble("adRoute_StartPosition__Longitude"));
                                                adrb.setAdRoute_StartTime(rs.getTime("adRoute_StartTime"));
                                                adrb.setAdRoute_EndPosition_Country(rs.getString("adRoute_EndPosition_Country"));
                                                adrb.setAdRoute_EndPosition_City(rs.getString("adRoute_EndPosition_City"));
                                                adrb.setAdRoute_EndPosition_Town(rs.getString("adRoute_EndPosition_Town"));
                                                adrb.setAdRoute_EndPosition_District(rs.getString("adRoute_EndPosition_District"));
                                                adrb.setAdRoute_EndPosition_Neighborhood(rs.getString("adRoute_EndPosition_Neighborhood"));
                                                adrb.setAdRoute_EndPosition__Latitude(rs.getDouble("adRoute_EndPosition__Latitude"));
                                                adrb.setAdRoute_EndPosition__Longitude(rs.getDouble("adRoute_EndPosition__Longitude"));
                                                adrb.setAdRoute_EndTime(rs.getTime("adRoute_EndTime"));
                                                adrb.setAdRoute_destinationTown(rs.getString("adRoute_destinationTown"));
                                                adrb.setAd_Id(rs.getString("ad_Id"));
                            
                                                al.add(adrb);
                        
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
        
        return al;
    }public int deleteAdRouteWithAdId(String adRouteId) {
        
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Route(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, adRouteId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setDouble(8, 0);
                        ps.setDouble(9, 0);
                        ps.setTime(10, null);
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setDouble(16, 0);
                        ps.setDouble(17, 0);
                        ps.setTime(18, null);
                        ps.setString(19, null);
                        ps.setString(20, null);
                        ps.setInt(21, 0);
                        
                        sonuc = ps.executeUpdate();  
                        
                        LogManagerDao.createLog("info", this.getClass().getName(), "İlan lokasyon bilgisi silindi. [adRouteId:"+adRouteId+"]", "system");
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
        
        return sonuc;  }  public int getRouteJobNumber( String adId) { 
        
        int sonuc = 0;   Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT MAX(adRoute_JobNumber) AS adRoute_JobNumber FROM ilan_tasimacilar.ad_route WHERE ad_Id = ? ";

                    ps = con.prepareStatement(query1);
                    ps.setString(1, adId);
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {  sonuc =  rs.getInt("adRoute_JobNumber"); }
               } 

            catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                      System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

            finally { try { if (ps != null) {try {ps.close();} 
                                     catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                               System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                    }
                    if (con != null && !con.isClosed()) {con.close();}
                  } 

              catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                        System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
            }
        } 
   
        return sonuc;
    }}
