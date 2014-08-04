/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Section;
import java.util.List;

/**
 *
 * @author bidur
 */
public interface ISectionService {

    public void saveSection(Section section);

    public List<Section> getAllSections();

    public void updateSection(Section section);

    public Section getSectionById(int Id);

    public void deleteSection(int Id);

    public List<Section> listSectionByCourseId(int Id);

    public List<Course> getAllCourses();

}
