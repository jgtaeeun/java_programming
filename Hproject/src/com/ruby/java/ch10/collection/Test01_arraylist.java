package com.ruby.java.ch10.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01_arraylist {

	public Test01_arraylist() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Object arr[] = new Object[10];
		String s = "java";
		Integer i1 = 123;
		arr[0] = s;
		arr[1] = i1;
	
	//	int len = arr[0].length();//Object에 length()가 없다, String에 length()가 있다. //arr[0]은 Object타입이다.
		int len = ((String) arr[0]).length();

		
		
		ArrayList lst = new ArrayList();//<E>생략했다. 모든 타입의 객체들을 저장할 수 있다. 그러나 비추다! 아무것도 없으면 Object객체로 본다.
		String s2 = "java";              
		Integer i2 = 123;
		lst.add(s2);
		lst.add(i2);
		//lst.         lst.get(1). 했을 때 length가 없다.
		
		//. 다음에 나타나는 메소드를 확인
		//int len = (lst.get(0)).length();//ArrayList생성 시에 <E>가 없어서 Object이기에 length()가 없다      
		int len2 = ((String)lst.get(0)).length();

		System.out.println("len2 = " + len2);

		
		
		
		
		
		
		
		
		
		ArrayList<String> list = new ArrayList<String>();//String 객체로 제한 > 바람직한 형태이다 , new ArrayList<>() ;라고 해도 된다.
      //  list.add(i2); 제네릭이 String이므로 Integer i2는 안된다.
		//list.add(int index, E element); index는 생략가능하고 element는 String 제네릭이다.
		list.add("서울");		list.add("북경");		list.add("상해");
		list.add("서울");		list.add("도쿄");		list.add("뉴욕");
		int len_string = list.get(0).length(); //list는 string 객체이다 그 차이는(원인은?)
		
		for (String element : list) { //배열이 아닌 ArrayList에도 확장형 for 사용 가능하다 
			System.out.print(" " + element);
		}
		System.out.println();
		
		
		for (int i=0 ; i<list.size() ; i++ ) { //469쪽 Test01.java
			System.out.print(list.get(i));
		}
		System.out.println();
		
		
		list.add("런던");		list.add("로마");		list.add("방콕");
		list.add("북경");		list.add("도쿄");		list.add("서울");
		
	
		System.out.println("1 : " + list.toString()); //이 메소드는 ArrayList의 함수
		//list.toString();//to.선택하여 나타나는 함수 리스트 확인
		System.out.println("list.size() = " + list.size());
		
		list.add(1, "LA");//인덱스 1 위치에 LA 추가
		print(2, list);

		// int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));

		// boolean remove(Object o)
		list.remove("LA");//우측 객체가 좌로 이동하는 효과
		//list.remove(Object) 선택할 때 // Object o = "LA"; 으로 비유될 수 있다 

		Object obj2 = "LA";//obj2는 Object의 하위클래스 객체를 모두 가질 수 있다 
		print(5, list);

		// E remove(int index)
		list.remove(2);
		print(6, list);

		// boolean contains(Object o)
		System.out.println("7 : " + list.contains("LA"));//boolean contains(Object o)를 사용한다 
		
		// Object[] toArray() *** 중요
		Object obj[] = list.toArray();//list를 배열로 변경 - Object[] toArray()**********************************************
		System.out.println("8 : " + obj);//obj는 참조 변수이고 이를 toString()으로 변환
		System.out.println("8 : " + Arrays.toString(obj));//배열의 원소들을 스트링으로 변화
		// <T> T[] toArray(T[] a) - 해석할 수 있어야 한다 
		String cities[] = new String[5];
		//cities = list.toArray();//list를 배열로 변경 - 배열의 크기를 list 크기로 자동 조정
		cities = list.toArray(cities);//toArray([T[] a)의 return type은 T[]**********************************************
		//toArray()의 return type은 Object[] 교재 475 하단설명 
		//list.toArray();//확인
		System.out.println("9 : " + Arrays.toString(cities));

		// void clear()
		list.clear();
		print(10, list);//print(list.toString()) 동일

		// boolean isEmpty()
		System.out.println("11: " + list.isEmpty());

		list.add("파리");
		list.add("방콕");
		list.add("LA");

		// Arrays 클래스의 static <T> List<T> asList(T... a) *** 중요
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");//asList()는 배열을 입력받아 리스트를 만든다 **********************************************
		print(12, list2);

		// boolean addAll(Collection<? extends E> c) - ?는 wild card 사용 *** 중요
		list.addAll(list2);
		print(13, list);

		// boolean containsAll(Collection<?> c)
		System.out.println("14: " + list.containsAll(list2));

		// boolean retainAll(Collection<?> c)
		list.retainAll(list2);
		print(15, list);

		// boolean removeAll(Collection<?> c)
		list.removeAll(list2);
		print(16, list);
	}

	static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);//스트링으로 타입 변환후 toString() 호출하여 실행
		//System.out.println(n + " : " + list.toString());//동일한 효과
	}
}
