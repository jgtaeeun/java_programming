package com.ruby.java.ch08.innerclass;

public class MyLinkedListTest {

	public MyLinkedListTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		MyLinkeddList myList = new MyLinkeddList();
		myList.print();

		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
		myList.print();
	}
}

