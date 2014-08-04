/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.IFacultyDAO;
import com.saviour.poweryoga.model.Faculty;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AnurR
 * @version 0.0.1
 */
@Repository
@Transactional
public class FacultyDAO implements IFacultyDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Faculty faculty) {
        sessionFactory.getCurrentSession().save(faculty);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Faculty> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Faculty");
        return q.list();
    }

    public void add(Faculty faculty) {
        sessionFactory.getCurrentSession().persist(faculty);
    }

    public Faculty get(long id) {
        return (Faculty) sessionFactory.getCurrentSession().get(Faculty.class, id);
    }

    public void update(Faculty p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    public void delete(long id) {
        Faculty p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }

}
