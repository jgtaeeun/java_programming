package com.ruby.java.test1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArmorSuit amor = new ArmorSuit();
      
      //ArmorSuit의 메소드
      amor.takeOff();
      amor.isFly = false;
      System.out.println();
      amor.takeOff();
      
//      amor.land();
//      amor.shootLaser();
//      amor.launchMissile();
      //ArmorSuit의 필드
      System.out.println("amor name : " + amor.name);
      System.out.println("amor height : " + amor.height);
      System.out.println("amor weight : " + amor.weight);
      System.out.println("amor color : " + amor.color);
      System.out.println("amor isFly : " + amor.isFly);
      
      
	}

}
