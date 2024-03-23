package com.tasimacilar.ilan.ad;
import com.tasimacilar.ilan.ad.aracimVarHostesAriyorum.Ad_AracimVarHostesAriyorum;
import com.tasimacilar.ilan.ad.aracimVarIsAriyorum.Ad_AracimVarIsAriyorum;
import com.tasimacilar.ilan.ad.aracimVarSoforAriyorum.Ad_AracimVarSoforAriyorum;
import com.tasimacilar.ilan.ad.hostesimİsAriyorum.Ad_HostesimİsAriyorum_Bean;
import com.tasimacilar.ilan.ad.isimvarAracAriyorum.Ad_IsimVarAracAriyorum;
import com.tasimacilar.ilan.ad.plakamiSatiyorum.Ad_PlakamiSatiyorum;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.ad.soforumİsAriyorum.Ad_SoforumİsAriyorum_Bean;
import com.tasimacilar.ilan.driver.Driver;
import com.tasimacilar.ilan.hostess.Hostess;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.vehicle.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tasimacilar.ilan.vehicle.VehicleBrandAndModelDao;
import com.tasimacilar.ilan.vehicle.VehicleImages;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import org.jsoup.Jsoup;
public class Ad_Dao {  public Ad_Bean getAdDetailWithId(String adId) {
        
        int sonuc = 0;  Ad_Bean ad = new Ad_Bean();  Connection con = null;   PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM ad_ a, ad_category c, account_ ac "
                                        + "WHERE  a.ad_Id = ? "
                                        + "AND a.ad_Category_Id = c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id ";
                        
                        ps = con.prepareStatement(query1); 
                        ps.setString(1, adId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {   AccountBean ab = new AccountBean();
                                            ab.setAccount_Id(rs.getString("account_Id"));
                                            ab.setAccount_TC_Id(rs.getLong("account_TC_Id"));
                                            ab.setAccount_EmailActivationId(rs.getString("account_EmailActivationId"));
                                            ab.setAccount_MobilePhoneNumberActivationId(rs.getString("account_MobilePhoneNumberActivationId"));
                                            ab.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ab.setAccount_LastName(rs.getString("account_LastName"));
                                            ab.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                            ab.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            ab.setAccount_Password_1(rs.getString("account_Password"));
                                            ab.setAccount_Gender(rs.getString("account_Gender"));
                                            ab.setAccount_BirthDate(rs.getTimestamp("account_BirthDate"));
                                            ab.setAccount_RememberMe(rs.getBoolean("account_RememberMe"));
                                            ab.setAccount_MembershipType(rs.getString("account_MembershipType"));
                                            ab.setAccount_ActivityArea(rs.getString("account_ActivityArea"));
                                            ab.setAccount_Type(rs.getString("account_Type"));
                                            ab.setAccount_SecretQuestion(rs.getString("account_SecretQuestion"));
                                            ab.setAccount_SecretQuestionAnswer(rs.getString("account_SecretQuestionAnswer"));
                                            ab.setAccount_MailSubscription(rs.getBoolean("account_MailSubscription"));
                                            ab.setAccount_TermsAccepted(rs.getBoolean("account_TermsAccepted"));
                                            ab.setAccount_TermsAcceptedIp(rs.getString("account_TermsAcceptedIp"));
                                            ab.setAccount_TermsAcceptedTime(rs.getTimestamp("account_TermsAcceptedTime"));
                                            ab.setAccount_IsActive(rs.getBoolean("account_IsActive"));
                                            ab.setAccount_CreatedIp(rs.getString("account_CreatedIp"));
                                            ab.setAccount_CreateTime(rs.getTimestamp("account_CreateTime"));
                                            ab.setAccount_LastLoginIp(rs.getString("account_LastLoginIp"));
                                            ab.setAccount_LastLoginTime(rs.getTimestamp("account_LastLoginTime"));
                                            ab.setAccount_LastModifyIp(rs.getString("account_LastModifyIp"));
                                            ab.setAccount_LastModifyTime(rs.getTimestamp("account_LastModifyTime"));
                                            ab.setAccount_LastChangerAccountId(rs.getString("account_LastChangerAccountId"));      
                                            ab.setCompany_Id(rs.getString("company_Id"));
                                            ab.setAddress_id(rs.getString("address_id"));
                                             ad.setAd_Id(rs.getString("ad_Id"));
                                            ad.setAd_Id2(rs.getString("ad_Id2"));
                                            ad.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ad.setAd_Title(rs.getString("ad_Title"));
                                            ad.setAd_Comment(rs.getString("ad_Comment"));
                                            ad.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
                                            ad.setAd_Type(rs.getString("ad_Type"));
                                            ad.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ad.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            ad.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            ad.setAd_Notes(rs.getString("ad_Notes"));
                                            ad.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ad.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            ad.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            ad.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            ad.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            ad.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            ad.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ad.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ad.setAccountBean(ab);
                                            
                                            
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
    }    public List<Ad_Bean> getAllAd(  boolean filtCat_IsimVarAracAriyorum, boolean filtCat_AracimVarIsAriyorum, 
                                    boolean filtCat_AracimVarSoforAriyorum, boolean filtCat_AracimVarHostesAriyorum, 
                                    boolean filtCat_HostesimIsAriyorum, boolean filtCat_SoforumIsAriyorum, 
                                    boolean filtCat_PlakamiSatiyorum, String lastTime,
                                    String company, String vehicleBrand,
                                    String vehicleModel, String vehicleModelYear,
                                    boolean ModelYearAndOver, String stCity,
                                    String stTown, String stTime,
                                    String enCity, String enTown,
                                    String enTime, String SortCreateTime,
                                    String serviceType) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_search(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                        ps.setBoolean(1, filtCat_IsimVarAracAriyorum);
                        ps.setBoolean(2, filtCat_AracimVarIsAriyorum);
                        ps.setBoolean(3, filtCat_AracimVarSoforAriyorum);
                        ps.setBoolean(4, filtCat_AracimVarHostesAriyorum);
                        ps.setBoolean(5, filtCat_HostesimIsAriyorum);
                        ps.setBoolean(6, filtCat_SoforumIsAriyorum);
                        ps.setBoolean(7, filtCat_PlakamiSatiyorum);
                        ps.setString(8, lastTime);
                        ps.setString(9, company);
                        ps.setString(10, vehicleBrand);
                        ps.setString(11, vehicleModel);
                        ps.setString(12, vehicleModelYear);
                        ps.setBoolean(13, ModelYearAndOver);
                        ps.setString(14, stCity);
                        ps.setString(15, stTown);
                        ps.setString(16, stTime);
                        ps.setString(17, enCity);
                        ps.setString(18, enTown);
                        ps.setString(19, enTime);
                        ps.setString(20, SortCreateTime);
                        ps.setString(21, serviceType);
                        
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("iln_Id"));
                                            ab.setAd_Category_Id(rs.getInt("iln_KategoriId"));
                                            ab.setAd_Title(rs.getString("iln_Baslik"));
                                            ab.setAd_Comment(rs.getString("iln_Aciklama"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("iln_Aciklama")).text());
                                            ab.setAd_Type(rs.getString("iln_Tipi"));
                                            ab.setAd_OvnerAccountId(rs.getString("iln_Sahibi_Id"));
                                            ab.setAd_CreateTime(rs.getTimestamp("iln_OlusturmaTarihi"));
                                            ab.setAd_Category_Name(rs.getString("iln_Kategori"));
                                            ab.setAd_PublishDate(rs.getTimestamp("iln_OnaylamaTarihi"));
                                             AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("iln_Sahibi_Id2"));
                                            abx.setAccount_FirstName(rs.getString("iln_Sahibi_Ad"));
                                            abx.setAccount_LastName(rs.getString("iln_Sahibi_Soyad"));
                                            abx.setAccount_EmailAddress(rs.getString("iln_Sahibi_Email"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("iln_Sahibi_Telefon"));
                                            abx.setAccount_MembershipType(rs.getString("iln_Sahibi_UyelikTipi"));
                                            abx.setAccount_ActivityArea(rs.getString("iln_Sahibi_FaliyetAlani"));
                                            abx.setAccount_Type(rs.getString("iln_Sahibi_Yetki"));
                                             ab.setAccountBean(abx);
                                             CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            cb.setCompany_Type(rs.getString("iln_Sahibi_FirmaTipi"));
                                            cb.setCompany_ActivityArea(rs.getString("iln_Sahibi_FirmaFaliyetAlani"));
                                            cb.setCompany_Name(rs.getString("iln_Sahibi_FirmaKısaAdi"));
                                            cb.setCompany_FullName(rs.getString("iln_Sahibi_FirmaUzunAdi"));
                                            cb.setCompany_LogoUrl(rs.getString("iln_Sahibi_FirmaLogoUrl"));
                                            ab.setCorporateAccountBean(cb);
                                           Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("iln_IsmVrArcAryrm_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("iln_IsmVrArcAryrm_Fiyat"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("iln_IsmVrArcAryrm_ServisTipi"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("iln_IsmVrArcAryrm_ServisSuresi"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("iln_IsmVrArcAryrm_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("iln_IsmVrArcAryrm_CalisilacakGun"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("iln_IsmVrArcAryrm_OdemeSekli"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("iln_IsmVrArcAryrm_YolcuSayisi"));    
                                            ab.setAdIsimVarAracAriyorum(iar);
                                            Vehicle vcxx = new Vehicle();
                                            vcxx.setVehicle_Typ(rs.getString("iln_IsmVrArcAryrm_AracTipi"));
                                            if(rs.getString("iln_IsmVrArcAryrm_HzlAracMarka")!=null){
                                                if(!rs.getString("iln_IsmVrArcAryrm_HzlAracMarka").equals("")){
                                                    String[] vbs = rs.getString("iln_IsmVrArcAryrm_HzlAracMarka").split(","); 
                                                    VehicleBrandAndModelDao vb = new VehicleBrandAndModelDao(); 
                                                        String vbx = ""; 
                                                        for (String x : vbs) {
                                                            if(x != null){
                                                                if(!x.equals("") && !x.equals("0")){
                                                                    vbx = vbx+", "+vb.getVehicleBrandWithId(Integer.parseInt(x)).getVehicleBrand_Name().toString();
                                                                }
                                                                else{vbx=", 0";} 
                                                            }
                                                        }
                                                    vbx = vbx.substring(1);                                           
                                                    vcxx.setVehicle_Brand(vbx);
                                                }    
                                            }
                                            else{vcxx.setVehicle_Brand("");}
                                            vcxx.setVehicle_BrandNotMatter(rs.getBoolean("iln_IsmVrArcAryrm_HzlAracMarkaFarketmez"));
                                            vcxx.setVehicle_Model(rs.getString("iln_IsmVrArcAryrm_HzlAracModel"));
                                            vcxx.setVehicle_ModelYear(rs.getString("iln_IsmVrArcAryrm_HzlAracYili"));
                                            vcxx.setVehicle_ModelYearAndOver(rs.getBoolean("iln_IsmVrArcAryrm_HzlAracYiliVeUzeri"));
                                            vcxx.setVehicle_ModelYearNotMatter(rs.getBoolean("iln_IsmVrArcAryrm_HzlAracYiliFarketmez"));
                                            ab.setAdIsimVarAracAriyorum_vehicle(vcxx);
                                            Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Id(rs.getString("iln_ArcmVrSfrsAryrm_Id"));
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("iln_ArcmVrSfrsAryrm_Fiyat"));    
                                            asax.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("iln_ArcmVrSfrsAryrm_ServisSuresi"));                
                                            asax.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("iln_ArcmVrSfrsAryrm_YolcuSayisi"));    
                                            asax.setAd_AracimVarSoforAriyorum_Km(rs.getString("iln_ArcmVrSfrsAryrm_Km"));                        
                                            asax.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("iln_ArcmVrSfrsAryrm_CalisilacakGun"));                    
                                            asax.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("iln_ArcmVrSfrsAryrm_OdemeSekli"));               
                                            asax.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("iln_ArcmVrSfrsAryrm_ServisTipi"));                    
                                            ab.setAd_AracimVarSoforAriyorum(asax);
                                          Ad_AracimVarHostesAriyorum ahax = new Ad_AracimVarHostesAriyorum();
                                            ahax.setAd_AracimVarHostesAriyorum_Id(rs.getString("iln_ArcmVrHstsAryrm_Id"));                                 
                                            ahax.setAd_AracimVarHostesAriyorum_Cost(rs.getFloat("iln_ArcmVrHstsAryrm_Fiyat"));                           
                                            ahax.setAd_AracimVarHostesAriyorum_school(rs.getString("iln_ArcmVrHstsAryrm_Okul"));                      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_AnaOkulu"));       
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_IlkOgretim"));      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_highSchool(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_Lise"));       
                                            ab.setAdAracimVarHostesAriyorum(ahax);
                                            Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("iln_ArcmVrIsAryrm_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax);
                                             Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("iln_ArcmVrIsAryrm_AracId"));
                                            aiaxx.setVehicle_Brand(rs.getString("iln_ArcmVrIsAryrm_AracMarkaAd"));
                                            aiaxx.setVehicle_Model(rs.getString("iln_ArcmVrIsAryrm_AracModel"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("iln_ArcmVrIsAryrm_AracModelYılı"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaIlKodu"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("iln_ArcmVrIsAryrm_AracPlakaHarfKodu"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaNumaraKodu"));
                                            aiaxx.setVehicle_Km(rs.getInt("iln_ArcmVrIsAryrm_AracKm"));
                                            aiaxx.setVehicle_Color(rs.getString("iln_ArcmVrIsAryrm_AracRenk"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("iln_ArcmVrIsAryrm_AracFirmaLogosu"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_1"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_2"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_3"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_4"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_5"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_6"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_7"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_8"));
                                            vimgx.setVehicleVideoUrl(rs.getString("iln_ArcmVrIsAryrm_AracVideo"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);
                                            Vehicle vcx = new Vehicle();
                                            vcx.setVehicle_Id(rs.getString("iln_ArcmVrIsAryrm_AracId"));    
                                            vcx.setVehicle_Brand(rs.getString("iln_ArcmVrIsAryrm_AracMarkaAd"));
                                            vcx.setVehicle_Model(rs.getString("iln_ArcmVrIsAryrm_AracModel"));                  
                                            vcx.setVehicle_ModelYear(rs.getString("iln_ArcmVrIsAryrm_AracModelYılı"));
                                            vcx.setVehicle_PlateProvinceCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaIlKodu"));          
                                            vcx.setVehicle_PlateLatterCode(rs.getString("iln_ArcmVrIsAryrm_AracPlakaHarfKodu"));            
                                            vcx.setVehicle_PlateNumberCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaNumaraKodu"));            
                                            vcx.setVehicle_Km(rs.getInt("iln_ArcmVrIsAryrm_AracKm"));                       
                                            vcx.setVehicle_Color(rs.getString("iln_ArcmVrIsAryrm_AracRenk"));                       
                                            vcx.setVehicle_CompanyLogoText(rs.getString("iln_ArcmVrIsAryrm_AracFirmaLogosu"));  
                                            vcx.setVehicle_ServiceTypes(rs.getString("iln_ArcmVrIsAryrm_AracServisTipi"));
                                            VehicleImages vimg = new VehicleImages();
                                            vimg.setVehicleImage_GalleryPtoho_1_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_1"));
                                            vimg.setVehicleImage_GalleryPtoho_2_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_2"));
                                            vimg.setVehicleImage_GalleryPtoho_3_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_3"));
                                            vimg.setVehicleImage_GalleryPtoho_4_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_4"));
                                            vimg.setVehicleImage_GalleryPtoho_5_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_5"));
                                            vimg.setVehicleImage_GalleryPtoho_6_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_6"));
                                            vimg.setVehicleImage_GalleryPtoho_7_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_7"));
                                            vimg.setVehicleImage_GalleryPtoho_8_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_8"));
                                            vimg.setVehicleVideoUrl(rs.getString("iln_ArcmVrIsAryrm_AracVideo"));
                                            vcx.setVehicleImages(vimg);
                                            ab.setAdAracimVarIsAriyorum_vehicle(vcx);
                                            Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("iln_HstsmIsAryrm_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("Hst_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("Hst_DogumTarihi"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("Hst_DogumYeri"));
                                            if(rs.getDate("Hst_DogumTarihi") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("Hst_DogumTarihi"));
                                                int year = cal.get(Calendar.YEAR);
                                                Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);
                                                
                                                if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            }
                                            else{hostess.setHostess_yasi(0);}
                                            
                                            hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);
                                             Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("iln_SfrmIsAryrm_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("Sfr_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("Sfr_dogumTarihi"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("Sfr_dogumYeri"));                
                                            drv.setDriver_Fee(rs.getFloat("Sfr_IstenenUcret"));   
                                            if(rs.getDate("Sfr_dogumTarihi") != null){
                                        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("Sfr_dogumTarihi"));
                                                int year = cal.get(Calendar.YEAR);
                                                Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);
                                                
                                                if(year2-year >= 18){
                                                   drv.setDriver_yasi(year2-year); 
                                                }
                                                else{drv.setDriver_yasi(0);}
                                                
                                            }
                                            else{drv.setDriver_yasi(0);}
                                            
                                            sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);
                                            Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);
                                            
                                            adList.add(ab);
                                            
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
        
        return adList;
    }public List<Ad_Bean> getDublicatedAd(   boolean filtCat_IsimVarAracAriyorum, boolean filtCat_AracimVarIsAriyorum, 
                                            boolean filtCat_AracimVarSoforAriyorum, boolean filtCat_AracimVarHostesAriyorum, 
                                            boolean filtCat_HostesimIsAriyorum, boolean filtCat_SoforumIsAriyorum, 
                                            boolean filtCat_PlakamiSatiyorum, String lastTime,
                                            String company, String vehicleBrand,
                                            String vehicleModel, String vehicleModelYear,
                                            boolean ModelYearAndOver, String stCity,
                                            String stTown, String stTime,
                                            String enCity, String enTown,
                                            String enTime, String SortCreateTime,
                                            String serviceType, String adOvnerAccountId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_getDublicated(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
                        ps.setBoolean(1, filtCat_IsimVarAracAriyorum);
                        ps.setBoolean(2, filtCat_AracimVarIsAriyorum);
                        ps.setBoolean(3, filtCat_AracimVarSoforAriyorum);
                        ps.setBoolean(4, filtCat_AracimVarHostesAriyorum);
                        ps.setBoolean(5, filtCat_HostesimIsAriyorum);
                        ps.setBoolean(6, filtCat_SoforumIsAriyorum);
                        ps.setBoolean(7, filtCat_PlakamiSatiyorum);
                        ps.setString(8, lastTime);
                        ps.setString(9, company);
                        ps.setString(10, vehicleBrand);
                        ps.setString(11, vehicleModel);
                        ps.setString(12, vehicleModelYear);
                        ps.setBoolean(13, ModelYearAndOver);
                        ps.setString(14, stCity);
                        ps.setString(15, stTown);
                        ps.setString(16, stTime);
                        ps.setString(17, enCity);
                        ps.setString(18, enTown);
                        ps.setString(19, enTime);
                        ps.setString(20, SortCreateTime);
                        ps.setString(21, serviceType);
                        ps.setString(22, adOvnerAccountId);
                        ResultSet rs = ps.executeQuery();;
                        

                        while (rs.next()) { Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("iln_Id"));
                                            ab.setAd_Category_Id(rs.getInt("iln_KategoriId"));
                                            ab.setAd_Title(rs.getString("iln_Baslik"));
                                            ab.setAd_Comment(rs.getString("iln_Aciklama"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("iln_Aciklama")).text());
                                            ab.setAd_Type(rs.getString("iln_Tipi"));
                                            ab.setAd_OvnerAccountId(rs.getString("iln_Sahibi_Id"));
                                            ab.setAd_CreateTime(rs.getTimestamp("iln_OlusturmaTarihi"));
                                            ab.setAd_Category_Name(rs.getString("iln_Kategori"));
                                            ab.setAd_IsPublish(rs.getBoolean("iln_Yayindami"));
                                             AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("iln_Sahibi_Id2"));
                                            abx.setAccount_FirstName(rs.getString("iln_Sahibi_Ad"));
                                            abx.setAccount_LastName(rs.getString("iln_Sahibi_Soyad"));
                                            abx.setAccount_EmailAddress(rs.getString("iln_Sahibi_Email"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("iln_Sahibi_Telefon"));
                                            abx.setAccount_MembershipType(rs.getString("iln_Sahibi_UyelikTipi"));
                                            abx.setAccount_ActivityArea(rs.getString("iln_Sahibi_FaliyetAlani"));
                                            abx.setAccount_Type(rs.getString("iln_Sahibi_Yetki"));
                                            ab.setAccountBean(abx);
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            cb.setCompany_Type(rs.getString("iln_Sahibi_FirmaTipi"));
                                            cb.setCompany_ActivityArea(rs.getString("iln_Sahibi_FirmaFaliyetAlani"));
                                            cb.setCompany_Name(rs.getString("iln_Sahibi_FirmaKısaAdi"));
                                            cb.setCompany_FullName(rs.getString("iln_Sahibi_FirmaUzunAdi"));
                                            cb.setCompany_LogoUrl(rs.getString("iln_Sahibi_FirmaLogoUrl"));
                                            
                                            ab.setCorporateAccountBean(cb);
                                          
                                             Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("iln_IsmVrArcAryrm_Id"));
     
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("iln_IsmVrArcAryrm_Fiyat"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("iln_IsmVrArcAryrm_ServisTipi"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("iln_IsmVrArcAryrm_ServisSuresi"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("iln_IsmVrArcAryrm_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("iln_IsmVrArcAryrm_CalisilacakGun"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("iln_IsmVrArcAryrm_OdemeSekli"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("iln_IsmVrArcAryrm_YolcuSayisi"));            
                                            ab.setAdIsimVarAracAriyorum(iar);   
                                            Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Id(rs.getString("iln_ArcmVrSfrsAryrm_Id"));
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("iln_ArcmVrSfrsAryrm_Fiyat"));    
                                            asax.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("iln_ArcmVrSfrsAryrm_ServisSuresi"));                
                                            asax.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("iln_ArcmVrSfrsAryrm_YolcuSayisi"));    
                                            asax.setAd_AracimVarSoforAriyorum_Km(rs.getString("iln_ArcmVrSfrsAryrm_Km"));                        
                                            asax.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("iln_ArcmVrSfrsAryrm_CalisilacakGun"));                    
                                            asax.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("iln_ArcmVrSfrsAryrm_OdemeSekli"));               
                                            asax.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("iln_ArcmVrSfrsAryrm_ServisTipi"));                    
                                            ab.setAd_AracimVarSoforAriyorum(asax); 
                                            Ad_AracimVarHostesAriyorum ahax = new Ad_AracimVarHostesAriyorum();
                                            ahax.setAd_AracimVarHostesAriyorum_Id(rs.getString("iln_ArcmVrHstsAryrm_Id"));                                 
                                            ahax.setAd_AracimVarHostesAriyorum_Cost(rs.getFloat("iln_ArcmVrHstsAryrm_Fiyat"));                           
                                            ahax.setAd_AracimVarHostesAriyorum_school(rs.getString("iln_ArcmVrHstsAryrm_Okul"));                      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_kindergarten(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_AnaOkulu"));       
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_primarySchool(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_IlkOgretim"));      
                                            ahax.setAd_AracimVarHostesAriyorum_schoolType_highSchool(rs.getBoolean("iln_ArcmVrHstsAryrm_OkulTipi_Lise"));       
                                            ab.setAdAracimVarHostesAriyorum(ahax);   
                                            Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("iln_ArcmVrIsAryrm_Id"));  
                                            Vehicle vc = new Vehicle();
                                            vc.setVehicle_Id(rs.getString("iln_ArcmVrIsAryrm_AracId"));
                                            vc.setVehicle_Brand(rs.getString("iln_ArcmVrIsAryrm_AracMarkaAd"));
                                            vc.setVehicle_PlateProvinceCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaIlKodu"));
                                            vc.setVehicle_PlateLatterCode(rs.getString("iln_ArcmVrIsAryrm_AracPlakaHarfKodu"));
                                            vc.setVehicle_PlateNumberCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaNumaraKodu"));
                                            
                                            ab.setAdAracimVarIsAriyorum_vehicle(vc);
                                            ab.setAdAracimVarIsAriyorum(aiax);
                                            Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("iln_HstsmIsAryrm_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("Hst_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("Hst_DogumTarihi"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("Hst_DogumYeri"));
                                            
                                            if(rs.getDate("Hst_DogumTarihi") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("Hst_DogumTarihi"));
                                                int year = cal.get(Calendar.YEAR);
                                                
                                                Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);
                                                
                                                if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            }
                                            else{hostess.setHostess_yasi(0);}
                                            
                                            hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);
                                            Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("iln_SfrmIsAryrm_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("Sfr_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("Sfr_dogumTarihi"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("Sfr_dogumYeri"));                
                                            drv.setDriver_Fee(rs.getFloat("Sfr_IstenenUcret"));   
                                            sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);
                                            Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);
                                            AdRouteBean adrb = new AdRouteBean();
                                            adrb.setAdRoute_StartPosition_City(rs.getString("adRoute_StartPosition_City"));
                                            adrb.setAdRoute_StartPosition_Town(rs.getString("adRoute_StartPosition_Town"));
                                            adrb.setAdRoute_StartPosition_Neighborhood(rs.getString("adRoute_StartPosition_Neighborhood"));
                                            adrb.setAdRoute_EndPosition_City(rs.getString("adRoute_EndPosition_City"));
                                            adrb.setAdRoute_EndPosition_Town(rs.getString("adRoute_EndPosition_Town"));
                                            adrb.setAdRoute_EndPosition_Neighborhood(rs.getString("adRoute_EndPosition_Neighborhood"));
                                            ab.setAdrb(adrb);
                                            
                                            adList.add(ab);
                                            
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
        
        return adList;
    }public List<Ad_Bean> getDublicatedAdPlate(  int PlateProvinceCode, String PlateLatterCode, int PlateNumberCode, String adOvnerAccountId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  ps = con.prepareCall("{call pro_ad_getDublicated_plate(?,?,?,?)}");   
                        ps.setInt(1, PlateProvinceCode);
                        ps.setString(2, PlateLatterCode);
                        ps.setInt(3, PlateNumberCode);
                        ps.setString(4, adOvnerAccountId);
                        ResultSet rs = ps.executeQuery();;
                        

                        while (rs.next()) { 
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("iln_Id"));
                                            ab.setAd_Category_Id(rs.getInt("iln_KategoriId"));
                                            ab.setAd_Title(rs.getString("iln_Baslik"));
                                            ab.setAd_Comment(rs.getString("iln_Aciklama"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("iln_Aciklama")).text());
                                            ab.setAd_Type(rs.getString("iln_Tipi"));
                                            ab.setAd_OvnerAccountId(rs.getString("iln_Sahibi_Id"));
                                            ab.setAd_CreateTime(rs.getTimestamp("iln_OlusturmaTarihi"));
                                            ab.setAd_Category_Name(rs.getString("iln_Kategori"));
                                            ab.setAd_IsPublish(rs.getBoolean("iln_Yayindami"));
                                            AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("iln_Sahibi_Id2"));
                                            abx.setAccount_FirstName(rs.getString("iln_Sahibi_Ad"));
                                            abx.setAccount_LastName(rs.getString("iln_Sahibi_Soyad"));
                                            abx.setAccount_EmailAddress(rs.getString("iln_Sahibi_Email"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("iln_Sahibi_Telefon"));
                                            abx.setAccount_MembershipType(rs.getString("iln_Sahibi_UyelikTipi"));
                                            abx.setAccount_ActivityArea(rs.getString("iln_Sahibi_FaliyetAlani"));
                                            abx.setAccount_Type(rs.getString("iln_Sahibi_Yetki"));
                                            
                                            ab.setAccountBean(abx);
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            cb.setCompany_Type(rs.getString("iln_Sahibi_FirmaTipi"));
                                            cb.setCompany_ActivityArea(rs.getString("iln_Sahibi_FirmaFaliyetAlani"));
                                            cb.setCompany_Name(rs.getString("iln_Sahibi_FirmaKısaAdi"));
                                            cb.setCompany_FullName(rs.getString("iln_Sahibi_FirmaUzunAdi"));
                                            cb.setCompany_LogoUrl(rs.getString("iln_Sahibi_FirmaLogoUrl"));
                                            
                                            ab.setCorporateAccountBean(cb);
                                            Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);

                                           
                                            adList.add(ab);
                                            
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
        
        return adList;
    }
    public List<Ad_Bean> getAllAdWithNotPublish() {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   ps = con.prepareCall("{call pro_ad_getAll(?)}");   
                        ps.setString(1, "getAllAdWithNotPublish");
                                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { 
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("iln_Id"));
                                            ab.setAd_Id2(rs.getString("iln_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("iln_KategoriId"));
                                            ab.setAd_Title(rs.getString("iln_Baslik"));
                                            ab.setAd_Comment(rs.getString("iln_Aciklama"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("iln_Aciklama")).text());
                                            ab.setAd_Type(rs.getString("iln_Tipi"));
                                            ab.setAd_OvnerAccountId(rs.getString("iln_Sahibi_Id"));
                                            ab.setAd_Category_Name(rs.getString("iln_Kategori"));
                                            ab.setAd_CreateTime(rs.getTimestamp("iln_OlusturmaTarihi"));
                                            AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("iln_Sahibi_Id2"));
                                            abx.setAccount_FirstName(rs.getString("iln_Sahibi_Ad"));
                                            abx.setAccount_LastName(rs.getString("iln_Sahibi_Soyad"));
                                            abx.setAccount_EmailAddress(rs.getString("iln_Sahibi_Email"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("iln_Sahibi_Telefon"));
                                            abx.setAccount_MembershipType(rs.getString("iln_Sahibi_UyelikTipi"));
                                            abx.setAccount_Type(rs.getString("iln_Sahibi_Yetki"));
                                            abx.setAccount_ActivityArea(rs.getString("iln_Sahibi_FaliyetAlani"));
                                            abx.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            cb.setCompany_Type(rs.getString("iln_Sahibi_FirmaTipi"));
                                            cb.setCompany_ActivityArea(rs.getString("iln_Sahibi_FirmaFaliyetAlani"));
                                            cb.setCompany_Name(rs.getString("iln_Sahibi_FirmaKısaAdi"));
                                            cb.setCompany_FullName(rs.getString("iln_Sahibi_FirmaUzunAdi"));
                                            cb.setCompany_LogoUrl(rs.getString("iln_Sahibi_FirmaLogoUrl"));
                                            Ad_AracimVarHostesAriyorum ahax = new Ad_AracimVarHostesAriyorum();
                                            ahax.setAd_AracimVarHostesAriyorum_Id(rs.getString("iln_ArcmVrHstsAryrm_Id"));                                 
                                            ahax.setAd_AracimVarHostesAriyorum_Cost(rs.getFloat("iln_ArcmVrHstsAryrm_Fiyat"));                           
                                            ahax.setAd_AracimVarHostesAriyorum_school(rs.getString("iln_ArcmVrHstsAryrm_Okul"));                
                                            ab.setAdAracimVarHostesAriyorum(ahax);
                                            Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("iln_ArcmVrIsAryrm_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax);
                                            Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("iln_ArcmVrIsAryrm_AracId"));
                                            aiaxx.setVehicle_Brand(rs.getString("iln_ArcmVrIsAryrm_AracMarkaAd"));
                                            aiaxx.setVehicle_Model(rs.getString("iln_ArcmVrIsAryrm_AracModel"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("iln_ArcmVrIsAryrm_AracModelYılı"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaIlKodu"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("iln_ArcmVrIsAryrm_AracPlakaHarfKodu"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaNumaraKodu"));
                                            aiaxx.setVehicle_Km(rs.getInt("iln_ArcmVrIsAryrm_AracKm"));
                                            aiaxx.setVehicle_Color(rs.getString("iln_ArcmVrIsAryrm_AracRenk"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("iln_ArcmVrIsAryrm_AracFirmaLogosu"));
                                            VehicleImages vimgx = new VehicleImages();
                                            vimgx.setVehicleImage_GalleryPtoho_1_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_1"));
                                            vimgx.setVehicleImage_GalleryPtoho_2_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_2"));
                                            vimgx.setVehicleImage_GalleryPtoho_3_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_3"));
                                            vimgx.setVehicleImage_GalleryPtoho_4_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_4"));
                                            vimgx.setVehicleImage_GalleryPtoho_5_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_5"));
                                            vimgx.setVehicleImage_GalleryPtoho_6_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_6"));
                                            vimgx.setVehicleImage_GalleryPtoho_7_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_7"));
                                            vimgx.setVehicleImage_GalleryPtoho_8_Url(rs.getString("iln_ArcmVrIsAryrm_AracResmi_8"));
                                            vimgx.setVehicleVideoUrl(rs.getString("iln_ArcmVrIsAryrm_AracVideo"));
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);
                                            Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Id(rs.getString("iln_ArcmVrSfrsAryrm_Id"));
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("iln_ArcmVrSfrsAryrm_Fiyat"));    
                                            asax.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("iln_ArcmVrSfrsAryrm_ServisSuresi"));                
                                            asax.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("iln_ArcmVrSfrsAryrm_YolcuSayisi"));    
                                            asax.setAd_AracimVarSoforAriyorum_Km(rs.getString("iln_ArcmVrSfrsAryrm_Km"));                        
                                            asax.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("iln_ArcmVrSfrsAryrm_CalisilacakGun"));                    
                                            asax.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("iln_ArcmVrSfrsAryrm_OdemeSekli"));               
                                            asax.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("iln_ArcmVrSfrsAryrm_ServisTipi"));    
                                            ab.setAd_AracimVarSoforAriyorum(asax);
                                            Vehicle aiaxxx = new Vehicle();
                                            aiaxxx.setVehicle_Id(rs.getString("iln_ArcmVrSfrsAryrm_AracId"));
                                            ab.setAdAracimVarSoforAriyorum_vehicle(aiaxxx);
                                            Ad_HostesimİsAriyorum_Bean hiab = new Ad_HostesimİsAriyorum_Bean();
                                            hiab.setAd_HostesimIsAriyorum_Id(rs.getString("iln_HstsmIsAryrm_Id"));   
                                            Hostess hostess = new Hostess();
                                            hostess.setHostess_Id(rs.getString("Hst_Id"));                        
                                            hostess.setHostess_BirthDate(rs.getDate("Hst_DogumTarihi"));                   
                                            hostess.setHostess_PlaceOfBirth(rs.getString("Hst_DogumYeri"));
                                            hostess.setHostess_ProfilePictureUrl(rs.getString("Hst_ProfilResimUrl"));
                                            if(rs.getDate("Hst_DogumTarihi") != null){
                                                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal.setTime(rs.getDate("Hst_DogumTarihi"));
                                                int year = cal.get(Calendar.YEAR);
                                                
                                                Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
                                                cal2.setTime(new Date());
                                                int year2 = cal2.get(Calendar.YEAR);
                                                
                                                if(year2-year >= 18){ hostess.setHostess_yasi(year2-year); }
                                                else{hostess.setHostess_yasi(0);}
                                            }
                                            else{hostess.setHostess_yasi(0);}
                                            
                                            hiab.setHostess(hostess);
                                            ab.setAdHostesimIsAriyorumBean(hiab);
                                            Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();
                                            sia.setAd_SoforumIsAriyorum_Id(rs.getString("iln_SfrmIsAryrm_Id"));     
                                            Driver drv = new Driver();
                                            drv.setDriver_Id(rs.getString("Sfr_Id"));                          
                                            drv.setDriver_BirthDate(rs.getDate("Sfr_dogumTarihi"));                    
                                            drv.setDriver_PlaceOfBirth(rs.getString("Sfr_dogumYeri"));                
                                            drv.setDriver_Fee(rs.getFloat("Sfr_IstenenUcret"));   
                                            drv.setDriver_ProfilePictureUrl(rs.getString("Sfr_ProfilResimUrl"));
                                            sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);
                                            Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_Id(rs.getString("Ad_PlakamiSatiyorum_Id"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_AraçlaBirliktemi(rs.getBoolean("Ad_PlakamiSatiyorum_AraclaBirliktemi"));
                                            pstx.setAd_PlakamiSatiyorum_YolBelgesiVarmi(rs.getBoolean("Ad_PlakamiSatiyorum_YolBelgesiVarmi"));
                                            pstx.setAd_PlakamiSatiyorum_NoterSatislimi(rs.getBoolean("Ad_PlakamiSatiyorum_NoterSatislimi"));
                                            pstx.setAd_PlakamiSatiyorum_Hisselimi(rs.getBoolean("Ad_PlakamiSatiyorum_Hisselimi"));
                                            ab.setAdPlakamiSatiyorum(pstx);
                                            Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("iln_IsmVrArcAryrm_Id"));
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("iln_IsmVrArcAryrm_Fiyat"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("iln_IsmVrArcAryrm_ServisTipi"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("iln_IsmVrArcAryrm_ServisSuresi"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("iln_IsmVrArcAryrm_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("iln_IsmVrArcAryrm_CalisilacakGun"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("iln_IsmVrArcAryrm_OdemeSekli"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("iln_IsmVrArcAryrm_YolcuSayisi"));            
                                            ab.setAdIsimVarAracAriyorum(iar);
                                            AdRouteBean adrb = new AdRouteBean();
                                            adrb.setAdRoute_StartPosition_City(rs.getString("adRoute_StartPosition_City"));
                                            adrb.setAdRoute_StartPosition_Town(rs.getString("adRoute_StartPosition_Town"));
                                            adrb.setAdRoute_StartPosition_Neighborhood(rs.getString("adRoute_StartPosition_Neighborhood"));
                                            adrb.setAdRoute_EndPosition_City(rs.getString("adRoute_EndPosition_City"));
                                            adrb.setAdRoute_EndPosition_Town(rs.getString("adRoute_EndPosition_Town"));
                                            adrb.setAdRoute_EndPosition_Neighborhood(rs.getString("adRoute_EndPosition_Neighborhood"));
                                            ab.setAdrb(adrb);
                                            ab.setAdSize_ToDay_ForUser(rs.getInt("iln_Shb_BuGunkuIlanlarinSayisi"));
                                            ab.setAdSize_All_ForUser(rs.getInt("iln_Shb_TumIlanlarinSayisi"));
                                            ab.setAccountBean(abx);
                                            ab.setCorporateAccountBean(cb);
                                            adList.add(ab);
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
        
        return adList;
    } public List<Ad_Bean> getAllAdWithPublish() {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac "
                                        + "WHERE a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC";
                        
                        ps = con.prepareStatement(query1);                   
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList;
    } public List<Ad_Bean> getUserAdWithPublish(String ovnerId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac "
                                        + "WHERE a.ad_OvnerAccountId = ? "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, ovnerId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList;
    }  public List<Ad_Bean> getUserAdWithPublish2(String ovnerId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac "
                                        + "WHERE a.ad_OvnerAccountId = ? "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "AND a.ad_IsActive = 1 "
                                        + "AND ac.account_IsActive = 1 "
                                        + "AND a.ad_UserEnableDisable = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC LIMIT 100 ";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, ovnerId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList;
    }public List<Ad_Bean> getUserTopTenAdWithPublish(String ovnerId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac "
                                        + "WHERE a.ad_OvnerAccountId = ? "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "AND a.ad_IsActive = 1 "
                                        + "AND ac.account_IsActive = 1 "
                                        + "AND a.ad_UserEnableDisable = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC "
                                        + "LIMIT 10";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, ovnerId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList;  } public List<Ad_Bean> getCompanyTopFiftyAdWithId(String companyId) {
        
        int sonuc = 0;
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        
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
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac, company_ co "
                                        + "WHERE co.company_Id = ? "
                                        + "AND ac.company_Id = co.company_Id "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "AND a.ad_IsActive = 1 "
                                        + "AND ac.account_IsActive = 1 "
                                        + "AND a.ad_UserEnableDisable = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC "
                                        + "LIMIT 50";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, companyId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList;  }  public List<Ad_Bean> getCompanyTopFiftyAdWithName(String companyName) {   
        int sonuc = 0;  List<Ad_Bean> adList = new ArrayList<Ad_Bean>();  Connection con = null;  PreparedStatement ps = null;     con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac, company_ co "
                                        + "WHERE co.company_UrlName = ? "
                                        + "AND ac.company_Id = co.company_Id "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "AND a.ad_IsPublish = 1 "
                                        + "AND a.ad_IsActive = 1 "
                                        + "AND ac.account_IsActive = 1 "
                                        + "AND a.ad_UserEnableDisable = 1 "
                                        + "ORDER BY a.ad_CreateTime DESC "
                                        + "LIMIT 50";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, companyName);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));                                           
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        } return adList;  } public List<Ad_Bean> getUserAllAd(String ovnerId) {
        
        int sonuc = 0;   List<Ad_Bean> adList = new ArrayList<Ad_Bean>();   Connection con = null;   PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a , `ilan_tasimacilar`.`ad_category` c , `ilan_tasimacilar`.`account_` ac "
                                        + "WHERE a.ad_OvnerAccountId = ? "
                                        + "AND a.ad_Category_Id=c.ad_Category_Id "
                                        + "AND a.ad_OvnerAccountId = ac.account_Id "
                                        + "ORDER BY a.ad_CreateTime DESC";
                        
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, ovnerId);
                                      
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AccountBean ac = new AccountBean();
                                            ac.setAccount_FirstName(rs.getString("account_FirstName"));
                                            ac.setAccount_LastName(rs.getString("account_LastName"));
                                            ac.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                            
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ab.setAccountBean(ac);
                                            adList.add(ab);
                                            
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
        
        return adList; } public List<Ad_Bean> getAllAdWithOvnerAccountId(String OvnerAccountId) {
          int sonuc = 0;  List<Ad_Bean> adList = new ArrayList<Ad_Bean>();   Connection con = null; PreparedStatement ps = null;   con = ConnectionManager.GetConnection();
  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT * "
                                        + "FROM `ilan_tasimacilar`.`ad_` a "
                                        + "LEFT JOIN ad_category c ON a.ad_Category_Id = c.ad_Category_Id "
                                        + "LEFT JOIN ad_aracim_var_hostes_ariyorum aha ON a.ad_Id = aha.Ad_Id "
                                        + "LEFT JOIN ad_aracim_var_sofor_ariyorum asa ON a.ad_Id = asa.Ad_Id "
                                        + "LEFT JOIN ad_soforum_is_ariyorum sia ON a.ad_Id = sia.ad_Id "
                                        + "LEFT JOIN drivers drv ON drv.driver_Id = sia.driver_Id "
                                        + "LEFT JOIN ad_plakami_satiyorum plk ON a.ad_Id = plk.ad_Id "
                                        + "LEFT JOIN ad_aracim_var_is_ariyorum aia ON a.ad_Id = aia.Ad_Id "
                                        + "LEFT JOIN vehicle_ v2 ON aia.vehicle_Id = v2.vehicle_Id "
                                        + "WHERE a.ad_OvnerAccountId =? "
                                        + "AND a.ad_IsActive =1 "
                                        + "ORDER BY a.ad_CreateTime DESC ";
                      
                        ps = con.prepareStatement(query1);  
                        ps.setString(1, OvnerAccountId);
                                  
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {    
                                            Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("ad_Comment")).text());
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
                                            ab.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            ab.setAd_UserEnableDisable(rs.getBoolean("ad_UserEnableDisable"));
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                              Ad_AracimVarHostesAriyorum ahax = new Ad_AracimVarHostesAriyorum();
                                            ahax.setAd_AracimVarHostesAriyorum_school(rs.getString("Ad_AracimVarHostesAriyorum_School"));       
                                            ab.setAdAracimVarHostesAriyorum(ahax);
                                             Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("Ad_AracimVarSoforAriyorum_Cost"));
                                            asax. setAd_AracimVarSoforAriyorum_Km(rs.getString("Ad_AracimVarSoforAriyorum_Km"));
                                            ab.setAd_AracimVarSoforAriyorum(asax);
                                           Ad_SoforumİsAriyorum_Bean sia = new Ad_SoforumİsAriyorum_Bean();  
                                            Driver drv = new Driver();               
                                            drv.setDriver_Fee(rs.getFloat("driver_Fee"));   
                                            sia.setDriver(drv);
                                            ab.setAdSoforumIsAriyorumBean(sia);
                                             Ad_PlakamiSatiyorum pstx = new Ad_PlakamiSatiyorum();
                                            pstx.setAd_PlakamiSatiyorum_ucret(rs.getInt("Ad_PlakamiSatiyorum_Ucret"));
                                            pstx.setAd_PlakamiSatiyorum_PlateProvinceCode(rs.getInt("Ad_PlakamiSatiyorum_PlateProvinceCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateLatterCode(rs.getString("Ad_PlakamiSatiyorum_PlateLatterCode"));
                                            pstx.setAd_PlakamiSatiyorum_PlateNumberCode(rs.getInt("Ad_PlakamiSatiyorum_PlateNumberCode"));
                                            ab.setAdPlakamiSatiyorum(pstx);
                                            
                                            Vehicle aiav = new Vehicle();
                                            aiav.setVehicle_PlateProvinceCode(rs.getInt("vehicle_PlateProvinceCode"));
                                            aiav.setVehicle_PlateLatterCode(rs.getString("vehicle_PlateLatterCode"));
                                            aiav.setVehicle_PlateNumberCode(rs.getInt("vehicle_PlateNumberCode"));
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiav);
                                            
                                            adList.add(ab);
                                            
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
        
        return adList; }public int publishAd(String adId){    
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_IsPublish=1 WHERE ad_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adId);
                
                        sonuc = ps.executeUpdate();
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }  return sonuc; } public int addPublishDate(String adId){
        
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_PublishDate=? WHERE ad_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(2, adId);
                
                        sonuc = ps.executeUpdate();
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;  }     public int addAdminNotes(String adminNote, String adId){
        
        int sonuc = 0;   Connection con = null;  PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_Notes=? WHERE ad_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adminNote);
                        ps.setString(2, adId);
                
                        sonuc = ps.executeUpdate();
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc; }  public int disableAd(String adId){
        
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;
   con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_IsActive=0 WHERE ad_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adId);
                
                        sonuc = ps.executeUpdate();
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;   } public int enableAd(String adId){
        
        int sonuc = 0; Connection con = null;   PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_IsActive=1 WHERE ad_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adId);
                
                        sonuc = ps.executeUpdate();
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;
    } public int enableDisableAdFromUser(String adId, String comment){
        
        int sonuc = 0;  Connection con = null;   PreparedStatement ps = null;
   con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   
                        if(adId != null && comment != null){
                            if(!adId.equals("") && !comment.equals("")){
                                String query = "";
                                
                                if(comment.equals("enable")){ query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_UserEnableDisable=1 WHERE ad_Id=? ;"; }
                                if(comment.equals("disable")){ query =  "UPDATE `ilan_tasimacilar`.`ad_` SET ad_UserEnableDisable=0 WHERE ad_Id=? ;"; }
                                
                                ps = con.prepareStatement(query);
                                ps.setString(1, adId);
                                
                                sonuc = ps.executeUpdate();
                            }
                        }
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }  return sonuc; }public int fastUpdateAd(Ad_Bean adb){
        
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;
  con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query1 = "";
                        String query2 = "";
        
                        if(adb.getAd_Category_Name().equals("Aracim var şöför arıyorum")){
                            
                            int S1, S2= 0;
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            S1 = ps.executeUpdate();
                            
                            
                            query2 = "UPDATE `ilan_tasimacilar`.`ad_aracim_var_sofor_ariyorum` "
                                   + "SET Ad_AracimVarSoforAriyorum_Cost=?, "
                                       + "Ad_AracimVarSoforAriyorum_ServiceTime = ?, "
                                       + "Ad_AracimVarSoforAriyorum_NumberOfPassengers = ?, "
                                       + "Ad_AracimVarSoforAriyorum_Km = ?, "
                                       + "Ad_AracimVarSoforAriyorum_DayToWork = ?, "
                                       + "Ad_AracimVarSoforAriyorum_PaymentMethod = ? "
                                   + "WHERE Ad_AracimVarSoforAriyorum_Id=? ;";
                            
                            ps = con.prepareStatement(query2);
                            ps.setFloat(1, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Cost());
                            ps.setString(2, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_ServiceTime());
                            ps.setInt(3, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_NumberOfPassengers());
                            ps.setString(4, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Km());
                            ps.setString(5, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_DayToWork());
                            ps.setString(6, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_PaymentMethod());
                            ps.setString(7, adb.getAd_AracimVarSoforAriyorum().getAd_AracimVarSoforAriyorum_Id());
                            S2 = ps.executeUpdate();
                           
                            if(S1==1 && S2==1){sonuc=1;}
                        }
                        if(adb.getAd_Category_Name().equals("Aracım var iş arıyorum")){
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            sonuc = ps.executeUpdate();
                            
                        }
                        if(adb.getAd_Category_Name().equals("İşim var araç arıyorum")){
                           
                            int S1, S2= 0;
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            S1 = ps.executeUpdate();
                            
                            
                            query2 = "UPDATE `ilan_tasimacilar`.`ad_lookingforvehicleforwork` "
                                   + "SET Ad_LookingForVehicleForWork_Cost = ?, "
                                       + "Ad_LookingForVehicleForWork_ServiceTime = ?, "
                                       + "Ad_LookingForVehicleForWork_NumberOfPassengers = ?, "
                                       + "Ad_LookingForVehicleForWork_Km = ?, "
                                       + "Ad_LookingForVehicleForWork_DayToWork = ?, "
                                       + "Ad_LookingForVehicleForWork_PaymentMethod = ? "
                                   + "WHERE Ad_LookingForVehicleForWork_Id =? ;";
                            
                            ps = con.prepareStatement(query2);
                            ps.setFloat(1, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Cost());
                            ps.setString(2, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_ServiceTime());
                            ps.setString(3, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_NumberOfPassengers());
                            ps.setString(4, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Km());
                            ps.setString(5, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_DayToWork());
                            ps.setString(6, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_PaymentMethod());
                            ps.setString(7, adb.getAdIsimVarAracAriyorum().getAd_LookingForVehicleForWork_Id());
                            S2 = ps.executeUpdate();
                           
                            if(S1==1 && S2==1){sonuc=1;}
                            
                        }
                        if(adb.getAd_Category_Name().equals("Şöförüm iş arıyorum")){
                            
                            int S1, S2= 0;
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            S1 = ps.executeUpdate();
                            
                            
                            query2 = "UPDATE `ilan_tasimacilar`.`drivers` "
                                   + "SET driver_PlaceOfBirth = ?, "
                                       + "driver_BirthDate = ?, "
                                       + "driver_Fee = ? "
                                   + "WHERE driver_Id =? ;";
                            
                            ps = con.prepareStatement(query2);
                            ps.setString(1, adb.getAdSoforumIsAriyorumBean().getDriver().getDriver_PlaceOfBirth());
                            ps.setTimestamp(2, adb.getAdSoforumIsAriyorumBean().getDriver().getDriver_BirthDate() == null ? null : new java.sql.Timestamp(adb.getAdSoforumIsAriyorumBean().getDriver().getDriver_BirthDate().getTime())); 
                            ps.setFloat(3, adb.getAdSoforumIsAriyorumBean().getDriver().getDriver_Fee());
                            ps.setString(4, adb.getAdSoforumIsAriyorumBean().getDriver().getDriver_Id());
                            S2 = ps.executeUpdate();
                           
                            if(S1==1 && S2==1){sonuc=1;}
                            
                        }
                        if(adb.getAd_Category_Name().equals("Hostesim iş arıyorum")){
                           
                            int S1, S2= 0;
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            S1 = ps.executeUpdate();
                            
                            
                            query2 = "UPDATE `ilan_tasimacilar`.`hostesses` "
                                   + "SET hostess_PlaceOfBirth = ?, "
                                       + "hostess_BirthDate = ? "
                                   + "WHERE hostess_Id =? ;";
                            
                            ps = con.prepareStatement(query2);
                            ps.setString(1, adb.getAdHostesimIsAriyorumBean().getHostess().getHostess_PlaceOfBirth());
                            ps.setTimestamp(2, adb.getAdHostesimIsAriyorumBean().getHostess().getHostess_BirthDate() == null ? null : new java.sql.Timestamp(adb.getAdHostesimIsAriyorumBean().getHostess().getHostess_BirthDate().getTime())); 
                            ps.setString(3, adb.getAdHostesimIsAriyorumBean().getHostess().getHostess_Id());
                            S2 = ps.executeUpdate();
                           
                            if(S1==1 && S2==1){sonuc=1;}
                            
                        }
                        if(adb.getAd_Category_Name().equals("Aracim var hostes arıyorum")){
                            
                            int S1, S2= 0;
                            
                            query1 = "UPDATE `ilan_tasimacilar`.`ad_` "
                                   + "SET ad_Title=?, "
                                       + "ad_Comment = ? "
                                   + "WHERE ad_Id=? ;";
                              
                            ps = con.prepareStatement(query1);
                            ps.setString(1, adb.getAd_Title());
                            ps.setString(2, adb.getAd_Comment());
                            ps.setString(3, adb.getAd_Id());
                            S1 = ps.executeUpdate();
                            
                            
                            query2 = "UPDATE `ilan_tasimacilar`.`ad_aracim_var_hostes_ariyorum` "
                                   + "SET Ad_AracimVarHostesAriyorum_Cost = ?, "
                                   + "Ad_AracimVarHostesAriyorum_School = ? "
                                   + "WHERE Ad_AracimVarHostesAriyorum_Id =? ;";
                            
                            ps = con.prepareStatement(query2);
                            ps.setFloat(1, adb.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Cost());
                            ps.setString(2, adb.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_school()); 
                            ps.setString(3, adb.getAdAracimVarHostesAriyorum().getAd_AracimVarHostesAriyorum_Id());
                            S2 = ps.executeUpdate();
                           
                            if(S1==1 && S2==1){sonuc=1;}
                            
                        }
                            
                            
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;  } public ArrayList<String> getAdRouteStartPositionCityList(int catId) {
        
        int sonuc = 0;  ArrayList<String> TownList = new ArrayList(); 
         Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT adRoute_StartPosition_City AS LABEL "
                                        + "FROM `ad_route`, `ad_` , account_ "
                                        + "where ad_route.ad_Id = ad_.ad_Id "
                                        + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                        + "AND ad_.ad_IsPublish = 1 "
                                        + "AND ad_.ad_IsActive = 1 "
                                        + "AND ad_.ad_UserEnableDisable = 1  "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_EndTime >= CURDATE() "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_Category_Id ="+catId+" "
                                        + "GROUP BY adRoute_StartPosition_City";
                        
                        
                        ps = con.prepareStatement(query1); 
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { TownList.add(rs.getString("LABEL"));  }  
            
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
        
        return TownList;  }     public ArrayList<String> getAdRouteEndPositionCityList(int catId) {
        
        int sonuc = 0;  ArrayList<String> TownList = new ArrayList(); 
          Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        String query1 =   "SELECT adRoute_EndPosition_City AS LABEL "
                                        + "FROM `ad_route`, `ad_` , account_ "
                                        + "where ad_route.ad_Id = ad_.ad_Id "
                                        + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                        + "AND ad_.ad_IsPublish = 1 "
                                        + "AND ad_.ad_IsActive = 1 "
                                        + "AND ad_.ad_UserEnableDisable = 1  "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_EndTime >= CURDATE() "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_Category_Id ="+catId+" "
                                        + "GROUP BY adRoute_EndPosition_City";
                        
                        
                        ps = con.prepareStatement(query1); 
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { TownList.add(rs.getString("LABEL"));  }  
            
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
        
        return TownList;
    }      public ArrayList<String> getAdRouteStartPositionTownList(int catId, String[] strtPosCity) {
          String strtPosCityListx = ""; if(strtPosCity != null && strtPosCity.length > 0){        for (String dl : strtPosCity) { strtPosCityListx = strtPosCityListx + '|' + dl.toString();  };       
        }  int sonuc = 0;ArrayList<String> TownList = new ArrayList();  Connection con = null;
        PreparedStatement ps = null;con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   String query1 =""
;                    
                        if(strtPosCityListx !=null && !strtPosCityListx.equals("")){
                
                            query1 =    "SELECT adRoute_StartPosition_Town AS LABEL "
                                      + "FROM `ad_route`, `ad_` , account_ "
                                      + "where ad_route.ad_Id = ad_.ad_Id "
                                      + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                      + "AND ad_.ad_IsPublish = 1 "
                                      + "AND ad_.ad_IsActive = 1 "
                                      + "AND ad_.ad_UserEnableDisable = 1  "
                                      + "AND account_.account_IsActive = 1 "
                                      + "AND ad_.ad_EndTime >= CURDATE() "
                                      + "AND account_.account_IsActive = 1 "
                                      + "AND ad_.ad_Category_Id ="+catId+" "
                                      + "AND ad_route.adRoute_StartPosition_City REGEXP '"+strtPosCityListx.substring(1)+"' "
                                      + "GROUP BY adRoute_StartPosition_Town "
                                      + "ORDER BY adRoute_StartPosition_Town ASC ";                  
                        }
                        else{
                            
                            query1 =  "SELECT adRoute_StartPosition_Town AS LABEL "
                                    + "FROM `ad_route`, `ad_` , account_ "
                                    + "where ad_route.ad_Id = ad_.ad_Id "
                                    + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                    + "AND ad_.ad_IsPublish = 1 "
                                    + "AND ad_.ad_IsActive = 1  "
                                    + "AND ad_.ad_UserEnableDisable = 1  "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_EndTime >= CURDATE() "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_Category_Id ="+catId+" "
                                    + "GROUP BY adRoute_StartPosition_Town "
                                    + "ORDER BY adRoute_StartPosition_Town ASC ";  
                        }
                
                        ps = con.prepareStatement(query1); 
                        ResultSet rs = ps.executeQuery();   

                        while (rs.next()) { TownList.add(rs.getString("LABEL"));  }  
            
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
        
        return TownList;
    }      public ArrayList<String> getAdRouteEndPositionTownList(int catId, String[] strtPosTwn, String[] endPosCity) { 
        
        String strtPosTwnListx = "";
        if(strtPosTwn != null && strtPosTwn.length > 0){
            for (String dl : strtPosTwn) { strtPosTwnListx = strtPosTwnListx + '|' + dl.toString();  };  
        }
           
        String endPosCityListx = "";
        if(endPosCity != null && endPosCity.length > 0){      
            for (String dl : endPosCity) { endPosCityListx = endPosCityListx + '|' + dl.toString();  };       
        }
        
        int sonuc = 0;
        ArrayList<String> TownList = new ArrayList(); 
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   String query1="";if(strtPosTwnListx != null && !strtPosTwnListx.equals("")){
                             if(endPosCityListx != null && !endPosCityListx.equals("")){ 
                             String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                                String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                                String[] avrupaVeAnadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR","ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                               
                                if(strtPosTwn != null && strtPosTwn.length > 0){
                                    
                                    List<String> lst = Arrays.asList(strtPosTwn);
                                    if(lst.size()==1 && lst.get(0).equals("AVRUPA YAKASI")){
 String avp = "";
                                        for (String dl : avrupa) { avp = avp + '|' + dl.toString();  }; 

                                        query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                        + "FROM `ad_route`, `ad_` , account_ "
                                        + "where ad_route.ad_Id = ad_.ad_Id "
                                        + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                        + "AND ad_.ad_IsPublish = 1 "
                                        + "AND ad_.ad_IsActive = 1 "
                                        + "AND ad_.ad_UserEnableDisable = 1  "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_EndTime >= CURDATE() "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_Category_Id ="+catId+" "
                                        + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                        + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+avp.substring(1)+"' "
                                        + "GROUP BY adRoute_EndPosition_Town "
                                        + "ORDER BY adRoute_EndPosition_Town ASC ";
                                    }

                                    else if(lst.size()==1 && lst.get(0).equals("ANADOLU YAKASI")){
                                        String and = "";
                                        for (String dl : anadolu) { and = and + '|' + dl.toString();  }; 

                                        query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                        + "FROM `ad_route`, `ad_` , account_ "
                                        + "where ad_route.ad_Id = ad_.ad_Id "
                                        + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                        + "AND ad_.ad_IsPublish = 1 "
                                        + "AND ad_.ad_IsActive = 1 "
                                        + "AND ad_.ad_UserEnableDisable = 1  "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_EndTime >= CURDATE() "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_Category_Id ="+catId+" "
                                        + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                        + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+and.substring(1)+"' "
                                        + "GROUP BY adRoute_EndPosition_Town "
                                        + "ORDER BY adRoute_EndPosition_Town ASC ";    

                                    }
                                    else if(lst.size()==1 ){
                                        if(!lst.get(0).equals("AVRUPA YAKASI") && !lst.get(0).equals("ANADOLU YAKASI")){
                                            query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                            + "FROM `ad_route`, `ad_` , account_ "
                                            + "where ad_route.ad_Id = ad_.ad_Id "
                                            + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                            + "AND ad_.ad_IsPublish = 1 "
                                            + "AND ad_.ad_IsActive = 1 "
                                            + "AND ad_.ad_UserEnableDisable = 1  "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_EndTime >= CURDATE() "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_Category_Id ="+catId+" "
                                            + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                            + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+strtPosTwnListx.substring(1)+"' "
                                            + "GROUP BY adRoute_EndPosition_Town "
                                            + "ORDER BY adRoute_EndPosition_Town ASC ";
                                        }

                                    }
                                    else if(lst.size()==2 && lst.get(0).equals("AVRUPA YAKASI") && lst.get(1).equals("ANADOLU YAKASI")){
String avpVand = "";
                                        for (String dl : avrupaVeAnadolu) { avpVand = avpVand + '|' + dl.toString();  }; 

                                        query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                        + "FROM `ad_route`, `ad_` , account_ "
                                        + "where ad_route.ad_Id = ad_.ad_Id "
                                        + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                        + "AND ad_.ad_IsPublish = 1 "
                                        + "AND ad_.ad_IsActive = 1 "
                                        + "AND ad_.ad_UserEnableDisable = 1  "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_EndTime >= CURDATE() "
                                        + "AND account_.account_IsActive = 1 "
                                        + "AND ad_.ad_Category_Id ="+catId+" "
                                        + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                        + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+avpVand.substring(1)+"' "
                                        + "GROUP BY adRoute_EndPosition_Town "
                                        + "ORDER BY adRoute_EndPosition_Town ASC ";
                                    }

                                    else{

                                        if(lst.get(0).equals("AVRUPA YAKASI") && lst.get(1).equals("ANADOLU YAKASI")){
                                            String avpVand = "";
                                            for (String dl : avrupaVeAnadolu) { avpVand = avpVand + '|' + dl.toString();  }; 

                                            query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                            + "FROM `ad_route`, `ad_` , account_ "
                                            + "where ad_route.ad_Id = ad_.ad_Id "
                                            + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                            + "AND ad_.ad_IsPublish = 1 "
                                            + "AND ad_.ad_IsActive = 1 "
                                            + "AND ad_.ad_UserEnableDisable = 1  "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_EndTime >= CURDATE() "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_Category_Id ="+catId+" "
                                            + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                            + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+avpVand.substring(1)+"' "
                                            + "GROUP BY adRoute_EndPosition_Town "
                                            + "ORDER BY adRoute_EndPosition_Town ASC ";
                                        }
                                        else if(lst.get(0).equals("AVRUPA YAKASI")){
                                            String avp = "";
                                            for (String dl : avrupa) { avp = avp + '|' + dl.toString();  }; 

                                            query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                            + "FROM `ad_route`, `ad_` , account_ "
                                            + "where ad_route.ad_Id = ad_.ad_Id "
                                            + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                            + "AND ad_.ad_IsPublish = 1 "
                                            + "AND ad_.ad_IsActive = 1 "
                                            + "AND ad_.ad_UserEnableDisable = 1  "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_EndTime >= CURDATE() "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_Category_Id ="+catId+" "
                                            + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                            + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+avp.substring(1)+"|"+strtPosTwnListx.substring(1)+"' "
                                            + "GROUP BY adRoute_EndPosition_Town "
                                            + "ORDER BY adRoute_EndPosition_Town ASC ";

                                        }
                                        else if(lst.get(0).equals("ANADOLU YAKASI")){
                                            String and = "";
                                            for (String dl : anadolu) { and = and + '|' + dl.toString();  }; 

                                            query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                            + "FROM `ad_route`, `ad_` , account_ "
                                            + "where ad_route.ad_Id = ad_.ad_Id "
                                            + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                            + "AND ad_.ad_IsPublish = 1 "
                                            + "AND ad_.ad_IsActive = 1 "
                                            + "AND ad_.ad_UserEnableDisable = 1  "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_EndTime >= CURDATE() "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_Category_Id ="+catId+" "
                                            + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                            + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+and.substring(1)+"|"+strtPosTwnListx.substring(1)+"' "
                                            + "GROUP BY adRoute_EndPosition_Town "
                                            + "ORDER BY adRoute_EndPosition_Town ASC ";  

                                        }
                                        else{
                                            query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                            + "FROM `ad_route`, `ad_` , account_ "
                                            + "where ad_route.ad_Id = ad_.ad_Id "
                                            + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                            + "AND ad_.ad_IsPublish = 1 "
                                            + "AND ad_.ad_IsActive = 1 "
                                            + "AND ad_.ad_UserEnableDisable = 1  "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_EndTime >= CURDATE() "
                                            + "AND account_.account_IsActive = 1 "
                                            + "AND ad_.ad_Category_Id ="+catId+" "
                                            + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' "    
                                            + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+strtPosTwnListx.substring(1)+"' "
                                            + "GROUP BY adRoute_EndPosition_Town "
                                            + "ORDER BY adRoute_EndPosition_Town ASC ";

                                        }
                                    }
                                }                                 
                            }
                            else{
                                
                                query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                    + "FROM `ad_route`, `ad_` , account_ "
                                    + "where ad_route.ad_Id = ad_.ad_Id "
                                    + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                    + "AND ad_.ad_IsPublish = 1 "
                                    + "AND ad_.ad_IsActive = 1 "
                                    + "AND ad_.ad_UserEnableDisable = 1  "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_EndTime >= CURDATE() "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_Category_Id ="+catId+" "
                                    + "AND ad_route.adRoute_StartPosition_Town REGEXP '"+strtPosTwnListx.substring(1)+"' "
                                    + "GROUP BY adRoute_EndPosition_Town "
                                    + "ORDER BY adRoute_EndPosition_Town ASC ";
                            }
                        
                            
                        }
                         else{
                           if(endPosCityListx != null && !endPosCityListx.equals("")){
                                query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                    + "FROM `ad_route`, `ad_` , account_ "
                                    + "where ad_route.ad_Id = ad_.ad_Id "
                                    + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                    + "AND ad_.ad_IsPublish = 1 "
                                    + "AND ad_.ad_IsActive = 1 "
                                    + "AND ad_.ad_EndTime >= CURDATE() "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_Category_Id ="+catId+" "
                                    + "AND ad_route.adRoute_EndPosition_City REGEXP '"+endPosCityListx.substring(1)+"' " 
                                    + "GROUP BY adRoute_EndPosition_Town "
                                    + "ORDER BY adRoute_EndPosition_Town ASC"; 
                            }
                             else{
                            
                                query1 =  "SELECT adRoute_EndPosition_Town AS LABEL "
                                    + "FROM `ad_route`, `ad_` , account_ "
                                    + "where ad_route.ad_Id = ad_.ad_Id "
                                    + "AND account_.account_Id = ad_.ad_OvnerAccountId "
                                    + "AND ad_.ad_IsPublish = 1 "
                                    + "AND ad_.ad_IsActive = 1 "
                                    + "AND ad_.ad_EndTime >= CURDATE() "
                                    + "AND account_.account_IsActive = 1 "
                                    + "AND ad_.ad_Category_Id ="+catId+" "
                                    + "GROUP BY adRoute_EndPosition_Town "
                                    + "ORDER BY adRoute_EndPosition_Town ASC";                  
                            }
                            
                               
                        }
                    
                        ps = con.prepareStatement(query1); 
                           
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { TownList.add(rs.getString("LABEL"));  }  
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
        
        return TownList;
    }   public int disableAdForOvnerChange(String adOvnerAccountId, String adOvnerAccountCompanyId){
        
        int sonuc = 0;  Connection con = null;   PreparedStatement ps = null;
   con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`ad_` "
                                      + "SET ad_OvnerAccountId ='"+adOvnerAccountId+"--"+adOvnerAccountCompanyId+"', "
                                          + "ad_IsActive=0 "
                                      + "WHERE ad_OvnerAccountId ='"+adOvnerAccountId+"'";

                        ps = con.prepareStatement(query);
                        
                        if(adOvnerAccountId != null && adOvnerAccountCompanyId != null){
                            if(!adOvnerAccountId.equals("") && !adOvnerAccountCompanyId.equals("")){
                                sonuc = ps.executeUpdate();
                            }
                            else{System.err.println(":::HATA:::"+this.getClass().getName()+":::Parametre bos geldi");}
                        }
                        else{System.err.println(":::HATA:::"+this.getClass().getName()+":::Parametre null geldi");}
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;
    }  public List<String> getAllVehicleCapacity() {  int sonuc = 0; List<String> lst = new ArrayList<String>();  Connection con = null;  PreparedStatement ps = null;
    con = ConnectionManager.GetConnection();   if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   String query1 =   "SELECT vehicle_capacity_list FROM vehicle_capacity_list ORDER BY vehicle_capacity_list ASC";
                        
                        ps = con.prepareStatement(query1); 
                                   
                        ResultSet rs = ps.executeQuery();

                    
                        
                        while (rs.next()) {  
                                            if(rs.getString("vehicle_capacity_list") != null){ lst.add(rs.getString("vehicle_capacity_list")); } 
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
        
        return lst;
    } public List<String> getAllVehicleBrands() {
        
        int sonuc = 0;  List<String> lst = new ArrayList<String>();   Connection con = null;
        PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   String query1 =   "SELECT vehicle_brand_lists FROM vehicle_brand_lists ORDER BY vehicle_brand_lists ASC";
                        
                        ps = con.prepareStatement(query1); 
                                   
                        ResultSet rs = ps.executeQuery();

                    
                        
                        while (rs.next()) {  
                                            if(rs.getString("vehicle_brand_lists") != null){ lst.add(rs.getString("vehicle_brand_lists")); } 
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
        
        return lst;
    } public List<Ad_Bean> getAllAdWithVehicleBrandAndCapacity(String param, String value) {
        
        int sonuc = 0; List<Ad_Bean> adList = new ArrayList<Ad_Bean>();     
        Connection con = null;   PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                 try {  
                        if(param.equals("brand")){
                            ps = con.prepareCall("{call pro_ad_search_VehicleBrand(?)}");   
                            ps.setString(1, value);
                        }
                        else if(param.equals("capacity")){
                            ps = con.prepareCall("{call pro_ad_search_VehicleCapacity(?)}");   
                            ps.setString(1, value);
                        }
                    
                        ResultSet rs = ps.executeQuery();;
                        

                        while (rs.next()) {  Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("iln_Id"));
                                            ab.setAd_Category_Id(rs.getInt("iln_KategoriId"));
                                            ab.setAd_Title(rs.getString("iln_Baslik"));
                                            ab.setAd_Comment(rs.getString("iln_Aciklama"));
                                            ab.setAd_CommentFormated(Jsoup.parse(rs.getString("iln_Aciklama")).text());
                                            ab.setAd_Type(rs.getString("iln_Tipi"));
                                            ab.setAd_OvnerAccountId(rs.getString("iln_Sahibi_Id"));
                                            ab.setAd_CreateTime(rs.getTimestamp("iln_OlusturmaTarihi"));
                                            ab.setAd_Category_Name(rs.getString("iln_Kategori"));
                                            AccountBean abx = new AccountBean();
                                            abx.setAccount_Id(rs.getString("iln_Sahibi_Id2"));
                                            abx.setAccount_FirstName(rs.getString("iln_Sahibi_Ad"));
                                            abx.setAccount_LastName(rs.getString("iln_Sahibi_Soyad"));
                                            abx.setAccount_EmailAddress(rs.getString("iln_Sahibi_Email"));
                                            abx.setAccount_MobilePhoneNumber(rs.getString("iln_Sahibi_Telefon"));
                                            abx.setAccount_MembershipType(rs.getString("iln_Sahibi_UyelikTipi"));
                                            abx.setAccount_ActivityArea(rs.getString("iln_Sahibi_FaliyetAlani"));
                                            abx.setAccount_Type(rs.getString("iln_Sahibi_Yetki"));
                                            
                                            ab.setAccountBean(abx);
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("iln_Sahibi_FirmaId"));
                                            cb.setCompany_Type(rs.getString("iln_Sahibi_FirmaTipi"));
                                            cb.setCompany_ActivityArea(rs.getString("iln_Sahibi_FirmaFaliyetAlani"));
                                            cb.setCompany_Name(rs.getString("iln_Sahibi_FirmaKısaAdi"));
                                            cb.setCompany_FullName(rs.getString("iln_Sahibi_FirmaUzunAdi"));
                                            cb.setCompany_LogoUrl(rs.getString("iln_Sahibi_FirmaLogoUrl"));
                                            
                                            ab.setCorporateAccountBean(cb);
                                          Ad_IsimVarAracAriyorum iar = new Ad_IsimVarAracAriyorum();
                                            iar.setAd_LookingForVehicleForWork_Id(rs.getString("iln_IsmVrArcAryrm_Id"));                                         
                                            iar.setAd_LookingForVehicleForWork_Cost(rs.getFloat("iln_IsmVrArcAryrm_Fiyat"));
                                            iar.setAd_LookingForVehicleForWork_ServiceType(rs.getString("iln_IsmVrArcAryrm_ServisTipi"));
                                            iar.setAd_LookingForVehicleForWork_ServiceTime(rs.getString("iln_IsmVrArcAryrm_ServisSuresi"));
                                            iar.setAd_LookingForVehicleForWork_Km(rs.getString("iln_IsmVrArcAryrm_Km"));                           
                                            iar.setAd_LookingForVehicleForWork_DayToWork(rs.getString("iln_IsmVrArcAryrm_CalisilacakGun"));                      
                                            iar.setAd_LookingForVehicleForWork_PaymentMethod(rs.getString("iln_IsmVrArcAryrm_OdemeSekli"));                
                                            iar.setAd_LookingForVehicleForWork_NumberOfPassengers(rs.getString("iln_IsmVrArcAryrm_YolcuSayisi"));            
                                            ab.setAdIsimVarAracAriyorum(iar);              
                                            Ad_AracimVarSoforAriyorum asax = new Ad_AracimVarSoforAriyorum();
                                            asax.setAd_AracimVarSoforAriyorum_Id(rs.getString("iln_ArcmVrSfrsAryrm_Id"));
                                            asax.setAd_AracimVarSoforAriyorum_Cost(rs.getFloat("iln_ArcmVrSfrsAryrm_Fiyat"));    
                                            asax.setAd_AracimVarSoforAriyorum_ServiceTime(rs.getString("iln_ArcmVrSfrsAryrm_ServisSuresi"));                
                                            asax.setAd_AracimVarSoforAriyorum_NumberOfPassengers(rs.getInt("iln_ArcmVrSfrsAryrm_YolcuSayisi"));    
                                            asax.setAd_AracimVarSoforAriyorum_Km(rs.getString("iln_ArcmVrSfrsAryrm_Km"));                        
                                            asax.setAd_AracimVarSoforAriyorum_DayToWork(rs.getString("iln_ArcmVrSfrsAryrm_CalisilacakGun"));                    
                                            asax.setAd_AracimVarSoforAriyorum_PaymentMethod(rs.getString("iln_ArcmVrSfrsAryrm_OdemeSekli"));               
                                            asax.setAd_AracimVarSoforAriyorum_ServiceType(rs.getString("iln_ArcmVrSfrsAryrm_ServisTipi"));                    
                                            ab.setAd_AracimVarSoforAriyorum(asax);                   
                                            Ad_AracimVarIsAriyorum aiax = new Ad_AracimVarIsAriyorum();
                                            aiax.setAd_AracimVarIsAriyorum_Id(rs.getString("iln_ArcmVrIsAryrm_Id"));
                                            ab.setAdAracimVarIsAriyorum(aiax);    
                                            Vehicle aiaxx = new Vehicle();
                                            aiaxx.setVehicle_Id(rs.getString("iln_ArcmVrIsAryrm_AracId"));
                                            aiaxx.setVehicle_Brand(rs.getString("iln_ArcmVrIsAryrm_AracMarkaAd"));
                                            aiaxx.setVehicle_Model(rs.getString("iln_ArcmVrIsAryrm_AracModel"));
                                            aiaxx.setVehicle_ModelYear(rs.getString("iln_ArcmVrIsAryrm_AracModelYılı"));
                                            aiaxx.setVehicle_PlateProvinceCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaIlKodu"));
                                            aiaxx.setVehicle_PlateLatterCode(rs.getString("iln_ArcmVrIsAryrm_AracPlakaHarfKodu"));
                                            aiaxx.setVehicle_PlateNumberCode(rs.getInt("iln_ArcmVrIsAryrm_AracPlakaNumaraKodu"));
                                            aiaxx.setVehicle_Km(rs.getInt("iln_ArcmVrIsAryrm_AracKm"));
                                            aiaxx.setVehicle_Color(rs.getString("iln_ArcmVrIsAryrm_AracRenk"));
                                            aiaxx.setVehicle_CompanyLogoText(rs.getString("iln_ArcmVrIsAryrm_AracFirmaLogosu"));
                                            aiaxx.setVehicle_ServiceTypes(rs.getString("iln_ArcmVrIsAryrm_AracServisTipi"));
                                            VehicleImages vimgx = new VehicleImages();
                                            aiaxx.setVehicleImages(vimgx);
                                            ab.setAdAracimVarIsAriyorum_vehicle(aiaxx);
                                            
                                            
                                            adList.add(ab);
                                            
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
        
        return adList;
    } public int createAdMoveUp(String adMoveUpId, int adHowManyTimesMovedUp, String adId, String accountId){ 
    
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "INSERT INTO `ilan_tasimacilar`.`ad_moveup` "
                                     + "(`ad_moveUp_Id`,`ad_moveUp_HowManyTimesMovedUp`,`ad_moveUp_LastUpdateTime`,`ad_Id`,`account_Id`) "
                                     + "VALUES (?,?,?,?,?)";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adMoveUpId);
                        ps.setInt(2, adHowManyTimesMovedUp);
                        ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(4, adId);
                        ps.setString(5, accountId);
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){  }       
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
    } public int updateAdMoveUp(String adMoveUpId, int adHowManyTimesMovedUp){
    
        int sonuc = 0;   Connection con = null; PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "UPDATE `ilan_tasimacilar`.`ad_moveup` "
                                     + "SET ad_moveUp_HowManyTimesMovedUp = ?, ad_moveUp_LastUpdateTime = ? "
                                     + "WHERE ad_moveUp_Id = ?; ";

                        ps = con.prepareStatement(query);
                        ps.setInt(1, adHowManyTimesMovedUp);
                        ps.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(3, adMoveUpId);
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){  }       
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
    }    public int adHowManyTimesMovedUp(String adId, String accountId){
           
        int sonuc = 0; Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "SELECT `ad_moveup`.`ad_moveUp_HowManyTimesMovedUp` "
                                     + "FROM `ad_moveup` "
                                     + "WHERE ad_Id=? "
                                     + "AND account_Id=? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adId);
                        ps.setString(2, accountId);
                     
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {sonuc = rs.getInt("ad_moveUp_HowManyTimesMovedUp"); } 
                        
                        if(sonuc == 1){  }       
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
    } public String getAdMoveUpId( String adId, String accountId){
           
        String sonuc = "";  Connection con = null;  PreparedStatement ps = null;
   con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "SELECT `ad_moveup`.`ad_moveUp_Id` "
                                     + "FROM `ad_moveup` "
                                     + "WHERE ad_Id=? "
                                     + "AND account_Id=? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, adId);
                        ps.setString(2, accountId);
                     
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {sonuc = rs.getString("ad_moveUp_Id"); } 
                        
                        if(sonuc != null && !sonuc.equals("")){ 
                            System.out.println("Yeni ilan ı yukariya tasima kaydi id si alındı");  
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
    }    public int updateAdPublishDate(String adId){
    
        int sonuc = 0; Connection con = null;   PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "UPDATE `ilan_tasimacilar`.`ad_` "
                                     + "SET ad_PublishDate = ? "
                                     + "WHERE ad_Id = ?; ";

                        ps = con.prepareStatement(query);
                        ps.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(2, adId);
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){ 
                            System.out.println("İlan yayinlama tarihi guncellendi.");  
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
