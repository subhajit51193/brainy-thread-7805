package com.BeanClass;

public class Student {

	private int roll;
	private String username;
	private String password;
	private String name;
	private String address;
	private String mobile;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String username, String password, String name, String address, String mobile) {
		super();
		this.roll = roll;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Student [roll=" + roll + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}
	
	
}
