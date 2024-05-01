/**
 * 
 */
package edu;

/**
 * 
 */
public class Test32_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] a = new int [10];
          
   
//      int i=1 ;
//      while ( i<10 ) {
//    	
//    	 a[i]=a[i-1]+5;
//    	 System.out.println(a[i]);
//    	  i++ ;
//    	 
//     }
      int i=0 ;
      do {
    	  if (i==0) {
    		  a[i]=0;
    		  System.out.println(a[i]);
    		  i++ ;
    	  }else {
    		  a[i]=a[i-1]+5;
    	      System.out.println(a[i]);
  	    	  i++ ;
    	  }
      }while(i<10 );
  
	}
}

 