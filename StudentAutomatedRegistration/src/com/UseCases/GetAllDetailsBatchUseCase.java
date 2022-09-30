package com.UseCases;

import java.util.List;

import com.BeanClass.Batch;
import com.Exceptions.BatchException;
import com.OperationsDAO.BatchDAO;
import com.OperationsDAO.BatchDAOImpl;

public class GetAllDetailsBatchUseCase {

	public static void getAllDetailsBatch() {
		
		BatchDAO dao = new BatchDAOImpl();
		
		try {
			List<Batch> list = dao.getAllBatchDetaisl();
			
			list.forEach(b ->{
				System.out.println("Batch No :"+b.getBatchno());
				System.out.println("Available Seats :"+b.getSeats());
				System.out.println("====================================");
			});
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
