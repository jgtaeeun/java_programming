package quiz;

import java.util.Scanner;

public class PrimeNumber1 {

	//필드 
	private int start_num2 = 2;
//	private int start_num3 = 3;
//	private int start_num5 = 5;
//	private int start_num7 = 7;
	
	//소수판단1 메서드
	//소수는 1과 자기자신만을 가진다. 
//	public boolean isPrime(int a) {
//		boolean flag=true;
//		
////		switch(a) {
////		 case 2 :
////		 case 3 :
////		 case 5 :
////		 case 7 :
////			 break;
////
////		 default :
////			 if ((a%2!=0)&&(a%3!=0)&&(a%5!=0)&&(a%7!=0)) {
////				 break;
////			 }
////			 else {
////				 flag=false;
////			 }
////		}
////		return flag;
////	}
//	
	public static boolean isPrime1(int a) {
		boolean flag=true;
		
		
		
        int result=0;
        if (a==2) {}
        else if (a==1) flag=false;
        else {
		for(int i =a-1 ; i>=2;) {
			 result= a%i;
			 
			 if (result!=0) {
					 i--;
			 }
			 else {
				  flag=false;
				  break;
			 }
					  
		}
        }
		
	   return flag;
	}
	

	
	//메서드
	public  void work() {
		Scanner sc =  new Scanner(System.in);
		while(true) {
			System.out.print("input number:"); 
			int num = sc.nextInt();
			
			if(num==0 || num==1) {
				System.out.println(num + "은 소수 입력 범위가 아님");
				break;     
			}
 			
			if(isPrime1(num)==true) {
              System.out.println(num + " isPrime");
			  break;}
			else {
				System.out.println(num + " is not a Prime");  break;
			}
		}
		sc.close();
	    System.out.println("소수판단 함수 종료");
	}

}
