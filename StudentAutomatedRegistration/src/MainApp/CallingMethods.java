package MainApp;

import java.util.Scanner;

import com.UseCases.AdminLoginUseCase;

public class CallingMethods {

	public static void selectMethods() {
		
		try {
			
			while(true) {
				System.out.println("Please select an options to continue....");
				System.out.println("1. Admin Login");
				System.out.println("2. Student Login");
				System.out.println("3. Register New Student");
				System.out.println("4. Exit");
				
				Scanner sc = new Scanner(System.in);
				
				int choice = sc.nextInt();
				
				if (choice == 1) {
					AdminLoginUseCase am = new AdminLoginUseCase();
					boolean r = am.AdminLogin();
					if (r == false) {
						break;
					}
					else {
						while(true) {
							
						}
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
