package com.tasimacilar.ilan.profile.account.corporate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("corporateAccountBeanConverter")
public class CorporateAccountBeanConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
         List<CorporateAccountBean> tmpFirmalar = new ArrayList<CorporateAccountBean>();
        CorporateAccountDao cad = new CorporateAccountDao();
        tmpFirmalar= cad.getAllCorporateAccountWithDetail();
        for(CorporateAccountBean c : tmpFirmalar){
            if(c.getCompany_Id().equals(value)){    return c;   }   } return null;  }
    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object value) {                 
         if(value instanceof CorporateAccountBean){
            CorporateAccountBean corporateAccountBean = (CorporateAccountBean)value;
            return corporateAccountBean.getCompany_Id();  }  return "";      
    }
    
    
}
