package com.ruby.java.test1;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Armor ar = new Armor();
//        boolean result = ar.takeOff();
//        
//        if(result) {
//        	System.out.println("날 수 있다.");
//        }else {
//        	System.out.println("날 수 없다.");
//        }
//        
//        System.out.println(result);
//	}
		//-------------------------------------------------------
		//Armor class의 필드 출력 ar.필드명
		//Armor class의 메소드 ar.메소드명(매개변수)
//		System.out.println("클래스 Armor의 height: " +ar.height);
//		ar.setHeight(170);
//		System.out.println(ar.height);
//		
//		System.out.println("클래스 Armor의 name: " +ar.name);
//		ar.setName("Selly");
//		System.out.println(ar.name);
		//-------------------------------------------------------
		ar.setData("Jelly" , 190);
		System.out.println(ar.name + " " + ar.height);
	}
}
