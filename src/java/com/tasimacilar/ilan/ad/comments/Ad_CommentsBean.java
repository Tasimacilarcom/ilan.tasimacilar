package com.tasimacilar.ilan.ad.comments;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
@ManagedBean(name = "AdCommentsBean")
@ViewScoped
public class Ad_CommentsBean implements Serializable{
    private String      AdComment_Id;                  
    private String      AdComment_Comment;             
    private String      AdComment_Type;                
    private String      AdComment_ItemId;              
    private String      AdComment_OvnerAccountId;      
    private boolean     AdComment_IsActive;            
    private boolean     AdComment_IsPublish;          
    private Date        AdComment_Modified;            
    private String      AdComment_Modifier;           
    private Date        AdComment_Created;            
    private String      AdComment_Creator;            
    private List<Ad_CommentsBean> commentsList;
    private List<Ad_CommentsBean> filteredCommentsList;
    private List<Ad_CommentsBean> commentsList2;
    private List<Ad_CommentsBean> filteredCommentsList2;
    private String selectedAdCommentId;
    private String selectedAdCommentComment; 
    private List<Ad_CommentsBean> userCommentsList;
    private List<Ad_CommentsBean> userFilteredCommentsList;
    private String aId;
    @ManagedProperty(value="#{adBean}")
     Ad_Bean adBean;
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;} 
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}
    @PostConstruct
    public void init() {     
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        aId = req.getParameter("aId"); 
        
        try {  String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
           if(FilenameUtils.getBaseName(urlx.getPath()).equals("onay_bekleyen_yorumlar") ){   allCommentListGet();  }
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("yorum_yonetimi") ){   allCommentListGet2();  }
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_userComments") ){  userCommentListGet(this.aId);  }           
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); } 
    }
public Ad_CommentsBean() {  }
public Ad_CommentsBean( String AdComments_Id, 
                            String AdComments_Comment, 
                            String AdComments_Type, 
                            String AdComments_ItemId, 
                            String AdComments_OvnerAccountId, 
                            boolean AdComments_IsActive, 
                            Date AdComments_Modified, 
                            String AdComments_Modifier, 
                            Date AdComments_Created, 
                            String AdComments_Creator, 
                            Ad_Bean adBean) {
        this.AdComment_Id = AdComments_Id;
        this.AdComment_Comment = AdComments_Comment;
        this.AdComment_Type = AdComments_Type;
        this.AdComment_ItemId = AdComments_ItemId;
        this.AdComment_OvnerAccountId = AdComments_OvnerAccountId;
        this.AdComment_IsActive = AdComments_IsActive;
        this.AdComment_Modified = AdComments_Modified;
        this.AdComment_Modifier = AdComments_Modifier;
        this.AdComment_Created = AdComments_Created;
        this.AdComment_Creator = AdComments_Creator;
        this.adBean = adBean;
    }
public String getAdComment_Id() { return AdComment_Id;}
    public void setAdComment_Id(String AdComment_Id) {this.AdComment_Id = AdComment_Id;}
    public String getAdComment_Comment() { return AdComment_Comment;}
    public void setAdComment_Comment(String AdComment_Comment) { this.AdComment_Comment = AdComment_Comment;}
    public String getAdComment_Type() { return AdComment_Type;}
    public void setAdComment_Type(String AdComment_Type) {this.AdComment_Type = AdComment_Type;}
    public String getAdComment_ItemId() {return AdComment_ItemId;}
    public void setAdComment_ItemId(String AdComment_ItemId) { this.AdComment_ItemId = AdComment_ItemId;}
    public String getAdComment_OvnerAccountId() {return AdComment_OvnerAccountId;}
    public void setAdComment_OvnerAccountId(String AdComment_OvnerAccountId) {this.AdComment_OvnerAccountId = AdComment_OvnerAccountId;}
    public boolean isAdComment_IsActive() { return AdComment_IsActive;}
    public void setAdComment_IsActive(boolean AdComment_IsActive) { this.AdComment_IsActive = AdComment_IsActive;}
    public boolean isAdComment_IsPublish() { return AdComment_IsPublish;}
    public void setAdComment_IsPublish(boolean AdComment_IsPublish) { this.AdComment_IsPublish = AdComment_IsPublish;} 
    public Date getAdComment_Modified() { return AdComment_Modified;}
    public void setAdComment_Modified(Date AdComment_Modified) { this.AdComment_Modified = AdComment_Modified;}
    public String getAdComment_Modifier() { return AdComment_Modifier;}
    public void setAdComment_Modifier(String AdComment_Modifier) {this.AdComment_Modifier = AdComment_Modifier;}
    public Date getAdComment_Created() {return AdComment_Created;}
    public void setAdComment_Created(Date AdComment_Created) { this.AdComment_Created = AdComment_Created;}
    public String getAdComment_Creator() {return AdComment_Creator;}
    public void setAdComment_Creator(String AdComment_Creator) { this.AdComment_Creator = AdComment_Creator;}
    public List<Ad_CommentsBean> getCommentsList() { return commentsList;}
    public void setCommentsList(List<Ad_CommentsBean> commentsList) {this.commentsList = commentsList;}
    public List<Ad_CommentsBean> getFilteredCommentsList() {return filteredCommentsList;}
    public void setFilteredCommentsList(List<Ad_CommentsBean> filteredCommentsList) {this.filteredCommentsList = filteredCommentsList;}
    public List<Ad_CommentsBean> getCommentsList2() { return commentsList2;}
    public void setCommentsList2(List<Ad_CommentsBean> commentsList2) { this.commentsList2 = commentsList2;}
    public List<Ad_CommentsBean> getFilteredCommentsList2() {return filteredCommentsList2;}
    public void setFilteredCommentsList2(List<Ad_CommentsBean> filteredCommentsList2) { this.filteredCommentsList2 = filteredCommentsList2;}
    public String getSelectedAdCommentId() {return selectedAdCommentId;}
    public void setSelectedAdCommentId(String selectedAdCommentId) { this.selectedAdCommentId = selectedAdCommentId;}
    public String getSelectedAdCommentComment() { return selectedAdCommentComment;}
    public void setSelectedAdCommentComment(String selectedAdCommentComment) { this.selectedAdCommentComment = selectedAdCommentComment;}
    public List<Ad_CommentsBean> getUserCommentsList() {return userCommentsList;}
    public void setUserCommentsList(List<Ad_CommentsBean> userCommentsList) {this.userCommentsList = userCommentsList;}
    public List<Ad_CommentsBean> getUserFilteredCommentsList() {return userFilteredCommentsList;}
    public void setUserFilteredCommentsList(List<Ad_CommentsBean> userFilteredCommentsList) {this.userFilteredCommentsList = userFilteredCommentsList;}
    @Override
    public String toString() {
        return "Ad_CommentsBean{"   + "AdComment_Id=" + AdComment_Id 
                                    + ", AdComment_Comment=" + AdComment_Comment 
                                    + ", AdComment_Type=" + AdComment_Type 
                                    + ", AdComment_ItemId=" + AdComment_ItemId 
                                    + ", AdComment_OvnerAccountId=" + AdComment_OvnerAccountId 
                                    + ", AdComment_IsActive=" + AdComment_IsActive 
                                    + ", AdComment_IsPublish=" + AdComment_IsPublish 
                                    + ", AdComment_Modified=" + AdComment_Modified 
                                    + ", AdComment_Modifier=" + AdComment_Modifier 
                                    + ", AdComment_Created=" + AdComment_Created 
                                    + ", AdComment_Creator=" + AdComment_Creator 
                                    + ", adBean=" + adBean + '}';
    }
 public int createAdComment(String adId, String commentx){  
        int sonuc = 0;     
        Ad_CommentsBean adc = new Ad_CommentsBean();
        adc.setAdComment_Id(UniqueId.RandomString(12)+UniqueId.RandomString(12));
        adc.setAdComment_Comment(commentx);
        adc.setAdComment_Type("ilan");
        adc.setAdComment_ItemId(adId);
        adc.setAdComment_OvnerAccountId(SessionUtil.getUserId());
        adc.setAdComment_IsActive(true);
        adc.setAdComment_IsPublish(false);
        adc.setAdComment_Modified(new Date());
        adc.setAdComment_Modifier(SessionUtil.getUserId());
        adc.setAdComment_Created(new Date());
        adc.setAdComment_Creator(SessionUtil.getUserId());       
        Ad_CommentsDao add = new Ad_CommentsDao();
        sonuc = add.createAdComment(adc);
        
        if(sonuc == 1){FacesContext facesContext5 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage5 = new FacesMessage("BAŞARILI","Yorumunuz kaydedilmiştir, incelendikten sonra yayınlanacaktır.");
            facesMessage5.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext5.addMessage(null, facesMessage5);
            facesContext5.renderResponse();
        }else{
            System.out.println(":::BİLGİ:::Yorum ekleme sırasında sorun oluştu");
            FacesContext facesContext5 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage5 = new FacesMessage("BAŞARISIZ","Yorumunuzu kaydederken bir sorun oluştu");
            facesMessage5.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext5.addMessage(null, facesMessage5);
            facesContext5.renderResponse();
        } return sonuc;
    }
public void allCommentListGet(){
        Ad_CommentsDao ad = new Ad_CommentsDao();
        this.commentsList = ad.getAllComment(); 
    }
 public void allCommentListGet2(){
        Ad_CommentsDao ad = new Ad_CommentsDao();
        this.commentsList2 = ad.getAllComment2(); 
    }
public void userCommentListGet(String onverId){
        Ad_CommentsDao ad = new Ad_CommentsDao();
        this.userCommentsList = ad.getAllComment3(onverId); 
    }    
public void enableDisablePublishAdComment(String param, String cId){
        int sonuc = 0;  
        Ad_CommentsDao a = new Ad_CommentsDao();
        sonuc = a.enableDisablePublishAdComment(param, cId); 
        if(sonuc == 1){
            allCommentListGet();
            allCommentListGet2();
            userCommentListGet(this.aId);
            FacesContext facesContext5 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage5 = new FacesMessage("BAŞARILI","Yorum güncellenmiştir");
            facesMessage5.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext5.addMessage(null, facesMessage5);
            facesContext5.renderResponse();
        } else{
            System.err.println(":::HATA:::Yorum güncelleme sırasında sorun oluşmuştur");
            FacesContext facesContext5 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage5 = new FacesMessage("BAŞARISIZ","Yorum güncelleme sırasında sorun oluştu");
            facesMessage5.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext5.addMessage(null, facesMessage5);
            facesContext5.renderResponse();
        }
    }
public void selectedAdCommentIdSet(String cId){   
        this.selectedAdCommentId= cId;  
        Ad_CommentsDao ad = new Ad_CommentsDao();
        this.selectedAdCommentComment= ad.getCommentWithId(cId).getAdComment_Comment(); 
    }
public void updateAdComment (){
    int sonuc = 0;
    Ad_CommentsDao a = new Ad_CommentsDao();
    sonuc = a.updateAdComment(this.selectedAdCommentComment, this.selectedAdCommentId);
    if(sonuc == 1){
        allCommentListGet();
        allCommentListGet2();
        userCommentListGet(this.aId);
        FacesContext facesContext5 = FacesContext.getCurrentInstance();
        FacesMessage facesMessage5 = new FacesMessage("BAŞARILI","Yorum güncellenmiştir");
        facesMessage5.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext5.addMessage(null, facesMessage5);
        facesContext5.renderResponse();
    }  else{
        System.err.println(":::HATA:::Yorum güncelleme sırasında sorun oluşmuştur");
        FacesContext facesContext5 = FacesContext.getCurrentInstance();
        FacesMessage facesMessage5 = new FacesMessage("BAŞARISIZ","Yorum güncelleme sırasında sorun oluştu");
        facesMessage5.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext5.addMessage(null, facesMessage5);
        facesContext5.renderResponse();
    }}}
