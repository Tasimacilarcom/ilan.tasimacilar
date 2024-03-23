package com.tasimacilar.ilan.vehicle;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class VehicleReferencesDao {

    public int createVehicleReference(VehicleReferencesBean vehicleReference) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");               
                        ps.setString(2, vehicleReference.getVehicleReferences_Id());
                        ps.setString(3, vehicleReference.getVehicleReferences_Company());
                        ps.setString(4, vehicleReference.getVehicleReferences_Project());
                        ps.setTimestamp(5, new java.sql.Timestamp(vehicleReference.getVehicleReferences_ProjectStartDate().getTime()));   
                        ps.setTimestamp(6, new java.sql.Timestamp(vehicleReference.getVehicleReferences_ProjectEndDate().getTime()));  
                        ps.setInt(7, vehicleReference.getVehicleReferences_ProjectDate());
                        ps.setTimestamp(8, new java.sql.Timestamp(vehicleReference.getVehicleReferences_Modified().getTime()));
                        ps.setString(9, vehicleReference.getVehicleReferences_Modifier());
                        ps.setTimestamp(10, new java.sql.Timestamp(vehicleReference.getVehicleReferences_Created().getTime()));
                        ps.setString(11, vehicleReference.getVehicleReferences_creator());
                        ps.setString(12, vehicleReference.getVehicle_Id());
                        
                        sonuc = ps.executeUpdate();  
                        
                        System.out.println("Yeni araç referansı Oluşturma BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni araç referansı olusturuldu. [Araç Referans Id:"+vehicleReference.getVehicleReferences_Id()+"]", "system");
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
    } public List<VehicleReferencesBean> getAllVehicleReferenceWithVehicleId(String vehicleId) {
       
        List<VehicleReferencesBean> vl = new ArrayList<VehicleReferencesBean>();     
       
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithvehicleId");
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
                        ps.setString(12, vehicleId);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { VehicleReferencesBean vrb = new VehicleReferencesBean();
                                            vrb.setVehicleReferences_Id(rs.getString("vehicleReferences_Id"));
                                            vrb.setVehicleReferences_Company(rs.getString("vehicleReferences_Company"));
                                            vrb.setVehicleReferences_Project(rs.getString("vehicleReferences_Project"));
                                            vrb.setVehicleReferences_ProjectStartDate(rs.getTimestamp("vehicleReferences_ProjectStartDate"));
                                            vrb.setVehicleReferences_ProjectEndDate(rs.getTimestamp("vehicleReferences_ProjectEndDate"));
                                            vrb.setVehicleReferences_ProjectDate(rs.getInt("vehicleReferences_ProjectDate"));
                                            vrb.setVehicleReferences_Modified(rs.getTimestamp("vehicleReferences_Modified"));
                                            vrb.setVehicleReferences_Modifier(rs.getString("vehicleReferences_Modifier"));
                                            vrb.setVehicleReferences_Created(rs.getTimestamp("vehicleReferences_Created"));
                                            vrb.setVehicleReferences_creator(rs.getString("vehicleReferences_creator"));
                                            vrb.setVehicle_Id(rs.getString("vehicle_Id"));
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
        }
        
        return vl;
    } public int deleteVehicleReference(String vehicleReferencesId) {
        
        int sonuc = 0;
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_vehicleReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, vehicleReferencesId);
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
                        
                        LogManagerDao.createLog("info", this.getClass().getName(), "Araç referansı silindi. [Araç Referans Id:"+vehicleReferencesId+"]", "system");
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
