package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Admin;
import com.Exceptions.AdminException;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;
import com.OperationsDAO.StudentDAO;
import com.OperationsDAO.StudentImplDAO;

public class AdminLoginUseCase {

	public static boolean AdminLogin() {
		
		Scanner sc = new Scanner(System.in);
		boolean result = false;;
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		AdminDAO ad = new AdminImplDAO();
		try {
			Admin admin = ad.loginAdmin(username, password);
			
			result = true;
			
			return result;
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return result;
		}
		
	}
}
