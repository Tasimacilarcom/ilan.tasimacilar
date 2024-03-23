package com.tasimacilar.ilan.common;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "selectItemsBean")
@ViewScoped
public class SelectItemsBean implements Serializable{
    private int     selectItem_Id;
    private String  selectItem_;
    private String  selectItem_Value;
    private String  selectItem_Label_Tr;
    private String  selectItem_Label_En;
 public SelectItemsBean() { }
    public int getSelectItem_Id() {return selectItem_Id;}
    public void setSelectItem_Id(int selectItem_Id) {this.selectItem_Id = selectItem_Id;}
    public String getSelectItem_() {return selectItem_;}
    public void setSelectItem_(String selectItem_) {this.selectItem_ = selectItem_;}
    public String getSelectItem_Value() { return selectItem_Value;}
    public void setSelectItem_Value(String selectItem_Value) {this.selectItem_Value = selectItem_Value;}
    public String getSelectItem_Label_Tr() {return selectItem_Label_Tr;}
    public void setSelectItem_Label_Tr(String selectItem_Label_Tr) {this.selectItem_Label_Tr = selectItem_Label_Tr;}
    public String getSelectItem_Label_En() {return selectItem_Label_En;}
    public void setSelectItem_Label_En(String selectItem_Label_En) {this.selectItem_Label_En = selectItem_Label_En;}
    public List<SelectItemsBean> selectItemList (String param){
        SelectItemsDao sd = new SelectItemsDao(); return  sd.getSelectItems(param); }
 
    
}
