package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Student;
import com.Exceptions.StudentException;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class StudentLoginUseCase {
	
	public static boolean StudentLogin() {
		
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		StudentDAO st = new StudentImplDAO();
		try {
			Student student = st.loginStudent(username, password);
			
			System.out.println("Welcome Back "+student.getName());
			System.out.println("Username :"+student.getUsername());
			System.out.println("Roll :"+student.getRoll());
			System.out.println("Mobile :"+student.getMobile());
			System.out.println("Address :"+student.getAddress());
			
			
			result = true;
			
			return result;
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return result;
		}
	}

}
