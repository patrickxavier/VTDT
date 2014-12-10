package com.mycompany.jsfclassespackage;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class ButtonView {
     
    public void addMessage() {
        FacesMessage message = new FacesMessage("Success",  "Feedback sent successfully!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}