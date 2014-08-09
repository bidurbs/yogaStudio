package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.model.ShoppingCartItem;
import com.saviour.poweryoga.serviceI.IShoppingCartService;
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
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private CRUDFacadeImpl crudfacade;

    @Override
    public ShoppingCart addToCart(ShoppingCart cart) {
        return (ShoppingCart) crudfacade.create(cart);
    }

    @Override
    public ShoppingCart removeFromCart(ShoppingCart cart, ShoppingCartItem item) {
        cart.getShoppingCartItems().remove(item);
        ShoppingCartItem it = (ShoppingCartItem) crudfacade.read(item.getId(), ShoppingCartItem.class);
        crudfacade.delete(it);
        return cart;
    }
}
