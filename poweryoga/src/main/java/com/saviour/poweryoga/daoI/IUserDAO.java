package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author TalakB
 */
public interface IUserDAO {

    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void saveUser(Users user);

    public void updateUser(Users user);

    public Users authenticatedUser(Users user);

    public Session getSession();

    public void setSession(Session session);

    public List<Customer> findAllCustomer();

    public Customer findCustomerById(long customerId);

    public Customer findCustomerByEmail(String email);

}
