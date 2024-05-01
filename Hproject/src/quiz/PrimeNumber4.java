package quiz;

import java.util.Random;
import java.util.Scanner;

public class PrimeNumber4 {

	public PrimeNumber4() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isPrime1(int a) {
		boolean flag=true;
		
		
		
        int result=0;
        
        if(a==1) {flag=false;}
        else if(a==2) {}
        else {
        
		for(int i =a/2 ; i>=2;) {
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
	
	
	public void work() {
	Scanner sc = new Scanner(System.in);
	
	while(true) {
	  System.out.print("Number[0:exit]:");
	  int num = sc.nextInt();
	
	  if (num == 0 ) {
    	System.out.println("입력이 잘못 되었습니다.");
    	break;
	  }
	
	
	  int s = (int)Math.pow(10.0, (double)(num-1));  //시작숫자
	  int e = (int)Math.pow(10.0, (double)(num))-1;  //끝숫자
	  
	  
	  while(true) {
	     Random rnd=new Random();
	     int number = rnd.nextInt(s,e);
	     if(isPrime1(number)==true) {System.out.println(number); break;}
	     
	 
	  }
	  break;
    }
	
}
}