package com.OperationsDAO;

import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Course;
import com.BeanClass.CourseDTO;
import com.Exceptions.AdminException;
import com.Exceptions.CourseException;

public interface AdminDAO {

	public Admin loginAdmin(String username,String password) throws AdminException;
	
	public String registerNewCourse(Course course);
	
	public String updateCourseFees(Course course);
	
	public String updateCourseDuration(Course course);
	
	public String deleteCourse(Course course);
	
	public List<Course> getAllCourseDetails() throws CourseException;
	
	public List<CourseDTO> getAllDetailsByCourseName(String coursename) throws CourseException;
}
