package Chap4_스택큐;
import java.util.Random;
import java.util.Scanner;

import Chap4_스택큐.Queue4.EmptyQueueException;
import Chap4_스택큐.Queue4.OverflowQueueException;


/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */


class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean emptyTag;

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception() {
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
		emptyTag=true;
		try {
			que=new int [capacity];
		}
		catch (OutOfMemoryError e){
			capacity=0;
		}
	}
	
	//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntQueue3Exception {
		//큐 배열이 다 채워져 있을 경우,
		if (front==rear && emptyTag==false) {
			new OverflowIntQueue3Exception();
		}
		else {
			que[rear]=x;
			emptyTag=false;
			rear=(rear+1)%capacity;

		}
		
		return x;
	}
	
	

	//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		//큐 배열이 비워져 있을 경우,
		
		int x =0;
		
		if(front==rear && emptyTag==true ) {
				new EmptyIntQueue3Exception();
		}
		else {
			x = que[front];
			
			front=(front+1)%capacity;
			
			if (front==rear) {
				emptyTag=true;
			}
		
		}
		return 	x;
	}
	
	//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
	
		
		if(front==rear && emptyTag==true ) {
			new EmptyIntQueue3Exception();
		}
		
		return 	que[front];
	}
	
	//--- 큐를 비움 ---//
	public void clear() {
			front=rear=0;
			emptyTag=true;
	}
	
	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		if(front==rear && emptyTag==true ) {
			new EmptyIntQueue3Exception();
		}
		if (rear > front) return rear-front;
		else if (rear < front) return rear+(capacity-front);
		else if (front==rear && emptyTag==false ) return capacity;
		return 0;
	}
	
	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		if(isEmpty()==true) {
			new EmptyIntQueue3Exception();
		}
		else {
			for (int i=0 ; i<que.length ; i++) {
				if (que[i]==x) return i ;
			}
			
		}
		return -1;
	}
	
	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
			return capacity;
	}
	
	//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		if (emptyTag==true && front==rear)
			return true ;
		else return false;
	}
	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		if (emptyTag==false && front==rear)
			return true ;
		else return false;
	}
	
	
	//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if(emptyTag==true && front==rear){
			new EmptyIntQueue3Exception();
			System.out.println("큐가 비어있습니다.");
		}
		else {
			System.out.println("큐 데이터 프런트->리어 순으로 출력");
				if(front==0) {
					for (int i=front ; i<que.length ; i++) System.out.print(que[i]+" ");
				}
				else if (front==1){
					for (int i=front ; i<que.length+1 ; i++) System.out.print(que[i%que.length]+" ");
				}else if (front==2) {
					for (int i=front ; i<que.length+2 ; i++) System.out.print(que[i%que.length]+" ");
				}
				else {
					for (int i=front ; i<que.length+3 ; i++) System.out.print(que[i%que.length]+" ");
				}
				
			}
		}
	
}

public class train_실습4_3_2정수원형큐_배열 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 4개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(1,21);
				System.out.print("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(Chap4_스택큐.IntQueue3.OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (Chap4_스택큐.IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (Chap4_스택큐.IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}//switch
		}//while
	}//main
}//class


