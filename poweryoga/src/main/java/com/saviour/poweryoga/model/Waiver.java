/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Guest
 */
@Entity
@Table(name = "WAIVER")
public class Waiver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String reason;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date requestDate = new Date();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;

    public enum statusType {

        approved, pending, notapproved;
    }
    private statusType status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public statusType getStatus() {
        return status;
    }

    public void setStatus(statusType status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void addCustSec(Users customer, Section section) {
        this.user = customer;
        this.section = section;
    }

}
