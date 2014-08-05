/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceI;

import com.saviour.poweryoga.model.Semester;
import java.util.List;

/**
 *
 * @author bidur
 */
public interface ISemesterService {

    public void saveSemester(Semester semester);

    public List<Semester> getAllSemester();

    public void updateSemester(Semester semester);

    public Semester getSemesterById(long Id);

    public void deleteSemester(long Id);
}
