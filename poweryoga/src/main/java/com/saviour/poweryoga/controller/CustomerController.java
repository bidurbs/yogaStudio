package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Address;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.serviceI.IFacultyService;
import com.saviour.poweryoga.serviceI.IRoleService;
import com.saviour.poweryoga.serviceI.IUserService;
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

/**
 *
 * @author Md Mojahidul Islam
 * @author TalakB
 * @version 0.0.1
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController extends NotificationController implements Serializable {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IFacultyService facultyService;

    private List<Customer> customers;

    private Customer customer;

    private Address address;

    private String rePassword;

    public CustomerController() {
        customer = new Customer();
        address = new Address();
        customers = new ArrayList<>();

    }

    /**
     * Customer registration.
     */

    public void saveCustomer() {
        try {
            if (validateEmail(customer.getEmail()) && findCustomerByEmail(customer.getEmail()) == false && checkPassword(customer.getPassword(), rePassword)) {
                customer.setAddress(address);
                customer.setPassword(PasswordService.encrypt(customer.getPassword()));
                Role custRRole = roleService.getRoleByUserCode(UserController.ROLE_CUSTOMER_CODE);

                //set role 
                customer.setRole(custRRole);
                //assign advisor 

                Faculty myAdvisor = facultyService.pickAdvisor();
                customer.setMyAdvisor(myAdvisor);
                userService.saveUser(customer);
                successMsg = "Customer " + customer.getFirstName() + " saved successfully";
                errorMsg = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            errorMsg = "Customer saving failed";
            successMsg = null;
        }
    }

    public boolean validateEmail(String email) {
        if (YogaValidator.emailValidator(customer.getEmail()) == false) {
            successMsg = null;
            errorMsg = "Invalid email format";
            return false;
        }
        return true;
    }

    public boolean findCustomerByEmail(String email) {
        Customer customer = userService.findCustomerByEmail(email.trim());
        if (customer == null) {
            return false;
        }
        successMsg = null;
        errorMsg = "This email already registered";
        return true;
    }

    public boolean checkPassword(String password, String rePassword) {
        if (password.equals(rePassword)) {
            return true;
        }
        successMsg = null;
        errorMsg = "Password and RePassword doesn't match";
        return false;
    }

    public void updateCustomer() {
        try {
            userService.updateUser(customer);
            successMsg = "Customer " + customer.getFirstName() + " updated successfully";
            errorMsg = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            errorMsg = "Customer updatation failed";
            successMsg = null;
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
