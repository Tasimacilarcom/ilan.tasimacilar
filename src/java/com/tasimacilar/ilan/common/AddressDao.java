package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
public class AddressDao { 
    public int createAddress(AddressBean address) {     
        int sonuc = 0;
        java.sql.Date address_create_time = address.getAddress_create_time() == null ? null : new java.sql.Date(address.getAddress_create_time().getTime());
        java.sql.Date address_last_change_time = address.getAddress_last_change_time() == null ? null : new java.sql.Date(address.getAddress_last_change_time().getTime());
        Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_addresses(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "insert");
                        ps.setString(2, address.getAddress_Id());
                        ps.setInt(3, address.getAddress_TypeId());
                        ps.setString(4, address.getAddress_Name());
                        ps.setString(5, address.getAddress());
                        ps.setInt(6, address.getAddress_CountryId());
                        ps.setInt(7, address.getAddress_CityId());
                        ps.setInt(8, address.getAddress_TownId());
                        ps.setInt(9, address.getAddress_DistrictId());
                        ps.setInt(10, address.getAddress_NeighborhoodId());
                        ps.setString(11, address.getAddress_PostCode());
                        ps.setString(12, address.getAddress_location_Latitude());
                        ps.setString(13, address.getAddress_location_Longitude());
                        ps.setDate(14, address_create_time);
                        ps.setDate(15, address_last_change_time);
                        ps.setString(16, address.getAddress_last_Changer_account_id());
                    
                        sonuc = ps.executeUpdate();  
                        
                        System.out.println("Yeni adres Oluşturma BAŞARILI");
                        LogManagerDao.createLog("info", this.getClass().getName(), "Yeni Adres olusturuldu. [ID:"+address.getAddress_Id()
                                                                                                            +" Adı:"+address.getAddress_Name()+"]", "system");
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
