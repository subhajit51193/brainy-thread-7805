package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Course;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class UpdateFeesUseCase {

	public static void updateFees() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new Fees");
		int fee = sc.nextInt();
		
		System.out.println("Enter the Course Name");
		String cname = sc.next();
		
		AdminDAO am = new AdminImplDAO();
		
		Course course = new Course();
		
		course.setFees(fee);
		course.setCoursename(cname);
		
		String result = am.updateCourseFees(course);
		System.out.println(result);
	}
}
