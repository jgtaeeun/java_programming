/**
 * 
 */
package edu;

/**
 * 
 */
public class Test32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] a = new int [10];
          
      a[0] =0; //배열 인덱스
      
     for(int i=1 ; i<10 ; i++ ) {
    	 a[i]=a[i-1]+5;
    	 
     }
     for (int j=0 ; j<10 ; j++) {
    	 System.out.println(a[j]);
     }
	}
}

 