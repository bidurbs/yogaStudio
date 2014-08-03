/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.serviceI.IProductService;
import com.saviour.poweryoga.serviceImpl.ProductService;
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
    private IProductService ProductService;

    private Product product;
    private List<Product> listOfProducts;

    public ProductController() {
        product = new Product();
    }
    
    /**
     * Save Product data
     *
     * @return 
     */
    public String saveProduct() {
        ProductService.saveProduct(product);
        return ("/views/admin/manageProduct.xhtml?faces-redirect=true");
    }
    
    /**
     * Display update Product data page
     *
     * @return 
     */
    public String updateProduct() {
        ProductService.updateProduct(product);
        return ("/views/admin/manageProduct.xhtml?faces-redirect=true");
    }
    
    /**
     * Update Product data
     * @param Id
     * @return 
     */
    public String editProduct(int Id) {
        product = ProductService.getProductById(Id);
        return "editProduct";
    }
    
    /**
     * Delete Product entry
     *
     * @param Id
     * @return 
     */
    public String deleteProduct(int Id) {
        ProductService.deleteProduct(Id);
        return ("/views/admin/manageProduct.xhtml?faces-redirect=true");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getListOfProducts() {
        listOfProducts = ProductService.getAllProducts();
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
