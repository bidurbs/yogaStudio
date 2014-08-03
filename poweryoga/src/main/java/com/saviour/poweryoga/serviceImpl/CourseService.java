/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.ICourseDAO;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.serviceI.ICourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDAO courseDao;

    
    public void saveCourse(Course course) {
        courseDao.save(course);
    }
    
    
    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public void updateCourse(Course course) {
        courseDao.update(course);
    }

    public Course getCourseById(int Id) {
        return courseDao.get(Id);
    }

    public void deleteCourse(int Id) {
        courseDao.delete(Id);
    }
}
