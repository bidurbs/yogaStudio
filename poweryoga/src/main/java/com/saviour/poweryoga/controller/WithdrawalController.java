package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Enrollment;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.serviceI.IEnrollmentService;
import com.saviour.poweryoga.serviceI.ISectionService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    @Autowired
    private IEnrollmentService enrollmentService;

    private Section section;
    private Customer customer;
    
    public WithdrawalController() {
        
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    /**
     * Customer request for withdrawal for a section
     * 
     * @param section
     */
    public void requestWithdrawal(Section section){
        //check if customer is entolled to this section previously
        customer = (Customer) userController.getUser();
        Enrollment enrollment = enrollmentService.isRegistered(customer, section);
        
        if(enrollment !=null){
            enrollment.setStatus("Withdrawal");
            enrollmentService.updateEnrollment(enrollment);
        }
    }
}
