package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CityListsDao {
    public List<CityListsBean> getAllCountryWithDetail() { List<CityListsBean> list = new ArrayList<CityListsBean>();
     Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
    else{  try {   String query1 = "SELECT * FROM `ilan_tasimacilar`.`address_1_country` ";

                    ps = con.prepareStatement(query1);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   CityListsBean cb = new CityListsBean();
                                            cb.setCountryID(rs.getInt("CountryID"));
                                            cb.setCountryBinaryCode(rs.getString("BinaryCode"));
                                            cb.setCountryTripleCode(rs.getString("TripleCode"));
                                            cb.setCountryName(rs.getString("CountryName"));
                                            cb.setCountryPhoneCode(rs.getString("PhoneCode"));
                                            list.add(cb);
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
        
        return list;  }public List<CityListsBean> getAllCityWithDetail() {     
        List<CityListsBean> list = new ArrayList<CityListsBean>(); Connection con = null; PreparedStatement ps = null;
        con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM `ilan_tasimacilar`.`address_2_city` ";

                    ps = con.prepareStatement(query1);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   CityListsBean cb = new CityListsBean();
                                            cb.setCityID(rs.getInt("CityID"));
                                            cb.setCityName(rs.getString("CityName"));
                                            cb.setCityPlateNo(rs.getString("PlateNo"));
                                            cb.setCountryPhoneCode(rs.getString("PhoneCode"));
                                            list.add(cb);
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
        
        return list;
    } public List<CityListsBean> getTownDetailWithCity(int cityId) {
         List<CityListsBean> list = new ArrayList<CityListsBean>(); Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * FROM `ilan_tasimacilar`.`address_3_town` WHERE CityID = ?";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, cityId);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   CityListsBean cb = new CityListsBean();
                                            cb.setTownID(rs.getInt("TownID"));
                                            cb.setTownName(rs.getString("TownName"));
                                            list.add(cb);
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
        
        return list;
    } public List<CityListsBean> getNeighborhoodDetailWithTown(int townId) { 
        
        List<CityListsBean> list = new ArrayList<CityListsBean>(); Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * "
                                  + "FROM `address_5_neighborhood` "
                                  + "WHERE DistrictID "
                                  + "BETWEEN (SELECT MIN(DistrictID)  FROM `address_4_district` WHERE TownID = ?) "
                                  + "AND (SELECT MAX(DistrictID)  FROM `address_4_district` WHERE TownID = ?)";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, townId);
                    ps.setInt(2, townId);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   CityListsBean cb = new CityListsBean();
                                            cb.setNeighborhoodID(rs.getInt("NeighborhoodID"));
                                            cb.setNeighborhoodName(rs.getString("NeighborhoodName"));
                                            list.add(cb);
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
        
        return list;
    }public CityListsBean getTownDetailWithTownId(int townId) { 
        
        CityListsBean cb = new CityListsBean(); Connection con = null; PreparedStatement ps = null; con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{   try {   String query1 = "SELECT * "
                                  + "FROM `address_3_town` "
                                  + "WHERE TownID = ? ";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, townId);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   cb.setTownID(rs.getInt("TownID"));
                                            cb.setTownName(rs.getString("TownName"));
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
        
        return cb; } public CityListsBean getNeighborhoodDetailWithNeighborhoodId(int neighborhoodId) { 
        
        CityListsBean cb = new CityListsBean();  Connection con = null;  PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+this.getClass().getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
         
        else{  
            
            try {   String query1 = "SELECT * "
                                  + "FROM `address_5_neighborhood` "
                                  + "WHERE NeighborhoodID = ? ";

                    ps = con.prepareStatement(query1);
                    ps.setInt(1, neighborhoodId);
                    ResultSet rs = ps.executeQuery();

                      while (rs.next()) {   cb.setNeighborhoodID(rs.getInt("NeighborhoodID"));
                                            cb.setNeighborhoodName(rs.getString("NeighborhoodName"));
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
        }   return cb;  }
 
}
