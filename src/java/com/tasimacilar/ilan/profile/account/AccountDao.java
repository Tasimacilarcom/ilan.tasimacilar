package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.common.AddressBean;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
public class AccountDao {
    public int createAccount(PersonalAccountBean pAccount) { 
        int sonuc = 0;
        Long Account_TC_Id = pAccount.getAccountBean().getAccount_TC_Id() == null ? 0L : pAccount.getAccountBean().getAccount_TC_Id();
        java.sql.Timestamp account_BirthDate = pAccount.getAccountBean().getAccount_BirthDate() == null ? null : new java.sql.Timestamp(pAccount.getAccountBean().getAccount_BirthDate().getTime());
        java.sql.Timestamp account_TermsAcceptedTime = pAccount.getAccountBean().getAccount_TermsAcceptedTime() == null ? null : new java.sql.Timestamp(pAccount.getAccountBean().getAccount_TermsAcceptedTime().getTime());
        java.sql.Timestamp account_CreateTime = pAccount.getAccountBean().getAccount_CreateTime() == null ? null : new java.sql.Timestamp(pAccount.getAccountBean().getAccount_CreateTime().getTime());
        java.sql.Timestamp account_LastLoginTime = pAccount.getAccountBean().getAccount_LastLoginTime() == null ? null : new java.sql.Timestamp(pAccount.getAccountBean().getAccount_LastLoginTime().getTime());
        java.sql.Timestamp account_LastModifyTime = pAccount.getAccountBean().getAccount_LastModifyTime() == null ? null : new java.sql.Timestamp(pAccount.getAccountBean().getAccount_LastModifyTime().getTime());
        java.sql.Timestamp address_CreateTime = pAccount.getAddressBean().getAddress_last_change_time() == null ? null : new java.sql.Timestamp(pAccount.getAddressBean().getAddress_last_change_time().getTime());
        Connection con = null;   PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_accounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");
                        ps.setString(2, pAccount.getAccountBean().getAccount_Id());
                        ps.setLong(3, Account_TC_Id);
                        ps.setString(4, pAccount.getAccountBean().getAccount_EmailActivationId());
                        ps.setString(5, pAccount.getAccountBean().getAccount_MobilePhoneNumberActivationId());
                        ps.setString(6, pAccount.getAccountBean().getAccount_FirstName());
                        ps.setString(7, pAccount.getAccountBean().getAccount_LastName());
                        ps.setString(8, pAccount.getAccountBean().getAccount_EmailAddress());
                        ps.setString(9, pAccount.getAccountBean().getAccount_MobilePhoneNumber());
                        ps.setString(10, pAccount.getAccountBean().getAccount_Password_1());
                        ps.setString(11, pAccount.getAccountBean().getAccount_Gender());
                        ps.setTimestamp(12, account_BirthDate);
                        ps.setBoolean(13, pAccount.getAccountBean().isAccount_RememberMe());
                        ps.setString(14, pAccount.getAccountBean().getAccount_MembershipType());
                        ps.setString(15, pAccount.getAccountBean().getAccount_ActivityArea());
                        ps.setString(16, pAccount.getAccountBean().getAccount_Type());
                        ps.setString(17, pAccount.getAccountBean().getAccount_SecretQuestion());
                        ps.setString(18, pAccount.getAccountBean().getAccount_SecretQuestionAnswer());
                        ps.setBoolean(19, pAccount.getAccountBean().isAccount_MailSubscription());
                        ps.setBoolean(20, pAccount.getAccountBean().isAccount_TermsAccepted());
                        ps.setString(21, pAccount.getAccountBean().getAccount_TermsAcceptedIp());
                        ps.setTimestamp(22, account_TermsAcceptedTime);
                        ps.setBoolean(23, pAccount.getAccountBean().isAccount_IsActive());
                        ps.setString(24, pAccount.getAccountBean().getAccount_CreatedIp());
                        ps.setTimestamp(25, account_CreateTime);
                        ps.setString(26, pAccount.getAccountBean().getAccount_LastLoginIp());
                        ps.setTimestamp(27, account_LastLoginTime);
                        ps.setString(28, pAccount.getAccountBean().getAccount_LastModifyIp());
                        ps.setTimestamp(29, account_LastModifyTime);
                        ps.setString(30, pAccount.getAccountBean().getAccount_LastChangerAccountId());
                        ps.setString(31, pAccount.getAccountBean().getCompany_Id());
                        ps.setString(32, pAccount.getAccountBean().getAddress_id());
                        ps.setBoolean(33, pAccount.getAccountBean().getAccount_passwordNotChange());
                        ps.setString(34, pAccount.getAddressBean().getAddress_Id());
                        ps.setInt(35, pAccount.getAddressBean().getAddress_TypeId());
                        ps.setString(36, pAccount.getAddressBean().getAddress_Name());
                        ps.setString(37, pAccount.getAddressBean().getAddress());
                        ps.setInt(38, pAccount.getAddressBean().getAddress_CountryId());
                        ps.setInt(39, pAccount.getAddressBean().getAddress_CityId());
                        ps.setInt(40, pAccount.getAddressBean().getAddress_TownId());
                        ps.setInt(41, pAccount.getAddressBean().getAddress_DistrictId());
                        ps.setInt(42, pAccount.getAddressBean().getAddress_NeighborhoodId());
                        ps.setString(43, pAccount.getAddressBean().getAddress_PostCode());
                        ps.setString(44, pAccount.getAddressBean().getAddress_location_Latitude());
                        ps.setString(45, pAccount.getAddressBean().getAddress_location_Longitude());
                        ps.setTimestamp(46, address_CreateTime);
                        ps.setTimestamp(47, address_CreateTime);
                        ps.setString(48, pAccount.getAddressBean().getAddress_last_Changer_account_id());
    
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc==1){
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni kullanıcı olusturuldu. [Adı:"+pAccount.getAccountBean().getAccount_FirstName()
                                                                                                            +" Soyadı:"+pAccount.getAccountBean().getAccount_LastName()
                                                                                                            +" Email:"+pAccount.getAccountBean().getAccount_EmailAddress()+"]", "system");
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
    }public PersonalAccountBean getAccountDetailWithParam(PersonalAccountBean pAccount, String processParameter) {
      
        int sonuc = 0;
        PersonalAccountBean pab = new PersonalAccountBean();
        Connection con = null;
        PreparedStatement ps = null;
        if( processParameter.equals("getAllWithEmail") || 
            processParameter.equals("getAllWithMobilePhoneNumber") || 
            processParameter.equals("getAllWithId")){
            
    
            con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                       +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   ps = con.prepareCall("{call pro_accounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                            ps.setString(1, processParameter); 
ps.setString(2, pAccount.getAccountBean().getAccount_Id());
                            ps.setLong(3, 0);
                            ps.setString(4, null);
                            ps.setString(5, null);
                            ps.setString(6, null);
                            ps.setString(7, null);
                            ps.setString(8, pAccount.getAccountBean().getAccount_EmailAddress());
                            ps.setString(9, pAccount.getAccountBean().getAccount_MobilePhoneNumber());
                            ps.setString(10, null);
                            ps.setString(11, null);
                            ps.setDate(12, null);
                            ps.setBoolean(13, false);
                            ps.setString(14, null);
                            ps.setString(15, null);
                            ps.setString(16, null);
                            ps.setString(17, null);
                            ps.setString(18, null);
                            ps.setBoolean(19, false);
                            ps.setBoolean(20, false);
                            ps.setString(21, null);
                            ps.setDate(22, null);
                            ps.setBoolean(23, false);
                            ps.setString(24, null);
                            ps.setDate(25, null);
                            ps.setString(26, null);
                            ps.setDate(27, null);
                            ps.setString(28, null);
                            ps.setDate(29, null);
                            ps.setString(30, null);
                            ps.setString(31, null);
                            ps.setString(32, null);
                            ps.setBoolean(33, false);
ps.setString(34, null);
                            ps.setInt(35, 0);
                            ps.setString(36, null);
                            ps.setString(37, null);
                            ps.setInt(38, 0);
                            ps.setInt(39, 0);
                            ps.setInt(40, 0);
                            ps.setInt(41, 0);
                            ps.setInt(42, 0);
                            ps.setString(43, null);
                            ps.setString(44, null);
                            ps.setString(45, null);
                            ps.setDate(46, null);
                            ps.setDate(47, null);
                            ps.setString(48,null);
                          
                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    AccountBean ab = new AccountBean();
                                                    ab.setAccount_Id(rs.getString("account_Id"));
                                                    ab.setAccount_TC_Id(rs.getLong("account_TC_Id"));
                                                    ab.setAccount_EmailActivationId(rs.getString("account_EmailActivationId"));
                                                    ab.setAccount_MobilePhoneNumberActivationId(rs.getString("account_MobilePhoneNumberActivationId"));
                                                    ab.setAccount_FirstName(rs.getString("account_FirstName"));
                                                    ab.setAccount_LastName(rs.getString("account_LastName"));
                                                    ab.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                                    ab.setAccount_EmailAddressActivated(rs.getBoolean("account_EmailAddressActivated"));
                                                    ab.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                                    ab.setAccount_MobilePhoneNumberActivated(rs.getBoolean("account_MobilePhoneNumberActivated"));
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
                                                    ab.setAccount_passwordNotChange(rs.getBoolean("account_passwordNotChange"));
                                                    ab.setAccount_passwordChangeRequired(rs.getBoolean("account_passwordChangeRequired"));
                                                    
                                                    AddressBean adb = new AddressBean();
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
                                                    
                                                    pab.setAccountBean(ab);
                                                    pab.setAddressBean(adb);
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
        
        else{   LogManagerDao.createLog("error", this.getClass().getName(), "Invalid processParameter.", "system"); }   
        return pab;
    } public AccountBean getAccountDetailWithAccountId(String accountId) {
      
        int sonuc = 0;
        AccountBean ab = new AccountBean();
        
        Connection con = null;
        PreparedStatement ps = null;
         
        if( accountId != null && !accountId.equals("")){
             
    
            con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                       +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   ps = con.prepareCall("{call pro_accounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                            ps.setString(1, "getAllWithId"); 
ps.setString(2, accountId);
                            ps.setLong(3, 0);
                            ps.setString(4, null);
                            ps.setString(5, null);
                            ps.setString(6, null);
                            ps.setString(7, null);
                            ps.setString(8, null);
                            ps.setString(9, null);
                            ps.setString(10, null);
                            ps.setString(11, null);
                            ps.setDate(12, null);
                            ps.setBoolean(13, false);
                            ps.setString(14, null);
                            ps.setString(15, null);
                            ps.setString(16, null);
                            ps.setString(17, null);
                            ps.setString(18, null);
                            ps.setBoolean(19, false);
                            ps.setBoolean(20, false);
                            ps.setString(21, null);
                            ps.setDate(22, null);
                            ps.setBoolean(23, false);
                            ps.setString(24, null);
                            ps.setDate(25, null);
                            ps.setString(26, null);
                            ps.setDate(27, null);
                            ps.setString(28, null);
                            ps.setDate(29, null);
                            ps.setString(30, null);
                            ps.setString(31, null);
                            ps.setString(32, null);
                            ps.setBoolean(33, false);
ps.setString(34, null);
                            ps.setInt(35, 0);
                            ps.setString(36, null);
                            ps.setString(37, null);
                            ps.setInt(38, 0);
                            ps.setInt(39, 0);
                            ps.setInt(40, 0);
                            ps.setInt(41, 0);
                            ps.setInt(42, 0);
                            ps.setString(43, null);
                            ps.setString(44, null);
                            ps.setString(45, null);
                            ps.setDate(46, null);
                            ps.setDate(47, null);
                            ps.setString(48,null);

                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    
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
                                                    ab.setAccount_passwordNotChange(rs.getBoolean("account_passwordNotChange"));
                                                    
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
        
        
        return ab;
    } public List<PersonalAccountBean> getAllAccountsWithParam(PersonalAccountBean pAccount, String processParameter) {
        
        int sonuc = 0;  List<PersonalAccountBean> abList = new ArrayList<PersonalAccountBean>();
         Connection con = null; PreparedStatement ps = null;  if( processParameter.equals("getAll") ){  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   ps = con.prepareCall("{call pro_accounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                            ps.setString(1, processParameter); 
ps.setString(2, pAccount.getAccountBean().getAccount_Id());
                            ps.setLong(3, 0);
                            ps.setString(4, null);
                            ps.setString(5, null);
                            ps.setString(6, null);
                            ps.setString(7, null);
                            ps.setString(8, pAccount.getAccountBean().getAccount_EmailAddress());
                            ps.setString(9, pAccount.getAccountBean().getAccount_MobilePhoneNumber());
                            ps.setString(10, null);
                            ps.setString(11, null);
                            ps.setDate(12, null);
                            ps.setBoolean(13, false);
                            ps.setString(14, null);
                            ps.setString(15, null);
                            ps.setString(16, null);
                            ps.setString(17, null);
                            ps.setString(18, null);
                            ps.setBoolean(19, false);
                            ps.setBoolean(20, false);
                            ps.setString(21, null);
                            ps.setDate(22, null);
                            ps.setBoolean(23, false);
                            ps.setString(24, null);
                            ps.setDate(25, null);
                            ps.setString(26, null);
                            ps.setDate(27, null);
                            ps.setString(28, null);
                            ps.setDate(29, null);
                            ps.setString(30, null);
                            ps.setString(31, null);
                            ps.setString(32, null);
                            ps.setBoolean(33, false);
 ps.setString(34, null);
                            ps.setInt(35, 0);
                            ps.setString(36, null);
                            ps.setString(37, null);
                            ps.setInt(38, 0);
                            ps.setInt(39, 0);
                            ps.setInt(40, 0);
                            ps.setInt(41, 0);
                            ps.setInt(42, 0);
                            ps.setString(43, null);
                            ps.setString(44, null);
                            ps.setString(45, null);
                            ps.setDate(46, null);
                            ps.setDate(47, null);
                            ps.setString(48,null);

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
                                                    ab.setAccount_passwordNotChange(rs.getBoolean("account_passwordNotChange"));
                                                    
                                                    AddressBean adb = new AddressBean();
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
                                                    
                                                    PersonalAccountBean pab = new PersonalAccountBean();
                                                    pab.setAccountBean(ab);
                                                    pab.setAddressBean(adb);
                                                    
                                                    abList.add(pab);
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
        
         return abList;
    } public String getUserLastLoginTime(String accountId){
        
        String sonuc = "";Connection con = null;  PreparedStatement ps = null;   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT * FROM ilan_tasimacilar.account_lastlogin u WHERE u.account_Id=? ORDER BY u.account_LastLoginId DESC LIMIT 1,1 ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, accountId);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                                            sonuc = sdf.format(rs.getTimestamp("account_LastLoginTime")); 
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
        }return sonuc;
    }public String getUserLastLoginIp(String accountId){
        
        String sonuc = "";  Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT * FROM ilan_tasimacilar.account_lastlogin u WHERE u.account_Id=? ORDER BY u.account_LastLoginId DESC LIMIT 1,1 ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, accountId);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { sonuc = rs.getString("account_LastLoginIp"); }
                        
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
    } public int insertAccountLastLoginInfo(String accountId, String loginTime, String loginIp, String loginOs, String loginBrowser){
        
        int sonuc = 0;   PreparedStatement ps = null; con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "INSERT INTO `ilan_tasimacilar`.`account_lastlogin` (`account_LastLoginTime`,"
                                                                                         + "`account_LastLoginIp`,"
                                                                                         + "`account_LastLoginOs`,"
                                                                                         + "`account_LastLoginBrowser`,"
                                                                                         + "`account_Id`) "
                                                                                         + "VALUES (?,?,?,?,?)";

                        ps = con.prepareStatement(query);
                        ps.setString(1, loginTime);
                        ps.setString(2, loginIp);
                        ps.setString(3, loginOs);
                        ps.setString(4, loginBrowser);
                        ps.setString(5, accountId);
                       
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
    } public int updateAccountPassword(String userEmail, String newPassword){
        
        int sonuc = 0; Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_Password=? WHERE account_EmailAddress=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, newPassword);
                        ps.setString(2, userEmail);
                       
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
    } public int updateAccountGsmActivationId(String accountId, String newGsmActivationId){
        
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;
  con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` "
                                      + "SET account_MobilePhoneNumberActivationId=?, "
                                      + "account_IsActive=false, "
                                      + "account_MobilePhoneNumberActivated=false "
                                      + "WHERE account_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, newGsmActivationId);
                        ps.setString(2, accountId);
                       
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
    } public int updateAccountEmailActivationId(String accountId, String newEmailActivationId){
        
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;
   con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` "
                                      + "SET account_EmailActivationId=?, "
                                      + "account_EmailAddressActivated=false "
                                      + "WHERE account_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, newEmailActivationId);
                        ps.setString(2, accountId);
                       
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
    } public int updateAccountEmail(String userEmail, String newPassword){
        
        int sonuc = 0;   Connection con = null; PreparedStatement ps = null;
  con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_Password=? WHERE account_EmailAddress=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, newPassword);
                        ps.setString(2, userEmail);
                       
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
    }      public int updateAccount(PersonalAccountBean pAccount) {
        
        int sonuc = 0;
        Long Account_TC_Id = pAccount.getAccountBean().getAccount_TC_Id() == null ? 0L : pAccount.getAccountBean().getAccount_TC_Id();
        java.sql.Date account_BirthDate = pAccount.getAccountBean().getAccount_BirthDate() == null ? null : new java.sql.Date(pAccount.getAccountBean().getAccount_BirthDate().getTime());
        java.sql.Date account_TermsAcceptedTime = pAccount.getAccountBean().getAccount_TermsAcceptedTime() == null ? null : new java.sql.Date(pAccount.getAccountBean().getAccount_TermsAcceptedTime().getTime());
        java.sql.Date account_CreateTime = pAccount.getAccountBean().getAccount_CreateTime() == null ? null : new java.sql.Date(pAccount.getAccountBean().getAccount_CreateTime().getTime());
        java.sql.Date account_LastLoginTime = pAccount.getAccountBean().getAccount_LastLoginTime() == null ? null : new java.sql.Date(pAccount.getAccountBean().getAccount_LastLoginTime().getTime());
        java.sql.Date account_LastModifyTime = pAccount.getAccountBean().getAccount_LastModifyTime() == null ? null : new java.sql.Date(pAccount.getAccountBean().getAccount_LastModifyTime().getTime());
        java.sql.Date address_LastModifyTime = pAccount.getAddressBean().getAddress_last_change_time() == null ? null : new java.sql.Date(pAccount.getAddressBean().getAddress_last_change_time().getTime());

        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_accounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "update");ps.setString(2, pAccount.getAccountBean().getAccount_Id());
                        ps.setLong(3, Account_TC_Id);
                        ps.setString(4, pAccount.getAccountBean().getAccount_EmailActivationId());
                        ps.setString(5, pAccount.getAccountBean().getAccount_MobilePhoneNumberActivationId());
                        ps.setString(6, pAccount.getAccountBean().getAccount_FirstName());
                        ps.setString(7, pAccount.getAccountBean().getAccount_LastName());
                        ps.setString(8, pAccount.getAccountBean().getAccount_EmailAddress());
                        ps.setString(9, pAccount.getAccountBean().getAccount_MobilePhoneNumber());
                        ps.setString(10, pAccount.getAccountBean().getAccount_Password_1());
                        ps.setString(11, pAccount.getAccountBean().getAccount_Gender());
                        ps.setDate(12, account_BirthDate);
                        ps.setBoolean(13, pAccount.getAccountBean().isAccount_RememberMe());
                        ps.setString(14, pAccount.getAccountBean().getAccount_MembershipType());
                        ps.setString(15, pAccount.getAccountBean().getAccount_ActivityArea());
                        ps.setString(16, pAccount.getAccountBean().getAccount_Type());
                        ps.setString(17, pAccount.getAccountBean().getAccount_SecretQuestion());
                        ps.setString(18, pAccount.getAccountBean().getAccount_SecretQuestionAnswer());
                        ps.setBoolean(19, pAccount.getAccountBean().isAccount_MailSubscription());
                        ps.setBoolean(20, pAccount.getAccountBean().isAccount_TermsAccepted());
                        ps.setString(21, pAccount.getAccountBean().getAccount_TermsAcceptedIp());
                        ps.setDate(22, account_TermsAcceptedTime);
                        ps.setBoolean(23, pAccount.getAccountBean().isAccount_IsActive());
                        ps.setString(24, pAccount.getAccountBean().getAccount_CreatedIp());
                        ps.setDate(25, account_CreateTime);
                        ps.setString(26, pAccount.getAccountBean().getAccount_LastLoginIp());
                        ps.setDate(27, account_LastLoginTime);
                        ps.setString(28, pAccount.getAccountBean().getAccount_LastModifyIp());
                        ps.setDate(29, account_LastModifyTime);
                        ps.setString(30, pAccount.getAccountBean().getAccount_LastChangerAccountId());
                        ps.setString(31, pAccount.getAccountBean().getCompany_Id());
                        ps.setString(32, pAccount.getAccountBean().getAddress_id());
                        ps.setBoolean(33, pAccount.getAccountBean().getAccount_passwordNotChange());
                       ps.setString(34, pAccount.getAddressBean().getAddress_Id()); 
                        ps.setInt(35, pAccount.getAddressBean().getAddress_TypeId());
                        ps.setString(36, pAccount.getAddressBean().getAddress_Name());
                        ps.setString(37, pAccount.getAddressBean().getAddress());
                        ps.setInt(38, pAccount.getAddressBean().getAddress_CountryId());
                        ps.setInt(39, pAccount.getAddressBean().getAddress_CityId());
                        ps.setInt(40, pAccount.getAddressBean().getAddress_TownId());
                        ps.setInt(41, pAccount.getAddressBean().getAddress_DistrictId());
                        ps.setInt(42, pAccount.getAddressBean().getAddress_NeighborhoodId());
                        ps.setString(43, pAccount.getAddressBean().getAddress_PostCode());
                        ps.setString(44, pAccount.getAddressBean().getAddress_location_Latitude());
                        ps.setString(45, pAccount.getAddressBean().getAddress_location_Longitude());
                        ps.setDate(46, address_LastModifyTime);
                        ps.setDate(47, address_LastModifyTime);
                        ps.setString(48, pAccount.getAddressBean().getAddress_last_Changer_account_id());
           
                        sonuc = ps.executeUpdate();  
                       
                        if(sonuc == 1){
                            System.out.println("Kullanıcı Güncelleme BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Kullanıcı guncelleme basarılı. [Adı:"+pAccount.getAccountBean().getAccount_FirstName()
                                                                                                            +" Soyadı:"+pAccount.getAccountBean().getAccount_LastName()
                                                                                                            +" Email:"+pAccount.getAccountBean().getAccount_EmailAddress()+"]", "system");
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
    }public AccountBean getAccountWithGsmNo(String gsmNo) {
        
        int sonuc = 0;  AccountBean ab = new AccountBean(); Connection con = null;
        PreparedStatement ps = null; if(gsmNo!=null && !gsmNo.equals("") ){
                     
            con = ConnectionManager.GetConnection();

            if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                               System.err.println(":::ERROR::: Time=["+new Date()
                                                          +"] Class=["+this.getClass().getName()
                                                         +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                        +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}

            else{   try {   String query = "SELECT * FROM ilan_tasimacilar.account_ WHERE account_MobilePhoneNumber = ?";

                            ps = con.prepareStatement(query);
                            ps.setString(1, gsmNo);
     
                            ResultSet rs = ps.executeQuery();

                             while (rs.next()) {    ab.setAccount_Id(rs.getString("account_Id"));
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
        
        
       
        return ab;
    }  public boolean getUserSupportNotification(String accountId){
        
        boolean sonuc = false;  Connection con = null; PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT account_isSupportNotification FROM ilan_tasimacilar.account_ u WHERE u.account_Id=? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, accountId);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { sonuc = rs.getBoolean("account_isSupportNotification");    }
                        
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
    } public int updateUserSupportNotification(boolean value, String accountId){
        
        int sonuc = 0;  Connection con = null;   PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_isSupportNotification=? WHERE account_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setBoolean(1, value);
                        ps.setString(2, accountId);
                     
                       
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
    }     public boolean getUserMessageNotification(String accountId){
        
        boolean sonuc = false;  Connection con = null; PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT account_isMessageNotification FROM ilan_tasimacilar.account_ u WHERE u.account_Id=? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, accountId);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { sonuc = rs.getBoolean("account_isMessageNotification");    }
                        
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
    }  public int updateUserMessageNotification(boolean value, String accountId){
        
        int sonuc = 0;  Connection con = null;  PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_isMessageNotification=? WHERE account_Id=? ;";

                        ps = con.prepareStatement(query);
                        ps.setBoolean(1, value);
                        ps.setString(2, accountId);
                     
                       
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
    }    
    

    
    
    
}
