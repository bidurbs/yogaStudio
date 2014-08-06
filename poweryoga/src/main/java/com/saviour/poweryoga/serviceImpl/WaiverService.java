/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.serviceImpl;

import com.saviour.poweryoga.crudfacade.CRUDFacadeImpl;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.model.Waiver;
import com.saviour.poweryoga.serviceI.IWaiverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guest
 * @author TalakB
 * @version 0.0.1 
 */
@Service
@Transactional
public class WaiverService implements IWaiverService {

    
    @Autowired
    private CRUDFacadeImpl crudfacade;

    @Override
    public void saveWaiver(Waiver waiver) {
        crudfacade.create(waiver);
    }

    @Override
    public List<Waiver> getAllWaiver() {
        return crudfacade.findWithNamedQuery("Waiver.findAllWaivers");
    }

    @Override
    public void updateWaiver(Waiver waiver) {

    }

    @Override
    public Waiver getWaiverById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteWaiver(Waiver waiver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> displayAllSections() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Section getSectionOb(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
