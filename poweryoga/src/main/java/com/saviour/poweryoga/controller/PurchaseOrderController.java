package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Address;
import com.saviour.poweryoga.model.CreditCard;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.model.PurchaseOrder;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.model.ShoppingCartItem;
import com.saviour.poweryoga.serviceI.IProductService;
import com.saviour.poweryoga.serviceI.IPurchaseOrderService;
import com.saviour.poweryoga.serviceI.IShoppingCartService;
import com.saviour.poweryoga.serviceI.IUserService;
import com.saviour.poweryoga.util.EmailManager;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

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
    private IUserService customerService;

    @Autowired
    private IProductService productService;

    @Autowired
    private JavaMailSender mailSender;

    private Product product;

    private PurchaseOrder purchaseOrder;

    private ShoppingCart shoppingCart;

    private int productQty;

    private double price;

    private int noOfItemsInTheCart;

    private Customer customer = null;

    private String errorMsg = null;

    private String successMsg = null;

    private Address billingAddress;

    private Address shippingAddress;

    private CreditCard creditCard;

    public PurchaseOrderController() {
        shoppingCart = new ShoppingCart();
        purchaseOrder = new PurchaseOrder();
        billingAddress = new Address();
        shippingAddress = new Address();
        creditCard = new CreditCard();
        productQty = 1;
    }

    public String addToCart(Long productId) {

        product = productService.getProductById(productId);

        HttpSession activeSession = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);

        Long customerId = (Long) activeSession.getAttribute("loggedUserId");

        customer = customerService.findCustomerById(customerId);

        if (shoppingCart.getId() == null) {
            shoppingCart.setUser(customer);
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

    public String checkout() {
        purchaseOrder = purchaseOrderService.savePurchaseOrder(shoppingCart, customer, Calendar.getInstance());
        if (purchaseOrder != null) {

            //EMAIL SENDING
            EmailManager.sendEmail(mailSender, "Your shopping receipt", "Thank you for shopping", "shahin.kuet@gmail.com");

            successMsg = "Thank you for shopping with us. Please check your email for order detail";
            errorMsg = null;
            return "/views/customer/customerAddress.jsf?faces-redirect=true";
        }
        successMsg = null;
        errorMsg = "Ooops !!! something went wrong confirming your order";
        return null;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfItemsInTheCart() {
        return noOfItemsInTheCart;
    }

    public void setNoOfItemsInTheCart(int noOfItemsInTheCart) {
        this.noOfItemsInTheCart = noOfItemsInTheCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String saveAddress() {

        customer = getCurrentCustomer();
        customer.setAddress(billingAddress);
        customerService.updateUser(customer);

        return "/views/customer/cardInformation.jsf?faces-redirect=true";
    }

    public String saveCreditCard() {
        customer = getCurrentCustomer();
        creditCard.setCustomer(customer);
        customer.addCreditCard(creditCard);
        customerService.updateUser(customer);

        return "/views/customer/orderDetail.jsf?faces-redirect=t                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          rue";
    }

    public Customer getCurrentCustomer() {
        HttpSession activeSession = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);

        Long customerId = (Long) activeSession.getAttribute("loggedUserId");

        return customerService.findCustomerById(customerId);
    }

}
