package com.ruby.java.ch07;

public class Professor extends Person {
	

//	private String name;
//	private int age;
	private String subject; //연구주제
	

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
//
//	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
 	public String toString() {
		return  name + "," + age + "," +  subject ;
	}

}