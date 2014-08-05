/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.ISemesterDAO;
import com.saviour.poweryoga.model.Semester;
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
public class SemesterDAO implements ISemesterDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Semester semester) {
        sessionFactory.getCurrentSession().save(semester);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Semester> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Semester");
        return q.list();
    }

    public void add(Semester semester) {
        sessionFactory.getCurrentSession().persist(semester);
    }

    public Semester get(long id) {
        return (Semester) sessionFactory.getCurrentSession().get(Semester.class, id);
    }

    public void update(Semester p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    public void delete(long id) {
        Semester p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }
    @Override
     public Semester getSemesterBySemesterId(long Id) {
        return null;
    }

}
