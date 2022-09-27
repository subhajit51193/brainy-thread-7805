package com.BeanClass;

public class Course {

	private int courseid;
	private String coursename;
	private int fees;
	private String duration;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int courseid, String coursename, int fees, String duration) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fees = fees;
		this.duration = duration;
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

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", fees=" + fees + ", duration="
				+ duration + "]";
	}
	
	
	
}
