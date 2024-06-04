package Chap4_스택큐;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Queue4 {
	private List<Integer> que;//원형큐로 구현하지 않는다 
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//--- 생성자(constructor) ---//
	public Queue4(int maxlen) {
		front=rear=0;
		capacity=maxlen;
		
		try {
			que = new ArrayList <Integer> ();
		}
		catch (OutOfMemoryError e) {
			capacity=0;
		}
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
		if (front==rear && front==0 && que.size() == capacity) {
			new OverflowQueueException();
		}
		else if  ( que.size() != capacity) {
			que.add(x);
			rear+=1;
			front=que.size()-rear;
		}
		
		return x;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (front==rear && front==0 && que.size() == 0) {
			new EmptyQueueException();
		}
		else if (que.size() <= capacity) {
			que.remove(front);
			front+=1;
		}
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {

	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {

	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {

	}
}



public class train_실습4_3_1정수선형큐_리스트 {

	public train_실습4_3_1정수선형큐_리스트() {
		// TODO Auto-generated constructor stub
	}

}
