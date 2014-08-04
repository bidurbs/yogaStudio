/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.serviceI.IFacultyService;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.serviceImpl.FacultyService;
import java.io.Serializable;
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

    private Faculty faculty;
    private List<Faculty> listOfFaculty;

    public FacultyController() {
        faculty = new Faculty();
    }
    
    /**
     * Save Course data
     *
     * @return 
     */
    public String saveFaculty() {
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
     * Update Course data
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
