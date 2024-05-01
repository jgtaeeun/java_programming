package com.ruby.java.ch06;

public class StaticMethodTest {

	 int num = 123;  //인스턴스 필드 => 인스턴스 객체 생성 후 사용할 수 있다.
	 static int count = 0;  //클래스 필드
	
	
   public static void print1() {
	   int num2 = count ; //int num2 = num ; 일때 non-static field 에러 발생(인스턴스 필드이므로)
	   System.out.println("hello");
   }
   public void print2() {
	   int num3 = num;
	   System.out.println("java");
   }
   
   
   
   public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		 StaticMethodTest.print1();
		 //StaticMethodTest.print2();      //인스턴스 메소드이기에 인스턴스 객체.인스턴스메서드 필요
	     StaticMethodTest smt = new StaticMethodTest();
	     smt.print2(); //객체 생성 후 사용됨
   
   }
}
