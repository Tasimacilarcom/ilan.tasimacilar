package com.tasimacilar.ilan.system.sms;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
@ManagedBean(name = "smsBean")
@ViewScoped
public class SmsBean implements Serializable {
    private static String KULNO = "";
    private static String KULAD = "";
    private static String KULSIFRE = "";
    private static String ORJINATOR = "";
    private static String ZAMAN = "";   	
    private static String ZAMANASIMI = "";	
    private static String TIP = "Turkce";  
    private static String Adres = "";
     private static String sms2_api_id = "";
    private static String sms2_api_key = "";
    private static String sms2_sender = "";
    private static String sms2_message_type = "";
    private static String sms2_apiUrl = "";
public SmsBean() {  }
public static void sendSms2(String gsmNo, String sms){
        try {   CompositeConfiguration config = new CompositeConfiguration();

                config.addConfiguration(new SystemConfiguration());
                config.addConfiguration(new PropertiesConfiguration("Settings.properties"));
                
                SmsBean.KULNO = (String) (config.getProperty("sms_kullaniciNo"));
                SmsBean.KULAD = (String) (config.getProperty("sms_kullaniciAdi"));
                SmsBean.KULSIFRE = (String) (config.getProperty("sms_kullaniciSifre"));
                SmsBean.ORJINATOR = (String) (config.getProperty("sms_orjinator"));
                SmsBean.Adres = (String) (config.getProperty("sms_postUrl"));
            } 
        catch (ConfigurationException ex) {System.out.println(":::HATA:::"+ex);}
        
        try {
            String Numara = gsmNo;
            String Mesajx ="Tasimacilar.com ilan sitesi için SMS Onay şifreniz: "+sms+"  Bu şifre şuandan itibaren 1 saat geçerlidir.";
            String Mesaj = new String(Mesajx.getBytes("UTF-8"), "UTF-8");
            
            String SmsBody = "<?xml version='1.0' encoding='utf-8'?>"
                    + "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"
                    + "<soap:Body>"
                    + "<TekSmsiBirdenCokNumarayaGonder xmlns='" + Adres + "'>"
                    + "<kullanicino>" + KULNO + "</kullanicino>"
                    + "<kullaniciadi>" + KULAD + "</kullaniciadi>"
                    + "<sifre>" + KULSIFRE + "</sifre>"
                    + "<orjinator>" + ORJINATOR + "</orjinator>"
                    + "<numaralar>" + Numara + "</numaralar>"
                    + "<mesaj>" + Mesaj + "</mesaj>"
                    + "<zaman>" + ZAMAN + "</zaman>"
                    + "<zamanasimi>" + ZAMANASIMI + "</zamanasimi>"
                    + "<tip>" + TIP + "</tip>"
                    + "</TekSmsiBirdenCokNumarayaGonder>"
                    + "</soap:Body>"
                    + "</soap:Envelope>";
            System.out.println(":::SMS GONDERILDI::: TEL= "+Numara+" -- SMS= "+Mesaj+" -- SONUC= "+POST(Adres, SmsBody));
        } 
        catch (UnsupportedEncodingException ex) {  System.out.println(":::HATA:::"+ex);  }
    } public static String POST(String _Adres, String _Xml) {
        
        HttpClient client = new DefaultHttpClient();
        
        try {
            HttpEntity httpEntity = new StringEntity(_Xml, Charset.forName("UTF-8"));
            HttpPost post = new HttpPost(_Adres);
            post.setHeader("Content-type", "text/xml; charset=utf-8");
            post.setEntity(httpEntity);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String cevap = EntityUtils.toString(entity);
                cevap = cevap.split("<return xsi:type=\"xsd:string\">")[1];
                return cevap.split("</return>")[0];
            }
            return null;
        } 
        
        catch (IOException ex) { System.out.println(ex);  throw new RuntimeException(ex); } 
        finally {    client.getConnectionManager().shutdown();   }
    }public static void sendSms(String gsmNo, String sms){
        
         try {   CompositeConfiguration config = new CompositeConfiguration();

                config.addConfiguration(new SystemConfiguration());
                config.addConfiguration(new PropertiesConfiguration("Settings.properties"));
                
                SmsBean.sms2_api_id = (String) (config.getProperty("sms2_api_id"));
                SmsBean.sms2_api_key = (String) (config.getProperty("sms2_api_key"));
                SmsBean.sms2_sender = (String) (config.getProperty("sms2_sender"));
                SmsBean.sms2_message_type = (String) (config.getProperty("sms2_message_type"));
                SmsBean.sms2_apiUrl = (String) (config.getProperty("sms2_apiUrl"));      
            } 
        catch (ConfigurationException ex) {System.out.println(":::HATA:::"+ex);}
        
        String apiUrl = sms2_apiUrl;
        String jsonFormData = "{ \"api_id\": \" "+sms2_api_id+" \", \"api_key\": \" "+sms2_api_key+" \", "
                + "\"sender\": \" "+sms2_sender+" \", \"message_type\": \" "+sms2_message_type+" \", \"message\": \" "+"TASIMACILAR.COM GSM Aktivasyon Kodunuz : "+sms+" dir. \","
                + " \"phones\": [ \" "+gsmNo+" \" ] }";
        
        try {
          URL url = new URL(apiUrl);
          HttpURLConnection connect = (HttpURLConnection) url.openConnection();
          connect.setDoOutput(true);
          connect.setConnectTimeout(5000);
          connect.setDoInput(true);
          connect.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          connect.setRequestMethod("POST");
    
          OutputStream prepareFormData = connect.getOutputStream();
          prepareFormData.write(jsonFormData.getBytes("UTF-8"));
          prepareFormData.close();
          
          InputStream inputStream = new BufferedInputStream(connect.getInputStream());
          Scanner s = new Scanner(inputStream).useDelimiter("A");
          String result = s.hasNext() ? s.next() : "";
          
          System.out.println(result);
          inputStream.close();
          connect.disconnect();
          
        } catch (Exception e) { System.out.println("Bir hata ile karşılaşıldı : " + e.getMessage());}       
        
    }
     
}
