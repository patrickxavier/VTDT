/*
 * Created by Sanchit Chadha on 2014.12.07  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */

import com.group2.email.EmailSessionBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class EditorView {
    @EJB
    private EmailSessionBean emailSessionBean;
     
    private String text;
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
    
    public void sendMessage() { 
        emailSessionBean.sendEmail("sanchit.chadha@gmail.com", "Feedback", getText());
    }
}
