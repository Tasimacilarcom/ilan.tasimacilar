package com.tasimacilar.ilan.messages;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.UrlRedirect;
import com.tasimacilar.ilan.system.email.EmailBean;
import com.tasimacilar.ilan.system.email.EmailBodyes;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
@ManagedBean(name = "messagesBean")
@ViewScoped
public class MessagesBean implements Serializable{
    private String      message_Id;                
    private String      message_GroupId;           
    private String      message_;                  
    private String      message_Subject;          
    private String      message_FromUserId;       
    private String      message_ToUserId;        
    private String      message_Priority;          
    private String      message_Status;           
    private boolean     message_IsActive;         
    private Date        message_Modified;        
    private String      message_Modifier;          
    private Date        message_Created;           
    private String      message_creator;         
    private String      ad_Id;                    
    String param1 = null;
    String param2 = null;
    boolean newMessage = false;
    String frmUserId;
    String frmUserName;
    String frmUserEmail;
    String toUserId;
    String toUserName;
    String toUserEmail;
    List<MessagesBean> messagesList = new ArrayList<MessagesBean>();
    List<MessagesBean> usersMessagesList = new ArrayList<MessagesBean>();
    private String      fromUser_message_Statusx;            
    private boolean     fromUser_message_IsActivex;       
    private String      toUser_message_Statusx;            
    private boolean     toUser_message_IsActivex;         
    private String      messId;
    @ManagedProperty(value="#{adBean}")
     Ad_Bean adBean;
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}
    @PostConstruct
    public void init() { 
        AccountBean.updateUserMessageNotification(false, SessionUtil.getUserId());      
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1"); 
        param2 = req.getParameter("param2");   
        frmUserId =  SessionUtil.getUserId();
        frmUserName = SessionUtil.getUserName() + " " + SessionUtil.getUserSurname();
       messId = req.getParameter("messageId");
        if(messId != null ){ if(!messId.equals("")){  messageRead(messId); }  }
        try { String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("messages_ads") || FilenameUtils.getBaseName(urlx.getPath()).equals("messages_detail")){ 
                getUsersMessages(frmUserId);
            } }  catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }  
        if(param1 != null && !param1.equals("")){ getAdDetailWithAdId(param1);
            toUserId = this.adBean.getAd_OvnerAccountId();
            toUserName = this.adBean.getAccountBean().getAccount_FirstName()+" "+this.adBean.getAccountBean().getAccount_LastName();
            toUserEmail = this.adBean.getAccountBean().getAccount_EmailAddress();
            if(param2 != null && !param2.equals("")){  if(param2.equals("yeni")){
                    this.newMessage = true; }  else {   getMessages(param2);
                    this.ad_Id = param1;
                    this.message_GroupId = param2;
                 for (MessagesBean m : this.messagesList) {if(!m.message_FromUserId.equals(frmUserId)){
                            toUserId = m.message_FromUserId; break;  
                        } } AccountDao ad = new AccountDao();
                    toUserName = ad.getAccountDetailWithAccountId(toUserId).getAccount_FirstName()+" "+ad.getAccountDetailWithAccountId(toUserId).getAccount_LastName();
                    toUserEmail = ad.getAccountDetailWithAccountId(toUserId).getAccount_EmailAddress();
                } }   } } public MessagesBean() { }
    public MessagesBean(String message_Id, 
                        String message_GroupId, 
                        String message_, 
                        String message_Subject, 
                        String message_FromUserId, 
                        String message_ToUserId, 
                        String message_Priority, 
                        String message_Status, 
                        boolean message_IsActive, 
                        Date message_Modified, 
                        String message_Modifier, 
                        Date message_Created, 
                        String message_creator,
                        String ad_Id) {
        this.message_Id = message_Id;
        this.message_GroupId = message_GroupId;
        this.message_ = message_;
        this.message_Subject = message_Subject;
        this.message_FromUserId = message_FromUserId;
        this.message_ToUserId = message_ToUserId;
        this.message_Priority = message_Priority;
        this.message_Status = message_Status;
        this.message_IsActive = message_IsActive;
        this.message_Modified = message_Modified;
        this.message_Modifier = message_Modifier;
        this.message_Created = message_Created;
        this.message_creator = message_creator;
        this.ad_Id = ad_Id; }
    public String getMessage_Id() {return message_Id;}
    public void setMessage_Id(String message_Id) {this.message_Id = message_Id;}
    public String getMessage_GroupId() {return message_GroupId;}
    public void setMessage_GroupId(String message_GroupId) {this.message_GroupId = message_GroupId;}  
    public String getMessage_() {return message_;}
    public void setMessage_(String message_) {this.message_ = message_;}
    public String getMessage_Subject() {return message_Subject;}
    public void setMessage_Subject(String message_Subject) {this.message_Subject = message_Subject;}
    public String getMessage_FromUserId() {return message_FromUserId;}
    public void setMessage_FromUserId(String message_FromUserId) {this.message_FromUserId = message_FromUserId;}
    public String getMessage_ToUserId() {return message_ToUserId;}
    public void setMessage_ToUserId(String message_ToUserId) {this.message_ToUserId = message_ToUserId;}
    public String getMessage_Priority() { return message_Priority;}
    public void setMessage_Priority(String message_Priority) { this.message_Priority = message_Priority;}
    public String getMessage_Status() {return message_Status;}
    public void setMessage_Status(String message_Status) {this.message_Status = message_Status;}
    public boolean isMessage_IsActive() { return message_IsActive;}
    public void setMessage_IsActive(boolean message_IsActive) { this.message_IsActive = message_IsActive;}
    public Date getMessage_Modified() { return message_Modified;}
    public void setMessage_Modified(Date message_Modified) { this.message_Modified = message_Modified;}
    public String getMessage_Modifier() { return message_Modifier;}
    public void setMessage_Modifier(String message_Modifier) { this.message_Modifier = message_Modifier;}
    public Date getMessage_Created() { return message_Created;}
    public void setMessage_Created(Date message_Created) { this.message_Created = message_Created;}
    public String getMessage_creator() {return message_creator;}
    public void setMessage_creator(String message_creator) {this.message_creator = message_creator;}
    public String getAd_Id() { return ad_Id;}
    public void setAd_Id(String ad_Id) { this.ad_Id = ad_Id;}
    public String getFrmUserId() { return frmUserId;}
    public void setFrmUserId(String frmUserId) {  this.frmUserId = frmUserId;}
    public String getFrmUserName() { return frmUserName;}
    public void setFrmUserName(String frmUserName) { this.frmUserName = frmUserName;}
    public String getToUserId() { return toUserId;}
    public void setToUserId(String toUserId) { this.toUserId = toUserId;}
    public String getToUserName() {  return toUserName;}
    public void setToUserName(String toUserName) { this.toUserName = toUserName;}
    public List<MessagesBean> getMessagesList() {return messagesList;}
    public void setMessagesList(List<MessagesBean> messagesList) { this.messagesList = messagesList;}
    public List<MessagesBean> getUsersMessagesList() { return usersMessagesList;}
    public void setUsersMessagesList(List<MessagesBean> usersMessagesList) { this.usersMessagesList = usersMessagesList;}
    public String getFromUser_message_Statusx() {return fromUser_message_Statusx;}
    public void setFromUser_message_Statusx(String fromUser_message_Statusx) { this.fromUser_message_Statusx = fromUser_message_Statusx;}
    public boolean isFromUser_message_IsActivex() { return fromUser_message_IsActivex;}
    public void setFromUser_message_IsActivex(boolean fromUser_message_IsActivex) { this.fromUser_message_IsActivex = fromUser_message_IsActivex;}
    public String getToUser_message_Statusx() { return toUser_message_Statusx;}
    public void setToUser_message_Statusx(String toUser_message_Statusx) {this.toUser_message_Statusx = toUser_message_Statusx;}
    public boolean isToUser_message_IsActivex() { return toUser_message_IsActivex;}
    public void setToUser_message_IsActivex(boolean toUser_message_IsActivex) { this.toUser_message_IsActivex = toUser_message_IsActivex;}
    public String getParam2() {return param2;}
    public void setParam2(String param2) {this.param2 = param2;}
    public String getMessId() { return messId;}
    public void setMessId(String messId) { this.messId = messId;}
    public String createMessage(){
     String yonlen = "";
        String MessageId = UniqueId.RandomString(12)+UniqueId.RandomString(12);
        String GroupId = UniqueId.RandomString(12)+UniqueId.RandomString(12);
    if(newMessage){int sonuc = 0; int sonucx = 0;int sonucxx = 0;
        MessagesBean mxx = new MessagesBean();
            mxx.setMessage_Id(UniqueId.RandomString(12)+UniqueId.RandomString(12));
            mxx.setMessage_GroupId(GroupId);
            mxx.setMessage_Subject("AdRootMessage");
            mxx.setMessage_FromUserId(this.frmUserId);
            mxx.setMessage_ToUserId(null);
            mxx.setMessage_Priority(null);
            mxx.setMessage_Status("Okunmadı");
            mxx.setMessage_IsActive(true);
            mxx.setMessage_Modified(new Date());
            mxx.setMessage_Modifier(SessionUtil.getUserId());
            mxx.setMessage_Created(new Date());
            mxx.setMessage_creator(SessionUtil.getUserId());
            mxx.setAd_Id(this.adBean.getAd_Id());
            MessagesDao mdxx = new MessagesDao();
            sonucxx = mdxx.createMessage(mxx);
              MessagesBean mx = new MessagesBean();
            mx.setMessage_Id(UniqueId.RandomString(12)+UniqueId.RandomString(12));
            mx.setMessage_GroupId(GroupId);
            mx.setMessage_Subject("AdRootMessage");
            mx.setMessage_FromUserId(null);
            mx.setMessage_ToUserId(this.toUserId);
            mx.setMessage_Priority(null);
            mx.setMessage_Status("Okunmadı");
            mx.setMessage_IsActive(true);
            mx.setMessage_Modified(new Date());
            mx.setMessage_Modifier(SessionUtil.getUserId());
            mx.setMessage_Created(new Date());
            mx.setMessage_creator(SessionUtil.getUserId());
            mx.setAd_Id(this.adBean.getAd_Id());
            MessagesDao mdx = new MessagesDao();
            sonucx = mdx.createMessage(mx); MessagesBean m = new MessagesBean();
            m.setMessage_Id(MessageId);
            m.setMessage_GroupId(GroupId);
            m.setMessage_(this.message_);
            m.setMessage_Subject("AdMessage");
            m.setMessage_FromUserId(this.frmUserId);
            m.setMessage_ToUserId(this.toUserId);
            m.setMessage_Priority(null);
            m.setMessage_Status(null);
            m.setMessage_IsActive(true);
            m.setMessage_Modified(new Date());
            m.setMessage_Modifier(SessionUtil.getUserId());
            m.setMessage_Created(new Date());
            m.setMessage_creator(SessionUtil.getUserId());
            m.setAd_Id(this.adBean.getAd_Id()); if(sonucx == 1 && sonucxx ==1){
                System.out.println(":::BİLGİ:::default root mesajları oluşturuldu");
                MessagesDao md = new MessagesDao();
                sonuc = md.createMessage(m); }
            else{ System.out.println(":::HATA:::default root mesajları oluşturma hatası");}
            if(sonuc == 1){ AccountBean.updateUserMessageNotification(true, this.toUserId);
                String emailBody = EmailBodyes.UserMessageNotificationEmailBody(toUserName);
                EmailBean eb = new EmailBean();
                eb.sendMailNow(toUserEmail, "", "", emailBody, "Yeni bir ilan mesajınız var - tasimacilar.com", "");
 if (SessionUtil.getUserType().equals("personal")) {  try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                        ec.redirect(ec.getRequestContextPath() + "/private/bireysel/mesajlar/detay/" + GroupId + "/" + this.adBean.getAd_Id());
                    } catch (IOException ex) { System.out.println(":::HATA:::" + ex); } }
                if (SessionUtil.getUserType().equals("corporate")) {
                    try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                        ec.redirect(ec.getRequestContextPath() + "/private/kurumsal/mesajlar/detay/" + GroupId + "/" + this.adBean.getAd_Id());
                    }  catch (IOException ex) {  System.out.println(":::HATA:::" + ex);  } } } }
        else {int sonuc = 0;  MessagesBean m = new MessagesBean();
            m.setMessage_Id(MessageId);
            m.setMessage_GroupId(this.message_GroupId);
            m.setMessage_(this.message_); 
            m.setMessage_Subject("AdMessage");
            m.setMessage_FromUserId(this.frmUserId);
            m.setMessage_ToUserId(this.toUserId);
            m.setMessage_Priority(null);
            m.setMessage_Status(null);
            m.setMessage_IsActive(true);
            m.setMessage_Modified(new Date());
            m.setMessage_Modifier(SessionUtil.getUserId());
            m.setMessage_Created(new Date());
            m.setMessage_creator(SessionUtil.getUserId());
            m.setAd_Id(this.ad_Id);
            MessagesDao md = new MessagesDao();
            sonuc = md.createMessage(m);if(sonuc == 1){ 
                messageUnDelete(this.message_GroupId);
                AccountBean.updateUserMessageNotification(true, this.toUserId);
              String emailBody = EmailBodyes.UserMessageNotificationEmailBody(toUserName);
                EmailBean eb = new EmailBean();
                eb.sendMailNow(toUserEmail, "", "", emailBody, "Yeni bir ilan mesajınız var - tasimacilar.com", "");
              getMessages(this.message_GroupId);
              if (SessionUtil.getUserType().equals("personal")) {
                    try {  ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                        ec.redirect(ec.getRequestContextPath() + "/private/bireysel/mesajlar/detay/"+ this.message_GroupId +"/"+ this.ad_Id ); } 
                    catch (IOException ex) { System.out.println(":::HATA:::" + ex); }
                } if (SessionUtil.getUserType().equals("corporate")) {
                    try { ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                        ec.redirect(ec.getRequestContextPath() + "/private/kurumsal/mesajlar/detay/"+ this.message_GroupId +"/"+ this.ad_Id );
                    }  catch (IOException ex) {  System.out.println(":::HATA:::" + ex);  }  }  }   } return yonlen;  }
    public void getAdDetailWithAdId(String adId) {
         Ad_Bean a = new Ad_Bean();
        Ad_Dao ad = new Ad_Dao();
        a = ad.getAdDetailWithId(adId);
         this.adBean.setAd_Id(a.getAd_Id());
        this.adBean.setAd_Category_Id(a.getAd_Category_Id());
        this.adBean.setAd_Title(a.getAd_Title());
        this.adBean.setAd_Comment(stringPars(htmlToText(a.getAd_Comment())));    
        this.adBean.setAd_Type(a.getAd_Type());
        this.adBean.setAd_OvnerAccountId(a.getAd_OvnerAccountId());
        this.adBean.setAd_IsActive(a.isAd_IsActive());
        this.adBean.setAd_EndTime(a.getAd_EndTime());
        this.adBean.setAd_Notes(a.getAd_Notes());
        this.adBean.setAd_CreateTime(a.getAd_CreateTime());
        this.adBean.setAd_CreatedIp(a.getAd_CreatedIp());
        this.adBean.setAd_CreatedAccountId(a.getAd_CreatedAccountId());
        this.adBean.setAd_LastModifyIp(a.getAd_LastModifyIp());
        this.adBean.setAd_LastModifyTime(a.getAd_LastModifyTime());
        this.adBean.setAd_LastChangerAccountId(a.getAd_LastChangerAccountId());   
        this.adBean.setAd_Category_Name(a.getAd_Category_Name());
         this.adBean.setAccountBean(a.getAccountBean()); }
private void getMessages(String messageGroupId) {
       MessagesDao md = new MessagesDao();
        this.messagesList = md.getAllMessagesWithGroupId(messageGroupId); }
 private void getUsersMessages(String usrId ) { MessagesDao md = new MessagesDao();
        this.usersMessagesList = md.getUsersMessages(usrId, usrId);  }    
 public String htmlToText(String html) { return Jsoup.parse(html).text(); }
 public String stringPars(String comment) {
    String parsedComment = ""; if (comment.length() > 70) {    parsedComment = comment.substring(0, 70)+" ...";   } 
        else {  parsedComment = comment;   } return parsedComment; }
 public void messageRead(String messageId){ int sonuc = 0;
     MessagesDao m = new MessagesDao(); sonuc = m.readOrUnreadMessageGroup("readMessageGroup", messageId);
     if(sonuc == 1){  getUsersMessages(SessionUtil.getUserId()); }
    }  public void messageUnRead(String messageId){
             int sonuc = 0; MessagesDao m = new MessagesDao();
       sonuc = m.readOrUnreadMessageGroup("unReadMessageGroup", messageId);
        if(sonuc == 1){  getUsersMessages(SessionUtil.getUserId());
        if (SessionUtil.getUserType().equals("personal")) { UrlRedirect.redirect("/private/bireysel/ilan-mesajlarim");  }
           else if (SessionUtil.getUserType().equals("corporate")) { UrlRedirect.redirect("/private/kurumsal/ilan-mesajlarim");   }  }
       else{System.out.println(":::Mesaj Durum Değistirme Hatası");}  }
   public void messageDelete(String messageId){
        int sonuc = 0;  MessagesDao m = new MessagesDao();
        sonuc = m.enableDisableMessageGroup("disableMessageGroup", messageId);if(sonuc == 1){
           getUsersMessages(SessionUtil.getUserId());
           if (SessionUtil.getUserType().equals("personal")) {  UrlRedirect.redirect("/private/bireysel/ilan-mesajlarim");   }
           else if (SessionUtil.getUserType().equals("corporate")) {  UrlRedirect.redirect("/private/kurumsal/ilan-mesajlarim");  }
        } else{System.out.println(":::Mesaj Silme Hatası");}
    } public void messageUnDelete(String messageGroupId){ int sonuc = 0;
        MessagesDao m = new MessagesDao(); sonuc = m.enableDisableMessageGroupWithGroupId("enableMessageGroupWithGroupId", messageGroupId);
      if(sonuc == 1){ System.out.println("::::MESAJ GERİ ALINDI");  getUsersMessages(SessionUtil.getUserId());  } }
     public void refreshMessages() {  getMessages(param2); }
}
