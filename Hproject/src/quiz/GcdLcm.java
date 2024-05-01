/**
 * 
 */
package quiz;

import java.util.Scanner;

/**
 * 
 */
public class GcdLcm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//최대공약수, 최소공배수
	    //유클리드 호제법
		Scanner sc  = new Scanner (System.in);
		System.out.print("정수 입력 : "); int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력: "); int num2 = sc.nextInt();
		
		 int max,min,maxResult=0, minResult=0;
		//입력정수 크기 비교
		if(num1 > num2) {
			 max = num1;
			 min = num2;
		}else {
			 max = num2;
			 min =num1;
		}
		
		//rem구하기
		 int rem = max % min ;
		 if (rem==0) {
			 maxResult=min;
			 minResult=(num1*num2)/maxResult;
			 System.out.println("최대공약수: " + maxResult + " 최소공배수: "+ minResult);
		 }else {
			 max=min;
			 min=rem;
			 rem = max % min ;
			 
			 if (rem==0) {
				 maxResult=min;
				 minResult=(num1*num2)/maxResult;
				 System.out.println("최대공약수: " + maxResult + " 최소공배수: "+ minResult);
			 }
             
			
		 }
		 
		 
       
	}

}
