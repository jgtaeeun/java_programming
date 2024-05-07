package com.ruby.java.ch13.nonGen;

class Bag { //generic 대신에 Object class 사용한 방법
	private Object thing;

	public Bag(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book {
}
class PencilCase {
}

class Notebook {
}

public class BagTest {

	public static void main(String[] args) {
		Bag bag = new Bag(new Book());
		Bag bag2 = new Bag(new PencilCase());
		Bag bag3 = new Bag(new Notebook());

		Book book = (Book) bag.getThing();       //down casting
		PencilCase pc = (PencilCase) bag2.getThing();
		Notebook nb = (Notebook) bag3.getThing();

		bag = bag2;//에러가 발생하지 않지만 잘못된 코드이다. bag은 Book, bag2은 PencilCase이기 때문이다.
		
		/*Book book =  bag.getThing();               .getThing()의 return타입은 Object이다.  Object 밑에 Book이 있다. Object =  Book 은 되고 Book=Object는 안됨
		PencilCase pc =  bag2.getThing();                Person밑에 Student있을 때 Person =Student 됨/Student=Person은 안됨
		Notebook nb = bag3.getThing();*/
	}
}