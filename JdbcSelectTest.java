package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectTest {
	public static void main(String[] args) throws Exception {
//jdbc properties
		String driverclass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myhiber";
		String username="root";
		String password="Avi@12345";		
		String sql = "select * from student";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		//next(): Boolean => this method is used to check next row exist or not in ResultSet.
		
		while (rs.next()) {
			System.out.println(rs.getInt("sid") + "," + rs.getString("sname") + "," + rs.getDouble("sfee"));
		}
		con.close();
	}
}
