package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Address;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.serviceI.IFacultyService;
import com.saviour.poweryoga.serviceI.IRoleService;
import com.saviour.poweryoga.serviceI.IUserService;
import com.saviour.poweryoga.util.EmailManager;
import com.saviour.poweryoga.util.PasswordService;
import com.saviour.poweryoga.util.YogaValidator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author Md Mojahidul Islam
 * @author TalakB
 * @version 0.0.1
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IFacultyService facultyService;

    @Autowired
    private NotificationController notificationController;

    private List<Customer> customers;

    private Customer customer;

    private Address address;

    private String rePassword;

    @Autowired
    private JavaMailSender mailSender;

    public CustomerController() {
        customer = new Customer();
        address = new Address();
        customers = new ArrayList<>();

    }

    /**
     *
     * Customer registration.
     */
    public String saveCustomer() {
        try {
            if (validateEmail(customer.getEmail())
                    && findCustomerByEmail(customer.getEmail()) == false
                    && checkPassword(customer.getPassword(), rePassword)) {
                customer.setAddress(address);
                customer.setPassword(PasswordService.encrypt(customer.getPassword()));
                Role custRRole = roleService.getRoleByUserCode(Role.ROLE_CUSTOMER_CODE);

                //set role 
                customer.setRole(custRRole);
                //assign advisor 
                Faculty myAdvisor = facultyService.pickAdvisor();
                customer.setMyAdvisor(myAdvisor);
                userService.saveUser(customer);
                sendRegistrationEmail(customer);
                //redirect = "/views/index.xhtml?faces-redirect=true";
                //return (redirect);
                notificationController.setSuccessMsg("Welcome !! " + customer.getFirstName() + " " + customer.getLastName() + ". Please cheack your email and you can proceed to Login.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            notificationController.setErrorMsg("Customer saving failed");
        }
        return null;
    }

    public void sendRegistrationEmail(Customer mycustomer) {
        //EMAIL SENDING
        StringBuilder body = new StringBuilder(" Welcome !!! to PowerYoga family.\n\n Your registration information\n\n");
        body.append("   First Name:   ").append(customer.getFirstName()).append("\n   Last Name:   ").append(customer.getLastName()).append("\n   Email:   ").append(customer.getEmail());
        body.append("\n\n");
        body.append("Regards\n-PowerYoga Team");
        EmailManager.sendEmail(mailSender, "Welcome to PowerYoga studio", body.toString(), mycustomer.getEmail());
    }

    public boolean validateEmail(String email) {
        if (YogaValidator.emailValidator(customer.getEmail()) == false) {
            // successMsg = null;
            notificationController.setErrorMsg("Invalid email format");
            // errorMsg = "Invalid email format";
            return false;
        }
        return true;
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean findCustomerByEmail(String email) {
        Customer cust = userService.findCustomerByEmail(email.trim());
        if (cust == null) {
            return false;
        }
        //  successMsg = null;
        notificationController.setErrorMsg("Email ID already exists.");

        return true;
    }

    public boolean checkPassword(String password, String rePassword) {
        if (password.equals(rePassword)) {
            return true;
        }
        //  notificationController.setSuccessMsg = null;
        notificationController.setErrorMsg("Password and confirm password  mismatch");
        return false;
    }

    public void updateCustomer() {
        try {
            userService.updateUser(customer);
            notificationController.setSuccessMsg("Customer " + customer.getFirstName() + " updated successfully");
            //    errorMsg = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            notificationController.setErrorMsg("Customer update failed");
            //successMsg = null;
        }
    }

    public String findCustomerById() {
        HttpSession activeSession = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);

        Long customerId = (Long) activeSession.getAttribute("loggedUserId");

        customer = userService.findCustomerById(customerId);
        if (customer != null) {
            return "/views/customer/customerUpdate";
        }
        return null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
