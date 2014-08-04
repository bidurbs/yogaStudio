/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.serviceI.IProductService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
@Named(value = "productSearchController")
@SessionScoped
public class ProductSearchController implements Serializable {

    @Autowired
    private IProductService productService;

    private Product product;
    private List<Product> products;

    private String productName;
    
    public ProductSearchController() {
    }


    public String searchProduct() {
        products = productService.searchProduct(productName);
        return "/views/customer/productSearch";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String viewProductDetail(Product product) {
        this.product=product;
        return "/views/customer/productDetail";
    }
    
}
