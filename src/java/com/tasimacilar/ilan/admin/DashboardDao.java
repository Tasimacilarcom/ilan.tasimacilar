package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
public class DashboardDao {   public int bekleyenDestekTalepleriSayisi() {
        
        int sonuc = 0; Connection con = null;   PreparedStatement ps = null;
           con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(support_Id) FROM `supports` WHERE support_IsActive AND  support_Status = 'Cevap Bekliyor' ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    }  public int toplamDestekTalepleriSayisi() {
        
        int sonuc = 0; Connection con = null;  PreparedStatement ps = null;    con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(support_Id) FROM `supports` WHERE support_IsActive ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    }  public int bekleyenYorumSayisi() {  int sonuc = 0;
        
        Connection con = null;    PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(AdComment_Id) FROM `ad_comments` WHERE AdComment_IsPublish= false  ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    }public int toplamYorumSayisi() { int sonuc = 0;
        
        Connection con = null;  PreparedStatement ps = null;
           
            con = ConnectionManager.GetConnection();   if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(AdComment_Id) FROM `ad_comments` WHERE AdComment_IsPublish= true ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
        
        return sonuc;  } public int toplamAracSayisi() {
        
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;
           
            con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(v.vehicle_Id) "
                                           + "FROM vehicle_ v,  vehicle_images i, account_ a "
                                           + "WHERE i.vehicle_Id = v.vehicle_Id "
                                           + "AND v.vehicle_OvnerAccountId = a.account_Id "
                                           + "AND v.vehicle_IsActive = true ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    } public int bekleyenFirmaSayisi() {  int sonuc = 0;
        
        Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =    "SELECT count(company_Id) "
                                            + "FROM `ilan_tasimacilar`.`company_` c, `ilan_tasimacilar`.addresses_ a, `ilan_tasimacilar`.socialmedia s, `ilan_tasimacilar`.phones_ p "
                                            + "WHERE c.address_id = a.address_id "
                                            + "AND c.SocialMedia_Id = s.socialMedia_id "
                                            + "AND c.phone_id = p.phone_id "
                                            + "AND c.company_IsPublish = 0  ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
            }  return sonuc;   }  public int toplamFirmaSayisi() {
        
        int sonuc = 0; Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =   "SELECT count(company_Id) "
                                            + "FROM `ilan_tasimacilar`.`company_` c, `ilan_tasimacilar`.addresses_ a, `ilan_tasimacilar`.socialmedia s, `ilan_tasimacilar`.phones_ p "
                                            + "WHERE c.address_id = a.address_id "
                                            + "AND c.SocialMedia_Id = s.socialMedia_id "
                                            + "AND c.phone_id = p.phone_id "
                                            + "AND c.company_IsPublish = 1  ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    }public int bekleyenIlanSayisi() {
        
        int sonuc = 0;  Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =    "SELECT count(a.ad_Id) "
                                            + "FROM ad_ a "
                                            + "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id "
                                            + "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id "
                                            + "LEFT JOIN company_ co on ac.company_Id = co.company_Id "
                                            + "LEFT JOIN ad_aracim_var_hostes_ariyorum aha ON a.ad_Id = aha.Ad_Id "
                                            + "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id "
                                            + "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id "
                                            + "LEFT JOIN ad_hostesim_is_ariyorum hia ON a.ad_Id = hia.ad_Id "
                                            + "LEFT JOIN hostesses ho ON ho.hostess_Id = hia.hostess_Id "
                                            + "LEFT JOIN ad_soforum_is_ariyorum sia ON a.ad_Id = sia.ad_Id "
                                            + "LEFT JOIN hostesses ho2 ON ho2.hostess_Id = sia.hostess_Id "
                                            + "LEFT JOIN drivers drv ON drv.driver_Id = sia.driver_Id "
                                            + "LEFT JOIN ad_lookingforvehicleforwork iaa ON a.ad_Id = iaa.Ad_Id "
                                            + "WHERE a.ad_IsActive = 1 "
                                            + "AND a.ad_IsPublish = 0 ";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { sonuc = rs.getInt(1); }                       
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
    } public ArrayList<String> bugun_ilanlar() {
        
        ArrayList<String> catList = new ArrayList<String>();
        
        Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =  "SELECT c.ad_Category_ " +
                                            "FROM ad_ a " +
                                            "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id " +
                                            "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id " +
                                            "LEFT JOIN company_ co on ac.company_Id = co.company_Id " +
                                            "LEFT JOIN ad_aracim_var_hostes_ariyorum aha ON a.ad_Id = aha.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id " +
                                            "LEFT JOIN ad_hostesim_is_ariyorum hia ON a.ad_Id = hia.ad_Id " +
                                            "LEFT JOIN hostesses ho ON ho.hostess_Id = hia.hostess_Id " +
                                            "LEFT JOIN ad_soforum_is_ariyorum sia ON a.ad_Id = sia.ad_Id " +
                                            "LEFT JOIN hostesses ho2 ON ho2.hostess_Id = sia.hostess_Id " +
                                            "LEFT JOIN drivers drv ON drv.driver_Id = sia.driver_Id " +
                                            "LEFT JOIN ad_lookingforvehicleforwork iaa ON a.ad_Id = iaa.Ad_Id " +
                                            "LEFT JOIN ad_route ro ON a.ad_Id = ro.ad_Id " +
                                            "WHERE a.ad_IsActive = 1 " +
                                            "AND ac.account_IsActive = 1 " +
                                            "AND a.ad_EndTime	>= CURDATE() " +
                                            "AND c.ad_Category_ = c.ad_Category_ " +
                                            "AND a.ad_CreateTime >= CONCAT(CURDATE(), ' 00:00:00') && a.ad_CreateTime < CONCAT(CURDATE(), ' 23:59:59') " +
                                            "AND a.ad_IsPublish = 1 GROUP BY a.ad_Id";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { catList.add(rs.getString("ad_Category_"));      }                       
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
        
        return catList;
    } public ArrayList<String> yayindaki_ilanlar() {
        
        ArrayList<String> catList = new ArrayList<String>();
        
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =  "SELECT c.ad_Category_ " +
                                            "FROM ad_ a " +
                                            "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id " +
                                            "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id " +
                                            "LEFT JOIN company_ co on ac.company_Id = co.company_Id " +
                                            "LEFT JOIN ad_aracim_var_hostes_ariyorum aha ON a.ad_Id = aha.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id " +
                                            "LEFT JOIN ad_hostesim_is_ariyorum hia ON a.ad_Id = hia.ad_Id " +
                                            "LEFT JOIN hostesses ho ON ho.hostess_Id = hia.hostess_Id " +
                                            "LEFT JOIN ad_soforum_is_ariyorum sia ON a.ad_Id = sia.ad_Id " +
                                            "LEFT JOIN hostesses ho2 ON ho2.hostess_Id = sia.hostess_Id " +
                                            "LEFT JOIN drivers drv ON drv.driver_Id = sia.driver_Id " +
                                            "LEFT JOIN ad_lookingforvehicleforwork iaa ON a.ad_Id = iaa.Ad_Id " +
                                            "LEFT JOIN ad_route ro ON a.ad_Id = ro.ad_Id " +
                                            "WHERE a.ad_IsActive = 1 " +
                                            "AND ac.account_IsActive = 1 " +
                                            "AND a.ad_EndTime	>= CURDATE() " +
                                            "AND c.ad_Category_ = c.ad_Category_ " +
                                            "AND a.ad_CreateTime > DATE_SUB(NOW(), INTERVAL 3 MONTH) " +
                                            "AND a.ad_IsPublish = 1 GROUP BY a.ad_Id";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { catList.add(rs.getString("ad_Category_"));      }                       
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
        
        return catList;
    } public ArrayList<String> tum_ilanlar() { ArrayList<String> catList = new ArrayList<String>();
        
        Connection con = null;  PreparedStatement ps = null;
           
            con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query =  "SELECT c.ad_Category_ " +
                                            "FROM ad_ a " +
                                            "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id " +
                                            "LEFT JOIN account_ ac ON a.ad_OvnerAccountId = ac.account_Id " +
                                            "LEFT JOIN company_ co on ac.company_Id = co.company_Id " +
                                            "LEFT JOIN ad_aracim_var_hostes_ariyorum aha ON a.ad_Id = aha.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id " +
                                            "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id " +
                                            "LEFT JOIN ad_hostesim_is_ariyorum hia ON a.ad_Id = hia.ad_Id " +
                                            "LEFT JOIN hostesses ho ON ho.hostess_Id = hia.hostess_Id " +
                                            "LEFT JOIN ad_soforum_is_ariyorum sia ON a.ad_Id = sia.ad_Id " +
                                            "LEFT JOIN hostesses ho2 ON ho2.hostess_Id = sia.hostess_Id " +
                                            "LEFT JOIN drivers drv ON drv.driver_Id = sia.driver_Id " +
                                            "LEFT JOIN ad_lookingforvehicleforwork iaa ON a.ad_Id = iaa.Ad_Id " +
                                            "LEFT JOIN ad_route ro ON a.ad_Id = ro.ad_Id " +
                                            "WHERE a.ad_IsActive = 1 " +
                                            "AND ac.account_IsActive = 1 " +
                                            "AND c.ad_Category_ = c.ad_Category_ " +
                                            "AND a.ad_IsPublish = 1 GROUP BY a.ad_Id";

                            ps = con.prepareStatement(query);
                            
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) { catList.add(rs.getString("ad_Category_"));      }                       
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
        
        return catList;
    }
    

    
    
    
    
    
    
}
