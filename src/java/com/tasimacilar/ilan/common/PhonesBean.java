package com.tasimacilar.ilan.common;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "phonesBean")
@ViewScoped
public class PhonesBean implements Serializable{
    private String      phone_id;
    private int         phone_type_id;
    private String      phone_name;
    private String      phone_1;
    private String      phone_2;
    private String      phone_3;
    private String      phone_4;
    private String      phone_5;
    private String      phone_gsm1;
    private String      phone_gsm2;
    private String      phone_gsm3;
    private String      phone_fax1;
    private String      phone_fax2;
    private boolean     phone_isActive;
    private Date        phone_Modified;  
    private String      phone_Modifier; 
    private Date        phone_Created; 
    private String      phone_creator;
 @PostConstruct 
 public void init() {   }    
  public PhonesBean() { }
    public PhonesBean(   String phone_id, 
                        int phone_type_id, 
                        String phone_name, 
                        String phone_1, 
                        String phone_2, 
                        String phone_3, 
                        String phone_4, 
                        String phone_5, 
                        String phone_gsm1, 
                        String phone_gsm2, 
                        String phone_gsm3, 
                        String phone_fax1, 
                        String phone_fax2, 
                        Date phone_Modified, 
                        String phone_Modifier, 
                        Date phone_Created, 
                        String phone_creator) {
        this.phone_id = phone_id;
        this.phone_type_id = phone_type_id;
        this.phone_name = phone_name;
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.phone_3 = phone_3;
        this.phone_4 = phone_4;
        this.phone_5 = phone_5;
        this.phone_gsm1 = phone_gsm1;
        this.phone_gsm2 = phone_gsm2;
        this.phone_gsm3 = phone_gsm3;
        this.phone_fax1 = phone_fax1;
        this.phone_fax2 = phone_fax2;
        this.phone_Modified = phone_Modified;
        this.phone_Modifier = phone_Modifier;
        this.phone_Created = phone_Created;
        this.phone_creator = phone_creator;
    }
    public String getPhone_id() { return phone_id;}
    public void setPhone_id(String phone_id) {this.phone_id = phone_id;}
    public int getPhone_type_id() {return phone_type_id;}
    public void setPhone_type_id(int phone_type_id) {this.phone_type_id = phone_type_id;}
    public String getPhone_name() {return phone_name;}
    public void setPhone_name(String phone_name) {this.phone_name = phone_name;}
    public String getPhone_1() {return phone_1;}
    public void setPhone_1(String phone_1) { this.phone_1 = phone_1;}
    public String getPhone_2() {return phone_2;}
    public void setPhone_2(String phone_2) {this.phone_2 = phone_2;}
    public String getPhone_3() {return phone_3;}
    public void setPhone_3(String phone_3) { this.phone_3 = phone_3;}
    public String getPhone_4() { return phone_4;}
    public void setPhone_4(String phone_4) {this.phone_4 = phone_4;}
    public String getPhone_5() {return phone_5;}
    public void setPhone_5(String phone_5) {this.phone_5 = phone_5;}
    public String getPhone_gsm1() {return phone_gsm1;}
    public void setPhone_gsm1(String phone_gsm1) {this.phone_gsm1 = phone_gsm1;}
    public String getPhone_gsm2() {return phone_gsm2;}
    public void setPhone_gsm2(String phone_gsm2) {this.phone_gsm2 = phone_gsm2;}
    public String getPhone_gsm3() {return phone_gsm3;}
    public void setPhone_gsm3(String phone_gsm3) {this.phone_gsm3 = phone_gsm3;}
    public String getPhone_fax1() { return phone_fax1;}
    public void setPhone_fax1(String phone_fax1) { this.phone_fax1 = phone_fax1;}
    public String getPhone_fax2() { return phone_fax2;}
    public void setPhone_fax2(String phone_fax2) {this.phone_fax2 = phone_fax2;}
    public boolean isPhone_isActive() {return phone_isActive;}
    public void setPhone_isActive(boolean phone_isActive) {this.phone_isActive = phone_isActive;}
    public Date getPhone_Modified() { return phone_Modified;}
    public void setPhone_Modified(Date phone_Modified) {this.phone_Modified = phone_Modified;}
    public String getPhone_Modifier() {return phone_Modifier;}
    public void setPhone_Modifier(String phone_Modifier) { this.phone_Modifier = phone_Modifier;}
    public Date getPhone_Created() { return phone_Created;}
    public void setPhone_Created(Date phone_Created) {this.phone_Created = phone_Created;}
    public String getPhone_creator() {return phone_creator;}
    public void setPhone_creator(String phone_creator) {this.phone_creator = phone_creator;}

    
    
}
