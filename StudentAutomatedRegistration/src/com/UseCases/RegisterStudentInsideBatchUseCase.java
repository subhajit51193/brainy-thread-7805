package com.UseCases;

import java.util.Scanner;

import com.Exceptions.BatchException;
import com.Exceptions.StudentException;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class RegisterStudentInsideBatchUseCase {

	public static void registerStudentInsideBatch() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Roll No.");
		int roll = sc.nextInt();
		
		System.out.println("Enter the Batch No.");
		int batch = sc.nextInt();
		
		AdminDAO am = new AdminImplDAO();
		
		try {
			String result = am.registerStudentInsideBatch(roll, batch);
			System.out.println(result);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
