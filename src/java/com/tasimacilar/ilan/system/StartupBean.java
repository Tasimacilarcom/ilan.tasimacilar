
package com.tasimacilar.ilan.system;


import com.tasimacilar.ilan.ad.search.Ad_Search_Bean;
import com.tasimacilar.ilan.system.backup.ScheduledDatabaseBackup;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;


@ManagedBean(name="startupBean", eager=true)
@ApplicationScoped
public class StartupBean {


    public StartupBean() {
        
        try { System.setOut(new PrintStream(System.out, true, "utf-8")); } 
        catch (UnsupportedEncodingException ex) { System.out.println(":::ERROR:::"+ex); }
        
        System.out.println("==============================================================");
        System.out.println(".:: TASIMACILAR.COM WEB APP STARTED ::.");
        System.out.println(".:: TASIMACILAR.COM WEB APP POWERED BY SUPFORCE BILGI TEKNOLOJILERI ::.");
        System.out.println("==============================================================");
        
   
    }
    
   
    
    
}
