package Chap3_검색알고리즘;

import java.util.Arrays;
import java.util.List;

public class Test_스트링배열합병 {

	public Test_스트링배열합병() {
		// TODO Auto-generated constructor stub
	}
	static void showList(String text, String [] s) {
		 System.out.println(Arrays.toString(s));
	 }
	 
	 static String [] mergeList( String [] s1, String [] s2) {
		 
		 String [] s3 = new String [s1.length + s2.length];
		 //System.out.println(s3.length);
		 
		 for (int i=0 ; i <s1.length ; i++) {
			 s3[i]=s1[i];
			 s3[i+s1.length ]=s2[i];
		 }
		 Arrays.sort(s3); 
		 
		
		 return s3;
	 }
	 
	
	

	public static void main(String[] args) {
			String[] s1 = {"홍길동", "강감찬", "을지문덕", "계백", "김유신", "최치원" };
			String[] s2 = {"독도", "울릉도", "한산도", "영도", "오륙도", "동백섬"};
			Arrays.sort(s1);
			Arrays.sort(s2);
			
			showList("s1배열 = ", s1);
			showList("s2배열 = ", s2);
			
			String[] s3 = mergeList(s1,s2);//정렬된 s1[], s2[]을 합병하여 다시 정렬된 결과를 만드는 함수 구현
			showList("스트링 배열 s3 = s1 + s2:: ", s3);
		}

}
