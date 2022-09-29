package MainApp;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Welcome to Automated Student Registration System...");
			System.out.println("This is Automated Student Registration System created by Me-");
			System.out.println("Features:");
			System.out.println("*. Admin Login");
			System.out.println("*. New Students Registration");
			System.out.println("*. Student Login");
			System.out.println("*. Add new Courses");
			System.out.println("*. Update courses");
			System.out.println("Select below options to continue to main menu");
			System.out.println("1. Continue to main menu..");
			System.out.println("2. I will check later... Exit for now");
			
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			if (choice == 1) {
				CallingClass.selectOption();
//				CallingMethods.selectMethods();
			}
			else {
				System.out.println("Thank you ");
				break;
			}
				
			
		}
		
		
	}
}
