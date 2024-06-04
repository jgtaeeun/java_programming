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
	
	static void updateUser(Connection con, int id, String pass, String name) throws SQLException {
		PreparedStatement pt = con.prepareStatement("update member set pass=? ,name=? where id=?");
		pt.setInt(3, id);
		pt.setString(1 ,pass);
		pt.setString(2,name);
		pt.executeUpdate();
		
		pt.close();
		
	}
	
	static void selectUser(Connection con) throws SQLException {
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery("select id, pass, name from member" );
		ResultSetMetaData meta = rs.getMetaData();
		
		int count = meta.getColumnCount();
		
		while (rs.next()) {
			for (int i=1 ; i<= count ; i++) {
			System.out.print(rs.getString(i) != null ? rs.getString(i) +  ", ": " - ");
				
			}
			System.out.println();
		}
		
		rs.close();
		st.close();
	}
	
	static void query1(Connection con, int id, String pass, String name) throws SQLException {
//		
//		PreparedStatement pt = con.prepareStatement("insert into member(id, pass, name) values (?, ?, ?)");
//		pt.setInt(1,id);
//		pt.setString(2, pass);
//		pt.setString(3,name);
//		pt.executeUpdate();
//		pt.close();
		
		// try -catch -resources 문
		try (PreparedStatement pt = con.prepareStatement("insert into member(id, pass, name) values (?, ?, ?)")) {
			pt.setInt(1,id);
			pt.setString(2, pass);
			pt.setString(3,name);
			pt.executeUpdate();
			pt.close();
		}
		catch (Exception e){
			System.out.println("연결실패"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		while(count<10) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
			
			System.out.println("연결 성공");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("[I]nput , [D]elete, [U]pdate, [S]how");
			System.out.print("원하는 항목 선택 :");
			char want=sc.next().charAt(0);
			
			switch(want) {
			case 'I':  {System.out.print("입력 id: "); int id = sc.nextInt();
					   System.out.print("pass 입력사항: "); String pass = sc.next();
					   System.out.print("name 입력사항: "); String name = sc.next();
					   query1(con, id, pass, name);  break;}
			case 'D':  {deleteUser(con); break;}
			case 'U':  { System.out.print("변경하고자 하는 id: "); int id = sc.nextInt();
						System.out.print("pass 변경사항: "); String pass = sc.next();
						System.out.print("name 변경사항: "); String name = sc.next();
						updateUser(con, id, pass, name); break;}
			case 'S':  {selectUser(con); break;}
			default : System.out.println("범위 내 항목 선택하세요"); break;
			}


			
		}
		catch (Exception e) {
			System.out.println("연결실패"+e.getMessage());
			e.printStackTrace();
		}
		count+=1;
	}
}


	

}
