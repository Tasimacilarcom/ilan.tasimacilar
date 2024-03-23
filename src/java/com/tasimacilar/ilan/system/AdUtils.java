package com.tasimacilar.ilan.system;
import com.tasimacilar.ilan.profile.account.AccountDao;
public class AdUtils {
 public static String getAdTyp(String userId){
        
        String result = null;
        
        if(userId != null){
            if(!userId.equals("")){
                String amt = "";
                AccountDao a = new AccountDao();
                amt = a.getAccountDetailWithAccountId(userId).getAccount_MembershipType(); 
                if(amt.equals("personal")){result = "personal";}
                if(amt.equals("corporate")){result = "corporate";}
            }
            else{
                if(SessionUtil.getUserMembershipType().equals("personal")){ result = "personal"; }
                if(SessionUtil.getUserMembershipType().equals("corporate")){ result = "corporate";} 
            }
        }
        else{
            if(SessionUtil.getUserMembershipType().equals("personal")){ result = "personal"; }
            if(SessionUtil.getUserMembershipType().equals("corporate")){ result = "corporate";} 
        }

        return result;
    } public static String getOvnerAccountId(String userId){
    
        String result = null;
        
        if(userId != null){
            if(!userId.equals("")){ result = userId; } else { result = SessionUtil.getUserId(); }
        }
        else {result = SessionUtil.getUserId(); }
        
        return result;
    }
}
