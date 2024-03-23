
package com.tasimacilar.ilan.system.loging;
import com.tasimacilar.ilan.system.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogManagerDao {
  
    public static int createLog( String logLevel, String logSource, String logContent, String logUser ) {

        int sonuc = 0; 

        if( logLevel.equals("") || logSource.equals("") || logContent.equals("") || logUser.equals("")){
            System.err.println(":::HATA:::"+LogManagerDao.class.getName()+":::Log parametrelerini bos olarak gecemezsiniz:::");   
        }
        else{   

            if ( !logLevel.equals("info") && !logLevel.equals("warning") && !logLevel.equals("error")) {
                System.err.println(":::HATA:::"+LogManagerDao.class.getName()+":::Log Level olarak sadece 'info,warning,error' kullanabilirsiniz.:::");    
            }

            else{

                Connection con = null;
                PreparedStatement ps = null;

                con = ConnectionManager.GetConnection();

                if (con == null) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                                   System.err.println(":::HATA:::"+LogManagerDao.class.getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
                
                else{   try { String query = "INSERT INTO `ilan_tasimacilar`.`logging` (`log_Id`,"
                                                                              + "`log_Level`,"
                                                                              + "`log_Source`,"
                                                                              + "`log_Content`,"
                                                                              + "`log_User`)"
                                                                              + "VALUES (?,?,?,?,?)";

                            ps = con.prepareStatement(query);
                            ps.setString(1, UniqueId.RandomString(12));
                            ps.setString(2, logLevel);
                            ps.setString(3, logSource);
                            ps.setString(4, logContent);
                            ps.setString(5, logUser);

                            sonuc = ps.executeUpdate();
                        }

                        catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+ex);} 

                        finally { try { if (ps != null) {try {ps.close();} 
                                                 catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                                                           System.err.println(":::HATA:::"+ex);}
                                                }
                                if (con != null && !con.isClosed()) {con.close();}
                              } 

                          catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                                    System.err.println(":::HATA:::"+ex);}
                        }
                }
            }
        }
        return sonuc;    
    } public List<LogManagerBean> listAllLog(){


        List<LogManagerBean> allLogList = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;

        con = com.tasimacilar.ilan.system.ConnectionManager.GetConnection();

        if (con == null) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), "Database baglanti hatasi.Connection null gonderdi", "system");
                           System.err.println(":::HATA:::"+LogManagerDao.class.getName()+":::Database baglanti hatasi.Connection null gonderdi:::");}
        
        else{  
                try {   String query1 = "SELECT * FROM `ilan_tasimacilar`.`logging` ORDER BY log_CreateTime DESC limit 1000";

                        ps = con.prepareStatement(query1);
                        ResultSet rs = ps.executeQuery();

                         while (rs.next()) {  LogManagerBean lmb = new LogManagerBean();
                                              lmb.setLogId(rs.getString("log_Id"));
                                              lmb.setLogLevel(rs.getString("log_Level"));
                                              lmb.setLogsource(rs.getString("log_Source"));
                                              lmb.setLogContent(rs.getString("log_Content"));
                                              lmb.setLogUser(rs.getString("log_User"));
                                              lmb.setLogShowing(rs.getBoolean("log_Showing"));
                                              lmb.setLogCreateTime(rs.getTimestamp("log_CreateTime"));
                                              lmb.setLogChangeTime(rs.getTimestamp("log_ChangeTime"));
                                              allLogList.add(lmb);
                                            }
                   } 

                catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                          System.err.println(":::HATA:::"+ex);} 

                finally { try { if (ps != null) {try {ps.close();} 
                                         catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                                                   System.err.println(":::HATA:::"+ex);}
                                        }
                        if (con != null && !con.isClosed()) {con.close();}
                      } 

                  catch (SQLException ex) { LogManagerDao.createLog("error", LogManagerDao.class.getName(), ex.toString(), "system");
                                            System.err.println(":::HATA:::"+ex);}
                }
        }

        return allLogList;
    }

    
}
