package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BeanClass.Admin;
import com.BeanClass.Course;
import com.Exceptions.AdminException;
import com.utility.DataBaseUtil;

public class AdminImplDAO implements AdminDAO{

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException{
		
		Admin admin = null;
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareCall("select * from admin where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String usname = rs.getString("username");
				String pass = rs.getString("password");
				
				admin = new Admin(usname,pass);
			}
			else {
				throw new AdminException("Invalid USername or Password!!!");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		
		return admin;
	}

	@Override
	public String registerNewCourse(Course course) {
		
		String message = "Not inserted please check and try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into course(coursename,fees,duration) values(?,?,?)");
			
			ps.setString(1, course.getCoursename());
			ps.setInt(2, course.getFees());
			ps.setString(3, course.getDuration());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Course Details Registered Successfully!!!";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public String updateCourseFees(Course course) {
		
		String message = "Not updated Please try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update course set fees = ? where coursename = ?");
		
		ps.setInt(1, course.getFees());
		ps.setString(2, course.getCoursename());
		
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Fees structure updated Successfully ...";
		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public String updateCourseDuration(Course course) {
		String message = "Not updated Please try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update course set duration = ? where coursename = ?");
		
		ps.setString(1, course.getDuration());
		ps.setString(2, course.getCoursename());
		
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Course Duration updated Successfully ...";
		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	
}
