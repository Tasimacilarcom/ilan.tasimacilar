package com.tasimacilar.ilan.system;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class ConnectionManager {

    private static String dbAdresi;
    private static String dbPort;
    private static String dbAdi;
    private static String dbTur;
    private static String kullaniciAdi;
    private static String sifre;
    private static Connection con;

public static Connection GetConnection() {

    try {   CompositeConfiguration config = new CompositeConfiguration();

            config.addConfiguration(new SystemConfiguration());
            config.addConfiguration(new PropertiesConfiguration("ConMan_Cfg.properties"));
            dbTur = (String) (config.getProperty("Db_Tur"));
            dbAdresi = (String) (config.getProperty("Db_Adres"));
            dbPort = (String) (config.getProperty("Db_Port"));
            dbAdi = (String) (config.getProperty("Db_Adi"));
            kullaniciAdi = (String) (config.getProperty("Db_KullaniciAdi"));
            sifre = (String) (config.getProperty("Db_KullaniciSifre"));
        } 
    catch (ConfigurationException ex) { System.err.println(":::HATA:::"+ConnectionManager.class.getName()+":::"+ex+":::");
                                        LogManagerDao.createLog("error", ConnectionManager.class.getName(), ex.toString(), "system");}
   
    String yol_Mysql = "jdbc:mysql://" + dbAdresi + ":" + dbPort + "/" + dbAdi + "?allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
                                                                                                                                      

    try {   Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection(yol_Mysql, kullaniciAdi, sifre);} 

    catch (ClassNotFoundException e) { 
            System.err.println("-----ClassNotFoundException-----");
            System.err.println("JDBC_Sqlserver Driver'inde sorun bulunmakta");
            System.err.println("Message :  " + e.getMessage());
            System.err.println("----------------------");
            e.printStackTrace(); } 

    catch (SQLException e) {   
            System.err.println("-----SQLException-----");
            System.err.println("SQL Sorunu bulundu");
            System.err.println("SQLState:  " + e.getSQLState());
            System.err.println("Message :  " + e.getMessage());
            System.err.println("Vendor  :  " + e.getErrorCode());
            System.err.println("----------------------");
            e.printStackTrace();}

    return con;
}
    

}
