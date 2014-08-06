/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Product;
import com.saviour.poweryoga.serviceI.ICourseService;
import com.saviour.poweryoga.serviceI.IProductService;
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
@Named("indexController")
@SessionScoped
public class IndexController implements Serializable {

    @Autowired
    private IProductService ProductService;

    @Autowired
    private ICourseService CourseService;

    private List<Course> ListOfCourses;
    private List<Product> listOfProducts;
    private List<Product> listOfFeaturedProducts;

    public IndexController() {

    }

    public List<Course> getListOfCourses() {
        ListOfCourses = CourseService.getAllCourses();
        return ListOfCourses;
    }

    public void setListOfCourses(List<Course> ListOfCourses) {
        this.ListOfCourses = ListOfCourses;
    }

    public List<Product> getListOfProducts() {
        listOfProducts = ProductService.getAllProducts();
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
    
    public List<Product> getListOfFeaturedProducts() {
        return listOfFeaturedProducts;
    }

    public void setListOfFeaturedProducts(List<Product> listOfFeaturedProducts) {
        this.listOfFeaturedProducts = listOfFeaturedProducts;
    }


    public List<Product> getFeaturedProducts() {
        listOfFeaturedProducts = ProductService.getFeaturedProducts();
        return listOfFeaturedProducts;
    }

}
