//world database에서 city 표에 있는 값 일부 출력
//1)DriverManager.getConnection
//2)con.createStatement();
//3)select의 경우,executeQuery를 호출하여  resultset으로 리턴값이 된다. =>ResultSet rs = st.executeQuery
//4)rs를 한 행씩 돌면서 출력 =>rs.next()

package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DriveLoading {

	
	public static void main(String[] args) {
		
		try {
		Connection con =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");

		System.out.println("연결 성공");
		
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id, name, countrycode, district, population from city limit 10 ");
		
		
		while (rs.next()) {
			System.out.print(rs.getString("id") + ",");
			System.out.print(rs.getString("name") + ",");
			System.out.print(rs.getString("countrycode") + ",");
			System.out.print(rs.getString("district" )+ ",");
			System.out.print(rs.getString("population") + "\n");
		}
		rs.close();
		st.close();
		con.close();
		}catch (Exception e) {
			System.out.println("DB가 없음" + e.getMessage());
		}
	}
	
}
