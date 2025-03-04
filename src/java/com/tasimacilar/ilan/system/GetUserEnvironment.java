package com.tasimacilar.ilan.system;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
public class GetUserEnvironment { public static String getInternetIp(HttpServletRequest request) {
        
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        
        if (realIp == null) {
            if (forwarded == null) { ip = remoteAddr; } 
            else { ip = remoteAddr + "/" + forwarded.split(",")[0]; }
        } 
        else { if (realIp.equals(forwarded)) { ip = realIp;} 
               else {  if (forwarded != null) { forwarded = forwarded.split(",")[0]; }
               ip = realIp + "/" + forwarded;
            }
        }

        return ip;
    }public static String getInternetIp() {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        String forwarded = httpServletRequest.getHeader("X-Forwarded-For");
        String realIp = httpServletRequest.getHeader("X-Real-IP");

        String ip = null;
        
        if (realIp == null) {
            if (forwarded == null) { ip = remoteAddr; } 
            else { ip = remoteAddr + "/" + forwarded.split(",")[0]; }
        } 
        else { if (realIp.equals(forwarded)) { ip = realIp;} 
               else {  if (forwarded != null) { forwarded = forwarded.split(",")[0]; }
               ip = realIp + "/" + forwarded;
            }
        }

        return ip;
    }public static String getOsHeader(HttpServletRequest request) {
        String os = null;
        String userAgent = request.getHeader("User-Agent");
      
        if (userAgent.toLowerCase().indexOf("windows") >= 0) {os = "Windows";} 
        else if (userAgent.toLowerCase().indexOf("mac") >= 0) {os = "Mac";} 
        else if (userAgent.toLowerCase().indexOf("x11") >= 0) {os = "Unix";} 
        else if (userAgent.toLowerCase().indexOf("android") >= 0) {os = "Android";} 
        else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {os = "IPhone";} 
        else {os = "Bilinmiyor, Bilgi: " + userAgent;}

      
        return os;
    } public static String getBrowserHeader(HttpServletRequest request) {
        
        String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();
        String browser = null;
        
        if (user.contains("msie")) {
            String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
        } 
        
        else if (user.contains("safari") && user.contains("version")) {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } 
        
        else if (user.contains("opr") || user.contains("opera")) {
            if (user.contains("opera")) {browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];} 
            else if (user.contains("opr")) {browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");}
        } 
        
        else if (user.contains("chrome")) {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } 
        
        else if ( (user.indexOf("mozilla/7.0") > -1) || 
                  (user.indexOf("netscape6") != -1) || 
                  (user.indexOf("mozilla/4.7") != -1) || 
                  (user.indexOf("mozilla/4.78") != -1) || 
                  (user.indexOf("mozilla/4.08") != -1) || 
                  (user.indexOf("mozilla/3") != -1)) {
            browser = "Netscape-?";
        } 
        
        else if (user.contains("firefox")) {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } 
        
        else if (user.contains("rv")) { browser = "IE"; } 
        
        else { browser = "Bilinmiyor, Bilgi: " + userAgent;}

     
        return browser ;
    }
    
    
    
    
    
    
    
}
