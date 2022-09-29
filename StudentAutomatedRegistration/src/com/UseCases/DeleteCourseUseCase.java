package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Course;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class DeleteCourseUseCase {

	
	public static void deleteCourse() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name which you want to Delete");
		String cname = sc.next();
		
		AdminDAO am = new AdminImplDAO();
		
		Course course = new Course();
		
		course.setCoursename(cname);
		
		String result = am.deleteCourse(course);
		System.out.println(result);
	}
}
