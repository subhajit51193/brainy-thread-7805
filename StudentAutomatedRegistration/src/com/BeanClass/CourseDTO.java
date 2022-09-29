package com.BeanClass;

public class CourseDTO {

	private int courseid;
	private String coursename;
	private int fees;
	private String duration;
	
	private int roll;
	private String username;
	private String name;
	private String address;
	private String mobile;
	
	public CourseDTO() {
		// TODO Auto-generated constructor stub
	}

	public CourseDTO(int courseid, String coursename, int fees, String duration, int roll, String username, String name,
			String address, String mobile) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fees = fees;
		this.duration = duration;
		this.roll = roll;
		this.username = username;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "CourseDTO [courseid=" + courseid + ", coursename=" + coursename + ", fees=" + fees + ", duration="
				+ duration + ", roll=" + roll + ", username=" + username + ", name=" + name + ", address=" + address
				+ ", mobile=" + mobile + "]";
	}
	
	
}
