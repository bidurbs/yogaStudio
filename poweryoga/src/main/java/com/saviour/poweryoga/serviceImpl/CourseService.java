/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.serviceI.ICourseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Service
@Transactional
public class CourseService implements ICourseService {

//    @Autowired
//    private ICourseDAO courseDao;
    @Autowired
    private CRUDFacadeImpl crudfacade;

    /**
     * Find course by course name
     *
     * @param cname
     * @return
     */
    @Override
    public Course findByName(String cname) {
        Map<String, String> paramaters = new HashMap<>(1);
        paramaters.put("cname", cname);
        List course = crudfacade.findWithNamedQuery("Course.findByName", paramaters);
        return (Course) course.get(0);

    }

    @Override
    public void saveCourse(Course course) {
        crudfacade.create(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return crudfacade.findWithNamedQuery("Course.findAll");
    }

    @Override
    public void updateCourse(Course course) {
        crudfacade.update(course);
    }

    @Override
    public Course getCourseById(long Id) {
        return (Course) crudfacade.read(Id, Course.class);
    }

    @Override
    public void deleteCourse(Course course) {
        crudfacade.delete(course);
    }
}
