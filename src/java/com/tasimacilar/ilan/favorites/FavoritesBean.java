package com.tasimacilar.ilan.favorites;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name = "favoritesBean")
@ViewScoped
public class FavoritesBean implements Serializable{
    private String      favorites_Id;
    private String      favorites_Type;              
    private String      favorites_ItemId;          
    private String      favorites_ListName;         
    private String      favorites_OvnerAccountId;   
    private boolean     favorites_IsActive;
    private String      favorites_Commnet;
    private Date        favorites_Modified;
    private String      favorites_Modifier;
    private Date        favorites_Created;    
    private String      favorites_Creator;   
    private List<FavoritesBean> favoritesList = new ArrayList<FavoritesBean>();
    @ManagedProperty(value="#{adBean}")
     Ad_Bean adBean;
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}
    @PostConstruct
    public void init() {  favoriteListGet();  }
    public FavoritesBean() {  }
    public FavoritesBean(String favorites_Id, String favorites_Type, String favorites_ItemId, String favorites_ListName, String favorites_OvnerAccountId, boolean favorites_IsActive, String favorites_Commnet, Date favorites_Modified, String favorites_Modifier, Date favorites_Created, String favorites_Creator) {
        this.favorites_Id = favorites_Id;
        this.favorites_Type = favorites_Type;
        this.favorites_ItemId = favorites_ItemId;
        this.favorites_ListName = favorites_ListName;
        this.favorites_OvnerAccountId = favorites_OvnerAccountId;
        this.favorites_IsActive = favorites_IsActive;
        this.favorites_Commnet = favorites_Commnet;
        this.favorites_Modified = favorites_Modified;
        this.favorites_Modifier = favorites_Modifier;
        this.favorites_Created = favorites_Created;
        this.favorites_Creator = favorites_Creator;
    }
public String getFavorites_Id() {return favorites_Id;}
    public void setFavorites_Id(String favorites_Id) {this.favorites_Id = favorites_Id;}
    public String getFavorites_Type() {return favorites_Type;}
    public void setFavorites_Type(String favorites_Type) {this.favorites_Type = favorites_Type;}
    public String getFavorites_ItemId() {return favorites_ItemId;}
    public void setFavorites_ItemId(String favorites_ItemId) {this.favorites_ItemId = favorites_ItemId;}
    public String getFavorites_ListName() {return favorites_ListName;}
    public void setFavorites_ListName(String favorites_ListName) {this.favorites_ListName = favorites_ListName;}
    public String getFavorites_OvnerAccountId() {return favorites_OvnerAccountId;}
    public void setFavorites_OvnerAccountId(String favorites_OvnerAccountId) {this.favorites_OvnerAccountId = favorites_OvnerAccountId;}
    public boolean isFavorites_IsActive() { return favorites_IsActive;}
    public void setFavorites_IsActive(boolean favorites_IsActive) {this.favorites_IsActive = favorites_IsActive;}
    public String getFavorites_Commnet() { return favorites_Commnet;}
    public void setFavorites_Commnet(String favorites_Commnet) { this.favorites_Commnet = favorites_Commnet;}
    public Date getFavorites_Modified() {return favorites_Modified;}
    public void setFavorites_Modified(Date favorites_Modified) {this.favorites_Modified = favorites_Modified;}
    public String getFavorites_Modifier() {return favorites_Modifier;}
    public void setFavorites_Modifier(String favorites_Modifier) {this.favorites_Modifier = favorites_Modifier;}
    public Date getFavorites_Created() {return favorites_Created;}
    public void setFavorites_Created(Date favorites_Created) {this.favorites_Created = favorites_Created;}
    public String getFavorites_Creator() { return favorites_Creator;}
    public void setFavorites_Creator(String favorites_Creator) { this.favorites_Creator = favorites_Creator;}
    public List<FavoritesBean> getFavoritesList() { return favoritesList;}
    public void setFavoritesList(List<FavoritesBean> favoritesList) {this.favoritesList = favoritesList;}
    public void createFavoritesAd(String adId){
        int sonuc = 0; String logedUser = SessionUtil.getUserId(); boolean isExistFavorites;
        FavoritesDao fdx = new FavoritesDao();
        isExistFavorites = fdx.isExistFavorites(adId, logedUser);
         if(isExistFavorites){
            System.err.println(":::HATA:::İlan favori listesine eklenmiş zaten..");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ",  "Bu ilan daha önceden favori listenize eklenmiş zaten..");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        } else{ FavoritesBean f = new FavoritesBean();
            f.setFavorites_Id(UniqueId.RandomString(12));
            f.setFavorites_Type("ilan");
            f.setFavorites_ItemId(adId);
            f.setFavorites_ListName("default");
            f.setFavorites_OvnerAccountId(logedUser);
            f.setFavorites_IsActive(true);
            f.setFavorites_Commnet(null);
            f.setFavorites_Modified(new Date());
            f.setFavorites_Modifier(logedUser);
            f.setFavorites_Created(new Date());
            f.setFavorites_Creator(logedUser);
 FavoritesDao fd = new FavoritesDao();
            sonuc = fd.createFavorites(f);if(sonuc == 1){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI",  "İlan favori listenize eklenmiştir");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }else {System.err.println(":::HATA:::İlanı favori listesine ekleme sırasında sorun oluştu.");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ",  "İlanınızı favori listenize ekleme sırasında sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
        }   
    } public void favoriteListGet(){     
        FavoritesDao fd = new FavoritesDao();
        this.favoritesList = fd.getAllFavoritesWithOvnerAccountId(SessionUtil.getUserId()); }
public void deleteFavoriteAd(String fId){ int sonuc = 0; FavoritesDao fd = new FavoritesDao();
        sonuc = fd.deleteFavorites(fId);if(sonuc == 1){
            favoriteListGet();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI",  "İlan favori listenizden silinmiştir");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse(); 
        }  else{ System.err.println(":::HATA:::İlanın favori listesinden silinirken sorun olustu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ",  "İlanın favori listesinden silinirken sorun olustu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();}
    }
    
    
    
    
}
