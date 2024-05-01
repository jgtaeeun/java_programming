/**
 * 
 */
package chater3;

import java.util.Scanner;

/**
 * 
 */
public class Test20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in); /*ctrl shift O 눌러서 자동 import*/
		
		System.out.print("점수를 입력하세요: ");   
		int score = sc.nextInt();
		char grade ;
		
		if (score >= 90) {
			grade = 'A';
		}else if (score >=80) {
			grade = 'B';
		}else if(score>=70) {
			grade='C';
		}else if(score>=60) {
			grade='D';
		}else {
			grade='F';
		}
		
		System.out.println("당신의 등급은 " + grade + "입니다");

	}

}
