package com.tasimacilar.ilan.hostess;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class HostessReferencesDao {
 public int createHostessReference(HostessReferencesBean hostessReference) {
    int sonuc = 0; Connection con = null;  PreparedStatement ps = null;
  con = ConnectionManager.GetConnection();if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_hostessesReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");               
                        ps.setString(2, hostessReference.getHostessReferences_Id());
                        ps.setString(3, hostessReference.getHostessReferences_Company());
                        ps.setString(4, hostessReference.getHostessReferences_Project());
                        ps.setTimestamp(5, new java.sql.Timestamp(hostessReference.getHostessReferences_ProjectStartDate().getTime()));   
                        ps.setTimestamp(6, new java.sql.Timestamp(hostessReference.getHostessReferences_ProjectEndDate().getTime()));  
                        ps.setInt(7, hostessReference.getHostessReferences_ProjectWorkingYear());
                        ps.setTimestamp(8, new java.sql.Timestamp(hostessReference.getHostessReferences_Modified().getTime()));
                        ps.setString(9, hostessReference.getHostessReferences_Modifier());
                        ps.setTimestamp(10, new java.sql.Timestamp(hostessReference.getHostessReferences_Created().getTime()));
                        ps.setString(11, hostessReference.getHostessReferences_creator());
                        ps.setString(12, hostessReference.getHostess_Id());
                        
                        sonuc = ps.executeUpdate();  LogManagerDao.createLog("info", this.getClass().getName(), "Yeni hostes referansı olusturuldu. [Araç Referans Id:"+hostessReference.getHostessReferences_Id()+"]", "system");
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
        } return sonuc;  } public List<HostessReferencesBean> getAllHostessReferenceWithHostessId(String hostessId) {
        List<HostessReferencesBean> vl = new ArrayList<HostessReferencesBean>();     
        Connection con = null;  PreparedStatement ps = null; con = ConnectionManager.GetConnection();
  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_hostessesReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithhostessId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setTimestamp(5, null);
                        ps.setTimestamp(6, null);
                        ps.setInt(7, 0);
                        ps.setTimestamp(8, null);
                        ps.setString(9, null);
                        ps.setTimestamp(10, null);
                        ps.setString(11, null);
                        ps.setString(12, hostessId);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { HostessReferencesBean hb = new HostessReferencesBean();
                                            hb.setHostessReferences_Id(rs.getString("hostessReferences_Id"));
                                            hb.setHostessReferences_Company(rs.getString("hostessReferences_Company"));
                                            hb.setHostessReferences_Project(rs.getString("hostessReferences_Project"));
                                            hb.setHostessReferences_ProjectStartDate(rs.getTimestamp("hostessReferences_ProjectStartDate"));
                                            hb.setHostessReferences_ProjectEndDate(rs.getTimestamp("hostessReferences_ProjectEndDate"));
                                            hb.setHostessReferences_ProjectWorkingYear(rs.getInt("hostessReferences_ProjectWorkingYear"));
                                            hb.setHostessReferences_Modified(rs.getTimestamp("hostessReferences_Modified"));
                                            hb.setHostessReferences_Modifier(rs.getString("hostessReferences_Modifier"));
                                            hb.setHostessReferences_Created(rs.getTimestamp("hostessReferences_Created"));
                                            hb.setHostessReferences_creator(rs.getString("hostessReferences_creator"));
                                            hb.setHostess_Id(rs.getString("hostess_Id"));
                                            vl.add(hb);
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
        }  return vl; } public int deleteHostessReference(String hostessReferencesId) {
        int sonuc = 0; Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_hostessesReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, hostessReferencesId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setTimestamp(5, null);
                        ps.setTimestamp(6, null);
                        ps.setInt(7, 0);
                        ps.setTimestamp(8, null);
                        ps.setString(9, null);
                        ps.setTimestamp(10, null);
                        ps.setString(11, null);
                        ps.setString(12, null);
                          sonuc = ps.executeUpdate();  
                        LogManagerDao.createLog("info", this.getClass().getName(), "Hostes referansı silindi. [Hostes Referans Id:"+hostessReferencesId+"]", "system");
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
