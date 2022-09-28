package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BeanClass.Student;
import com.Exceptions.AdminException;
import com.Exceptions.StudentException;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.utility.DataBaseUtil;

public class StudentImplDAO implements StudentDAO{

	
	@Override
	public String registerStudent(Student student) {
		String message = "Not inserted please check and try again!!!";
		
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into student(username,password,name,address,mobile) values(?,?,?,?,?)");
			
			ps.setString(1, student.getUsername());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getMobile());
			
			int x = ps.executeUpdate();
			
			
			if (x > 0) {
				message = "Student Details Registered Successfully !";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public Student loginStudent(String username, String password) throws StudentException {
		
		Student student = null;
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareCall("select * from student where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int r = rs.getInt("roll");
				String u = rs.getString("username");
				String p = rs.getString("password");
				String n = rs.getString("name");
				String a = rs.getString("address");
				String m = rs.getString("mobile");
				
				student = new Student(r, u, p, n, a, m);
				
				
			}
			else {
				throw new StudentException("Invalid Username or Password!");
			}
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return student;
	}

	

}
