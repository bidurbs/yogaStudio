package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.service.UserService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author TalakB
 * @version 0.0.1
 */
@Named("userController")
@SessionScoped
public class UserController implements Serializable {

    @Autowired
    private UserService userService;
    private Users user;
    private Role userRole;

    private static final int ROLE_ADMIN_CODE = 1;
    private static final int ROLE_FACULTY_CODE = 2;
    private static final int ROLE_CUSTOMER_CODE = 3;

    public UserController() {
        user = new Users();
        userRole = new Role();
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String loginUser() throws Exception {

        user = userService.authenticateUser(user);
        //check if the user is registered and authenticated 
        if (user != null) {
            //get the authenticated user 

            int userRoleCode = user.getRole().getUserCode();
            //admin
            if (userRoleCode == ROLE_ADMIN_CODE) {
                // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                return "adminHome";
            } //faculty user 
            else if (userRoleCode == ROLE_FACULTY_CODE) {
                // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                return "facultyHome";
            } //vedor user
            else if (userRoleCode == ROLE_CUSTOMER_CODE) {
                // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                return "customerHome";
            }
        }
        return null;
    }

}
