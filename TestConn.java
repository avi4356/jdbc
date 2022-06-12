package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestConn {
	public static void main(String[] args) throws Exception {
//jdbc properties-MYSQL DB
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";
		String sql = "insert into student values(?,?,?)";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, "avinash singh");
		pstmt.setInt(3, 3);
//execute
		int count = pstmt.executeUpdate();
		System.out.println("Inserted:" + count);
		con.close();
	}
}
