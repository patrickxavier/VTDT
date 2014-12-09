/*
 * Created by Ragan Walker on 2014.12.08  * 
 * Copyright © 2014 Ragan Walker. All rights reserved. * 
 */
package com.mycompany.jsfclassespackage;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.group2.news.News;
import com.group2.news.NewsService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
 
@ManagedBean
@ViewScoped
public class NewsFeedView implements Serializable {
     
    private List<News> news;
         
    @ManagedProperty(value="#{newsService}")
    private NewsService service;
         
    @PostConstruct
    public void init() {        
        news = service.createNews();
    }
 
    public List<News> getNews() {
        return news;
    }
 
    public void setService(NewsService service) {
        this.service = service;
    }
}
