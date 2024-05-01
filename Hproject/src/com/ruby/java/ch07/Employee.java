package com.ruby.java.ch07;

public class Employee extends Person {
//	private String name;
//	private int age;
	private String dept; 
	
    public Employee() {
    	super(); //부모클래스 생성자 호출>자바 컴파일러가 자동으로 삽입
    	System.out.println("Employee 생성자 호출");
    } //default생성자 자바가 자동 생성
    
    public Employee(String name, int age, String dept) {
    	this.name = name ;      //this는 Employee객체의 인스턴스(heap에 있는)를 가리킨다.
    	this.age = age ;
    	this.dept = dept ;
    }
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name= name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age =age;
//	}

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept =dept;
	}
//	toString()방법 첫번째
//	public String toString() {
//		return   name + "," + age + "," +  dept ;
//	}
//	toString()방법 두번째(this.getName()해도 됨)
//	public String toString() {
//		return getName()+ "," + getAge()+ dept;
//	}
	public String toString() {
		return super.toString()	+ "," + dept;
	}
}