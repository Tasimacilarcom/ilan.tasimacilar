package com.tasimacilar.ilan.ad.plakamiSatiyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_PlakamiSatiyorum_Dao {  public int plakamiSatiyorumIlanOlustur(Ad_PlakamiSatiyorum_Bean ad) { int sonuc = 0;
        Connection con = null;  PreparedStatement ps = null;con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_PlakamiSatiyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");     ps.setString(2, ad.getAdBean().getAd_Id());
                        ps.setInt(3, ad.getAdBean().getAd_Category_Id());
                        ps.setString(4, ad.getAdBean().getAd_Title());
                        ps.setString(5, ad.getAdBean().getAd_Comment());
                        ps.setString(6, ad.getAdBean().getAd_Type());
                        ps.setString(7, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(8, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(9, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(10, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(11, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(12, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(13, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(14, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(15, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(16, ad.getAdBean().getAd_LastChangerAccountId());
                        ps.setString(17, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_Id());
                        ps.setInt(18, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateProvinceCode());
                        ps.setString(19, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateLatterCode());
                        ps.setInt(20, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateNumberCode());
                        ps.setFloat(21, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_ucret());
                        ps.setBoolean(22, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_AraçlaBirliktemi());
                        ps.setBoolean(23, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_YolBelgesiVarmi());
                        ps.setBoolean(24, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_NoterSatislimi());
                        ps.setBoolean(25, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_Hisselimi());
                        ps.setString(26, ad.getAdBean().getAd_Id());                      
                     sonuc = ps.executeUpdate();  
                         if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: plakami satiyorum "
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
    public int plakamiSatiyorumIlanDuzenle(Ad_PlakamiSatiyorum_Bean ad) {   int sonuc = 0;    Connection con = null;  PreparedStatement ps = null; con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_PlakamiSatiyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "update");                             
                        ps.setString(2, ad.getAdBean().getAd_Id());
                        ps.setInt(3, ad.getAdBean().getAd_Category_Id());
                        ps.setString(4, ad.getAdBean().getAd_Title());
                        ps.setString(5, ad.getAdBean().getAd_Comment());
                        ps.setString(6, ad.getAdBean().getAd_Type());
                        ps.setString(7, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(8, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(9, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(10, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(11, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(12, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(13, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(14, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(15, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(16, ad.getAdBean().getAd_LastChangerAccountId());
                        ps.setString(17, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_Id());
                        ps.setInt(18, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateProvinceCode());
                        ps.setString(19, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateLatterCode());
                        ps.setInt(20, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_PlateNumberCode());
                        ps.setFloat(21, ad.getAdPlakamiSatiyorum().getAd_PlakamiSatiyorum_ucret());
                        ps.setBoolean(22, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_AraçlaBirliktemi());
                        ps.setBoolean(23, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_YolBelgesiVarmi());
                        ps.setBoolean(24, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_NoterSatislimi());
                        ps.setBoolean(25, ad.getAdPlakamiSatiyorum().isAd_PlakamiSatiyorum_Hisselimi());
                        ps.setString(26, ad.getAdBean().getAd_Id());                                                                         
                        sonuc = ps.executeUpdate();                         
                        if(sonuc==1){
                            System.out.println("Yeni ilan guncelleme BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan guncellendi. [Kategori: plakami satiyorum "
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
        
        return sonuc; }    public Ad_PlakamiSatiyorum_Bean getPlakamiSatiyorumWithAdId(String adId) {    
        int sonuc = 0; Ad_PlakamiSatiyorum_Bean aps = new Ad_PlakamiSatiyorum_Bean(); Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`ad_plakami_satiyorum` l "
                                        + "WHERE a.ad_Id=? "
                                        + "AND a.ad_Category_Id = c.ad_Category_Id "
                                        + "AND a.ad_Id = l.Ad_Id ";
                        
                        ps = con.prepareStatement(query1);                   
                        ps.setString(1, adId);                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {  Ad_PlakamiSatiyorum pst = new Ad_PlakamiSatiyorum();
                                            pst.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pst.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pst.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pst.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pst.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pst.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pst.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pst.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pst.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            aps.setAdPlakamiSatiyorum(pst);                                        
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
                                            aps.setAdBean(ab);                                   
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
        } return aps; }}
