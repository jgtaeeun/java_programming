package quiz;

import java.util.Random;
import java.util.Scanner;

public class MatrixCalc_1 {

	    //필드
		private int[][] matrix = {{1,2,3},
				               {4,5,6},
				               {7,8,9} 
				               };
		//메서드(행렬 만들기)
	    private void getMatrix(int a, int b){
	    
	    	
	    	matrix =new int [a][b];
	    	
	    	Random rnd = new Random();
	    	
	    	int max =0;
	    	if (a>b ) max =a;
	    	else max = b;
	    	
	    	if (max==a) {
	    	 for (int i = 0 ; i <matrix[0].length ; i++) {
	    		for(int j=0 ; j<matrix.length; j++) {
	    			matrix[i][j] = rnd.nextInt(10);
	    			System.out.print(matrix[i][j] + " ");
	    		}
	    		System.out.println();}
	    	 
	    	//합 초기화
		      int sum= 0;
		      
		      //행연산
		   
			  for (int i = 0 ; i <matrix[0].length; i++) {
		    		for(int j=0 ; j<matrix.length ; j++) {
		    			sum = sum + matrix[i][j] ;
		    		}
		    		System.out.println(i +"행연산 :"+ sum);
		    		 sum= 0;
		     }
			  
			  //열 연산
			   sum= 0;
			  for (int j = 0 ; j <matrix.length ; j++) {
		    		for(int i=0 ; i<matrix[0].length ; i++) {
		    			sum = sum + matrix[i][j] ;
		    		}
		    		System.out.println(j+"열연산 :"+ sum);
		    		sum= 0;
		     }
	    	}
	    	else if(max==b){
	    		for (int i = 0 ; i <matrix.length ; i++) {
		    		for(int j=0 ; j<matrix[0].length; j++) {
		    			matrix[i][j] = rnd.nextInt(10);
		    			System.out.print(matrix[i][j] + " ");
		    		}
		    		System.out.println();}
	    		
	    		//합 초기화
			      int sum= 0;
			      
			      //행연산
			   
				  for (int i = 0 ; i <matrix.length; i++) {
			    		for(int j=0 ; j<matrix[0].length ; j++) {
			    			sum = sum + matrix[i][j] ;
			    		}
			    		System.out.println(i +"행연산 :"+ sum);
			    		 sum= 0;
			     }
				  
				  //열 연산
				   sum= 0;
				  for (int j = 0 ; j <matrix[0].length ; j++) {
			    		for(int i=0 ; i<matrix.length ; i++) {
			    			sum = sum + matrix[i][j] ;
			    		}
			    		System.out.println(j+"열연산 :"+ sum);
			    		sum= 0;
			     }
	    	}
	    	
	    	else {for (int i = 0 ; i <matrix.length ; i++) {
	    		for(int j=0 ; j<matrix.length; j++) {
	    			matrix[i][j] = rnd.nextInt(10);
	    			System.out.print(matrix[i][j] + " ");
	    		}
	    		System.out.println();}
	    	
	    	  int sum= 0;
		      
		      //행연산
		   
			  for (int i = 0 ; i <matrix.length; i++) {
		    		for(int j=0 ; j<matrix.length ; j++) {
		    			sum = sum + matrix[i][j] ;
		    		}
		    		System.out.println(i +"행연산 :"+ sum);
		    		 sum= 0;
		     }
			  
			  //열 연산
			   sum= 0;
			  for (int j = 0 ; j <matrix.length ; j++) {
		    		for(int i=0 ; i<matrix.length ; i++) {
		    			sum = sum + matrix[i][j] ;
		    		}
		    		System.out.println(j+"열연산 :"+ sum);
		    		sum= 0;
		     }
	    	
	    	}
	    
	    	 
	    }
	    //메서드(덧셈 연산)
	   public void work() {
		   
		  
			  Scanner sc = new Scanner(System.in);
		      System.out.print("행입력:"); int m = sc.nextInt();
		      System.out.print("열입력:");int n = sc.nextInt();
		      getMatrix(m,n);
		      
		    
		      
		     
	  }
			 
		  
		 
	  
		
	}


