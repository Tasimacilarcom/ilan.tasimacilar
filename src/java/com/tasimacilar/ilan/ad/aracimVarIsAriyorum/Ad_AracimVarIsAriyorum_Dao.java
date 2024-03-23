package com.tasimacilar.ilan.ad.aracimVarIsAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.common.lists.ForeignLanguagesBean;
import com.tasimacilar.ilan.common.lists.SrcDocumentsBean;
import com.tasimacilar.ilan.common.lists.ServiceTypeBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.Vehicle;
import com.tasimacilar.ilan.vehicle.VehicleBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_AracimVarIsAriyorum_Dao { 
    public int createAracimVarIsAriyorumAd(Ad_AracimVarIsAriyorum_Bean ad) {       
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}        
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarIsAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, ad.getAdAracimVarIsAriyorum().getAd_AracimVarIsAriyorum_Id());
                        ps.setString(3, ad.getVehicle().getVehicle_Id());
                        ps.setString(4, ad.getAdBean().getAd_Id());
                        ps.setInt(5, ad.getAdBean().getAd_Category_Id());
                        ps.setString(6, ad.getAdBean().getAd_Title());
                        ps.setString(7, ad.getAdBean().getAd_Comment());
                        ps.setString(8, ad.getAdBean().getAd_Type());
                        ps.setString(9, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(10, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(11, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(12, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(13, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(14, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(15, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(16, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(17, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(18, ad.getAdBean().getAd_LastChangerAccountId());                    
                        sonuc = ps.executeUpdate();  
                        System.out.println("Yeni ilan Oluşturma BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: Aracim Var İş Arıyorum Ad Id:"+ad.getAdBean().getAd_Id()+"]", "system");
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
    public int updateAracimVarIsAriyorumAd(Ad_AracimVarIsAriyorum_Bean ad) {        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}      
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarIsAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "update");
                        ps.setString(2, ad.getAdAracimVarIsAriyorum().getAd_AracimVarIsAriyorum_Id());
                        ps.setString(3, ad.getVehicle().getVehicle_Id());
                        ps.setString(4, ad.getAdBean().getAd_Id());
                        ps.setInt(5, ad.getAdBean().getAd_Category_Id());
                        ps.setString(6, ad.getAdBean().getAd_Title());
                        ps.setString(7, ad.getAdBean().getAd_Comment());
                        ps.setString(8, ad.getAdBean().getAd_Type());
                        ps.setString(9, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(10, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(11, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(12, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(13, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(14, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(15, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(16, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(17, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(18, ad.getAdBean().getAd_LastChangerAccountId());                                            
                        sonuc = ps.executeUpdate();                        
                        System.out.println("İlan guncelleme BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "İlan güncellendi. [Kategori: Aracim Var İş Arıyorum Ad Id:"+ad.getAdBean().getAd_Id()+"]", "system");
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
    public Ad_AracimVarIsAriyorum_Bean getAracimVarIsAriyorumWithAdId(String adId) {    
        int sonuc = 0;
        Ad_AracimVarIsAriyorum_Bean ad = new Ad_AracimVarIsAriyorum_Bean();
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}      
        else{              
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`ad_aracim_var_is_ariyorum` l "
                                        + "WHERE a.ad_Id=? "
                                        + "AND a.ad_Category_Id = c.ad_Category_Id "
                                        + "AND a.ad_Id = l.Ad_Id ";
                        
                        ps = con.prepareStatement(query1);                   
                        ps.setString(1, adId);                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { 
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_Type(rs.getString("ad_Type"));
                                            ab.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ab.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            ab.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            ab.setAd_Notes(rs.getString("ad_Notes"));
                                            ab.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ab.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            ab.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            ab.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            ab.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            ab.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            Vehicle vc = new Vehicle();
                                            vc.setVehicle_Id(rs.getString("vehicle_Id"));
                                            Ad_AracimVarIsAriyorum ai = new Ad_AracimVarIsAriyorum();
                                            ai.setAd_AracimVarIsAriyorum_Id(rs.getString("Ad_AracimVarIsAriyorum_Id"));                                         
                                            ad.setAdAracimVarIsAriyorum(ai);
                                            ad.setVehicle(vc);
                                            ad.setAdBean(ab);
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
        return ad;
    }  
}
