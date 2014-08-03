package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IUserDAO;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IUserService;
import com.saviour.poweryoga.util.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Mojahidul Islam
 * @author TalakB
 * @version 0.0.1
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDao;

    //for password encription 
    private PasswordService encpass = new PasswordService();

    /**
     * Save the user and return Users object if it is saved successfully.
     *
     * @param user
     * @return 
     */
    @Override
    public Users save(Users user) {

        boolean userSaved = false;
        try {
            userDao.save(user);
            userSaved = true;
        } catch (Exception ex) {
        }
        if (userSaved) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * This method pass authentication request to DAO .
     *
     * @param user
     * @return userAuthenticated or null
     */
    @Override
    public Users authenticateUser(Users user) {
        Users userAuthenticated = userDao.authenticatedUser(user);
        return userAuthenticated;
    }

}
