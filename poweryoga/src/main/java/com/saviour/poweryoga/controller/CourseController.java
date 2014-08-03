/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.serviceI.ICourseService;
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
@Named("CourseController")
@SessionScoped
public class CourseController implements Serializable {

    @Autowired
    private ICourseService CourseService;

    private Course course;
    private List<Course> listOfCourses;

    public CourseController() {
        course = new Course();
    }
    
    /**
     * Save Course data
     *
     * @return 
     */
    public String saveCourse() {
        CourseService.saveCourse(course);
        return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
    }
    
    /**
     * Display update Course data page
     *
     * @return 
     */
    public String updateCourse() {
        CourseService.updateCourse(course);
        return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
    }
    
    /**
     * Update Course data
     * @param Id
     * @return 
     */
    public String editCourse(int Id) {
        course = CourseService.getCourseById(Id);
        return "editCourse";
    }
    
    /**
     * Delete Course entry
     *
     * @param Id
     * @return 
     */
    public String deleteCourse(int Id) {
        CourseService.deleteCourse(Id);
        return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getListOfCourses() {
        listOfCourses = CourseService.getAllCourses();
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
}
