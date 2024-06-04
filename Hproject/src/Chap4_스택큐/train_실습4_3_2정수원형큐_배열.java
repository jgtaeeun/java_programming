package Chap4_스택큐;
import java.util.Random;
import java.util.Scanner;


/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */


class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception(String msg) {
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception() {
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		capacity = maxlen;
		front=rear=0;
		
		try {
			que=new int [capacity];
		}
		catch (OutOfMemoryError e){
			capacity=0;
		}
		
	}

	
}

public class train_실습4_3_2정수원형큐_배열 {

	public train_실습4_3_2정수원형큐_배열() {
		// TODO Auto-generated constructor stub
	}

}
