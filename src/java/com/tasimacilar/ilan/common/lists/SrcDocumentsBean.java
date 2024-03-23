package com.tasimacilar.ilan.common.lists;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "srcDocumentsBean")
@ViewScoped
public class SrcDocumentsBean implements Serializable{
    
    private String      requestedDocuments_Id; 
    private boolean     requestedDocuments_Src;       
    private boolean     requestedDocuments_Src1;        
    private boolean     requestedDocuments_Src2;       
    private boolean     requestedDocuments_Src3;       
    private boolean     requestedDocuments_Psikoteknik;
    private String      requestedDocuments_Other;       
    private String      ad_Id;                          
  public SrcDocumentsBean() {  }
    public String getRequestedDocuments_Id() {return requestedDocuments_Id;}
    public void setRequestedDocuments_Id(String requestedDocuments_Id) {this.requestedDocuments_Id = requestedDocuments_Id;}
    public boolean isRequestedDocuments_Src() {return requestedDocuments_Src;}
    public void setRequestedDocuments_Src(boolean requestedDocuments_Src) {this.requestedDocuments_Src = requestedDocuments_Src;}
    public boolean isRequestedDocuments_Src1() {return requestedDocuments_Src1;}
    public void setRequestedDocuments_Src1(boolean requestedDocuments_Src1) {this.requestedDocuments_Src1 = requestedDocuments_Src1;}
    public boolean isRequestedDocuments_Src2() {return requestedDocuments_Src2;}
    public void setRequestedDocuments_Src2(boolean requestedDocuments_Src2) {this.requestedDocuments_Src2 = requestedDocuments_Src2;}
    public boolean isRequestedDocuments_Src3() {return requestedDocuments_Src3;}
    public void setRequestedDocuments_Src3(boolean requestedDocuments_Src3) {this.requestedDocuments_Src3 = requestedDocuments_Src3;}
    public boolean isRequestedDocuments_Psikoteknik() {return requestedDocuments_Psikoteknik;}
    public void setRequestedDocuments_Psikoteknik(boolean requestedDocuments_Psikoteknik) {this.requestedDocuments_Psikoteknik = requestedDocuments_Psikoteknik;}
    public String getRequestedDocuments_Other() {return requestedDocuments_Other;}
    public void setRequestedDocuments_Other(String requestedDocuments_Other) {this.requestedDocuments_Other = requestedDocuments_Other;}
    public String getAd_Id() {return ad_Id;}
    public void setAd_Id(String ad_Id) {this.ad_Id = ad_Id;}

    
    
}
