package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {

	public Test16() {
		// TODO Auto-generated constructor stub
	}
	

		  public static void main(String[] args) {

		    try(ObjectInputStream in = 
		        new ObjectInputStream(new FileInputStream("user.txt"))) {
		      Userbean user = (Userbean) in.readObject();
		      System.out.println(user);

		    } catch(Exception e) {
		      e.printStackTrace();
		    }
		    
		   
}
}


