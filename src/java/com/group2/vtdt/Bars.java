/*
 * Created by Patrick Sherman on 2014.10.24  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.group2.vtdt;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrickxavier
 */
@Entity
@Table(name = "bars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bars.findAll", query = "SELECT b FROM Bars b"),
    @NamedQuery(name = "Bars.findById", query = "SELECT b FROM Bars b WHERE b.id = :id"),
    @NamedQuery(name = "Bars.findByName", query = "SELECT b FROM Bars b WHERE b.name = :name"),
    @NamedQuery(name = "Bars.findByAddress", query = "SELECT b FROM Bars b WHERE b.address = :address"),
    @NamedQuery(name = "Bars.findByPhoneNumber", query = "SELECT b FROM Bars b WHERE b.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Bars.findByWebsite", query = "SELECT b FROM Bars b WHERE b.website = :website"),
    @NamedQuery(name = "Bars.findByLatitude", query = "SELECT b FROM Bars b WHERE b.latitude = :latitude"),
    @NamedQuery(name = "Bars.findByLongitude", query = "SELECT b FROM Bars b WHERE b.longitude = :longitude")})
public class Bars implements Serializable {
    @Lob
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Size(max = 128)
    @Column(name = "address")
    private String address;
    @Size(max = 128)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 128)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;

    public Bars() {
    }

    public Bars(Integer id) {
        this.id = id;
    }

    public Bars(Integer id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        if (!(object instanceof Bars)) {
            return false;
        }
        Bars other = (Bars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entitypackage.Bars[ id=" + id + " ]";
    }

    
}
