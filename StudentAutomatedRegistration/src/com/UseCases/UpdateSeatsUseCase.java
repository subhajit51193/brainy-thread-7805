package com.UseCases;

import java.util.Scanner;

import com.BeanClass.Batch;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class UpdateSeatsUseCase {

	public static void updateSeats() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter total Seats");
		int seat = sc.nextInt();
		
		System.out.println("Enter Batch No.");
		int batch = sc.nextInt();
		
		AdminDAO am = new AdminImplDAO();
		
		Batch bat = new Batch();
		bat.setSeats(seat);
		bat.setBatchno(batch);
		
		String result = am.updateSeatsNumber(bat);
		System.out.println(result);
	}
}
