package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Waiver;
import com.saviour.poweryoga.serviceI.IFacultyService;
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
public class FacultyService implements IFacultyService {

    @Autowired
    private CRUDFacadeImpl crudfacade;


    @Override
    public void saveFaculty(Faculty faculty) {
        //set faculty role 

        crudfacade.create(faculty);

    }

    @Override
    public List<Faculty> getListOfFaculty() {
        return crudfacade.findWithNamedQuery("Faculty.findAll");
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Faculty getFacultyById(long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFaculty(long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Find the sections where the faculty is assigned.
     *
     * @return
     */
    @Override
    public List<Section> getMySections(Faculty faculty) {

//        Map<String, String> paramaters = new HashMap<>(1);
//        paramaters.put("uemail", facult);
//        paramaters.put("upass", user.getPassword());
//
//        List authUser = crudfacade.findWithNamedQuery("User.authenticateUser", paramaters);
//
//        return (Users) authUser.get(0);
        return null;
    }

    @Override
    public void approveWaiver(Waiver waiver) {
         crudfacade.update(waiver);
    }

//    @Override
//    public void approveWaiver(Waiver waiver) {
//        crudfacade.update(waiver);
//    }

    @Override
    public void rejectWaiver(Waiver waiver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
