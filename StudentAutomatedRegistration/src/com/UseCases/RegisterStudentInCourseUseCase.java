package com.UseCases;

import java.util.Scanner;

import com.Exceptions.CourseException;
import com.Exceptions.StudentException;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class RegisterStudentInCourseUseCase {

	public static void registerStudentinCourse() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Roll Number");
		int roll = sc.nextInt();
		
		System.out.println("Enter the course ID");
		int id = sc.nextInt();
		
		StudentDAO st = new StudentImplDAO();
		
		try {
			String result = st.registerStudentInsideCourse(id, roll);
			
			System.out.println(result);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
