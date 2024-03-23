package com.tasimacilar.ilan.system;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

public class Match {

    public FacesContext passwordMatch(ComponentSystemEvent event, String pass, String cfpass) {   
        FacesContext sonuc= null;

        UIComponent components = event.getComponent();

        UIInput uiInputPassword = (UIInput) components.findComponent(pass);
        String password = uiInputPassword.getLocalValue() == null ? "" : uiInputPassword.getLocalValue().toString();

        UIInput uiInputConfirmPassword = (UIInput) components.findComponent(cfpass);
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? "" : uiInputConfirmPassword.getLocalValue().toString();

        String passwordId = uiInputPassword.getClientId();

        if (password.isEmpty() || confirmPassword.isEmpty()) {return sonuc;}

        if (!password.equals(confirmPassword)) {
            FacesContext fc2 = FacesContext.getCurrentInstance();
            FacesMessage msg2 = new FacesMessage("Şifreniz ve Şifreniz(Tekrar) birbirleriyle eşleşmelidir.");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc2.addMessage(passwordId, msg2);
            fc2.renderResponse();
            sonuc= fc2;
            
        }
        return sonuc;
    }
    
//------------------------------------------------------------------------------    
    
    
}
