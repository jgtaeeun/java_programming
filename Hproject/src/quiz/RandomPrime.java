package quiz;

import java.util.Random;
import java.util.Scanner;



public class RandomPrime {

	public RandomPrime() {
		// TODO Auto-generated constructor stub
	}

	public static boolean Prime1(int a, int n) {
		boolean flag = false;

	String str = String.valueOf(a);   //237을 문자열로
	int txt;
	 
	 
	if ((a>=1)&&(a<=9)) {
		 if(PrimeNumber1.isPrime1(a)==true) { flag = true;}
		 
	}
	else{
		 if(PrimeNumber1.isPrime1(a)==true) {
			 for(int k=1 ; k<n ; ){
			     txt= Integer.parseInt(str.substring(0,k)); // 53,537
			     if(PrimeNumber1.isPrime1(txt)==true) {
			    	 if(k==(n-1)){ flag = true;}
			    	 k++;
			     }
			     else break; 
	        }

		 }
		 
	}
	return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
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
	    	 
	    	  
	    	  int count =0; 
	    	 
	    	 
	    	  
	    	  while(true) {
	    		     Random rnd=new Random();
	    		     int number = rnd.nextInt(s,e);
	    		     if(Prime1(number,num)==true) {System.out.println(number); break;}
	    		     
	    		 
	    	 }
	    		  
	    	   break;
	    	}
	    

	}

}
