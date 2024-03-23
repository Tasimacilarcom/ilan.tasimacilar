package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SelectItemsDao {
public List<SelectItemsBean> getSelectItems(String selectItem) {
        List<SelectItemsBean> list = new ArrayList<SelectItemsBean>();
         Connection con = null; PreparedStatement ps = null;con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM `ilan_tasimacilar`.`selectitems` WHERE selectItem_=?";

                    ps = con.prepareStatement(query1);
                    ps.setString(1, selectItem);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   SelectItemsBean sb = new SelectItemsBean();
                                            sb.setSelectItem_Id(rs.getInt("selectItem_Id"));
                                            sb.setSelectItem_(rs.getString("selectItem_"));
                                            sb.setSelectItem_Value(rs.getString("selectItem_Value"));
                                            sb.setSelectItem_Label_Tr(rs.getString("selectItem_Label_Tr"));
                                            sb.setSelectItem_Label_En(rs.getString("selectItem_Label_Tr"));
                                            list.add(sb);
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
        }  return list; }
    
}
