package quiz;

import java.util.Scanner;

public class primetest {

	public primetest() {
		// TODO Auto-generated constructor stub
	}
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		System.out.print("input number:"); 
		int num = sc.nextInt();
		int s = (int)Math.pow(10.0, (double)(num-1));  //시작숫자
    	int e = (int)Math.pow(10.0, (double)(num))-1;  //끝숫자
    	  
       for(int k=s ; k<=e ; k++) {
    	  if(isPrime1(k)==true) {
    		  System.out.print(k+ " "); 
    	  }
       }
	}
	
}
