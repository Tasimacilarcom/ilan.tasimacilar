
package com.tasimacilar.ilan.vehicle;

import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class VehicleImagesDao {

    public int createVehicleImages(VehicleImages vehicleImages) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleImages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");               
                        ps.setString(2, vehicleImages.getVehicleImage_Id());
                        ps.setString(3, vehicleImages.getVehicleImage_ProfilePhotoUrl());
                        ps.setBoolean(4, vehicleImages.isVehicleImage_ProfilePhotoPublish());
                        ps.setString(5, vehicleImages.getVehicleImage_GalleryPtoho_1_Url());
                        ps.setString(6, vehicleImages.getVehicleImage_GalleryPtoho_2_Url());
                        ps.setString(7, vehicleImages.getVehicleImage_GalleryPtoho_3_Url());
                        ps.setString(8, vehicleImages.getVehicleImage_GalleryPtoho_4_Url());
                        ps.setString(9, vehicleImages.getVehicleImage_GalleryPtoho_5_Url());
                        ps.setString(10, vehicleImages.getVehicleImage_GalleryPtoho_6_Url());
                        ps.setString(11, vehicleImages.getVehicleImage_GalleryPtoho_7_Url());
                        ps.setString(12, vehicleImages.getVehicleImage_GalleryPtoho_8_Url());
                        ps.setString(13, vehicleImages.getVehicleImage_GalleryPtoho_9_Url());
                        ps.setString(14, vehicleImages.getVehicleImage_GalleryPtoho_10_Url());
                        ps.setString(15, vehicleImages.getVehicleImage_Commnet());
                        ps.setTimestamp(16, new java.sql.Timestamp(vehicleImages.getVehicleImage_Modified().getTime()));   
                        ps.setString(17, vehicleImages.getVehicleImage_Modifier());
                        ps.setTimestamp(18, new java.sql.Timestamp(vehicleImages.getVehicleImage_Created().getTime())); 
                        ps.setString(19, vehicleImages.getVehicleImage_creator());
                        ps.setString(20, vehicleImages.getVehicle_Id());
                        ps.setString(21, vehicleImages.getVehicleVideoUrl());
                        sonuc = ps.executeUpdate();  
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni araç görselleri eklendi. [Araç Gorsel Id:"+vehicleImages.getVehicleImage_Id()+"]", "system");
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
     public int updateVehicleImages(VehicleImages vehicleImages) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleImages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "update");               
                        ps.setString(2, vehicleImages.getVehicleImage_Id());
                        ps.setString(3, vehicleImages.getVehicleImage_ProfilePhotoUrl());
                        ps.setBoolean(4, vehicleImages.isVehicleImage_ProfilePhotoPublish());
                        ps.setString(5, vehicleImages.getVehicleImage_GalleryPtoho_1_Url());
                        ps.setString(6, vehicleImages.getVehicleImage_GalleryPtoho_2_Url());
                        ps.setString(7, vehicleImages.getVehicleImage_GalleryPtoho_3_Url());
                        ps.setString(8, vehicleImages.getVehicleImage_GalleryPtoho_4_Url());
                        ps.setString(9, vehicleImages.getVehicleImage_GalleryPtoho_5_Url());
                        ps.setString(10, vehicleImages.getVehicleImage_GalleryPtoho_6_Url());
                        ps.setString(11, vehicleImages.getVehicleImage_GalleryPtoho_7_Url());
                        ps.setString(12, vehicleImages.getVehicleImage_GalleryPtoho_8_Url());
                        ps.setString(13, vehicleImages.getVehicleImage_GalleryPtoho_9_Url());
                        ps.setString(14, vehicleImages.getVehicleImage_GalleryPtoho_10_Url());
                        ps.setString(15, vehicleImages.getVehicleImage_Commnet());
                        ps.setTimestamp(16, new java.sql.Timestamp(vehicleImages.getVehicleImage_Modified().getTime()));   
                        ps.setString(17, vehicleImages.getVehicleImage_Modifier());
                        ps.setTimestamp(18, new java.sql.Timestamp(vehicleImages.getVehicleImage_Created().getTime())); 
                        ps.setString(19, vehicleImages.getVehicleImage_creator());
                        ps.setString(20, vehicleImages.getVehicle_Id());
                        ps.setString(21, vehicleImages.getVehicleVideoUrl());
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){
                            System.out.println("Araç resmi guncelleme BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Araç görselleri guncellendi. [Araç Gorsel Id:"+vehicleImages.getVehicleImage_Id()+"]", "system");
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
    public VehicleImages getvehicleImagesWithVehicleId(String VehicleId) {
        
        int sonuc = 0;
       VehicleImages vi = new VehicleImages();
        
        
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
                        ps = con.prepareCall("{call pro_vehicleImages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");              
                        ps.setString(1, "getAllWithVehicleId");               
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setBoolean(4, false);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setString(10, null);
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setTimestamp(16, null);   
                        ps.setString(17, null);
                        ps.setTimestamp(18, null); 
                        ps.setString(19, null);
                        ps.setString(20, VehicleId);
                        ps.setString(21, null);
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { 
                                            vi.setVehicleImage_Id(rs.getString("vehicleImage_Id"));
                                            vi.setVehicleImage_ProfilePhotoUrl(rs.getString("vehicleImage_ProfilePhotoUrl"));
                                            vi.setVehicleImage_ProfilePhotoPublish(rs.getBoolean("vehicleImage_ProfilePhotoPublish"));
                                            vi.setVehicleImage_GalleryPtoho_1_Url(rs.getString("vehicleImage_GalleryPtoho_1_Url"));
                                            vi.setVehicleImage_GalleryPtoho_2_Url(rs.getString("vehicleImage_GalleryPtoho_2_Url"));
                                            vi.setVehicleImage_GalleryPtoho_3_Url(rs.getString("vehicleImage_GalleryPtoho_3_Url"));
                                            vi.setVehicleImage_GalleryPtoho_4_Url(rs.getString("vehicleImage_GalleryPtoho_4_Url"));
                                            vi.setVehicleImage_GalleryPtoho_5_Url(rs.getString("vehicleImage_GalleryPtoho_5_Url"));
                                            vi.setVehicleImage_GalleryPtoho_6_Url(rs.getString("vehicleImage_GalleryPtoho_6_Url"));
                                            vi.setVehicleImage_GalleryPtoho_7_Url(rs.getString("vehicleImage_GalleryPtoho_7_Url"));
                                            vi.setVehicleImage_GalleryPtoho_8_Url(rs.getString("vehicleImage_GalleryPtoho_8_Url"));
                                            vi.setVehicleImage_GalleryPtoho_9_Url(rs.getString("vehicleImage_GalleryPtoho_9_Url"));
                                            vi.setVehicleImage_GalleryPtoho_10_Url(rs.getString("vehicleImage_GalleryPtoho_10_Url"));
                                            vi.setVehicleImage_Commnet(rs.getString("vehicleImage_Commnet"));
                                            vi.setVehicleImage_Modified(rs.getTimestamp("vehicleImage_Modified"));
                                            vi.setVehicleImage_Modifier(rs.getString("vehicleImage_Modifier"));
                                            vi.setVehicleImage_Created(rs.getTimestamp("vehicleImage_Created"));
                                            vi.setVehicleImage_creator(rs.getString("vehicleImage_creator"));
                                            vi.setVehicle_Id(rs.getString("vehicle_Id"));
                                            vi.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
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
        
        return vi;
    }
    
    
    
    
    
}
