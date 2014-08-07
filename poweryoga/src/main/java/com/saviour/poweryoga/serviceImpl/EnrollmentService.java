/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Enrollment;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.serviceI.IEnrollmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guest
 */
@Service
@Transactional
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private CRUDFacadeImpl crudfacade;

    @Override
    public void saveEnrollment(Enrollment enrollment) {
        crudfacade.create(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollment() {
        return crudfacade.findWithNamedQuery("Enrollment.getAllEnrollment");
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        crudfacade.update(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long Id) {
        List<Enrollment> enrollment = crudfacade.findWithNamedQuery("Enrollment.getEnrollmentById");
        return (Enrollment) enrollment.get(0);
    }

    @Override
    public void deleteEnrollment(Enrollment enrollment) {
        crudfacade.delete(enrollment);
    }
//
//    @Override
//    public List<Section> displayAllSections() {
//        return crudfacade.displayAllSections();
//    }
//
//    @Override
//    public Users getCustomer() {
//        return crudfacade.getCustomer();
//    }
//
//    @Override
//    public Section getSectionOb(Long id) {
//        return crudfacade.getSectionOb(id);
//    }
//
//    @Override
//    public int getCurrentCount(Long id) {
//        return crudfacade.getCurrentCount(id);
//    }
//
//    @Override
//    public List<Course> getSectionHistory(Users custmomer) {
//        return crudfacade.getSectionHistory(custmomer);
//    }

    @Override
    public Enrollment isRegistered(Customer customer, Section section) {
        List<Enrollment> enrollment = crudfacade.findWithNamedQuery("Enrollment.isRegistered");
        return (Enrollment) enrollment.get(0);
    }

//    @Override
//    public List<Course> getPrerequisites(Section section) {
//        return crudfacade.getPrerequisites(section);
//    }

    @Override
    public List<Section> displayAllSections() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Section getSectionOb(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrentCount(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> getSectionHistory(Users custmomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> getPrerequisites(Section section) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
