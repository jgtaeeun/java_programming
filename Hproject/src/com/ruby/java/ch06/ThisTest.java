package com.ruby.java.ch06;

//class Student{
//	private int i;
//}

public class ThisTest {

	private int i = 1;
	
	public ThisTest() {
		// TODO Auto-generated constructor stu	
	}
	
	public void first() {
		int i = 2 ;
		int j = 3;
		System.out.println(this.i+=j);
		this.i=i+j;      
		System.out.println(this.i);
		
		System.out.println(this.i+=j);
		
		second(4); //this.second(4); 
	}

	public void second(int i) {
		int j=5;
		this.i=i+j;
		System.out.println(this.i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          ThisTest exam = new ThisTest();
          exam.first();
          System.out.println(exam.i);
         
          //Student 클래스는 외부 클래스이므로 ThisTest클래스 안에서 인식되지 않는다.
          // Student s = new Student(); 
          // s.i();
	}

}
