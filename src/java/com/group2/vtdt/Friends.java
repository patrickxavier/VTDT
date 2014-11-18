/*
 * Created by Sanchit Chadha on 2014.10.23  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */
package com.group2.vtdt;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanchit
 */
@Entity
@Table(name = "friends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f"),
    @NamedQuery(name = "Friends.findById", query = "SELECT f FROM Friends f WHERE f.id = :id"),
    @NamedQuery(name = "Friends.findByUser", query = "SELECT f FROM Friends f WHERE f.user = :user"),
    @NamedQuery(name = "Friends.findOnline", query = "SELECT f FROM Friends f JOIN Users u ON f.friend = u.username WHERE u.checkedInBar != 100 AND f.user = :user"),
    @NamedQuery(name = "Friends.findByFriend", query = "SELECT f FROM Friends f WHERE f.friend = :friend")})
public class Friends implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "friend")
    private String friend;

    public Friends() {
    }

    public Friends(Integer id) {
        this.id = id;
    }

    public Friends(Integer id, String user, String friend) {
        this.id = id;
        this.user = user;
        this.friend = friend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
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
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group2.vtdt.Friends[ id=" + id + " ]";
    }
    
}