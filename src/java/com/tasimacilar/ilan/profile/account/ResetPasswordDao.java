package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ResetPasswordDao {
   public int createPasswordChangeRecord(ResetPasswordBean passResetReq){
    
        int sonuc = 0;
     Connection con = null;
        PreparedStatement ps = null;
         java.sql.Timestamp requestTime = passResetReq.getResetPassword_SmsOnayKodu_RequestTime() == null ? null : new java.sql.Timestamp(passResetReq.getResetPassword_SmsOnayKodu_RequestTime().getTime());
        java.sql.Timestamp createTime = passResetReq.getResetPassword_ChangeTime() == null ? null : new java.sql.Timestamp(passResetReq.getResetPassword_ChangeTime().getTime());
        con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "INSERT INTO `ilan_tasimacilar`.`password_reset` (`resetPassword_Id`,"
                                                                                      + "`resetPassword_GsmNo`,"
                                                                                      + "`resetPassword_SmsOnayKodu_RequestTime`,"
                                                                                      + "`resetPassword_SmsOnayKodu_RequestIp`,"
                                                                                      + "`resetPassword_SmsOnayKodu`,"
                                                                                      + "`resetPassword_ChangeTime`,"
                                                                                      + "`resetPassword_ChangeIp`,"
                                                                                      + "`resetPassword_IsActive`) "
                                                                                      + "VALUES (?,?,?,?,?,?,?,?)";

                        ps = con.prepareStatement(query);
                        ps.setString(1, passResetReq.getResetPassword_Id());
                        ps.setString(2, passResetReq.getResetPassword_GsmNo());
                        ps.setTimestamp(3, requestTime);
                        ps.setString(4, passResetReq.getResetPassword_SmsOnayKodu_RequestIp());
                        ps.setString(5, passResetReq.getResetPassword_SmsOnayKodu());
                        ps.setTimestamp(6, createTime);
                        ps.setString(7, passResetReq.getResetPassword_ChangeIp());
                        ps.setBoolean(8, passResetReq.isResetPassword_IsActive());
                       
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
    } public int updatePasswordChangeRecord(ResetPasswordBean passResetReq){
    
        int sonuc = 0; Connection con = null;  PreparedStatement ps = null;
        
        java.sql.Timestamp ChangeTime = passResetReq.getResetPassword_ChangeTime() == null ? null : new java.sql.Timestamp(passResetReq.getResetPassword_ChangeTime().getTime());
       
        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`password_reset` "
                                      + "SET resetPassword_ChangeTime=?, "
                                      + "resetPassword_ChangeIp=?, "
                                      + "resetPassword_IsActive=? "
                                      + "WHERE resetPassword_SmsOnayKodu=? "
                                      + "AND resetPassword_GsmNo = ? ;";
                        
                        ps = con.prepareStatement(query);
                        ps.setTimestamp(1, ChangeTime);
                        ps.setString(2, passResetReq.getResetPassword_ChangeIp());
                        ps.setBoolean(3, passResetReq.isResetPassword_IsActive());
                        ps.setString(4, passResetReq.getResetPassword_SmsOnayKodu());
                        ps.setString(5, passResetReq.getResetPassword_GsmNo());
                      
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
    } public int getPasswordChangeRequestSize(String GsmNo){
       int sonuc = 0; Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT COUNT(resetPassword_Id) AS total_req "
                                     + "FROM `ilan_tasimacilar`.`password_reset` "
                                     + "WHERE resetPassword_GsmNo =? "
                                     + "AND resetPassword_SmsOnayKodu_RequestTime >= DATE_SUB(NOW(),INTERVAL 1 HOUR); ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, GsmNo);
                       
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { sonuc = rs.getInt("total_req");  }
                        
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
    } public ResetPasswordBean getSmsOnayKoduDetay(String SmsOnayKodu, String gsmNo){
        
        ResetPasswordBean r = new ResetPasswordBean();
            
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query = "SELECT * "
                                     + "FROM `ilan_tasimacilar`.`password_reset` "
                                     + "WHERE resetPassword_SmsOnayKodu=?  AND resetPassword_GsmNo=? ";

                        ps = con.prepareStatement(query);
                        ps.setString(1, SmsOnayKodu);
                        ps.setString(2, gsmNo);
                        
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { r.setResetPassword_GsmNo(rs.getString("resetPassword_GsmNo"));
                                            r.setResetPassword_SmsOnayKodu_RequestTime(rs.getTimestamp("resetPassword_SmsOnayKodu_RequestTime"));
                                            r.setResetPassword_IsActive(rs.getBoolean("resetPassword_IsActive"));
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
        return r;
    }public int updateAccountPasswordNotChange(String MobilePhoneNumber){
        
        int sonuc = 0;
    
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_passwordNotChange=true WHERE account_MobilePhoneNumber=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, MobilePhoneNumber);
                       
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
    } public int updateAccountPassword(String userGSM, String newPassword){
        
        int sonuc = 0;
    
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_Password=?, account_passwordChangeRequired=false WHERE account_MobilePhoneNumber=? ;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, newPassword);
                        ps.setString(2, userGSM);
                       
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
