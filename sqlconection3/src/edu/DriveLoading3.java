//world database에서 원하는 것만 출력
//각각의 조건에 대한 함수를 만든다.

package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class DriveLoading3 {

	
	static void result(ResultSet rs) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		
		int count = meta.getColumnCount();
		
		while (rs.next()) {
			for (int i=1 ; i<= count ; i++) {
			System.out.print(rs.getString(i) != null ? rs.getString(i) +  ", ": " - ");
				
			}
			System.out.println();
		}
	}
	
	static void query1 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select Name, Capital from country");
		result(rs);
		rs.close();
	}
	
	static void query2 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select Population, Name from city order by Population DESC limit 5");
		result(rs);
		rs.close();
	}
	
	static void query3 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select * from city where CountryCode='USA'");
		result(rs);
		rs.close();
	}
	
	static void query4 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select  C.Name ,CL.Language from countrylanguage CL, country C where  C.Name = 'China' and C.Code = CL.CountryCode");
		result(rs);
		rs.close();
	}
	
	static void query5 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select Name, Population, Continent from country where Continent='Europe' and Population>=1000000");
		result(rs);
		rs.close();
	}
	
	static void query6 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select Name, IndepYear from country where IndepYear>1900");
		result(rs);
		rs.close();
	}
	
	static void query7 (Statement st) throws Exception {
		ResultSet rs = st.executeQuery("select C.Name,  C.GNP,CL.Language,CL.IsOfficial from countrylanguage CL , country C\r\n"
				+ "where CL.Language='English' and CL.IsOfficial='F' and CL.CountryCode =C.Code and C.GNP >1000;");
		result(rs);
		rs.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		
		String url=null;
		String user=null;
		String password=null;
		Connection con=null;
		Statement st=null;
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
			
			
			st = con.createStatement();
			
			while (true) {
				System.out.println();
				System.out.println("==========항목==========");
				System.out.println("1. 수도 이름과 함께 국가 이름을 검색합니다.");
				System.out.println("2. 세계에서 인구가 가장 많은 상위 5개 도시의 이름과 인구를 검색합니다.결과를 인구별로 내림차순으로 정렬합니다. ");
				System.out.println("3. 미국(United States)에 있는 모든 도시의 이름을 검색합니다.");
				System.out.println("4. 중국(China)에서 사용되는 모든 언어의 이름을 검색합니다.");
				System.out.println("5. 인구가 100만 명 이상인 유럽 국가의 이름을 검색합니다.");
				System.out.println("6. 1900년 이후 독립한 국가의 이름을 검색합니다.");
				System.out.println("7. 영어가 공용어가 아니고 국민총생산(GNP)이 1,000보다 큰 국가의 이름을 검색합니다.");
				System.out.print("원하는 항목을 입력하세요(1~7): ");
				int number = sc.nextInt();
				
				switch(number) {
					case 1:{ System.out.println("<항목1> 국가 이름,수도 이름 "); query1(st); break;}
					case 2: {System.out.println("<항목2> 인구, 상위 5개 도시의 이름"); query2(st); break;}
					case 3: {query3(st); break;}
					case 4: {query4(st); break;}
					case 5: {query5(st); break;}
					case 6: {query6(st); break;}
					case 7: {query7(st); break;}
					default : {System.out.println("항목범위를 확인하세요.그리고 다시 입력하세요"); break;}
				}
				
			}
//			
		}
		catch (Exception e){
			System.out.println("연결 실패");
		}
		st.close();
		con.close();
		
		
	}

}
