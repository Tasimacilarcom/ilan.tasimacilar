
package com.tasimacilar.ilan.vehicle;

import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VehicleDriverAndHostessDao {
  
    public int createvehicleDriverAndHostess(VehicleDriverAndHostessBean vhcDrvHst ) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleDriverAndHostess(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                                     
                        ps.setString(1, "insert");               
                        ps.setString(2, vhcDrvHst.getVehicleDriverAndHostess_Id());
                        ps.setString(3, vhcDrvHst.getVehicleDriverAndHostess_DriverInfo());
                        ps.setString(4, vhcDrvHst.getVehicleDriverAndHostess_DriverId());
                        ps.setString(5, vhcDrvHst.getVehicleDriverAndHostess_HostessInfo());   
                        ps.setString(6, vhcDrvHst.getVehicleDriverAndHostess_HostessId());  
                        ps.setBoolean(7, vhcDrvHst.isVehicleDriverAndHostess_IsActive());
                        ps.setString(8, vhcDrvHst.getVehicleDriverAndHostess_Commnet());
                        ps.setTimestamp(9,  vhcDrvHst.getVehicleDriverAndHostess_Modified() != null ? new java.sql.Timestamp(vhcDrvHst.getVehicleDriverAndHostess_Modified().getTime()) : null);  
                        ps.setString(10, vhcDrvHst.getVehicleDriverAndHostess_Modifier());
                        ps.setTimestamp(11, vhcDrvHst.getVehicleDriverAndHostess_Created() != null ? new java.sql.Timestamp(vhcDrvHst.getVehicleDriverAndHostess_Created().getTime()) : null );     
                        ps.setString(12, vhcDrvHst.getVehicleDriverAndHostess_creator());
                        ps.setString(13, vhcDrvHst.getVehicle_Id());
                        
                        ps.setString(14, vhcDrvHst.getDriver().getDriver_Id());               
                        ps.setString(15, vhcDrvHst.getDriver().getDriver_FirstName());
                        ps.setString(16, vhcDrvHst.getDriver().getDriver_LastName());
                        ps.setString(17, vhcDrvHst.getDriver().getDriver_EmailAddress());
                        ps.setString(18, vhcDrvHst.getDriver().getDriver_MobilePhoneNumber());   
                        ps.setString(19, vhcDrvHst.getDriver().getDriver_Gender());  
                        ps.setTimestamp(20, vhcDrvHst.getDriver().getDriver_BirthDate() != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_BirthDate().getTime()):null);   
                        ps.setString(21, vhcDrvHst.getDriver().getDriver_PlaceOfBirth());
                        ps.setString(22, vhcDrvHst.getDriver().getDriver_Education());
                        ps.setString(23, vhcDrvHst.getDriver().getDriver_DriversLicense());
                        ps.setTimestamp(24, vhcDrvHst.getDriver().getDriver_DriversLicenseYear() != null ?   new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_DriversLicenseYear().getTime()):null);     
                        ps.setFloat(25, vhcDrvHst.getDriver().getDriver_Fee());
                        ps.setBoolean(26, vhcDrvHst.getDriver().isDriver_ServiceTransportationExperience());
                        ps.setInt(27, vhcDrvHst.getDriver().getDriver_Experience());               
                        ps.setString(28, vhcDrvHst.getDriver().getDriver_ProfilePictureUrl());
                        ps.setBoolean(29, vhcDrvHst.getDriver().isDriver_ProfilePicturePublish());
                        ps.setBoolean(30, vhcDrvHst.getDriver().isDriver_Retired());
                        ps.setBoolean(31, vhcDrvHst.getDriver().isDriver_CriminalRecord());   
                        ps.setBoolean(32, vhcDrvHst.getDriver().isDriver_CertificateOfProfessionalCompetence());  
                        ps.setString(33, vhcDrvHst.getDriver().getDriver_BusinessPreference());
                        ps.setBoolean(34, vhcDrvHst.getDriver().isDriver_DoYouHaveHostess());
                        ps.setBoolean(35, vhcDrvHst.getDriver().isDriver_ExtraJobs());
                        ps.setBoolean(36, vhcDrvHst.getDriver().isDriver_IsActive());
                        ps.setString(37, vhcDrvHst.getDriver().getDriver_Commnet());
                        ps.setTimestamp(38, vhcDrvHst.getDriver().getDriver_Modified()  != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_Modified().getTime()):null);    
                        ps.setString(39, vhcDrvHst.getDriver().getDriver_Modifier());
                        ps.setTimestamp(40, vhcDrvHst.getDriver().getDriver_Created()  != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_Created().getTime()):null);     
                        ps.setString(41, vhcDrvHst.getDriver().getDriver_creator());
                        ps.setString(42, vhcDrvHst.getDriver().getDriver_RequestedDocumentes());
                        ps.setString(43, vhcDrvHst.getDriver().getDriver_ForeignLanguages());
                        ps.setString(44, vhcDrvHst.getDriver().getDriver_VehicleTypes());
                        
                        ps.setString(45, vhcDrvHst.getHostess().getHostess_Id()); 
                        ps.setString(46, vhcDrvHst.getHostess().getHostess_FirstName()); 
                        ps.setString(47, vhcDrvHst.getHostess().getHostess_LastName()); 
                        ps.setString(48, vhcDrvHst.getHostess().getHostess_EmailAddress()); 
                        ps.setString(49, vhcDrvHst.getHostess().getHostess_MobilePhoneNumber()); 
                        ps.setString(50, vhcDrvHst.getHostess().getHostess_Gender()); 
                        ps.setTimestamp(51, vhcDrvHst.getHostess().getHostess_BirthDate() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_BirthDate().getTime()):null); 
                        ps.setString(52, vhcDrvHst.getHostess().getHostess_PlaceOfBirth()); 
                        ps.setString(53, vhcDrvHst.getHostess().getHostess_Proximity()); 
                        ps.setString(54, vhcDrvHst.getHostess().getHostess_Education()); 
                        ps.setBoolean(55, vhcDrvHst.getHostess().isHostess_CriminalRecord()); 
                        ps.setBoolean(56, vhcDrvHst.getHostess().isHostess_ServiceTransportationExperience()); 
                        ps.setInt(57, vhcDrvHst.getHostess().getHostess_Experience()); 
                        ps.setString(58, vhcDrvHst.getHostess().getHostess_ProfilePictureUrl()); 
                        ps.setBoolean(59, vhcDrvHst.getHostess().isHostess_ProfilePicturePublish()); 
                        ps.setBoolean(60, vhcDrvHst.getHostess().isHostess_IsActive()); 
                        ps.setString(61, vhcDrvHst.getHostess().getHostess_Commnet()); 
                        ps.setTimestamp(62, vhcDrvHst.getHostess().getHostess_Modified() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_Modified().getTime()):null);   
                        ps.setString(63, vhcDrvHst.getHostess().getHostess_Modifier()); 
                        ps.setTimestamp(64, vhcDrvHst.getHostess().getHostess_Created() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_Created().getTime()):null);    
                        ps.setString(65, vhcDrvHst.getHostess().getHostess_creator()); 
                        ps.setString(66, vhcDrvHst.getHostess().getHostess_ForeignLanguages()); 
                    
                        
                        sonuc = ps.executeUpdate();  
                        
                        System.out.println("Yeni araç surucu ve hostes bilgisi Oluşturma BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni araç surucu ve hostes bilgisi olusturuldu. [Araç VehicleDriverAndHostess Id:"+vhcDrvHst.getVehicleDriverAndHostess_Id()+"]", "system");
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
    } public int updateVehicleDriverAndHostess(VehicleDriverAndHostessBean vhcDrvHst) { 
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleDriverAndHostess(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                                        
                        ps.setString(1, "update");               
                        ps.setString(2, vhcDrvHst.getVehicleDriverAndHostess_Id());
                        ps.setString(3, vhcDrvHst.getVehicleDriverAndHostess_DriverInfo());
                        ps.setString(4, vhcDrvHst.getVehicleDriverAndHostess_DriverId());
                        ps.setString(5, vhcDrvHst.getVehicleDriverAndHostess_HostessInfo());   
                        ps.setString(6, vhcDrvHst.getVehicleDriverAndHostess_HostessId());  
                        ps.setBoolean(7, vhcDrvHst.isVehicleDriverAndHostess_IsActive());
                        ps.setString(8, vhcDrvHst.getVehicleDriverAndHostess_Commnet());
                        ps.setTimestamp(9,  vhcDrvHst.getVehicleDriverAndHostess_Modified() != null ? new java.sql.Timestamp(vhcDrvHst.getVehicleDriverAndHostess_Modified().getTime()) : null);  
                        ps.setString(10, vhcDrvHst.getVehicleDriverAndHostess_Modifier());
                        ps.setTimestamp(11, null);     
                        ps.setString(12, vhcDrvHst.getVehicleDriverAndHostess_creator());
                        ps.setString(13, vhcDrvHst.getVehicle_Id());
                        
                        ps.setString(14, vhcDrvHst.getDriver().getDriver_Id());               
                        ps.setString(15, vhcDrvHst.getDriver().getDriver_FirstName());
                        ps.setString(16, vhcDrvHst.getDriver().getDriver_LastName());
                        ps.setString(17, vhcDrvHst.getDriver().getDriver_EmailAddress());
                        ps.setString(18, vhcDrvHst.getDriver().getDriver_MobilePhoneNumber());   
                        ps.setString(19, vhcDrvHst.getDriver().getDriver_Gender());  
                        ps.setTimestamp(20, vhcDrvHst.getDriver().getDriver_BirthDate() != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_BirthDate().getTime()):null);   
                        ps.setString(21, vhcDrvHst.getDriver().getDriver_PlaceOfBirth());
                        ps.setString(22, vhcDrvHst.getDriver().getDriver_Education());
                        ps.setString(23, vhcDrvHst.getDriver().getDriver_DriversLicense());
                        ps.setTimestamp(24, vhcDrvHst.getDriver().getDriver_DriversLicenseYear() != null ?   new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_DriversLicenseYear().getTime()):null);     
                        ps.setFloat(25, vhcDrvHst.getDriver().getDriver_Fee());
                        ps.setBoolean(26, vhcDrvHst.getDriver().isDriver_ServiceTransportationExperience());
                        ps.setInt(27, vhcDrvHst.getDriver().getDriver_Experience());               
                        ps.setString(28, vhcDrvHst.getDriver().getDriver_ProfilePictureUrl());
                        ps.setBoolean(29, vhcDrvHst.getDriver().isDriver_ProfilePicturePublish());
                        ps.setBoolean(30, vhcDrvHst.getDriver().isDriver_Retired());
                        ps.setBoolean(31, vhcDrvHst.getDriver().isDriver_CriminalRecord());   
                        ps.setBoolean(32, vhcDrvHst.getDriver().isDriver_CertificateOfProfessionalCompetence());  
                        ps.setString(33, vhcDrvHst.getDriver().getDriver_BusinessPreference());
                        ps.setBoolean(34, vhcDrvHst.getDriver().isDriver_DoYouHaveHostess());
                        ps.setBoolean(35, vhcDrvHst.getDriver().isDriver_ExtraJobs());
                        ps.setBoolean(36, vhcDrvHst.getDriver().isDriver_IsActive());
                        ps.setString(37, vhcDrvHst.getDriver().getDriver_Commnet());
                        ps.setTimestamp(38, vhcDrvHst.getDriver().getDriver_Modified()  != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_Modified().getTime()):null);    
                        ps.setString(39, vhcDrvHst.getDriver().getDriver_Modifier());
                        ps.setTimestamp(40, vhcDrvHst.getDriver().getDriver_Created()  != null ? new java.sql.Timestamp(vhcDrvHst.getDriver().getDriver_Created().getTime()):null);     
                        ps.setString(41, vhcDrvHst.getDriver().getDriver_creator());
                        ps.setString(42, vhcDrvHst.getDriver().getDriver_RequestedDocumentes());
                        ps.setString(43, vhcDrvHst.getDriver().getDriver_ForeignLanguages());
                        ps.setString(44, vhcDrvHst.getDriver().getDriver_VehicleTypes());
                        
                        ps.setString(45, vhcDrvHst.getHostess().getHostess_Id()); 
                        ps.setString(46, vhcDrvHst.getHostess().getHostess_FirstName()); 
                        ps.setString(47, vhcDrvHst.getHostess().getHostess_LastName()); 
                        ps.setString(48, vhcDrvHst.getHostess().getHostess_EmailAddress()); 
                        ps.setString(49, vhcDrvHst.getHostess().getHostess_MobilePhoneNumber()); 
                        ps.setString(50, vhcDrvHst.getHostess().getHostess_Gender()); 
                        ps.setTimestamp(51, vhcDrvHst.getHostess().getHostess_BirthDate() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_BirthDate().getTime()):null); 
                        ps.setString(52, vhcDrvHst.getHostess().getHostess_PlaceOfBirth()); 
                        ps.setString(53, vhcDrvHst.getHostess().getHostess_Proximity()); 
                        ps.setString(54, vhcDrvHst.getHostess().getHostess_Education()); 
                        ps.setBoolean(55, vhcDrvHst.getHostess().isHostess_CriminalRecord()); 
                        ps.setBoolean(56, vhcDrvHst.getHostess().isHostess_ServiceTransportationExperience()); 
                        ps.setInt(57, vhcDrvHst.getHostess().getHostess_Experience()); 
                        ps.setString(58, vhcDrvHst.getHostess().getHostess_ProfilePictureUrl()); 
                        ps.setBoolean(59, vhcDrvHst.getHostess().isHostess_ProfilePicturePublish()); 
                        ps.setBoolean(60, vhcDrvHst.getHostess().isHostess_IsActive()); 
                        ps.setString(61, vhcDrvHst.getHostess().getHostess_Commnet()); 
                        ps.setTimestamp(62, vhcDrvHst.getHostess().getHostess_Modified() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_Modified().getTime()):null);   
                        ps.setString(63, vhcDrvHst.getHostess().getHostess_Modifier()); 
                        ps.setTimestamp(64, vhcDrvHst.getHostess().getHostess_Created() != null ? new java.sql.Timestamp(vhcDrvHst.getHostess().getHostess_Created().getTime()):null);    
                        ps.setString(65, vhcDrvHst.getHostess().getHostess_creator()); 
                        ps.setString(66, vhcDrvHst.getHostess().getHostess_ForeignLanguages()); 
                  
                        sonuc = ps.executeUpdate();  
                        if(sonuc == 1){
                            System.out.println("Araç surucu ve hostes bilgisi Güncelleme BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Araç surucu ve hostes bilgisi guncellendi. [Araç VehicleDriverAndHostess Id:"+vhcDrvHst.getVehicleDriverAndHostess_Id()+"]", "system");
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
    public VehicleDriverAndHostessBean getvehicleDriverAndHostessWithVehicleId(String VehicleId) {
        
        int sonuc = 0;
       VehicleDriverAndHostessBean vdh = new VehicleDriverAndHostessBean(); 
        
        
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
                        ps = ps = con.prepareCall("{call pro_vehicleDriverAndHostess_getAll(?,?,?)}");                
                        ps.setString(1, "getAllWithVehicleId");
                        ps.setString(2, "");
                        ps.setString(3, VehicleId);
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { 
                                            Driver db = new Driver();
                                            db.setDriver_Id(rs.getString("driver_Id"));
                                            db.setDriver_FirstName(rs.getString("driver_FirstName"));
                                            db.setDriver_LastName(rs.getString("driver_LastName"));
                                            db.setDriver_EmailAddress(rs.getString("driver_EmailAddress"));
                                            db.setDriver_MobilePhoneNumber(rs.getString("driver_MobilePhoneNumber"));
                                            db.setDriver_Gender(rs.getString("driver_Gender"));
                                            db.setDriver_BirthDate(rs.getTimestamp("driver_BirthDate"));
                                            db.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));
                                            db.setDriver_Education(rs.getString("driver_Education"));
                                            
                                            db.setDriver_DriversLicense(rs.getString("driver_DriversLicense"));
                                            if (rs.getString("driver_DriversLicense") != null) {
                                                String driver_DriversLicensexx = rs.getString("driver_DriversLicense").substring(1);
                                                String[] driver_DriversLicensexxx = driver_DriversLicensexx.split(",");
                                                db.setDriver_DriversLicenses(driver_DriversLicensexxx);
                                            }
                                            
                                            db.setDriver_DriversLicenseYear(rs.getTimestamp("driver_DriversLicenseYear"));
                                            db.setDriver_Fee(rs.getFloat("driver_Fee"));
                                            db.setDriver_ServiceTransportationExperience(rs.getBoolean("driver_ServiceTransportationExperience"));
                                            db.setDriver_Experience(rs.getInt("driver_Experience"));
                                            db.setDriver_ProfilePictureUrl(rs.getString("driver_ProfilePictureUrl"));
                                            db.setDriver_ProfilePicturePublish(rs.getBoolean("driver_ProfilePicturePublish"));
                                            db.setDriver_Retired(rs.getBoolean("driver_Retired"));
                                            db.setDriver_CriminalRecord(rs.getBoolean("driver_CriminalRecord"));
                                            db.setDriver_CertificateOfProfessionalCompetence(rs.getBoolean("driver_CertificateOfProfessionalCompetence"));
                                            db.setDriver_BusinessPreference(rs.getString("driver_BusinessPreference"));
                                            db.setDriver_DoYouHaveHostess(rs.getBoolean("driver_DoYouHaveHostess"));
                                            db.setDriver_ExtraJobs(rs.getBoolean("driver_ExtraJobs"));
                                            db.setDriver_IsActive(rs.getBoolean("driver_IsActive"));
                                            db.setDriver_Commnet(rs.getString("driver_Commnet"));
                                            db.setDriver_Modified(rs.getTimestamp("driver_Modified"));
                                            db.setDriver_Modifier(rs.getString("driver_Modifier"));
                                            db.setDriver_Created(rs.getTimestamp("driver_Created"));
                                            db.setDriver_creator(rs.getString("driver_creator"));
                                            
                                            db.setDriver_RequestedDocumentes(rs.getString("driver_RequestedDocumentes"));
                                             if (rs.getString("driver_RequestedDocumentes") != null) {
                                                String driver_RequestedDocumentesxx = rs.getString("driver_RequestedDocumentes").substring(1);
                                                String[] driver_RequestedDocumentesxxx = driver_RequestedDocumentesxx.split(",");
                                                db.setDriver_RequestedDocumentesList(driver_RequestedDocumentesxxx);
                                            }
                                            
                                            db.setDriver_ForeignLanguages(rs.getString("driver_ForeignLanguages"));
                                            if (rs.getString("driver_ForeignLanguages") != null) {
                                                String driver_ForeignLanguagesxx = rs.getString("driver_ForeignLanguages").substring(1);
                                                String[] driver_ForeignLanguagesxxx = driver_ForeignLanguagesxx.split(",");
                                                db.setDriver_ForeignLanguagesList(driver_ForeignLanguagesxxx);
                                            }
                                            
                                            db.setDriver_VehicleTypes(rs.getString("driver_VehicleTypes"));
                                            if (rs.getString("driver_VehicleTypes") != null) {
                                                String driver_VehicleTypesxx = rs.getString("driver_VehicleTypes").substring(1);
                                                String[] driver_VehicleTypesxxx = driver_VehicleTypesxx.split(",");
                                                db.setDriver_VehicleTypesList(driver_VehicleTypesxxx);
                                            }
   
                                            Hostess hb = new Hostess();
                                            hb.setHostess_Id(rs.getString("hostess_Id"));
                                            hb.setHostess_FirstName(rs.getString("hostess_FirstName"));
                                            hb.setHostess_LastName(rs.getString("hostess_LastName"));
                                            hb.setHostess_EmailAddress(rs.getString("hostess_EmailAddress"));
                                            hb.setHostess_MobilePhoneNumber(rs.getString("hostess_MobilePhoneNumber"));
                                            hb.setHostess_Gender(rs.getString("hostess_Gender"));
                                            hb.setHostess_BirthDate(rs.getTimestamp("hostess_BirthDate"));
                                            hb.setHostess_PlaceOfBirth(rs.getString("hostess_PlaceOfBirth"));
                                            hb.setHostess_Proximity(rs.getString("hostess_Proximity"));
                                            hb.setHostess_Education(rs.getString("hostess_Education"));
                                            hb.setHostess_CriminalRecord(rs.getBoolean("hostess_CriminalRecord"));
                                            hb.setHostess_ServiceTransportationExperience(rs.getBoolean("hostess_ServiceTransportationExperience"));
                                            hb.setHostess_Experience(rs.getInt("hostess_Experience"));
                                            hb.setHostess_ProfilePictureUrl(rs.getString("hostess_ProfilePictureUrl"));
                                            hb.setHostess_ProfilePicturePublish(rs.getBoolean("hostess_ProfilePicturePublish"));
                                            hb.setHostess_IsActive(rs.getBoolean("hostess_IsActive"));
                                            hb.setHostess_Commnet(rs.getString("hostess_Commnet"));
                                            hb.setHostess_Modified(rs.getTimestamp("hostess_Modified"));
                                            hb.setHostess_Modifier(rs.getString("hostess_Modifier"));
                                            hb.setHostess_Created(rs.getTimestamp("hostess_Created"));
                                            hb.setHostess_creator(rs.getString("hostess_creator"));
                                            
                                            hb.setHostess_ForeignLanguages(rs.getString("hostess_ForeignLanguages"));
                                            if (rs.getString("hostess_ForeignLanguages") != null) {
                                                String hostess_ForeignLanguagesxx = rs.getString("hostess_ForeignLanguages").substring(1);
                                                String[] hostess_ForeignLanguagesxxx = hostess_ForeignLanguagesxx.split(",");
                                                hb.setHostess_ForeignLanguagesList(hostess_ForeignLanguagesxxx);
                                            }
                            
                                            vdh.setVehicleDriverAndHostess_Id(rs.getString("vehicleDriverAndHostess_Id"));
                                            vdh.setVehicleDriverAndHostess_DriverInfo(rs.getString("vehicleDriverAndHostess_DriverInfo"));
                                            vdh.setVehicleDriverAndHostess_DriverId(rs.getString("vehicleDriverAndHostess_DriverId"));
                                            vdh.setVehicleDriverAndHostess_HostessInfo(rs.getString("vehicleDriverAndHostess_HostessInfo"));
                                            vdh.setVehicleDriverAndHostess_HostessId(rs.getString("vehicleDriverAndHostess_HostessId"));
                                            vdh.setVehicleDriverAndHostess_IsActive(rs.getBoolean("vehicleDriverAndHostess_IsActive"));
                                            vdh.setVehicleDriverAndHostess_Commnet(rs.getString("vehicleDriverAndHostess_Commnet"));
                                            vdh.setVehicleDriverAndHostess_Modified(rs.getTimestamp("vehicleDriverAndHostess_Modified"));
                                            vdh.setVehicleDriverAndHostess_Modifier(rs.getString("vehicleDriverAndHostess_Modifier"));
                                            vdh.setVehicleDriverAndHostess_Created(rs.getTimestamp("vehicleDriverAndHostess_Created"));
                                            vdh.setVehicleDriverAndHostess_creator(rs.getString("vehicleDriverAndHostess_creator"));
                                            vdh.setDriver(db);
                                            vdh.setHostess(hb);
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
        
        return vdh;
    }
    
    
    
    
    
    
}
