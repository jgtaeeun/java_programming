package javahong;

public class MyLinkedList {
	private Node head;
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
	}
	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	public void insert(String data) {
            Node newNode=new Node(data);
            if (head ==null) head=newNode;
            else {
            	Node next = head;
            	while(next.link != null) {
            		next=next.link;
            	}
            	next.link=newNode;
            }
	}
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		}
		else {
			System.out.println("등록된 데이터가 없습니다.");
			Node next = head;
			while(next!= null) {
				System.out.println(next.data);
				next=next.link;
			}
		}
	}
	public void delete(String data) {

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList myList = new MyLinkedList();
		myList.printList();

		myList.insert("JAVA");
		myList.insert("HTML");
		myList.insert("CSS");
		myList.insert("Javascript");
		myList.printList();
		myList.delete("CSS");
		myList.printList();
	}

}
