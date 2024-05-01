package com.ruby.java.ch07;

public class Employee2 extends Person {

	private String dept; 
	
    public Employee2() {
    	super(); //부모클래스 생성자 호출>자바 컴파일러가 자동으로 삽입
    	System.out.println("Employee 생성자 호출");
    } 
    
    public Employee2(String name, int age, String dept) {
//    	this.name = name ;      //this는 Employee객체의 인스턴스(heap에 있는)를 가리킨다.
//    	this.age = age ;
    	super(name, age);
    	this.dept = dept ;
    }

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept =dept;
	}
	public String toString() {
		return super.toString()	+ "," + dept;
	}
}