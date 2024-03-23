
package com.tasimacilar.ilan.system;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class UniqueId {
 
    public String DefaultUUID(){
        
        UUID id = UUID.randomUUID();
        
        return id.toString();
    }

 
    public String WithoutDashesUUID(){
        
        UUID id = UUID.randomUUID();
        
        return id.toString().replaceAll("-", "");
    }
    
 
    public static String RandomString(int prm){
        String sonuc = null;
        SecureRandom srandom = new SecureRandom();
        sonuc = new BigInteger(64, srandom).toString(32);
        
        if(sonuc.length() > prm){
            sonuc = sonuc.substring(0, prm); 
        }
        
        while (sonuc.length() < prm) {            
           sonuc = new BigInteger(64, srandom).toString(32);
           if(sonuc.length() > prm){
                sonuc = sonuc.substring(0, prm); 
            }
        }
        
                
        return sonuc;
    }
         
    public static int RandomInt(int min, int max) {
        
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        return randomNum;
    }
}
