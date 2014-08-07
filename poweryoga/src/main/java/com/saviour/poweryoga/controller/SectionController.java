/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.crudfacade.CRUDEntityFacade;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.serviceI.ICourseService;
import com.saviour.poweryoga.serviceI.ISectionService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bidur
 * @author TalakB
 * @version 0.0.1
 */
@Named("SectionController")
@SessionScoped
public class SectionController implements Serializable {

    @Autowired
    private ISectionService SectionService;

    @Autowired
    private ICourseService courseService;

    //  private Course course;
    private Section section;
    private List<Section> listOfSection;
    private List<Course> listOfCourse;
    private String selectedCourse;

    public SectionController() {
        section = new Section();
        //    course = new Course();
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    /**
     * Save Section data
     *
     * @return
     */
    public String saveSection() {
        // find the section based on selected course name and set course of this section 
        Course course = courseService.findByName(selectedCourse);
        section.setCourse(course);
        SectionService.saveSection(section);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    /**
     * Display update Section data page
     *
     * @return
     */
    public String updateSection() {
        SectionService.updateSection(section);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    /**
     * Update Section data
     *
     * @param Id
     * @return
     */
    public String editSection(Long Id) {
        section = SectionService.getSectionById(Id);
        return "editSection";
    }

    /**
     * Delete Section entry
     *
     * @param Id
     * @return
     */
    public String deleteSection(Long Id) {
        section = SectionService.getSectionById(Id);
        SectionService.deleteSection(section);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    /**
     * list all the Section for requested course data
     *
     * @param courseId
     * @return
     */
    public String viewSection(Long courseId) {
        listOfSection = SectionService.listSectionByCourseId(courseId);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Section> getListOfSection() {
        return listOfSection = SectionService.getAllSections();
    }

    public void setListOfSection(List<Section> listOfSection) {
        this.listOfSection = listOfSection;
    }

    public List<Course> getListOfCourse() {
        listOfCourse = SectionService.getAllCourses();
        return listOfCourse;
    }

    public void setListOfCourse(List<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }
    /**
     * Display all the Section for requested course data for customer
     *
     * @param courseId
     * @return
     */
    public String displaySection(long courseId) {
        listOfSection = SectionService.listSectionByCourseId(courseId);
        return ("/views/customer/section.xhtml?faces-redirect=true");
    }
}
