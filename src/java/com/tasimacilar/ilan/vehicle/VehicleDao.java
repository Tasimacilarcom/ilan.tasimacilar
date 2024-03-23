
package com.tasimacilar.ilan.vehicle;


import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VehicleDao { 
    public int createVehicle(Vehicle vehicle) {
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");
                        ps.setString(2, vehicle.getVehicle_Id());
                        ps.setInt(3, vehicle.getVehicle_PlateProvinceCode());
                        ps.setString(4, vehicle.getVehicle_PlateLatterCode());
                        ps.setInt(5, vehicle.getVehicle_PlateNumberCode());
                        ps.setBoolean(6, vehicle.getVehicle_PlateLicense());
                        ps.setString(7, vehicle.getVehicle_Brand());
                        ps.setString(8, vehicle.getVehicle_Model());
                        ps.setString(9, vehicle.getVehicle_ModelYear());
                        ps.setString(10, vehicle.getVehicle_NumberOfSeats());
                        ps.setInt(11, vehicle.getVehicle_Km());
                        ps.setString(12, vehicle.getVehicle_Color());
                        ps.setString(13, vehicle.getVehicle_OvnerAccountId());
                        ps.setBoolean(14, vehicle.isVehicle_IsActive());
                        ps.setString(15, vehicle.getVehicle_Commnet());
                        ps.setTimestamp(16, new java.sql.Timestamp(vehicle.getVehicle_Modified().getTime()));      
                        ps.setString(17, vehicle.getVehicle_Modifier());
                        ps.setTimestamp(18, new java.sql.Timestamp(vehicle.getVehicle_Created().getTime()));   
                        ps.setString(19, vehicle.getVehicle_creator());
                        ps.setString(20, vehicle.getVehicle_ServiceTypes());
                        ps.setString(21, vehicle.getVehicle_AuthorityDocuments());
                        ps.setString(22, vehicle.getVehicle_VehicleProperties());
                        ps.setBoolean(23, vehicle.getVehicle_CompanyLogo());
                        ps.setString(24, vehicle.getVehicle_CompanyLogoText());
                        ps.setString(25, vehicle.getVehicle_DriverInfo());
                        ps.setString(26, vehicle.getVehicle_HostessInfo());
                        
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc==1){
                            System.out.println("Yeni araç Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni araç olusturuldu. [Araç Id:"+vehicle.getVehicle_Id()+"]", "system");
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
    } public int updateVehicle(Vehicle vehicle) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "update");
                        ps.setString(2, vehicle.getVehicle_Id());
                        ps.setInt(3, vehicle.getVehicle_PlateProvinceCode());
                        ps.setString(4, vehicle.getVehicle_PlateLatterCode());
                        ps.setInt(5, vehicle.getVehicle_PlateNumberCode());
                        ps.setBoolean(6, vehicle.getVehicle_PlateLicense());
                        ps.setString(7, vehicle.getVehicle_Brand());
                        ps.setString(8, vehicle.getVehicle_Model());
                        ps.setString(9, vehicle.getVehicle_ModelYear());
                        ps.setString(10, vehicle.getVehicle_NumberOfSeats());
                        ps.setInt(11, vehicle.getVehicle_Km());
                        ps.setString(12, vehicle.getVehicle_Color());
                        ps.setString(13, vehicle.getVehicle_OvnerAccountId());
                        ps.setBoolean(14, vehicle.isVehicle_IsActive());
                        ps.setString(15, vehicle.getVehicle_Commnet());
                        ps.setTimestamp(16, new java.sql.Timestamp(vehicle.getVehicle_Modified().getTime()));      
                        ps.setString(17, vehicle.getVehicle_Modifier());
                        ps.setTimestamp(18, null);   
                        ps.setString(19, vehicle.getVehicle_creator());
                        ps.setString(20, vehicle.getVehicle_ServiceTypes());
                        ps.setString(21, vehicle.getVehicle_AuthorityDocuments());
                        ps.setString(22, vehicle.getVehicle_VehicleProperties());
                        ps.setBoolean(23, vehicle.getVehicle_CompanyLogo());
                        ps.setString(24, vehicle.getVehicle_CompanyLogoText());
                        ps.setString(25, vehicle.getVehicle_DriverInfo());
                        ps.setString(26, vehicle.getVehicle_HostessInfo());
                        
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc ==1){
                            LogManagerDao.createLog("info", this.getClass().getName(), "Araç güncellendi. [Araç Id:"+vehicle.getVehicle_Id()+"]", "system");
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
    } public VehicleBean getVehicleWithAdId(String vehicleId) {
        
        int sonuc = 0;
        VehicleBean vb = new VehicleBean();
        
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
                        
                        ps = con.prepareCall("{call pro_vehicleFull_getAll(?,?)}");                  
                        ps.setString(1, "getAllWithId");
                        ps.setString(2, vehicleId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { Vehicle v = new Vehicle();
                                            v.setVehicle_Id(rs.getString("vehicle_Id"));
                                            v.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            v.setVehicle_PlateProvinceCode2(rs.getInt("vehicle_PlateProvinceCode"));
                                            v.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            v.setVehicle_PlateLatterCode2(rs.getString("vehicle_PlateLatterCode"));
                                            v.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            v.setVehicle_PlateNumberCode2(rs.getInt("vehicle_PlateNumberCode"));
                                            v.setVehicle_PlateLicense(rs.getBoolean("vehicle_PlateLicense"));
                                            v.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            v.setVehicle_BrandId(rs.getString("vehicle_Brand"));
                                            v.setVehicle_Model(rs.getString("vehicle_Model"));
                                            v.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            v.setVehicle_NumberOfSeats(rs.getString("vehicle_NumberOfSeats"));
                                            v.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            v.setVehicle_Color(rs.getString("vehicle_Color"));
                                            v.setVehicle_OvnerAccountId(rs.getString("vehicle_OvnerAccountId"));
                                            v.setVehicle_IsActive(rs.getBoolean("vehicle_IsActive"));
                                            v.setVehicle_Commnet(rs.getString("vehicle_Commnet"));
                                            v.setVehicle_Modified(rs.getTimestamp("vehicle_Modified"));
                                            v.setVehicle_Modifier(rs.getString("vehicle_Modifier"));
                                            v.setVehicle_Created(rs.getTimestamp("vehicle_Created"));
                                            v.setVehicle_creator(rs.getString("vehicle_creator"));
                                            v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                            v.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            v.setVehicle_DriverInfo(rs.getString("vehicle_DriverInfo"));
                                            v.setVehicle_HostessInfo(rs.getString("vehicle_HostessInfo"));
                                           
                                            v.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            if (rs.getString("vehicle_ServiceTypes") != null) {
                                                if(!rs.getString("vehicle_ServiceTypes").equals("") ){
                                                    String vehicle_ServiceTypesxx = rs.getString("vehicle_ServiceTypes").substring(1);
                                                    String[] vehicle_ServiceTypesxxx = vehicle_ServiceTypesxx.split(",");
                                                    v.setVehicle_ServiceTypesList(vehicle_ServiceTypesxxx);
                                                }
                                            }v.setVehicle_AuthorityDocuments(rs.getString("vehicle_AuthorityDocuments"));
                                            if (rs.getString("vehicle_AuthorityDocuments") != null) {
                                                if(!rs.getString("vehicle_AuthorityDocuments").equals("")){
                                                    String vehicle_AuthorityDocumentsxx = rs.getString("vehicle_AuthorityDocuments").substring(1);
                                                    String[] vehicle_AuthorityDocumentsxxx = vehicle_AuthorityDocumentsxx.split(",");
                                                    v.setVehicle_AuthorityDocumentsList(vehicle_AuthorityDocumentsxxx);
                                                } 
                                            }v.setVehicle_VehicleProperties(rs.getString("vehicle_VehicleProperties"));
                                            if (rs.getString("vehicle_VehicleProperties") != null) {
                                                if(!rs.getString("vehicle_VehicleProperties").equals("")){
                                                    String vehicle_VehiclePropertiesxx = rs.getString("vehicle_VehicleProperties").substring(1);
                                                    String[] vehicle_VehiclePropertiesxxx = vehicle_VehiclePropertiesxx.split(",");
                                                    v.setVehicle_VehiclePropertiesList(vehicle_VehiclePropertiesxxx);
                                                } 
                                            }v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                            VehicleImages vi = new VehicleImages();
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
                                            vi.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            
                                            
                                            v.setVehicleImages(vi);
                                            
                                            vb.setVehicle(v);
                                          
                                            
                                           
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
        
        return vb;
    } public List<Vehicle> getVehiclesWithvehicleOvnerAccountId(String vehicleOvnerAccountId) { 
        
        int sonuc = 0;
        List<Vehicle> vList = new ArrayList<Vehicle>();
        
        
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
                        
                        ps = ps = con.prepareCall("{call pro_vehicleFull_getAll(?,?)}");                  
                        ps.setString(1, "getAllWithOvnerAccountId");
                        ps.setString(2, vehicleOvnerAccountId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {  Vehicle v = new Vehicle();
                                            v.setVehicle_Id(rs.getString("vehicle_Id"));
                                            v.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            v.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode").toUpperCase());
                                            v.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            v.setVehicle_PlateLicense(rs.getBoolean("vehicle_PlateLicense"));
                                            v.setVehicle_BrandId(rs.getString("vehicle_Brand"));
                                            v.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            v.setVehicle_Model(rs.getString("vehicle_Model"));
                                            v.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            v.setVehicle_NumberOfSeats(rs.getString("vehicle_NumberOfSeats"));
                                            v.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            v.setVehicle_Color(rs.getString("vehicle_Color"));
                                            v.setVehicle_OvnerAccountId(rs.getString("vehicle_OvnerAccountId"));
                                            v.setVehicle_IsActive(rs.getBoolean("vehicle_IsActive"));
                                            v.setVehicle_Commnet(rs.getString("vehicle_Commnet"));
                                            v.setVehicle_Modified(rs.getTimestamp("vehicle_Modified"));
                                            v.setVehicle_Modifier(rs.getString("vehicle_Modifier"));
                                            v.setVehicle_Created(rs.getTimestamp("vehicle_Created"));
                                            v.setVehicle_creator(rs.getString("vehicle_creator"));
                                            v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                            v.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            v.setVehicle_DriverInfo(rs.getString("vehicle_DriverInfo"));
                                            v.setVehicle_HostessInfo(rs.getString("vehicle_HostessInfo"));
                                            
                                            v.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            if (rs.getString("vehicle_ServiceTypes") != null) {
                                                if(!rs.getString("vehicle_ServiceTypes").equals("")){
                                                String vehicle_ServiceTypesxx = rs.getString("vehicle_ServiceTypes").substring(1);
                                                String[] vehicle_ServiceTypesxxx = vehicle_ServiceTypesxx.split(",");
                                                 v.setVehicle_ServiceTypesList(vehicle_ServiceTypesxxx);
                                                }
                                            } v.setVehicle_AuthorityDocuments(rs.getString("vehicle_AuthorityDocuments"));
                                            if (rs.getString("vehicle_AuthorityDocuments") != null) {
                                                if(!rs.getString("vehicle_AuthorityDocuments").equals("")){
                                                String vehicle_AuthorityDocumentsxx = rs.getString("vehicle_AuthorityDocuments").substring(1);
                                                String[] vehicle_AuthorityDocumentsxxx = vehicle_AuthorityDocumentsxx.split(",");
                                                 v.setVehicle_AuthorityDocumentsList(vehicle_AuthorityDocumentsxxx);
                                                 }
                                            }v.setVehicle_VehicleProperties(rs.getString("vehicle_VehicleProperties"));
                                            if (rs.getString("vehicle_VehicleProperties") != null) {
                                                if (!rs.getString("vehicle_VehicleProperties").equals("")) {
                                                   String vehicle_VehiclePropertiesxx = rs.getString("vehicle_VehicleProperties").substring(1);
                                                String[] vehicle_VehiclePropertiesxxx = vehicle_VehiclePropertiesxx.split(",");
                                                 v.setVehicle_VehiclePropertiesList(vehicle_VehiclePropertiesxxx); 
                                                }
                                            }
                                            v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                             VehicleImages vi = new VehicleImages();
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
                                            vi.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            
                                            v.setVehicleImages(vi);
                                            vList.add(v);
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
        
        return vList;
    } public List<VehicleBean> getAllVehicle() {
        
        int sonuc = 0;
        List<VehicleBean> vl = new ArrayList<VehicleBean>();
        
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
                        
                        ps = ps = con.prepareCall("{call pro_vehicleFull_getAll(?,?)}");                  
                        ps.setString(1, "getAll");
                        ps.setString(2, null);   
                        ResultSet rs = ps.executeQuery();  

                        while (rs.next()) { VehicleBean vb = new VehicleBean(); 
                                            AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            Vehicle v = new Vehicle();
                                            v.setVehicle_Id(rs.getString("vehicle_Id"));
                                            v.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            v.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            v.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            v.setVehicle_PlateLicense(rs.getBoolean("vehicle_PlateLicense"));
                                            v.setVehicle_BrandId(rs.getString("vehicle_Brand"));
                                            v.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            v.setVehicle_Model(rs.getString("vehicle_Model"));
                                            v.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            v.setVehicle_NumberOfSeats(rs.getString("vehicle_NumberOfSeats"));
                                            v.setVehicle_OvnerAccountId(rs.getString("vehicle_OvnerAccountId"));
                                            v.setVehicle_IsActive(rs.getBoolean("vehicle_IsActive"));
                                            v.setVehicle_Modified(rs.getTimestamp("vehicle_Modified"));
                                            v.setVehicle_Modifier(rs.getString("vehicle_Modifier"));
                                            v.setVehicle_Created(rs.getTimestamp("vehicle_Created"));
                                            v.setVehicle_creator(rs.getString("vehicle_creator"));
                                            v.setVehicle_DriverInfo(rs.getString("vehicle_DriverInfo"));
                                            v.setVehicle_HostessInfo(rs.getString("vehicle_HostessInfo"));
                                           
                                            v.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            if (rs.getString("vehicle_ServiceTypes") != null) {
                                                String vehicle_ServiceTypesxx = rs.getString("vehicle_ServiceTypes").substring(1);
                                                String[] vehicle_ServiceTypesxxx = vehicle_ServiceTypesxx.split(",");
                                                 v.setVehicle_ServiceTypesList(vehicle_ServiceTypesxxx);
                                            }
                                                  
                                            v.setVehicle_VehicleProperties(rs.getString("vehicle_VehicleProperties"));
                                            if (rs.getString("vehicle_VehicleProperties") != null && rs.getString("vehicle_VehicleProperties").length() > 2) {
                                                String vehicle_VehiclePropertiesxx = rs.getString("vehicle_VehicleProperties").substring(1);
                                                String[] vehicle_VehiclePropertiesxxx = vehicle_VehiclePropertiesxx.split(",");
                                                v.setVehicle_VehiclePropertiesList(vehicle_VehiclePropertiesxxx);
                                            }
                                            
                                            v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                             /* 19 images*/
                                            VehicleImages vi = new VehicleImages();
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
                                            vi.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            vb.setVehicle(v);
                                           VehicleImagesBean vib = new VehicleImagesBean();
                                            vib.setVehicleImages(vi);
                                            vb.setVehicle(v);
                                            vb.setVehicleImagesBean(vib);
                                            vb.setAccountBean(ac);
                                            vl.add(vb);
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
        
        return vl;
    }public List<VehicleBean> getUserVehicle(String ownerId) {
        
        int sonuc = 0;
        List<VehicleBean> vl = new ArrayList<VehicleBean>();
        
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
                        
                        ps = ps = con.prepareCall("{call pro_vehicleFull_getAll(?,?)}");                  
                        ps.setString(1, "getAll2");
                        ps.setString(2, ownerId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { VehicleBean vb = new VehicleBean(); 
                                            AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            Vehicle v = new Vehicle();
                                            v.setVehicle_Id(rs.getString("vehicle_Id"));
                                            v.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            v.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            v.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            v.setVehicle_PlateLicense(rs.getBoolean("vehicle_PlateLicense"));
                                            v.setVehicle_BrandId(rs.getString("vehicle_Brand"));
                                            v.setVehicle_Brand(rs.getString("VehicleBrand_Name"));
                                            v.setVehicle_Model(rs.getString("vehicle_Model"));
                                            v.setVehicle_ModelYear(rs.getString("vehicle_ModelYear"));
                                            v.setVehicle_NumberOfSeats(rs.getString("vehicle_NumberOfSeats"));
                                            v.setVehicle_Km(rs.getInt("vehicle_Km"));
                                            v.setVehicle_Color(rs.getString("vehicle_Color"));
                                            v.setVehicle_OvnerAccountId(rs.getString("vehicle_OvnerAccountId"));
                                            v.setVehicle_IsActive(rs.getBoolean("vehicle_IsActive"));
                                            v.setVehicle_Commnet(rs.getString("vehicle_Commnet"));
                                            v.setVehicle_Modified(rs.getTimestamp("vehicle_Modified"));
                                            v.setVehicle_Modifier(rs.getString("vehicle_Modifier"));
                                            v.setVehicle_Created(rs.getTimestamp("vehicle_Created"));
                                            v.setVehicle_creator(rs.getString("vehicle_creator"));
                                            v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                            v.setVehicle_CompanyLogoText(rs.getString("vehicle_CompanyLogoText"));
                                            v.setVehicle_DriverInfo(rs.getString("vehicle_DriverInfo"));
                                            v.setVehicle_HostessInfo(rs.getString("vehicle_HostessInfo"));
                                           v.setVehicle_ServiceTypes(rs.getString("vehicle_ServiceTypes"));
                                            if (rs.getString("vehicle_ServiceTypes") != null) {
                                                String vehicle_ServiceTypesxx = rs.getString("vehicle_ServiceTypes").substring(1);
                                                String[] vehicle_ServiceTypesxxx = vehicle_ServiceTypesxx.split(",");
                                                 v.setVehicle_ServiceTypesList(vehicle_ServiceTypesxxx);
                                            }v.setVehicle_VehicleProperties(rs.getString("vehicle_VehicleProperties"));
                                            if (rs.getString("vehicle_VehicleProperties") != null) {
                                                String vehicle_VehiclePropertiesxx = rs.getString("vehicle_VehicleProperties").substring(1);
                                                String[] vehicle_VehiclePropertiesxxx = vehicle_VehiclePropertiesxx.split(",");
                                                 v.setVehicle_VehiclePropertiesList(vehicle_VehiclePropertiesxxx);
                                            }v.setVehicle_CompanyLogo(rs.getBoolean("vehicle_CompanyLogo"));
                                             VehicleImages vi = new VehicleImages();
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
                                            vi.setVehicleVideoUrl(rs.getString("vehicleVideoUrl"));
                                            vb.setVehicle(v);
                                            VehicleImagesBean vib = new VehicleImagesBean();
                                            vib.setVehicleImages(vi);
                                            
                                            vb.setVehicle(v);
                                            vb.setVehicleImagesBean(vib);
                                            
                                            
                                            vb.setAccountBean(ac);
                                            vl.add(vb);
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
        
        return vl;
    }public int enableDisableVehicle(String param, String vId) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
        
        if(param != null && !param.equals("") && vId != null && !vId.equals("")){
        
        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        
                        if(param.equals("disable")){ps.setString(1, "disable");}
                        if(param.equals("enable")){ps.setString(1, "enable");}
                        ps.setString(2, vId);
                        ps.setInt(3, 0);
                        ps.setString(4, null);
                        ps.setInt(5, 0);
                        ps.setBoolean(6, false);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setString(10, null);
                        ps.setInt(11, 0);
                        ps.setString(12, null);
                        ps.setString(13, null);
                        ps.setBoolean(14, false);
                        ps.setString(15, null);
                        ps.setTimestamp(16, null);      
                        ps.setString(17, SessionUtil.getUserId());
                        ps.setTimestamp(18, null);   
                        ps.setString(19, null);
                        ps.setString(20, null);
                        ps.setString(21, null);
                        ps.setString(22, null);
                        ps.setBoolean(23, false);
                        ps.setString(24, null);
                        ps.setString(25, null);
                        ps.setString(26, null);
                        
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc==1){ LogManagerDao.createLog("info", this.getClass().getName(), "Araç enable/disable edildi. [Araç Id:"+vId+"]", "system");
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
        }
        else {System.err.println(":::HATA:::Param veya komut null geldi");}
        return sonuc;
    } public static boolean isExistvehiclePlate(int provinceCode, String latterCode, int numberCode){
   
        String dbId = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", VehicleDao.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+VehicleDao.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT vehicle_Id "
                                      + "FROM  ilan_tasimacilar.vehicle_ "
                                      + "WHERE vehicle_PlateProvinceCode LIKE ? "
                                      + "AND vehicle_PlateLatterCode LIKE ? "
                                      + "AND vehicle_PlateNumberCode LIKE ? "
                                      + "AND vehicle_IsActive = 1";

                        ps = con.prepareStatement(query1);
                        ps.setInt(1, provinceCode);
                        ps.setString(2, latterCode);
                        ps.setInt(3, numberCode);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbId = rs.getString("vehicle_Id"); }
                                            if (dbId==null) {exist=false;} else{exist=true;}
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+VehicleDao.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+VehicleDao.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+VehicleDao.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return exist;
    }public static boolean isExistvehiclePlateForUser(int provinceCode, String latterCode, int numberCode, String userId){
   
        String dbId = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", VehicleDao.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+VehicleDao.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT vehicle_Id "
                                      + "FROM  ilan_tasimacilar.vehicle_ "
                                      + "WHERE vehicle_PlateProvinceCode LIKE ? "
                                      + "AND vehicle_PlateLatterCode LIKE ? "
                                      + "AND vehicle_PlateNumberCode LIKE ? "
                                      + "AND vehicle_OvnerAccountId LIKE ? "
                                      + "AND vehicle_IsActive = 1";

                        ps = con.prepareStatement(query1);
                        ps.setInt(1, provinceCode);
                        ps.setString(2, latterCode);
                        ps.setInt(3, numberCode);
                        ps.setString(4, userId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbId = rs.getString("vehicle_Id"); }
                                            if (dbId==null) {exist=false;} else{exist=true;}
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+VehicleDao.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+VehicleDao.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+VehicleDao.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", VehicleDao.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return exist;
    }     public int disableVehicleLinkedAds(String vehicleId ){
         
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   
                        boolean exist;
                        String dbId =null;
                        String query1 = "SELECT a.ad_Id "
                                      + "FROM  ad_ a, ad_aracim_var_is_ariyorum ai "
                                      + "WHERE a.ad_Id = ai.ad_Id "
                                      + "AND a.ad_IsActive = 1 "
                                      + "AND ai.vehicle_Id =? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, vehicleId);
                        
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbId = rs.getString("ad_Id"); }
                        
                        if (dbId==null) {exist=false;sonuc =1;} else{exist=true;}
                        
                        if(exist){
                            String query2 = "UPDATE ad_ a INNER JOIN `ad_aracim_var_is_ariyorum` ai on ai.Ad_Id= a.ad_Id "
                                          + "SET a.ad_IsActive=0 "
                                          + "WHERE ai.vehicle_Id =? ";
                            
                            ps = con.prepareStatement(query2);
                            ps.setString(1, vehicleId);
                            
                            sonuc = ps.executeUpdate();
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
    
}
