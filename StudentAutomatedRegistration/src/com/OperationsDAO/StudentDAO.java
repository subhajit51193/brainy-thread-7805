package com.OperationsDAO;

import com.BeanClass.Student;
import com.Exceptions.AdminException;
import com.Exceptions.StudentException;

public interface StudentDAO {

	
	public String registerStudent(Student student);
	
	public Student loginStudent(String username, String password) throws StudentException;
}
