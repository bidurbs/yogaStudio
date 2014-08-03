/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.ICourseDAO;
import com.saviour.poweryoga.model.Course;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Repository
@Transactional
public class CourseDAO implements ICourseDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Course> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Course");
        return q.list();
    }

    public void add(Course course) {
        sessionFactory.getCurrentSession().persist(course);
    }

    public Course get(int id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

    public void update(Course p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    public void delete(int id) {
        Course p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }

}
