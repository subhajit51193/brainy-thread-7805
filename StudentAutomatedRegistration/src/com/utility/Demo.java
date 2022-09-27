package com.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		
//		test for connection establishment
		
		Connection conn = DataBaseUtil.provideConnection();
		
		System.out.println(conn);
	}
}
