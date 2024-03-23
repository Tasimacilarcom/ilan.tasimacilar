package com.tasimacilar.ilan.ad.soforumİsAriyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Ad_SoforumİsAriyorum_Dao {  public int createSoforumIsAriyorumAd(Ad_SoforumİsAriyorum_Bean ad) { 
  int sonuc = 0;   Connection con = null;  PreparedStatement ps = null;    con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_SoforumIsAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
                         ps.setString(1, "insert");
                        ps.setString(2, ad.getAd_SoforumIsAriyorum_Id());                
                        ps.setString(3, ad.getAdBean().getAd_Id());
                        ps.setInt(4, ad.getAdBean().getAd_Category_Id());
                        ps.setString(5, ad.getAdBean().getAd_Title());
                        ps.setString(6, ad.getAdBean().getAd_Comment());
                        ps.setString(7, ad.getAdBean().getAd_Type());
                        ps.setString(8, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(9, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(10, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(11, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(12, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(13, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(14, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(15, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(16, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(17, ad.getAdBean().getAd_LastChangerAccountId());
                    ps.setString(18, ad.getHostess().getHostess_Id()); 
                        ps.setString(19, ad.getHostess().getHostess_FirstName()); 
                        ps.setString(20, ad.getHostess().getHostess_LastName()); 
                        ps.setString(21, ad.getHostess().getHostess_EmailAddress()); 
                        ps.setString(22, ad.getHostess().getHostess_MobilePhoneNumber()); 
                        ps.setString(23, ad.getHostess().getHostess_Gender()); 
                        ps.setTimestamp(24, ad.getHostess().getHostess_BirthDate() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_BirthDate().getTime()):null); 
                        ps.setString(25, ad.getHostess().getHostess_PlaceOfBirth()); 
                        ps.setString(26, ad.getHostess().getHostess_Proximity()); 
                        ps.setString(27, ad.getHostess().getHostess_Education()); 
                        ps.setBoolean(28, ad.getHostess().isHostess_CriminalRecord()); 
                        ps.setBoolean(29, ad.getHostess().isHostess_ServiceTransportationExperience()); 
                        ps.setInt(30, ad.getHostess().getHostess_Experience()); 
                        ps.setString(31, ad.getHostess().getHostess_ProfilePictureUrl()); 
                        ps.setBoolean(32, ad.getHostess().isHostess_ProfilePicturePublish()); 
                        ps.setBoolean(33, ad.getHostess().isHostess_IsActive()); 
                        ps.setString(34, ad.getHostess().getHostess_Commnet()); 
                        ps.setTimestamp(35, ad.getHostess().getHostess_Modified() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_Modified().getTime()):null);   
                        ps.setString(36, ad.getHostess().getHostess_Modifier()); 
                        ps.setTimestamp(37, ad.getHostess().getHostess_Created() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_Created().getTime()):null);    
                        ps.setString(38, ad.getHostess().getHostess_creator()); 
                        ps.setString(39, ad.getHostess().getHostess_ForeignLanguages()); 
                        ps.setString(40, ad.getDriver().getDriver_Id());               
                        ps.setString(41, ad.getDriver().getDriver_FirstName());
                        ps.setString(42, ad.getDriver().getDriver_LastName());
                        ps.setString(43, ad.getDriver().getDriver_EmailAddress());
                        ps.setString(44, ad.getDriver().getDriver_MobilePhoneNumber());   
                        ps.setString(45, ad.getDriver().getDriver_Gender());  
                        ps.setTimestamp(46, ad.getDriver().getDriver_BirthDate() != null ? new java.sql.Timestamp(ad.getDriver().getDriver_BirthDate().getTime()):null);   
                        ps.setString(47, ad.getDriver().getDriver_PlaceOfBirth());
                        ps.setString(48, ad.getDriver().getDriver_Education());
                        ps.setString(49, ad.getDriver().getDriver_DriversLicense());
                        ps.setTimestamp(50, ad.getDriver().getDriver_DriversLicenseYear() != null ?   new java.sql.Timestamp(ad.getDriver().getDriver_DriversLicenseYear().getTime()):null);     
                        ps.setFloat(51, ad.getDriver().getDriver_Fee());
                        ps.setBoolean(52, ad.getDriver().isDriver_ServiceTransportationExperience());
                        ps.setInt(53, ad.getDriver().getDriver_Experience());               
                        ps.setString(54, ad.getDriver().getDriver_ProfilePictureUrl());
                        ps.setBoolean(55, ad.getDriver().isDriver_ProfilePicturePublish());
                        ps.setBoolean(56, ad.getDriver().isDriver_Retired());
                        ps.setBoolean(57, ad.getDriver().isDriver_CriminalRecord());   
                        ps.setBoolean(58, ad.getDriver().isDriver_CertificateOfProfessionalCompetence());  
                        ps.setString(59, ad.getDriver().getDriver_BusinessPreference());
                        ps.setBoolean(60, ad.getDriver().isDriver_DoYouHaveHostess());
                        ps.setBoolean(61, ad.getDriver().isDriver_ExtraJobs());
                        ps.setBoolean(62, ad.getDriver().isDriver_IsActive());
                        ps.setString(63, ad.getDriver().getDriver_Commnet());
                        ps.setTimestamp(64, ad.getDriver().getDriver_Modified()  != null ? new java.sql.Timestamp(ad.getDriver().getDriver_Modified().getTime()):null);    
                        ps.setString(65, ad.getDriver().getDriver_Modifier());
                        ps.setTimestamp(66, ad.getDriver().getDriver_Created()  != null ? new java.sql.Timestamp(ad.getDriver().getDriver_Created().getTime()):null);     
                        ps.setString(67, ad.getDriver().getDriver_creator());
                        ps.setString(68, ad.getDriver().getDriver_RequestedDocumentes());
                        ps.setString(69, ad.getDriver().getDriver_ForeignLanguages());
                        ps.setString(70, ad.getDriver().getDriver_VehicleTypes());
                        sonuc = ps.executeUpdate();  if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: soforum-is-ariyorum "
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
        
        return sonuc; }public int updateSoforumIsAriyorumAd(Ad_SoforumİsAriyorum_Bean ad) { 
  int sonuc = 0; Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_SoforumIsAriyorum(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
                        ps.setString(1, "update");
                        ps.setString(2, ad.getAd_SoforumIsAriyorum_Id());                
                        ps.setString(3, ad.getAdBean().getAd_Id());
                        ps.setInt(4, ad.getAdBean().getAd_Category_Id());
                        ps.setString(5, ad.getAdBean().getAd_Title());
                        ps.setString(6, ad.getAdBean().getAd_Comment());
                        ps.setString(7, ad.getAdBean().getAd_Type());
                        ps.setString(8, ad.getAdBean().getAd_OvnerAccountId());
                        ps.setBoolean(9, ad.getAdBean().isAd_IsActive());                       
                        ps.setTimestamp(10, ad.getAdBean().getAd_EndTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_EndTime().getTime()));
                        ps.setString(11, ad.getAdBean().getAd_Notes());
                        ps.setTimestamp(12, ad.getAdBean().getAd_CreateTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_CreateTime().getTime()));
                        ps.setString(13, ad.getAdBean().getAd_CreatedIp());
                        ps.setString(14, ad.getAdBean().getAd_CreatedAccountId());
                        ps.setString(15, ad.getAdBean().getAd_LastModifyIp());
                        ps.setTimestamp(16, ad.getAdBean().getAd_LastModifyTime() == null ? null : new java.sql.Timestamp(ad.getAdBean().getAd_LastModifyTime().getTime()));
                        ps.setString(17, ad.getAdBean().getAd_LastChangerAccountId());
                    ps.setString(18, ad.getHostess().getHostess_Id()); 
                        ps.setString(19, ad.getHostess().getHostess_FirstName()); 
                        ps.setString(20, ad.getHostess().getHostess_LastName()); 
                        ps.setString(21, ad.getHostess().getHostess_EmailAddress()); 
                        ps.setString(22, ad.getHostess().getHostess_MobilePhoneNumber()); 
                        ps.setString(23, ad.getHostess().getHostess_Gender()); 
                        ps.setTimestamp(24, ad.getHostess().getHostess_BirthDate() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_BirthDate().getTime()):null); 
                        ps.setString(25, ad.getHostess().getHostess_PlaceOfBirth()); 
                        ps.setString(26, ad.getHostess().getHostess_Proximity()); 
                        ps.setString(27, ad.getHostess().getHostess_Education()); 
                        ps.setBoolean(28, ad.getHostess().isHostess_CriminalRecord()); 
                        ps.setBoolean(29, ad.getHostess().isHostess_ServiceTransportationExperience()); 
                        ps.setInt(30, ad.getHostess().getHostess_Experience()); 
                        ps.setString(31, ad.getHostess().getHostess_ProfilePictureUrl()); 
                        ps.setBoolean(32, ad.getHostess().isHostess_ProfilePicturePublish()); 
                        ps.setBoolean(33, ad.getHostess().isHostess_IsActive()); 
                        ps.setString(34, ad.getHostess().getHostess_Commnet()); 
                        ps.setTimestamp(35, ad.getHostess().getHostess_Modified() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_Modified().getTime()):null);   
                        ps.setString(36, ad.getHostess().getHostess_Modifier()); 
                        ps.setTimestamp(37, ad.getHostess().getHostess_Created() != null ? new java.sql.Timestamp(ad.getHostess().getHostess_Created().getTime()):null);    
                        ps.setString(38, ad.getHostess().getHostess_creator()); 
                        ps.setString(39, ad.getHostess().getHostess_ForeignLanguages()); 
                        ps.setString(40, ad.getDriver().getDriver_Id());               
                        ps.setString(41, ad.getDriver().getDriver_FirstName());
                        ps.setString(42, ad.getDriver().getDriver_LastName());
                        ps.setString(43, ad.getDriver().getDriver_EmailAddress());
                        ps.setString(44, ad.getDriver().getDriver_MobilePhoneNumber());   
                        ps.setString(45, ad.getDriver().getDriver_Gender());  
                        ps.setTimestamp(46, ad.getDriver().getDriver_BirthDate() != null ? new java.sql.Timestamp(ad.getDriver().getDriver_BirthDate().getTime()):null);   
                        ps.setString(47, ad.getDriver().getDriver_PlaceOfBirth());
                        ps.setString(48, ad.getDriver().getDriver_Education());
                        ps.setString(49, ad.getDriver().getDriver_DriversLicense());
                        ps.setTimestamp(50, ad.getDriver().getDriver_DriversLicenseYear() != null ?   new java.sql.Timestamp(ad.getDriver().getDriver_DriversLicenseYear().getTime()):null);     
                        ps.setFloat(51, ad.getDriver().getDriver_Fee());
                        ps.setBoolean(52, ad.getDriver().isDriver_ServiceTransportationExperience());
                        ps.setInt(53, ad.getDriver().getDriver_Experience());               
                        ps.setString(54, ad.getDriver().getDriver_ProfilePictureUrl());
                        ps.setBoolean(55, ad.getDriver().isDriver_ProfilePicturePublish());
                        ps.setBoolean(56, ad.getDriver().isDriver_Retired());
                        ps.setBoolean(57, ad.getDriver().isDriver_CriminalRecord());   
                        ps.setBoolean(58, ad.getDriver().isDriver_CertificateOfProfessionalCompetence());  
                        ps.setString(59, ad.getDriver().getDriver_BusinessPreference());
                        ps.setBoolean(60, ad.getDriver().isDriver_DoYouHaveHostess());
                        ps.setBoolean(61, ad.getDriver().isDriver_ExtraJobs());
                        ps.setBoolean(62, ad.getDriver().isDriver_IsActive());
                        ps.setString(63, ad.getDriver().getDriver_Commnet());
                        ps.setTimestamp(64, ad.getDriver().getDriver_Modified()  != null ? new java.sql.Timestamp(ad.getDriver().getDriver_Modified().getTime()):null);    
                        ps.setString(65, ad.getDriver().getDriver_Modifier());
                        ps.setTimestamp(66, ad.getDriver().getDriver_Created()  != null ? new java.sql.Timestamp(ad.getDriver().getDriver_Created().getTime()):null);     
                        ps.setString(67, ad.getDriver().getDriver_creator());
                        ps.setString(68, ad.getDriver().getDriver_RequestedDocumentes());
                        ps.setString(69, ad.getDriver().getDriver_ForeignLanguages());
                        ps.setString(70, ad.getDriver().getDriver_VehicleTypes());
                        sonuc = ps.executeUpdate();  
                        if(sonuc==1){
                            System.out.println("Yeni ilan Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni ilan olusturuldu. [Kategori: soforum-is-ariyorum "
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
        
        return sonuc;  }  public Ad_SoforumİsAriyorum_Bean getSoforumIsAriyorumAdWithAdId(String adId) { 
        
        int sonuc = 0;  Ad_SoforumİsAriyorum_Bean ad = new Ad_SoforumİsAriyorum_Bean();
        
        Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        ps = ps = con.prepareCall("{call pro_ad_SoforumIsAriyorum_getAll(?,?)}");                  
                        ps.setString(1, "getAllWithId");
                        ps.setString(2, adId);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {  Driver db = new Driver();
                                            db.setDriver_Id(rs.getString("driver_Id"));
                                            db.setDriver_FirstName(rs.getString("driver_FirstName"));
                                            db.setDriver_LastName(rs.getString("driver_LastName"));
                                            db.setDriver_EmailAddress(rs.getString("driver_EmailAddress"));
                                            db.setDriver_MobilePhoneNumber(rs.getString("driver_MobilePhoneNumber"));
                                            db.setDriver_Gender(rs.getString("driver_Gender"));
                                            db.setDriver_BirthDate(rs.getTimestamp("driver_BirthDate"));
                                            db.setDriver_PlaceOfBirth(rs.getString("driver_PlaceOfBirth"));
                                            db.setDriver_Education(rs.getString("driver_Education")); if (rs.getString("driver_DriversLicense") != null) {
                                                String[] a = rs.getString("driver_DriversLicense").split(",");
                                                db.setDriver_DriversLicenses(a); }  db.setDriver_DriversLicenseYear(rs.getTimestamp("driver_DriversLicenseYear"));
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
                                            if (rs.getString("driver_RequestedDocumentes") != null) {
                                                String RequestedDocumentes = rs.getString("driver_RequestedDocumentes").substring(1);
                                                String[] RequestedDocumentesx = RequestedDocumentes.split(",");
                                                db.setDriver_RequestedDocumentesList(RequestedDocumentesx); }if (rs.getString("driver_ForeignLanguages") != null) {
                                                String ForeignLanguage = rs.getString("driver_ForeignLanguages").substring(1);
                                                String[] ForeignLanguagex = ForeignLanguage.split(",");
                                                db.setDriver_ForeignLanguagesList(ForeignLanguagex);
                                            }  if (rs.getString("driver_VehicleTypes") != null) {
                                                String VehicleTypes = rs.getString("driver_VehicleTypes").substring(1);
                                                String[] VehicleTypesx = VehicleTypes.split(",");
                                                db.setDriver_VehicleTypesList(VehicleTypesx);
                                            } Hostess hb = new Hostess();
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
                                            if (rs.getString("hostess_ForeignLanguages") != null) {
                                                String ForeignLanguages = rs.getString("hostess_ForeignLanguages").substring(1);
                                                String[] ForeignLanguagesx = ForeignLanguages.split(",");
                                                hb.setHostess_ForeignLanguagesList(ForeignLanguagesx);
                                            } Ad_Bean ab = new Ad_Bean();
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
                                            ad.setAd_SoforumIsAriyorum_Id(rs.getString("Ad_SoforumIsAriyorum_Id"));
                                            ad.setAd_Id(rs.getString("ad_Id"));
                                            ad.setDriver_Id(rs.getString("driver_Id"));
                                            ad.setHostess_Id(rs.getString("hostess_Id"));
                                            ad.setAdBean(ab);
                                            ad.setDriver(db);
                                            ad.setHostess(hb); }  
            
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
