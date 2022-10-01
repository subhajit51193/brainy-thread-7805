package com.OperationsDAO;

import java.util.List;

import com.BeanClass.Student;
import com.BeanClass.StudentDTO;
import com.BeanClass.StudentDTOO;
import com.Exceptions.AdminException;
import com.Exceptions.CourseException;
import com.Exceptions.StudentException;

public interface StudentDAO {

	
	public String registerStudent(Student student);
	
	public Student loginStudent(String username, String password) throws StudentException;
	
	public String registerStudentInsideCourse(int courseid, int roll) throws StudentException,CourseException;
	
	public String registerStudentInsideCourse2(int courseid,int roll) throws StudentException,CourseException;
	
	public List<Student> getAllStudentDetails() throws StudentException;
	
	public List<StudentDTOO> getAllDetailsByStudentName(String username) throws StudentException;
	
	public String updateStudentName(Student student);
	
	public String updateStudentMobile(Student student);
}
