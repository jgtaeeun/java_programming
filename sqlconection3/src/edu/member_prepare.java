package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class member_prepare {

	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/musthave";
	private static String user="scott";
	private static String pass ="tiger" ;
	
	private static void insertUser(Connection con) throws SQLException  {
		System.out.println("---insert member_prepare---");
		
		try (PreparedStatement pt = con.prepareStatement("insert into member_prepare(pass, name) values ( ?, ?)")) {
			System.out.print("pass 내용: "); String pcontent=sc.next();
			System.out.print("name 내용: "); String name =sc.next();
			System.out.println();
			pt.setString(1,pcontent);
			pt.setString(2,name);
			pt.executeUpdate();
			pt.close();
			System.out.println("insert 완료");
		}
		catch (Exception e){
			System.out.println("insert 실행 에러(연결실패 또는 insert 할 입력 내용 오류)"+e.getMessage());
		}
	}
	
	private static void deleteUser(Connection con) throws SQLException  {
		System.out.println("---delete member_prepare---");
		
		
		try (PreparedStatement psmt = con.prepareStatement("delete from member_prepare where id=?")) {
			System.out.print("삭제하고자 하는 id 입력: ");int selectid = sc.nextInt();
			System.out.println();
			psmt.setInt(1,selectid);
			psmt.executeUpdate();
			psmt.close();
			System.out.println("delete 완료");
		}
		catch (Exception e){
			System.out.println("delete 실행 에러(연결실패 또는 삭제 할 id 입력 오류)"+e.getMessage());
		}
		
	}
	
	private static void updateUser(Connection con) throws SQLException  {
		System.out.println("---update member_prepare---");
		
		try (PreparedStatement psmt = con.prepareStatement("update member_prepare set pass=?, name=? where id=?  ")) {
			System.out.print("수정하고자 하는 id 입력: ");int selectid =sc.nextInt();
			System.out.print("수정하고자 하는 pass 내용: ");String repass=sc.next();
			System.out.print("수정하고자 하는 name 내용: ");String rename =sc.next();
			System.out.println();
			
			psmt.setString(1,repass);
			psmt.setString(2,rename);
			psmt.setInt(3,selectid);
			psmt.executeUpdate();
			psmt.close();
			System.out.println("update 완료");
		}
		catch (Exception e){
			System.out.println("update 실행 에러(연결실패 또는 수정 할 내용 입력 오류)"+e.getMessage());
		}
		
	}
	
	private static void selectUser(Connection con) throws SQLException  {
		System.out.println("---select member_prepare---");
		int selectid =0;
		
		try (PreparedStatement psmt = con.prepareStatement("select * from member_prepare where id >? ")) {
			psmt.setInt(1, selectid);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pass") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.println();
			}
			
			System.out.println("select 완료");
			
			rs.close();
			psmt.close();
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
		
	
	}
	
}
