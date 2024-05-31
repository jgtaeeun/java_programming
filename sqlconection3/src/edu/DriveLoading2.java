//world database에서 city 표에 있는 값 전부 출력
//4079 행(rows)

package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DriveLoading2 {
	
	
	
	public static void main(String[] args) {
		
		try {
		Connection con =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");

		System.out.println("연결 성공");
		
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id, name, countrycode, district, population from city ");
		ResultSetMetaData meta = rs.getMetaData();
		
		int count = meta.getColumnCount();
		System.out.println(count);
		
		while (rs.next()) {
			for (int i=1 ; i<= count ; i++) {
			System.out.print(rs.getString(i) != null ? rs.getString(i) +  ", ": " - ");
				
			}
			System.out.println();
		}
		
		
		rs.close();
		st.close();
		con.close();
		}catch (Exception e) {
			System.out.println("DB가 없음" + e.getMessage());
		}
	}
}
