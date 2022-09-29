package com.UseCases;

import java.util.List;
import java.util.Scanner;

import com.BeanClass.Student;
import com.BeanClass.StudentDTO;
import com.Exceptions.StudentException;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class GetAllDetailsByStudentNameUseCase {

	
	public static void getAllDetailsByStudentName() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Authentication Required!!!");
		
		System.out.println("Enter Username");
		String name = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		StudentDAO st = new StudentImplDAO();
		
		try {
			Student student = st.loginStudent(name, pass);
			
			String username = student.getUsername();
			
			List<StudentDTO> list1 = st.getAllDetailsByStudentName(username);
			
			for (StudentDTO s : list1) {
				System.out.println("Roll :"+s.getRoll());
				System.out.println("Username :"+s.getUsername());
				System.out.println("Name :"+s.getName());
				System.out.println("Address :"+s.getAddress());
				System.out.println("Mobile :"+s.getMobile());
				System.out.println("Course ID :"+s.getCourseid());
				System.out.println("Course Name :"+s.getCoursename());
				System.out.println("Course Fees :"+s.getFees());
				System.out.println("Course Duration :"+s.getDuration());
				System.out.println("==========================================");
				
			}
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	
}
