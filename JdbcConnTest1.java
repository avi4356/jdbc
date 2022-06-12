package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnTest1 {
	public static void main(String[] args) throws Exception {
//1.jdbc properties
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";
		String sql = "insert into student values(2,'vijay',5)";
//jdbc code
//load DriverClass
		Class.forName(driverclass);
//2.create Statement connection
		Connection con = DriverManager.getConnection(url, username, password);
//3.create Statement
		Statement st = con.createStatement();
//4.Execute Statement
//5.Get Result
		int count = st.executeUpdate(sql);
//6.Print result
		System.out.println("Inserted:" + count);
//7.close connection
		con.close();
	}
}