package com.tasimacilar.ilan.profile.account;
import com.tasimacilar.ilan.system.loging.*;
import com.tasimacilar.ilan.system.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {
    public boolean accountIsActive(String accountMobilePhoneNumber){
        boolean sonuc = false; Connection con = null; PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();     if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{  
                try {   String query1 = "SELECT * FROM ilan_tasimacilar.account_ u  WHERE u.account_MobilePhoneNumber=? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, accountMobilePhoneNumber);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {sonuc = rs.getBoolean("account_IsActive"); }
                                            
                   } 

                catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", this.getClass().getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+ex);}
                        }
        }
        
     return sonuc;
    } 
}
