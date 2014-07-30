/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.dao;

import com.saviour.poweryoga.model.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Product> getAllProducts() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PRODUCT");
        return q.list();
    }
}
