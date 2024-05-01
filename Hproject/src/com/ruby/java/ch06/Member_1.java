package com.ruby.java.ch06;

public class Member_1 {
	private String name;
	private int age;
	
	public Member_1() {
		// TODO Auto-generated constructor stub 
		System.out.println("Member_1() 생성자 실행");
	}
	public Member_1(String name) {
		System.out.print("Member_1(String) 생성자 실행 : ");
		System.out.println(name);
	}

	public Member_1(String name, int age) {
		System.out.print("Member_1(String, int) 생성자 실행 : ");
		System.out.println(name + " : " + age);
	}

	public void setName(String name) {
	}

	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		 
		//참조변수가 가리키는 값이 있다.
		Member_1 m1 =new Member_1();
		Member_1 m2 =new Member_1("Amy");
		Member_1 m3 =new Member_1("Amy", 23);
		
		//참조변수가 가리키는 값이 없어서 쓰레기값이 된다.
//				new Member_1();
//				new Member_1("Amy");
//				new Member_1("Amy", 23);
			}
}


