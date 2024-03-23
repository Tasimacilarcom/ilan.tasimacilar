package com.tasimacilar.ilan.system;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ExpiryDates {

    public static Date AdExpiryDate(long expiryDays){
        LocalDate localDatex = LocalDate.now();
        LocalDate localDatexx = localDatex.plusDays(expiryDays);
        return Date.from(localDatexx.atStartOfDay(ZoneId.systemDefault()).toInstant());
    } 
}
