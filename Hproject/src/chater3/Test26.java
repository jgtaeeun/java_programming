/**
 * 
 */
package chater3;

import java.util.Scanner;

/**
 * 
 */
public class Test26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//조건식 입력받기
		Scanner sc =  new Scanner(System.in);
		System.out.print("반복 횟수 입려하세요: ");
		int num= sc.nextInt();
		
		//초기화
		int i = 0;
		//반복문 while
        while(i<num) {
        	if (i %2 ==0) {
        	System.out.println(i);
        	}
        	i++;
        }
        System.out.println("OK");
	}

}
