package Chap6_Sorting;

import java.util.ArrayList;
import java.util.List;

import Chap6_Sorting.Stack4.EmptyGenericStackException;



class Point {
	private int ix;
	private int iy;


	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "("+ix+","+iy+")";
	}

	@Override
	public boolean equals(Object p) {
		return this.equals(p);
	}

	public int getix() {
		return ix;
	}
	public int getiy() {
		return iy;
	}
}

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		this.capacity=capacity;
		top=0;
		
		try {
			data=new ArrayList<Point>();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (top >= capacity) // 스택이 가득 참
			System.out.println("push: stack overflow"); 
		data.add(x);
		top++; // Increment top after adding an element
		return true; 

	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (top <= 0) // 스택이 비어있음
			System.out.println("pop: stack empty");
		top--;
		return data.remove(top); 
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (top <= 0) // 스택이 비어있음
			System.out.println("pop: stack empty");
		return data.get(top-1) ;
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++) {
				System.out.print(data.get(i) + " ");
				System.out.println();
			}
			
		}
	}
}




public class 실습6_10_1QuickSort2_개량 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) throws EmptyGenericStackException {

		Stack4 st = new Stack4(10);
		Point pt = new Point(left, right);
		st.push(pt);
		while (!st.isEmpty()) {
			Point rt = st.pop();
			int pl = left = rt.getix();
			int pr = right = rt.getiy();
			int mp = a[(pr + pl) / 2];

			do {
				while (a[pl] < mp)
					pl++;
				while (a[pr] > mp)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			System.out.println("left = " + left + "right = " + right);
			for (int i = left; i <= right; i++)
				System.out.print(" " + a[i]);
			System.out.println();
			if (left < pr) {
				Point pt2 = new Point(left, pr);
				st.push(pt2);

			}
			if (pl < right) {
				Point pt2 = new Point(pl, right);
				st.push(pt2);

			}

		}
	}
	static void showData(int[] d) {
		System.out.println();
	    for (int i = 0; i < d.length; i++)
	        System.out.print(d[i] + " ");
	    System.out.println();
	}
	public static void main(String[] args) throws EmptyGenericStackException {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		showData(x);

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		showData(x);
		
	}
}