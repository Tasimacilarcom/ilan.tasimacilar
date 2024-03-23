package com.tasimacilar.ilan.banners;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class BannersDao {
     public int createBanner(BannersBean banner) {
        
        int sonuc = 0;   java.sql.Timestamp CreateTime = banner.getBanner_Created() == null ? null : new java.sql.Timestamp(banner.getBanner_Created().getTime());


        Connection con = null;   PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_banners(?,?,?,?,?,?,?,?,?,?,?,?)}");
                      
                        ps.setString(1, "insert");
                        ps.setString(2, banner.getBanner_Id());
                        ps.setString(3, banner.getBanner_Location());
                        ps.setString(4, banner.getBanner_Code());
                        ps.setString(5, banner.getBanner_Comment());
                        ps.setBoolean(6, banner.isBanner_IsActive());
                        ps.setTimestamp(7, null);
                        ps.setTimestamp(8, null);
                        ps.setTimestamp(9, CreateTime);
                        ps.setString(10, banner.getBanner_Modifier());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, banner.getBanner_creator());
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Yeni banner olusturuldu"); }
                        
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
    } public int updateBanner(BannersBean banner) {
        
        int sonuc = 0;  java.sql.Timestamp CreateTime = banner.getBanner_Created() == null ? null : new java.sql.Timestamp(banner.getBanner_Created().getTime());


        Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_banners(?,?,?,?,?,?,?,?,?,?,?,?)}");
                      
                        ps.setString(1, "update");
                        ps.setString(2, banner.getBanner_Id());
                        ps.setString(3, banner.getBanner_Location());
                        ps.setString(4, banner.getBanner_Code());
                        ps.setString(5, banner.getBanner_Comment());
                        ps.setBoolean(6, banner.isBanner_IsActive());
                        ps.setTimestamp(7, null);
                        ps.setTimestamp(8, null);
                        ps.setTimestamp(9, CreateTime);
                        ps.setString(10, banner.getBanner_Modifier());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, banner.getBanner_creator());
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Banner güncellendi"); }
                        
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
    } public BannersBean getBannerWithLocation(String location) {
       
        BannersBean b = new BannersBean(); Connection con = null;  PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_banners(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "getWithLocation");
                        ps.setString(2, null);
                        ps.setString(3, location);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setBoolean(6, false);
                        ps.setTimestamp(7, null);
                        ps.setTimestamp(8, null);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { 
                                            b.setBanner_Id(rs.getString("banner_Id"));
                                            b.setBanner_Location(rs.getString("banner_Location"));            
                                            b.setBanner_Code(rs.getString("banner_Code"));               
                                            b.setBanner_Comment(rs.getString("banner_Comment"));           
                                            b.setBanner_IsActive(rs.getBoolean("banner_IsActive"));          
                                            b.setBanner_StartViewDate(rs.getTimestamp("banner_StartViewDate"));     
                                            b.setBanner_EndViewDate(rs.getTimestamp("banner_EndViewDate"));        
                                            b.setBanner_Modified(rs.getTimestamp("banner_Modified"));           
                                            b.setBanner_Modifier(rs.getString("banner_Modifier"));          
                                            b.setBanner_Created(rs.getTimestamp("banner_Created"));           
                                            b.setBanner_creator(rs.getString("banner_creator")); 
                                          
                        }                    
                    } 

                catch (SQLException ex) {  System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+this.getClass().getName()
                                                                    +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                          LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                } 

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
        
        return b;
    }
    
    
    
    
    
    
}
