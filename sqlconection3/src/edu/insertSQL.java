package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class insertSQL {

	public insertSQL() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
			
			System.out.println("연결 성공");
			
			PreparedStatement pt = con.prepareStatement("insert into member(id, pass, name) values (?, ?, ?)");
			pt.setInt(1, 1);
			pt.setString(2, "pass1");
			pt.setString(3,"name1");
			pt.executeUpdate();
			
			for (int i=2 ; i<=10 ; i++) {
				
				pt.setInt(1, i);
				pt.setString(2, "pass"+i);
				pt.setString(3,"name"+i);
				pt.executeUpdate();
			}
			
			
			
			con.close();
			
			
		}
		catch (Exception e) {
			System.out.println("연결실패"+e.getMessage());
		}
	}


	

}
