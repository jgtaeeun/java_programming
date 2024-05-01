/**
 * 
 */
package chater3;

import java.util.Scanner;

/**
 * 
 */
public class Test22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * int a = 12; int b = 2; char op = '-';
		 */
		//표준입력장치로부터 입력받기
		Scanner sc = new Scanner(System.in);
		
		//정수형 입력 받아서 변수 a,b에 저장
		System.out.print("첫번째 숫자: "); int a = sc.nextInt();  
		System.out.print("두번째 숫자: "); int b=sc.nextInt();
		System.out.print("연산자: "); 
		String ops = sc.next(); //문자열을 입력받아 문자열 변수 ops에 저장
		char op=ops.charAt(0);  //ops에 저장된 첫번째 문자를 문자변수 op에 저장

		
		//op에 저장된 값으로 코드 실행
		switch(op) {
		case '+' : System.out.println(a+b); break; 
		case '-' : System.out.println(a-b); break;
		case '*' : System.out.println(a*b); break;
		case '/' : System.out.println(a/b); break;
		default : System.out.println("input error"); break;
		}
		
	}

}
