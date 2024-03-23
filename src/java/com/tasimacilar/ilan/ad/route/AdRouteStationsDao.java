package com.tasimacilar.ilan.ad.route;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class AdRouteStationsDao { public int createAdRouteStation(AdRouteStations adRouteStation) { int sonuc = 0;
        java.sql.Time Time = adRouteStation.getAdRouteStation_Time() == null ? null : new java.sql.Time(adRouteStation.getAdRouteStation_Time().getTime());
     Connection con = null; PreparedStatement ps = null;con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Routestation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, adRouteStation.getAdRouteStation_Id());
                        ps.setString(3, adRouteStation.getAdRouteStation_Comment());
                        ps.setString(4, adRouteStation.getAdRouteStation_Country());
                        ps.setString(5, adRouteStation.getAdRouteStation_City());
                        ps.setString(6, adRouteStation.getAdRouteStation_Town());
                        ps.setString(7, adRouteStation.getAdRouteStation_District());
                        ps.setString(8, adRouteStation.getAdRouteStation_Neighborhood());
                        ps.setDouble(9, adRouteStation.getAdRouteStation_Latitude());
                        ps.setDouble(10, adRouteStation.getAdRouteStation_Longitude());
                        ps.setTime(11, Time);
                        ps.setString(12, adRouteStation.getAdRoute_Id());
                        sonuc = ps.executeUpdate();  
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni durak olusturuldu. [AdRouteStation_Id:"+adRouteStation.getAdRouteStation_Id()
                                                                                                            +" AdRoute_Id:"+adRouteStation.getAdRoute_Id()+"]", "system");
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
        
        return sonuc;   }public List<AdRouteStations> getAllAdRouteStationWithAdRouteId(String AdRouteId) {
        int sonuc = 0; List<AdRouteStations> al = new ArrayList<AdRouteStations>();  Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Routestation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithadRouteId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setDouble(9, 0.0);
                        ps.setDouble(10, 0.0);
                        ps.setTime(11, null);
                        ps.setString(12, AdRouteId);
                        ResultSet rs = ps.executeQuery();                      
                        while (rs.next()) {     AdRouteStations adrb = new AdRouteStations();
                                                adrb.setAdRouteStation_Id(rs.getString("adRouteStation_Id"));
                                                adrb.setAdRouteStation_Comment(rs.getString("adRouteStation_Comment"));
                                                adrb.setAdRouteStation_Country(rs.getString("adRouteStation_Country"));
                                                adrb.setAdRouteStation_City(rs.getString("adRouteStation_City"));
                                                adrb.setAdRouteStation_Town(rs.getString("adRouteStation_Town"));
                                                adrb.setAdRouteStation_District(rs.getString("adRouteStation_District"));
                                                adrb.setAdRouteStation_Neighborhood(rs.getString("adRouteStation_Neighborhood"));
                                                adrb.setAdRouteStation_Latitude(rs.getDouble("adRouteStation_Latitude"));
                                                adrb.setAdRouteStation_Longitude(rs.getDouble("adRouteStation_Longitude"));
                                                adrb.setAdRouteStation_Time(rs.getTime("adRouteStation_Time"));
                                                adrb.setAdRouteStation_TimeEditable(rs.getBoolean("adRouteStation_TimeEditable"));
                                                adrb.setAdRoute_Id(rs.getString("adRoute_Id"));
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
        
        return al;  } public int updateAdRouteStation(AdRouteStations adRouteStation) {
        int sonuc = 0;   java.sql.Time Time = adRouteStation.getAdRouteStation_Time() == null ? null : new java.sql.Time(adRouteStation.getAdRouteStation_Time().getTime());
        Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}     
        else{   try {   ps = con.prepareCall("{call pro_ad_Routestation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "update");
                        ps.setString(2, adRouteStation.getAdRouteStation_Id());
                        ps.setString(3, adRouteStation.getAdRouteStation_Comment());
                        ps.setString(4, adRouteStation.getAdRouteStation_Country());
                        ps.setString(5, adRouteStation.getAdRouteStation_City());
                        ps.setString(6, adRouteStation.getAdRouteStation_Town());
                        ps.setString(7, adRouteStation.getAdRouteStation_District());
                        ps.setString(8, adRouteStation.getAdRouteStation_Neighborhood());
                        ps.setDouble(9, adRouteStation.getAdRouteStation_Latitude());
                        ps.setDouble(10, adRouteStation.getAdRouteStation_Longitude());
                        ps.setTime(11, Time);
                        ps.setString(12, adRouteStation.getAdRoute_Id());
                        sonuc = ps.executeUpdate();  
                        LogManagerDao.createLog("info", this.getClass().getName(), "Durak guncellendi. [AdRouteStation_Id:"+adRouteStation.getAdRouteStation_Id()
                                                                                                            +" AdRoute_Id:"+adRouteStation.getAdRoute_Id()+"]", "system");
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
        
        return sonuc;  } public int updateAdRouteStationTime(Date stationTime, String stationId) { System.out.println("--"+stationId);System.out.println("--"+new java.sql.Time(stationTime.getTime()));
        int sonuc = 0; Connection con = null;    PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}  
        else{   try {   ps = con.prepareCall("{call pro_ad_Routestation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "updateTime");
                        ps.setString(2, stationId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setDouble(9, 0.0);
                        ps.setDouble(10, 0.0);
                        ps.setTime(11, new java.sql.Time(stationTime.getTime()));
                        ps.setString(12, null);
                        sonuc = ps.executeUpdate();  
                        System.out.println("Durak saat guncelleme BAŞARILI");
                        
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
        
        return sonuc;  } public int deleteAdRouteStationWithAdId(String adRouteStationId) {   
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;   con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Routestation(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, adRouteStationId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setDouble(9, 0);
                        ps.setDouble(10, 0);
                        ps.setTime(11, null);
                        ps.setString(12, null);                    
                        sonuc = ps.executeUpdate();  
                        LogManagerDao.createLog("info", this.getClass().getName(), "İlan durak bilgisi silindi. [adRouteStationId:"+adRouteStationId+"]", "system");
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
        
        return sonuc;
    }
    
    
}
