
package com.tasimacilar.ilan.system;


import java.text.Normalizer;
import java.util.regex.Pattern;


public class ReplaiceTurkishLetters {


    public static String replaice(String word) {
        String temp = Normalizer.normalize(word, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        return pattern.matcher(temp).replaceAll("").replaceAll("ı", "i");
    }
    
}

