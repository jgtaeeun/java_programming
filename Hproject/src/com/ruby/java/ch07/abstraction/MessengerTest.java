package com.ruby.java.ch07.abstraction;

public class MessengerTest {

	public MessengerTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       IPhoneMessenger iphone = new  IPhoneMessenger();
       iphone.setMessage("testiphone");
       System.out.println( iphone.getMessage());
       
       GalaxyMessenger galaxy = new GalaxyMessenger ();
       galaxy.setMessage("testgalaxy");
       System.out.println(  galaxy.getMessage());
     
	}

}
