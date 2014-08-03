/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.serviceI.IShoppingCartService;
import com.saviour.poweryoga.dao.ShoppingCartDAO;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.model.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private ShoppingCartDAO shoppingCartDao;

    @Override
    public ShoppingCart addToCart(ShoppingCart cart) {
        return shoppingCartDao.addToCart(cart);
    }

    @Override
    public ShoppingCart removeFromCart(ShoppingCart cart, ShoppingCartItem item) {
        return shoppingCartDao.removeFromCart(cart, item);
    }
}
