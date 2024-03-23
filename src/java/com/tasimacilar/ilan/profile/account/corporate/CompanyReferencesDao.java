package com.tasimacilar.ilan.profile.account.corporate;
import com.tasimacilar.ilan.hostess.HostessReferencesBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CompanyReferencesDao {
    public int createCompanyReference(CompanyReferencesBean CompanyReference) {
         java.sql.Timestamp CreateTime = CompanyReference.getCompanyReferences_Created() == null ? null : new java.sql.Timestamp(CompanyReference.getCompanyReferences_Created().getTime());
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;
        con = ConnectionManager.GetConnection();
  if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}  
        else{   try {   ps = con.prepareCall("{call pro_companyReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");               
                        ps.setString(1, "insert");               
                        ps.setString(2, CompanyReference.getCompanyReferences_Id());
                        ps.setString(3, CompanyReference.getCompanyReferences_Company());
                        ps.setString(4, CompanyReference.getCompanyReferences_Project());
                        ps.setTimestamp(5, null);   
                        ps.setTimestamp(6, null);  
                        ps.setInt(7, CompanyReference.getCompanyReferences_ProjectWorkingYear());
                        ps.setTimestamp(8, CreateTime);
                        ps.setString(9, CompanyReference.getCompanyReferences_Modifier());
                        ps.setTimestamp(10, CreateTime);
                        ps.setString(11, CompanyReference.getCompanyReferences_creator());
                        ps.setString(12, CompanyReference.getCompany_Id());
                        sonuc = ps.executeUpdate();    if( sonuc == 1){
                            System.out.println("Yeni Firma referansı Oluşturma BAŞARILI");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Yeni firma referansı olusturuldu. [Firma Referans Id:"+CompanyReference.getCompanyReferences_Id()+"]", "system");
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
        }  return sonuc;  }
public List<CompanyReferencesBean> getAllCompanyReferenceWithCompanyId(String compantId) {
       List<CompanyReferencesBean> vl = new ArrayList<CompanyReferencesBean>();     
    Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_companyReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithCompanyId");
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
                        ps.setString(12, compantId);
                    ResultSet rs = ps.executeQuery();
                        while (rs.next()) { CompanyReferencesBean cb = new CompanyReferencesBean();
                                            cb.setCompanyReferences_Id(rs.getString("companyReferences_Id"));
                                            cb.setCompanyReferences_Company(rs.getString("companyReferences_Company"));
                                            cb.setCompanyReferences_Project(rs.getString("companyReferences_Project"));
                                            cb.setCompanyReferences_ProjectStartDate(rs.getTimestamp("companyReferences_ProjectStartDate"));
                                            cb.setCompanyReferences_ProjectEndDate(rs.getTimestamp("companyReferences_ProjectEndDate"));
                                            cb.setCompanyReferences_ProjectWorkingYear(rs.getInt("companyReferences_ProjectWorkingYear"));
                                            cb.setCompanyReferences_Modified(rs.getTimestamp("companyReferences_Modified"));
                                            cb.setCompanyReferences_Modifier(rs.getString("companyReferences_Modifier"));
                                            cb.setCompanyReferences_Created(rs.getTimestamp("companyReferences_Created"));
                                            cb.setCompanyReferences_creator(rs.getString("companyReferences_creator"));
                                            cb.setCompany_Id(rs.getString("company_Id"));
                                            vl.add(cb);
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
        } return vl; }public int deleteCompanyReference(String companyReferencesId) {
          int sonuc = 0; Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
         else{   try {   ps = con.prepareCall("{call pro_companyReferences(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "deleteWithId");
                        ps.setString(2, companyReferencesId);
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
                        if(sonuc == 1){
                            System.out.println(":::BİLGİ:::Firma referansı silindi");
                            LogManagerDao.createLog("info", this.getClass().getName(), "Firma referansı silindi. [Firma Referans Id:"+companyReferencesId+"]", "system");
                        } 
                    }  catch (SQLException ex) {System.err.println(":::ERROR::: Time=["+new Date()
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
        }return sonuc;}
   
    
    
    
}
