package com.tasimacilar.ilan.system;
import org.jsoup.Jsoup;
public class HtmlToText {
    public String html2text(String html) {    
        return Jsoup.parse(html).text();
    }

    
}
