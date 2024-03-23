package com.tasimacilar.ilan.ad.search;
import com.tasimacilar.ilan.ad.Ad_Bean;
import com.tasimacilar.ilan.system.loging.LogManagerDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "adSearchBean")
@ViewScoped
public class Ad_Search_Bean implements Serializable{  Ad_Search_InputEntity   adSearchInputEntity;  @PostConstruct public void init() { 
        String[] s ={"İSTANBUL"};
        String[] aracMarka ={"0"};
        String[] aracModel ={"Farketmez"};
        String[] aracKapasitesi ={"Farketmez"};
        adSearchInputEntity = new Ad_Search_InputEntity();
        adSearchInputEntity.setFltr_AdRoute_StartPosition_City(s);
        adSearchInputEntity.setFltr_AdRoute_EndPosition_City(s);
        adSearchInputEntity.setFltr_Vehicle_BrandIds(aracMarka);
        adSearchInputEntity.setFltr_Vehicle_Model(aracModel);
        adSearchInputEntity.setFltr_Vehicle_NumberOfSeats(aracKapasitesi);
    }
public Ad_Search_InputEntity getAdSearchInputEntity() { return adSearchInputEntity;  }
    public void setAdSearchInputEntity(Ad_Search_InputEntity adSearchInputEntity) {  this.adSearchInputEntity = adSearchInputEntity;   }
   public void clearadSearchInputEntity (){
        String[] s ={"İSTANBUL"};
        String[] aracMarka ={"0"};
        String[] aracModel ={"Farketmez"};
        String[] aracKapasitesi ={"Farketmez"};
        adSearchInputEntity = new Ad_Search_InputEntity();
        adSearchInputEntity.setFltr_AdRoute_StartPosition_City(s);
        adSearchInputEntity.setFltr_AdRoute_EndPosition_City(s);
        adSearchInputEntity.setFltr_Vehicle_BrandIds(aracMarka);
        adSearchInputEntity.setFltr_Vehicle_Model(aracModel);
        adSearchInputEntity.setFltr_Vehicle_NumberOfSeats(aracKapasitesi);
    }public List<Ad_Bean> findAd(String searchTyp){   
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        if(searchTyp != null && !searchTyp.equals("")){
            if(searchTyp.equals("DetailedSearch")){
                    if(adSearchInputEntity.getFltr_Ad_CategoryId()==1){ String[] FarkEtmez = {"FarkEtmez"};                      
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());                    
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town());                    
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList();                        
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa);                       
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;}                       
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }                       
                        if(andl){outList.addAll(anadoluList);}
                        else if(avrp){outList.addAll(avrupaList);}                       
                        String[] outListx = outList.toArray(new String[0]);                      
                        adse.setFltr_AdRoute_StartPosition_Town(outListx);                        
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(adSearchInputEntity.getFltr_AdRoute_EndPosition_City()); 
                        List<String> inList2 = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town());
                        boolean andl2 = false;
                        boolean avrp2 = false;
                        List<String> outList2 = new ArrayList();                     
                        String[] avrupa2 = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu2 = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList2 = Arrays.asList(anadolu2);
                        List<String> avrupaList2 = Arrays.asList(avrupa2);                   
                        if(inList2.contains("ANADOLU YAKASI")){andl2=true;}
                        else if(inList2.contains("AVRUPA YAKASI")){avrp2=true;}     
                        for (String str : inList2) {
                            if(andl2){ if(!anadoluList2.contains(str)){outList2.add(str);}  }
                            else if(avrp2){ if(!avrupaList2.contains(str)){outList2.add(str);} }  
                            else{outList2.add(str);}
                        }  
                        if(andl2){outList2.addAll(anadoluList2);}
                        else if(avrp2){outList2.addAll(avrupaList2);}   
                        String[] outListx2 = outList2.toArray(new String[0]);    
                        adse.setFltr_AdRoute_EndPosition_Town(outListx2); 
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_IsimVarAracAriyorum(adse);                     
                    } if(adSearchInputEntity.getFltr_Ad_CategoryId()==2){
                        String[] FarkEtmez = {"FarkEtmez"};                       
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());                     
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town());                
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList(); 
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa);
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;}
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }  
                        if(andl){outList.addAll(anadoluList);}
                        else if(avrp){outList.addAll(avrupaList);} 
                        String[] outListx = outList.toArray(new String[0]); 
                        adse.setFltr_AdRoute_StartPosition_Town(outListx); 
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_AracimVarIsAriyorum(adse);
                    } if(adSearchInputEntity.getFltr_Ad_CategoryId()==3){
                        String[] FarkEtmez = {"FarkEtmez"};
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());                     
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town());                     
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList();                       
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa);                       
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;}                      
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }                      
                        if(andl){outList.addAll(anadoluList);}
                        else if(avrp){outList.addAll(avrupaList);}                       
                        String[] outListx = outList.toArray(new String[0]);                        
                        adse.setFltr_AdRoute_StartPosition_Town(outListx);                       
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(adSearchInputEntity.getFltr_AdRoute_EndPosition_City());        
                        List<String> inList2 = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town());                     
                        boolean andl2 = false;
                        boolean avrp2 = false;
                        List<String> outList2 = new ArrayList();                       
                        String[] avrupa2 = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu2 = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList2 = Arrays.asList(anadolu2);
                        List<String> avrupaList2 = Arrays.asList(avrupa2);                      
                        if(inList2.contains("ANADOLU YAKASI")){andl2=true;}
                        else if(inList2.contains("AVRUPA YAKASI")){avrp2=true;}                       
                        for (String str : inList2) {
                            if(andl2){ if(!anadoluList2.contains(str)){outList2.add(str);}  }
                            else if(avrp2){ if(!avrupaList2.contains(str)){outList2.add(str);} }  
                            else{outList2.add(str);} }                       
                        if(andl2){outList2.addAll(anadoluList2);}
                        else if(avrp2){outList2.addAll(avrupaList2);}                      
                        String[] outListx2 = outList2.toArray(new String[0]);                      
                        adse.setFltr_AdRoute_EndPosition_Town(outListx2);                      
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_AracimVarSoforAriyorum(adse);                       
                    }if(adSearchInputEntity.getFltr_Ad_CategoryId()==4){ String[] FarkEtmez = {"FarkEtmez"}; Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());                    
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town());                   
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList();                      
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa);                     
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;}                       
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }                       
                        if(andl){outList.addAll(anadoluList);}
                        else if(avrp){outList.addAll(avrupaList);}                      
                        String[] outListx = outList.toArray(new String[0]);                      
                        adse.setFltr_AdRoute_StartPosition_Town(outListx);                   
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(adSearchInputEntity.getFltr_AdRoute_EndPosition_City());
                        List<String> inList2 = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_EndPosition_Town());
                        boolean andl2 = false;
                        boolean avrp2 = false;
                        List<String> outList2 = new ArrayList();  
                        String[] avrupa2 = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu2 = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList2 = Arrays.asList(anadolu2);
                        List<String> avrupaList2 = Arrays.asList(avrupa2); 
                        if(inList2.contains("ANADOLU YAKASI")){andl2=true;}
                        else if(inList2.contains("AVRUPA YAKASI")){avrp2=true;}
                        for (String str : inList2) {
                            if(andl2){ if(!anadoluList2.contains(str)){outList2.add(str);}  }
                            else if(avrp2){ if(!avrupaList2.contains(str)){outList2.add(str);} }  
                            else{outList2.add(str);}
                        } 
                        if(andl2){outList2.addAll(anadoluList2);}
                        else if(avrp2){outList2.addAll(avrupaList2);}  
                        String[] outListx2 = outList2.toArray(new String[0]);  
                        adse.setFltr_AdRoute_EndPosition_Town(outListx2);   
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_AracimVarHostesAriyorum(adse);    }if(adSearchInputEntity.getFltr_Ad_CategoryId()==5){
                        String[] FarkEtmez = {"FarkEtmez"};                 
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());                     
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town());                    
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList();                     
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa); 
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;} 
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }  if(andl){outList.addAll(anadoluList);} else if(avrp){outList.addAll(avrupaList);}                    
                        String[] outListx = outList.toArray(new String[0]);                     
                        adse.setFltr_AdRoute_StartPosition_Town(outListx);        
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_HostesimIsAriyorum(adse);  } if(adSearchInputEntity.getFltr_Ad_CategoryId()==6){
                          String[] FarkEtmez = {"FarkEtmez"};
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(adSearchInputEntity.getFltr_Vehicle_BrandIds());
                        adse.setFltr_Vehicle_Model(adSearchInputEntity.getFltr_Vehicle_Model());
                        adse.setFltr_Vehicle_ModelYear(adSearchInputEntity.getFltr_Vehicle_ModelYear());
                        adse.setFltr_Vehicle_ModelYearAndOver(adSearchInputEntity.isFltr_Vehicle_ModelYearAndOver());
                        adse.setFltr_Vehicle_NumberOfSeats(adSearchInputEntity.getFltr_Vehicle_NumberOfSeats());
                        adse.setFltr_Vehicle_ServiceTypes(adSearchInputEntity.getFltr_Vehicle_ServiceTypes());
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(adSearchInputEntity.getFltr_AdRoute_StartTime());
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(adSearchInputEntity.getFltr_AdRoute_StartPosition_City());
                        List<String> inList = Arrays.asList(adSearchInputEntity.getFltr_AdRoute_StartPosition_Town()); 
                        boolean andl = false;
                        boolean avrp = false;
                        List<String> outList = new ArrayList();  
                        String[] avrupa = {"ARNAVUTKÖY","AVCILAR", "BAĞCILAR", "BAHÇELİEVLER", "BAKIRKÖY", "BAŞAKŞEHİR", "BAYRAMPAŞA", "BEŞİKTAŞ", "BEYLİKDÜZÜ", "BEYOĞLU", "BÜYÜKÇEKMECE", "ÇATALCA", "ESENLER", "ESENYURT", "EYÜPSULTAN", "FATİH", "GAZİOSMANPAŞA", "GÜNGÖREN", "KAĞITHANE", "KÜÇÜKÇEKMECE", "SARIYER", "SİLİVRİ", "SULTANGAZİ", "ŞİŞLİ", "ZEYTİNBURNU"};
                        String[] anadolu = {"ADALAR","ATAŞEHİR","BEYKOZ","ÇEKMEKÖY", "KADIKÖY", "KARTAL", "MALTEPE", "PENDİK", "SANCAKTEPE", "SULTANBEYLİ", "ŞİLE", "TUZLA", "ÜMRANİYE", "ÜSKÜDAR"};    
                        List<String> anadoluList = Arrays.asList(anadolu);
                        List<String> avrupaList = Arrays.asList(avrupa);
                        if(inList.contains("ANADOLU YAKASI")){andl=true;}
                        else if(inList.contains("AVRUPA YAKASI")){avrp=true;}
                        for (String str : inList) {
                            if(andl){ if(!anadoluList.contains(str)){outList.add(str);}  }
                            else if(avrp){ if(!avrupaList.contains(str)){outList.add(str);} }  
                            else{outList.add(str);}
                        }
                        if(andl){outList.addAll(anadoluList);}
                        else if(avrp){outList.addAll(avrupaList);}
                        String[] outListx = outList.toArray(new String[0]);
                        adse.setFltr_AdRoute_StartPosition_Town(outListx);
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(adSearchInputEntity.getFltr_AdRoute_EndTime());
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_SoforumIsAriyorum(adse);
                    }if(adSearchInputEntity.getFltr_Ad_CategoryId()==7){String[] FarkEtmez = {"FarkEtmez"};                        
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(adSearchInputEntity.getFltr_Ad_CategoryId());
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(FarkEtmez);
                        adse.setFltr_Vehicle_Model(FarkEtmez);
                        adse.setFltr_Vehicle_ModelYear("FarkEtmez");
                        adse.setFltr_Vehicle_ModelYearAndOver(false);
                        adse.setFltr_Vehicle_NumberOfSeats(FarkEtmez);
                        adse.setFltr_Vehicle_ServiceTypes(FarkEtmez);
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(null);
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(null);
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_DetailedSearch_PlakamiSatiyorum(adse);     } if( adSearchInputEntity.getFltr_Ad_CategoryId() == 0 ){ String[] FarkEtmez = {"FarkEtmez"};                       
                        Ad_Search_Dao adsd = new Ad_Search_Dao();
                        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                        adse.setFltr_SearchTyp("DetailedSearch");
                        adse.setFltr_SortType("DESC");
                        adse.setFltr_Ad_Id("FarkEtmez");
                        adse.setFltr_Ad_CategoryId(0);
                        adse.setFltr_Ad_Comment("FarkEtmez");
                        adse.setFltr_Ad_Type(FarkEtmez);
                        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                        adse.setFltr_Ad_IsActive(true);
                        adse.setFltr_Ad_EndTime(new Date());
                        adse.setFltr_Ad_CreateTime(new Date());
                        adse.setFltr_Ad_IsPublish(true);
                        adse.setFltr_Ad_PublishDate(null);
                        adse.setFltr_Ad_WhatTime(adSearchInputEntity.fltr_Ad_WhatTime);
                        adse.setFltr_CompanyId(adSearchInputEntity.getFltr_CompanyId());
                        adse.setFltr_Vehicle_PlateProvinceCode(0);
                        adse.setFltr_Vehicle_BrandIds(FarkEtmez);
                        adse.setFltr_Vehicle_Model(FarkEtmez);
                        adse.setFltr_Vehicle_ModelYear("FarkEtmez");
                        adse.setFltr_Vehicle_ModelYearAndOver(false);
                        adse.setFltr_Vehicle_NumberOfSeats(FarkEtmez);
                        adse.setFltr_Vehicle_ServiceTypes(FarkEtmez);
                        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                        adse.setFltr_Vehicle_Properties(FarkEtmez);
                        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                        adse.setFltr_AdRoute_StartTime(null);
                        adse.setFltr_AdRoute_StartPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_StartPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                        adse.setFltr_AdRoute_EndTime(null);
                        adse.setFltr_AdRoute_EndPosition_Country("Türkiye");
                        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                        adList = adsd.getAdSearch_AllForCatZero(adse);    }   } else if(searchTyp.equals("SingularSearch-Brand")){  }  else if(searchTyp.equals("SingularSearch-NumberOfSeats")){ } else if(searchTyp.equals("All")){
               String[] FarkEtmez = {"FarkEtmez"};
                Ad_Search_Dao adsd = new Ad_Search_Dao();
                Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
                adse.setFltr_SearchTyp("All");
                adse.setFltr_SortType("DESC");
                adse.setFltr_Ad_Id("FarkEtmez");
                adse.setFltr_Ad_CategoryId(0);
                adse.setFltr_Ad_Comment("FarkEtmez");
                adse.setFltr_Ad_Type(FarkEtmez);
                adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
                adse.setFltr_Ad_IsActive(true);
                adse.setFltr_Ad_EndTime(null);
                adse.setFltr_Ad_CreateTime(null);
                adse.setFltr_Ad_IsPublish(true);
                adse.setFltr_Ad_PublishDate(null);
                adse.setFltr_Ad_WhatTime("last3Days");
                adse.setFltr_CompanyId("FarkEtmez");
                adse.setFltr_Vehicle_PlateProvinceCode(0);
                adse.setFltr_Vehicle_BrandIds(FarkEtmez);
                adse.setFltr_Vehicle_Model(FarkEtmez);
                adse.setFltr_Vehicle_ModelYear("FarkEtmez");
                adse.setFltr_Vehicle_ModelYearAndOver(false);
                adse.setFltr_Vehicle_NumberOfSeats(FarkEtmez);
                adse.setFltr_Vehicle_ServiceTypes(FarkEtmez);
                adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
                adse.setFltr_Vehicle_Properties(FarkEtmez);
                adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
                adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
                adse.setFltr_AdRoute_StartTime(null);
                adse.setFltr_AdRoute_StartPosition_Country("FarkEtmez");
                adse.setFltr_AdRoute_StartPosition_City(FarkEtmez);
                adse.setFltr_AdRoute_StartPosition_Town(FarkEtmez);
                adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
                adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
                adse.setFltr_AdRoute_EndTime(null);
                adse.setFltr_AdRoute_EndPosition_Country("FarkEtmez");
                adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
                adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
                adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
                adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
                adList = adsd.getAdSearch_All(adse);
            }  }
        else{
            System.err.println(":::ERROR::: Time=["+new Date()
                                       +"] Class=["+this.getClass().getName()
                                      +"] Method=["+new Object(){}.getClass().getEnclosingMethod().getName()
                                     +"] Message=[Arama yapmak icin gereken arama tipi parametresi bos veya nul geldi.]:::");
            LogManagerDao.createLog("error", this.getClass().getName(), "Arama yapmak icin gereken arama tipi parametresi bos veya nul geldi.", "system");
        } return adList; } public List<Ad_Bean> findAllForCompany(String companyId){ 
        
        List<Ad_Bean> adList = new ArrayList<Ad_Bean>();
        String[] FarkEtmez = {"FarkEtmez"};
        Ad_Search_Dao adsd = new Ad_Search_Dao();
        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
        adse.setFltr_SearchTyp("AllForCompany");
        adse.setFltr_SortType("DESC");
        adse.setFltr_Ad_Id("FarkEtmez");
        adse.setFltr_Ad_CategoryId(0);
        adse.setFltr_Ad_Comment("FarkEtmez");
        adse.setFltr_Ad_Type(FarkEtmez);
        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
        adse.setFltr_Ad_IsActive(true);
        adse.setFltr_Ad_EndTime(null);
        adse.setFltr_Ad_CreateTime(null);
        adse.setFltr_Ad_IsPublish(true);
        adse.setFltr_Ad_PublishDate(null);
        adse.setFltr_Ad_WhatTime("last3Days");
        adse.setFltr_CompanyId(companyId);
        adse.setFltr_Vehicle_PlateProvinceCode(0);
        adse.setFltr_Vehicle_BrandIds(FarkEtmez);
        adse.setFltr_Vehicle_Model(FarkEtmez);
        adse.setFltr_Vehicle_ModelYear("FarkEtmez");
        adse.setFltr_Vehicle_ModelYearAndOver(false);
        adse.setFltr_Vehicle_NumberOfSeats(FarkEtmez);
        adse.setFltr_Vehicle_ServiceTypes(FarkEtmez);
        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
        adse.setFltr_Vehicle_Properties(FarkEtmez);
        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
        adse.setFltr_AdRoute_StartTime(null);
        adse.setFltr_AdRoute_StartPosition_Country("FarkEtmez");
        adse.setFltr_AdRoute_StartPosition_City(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_Town(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
        adse.setFltr_AdRoute_EndTime(null);
        adse.setFltr_AdRoute_EndPosition_Country("FarkEtmez");
        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
        adList = adsd.getAdSearch_AllForCompany(adse);           
        return adList; 
    } public List<Ad_Bean> findAllForCategory(int catId){  List<Ad_Bean> adList = new ArrayList<Ad_Bean>();  String[] FarkEtmez = {"FarkEtmez"};
        Ad_Search_Dao adsd = new Ad_Search_Dao();
        Ad_Search_InputEntity adse = new Ad_Search_InputEntity();
        adse.setFltr_SearchTyp("AllForCategory");
        adse.setFltr_SortType("DESC");
        adse.setFltr_Ad_Id("FarkEtmez");
        adse.setFltr_Ad_CategoryId(catId);
        adse.setFltr_Ad_Comment("FarkEtmez");
        adse.setFltr_Ad_Type(FarkEtmez);
        adse.setFltr_Ad_OvnerAccountId("FarkEtmez");
        adse.setFltr_Ad_IsActive(true);
        adse.setFltr_Ad_EndTime(null);
        adse.setFltr_Ad_CreateTime(null);
        adse.setFltr_Ad_IsPublish(true);
        adse.setFltr_Ad_PublishDate(null);
        adse.setFltr_Ad_WhatTime("last3Days");
        adse.setFltr_CompanyId("FarkEtmez");
        adse.setFltr_Vehicle_PlateProvinceCode(0);
        adse.setFltr_Vehicle_BrandIds(FarkEtmez);
        adse.setFltr_Vehicle_Model(FarkEtmez);
        adse.setFltr_Vehicle_ModelYear("FarkEtmez");
        adse.setFltr_Vehicle_ModelYearAndOver(false);
        adse.setFltr_Vehicle_NumberOfSeats(FarkEtmez);
        adse.setFltr_Vehicle_ServiceTypes(FarkEtmez);
        adse.setFltr_Vehicle_AuthorityDocuments(FarkEtmez);
        adse.setFltr_Vehicle_Properties(FarkEtmez);
        adse.setFltr_Vehicle_DriverInfo("FarkEtmez");
        adse.setFltr_Vehicle_HostessInfo("FarkEtmez");
        adse.setFltr_AdRoute_StartTime(null);
        adse.setFltr_AdRoute_StartPosition_Country("FarkEtmez");
        adse.setFltr_AdRoute_StartPosition_City(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_Town(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_District(FarkEtmez);
        adse.setFltr_AdRoute_StartPosition_Neighborhood(FarkEtmez);
        adse.setFltr_AdRoute_EndTime(null);
        adse.setFltr_AdRoute_EndPosition_Country("FarkEtmez");
        adse.setFltr_AdRoute_EndPosition_City(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_Town(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_District(FarkEtmez);
        adse.setFltr_AdRoute_EndPosition_Neighborhood(FarkEtmez);
        adList = adsd.getAdSearch_AllForCategory(adse);        
        return adList;
    } }
