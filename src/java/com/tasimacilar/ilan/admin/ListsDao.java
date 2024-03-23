package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.ad.aracimVarHostesAriyorum.Ad_AracimVarHostesAriyorum_Bean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.loging.LogManagerBean;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ListsDao { public int createList(ListsBean list) {
        
        int sonuc = 0; Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection();  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "INSERT INTO `ilan_tasimacilar`.`selectitems` (`selectItem_`,`selectItem_Value`,`selectItem_Label_Tr`,`selectItem_Label_En`) VALUES (?,?,?,?)";

                        ps = con.prepareStatement(query);
                        ps.setString(1, list.getSelectItem_());
                        ps.setString(2, list.getSelectItem_Value());
                        ps.setString(3, list.getSelectItem_Label_Tr());
                        ps.setString(4, list.getSelectItem_Label_En());
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){    }
                             
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
    }  public List<ListsBean> getListWithItem(String  itemName) {
        
        List<ListsBean> ls = new ArrayList<ListsBean>();
        
        Connection con = null; PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = "SELECT * FROM `ilan_tasimacilar`.`selectitems` WHERE selectItem_ = ? ORDER BY selectItem_Id DESC";

                        ps = con.prepareStatement(query);
                        ps.setString(1, itemName);
                        ResultSet rs = ps.executeQuery();

                         while (rs.next()) {  ListsBean l = new ListsBean();
                                              l.setSelectItem_Id(rs.getInt("selectItem_Id"));
                                              l.setSelectItem_(rs.getString("selectItem_"));
                                              l.setSelectItem_Value(rs.getString("selectItem_Value"));
                                              l.setSelectItem_Label_Tr(rs.getString("selectItem_Label_Tr"));
                                              l.setSelectItem_Label_En(rs.getString("selectItem_Label_En"));
                                              ls.add(l);
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
        
        return ls;
    } public int deleteListItem(int ItemId) {
        
        int sonuc = 0; Connection con = null;  PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();   if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   String query = " DELETE FROM  `ilan_tasimacilar`.selectitems WHERE selectItem_Id = ?;";

                        ps = con.prepareStatement(query);
                        ps.setInt(1, ItemId);
                      
                       
                        sonuc = ps.executeUpdate(); 
                        
                        if(sonuc == 1){ System.out.println("Liste ogesi silindi");  }
                             
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
