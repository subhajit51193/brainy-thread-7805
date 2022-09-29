package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Student;
import com.Exceptions.CourseException;
import com.Exceptions.StudentException;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class RegisterStudentInCourseUseCase2 {

	public static void registerStudentInCourse2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Authentication Required!!!");
		
		System.out.println("Enter Username");
		String name = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		StudentDAO st = new StudentImplDAO();
		
		
		try {
			Student student = st.loginStudent(name, pass);
			
			int roll = student.getRoll();
			
			System.out.println("Enter CouseID");
			
			int id = sc.nextInt();
			
			try {
				String result = st.registerStudentInsideCourse2(id, roll);
				System.out.println(result);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
