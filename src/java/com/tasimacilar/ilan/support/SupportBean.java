package com.tasimacilar.ilan.support;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.system.Messages;
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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.CloseEvent;
@ManagedBean(name = "supportBean")
@ViewScoped
public class SupportBean implements Serializable{
    private String      support_Id;                 
    private String      support_GroupId;            
    private String      support_comment;          
    private String      support_Subject;           
    private String      support_FromUserId;      
    private String      support_ToUserId;           
    private String      support_Priority;          
    private String      support_Status;           
    private boolean     support_IsActive;          
    private Date        support_Modified;         
    private String      support_Modifier;         
    private Date        support_Created;          
    private String      support_creator;          
    private Date        support_answeredTime;     
    private String      support_answeredUser;      
    private String      support_answer;         
    private List<SupportBean> fromUserSupMessages = new ArrayList<SupportBean>();
    private List<SupportBean> filteredFromUserSupMessages ;
    private String      support_FromUserName;      
    private String      support_ToUserName;         
    private String      support_answeredUserName;    
    private List<SupportBean> fromUserSupMessagesForAdmin = new ArrayList<SupportBean>();
    private List<SupportBean> filteredFromUserSupMessagesForAdmin ;  
    private String      account_MobilePhoneNumber;     
    private String      account_Name;   
    private String      account_Id;  
    private boolean     fromAdmin;
    private SupportBean sx =null;
    private String      iletisimForm_Ad;
    private String      iletisimForm_Email;
    private String      iletisimForm_Telefon;
    private String      iletisimForm_Mesaj;
    @PostConstruct
    public void init() {       
        if(SessionUtil.getUserId() != null){ AccountBean.updateUserSupportNotification(false, SessionUtil.getUserId()); } 
        String sId;
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        sId = req.getParameter("sId");   
        
        try { String url = req.getRequestURL().toString();
            URL urlx = new URL(url);if(FilenameUtils.getBaseName(urlx.getPath()).equals("support") ){             
                getAllMessagesWithFromUserId();
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("support_questionAndAnswer") ){             
                if(sId != null && !sId.equals("")){ getMessagesWithSupportId(sId);  } 
            }   if(FilenameUtils.getBaseName(urlx.getPath()).equals("destek_kayitlari_yonetimi") ){             
                getAllMessages();
            }   if(FilenameUtils.getBaseName(urlx.getPath()).equals("yeni_destek_kaydi_ekle") ){             
                 fromAdmin =true; 
            } 
        } catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }  
        
        
    }      public SupportBean() {  } public SupportBean( String support_Id, 
                        String support_GroupId, 
                        String support_comment, 
                        String support_Subject, 
                        String support_FromUserId, 
                        String support_ToUserId, 
                        String support_Priority, 
                        String support_Status, 
                        boolean support_IsActive, 
                        Date support_Modified, 
                        String support_Modifier, 
                        Date support_Created, 
                        String support_creator) {
        this.support_Id = support_Id;
        this.support_GroupId = support_GroupId;
        this.support_comment = support_comment;
        this.support_Subject = support_Subject;
        this.support_FromUserId = support_FromUserId;
        this.support_ToUserId = support_ToUserId;
        this.support_Priority = support_Priority;
        this.support_Status = support_Status;
        this.support_IsActive = support_IsActive;
        this.support_Modified = support_Modified;
        this.support_Modifier = support_Modifier;
        this.support_Created = support_Created;
        this.support_creator = support_creator;
    }
    
public String getSupport_Id() {return support_Id;}
    public void setSupport_Id(String support_Id) {this.support_Id = support_Id;}
    public String getSupport_GroupId() {return support_GroupId;}
    public void setSupport_GroupId(String support_GroupId) { this.support_GroupId = support_GroupId;}
    public String getSupport_comment() { return support_comment;}
    public void setSupport_comment(String support_comment) { this.support_comment = support_comment;}
    public String getSupport_Subject() {return support_Subject;}
    public void setSupport_Subject(String support_Subject) {this.support_Subject = support_Subject;}
    public String getSupport_FromUserId() {return support_FromUserId;}
    public void setSupport_FromUserId(String support_FromUserId) {this.support_FromUserId = support_FromUserId;}
    public String getSupport_ToUserId() {return support_ToUserId;}
    public void setSupport_ToUserId(String support_ToUserId) { this.support_ToUserId = support_ToUserId;}
    public String getSupport_Priority() {return support_Priority;}
    public void setSupport_Priority(String support_Priority) {this.support_Priority = support_Priority;}
    public String getSupport_Status() {return support_Status;}
    public void setSupport_Status(String support_Status) {this.support_Status = support_Status;}
    public boolean isSupport_IsActive() {return support_IsActive;}
    public void setSupport_IsActive(boolean support_IsActive) {this.support_IsActive = support_IsActive;}
    public Date getSupport_Modified() {return support_Modified;}
    public void setSupport_Modified(Date support_Modified) {this.support_Modified = support_Modified;}
    public String getSupport_Modifier() {return support_Modifier;}
    public void setSupport_Modifier(String support_Modifier) {this.support_Modifier = support_Modifier;}
    public Date getSupport_Created() {return support_Created;}
    public void setSupport_Created(Date support_Created) {this.support_Created = support_Created;}
    public String getSupport_creator() {return support_creator;}
    public void setSupport_creator(String support_creator) { this.support_creator = support_creator;}
    public Date getSupport_answeredTime() {return support_answeredTime;}
    public void setSupport_answeredTime(Date support_answeredTime) { this.support_answeredTime = support_answeredTime;}
    public String getSupport_answeredUser() {return support_answeredUser;}
    public void setSupport_answeredUser(String support_answeredUser) { this.support_answeredUser = support_answeredUser;}
    public String getSupport_answer() {return support_answer;}
    public void setSupport_answer(String support_answer) {this.support_answer = support_answer;}   
    public List<SupportBean> getFromUserSupMessages() { return fromUserSupMessages;}
    public void setFromUserSupMessages(List<SupportBean> fromUserSupMessages) {this.fromUserSupMessages = fromUserSupMessages;}
    public List<SupportBean> getFilteredFromUserSupMessages() { return filteredFromUserSupMessages;}
    public void setFilteredFromUserSupMessages(List<SupportBean> filteredFromUserSupMessages) { this.filteredFromUserSupMessages = filteredFromUserSupMessages;}
    public String getSupport_FromUserName() { return support_FromUserName;}
    public void setSupport_FromUserName(String support_FromUserName) { this.support_FromUserName = support_FromUserName;}
    public String getSupport_ToUserName() { return support_ToUserName;}
    public void setSupport_ToUserName(String support_ToUserName) {this.support_ToUserName = support_ToUserName;}
    public String getSupport_answeredUserName() {return support_answeredUserName;}
    public void setSupport_answeredUserName(String support_answeredUserName) { this.support_answeredUserName = support_answeredUserName;}
    public List<SupportBean> getFromUserSupMessagesForAdmin() { return fromUserSupMessagesForAdmin;}
    public void setFromUserSupMessagesForAdmin(List<SupportBean> fromUserSupMessagesForAdmin) { this.fromUserSupMessagesForAdmin = fromUserSupMessagesForAdmin;}
    public List<SupportBean> getFilteredFromUserSupMessagesForAdmin() { return filteredFromUserSupMessagesForAdmin;}
    public void setFilteredFromUserSupMessagesForAdmin(List<SupportBean> filteredFromUserSupMessagesForAdmin) { this.filteredFromUserSupMessagesForAdmin = filteredFromUserSupMessagesForAdmin;}
    public String getAccount_MobilePhoneNumber() {return account_MobilePhoneNumber;}
    public void setAccount_MobilePhoneNumber(String account_MobilePhoneNumber) {this.account_MobilePhoneNumber = account_MobilePhoneNumber;}
    public String getAccount_Name() { return account_Name;}
    public void setAccount_Name(String account_Name) { this.account_Name = account_Name;}
    public String getAccount_Id() { return account_Id;}
    public void setAccount_Id(String account_Id) {this.account_Id = account_Id;}  
    public SupportBean getSx() { return sx;}
    public void setSx(SupportBean sx) { this.sx = sx;}
   public String getIletisimForm_Ad() {return iletisimForm_Ad;}
    public void setIletisimForm_Ad(String iletisimForm_Ad) {this.iletisimForm_Ad = iletisimForm_Ad;}
    public String getIletisimForm_Email() {return iletisimForm_Email;}
    public void setIletisimForm_Email(String iletisimForm_Email) {this.iletisimForm_Email = iletisimForm_Email;}
    public String getIletisimForm_Telefon() {return iletisimForm_Telefon;}
    public void setIletisimForm_Telefon(String iletisimForm_Telefon) {this.iletisimForm_Telefon = iletisimForm_Telefon;}
    public String getIletisimForm_Mesaj() {return iletisimForm_Mesaj;}
    public void setIletisimForm_Mesaj(String iletisimForm_Mesaj) { this.iletisimForm_Mesaj = iletisimForm_Mesaj;}
     public void createSupportMessage(){
       int sonuc = 0;
        String supportId = UniqueId.RandomString(12);
        String GroupId = UniqueId.RandomString(12);
        
        SupportBean sb = new SupportBean();
        sb.setSupport_Id(supportId);
        sb.setSupport_GroupId(GroupId);
        sb.setSupport_comment(this.support_comment);
        sb.setSupport_Subject(this.support_Subject);
        
        if(fromAdmin){ sb.setSupport_FromUserId(account_Id);          }
        else{ sb.setSupport_FromUserId(SessionUtil.getUserId());}
        
        sb.setSupport_ToUserId(null);
        sb.setSupport_Priority(this.support_Priority);
        sb.setSupport_Status("Cevap Bekliyor");
        sb.setSupport_IsActive(true);
        sb.setSupport_Modified(new Date());
        sb.setSupport_Modifier(SessionUtil.getUserId());
        sb.setSupport_Created(new Date());
        sb.setSupport_creator(SessionUtil.getUserId());
        sb.setSupport_answeredTime(null);
        sb.setSupport_answeredUser(null);
        
        
        SupportDao sd = new SupportDao();
        sonuc = sd.createSupportMessage(sb);
        
        if(sonuc == 1){ 
            getAllMessagesWithFromUserId();
            Messages.dynMsg(null, "info", "Destek kaydınız BAŞARILI birşekilde oluşturuldu.");
            
            this.support_comment = null;
            this.support_Subject = null;
            this.support_Priority = null;
        }
        else{Messages.dynMsg(null, "error", "Destek kaydı oluşturma sırasında sorun oluştu."); }
    }  public void createSupportMessage2(){
        
        int sonuc = 0;
        String supportId = UniqueId.RandomString(12);
        String GroupId = UniqueId.RandomString(12);
        
        SupportBean sb = new SupportBean();
        sb.setSupport_Id(supportId);
        sb.setSupport_GroupId(GroupId);
        
        String msg = "<B>KİMDEN :</B>"+this.iletisimForm_Ad+" ("+this.iletisimForm_Email+" - "+this.iletisimForm_Telefon+")  <br/> "
                   + "<B>MESAJ :</B>"+this.iletisimForm_Mesaj;
        
        sb.setSupport_comment(msg);
        sb.setSupport_Subject("İletişim Formu Mesajı");
        
        if(fromAdmin){ sb.setSupport_FromUserId(account_Id);          }
        else{ sb.setSupport_FromUserId(SessionUtil.getUserId());}
        
        sb.setSupport_ToUserId(null);
        sb.setSupport_Priority("Normal");
        sb.setSupport_Status("Cevap Bekliyor");
        sb.setSupport_IsActive(true);
        sb.setSupport_Modified(new Date());
        sb.setSupport_Modifier("");
        sb.setSupport_Created(new Date());
        sb.setSupport_creator("");
        sb.setSupport_answeredTime(null);
        sb.setSupport_answeredUser(null);
        
        
        SupportDao sd = new SupportDao();
        sonuc = sd.createSupportMessage(sb);
        
        if(sonuc == 1){
            Messages.dynMsg(null, "info", "Mesajınız iletilmiştir.");
            this.iletisimForm_Ad = null;
            this.iletisimForm_Email = null;
            this.iletisimForm_Telefon = null;
            this.iletisimForm_Mesaj = null;
        }
        else{Messages.dynMsg(null, "error", "Destek kaydı oluşturma sırasında sorun oluştu."); }
    }public void getAllMessagesWithFromUserId(){
        
        if(SessionUtil.getUserId() != null){
            SupportDao sd = new SupportDao();
            this.fromUserSupMessages.clear();
            this.fromUserSupMessages = sd.getAllMessagesWithFromUserId(SessionUtil.getUserId());
        }
        else {System.err.println(":::HATA:::Loged userId Null geldi..");}
        
    }public void getMessagesWithSupportId(String sId){
       
        if(sId != null && !sId.equals("")){
            SupportBean s = new SupportBean();
            SupportDao sd = new SupportDao();
            s = sd.getMessagesWithSupportId(sId);
            
            this.support_Id = s.getSupport_Id();
            this.support_GroupId = s.getSupport_GroupId();
            this.support_comment = s.getSupport_comment();
            this.support_Subject = s.getSupport_Subject();
            this.support_FromUserId = s.getSupport_FromUserId();
            this.support_ToUserId = s.getSupport_ToUserId();
            this.support_Priority = s.getSupport_Priority();
            this.support_Status = s.getSupport_Status();
            this.support_IsActive = s.isSupport_IsActive();
            this.support_Modified = s.getSupport_Modified();
            this.support_Modifier = s.getSupport_Modifier();
            this.support_Created = s.getSupport_Created();
            this.support_creator = s.getSupport_creator();
            this.support_answeredTime = s.getSupport_answeredTime();
            this.support_answeredUser = s.getSupport_answeredUser();
            this.support_answer = s.getSupport_answer();
        }
    
    } public void getMessagesWithSupportId2(String sId){
        
        if(sId != null && !sId.equals("")){
   
            SupportDao sd = new SupportDao();
            this.sx = sd.getMessagesWithSupportId(sId); 
        }
    
    }public void deleteMessage(String sId){
        
        int sonuc = 0;
        
        SupportDao s = new SupportDao();
        sonuc = s.deleteMessage(sId);
        
        if(sonuc==1){
            getAllMessagesWithFromUserId();
            getAllMessages();
            
              FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Destek kaydınız BAŞARILI birşekilde silindi");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else {
            System.err.println(":::HATA:::Mesaj silme sırasında sorun olustu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Destek kaydı silme sırasında sorun oluştu.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    
    }public void getAllMessages(){
        
        if(SessionUtil.getUserId() != null){
            SupportDao sd = new SupportDao();
            this.fromUserSupMessagesForAdmin.clear();
            this.fromUserSupMessagesForAdmin = sd.getAllMessages();
        }
        else {System.err.println(":::HATA:::Loged userId Null geldi..");}
        
    }public void handleCloseSector(CloseEvent event) {
this.sx = null;

    }public void answeerMessage(){
        
        int sonuc = 0;
        
        SupportBean sb = new SupportBean();
        sb = this.sx;
        sb.setSupport_answer(this.support_answer);
        sb.setSupport_answeredUser(SessionUtil.getUserId());
        sb.setSupport_answeredTime(new Date());  
        SupportDao s = new SupportDao();
        sonuc = s.answeerMessage(sb);
        
        if (sonuc == 1) {
             AccountBean.updateUserSupportNotification(true, this.sx.support_FromUserId);
            
            getAllMessages();
            this.support_answer = null;
             FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Destek talebi yanıtlanmıştır");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else {
           System.err.println(":::BİLGİ:::Destek talebini yanıtlama sırasında sorun olustu");
           FacesContext facesContext = FacesContext.getCurrentInstance();
           FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Destek talebini yanıtlama sırasında sorun olustu");
           facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
           facesContext.addMessage(null, facesMessage);
           facesContext.renderResponse();
        }
    
    }public void accountDetailGet(){
        
        if (!this.account_MobilePhoneNumber.equals("") && this.account_MobilePhoneNumber != null) {

            AccountBean ab = new AccountBean();
            AccountDao a = new AccountDao();
            ab = a.getAccountWithGsmNo(this.account_MobilePhoneNumber);

            this.account_Name = ab.getAccount_FirstName() + " " + ab.getAccount_LastName();
            this.account_Id = ab.getAccount_Id();
        }
    }
    
    
}
