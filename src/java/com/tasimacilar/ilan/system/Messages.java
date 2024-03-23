package com.tasimacilar.ilan.system;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
public class Messages {
    public static void dynMsg(String ElementId, String Severity, String Msg) {
        if(Severity.equals("fatal")){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("HATA",Msg);
            facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
            if(ElementId == null){facesContext.addMessage(null, facesMessage);}
            else{facesContext.addMessage(ElementId, facesMessage);}
            facesContext.renderResponse();
            System.err.println(":::FATAL:::"+Msg);
        }
        else if(Severity.equals("error")){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("HATA",Msg);
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            if(ElementId == null){facesContext.addMessage(null, facesMessage);}
            else{facesContext.addMessage(ElementId, facesMessage);}
            facesContext.renderResponse();  
            System.err.println(":::ERROR:::"+Msg);
        }
        else if(Severity.equals("info")){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("BİLGİ",Msg);
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            if(ElementId == null){facesContext.addMessage(null, facesMessage);}
            else{facesContext.addMessage(ElementId, facesMessage);}
            facesContext.renderResponse();
            System.err.println(":::INFO:::"+Msg);
        }
        else if(Severity.equals("warn")){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("UYARI",Msg);
            facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);           
            if(ElementId == null){facesContext.addMessage(null, facesMessage);}
            else{facesContext.addMessage(ElementId, facesMessage);}
            facesContext.renderResponse();
            System.err.println(":::WARN:::"+Msg);
        }
       
    }
    public static void insSuppReqSuccMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Talebiniz BAŞARILI bir şekilde iletilmiştir");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }   
    public static void insSuppReqErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Talebinizi iletirken bir HATA OLUŞTU");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void insSuccMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("! Successfully / Başarılı");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }   
    public static void updSuccMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Kayıt düzenleme işlemi BAŞARILI");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }  
    public static void disableSuccMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu hesap kullanıma kapatılmıştır.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void notFoundErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Aradığınız kayıt bulunamamıştır");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void insErrMsg(String hata) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Kayıt işlemi işlemi sırasında bir HATA OLUŞTU \n HATA: "+hata);
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void insErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Kayıt işlemi işlemi sırasında bir HATA OLUŞTU");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static  void emailExistMesg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu E-Mail adresi kullanılmaktadır, farklı bir E-Mail adresi deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("newUserForm:userEmail", facesMessage);
        facesContext.renderResponse();
    }
    public static  void emailExistMesg2() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu E-Mail adresi kullanılmaktadır, farklı bir E-Mail adresi deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("registerUserForm:userEmail", facesMessage);
        facesContext.renderResponse();
    }    
    public static  void emailExistMesg3() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu E-Mail adresi kullanılmaktadır, farklı bir E-Mail adresi deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("memberProfileForm:userEmail", facesMessage);
        facesContext.renderResponse();
    } 
    public static  void emailNotExistMesg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Böyle bir email adresi yok");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("passwordResetForm:userEmail", facesMessage);
        facesContext.renderResponse();
    } 
    public static  void emailNotExistMesg2() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Kayıtlı böyle bir email adresi yok");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }    
    public static  void categoryExistMesg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu kategori ismi kullanılmaktadır, farklı bir isim deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("newCategoryForm:categoryName", facesMessage);
        facesContext.renderResponse();
    } 
    public static  void templateExistMesg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu şablon ismi kullanılmaktadır, farklı bir isim deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("newTemplateForm:templateName", facesMessage);
        facesContext.renderResponse();
    }
    public static  void aliasExistMesg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu Url ismi kullanılmaktadır, farklı bir isim deneyin.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("newPageForm:contentAlias", facesMessage);
        facesContext.renderResponse();
    }
    public static void userNameError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Kullanıcı adınız hatalı");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void passwordError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Şifreniz yanlış..");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void userAccoundLockError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Bu hesap kapalıdır. Bilgi için bizimle iletişime geçiniz.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void userPasswordChangeRequiredError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("<a style='color: inherit' href='/reset-password'><b>!! ŞİFRENİZİ DEĞİŞTİRMENİZ GEREKİYOR</b><br/>&nbsp;&nbsp;buradan yeni şifre oluşturabilirsiniz </a>");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void emailActivationRequiredError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("<b>!! E-MAIL AKTİVASYONU GEREKİYOR</b><br/>&nbsp;&nbsp;<a style='color: inherit' href='/activation'>buradan</a> E-Mail aktivasyonu yapabilirsiniz ");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }    
    public static void gsmNoActivationRequiredError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("<b>!! GSM NO AKTİVASYONU GEREKİYOR</b><br/>&nbsp;&nbsp;<a style='color: inherit' href='/activation'>buradan</a> GSM No aktivasyonu yapabilirsiniz ");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }   
    public static void userLoginUnsuccessfulError() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Giriş başarısız");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void passwordResetSuccMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Şifreniz yenilenmiş ve yeni şifreniz yukarıdaki mail adresine gönderilmiştir");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }   
    public static void passwordResetErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("Şifre yenileme sırasında bir hata oluştu. Lütfen destek ekine bildiriniz.");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }      
    public static void InsertOrderSupportErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("HATA [Yeni destek talebi oluşturulurken hata oluştu]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }
    public static void InsertOrderSupportSucc() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("BİLGİ [Başarılı bir şekilde yeni bir destek talebi oluşturdunuz]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }  
    public static void UserActivicationIdErrMsg() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("HATA [Böyle bir aktivasyon kodu yok]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    }  
    public static void UserActivicationIdErrMsg2() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("HATA [Bu hesap zaten etkinleştirilmiş]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void UserActivicationIdErrMsg3() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("HATA [Kullanıcı etkinleştirme sırasında hata oluştu]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        facesContext.renderResponse();
    } 
    public static void ErrMsg(String ElementId, String Msg) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("HATA [" + Msg + "]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(ElementId, facesMessage);
        facesContext.renderResponse();
    }
    public static void InfoMsg(String ElementId, String Msg) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("BILGI [" + Msg + "]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(ElementId, facesMessage);
        facesContext.renderResponse();
    }
    public static void WarnMsg(String ElementId, String Msg) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("UYARI [" + Msg + "]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
        facesContext.addMessage(ElementId, facesMessage);
        facesContext.renderResponse();
    }
    public static void FatlMsg(String ElementId, String Msg) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("FATAL [" + Msg + "]");
        facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
        facesContext.addMessage(ElementId, facesMessage);
        facesContext.renderResponse();
    }
}
