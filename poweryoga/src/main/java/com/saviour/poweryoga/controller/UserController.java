package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IUserService;
import com.saviour.poweryoga.util.PasswordService;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
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
@Dependent
public class UserController implements Serializable {

    @Autowired
    private IUserService userService;
    
    //for success and error message notifications 
    @Autowired
    private NotificationController notoficationController; 
    
    private Users user;
    private Role userRole;

    //to keep user relaed data on the session 
    private HttpSession activeSession;

    public static final int ROLE_ADMIN_CODE = 1;
    public static final int ROLE_FACULTY_CODE = 2;
    public static final int ROLE_CUSTOMER_CODE = 3;

    private boolean isAdmin;
    private boolean isFaculty;
    private boolean isCustomer;
    private boolean isLoggedin;



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

    public HttpSession getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(HttpSession activeSession) {
        this.activeSession = activeSession;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsFaculty() {
        return isFaculty;
    }

    public void setIsFaculty(boolean isFaculty) {
        this.isFaculty = isFaculty;
    }

    public boolean isIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public boolean isIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }
    
    

    /**
     * Authenticate user and redirect to the respective home page based on role.
     *
     * @return
     * @throws Exception
     */
    public String loginUser() throws Exception {
        
        //encrypt password to check it against the DB. 
        String encPass = PasswordService.encrypt(user.getPassword());
        user.setPassword(encPass);

        try {
            user = userService.authenticateUser(user);
            //check if the user is registered and authenticated 
            if (user != null) {
                //set the authenticated user info. on the session  
                setUserSessionData(user);
                

                //check user code 
                int userRoleCode = user.getRole().getUserCode();
                //admin
                if (userRoleCode == ROLE_ADMIN_CODE) {
                    isAdmin = true;
                    return ("/views/admin/adminHome.xhtml?faces-redirect=true");
                } //faculty user 
                else if (userRoleCode == ROLE_FACULTY_CODE) {
                    // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                    isFaculty = true;
                    return ("/views/faculty/facultyHome.xhtml?faces-redirect=true");

                } //vedor user
                else if (userRoleCode == ROLE_CUSTOMER_CODE) {
                    // activeSession.setAttribute("loggedUser", user);
//                userLogged = true;
//                isAdminUser = true;
                    isCustomer = true;
                    return ("/views/customer/customerHome.xhtml?faces-redirect=true");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            notoficationController.setErrorMsg("Login failed. Please cehck username/password.");
        }
        return null;

    }

    /**
     * Save userID and first name on session
     *
     * @param user
     */
    public void setUserSessionData(Users user) {
        //set loggedin flag true 
        isLoggedin = true;
        activeSession = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);
        activeSession.setAttribute("loggedUserId", user.getUserId());
        activeSession.setAttribute("loggedUserFname", user.getFirstName());
    }

}
