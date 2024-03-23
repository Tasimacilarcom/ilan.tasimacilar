package com.tasimacilar.ilan.banners;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "bannersBean")
@ViewScoped
public class BannersBean implements Serializable{
    private String      banner_Id;               
    private String      banner_Location;           
    private String      banner_Code;               
    private String      banner_Comment;             
    private boolean     banner_IsActive;           
    private Date        banner_StartViewDate;       
    private Date        banner_EndViewDate;        
    private Date        banner_Modified;            
    private String      banner_Modifier;            
    private Date        banner_Created;             
    private String      banner_creator;              

    @PostConstruct
    public void init() { 
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        try { String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
      
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("left-main-banners-settings") ){ getBannerWithLocation("main-left"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("right-main-banners-settings") ){ getBannerWithLocation("main-right"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("ust-filter-banners-settings") ){ getBannerWithLocation("filter-ust"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("orta-filter-banners-settings") ){ getBannerWithLocation("filter-orta"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("alt-filter-banners-settings") ){ getBannerWithLocation("filter-alt"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-ust-banners-settings") ){ getBannerWithLocation("list-ust"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("ad-banners-settings") ){ getBannerWithLocation("ad"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("ust-tam-banners-settings") ){ getBannerWithLocation("ust-tam"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("ust-yarim-banners-settings") ){ getBannerWithLocation("ust-yarim"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-banners-settings-1") ){ getBannerWithLocation("list-rek1"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-banners-settings-2") ){ getBannerWithLocation("list-rek2"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-banners-settings-3") ){ getBannerWithLocation("list-rek3"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-banners-settings-4") ){ getBannerWithLocation("list-rek4"); }
            else if(FilenameUtils.getBaseName(urlx.getPath()).equals("list-banners-settings-5") ){ getBannerWithLocation("list-rek5"); }
            else {
            }
            
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }     
        
    } public BannersBean() {    }
    public BannersBean( String banner_Id, String banner_Location, String banner_Code, 
                        String banner_Comment, boolean banner_IsActive, Date banner_StartViewDate, 
                        Date banner_EndViewDate, Date banner_Modified, String banner_Modifier, 
                        Date banner_Created, String banner_creator) {
        this.banner_Id = banner_Id;
        this.banner_Location = banner_Location;
        this.banner_Code = banner_Code;
        this.banner_Comment = banner_Comment;
        this.banner_IsActive = banner_IsActive;
        this.banner_StartViewDate = banner_StartViewDate;
        this.banner_EndViewDate = banner_EndViewDate;
        this.banner_Modified = banner_Modified;
        this.banner_Modifier = banner_Modifier;
        this.banner_Created = banner_Created;
        this.banner_creator = banner_creator;
    }
 public String getBanner_Id() {return banner_Id;}
    public void setBanner_Id(String banner_Id) {this.banner_Id = banner_Id;}
    public String getBanner_Location() {return banner_Location;}
    public void setBanner_Location(String banner_Location) {this.banner_Location = banner_Location;}
    public String getBanner_Code() {return banner_Code;}
    public void setBanner_Code(String banner_Code) {this.banner_Code = banner_Code;}
    public String getBanner_Comment() {return banner_Comment;}
    public void setBanner_Comment(String banner_Comment) {this.banner_Comment = banner_Comment;}
    public boolean isBanner_IsActive() {return banner_IsActive;}
    public void setBanner_IsActive(boolean banner_IsActive) {this.banner_IsActive = banner_IsActive;}
    public Date getBanner_StartViewDate() {return banner_StartViewDate;}
    public void setBanner_StartViewDate(Date banner_StartViewDate) {this.banner_StartViewDate = banner_StartViewDate;}
    public Date getBanner_EndViewDate() {return banner_EndViewDate;}
    public void setBanner_EndViewDate(Date banner_EndViewDate) {this.banner_EndViewDate = banner_EndViewDate;}
    public Date getBanner_Modified() {return banner_Modified;}
    public void setBanner_Modified(Date banner_Modified) {this.banner_Modified = banner_Modified;}
    public String getBanner_Modifier() {return banner_Modifier;}
    public void setBanner_Modifier(String banner_Modifier) {this.banner_Modifier = banner_Modifier;}
    public Date getBanner_Created() {return banner_Created;}
    public void setBanner_Created(Date banner_Created) {this.banner_Created = banner_Created;}
    public String getBanner_creator() {return banner_creator;}
    public void setBanner_creator(String banner_creator) {this.banner_creator = banner_creator;}
@Override
    public String toString() {
        return "BannersBean{" + "banner_Id=" + banner_Id + 
                            ", banner_Location=" + banner_Location + 
                            ", banner_Code=" + banner_Code + 
                            ", banner_Comment=" + banner_Comment + 
                            ", banner_IsActive=" + banner_IsActive + 
                            ", banner_StartViewDate=" + banner_StartViewDate + 
                            ", banner_EndViewDate=" + banner_EndViewDate + 
                            ", banner_Modified=" + banner_Modified + 
                            ", banner_Modifier=" + banner_Modifier + 
                            ", banner_Created=" + banner_Created + 
                            ", banner_creator=" + banner_creator + '}';
    }

    public void createBanner(String location) {
        
        int sonuc = 0;
        String logedUser = SessionUtil.getUserId();
    
        BannersBean b = new BannersBean();
        b.setBanner_Id(UniqueId.RandomString(12));
        b.setBanner_Location(location);            
        b.setBanner_Code(this.banner_Code);               
        b.setBanner_Comment(this.banner_Comment);           
        b.setBanner_IsActive(true);          
        b.setBanner_StartViewDate(null);     
        b.setBanner_EndViewDate(null);        
        b.setBanner_Modified(new Date());           
        b.setBanner_Modifier(logedUser);          
        b.setBanner_Created(new Date());           
        b.setBanner_creator(logedUser);     
        
        BannersDao bd = new BannersDao();
        sonuc = bd.createBanner(b);
        
        if(sonuc == 1){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            System.out.println(":::BİLGİ:::Yani banner eklenmiştir");    
            FacesMessage facesMessage = new FacesMessage("BAŞARILI",  "Yani banner eklenmiştir");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            System.err.println(":::HATA:::Yani banner eklemede sorun oluştu");    
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ",  "Yani banner ekleme sırasında sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    }
    public void updateBanner(String location) {
        
        int sonuc = 0;
        String logedUser = SessionUtil.getUserId();
    
        BannersBean b = new BannersBean();
        b.setBanner_Id(this.banner_Id);
        b.setBanner_Location(location);            
        b.setBanner_Code(this.banner_Code);               
        b.setBanner_Comment(this.banner_Comment);           
        b.setBanner_IsActive(this.isBanner_IsActive());          
        b.setBanner_StartViewDate(null);     
        b.setBanner_EndViewDate(null);        
        b.setBanner_Modified(new Date());           
        b.setBanner_Modifier(logedUser);          
        b.setBanner_Created(new Date());           
        b.setBanner_creator(logedUser);     
        
        BannersDao bd = new BannersDao();
        sonuc = bd.updateBanner(b);
        
        if(sonuc == 1){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            System.out.println(":::BİLGİ:::Banner güncellenmiştir");    
            FacesMessage facesMessage = new FacesMessage("BAŞARILI",  "Banner güncellenmiştir");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            System.err.println(":::HATA:::Banner güncellemede sorun oluştu");    
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ",  "Banner güncelleme sırasında sorun oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    } public String getBannerCodeWithLocation(String location){
        
        String returnx = "";
        BannersDao bd = new BannersDao();
        
        if(bd.getBannerWithLocation(location).isBanner_IsActive()){ 
            returnx = bd.getBannerWithLocation(location).getBanner_Code();
        }
            
        return returnx;
    } public void getBannerWithLocation(String location){System.out.println("*****"+location);
        
        BannersBean b = new BannersBean();
        BannersDao bd = new BannersDao(); 
        b = bd.getBannerWithLocation(location);
        this.banner_Id = b.getBanner_Id();
        this.banner_Location = b.getBanner_Location();
        this.banner_Code = b.getBanner_Code();
        this.banner_Comment = b.getBanner_Comment();
        this.banner_IsActive = b.isBanner_IsActive();
        this.banner_StartViewDate = b.getBanner_StartViewDate();
        this.banner_EndViewDate = b.getBanner_EndViewDate();
        this.banner_Modified = b.getBanner_Modified();
        this.banner_Modifier = b.getBanner_Modifier();
        this.banner_Created = b.getBanner_Created();
        this.banner_creator = b.getBanner_creator();
       
    }
    
    
    
    
}
