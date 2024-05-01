package com.ruby.java.ch10;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Test05 {

	public Test05() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();

		list.add("서울"); //add(int index, E element)일 때, index생략할 수 있다. 이 때 데이터는 가장 오른쪽에 저장된다.
		list.add("북경");
		list.add("상해");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "\t");
		}

		list.add(1, "LA");
		print(1, list);
		list.addFirst("런던");
		print(2, list);
		list.addLast("서울");
		print(3, list);

		list.offer("파리");
		print(4, list);
		list.offerFirst("로마");
		print(5, list);
		list.offerLast("베른");
		print(6, list);

		System.out.println("7 : " + list.peek());
		System.out.println("8 : " + list.peekFirst());
		System.out.println("9 : " + list.peekLast());

		list.poll();
		print(10, list);
		list.pollFirst();
		print(11, list);
		list.pollLast();
		print(12, list);

		list.push("제주");
		print(13, list);
		System.out.println("14 : " + list.pop());

		System.out.println("15 : " + list.get(3));
		System.out.println("16 : " + list.getFirst());
		System.out.println("17 : " + list.getLast());

		System.out.println("18 : " + list.indexOf("서울"));
		System.out.println("19 : " + list.lastIndexOf("서울"));

		list.removeFirst();
		print(20, list);
		list.removeLast();
		print(21, list);
		list.remove(3);
		print(22, list);
		list.remove("LA");
		print(23, list);

		List<String> list2 = Arrays.asList("북경", "상해");
		list.addAll(list2);

		Object obj[] = list.toArray();               //list를 배열도 만들어 주기 위한 .toArray()
		System.out.println("24 : " + Arrays.toString(obj));

		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("25 : " + Arrays.toString(cities));

		list.removeAll(list2);
		print(26, list);
		//list.sort(null);
		
		
	}
	
	public static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);
	}
}
