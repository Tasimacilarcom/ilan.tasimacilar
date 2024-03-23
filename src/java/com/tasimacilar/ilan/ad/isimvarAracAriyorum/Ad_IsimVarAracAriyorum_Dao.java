package com.tasimacilar.ilan.ad.isimvarAracAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.Vehicle;
import com.tasimacilar.ilan.vehicle.VehicleBean;
import com.tasimacilar.ilan.vehicle.VehicleBrandAndModelDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_IsimVarAracAriyorum_Dao {  public int createLookingForVehicleForWorkAd(Ad_IsimVarAracAriyorum_Bean ad) { int sonuc = 0;
        Connection con = null;   PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_LookingForVehicleForWork(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Id());
                        ps.setString(3, ad.getVehicle().getVehicle_Typ());
                        ps.setString(4, ad.getVehicle().getVehicle_Brand());
                        ps.setBoolean(5, ad.getVehicle().isVehicle_BrandNotMatter());
                        ps.setString(6, ad.getVehicle().getVehicle_Model());
                        ps.setInt(7, Integer.parseInt(ad.getVehicle().getVehicle_ModelYear()));
                        ps.setBoolean(8, ad.getVehicle().isVehicle_ModelYearAndOver());
                        ps.setBoolean(9, ad.getVehicle().isVehicle_ModelYearNotMatter());
                        ps.setString(10, ad.getVehicle().getVehicle_NumberOfSeats());
                        ps.setFloat(11, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Cost());
                        ps.setString(12, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Experience());
                        ps.setString(13, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceTime());
                        ps.setString(14, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_NumberOfPassengers());
                        ps.setString(15, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Km());
                        ps.setString(16, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_DayToWork());
                        ps.setString(17, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_PaymentMethod());
                        ps.setString(18, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceType());
                        ps.setString(19, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_RequestedDocument());
                        ps.setString(20, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ForeignLanguage());
                        ps.setString(21, ad.getAdBean().getAd_Id());
                        ps.setInt(22, ad.getAdBean().getAd_Category_Id());
                        ps.setString(23, ad.getAdBean().getAd_Title());
                        ps.setString(24, ad.getAdBean().getAd_Comment());
                        ps.setString(25, ad.getAdBean().getAd_Type());
                        ps.setString(26, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(27, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(28, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(29, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(30, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(31, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(32, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(33, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(34, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(35, ad.getAdBean().getAd_LastChangerAccountId());                             
                        sonuc = ps.executeUpdate();                         
                        if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: personal-isim_var_arac_ariyorum "
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
        
        return sonuc;  }  public int updateLookingForVehicleForWorkAd(Ad_IsimVarAracAriyorum_Bean ad) {   int sonuc = 0;   Connection con = null;   PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_LookingForVehicleForWork(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        ps.setString(1, "update");
                        ps.setString(2, null);
                        ps.setString(3, ad.getVehicle().getVehicle_Typ());
                        ps.setString(4, ad.getVehicle().getVehicle_Brand());                       
                        boolean BrandNotMatter = false;
                        if(ad.getVehicle().getVehicle_Brand().contains(",0")){ BrandNotMatter = true;}
                        ps.setBoolean(5, BrandNotMatter);
                        ps.setString(6, ad.getVehicle().getVehicle_Model());
                        ps.setInt(7, Integer.parseInt(ad.getVehicle().getVehicle_ModelYear()));
                        ps.setBoolean(8, ad.getVehicle().isVehicle_ModelYearAndOver());
                        ps.setBoolean(9, ad.getVehicle().isVehicle_ModelYearNotMatter());
                        ps.setString(10, ad.getVehicle().getVehicle_NumberOfSeats());
                        ps.setFloat(11, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Cost());
                        ps.setString(12, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Experience());
                        ps.setString(13, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceTime());
                        ps.setString(14, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_NumberOfPassengers());
                        ps.setString(15, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Km());
                        ps.setString(16, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_DayToWork());
                        ps.setString(17, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_PaymentMethod());
                        ps.setString(18, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceType()); 
                        ps.setString(19, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_RequestedDocument());
                        ps.setString(20, ad.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ForeignLanguage());
                        ps.setString(21, ad.getAdBean().getAd_Id());
                        ps.setInt(22, ad.getAdBean().getAd_Category_Id());
                        ps.setString(23, ad.getAdBean().getAd_Title());
                        ps.setString(24, ad.getAdBean().getAd_Comment());
                        ps.setString(25, ad.getAdBean().getAd_Type());
                        ps.setString(26, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(27, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(28, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(29, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(30, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(31, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(32, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(33, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(34, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(35, ad.getAdBean().getAd_LastChangerAccountId());
                        sonuc = ps.executeUpdate();   
                        if(sonuc==1){
                            System.out.println("İlan Güncelleme Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: personal-isim_var_arac_ariyorum "
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
        
        return sonuc; } public Ad_IsimVarAracAriyorum_Bean getLookingForVehicleForWorkAdWithAdId(String adId) {   int sonuc = 0;  Ad_IsimVarAracAriyorum_Bean ad = new Ad_IsimVarAracAriyorum_Bean();     
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`ad_lookingforvehicleforwork` l "
                                        + "WHERE a.ad_Id=? "
                                        + "AND a.ad_Category_Id = c.ad_Category_Id "
                                        + "AND a.ad_Id = l.Ad_Id ";
                        
                        ps = con.prepareStatement(query1);                   
                        ps.setString(1, adId);                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { Ad_IsimVarAracAriyorum adx = new Ad_IsimVarAracAriyorum();
                                            adx.setAd_LookingForVehicleForWork_Id(rs.getString("Ad_LookingForVehicleForWork_Id"));
                                            adx.setAd_LookingForVehicleForWork_Cost(rs.getFloat("Ad_LookingForVehicleForWork_Cost"));
                                            adx.setAd_LookingForVehicleForWork_Experience(rs.getString("Ad_LookingForVehicleForWork_Experience"));
                                            adx.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("Ad_LookingForVehicleForWork_ServiceTime"));
                                            adx.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("Ad_LookingForVehicleForWork_NumberOfPassengers"));
                                            adx.setAd_LookingForVehicleForWork_Km(rs.getString("Ad_LookingForVehicleForWork_Km"));
                                            adx.setAd_LookingForVehicleForWork_DayToWork(rs.getString("Ad_LookingForVehicleForWork_DayToWork"));
                                            adx.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("Ad_LookingForVehicleForWork_PaymentMethod"));
                                            adx.setAd_LookingForVehicleForWork_ServiceType(rs.getString("Ad_LookingForVehicleForWork_ServiceTypes"));
                                            ad.setAdIsimVarAracAriyorum(adx);                                            
                                            Vehicle vb = new Vehicle();
                                            vb.setVehicle_Typ(rs.getString("Ad_LookingForVehicleForWork_VehicleType"));                                      
                                            if(rs.getString("Ad_LookingForVehicleForWork_VehicleBrand") != null){
                                                if(!rs.getString("Ad_LookingForVehicleForWork_VehicleBrand").equals("")){ 
                                                    String VehicleBrand = rs.getString("Ad_LookingForVehicleForWork_VehicleBrand");
                                                    VehicleBrand = VehicleBrand.substring(1);
                                                    String[] vbs = VehicleBrand.split(",");      
                                                    vb.setVehicle_Brands(vbs);
                                                    VehicleBrandAndModelDao vbxx = new VehicleBrandAndModelDao();         
                                                    String vbx = ""; 
                                                    for (String x : vbs) {
                                                        if(x != null && !x.equals("0")){ if(!x.equals("")){ vbx = vbx+", "+vbxx.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();   }   }
                                                        else{vbx=", 0";}    
                                                    }
                                                    vbx = vbx.substring(1); 
                                                    vb.setVehicle_Brand(vbx);
                                                }
                                            }
                                            else{vb.setVehicle_Brand("");}                                          
                                            vb.setVehicle_BrandNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleBrandNotMatter"));
                                            vb.setVehicle_Model(rs.getString("Ad_LookingForVehicleForWork_VehicleModel"));
                                            vb.setVehicle_ModelYear(String.valueOf(rs.getInt("Ad_LookingForVehicleForWork_VehicleYear")));
                                            vb.setVehicle_ModelYearAndOver(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearAndOver"));
                                            vb.setVehicle_ModelYearNotMatter(rs.getBoolean("Ad_LookingForVehicleForWork_VehicleYearNotMatter"));
                                            vb.setVehicle_NumberOfSeats(rs.getString("Ad_LookingForVehicleForWork_VehicleCapacity"));
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
                                            ad.setVehicle(vb);
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
    }}
