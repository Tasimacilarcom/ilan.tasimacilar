package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.common.CommonDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "dashboardBean")
@ViewScoped
public class DashboardBean implements Serializable{
    private int bekleyenDestekTalebiSayısı;
    private int toplamDestekTalebiSayısı;
    private int bekleyenYorumSayısı;
    private int toplamYorumSayısı;
    private int toplamAracSayısı;
    private int bekleyenFirmaSayısı;
    private int toplamFirmaSayısı;
    private int bireyselKullaniciSayisi;
    private int kurumsalKullaniciSayisi;
    private int toplamKullaniciSayisi;
    private int bekleyenIlanlar;
    private int bugun_isimVarAracAriyorum;
    private int bugun_aracimVarIsAriyorum;
    private int bugun_aracimVarSoforAriyorum;
    private int bugun_aracimVarHostesAriyorum;
    private int bugun_hostesimIsAriyorum;
    private int bugun_soforumIsAriyorum;
    private int bugun_plakamiSatiyorum;
    private int bugun_toplam;  
    private int yayinda_isimVarAracAriyorum;
    private int yayinda_aracimVarIsAriyorum;
    private int yayinda_aracimVarSoforAriyorum;
    private int yayinda_aracimVarHostesAriyorum;
    private int yayinda_hostesimIsAriyorum;
    private int yayinda_soforumIsAriyorum;
    private int yayinda_plakamiSatiyorum;
    private int yayinda_toplam; 
    private int tum_isimVarAracAriyorum;
    private int tum_aracimVarIsAriyorum;
    private int tum_aracimVarSoforAriyorum;
    private int tum_aracimVarHostesAriyorum;
    private int tum_hostesimIsAriyorum;
    private int tum_soforumIsAriyorum;
    private int tum_plakamiSatiyorum;
    private int tum_toplam;
    @PostConstruct
    public void init() { 
       bekleyenDestekTalepleriSayisi();
       toplamDestekTalepleriSayisi();
       bekleyenYorumSayisix();
       toplamYorumSayisix();
       toplamAracSayisix();
       toplamFirmaSayisix();
       bekleyenFirmaSayisix();
       bireyselKullaniciSayisix();
       kurumsalKullaniciSayisix();
       toplamKullaniciSayisix();
       bekleyenIlanlarx();
       bugun_ilanlar();
       yayinda_ilanlar();
       tum_ilanlar();
    }
    public DashboardBean() { }
    public int getBekleyenDestekTalebiSayısı() {return bekleyenDestekTalebiSayısı;}
    public void setBekleyenDestekTalebiSayısı(int bekleyenDestekTalebiSayısı) { this.bekleyenDestekTalebiSayısı = bekleyenDestekTalebiSayısı;}
    public int getToplamDestekTalebiSayısı() { return toplamDestekTalebiSayısı;}
    public void setToplamDestekTalebiSayısı(int toplamDestekTalebiSayısı) { this.toplamDestekTalebiSayısı = toplamDestekTalebiSayısı;}
    public int getBekleyenYorumSayısı() { return bekleyenYorumSayısı;}
    public void setBekleyenYorumSayısı(int bekleyenYorumSayısı) {this.bekleyenYorumSayısı = bekleyenYorumSayısı;}
    public int getToplamYorumSayısı() {return toplamYorumSayısı;}
    public void setToplamYorumSayısı(int toplamYorumSayısı) { this.toplamYorumSayısı = toplamYorumSayısı;}
    public int getToplamAracSayısı() {  return toplamAracSayısı;}
    public void setToplamAracSayısı(int toplamAracSayısı) {  this.toplamAracSayısı = toplamAracSayısı;}
    public int getBekleyenFirmaSayısı() {return bekleyenFirmaSayısı;}
    public void setBekleyenFirmaSayısı(int bekleyenFirmaSayısı) {this.bekleyenFirmaSayısı = bekleyenFirmaSayısı;}
    public int getToplamFirmaSayısı() {return toplamFirmaSayısı;}
    public void setToplamFirmaSayısı(int toplamFirmaSayısı) {this.toplamFirmaSayısı = toplamFirmaSayısı;}
    public int getBireyselKullaniciSayisi() { return bireyselKullaniciSayisi;}
    public void setBireyselKullaniciSayisi(int bireyselKullaniciSayisi) {this.bireyselKullaniciSayisi = bireyselKullaniciSayisi;}
    public int getKurumsalKullaniciSayisi() {return kurumsalKullaniciSayisi;}
    public void setKurumsalKullaniciSayisi(int kurumsalKullaniciSayisi) {this.kurumsalKullaniciSayisi = kurumsalKullaniciSayisi;}
    public int getToplamKullaniciSayisi() {return toplamKullaniciSayisi;}
    public void setToplamKullaniciSayisi(int toplamKullaniciSayisi) {this.toplamKullaniciSayisi = toplamKullaniciSayisi;}
    public int getBekleyenIlanlar() { return bekleyenIlanlar; }
    public void setBekleyenIlanlar(int bekleyenIlanlar) { this.bekleyenIlanlar = bekleyenIlanlar;}
    public int getBugun_isimVarAracAriyorum() {return bugun_isimVarAracAriyorum;}
    public void setBugun_isimVarAracAriyorum(int bugun_isimVarAracAriyorum) {this.bugun_isimVarAracAriyorum = bugun_isimVarAracAriyorum;}
    public int getBugun_aracimVarIsAriyorum() {return bugun_aracimVarIsAriyorum;}
    public void setBugun_aracimVarIsAriyorum(int bugun_aracimVarIsAriyorum) { this.bugun_aracimVarIsAriyorum = bugun_aracimVarIsAriyorum;}
    public int getBugun_aracimVarSoforAriyorum() {return bugun_aracimVarSoforAriyorum;}
    public void setBugun_aracimVarSoforAriyorum(int bugun_aracimVarSoforAriyorum) {this.bugun_aracimVarSoforAriyorum = bugun_aracimVarSoforAriyorum;}
    public int getBugun_aracimVarHostesAriyorum() {return bugun_aracimVarHostesAriyorum;}
    public void setBugun_aracimVarHostesAriyorum(int bugun_aracimVarHostesAriyorum) {this.bugun_aracimVarHostesAriyorum = bugun_aracimVarHostesAriyorum;}
    public int getBugun_hostesimIsAriyorum() {return bugun_hostesimIsAriyorum;}
    public void setBugun_hostesimIsAriyorum(int bugun_hostesimIsAriyorum) {this.bugun_hostesimIsAriyorum = bugun_hostesimIsAriyorum;}
    public int getBugun_soforumIsAriyorum() {return bugun_soforumIsAriyorum;}
    public void setBugun_soforumIsAriyorum(int bugun_soforumIsAriyorum) {this.bugun_soforumIsAriyorum = bugun_soforumIsAriyorum;}
    public int getBugun_plakamiSatiyorum() { return bugun_plakamiSatiyorum;}
    public void setBugun_plakamiSatiyorum(int bugun_plakamiSatiyorum) { this.bugun_plakamiSatiyorum = bugun_plakamiSatiyorum;}
    public int getBugun_toplam() {return bugun_toplam;}
    public void setBugun_toplam(int bugun_toplam) { this.bugun_toplam = bugun_toplam;}
    public int getYayinda_isimVarAracAriyorum() {return yayinda_isimVarAracAriyorum;}
    public void setYayinda_isimVarAracAriyorum(int yayinda_isimVarAracAriyorum) {this.yayinda_isimVarAracAriyorum = yayinda_isimVarAracAriyorum;}
    public int getYayinda_aracimVarIsAriyorum() {return yayinda_aracimVarIsAriyorum;}
    public void setYayinda_aracimVarIsAriyorum(int yayinda_aracimVarIsAriyorum) { this.yayinda_aracimVarIsAriyorum = yayinda_aracimVarIsAriyorum;}
    public int getYayinda_aracimVarSoforAriyorum() {return yayinda_aracimVarSoforAriyorum;}
    public void setYayinda_aracimVarSoforAriyorum(int yayinda_aracimVarSoforAriyorum) {this.yayinda_aracimVarSoforAriyorum = yayinda_aracimVarSoforAriyorum;}
    public int getYayinda_aracimVarHostesAriyorum() {return yayinda_aracimVarHostesAriyorum;}
    public void setYayinda_aracimVarHostesAriyorum(int yayinda_aracimVarHostesAriyorum) {this.yayinda_aracimVarHostesAriyorum = yayinda_aracimVarHostesAriyorum;}
    public int getYayinda_hostesimIsAriyorum() {return yayinda_hostesimIsAriyorum;}
    public void setYayinda_hostesimIsAriyorum(int yayinda_hostesimIsAriyorum) {this.yayinda_hostesimIsAriyorum = yayinda_hostesimIsAriyorum;}
    public int getYayinda_soforumIsAriyorum() {return yayinda_soforumIsAriyorum;}
    public void setYayinda_soforumIsAriyorum(int yayinda_soforumIsAriyorum) { this.yayinda_soforumIsAriyorum = yayinda_soforumIsAriyorum;}
    public int getYayinda_plakamiSatiyorum() { return yayinda_plakamiSatiyorum;}
    public void setYayinda_plakamiSatiyorum(int yayinda_plakamiSatiyorum) {this.yayinda_plakamiSatiyorum = yayinda_plakamiSatiyorum;}  
    public int getYayinda_toplam() { return yayinda_toplam;}
    public void setYayinda_toplam(int yayinda_toplam) { this.yayinda_toplam = yayinda_toplam;}
    public int getTum_isimVarAracAriyorum() { return tum_isimVarAracAriyorum;}
    public void setTum_isimVarAracAriyorum(int tum_isimVarAracAriyorum) {this.tum_isimVarAracAriyorum = tum_isimVarAracAriyorum;}
    public int getTum_aracimVarIsAriyorum() { return tum_aracimVarIsAriyorum;}
    public void setTum_aracimVarIsAriyorum(int tum_aracimVarIsAriyorum) {this.tum_aracimVarIsAriyorum = tum_aracimVarIsAriyorum;}
    public int getTum_aracimVarSoforAriyorum() { return tum_aracimVarSoforAriyorum;}
    public void setTum_aracimVarSoforAriyorum(int tum_aracimVarSoforAriyorum) { this.tum_aracimVarSoforAriyorum = tum_aracimVarSoforAriyorum;}
    public int getTum_aracimVarHostesAriyorum() { return tum_aracimVarHostesAriyorum;}
    public void setTum_aracimVarHostesAriyorum(int tum_aracimVarHostesAriyorum) { this.tum_aracimVarHostesAriyorum = tum_aracimVarHostesAriyorum;}
    public int getTum_hostesimIsAriyorum() {return tum_hostesimIsAriyorum;}
    public void setTum_hostesimIsAriyorum(int tum_hostesimIsAriyorum) {this.tum_hostesimIsAriyorum = tum_hostesimIsAriyorum;}
    public int getTum_soforumIsAriyorum() {return tum_soforumIsAriyorum;}
    public void setTum_soforumIsAriyorum(int tum_soforumIsAriyorum) { this.tum_soforumIsAriyorum = tum_soforumIsAriyorum;}
    public int getTum_plakamiSatiyorum() {return tum_plakamiSatiyorum;}
    public void setTum_plakamiSatiyorum(int tum_plakamiSatiyorum) {this.tum_plakamiSatiyorum = tum_plakamiSatiyorum;}
    public int getTum_toplam() { return tum_toplam;}
    public void setTum_toplam(int tum_toplam) {this.tum_toplam = tum_toplam;}
public void bekleyenDestekTalepleriSayisi() {    
        DashboardDao d = new DashboardDao();
        this.bekleyenDestekTalebiSayısı = d.bekleyenDestekTalepleriSayisi(); } public void toplamDestekTalepleriSayisi() { DashboardDao d = new DashboardDao();
        this.toplamDestekTalebiSayısı = d.toplamDestekTalepleriSayisi();
    } public void bekleyenYorumSayisix() { DashboardDao d = new DashboardDao();
        this.bekleyenYorumSayısı = d.bekleyenYorumSayisi();
    }public void toplamYorumSayisix() { DashboardDao d = new DashboardDao();
        this.toplamYorumSayısı = d.toplamYorumSayisi(); } public void toplamAracSayisix() { DashboardDao d = new DashboardDao();
        this.toplamAracSayısı = d.toplamAracSayisi();
    } public void bekleyenFirmaSayisix() { DashboardDao d = new DashboardDao();
        this.bekleyenFirmaSayısı = d.bekleyenFirmaSayisi(); }public void toplamFirmaSayisix() {
        DashboardDao d = new DashboardDao();
        this.toplamFirmaSayısı = d.toplamFirmaSayisi();} public void bireyselKullaniciSayisix() { 
       CommonDao dd = new CommonDao();
        this.bireyselKullaniciSayisi = dd.toplamAktifBireyselKullaniciSayisi(); }public void kurumsalKullaniciSayisix() {
        CommonDao dd = new CommonDao();
        this.kurumsalKullaniciSayisi = dd.toplamAktifKurumsalKullaniciSayisi(); } public void toplamKullaniciSayisix() { 
        this.toplamKullaniciSayisi = this.bireyselKullaniciSayisi + this.kurumsalKullaniciSayisi;
    } public void bekleyenIlanlarx() { DashboardDao d = new DashboardDao();
       this.bekleyenIlanlar = d.bekleyenIlanSayisi();} public void bugun_ilanlar() {      
        ArrayList<String> catList = new ArrayList<String>();
        DashboardDao d = new DashboardDao();
        catList = d.bugun_ilanlar();
        
        for (String s : catList) { 
            switch (s) { 
                case "Aracim var şöför arıyorum" : this.bugun_aracimVarSoforAriyorum = this.bugun_aracimVarSoforAriyorum +1 ; break;
                case "Aracim var hostes arıyorum" : this.bugun_aracimVarHostesAriyorum = this.bugun_aracimVarHostesAriyorum +1; break;
                case "İşim var araç arıyorum" : this.bugun_isimVarAracAriyorum = this.bugun_isimVarAracAriyorum +1; break;
                case "Aracım var iş arıyorum" : this.bugun_aracimVarIsAriyorum = this.bugun_aracimVarIsAriyorum +1; break;
                case "Hostesim iş arıyorum" : this.bugun_hostesimIsAriyorum = this.bugun_hostesimIsAriyorum +1; break;
                case "Şöförüm iş arıyorum" : this.bugun_soforumIsAriyorum = this.bugun_soforumIsAriyorum +1; break;
                case "Plakamı satıyorum" : this.bugun_plakamiSatiyorum = this.bugun_plakamiSatiyorum +1; break;
                default : break;
            }
        }
       
        this.bugun_toplam = this.bugun_aracimVarSoforAriyorum + 
                            this.bugun_aracimVarHostesAriyorum + 
                            this.bugun_isimVarAracAriyorum + 
                            this.bugun_aracimVarIsAriyorum + 
                            this.bugun_hostesimIsAriyorum + 
                            this.bugun_soforumIsAriyorum +
                            this.bugun_plakamiSatiyorum;
        
    }public void yayinda_ilanlar() {
        
                ArrayList<String> catList = new ArrayList<String>();
        DashboardDao d = new DashboardDao();
        catList = d.yayindaki_ilanlar();
        
        for (String s : catList) {
            switch (s) { 
                case "Aracim var şöför arıyorum" : this.yayinda_aracimVarSoforAriyorum = this.yayinda_aracimVarSoforAriyorum +1 ; break;
                case "Aracim var hostes arıyorum" : this.yayinda_aracimVarHostesAriyorum = this.yayinda_aracimVarHostesAriyorum +1; break;
                case "İşim var araç arıyorum" : this.yayinda_isimVarAracAriyorum = this.yayinda_isimVarAracAriyorum +1; break;
                case "Aracım var iş arıyorum" : this.yayinda_aracimVarIsAriyorum = this.yayinda_aracimVarIsAriyorum +1; break;
                case "Hostesim iş arıyorum" : this.yayinda_hostesimIsAriyorum = this.yayinda_hostesimIsAriyorum +1; break;
                case "Şöförüm iş arıyorum" : this.yayinda_soforumIsAriyorum = this.yayinda_soforumIsAriyorum +1; break;
                case "Plakamı satıyorum" : this.yayinda_plakamiSatiyorum = this.yayinda_plakamiSatiyorum +1; break;
                default : break;
            }
        }
       
        this.yayinda_toplam = this.yayinda_aracimVarSoforAriyorum + 
                            this.yayinda_aracimVarHostesAriyorum + 
                            this.yayinda_isimVarAracAriyorum + 
                            this.yayinda_aracimVarIsAriyorum + 
                            this.yayinda_hostesimIsAriyorum + 
                            this.yayinda_soforumIsAriyorum +
                            this.yayinda_plakamiSatiyorum ;
      
    } public void tum_ilanlar() {
        
        ArrayList<String> catList = new ArrayList<String>();
        DashboardDao d = new DashboardDao();
        catList = d.tum_ilanlar();
        
        for (String s : catList) {
            switch (s) { 
                case "Aracim var şöför arıyorum" : this.tum_aracimVarSoforAriyorum = this.tum_aracimVarSoforAriyorum +1 ; break;
                case "Aracim var hostes arıyorum" : this.tum_aracimVarHostesAriyorum = this.tum_aracimVarHostesAriyorum +1; break;
                case "İşim var araç arıyorum" : this.tum_isimVarAracAriyorum = this.tum_isimVarAracAriyorum +1; break;
                case "Aracım var iş arıyorum" : this.tum_aracimVarIsAriyorum = this.tum_aracimVarIsAriyorum +1; break;
                case "Hostesim iş arıyorum" : this.tum_hostesimIsAriyorum = this.tum_hostesimIsAriyorum +1; break;
                case "Şöförüm iş arıyorum" : this.tum_soforumIsAriyorum = this.tum_soforumIsAriyorum +1; break;
                case "Plakamı satıyorum" : this.tum_plakamiSatiyorum = this.tum_plakamiSatiyorum +1; break;
                default : break;
            }
        }
       
        this.tum_toplam = this.tum_aracimVarSoforAriyorum + 
                            this.tum_aracimVarHostesAriyorum + 
                            this.tum_isimVarAracAriyorum + 
                            this.tum_aracimVarIsAriyorum + 
                            this.tum_hostesimIsAriyorum + 
                            this.tum_plakamiSatiyorum +
                            this.tum_soforumIsAriyorum;
      
      
    }
    
    
    
    
    
    
    
}
