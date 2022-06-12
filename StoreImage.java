package com.app;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImage {
	public static void main(String[] args) throws Exception {
//jdbc properties
		String driverclass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/myhiber";
		String username = "root";
		String password = "Avi@12345";
		String sql = "insert into imagetab values (?,?,?)";
//jdbc code
		Class.forName(driverclass);
		Connection con = DriverManager.getConnection(url, username, password);
//1.load image into file object(RAM)
		File f = new File("D:\\1.jpg");
//2.read data from file object
		FileInputStream fis = new FileInputStream(f);
//3.create pstmt object
		PreparedStatement pstmt = con.prepareStatement(sql);
//4.set basic data
		pstmt.setInt(1, 100);
		pstmt.setString(2, "2.jpg");
//5.set image data into BLOB
		pstmt.setBinaryStream(3, fis, (int) f.length());
//6.execute pstmt
		int count = pstmt.executeUpdate();
//7.print result
		System.out.println("Inserted:" + count);
		con.close();
	}
}