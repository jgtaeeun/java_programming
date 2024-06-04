package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class member_cstate_query {


	public static void main(String[] args) {
		String name;
		String pass;
		String sql;
		Scanner sc = new Scanner(System.in);
		
		try {
		Connection con =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");

		System.out.println("연결 성공");
		System.out.print("id 입력: "); 
		int select =sc.nextInt();
		
		Statement st = con.createStatement();
		
		switch (select) {
		
		case 1 : 	int id =sc.nextInt();
					sql= "select id,name from member_cstate ";
					ResultSet rs = st.executeQuery(sql + String.format("where id= %d", id));
		
					while (rs.next()) {
							System.out.print(rs.getString("id") + ",");
							System.out.print(rs.getString("name") + ",");
					}
					System.out.println("--------------");
					rs.close();
		case 2 : int id =sc.nextInt();
				sql= "select id,name from member_cstate ";
		ResultSet rs = st.executeQuery(sql + String.format("where id= %d", id));

		while (rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("name") + ",");
		}
		System.out.println("--------------");
		rs.close();
		case 3 :
		}
		
			
		else if (pass !=null) {
			sql= "select id,pass from member_cstate ";
			ResultSet rs = st.executeQuery(sql + String.format("where id= %d", id));
			while (rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pass") + ",");
			}
			System.out.println("--------------");
			rs.close();
		}
		else if (pass !=null && name!=null){
			sql= "select id,pass, name from city ";
			ResultSet rs = st.executeQuery(sql + String.format("where id= %d", id));
			while (rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pass") + ",");
				System.out.print(rs.getString("name") + ",");
			}
			System.out.println("--------------");
			rs.close();
		}
		st.close();
		con.close();
		}catch (Exception e) {
			System.out.println("DB가 없음" + e.getMessage());
		}
	}
}
	