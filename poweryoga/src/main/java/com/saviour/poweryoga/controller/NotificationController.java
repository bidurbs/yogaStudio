package com.saviour.poweryoga.controller;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * To handle success and failure message notifications. 
 * @author TalakB
 * @version 0.0.1 
 */
@Named("notificationController")
@Dependent
public class NotificationController implements Serializable{

    public static String errorMsg = null;

    public static String successMsg = null;

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
    
    

}
