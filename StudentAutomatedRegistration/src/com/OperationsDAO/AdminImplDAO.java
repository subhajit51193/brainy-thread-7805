package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Course;
import com.BeanClass.CourseDTO;
import com.BeanClass.Student;
import com.BeanClass.StudentDTO;
import com.Exceptions.AdminException;
import com.Exceptions.CourseException;
import com.Exceptions.StudentException;
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

	@Override
	public String deleteCourse(Course course) {
		
		String message = "Not Deleted Please try again";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("delete from course where coursename = ?");
		
		ps.setString(1, course.getCoursename());
		
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Course Deleted Successfully";
		}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public List<Course> getAllCourseDetails() throws CourseException {
		
		List<Course> list = new ArrayList<>();
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from course");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt("courseid");
				String cname = rs.getString("coursename");
				int fee = rs.getInt("fees");
				String dur = rs.getString("duration");
				
				Course course = new Course(cid, cname, fee, dur);
				
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new CourseException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new CourseException("No details Found");
		}
		
		return list;
	}

	@Override
	public List<CourseDTO> getAllDetailsByCourseName(String coursename) throws CourseException {
		List<CourseDTO> list = new ArrayList<>();
		
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select c.courseid,c.coursename,c.fees,c.duration,s.roll,s.username,s.name,s.address,s.mobile from course c,student s,student_course sc where c.courseid = sc.courseid AND s.roll = sc.roll AND coursename = ?");
			
			ps.setString(1, coursename);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("courseid");
				String cn = rs.getString("coursename");
				int f = rs.getInt("fees");
				String dur = rs.getString("duration");
				int r = rs.getInt("roll");
				String un = rs.getString("username");
				String n = rs.getString("name");
				String add = rs.getString("address");
				String mob = rs.getString("mobile");
				
				CourseDTO dto = new CourseDTO(cid, cn, f, dur, r, un, n, add, mob);
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new CourseException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new CourseException("No course found...");
		}
		return list;
	}

	
}
