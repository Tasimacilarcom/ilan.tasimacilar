package com.tasimacilar.ilan.vehicle;
import com.tasimacilar.ilan.system.Messages;
import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import com.tasimacilar.ilan.system.fileUpload.FileUpload;
import com.tasimacilar.ilan.system.fileUpload.Functions;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.PrimeFaces;
@ManagedBean(name = "vehicleImagesBean")
@ViewScoped
public class VehicleImagesBean implements Serializable{
    private VehicleImages   vehicleImages;   
    private Collection<Part>    vehicleImagesGallery;
    private List<Part>          selectedVehicleImagesGallery = new ArrayList<Part>();
    private String              selectedVehicleImages = "";
    private String          vehicleImageProfilePhotoSubmittedFileName;
    private Part        vehicleVideoFile;
    private String      vehicleVideoSubmittedFileName;
    private String      pageNo;
    private String      vParam2 = "";
    private String      urlPath="";
    private String      aId;
    private boolean     Imagesrecordable;
    private int         totalUploadFile;
    
    @PostConstruct
    public void init() { 
        vehicleImages = new VehicleImages();
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        aId = req.getParameter("aId");
        String url = req.getRequestURL().toString();
        
        try {    URL urlx = new URL(url);  
            
                this.urlPath = FilenameUtils.getBaseName(urlx.getPath());
       
                
      

        } 
        catch (MalformedURLException ex) {System.out.println(":::HATA:::"+ex);    }
        
        
        
        
        String vId = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(facesContext != null){
            
            vehicleImages.setVehicle_Id(facesContext.getExternalContext().getRequestParameterMap().get("vId")); 
            this.vParam2= facesContext.getExternalContext().getRequestParameterMap().get("vParam2");
                
            if(vParam2 != null && vParam2.equals("ad") && pageNo != null && pageNo.equals("s4")){
                getvehicleImagesWithVehicleId(vehicleImages.getVehicle_Id());
            }
        }
    
    }
    public VehicleImagesBean() {
    }
    public Collection<Part> getVehicleImagesGallery() { return vehicleImagesGallery;}
    public void setVehicleImagesGallery(Collection<Part> vehicleImagesGallery) {  this.vehicleImagesGallery = vehicleImagesGallery;}
    public Part getVehicleVideoFile() {return vehicleVideoFile;}
    public void setVehicleVideoFile(Part vehicleVideoFile) { this.vehicleVideoFile = vehicleVideoFile;}
    public String getSelectedVehicleImages() {return selectedVehicleImages;}
    public void setSelectedVehicleImages(String selectedVehicleImages) { this.selectedVehicleImages = selectedVehicleImages;}
    public String getVehicleVideoSubmittedFileName() { return vehicleVideoSubmittedFileName;}
    public void setVehicleVideoSubmittedFileName(String vehicleVideoSubmittedFileName) { this.vehicleVideoSubmittedFileName = vehicleVideoSubmittedFileName;}
    public List<Part> getSelectedVehicleImagesGallery() { return selectedVehicleImagesGallery;}
    public void setSelectedVehicleImagesGallery(List<Part> selectedVehicleImagesGallery) {  this.selectedVehicleImagesGallery = selectedVehicleImagesGallery;}
    public String getaId() { return aId;}
    public void setaId(String aId) { this.aId = aId;}
    public VehicleImages getVehicleImages() {  return vehicleImages;  }
    public void setVehicleImages(VehicleImages vehicleImages) {   this.vehicleImages = vehicleImages;  }
    public String createVehicleImages(){
        
        int sonuc = 0;
        String yonlen = "";
        
        vehicleImages.setVehicleImage_Id(UniqueId.RandomString(12));  
        vehicleImages.setVehicleImage_Commnet(null);
        vehicleImages.setVehicleImage_Modified(new Date());
        vehicleImages.setVehicleImage_Modifier(SessionUtil.getUserId());
        vehicleImages.setVehicleImage_Created(new Date());
        vehicleImages.setVehicleImage_creator(SessionUtil.getUserId());
     
    
        if( vehicleImages.getVehicleImage_ProfilePhotoUrl() != null || 
            vehicleImages.getVehicleImage_GalleryPtoho_1_Url() != null || 
            vehicleImages.getVehicleVideoUrl() != null){
        
            VehicleImagesDao vid = new VehicleImagesDao();
            sonuc = vid.createVehicleImages(vehicleImages);
        }
        else { Messages.dynMsg(null, "error", "Herhangi bir resim veya video eklemediniz.");}
        
        if(sonuc == 1){            

            if(SessionUtil.getUserType().equals("personal")){ yonlen = "/private/common/vehicle/sonucSayfasi.xhml?vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true";}
            if(SessionUtil.getUserType().equals("corporate")){ yonlen = "/private/common/vehicle/sonucSayfasi.xhml?vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true";}
            if(SessionUtil.getUserType().equals("director")){ yonlen = "/private/director/users/kullanici_detay_yeni_arac_ekle_SonucSayfasi?p=addVehicle_s1&aId="+this.aId+"&vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true"; }         
        }
        else {Messages.dynMsg(null, "error", "Araç görselleri ekleme sırasında hata oluştu");}
        
        return yonlen;
    } public String updateVehicleImages(){
        
        int sonuc = 0;
        String yonlen = "";
        
        
        vehicleImages.setVehicleImage_Modified(new Date());
        vehicleImages.setVehicleImage_Modifier(SessionUtil.getUserId());
       
        if(vehicleImages.getVehicleImage_Id() != null){
        
            VehicleImagesDao vid = new VehicleImagesDao();
            sonuc = vid.updateVehicleImages(vehicleImages);

            if(sonuc == 1){ 
                Messages.dynMsg(null, "info", "Araç görselleriniz BAŞARILI birşekilde güncellenmiştir.");
               
                if(SessionUtil.getUserType().equals("personal")){yonlen = "/private/common/vehicle/sonucSayfasi2.xhml?vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true"; }
                if(SessionUtil.getUserType().equals("corporate")){yonlen = "/private/common/vehicle/sonucSayfasi2.xhml?vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true"; }
                if(SessionUtil.getUserType().equals("director")){yonlen = "/private/director/vehicles/edit_vehicle_sonucSayfasi.xhtml?vParam2=ad&vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true"; }
             
                if( this.urlPath.equals("kullanici_detay_edit_vehicle_s4") ){yonlen = "/private/director/users/kullanici_detay_edit_vehicle_s4.xhtml?p=addVehicle_s1&vParam2=ad&aId="+this.aId+"&vId="+vehicleImages.getVehicle_Id()+"&faces-redirect=true";}
            }
            else {Messages.dynMsg(null, "error", "Araç görsellerini güncelleme sırasında hata oluştu");} 
        }
        else {
            String Snc = "";
            Snc = createVehicleImages();
            if (Snc != null) {  if (!Snc.equals("")) { yonlen = Snc; }   }
        }
        
        return yonlen;
    }   
    public void fileUpload() {
        
        if(vehicleImages.getVehicleImage_ProfilePhotoFile() != null){
            
            this.vehicleImageProfilePhotoSubmittedFileName = vehicleImages.getVehicleImage_ProfilePhotoFile().getSubmittedFileName();
            
            try { vehicleImages.setVehicleImage_ProfilePhotoUrl("/resources/media/" + FileUpload.uploadFile(vehicleImages.getVehicleImage_ProfilePhotoFile()));     } 
            catch (IOException ex) { System.out.println(":::HATA:::"+ex);}
           
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("cxvdsfsa cxvdsfsax");
        
        }
        else{System.err.println(":::HATA::: Arac resim file null geldi");}
    } public void videoUpload() {
      
        if(this.vehicleVideoFile != null){
            
            this.vehicleVideoSubmittedFileName = this.vehicleVideoFile.getSubmittedFileName();
            
            try { vehicleImages.setVehicleVideoUrl("/resources/media/" + FileUpload.uploadFile(this.vehicleVideoFile));     } 
            catch (IOException ex) { System.out.println(":::HATA:::"+ex);}
           
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("fdt45trfes");
 
        }
        else{System.err.println(":::HATA::: Arac video file null geldi");}
    }public void validateFile(FacesContext ctx, UIComponent comp, Object value) {

       Functions.validateFile(ctx, comp, value);
    }public void validateVideoFile(FacesContext ctx, UIComponent comp, Object value) {

       Functions.validateVideoFile(ctx, comp, value);
    }     public void filesUpload() {
               
        try {   
            this.selectedVehicleImages ="";
            vehicleImagesGallery = getParts();
               
            if(vehicleImagesGallery != null){      
                for (Part part : vehicleImagesGallery) {   
                    if (part.getSubmittedFileName() != null ) {
                        if (!part.getSubmittedFileName().equals("")) {
                       
                            double FileSize = ((double) part.getSize() / 1024) / 1024;
                            DecimalFormat df = new DecimalFormat("0.00");
                            
                            if (part.getSize() > 20971520) {
                                System.err.println(":::HATA:::Büyük boyutlu(" + df.format(FileSize) + "Mb) resim yüklenmek istendi");
                                FacesContext facesContext = FacesContext.getCurrentInstance();
                                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ", "Büyük boyutlu(" + df.format(FileSize) + "Mb) resim dosyası");
                                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                                facesContext.addMessage(null, facesMessage);
                                facesContext.renderResponse();
                                this.selectedVehicleImages ="";
                                break;
                            }
                            else{
                                if (    !"image/jpeg".equals(part.getContentType())
                                      
                                        && !"image/gif".equals(part.getContentType())
                                        && !"image/png".equals(part.getContentType()) ) { 
                                     System.err.println(":::HATA:::Desteklenmeyen resim dosyası yüklenmek istendi");
                                     FacesContext facesContext = FacesContext.getCurrentInstance();
                                     FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Araç resmi olarak desteklenmeyen dosya formatı seçtiniz");
                                     facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                                     facesContext.addMessage(null, facesMessage);
                                     facesContext.renderResponse();
                                     this.selectedVehicleImages ="";
                                     break;
                                }
                                else{   
                                        if(selectedVehicleImagesGallery.size() < 4){
                                          
                                            if (this.vehicleVideoSubmittedFileName != null) {
                                                if (!this.vehicleVideoSubmittedFileName.equals(part.getSubmittedFileName())) {
                                                    selectedVehicleImagesGallery.add(part);
                                                    totalUploadFile ++;
                                                }
                                            }

                                             else { selectedVehicleImagesGallery.add(part);
                                                    totalUploadFile ++;
                                            }
                                            
                                            Imagesrecordable = true;
                                            
                                        }
                                        else{
                                            System.err.println(":::UYARI:::Fazla sayıda resim yüklenmek istendi");
                                            FacesContext facesContext = FacesContext.getCurrentInstance();
                                            FacesMessage facesMessage = new FacesMessage("UYARI","İzin verilenden(4Adet) fazla resim yüklemeye çalışıyorsunuz. 4. resimden sonrası yüklenemedi");
                                            facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
                                            facesContext.addMessage(null, facesMessage);
                                            facesContext.renderResponse();
                                        }
                                }
                            }
                        }
                    }
                }  
                PrimeFaces.current().executeScript("document.getElementById('uploadProgress').style.display = 'none' ");
            }  
               
          uploadedFilesSave();
         
           
            
        } 
        
        catch (Exception ex) {   System.err.println(":::HATA:::"+ex); }
   
    }public void uploadedFilesSave() {
    
        try {
           
            
            if(selectedVehicleImagesGallery != null && Imagesrecordable){
            
                  for (Part part : selectedVehicleImagesGallery) {

                    if (part.getSubmittedFileName() != null ) {
                        if (!part.getSubmittedFileName().equals("")) {                     
                            if(vehicleImages.getVehicleImage_GalleryPtoho_1_Url() == null){ vehicleImages.setVehicleImage_GalleryPtoho_1_Url("/resources/media/" + FileUpload.uploadFile(part));  }
                            else if(vehicleImages.getVehicleImage_GalleryPtoho_2_Url() == null){ vehicleImages.setVehicleImage_GalleryPtoho_2_Url("/resources/media/" + FileUpload.uploadFile(part)); }
                            else if(vehicleImages.getVehicleImage_GalleryPtoho_3_Url() == null){ vehicleImages.setVehicleImage_GalleryPtoho_3_Url("/resources/media/" + FileUpload.uploadFile(part)); }
                            else if(vehicleImages.getVehicleImage_GalleryPtoho_4_Url() == null){ vehicleImages.setVehicleImage_GalleryPtoho_4_Url("/resources/media/" + FileUpload.uploadFile(part)); }
                                        
                        }    
                    }
                }
                 if(selectedVehicleImagesGallery.size()==1){
                    vehicleProfileImageSet(1);
                }  
                
                selectedVehicleImages ="";
                selectedVehicleImagesGallery.clear();
              
                FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("uploaded-images");
                
            }  
            else{
                System.err.println(":::HATA:::Yüklenecek dosya bulunamadı");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Yüklenecek dosya bulunamadı");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }        
        } 
        catch (Exception ex) {   System.err.println(":::HATA:::"+ex);     }
    }private Collection<Part> getParts() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return request.getParts();
    }public void getvehicleImagesWithVehicleId(String vId){         
        VehicleImagesDao vid = new VehicleImagesDao();
        vehicleImages = vid.getvehicleImagesWithVehicleId(vId);
    }public void deleteVehiclevideo(){
        
        vehicleImages.setVehicleVideoUrl(null);
    } public void deleteVehiclegalleryImages(){
        
        vehicleImages.setVehicleImage_GalleryPtoho_1_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_2_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_3_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_4_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_5_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_6_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_7_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_8_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_9_Url(null);
        vehicleImages.setVehicleImage_GalleryPtoho_10_Url(null);
    }public void deleteVehiclegalleryImage(int img){
        
        if(img == 1){vehicleImages.setVehicleImage_GalleryPtoho_1_Url(null);}
        if(img == 2){vehicleImages.setVehicleImage_GalleryPtoho_2_Url(null);}
        if(img == 3){vehicleImages.setVehicleImage_GalleryPtoho_3_Url(null);}
        if(img == 4){vehicleImages.setVehicleImage_GalleryPtoho_4_Url(null);}
        if(img == 5){vehicleImages.setVehicleImage_GalleryPtoho_5_Url(null);}
        if(img == 6){vehicleImages.setVehicleImage_GalleryPtoho_6_Url(null);}
        if(img == 7){vehicleImages.setVehicleImage_GalleryPtoho_7_Url(null);}
        if(img == 8){vehicleImages.setVehicleImage_GalleryPtoho_8_Url(null);}
    }   public void vehicleProfileImageSet(int img){
        
        if(img == 1){vehicleImages.setVehicleImage_ProfilePhotoUrl(vehicleImages.getVehicleImage_GalleryPtoho_1_Url());}
        if(img == 2){vehicleImages.setVehicleImage_ProfilePhotoUrl(vehicleImages.getVehicleImage_GalleryPtoho_2_Url());}
        if(img == 3){vehicleImages.setVehicleImage_ProfilePhotoUrl(vehicleImages.getVehicleImage_GalleryPtoho_3_Url());}
        if(img == 4){vehicleImages.setVehicleImage_ProfilePhotoUrl(vehicleImages.getVehicleImage_GalleryPtoho_4_Url());}
    
    } public void deleteVehicleProfileImages(){
        
        vehicleImages.setVehicleImage_ProfilePhotoUrl(null);

    }    
    
    
    
}
