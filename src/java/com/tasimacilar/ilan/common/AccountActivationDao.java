package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.*;
import com.tasimacilar.ilan.system.loging.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class AccountActivationDao { public int updateEmailActivation(String emailActivationId) {      
        int sonuc = 0;  Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` SET account_EmailActivationId='', account_EmailAddressActivated=true WHERE account_EmailActivationId=? ;";
            ps = con.prepareStatement(query);ps.setString(1, emailActivationId);sonuc = ps.executeUpdate(); System.out.println("Hesap E-Mail Aktivasyonu BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Hesap E-Mail Aktivasyonu BAŞARILI. [emailActivationId:"+emailActivationId +"]", "system");
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
        } return sonuc; }    public int updatemobilePhoneNumberActivation(String mobilePhoneNumberActivationId) {
        
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        else{   try {   String query =  "UPDATE `ilan_tasimacilar`.`account_` "
                                      + "SET account_MobilePhoneNumberActivationId='', account_MobilePhoneNumberActivated=true, account_IsActive=true "
                                      + "WHERE account_MobilePhoneNumberActivationId=? ;";
             ps = con.prepareStatement(query);ps.setString(1, mobilePhoneNumberActivationId);
                   sonuc = ps.executeUpdate(); System.out.println("Hesap E-Mail Aktivasyonu BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Hesap Mobil Telefon numarası aktivasyonu BAŞARILI. [mobilePhoneNumberActivationId:"+mobilePhoneNumberActivationId +"]", "system");
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
        }return sonuc; }    public static boolean isActivatedMobilePhoneNumber(String mobilePhoneNumberActivationId){
   
        boolean status = false;   boolean activated = false; Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();     if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_MobilePhoneNumberActivated FROM  ilan_tasimacilar.account_ a  WHERE a.account_MobilePhoneNumberActivationId=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, mobilePhoneNumberActivationId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {status = rs.getBoolean("account_MobilePhoneNumberActivated"); }
                                            if (status==false) {activated=false;} else{activated=true;} 
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+IsExist.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+IsExist.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+IsExist.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return activated;
    }public static boolean isActivatedEmail(String emailActivationId){boolean status = false; boolean activated = false;
        Connection con = null;PreparedStatement ps = null; con = ConnectionManager.GetConnection();    
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_EmailAddressActivated    FROM  ilan_tasimacilar.account_ a  WHERE a.account_EmailActivationId=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, emailActivationId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {status = rs.getBoolean("account_EmailAddressActivated"); }
                                            if (status==false) {activated=false;} else{activated=true;} 
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+IsExist.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+IsExist.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+IsExist.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return activated; } public static boolean isActivatedEmailWithGsmNo(String mobilePhoneNumber){
     boolean status = false; boolean activated = false;  Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();    if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_EmailAddressActivated  FROM  ilan_tasimacilar.account_ a  WHERE a.account_MobilePhoneNumber=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, mobilePhoneNumber);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {status = rs.getBoolean("account_EmailAddressActivated"); }
                                            if (status==false) {activated=false;} else{activated=true;} 
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+IsExist.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+IsExist.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+IsExist.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return activated; }public static boolean isActivatedMobilePhoneNumberWithGsmNo(String mobilePhoneNumber){
    boolean status = false;  boolean activated = false; Connection con = null;  PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();     if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_MobilePhoneNumberActivated  FROM  ilan_tasimacilar.account_ a  WHERE a.account_MobilePhoneNumber=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, mobilePhoneNumber);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {status = rs.getBoolean("account_MobilePhoneNumberActivated"); }
                                            if (status==false) {activated=false;} else{activated=true;} 
                   } 

                catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
                                                                    +"] Class=["+IsExist.class.getName()
                                                                   +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                  +"] Message=["+ex+"]:::");
                                         LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) {   System.err.println(":::ERROR::: Time=["+new Date()
                                                                                                        +"] Class=["+IsExist.class.getName()
                                                                                                       +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                                                      +"] Message=["+ex+"]:::");
                                                                             LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { System.err.println(":::ERROR::: Time=["+new Date()
                                                                               +"] Class=["+IsExist.class.getName()
                                                                              +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                                             +"] Message=["+ex+"]:::");
                                                    LogManagerDao.createLog("error", IsExist.class.getName(), ex.toString(), "system");}
                        }
        }
        
     return activated; }

    
}
