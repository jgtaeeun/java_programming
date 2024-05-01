package com.ruby.java.test1;

public class ArmorSuit {
	//필드
	String name ="John";      
	int height = 185;
	int weight= 100;
	String color = "RED";
	boolean isFly = true;
	
	//메소드
	
	 void takeOff()
	{
		if (isFly) {
			System.out.println("날 수 있다.");
		}else {
			System.out.println("날 수 없다.");
		}
		System.out.println("takeOff 실행");
	}
//	void land() 
//	{
//		System.out.println("+".repeat(10));         //String 객체.메소드
//	}
//	void shootLaser() 
//	{
//		System.out.println("-".repeat(10));
//	}
//	void launchMissile()
//	{
//		System.out.println("launchMissile 실행");
//	}
//	
}
