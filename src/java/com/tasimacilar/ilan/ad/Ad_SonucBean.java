package com.tasimacilar.ilan.ad;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
@ManagedBean(name = "adSonucBean") @ViewScoped public class Ad_SonucBean implements Serializable{
    private String pAdId;    private String cat;    private String yonlen;   @PostConstruct public void init() { 
     HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
 pAdId = req.getParameter("adId");       //
 cat = req.getParameter("cat");     
 if(cat.equals("isim-var-arac-ariyorum")){yonlen="/ad/isim-var-arac-ariyorum/"+pAdId;}
        if(cat.equals("aracim-var-hostes-ariyorum")){yonlen="/ad/aracim-var-hostes-ariyorum/"+pAdId;}
        if(cat.equals("aracim-var-sofor-ariyorum")){yonlen="/ad/aracim-var-sofor-ariyorum/"+pAdId;}
        if(cat.equals("aracim-var-is-ariyorum")){yonlen="/ad/aracim-var-is-ariyorum/"+pAdId;}
        if(cat.equals("hostesim-is-ariyorum")){yonlen="/ad/hostesim-is-ariyorum/"+pAdId;}
        if(cat.equals("soforum-is-ariyorum")){yonlen="/ad/soforum-is-ariyorum/"+pAdId;}
        if(cat.equals("plakami-satiyorum")){yonlen="/ad/plakami-satiyorum/"+pAdId;}
    }    
 public String getpAdId() {return pAdId;}
 public void setpAdId(String pAdId) { this.pAdId = pAdId;}   
    public String getCat() { return cat;}
    public void setCat(String cat) { this.cat = cat;}  
    public String getYonlen() { return yonlen;}
    public void setYonlen(String yonlen) { this.yonlen = yonlen;}

    
    
    
    
}
