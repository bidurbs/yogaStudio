/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.serviceI.IFacultyService;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Waiver;
import com.saviour.poweryoga.serviceI.IRoleService;
import com.saviour.poweryoga.serviceI.ISectionService;
import com.saviour.poweryoga.util.EmailManager;
import com.saviour.poweryoga.util.PasswordService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author AnurR
 * @author TalakB
 * @version 0.0.1
 */
@Named("facultyController")
@SessionScoped
public class FacultyController implements Serializable {

    @Autowired
    private IFacultyService facultyService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private UserController usercontroller;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private JavaMailSender mailSender;

    private Faculty faculty;
    private List<Faculty> listOfFaculty;

    private List<Section> sectionList = new ArrayList<>();

    private Long selectedSectionId;

    private String errorMsg = null;

    private String successMsg = null;

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
     * Save faculty data
     *
     * @return
     */
    public String saveFaculty() {

        try {
            Section sectionsAssigned = sectionService.getSectionById(selectedSectionId);
            sectionList.add(sectionsAssigned);
            faculty.setSections(sectionList);

            //set faculty role from userControll
            Role facRRole = roleService.getRoleByUserCode(UserController.ROLE_FACULTY_CODE);
            //  facRRole.setUserCode(UserController.ROLE_FACULTY_CODE);
            faculty.setPassword(PasswordService.encrypt(faculty.getPassword()));

            faculty.setRole(facRRole);
            facultyService.saveFaculty(faculty);
            return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
        } catch (Exception ex) {
            ex.printStackTrace();
            errorMsg = "Customer saving failed";
        }
        return null;
    }

    /**
     * Display update faculty data page
     *
     * @return
     */
    public String updateFaculty() {
        facultyService.updateFaculty(faculty);
        return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
    }

    /**
     * List all the sections assigned to a faculty
     *
     * @return
     */
    public List<Section> getMySections() {
        Faculty fac = (Faculty) usercontroller.getUser();
        return fac.getSections();
    }

    /**
     * Update Faculty data
     *
     * @param Id
     * @return
     */
    public String editFaculty(long Id) {
        faculty = facultyService.getFacultyById(Id);
        return "editFaculty";
    }

    /**
     * Delete Faculty entry
     *
     * @param Id
     * @return
     */
    public String deleteFaculty(long Id) {
        faculty = facultyService.getFacultyById(Id);
        facultyService.deleteFaculty(faculty);
        return ("/views/admin/manageFaculty.xhtml?faces-redirect=true");
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Faculty> getListOfFaculty() {
        listOfFaculty = facultyService.getListOfFaculty();
        return listOfFaculty;
    }

    public void setListOfFaculty(List<Faculty> listOfFaculty) {
        this.listOfFaculty = listOfFaculty;
    }

    /**
     * Approve pending requests
     *
     * @param waiver
     * @return
     */
    public String approveWaiverRequest(Waiver waiver) {
        try {
            waiver.setStatus(Waiver.statusType.APPROVED);
            facultyService.updateWaiverRequest(waiver);

            //send email to the customer 
            notifyWaiverRequestDecision(waiver);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return "";

    }

    

    /**
     * Reject pending requests
     *
     * @param waiver
     * @return
     */
    public String rejectWaiverRequest(Waiver waiver) {
        try {
            waiver.setStatus(Waiver.statusType.NOTAPPROVED);
            facultyService.updateWaiverRequest(waiver);
             //send email to the customer 
            notifyWaiverRequestDecision(waiver);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return "";

    }
    
    /**
     * Notify user about the waiver decision. 
     * @param waiver 
     */
    public void notifyWaiverRequestDecision(Waiver waiver) {
        EmailManager.sendEmail(mailSender, "Waiver request +" + waiver.getStatus().toString().toLowerCase(),
                "Your waiver request for the section" + waiver.getSection().getSectionName() + " is " + waiver.getStatus().toString().toLowerCase(),
                waiver.getUser().getEmail());
    }
}
