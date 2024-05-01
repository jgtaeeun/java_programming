package com.ruby.java.ch08.nonEnum;


//클래스 Enum
enum Mandarin{   
	금귤, 한라봉, 레드향, 천혜향, 황금향;
}

public class EnumTest02 {

	public EnumTest02() {
		// TODO Auto-generated constructor stub
	}
    public static void main(String [] args) {
    	Mandarin ma = Mandarin.한라봉;
    	
    	System.out.println("이름 : " + ma.name());
        System.out.println("위치 : " + ma.ordinal());
        System.out.println("황금향과의 상대 위치 : " + ma.compareTo(Mandarin.황금향));
    	
    	Mandarin ma2 = Mandarin.valueOf("레드향");
    	System.out.println(ma2);
    	
    	Mandarin list[] = Mandarin.values();
    	System.out.println("=====귤의 종류=====");
    	for(Mandarin m : list) {
    		System.err.println(m);
    		
    	}
    }
}
