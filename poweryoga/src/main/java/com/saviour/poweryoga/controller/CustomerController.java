/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.service.UserService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

    @Autowired
    private UserService userService;

    private Customer customer;

    public CustomerController() {
        customer = new Customer();
    }

    public void save() {
        userService.save(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
