package quiz;

import java.util.Scanner;

public class PrimeNumber3 {

	public PrimeNumber3() {
		// TODO Auto-generated constructor stub
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
    	 
    	  
    	  int count =0; 
    	 
    	  
    	  
    	  for (int i = s ; i<= e ; i++) {        //100~999 일 때 자리수 모두 소수인 것을 찾자 (예-237)
    		 //자리수 검사
    		  String str = String.valueOf(i);   //237을 문자열로
  		       int txt;
    		  
    		  
    		 if ((i>=1)&&(i<=9)) {
    			 if(PrimeNumber1.isPrime1(i)==true) { System.out.print(i + " "); count+=1;}
    			 
    		 }
    		 else{
    			 if(PrimeNumber1.isPrime1(i)==true) {
    				 for(int n=1 ; n<num ; ){
	    			     txt= Integer.parseInt(str.substring(0,n)); // 53,537
	    			     if(PrimeNumber1.isPrime1(txt)==true) {
	    			    	 if(n==(num-1))System.out.print(i + " "); 
	    			    	 n++;
	    			     }
	    			     else break; 
    		     }
    			 
    			   
    			   
	    			     
	    			     
    			 
    			 }//else
    				    	
    		 }	 //    for
    	   
    	  }
    	  break;
    	  }
    	  	 
    }
    }
 
    	
    	
    	
    
