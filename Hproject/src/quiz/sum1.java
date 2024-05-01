/**
 * 
 */
package quiz;

import java.util.Scanner;

/**
 * 
 */
public class sum1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//전체합, 홀수합, 짝수합
		Scanner sc = new Scanner(System.in);
		System.out.print("0보다 큰 하나의 정수 입력하세요: ");
		int num = sc.nextInt();
		
		
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i = 1 ; i<= num ; i++) {
			if (i %2 == 0) {
				evenSum= evenSum + i;
			}else {
				oddSum= oddSum +i;
			}

		}
		
		System.out.println("입력:"+ num);
		System.out.println("전체 합:"+ (oddSum+evenSum));
		System.out.println("홀수 합:"+ oddSum);
		System.out.println("짝수 합:"+ evenSum);
		
	}

}
