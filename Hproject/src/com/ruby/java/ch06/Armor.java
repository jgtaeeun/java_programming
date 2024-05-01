package com.ruby.java.ch06;
//
//public class Student{
//	private String sname;
//	private int age;
//}

public class Armor {
     private String name;
     private int height;
     
     
     public String getName() {   //게터
    	 return name;
     }
     
     public void setName(String value) { //세터
    	 name=value;
     }
     public static void main(String[] args) {
    	 //1. 생성자, 게터, 세터
    	 Armor a = new Armor();   //생성자
    	 a.setName("Kim");        
    	 System.out.println(a.getName());  
    	 //2. 배열 생성자, heap, stack
    	 Armor b[] = new Armor[10]; //배열 생성자
    	 for (int i=0 ;  i<b.length ; i++) {
    		 b[i]= new Armor();
    	 }
    	 
//    	 int []array = new int [10]; //정수형 배열 생성
    	 //a.name = "kim";  //private이기에 main에서는 name 접근 못 한다.
    	   	 
    	 
//    	 Student s = new Student();
    	// s.sname ="hong";                  //Student 클래스는 외부에서 선언됨
    	 
    	 //3. suit1은 stack이고 setName과 getName은 heap이고 각각의 함수코드는 code이다.
    	Armor suit1 = new Armor();
//        suit1 = null;
    	suit1.setName("mark6");
        System.out.println(suit1.getName());       
        System.out.println(suit1);  
    	 
     }
}
