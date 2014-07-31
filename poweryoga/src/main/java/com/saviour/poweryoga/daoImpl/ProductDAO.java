/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.IProductDAO;
import com.saviour.poweryoga.model.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Repository
@Transactional
public class ProductDAO implements IProductDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Product> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Product");
        return q.list();
    }

    public void add(Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    public Product get(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public void update(Product p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    public void delete(int id) {
        Product p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }

}
