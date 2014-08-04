/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.daoI.IFacultyDAO;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.serviceI.IFacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnurR
 * @version 0.0.1
 */
@Service
public class FacultyService implements IFacultyService {

    @Autowired
    private IFacultyDAO facultyDao;

    
    public void saveFaculty(Faculty faculty) {
        facultyDao.save(faculty);
    }
    
    
    public List<Faculty> getListOfFaculty() {
        return facultyDao.getAll();
    }

    public void updateFaculty(Faculty faculty) {
        facultyDao.update(faculty);
    }

    public Faculty getFacultyById(long Id) {
        return facultyDao.get(Id);
    }

    public void deleteFaculty(long Id) {
        facultyDao.delete(Id);
    }
}
