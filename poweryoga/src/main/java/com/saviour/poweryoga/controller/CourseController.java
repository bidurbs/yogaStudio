package com.saviour.poweryoga.controller;

import com.saviour.poweryoga.model.Course;
import com.saviour.poweryoga.serviceI.ICourseService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Named("courseController")
@SessionScoped
public class CourseController implements Serializable {

    @Autowired
    private ICourseService CourseService;

    private Course course;
    private List<Course> listOfCourses;
    private int noOfCourses;
    private Long selectedPrerequisiteId;

    public int getNoOfCourses() {
        return noOfCourses;
    }

    public void setNoOfCourses(int noOfCourses) {
        this.noOfCourses = noOfCourses;
    }

    public CourseController() {
        //course = new Course();
    }

    /**
     * Save Course data
     *
     * @return
     */
    public String saveCourse() {
        try {
            if (selectedPrerequisiteId != null) {
                Course pre = CourseService.getCourseById(selectedPrerequisiteId);
                course.setPrerequisites(pre);
            }
            //set course status 
            course.setStatus(Course.statusType.ACTIVE);
            CourseService.saveCourse(course);
            return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
        } catch (Exception ex) {
            ex.printStackTrace();
            //errorMsg = "Course saving failed";
        }
        return null;
    }

    /**
     * Display update Course data page
     *
     * @return
     */
    public String updateCourse() {
        if (selectedPrerequisiteId !=null) {
            Course pre = CourseService.getCourseById(selectedPrerequisiteId);
            if (!pre.getId().equals(course.getId())) {
                course.setPrerequisites(pre);
            }
        } else {
            course.setPrerequisites(null);
        }
        CourseService.updateCourse(course);
        return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
    }

    /**
     * Validate if the selected prerequisite is the same as the course or not.
     *
     * @param fc
     * @param c
     * @param value
     */
    public void validatePrerequisite(FacesContext fc, UIComponent c, Object value) {
        Course pre = CourseService.getCourseById(selectedPrerequisiteId);
        if (pre.getId().equals(course.getId())) {
            throw new ValidatorException(
                    new FacesMessage("The same course can't be a prerequsite."));
        }
    }

    /**
     * Update Course data
     *
     * @return
     */
    public String addCourse() {
        course = new Course();
        return ("/views/admin/addCourse.xhtml?faces-redirect=true");
    }
    
    /**
     * Update Course data
     *
     * @param Id
     * @return
     */
    public String editCourse(long Id) {
        course = CourseService.getCourseById(Id);
        return "editCourse";
    }

    /**
     * Delete Course entry( set its status INACTIVE).
     *
     * @param Id
     * @return
     */
    public String deleteCourse(Long Id) {
        course = CourseService.getCourseById(Id);

        //Set its status inactive
        course.setStatus(Course.statusType.INACTIVE);
        CourseService.updateCourse(course);
        return ("/views/admin/manageCourse.xhtml?faces-redirect=true");
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getListOfCourses() {
        listOfCourses = CourseService.getActiveCourses();
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    /**
     * Display list of Courses for customer
     *
     * @return
     */
    public String displayCourses() {
        noOfCourses = getListOfCourses().size();
        return ("/views/customer/course.xhtml?faces-redirect=true");
    }

    public Long getSelectedPrerequisiteId() {
        return selectedPrerequisiteId;
    }

    public void setSelectedPrerequisiteId(Long selectedPrerequisiteId) {
        this.selectedPrerequisiteId = selectedPrerequisiteId;
    }

}
