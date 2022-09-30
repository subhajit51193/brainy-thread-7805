package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Batch;
import com.BeanClass.Course;
import com.Exceptions.BatchException;
import com.Exceptions.CourseException;
import com.utility.DataBaseUtil;

public class BatchDAOImpl implements BatchDAO{

	@Override
	public List<Batch> getAllBatchDetaisl() throws BatchException {
		List<Batch> list = new ArrayList<>();
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from batch");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				int no = rs.getInt("batchno");
				int seats = rs.getInt("seats");
				
				Batch batch = new Batch(no, seats);
				
				list.add(batch);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new BatchException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new BatchException("No details Found");
		}
		
		return list;
	}

	
}
