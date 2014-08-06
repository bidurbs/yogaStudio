/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Customer;
import com.saviour.poweryoga.model.Section;
import com.saviour.poweryoga.model.Waiver;
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
 */
@Named
@SessionScoped
public class WaiverController implements Serializable {

    private Waiver waiver;
    @Autowired
    private IWaiverService waiverService;
    private List<Section> sections = new ArrayList<>();
    private String sectionId;

    public WaiverController() {
        waiver = new Waiver();
    }

    public Waiver getWaiver() {
        return waiver;
    }

    public void setWaiver(Waiver waiver) {
        this.waiver = waiver;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String displaySections() {
        sections = waiverService.displayAllSections();
        return "requestForWaiver";
    }

    public String waiveSection() {
        //some code here
        Customer customer = (Customer) waiverService.getCustomer();//This customer must be instead obtained from the login user
        Section section = waiverService.getSectionOb(Long.parseLong(sectionId));
        sectionId = " customerID= " + customer.getUserId();//+ " section id= "+section.getId();
        waiver.addCustSec(customer, section);
        waiverService.saveWaiver(waiver);
        return "requestForWaiver";
    }

}
