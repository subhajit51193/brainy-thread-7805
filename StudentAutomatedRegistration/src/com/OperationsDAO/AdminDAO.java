package com.OperationsDAO;

import com.BeanClass.Admin;
import com.BeanClass.Course;
import com.Exceptions.AdminException;

public interface AdminDAO {

	public Admin loginAdmin(String username,String password) throws AdminException;
	
	public String registerNewCourse(Course course);
	
	public String updateCourseFees(Course course);
	
	public String updateCourseDuration(Course course);
}
