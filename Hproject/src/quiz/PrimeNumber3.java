package quiz;

import java.util.Scanner;

public class PrimeNumber3 {

	public PrimeNumber3() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean calc1(int s, int e) {        //일의 자리수 계산
		boolean flag =false;
		int i, div;  //div는 2부터 Math.sqrt
		int start =s;  //시작숫자
		int end =e;  //끝숫자
		
		for( i =start ; i <=end ; i++) {
			
		if (start==1) {}
		else if((i==2)||(i==3)) {System.out.print(i+ " "); }
		else {
//			   2~div로 나누었을 때 나누어떨어지지 않아야함
			  for (int j=2; j<=Math.sqrt(i);) {
				  if ((i%j)!=0) { 
					 if(j==Math.sqrt(i)) {
						 if (i<10) System.out.print(i+ " "); 
		    			 flag=true;
					 }
					 j++; 
				  }
				  else break;
				  
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
    	 
    	  
    	
    	  
    	  //일의 자리수 소수 계산
    	  //십의 자리수 소수 계산
    	  //백의 자리수 소수 계산
    	  //천의 자리수 소수 계산
    	  int result =0 ;
    	  System.out.println(s + " ~ "+ e );
    	  System.out.println("자리수 : " + num);
    	  
    	  //정수 자리수 분류
    	  if (num==1) {calc1(s,e);}
    	  
    	  else if (calc1(s,e) ==true) {
    		 
    		    for(int div=10 ; div<=s ; div=10*div ) {
    		       int k1=s;
    		       int k2=e;
    		       if (k=s)
	        			      result = i%div;
	        			      
	        			      	
    	          }      
              }   
         }
    		  {소수가 아닌지 판단 아닐 경우, 아래 실시}
    		     for(int div=10 ; div<=s ; div=10*div ) {    //10
    			       int result = i%div;                     //
    			       
    		     }
    		  }
    	  }
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  System.out.println(s + " ~ "+ e + " 중에서 정수의 자릿수 모두 소수:");
    	  
    	  switch(num){
    	   case 1 :  for (int i = s ;i <e ; i++) {   
    		               if (i==1) {}
                           else if ( (i==2) ||(i==3)){System.out.print(i+ " ");}//s부터 e 숫자 범위
                           else { 
                        	   for (int j=2 ; j<=Math.sqrt(i);) {    //2부터 Math.sqrt(i)
       			                   int result = i%j ; 
       			                   if (result!=0) {
       			                	   if(j==Math.sqrt(i)) {System.out.print(i+ " ");}
       			                	   j++;}
       			                   else break;
       			               }
       	                  }
    	           } 
    	   break;
    	   
    	   case 2 :  
     
    	  //2자리수 입력 10~99 charAt(0) / charAt(0)+charAt(1)
    	  //3자리수 입력 100~999 charAt(0) / charAt(0)+charAt(1)/charAt(0)+charAt(1)++charAt(2)
    	  //4자리수 입력 1000~9999
      	  for(int k=0 ; k<num ; k++) {
      		  
      	  }
    	  
    	  
         }//while
    }//work()
}//클래스
