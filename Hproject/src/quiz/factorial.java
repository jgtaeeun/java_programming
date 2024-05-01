package quiz;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자를 입력하세요:");
		int num=sc.nextInt();
		
		int sum=1;
		
		for (int i= num; i>0 ; i--) {
			sum=sum*i;
		}
		System.out.println(num +"!= "+sum);

	}

}
