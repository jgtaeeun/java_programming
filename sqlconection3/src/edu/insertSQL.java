package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class insertSQL {

	public insertSQL() {
		// TODO Auto-generated constructor stub
	}
	static void deleteUser(Connection con) throws SQLException {
		Statement st= con.createStatement();
		int ret=st.executeUpdate("delete from member");
		st.close();
		System.out.println("deleted: " + ret);
		
	}
	
	static void updateUser(PreparedStatement pt , int id, String pass, String name) throws SQLException {
		pt.setInt(3, id);
		pt.setString(1 ,pass);
		pt.setString(2,name);
		pt.executeUpdate();
		
	}
	
	static void selectUser(Connection con) throws SQLException {
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery("select id, pass, name from member ");
		ResultSetMetaData meta = rs.getMetaData();
		
		int count = meta.getColumnCount();
		
		while (rs.next()) {
			for (int i=1 ; i<= count ; i++) {
			System.out.print(rs.getString(i) != null ? rs.getString(i) +  ", ": " - ");
				
			}
			System.out.println();
		}
		
		rs.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
			
			System.out.println("연결 성공");
			
			//업로드
//			PreparedStatement pt = con.prepareStatement("insert into member(id, pass, name) values (?, ?, ?)");
//			pt.setInt(1, 1);
//			pt.setString(2, "pass1");
//			pt.setString(3,"name1");
//			pt.executeUpdate();
//			
//			
//			for (int i=2 ; i<=10 ; i++) {
//				
//				pt.setInt(1, i);
//				pt.setString(2, "pass"+i);
//				pt.setString(3,"name"+i);
//				pt.executeUpdate();
//			}
//			//삭제
			//deleteUser(con);
			
			//데이터 수정 (업로드)
			PreparedStatement pt = con.prepareStatement("update member set pass=? ,name=? where id=?");
			Scanner sc = new Scanner(System.in);
			System.out.print("변경하고자 하는 id: "); int id = sc.nextInt();
			System.out.print("pass 변경사항: "); String pass = sc.next();
			System.out.print("name 변경사항: "); String name = sc.next();
			updateUser(pt, id, pass, name);
			
			//변경이후 데이터 출력
			selectUser(con);
			
			pt.close();
			con.close();
			
			
		}
		catch (Exception e) {
			System.out.println("연결실패"+e.getMessage());
			e.printStackTrace();
		}
	}


	

}
