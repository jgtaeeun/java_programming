package com.ruby.java.ch06;

class Count{
 public static int totalCount;
 private int num;
 public Count() {
	 num = 1;
	 totalCount++;
	 
	
 }
 int getter() {
		return num; 
	 }
 void setter(int a) {
		 num=a;
	 }
}





public class CountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println(Count.totalCount);
           Count c1 = new Count();  //생성자  
           
           Count c2 = new Count();  //생성자
           Count c3 = new Count();  //생성자
           System.out.println(c3.totalCount);
           System.out.println(c1.totalCount);
           System.out.println(Count.totalCount);
           //System.out.println(  c1.num++); //int num일때
         
           //private int num일 때  
           c1.setter(2);
           System.out.println( c1.getter());
		}
}

