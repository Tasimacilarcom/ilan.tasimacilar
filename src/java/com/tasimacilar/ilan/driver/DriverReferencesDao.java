package com.tasimacilar.ilan.driver;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DriverReferencesDao { 
    public int createDriverReference(DriverReferences driverReference) {
    int sonuc = 0; Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_driversReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");               
                        ps.setString(2, driverReference.getDriverReferences_Id());
                        ps.setString(3, driverReference.getDriverReferences_Company());
                        ps.setString(4, driverReference.getDriverReferences_Project());
                        ps.setTimestamp(5, new java.sql.Timestamp(driverReference.getDriverReferences_ProjectStartDate().getTime()));   
                        ps.setTimestamp(6, new java.sql.Timestamp(driverReference.getDriverReferences_ProjectEndDate().getTime()));  
                        ps.setInt(7, driverReference.getDriverReferences_ProjectWorkingYear());
                        ps.setTimestamp(8, new java.sql.Timestamp(driverReference.getDriverReferences_Modified().getTime()));
                        ps.setString(9, driverReference.getDriverReferences_Modifier());
                        ps.setTimestamp(10, new java.sql.Timestamp(driverReference.getDriverReferences_Created().getTime()));
                        ps.setString(11, driverReference.getDriverReferences_creator());
                        ps.setString(12, driverReference.getDriver_Id());
                        sonuc = ps.executeUpdate();  
                         System.out.println("Yeni surucu referansı Oluşturma BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni surucu referansı olusturuldu. [Araç Referans Id:"+driverReference.getDriverReferences_Id()+"]", "system");
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
        
        return sonuc;} public List<DriverReferences> getAllVehicleReferenceWithDriverId(String driverId) {
       
        List<DriverReferences> vl = new ArrayList<DriverReferences>();     Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection();
if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_driversReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithDriverId");
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
                        ps.setString(12, driverId);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { DriverReferences vrb = new DriverReferences();
                                            vrb.setDriverReferences_Id(rs.getString("driverReferences_Id"));
                                            vrb.setDriverReferences_Company(rs.getString("driverReferences_Company"));
                                            vrb.setDriverReferences_Project(rs.getString("driverReferences_Project"));
                                            vrb.setDriverReferences_ProjectStartDate(rs.getTimestamp("driverReferences_ProjectStartDate"));
                                            vrb.setDriverReferences_ProjectEndDate(rs.getTimestamp("driverReferences_ProjectEndDate"));
                                            vrb.setDriverReferences_ProjectWorkingYear(rs.getInt("driverReferences_ProjectWorkingYear"));
                                            vrb.setDriverReferences_Modified(rs.getTimestamp("driverReferences_Modified"));
                                            vrb.setDriverReferences_Modifier(rs.getString("driverReferences_Modifier"));
                                            vrb.setDriverReferences_Created(rs.getTimestamp("driverReferences_Created"));
                                            vrb.setDriverReferences_creator(rs.getString("driverReferences_creator"));
                                            vrb.setDriver_Id(rs.getString("driver_Id"));
                                            vl.add(vrb);
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
        } return vl; } public int deleteDriverReference(String driverReferencesId) {
        
        int sonuc = 0; Connection con = null;   PreparedStatement ps = null;
  con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_driversReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, driverReferencesId);
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
                         LogManagerDao.createLog("info", this.getClass().getName(), "Surucu referansı silindi. [Surucu Referans Id:"+driverReferencesId+"]", "system");
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
        } return sonuc; }
    

    
}
