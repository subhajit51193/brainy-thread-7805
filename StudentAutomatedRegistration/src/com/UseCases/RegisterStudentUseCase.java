package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Student;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class RegisterStudentUseCase {

	public static void studentRegistration() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter Address");
		String address = sc.next();
		
		System.out.println("Enter Mobile No.");
		String mobile = sc.next();
		
		StudentDAO st = new StudentImplDAO();
		
		Student  student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		student.setName(name);
		student.setAddress(address);
		student.setMobile(mobile);
		
		
		String result = st.registerStudent(student);
		
		System.out.println(result);
		
		
	}
}
