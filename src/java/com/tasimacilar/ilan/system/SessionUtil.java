
package com.tasimacilar.ilan.system;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

 public static HttpSession getSession() {
        
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
    
public static HttpServletRequest getRequest() {
        
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
  
    public static String getUserId() {
        
        HttpSession session = getSession();
        if (session != null) {
            if(session.getAttribute("accountId") != null){
                return  session.getAttribute("accountId").toString();
            }
            else { return null;}
        } 
        else {return null;}
    }
    

    public static String getUserEmail() {
        
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountEmailAddress");
        } else {
            return null;
        }
    }
    public static String getUserMobilePhoneNumber() {
        
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountMobilePhoneNumber");
        } else {
            return null;
        }
    }
     
    public static String getUserName() {
        
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountFirstName");
        } else {
            return null;
        }
    } 
    public static String getUserSurname() {
        
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountLastName");
        } else {
            return null;
        }
    }
    
    public static String getUserType() {
            
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("AccountType");
        } else {
            return null;
        }
    }
    public static String getUserMembershipType() {
            
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountMembershipType");
        } else {
            return null;
        }
    }
        
    public static String getAccountCompanyId() {
            
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountCompanyId");
        } else {
            return null;
        }
    }
        
    public static String getAccountActivityArea() {
            
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("accountActivityArea");
        } else {
            return null;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
