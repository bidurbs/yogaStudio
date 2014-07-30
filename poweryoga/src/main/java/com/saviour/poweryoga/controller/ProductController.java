/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.service.ProductService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Named("productController")
@SessionScoped
public class ProductController implements Serializable {

    @Autowired
    private ProductService ProductService;

    private Product product;
    private List<Product> listOfProducts;

    public ProductController() {
        product = new Product();
        //listProducts();
    }

    public String saveProduct() {
        ProductService.saveProduct(product);
        return "product";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void listProducts(){
        listOfProducts = ProductService.getAllProducts();}

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
