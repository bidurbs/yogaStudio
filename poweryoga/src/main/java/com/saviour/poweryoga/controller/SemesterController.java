package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Semester;
import com.saviour.poweryoga.serviceI.ISemesterService;
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
@Named("semesterController")
@SessionScoped
public class SemesterController implements Serializable {

    @Autowired
    private ISemesterService SemesterService;

    private Semester semester;
    private List<Semester> listOfSemester;

    public SemesterController() {
        semester = new Semester();
    }
    
    /**
     * Save Semester data
     *
     * @return 
     */
    public String saveSemester() {
        semester.setStatus(Semester.statusType.ACTIVE);
        SemesterService.saveSemester(semester);
        return ("/views/admin/manageSemester.xhtml?faces-redirect=true");
    }
    
    /**
     * Display update Semester data page
     *
     * @return 
     */
    public String updateSemester() {
        SemesterService.updateSemester(semester);
        return ("/views/admin/manageSemester.xhtml?faces-redirect=true");
    }
    
    /**
     * Update Semester data
     * @param Id
     * @return 
     */
    public String editSemester(long Id) {
        semester = SemesterService.getSemesterById(Id);
        return "editSemester";
    }
    
    /**
     * add Semester form
     * @return 
     */
    public String addSemester() {
        return ("/views/admin/addSemester.xhtml?faces-redirect=true");
    }
    
    /**
     * Delete Course entry
     *
     * @param Id
     * @return 
     */
    public String deleteSemester(long Id) {
        semester = SemesterService.getSemesterById(Id);

        //Set its status inactive
        semester.setStatus(Semester.statusType.INACTIVE);
        SemesterService.updateSemester(semester);
        //SemesterService.deleteSemester(Id);
        return ("/views/admin/manageSemester.xhtml?faces-redirect=true");
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public List<Semester> getListOfSemester() {
        listOfSemester = SemesterService.getAllSemester();
        return listOfSemester;
    }

    public void setListOfSemester(List<Semester> listOfSemester) {
        this.listOfSemester = listOfSemester;
    }
}
