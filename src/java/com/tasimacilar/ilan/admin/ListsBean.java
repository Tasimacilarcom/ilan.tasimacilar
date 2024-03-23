package com.tasimacilar.ilan.admin;
import com.tasimacilar.ilan.ad.route.AdRouteBean;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
@ManagedBean(name = "listsBean")
@ViewScoped
public class ListsBean implements Serializable{
    private int         selectItem_Id;
    private String      selectItem_;
    private String      selectItem_Value;
    private String      selectItem_Label_Tr;
    private String      selectItem_Label_En;
    private List<ListsBean>  selectItemList = new ArrayList<ListsBean>();
    private List<ListsBean>  filteredSelectItemList;
    private String selectItemName;

    @PostConstruct
    public void init() { 
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        try { String url = req.getRequestURL().toString();
            URL urlx = new URL(url);
            if(FilenameUtils.getBaseName(urlx.getPath()).equals("arac_ozellikleri")){ 
                listWithItemget("VehicleProperties"); 
                this.selectItemName = "VehicleProperties";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("arac_yetki_belgeleri")){ 
                listWithItemget("AuthorityDocuments"); 
                this.selectItemName = "AuthorityDocuments";
            } if(FilenameUtils.getBaseName(urlx.getPath()).equals("sofor_belgeleri")){ 
                listWithItemget("RequestedDocument"); 
                this.selectItemName = "RequestedDocument";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("yabanci_diller")){ 
                listWithItemget("ForeignLanguage"); 
                this.selectItemName = "ForeignLanguage";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("arac_tipleri")){ 
                listWithItemget("VehicleType"); 
                this.selectItemName = "VehicleType";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("arac_kapasiteleri")){ 
                listWithItemget("VehicleCapacity"); 
                this.selectItemName = "VehicleCapacity";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("surucu_belgeleri")){ 
                listWithItemget("DriversLicense"); 
                this.selectItemName = "DriversLicense";
            } if(FilenameUtils.getBaseName(urlx.getPath()).equals("servis_tipleri")){ 
                listWithItemget("serviceType"); 
                this.selectItemName = "serviceType";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("kurumsal_faliyet_alanlari")){ 
                listWithItemget("corporateActivityArea"); 
                this.selectItemName = "corporateActivityArea";
            }  if(FilenameUtils.getBaseName(urlx.getPath()).equals("bireysel_faliyet_alanlari")){ 
                listWithItemget("personalActivityArea"); 
                this.selectItemName = "personalActivityArea";
            }
            
        } 
        catch (MalformedURLException ex) { System.err.println(":::HATA:: URL Gelmedi :::"+ex); }  
    }  public ListsBean() {  } public ListsBean(   int selectItem_Id, 
                        String selectItem_, 
                        String selectItem_Value, 
                        String selectItem_Label_Tr, 
                        String selectItem_Label_En) {
        this.selectItem_Id = selectItem_Id;
        this.selectItem_ = selectItem_;
        this.selectItem_Value = selectItem_Value;
        this.selectItem_Label_Tr = selectItem_Label_Tr;
        this.selectItem_Label_En = selectItem_Label_En;
    }
      public int getSelectItem_Id() { return selectItem_Id;}
    public void setSelectItem_Id(int selectItem_Id) {this.selectItem_Id = selectItem_Id;}
    public String getSelectItem_() {return selectItem_;}
    public void setSelectItem_(String selectItem_) {this.selectItem_ = selectItem_;}
    public String getSelectItem_Value() {return selectItem_Value;}
    public void setSelectItem_Value(String selectItem_Value) {this.selectItem_Value = selectItem_Value;}
    public String getSelectItem_Label_Tr() {return selectItem_Label_Tr;}
    public void setSelectItem_Label_Tr(String selectItem_Label_Tr) {this.selectItem_Label_Tr = selectItem_Label_Tr;}
    public String getSelectItem_Label_En() { return selectItem_Label_En;}
    public void setSelectItem_Label_En(String selectItem_Label_En) {this.selectItem_Label_En = selectItem_Label_En;}
    public List<ListsBean> getSelectItemList() {return selectItemList;}
    public void setSelectItemList(List<ListsBean> selectItemList) { this.selectItemList = selectItemList;}
    public List<ListsBean> getFilteredSelectItemList() {  return filteredSelectItemList;}
    public void setFilteredSelectItemList(List<ListsBean> filteredSelectItemList) { this.filteredSelectItemList = filteredSelectItemList;}
  @Override
    public String toString() {
        return "ListsBean{" + "selectItem_Id=" + selectItem_Id 
                            + ", selectItem_=" + selectItem_ 
                            + ", selectItem_Value=" + selectItem_Value 
                            + ", selectItem_Label_Tr=" + selectItem_Label_Tr 
                            + ", selectItem_Label_En=" + selectItem_Label_En + '}';
    }public void createList(){
        
        int sonuc = 0;
        
        ListsBean l = new ListsBean();
        l.selectItem_Id = 0;
        l.selectItem_ = this.selectItemName;
        l.selectItem_Value =  this.selectItem_Value;
        l.selectItem_Label_Tr =  this.selectItem_Value;
        l.selectItem_Label_En =  this.selectItem_Value;
          
        ListsDao ld = new ListsDao();
        sonuc = ld.createList(l);
        
        if(sonuc == 1 ){
            listWithItemget(this.selectItemName);
            this.selectItem_Value = null;
             FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI","Yeni liste öğesi eklendi");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else{
            System.err.println(":::HATA:::Yeni liste öğesi eklenirken hata oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Yeni liste öğesi eklenirken hata oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    }
 public void listWithItemget(String itemName){
        
        ListsDao ld = new ListsDao();
        this.selectItemList = ld.getListWithItem(itemName);
    }
 public void deleteListItem(int ItemId) {
    
        int sonuc = 0;
        
        ListsDao l = new ListsDao();
        sonuc = l.deleteListItem(ItemId);
        
        if(sonuc == 1){
            listWithItemget(this.selectItemName);
             FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARILI",  "Liste öğesi silindi");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
        else{
            System.err.println(":::HATA:::Liste ogesi silinirken hata oluştu");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Liste ogesi silinirken hata oluştu");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            facesContext.renderResponse();
        }
    }

}
