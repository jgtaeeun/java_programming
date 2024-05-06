package javahong;

public class MyLinkedList_Hw3 {
private Node head;
	
	static class MyList extends MyLinkedList_Hw3{
			Node head = null;
		
	}
	
	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	
	public void insert(String data) {
		
		Node newNode = new Node(data);
		if (head == null) {
			head=newNode;
		}else {
			Node next=head;
			int a = (int) next.data.charAt(0);
			int b = (int)newNode.data.charAt(0);
			if (a<b) {
				
				while(next.link !=null) {
					next=next.link;
				}
				next.link=newNode;
			}
			else if(a>b){
				
				
				
				newNode.link=next;
				head=newNode;

			}
			else {
				a=(int) next.data.charAt(1);
				b=(int) newNode.data.charAt(1);
				if (a<b) {
					
					while(next.link !=null) {
						next=next.link;
					}
					next.link=newNode;
				}
				else if(a>b){
					
					
					
					newNode.link=next;
					head=newNode;

				}
			}
			
			
		}
	}
	public void printList() {
		if(head==null) {
			System.out.println("등록된 데이터가 없습니다.");
		}
		else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next=head;
			while(next!=null) {
				System.out.println(next.data);
				next=next.link;
			}
		}
	}
	public void delete(String data) {
		Node next=head;
		while(next!=null) {
		   if(next.data==data) {
			//삭제부분 코딩하기
			   head =next.link;
			   next=head;
			   next=next.link;
			   
		   }
		   else next=next.link;
		}
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList myList = new MyList();
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
