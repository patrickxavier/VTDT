/*
 * Created by Rohan Elwadhi on 2014.10.09  * 
 * Copyright © 2014 Rohan Elwadhi. All rights reserved. * 
 */

package com.group2.vtdt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rohan
 */
@Entity
@Table(name = "newsfeed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsfeed.findAll", query = "SELECT n FROM Newsfeed n"),
    @NamedQuery(name = "Newsfeed.findAllSorted", query="SELECT n FROM Newsfeed n ORDER BY n.timePosted DESC"),
    @NamedQuery(name = "Newsfeed.findById", query = "SELECT n FROM Newsfeed n WHERE n.id = :id"),
    @NamedQuery(name = "Newsfeed.findByUsername", query = "SELECT n FROM Newsfeed n WHERE n.username = :username ORDER BY n.timePosted DESC"),
    @NamedQuery(name = "Newsfeed.findByMessage", query = "SELECT n FROM Newsfeed n WHERE n.message = :message"),
    @NamedQuery(name = "Newsfeed.findByTimePosted", query = "SELECT n FROM Newsfeed n WHERE n.timePosted = :timePosted"),
    @NamedQuery(name = "Newsfeed.findByBar", query = "SELECT n FROM Newsfeed n WHERE n.bar = :bar ORDER BY n.timePosted DESC")})
public class Newsfeed implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "username")
    private String username;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(max=140)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_posted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timePosted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bar")
    private int bar;

    public Newsfeed() {
    }

    public Newsfeed(Integer id) {
        this.id = id;
    }

    public Newsfeed(Integer id, String username, String message, Date timePosted, int bar) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.timePosted = timePosted;
        this.bar = bar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsfeed)) {
            return false;
        }
        Newsfeed other = (Newsfeed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group2.vtdt.Newsfeed[ id=" + id + " ]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}