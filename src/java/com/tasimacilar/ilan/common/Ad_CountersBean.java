package com.tasimacilar.ilan.common;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
@ManagedBean(name = "adCountersBean")
@SessionScoped
public class Ad_CountersBean  implements Serializable{
    private int   ad_ViewCount;    
    boolean methodWorked = false;  
    String pAdId;   Ad_CountersDao acd;
@PostConstruct
    public void init() { 
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        pAdId = req.getParameter("adId");   
        acd = new Ad_CountersDao();
    } public Ad_CountersBean() { }public int getAd_ViewCount() {return ad_ViewCount;}
    public void setAd_ViewCount(int ad_ViewCount) {this.ad_ViewCount = ad_ViewCount;}
    public void execute() {   this.ad_ViewCount = acd.getCounterData(pAdId, true, false, false);
    if(methodWorked ==false){
            acd.addCounterData(pAdId, true, false, false);
            methodWorked =true;
        }this.ad_ViewCount = acd.getCounterData(pAdId, true, false, false);
    }public int getAdViewCount(String adId){ return acd.getCounterData(adId, true, false, false); }  
}
