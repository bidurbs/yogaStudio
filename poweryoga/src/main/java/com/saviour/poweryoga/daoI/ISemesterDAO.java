/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Semester;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AnurR
 */
public interface ISemesterDAO {
    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Semester semester);

    public List<Semester> getAll();

    public void add(Semester semester);

    public Semester get(long id);

    public void update(Semester p);

    public void delete(long id);

    public Semester getSemesterBySemesterId(long Id);
    
}
