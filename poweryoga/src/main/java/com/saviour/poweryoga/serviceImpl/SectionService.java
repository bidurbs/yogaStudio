package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Enrollment;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Users;
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
 * @author TalakB
 * @version 0.0.1
 */
@Service
@Transactional
public class SectionService implements ISectionService {

    @Autowired
    private CRUDFacadeImpl crudfacade;

    /**
     * Save new section to the DB.
     *
     * @param section
     */
    @Override
    public void saveSection(Section section) {
        crudfacade.create(section);
    }

    @Override
    public List<Section> getAllSections() {
        return crudfacade.findWithNamedQuery("Section.findAll");
    }

    @Override
    public void updateSection(Section section) {
        crudfacade.update(section);
    }

    @Override
    public Section getSectionById(Long Id) {
        return (Section) crudfacade.read(Id, Section.class);
    }

    @Override
    public void deleteSection(Section section) {
      
        crudfacade.delete(section);
    }

    @Override
    public List<Section> listSectionByCourseId(Long Id) {
        return crudfacade.findWithNamedQuery("Section.findAll");
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

    @Override
    public Section getSectionByName(String sectionName) {
        Map<String, String> paramaters = new HashMap<>(1);
        paramaters.put("sname", sectionName);
        List section = crudfacade.findWithNamedQuery("Section.findByName", paramaters);
        return (Section) section.get(0);
    }

    public Enrollment checkCustomerEnrolled(Section section, Users customer) {
        Enrollment enrollment = (Enrollment) crudfacade.findWithNamedQuery("Enrollment.findCustomerInSection");
        return enrollment;

    }

}
