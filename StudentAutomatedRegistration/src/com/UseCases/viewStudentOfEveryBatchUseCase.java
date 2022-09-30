package com.UseCases;

import java.util.List;

import com.BeanClass.BatchDTO;
import com.Exceptions.StudentException;
import com.OperationsDAO.AdminDAO;
import com.OperationsDAO.AdminImplDAO;

public class viewStudentOfEveryBatchUseCase {

	public static void viewStudentOfEveryBatch() {
		
		AdminDAO am = new AdminImplDAO();
		
		try {
			List<BatchDTO> list = 	am.viewStudentOfEveryBatch();
			
			list.forEach(b ->{
				System.out.println("Student Name :"+b.getName());
				System.out.println("Student Address :"+b.getAddress());
				System.out.println("Student Roll No :"+b.getRoll());
				System.out.println("Student Mobile :"+b.getMobile());
				System.out.println("Batch No Allocated :"+b.getBatchno());
				System.out.println("===========================================");
			});
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
