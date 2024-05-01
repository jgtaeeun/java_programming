/**
 * 
 */
package chater3;

import java.util.Scanner;

/**
 * 
 */
public class Test30_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*최소공배수 찾기*/
		System.out.print("최대숫자 입력: ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 1 ; i <=num ; i++) {
		 if ((i%2)==0) {
			if ((i%3)==0) {
				System.out.println(i+ "은 2와 3의 배수입니다.");
			}
		 }	
		}

	}

}
