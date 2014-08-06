/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saviour.poweryoga.junit;

import com.saviour.poweryoga.controller.CourseController;
import com.saviour.poweryoga.model.Course;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author bidur
 */
public class CourseControllerTest {
    
    public CourseControllerTest() {
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
     * Test of getNoOfCourses method, of class CourseController.
     */
    @org.junit.Test
    public void testGetNoOfCourses() {
        System.out.println("getNoOfCourses");
        CourseController instance = new CourseController();
        int expResult = 0;
        int result = instance.getNoOfCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoOfCourses method, of class CourseController.
     */
    @org.junit.Test
    public void testSetNoOfCourses() {
        System.out.println("setNoOfCourses");
        int noOfCourses = 0;
        CourseController instance = new CourseController();
        instance.setNoOfCourses(noOfCourses);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testSaveCourse() {
        System.out.println("saveCourse");
        CourseController instance = new CourseController();
        String expResult = "";
        String result = instance.saveCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testUpdateCourse() {
        System.out.println("updateCourse");
        CourseController instance = new CourseController();
        String expResult = "";
        String result = instance.updateCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testEditCourse() {
        System.out.println("editCourse");
        int Id = 0;
        CourseController instance = new CourseController();
        String expResult = "";
        String result = instance.editCourse(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testDeleteCourse() {
        System.out.println("deleteCourse");
        int Id = 0;
        CourseController instance = new CourseController();
        String expResult = "";
        String result = instance.deleteCourse(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testGetCourse() {
        System.out.println("getCourse");
        CourseController instance = new CourseController();
        Course expResult = null;
        Course result = instance.getCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourse method, of class CourseController.
     */
    @org.junit.Test
    public void testSetCourse() {
        System.out.println("setCourse");
        Course course = null;
        CourseController instance = new CourseController();
        instance.setCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfCourses method, of class CourseController.
     */
    @org.junit.Test
    public void testGetListOfCourses() {
        System.out.println("getListOfCourses");
        CourseController instance = new CourseController();
        List<Course> expResult = null;
        List<Course> result = instance.getListOfCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListOfCourses method, of class CourseController.
     */
    @org.junit.Test
    public void testSetListOfCourses() {
        System.out.println("setListOfCourses");
        List<Course> listOfCourses = null;
        CourseController instance = new CourseController();
        instance.setListOfCourses(listOfCourses);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayCourses method, of class CourseController.
     */
    @org.junit.Test
    public void testDisplayCourses() {
        System.out.println("displayCourses");
        CourseController instance = new CourseController();
        String expResult = "";
        String result = instance.displayCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
