
package com.tasimacilar.ilan.system;

public class CountryList {
    
    
    private int id;
    private String countryCode;
    private String countryNameInt;
    private String countryNameTr;
   public CountryList() {
    } public CountryList(int id, String countryCode, String countryNameInt, String countryNameTr) {
        this.id = id;
        this.countryCode = countryCode;
        this.countryNameInt = countryNameInt;
        this.countryNameTr = countryNameTr;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) {this.countryCode = countryCode; }
    public String getCountryNameInt() {return countryNameInt; }
    public void setCountryNameInt(String countryNameInt) {this.countryNameInt = countryNameInt; }
    public String getCountryNameTr() {return countryNameTr; }
    public void setCountryNameTr(String countryNameTr) {this.countryNameTr = countryNameTr; }
   
}
