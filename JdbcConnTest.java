package com.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnTest {
	public static void main(String[] args) throws Exception {
		
		 //1.jdbc properties-mysql DB
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";
		
		//2.jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println(con);
	}
}
