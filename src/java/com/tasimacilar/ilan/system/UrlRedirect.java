
package com.tasimacilar.ilan.system;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class UrlRedirect {
 

    public static void redirect(String url){
        
        try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
              ec.redirect(ec.getRequestContextPath() + url);  } 
        catch (IOException ex) {System.out.println(":::HATA:::"+ex); }
    
    }
}
