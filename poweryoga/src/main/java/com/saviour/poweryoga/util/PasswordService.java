package com.saviour.poweryoga.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Singleton;
import org.springframework.stereotype.Component;
//import org.myorg.SystemUnavailableException;
import sun.misc.BASE64Encoder;

/**
 * This class handles password encryption
 *
 * @author TalakB 
 * @version 1.0.0
 */
@Component
@Singleton
public class PasswordService implements Serializable {

    private static PasswordService instance;

    public PasswordService() {
    }

    /**
     * This method encrypts password
     *
     * @param plaintext
     * @return hash
     * @throws Exception
     */
    public static synchronized String encrypt(String plaintext) throws Exception {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA"); //step 2
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e.getMessage());
        }
        try {
            md.update(plaintext.getBytes("UTF-8")); //step 3
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e.getMessage());
        }

        byte raw[] = md.digest(); //step 4
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash; //step 6
    }
}
