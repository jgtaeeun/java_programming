/**
 * 
 */
package chater2;

/**
 * 
 */
public class test11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 42;
		String binaryValue1=Integer.toBinaryString(num1);  
		System.out.println(binaryValue1);  /*10진수->2진수*/
		 

		
		int num2 = -42;
		String binaryValue2=Integer.toBinaryString(num2);
		System.out.println(binaryValue2);
		
		int num3 = 42;
		String hexValue3=Integer.toHexString(num3);
		System.out.println(hexValue3);                /*10진수->16진수*/
		
		/*Integer.toHexString( 숫자)*/
	}

}
