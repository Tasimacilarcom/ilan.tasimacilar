/**
 * @author  Yasin KALAYCI (yasin@supforce.com)
 * @since   01-01-2019 
 * @version 1.0.0
 */
package com.tasimacilar.ilan.blackList;


import com.tasimacilar.ilan.admin.ListsBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
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

public class BlackListDao {
    
//------------------------------------------------------------------------------    
    /**
     * Bu metodla  yenibir kara liste ogesi eklenir
     *
     * {@code int createBlackListItem(BlackListBean blackListItem) ;}
     * 
     * @param blackListItem BlackListBean tipinde yeni karaliste ogesinin icerigi aliniyor.
     * 
     * @return sonuc olarak integer tipinde işlem başarılı ise "1" değilse "0" doner.
     */  
    public int createBlackListItem(BlackListBean blackListItem) {
        
        int sonuc = 0;
        java.sql.Timestamp CreateTime = blackListItem.getBlackList_Created() == null ? null : new java.sql.Timestamp(blackListItem.getBlackList_Created().getTime());


        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_blackList(?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");
                        ps.setString(2, blackListItem.getBlackList_Id());
                        ps.setString(3, blackListItem.getBlackList_Type());
                        ps.setString(4, blackListItem.getBlackList_TypeRelationId());
                        ps.setString(5, blackListItem.getBlackList_UserMessage());
                        ps.setString(6, blackListItem.getBlackList_AdminNote());
                        ps.setBoolean(7, blackListItem.isBlackList_IsActive());
                        ps.setTimestamp(8, CreateTime);
                        ps.setString(9, blackListItem.getBlackList_Modifier());
                        ps.setTimestamp(10, CreateTime);
                        ps.setString(11, blackListItem.getBlackList_Creator());
                      
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Yeni BlackList ogesi olusturuldu"); }
                        
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
    
//------------------------------------------------------------------------------     
    /**
     * Bu metod bir kullanıcıyı blacklist e ekleme sırasında kullanıcının 
     * daha onceden listeye eklenip eklenmediğini kontrol eder
     *
     * {@code static boolean isExistUserBlackListItem(String TypeRelationId);}
     * 
     * @param TypeRelationId String tipinde aranacak olan TypeRelationId
     * 
     * @return sonuc olarak girilen TypeRelationId sistemde var ise geriye true değer yoksa false döndürür.
     */
    public static boolean isExistUserBlackListItem(String TypeRelationId){
   
        String dbTypeRelationId = null;
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
                try {   String query1 = "SELECT blackList_TypeRelationId FROM  ilan_tasimacilar.blacklists a  WHERE a.blackList_TypeRelationId=? AND a.blackList_Type ='user' ";

                        ps = con.prepareStatement(query1);
                        ps.setString(1, TypeRelationId);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {dbTypeRelationId = rs.getString("blackList_TypeRelationId"); }
                                            if (dbTypeRelationId==null) {exist=false;} else{exist=true;}
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

//------------------------------------------------------------------------------
    /**
     * Bu metodla  bir karaliste ogesine ait detaylar alınıyor
     *
     * {@code BlackListBean getBlackListItem(String TypeRelationId);}
     * 
     * @param TypeRelationId String tipinde detayı istenecek ogenın ıd sı
     * 
     * @return sonuc olarak integer tipinde işlem başarılı ise "1" değilse "0" doner.
     */  
    public BlackListBean getBlackListItem(String TypeRelationId) {
        
        BlackListBean b = new BlackListBean();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_blackList(?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "getAllWithTypeRelationId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, TypeRelationId);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setTimestamp(8, null);
                        ps.setString(9, null);
                        ps.setTimestamp(10, null);
                        ps.setString(11, null);
                        
                        ResultSet rs = ps.executeQuery();

                         while (rs.next()) {  b.setBlackList_Id(rs.getString("blackList_Id"));
                                              b.setBlackList_Type(rs.getString("blackList_Type"));
                                              b.setBlackList_TypeRelationId(rs.getString("blackList_TypeRelationId"));
                                              b.setBlackList_UserMessage(rs.getString("blackList_UserMessage"));
                                              b.setBlackList_AdminNote(rs.getString("blackList_AdminNote"));
                                              b.setBlackList_IsActive(rs.getBoolean("blackList_IsActive"));
                                              b.setBlackList_Modified(rs.getTimestamp("blackList_Modified"));
                                              b.setBlackList_Modifier(rs.getString("blackList_Modifier"));
                                              b.setBlackList_Created(rs.getTimestamp("blackList_Created"));
                                              b.setBlackList_Creator(rs.getString("blackList_Creator"));
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
        
        return b;
    }
    
//------------------------------------------------------------------------------  
    /**
     * Bu metodla kara liste ogesi guncellenir
     *
     * {@code int updateBlackListItem(BlackListBean blackListItem) ;}
     * 
     * @param blackListItem BlackListBean tipinde guncellenecek karaliste ogesinin icerigi aliniyor.
     * 
     * @return sonuc olarak integer tipinde işlem başarılı ise "1" değilse "0" doner.
     */  
    public int updateBlackListItem(BlackListBean blackListItem) {
        
        int sonuc = 0;
        java.sql.Timestamp updateTime = blackListItem.getBlackList_Created() == null ? null : new java.sql.Timestamp(blackListItem.getBlackList_Created().getTime());


        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_blackList(?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "updateWithTypeRelationId");
                        ps.setString(2, blackListItem.getBlackList_Id());
                        ps.setString(3, blackListItem.getBlackList_Type());
                        ps.setString(4, blackListItem.getBlackList_TypeRelationId());
                        ps.setString(5, blackListItem.getBlackList_UserMessage());
                        ps.setString(6, blackListItem.getBlackList_AdminNote());
                        ps.setBoolean(7, blackListItem.isBlackList_IsActive());
                        ps.setTimestamp(8, updateTime);
                        ps.setString(9, blackListItem.getBlackList_Modifier());
                        ps.setTimestamp(10, updateTime);
                        ps.setString(11, blackListItem.getBlackList_Creator());
                      
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("BlackList ogesi guncellendi"); }
                        
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
    
//------------------------------------------------------------------------------    
    /**
     * Bu metodla bir kara liste ogesi siliniyor
     *
     * {@codeint deleteBlackListItem(String TypeRelationId);}
     * 
     * @param TypeRelationId String tipinde silinecek ogenın ıd sı
     * 
     * @return sonuc olarak integer tipinde işlem başarılı ise "1" değilse "0" doner.
     */  
    public int deleteBlackListItem(String TypeRelationId) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = " DELETE FROM  `ilan_tasimacilar`.blacklists WHERE blackList_TypeRelationId = ?;";

                        ps = con.prepareStatement(query);
                        ps.setString(1, TypeRelationId);
                      
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){ System.out.println("Kara Liste ogesi silindi");  }
                             
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
    
//------------------------------------------------------------------------------     
    /**
     * Bu metodla   karaliste ogeleri detaylarıyla liste halinde alınıyor
     *
     * {@code List<BlackListBean> getBlackLists();}
     * 
     * @return sonuc olarak liste halinde kara liste ogelerı donuyor.
     */  
    public List<BlackListBean> getBlackLists() {
        
        List<BlackListBean> bl = new ArrayList<>();
        
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_blackList(?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "getAllForAdmin");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setBoolean(7, false);
                        ps.setTimestamp(8, null);
                        ps.setString(9, null);
                        ps.setTimestamp(10, null);
                        ps.setString(11, null);
                        
                        ResultSet rs = ps.executeQuery();

                         while (rs.next()) {    // Account
                                                AccountBean ab = new AccountBean();
                                                ab.setAccount_Id(rs.getString("account_Id"));
                                                ab.setAccount_FirstName(rs.getString("account_FirstName"));
                                                ab.setAccount_LastName(rs.getString("account_LastName"));
                                                ab.setAccount_EmailAddress(rs.getString("account_EmailAddress"));
                                                ab.setAccount_MobilePhoneNumber(rs.getString("account_MobilePhoneNumber"));
                                               
                                                // BlackList
                                                BlackListBean b = new BlackListBean();
                                                b.setBlackList_Id(rs.getString("blackList_Id"));
                                                b.setBlackList_Type(rs.getString("blackList_Type"));
                                                b.setBlackList_TypeRelationId(rs.getString("blackList_TypeRelationId"));
                                                b.setBlackList_UserMessage(rs.getString("blackList_UserMessage"));
                                                b.setBlackList_AdminNote(rs.getString("blackList_AdminNote"));
                                                b.setBlackList_IsActive(rs.getBoolean("blackList_IsActive"));
                                                b.setBlackList_Modified(rs.getTimestamp("blackList_Modified"));
                                                b.setBlackList_Modifier(rs.getString("blackList_Modifier"));
                                                b.setBlackList_Created(rs.getTimestamp("blackList_Created"));
                                                b.setBlackList_Creator(rs.getString("blackList_Creator"));
                                                b.setAccountBean(ab);
                                                bl.add(b);
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
        
        return bl;
    }
    
//------------------------------------------------------------------------------ 
 
    
    
    
    
    
}
