/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author bidur
 */
@Entity
@Table(name = "ENROLLMENT")
@NamedQueries({
    @NamedQuery(name = "Enrollment.findAll", query = "from Enrollment e"),
    @NamedQuery(name = "Enrollment.findCustomerInSection", query = "from Enrollment e join Users u on u.id=e.user.id join Section s on s.id=e.section.id where e.user.id:userId and e.section.id:sectionId")

})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;
    private String status;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date enrolledDate = new Date();

    public Enrollment() {
    }

    public Enrollment(Section section, Users user, String status) {
        this.section = section;
        this.user = user;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
