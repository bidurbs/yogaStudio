/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.IShoppingCartDAO;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.model.ShoppingCartItem;
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
public class ShoppingCartDAO implements IShoppingCartDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public ShoppingCart addToCart(ShoppingCart cart) {
        try {
            sessionFactory.getCurrentSession().save(cart);
            return cart;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ShoppingCart removeFromCart(ShoppingCart cart, ShoppingCartItem item) {
        try {
            cart.getShoppingCartItems().remove(item);
            ShoppingCartItem it = (ShoppingCartItem) sessionFactory.getCurrentSession().get(ShoppingCartItem.class, item.getId());
            sessionFactory.getCurrentSession().delete(it);
            return cart;
        } catch (Exception ex) {

        }
        return null;
    }
}
