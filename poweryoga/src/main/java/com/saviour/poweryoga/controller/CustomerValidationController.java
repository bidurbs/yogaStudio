/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.serviceI.IUserService;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
//@Controller
@ManagedBean(name = "customerValidationController")
@RequestScoped
public class CustomerValidationController implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    private String myStatus;

    @ManagedProperty("#{param.id}")
    private String id;

    public CustomerValidationController() {
    }

    @PostConstruct
    public void init() {
        checkValidation();
    }

    public void checkValidation() {

        System.out.println("Key" + id);
        try {
            myStatus = "invalid_link";
            if (id != null) {
                Customer mycustomer = userService.findCustomerByValidationLink(id);

                if (mycustomer != null && !mycustomer.isApproved()) {
                    mycustomer.setApproved(true);
                    userService.updateUser(mycustomer);
                    //String myApp = "<a href=\"http://" + findMyIP() + ":8080/poweryoga/views/userLogin.xhtml\">Verify</a>";
                    //System.out.println("Link " + myApp);
                    //myStatus = "Verification Complete. You can login now " + myApp;
                    myStatus="validation_success";
                } else {
                    myStatus = "validation_done";
                }
            }
        } catch (Exception e) {

        }

    }

    public String findMyIP() {
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (java.net.UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip.getHostAddress();
    }

    public String getMyStatus() {
        return myStatus;
    }

    public void setMyStatus(String myStatus) {
        this.myStatus = myStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
