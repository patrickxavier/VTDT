/*
 * Created by Ragan Walker on 2014.12.11  * 
 * Copyright © 2014 Ragan Walker. All rights reserved. * 
 */
package com.group2.chat;

import java.util.Date;
 
public class ChatMessage {
	private String message;
	private String sender;
	private Date received;
 
	public String getMessage() {
            return message;
        }
        
        public String getSender() {
            return sender;
        }
        
        public Date getReceived() {
            return received;
        }
        
        public void setMessage(String m) {
            message = m;
        }
        
        public void setSender(String s) {
            sender = s;
        }
        
        public void setReceived(Date r) {
            received = r;
        }
}
