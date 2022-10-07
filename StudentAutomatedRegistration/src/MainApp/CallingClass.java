package MainApp;

import java.util.Scanner;

import com.BeanClass.Student;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;
import com.UseCases.AdminLoginUseCase;
import com.UseCases.DeleteCourseUseCase;
import com.UseCases.GetAllCoursesUseCase;
import com.UseCases.GetAllDetailsBatchUseCase;
import com.UseCases.GetAllDetailsByStudentNameUseCase;
import com.UseCases.RegisterBatchUseCase;
import com.UseCases.RegisterCourseUseCase;
import com.UseCases.RegisterStudentInCourseUseCase;
import com.UseCases.RegisterStudentInCourseUseCase2;
import com.UseCases.RegisterStudentInsideBatchUseCase;
import com.UseCases.RegisterStudentUseCase;
import com.UseCases.StudentLoginUseCase;
import com.UseCases.UpdateDurationUseCase;
import com.UseCases.UpdateFeesUseCase;
import com.UseCases.UpdateSeatsUseCase;
import com.UseCases.UpdateStudentMobileUseCase;
import com.UseCases.UpdateStudentNameUseCase;
import com.UseCases.getAllDetailsByCourseNameUseCase;
import com.UseCases.viewStudentOfEveryBatchUseCase;

public class CallingClass {
	
	public static StudentDAO st = new StudentImplDAO();

	public static void selectOption() {
		try {
			
			System.out.println("Please select an option to continue..");
			System.out.println("\n1. Admin Login\n2. Student Login\n3. Register New Student\n4. Exit");
			
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			
			case 1:
				AdminLoginUseCase am = new AdminLoginUseCase();
				boolean r = am.AdminLogin();
				if (r == false) {
					break;
				}
				else {
					while(true) {
						System.out.println("Welcome to Admin Panel");
						System.out.println("Please select an option to continue");
						System.out.println("\n1. Add new Course\n2. Update Existing Course Fees\n3. Update Existing Course Duration\n4. Delete a Course\n5. Get all course details\n6. Get all information according to Course Name\n7. Create a new  Batch\n8. Allocate students in a batch\n9. Update total Seats in a batch\n10. View students of every batch\n11. Logout");
						int c1 = sc.nextInt();
						
						switch (c1) {
						
						case 1:
							RegisterCourseUseCase rc = new RegisterCourseUseCase();
							rc.courseRegistration();
							break;
						case 2:
							UpdateFeesUseCase uf = new UpdateFeesUseCase();
							uf.updateFees();
							break;
						case 3:
							UpdateDurationUseCase ud = new UpdateDurationUseCase();
							ud.updateDuration();
							break;
						case 4:
							DeleteCourseUseCase dc = new DeleteCourseUseCase();
							dc.deleteCourse();
							break;
						case 5:
							GetAllCoursesUseCase gc = new GetAllCoursesUseCase();
							gc.getAllCourses();
							break;
						case 6:
							getAllDetailsByCourseNameUseCase g = new getAllDetailsByCourseNameUseCase();
							g.getAllDetailsByCourseName();
							break;
						case 7:
							RegisterBatchUseCase rb = new RegisterBatchUseCase();
							rb.registerNewBatch();
							break;
						case 8:
							RegisterStudentInsideBatchUseCase rsb = new RegisterStudentInsideBatchUseCase();
							rsb.registerStudentInsideBatch();
							break;
						case 9:
							UpdateSeatsUseCase us = new UpdateSeatsUseCase();
							us.updateSeats();
							break;
						case 10:
							viewStudentOfEveryBatchUseCase vs = new viewStudentOfEveryBatchUseCase();
							vs.viewStudentOfEveryBatch();
							break;
						case 11:
							System.out.println("Returning to Main Menu...");
							CallingClass.selectOption();
							break;
						}
					}
					
				}
//				break;
			case 2:
				while(true) {
				
					StudentLoginUseCase st = new StudentLoginUseCase();
					boolean sr = st.StudentLogin();
					if (sr == false) {
						break;
					}
					else {
						while(true) {
							System.out.println("Please select an option to continue");
							System.out.println("\n1. Register in a new course\n2. See all information\n3. Update Student Name\n4. Update Mobile Number\n5. See all the Course Lists\n6. Check Seat Avaialibility of current ongoing batches\n7. Logout");
							int c2 = sc.nextInt();
							
							switch(c2) {
							
							case 1:
	//							RegisterStudentInCourseUseCase rsc = new RegisterStudentInCourseUseCase();
	//							rsc.registerStudentinCourse();
								//register student in a new course by authenticating ...
								RegisterStudentInCourseUseCase2 rsc = new RegisterStudentInCourseUseCase2();
								rsc.registerStudentInCourse2();
								break;
							case 2:
								GetAllDetailsByStudentNameUseCase gt = new GetAllDetailsByStudentNameUseCase();
								gt.getAllDetailsByStudentName();
								break;
							case 3:
								UpdateStudentNameUseCase us = new UpdateStudentNameUseCase();
								us.updateStuentName();
								break;
							case 4:
								UpdateStudentMobileUseCase um = new UpdateStudentMobileUseCase();
								um.updateStudentMobile();
								break;
							case 5:
								GetAllCoursesUseCase gc = new GetAllCoursesUseCase();
								gc.getAllCourses();
								break;
							case 6:
								GetAllDetailsBatchUseCase gb = new GetAllDetailsBatchUseCase();
								gb.getAllDetailsBatch();
								break;
							case 7:
								System.out.println("Returning to Main Menu...");
								CallingClass.selectOption();
								break;
							}
						}
					}
					
					
				}
//				break;
				
			case 3:
				
				RegisterStudentUseCase rs = new RegisterStudentUseCase();
				rs.studentRegistration();
				break;
			case 4:
				System.out.println("Returning to Home Screen......");
				Application.main(null);
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
