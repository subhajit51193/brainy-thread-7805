package com.BeanClass;

public class Batch {

	private int batchno;
	private int seats;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchno, int seats) {
		super();
		this.batchno = batchno;
		this.seats = seats;
	}

	public int getBatchno() {
		return batchno;
	}

	public void setBatchno(int batchno) {
		this.batchno = batchno;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Batch [batchno=" + batchno + ", seats=" + seats + "]";
	}
	
	
}
