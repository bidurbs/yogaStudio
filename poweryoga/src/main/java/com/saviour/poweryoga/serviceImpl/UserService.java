package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IUserDAO;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IUserService;
import com.saviour.poweryoga.util.PasswordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Mojahidul Islam
 * @author TalakB
 * @version 0.0.1
 */
@Transactional
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
    public Users saveUser(Users user) {

        boolean userSaved = false;
        try {
            userDao.saveUser(user);
            userSaved = true;
        } catch (Exception ex) {
        }
        if (userSaved) {
            return user;
        } else {
            return null;
        }
    }

    public List<Customer> findAllCustomer() {
        return userDao.findAllCustomer();
    }

    public Customer findCustomerById(long customerId) {
        return userDao.findCustomerById(customerId);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return userDao.findCustomerByEmail(email);
    }

    public void updateUser(Users user) {
        userDao.updateUser(user);
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
