package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestConn1 {
	public static void main(String[] args) throws Exception {
//jdbc properties-MYSQL DB
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";
		String sql = "update student set sname=?,sfee=? where sid=?";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
//create pstmt
		PreparedStatement pstmt = con.prepareStatement(sql);
//use scanner to read data from console
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID:");
		int stdId = sc.nextInt();
		System.out.println("Enter New Name:");
		String stdName = sc.next();
		System.out.println("Enter New Fee");
		double stdFee = sc.nextDouble();
//setData
		pstmt.setString(1, stdName);
		pstmt.setDouble(2, stdFee);
		pstmt.setInt(3, stdId);
//execute
		int count = pstmt.executeUpdate();
		if (count == 0)
			System.out.println("No rows updated");
		else
			System.out.println("rows updated");
		System.out.println("Inserted:" + count);
		con.close();
	}
}