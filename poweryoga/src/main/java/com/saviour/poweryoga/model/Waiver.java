package com.saviour.poweryoga.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TalakB
 */
@Entity
@Table(name = "WAIVER")
public class Waiver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wavierId;

    private String reason;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Faculty submittedTo;
    
    private boolean approved; 

    public Waiver() {
    }

    public Long getWavierId() {
        return wavierId;
    }

    public void setWavierId(Long wavierId) {
        this.wavierId = wavierId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Faculty getSubmittedTo() {
        return submittedTo;
    }

    public void setSubmittedTo(Faculty submittedTo) {
        this.submittedTo = submittedTo;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    
    

}
