package quiz;

import java.util.Scanner;

public class PrimeNumber2 {

	
	
	//메서드
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
    	 
    	  
    	  
    	  for (int i = s ; i<= e ; i++) {
    		  
    		 
    	    	//  if(PrimeNumber1.isPrime1(i)==true) {
    	    	//	  System.out.print(i+ " "); 
    	    	//	  count+=1;
    	    	//  }
    		  int div = i/2;
     		 
    		  if (i==1) {}
    		  else if((i==2)||(i==3)) {
    			  System.out.println(i+ " ");
    			  count+=1;
    		  }
    		  else {
//    			   2~div로 나누었을 때 나누어떨어지지 않아야함
    			  for (int j=div; j>=2;) {
    				  if ((i%j)!=0) { 
    					 if(j==2) {
    						 System.out.println(i+ " ");
    		    			  count+=1;
    					 }
    					 j--; 
    				  }
    				  else break;
    				  
    			  }
    		      
    		      
    		  }
    		 
    		    	  
    	  }
    	  
    	  System.out.println(s + " ~ "+ e + " 중에서 소수에 해당하는 숫자 개수 :" + count);
    	  
    	
    	  System.out.println("Done!");
        }
    	
    	
    	
    }
}

