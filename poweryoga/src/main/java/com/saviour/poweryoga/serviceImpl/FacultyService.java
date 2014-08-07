
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Faculty;
import com.saviour.poweryoga.model.Role;
import com.saviour.poweryoga.model.Section;
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
        crudfacade.update(faculty);
    }

    @Override
    public Faculty getFacultyById(long Id) {
        return (Faculty) crudfacade.read(Id, Faculty.class);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
       crudfacade.delete(faculty);
    }

    /**
     * Find the sections where the faculty is assigned. 
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
}
