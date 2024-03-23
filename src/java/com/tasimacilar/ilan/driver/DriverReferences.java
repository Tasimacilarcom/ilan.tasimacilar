package com.tasimacilar.ilan.driver;
import java.io.Serializable;
import java.util.Date;
public class DriverReferences implements Serializable{ 
    private String      driverReferences_Id;
    private String      driverReferences_Company;                 
    private String      driverReferences_Project;                 
    private Date        driverReferences_ProjectStartDate;         
    private Date        driverReferences_ProjectEndDate;         
    private int         driverReferences_ProjectWorkingYear;      
    private Date        driverReferences_Modified;               
    private String      driverReferences_Modifier;                
    private Date        driverReferences_Created;             
    private String      driverReferences_creator;               
    private String      driver_Id;                               
    public DriverReferences() { }
    public String getDriverReferences_Id() {return driverReferences_Id;}
    public void setDriverReferences_Id(String driverReferences_Id) {this.driverReferences_Id = driverReferences_Id;}
    public String getDriverReferences_Company() {return driverReferences_Company;}
    public void setDriverReferences_Company(String driverReferences_Company) {this.driverReferences_Company = driverReferences_Company;}
    public String getDriverReferences_Project() {return driverReferences_Project;}
    public void setDriverReferences_Project(String driverReferences_Project) {this.driverReferences_Project = driverReferences_Project;}
    public Date getDriverReferences_ProjectStartDate() {return driverReferences_ProjectStartDate;}
    public void setDriverReferences_ProjectStartDate(Date driverReferences_ProjectStartDate) {this.driverReferences_ProjectStartDate = driverReferences_ProjectStartDate;}
    public Date getDriverReferences_ProjectEndDate() {return driverReferences_ProjectEndDate;}
    public void setDriverReferences_ProjectEndDate(Date driverReferences_ProjectEndDate) {this.driverReferences_ProjectEndDate = driverReferences_ProjectEndDate;}
    public int getDriverReferences_ProjectWorkingYear() {return driverReferences_ProjectWorkingYear;}
    public void setDriverReferences_ProjectWorkingYear(int driverReferences_ProjectWorkingYear) {this.driverReferences_ProjectWorkingYear = driverReferences_ProjectWorkingYear;}  
    public Date getDriverReferences_Modified() {return driverReferences_Modified;}
    public void setDriverReferences_Modified(Date driverReferences_Modified) {this.driverReferences_Modified = driverReferences_Modified;}
    public String getDriverReferences_Modifier() {return driverReferences_Modifier;}
    public void setDriverReferences_Modifier(String driverReferences_Modifier) {this.driverReferences_Modifier = driverReferences_Modifier;}
    public Date getDriverReferences_Created() {return driverReferences_Created;}
    public void setDriverReferences_Created(Date driverReferences_Created) {this.driverReferences_Created = driverReferences_Created;}
    public String getDriverReferences_creator() {return driverReferences_creator;}
    public void setDriverReferences_creator(String driverReferences_creator) {this.driverReferences_creator = driverReferences_creator;}
    public String getDriver_Id() {return driver_Id;}
    public void setDriver_Id(String driver_Id) {this.driver_Id = driver_Id;}    

    
}
