/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Course;
import java.util.List;

/**
 *
 * @author bidur
 */
public interface ICourseService {

    public void saveCourse(Course course);

    public List<Course> getAllCourses();

    public void updateCourse(Course course);

    public Course getCourseById(int Id);

    public void deleteCourse(int Id);

    public Course findByName(String cname);
}
