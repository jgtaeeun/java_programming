package Chap5_Recursive;
import java.util.Scanner;

public class 실습5_3Recur {
	static void recur(int n) {
	     if (n > 0) {
	    	 System.out.println("recur(" + n + " - 1) 호출됨");
	         recur(n - 1);
	         System.out.println("n = " + n);
	         System.out.println("recur(" + n + " - 2) 호출됨");
	         recur(n - 2);
	     }
	}
	public static void main(String[] args) {
	         Scanner stdIn = new Scanner(System.in);
	         // 처음에는 n = 2,3에 대하여 실행한다 다음에 5에 대하여 
	         System.out.print("정수를 입력하세요 : ");
	         int x = stdIn.nextInt();

	         recur(x);
	}
}
