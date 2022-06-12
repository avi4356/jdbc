package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestConn2 {
	public static void main(String[] args) throws Exception {
//jdbc properties-MYSQL DB
		String driverclass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/myhiber";
		String username = "root";
		String password = "Avi@12345";
		String sql = "delete from student";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = null;
		System.out.println("---------------------------");
		System.out.println("MENU");
		System.out.println("0,Delete All Students");
		System.out.println("1,Delete All By ID");
		System.out.println("2,Delete All By Name");
		System.out.println("3,Delete All By Fee");
		System.out.println("---------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your option:");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			sql += "where sid=?";
			System.out.println("enter student Id:");
			int stdId = sc.nextInt();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			break;
		case 2:
			sql += "where sname=?";
			System.out.println("Enter student Name:");
			String stdName = sc.next();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stdName);
			break;
		case 3:
			sql += "where sfee=?";
			System.out.println("Enter student fee:");
			Double stdFee = sc.nextDouble();
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, stdFee);
			break;
		default:
			pstmt = con.prepareStatement(sql);
			System.out.println("you choosen all row delete:");
			break;
		}
		int count = pstmt.executeUpdate();
		if (count == 0)
			System.out.println("sorry!!Details not Found");
		else
			System.out.println("Data removed");
		con.close();
	}
}