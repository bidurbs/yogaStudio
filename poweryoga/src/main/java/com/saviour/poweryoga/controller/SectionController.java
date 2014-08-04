/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

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
 * @version 0.0.1
 */
@Named("SectionController")
@SessionScoped
public class SectionController implements Serializable {

    @Autowired
    private ISectionService SectionService;

    private Course course;
    private Section section;
    private List<Section> listOfSection;
    
    private List<Course> listOfCourse;
    

    public SectionController() {
        section = new Section();
        course = new Course();
    }

    /**
     * Save Section data
     *
     * @return
     */
    public String saveSection() {
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
    public String editSection(int Id) {
        section = SectionService.getSectionById(Id);
        return "editSection";
    }

    /**
     * Delete Section entry
     *
     * @param Id
     * @return
     */
    public String deleteSection(int Id) {
        SectionService.deleteSection(Id);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    /**
     * list all the Section for requested course data
     *
     * @param courseId
     * @return
     */
    public String viewSection(int courseId) {
        listOfSection = SectionService.listSectionByCourseId(courseId);
        return ("/views/admin/manageSection.xhtml?faces-redirect=true");
    }

    public Course getCourse() {
        return course;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Section> getListOfSection() {
        return listOfSection;
    }

    public void setListOfSection(List<Section> listOfSection) {
        this.listOfSection = listOfSection;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getListOfCourse() {
        listOfCourse = SectionService.getAllCourses();
        return listOfCourse;
    }

    public void setListOfCourse(List<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }
    
    

}
