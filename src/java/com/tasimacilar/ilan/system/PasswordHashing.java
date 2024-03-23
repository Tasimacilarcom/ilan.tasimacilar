
package com.tasimacilar.ilan.system;

import com.tasimacilar.ilan.system.loging.LogManagerDao;
import com.tasimacilar.ilan.system.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordHashing {     public String shaPasswordHashing(String password){
    
        MessageDigest md = null;
        StringBuffer sb = null;
        
        if(password != null || !password.equals("")){
        
                try {   md = MessageDigest.getInstance("SHA-256");  
                        md.update(password.getBytes());
                        byte byteData[] = md.digest();
 sb = new StringBuffer();

                        for (int i = 0; i < byteData.length; i++) {
                         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                        }
                    } 

                catch (NoSuchAlgorithmException ex) {
                    LogManagerDao.createLog("error", PasswordHashing.class.getName(), "Sha-256 hashing hatası"+ex.toString(), "system");
                    System.err.println(":::HATA:::"+PasswordHashing.class.getName()+":::Sha-256 hashing hatası:::"+ex.toString());
                }          
        }
        
        else{ LogManagerDao.createLog("error", PasswordHashing.class.getName(), "Sha-256 hashing hatası. Sifre bos veya null geldi", "system");
              System.err.println(":::HATA:::"+PasswordHashing.class.getName()+":::Sha-256 hashing hatası. Sifre bos veya null geldi:::");}
        
        return sb.toString();
    }

}
