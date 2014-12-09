/*
 * Created by Ragan Walker on 2014.12.09  * 
 * Copyright © 2014 Ragan Walker. All rights reserved. * 
 */
package com.group2.news;

/**
 *
 * @author aragawalker
 */
public class News {
    
    private String username;
    private String message;
    private String locationTime;
    private String uid;

    public News(String username, String message, String locationTime, String uid) {
        this.username = username;
        this.message = message;
        this.locationTime = locationTime;
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    
    
}
