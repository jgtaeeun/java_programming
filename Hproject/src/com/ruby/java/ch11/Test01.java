package com.ruby.java.ch11;

public class Test01 {

	public Test01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {  
			int a=1/0;
//			String s= new String("java");
//			int len=s.length();
//			s=null;
//			s.length();
	    	  
			int arr[]= new int[3];
			arr[3] = 30;
			System.out.println("OK");
			}catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println(e1.getMessage());
			
			}catch (NullPointerException e2) {
				e2.printStackTrace();
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			      
			System.out.println("GOOD");
	}

}