package com.tasimacilar.ilan.ad.plakamiSatiyorum;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.ad.Ad_Dao;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsBean;
import com.tasimacilar.ilan.ad.comments.Ad_CommentsDao;
import com.tasimacilar.ilan.common.Ad_CountersDao;
import com.tasimacilar.ilan.favorites.FavoritesBean;
import com.tasimacilar.ilan.profile.account.AccountBean;
import com.tasimacilar.ilan.profile.account.AccountDao;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountBean;
import com.tasimacilar.ilan.profile.account.corporate.CorporateAccountDao;
import com.tasimacilar.ilan.profile.account.personal.PersonalAccountBean;
import com.tasimacilar.ilan.system.AdUtils;
import com.tasimacilar.ilan.system.ExpiryDates;
import com.tasimacilar.ilan.system.GetUserEnvironment;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.UrlRedirect;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "AdPlakamiSatiyorumBean")
@ViewScoped
public class Ad_PlakamiSatiyorum_Bean implements Serializable{  
    private Ad_PlakamiSatiyorum     adPlakamiSatiyorum;
    private Ad_Bean                 adBean;                
    private String                  param1;
    private String                  aId;      
    private String                  pAdId = null;
    private String                  AdComment = null;
    private List<Ad_CommentsBean>   adCommentsList = new ArrayList<Ad_CommentsBean>();
    private UIInput                 inputBox;
    private UIInput                 inputBox1;
    private UIInput                 inputBox2;
    private List<Ad_Bean>           adList;
    @ManagedProperty(value="#{accountBean}")
    private AccountBean accountBean;
    public AccountBean getAccountBean() {return accountBean;}
    public void setAccountBean(AccountBean accountBean) {this.accountBean = accountBean;}  
    @ManagedProperty(value="#{corporateAccountBean}")
    private CorporateAccountBean corporateAccountBean;
    public CorporateAccountBean getCorporateAccountBean() {return corporateAccountBean;}
    public void setCorporateAccountBean(CorporateAccountBean corporateAccountBean) {this.corporateAccountBean = corporateAccountBean;}
    @PostConstruct
    public void init() {           
        adPlakamiSatiyorum = new Ad_PlakamiSatiyorum();
        adBean = new Ad_Bean();
        adList = new ArrayList<Ad_Bean>();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        param1 = req.getParameter("param1");   
        pAdId = req.getParameter("adId");        
        aId = req.getParameter("aId");           
        try {String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("personal_yeni") || FilenameUtils.getBaseName(urlx.getPath()).equals("corporate_yeni") ||
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_plakami-satiyorum")){ 
               if (param1.equals("ekle")) { adBean.setAd_Id(UniqueId.RandomString(12));}
            }     
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("duzenle") ||
               FilenameUtils.getBaseName(urlx.getPath()).equals("kullanici_detay_addAd_aracim-var-hostes-ariyorum") ){            
                if(param1!= null && !param1.equals("")){ if (param1.equals("duzenle")) { }
                }                
            } 
            if(pAdId != null && !pAdId.equals("")){  getAdFullDetailWithAdId(pAdId); }  
        }  catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::" + ex);   } }
    public Ad_PlakamiSatiyorum_Bean() { }
    public Ad_PlakamiSatiyorum getAdPlakamiSatiyorum() {return adPlakamiSatiyorum;}
    public void setAdPlakamiSatiyorum(Ad_PlakamiSatiyorum adPlakamiSatiyorum) {this.adPlakamiSatiyorum = adPlakamiSatiyorum;}
    public Ad_Bean getAdBean() {return adBean;}
    public void setAdBean(Ad_Bean adBean) {this.adBean = adBean;}
    public String getParam1() {return param1;}
    public void setParam1(String param1) {this.param1 = param1;}
    public String getaId() {return aId;}
    public void setaId(String aId) { this.aId = aId;}
    public String getpAdId() { return pAdId;}
    public void setpAdId(String pAdId) { this.pAdId = pAdId;}
    public String getAdComment() {return AdComment;}
    public void setAdComment(String AdComment) {this.AdComment = AdComment;}
    public List<Ad_CommentsBean> getAdCommentsList() {return adCommentsList;}
    public void setAdCommentsList(List<Ad_CommentsBean> adCommentsList) {this.adCommentsList = adCommentsList;}
    public UIInput getInputBox() {return inputBox;}
    public void setInputBox(UIInput inputBox) {this.inputBox = inputBox;}
    public UIInput getInputBox1() {return inputBox1;}
    public void setInputBox1(UIInput inputBox1) {this.inputBox1 = inputBox1;}
    public UIInput getInputBox2() {return inputBox2;}
    public void setInputBox2(UIInput inputBox2) {this.inputBox2 = inputBox2;}
    public List<Ad_Bean> getAdList() { return adList; }
    public void setAdList(List<Ad_Bean> adList) { this.adList = adList;   }public void preRenderInput() {
        if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateProvinceCode() ==0){inputBox.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox.setValue("");
            }
        }
    }  public void preRenderInput1() {
                if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateNumberCode() ==0){inputBox1.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox1.setValue("");
            }
        }
    } public void preRenderInput2() {
        if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_ucret()==0){inputBox2.setValue("");
            if(!FacesContext.getCurrentInstance().isPostback()) {
                inputBox2.setValue("");  } }}  public void plakamiSatiyorumIlanOlustur() {    
        if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateProvinceCode() != 0){
            if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateLatterCode() !=null && !this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateLatterCode().equals("")){
                if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateNumberCode() != 0){ Ad_Bean adb = new Ad_Bean();                            
                    adb.setAd_Id(this.adBean.getAd_Id());           
                    adb.setAd_Category_Id(7);                               
                    adb.setAd_Title("");     
                    adb.setAd_Comment(this.adBean.getAd_Comment());     
                    adb.setAd_Type(AdUtils.getAdTyp(aId)); 
                    adb.setAd_OvnerAccountId(AdUtils.getOvnerAccountId(aId));  
                    adb.setAd_IsActive(true);  
                    adb.setAd_EndTime(ExpiryDates.AdExpiryDate(7));   
                    adb.setAd_Notes(null);                          
                    adb.setAd_CreateTime(new Date());                       
                    adb.setAd_CreatedIp(GetUserEnvironment.getInternetIp());
                    adb.setAd_CreatedAccountId(SessionUtil.getUserId()); Ad_PlakamiSatiyorum_Bean adp = new Ad_PlakamiSatiyorum_Bean();
                    adp.adPlakamiSatiyorum = this.adPlakamiSatiyorum;
                    adp.adPlakamiSatiyorum.setAd_PlakamiSatiyorum_Id(UniqueId.RandomString(12));
                    adp.setAdBean(adb);
                    int sonuc = 0;   
                    Ad_PlakamiSatiyorum_Dao adpl = new Ad_PlakamiSatiyorum_Dao();
                    sonuc = adpl.plakamiSatiyorumIlanOlustur(adp); 
                    if(sonuc==1){ if(SessionUtil.getUserType().equals("director")){  UrlRedirect.redirect("/private/director/users/kullanici_detay_addAd_sonucSayfasi.xhtml?cat=plakami-satiyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id()); }
                        else{ UrlRedirect.redirect( "/ad/sonuc/plakami-satiyorum/"+this.adBean.getAd_Id() ); }
                    } else{ Messages.dynMsg(null, "error", "İlanı kaydetme sırasında sorun oluştu"); }
                }  else{ Messages.dynMsg(null, "error", "Araç plakası rakam kodu geçersiz");}               
            } else{ Messages.dynMsg(null, "error", "Araç plakası harf kodu geçersiz"); }
        }  else{ Messages.dynMsg(null, "error", "Araç plakası il kodu geçersiz"); }        
    } public void plakamiSatiyorumIlanDuzenle() {  if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateProvinceCode() != 0){
            if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateLatterCode() !=null && !this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateLatterCode().equals("")){
                if(this.adPlakamiSatiyorum.getAd_PlakamiSatiyorum_PlateNumberCode() != 0){ Ad_Bean adb = new Ad_Bean();                            
                    adb.setAd_Id(this.adBean.getAd_Id());           
                    adb.setAd_Category_Id(7);                               
                    adb.setAd_Title("");     
                    adb.setAd_Comment(this.adBean.getAd_Comment());                          
                    adb.setAd_LastModifyIp(GetUserEnvironment.getInternetIp());
                    adb.setAd_LastModifyTime(new Date());
                    adb.setAd_LastChangerAccountId(SessionUtil.getUserId()); Ad_PlakamiSatiyorum_Bean adp = new Ad_PlakamiSatiyorum_Bean();
                    adp.adPlakamiSatiyorum = this.adPlakamiSatiyorum;
                    adp.setAdBean(adb);  int sonuc = 0;  Ad_PlakamiSatiyorum_Dao adpl = new Ad_PlakamiSatiyorum_Dao();
                    sonuc = adpl.plakamiSatiyorumIlanDuzenle(adp);   if(sonuc==1){
                        if(SessionUtil.getUserType().equals("director")){
                            UrlRedirect.redirect("/private/director/ilanlar/sonuc2/?cat=plakami-satiyorum&aId="+this.aId+"&adId="+this.adBean.getAd_Id());
                        } else{ UrlRedirect.redirect("/ad/sonuc2/plakami-satiyorum/"+this.adBean.getAd_Id()); }
                    }  else{ Messages.dynMsg(null, "error", "İlanı güncelleme sırasında sorun oluştu"); }
                }  else{ Messages.dynMsg(null, "error", "Araç plakası rakam kodu geçersiz");}               
            }  else{ Messages.dynMsg(null, "error", "Araç plakası harf kodu geçersiz"); }
        } else{ Messages.dynMsg(null, "error", "Araç plakası il kodu geçersiz"); }         }
    public void getAdFullDetailWithAdId(String adId) { Ad_PlakamiSatiyorum_Bean adpl = new Ad_PlakamiSatiyorum_Bean();
        Ad_PlakamiSatiyorum_Dao adpd = new Ad_PlakamiSatiyorum_Dao();
        adpl = adpd.getPlakamiSatiyorumWithAdId(adId);  this.adPlakamiSatiyorum = adpl.getAdPlakamiSatiyorum(); this.adBean.setAd_Id(adpl.adBean.getAd_Id());
        this.adBean.setAd_Id2(adpl.adBean.getAd_Id2());
        this.adBean.setAd_Category_Id(adpl.adBean.getAd_Category_Id());
        this.adBean.setAd_Title(adpl.adBean.getAd_Title());
        this.adBean.setAd_Comment(adpl.adBean.getAd_Comment());
        this.adBean.setAd_Type(adpl.adBean.getAd_Type());
        this.adBean.setAd_OvnerAccountId(adpl.adBean.getAd_OvnerAccountId());
        this.adBean.setAd_IsActive(adpl.adBean.isAd_IsActive());
        this.adBean.setAd_EndTime(adpl.adBean.getAd_EndTime());
        this.adBean.setAd_Notes(adpl.adBean.getAd_Notes());
        this.adBean.setAd_CreateTime(adpl.adBean.getAd_CreateTime());
        this.adBean.setAd_CreatedIp(adpl.adBean.getAd_CreatedIp());
        this.adBean.setAd_CreatedAccountId(adpl.adBean.getAd_CreatedAccountId());
        this.adBean.setAd_LastModifyIp(adpl.adBean.getAd_LastModifyIp());
        this.adBean.setAd_LastModifyTime(adpl.adBean.getAd_LastModifyTime());
        this.adBean.setAd_LastChangerAccountId(adpl.adBean.getAd_LastChangerAccountId());   AccountBean acb = new AccountBean();
        acb.setAccount_Id(adpl.getAdBean().getAd_OvnerAccountId());
        PersonalAccountBean pab = new PersonalAccountBean();
        pab.setAccountBean(acb);
        AccountDao ado = new AccountDao();
        this.accountBean = ado.getAccountDetailWithParam(pab, "getAllWithId").getAccountBean(); CorporateAccountDao cod = new CorporateAccountDao();
        if(this.accountBean != null){this.corporateAccountBean = cod.getOneCorporateAccountWithId(this.accountBean.getCompany_Id());} Ad_CommentsDao adxx = new Ad_CommentsDao();
        this.adCommentsList = adxx.getAllCommentWithItemId(this.adBean.getAd_Id());    Ad_Dao adda = new Ad_Dao();
        this.adList = adda.getUserTopTenAdWithPublish(adpl.getAdBean().getAd_OvnerAccountId());    
    } public void createFavoritesAd(){  FavoritesBean f = new FavoritesBean();
        f.createFavoritesAd(pAdId);
    }   public void createAdComment(){
        int sonuc = 0;
        Ad_CommentsBean ac = new Ad_CommentsBean();
        sonuc = ac.createAdComment(this.pAdId,this.AdComment ); 
        if(sonuc == 1){this.AdComment = null;}
    }}
