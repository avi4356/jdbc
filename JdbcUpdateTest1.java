
package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateTest1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("driver class is invalid");
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myhiber", "root", "Avi@12345");
			Statement st = con.createStatement();
			int count = st.executeUpdate("update student set sfee=10");
			System.out.println(count);
			con.close();
			System.out.println("done");
		} catch (SQLException sqle) {
			System.out.println("JDBC code problem:" + sqle);
		}
	}
}