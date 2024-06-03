package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Member {
	private int id;
	private String pass;
	private String name;
	
	public void setId(int i) {
		this.id=i;
	}
	public void setPass(String s) {
		this.pass=s;
	}
	public void setName(String s) {
		this.name=s;
	}
	public int getId() {
	return id;
	}
	public String getPass() {
		return pass;
	}
	
	public String getName() {
		return name;
	}
	
}


public class insertSQL_class {

	public insertSQL_class() {
		// TODO Auto-generated constructor stub
	}
	public static int insertUser(PreparedStatement pt ,Member member) throws Exception {
		pt.setInt(1, member.getId());
		pt.setString(2,  member.getPass());
		pt.setString(3, member.getName());
		return pt.executeUpdate();
	}
	
	public int deleteUser(Connection con) throws SQLException {
		Statement st= con.createStatement();
		int ret=st.executeUpdate("delete from member");
		st.close();
		System.out.println("deleted: " + ret);
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		Connection con=null;
		PreparedStatement pt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
			
			System.out.println("연결 성공");
			
			pt = con.prepareStatement("insert into member_class(id, pass, name) values (?, ?, ?)");
			
			for (int i=1 ; i<=10 ; i++) {
				
				Member member = new Member();
				member.setId(i);
				member.setPass("pass"+i);
				member.setName("name"+i);
				count+=insertUser(pt,member);
			}
			
		
			pt.close();
			con.close();
			
			
		}
		catch (Exception e) {
			System.out.println("연결실패"+e.getMessage());
		}
	}


	

}
