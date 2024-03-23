package com.tasimacilar.ilan.profile.account.corporate;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "companyReferencesBean")
@ViewScoped
public class CompanyReferencesBean implements Serializable{
    private String      companyReferences_Id;
    private String      companyReferences_Company;                  
    private String      companyReferences_Project;                  
    private Date        companyReferences_ProjectStartDate;        
    private Date        companyReferences_ProjectEndDate;         
    private int         companyReferences_ProjectWorkingYear;       
    private Date        companyReferences_Modified;               
    private String      companyReferences_Modifier;                
    private Date        companyReferences_Created;               
    private String      companyReferences_creator;                
    private String      company_Id;                               
     public CompanyReferencesBean() { }
    public CompanyReferencesBean( String companyReferences_Id, 
                                    String companyReferences_Company, 
                                    String companyReferences_Project, 
                                    Date companyReferences_ProjectStartDate, 
                                    Date companyReferences_ProjectEndDate, 
                                    int companyReferences_ProjectWorkingYear, 
                                    Date companyReferences_Modified, 
                                    String companyReferences_Modifier, 
                                    Date companyReferences_Created, 
                                    String companyReferences_creator, 
                                    String company_Id) {
        this.companyReferences_Id = companyReferences_Id;
        this.companyReferences_Company = companyReferences_Company;
        this.companyReferences_Project = companyReferences_Project;
        this.companyReferences_ProjectStartDate = companyReferences_ProjectStartDate;
        this.companyReferences_ProjectEndDate = companyReferences_ProjectEndDate;
        this.companyReferences_ProjectWorkingYear = companyReferences_ProjectWorkingYear;
        this.companyReferences_Modified = companyReferences_Modified;
        this.companyReferences_Modifier = companyReferences_Modifier;
        this.companyReferences_Created = companyReferences_Created;
        this.companyReferences_creator = companyReferences_creator;
        this.company_Id = company_Id;  }
    public String getCompanyReferences_Id() { return companyReferences_Id;}
    public void setCompanyReferences_Id(String companyReferences_Id) { this.companyReferences_Id = companyReferences_Id;}
    public String getCompanyReferences_Company() { return companyReferences_Company;}
    public void setCompanyReferences_Company(String companyReferences_Company) { this.companyReferences_Company = companyReferences_Company;}
    public String getCompanyReferences_Project() {  return companyReferences_Project;}
    public void setCompanyReferences_Project(String companyReferences_Project) { this.companyReferences_Project = companyReferences_Project;}
    public Date getCompanyReferences_ProjectStartDate() { return companyReferences_ProjectStartDate;}
    public void setCompanyReferences_ProjectStartDate(Date companyReferences_ProjectStartDate) { this.companyReferences_ProjectStartDate = companyReferences_ProjectStartDate;}
    public Date getCompanyReferences_ProjectEndDate() { return companyReferences_ProjectEndDate;}
    public void setCompanyReferences_ProjectEndDate(Date companyReferences_ProjectEndDate) {this.companyReferences_ProjectEndDate = companyReferences_ProjectEndDate;}
    public int getCompanyReferences_ProjectWorkingYear() { return companyReferences_ProjectWorkingYear;}
    public void setCompanyReferences_ProjectWorkingYear(int companyReferences_ProjectWorkingYear) {this.companyReferences_ProjectWorkingYear = companyReferences_ProjectWorkingYear;}
    public Date getCompanyReferences_Modified() { return companyReferences_Modified;}
    public void setCompanyReferences_Modified(Date companyReferences_Modified) { this.companyReferences_Modified = companyReferences_Modified;}
    public String getCompanyReferences_Modifier() {  return companyReferences_Modifier;}
    public void setCompanyReferences_Modifier(String companyReferences_Modifier) { this.companyReferences_Modifier = companyReferences_Modifier;}
    public Date getCompanyReferences_Created() { return companyReferences_Created;}
    public void setCompanyReferences_Created(Date companyReferences_Created) { this.companyReferences_Created = companyReferences_Created;}
    public String getCompanyReferences_creator() { return companyReferences_creator;}
    public void setCompanyReferences_creator(String companyReferences_creator) {this.companyReferences_creator = companyReferences_creator;}
    public String getCompany_Id() { return company_Id;}
    public void setCompany_Id(String company_Id) {  this.company_Id = company_Id;}
  
    
    
    
}
