
package com.tasimacilar.ilan.vehicle;

import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VehicleBrandAndModelDao {
    
     public List<VehicleBrandAndModelBean> getAllVehicleBrand() { 
        
        List<VehicleBrandAndModelBean> vList = new ArrayList<VehicleBrandAndModelBean>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM ilan_tasimacilar.vehicle_brand ORDER BY VehicleBrand_SortNumber ASC";

                    ps = con.prepareStatement(query1);
                   
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    VehicleBrandAndModelBean ab = new VehicleBrandAndModelBean();
                                            ab.setVehicleBrand_Id(rs.getInt("VehicleBrand_Id"));
                                            ab.setVehicleBrand_Name(rs.getString("VehicleBrand_Name"));
                                          
                                            vList.add(ab);
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
        } 
        
        return vList;
    }
     public VehicleBrandAndModelBean getVehicleBrandWithId(int VehicleBrandId) { 
        
        VehicleBrandAndModelBean ab = new VehicleBrandAndModelBean();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM ilan_tasimacilar.vehicle_brand  WHERE VehicleBrand_Id = ? ";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, VehicleBrandId);
                   
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    ab.setVehicleBrand_Id(rs.getInt("VehicleBrand_Id"));
                                            ab.setVehicleBrand_Name(rs.getString("VehicleBrand_Name"));
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
        } 
        
        return ab;
    }
     public VehicleBrandAndModelBean getVehicleBrandWithName(String VehicleBrandName) { 
        
        VehicleBrandAndModelBean ab = new VehicleBrandAndModelBean();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM ilan_tasimacilar.vehicle_brand  WHERE VehicleBrand_Name = ? ";

                    ps = con.prepareStatement(query1);
                    ps.setString(1, VehicleBrandName);
                   
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    ab.setVehicleBrand_Id(rs.getInt("VehicleBrand_Id"));
                                            ab.setVehicleBrand_Name(rs.getString("VehicleBrand_Name"));
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
        } 
        
        return ab;
    }
     public List<String> getAllVehicleModels(int VehicleBrandId) { 
        
        List<String> vList = new ArrayList<String>();
        
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM ilan_tasimacilar.vehicle_brand_model WHERE VehicleBrand_Id = ?  ";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, VehicleBrandId);
                   
                    
                    ResultSet rs = ps.executeQuery();

                     while (rs.next()) {    vList.add(rs.getString("VehicleModel_Name")); }
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
        } 
        
        return vList;
    }
     
    
    
    
    
    
    
    
}
