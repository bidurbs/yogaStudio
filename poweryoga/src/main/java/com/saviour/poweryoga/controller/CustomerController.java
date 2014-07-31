package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

//    @Autowired
//    private UserService userService;

    private Customer customer;

    public CustomerController() {
        customer = new Customer();
    }

//    public void save() {
//        userService.save(customer);
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
