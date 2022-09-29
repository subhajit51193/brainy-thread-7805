package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Student;
import com.Exceptions.StudentException;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class UpdateStudentNameUseCase {

	public static void updateStuentName() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Authentication Required!!");
		
		System.out.println("Enter Username");
		String name = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		StudentDAO st = new StudentImplDAO();
		
		try {
			Student student = st.loginStudent(name, pass);
			
			String username = student.getUsername();
			
			System.out.println("Enter New Name");
			
			String updated = sc.next();
			
			Student student1 = new Student();
			
			student1.setUsername(username);
			student1.setName(updated);
			
			String result = st.updateStudentName(student1);
			System.out.println(result);
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
