package MainApp;

import java.util.Scanner;

import com.BeanClass.Student;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;
import com.UseCases.AdminLoginUseCase;
import com.UseCases.RegisterCourseUseCase;
import com.UseCases.RegisterStudentUseCase;
import com.UseCases.StudentLoginUseCase;
import com.UseCases.UpdateDurationUseCase;
import com.UseCases.UpdateFeesUseCase;

public class CallingClass {
	
	public static StudentDAO st = new StudentImplDAO();

	public static void selectOption() {
		try {
			
			System.out.println("Please select an option to continue..");
			System.out.println("\n1. Admin Login\n2. Student Login\n3. Register New Student");
			
			
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
					System.out.println("Welcome to Admin Panel");
					System.out.println("Please select an option to continue");
					System.out.println("\n1. Add new Course\n2. Update Existing Course Fees\n3. Update Existing Course Duration\n4. Delete a Course\n5. Get info about a course\n6. Create a batch under a course\n7. Allocate students under a batch in a course\n8. Update total seats of batch\n9. View students of every batch");
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
					}
				}
				break;
			case 2:
				
				StudentLoginUseCase st = new StudentLoginUseCase();
				boolean sr = st.StudentLogin();
				if (sr == false) {
					break;
				}
				else {
					System.out.println("Please select an option to continue");
					System.out.println("\n1. Register in a new course\n2. Update existing details\n3. See all the available course list with seat availability");
					
				}
				
			case 3:
				
				RegisterStudentUseCase rs = new RegisterStudentUseCase();
				rs.studentRegistration();
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
