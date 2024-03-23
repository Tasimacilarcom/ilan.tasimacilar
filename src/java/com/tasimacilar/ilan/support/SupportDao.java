package com.tasimacilar.ilan.support;
import com.tasimacilar.ilan.messages.MessagesBean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class SupportDao {
    public int createSupportMessage(SupportBean sMessage) {
        int sonuc = 0;
        java.sql.Timestamp CreateTime = sMessage.getSupport_Created() == null ? null : new java.sql.Timestamp(sMessage.getSupport_Created().getTime());
 Connection con = null;
        PreparedStatement ps = null; con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "insert");
                        ps.setString(2, sMessage.getSupport_Id());
                        ps.setString(3, sMessage.getSupport_GroupId());
                        ps.setString(4, sMessage.getSupport_comment());
                        ps.setString(5, sMessage.getSupport_Subject());
                        ps.setString(6, sMessage.getSupport_FromUserId());
                        ps.setString(7, sMessage.getSupport_ToUserId());
                        ps.setString(8, sMessage.getSupport_Priority());
                        ps.setString(9, sMessage.getSupport_Status());
                        ps.setBoolean(10, sMessage.isSupport_IsActive());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, sMessage.getSupport_Modifier());
                        ps.setTimestamp(13, CreateTime);
                        ps.setString(14, sMessage.getSupport_creator());
                        ps.setString(15, null);
                        ps.setString(16, null);
                        ps.setString(17, null);
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Yeni destek mesajı olusturuldu"); }
                        
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
    } public List<SupportBean> getAllMessagesWithFromUserId(String FromUserId) {
       
        List<SupportBean> vl = new ArrayList<SupportBean>();     
       
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithFromUserId");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, FromUserId);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, null);
                        ps.setString(17, null);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { SupportBean sb = new SupportBean();
                                            sb.setSupport_Id(rs.getString("support_Id"));
                                            sb.setSupport_GroupId(rs.getString("support_GroupId"));
                                            sb.setSupport_comment(rs.getString("support_Comment"));
                                            sb.setSupport_Subject(rs.getString("support_Subject"));
                                            sb.setSupport_FromUserId(rs.getString("support_FromUserId"));
                                            sb.setSupport_ToUserId(rs.getString("support_ToUserId"));
                                            sb.setSupport_Priority(rs.getString("support_Priority"));
                                            sb.setSupport_Status(rs.getString("support_Status"));
                                            sb.setSupport_IsActive(rs.getBoolean("support_IsActive"));
                                            sb.setSupport_Modified(rs.getTimestamp("support_Modified"));
                                            sb.setSupport_Modifier(rs.getString("support_Modifier"));
                                            sb.setSupport_Created(rs.getTimestamp("support_Created"));
                                            sb.setSupport_creator(rs.getString("support_creator"));
                                            sb.setSupport_answeredTime(rs.getTimestamp("support_answeredTime"));
                                            sb.setSupport_answeredUser(rs.getString("support_answeredUser"));
                                            sb.setSupport_answer(rs.getString("support_answer"));
                                            vl.add(sb);
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
    } public List<SupportBean> getAllMessages() {
       
        List<SupportBean> vl = new ArrayList<SupportBean>();     
       
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllForDirector");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, null);
                        ps.setString(17, null);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { SupportBean sb = new SupportBean();
                                            sb.setSupport_Id(rs.getString("support_Id"));
                                            sb.setSupport_GroupId(rs.getString("support_GroupId"));
                                            sb.setSupport_comment(rs.getString("support_Comment"));
                                            sb.setSupport_Subject(rs.getString("support_Subject"));
                                            sb.setSupport_FromUserId(rs.getString("support_FromUserId"));
                                            sb.setSupport_ToUserId(rs.getString("support_ToUserId"));
                                            sb.setSupport_Priority(rs.getString("support_Priority"));
                                            sb.setSupport_Status(rs.getString("support_Status"));
                                            sb.setSupport_IsActive(rs.getBoolean("support_IsActive"));
                                            sb.setSupport_Modified(rs.getTimestamp("support_Modified"));
                                            sb.setSupport_Modifier(rs.getString("support_Modifier"));
                                            sb.setSupport_Created(rs.getTimestamp("support_Created"));
                                            sb.setSupport_creator(rs.getString("support_creator"));
                                            sb.setSupport_answeredTime(rs.getTimestamp("support_answeredTime"));
                                            sb.setSupport_answeredUser(rs.getString("support_answeredUser"));
                                            sb.setSupport_answer(rs.getString("support_answer"));
                                            sb.setSupport_FromUserName(rs.getString("fromUserName"));
                                            sb.setSupport_ToUserName(rs.getString("toUserName"));
                                            sb.setSupport_answeredUserName(rs.getString("answeredUserName"));
                                            vl.add(sb);
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
    }     public SupportBean getMessagesWithSupportId(String sId) {
       
        SupportBean sb = new SupportBean();  
       
        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithSupportId");
                        ps.setString(2, sId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, null);
                        ps.setString(17, null);
                  
                        ResultSet rs = ps.executeQuery();
                        
                        while (rs.next()) { 
                                            sb.setSupport_Id(rs.getString("support_Id"));
                                            sb.setSupport_GroupId(rs.getString("support_GroupId"));
                                            sb.setSupport_comment(rs.getString("support_Comment"));
                                            sb.setSupport_Subject(rs.getString("support_Subject"));
                                            sb.setSupport_FromUserId(rs.getString("support_FromUserId"));
                                            sb.setSupport_ToUserId(rs.getString("support_ToUserId"));
                                            sb.setSupport_Priority(rs.getString("support_Priority"));
                                            sb.setSupport_Status(rs.getString("support_Status"));
                                            sb.setSupport_IsActive(rs.getBoolean("support_IsActive"));
                                            sb.setSupport_Modified(rs.getTimestamp("support_Modified"));
                                            sb.setSupport_Modifier(rs.getString("support_Modifier"));
                                            sb.setSupport_Created(rs.getTimestamp("support_Created"));
                                            sb.setSupport_creator(rs.getString("support_creator"));
                                            sb.setSupport_answeredTime(rs.getTimestamp("support_answeredTime"));
                                            sb.setSupport_answeredUser(rs.getString("support_answeredUser"));
                                            sb.setSupport_answer(rs.getString("support_answer"));
                                            
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
        
        return sb;
    } public int deleteMessage(String sId) {
        
        int sonuc = 0;

        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "deleteMessage");
                        ps.setString(2, sId);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                        ps.setString(16, null);
                        ps.setString(17, null);
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Destek mesajı silindi"); }
                        
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
    }  public int answeerMessage(SupportBean sMessage) {
        
        int sonuc = 0;
        java.sql.Timestamp CreateTime = sMessage.getSupport_answeredTime() == null ? null : new java.sql.Timestamp(sMessage.getSupport_answeredTime().getTime());


        Connection con = null;
        PreparedStatement ps = null;

        con = ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_support(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        ps.setString(1, "answeerMessage");
                        ps.setString(2, sMessage.getSupport_Id());
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, null);
                        ps.setString(7, null);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setTimestamp(15, CreateTime);
                        ps.setString(16, sMessage.getSupport_answeredUser());
                        ps.setString(17, sMessage.getSupport_answer());
                     
                        sonuc = ps.executeUpdate();  
                        
                        if(sonuc == 1){System.out.println("Destek mesajı cevaplandı"); }
                        
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
