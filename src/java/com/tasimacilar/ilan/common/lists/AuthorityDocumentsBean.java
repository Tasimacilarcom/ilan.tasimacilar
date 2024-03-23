package com.tasimacilar.ilan.common.lists;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "authorityDocumentsBean")
@ViewScoped
public class AuthorityDocumentsBean implements Serializable{ 
    private String      authorityDocuments_Id;
    private boolean     authorityDocuments_D2Belgesi;
    private boolean     authorityDocuments_ZorunluTrafikSigortasi;
    private boolean     authorityDocuments_ESinifiEhliyet;
    private boolean     authorityDocuments_YolBelgesi;
    private boolean     authorityDocuments_AracMuayenesi; 
    private boolean     authorityDocuments_Psikoteknik;
    private boolean     authorityDocuments_SosyalAktiviteBelgesi;
    private boolean     authorityDocuments_KoltukFerdiKazaSigortasi;
    private boolean     authorityDocuments_Other;                     
    private String      authorityDocuments_OtherComment;               
    private Date        authorityDocuments_Modified;                   
    private String      authorityDocuments_Modifier;                    
    private Date        authorityDocuments_Created;                     
    private String      authorityDocuments_creator;                   
    private String      vehicle_Id;                                   
    public AuthorityDocumentsBean() {  }
    public AuthorityDocumentsBean(  String authorityDocuments_Id, 
                                    boolean authorityDocuments_D2Belgesi, 
                                    boolean authorityDocuments_ZorunluTrafikSigortasi, 
                                    boolean authorityDocuments_ESinifiEhliyet, 
                                    boolean authorityDocuments_YolBelgesi, 
                                    boolean authorityDocuments_AracMuayenesi, 
                                    boolean authorityDocuments_Psikoteknik, 
                                    boolean authorityDocuments_SosyalAktiviteBelgesi, 
                                    boolean authorityDocuments_KoltukFerdiKazaSigortasi, 
                                    boolean authorityDocuments_Other, 
                                    String authorityDocuments_OtherComment, 
                                    Date authorityDocuments_Modified, 
                                    String authorityDocuments_Modifier, 
                                    Date authorityDocuments_Created, 
                                    String authorityDocuments_creator, 
                                    String vehicle_Id) {
        this.authorityDocuments_Id = authorityDocuments_Id;
        this.authorityDocuments_D2Belgesi = authorityDocuments_D2Belgesi;
        this.authorityDocuments_ZorunluTrafikSigortasi = authorityDocuments_ZorunluTrafikSigortasi;
        this.authorityDocuments_ESinifiEhliyet = authorityDocuments_ESinifiEhliyet;
        this.authorityDocuments_YolBelgesi = authorityDocuments_YolBelgesi;
        this.authorityDocuments_AracMuayenesi = authorityDocuments_AracMuayenesi;
        this.authorityDocuments_Psikoteknik = authorityDocuments_Psikoteknik;
        this.authorityDocuments_SosyalAktiviteBelgesi = authorityDocuments_SosyalAktiviteBelgesi;
        this.authorityDocuments_KoltukFerdiKazaSigortasi = authorityDocuments_KoltukFerdiKazaSigortasi;
        this.authorityDocuments_Other = authorityDocuments_Other;
        this.authorityDocuments_OtherComment = authorityDocuments_OtherComment;
        this.authorityDocuments_Modified = authorityDocuments_Modified;
        this.authorityDocuments_Modifier = authorityDocuments_Modifier;
        this.authorityDocuments_Created = authorityDocuments_Created;
        this.authorityDocuments_creator = authorityDocuments_creator;
        this.vehicle_Id = vehicle_Id;
    }
    public String getAuthorityDocuments_Id() {return authorityDocuments_Id;}
    public void setAuthorityDocuments_Id(String authorityDocuments_Id) {this.authorityDocuments_Id = authorityDocuments_Id;}
    public boolean isAuthorityDocuments_D2Belgesi() {return authorityDocuments_D2Belgesi;}
    public void setAuthorityDocuments_D2Belgesi(boolean authorityDocuments_D2Belgesi) {this.authorityDocuments_D2Belgesi = authorityDocuments_D2Belgesi;}
    public boolean isAuthorityDocuments_ZorunluTrafikSigortasi() {return authorityDocuments_ZorunluTrafikSigortasi;}
    public void setAuthorityDocuments_ZorunluTrafikSigortasi(boolean authorityDocuments_ZorunluTrafikSigortasi) {this.authorityDocuments_ZorunluTrafikSigortasi = authorityDocuments_ZorunluTrafikSigortasi;}
    public boolean isAuthorityDocuments_ESinifiEhliyet() {return authorityDocuments_ESinifiEhliyet;}
    public void setAuthorityDocuments_ESinifiEhliyet(boolean authorityDocuments_ESinifiEhliyet) {this.authorityDocuments_ESinifiEhliyet = authorityDocuments_ESinifiEhliyet;}
    public boolean isAuthorityDocuments_YolBelgesi() {return authorityDocuments_YolBelgesi;}
    public void setAuthorityDocuments_YolBelgesi(boolean authorityDocuments_YolBelgesi) {this.authorityDocuments_YolBelgesi = authorityDocuments_YolBelgesi;}
    public boolean isAuthorityDocuments_AracMuayenesi() {return authorityDocuments_AracMuayenesi;}
    public void setAuthorityDocuments_AracMuayenesi(boolean authorityDocuments_AracMuayenesi) {this.authorityDocuments_AracMuayenesi = authorityDocuments_AracMuayenesi;}  
    public boolean isAuthorityDocuments_Psikoteknik() {return authorityDocuments_Psikoteknik;}
    public void setAuthorityDocuments_Psikoteknik(boolean authorityDocuments_Psikoteknik) {this.authorityDocuments_Psikoteknik = authorityDocuments_Psikoteknik;}
    public boolean isAuthorityDocuments_SosyalAktiviteBelgesi() {return authorityDocuments_SosyalAktiviteBelgesi;}
    public void setAuthorityDocuments_SosyalAktiviteBelgesi(boolean authorityDocuments_SosyalAktiviteBelgesi) {this.authorityDocuments_SosyalAktiviteBelgesi = authorityDocuments_SosyalAktiviteBelgesi;}
    public boolean isAuthorityDocuments_KoltukFerdiKazaSigortasi() {return authorityDocuments_KoltukFerdiKazaSigortasi;}
    public void setAuthorityDocuments_KoltukFerdiKazaSigortasi(boolean authorityDocuments_KoltukFerdiKazaSigortasi) {this.authorityDocuments_KoltukFerdiKazaSigortasi = authorityDocuments_KoltukFerdiKazaSigortasi;}
    public boolean isAuthorityDocuments_Other() {return authorityDocuments_Other;}
    public void setAuthorityDocuments_Other(boolean authorityDocuments_Other) {this.authorityDocuments_Other = authorityDocuments_Other;}
    public String getAuthorityDocuments_OtherComment() {return authorityDocuments_OtherComment;}
    public void setAuthorityDocuments_OtherComment(String authorityDocuments_OtherComment) {this.authorityDocuments_OtherComment = authorityDocuments_OtherComment;}
    public Date getAuthorityDocuments_Modified() {return authorityDocuments_Modified;}
    public void setAuthorityDocuments_Modified(Date authorityDocuments_Modified) {this.authorityDocuments_Modified = authorityDocuments_Modified;}
    public String getAuthorityDocuments_Modifier() {return authorityDocuments_Modifier;}
    public void setAuthorityDocuments_Modifier(String authorityDocuments_Modifier) {this.authorityDocuments_Modifier = authorityDocuments_Modifier;}
    public Date getAuthorityDocuments_Created() {return authorityDocuments_Created;}
    public void setAuthorityDocuments_Created(Date authorityDocuments_Created) {this.authorityDocuments_Created = authorityDocuments_Created;}
    public String getAuthorityDocuments_creator() {return authorityDocuments_creator;}
    public void setAuthorityDocuments_creator(String authorityDocuments_creator) {this.authorityDocuments_creator = authorityDocuments_creator;}
    public String getVehicle_Id() {return vehicle_Id;}
    public void setVehicle_Id(String vehicle_Id) {this.vehicle_Id = vehicle_Id;}

    
}
