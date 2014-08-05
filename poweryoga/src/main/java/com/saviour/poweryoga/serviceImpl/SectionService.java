/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.serviceI.ISectionService;
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
public class SectionService implements ISectionService {
//
//    @Autowired
//    private ISectionDAO sectionDao;
//
//    @Autowired
//    private ICourseDAO courseDao;

    @Autowired
    private CRUDFacadeImpl crudfacade;

    /**
     * Save new section to the DB.
     *
     * @param section
     */
    public void saveSection(Section section) {
        crudfacade.create(section);
        //sectionDao.save(section);
    }

//    public List<Section> getAllSections() {
//        return sectionDao.getAll();
//    }
//
//    public void updateSection(Section section) {
//        sectionDao.update(section);
//    }
//
//    public Section getSectionById(int Id) {
//        return sectionDao.get(Id);
//    }
//
//    public void deleteSection(int Id) {
//        sectionDao.delete(Id);
//    }
//
//    public List<Section> listSectionByCourseId(int Id) {
//        return sectionDao.listSectionByCourseId(Id);
//    }
//
//    public List<Course> getAllCourses() {
//        return courseDao.getAll();
//    }
    @Override
    public List<Section> getAllSections() {
        return crudfacade.findWithNamedQuery("Section.findAll");
    }

    @Override
    public void updateSection(Section section) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Section getSectionById(Long Id) {
        return (Section) crudfacade.read(Id, Section.class);
    }

    @Override
    public void deleteSection(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> listSectionByCourseId(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Find all courses. It is used to assign course for a specific section.
     *
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        return crudfacade.findWithNamedQuery("Course.findAll");
    }

}
