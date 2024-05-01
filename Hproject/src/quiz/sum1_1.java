/**
 * 
 */
package quiz;

import java.util.Scanner;

/**
 * 
 */
public class sum1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//전체합, 홀수합, 짝수합
		Scanner sc = new Scanner(System.in);
		
		

		int oddSum = 0;
		int evenSum = 0;
		while(true) {      
			System.out.print("0보다 큰 하나의 정수 입력하세요: ");
			int num = sc.nextInt();
			
			if (num==0) break;
			
		    for(int i = 1 ; i<= num ; i++) {
			if (i %2 == 0) {
				evenSum= evenSum + i;
			}else {
				oddSum= oddSum +i;
			}

		}
		
		System.out.println("입력:"+ num);
		System.out.println("전체 합:"+ (oddSum+evenSum)); //oddSum과 evenSum 합을 출력하기 위해 괄호로 묶어주어야한다.
		                                                 //그렇지 않을 경우, 정수리터럴로 출력된다.
		System.out.println("홀수 합:"+ oddSum);
		System.out.println("짝수 합:"+ evenSum);
		System.out.println();
		
	}
	}

}
