package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class QueryByPrepareStatement {

	public QueryByPrepareStatement() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args) {
		String url=null;
		String user=null;
		String password=null;
		Connection con=null;
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("url 입력하세요: ");
			url=sc.next();
			System.out.print("user 입력하세요: ");
			user=sc.next();
			System.out.print("password 입력하세요: ");
			password=sc.next();
			
			con =DriverManager.getConnection(url, user, password);

			System.out.println("연결 성공");
			
			PreparedStatement pt = con.prepareStatement("select id,name,countrycode,district,population from city where name=? and population>?");
			pt.setString(1, "Seoul");
			pt.setInt(2, 1000000);
			
			ResultSet rs = pt.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getInt("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("countrycode") + ",");
				System.out.print(rs.getString("district" )+ ",");
				System.out.print(rs.getInt("population") + "\n");
			}
			
			rs.close();
			pt.close();
			con.close();
		}	
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
