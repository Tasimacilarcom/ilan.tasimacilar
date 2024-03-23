package com.tasimacilar.ilan.ad.aracimVarHostesAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.common.lists.ForeignLanguagesBean;
import com.tasimacilar.ilan.common.lists.SrcDocumentsBean;
import com.tasimacilar.ilan.common.lists.ServiceTypeBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_AracimVarHostesAriyorum_Dao {
    public int createAracimVarHostesAriyorumAd(Ad_AracimVarHostesAriyorum_Bean ad) {
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarHostesAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					    ps.setString(1, "insert");
                        ps.setString(2, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Id());
                        ps.setString(3, "");
                        ps.setString(4, "");
                        ps.setInt(5, 0);
                        ps.setBoolean(6, false);
                        ps.setBoolean(7, false);
                        ps.setString(8, "");
                        ps.setFloat(9, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Cost());
                        ps.setString(10, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Experience());
                        ps.setString(11, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_school());
                        ps.setBoolean(12, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_highSchool());
                        ps.setBoolean(13, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_kindergarten());
                        ps.setBoolean(14, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_primarySchool());
                        ps.setString(15, "");
                        ps.setString(16, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_ForeignLanguage());                      
                        ps.setString(17, ad.getAdBean().getAd_Id());
                        ps.setInt(18, ad.getAdBean().getAd_Category_Id());
                        ps.setString(19, ad.getAdBean().getAd_Title());
                        ps.setString(20, ad.getAdBean().getAd_Comment());
                        ps.setString(21, ad.getAdBean().getAd_Type());
                        ps.setString(22, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(23, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(24, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(25, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(26, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(27, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(28, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(29, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(30, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(31, ad.getAdBean().getAd_LastChangerAccountId());                                            
                        sonuc = ps.executeUpdate();                       
                        if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: aracim-var-hostes-ariyorum "
                                                                                                            + "Ad Id:"+ad.getAdBean().getAd_Id()+"]", "system");
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
        
        return sonuc;
    } 
    public int updateAracimVarHostesAriyorumAd(Ad_AracimVarHostesAriyorum_Bean ad) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarHostesAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
                        ps.setString(1, "update");
                        ps.setString(2, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Id());
                        ps.setString(3, "");
                        ps.setString(4, "");
                        ps.setInt(5, 0);
                        ps.setBoolean(6, false);
                        ps.setBoolean(7, false);
                        ps.setString(8, "");
                        ps.setFloat(9, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Cost());
                        ps.setString(10, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Experience());
                        ps.setString(11, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_school());
                        ps.setBoolean(12, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_highSchool());
                        ps.setBoolean(13, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_kindergarten());
                        ps.setBoolean(14, ad.getAdAracimVarHostesAriyorum().isAd_AracimVarHostesAriyorum_schoolType_primarySchool());
                        ps.setString(15, "");
                        ps.setString(16, ad.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_ForeignLanguage());
						ps.setString(17, ad.getAdBean().getAd_Id());
                        ps.setInt(18, ad.getAdBean().getAd_Category_Id());
                        ps.setString(19, ad.getAdBean().getAd_Title());
                        ps.setString(20, ad.getAdBean().getAd_Comment());
                        ps.setString(21, ad.getAdBean().getAd_Type());
                        ps.setString(22, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(23, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(24, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(25, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(26, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(27, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(28, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(29, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(30, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(31, ad.getAdBean().getAd_LastChangerAccountId());
                        sonuc = ps.executeUpdate();  
                        System.out.println("Ilan güncelleştirme BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Ilan güncellendi. [Kategori: aracim-var-hostes-ariyorum "
                                                                                                            + "Ad Id:"+ad.getAdBean().getAd_Id()+"]", "system");
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
    public Ad_AracimVarHostesAriyorum_Bean getAracimVarHostesAriyorumWithAdId(String adId) {        
        int sonuc = 0;
        Ad_AracimVarHostesAriyorum_Bean ad = new Ad_AracimVarHostesAriyorum_Bean();       
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`ad_aracim_var_hostes_ariyorum` l "
                                        + "WHERE a.ad_Id=? "
                                        + "AND a.ad_Category_Id = c.ad_Category_Id "
                                        + "AND a.ad_Id = l.Ad_Id ";
                        
                        ps = con.prepareStatement(query1);                   
                        ps.setString(1, adId);                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { Ad_AracimVarHostesAriyorum aha = new Ad_AracimVarHostesAriyorum();
                                            aha.setAd_AracimVarHostesAriyorum_Id(rs.getString("Ad_AracimVarHostesAriyorum_Id"));
                                            aha.setAd_AracimVarHostesAriyorum_Cost(rs.getFloat("Ad_AracimVarHostesAriyorum_Cost"));
                                            aha.setAd_AracimVarHostesAriyorum_Experience(rs.getString("Ad_AracimVarHostesAriyorum_Experience"));
                                            aha.setAd_AracimVarHostesAriyorum_school(rs.getString("Ad_AracimVarHostesAriyorum_School"));
                                            aha.setAd_AracimVarHostesAriyorum_schoolType_highSchool(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_highSchool"));
                                            aha.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_kindergarten"));
                                            aha.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(rs.getBoolean("Ad_AracimVarHostesAriyorum_schoolType_primarySchool"));                                           
                                            aha.setAd_AracimVarHostesAriyorum_ForeignLanguage(rs.getString("Ad_AracimVarHostesAriyorum_ForeignLanguages"));
                                            ad.setAdAracimVarHostesAriyorum(aha);
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
