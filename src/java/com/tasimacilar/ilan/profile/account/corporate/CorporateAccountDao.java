package com.tasimacilar.ilan.profile.account.corporate;
import com.tasimacilar.ilan.common.AddressBean;
import com.tasimacilar.ilan.common.CityListsBean;
import com.tasimacilar.ilan.common.PhonesBean;
import com.tasimacilar.ilan.common.SocialMediaBean;
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
public class CorporateAccountDao { 
    public int createCompany(CorporateAccountBean corporateAccount) {
      int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
                        ps.setString(1, "insert");
                        ps.setString(2, corporateAccount.getCompany_Id());
                        ps.setString(3, corporateAccount.getCompany_Type());
                        ps.setString(4, corporateAccount.getCompany_ActivityArea());
                        ps.setString(5, corporateAccount.getCompany_Name());
                        ps.setString(6, corporateAccount.getCompany_FullName());
                        ps.setString(7, corporateAccount.getCompany_UrlName());
                        ps.setString(8, corporateAccount.getCompany_TaxOffice());
                        ps.setString(9, corporateAccount.getCompany_TaxNumber());
                        ps.setString(10, corporateAccount.getCompany_Email());
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, corporateAccount.getCompany_Web());
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, corporateAccount.getCompany_LogoUrl());
                        ps.setTimestamp(17,  new java.sql.Timestamp(new Date().getTime()));
                        ps.setTimestamp(18, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(19, corporateAccount.getCompany_last_Changer_account_id());
                        ps.setBoolean(20, corporateAccount.isCompany_IsActive());
                        ps.setString(21, corporateAccount.getAddress_id());
                        ps.setString(22, corporateAccount.getSocialMedia_Id());
                        ps.setString(23, corporateAccount.getPhone_id());
                        ps.setString(24, corporateAccount.getAddressBean().getAddress_Id());
                        ps.setInt(25, corporateAccount.getAddressBean().getAddress_TypeId());
                        ps.setString(26, corporateAccount.getAddressBean().getAddress_Name());
                        ps.setString(27, corporateAccount.getAddressBean().getAddress());
                        ps.setInt(28, corporateAccount.getAddressBean().getAddress_CountryId());
                        ps.setInt(29, corporateAccount.getAddressBean().getAddress_CityId());
                        ps.setInt(30, corporateAccount.getAddressBean().getAddress_TownId());
                        ps.setInt(31, corporateAccount.getAddressBean().getAddress_DistrictId());
                        ps.setInt(32, corporateAccount.getAddressBean().getAddress_NeighborhoodId());
                        ps.setString(33, corporateAccount.getAddressBean().getAddress_PostCode());
                        ps.setString(34, corporateAccount.getAddressBean().getAddress_location_Latitude());
                        ps.setString(35, corporateAccount.getAddressBean().getAddress_location_Longitude());
                        ps.setTimestamp(36, new java.sql.Timestamp(new Date().getTime()));
                        ps.setTimestamp(37, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(38, corporateAccount.getAddressBean().getAddress_last_Changer_account_id());
                        ps.setString(39, corporateAccount.getSocialMediaBean().getSocialMedia_Id());
                        ps.setString(40, corporateAccount.getSocialMediaBean().getFacebook_profileUrl());
                        ps.setString(41, corporateAccount.getSocialMediaBean().getTwitter_profileUrl());
                        ps.setString(42, corporateAccount.getSocialMediaBean().getLinkedin_profileUrl());
                        ps.setString(43, corporateAccount.getSocialMediaBean().getWhatsApp_profileUrl());
                        ps.setString(44, corporateAccount.getSocialMediaBean().getWeChat_profileUrl());
                        ps.setString(45, corporateAccount.getSocialMediaBean().getTumblr_profileUrl());
                        ps.setString(46, corporateAccount.getSocialMediaBean().getInstagram_profileUrl());
                        ps.setString(47, corporateAccount.getSocialMediaBean().getGoogle_profileUrl());
                        ps.setString(48, corporateAccount.getSocialMediaBean().getSkype_profileUrl());
                        ps.setString(49, corporateAccount.getSocialMediaBean().getViber_profileUrl());
                        ps.setString(50, corporateAccount.getSocialMediaBean().getLine_profileUrl());
                        ps.setString(51, corporateAccount.getSocialMediaBean().getSnapchat_profileUrl());
                        ps.setString(52, corporateAccount.getSocialMediaBean().getPinterest_profileUrl());
                        ps.setString(53, corporateAccount.getSocialMediaBean().getTelegram_profileUrl());
                        ps.setString(54, corporateAccount.getSocialMediaBean().getReddit_profileUrl());
                        ps.setString(55, corporateAccount.getSocialMediaBean().getFoursquare_profileUrl());
                        ps.setString(56, corporateAccount.getSocialMediaBean().getMyspace_profileUrl());
                        ps.setString(57, corporateAccount.getSocialMediaBean().getYouTube_profileUrl());
                        ps.setString(58, corporateAccount.getSocialMediaBean().getVine_profileUrl());
                        ps.setString(59, corporateAccount.getSocialMediaBean().getXing_profileUrl());
                        ps.setString(60, corporateAccount.getSocialMediaBean().getFlickr_profileUrl());
                        ps.setString(61, corporateAccount.getSocialMediaBean().getMeetup_profileUrl());
                        ps.setTimestamp(62, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(63, corporateAccount.getSocialMediaBean().getLast_change_time());
                        ps.setString(64, corporateAccount.getSocialMediaBean().getLast_Changer_account_id());
                        ps.setString(65, corporateAccount.getPhonesBean().getPhone_id());
                        ps.setInt(66, corporateAccount.getPhonesBean().getPhone_type_id());
                        ps.setString(67, corporateAccount.getPhonesBean().getPhone_name());
                        ps.setString(68, corporateAccount.getPhonesBean().getPhone_1());
                        ps.setString(69, corporateAccount.getPhonesBean().getPhone_2());
                        ps.setString(70, corporateAccount.getPhonesBean().getPhone_3());
                        ps.setString(71, corporateAccount.getPhonesBean().getPhone_4());
                        ps.setString(72, corporateAccount.getPhonesBean().getPhone_5());
                        ps.setString(73, corporateAccount.getPhonesBean().getPhone_gsm1());
                        ps.setString(74, corporateAccount.getPhonesBean().getPhone_gsm2());
                        ps.setString(75, corporateAccount.getPhonesBean().getPhone_gsm3());
                        ps.setString(76, corporateAccount.getPhonesBean().getPhone_fax1());
                        ps.setString(77, corporateAccount.getPhonesBean().getPhone_fax2());
                        ps.setBoolean(78, corporateAccount.getPhonesBean().isPhone_isActive());
                        ps.setTimestamp(79, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(80, corporateAccount.getPhonesBean().getPhone_Modifier());
                        ps.setTimestamp(81, new java.sql.Timestamp(new Date().getTime()));
                        ps.setString(82, corporateAccount.getPhonesBean().getPhone_creator());
                        sonuc = ps.executeUpdate();  
                        if(sonuc == 1){
                            System.out.println("Yeni firma Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni firma olusturuldu. [ID:"+corporateAccount.getCompany_Id()
                                                                                                            +" Adı:"+corporateAccount.getCompany_Name()+"]", "system");
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
    } public int createCompany_tmp(CorporateAccountBean corporateAccount) {
         int sonuc = 0;
        java.sql.Timestamp companyCreateTime = corporateAccount.getCompany_create_time() == null ? null : new java.sql.Timestamp(corporateAccount.getCompany_create_time().getTime());
        java.sql.Timestamp companylastChangeTime = corporateAccount.getCompany_last_change_time() == null ? null : new java.sql.Timestamp(corporateAccount.getCompany_last_change_time().getTime());
        java.sql.Timestamp address_CreateTime = corporateAccount.getAddressBean().getAddress_last_change_time() == null ? null : new java.sql.Timestamp(corporateAccount.getAddressBean().getAddress_last_change_time().getTime());
        java.sql.Timestamp SocialMedia_CreateTime = corporateAccount.getSocialMediaBean().getCreate_time() == null ? null : new java.sql.Timestamp(corporateAccount.getSocialMediaBean().getCreate_time().getTime());
        java.sql.Timestamp phone_CreateTime = corporateAccount.getPhonesBean().getPhone_Modified() == null ? null : new java.sql.Timestamp(corporateAccount.getPhonesBean().getPhone_Modified().getTime());
         java.sql.Timestamp companyTmplastChangeTime = corporateAccount.getCompany_tmp_last_change_time() == null ? null : new java.sql.Timestamp(corporateAccount.getCompany_tmp_last_change_time().getTime());
         Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company_tmp(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                       + "?,?,?,?)}");ps.setString(1, "insert_tmp");
                        ps.setString(2, corporateAccount.getCompany_Id());
                        ps.setString(3, corporateAccount.getCompany_Type());
                        ps.setString(4, corporateAccount.getCompany_ActivityArea());
                        ps.setString(5, corporateAccount.getCompany_Name());
                        ps.setString(6, corporateAccount.getCompany_FullName());
                        ps.setString(7, corporateAccount.getCompany_UrlName());
                        ps.setString(8, corporateAccount.getCompany_TaxOffice());
                        ps.setString(9, corporateAccount.getCompany_TaxNumber());
                        ps.setString(10, corporateAccount.getCompany_Email());
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, corporateAccount.getCompany_Web());
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, corporateAccount.getCompany_LogoUrl());
                        ps.setTimestamp(17,  companyCreateTime);
                        ps.setTimestamp(18, companylastChangeTime);
                        ps.setString(19, corporateAccount.getCompany_last_Changer_account_id());
                        ps.setBoolean(20, corporateAccount.isCompany_IsActive());
                        ps.setString(21, corporateAccount.getAddress_id());
                        ps.setString(22, corporateAccount.getSocialMedia_Id());
                        ps.setString(23, corporateAccount.getPhone_id());
                        ps.setString(24, corporateAccount.getAddressBean().getAddress_Id());
                        ps.setInt(25, corporateAccount.getAddressBean().getAddress_TypeId());
                        ps.setString(26, corporateAccount.getAddressBean().getAddress_Name());
                        ps.setString(27, corporateAccount.getAddressBean().getAddress());
                        ps.setInt(28, corporateAccount.getAddressBean().getAddress_CountryId());
                        ps.setInt(29, corporateAccount.getAddressBean().getAddress_CityId());
                        ps.setInt(30, corporateAccount.getAddressBean().getAddress_TownId());
                        ps.setInt(31, corporateAccount.getAddressBean().getAddress_DistrictId());
                        ps.setInt(32, corporateAccount.getAddressBean().getAddress_NeighborhoodId());
                        ps.setString(33, corporateAccount.getAddressBean().getAddress_PostCode());
                        ps.setString(34, corporateAccount.getAddressBean().getAddress_location_Latitude());
                        ps.setString(35, corporateAccount.getAddressBean().getAddress_location_Longitude());
                        ps.setTimestamp(36, address_CreateTime);
                        ps.setTimestamp(37, address_CreateTime);
                        ps.setString(38, corporateAccount.getAddressBean().getAddress_last_Changer_account_id());
                        ps.setString(39, corporateAccount.getSocialMediaBean().getSocialMedia_Id());
                        ps.setString(40, corporateAccount.getSocialMediaBean().getFacebook_profileUrl());
                        ps.setString(41, corporateAccount.getSocialMediaBean().getTwitter_profileUrl());
                        ps.setString(42, corporateAccount.getSocialMediaBean().getLinkedin_profileUrl());
                        ps.setString(43, corporateAccount.getSocialMediaBean().getWhatsApp_profileUrl());
                        ps.setString(44, corporateAccount.getSocialMediaBean().getWeChat_profileUrl());
                        ps.setString(45, corporateAccount.getSocialMediaBean().getTumblr_profileUrl());
                        ps.setString(46, corporateAccount.getSocialMediaBean().getInstagram_profileUrl());
                        ps.setString(47, corporateAccount.getSocialMediaBean().getGoogle_profileUrl());
                        ps.setString(48, corporateAccount.getSocialMediaBean().getSkype_profileUrl());
                        ps.setString(49, corporateAccount.getSocialMediaBean().getViber_profileUrl());
                        ps.setString(50, corporateAccount.getSocialMediaBean().getLine_profileUrl());
                        ps.setString(51, corporateAccount.getSocialMediaBean().getSnapchat_profileUrl());
                        ps.setString(52, corporateAccount.getSocialMediaBean().getPinterest_profileUrl());
                        ps.setString(53, corporateAccount.getSocialMediaBean().getTelegram_profileUrl());
                        ps.setString(54, corporateAccount.getSocialMediaBean().getReddit_profileUrl());
                        ps.setString(55, corporateAccount.getSocialMediaBean().getFoursquare_profileUrl());
                        ps.setString(56, corporateAccount.getSocialMediaBean().getMyspace_profileUrl());
                        ps.setString(57, corporateAccount.getSocialMediaBean().getYouTube_profileUrl());
                        ps.setString(58, corporateAccount.getSocialMediaBean().getVine_profileUrl());
                        ps.setString(59, corporateAccount.getSocialMediaBean().getXing_profileUrl());
                        ps.setString(60, corporateAccount.getSocialMediaBean().getFlickr_profileUrl());
                        ps.setString(61, corporateAccount.getSocialMediaBean().getMeetup_profileUrl());
                        ps.setTimestamp(62, SocialMedia_CreateTime);
                        ps.setString(63, corporateAccount.getSocialMediaBean().getLast_change_time());
                        ps.setString(64, corporateAccount.getSocialMediaBean().getLast_Changer_account_id());
                        ps.setString(65, corporateAccount.getPhonesBean().getPhone_id());
                        ps.setInt(66, corporateAccount.getPhonesBean().getPhone_type_id());
                        ps.setString(67, corporateAccount.getPhonesBean().getPhone_name());
                        ps.setString(68, corporateAccount.getPhonesBean().getPhone_1());
                        ps.setString(69, corporateAccount.getPhonesBean().getPhone_2());
                        ps.setString(70, corporateAccount.getPhonesBean().getPhone_3());
                        ps.setString(71, corporateAccount.getPhonesBean().getPhone_4());
                        ps.setString(72, corporateAccount.getPhonesBean().getPhone_5());
                        ps.setString(73, corporateAccount.getPhonesBean().getPhone_gsm1());
                        ps.setString(74, corporateAccount.getPhonesBean().getPhone_gsm2());
                        ps.setString(75, corporateAccount.getPhonesBean().getPhone_gsm3());
                        ps.setString(76, corporateAccount.getPhonesBean().getPhone_fax1());
                        ps.setString(77, corporateAccount.getPhonesBean().getPhone_fax2());
                        ps.setBoolean(78, corporateAccount.getPhonesBean().isPhone_isActive());
                        ps.setTimestamp(79, phone_CreateTime);
                        ps.setString(80, corporateAccount.getPhonesBean().getPhone_Modifier());
                        ps.setTimestamp(81, phone_CreateTime);
                        ps.setString(82, corporateAccount.getPhonesBean().getPhone_creator());
                        ps.setString(83, corporateAccount.getCompany_tmp_Id());
                        ps.setInt(84, corporateAccount.getCompany_tmp_Version());
                        ps.setString(85, corporateAccount.getCompany_tmp_last_Changer_account_id());
                        ps.setTimestamp(86, companyTmplastChangeTime);
                       
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni TMP firma olusturuldu. [ID:"+corporateAccount.getCompany_Id()
                                                                                                            +" Adı:"+corporateAccount.getCompany_Name()+"]", "system");
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
    }    public int updateCompany(CorporateAccountBean corporateAccount) {
        
        int sonuc = 0;
        java.sql.Timestamp companyCreateTime = corporateAccount.getCompany_create_time() == null ? null : new java.sql.Timestamp(corporateAccount.getCompany_create_time().getTime());
        java.sql.Timestamp companylastChangeTime = corporateAccount.getCompany_last_change_time() == null ? null : new java.sql.Timestamp(corporateAccount.getCompany_last_change_time().getTime());
        java.sql.Timestamp address_CreateTime = corporateAccount.getAddressBean().getAddress_last_change_time() == null ? null : new java.sql.Timestamp(corporateAccount.getAddressBean().getAddress_last_change_time().getTime());
        java.sql.Timestamp SocialMedia_CreateTime = corporateAccount.getSocialMediaBean().getCreate_time() == null ? null : new java.sql.Timestamp(corporateAccount.getSocialMediaBean().getCreate_time().getTime());
        java.sql.Timestamp phone_CreateTime = corporateAccount.getPhonesBean().getPhone_Modified() == null ? null : new java.sql.Timestamp(corporateAccount.getPhonesBean().getPhone_Modified().getTime());
 Connection con = null;PreparedStatement ps = null; con = ConnectionManager.GetConnection();
if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                                      + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
                        ps.setString(1, "update");
                        
                        // 22 company
                        ps.setString(2, corporateAccount.getCompany_Id());
                        ps.setString(3, corporateAccount.getCompany_Type());
                        ps.setString(4, corporateAccount.getCompany_ActivityArea());
                        ps.setString(5, corporateAccount.getCompany_Name());
                        ps.setString(6, corporateAccount.getCompany_FullName());
                        ps.setString(7, corporateAccount.getCompany_UrlName());
                        ps.setString(8, corporateAccount.getCompany_TaxOffice());
                        ps.setString(9, corporateAccount.getCompany_TaxNumber());
                        ps.setString(10, corporateAccount.getCompany_Email());
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, corporateAccount.getCompany_Web());
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, corporateAccount.getCompany_LogoUrl());
                        ps.setTimestamp(17,  companyCreateTime);
                        ps.setTimestamp(18, companylastChangeTime);
                        ps.setString(19, corporateAccount.getCompany_last_Changer_account_id());
                        ps.setBoolean(20, corporateAccount.isCompany_IsActive());
                        ps.setString(21, corporateAccount.getAddress_id());
                        ps.setString(22, corporateAccount.getSocialMedia_Id());
                        ps.setString(23, corporateAccount.getPhone_id());
                         ps.setString(24, corporateAccount.getAddressBean().getAddress_Id());
                        ps.setInt(25, corporateAccount.getAddressBean().getAddress_TypeId());
                        ps.setString(26, corporateAccount.getAddressBean().getAddress_Name());
                        ps.setString(27, corporateAccount.getAddressBean().getAddress());
                        ps.setInt(28, corporateAccount.getAddressBean().getAddress_CountryId());
                        ps.setInt(29, corporateAccount.getAddressBean().getAddress_CityId());
                        ps.setInt(30, corporateAccount.getAddressBean().getAddress_TownId());
                        ps.setInt(31, corporateAccount.getAddressBean().getAddress_DistrictId());
                        ps.setInt(32, corporateAccount.getAddressBean().getAddress_NeighborhoodId());
                        ps.setString(33, corporateAccount.getAddressBean().getAddress_PostCode());
                        ps.setString(34, corporateAccount.getAddressBean().getAddress_location_Latitude());
                        ps.setString(35, corporateAccount.getAddressBean().getAddress_location_Longitude());
                        ps.setTimestamp(36, address_CreateTime);
                        ps.setTimestamp(37, address_CreateTime);
                        ps.setString(38, corporateAccount.getAddressBean().getAddress_last_Changer_account_id());
                         ps.setString(39, corporateAccount.getSocialMediaBean().getSocialMedia_Id());
                        ps.setString(40, corporateAccount.getSocialMediaBean().getFacebook_profileUrl());
                        ps.setString(41, corporateAccount.getSocialMediaBean().getTwitter_profileUrl());
                        ps.setString(42, corporateAccount.getSocialMediaBean().getLinkedin_profileUrl());
                        ps.setString(43, corporateAccount.getSocialMediaBean().getWhatsApp_profileUrl());
                        ps.setString(44, corporateAccount.getSocialMediaBean().getWeChat_profileUrl());
                        ps.setString(45, corporateAccount.getSocialMediaBean().getTumblr_profileUrl());
                        ps.setString(46, corporateAccount.getSocialMediaBean().getInstagram_profileUrl());
                        ps.setString(47, corporateAccount.getSocialMediaBean().getGoogle_profileUrl());
                        ps.setString(48, corporateAccount.getSocialMediaBean().getSkype_profileUrl());
                        ps.setString(49, corporateAccount.getSocialMediaBean().getViber_profileUrl());
                        ps.setString(50, corporateAccount.getSocialMediaBean().getLine_profileUrl());
                        ps.setString(51, corporateAccount.getSocialMediaBean().getSnapchat_profileUrl());
                        ps.setString(52, corporateAccount.getSocialMediaBean().getPinterest_profileUrl());
                        ps.setString(53, corporateAccount.getSocialMediaBean().getTelegram_profileUrl());
                        ps.setString(54, corporateAccount.getSocialMediaBean().getReddit_profileUrl());
                        ps.setString(55, corporateAccount.getSocialMediaBean().getFoursquare_profileUrl());
                        ps.setString(56, corporateAccount.getSocialMediaBean().getMyspace_profileUrl());
                        ps.setString(57, corporateAccount.getSocialMediaBean().getYouTube_profileUrl());
                        ps.setString(58, corporateAccount.getSocialMediaBean().getVine_profileUrl());
                        ps.setString(59, corporateAccount.getSocialMediaBean().getXing_profileUrl());
                        ps.setString(60, corporateAccount.getSocialMediaBean().getFlickr_profileUrl());
                        ps.setString(61, corporateAccount.getSocialMediaBean().getMeetup_profileUrl());
                        ps.setTimestamp(62, SocialMedia_CreateTime);
                        ps.setString(63, corporateAccount.getSocialMediaBean().getLast_change_time());
                        ps.setString(64, corporateAccount.getSocialMediaBean().getLast_Changer_account_id());
                         ps.setString(65, corporateAccount.getPhonesBean().getPhone_id());
                        ps.setInt(66, corporateAccount.getPhonesBean().getPhone_type_id());
                        ps.setString(67, corporateAccount.getPhonesBean().getPhone_name());
                        ps.setString(68, corporateAccount.getPhonesBean().getPhone_1());
                        ps.setString(69, corporateAccount.getPhonesBean().getPhone_2());
                        ps.setString(70, corporateAccount.getPhonesBean().getPhone_3());
                        ps.setString(71, corporateAccount.getPhonesBean().getPhone_4());
                        ps.setString(72, corporateAccount.getPhonesBean().getPhone_5());
                        ps.setString(73, corporateAccount.getPhonesBean().getPhone_gsm1());
                        ps.setString(74, corporateAccount.getPhonesBean().getPhone_gsm2());
                        ps.setString(75, corporateAccount.getPhonesBean().getPhone_gsm3());
                        ps.setString(76, corporateAccount.getPhonesBean().getPhone_fax1());
                        ps.setString(77, corporateAccount.getPhonesBean().getPhone_fax2());
                        ps.setBoolean(78, corporateAccount.getPhonesBean().isPhone_isActive());
                        ps.setTimestamp(79, phone_CreateTime);
                        ps.setString(80, corporateAccount.getPhonesBean().getPhone_Modifier());
                        ps.setTimestamp(81, phone_CreateTime);
                        ps.setString(82, corporateAccount.getPhonesBean().getPhone_creator());
                       sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){
                            System.out.println("Firma güncelleme BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Firma güncelleme başarılı. [ID:"+corporateAccount.getCompany_Id()
                                                                                                            +" Adı:"+corporateAccount.getCompany_Name()+"]", "system");
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
    } public List<CorporateAccountBean> getAllCorporateAccountWithDetail() { 
        
        List<CorporateAccountBean> acList = new ArrayList<CorporateAccountBean>();  Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
        
                    ps.setString(1, "getAll");
                    ps.setString(2, null);
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                             SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                             PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
    CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                             if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                             cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email(rs.getString("company_Email1"));
                                            cb.setCompany_Web(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id(rs.getString("address_id"));
                                            cb.setSocialMedia_Id(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean(adb);
                                            cb.setSocialMediaBean(sb);
                                            acList.add(cb);
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
        
        return acList;
    }public List<CorporateAccountBean> getAllCorporateAccountWithDetail2() { 
        
        List<CorporateAccountBean> acList = new ArrayList<CorporateAccountBean>();
        
        Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
        
                    ps.setString(1, "getAll2");
                    ps.setString(2, null);
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                             SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                             PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
                                             CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_UrlName(rs.getString("company_UrlName"));
                                            cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email(rs.getString("company_Email1"));
                                            cb.setCompany_Web(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id(rs.getString("address_id"));
                                            cb.setSocialMedia_Id(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean(adb);
                                            cb.setSocialMediaBean(sb);
                                            acList.add(cb);
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
        
        return acList;
    } public List<CorporateAccountBean> onayBekleyenler() { 
        
        List<CorporateAccountBean> acList = new ArrayList<CorporateAccountBean>();
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
           else{   try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
        
                    ps.setString(1, "onayBekleyenler");
                    ps.setString(2, null);
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {   AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                             SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                            PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                             if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email(rs.getString("company_Email1"));
                                            cb.setCompany_Web(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id(rs.getString("address_id"));
                                            cb.setSocialMedia_Id(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean(adb);
                                            cb.setSocialMediaBean(sb);
                                            acList.add(cb);
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
        
        return acList;
    } public List<CorporateAccountBean> onayBekleyenlerTMP() { 
        
        List<CorporateAccountBean> acList = new ArrayList<CorporateAccountBean>();
         Connection con = null; PreparedStatement ps = null;
   con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
        
                    ps.setString(1, "onayBekleyenlerTMP");
                    ps.setString(2, null);
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                            SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                            PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
                                            CorporateAccountBean cb = new CorporateAccountBean();
                                            cb.setCompany_tmp_Id(rs.getString("company_tmp_Id"));
                                            cb.setCompany_tmp_Version(rs.getInt("company_tmp_Version"));
                                            cb.setCompany_tmp_last_Changer_account_id(rs.getString("company_tmp_last_Changer_account_id"));
                                            cb.setCompany_tmp_last_change_time(rs.getTimestamp("company_tmp_last_change_time"));
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                             if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email(rs.getString("company_Email1"));
                                            cb.setCompany_Web(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id(rs.getString("address_id"));
                                            cb.setSocialMedia_Id(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean(adb);
                                            cb.setSocialMediaBean(sb);
                                            acList.add(cb);
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
        
        return acList;
    }public CorporateAccountBean getOneCorporateAccountWithId(String company_Id) { 
        
        CorporateAccountBean cb = new CorporateAccountBean();
        
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
        
                        ps.setString(1, "getAllWithId");
                        ps.setString(2, company_Id);
                    
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                             SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                            PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
                                            
                                             cb.setCompany_Id(rs.getString("company_Id"));
                                            cb.setCompany_Type(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                            
                                            if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                            
                                            cb.setCompany_FullName(rs.getString("company_FullName"));
                                            cb.setCompany_UrlName(rs.getString("company_UrlName"));
                                            cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email(rs.getString("company_Email1"));
                                            cb.setCompany_Web(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id(rs.getString("address_id"));
                                            cb.setSocialMedia_Id(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean(adb);
                                            cb.setSocialMediaBean(sb);
                                            cb.setPhonesBean(p);
                                            cb.setAddress_(rs.getString("companyFullAdress"));
                                           
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
        
        return cb;
        
        
    }public CorporateAccountBean getOneCorporateAccountWithId2(String TmpCompId) { 
        
        CorporateAccountBean cb = new CorporateAccountBean();
        
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query1 =  "SELECT *  "
                                        + "FROM `ilan_tasimacilar`.`company_tmp` c, `ilan_tasimacilar`.addresses_ a, `ilan_tasimacilar`.socialmedia s, `ilan_tasimacilar`.phones_ p "
                                        + "WHERE c.address_id = a.address_id "
                                        + "AND c.SocialMedia_Id = s.socialMedia_id "
                                        + "AND c.phone_id = p.phone_id "
                                        + "AND c.company_IsPublish = 0 "
                                        + "AND c.company_tmp_lsActive =1 "
                                        + "AND c.company_tmp_Id = ? "
                                        + "ORDER BY c.company_Id ASC, c.company_tmp_Version ASC; " ;

                        ps = con.prepareStatement(query1);
        
                        ps.setString(1, TmpCompId);
                    
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { AddressBean adb = new AddressBean();
                                            adb.setAddress_Id(rs.getString("address_id"));
                                            adb.setAddress_TypeId(rs.getInt("address_type_id"));
                                            adb.setAddress_Name(rs.getString("address_name"));
                                            adb.setAddress(rs.getString("address_"));
                                            adb.setAddress_CountryId(rs.getInt("address_country_id")); 
                                            adb.setAddress_CityId(rs.getInt("address_city_id"));
                                            adb.setAddress_TownId(rs.getInt("address_town_id"));
                                            adb.setAddress_DistrictId(rs.getInt("address_district_id"));
                                            adb.setAddress_NeighborhoodId(rs.getInt("address_neighborhood_id"));
                                            adb.setAddress_PostCode(rs.getString("address_postCode"));
                                            adb.setAddress_location_Latitude(rs.getString("address_location_latitude"));
                                            adb.setAddress_location_Longitude(rs.getString("address_location_longitude"));
                                            adb.setAddress_create_time(rs.getTimestamp("address_create_time"));
                                            adb.setAddress_last_change_time(rs.getTimestamp("address_last_change_time"));
                                            adb.setAddress_last_Changer_account_id(rs.getString("address_last_Changer_account_id"));
                                              SocialMediaBean sb = new SocialMediaBean();
                                            sb.setSocialMedia_Id(rs.getString("socialMedia_id"));
                                            sb.setFacebook_profileUrl(rs.getString("socialMedia_facebookProfileUrl"));
                                            sb.setTwitter_profileUrl(rs.getString("socialMedia_twitterProfileUrl"));
                                            sb.setLinkedin_profileUrl(rs.getString("socialMedia_linkedinProfileUrl"));
                                            sb.setInstagram_profileUrl(rs.getString("socialMedia_instagramProfileUrl"));
                                             PhonesBean p = new PhonesBean();
                                            p.setPhone_id(rs.getString("phone_id"));
                                            p.setPhone_type_id(rs.getInt("phone_type_id"));
                                            p.setPhone_name(rs.getString("phone_name"));
                                            p.setPhone_1(rs.getString("phone_1"));
                                            p.setPhone_2(rs.getString("phone_2"));
                                            p.setPhone_3(rs.getString("phone_3"));
                                            p.setPhone_4(rs.getString("phone_4"));
                                            p.setPhone_5(rs.getString("phone_5"));
                                            p.setPhone_gsm1(rs.getString("phone_gsm1"));
                                            p.setPhone_gsm2(rs.getString("phone_gsm2"));
                                            p.setPhone_gsm3(rs.getString("phone_gsm3"));
                                            p.setPhone_fax1(rs.getString("phone_fax1"));
                                            p.setPhone_fax2(rs.getString("phone_fax2"));
                                            p.setPhone_isActive(rs.getBoolean("phone_IsActive"));
                                            p.setPhone_Modified(rs.getTimestamp("phone_Modified"));
                                            p.setPhone_Modifier(rs.getString("phone_Modifier"));
                                            p.setPhone_Created(rs.getTimestamp("phone_Created"));
                                            p.setPhone_creator(rs.getString("phone_creator"));
                                             cb.setCompany_tmp_Id(rs.getString("company_tmp_Id"));
                                            cb.setCompany_tmp_Version(rs.getInt("company_tmp_Version"));
                                            cb.setCompany_tmp_last_change_time(rs.getTimestamp("company_tmp_last_change_time"));
                                            cb.setCompany_tmp_last_Changer_account_id(rs.getString("company_tmp_last_Changer_account_id"));
                                            cb.setCompany_Id_2(rs.getString("company_Id"));
                                            cb.setCompany_Type_2(rs.getString("company_Type"));
                                            cb.setCompany_ActivityArea_2(rs.getString("company_ActivityArea"));
                                            if(rs.getBoolean("company_IsPublish")){ cb.setCompany_Name_2(rs.getString("company_Name")); }
                                            else{ cb.setCompany_Name_2(rs.getString("company_Name")+" (Doğrulanmamış)");}
                                             cb.setCompany_FullName_2(rs.getString("company_FullName"));
                                            cb.setCompany_TaxOffice_2(rs.getString("company_TaxOffice"));
                                            cb.setCompany_TaxNumber_2(rs.getString("company_TaxNumber"));
                                            cb.setCompany_Email_2(rs.getString("company_Email1"));
                                            cb.setCompany_Web_2(rs.getString("company_Web1"));
                                            cb.setCompany_LogoUrl_2(rs.getString("company_LogoUrl"));
                                            cb.setCompany_create_time_2(rs.getTimestamp("company_create_time"));
                                            cb.setCompany_last_change_time_2(rs.getTimestamp("company_last_change_time"));
                                            cb.setCompany_last_Changer_account_id_2(rs.getString("company_last_Changer_account_id"));
                                            cb.setCompany_IsActive_2(rs.getBoolean("company_IsActive"));
                                            cb.setAddress_id_2(rs.getString("address_id"));
                                            cb.setSocialMedia_Id_2(rs.getString("SocialMedia_Id"));
                                            cb.setAddressBean2(adb);
                                            cb.setSocialMediaBean2(sb);
                                            cb.setPhonesBean2(p);
                                           
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
        
        return cb;
        
        
    } public int enableDisableCompany(String param, String cId) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
        
        if(param != null && !param.equals("") && cId != null && !cId.equals("")){
        
        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
                        
                        
                        if(param.equals("disable")){ps.setString(1, "disable");}
                        if(param.equals("enable")){ps.setString(1, "enable");}
                        ps.setString(2, cId);
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){
                            System.out.println("Firma enable/disable edildi");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Firma enable/disable edildi. [Firma Id:"+cId+"]", "system");
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
    } public int publishCompany(String cId) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;
     
        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_company_gelAll(?,?)}");
                                               
                        ps.setString(1, "publish");
                        ps.setString(2, cId);
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){
                            System.out.println("Firma yayınlandıedildi");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Firma yayınlandı. [Firma Id:"+cId+"]", "system");
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
    } public int getTmpCompanyVerId(String company_Id) { 
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query1 = "SELECT MAX(company_tmp_Version) AS verID FROM `company_tmp` WHERE company_Id = ? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, company_Id); 
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {   sonuc = rs.getInt("verID"); }                      
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
 
    }  public int updateTmpCompany(String companyId) { 
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query1 = "UPDATE `ilan_tasimacilar`.company_tmp SET `company_tmp_lsActive`= 0  WHERE `company_Id` = ? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, companyId);
                        sonuc = ps.executeUpdate();

                                              
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
 
    }  public int disableTmpCompany(String companyTmpId) { 
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query1 = "UPDATE `ilan_tasimacilar`.company_tmp SET `company_tmp_lsActive`= 0  WHERE `company_tmp_Id` = ? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, companyTmpId);
                        sonuc = ps.executeUpdate();

                                              
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
 
    } public CorporateAccountBean getCompanyWithUrlName(String urlName) {
       
        
        CorporateAccountBean cb = new CorporateAccountBean();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   
                        String query1 = "SELECT * FROM `ilan_tasimacilar`.`company_` WHERE `company_UrlName` = ? AND company_IsPublish = 1";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, urlName);
                        ResultSet rs = ps.executeQuery();

                          while (rs.next()) {   
                                                cb.setCompany_Id(rs.getString("company_Id"));
                                                cb.setCompany_Name(rs.getString("company_Name"));
                                                cb.setCompany_FullName(rs.getString("company_FullName"));
                                            
                                                
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
        
        return cb;
    } public CorporateAccountBean getCompanyWithId(String companyId) {
       
        
        CorporateAccountBean cb = new CorporateAccountBean();   Connection con = null;  PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   
                        String query1 = "SELECT * FROM `ilan_tasimacilar`.`company_` WHERE `company_Id` = ? AND company_IsPublish = 1";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, companyId);
                        ResultSet rs = ps.executeQuery();

                          while (rs.next()) {  
                                                cb.setCompany_Name(rs.getString("company_Name"));
                                                cb.setCompany_FullName(rs.getString("company_FullName"));
                                                cb.setCompany_UrlName(rs.getString("company_UrlName"));
                                                
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
        
        return cb;
    }
   
    
    
    
    
    
}
