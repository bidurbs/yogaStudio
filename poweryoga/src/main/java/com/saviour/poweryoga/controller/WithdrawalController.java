/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.ISectionService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Named("withdrawalController")
@SessionScoped
public class WithdrawalController implements Serializable {

    @Autowired
    private ISectionService SectionService;
    
    @Autowired
    private UserController userController;

    private Section section;
    private Users customer;
    
    public WithdrawalController() {
        
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Users getUser() {
        return customer;
    }

    public void setUser(Users customer) {
        this.customer = customer;
    }
    
    
    /**
     * Customer request for withdrawal for a section
     * 
     * @param section
     */
    public void requestWithdrawal(Section section){
        //check if customer is entolled to this section previously
        Boolean isEnrolled = false;
        customer = userController.getUser();
        isEnrolled = SectionService.checkCustomerEnrolled(section, customer);
        
        if(isEnrolled){
            section.getWithdrawalList().add(customer);
            //TODO: remove customer from enrollment table
            
            SectionService.updateSection(section); // update section table
        }
        
    }
}
