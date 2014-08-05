/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.junit;

import com.saviour.poweryoga.controller.CustomerController;
import com.saviour.poweryoga.model.Customer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bidur
 */
public class CustomerControllerTest {
    
    public CustomerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class CustomerController.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        CustomerController instance = new CustomerController();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCustomer method, of class CustomerController.
     */
    @Test
    public void testSaveCustomer() {
        System.out.println("saveCustomer");
        CustomerController instance = new CustomerController();
        instance.saveCustomer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCustomerByEmail method, of class CustomerController.
     */
    @Test
    public void testFindCustomerByEmail() {
        System.out.println("findCustomerByEmail");
        String email = "";
        CustomerController instance = new CustomerController();
        boolean expResult = false;
        boolean result = instance.findCustomerByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class CustomerController.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        String rePassword = "";
        CustomerController instance = new CustomerController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, rePassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerController.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        CustomerController instance = new CustomerController();
        instance.updateCustomer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCustomerById method, of class CustomerController.
     */
    @Test
    public void testFindCustomerById() {
        System.out.println("findCustomerById");
        CustomerController instance = new CustomerController();
        String expResult = "";
        String result = instance.findCustomerById();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class CustomerController.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        CustomerController instance = new CustomerController();
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class CustomerController.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        Customer customer = null;
        CustomerController instance = new CustomerController();
        instance.setCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomers method, of class CustomerController.
     */
    @Test
    public void testGetCustomers() {
        System.out.println("getCustomers");
        CustomerController instance = new CustomerController();
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomers method, of class CustomerController.
     */
    @Test
    public void testSetCustomers() {
        System.out.println("setCustomers");
        List<Customer> customers = null;
        CustomerController instance = new CustomerController();
        instance.setCustomers(customers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getErrorMsg method, of class CustomerController.
     */
    @Test
    public void testGetErrorMsg() {
        System.out.println("getErrorMsg");
        CustomerController instance = new CustomerController();
        String expResult = "";
        String result = instance.getErrorMsg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setErrorMsg method, of class CustomerController.
     */
    @Test
    public void testSetErrorMsg() {
        System.out.println("setErrorMsg");
        String errorMsg = "";
        CustomerController instance = new CustomerController();
        instance.setErrorMsg(errorMsg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuccessMsg method, of class CustomerController.
     */
    @Test
    public void testGetSuccessMsg() {
        System.out.println("getSuccessMsg");
        CustomerController instance = new CustomerController();
        String expResult = "";
        String result = instance.getSuccessMsg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSuccessMsg method, of class CustomerController.
     */
    @Test
    public void testSetSuccessMsg() {
        System.out.println("setSuccessMsg");
        String successMsg = "";
        CustomerController instance = new CustomerController();
        instance.setSuccessMsg(successMsg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRePassword method, of class CustomerController.
     */
    @Test
    public void testGetRePassword() {
        System.out.println("getRePassword");
        CustomerController instance = new CustomerController();
        String expResult = "";
        String result = instance.getRePassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRePassword method, of class CustomerController.
     */
    @Test
    public void testSetRePassword() {
        System.out.println("setRePassword");
        String rePassword = "";
        CustomerController instance = new CustomerController();
        instance.setRePassword(rePassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
