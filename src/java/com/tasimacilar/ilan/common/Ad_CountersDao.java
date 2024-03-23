package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.jsoup.Jsoup;
public class Ad_CountersDao {
    public int addCounterData(String adId, boolean adViewCount, boolean adNumberOfLikes, boolean adNumberOfDislikes) {
    int sonuc = 0;  Connection con = null; PreparedStatement ps = null;  Timestamp now = new java.sql.Timestamp(new Date().getTime());
     HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userInternetIp = GetUserEnvironment.getInternetIp(httpServletRequest);con = ConnectionManager.GetConnection();
if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   
                        if(adViewCount){
                            String query_adViewCount = " UPDATE ad_counters SET ad_ViewCount = LAST_INSERT_ID(ad_ViewCount) + 1 , ad_ViewCount_IP = ? , ad_ViewCount_DATE = ? WHERE Ad_Id = ?;";
                            ps = con.prepareStatement(query_adViewCount);
                            ps.setString(1, userInternetIp);
                            ps.setTimestamp(2, now);
                            ps.setString(3, adId);
                        }
                        else if(adNumberOfLikes){
                            String query_adNumberOfLikes = " UPDATE ad_counters SET ad_NumberOfLikes = LAST_INSERT_ID(ad_NumberOfLikes) + 1 WHERE Ad_Id = ?;";
                            ps = con.prepareStatement(query_adNumberOfLikes);
                        }
                        else if(adNumberOfDislikes){
                            String query_adNumberOfDislikes = " UPDATE ad_counters SET ad_NumberOfDislikes = LAST_INSERT_ID(ad_NumberOfDislikes) + 1 WHERE Ad_Id = ?;";
                            ps = con.prepareStatement(query_adNumberOfDislikes);                            
                        }
                        
                        sonuc = ps.executeUpdate();
                        
                        if(sonuc ==1){ 
                            //System.out.println("Yeni count eklendi");   
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
        
        return sonuc;  } public int getCounterData(String adId, boolean adViewCount, boolean adNumberOfLikes, boolean adNumberOfDislikes) {
        int sonuc = 0;Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   
            
                try {   
                        if(adViewCount){
                            String query_adViewCount = "SELECT ad_ViewCount FROM ad_counters WHERE  ad_Id = ? ;";
                            ps = con.prepareStatement(query_adViewCount);
                            ps.setString(1, adId);
                        }
                        else if(adNumberOfLikes){
                            String query_adNumberOfLikes = "SELECT ad_NumberOfLikes FROM ad_counters WHERE  ad_Id = ? ;";
                            ps = con.prepareStatement(query_adNumberOfLikes);
                        }
                        else if(adNumberOfDislikes){
                            String query_adNumberOfDislikes = "SELECT ad_NumberOfDislikes FROM ad_counters WHERE  ad_Id = ? ;";
                            ps = con.prepareStatement(query_adNumberOfDislikes);                            
                        }
                        
                                                              
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) { if(adViewCount){ sonuc = rs.getInt("ad_ViewCount"); }
                                            else if (adNumberOfLikes){ sonuc = rs.getInt("ad_NumberOfLikes"); }
                                            else if(adNumberOfDislikes){ sonuc = rs.getInt("ad_NumberOfDislikes"); }
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
