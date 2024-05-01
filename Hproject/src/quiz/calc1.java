/**
 * 
 */
package quiz;

import java.util.Scanner;

/**
 * 
 */
public class calc1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    
    System.out.print("첫번째 숫자 입력: "); int num1 = sc.nextInt();
    System.out.print("두번째 숫자 입력: "); int num2 = sc.nextInt();
    
   
    
    System.out.println("입력값: " +num1 + "," +  num2);
    System.out.println("곱: "+ num1*num2);
    System.out.println("몫:"+num1/num2);
    System.out.println("나머지:"+ num1%num2);
    
		
	}

}
