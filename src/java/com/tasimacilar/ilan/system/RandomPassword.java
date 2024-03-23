
package com.tasimacilar.ilan.system;

import java.util.Random;


public class RandomPassword {

/public String createRandomPassword(int passwordLength) {

        final String ufakHarf = "abcdefghijklmnopqrstuvwxyz";
        final String buyukHarf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String karakter = "!@#$%&*";
        final String rakam = "0123456789";
        Random r = new Random();
        String pass = "";

        while (pass.length() != passwordLength) {

            int rPick = r.nextInt(4);

            if (rPick == 0) { int spot = r.nextInt(25);
                              pass += ufakHarf.charAt(spot);
                            } 
            
            else if (rPick == 1) { int tmp = r.nextInt(25);
                                   pass += buyukHarf.charAt(tmp);
                                 }
            
            else if (rPick == 2) { int tmp = r.nextInt(7);
                                   pass += karakter.charAt(tmp);
                                 }
            
            else if (rPick == 3) { int tmp = r.nextInt(9);
                                   pass += rakam.charAt(tmp);
                                 }
        }

        return pass;
    }
    

  
}
