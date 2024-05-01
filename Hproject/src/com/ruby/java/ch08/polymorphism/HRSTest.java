package com.ruby.java.ch08.polymorphism;

abstract class Employee {       //추상클래스 
	String name;
	int salary;
	
	public abstract void calcSalary();
	
}

class Salesman extends Employee{         //추상클래스 상속받은 자식 클래스
	
	int annual_sales ;
	public void calcSalary() {
		System.out.println("Salesman급여=기본금+판매수당");
	}
	
}


class Consultant extends Employee{
	
	int num_project ;
	public void calcSalary() {
		System.out.println("Consultant급여=기본금+컨설팅 특별 수당");
	}
	
}


class Manager extends Employee{

	int num_team ;
	
	public void calcSalary() {
		System.out.println("Manager급여=기본금+팀 성과 수당");
	}
	public void calcSalary2() {
		System.out.println("Manager급여=기본금+팀 성과 수당");
	}
}
class Director extends Manager{          //Manager을 상속받은 Director
	
}


public class HRSTest {

	public HRSTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void calcTax() {
	    	System.out.println("소득세를 계산합니다.");
	}
	  
    public static void calcTax(Employee e) {
    	System.out.println("소득세를 계산합니다.");
    }
  
//    public static void calcTax(Salesman a) {
//    	System.out.println("소득세를 계산합니다.");
//    }
//    
//    public static void calcTax(Consultant b) {
//    	System.out.println("소득세를 계산합니다.");
//    }
//    
//    public static void calcTax(Director c) {
//    	System.out.println("소득세를 계산합니다.");
//    }
//    
    
    
    public static void main(String [] args) {
    	Salesman s = new Salesman ();
    	Consultant c = new Consultant();
    	Director d = new Director();
    	Salesman s2 = s;
    	              
//    	calcTax();
////    	calcTax(s);                 //HRSTest 클래스의 메서드
////    	calcTax(c);
////    	calcTax(d);
//    	 
//    	
//    	System.out.println(s.toString());             //Salesman,Consultant, Director클래스 메서드에 toString()이 없다. 상위클래스 object가 가지고 있는 toString()적용된다.
//    	System.out.println(s2.toString());
//    	
//    	System.out.println(c.toString());
//    	System.out.println(d.toString());
//    	
//    	
//    	if(s.equals(c)) {                                   //equals() 또한 object클래스의 메서드이다.
//    		System.out.println("동일한 객체 입니다.");
//    	}else {
//    		System.out.println("서로 다른 객체 입니다.");
//    	}
//    	
//    	
//
//    	if(s.equals(s2)) {                                   //equals() 또한 object클래스의 메서드이다.
//    		System.out.println("동일한 객체 입니다.");
//    	}else {
//    		System.out.println("서로 다른 객체 입니다.");
//    	}
//    	
//    	-------------------------------------------------------------------------------------------------------인스턴스생성(부모-자식 1라인 경우)
//    	Object  s3 = new Salesman();      //인스턴스 생성, 상위클래스를 이용
//    	Employee  s4 = new Salesman();
//    	Salesman  s5 = new Salesman();
//    	
//    	Object  m1 = new Manager();      //인스턴스 생성, 상위클래스를 이용
//    	Employee  m2 = new Manager();
//    	Manager  m3 = new Manager();
//    	Director  m4 = new Manager();     //직계존속이 아니어서 오류난다.
//    	-------------------------------------------------------------------------------------------------------p348배열
    	Object  s11 = new Salesman();      //인스턴스 생성, 상위클래스를 이용
     	Employee  s22 = new Salesman();
     	Salesman  s33 = new Salesman();
//    	
    	Object  m11 = new Manager();      //인스턴스 생성, 상위클래스를 이용
    	Employee m22 = new Manager();
     	Manager  m33 = new Manager();
    	
     	Object arr [] =new Object [6];
     	arr[0] =s11;
     	arr[1] =s22;
     	arr[2] =s33;
     	arr[3] =m11;
     	arr[4] =m22;
     	arr[5] =m33;
     	
     	for(int i=0 ; i <arr.length ; i++) {
     		System.out.println(arr[i]);      //참조변수를 출력하는 것은 heap영역에 있는 곳의 주소를 가리키는 것이다.
    	}
     	
//    	------------------------------------------------------------------
    	
    	
    }
}

