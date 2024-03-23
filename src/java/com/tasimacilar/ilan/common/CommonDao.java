package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class CommonDao {
public int toplamAktifKullaniciSayisi() {
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;
         con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {    String query =   "SELECT settings_Value_1 "
                                           + "FROM `settings` "
                                           + "WHERE settings_Key = 'Total_Number_Of_Active_Accounts' ";

                            ps = con.prepareStatement(query);  ResultSet rs = ps.executeQuery(); while (rs.next()) { sonuc = rs.getInt(1); }                       
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
        
        return sonuc;   } public int toplamAktifBireyselKullaniciSayisi() {
        
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;
         con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {    String query =   "SELECT settings_Value_1 "
                                           + "FROM `settings` "
                                           + "WHERE settings_Key = 'Total_Number_Of_Active_Personal_Accounts' ";

                            ps = con.prepareStatement(query);  ResultSet rs = ps.executeQuery();  while (rs.next()) { sonuc = rs.getInt(1); }                       
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
            }  return sonuc; } public int toplamAktifKurumsalKullaniciSayisi() {
         int sonuc = 0; Connection con = null;  PreparedStatement ps = null;
           con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {    String query =   "SELECT settings_Value_1 "
                                           + "FROM `settings` "
                                           + "WHERE settings_Key = 'Total_Number_Of_Active_Corporate_Accounts' ";               

                            ps = con.prepareStatement(query);  ResultSet rs = ps.executeQuery(); while (rs.next()) { sonuc = rs.getInt(1); }                       
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
            } return sonuc; }
    
    
}
