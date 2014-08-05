/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;


import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.daoI.ISemesterDAO;
import com.saviour.poweryoga.model.Semester;
import com.saviour.poweryoga.serviceI.ISemesterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AnurR
 * @version 0.0.1
 */
@Service
@Transactional
public class SemesterService implements ISemesterService {

    @Autowired
    private ISemesterDAO semesterDao;

    @Autowired
    private CRUDFacadeImpl crudfacade;

    public void saveSemester(Semester semester) {
        crudfacade.create(semester);
    }


    public List<Semester> getAllSemester() {
        return semesterDao.getAll();
    }

    public void updateSemester(Semester semester) {
        semesterDao.update(semester);
    }

    public Semester getSemesterById(long Id) {
        return semesterDao.get(Id);
    }

    public void deleteSemester(long Id) {
        semesterDao.delete(Id);
    }
}
