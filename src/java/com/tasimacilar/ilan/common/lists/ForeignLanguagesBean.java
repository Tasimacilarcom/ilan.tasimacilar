package com.tasimacilar.ilan.common.lists;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "foreignLanguagesBean")
@ViewScoped
public class ForeignLanguagesBean implements Serializable{
    private String      foreignLanguage_Id; 
    private boolean     foreignLanguage_English;      
    private boolean     foreignLanguage_Arabic;        
    private boolean     foreignLanguage_German;      
    private boolean     foreignLanguage_French;        
    private boolean     foreignLanguage_Chinese;       
    private boolean     foreignLanguage_Japanese;       
    private boolean     foreignLanguage_Spanish;       
    private boolean     foreignLanguage_Russian;       
    private boolean     foreignLanguage_Kurtce;          
    private String      foreignLanguage_Other;         
    private String      ad_Id;                       
    public ForeignLanguagesBean() {    }
    public String getForeignLanguage_Id() {return foreignLanguage_Id;}
    public void setForeignLanguage_Id(String foreignLanguage_Id) {this.foreignLanguage_Id = foreignLanguage_Id;}
    public boolean isForeignLanguage_English() {return foreignLanguage_English;}
    public void setForeignLanguage_English(boolean foreignLanguage_English) {this.foreignLanguage_English = foreignLanguage_English;}
    public boolean isForeignLanguage_Arabic() {return foreignLanguage_Arabic;}
    public void setForeignLanguage_Arabic(boolean foreignLanguage_Arabic) {this.foreignLanguage_Arabic = foreignLanguage_Arabic;}
    public boolean isForeignLanguage_German() { return foreignLanguage_German;}
    public void setForeignLanguage_German(boolean foreignLanguage_German) {this.foreignLanguage_German = foreignLanguage_German;}
    public boolean isForeignLanguage_French() {return foreignLanguage_French;}
    public void setForeignLanguage_French(boolean foreignLanguage_French) {this.foreignLanguage_French = foreignLanguage_French;}
    public boolean isForeignLanguage_Chinese() {return foreignLanguage_Chinese;}
    public void setForeignLanguage_Chinese(boolean foreignLanguage_Chinese) {this.foreignLanguage_Chinese = foreignLanguage_Chinese;}
    public boolean isForeignLanguage_Japanese() {return foreignLanguage_Japanese;}
    public void setForeignLanguage_Japanese(boolean foreignLanguage_Japanese) {this.foreignLanguage_Japanese = foreignLanguage_Japanese;}
    public boolean isForeignLanguage_Spanish() {return foreignLanguage_Spanish;}
    public void setForeignLanguage_Spanish(boolean foreignLanguage_Spanish) {this.foreignLanguage_Spanish = foreignLanguage_Spanish;}
    public boolean isForeignLanguage_Russian() { return foreignLanguage_Russian;}
    public void setForeignLanguage_Russian(boolean foreignLanguage_Russian) {this.foreignLanguage_Russian = foreignLanguage_Russian;}
    public boolean isForeignLanguage_Kurtce() {return foreignLanguage_Kurtce;}
    public void setForeignLanguage_Kurtce(boolean foreignLanguage_Kurtce) {this.foreignLanguage_Kurtce = foreignLanguage_Kurtce;}
    public String getForeignLanguage_Other() {return foreignLanguage_Other;}
    public void setForeignLanguage_Other(String foreignLanguage_Other) {this.foreignLanguage_Other = foreignLanguage_Other;}
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}

    
    
}
