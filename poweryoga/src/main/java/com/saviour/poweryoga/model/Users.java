package com.saviour.poweryoga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author TalakB
 * @version 1.0.0
 */
@Entity
@Table(name = "USERS", uniqueConstraints=
           @UniqueConstraint(columnNames = {"email"}))
@NamedQueries({
    @NamedQuery(name = "Users.findAllCustomer", query = "from Customer c"),
    @NamedQuery(name = "Users.findCustomerByEmail", query = "from Customer c where c.email=:email"),
	 @NamedQuery(name = "User.authenticateUser", query = "from Users u where u.email = :uemail and u.password= :upass")
})
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Street")
    private String Street;
    
    @Column(name ="City")
    private String City;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    @Column(name = "Zip")
    private String zip;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Role role;

    @ManyToMany
    private List<Section> sections = new ArrayList<>();

    public Users() {
    }

    public Users(String firstName, String lastName, String email, String password, String phone, String Street, String state, String city, String country, String zip, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.Street = Street;
        this.state = state;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity(){
        return City;
    }
    
    public void setCity(String City){
        this.City = City;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
