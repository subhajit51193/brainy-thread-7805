package com.OperationsDAO;

import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Batch;
import com.BeanClass.BatchDTO;
import com.BeanClass.Course;
import com.BeanClass.CourseDTO;
import com.Exceptions.AdminException;
import com.Exceptions.BatchException;
import com.Exceptions.CourseException;
import com.Exceptions.StudentException;

public interface AdminDAO {

	public Admin loginAdmin(String username,String password) throws AdminException;
	
	public String registerNewCourse(Course course);
	
	public String updateCourseFees(Course course);
	
	public String updateCourseDuration(Course course);
	
	public String deleteCourse(Course course);
	
	public List<Course> getAllCourseDetails() throws CourseException;
	
	public List<CourseDTO> getAllDetailsByCourseName(String coursename) throws CourseException;
	
	public String registerNewBatch(Batch batch);
	
	public String registerStudentInsideBatch(int roll, int batchno) throws StudentException,BatchException;
	
	public String updateSeatsNumber(Batch batch);
	
	public List<BatchDTO> viewStudentOfEveryBatch() throws StudentException;
}
