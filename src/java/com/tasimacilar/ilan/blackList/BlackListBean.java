/**
 * @author  Yasin KALAYCI (yasin@supforce.com)
 * @since   01-01-2019 
 * @version 1.0.0
 */
package com.tasimacilar.ilan.blackList;



import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import com.tasimacilar.ilan.blackList.*;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;


@ManagedBean(name = "blackListBean")
@ViewScoped
public class BlackListBean implements Serializable{
    
    private String      blackList_Id;             // id   
    private String      blackList_Type;           // tipi. user, company, vehicle olabilir
    private String      blackList_TypeRelationId; // ilişkili oldugu tipin id si, userıd, companyId vb..
    private String      blackList_UserMessage;    // karalisteye girme sebebi. kullanıcıya gosterılecek mesaj
    private String      blackList_AdminNote;      // yonetici notu
    private boolean     blackList_IsActive;
    private Date        blackList_Modified;
    private String      blackList_Modifier;
    private Date        blackList_Created;    
    private String      blackList_Creator;
    
    private String      aId;
    private boolean     existUserBlackListItem;
    
    private List<BlackListBean>     blackLists;
    private List<BlackListBean>     filteredBlackLists; 
    
//------------------------------------------------------------------------------    
    /**
     * ManagedProperties
     */  
    //..........................................................................
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;

    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    //..........................................................................
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;

    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}
    //..........................................................................
    
//------------------------------------------------------------------------------    
    /**
     * PostConstruct metod. startup da çalışır.
     * 
     * {@code init();}
     */
    @PostConstruct
    public void init() { 
        
       HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       aId = req.getParameter("aId"); 
       
       try {
            
            // url deki dosya ismine göre islem yapiliyor
            String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            String urlBaseName = FilenameUtils.getBaseName(urlx.getPath());
           
            // System.out.println(FilenameUtils.getBaseName(urlx.getPath())); // -> file
            // System.out.println(FilenameUtils.getExtension(urlx.getPath())); // -> xml
            // System.out.println(FilenameUtils.getName(urlx.getPath())); // -> file.xml
     
            if(urlBaseName.equals("kullanici_detay_userBlackList") ){ 
                existUserBlackListItem = BlackListDao.isExistUserBlackListItem(aId);
                if(existUserBlackListItem){ userBlackListItemGetWithTypeRelationId(aId);}
            }
            if(urlBaseName.equals("kullanici_karaListe") ){ 
                blackListsGet();
            }
       
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }       
    }
    
//------------------------------------------------------------------------------     

    public BlackListBean() {
      
    }

//------------------------------------------------------------------------------
    
    public BlackListBean( String blackList_Id, 
                          String blackList_Type, 
                          String blackList_TypeRelationId, 
                          String blackList_UserMessage, 
                          String blackList_AdminNote, 
                          boolean blackList_IsActive, 
                          Date blackList_Modified, 
                          String blackList_Modifier, 
                          Date blackList_Created, 
                          String blackList_Creator) {
        this.blackList_Id = blackList_Id;
        this.blackList_Type = blackList_Type;
        this.blackList_TypeRelationId = blackList_TypeRelationId;
        this.blackList_UserMessage = blackList_UserMessage;
        this.blackList_AdminNote = blackList_AdminNote;
        this.blackList_IsActive = blackList_IsActive;
        this.blackList_Modified = blackList_Modified;
        this.blackList_Modifier = blackList_Modifier;
        this.blackList_Created = blackList_Created;
        this.blackList_Creator = blackList_Creator;
    }
    
//------------------------------------------------------------------------------    

    public String getBlackList_Id() {return blackList_Id;}
    public void setBlackList_Id(String blackList_Id) {this.blackList_Id = blackList_Id;}

    public String getBlackList_Type() {return blackList_Type;}
    public void setBlackList_Type(String blackList_Type) {this.blackList_Type = blackList_Type;}

    public String getBlackList_TypeRelationId() {return blackList_TypeRelationId;}
    public void setBlackList_TypeRelationId(String blackList_TypeRelationId) {this.blackList_TypeRelationId = blackList_TypeRelationId;}

    public String getBlackList_UserMessage() {return blackList_UserMessage;}
    public void setBlackList_UserMessage(String blackList_UserMessage) {this.blackList_UserMessage = blackList_UserMessage;}

    public String getBlackList_AdminNote() {return blackList_AdminNote;}
    public void setBlackList_AdminNote(String blackList_AdminNote) {this.blackList_AdminNote = blackList_AdminNote;}

    public boolean isBlackList_IsActive() {return blackList_IsActive;}
    public void setBlackList_IsActive(boolean blackList_IsActive) { this.blackList_IsActive = blackList_IsActive;}

    public Date getBlackList_Modified() {return blackList_Modified;}
    public void setBlackList_Modified(Date blackList_Modified) { this.blackList_Modified = blackList_Modified;}

    public String getBlackList_Modifier() {return blackList_Modifier;}
    public void setBlackList_Modifier(String blackList_Modifier) {this.blackList_Modifier = blackList_Modifier;}

    public Date getBlackList_Created() { return blackList_Created;}
    public void setBlackList_Created(Date blackList_Created) {this.blackList_Created = blackList_Created;}

    public String getBlackList_Creator() {return blackList_Creator;}
    public void setBlackList_Creator(String blackList_Creator) {this.blackList_Creator = blackList_Creator;}

    public String getaId() { return aId;}
    public void setaId(String aId) {this.aId = aId;}

    public boolean isExistUserBlackListItem() { return existUserBlackListItem;}
    public void setExistUserBlackListItem(boolean existUserBlackListItem) {this.existUserBlackListItem = existUserBlackListItem;}

    public List<BlackListBean> getBlackLists() {return blackLists;}
    public void setBlackLists(List<BlackListBean> blackLists) {this.blackLists = blackLists;}

    public List<BlackListBean> getFilteredBlackLists() {return filteredBlackLists;}
    public void setFilteredBlackLists(List<BlackListBean> filteredBlackLists) {this.filteredBlackLists = filteredBlackLists;}
    
//------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "BlackListBean{" + "blackList_Id=" + blackList_Id 
                                + ", blackList_Type=" + blackList_Type 
                                + ", blackList_TypeRelationId=" + blackList_TypeRelationId 
                                + ", blackList_UserMessage=" + blackList_UserMessage 
                                + ", blackList_AdminNote=" + blackList_AdminNote 
                                + ", blackList_IsActive=" + blackList_IsActive 
                                + ", blackList_Modified=" + blackList_Modified 
                                + ", blackList_Modifier=" + blackList_Modifier 
                                + ", blackList_Created=" + blackList_Created 
                                + ", blackList_Creator=" + blackList_Creator + '}';
    }

//------------------------------------------------------------------------------    
     public void createUserBlackListItem(){
    
        if(this.aId != null && !this.aId.equals("")){
            
            if(!BlackListDao.isExistUserBlackListItem(this.aId)){
                
                int sonuc = 0;
        
                BlackListBean bb = new BlackListBean();
                bb.setBlackList_Id(UniqueId.RandomString(12));
                bb.setBlackList_Type("user");
                bb.setBlackList_TypeRelationId(this.aId);
                bb.setBlackList_UserMessage(this.blackList_UserMessage);
                bb.setBlackList_AdminNote(this.blackList_AdminNote);
                bb.setBlackList_IsActive(true);
                bb.setBlackList_Modified(new Date());
                bb.setBlackList_Modifier(SessionUtil.getUserId());
                bb.setBlackList_Created(new Date());
                bb.setBlackList_Creator(SessionUtil.getUserId());

                BlackListDao bl = new BlackListDao();
                sonuc = bl.createBlackListItem(bb);

                if(sonuc == 1){
                    
                    this.existUserBlackListItem = true;
                   
                
                    //System.err.println(":::BİLGİ:::Kullanıcı kara listeye eklenmiştir.");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kullanıcı kara listeye eklenmiştir.");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                }
                else{
                    System.err.println(":::HATA:::Kullanıcıyı kara listeye ekleme sırasında sorun oluştu");
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kullanıcıyı kara listeye ekleme sırasında sorun oluştu");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    facesContext.addMessage(null, facesMessage);
                    facesContext.renderResponse();
                }  
            }
            else{
                System.err.println(":::HATA:::Kullanıcı zaten kara listede");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kullanıcı daha önceden kara listeye alınmış zaten");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            
                 
        }
        else{System.out.println(":::HATA:::Account Id null geldi.");}
    }
    
//------------------------------------------------------------------------------    

    public void userBlackListItemGetWithTypeRelationId(String typeRelationId){ 
    
        BlackListBean bb = new BlackListBean();
        
        BlackListDao bd = new BlackListDao();
        bb = bd.getBlackListItem(typeRelationId);
        
        this.blackList_Id = bb.getBlackList_Id();
        this.blackList_Type = bb.getBlackList_Type();
        this.blackList_TypeRelationId = bb.getBlackList_TypeRelationId();
        this.blackList_UserMessage = bb.getBlackList_UserMessage();
        this.blackList_AdminNote = bb.getBlackList_AdminNote();
        this.blackList_IsActive = bb.isBlackList_IsActive();
        this.blackList_Modified = bb.getBlackList_Modified();
        this.blackList_Modifier = bb.getBlackList_Modifier();
        this.blackList_Created = bb.getBlackList_Created();
        this.blackList_Creator = bb.getBlackList_Creator();
    
    }
//------------------------------------------------------------------------------  
    
    public void updateBlackListItem(){
    
        if(this.aId != null && !this.aId.equals("")){
        
            int sonuc = 0;
        
            BlackListBean bb = new BlackListBean();
            bb.setBlackList_Id(null);
            bb.setBlackList_Type(null);
            bb.setBlackList_TypeRelationId(this.aId);
            bb.setBlackList_UserMessage(this.blackList_UserMessage);
            bb.setBlackList_AdminNote(this.blackList_AdminNote);
            bb.setBlackList_IsActive(false);
            bb.setBlackList_Modified(new Date());
            bb.setBlackList_Modifier(SessionUtil.getUserId());
            bb.setBlackList_Created(new Date());
            bb.setBlackList_Creator(SessionUtil.getUserId());

            BlackListDao bl = new BlackListDao();
            sonuc = bl.updateBlackListItem(bb);
                
            if(sonuc == 1){
                //System.err.println(":::BİLGİ:::Kara liste ogesi guncellenmistir.");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kara liste öğesi guncellenmistir.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            else{
                System.err.println(":::HATA:::Kara liste öğesini guncelleme sırasında sorun oluştu");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kara liste öğesini guncelleme sırasında sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }    
            
        }
        else{System.out.println(":::HATA:::Account Id null geldi.");}
    }
    
//------------------------------------------------------------------------------    
    public void deleteBlackListItem(){
    
        if(this.aId != null && !this.aId.equals("")){
        
            int sonuc = 0;
        
            BlackListDao bl = new BlackListDao();
            sonuc = bl.deleteBlackListItem(this.aId);
                
            if(sonuc == 1){
                
                this.existUserBlackListItem = false;
                this.blackList_UserMessage = null;
                this.blackList_AdminNote = null;
                
                //System.err.println(":::BİLGİ:::Kara liste ogesi silinmistir.");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kara liste öğesi silinmistir.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            else{
                System.err.println(":::HATA:::Kara liste öğesini silme sırasında sorun oluştu");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kara liste öğesini silme sırasında sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }    
            
        }
        else{System.out.println(":::HATA:::Account Id null geldi.");}
    }
    
    
//------------------------------------------------------------------------------    
    public void deleteBlackListItem2(String aIdx){
    
        if(aIdx != null && !aIdx.equals("")){
        
            int sonuc = 0;
        
            BlackListDao bl = new BlackListDao();
            sonuc = bl.deleteBlackListItem(aIdx);
                
            if(sonuc == 1){
                
                blackListsGet();
                
                this.existUserBlackListItem = false;
                this.blackList_UserMessage = null;
                this.blackList_AdminNote = null;
                
                //System.err.println(":::BİLGİ:::Kara liste ogesi silinmistir.");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARILI","Kara liste öğesi silinmistir.");
                facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            else{
                System.err.println(":::HATA:::Kara liste öğesini silme sırasında sorun oluştu");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Kara liste öğesini silme sırasında sorun oluştu");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }    
            
        }
        else{System.out.println(":::HATA:::Account Id null geldi.");}
    }    
    
//------------------------------------------------------------------------------    
    
    public void blackListsGet(){
    
        BlackListDao bd = new BlackListDao();
        this.blackLists = bd.getBlackLists();
    
    }
    
//------------------------------------------------------------------------------    
    public boolean isExistUserBlackList(String aId){
    
        return BlackListDao.isExistUserBlackListItem(aId);
    }
//------------------------------------------------------------------------------  
     public String userBlackListItemMessage(String aId){ 

        BlackListDao bd = new BlackListDao();
        
        return bd.getBlackListItem(aId).getBlackList_UserMessage();
    }
//------------------------------------------------------------------------------  
     
}
