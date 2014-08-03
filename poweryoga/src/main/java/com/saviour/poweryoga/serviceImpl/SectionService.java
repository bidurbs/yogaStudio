/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.ISectionDAO;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.serviceI.ISectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Service
public class SectionService implements ISectionService {

    @Autowired
    private ISectionDAO sectionDao;

    public void saveSection(Section section) {
        sectionDao.save(section);
    }

    public List<Section> getAllSections() {
        return sectionDao.getAll();
    }

    public void updateSection(Section section) {
        sectionDao.update(section);
    }

    public Section getSectionById(int Id) {
        return sectionDao.get(Id);
    }

    public void deleteSection(int Id) {
        sectionDao.delete(Id);
    }

    public List<Section> listSectionByCourseId(int Id) {
        return sectionDao.listSectionByCourseId(Id);
    }

}
