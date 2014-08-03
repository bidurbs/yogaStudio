package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Users;
import java.util.List;

/**
 *
 * @author TalakB
 */
public interface IUserService {

    public Users saveUser(Users user);
    
    public void updateUser(Users user);

    public Users authenticateUser(Users user);

    public List<Customer> findAllCustomer();

    public Customer findCustomerById(long customerId);

    public Customer findCustomerByEmail(String email);

}
