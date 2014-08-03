package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.model.PurchaseOrder;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.model.ShoppingCartItem;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IProductService;
import com.saviour.poweryoga.serviceI.IPurchaseOrderService;
import com.saviour.poweryoga.serviceI.IShoppingCartService;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Named(value = "purchaseOrderController")
@SessionScoped
public class PurchaseOrderController implements Serializable {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    @Autowired
    private IProductService productService;

    private Product product;

    private PurchaseOrder purchaseOrder;

    private ShoppingCart shoppingCart;

    private int productQty;

    private double price;

    private int noOfItemsInTheCart;

    private Users usr = null;

    public PurchaseOrderController() {
        shoppingCart = new ShoppingCart();
        purchaseOrder = new PurchaseOrder();
        productQty = 1;
    }

    public String addToCart(int productId) {

        product = productService.getProductById(productId);

        if (shoppingCart.getId() == null) {
            shoppingCart.setUser(usr);
            shoppingCart.setShopDate(Calendar.getInstance());
        }

        List<ShoppingCartItem> cartItems = shoppingCart.getShoppingCartItems();
        ShoppingCartItem item = new ShoppingCartItem();
        item.setProduct(product);
        item.setQuantity(productQty);
        item.setPrice(productQty * product.getPrice());
        item.setShoppingCart(shoppingCart);
        cartItems.add(item);

        productQty = 1;

        shoppingCart = shoppingCartService.addToCart(shoppingCart);
        if (shoppingCart != null) {
            System.out.println("Product in Shopping cart added Successfully");

            noOfItemsInTheCart = shoppingCart.getShoppingCartItems().size();

        } else {

        }
        updateShoppingCartTotalCost();
        return "/views/customer/shoppingCart";
    }

    private void updateShoppingCartTotalCost() {
        double total = 0;
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
            total += shoppingCartItem.getPrice();
        }
        shoppingCart.setTotalPrice(total);
    }

    public void removeProduct(ShoppingCartItem item) {
        shoppingCart = shoppingCartService.removeFromCart(shoppingCart, item);
        updateShoppingCartTotalCost();
    }

    public void updateProduct(ShoppingCartItem item) {

        for (ShoppingCartItem cartItem : shoppingCart.getShoppingCartItems()) {
            if (cartItem.getId() == item.getId()) {
                cartItem.setPrice(item.getQuantity() * item.getProduct().getPrice());
            }
        }
        shoppingCart = shoppingCartService.addToCart(shoppingCart);
        updateShoppingCartTotalCost();
    }

    public void checkout() {

    }
}
