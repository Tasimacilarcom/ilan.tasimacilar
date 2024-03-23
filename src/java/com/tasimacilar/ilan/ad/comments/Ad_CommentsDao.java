package com.tasimacilar.ilan.ad.comments;
import com.tasimacilar.ilan.ad.aracimVarHostesAriyorum.Ad_AracimVarHostesAriyorum_Bean;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Ad_CommentsDao {  public int createAdComment(Ad_CommentsBean adComment) { int sonuc = 0; java.sql.Timestamp CreateTime = adComment.getAdComment_Modified() == null ? null : new java.sql.Timestamp(adComment.getAdComment_Modified().getTime());
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");           
                        ps.setString(1, "insert");
                        ps.setString(2, adComment.getAdComment_Id());
                        ps.setString(3, adComment.getAdComment_Comment());
                        ps.setString(4, adComment.getAdComment_Type());
                        ps.setString(5, adComment.getAdComment_ItemId());
                        ps.setString(6, adComment.getAdComment_OvnerAccountId());
                        ps.setBoolean(7, adComment.isAdComment_IsActive());
                        ps.setBoolean(8, adComment.isAdComment_IsPublish());
                        ps.setTimestamp(9, CreateTime);
                        ps.setString(10, adComment.getAdComment_Modifier());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, adComment.getAdComment_Creator());                                                 
                        sonuc = ps.executeUpdate();                         
                        System.out.println("Yeni ilan yorum olusturma BAŞARILI");                 
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
        
        return sonuc;  } public List<Ad_CommentsBean> getAllCommentWithItemId(String ItemId) {   List<Ad_CommentsBean> vl = new ArrayList<Ad_CommentsBean>();      
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}     
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");           
                        ps.setString(1, "getAllWithItemId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, ItemId);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);                
                        ResultSet rs = ps.executeQuery();                      
                        while (rs.next()) { Ad_CommentsBean adc = new Ad_CommentsBean();
                                            adc.setAdComment_Id(rs.getString("AdComment_Id"));
                                            adc.setAdComment_Comment(rs.getString("AdComment_Comment"));
                                            adc.setAdComment_Type(rs.getString("AdComment_Type"));
                                            adc.setAdComment_ItemId(rs.getString("AdComment_ItemId"));
                                            adc.setAdComment_OvnerAccountId(rs.getString("AdComment_OvnerAccountId"));
                                            adc.setAdComment_IsActive(rs.getBoolean("AdComment_IsActive"));
                                            adc.setAdComment_IsPublish(rs.getBoolean("AdComment_IsPublish"));
                                            adc.setAdComment_Modified(rs.getTimestamp("AdComment_Modified"));
                                            adc.setAdComment_Modifier(rs.getString("AdComment_Modifier"));
                                            adc.setAdComment_Created(rs.getTimestamp("AdComment_Created"));
                                            adc.setAdComment_Creator(rs.getString("AdComment_creator"));                                           
                                            AccountBean ab = new AccountBean();
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
                                            adc.setAccountBean(ab);                                         
                                            vl.add(adc);
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
    } 
    public List<Ad_CommentsBean> getAllComment() {     
        List<Ad_CommentsBean> vl = new ArrayList<Ad_CommentsBean>();          
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");           
                        ps.setString(1, "getAllForAdmin");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);               
                        ResultSet rs = ps.executeQuery();                       
                        while (rs.next()) { Ad_CommentsBean adc = new Ad_CommentsBean();
                                            adc.setAdComment_Id(rs.getString("AdComment_Id"));
                                            adc.setAdComment_Comment(rs.getString("AdComment_Comment"));
                                            adc.setAdComment_Type(rs.getString("AdComment_Type"));
                                            adc.setAdComment_ItemId(rs.getString("AdComment_ItemId"));
                                            adc.setAdComment_OvnerAccountId(rs.getString("AdComment_OvnerAccountId"));
                                            adc.setAdComment_IsActive(rs.getBoolean("AdComment_IsActive"));
                                            adc.setAdComment_IsPublish(rs.getBoolean("AdComment_IsPublish"));
                                            adc.setAdComment_Modified(rs.getTimestamp("AdComment_Modified"));
                                            adc.setAdComment_Modifier(rs.getString("AdComment_Modifier"));
                                            adc.setAdComment_Created(rs.getTimestamp("AdComment_Created"));
                                            adc.setAdComment_Creator(rs.getString("AdComment_creator"));                                           
                                            AccountBean ab = new AccountBean();
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
                                            Ad_Bean abx = new Ad_Bean();
                                            abx.setAd_Id(rs.getString("ad_Id"));
                                            abx.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            abx.setAd_Title(rs.getString("ad_Title"));
                                            abx.setAd_Comment(rs.getString("ad_Comment"));
                                            abx.setAd_Type(rs.getString("ad_Type"));
                                            abx.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            abx.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            abx.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            abx.setAd_Notes(rs.getString("ad_Notes"));
                                            abx.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            abx.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            abx.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            abx.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            abx.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            abx.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            abx.setAd_Category_Name(rs.getString("ad_Category_"));                                           
                                            adc.setAccountBean(ab);
                                            adc.setAdBean(abx);                                          
                                            vl.add(adc);
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
    }
    public List<Ad_CommentsBean> getAllComment2() {      
        List<Ad_CommentsBean> vl = new ArrayList<Ad_CommentsBean>();           
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}     
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");          
                        ps.setString(1, "getAllForAdmin2");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);                 
                        ResultSet rs = ps.executeQuery();                      
                        while (rs.next()) { Ad_CommentsBean adc = new Ad_CommentsBean();
                                            adc.setAdComment_Id(rs.getString("AdComment_Id"));
                                            adc.setAdComment_Comment(rs.getString("AdComment_Comment"));
                                            adc.setAdComment_Type(rs.getString("AdComment_Type"));
                                            adc.setAdComment_ItemId(rs.getString("AdComment_ItemId"));
                                            adc.setAdComment_OvnerAccountId(rs.getString("AdComment_OvnerAccountId"));
                                            adc.setAdComment_IsActive(rs.getBoolean("AdComment_IsActive"));
                                            adc.setAdComment_IsPublish(rs.getBoolean("AdComment_IsPublish"));
                                            adc.setAdComment_Modified(rs.getTimestamp("AdComment_Modified"));
                                            adc.setAdComment_Modifier(rs.getString("AdComment_Modifier"));
                                            adc.setAdComment_Created(rs.getTimestamp("AdComment_Created"));
                                            adc.setAdComment_Creator(rs.getString("AdComment_creator"));                                           
                                            AccountBean ab = new AccountBean();
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
                                            Ad_Bean abx = new Ad_Bean();
                                            abx.setAd_Id(rs.getString("ad_Id"));
                                            abx.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            abx.setAd_Title(rs.getString("ad_Title"));
                                            abx.setAd_Comment(rs.getString("ad_Comment"));
                                            abx.setAd_Type(rs.getString("ad_Type"));
                                            abx.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            abx.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            abx.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            abx.setAd_Notes(rs.getString("ad_Notes"));
                                            abx.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            abx.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            abx.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            abx.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            abx.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            abx.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            abx.setAd_Category_Name(rs.getString("ad_Category_"));                                            
                                            adc.setAccountBean(ab);
                                            adc.setAdBean(abx);                                          
                                            vl.add(adc);
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
    }
    public List<Ad_CommentsBean> getAllComment3(String ovnerId) {    
        List<Ad_CommentsBean> vl = new ArrayList<Ad_CommentsBean>();     
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}   
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");         
                        ps.setString(1, "getAllForAdmin3");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, ovnerId);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);                 
                        ResultSet rs = ps.executeQuery();                       
                        while (rs.next()) { Ad_CommentsBean adc = new Ad_CommentsBean();
                                            adc.setAdComment_Id(rs.getString("AdComment_Id"));
                                            adc.setAdComment_Comment(rs.getString("AdComment_Comment"));
                                            adc.setAdComment_Type(rs.getString("AdComment_Type"));
                                            adc.setAdComment_ItemId(rs.getString("AdComment_ItemId"));
                                            adc.setAdComment_OvnerAccountId(rs.getString("AdComment_OvnerAccountId"));
                                            adc.setAdComment_IsActive(rs.getBoolean("AdComment_IsActive"));
                                            adc.setAdComment_IsPublish(rs.getBoolean("AdComment_IsPublish"));
                                            adc.setAdComment_Modified(rs.getTimestamp("AdComment_Modified"));
                                            adc.setAdComment_Modifier(rs.getString("AdComment_Modifier"));
                                            adc.setAdComment_Created(rs.getTimestamp("AdComment_Created"));
                                            adc.setAdComment_Creator(rs.getString("AdComment_creator"));                                           
                                            AccountBean ab = new AccountBean();
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
                                            Ad_Bean abx = new Ad_Bean();
                                            abx.setAd_Id(rs.getString("ad_Id"));
                                            abx.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            abx.setAd_Title(rs.getString("ad_Title"));
                                            abx.setAd_Comment(rs.getString("ad_Comment"));
                                            abx.setAd_Type(rs.getString("ad_Type"));
                                            abx.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            abx.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            abx.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            abx.setAd_Notes(rs.getString("ad_Notes"));
                                            abx.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            abx.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            abx.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            abx.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            abx.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            abx.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            abx.setAd_Category_Name(rs.getString("ad_Category_"));                                           
                                            adc.setAccountBean(ab);
                                            adc.setAdBean(abx);                                          
                                            vl.add(adc);
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
    }   
    public int enableDisablePublishAdComment(String param, String cId) {       
        int sonuc = 0;        
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}      
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");
            
                        if (param != null && !param.equals("") && cId != null && !cId.equals("")){ 
                            if(param.equals("enable")){ps.setString(1, "enableComment");}  
                            if(param.equals("disable")){ps.setString(1, "disableComment");}
                            if(param.equals("publish")){ps.setString(1, "publishComment");}                          
                            ps.setString(2, cId);
                            ps.setString(3, null);
                            ps.setString(4, null);
                            ps.setString(5, null);
                            ps.setString(6, null);
                            ps.setBoolean(7, false);
                            ps.setBoolean(8, false);
                            ps.setTimestamp(9, null);
                            ps.setString(10, null);
                            ps.setTimestamp(11, null);
                            ps.setString(12, null);
                            sonuc = ps.executeUpdate();  
                            System.out.println("Yorum düzenleme olusturma BAŞARILI");                            
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
        return sonuc;  } public Ad_CommentsBean getCommentWithId(String cId) {  Ad_CommentsBean adc = new Ad_CommentsBean();    Connection con = null;  PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}       
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");
            
                        ps.setString(1, "getWithCommentId");
                        ps.setString(2, cId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);                
                        ResultSet rs = ps.executeQuery();                      
                        while (rs.next()) { 
                                            adc.setAdComment_Id(rs.getString("AdComment_Id"));
                                            adc.setAdComment_Comment(rs.getString("AdComment_Comment"));
                                            adc.setAdComment_Type(rs.getString("AdComment_Type"));
                                            adc.setAdComment_ItemId(rs.getString("AdComment_ItemId"));
                                            adc.setAdComment_OvnerAccountId(rs.getString("AdComment_OvnerAccountId"));
                                            adc.setAdComment_IsActive(rs.getBoolean("AdComment_IsActive"));
                                            adc.setAdComment_IsPublish(rs.getBoolean("AdComment_IsPublish"));
                                            adc.setAdComment_Modified(rs.getTimestamp("AdComment_Modified"));
                                            adc.setAdComment_Modifier(rs.getString("AdComment_Modifier"));
                                            adc.setAdComment_Created(rs.getTimestamp("AdComment_Created"));
                                            adc.setAdComment_Creator(rs.getString("AdComment_creator"));                                          
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
        
        return adc;
    }  public int updateAdComment(String comment, String cId) {      int sonuc = 0;    Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}       
        else{   try {   ps = con.prepareCall("{call pro_ad_Comments(?,?,?,?,?,?,?,?,?,?,?,?)}");                                              
                        ps.setString(1, "updateComment");
                        ps.setString(2, cId);
                        ps.setString(3, comment);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setBoolean(8, false);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        sonuc = ps.executeUpdate();  
                        System.out.println("Yorum düzenleme  BAŞARILI");                                                  
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
    }}
