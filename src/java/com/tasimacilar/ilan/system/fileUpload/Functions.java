package com.tasimacilar.ilan.system.fileUpload;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;


public class Functions {
    public static String getFileNameFromPart(Part part) {

        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String documentName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                return documentName;
            }
        }
        return null;
    }
    public static void validateFile(FacesContext ctx, UIComponent comp, Object value) {

        if (value != null) {
            List<FacesMessage> msgs = new ArrayList<FacesMessage>();
            Part file = (Part) value;

            double FileSize = ((double) file.getSize() / 1024) / 1024;
            DecimalFormat df = new DecimalFormat("0.00");

            if (file.getSize() > 20971520) {
                System.err.println(":::HATA:::Büyük boyutlu("+df.format(FileSize)+"Mb) resim yüklenmek istendi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Büyük boyutlu("+df.format(FileSize)+"Mb) resim dosyası");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            if (    !"image/jpeg".equals(file.getContentType())
                     
                    && !"image/gif".equals(file.getContentType())
                    && !"image/png".equals(file.getContentType())
               ) { 
                System.err.println(":::HATA:::Desteklenmeyen resim dosyası yüklenmek istendi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Desteklenmeyen resim dosyası");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }

            if (!msgs.isEmpty()) {
                System.err.println(":::HATA:::ValidatorException");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","resim-ValidatorException");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
                throw new ValidatorException(msgs);
            }
        }
    } public static void validateVideoFile(FacesContext ctx, UIComponent comp, Object value) {

        if (value != null) {
            List<FacesMessage> msgs = new ArrayList<FacesMessage>();
            Part file = (Part) value;
            
            double FileSize = ((double) file.getSize() / 1024) / 1024;
            DecimalFormat df = new DecimalFormat("0.00");

            if (file.getSize() > 52428800) { 
                System.err.println(":::HATA:::Büyük boyutlu("+df.format(FileSize)+"Mb) video dosyası yüklenmek istendi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Büyük boyutlu("+df.format(FileSize)+"Mb) video dosyası");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }
            
            if (  !"video/mp4".equals(file.getContentType())  ) { 
                System.err.println(":::HATA:::Desteklenmeyen video dosyası yüklenmek istendi");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","Desteklenmeyen video dosyası");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
            }

            if (!msgs.isEmpty()) {  
                System.err.println(":::HATA:::ValidatorException");
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("BAŞARISIZ","video-ValidatorException");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(null, facesMessage);
                facesContext.renderResponse();
                throw new ValidatorException(msgs); 
            }
            
        }
    }public static boolean copyFile(String sourcex, String targetx) {
        
        boolean sonuc = false;
        Path source = Paths.get(sourcex);
        Path target = Paths.get(targetx);

        try {
            Path p = Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
            System.out.println(source + "  has  been  copied to " + p);
            sonuc = true;
        } 
        catch (FileAlreadyExistsException e) { System.out.println(target + "  already exists."); } 
        catch (DirectoryNotEmptyException e) { System.out.println(target + "  is not  empty."); } 
        catch (IOException e) { e.printStackTrace(); }

        return sonuc;
    }  public static String documentUploadPath(){
        
        String documentUploadPath = null;
        try {
                CompositeConfiguration config = new CompositeConfiguration();
                config.addConfiguration(new SystemConfiguration());
                config.addConfiguration(new PropertiesConfiguration("Settings.properties"));
                documentUploadPath = (String) (config.getProperty("documentUploadPath"));
            } 
            catch (ConfigurationException ex) { System.err.println(":::HATA:::" + ex + ":::");  }
    
        return documentUploadPath;
    }
     
    
    
}
