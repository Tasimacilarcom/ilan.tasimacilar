package com.tasimacilar.ilan.favorites;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.messages.MessagesBean;
import com.tasimacilar.ilan.support.SupportBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.IsExist;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class FavoritesDao { 
    public int createFavorites(FavoritesBean favorites) {
   int sonuc = 0;   java.sql.Timestamp CreateTime = favorites.getFavorites_Created() == null ? null : new java.sql.Timestamp(favorites.getFavorites_Created().getTime());
 Connection con = null;  PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        else{   try {   ps = con.prepareCall("{call pro_favorites(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, favorites.getFavorites_Id());
                        ps.setString(3, favorites.getFavorites_Type());
                        ps.setString(4, favorites.getFavorites_ItemId());
                        ps.setString(5, favorites.getFavorites_ListName());
                        ps.setString(6, favorites.getFavorites_OvnerAccountId());
                        ps.setBoolean(7, favorites.isFavorites_IsActive());
                        ps.setString(8, favorites.getFavorites_Commnet());
                        ps.setTimestamp(9, CreateTime);
                        ps.setString(10, favorites.getFavorites_Modifier());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, favorites.getFavorites_Creator());
                      sonuc = ps.executeUpdate();   if(sonuc == 1){System.out.println("Yeni favori olusturuldu"); }
                        
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
        } return sonuc;  } public static boolean isExistFavorites(String ItemId, String OvnerAccountId ){
   
        String DbItemId = null; String DbOvnerAccountId = null; boolean exist = false;
        Connection con = null;PreparedStatement ps = null; con = ConnectionManager.GetConnection();    
          if (con == null) { LogManagerDao.createLog("error", IsExist.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+IsExist.class.getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{  
                try {   String query1 = "SELECT favorites_ItemId, favorites_OvnerAccountId  "
                                      + "FROM  ilan_tasimacilar.favorites  "
                                      + "WHERE favorites_ItemId = ? AND favorites_OvnerAccountId = ? ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, ItemId);
                        ps.setString(2, OvnerAccountId);
                        ResultSet rs = ps.executeQuery();
    
                        while (rs.next()) {  DbItemId = rs.getString("favorites_ItemId");  }
                        
                                            if (DbItemId == null ) {exist=false;} else{exist=true;}                                       
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
        }  return exist; } 
    public List<FavoritesBean> getAllFavoritesWithOvnerAccountId(String OvnerAccountId) {
        List<FavoritesBean> vl = new ArrayList<FavoritesBean>();      Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection();if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_favorites(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "getAllFavoritesAd");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, OvnerAccountId);
                        ps.setBoolean(7, false);
                        ps.setString(8, null);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                   ResultSet rs = ps.executeQuery();  while (rs.next()) { FavoritesBean f = new FavoritesBean();
                                            f.setFavorites_Id(rs.getString("favorites_Id"));
                                            f.setFavorites_Type(rs.getString("favorites_Type"));
                                            f.setFavorites_ItemId(rs.getString("favorites_ItemId"));
                                            f.setFavorites_ListName(rs.getString("favorites_ListName"));
                                            f.setFavorites_OvnerAccountId(rs.getString("favorites_OvnerAccountId"));
                                            f.setFavorites_IsActive(rs.getBoolean("favorites_IsActive"));
                                            f.setFavorites_Commnet(rs.getString("favorites_Commnet"));
                                            f.setFavorites_Modified(rs.getTimestamp("favorites_Modified"));
                                            f.setFavorites_Modifier(rs.getString("favorites_Modifier"));
                                            f.setFavorites_Created(rs.getTimestamp("favorites_Created"));
                                            f.setFavorites_Creator(rs.getString("favorites_Creator"));
                                             Ad_Bean ab = new Ad_Bean();
                                            ab.setAd_Id(rs.getString("ad_Id"));
                                            ab.setAd_Id2(rs.getString("ad_Id2"));
                                            ab.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ab.setAd_Title(rs.getString("ad_Title"));
                                            ab.setAd_Comment(rs.getString("ad_Comment"));
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
                                            ab.setAd_Category_Name(rs.getString("ad_Category_"));
                                             f.setAdBean(ab); vl.add(f);
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
        }  return vl; } public int deleteFavorites(String fId) {       
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_favorites(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "deleteFavoritesAd");
                        ps.setString(2, fId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setString(8, null);
                        ps.setTimestamp(9, null);
                        ps.setString(10, null);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null); sonuc = ps.executeUpdate();   if(sonuc == 1){System.out.println("Favori Ad silindi"); }
                      }   catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
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
        } return sonuc;   }
    
}
