package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class member_cstate {

	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/musthave";
	private static String user="scott";
	private static String pass ="tiger" ;
	
	private static void insertUser(Connection con) throws SQLException  {
		System.out.println("---insert member_cstate---");
		String sql="insert into member_cstate (pass, name) values";
		try  {
			System.out.print("pass 내용: "); String pcontent=sc.next();
			System.out.print("name 내용: "); String name =sc.next();
			Statement st = con.createStatement();
			st.executeUpdate(sql+ String.format("('%s','%s')",pcontent, name));
			st.close();
			System.out.println("insert 완료");
		}
		catch (Exception e){
			System.out.println("insert 실행 에러(연결실패 또는 insert 할 입력 내용 오류)"+e.getMessage());
		}
	}
	
	private static void deleteUser(Connection con) throws SQLException  {
		System.out.println("---delete member_cstate---");
		String sql="delete from member_cstate ";
		
		try  {
			System.out.print("삭제하고자 하는 id 입력: ");int selectid =sc.nextInt();
			Statement st = con.createStatement();
			st.executeUpdate(sql+ String.format("where id =%d",selectid));
			st.close();
			System.out.println("delete 완료");
		}
		catch (Exception e){
			System.out.println("delete 실행 에러(연결실패 또는 삭제 할 id 입력 오류)"+e.getMessage());
		}
		
		
	}
	
	private static void updateUser(Connection con) throws SQLException  {
		System.out.println("---update member_cstate---");
		String sql="update member_cstate ";
		try {
			System.out.print("수정하고자 하는 id 입력: ");int selectid =sc.nextInt();
			System.out.print("수정하고자 하는 pass 내용: ");String repass=sc.next();
			System.out.print("수정하고자 하는 name 내용: ");String rename =sc.next();
			Statement st =  con.createStatement();
			st.executeUpdate(sql+ String.format("set pass='%s', name='%s' where id=%d",repass,rename, selectid));
			st.close();
			System.out.println("update 완료");
		}
		catch (Exception e){
			System.out.println("update 실행 에러(연결실패 또는 수정 할 내용 입력 오류)"+e.getMessage());
		}
		
	}
	
	private static void selectUser(Connection con) throws SQLException  {
		System.out.println("---select member_cstate---");
		int selectid =0;
		String sql="select * from member_cstate";
		try  {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql+ String.format(" where id >%d ",selectid));
			
			while (rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pass") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.println();
			}
			
			System.out.println("select 완료");
			
			rs.close();
			st.close();
		}
		catch (Exception e){
			System.out.println("select 실행 에러(연결실패)"+e.getMessage());
		}
	}
	
	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection(url, user, pass);
		boolean flag=true;
	
		while(flag) {
			System.out.println("[I]nsert , [D]elete, [U]pdate, [S]elete, [e]xit");
			System.out.print("---원하는 항목 선택 :");
			String want=sc.next().toUpperCase();
			
			switch(want) {
				case "I":	insertUser(con); break;
				case "D":  deleteUser(con); break;
				case "U":  updateUser(con); break;
				case "S":  selectUser(con); break;
				case "E":  flag=false; break;
				default : System.out.println("범위 내 항목 선택하세요"); break;
			}
		}
		System.out.println("프로그램 종료합니다.");
		con.close();
	
	}
	
}