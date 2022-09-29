package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Student;
import com.BeanClass.StudentDTO;
import com.Exceptions.AdminException;
import com.Exceptions.CourseException;
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

	@Override
	public String registerStudentInsideCourse(int courseid, int roll) throws StudentException, CourseException {
		
		String message = "Not Registered . Please check and try again";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps  = conn.prepareStatement("select * from student where roll = ?");
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
			PreparedStatement ps2 = conn.prepareStatement("select * from course where courseid = ?");
			ps2.setInt(1, courseid);
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				
				PreparedStatement ps3 = conn.prepareStatement("insert into student_course values(?,?)");
				ps3.setInt(1, roll);
				ps3.setInt(2, courseid);
				
				int x = ps3.executeUpdate();
				
				if (x > 0) {
					message = "Registered Successfully ...";
				}
				else {
					throw new StudentException("Sorry Technical Error Occured!!! please try again after some time...");
				}
				
			}
			else {
				throw new CourseException("Invalid Course Name...");
			}
			
			}
			else {
				throw new StudentException("Invalid Student roll number... ");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new StudentException(e.getMessage());
		}
		
		return message;
		
		
	}

	@Override
	public String registerStudentInsideCourse2(int courseid, int roll) throws StudentException, CourseException {
		
		String message = "Not Registered . Please check and try again";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps2 = conn.prepareStatement("select * from course where courseid = ?");
			ps2.setInt(1, courseid);
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				PreparedStatement ps3 = conn.prepareStatement("insert into student_course values(?,?)");
				ps3.setInt(1, roll);
				ps3.setInt(2, courseid);
				
				int x = ps3.executeUpdate();
				
				if (x > 0) {
					message = "Registered Successfully ...";
				}
				else {
					throw new StudentException("Sorry Technical Error Occured!!! please try again after some time...");
				}
			}
			else {
				throw new CourseException("Invalid Course Name...");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new StudentException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> list = new ArrayList<>();
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from student");
			 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("roll");
				String un = rs.getString("username");
				String p = rs.getString("password");
				String n = rs.getString("name");
				String a = rs.getString("address");
				String m = rs.getString("mobile");
				
				Student student = new Student(r, m, p, n, a, m);
				
				list.add(student);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new StudentException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new StudentException("No details found...");
		}
		
		return list;
	}

	@Override
	public List<StudentDTO> getAllDetailsByStudentName(String username) throws StudentException {
		
		List<StudentDTO> list = new ArrayList<>();
		
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select s.roll,s.username,s.name,s.address,s.mobile,c.courseid,c.coursename,c.fees,c.duration from student s,course c,student_course sc where s.roll = sc.roll AND c.courseid = sc.courseid AND username = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("roll");
				String un = rs.getString("username");
				String n = rs.getString("name");
				String add = rs.getString("address");
				String mob = rs.getString("mobile");
				int cid = rs.getInt("courseid");
				String cn = rs.getString("coursename");
				int f = rs.getInt("fees");
				String dur = rs.getString("duration");
				
				StudentDTO dto = new StudentDTO(r, un, n, add, mob, cid, cn, f, dur);
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new StudentException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new StudentException("No student found...");
		}
		return list;
	}

	@Override
	public String updateStudentName(Student student) {
		
		String message = "Not updated Please try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update student set name = ? where username = ?");
		
		
		ps.setString(1, student.getName());
		ps.setString(2, student.getUsername());
		
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Name updated Successfully ...";
		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public String updateStudentMobile(Student student) {
		String message = "Not updated Please try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update student set mobile = ? where username = ?");
		
		
		ps.setString(1, student.getMobile());
		ps.setString(2, student.getUsername());
		
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Number updated Successfully ...";
		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	

}
