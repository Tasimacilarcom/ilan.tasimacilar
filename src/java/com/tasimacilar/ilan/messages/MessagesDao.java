package com.tasimacilar.ilan.messages;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.system.ConnectionManager;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class MessagesDao { 
    public int createMessage(MessagesBean message) {
      int sonuc = 0;
      java.sql.Timestamp CreateTime = message.getMessage_Created() == null ? null : new java.sql.Timestamp(message.getMessage_Created().getTime());
 Connection con = null; PreparedStatement ps = null;  con = ConnectionManager.GetConnection();
 if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
       else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
         ps.setString(1, "insert");
                        ps.setString(2, message.getMessage_Id());
                        ps.setString(3, message.getMessage_GroupId());
                        ps.setString(4, message.getMessage_());
                        ps.setString(5, message.getMessage_Subject());
                        ps.setString(6, message.getMessage_FromUserId());
                        ps.setString(7, message.getMessage_ToUserId());
                        ps.setString(8, message.getMessage_Priority());
                        ps.setString(9, message.getMessage_Status());
                        ps.setBoolean(10, message.isMessage_IsActive());
                        ps.setTimestamp(11, CreateTime);
                        ps.setString(12, message.getMessage_Modifier());
                        ps.setTimestamp(13, CreateTime);
                        ps.setString(14, message.getMessage_creator());
                        ps.setString(15, message.getAd_Id());
                        sonuc = ps.executeUpdate();   if(sonuc == 1){System.out.println("Yeni mesaj olusturuldu"); }  } 
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
        } return sonuc; } public List<MessagesBean> getAllMessagesWithGroupId(String GroupId) {
      List<MessagesBean> vl = new ArrayList<MessagesBean>();      Connection con = null;  PreparedStatement ps = null;
con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
         else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getAllWithGroupId");
                        ps.setString(2, null);
                        ps.setString(3, GroupId);
                        ps.setString(4, null);
                        ps.setTimestamp(5, null);
                        ps.setTimestamp(6, null);
                        ps.setInt(7, 0);
                        ps.setTimestamp(8, null);
                        ps.setString(9, null);
                        ps.setTimestamp(10, null);
                        ps.setString(11, null);
                        ps.setString(12, null);
                        ps.setString(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                    ResultSet rs = ps.executeQuery();
                     while (rs.next()) { MessagesBean m = new MessagesBean();
                                            m.setMessage_Id(rs.getString("message_Id"));
                                            m.setMessage_GroupId(rs.getString("message_GroupId"));
                                            m.setMessage_(rs.getString("message_"));
                                            m.setMessage_Subject(rs.getString("message_Subject"));
                                            m.setMessage_FromUserId(rs.getString("message_FromUserId"));
                                            m.setMessage_ToUserId(rs.getString("message_ToUserId"));
                                            m.setMessage_Priority(rs.getString("message_Priority"));
                                            m.setMessage_Status(rs.getString("message_Status"));
                                            m.setMessage_IsActive(rs.getBoolean("message_IsActive"));
                                            m.setMessage_Modified(rs.getTimestamp("message_Modified"));
                                            m.setMessage_Modifier(rs.getString("message_Modifier"));
                                            m.setMessage_Created(rs.getTimestamp("message_Created")); 
                                            m.setMessage_creator(rs.getString("message_creator"));
                                            m.setAd_Id(rs.getString("ad_Id"));
                                            vl.add(m);
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
        } return vl; }public List<MessagesBean> getUsersMessages(String fromUserId, String toUserId) {
        List<MessagesBean> vl = new ArrayList<MessagesBean>();    Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        ps.setString(1, "getUserMessage");
                        ps.setString(2, null);
                        ps.setString(3, null);
                        ps.setString(4, null);
                        ps.setString(5, null);
                        ps.setString(6, fromUserId);
                        ps.setString(7, toUserId);
                        ps.setString(8, null);
                        ps.setString(9, null);
                        ps.setBoolean(10, false);
                        ps.setTimestamp(11, null);
                        ps.setString(12, null);
                        ps.setTimestamp(13, null);
                        ps.setString(14, null);
                        ps.setString(15, null);
                   ResultSet rs = ps.executeQuery();  while (rs.next()) { MessagesBean m = new MessagesBean();
                                            m.setMessage_Id(rs.getString("message_Id"));
                                            m.setMessage_GroupId(rs.getString("message_GroupId"));
                                            m.setMessage_(rs.getString("message_"));
                                            m.setMessage_Subject(rs.getString("message_Subject"));
                                            m.setMessage_FromUserId(rs.getString("message_FromUserId"));
                                            m.setMessage_ToUserId(rs.getString("message_ToUserId"));
                                            m.setMessage_Priority(rs.getString("message_Priority"));
                                            m.setMessage_Status(rs.getString("message_Status"));
                                            m.setMessage_IsActive(rs.getBoolean("message_IsActive"));
                                            m.setMessage_Modified(rs.getTimestamp("message_Modified"));
                                            m.setMessage_Modifier(rs.getString("message_Modifier"));
                                            m.setMessage_Created(rs.getTimestamp("message_Created")); 
                                            m.setMessage_creator(rs.getString("message_creator"));
                                            m.setAd_Id(rs.getString("ad_Id"));
                                            m.setFromUser_message_Statusx(rs.getString("FromUser_message_Statusx")); 
                                            m.setFromUser_message_IsActivex(rs.getBoolean("FromUser_message_IsActivex")); 
                                            m.setToUser_message_Statusx(rs.getString("ToUser_message_Statusx"));
                                            m.setToUser_message_IsActivex(rs.getBoolean("ToUser_message_IsActivex"));
                                           Ad_Bean ad = new Ad_Bean();
                                            ad.setAd_Id(rs.getString("ad_Id"));
                                            ad.setAd_Category_Id(rs.getInt("ad_Category_Id"));
                                            ad.setAd_Category_Name(rs.getString("ad_Category_"));
                                            ad.setAd_Title(rs.getString("ad_Title"));
                                            ad.setAd_Comment(rs.getString("ad_Comment"));
                                            ad.setAd_Type(rs.getString("ad_Type"));
                                            ad.setAd_OvnerAccountId(rs.getString("ad_OvnerAccountId"));
                                            ad.setAd_IsActive(rs.getBoolean("ad_IsActive"));
                                            ad.setAd_EndTime(rs.getTimestamp("ad_EndTime"));
                                            ad.setAd_Notes(rs.getString("ad_Notes"));
                                            ad.setAd_CreateTime(rs.getTimestamp("ad_CreateTime"));
                                            ad.setAd_CreatedIp(rs.getString("ad_CreatedIp"));
                                            ad.setAd_CreatedAccountId(rs.getString("ad_CreatedAccountId"));
                                            ad.setAd_LastModifyIp(rs.getString("ad_LastModifyIp"));
                                            ad.setAd_LastModifyTime(rs.getTimestamp("ad_LastModifyTime"));
                                            ad.setAd_LastChangerAccountId(rs.getString("ad_LastChangerAccountId"));
                                            ad.setAd_IsPublish(rs.getBoolean("ad_IsPublish"));
                                            m.setAdBean(ad);
                                            vl.add(m);   }    } 
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
        } return vl;  } public int enableDisableMessageGroup(String cmd, String MessageId) {
        int sonuc = 0; Connection con = null;  PreparedStatement ps = null;
  con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                         if(cmd != null && !cmd.equals("")){
                            if(cmd.equals("disableMessageGroup")){ ps.setString(1, "disableMessageGroup"); }
                            if(cmd.equals("enableMessageGroup")){ ps.setString(1, "enableMessageGroup"); }
                             ps.setString(2, MessageId);
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
                            sonuc = ps.executeUpdate();  }
                        if(sonuc == 1){System.out.println("Mesaj silindi"); }
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
        } return sonuc;  }public int enableDisableMessageGroupWithGroupId(String cmd, String MessageGroupId) {
        int sonuc = 0; Connection con = null; PreparedStatement ps = null;
 con = ConnectionManager.GetConnection(); if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
        
        else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
                        if(cmd != null && !cmd.equals("")){
                            ps.setString(1, "enableMessageGroupWithGroupId");
                            ps.setString(2, null);
                            ps.setString(3, MessageGroupId);
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
                            ps.setString(15, null);  sonuc = ps.executeUpdate();
                         }  if(sonuc == 1){System.out.println("Mesaj geri alındı"); }  } 
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
        } return sonuc; } public int readOrUnreadMessageGroup(String cmd, String MessageId) {
         int sonuc = 0; Connection con = null; PreparedStatement ps = null;
con = ConnectionManager.GetConnection();if (con == null) { LogManagerDao.createLog("error", this.getClass().getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::ERROR::: Time=["+new Date()
                                                      +"] Class=["+this.getClass().getName()
                                                     +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                                    +"] Message=[Database baglanti hatasi.Connection null gonderdi]:::");}
         else{   try {   ps = con.prepareCall("{call pro_messages(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    if(cmd != null && !cmd.equals("")){
                            if(cmd.equals("unReadMessageGroup")){ ps.setString(1, "unReadMessageGroup"); }
                            if(cmd.equals("readMessageGroup")){ ps.setString(1, "readMessageGroup"); }
                             ps.setString(2, MessageId);
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
sonuc = ps.executeUpdate(); }if(sonuc == 1){ }  } 
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
