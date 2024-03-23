package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountDao;
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
public class AllAccountsDao {  public List<AllAccountsBean> getAllAccounts() {
        
        int sonuc = 0; List<AllAccountsBean> abList = new ArrayList<AllAccountsBean>();
    
        Connection con = null; PreparedStatement ps = null;
        
       
                     
            con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ "
                                            + "ON account_.company_Id = company_.company_Id";

                            ps = con.prepareStatement(query1);
                            
                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    AccountBean ab = new AccountBean();
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
                                                    PersonalAccountBean p = new PersonalAccountBean();
                                                    p.setAccountBean(ab);
                                                    
                                                    CorporateAccountBean cb = new CorporateAccountBean();
                                                    cb.setCompany_Id(rs.getString("company_Id"));
                                                    cb.setCompany_Type(rs.getString("company_Type"));
                                                    cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                                    cb.setCompany_Name(rs.getString("company_Name"));
                                                    cb.setCompany_FullName(rs.getString("company_FullName"));
                                                    cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                                    cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                                    cb.setCompany_Email(rs.getString("company_Email1"));
                                                    cb.setCompany_Web(rs.getString("company_Web1"));
                                                    cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                                    cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                                    cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                                    cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));

                                                    
                                                    AllAccountsBean a = new AllAccountsBean();
                                                    a.setPersonalAccountBean(p);
                                                    a.setCorporateAccountBean(cb);
                                                    
                                                    
                                                    abList.add(a);
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
        
     
       
        return abList;
    } public AllAccountsBean getAccountWithId(String aId) {  AllAccountsBean a = new AllAccountsBean();  Connection con = null;  PreparedStatement ps = null;
        
        con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query1 =   "SELECT account_.*, company_.*,"
                                                + "( SELECT CONCAT(addresses_.address_,' / ',address_3_town.TownName,' / ',address_2_city.CityName) "
                                                  + "FROM addresses_, address_2_city, address_3_town "
                                                  + "WHERE account_.address_id = addresses_.address_id "
                                                  + "AND addresses_.address_city_id = address_2_city.CityID "
                                                  + "AND addresses_.address_town_id = address_3_town.TownID ) AS userAdress, "
                                                + "( SELECT CONCAT(addresses_.address_,' / ',address_3_town.TownName,' / ',address_2_city.CityName) "
                                                  + "FROM addresses_, address_2_city, address_3_town "
                                                  + "WHERE company_.address_id = addresses_.address_id "
                                                  + "AND addresses_.address_city_id = address_2_city.CityID "
                                                  + "AND addresses_.address_town_id = address_3_town.TownID) AS companyAdress "
                                            + "FROM account_  "
                                            + "LEFT JOIN company_  "
                                            + "ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_Id = ?";

                            ps = con.prepareStatement(query1);
                            ps.setString(1, aId);
                            
                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    AccountBean ab = new AccountBean();
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
                                                    ab.setAddress_(rs.getString("userAdress"));
                                                    PersonalAccountBean p = new PersonalAccountBean();
                                                    p.setAccountBean(ab);
                                                    
                                                    CorporateAccountBean cb = new CorporateAccountBean();
                                                    cb.setCompany_Id(rs.getString("company_Id"));
                                                    cb.setCompany_Type(rs.getString("company_Type"));
                                                    cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                                    cb.setCompany_Name(rs.getString("company_Name"));
                                                    cb.setCompany_FullName(rs.getString("company_FullName"));
                                                    cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                                    cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                                    cb.setCompany_Email(rs.getString("company_Email1"));
                                                    cb.setCompany_Web(rs.getString("company_Web1"));
                                                    cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                                    cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                                    cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                                    cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));
                                                    cb.setAddress_(rs.getString("companyAdress"));

                                                    a.setPersonalAccountBean(p);
                                                    a.setCorporateAccountBean(cb);
                                                   
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
        
     
       
        return a;
    } public int enableDisableAccounts(String param, String aId) {
        
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   if(param != null && !param.equals("") && aId != null && !aId.equals("")){
                            
                            String query = " UPDATE `ilan_tasimacilar`.account_ SET account_IsActive=0 WHERE account_Id = ? ;";
                            String query1 = " UPDATE `ilan_tasimacilar`.account_ SET account_IsActive=1 WHERE account_Id = ? ;";

                            if(param.equals("enable")){ps = con.prepareStatement(query1);}
                            if(param.equals("disable")){ps = con.prepareStatement(query);}
                            
                            ps.setString(1, aId);

                            sonuc = ps.executeUpdate(); 

                            if(sonuc == 1){ System.out.println("Kullanıcı hesabı enable/disable oldu");  }
                        }
                        else {System.err.println(":::HATA:::param veya aId null, bos veya gecersiz geldi.");}
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
    } public int disableAccountsFromUser( String aId, String userEmail, String userMobilePhoneNumber) {
        
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   
                            String query = " UPDATE `ilan_tasimacilar`.account_ SET account_IsActive=0 , account_EmailAddress='old__"+userEmail+"' , account_MobilePhoneNumber='old__"+userMobilePhoneNumber+"'   WHERE account_Id = ? ;";
                            
                            ps = con.prepareStatement(query);
                            
                            ps.setString(1, aId);
                        
                            sonuc = ps.executeUpdate(); 

                            if(sonuc == 1){ System.out.println("Kullanıcı hesabı enable/disable oldu");  }
                       
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
    }  public int deleteAccount(String accountId){
        
        int sonuc = 0;    Connection con = null;  PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", SessionUtil.getUserId());
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "DELETE FROM account_ WHERE account_Id = ? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, accountId);
                       
                        sonuc = ps.executeUpdate(); 
                   
                        if(sonuc == 1){ 
                            LogManagerDao.createLog("info", this.getClass().getName(), accountId+" Id li hesap silindi" , SessionUtil.getUserId());
                            System.err.println(":::BILGI:::"+this.getClass().getName()+" ::: "+accountId+" Id'li hesap silindi");
                        }
                        else{
                            LogManagerDao.createLog("error", this.getClass().getName(), accountId+" Id li hesap silinirket hata oluştu" , SessionUtil.getUserId());
                            System.err.println(":::HATA:::"+this.getClass().getName()+" ::: "+accountId+" Id'li hesap silinirken hata oluştu");
                        }
                        
                    } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), SessionUtil.getUserId());
                                          System.err.println(":::HATA:::"+this.getClass().getName()+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), SessionUtil.getUserId());
                                                                           System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), SessionUtil.getUserId());
                                                    System.err.println(":::HATA:::"+this.getClass().getName()+ex);}
                        }
        }
        return sonuc;
    }  public List<AllAccountsBean> getAccountWithPhoneOrName(String email, String phone, String name) {
        
        int sonuc = 0;   String query1 = null; List<AllAccountsBean> abList = new ArrayList<AllAccountsBean>();
    
        Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   if(!email.equals("") && phone.equals("") && name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_EmailAddress LIKE '%"+email+"%'  ; ";
                            }
            
                            if(!email.equals("") && !phone.equals("") && name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_EmailAddress LIKE '%"+email+"%'  "
                                            + "AND account_.account_MobilePhoneNumber = '"+phone+"' ; ";
                            }
                            if(!email.equals("") && !phone.equals("") && !name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_EmailAddress LIKE '%"+email+"%'  "
                                            + "AND account_.account_MobilePhoneNumber = '"+phone+"' "
                                            + "AND CONCAT( account_.account_FirstName,  ' ', account_.account_LastName ) LIKE '%"+name+"%'; ";
                            }
                            if(!email.equals("") && phone.equals("") && !name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_EmailAddress LIKE '%"+email+"%'  "
                                            + "AND CONCAT( account_.account_FirstName,  ' ', account_.account_LastName ) LIKE '%"+name+"%' ; ";
                            }
                            
                
                            if(email.equals("") && !phone.equals("") && name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_MobilePhoneNumber = '"+phone+"'  ; ";
                            }
                            if(email.equals("") && phone.equals("") && !name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE CONCAT( account_.account_FirstName,  ' ', account_.account_LastName ) LIKE '%"+name+"%'  ; ";
                            }
                            if(email.equals("") && !phone.equals("") && !name.equals("")){
                                query1 =   "SELECT * "
                                            + "FROM account_ "
                                            + "LEFT JOIN company_ ON account_.company_Id = company_.company_Id "
                                            + "WHERE account_.account_MobilePhoneNumber = '"+phone+"' "
                                            + "AND CONCAT( account_.account_FirstName,  ' ', account_.account_LastName ) LIKE '%"+name+"%' ; ";
                            }
               
                            ps = con.prepareStatement(query1);
                                 
                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    AccountBean ab = new AccountBean();
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
                                                    PersonalAccountBean p = new PersonalAccountBean();
                                                    p.setAccountBean(ab);
                                                    
                                                    CorporateAccountBean cb = new CorporateAccountBean();
                                                    cb.setCompany_Id(rs.getString("company_Id"));
                                                    cb.setCompany_Type(rs.getString("company_Type"));
                                                    cb.setCompany_ActivityArea(rs.getString("company_ActivityArea"));
                                                    cb.setCompany_Name(rs.getString("company_Name"));
                                                    cb.setCompany_FullName(rs.getString("company_FullName"));
                                                    cb.setCompany_TaxOffice(rs.getString("company_TaxOffice"));
                                                    cb.setCompany_TaxNumber(rs.getString("company_TaxNumber"));
                                                    cb.setCompany_Email(rs.getString("company_Email1"));
                                                    cb.setCompany_Web(rs.getString("company_Web1"));
                                                    cb.setCompany_LogoUrl(rs.getString("company_LogoUrl"));
                                                    cb.setCompany_create_time(rs.getTimestamp("company_create_time"));
                                                    cb.setCompany_last_change_time(rs.getTimestamp("company_last_change_time"));
                                                    cb.setCompany_last_Changer_account_id(rs.getString("company_last_Changer_account_id"));

                                                    
                                                    AllAccountsBean a = new AllAccountsBean();
                                                    a.setPersonalAccountBean(p);
                                                    a.setCorporateAccountBean(cb);
                                                    
                                                    
                                                    abList.add(a);
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
        
     
       
        return abList;
    }
    

    
    
    
    
}
