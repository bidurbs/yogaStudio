package com.saviour.poweryoga.controller;

/**
 * To handle success and failure message notifications. 
 * @author TalakB
 * @version 0.0.1 
 */
public class NotificationController {

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
