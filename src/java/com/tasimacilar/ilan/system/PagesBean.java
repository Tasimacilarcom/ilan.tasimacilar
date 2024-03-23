package com.tasimacilar.ilan.system;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;


@ManagedBean(name = "pagesBean")
@ViewScoped
public class PagesBean implements Serializable{
    
    private String onPage;
   
    @PostConstruct
    public void init() { 
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        if(req != null){
            try {
            
                 String url = req.getRequestURL().toString();
                URL urlx = new URL(url);

                if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_my_ads") ){ this.onPage ="personal_my_ads";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_my_ads") ){ this.onPage ="corporate_my_ads";}
                
                if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") ){ this.onPage ="personal_my_ads";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_duzenle") ){ this.onPage ="personal_my_ads";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ){ this.onPage ="corporate_my_ads";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_duzenle") ){ this.onPage ="corporate_my_ads";}
                
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("profile_settings_s1") ){ this.onPage ="profile_settings_s1";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("profile_settings_s2") ){ this.onPage ="profile_settings_s1";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("profile_settings") ){ this.onPage ="profile_settings";}
                
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_my_vehicles") ){ this.onPage ="personal_my_vehicles";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_my_vehicles") ){ this.onPage ="corporate_my_vehicles";} 
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_add_vehicle") ){ this.onPage ="personal_my_vehicles";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_add_vehicle") ){ this.onPage ="corporate_my_vehicles";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_edit_vehicle") ){ this.onPage ="personal_my_vehicles";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_edit_vehicle") ){ this.onPage ="corporate_my_vehicles";}
                
                
                
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("messages_ads") ){ this.onPage ="messages_ads";}
                
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_my_favorites") ){ this.onPage ="personal_my_favorites";}
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_my_favorites") ){ this.onPage ="corporate_my_favorites";}
                
                else if(FilenameUtils.getBaseName(urlx.getPath()).equals("support") ){ this.onPage ="support";}
            } 
            catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }  
        }
        
        
    
    }  public String getOnPage() {return onPage;}
    public void setOnPage(String onPage) {this.onPage = onPage;}
    










    
}
