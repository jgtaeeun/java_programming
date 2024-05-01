/**
 * 
 */
package chater3;

import java.util.Scanner;

/**
 * 
 */
public class Test22_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//표준입력장치로부터 입력받기
		Scanner sc = new Scanner(System.in);
		//정수형 입력 받아서 변수 a,b에 저장
	    System.out.print("input1: "); int a = sc.nextInt();
	    System.out.print("input2: "); int b = sc.nextInt();
	    
		//문자열을 입력받아 문자열 변수 ops에 저장
		System.out.print("input3: "); String subinput = sc.next(); char op = subinput.charAt(0);
	    //ops에 저장된 첫번째 문자를 문자변수 op에 저장

		
		//op에 저장된 값으로 코드 실행 if 문
		
	    if (op=='+') {
	        System.out.print(a+b); 
	    }else if(op== '-') {
	    	System.out.println(a-b);
	    }else if(op== '*') {
	    	System.out.println(a*b);
	    }else if(op== '/') {
	    	System.out.println(a/b);
	    }else {
	    	System.out.println("잘못된 연산자입니다.");
	    }
	    
		
		
	}

}
