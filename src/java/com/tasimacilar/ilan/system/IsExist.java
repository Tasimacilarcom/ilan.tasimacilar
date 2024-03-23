package com.tasimacilar.ilan.system;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.system.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class IsExist {
    public static boolean isExistEmail(String email){
        String dbEmail = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();         
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_EmailAddress FROM  ilan_tasimacilar.account_ a  WHERE a.account_EmailAddress=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, email);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbEmail = rs.getString("account_EmailAddress"); }
                                            if (dbEmail==null) {exist=false;} else{exist=true;}
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
        
     return exist;
    }
    public static boolean isExistMobilePhoneNumber(String mobilePhoneNumber){
   
        String dbNo = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_MobilePhoneNumber FROM  ilan_tasimacilar.account_ a  WHERE a.account_MobilePhoneNumber=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, mobilePhoneNumber);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbNo = rs.getString("account_MobilePhoneNumber"); }
                                            if (dbNo==null) {exist=false;} else{exist=true;}
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
        
     return exist;
    }
    public static boolean isExistEmailActivationId(String emailActivationId){
   
        String dbEmail = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_EmailActivationId FROM  ilan_tasimacilar.account_ a  WHERE a.account_EmailActivationId=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, emailActivationId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbEmail = rs.getString("account_EmailActivationId"); }
                                            if (dbEmail==null) {exist=false;} else{exist=true;}
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
        
     return exist;
    }
    public static boolean isExistMobilePhoneNumberActivationId(String mobilePhoneNumberActivationId){
   
        String dbEmail = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_MobilePhoneNumberActivationId FROM  ilan_tasimacilar.account_ a  WHERE a.account_MobilePhoneNumberActivationId=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, mobilePhoneNumberActivationId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbEmail = rs.getString("account_MobilePhoneNumberActivationId"); }
                                            if (dbEmail==null) {exist=false;} else{exist=true;} 
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
        
     return exist;
    }
    public static boolean isExistTaxIdActivationId(String taxId){
   
        String dbtaxId = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT company_TaxNumber FROM  ilan_tasimacilar.company_ a  WHERE a.company_TaxNumber=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, taxId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbtaxId = rs.getString("company_TaxNumber"); }
                                            if (dbtaxId==null) {exist=false;} else{exist=true;} 
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
        
     return exist;
    }
    public static boolean canNotChangeUserPassword(String gsmNo){
   
        boolean sonuc = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT account_passwordNotChange FROM account_ WHERE account_MobilePhoneNumber = ? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, gsmNo);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {sonuc = rs.getBoolean("account_passwordNotChange"); }
                                            
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
        
     return sonuc;
    }
    public static boolean isExistSmsOnayKodu(String smsOnayKodu, String gsm){
   
        String dbSmsOnayKodu = null;
        boolean exist = false;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();    
        
        if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT resetPassword_SmsOnayKodu "
                                      + "FROM  ilan_tasimacilar.password_reset a  "
                                      + "WHERE a.resetPassword_SmsOnayKodu=? AND resetPassword_GsmNo=?";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, smsOnayKodu); 
                        ps.setString(2, gsm); 
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbSmsOnayKodu = rs.getString("resetPassword_SmsOnayKodu"); }
                                            if (dbSmsOnayKodu==null) {exist=false;} else{exist=true;}
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
        
     return exist;
    }

    
    


}
