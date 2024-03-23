package com.tasimacilar.ilan.common;
import com.tasimacilar.ilan.ad.Ad_Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
@ManagedBean(name = "commonBean")
@ViewScoped
public class CommonBean implements Serializable{ private int         resetPassword_msg;      
public CommonBean() { }   
 @PostConstruct
    public void init() {   HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
if(req.getParameter("msg") != null){
            if(!req.getParameter("msg").equals("")){
                resetPassword_msg = Integer.parseInt(req.getParameter("msg"));    // mesaj icin
            } }  }
 public int getResetPassword_msg() { return resetPassword_msg; }
    public void setResetPassword_msg(int resetPassword_msg) { this.resetPassword_msg = resetPassword_msg;  }
public int toplamAktifKullaniciSayisi(){  CommonDao dd = new CommonDao(); return dd.toplamAktifKullaniciSayisi(); }
 public List<String>  vehicleCapacityList() { Ad_Dao ado = new Ad_Dao();  return ado.getAllVehicleCapacity(); }
public List<String>  vehicleBransList() {  Ad_Dao ado = new Ad_Dao();      return ado.getAllVehicleBrands();  }

    
}
