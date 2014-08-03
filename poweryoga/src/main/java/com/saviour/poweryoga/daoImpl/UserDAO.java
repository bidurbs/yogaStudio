/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.IUserDAO;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Mojahidul Islam
 * @author TalakB
 * @version 0.0.2
 */
@Repository
@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(Users user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public List<Customer> findAllCustomer() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Users.findAllCustomer");

        List<Customer> customers = query.list();

        return customers;
    }

    public Customer findCustomerById(long customerId) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Users.findCustomerByEmail").setParameter("email", email);

        Customer customer = (Customer) query.uniqueResult();

        return customer;
    }

    public Users authenticatedUser(Users user) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Users u where u.email = :uemail and u.password= :upass");
        query.setParameter("uemail", user.getEmail());
        query.setParameter("upass", user.getPassword());

        if (query.uniqueResult() != null) {
            Users userAuthenticated = (Users) query.uniqueResult();
            return userAuthenticated;
        }

        //user not found or email and password error 
        return null;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
