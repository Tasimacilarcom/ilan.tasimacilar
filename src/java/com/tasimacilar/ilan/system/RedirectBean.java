
package com.tasimacilar.ilan.system;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "redirectBean")
@ViewScoped
public class RedirectBean implements Serializable{
    
   
    @PostConstruct
    public void init() {  

        
        
    }
    public String redirect() {
        
        String snc = "";
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        String userAgent = request.getHeader("User-Agent");
  
   
            if (userAgent != null && userAgent.toLowerCase().contains("mobile")) {
                snc = "mobil";
                
            } 
            else {
             
                snc = "pc";
                
            }
        

        
       
        return snc;
    }
        
   
}
