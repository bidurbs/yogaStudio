/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IPurchaseOrderDAO;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.PurchaseOrder;
import com.saviour.poweryoga.model.ShoppingCart;
import com.saviour.poweryoga.serviceI.IPurchaseOrderService;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Transactional
@Service
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private IPurchaseOrderDAO purchaseOrderDao;

    @Override
    public PurchaseOrder savePurchaseOrder(ShoppingCart shoppingCart, Customer customer, Calendar buyDate) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(buyDate, shoppingCart, customer);
        return purchaseOrderDao.savePurchaseOrder(purchaseOrder);

    }

}
