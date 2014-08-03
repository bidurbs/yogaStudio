package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IUserService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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
    private IUserService userService;
    private Users user;
    private Role userRole;

    //to keep user relaed data on the session 
    private HttpSession activeSession; 
//    = (HttpSession) FacesContext
//            .getCurrentInstance().getExternalContext().getSession(true);

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

    /**
     * Authenticate user and redirect to the respective home page based on role.
     *
     * @return
     * @throws Exception
     */
    public String loginUser() throws Exception {

        user = userService.authenticateUser(user);
        //check if the user is registered and authenticated 
        if (user != null) {
            //get the authenticated user 
            setUserSessionData(user);

            //check user code 
            int userRoleCode = user.getRole().getUserCode();
            //admin
            if (userRoleCode == ROLE_ADMIN_CODE) {
                return ("/views/admin/adminHome.xhtml?faces-redirect=true");
            } //faculty user 
            else if (userRoleCode == ROLE_FACULTY_CODE) {
                // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                return ("/views/faculty/facultyHome.xhtml?faces-redirect=true");

            } //vedor user
            else if (userRoleCode == ROLE_CUSTOMER_CODE) {
                // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                return ("/views/customer/customerHome.xhtml?faces-redirect=true");

            }
        }
        //username/password error 
        return null;
    }

    /**
     * Save userID and firstname on session
     *
     * @param user
     */
    public void setUserSessionData(Users user) {
        
        activeSession = (HttpSession) FacesContext
            .getCurrentInstance().getExternalContext().getSession(true);
        
        activeSession.setAttribute("loggedUserId", user.getUserId());
        activeSession.setAttribute("loggedUserFname", user.getFirstName());
    }

}
