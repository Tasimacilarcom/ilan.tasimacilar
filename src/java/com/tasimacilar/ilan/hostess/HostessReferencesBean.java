package com.tasimacilar.ilan.hostess;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "hostessReferencesBean")
@ViewScoped
public class HostessReferencesBean implements Serializable{
    private String      hostessReferences_Id;
    private String      hostessReferences_Company;                 
    private String      hostessReferences_Project;                
    private Date        hostessReferences_ProjectStartDate;        
    private Date        hostessReferences_ProjectEndDate;          
    private int         hostessReferences_ProjectWorkingYear;    
    private Date        hostessReferences_Modified;            
    private String      hostessReferences_Modifier;              
    private Date        hostessReferences_Created;           
    private String      hostessReferences_creator;            
    private String      hostess_Id;                             
    @PostConstruct
    public void init() {     }
 public HostessReferencesBean() {  }
    public HostessReferencesBean(    String hostessReferences_Id, 
                                    String hostessReferences_Company, 
                                    String hostessReferences_Project, 
                                    Date hostessReferences_ProjectStartDate, 
                                    Date hostessReferences_ProjectEndDate, 
                                    Date hostessReferences_Modified, 
                                    String hostessReferences_Modifier, 
                                    Date hostessReferences_Created, 
                                    String hostessReferences_creator, 
                                    String hostess_Id) {
        this.hostessReferences_Id = hostessReferences_Id;
        this.hostessReferences_Company = hostessReferences_Company;
        this.hostessReferences_Project = hostessReferences_Project;
        this.hostessReferences_ProjectStartDate = hostessReferences_ProjectStartDate;
        this.hostessReferences_ProjectEndDate = hostessReferences_ProjectEndDate;
        this.hostessReferences_Modified = hostessReferences_Modified;
        this.hostessReferences_Modifier = hostessReferences_Modifier;
        this.hostessReferences_Created = hostessReferences_Created;
        this.hostessReferences_creator = hostessReferences_creator;
        this.hostess_Id = hostess_Id;
    }
    public String getHostessReferences_Id() {return hostessReferences_Id;}
    public void setHostessReferences_Id(String hostessReferences_Id) {this.hostessReferences_Id = hostessReferences_Id;}
    public String getHostessReferences_Company() {return hostessReferences_Company;}
    public void setHostessReferences_Company(String hostessReferences_Company) {this.hostessReferences_Company = hostessReferences_Company;}
    public String getHostessReferences_Project() {return hostessReferences_Project;}
    public void setHostessReferences_Project(String hostessReferences_Project) {this.hostessReferences_Project = hostessReferences_Project;}
    public Date getHostessReferences_ProjectStartDate() {return hostessReferences_ProjectStartDate;}
    public void setHostessReferences_ProjectStartDate(Date hostessReferences_ProjectStartDate) {this.hostessReferences_ProjectStartDate = hostessReferences_ProjectStartDate;}
    public Date getHostessReferences_ProjectEndDate() {return hostessReferences_ProjectEndDate;}
    public void setHostessReferences_ProjectEndDate(Date hostessReferences_ProjectEndDate) {this.hostessReferences_ProjectEndDate = hostessReferences_ProjectEndDate;}
    public int getHostessReferences_ProjectWorkingYear() {return hostessReferences_ProjectWorkingYear;}
    public void setHostessReferences_ProjectWorkingYear(int hostessReferences_ProjectWorkingYear) { this.hostessReferences_ProjectWorkingYear = hostessReferences_ProjectWorkingYear;}
    public Date getHostessReferences_Modified() {return hostessReferences_Modified;}
    public void setHostessReferences_Modified(Date hostessReferences_Modified) {this.hostessReferences_Modified = hostessReferences_Modified;}
    public String getHostessReferences_Modifier() {return hostessReferences_Modifier;}
    public void setHostessReferences_Modifier(String hostessReferences_Modifier) {this.hostessReferences_Modifier = hostessReferences_Modifier;}
    public Date getHostessReferences_Created() {return hostessReferences_Created;}
    public void setHostessReferences_Created(Date hostessReferences_Created) {this.hostessReferences_Created = hostessReferences_Created;}
    public String getHostessReferences_creator() {return hostessReferences_creator;}
    public void setHostessReferences_creator(String hostessReferences_creator) {this.hostessReferences_creator = hostessReferences_creator;}
    public String getHostess_Id() {return hostess_Id;}
    public void setHostess_Id(String hostess_Id) {this.hostess_Id = hostess_Id;}    

    
}
