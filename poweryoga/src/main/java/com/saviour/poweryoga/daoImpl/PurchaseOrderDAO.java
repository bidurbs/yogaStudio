/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.IPurchaseOrderDAO;
import com.saviour.poweryoga.model.PurchaseOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Repository
public class PurchaseOrderDAO implements IPurchaseOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder order) {
        sessionFactory.getCurrentSession().save(order);
        return order;
    }
}
