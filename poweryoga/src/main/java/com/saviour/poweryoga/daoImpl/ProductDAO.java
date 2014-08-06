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
public class ProductDAO implements IProductDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<Product> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Product");
        return q.list();
    }

    @Override
    public void add(Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    @Override
    public Product get(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(Product p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    @Override
    public void delete(int id) {
        Product p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }

    public List<Product> searchProduct(String name) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Product.searchProduct");
        String param = "%" + name + "%";
        query.setParameter("pname", param);

        List<Product> products = query.list();
        return products;
    }

    public List<Product> findAllFeatured() {
        Query q = sessionFactory.getCurrentSession().getNamedQuery("Product.getAllFeatured");
        return (List<Product>) q.list();
    }

}
