package com.tasimacilar.ilan.ad.aracimVarSoforAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.Vehicle;
import com.tasimacilar.ilan.vehicle.VehicleBean;
import com.tasimacilar.ilan.vehicle.VehicleDriverAndHostessBean;
import com.tasimacilar.ilan.vehicle.VehicleImages;
import com.tasimacilar.ilan.vehicle.VehicleImagesBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_AracimVarSoforAriyorum_Dao { public int createAracimVarSoforAriyorumAd(Ad_AracimVarSoforAriyorum_Bean ad) { int sonuc = 0;  Connection con = null; PreparedStatement ps = null;con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}     
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarSoforAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");      
                        ps.setString(1, "insert");
                        ps.setString(2, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Id());
                        ps.setFloat(3, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Cost());
                        ps.setString(4, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Experience());
                        ps.setString(5, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ServiceTime());
                        ps.setInt(6, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_NumberOfPassengers());
                        ps.setString(7, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Km());
                        ps.setString(8, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_DayToWork());
                        ps.setString(9, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_PaymentMethod());
                        ps.setString(10, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_vehicle_Id());
                        ps.setString(11, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ServiceType());
                        ps.setString(12, "");
                        ps.setString(13, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ForeignLanguage());
                        ps.setString(14, ad.getAd_AracimVarSoforAriyorum().getVehicleSelection());
                        ps.setString(15, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_BrandId());
                        ps.setString(16, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_Model());
                        ps.setString(17, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_ModelYear());
                        ps.setString(18, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_NumberOfSeats());
                        ps.setString(19, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Id());
                        ps.setInt(20, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Category_Id());
                        ps.setString(21, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Title());
                        ps.setString(22, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Comment());
                        ps.setString(23, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Type());
                        ps.setString(24, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(25, ad.getAd_AracimVarSoforAriyorum().getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(26, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_EndTime().getTime()));
                        ps.setString(27, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Notes());
                        ps.setTimestamp(28, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(29, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreatedIp());
                        ps.setString(30, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreatedAccountId());
                        ps.setString(31, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(32, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(33, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastChangerAccountId());                        
                        sonuc = ps.executeUpdate();                       
                        if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: aracim-var-sofor-ariyorum "
                                                                                                            + "Ad Id:"+ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Id()+"]", "system");
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
    public int updateAracimVarSoforAriyorumAd(Ad_AracimVarSoforAriyorum_Bean ad) {
     
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_AracimVarSoforAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        ps.setString(1, "update");
                        ps.setString(2, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Id());
                        ps.setFloat(3, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Cost());
                        ps.setString(4, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Experience());
                        ps.setString(5, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ServiceTime());
                        ps.setInt(6, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_NumberOfPassengers());
                        ps.setString(7, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Km());
                        ps.setString(8, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_DayToWork());
                        ps.setString(9, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_PaymentMethod());
                        ps.setString(10, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_vehicle_Id()); 
                        ps.setString(11, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ServiceType());
                        ps.setString(12, "");
                        ps.setString(13, ad.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ForeignLanguage());
                        ps.setString(14, ad.getAd_AracimVarSoforAriyorum().getVehicleSelection());
                        ps.setString(15, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_BrandId());
                        ps.setString(16, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_Model());
                        ps.setString(17, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_ModelYear());
                        ps.setString(18, ad.getAd_AracimVarSoforAriyorum().getFast_vehicle_NumberOfSeats());
                        ps.setString(19, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Id());
                        ps.setInt(20, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Category_Id());
                        ps.setString(21, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Title());
                        ps.setString(22, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Comment());
                        ps.setString(23, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Type());
                        ps.setString(24, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(25, ad.getAd_AracimVarSoforAriyorum().getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(26, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_EndTime().getTime()));
                        ps.setString(27, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Notes());
                        ps.setTimestamp(28, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(29, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreatedIp());
                        ps.setString(30, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_CreatedAccountId());
                        ps.setString(31, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(32, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(33, ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_LastChangerAccountId());                   
                        sonuc = ps.executeUpdate();  
                        if(sonuc==1){
                            LogManagerDao.createLog("info", this.getClass().getName(), "İlan güncellendi. [Kategori: aracim-var-sofor-ariyorum "
                                                                                                            + "Ad Id:"+ad.getAd_AracimVarSoforAriyorum().getAdBean().getAd_Id()+"]", "system");
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
    public Ad_AracimVarSoforAriyorum_Bean getAracimVarSoforAriyorumWithAdId(String adId) {
        int sonuc = 0;
        Ad_AracimVarSoforAriyorum_Bean adxx = new Ad_AracimVarSoforAriyorum_Bean();
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
                        String query1 = "SELECT * "
                                      + "FROM `ilan_tasimacilar`.`ad_` a , "
                                           + "`ilan_tasimacilar`.`ad_category` c , "
                                           + "`ilan_tasimacilar`.`ad_aracim_var_sofor_ariyorum` l  " +
                                        "WHERE a.ad_Id=? " +
                                        "AND a.ad_Category_Id = c.ad_Category_Id " +
                                        "AND a.ad_Id = l.Ad_Id ";
                       
                        ps = con.prepareStatement(query1);                   
                        ps.setString(1, adId);                  
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) { Ad_AracimVarSoforAriyorum ad = new Ad_AracimVarSoforAriyorum();
                                            ad.setAd_AracimVarSoforAriyorum_Id(rs.getString("Ad_AracimVarSoforAriyorum_Id"));
                                            ad.setAd_AracimVarSoforAriyorum_vehicle_Id(rs.getString("vehicle_Id"));
                                            ad.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("Ad_AracimVarSoforAriyorum_Cost"));
                                            ad.setAd_AracimVarSoforAriyorum_Experience(rs.getString("Ad_AracimVarSoforAriyorum_Experience"));
                                            ad.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("Ad_AracimVarSoforAriyorum_ServiceTime"));
                                            ad.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("Ad_AracimVarSoforAriyorum_NumberOfPassengers"));
                                            ad.setAd_AracimVarSoforAriyorum_Km(rs.getString("Ad_AracimVarSoforAriyorum_Km"));
                                            ad.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("Ad_AracimVarSoforAriyorum_DayToWork"));
                                            ad.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("Ad_AracimVarSoforAriyorum_PaymentMethod"));                                        
                                            ad.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("fast_vehicle_ServiceTypes"));
                                            if (rs.getString("fast_vehicle_ServiceTypes") != null) {
                                                if(!rs.getString("fast_vehicle_ServiceTypes").equals("") ){
                                                    String serviceTypesxx = rs.getString("fast_vehicle_ServiceTypes").substring(1);
                                                    String[] serviceTypesxxx = serviceTypesxx.split(",");
                                                    ad.setAd_AracimVarSoforAriyorum_ServiceTypes(serviceTypesxxx);
                                                }
                                            }                                     
                                            ad.setAd_AracimVarSoforAriyorum_ForeignLanguage(rs.getString("Ad_AracimVarSoforAriyorum_ForeignLanguages"));
                                            if (rs.getString("Ad_AracimVarSoforAriyorum_ForeignLanguages") != null) {
                                                if(!rs.getString("Ad_AracimVarSoforAriyorum_ForeignLanguages").equals("") ){
                                                    String foreignLanguagesxx = rs.getString("Ad_AracimVarSoforAriyorum_ForeignLanguages").substring(1);
                                                    String[] foreignLanguagesxxx = foreignLanguagesxx.split(",");
                                                    ad.setAd_AracimVarSoforAriyorum_ForeignLanguages(foreignLanguagesxxx);
                                                }
                                            }                                      
                                            ad.setVehicleSelection(rs.getString("vehicleSelection"));
                                            ad.setFast_vehicle_BrandId(rs.getString("fast_vehicle_Brand"));
                                            ad.setFast_vehicle_Model(rs.getString("fast_vehicle_Model"));
                                            ad.setFast_vehicle_ModelYear(rs.getString("fast_vehicle_ModelYear"));
                                            ad.setFast_vehicle_NumberOfSeats(rs.getString("fast_vehicle_NumberOfSeats"));
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
                                            adxx.setAd_AracimVarSoforAriyorum(ad);
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
        return adxx;
    }}
