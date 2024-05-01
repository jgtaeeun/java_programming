package com.ruby.java.ch06;

public class Member { 
     private String name;
     private int age;
     
     public Member() {
    	// name="guest";
    	// age=0;
    	 this("guest");   //이함수는  Member(String name) 호출  
    	 
     }
     
    
     public Member(String name) {
    	//this.name=name;
    	//age=0;
    	 this(name,0);  //이함수는  Member(String name, int age)  호출
     }
     
     public Member(String name, int age) {
    	 this.name=name;
    	 this.age=age;
     }
     
     
    public String toString() {
   	 return name+","+age;
    }
  
     public static void main(String [] args) {
    	     
              Member m1 = new Member();	 //인스턴스 선언 heap,stack
              Member m2 = new Member("hong");
             
     
              Member m3 = new Member("hong",11);
              System.out.println(m3.toString());
     }
     
}
