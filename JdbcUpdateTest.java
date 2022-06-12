package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcUpdateTest {
	public static void main(String[] args) throws Exception {
//jdbc properties
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";
		String sql = "update student set sname='venky',sfee=5 where sid=1";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("Updated:" + count);
		con.close();
	}
}
