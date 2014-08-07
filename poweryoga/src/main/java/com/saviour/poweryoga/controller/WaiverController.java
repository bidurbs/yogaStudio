/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Users;
import com.saviour.poweryoga.model.Waiver;
import com.saviour.poweryoga.serviceI.ISectionService;
import com.saviour.poweryoga.serviceI.IWaiverService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guest
 * @author TalakB
 */
@Named
@SessionScoped
public class WaiverController implements Serializable {

    @Autowired
    private IWaiverService waiverService;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private UserController usercontroller;

    private List<Section> section = new ArrayList<>();

    private Waiver waiver;
    private String selectedSectionName;
    private List<Waiver> pendingRequests;

    private String errorMsg = null;

    private String successMsg = null;

    public String getSelectedSectionName() {
        return selectedSectionName;
    }

    public void setSelectedSectionName(String selectedSectionName) {
        this.selectedSectionName = selectedSectionName;
    }

    public WaiverController() {
        waiver = new Waiver();
    }

    public Waiver getWaiver() {
        return waiver;
    }

    public List<Section> getSection() {
        section = sectionService.getAllSections();
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public void setWaiver(Waiver waiver) {
        this.waiver = waiver;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    /**
     * Waive course
     *
     * @return
     */
    public String waiveSection() {
        //some code here
        try {
//            Customer customer = (Customer) waiverService.getCustomer();//This customer must be instead obtained from the login user
//            Section section = waiverService.getSectionOb(sectionId);
//            // sectionId = " customerID= " + customer.getUserId();//+ " section id= "+section.getId();
            //get user from session or by id. 
            Section sec = sectionService.getSectionByName(selectedSectionName);
            Users user = usercontroller.getUser();
            waiver.setUser(user);
            waiver.setSection(sec);
            // waiver.addCustSec(customer, section);
            //set waiver status 
            waiver.setStatus(waiver.getStatus().PENDING);

            waiverService.saveWaiver(waiver);
            successMsg = "Waiver submitted.";
            return ("/views/customer/customerHome.xhtml?faces-redirect=true");

        } catch (Exception ex) {
            ex.printStackTrace();
            errorMsg = "Waiver not submitted.";
            return null;

        }
    }

    

    public List<Waiver> getPendingRequests() {
        pendingRequests = waiverService.showPendingWaivers();
        return pendingRequests;
    }

    public void setPendingRequests(List<Waiver> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

}
