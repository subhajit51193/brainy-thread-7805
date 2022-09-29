package com.UseCases;

import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Course;
import com.Exceptions.CourseException;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class GetAllCoursesUseCase {

	public static void getAllCourses() {
		
		AdminDAO am = new AdminImplDAO();
		
		 try {
			List<Course> list = am.getAllCourseDetails();
			
			list.forEach(c->{
				
				System.out.println("Course ID :"+c.getCourseid());
				System.out.println("Course Name :"+c.getCoursename());
				System.out.println("Course Fees :"+c.getFees());
				System.out.println("Course Duration :"+c.getDuration());
				System.out.println("=====================================");
			});
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
