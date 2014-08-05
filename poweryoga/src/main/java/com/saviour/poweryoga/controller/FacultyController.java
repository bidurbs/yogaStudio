/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.serviceI.IFacultyService;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.serviceI.ISectionService;
import com.saviour.poweryoga.serviceI.IUserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AnurR
 * @version 0.0.1
 */
@Named("FacultyController")
@SessionScoped
public class FacultyController implements Serializable {

    @Autowired
    private IFacultyService FacultyService;
    
    @Autowired
    private UserController usercontroller; 

    @Autowired
    private ISectionService SectionService;

    private Faculty faculty;
    private List<Faculty> listOfFaculty;

    private List<Section> sectionList = new ArrayList<>();

    private Long selectedSectionId;

    public FacultyController() {
        faculty = new Faculty();
    }

    public Long getSelectedSectionId() {
        return selectedSectionId;
    }

    public void setSelectedSectionId(Long selectedSectionId) {
        this.selectedSectionId = selectedSectionId;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    /**
     * Save Course data
     *
     * @return
     */
    public String saveFaculty() {

        Section sectionsAssigned = SectionService.getSectionById(selectedSectionId);
        sectionList.add(sectionsAssigned);
        faculty.setSections(sectionList);
        FacultyService.saveFaculty(faculty);
        return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
    }

    /**
     * Display update Course data page
     *
     * @return
     */
    public String updateFaculty() {
        FacultyService.updateFaculty(faculty);
        return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
    }
    
    /**
     * List all the sections assigned to a faculty 
     * @return 
     */
    public List<Section> getMySections(){
        Faculty fac = (Faculty)usercontroller.getUser();
        return fac.getSections();
    
    }

    /**
     * Update Course data
     *
     * @param Id
     * @return
     */
    public String editFaculty(long Id) {
        faculty = FacultyService.getFacultyById(Id);
        return "editFaculty";
    }

    /**
     * Delete Course entry
     *
     * @param Id
     * @return
     */
    public String deleteFaculty(long Id) {
        FacultyService.deleteFaculty(Id);
        return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Faculty> getListOfFaculty() {
        listOfFaculty = FacultyService.getListOfFaculty();
        return listOfFaculty;
    }

    public void setListOfFaculty(List<Faculty> listOfFaculty) {
        this.listOfFaculty = listOfFaculty;
    }
}
