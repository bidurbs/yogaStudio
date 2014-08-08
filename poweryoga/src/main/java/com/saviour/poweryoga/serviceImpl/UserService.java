package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.daoI.IUserDAO;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private CRUDFacadeImpl crudfacade;

    
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
            crudfacade.create(user);
            
            //assign faculty for this registered user. 
            userSaved = true;
        } catch (Exception ex) {
        }
        if (userSaved) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        return userDao.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(long customerId) {
        return userDao.findCustomerById(customerId);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return userDao.findCustomerByEmail(email);
    }

    @Override
    public void updateUser(Users user) {
        crudfacade.update(user);
    }

    /**
     * This method pass authentication request to DAO .
     *
     * @param user
     * @return userAuthenticated or null
     */
    @Override
    public Users authenticateUser(Users user) {
        try {
            Map<String, String> paramaters = new HashMap<>(2);
            paramaters.put("uemail", user.getEmail());
            paramaters.put("upass", user.getPassword());

            List authUser = crudfacade.findWithNamedQuery("User.authenticateUser", paramaters);

            return (Users) authUser.get(0);
        } catch (Exception ex) {
            return null;

        }
    }

}
