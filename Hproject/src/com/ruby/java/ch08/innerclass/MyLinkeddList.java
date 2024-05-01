package com.ruby.java.ch08.innerclass;

public class MyLinkeddList {

	public MyLinkeddList() {             //-------------------기본생성자
		// TODO Auto-generated constructor stub
	}
	private Node head = null;       //----------------------필드

	private class Node {                  //--------------------내부클래스(필드, 생성자)
		private String data;         
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	
	public void add(String data) {           //---------------------메서드
		Node newNode = new Node(data);           //내부클래스 인스턴스 객체 생성
		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}
	
	
	public void print() {                                // ---------------------메서드
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	
	
}
