package com.BeanClass;

public class BatchDTO {

	private String name;
	private String address;
	private int roll;
	private String mobile;
	
	private int batchno;
	
	public BatchDTO() {
		// TODO Auto-generated constructor stub
	}

	public BatchDTO(String name, String address, int roll, String mobile, int batchno) {
		super();
		this.name = name;
		this.address = address;
		this.roll = roll;
		this.mobile = mobile;
		this.batchno = batchno;
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

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getBatchno() {
		return batchno;
	}

	public void setBatchno(int batchno) {
		this.batchno = batchno;
	}

	@Override
	public String toString() {
		return "BatchDTO [name=" + name + ", address=" + address + ", roll=" + roll + ", mobile=" + mobile
				+ ", batchno=" + batchno + "]";
	}
	
	
}
