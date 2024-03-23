
package com.tasimacilar.ilan.system.language;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


@ManagedBean(name = "lang")
@SessionScoped
public class LocaleBean implements Serializable{

    private String              yerelDurum;
    private Map<String, Object> ulkelerHaritasi;
    private Locale              locale;
    @PostConstruct
    public void init() {        
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }
    public LocaleBean() { 
        ulkelerHaritasi = new LinkedHashMap<String, Object>();
        ulkelerHaritasi.put("Türkçe", new Locale("tr","TR"));
        ulkelerHaritasi.put("English", new Locale("en","GB"));
    }
    public Map <String, Object> getLanguages(){return ulkelerHaritasi;}

    public String getYerelDurum() {return yerelDurum; }
    public void setYerelDurum(String yerelDurum) {this.yerelDurum = yerelDurum;}

    public Locale getLocale() {return locale;}
    public void setLocale(Locale locale) {this.locale = locale;}
 public void yerelDurumDegisiminiKontrolEt(ValueChangeEvent e) {

        String localeStr = e.getNewValue().toString();
        this.yerelDurum = localeStr;

        for (Map.Entry<String, Object> entry : ulkelerHaritasi.entrySet()) {
            if (entry.getValue().toString().equals(localeStr)) {
                locale = (Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
            }
        }
    }
    
    
    
}
