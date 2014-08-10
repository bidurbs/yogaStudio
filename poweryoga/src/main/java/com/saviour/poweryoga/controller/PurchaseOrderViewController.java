/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.PurchaseOrder;
import com.saviour.poweryoga.serviceI.IPurchaseOrderService;
import com.saviour.poweryoga.serviceI.IUserService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.mail.internet.MailDateFormat;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Named(value = "purchaseOrderViewController")
@SessionScoped
public class PurchaseOrderViewController implements Serializable {

    @Autowired
    private IUserService customerService;

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    private List<PurchaseOrder> purchaseOrders;

    private PurchaseOrder purchaseOrder;

    public PurchaseOrderViewController() {
        purchaseOrder = new PurchaseOrder();
        purchaseOrders = new ArrayList<>();
    }

    public String viewMyOrders() {
        Customer customer = getCurrentCustomer();

        purchaseOrders = purchaseOrderService.findOrderByCustomerId(customer.getUserId());
        for (int i = 0; i < purchaseOrders.size(); i++) {
            purchaseOrders.get(i).setBuyDateStr(refineDate(purchaseOrders.get(i).getBuyingDate()));
        }

        return "/views/customer/viewPurchase";

    }

    public String refineDate(Calendar buyDate) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        if (buyDate != null) {
            String nDate = df.format(buyDate.getTime());
            return nDate;
        }
        return null;
    }

    public Customer getCurrentCustomer() {
        HttpSession activeSession = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);

        Long customerId = (Long) activeSession.getAttribute("loggedUserId");

        return customerService.findCustomerById(customerId);
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public String viewMyOrderDetail(PurchaseOrder order) {
        purchaseOrder = order;
        return "/views/customer/viewPurchaseDetail";
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

}
