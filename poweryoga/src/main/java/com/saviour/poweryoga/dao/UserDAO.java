/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.dao;

import com.saviour.poweryoga.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public void save(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public Users authenticatedUser(Users user) {

        Query query = session.getNamedQuery("authenticateUser");
        query.setParameter("uname", user.getEmail());
        query.setParameter("upass", user.getPassword());

        if (!query.list().isEmpty()) {
            Users userAuthenticated = (Users) query.list();
            return userAuthenticated;
        }
        return null;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
