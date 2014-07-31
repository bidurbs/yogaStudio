package com.saviour.poweryoga.service;

import com.saviour.poweryoga.dao.UserDAO;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.util.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    //for password encription 
    private PasswordService encpass = new PasswordService();

    
    
    
    public void save(Users user) {
        userDao.save(user);
    }

    /**
     * This method authenticates user access and returns status.
     *
     * @param user
     * @return userAuthenticated or null
     */
    public Users authenticateUser(Users user) {
        Users userAuthenticated = userDao.authenticatedUser(user);
        return userAuthenticated;
    }

}
