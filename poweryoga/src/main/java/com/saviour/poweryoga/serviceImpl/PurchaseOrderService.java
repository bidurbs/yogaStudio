/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IPurchaseOrderDAO;
import com.saviour.poweryoga.model.PurchaseOrder;
import com.saviour.poweryoga.serviceI.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Service
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private IPurchaseOrderDAO purchaseOrderDao;

    @Override
    public void savePurchaseOrder(PurchaseOrder order) {

    }

}
