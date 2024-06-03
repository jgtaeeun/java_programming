package Chap4_스택큐;


import java.util.Scanner;

class IntStack3 {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException(String message) {
			super(message);
		}
	}

//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException(String message) {
			super(message);
		}
	}
	
//--- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
			if (ptr >= capacity) // 스택이 가득 참
				throw new OverflowIntStackException("push: stack overflow");
			return stk[ptr++] = x;
		}

}

public class 실습4_2정수스택 {

	public 실습4_2정수스택() {
		// TODO Auto-generated constructor stub
	}

}
