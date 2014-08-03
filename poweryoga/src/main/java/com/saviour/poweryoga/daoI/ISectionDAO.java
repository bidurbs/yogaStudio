/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.daoI;

import com.saviour.poweryoga.model.Section;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author bidur
 */
public interface ISectionDAO {

    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void save(Section course);

    public List<Section> getAll();

    public void add(Section course);

    public Section get(int id);

    public void update(Section p);

    public void delete(int id);

    public List<Section> listSectionByCourseId(int Id);
}
