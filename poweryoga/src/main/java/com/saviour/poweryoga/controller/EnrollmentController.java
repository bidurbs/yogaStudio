/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Enrollment;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Waiver;
import com.saviour.poweryoga.serviceI.IEnrollmentService;
import com.saviour.poweryoga.serviceI.IWaiverService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guest
 */
@Named
@RequestScoped
public class EnrollmentController implements Serializable {

    private int maxCapacity = 0, count = 0, flag = 0;
    private Enrollment enrollment;
    private String sectionId;
    private List<Section> sections = new ArrayList<>();
    @Autowired
    private IEnrollmentService enrollmentService;
    @Autowired
    private UserController userController;
    private String message;
    private List<Enrollment> enrollments = new ArrayList<>();
    private String status;
    private List<String> statuses = new ArrayList<>();
    @Autowired
    private IWaiverService waiverService;

    public EnrollmentController() {
        enrollment = new Enrollment();
        statuses.add(Enrollment.StatusType.active.toString());
        statuses.add(Enrollment.StatusType.completed.toString());
        statuses.add(Enrollment.StatusType.waitinglist.toString());
        statuses.add(Enrollment.StatusType.withdrawal.toString());
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void ajaxListner(AjaxBehaviorEvent event) {
//        sectionId = (String) ((UIOutput) event.getSource()).getValue();
//        enrollments = enrollmentService.getAllEnrollments(Long.parseLong(sectionId));
//    }
//
//    public void ajaxListner2(AjaxBehaviorEvent event) {
//        status = (String) ((UIOutput) event.getSource()).getValue();
//        enrollments = enrollmentService.getAllEnrollmentStatus(Long.parseLong(sectionId), status);
//        //message="sectionId="+sectionId;
//    }

    public String deleteCustomer() {
        enrollmentService.deleteEnrollment(enrollment);
        enrollments = enrollmentService.getAllEnrollmentStatus(Long.parseLong(sectionId), status);
        return "manageEnrolledCustomers";
    }

    public String updateCustomer() {
        enrollmentService.updateEnrollment(enrollment);
        enrollments = enrollmentService.getAllEnrollmentStatus(Long.parseLong(sectionId), status);
        return "manageEnrolledCustomers";
    }

    public String displaySections() {
        sections = enrollmentService.displayAllSections();
        sectionId = sections.get(0).getId().toString();
        enrollments = enrollmentService.getAllEnrollments(sections.get(0).getId());
        return "registerForClass";
    }

    public String displaySectionsStatus() {
        sections = enrollmentService.displayAllSections();
        enrollments = enrollmentService.getAllEnrollments(sections.get(0).getId());
        return "manageEnrolledCustomers";
    }
     public String deleteWaitingList(){
        enrollmentService.deleteEnrollment(enrollment);
        message="Data deletion success!!";
        return "section";
    }
    public String enrollCustomer(Long sectionId) {
        Customer customer = (Customer) userController.getCurrentUser();
        Section section = enrollmentService.getSectionOb(sectionId);
        Enrollment en = enrollmentService.isRegistered(customer, section);
        if (en != null) {
            message = "You are already registered!!!";
            return "section";
        }
        maxCapacity = section.getMaxNoStudent();
        count = enrollmentService.getCurrentCount(sectionId);
        if (count == maxCapacity) {

            return addToWaitingList(customer, section);
        }
        if (checkPrerequisite(customer, section) == 0) {
            return "section";
        }
        return  addToEnrolled(customer, section);
    }

    private String addToWaitingList(Customer customer, Section section) {
        enrollment.setCustomerStatus(Enrollment.StatusType.waitinglist);
        enrollment.addCustSec(customer, section);
        enrollmentService.saveEnrollment(enrollment);
        message = "Maximum limit reached, do you want to be added to waiting list?!!";
       // enrollments = enrollmentService.getAllEnrollments(Long.parseLong(sectionId));
        return "section";
    }

    private String addToEnrolled(Customer customer, Section section) {

        enrollment.setCustomerStatus(Enrollment.StatusType.active);
        enrollment.addCustSec(customer, section);
        enrollmentService.saveEnrollment(enrollment);
        message = "Data saved successfully!!";//customer="+customer.getFirstName()+"section="+section.getSectionName();
        flag = 0;
        //enrollments = enrollmentService.getAllEnrollments(Long.parseLong(sectionId));

        return "section";
    }

    private int checkPrerequisite(Customer customer, Section section) {
        Course prerequisite = section.getCourse().getPrerequisites();
        List<Course> sectionHistory = enrollmentService.getSectionHistory(customer);
//        List<Waiver> waivers = waiverService.getAllWaiver();//enrollmentService.checkWaiverStatus(customer.getUserId(),section.getId());
//        if (!waivers.isEmpty()) {
//            for (Waiver w : waivers) {
//                if ((Objects.equals(w.getSection().getId(), section.getId())) && (w.getUser().getUserId() == customer.getUserId()) && w.getStatus().equals(Waiver.statusType.APPROVED)) {
//                    flag = 1;
//                }
//            }
//        }
        if (prerequisite == null) { // check this if it works
            flag = 1;
        } else {
            if (!sectionHistory.isEmpty()) {
                for (Course c2 : sectionHistory) {
                    if (Objects.equals(prerequisite.getId(), c2.getId())) {
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 0) {
            message = "You didn't take prerequisites of the course!!!  ";
        }
        return flag;
    }

}
