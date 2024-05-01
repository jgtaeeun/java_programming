package com.ruby.java.test1;

public class Test03_2 {

	String name = "";
	int v ;
	
	void test(String name, int ...v) {
    	System.out.print(name + " : ");
    	for (int x : v) {
    		System.out.print(x + " " );
    	
    	}
    	System.out.println();
    	

	
	}
	
	

}

