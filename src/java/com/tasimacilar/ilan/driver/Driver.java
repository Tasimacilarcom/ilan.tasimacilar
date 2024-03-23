package com.tasimacilar.ilan.driver;
import java.io.Serializable;
import java.util.Date;
public class Driver implements Serializable{
    private String      driver_Id;                                 
    private String      driver_FirstName;                         
    private String      driver_LastName;                         
    private String      driver_EmailAddress;                       
    private String      driver_MobilePhoneNumber;               
    private String      driver_Gender;                             
    private Date        driver_BirthDate;                      
    private String      driver_PlaceOfBirth;                       
    private String      driver_Education;                        
    private String      driver_DriversLicense;                   
    private String[]    driver_DriversLicenses;                   
    private Date        driver_DriversLicenseYear;                
    private float       driver_Fee;                               
    private boolean     driver_ServiceTransportationExperience;   
    private int         driver_Experience;                         
    private String      driver_ProfilePictureUrl;                   
    private boolean     driver_ProfilePicturePublish;              
    private boolean     driver_Retired;                         
    private boolean     driver_CriminalRecord;                   
    private boolean     driver_CertificateOfProfessionalCompetence; 
    private String      driver_BusinessPreference;                 
    private boolean     driver_DoYouHaveHostess;                  
    private boolean     driver_ExtraJobs;                          
    private boolean     driver_IsActive;                          
    private String      driver_Commnet;                           
    private Date        driver_Modified;                          
    private String      driver_Modifier;                           
    private Date        driver_Created;                           
    private String      driver_creator;                           
    private String      driver_RequestedDocumentes;              
    private String[]    driver_RequestedDocumentesList;            
    private String      driver_ForeignLanguages;                    
    private String[]    driver_ForeignLanguagesList;              
    private String      driver_VehicleTypes;                     
    private String[]    driver_VehicleTypesList;                 
    private int         driver_yasi;                              
        public Driver() { }
    public String getDriver_Id() {return driver_Id;}
    public void setDriver_Id(String driver_Id) {this.driver_Id = driver_Id;}
    public String getDriver_FirstName() {return driver_FirstName;}
    public void setDriver_FirstName(String driver_FirstName) {this.driver_FirstName = driver_FirstName;}
    public String getDriver_LastName() {return driver_LastName;}
    public void setDriver_LastName(String driver_LastName) {this.driver_LastName = driver_LastName;}
    public String getDriver_EmailAddress() {return driver_EmailAddress;}
    public void setDriver_EmailAddress(String driver_EmailAddress) {this.driver_EmailAddress = driver_EmailAddress;}
    public String getDriver_MobilePhoneNumber() {return driver_MobilePhoneNumber;}
    public void setDriver_MobilePhoneNumber(String driver_MobilePhoneNumber) {this.driver_MobilePhoneNumber = driver_MobilePhoneNumber;}
    public String getDriver_Gender() {return driver_Gender;}
    public void setDriver_Gender(String driver_Gender) {this.driver_Gender = driver_Gender;}
    public Date getDriver_BirthDate() {return driver_BirthDate;}
    public void setDriver_BirthDate(Date driver_BirthDate) {this.driver_BirthDate = driver_BirthDate;}
    public String getDriver_PlaceOfBirth() {return driver_PlaceOfBirth;}
    public void setDriver_PlaceOfBirth(String driver_PlaceOfBirth) {this.driver_PlaceOfBirth = driver_PlaceOfBirth;}
    public String getDriver_Education() {return driver_Education;}
    public void setDriver_Education(String driver_Education) {this.driver_Education = driver_Education;}
    public String getDriver_DriversLicense() {return driver_DriversLicense;}
    public void setDriver_DriversLicense(String driver_DriversLicense) {this.driver_DriversLicense = driver_DriversLicense;}
    public String[] getDriver_DriversLicenses() {return driver_DriversLicenses;}
    public void setDriver_DriversLicenses(String[] driver_DriversLicenses) {this.driver_DriversLicenses = driver_DriversLicenses;}
    public Date getDriver_DriversLicenseYear() {return driver_DriversLicenseYear;}
    public void setDriver_DriversLicenseYear(Date driver_DriversLicenseYear) {this.driver_DriversLicenseYear = driver_DriversLicenseYear;}
    public float getDriver_Fee() {return driver_Fee;}
    public void setDriver_Fee(float driver_Fee) {this.driver_Fee = driver_Fee;}
    public boolean isDriver_ServiceTransportationExperience() {return driver_ServiceTransportationExperience;}
    public void setDriver_ServiceTransportationExperience(boolean driver_ServiceTransportationExperience) {this.driver_ServiceTransportationExperience = driver_ServiceTransportationExperience;}
    public int getDriver_Experience() {return driver_Experience;}
    public void setDriver_Experience(int driver_Experience) {this.driver_Experience = driver_Experience;}
    public String getDriver_ProfilePictureUrl() {return driver_ProfilePictureUrl;}
    public void setDriver_ProfilePictureUrl(String driver_ProfilePictureUrl) {this.driver_ProfilePictureUrl = driver_ProfilePictureUrl;}
    public boolean isDriver_ProfilePicturePublish() {return driver_ProfilePicturePublish;}
    public void setDriver_ProfilePicturePublish(boolean driver_ProfilePicturePublish) {this.driver_ProfilePicturePublish = driver_ProfilePicturePublish;}
    public boolean isDriver_Retired() {return driver_Retired;}
    public void setDriver_Retired(boolean driver_Retired) {this.driver_Retired = driver_Retired;}
    public boolean isDriver_CriminalRecord() {return driver_CriminalRecord;}
    public void setDriver_CriminalRecord(boolean driver_CriminalRecord) {this.driver_CriminalRecord = driver_CriminalRecord;}
    public boolean isDriver_CertificateOfProfessionalCompetence() {return driver_CertificateOfProfessionalCompetence;}
    public void setDriver_CertificateOfProfessionalCompetence(boolean driver_CertificateOfProfessionalCompetence) {this.driver_CertificateOfProfessionalCompetence = driver_CertificateOfProfessionalCompetence;}
    public String getDriver_BusinessPreference() {return driver_BusinessPreference;}
    public void setDriver_BusinessPreference(String driver_BusinessPreference) {this.driver_BusinessPreference = driver_BusinessPreference;}
    public boolean isDriver_DoYouHaveHostess() {return driver_DoYouHaveHostess;}
    public void setDriver_DoYouHaveHostess(boolean driver_DoYouHaveHostess) {this.driver_DoYouHaveHostess = driver_DoYouHaveHostess;}
    public boolean isDriver_ExtraJobs() {return driver_ExtraJobs;}
    public void setDriver_ExtraJobs(boolean driver_ExtraJobs) {this.driver_ExtraJobs = driver_ExtraJobs;}
    public boolean isDriver_IsActive() {return driver_IsActive;}
    public void setDriver_IsActive(boolean driver_IsActive) {this.driver_IsActive = driver_IsActive;}
    public String getDriver_Commnet() {return driver_Commnet;}
    public void setDriver_Commnet(String driver_Commnet) {this.driver_Commnet = driver_Commnet;}
    public Date getDriver_Modified() {return driver_Modified;}
    public void setDriver_Modified(Date driver_Modified) {this.driver_Modified = driver_Modified;}
    public String getDriver_Modifier() {return driver_Modifier;}
    public void setDriver_Modifier(String driver_Modifier) {this.driver_Modifier = driver_Modifier;}
    public Date getDriver_Created() {return driver_Created;}
    public void setDriver_Created(Date driver_Created) {this.driver_Created = driver_Created;}
    public String getDriver_creator() {return driver_creator;}
    public void setDriver_creator(String driver_creator) {this.driver_creator = driver_creator;}
    public String getDriver_RequestedDocumentes() {return driver_RequestedDocumentes;}
    public void setDriver_RequestedDocumentes(String driver_RequestedDocumentes) {this.driver_RequestedDocumentes = driver_RequestedDocumentes;}
    public String[] getDriver_RequestedDocumentesList() { return driver_RequestedDocumentesList;}
    public void setDriver_RequestedDocumentesList(String[] driver_RequestedDocumentesList) {this.driver_RequestedDocumentesList = driver_RequestedDocumentesList;}
    public String getDriver_ForeignLanguages() {return driver_ForeignLanguages;}
    public void setDriver_ForeignLanguages(String driver_ForeignLanguages) {this.driver_ForeignLanguages = driver_ForeignLanguages;}
    public String[] getDriver_ForeignLanguagesList() { return driver_ForeignLanguagesList;}
    public void setDriver_ForeignLanguagesList(String[] driver_ForeignLanguagesList) { this.driver_ForeignLanguagesList = driver_ForeignLanguagesList;}
    public String getDriver_VehicleTypes() { return driver_VehicleTypes;}
    public void setDriver_VehicleTypes(String driver_VehicleTypes) { this.driver_VehicleTypes = driver_VehicleTypes;}
    public String[] getDriver_VehicleTypesList() {return driver_VehicleTypesList;}
    public void setDriver_VehicleTypesList(String[] driver_VehicleTypesList) {  this.driver_VehicleTypesList = driver_VehicleTypesList;}  
    public int getDriver_yasi() { return driver_yasi;  }
    public void setDriver_yasi(int driver_yasi) {  this.driver_yasi = driver_yasi; }

    
    
    
}
