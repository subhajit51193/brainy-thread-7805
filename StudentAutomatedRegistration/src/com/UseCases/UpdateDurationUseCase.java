package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Course;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class UpdateDurationUseCase {

	public static void updateDuration() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name");
		String cname = sc.next();
		
		System.out.println("Enter new Course Duration");
		String dur = sc.next();
		
		AdminDAO am = new AdminImplDAO();
		
		Course course = new Course();
		course.setDuration(dur);
		course.setCoursename(cname);
		
		String result = am.updateCourseDuration(course);
		System.out.println(result);
	}
}
