/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IProductDAO;
import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.serviceI.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDao;

    @Transactional
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public Product getProductById(int Id) {
        return productDao.get(Id);
    }

    public void deleteProduct(int Id) {
        productDao.delete(Id);
    }

    /**
     * This method will return list of product matched with the parameter name
     *
     * @param name Name of the product
     * @return Product List
     */
    public List<Product> searchProduct(String name) {
        return productDao.searchProduct(name);
    }

}
