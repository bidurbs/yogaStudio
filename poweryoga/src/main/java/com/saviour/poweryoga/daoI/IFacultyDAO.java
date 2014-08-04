/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Faculty;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AnurR
 */
public interface IFacultyDAO {
    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Faculty faculty);

    public List<Faculty> getAll();

    public void add(Faculty faculty);

    public Faculty get(long id);

    public void update(Faculty p);

    public void delete(long id);
    
}
