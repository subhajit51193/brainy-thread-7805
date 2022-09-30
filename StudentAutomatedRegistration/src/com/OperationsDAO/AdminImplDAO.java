package com.OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Batch;
import com.BeanClass.BatchDTO;
import com.BeanClass.Course;
import com.BeanClass.CourseDTO;
import com.BeanClass.Student;
import com.BeanClass.StudentDTO;
import com.Exceptions.AdminException;
import com.Exceptions.BatchException;
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

	@Override
	public String registerNewBatch(Batch batch) {
		String message = "Not inserted please check and try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into batch values(?,?)");
			
			ps.setInt(1, batch.getBatchno());
			ps.setInt(2, batch.getSeats());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Batch Details Registered Successfully!!!";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public String registerStudentInsideBatch(int roll, int batchno) throws StudentException, BatchException {
		
		String message = "Not registered";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from batch where batchno = ?");
				ps2.setInt(1, batchno);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if (rs2.next()) {
					PreparedStatement ps3= conn.prepareStatement("insert into student_batch values(?,?)");
					
					ps3.setInt(1, roll);
					ps3.setInt(2, batchno);
					int x = ps3.executeUpdate();
					
					if (x > 0) {
						message = "Student Registered Successfully inside the  Batch";
						PreparedStatement ps4= conn.prepareStatement("update batch set seats = seats - 1 where batchno = ?");
						ps4.setInt(1, batchno);
						
						int x1 = ps4.executeUpdate();
						if (x1 > 0) {
							System.out.println("Seats updated.....");
						}
						
					}else {
						throw new StudentException("Technical Error");
					}
				}
				else {
					throw new BatchException("Invalid Batch...");
				}
			}
			else {
				throw new StudentException("Invalid Student...");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new StudentException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String updateSeatsNumber(Batch batch) {
		String message = "Not updated Please try again!!!";
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update batch set seats = ? where batchno =?");
		
		
		ps.setInt(1, batch.getSeats());
		ps.setInt(2, batch.getBatchno());
		int x = ps.executeUpdate();
		
		if (x > 0) {
			message = "Seats updated Successfully ...";
		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public List<BatchDTO> viewStudentOfEveryBatch() throws StudentException {
		List<BatchDTO> list = new ArrayList<>();
		
		
		try (Connection conn = DataBaseUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select s.name,s.address,s.roll,s.mobile,b.batchno from student s,batch b,student_batch sb where s.roll = sb.roll AND b.batchno = sb.batchno;");
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String n = rs.getString("name");
				String add = rs.getString("address");
				int roll = rs.getInt("roll");
				String m = rs.getString("mobile");
				int b = rs.getInt("batchno");
				
				
				BatchDTO dto = new BatchDTO(n, add, roll, m, b);
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
//			// TODO: handle exception
////			throw new CourseException(e.getMessage());
			throw new StudentException(e.getMessage());
		}
		
		if (list.size() == 0) {
			throw new StudentException("No Student Found...");
		}
		return list;
	}

	

	
}
