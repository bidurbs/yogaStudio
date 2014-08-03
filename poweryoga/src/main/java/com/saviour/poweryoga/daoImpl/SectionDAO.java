/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoImpl;

import com.saviour.poweryoga.daoI.ISectionDAO;
import com.saviour.poweryoga.model.Section;
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
public class SectionDAO implements ISectionDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Section section) {
        sessionFactory.getCurrentSession().save(section);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Section> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Section");
        return q.list();
    }

    public void add(Section section) {
        sessionFactory.getCurrentSession().persist(section);
    }

    public Section get(int id) {
        return (Section) sessionFactory.getCurrentSession().get(Section.class, id);
    }

    public void update(Section p) {
        sessionFactory.getCurrentSession().merge(p);
    }

    public void delete(int id) {
        Section p = get(id);
        sessionFactory.getCurrentSession().delete(p);
    }
    
    
    public List<Section> listSectionByCourseId(int Id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Section");
        return q.list();
    }

}
