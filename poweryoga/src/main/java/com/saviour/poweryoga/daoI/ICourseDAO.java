/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Course;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author bidur
 */
public interface ICourseDAO {
    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Course course);

    public List<Course> getAll();

    public void add(Course course);

    public Course get(int id);

    public void update(Course p);

    public void delete(int id);
    
}
