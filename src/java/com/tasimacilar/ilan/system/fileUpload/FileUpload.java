package com.tasimacilar.ilan.system.fileUpload;

import com.tasimacilar.ilan.system.SessionUtil;
import com.tasimacilar.ilan.system.UniqueId;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Part;
import com.tasimacilar.ilan.system.fileUpload.*;
import org.primefaces.model.UploadedFile;

public class FileUpload {
    
        private static File            outputFile = null;
        private static InputStream     inputStream = null;
        private static OutputStream    outputStream = null; 
        private static boolean         file1Success = false;
        private static String          documentUploadPath = null;
        private static String          documentName = null;

    public static String uploadFile(Part file) throws IOException {
           if (file != null && file.getSize() > 0) {
       SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss_");
            documentName = ft.format(new Date()) + Functions.getFileNameFromPart(file);
           documentUploadPath = Functions.documentUploadPath();
            outputFile = new File(documentUploadPath + documentName);   
            inputStream = file.getInputStream(); // Gelen dokuman
            outputStream = new FileOutputStream(outputFile); // Cikan dokuman
            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) { outputStream.write(buffer, 0, bytesRead);  }          
            if (outputStream != null) { outputStream.close(); }
            if (inputStream != null) { inputStream.close(); }

            file1Success = true;
        }

        if (file1Success) {System.out.println("::: FILE UPLOAD OK :::");   } 
        else {      System.err.println("Error, There was a problem during file upload ");  }

        return outputFile.getName();
    } public static String uploadFile2(UploadedFile file) throws IOException {
          if (file != null && file.getSize() > 0) { SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss_");
            documentName = ft.format(new Date()) + file.getFileName();documentUploadPath = Functions.documentUploadPath();
             outputFile = new File(documentUploadPath + documentName);   
            inputStream = file.getInputstream();
            outputStream = new FileOutputStream(outputFile); 
            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) { outputStream.write(buffer, 0, bytesRead);  }          
            if (outputStream != null) { outputStream.close(); }
            if (inputStream != null) { inputStream.close(); }

            file1Success = true;
        }

        if (file1Success) {

                System.out.println("::: FILE UPLOAD OK :::");
        } 
        else {         
            System.err.println("Error, There was a problem during file upload ");
        }
          return outputFile.getName();
    }
    
    
    
    
    
}
