/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saviour.poweryoga.util;

import java.util.regex.Pattern;

/**
 *
 * @author Md Mojahidul Islam
 * @version 0.0.1
 */
public class YogaValidator {

    public static Boolean emailValidator(String email) {
        try {
            String pattern = "\\A^(?=.{0,64}$)([a-z0-9_\\.-]+)@([\\da-z\\.-]+)([\\da-z]+)\\.([a-z]+)\\z";
            return Pattern.compile(pattern).matcher(email).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean dateValidator(String dateValue) {
        try {
            String pattern1 = "\\A^(?=.{0,10}$)((19|20)\\d\\d|\\d{2})[/-](0?[1-9]|1[012])[/-](0?[1-9]|[12][0-9]|3[01])\\z";
            String pattern2 = "\\A^(?=.{0,8}$)((19|20)\\d\\d|\\d{2})(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])\\z";
            return Pattern.compile(pattern1).matcher(dateValue).matches()
                    || Pattern.compile(pattern2).matcher(dateValue).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean numValidator(String number) {
        try {
            String pattern = "\\A-?[0-9]*[\\.]?[0-9]*\\z";
            return Pattern.compile(pattern).matcher(number).matches();
        } catch (Exception e) {
            return false;
        }
    }

}
