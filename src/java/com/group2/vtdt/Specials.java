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
@Table(name = "specials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specials.findAll", query = "SELECT s FROM Specials s"),
    @NamedQuery(name = "Specials.findById", query = "SELECT s FROM Specials s WHERE s.id = :id"),
    @NamedQuery(name = "Specials.findByMenuItem", query = "SELECT s FROM Specials s WHERE s.menuItem = :menuItem"),
    @NamedQuery(name = "Specials.findByPrice", query = "SELECT s FROM Specials s WHERE s.price = :price"),
    @NamedQuery(name = "Specials.findByDays", query = "SELECT s FROM Specials s WHERE s.days LIKE :days"),
    @NamedQuery(name = "Specials.findByStartTime", query = "SELECT s FROM Specials s WHERE s.startTime = :startTime"),
    @NamedQuery(name = "Specials.findByEndTime", query = "SELECT s FROM Specials s WHERE s.endTime = :endTime"),
    @NamedQuery(name = "Specials.findByBar", query = "SELECT s FROM Specials s WHERE s.bar = :bar")})
public class Specials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "menu_item")
    private String menuItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "days")
    private String days;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bar")
    private int bar;

    public Specials() {
    }

    public Specials(Integer id) {
        this.id = id;
    }

    public Specials(Integer id, String menuItem, double price, String days, Date startTime, Date endTime, int bar) {
        this.id = id;
        this.menuItem = menuItem;
        this.price = price;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bar = bar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof Specials)) {
            return false;
        }
        Specials other = (Specials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group2.vtdt.Specials[ id=" + id + " ]";
    }
    
}
