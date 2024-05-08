package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}


public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}

	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}
	public static MyInterface test3() {
		return new MyInterface() {
			@Override
			public void print() {
				System.out.println("hello");
			}
		};
	}
	
	public static void main(String[] args) {
		//방법1 implements 키워드로 클래스선언
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print(); // MyClass1
		mc2.print(); // MyClass2
		
		
		MyInterface m = test3();
		m.print();
				//함수형 스타일의 람다식 구현 
		MyInterface m2 = ()->System.out.println("hello");//함수형 인터페이스 - 오직 한 메소드만 구현한다 
		m2.print();
		
		
		//방법2 익명클래스
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}
			
		};
		
		mi.print(); // 익명 클래스로 구현
		
		
		//mi=mc1;  //MyInterface mi , MyClass1 mc1        상위클래스=하위클래스;
		//mc1=mi;  
		
		//방법 3 선언, 생성, 호출을 한번에 처리  
		(new MyInterface() {       //new () 생성자호출,객체생성
			@Override				//{     } 익명클래스 선언
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print(); // 선언, 생성, 호출을 한번에 처리           //함수실행

		//방법 4 매개변수
		
		test(mc1); // MyClass1            MyInterface mi =mc1;     mc1.print();
		test(mi); // 익명 클래스로 구현        	MyInterface mi = mi
		
		MyInterface mi2 = test2();
		mi2.print(); // test2() 메서드에서 반환된 MyInterface
		
		

	}
}