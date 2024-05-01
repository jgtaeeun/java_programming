package com.ruby.java.ch07.abstraction;

abstract class Person {              //추상클래스 Person
	int pid;                      //추상클래스 필드
	String name; 
	int age;
	
	public Person(int pid, String name, int age) {             //추상클래스 생성자
		this.pid = pid;
		this.name = name ;
		this.age = age;
	}
	
	public abstract String toString() ;       //추상메서드

	
}



class Student extends Person {          //부모클래스 Person 자식 클래스 Student   (상속-super.메서드/super(), 추상적-메서드 오버라이딩)
	int sid;                           // 필드
	String dept;
	int year;
	
	
	public Student(int pid, String name, int age, int sid, String dept, int year){         //생성자
		super(pid, name, age);
		this.sid = sid;
		this.dept = dept;
		this.year= year;
	}
	//super 사용
	@Override
	public String toString() {     
		//메서드 오버라이딩 
      return pid+ " " + name + " " + age + " " +  sid + " " + dept + " " + year ;
    }
}


class Professor extends Person {
	int eno;
	String dept;
	int salary;
	
	public  Professor(int pid, String name, int age, int eno, String dept, int salary) {
		super(pid, name, age);
		this.eno =  eno;
		this.dept = dept;
		this.salary=salary;
	}
	
	public String toString() {
		return pid+ " " + name + " " + age + " " +  eno + " " + dept + " " + salary ;
	}
}  

class Worker extends Professor {                      //상속클래스 
	
	public  Worker(int pid, String name, int age, int eno, String dept, int salary) {
		super(pid, name, age , eno, dept, salary);
	}

	public String toString() {
		return super.toString();
	}
}  


public class CH07_AbstractClass {

	public CH07_AbstractClass() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person arr[] = new Person[6];
        arr[0] = new Student(1, "Kim", 20, 1001, "Computer Science", 3);          //Person > Student
        arr[1] = new Student(2, "Lee", 21, 1002, "Mathematics", 2);             //Person > Student
        arr[2] = new Professor(3, "Park", 30, 2001, "HR", 3000);            //Person > Professor 
        arr[3] = new  Professor(4, "Choi", 35, 2002, "Engineering", 4000);  //Person > Professor 
        arr[4] = new Student(5, "Kang", 22, 1003, "Physics", 4);           //Person > Student
        arr[5] = new Worker(6 , "JE" , 25 , 1006 , "Bio" , 3);           //Person > Professor > Worker
      
		for(Person p : arr) {
			System.out.println(p.toString());}
		
		System.out.println();
		//  Professor > Worker
		Worker w = new Worker(6 , "JE" , 25 , 1006 , "Bio" , 3);
		System.out.println(w.toString());
		
		
    }
}
