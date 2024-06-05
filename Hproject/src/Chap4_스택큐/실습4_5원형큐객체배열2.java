package Chap4_스택큐;

import java.util.Random;
import java.util.Scanner;

class Point5 {
	private int ix;
	private int iy;
	
	public Point5(int x, int y) {
		this.ix = x;
		this.iy = y;
	}

	@Override
	public String toString() {
		return "point("+ix+","+iy+")";
	}

	@Override
	public boolean equals(Object p) {
		 return this.equals(p);
	}
}


class CircularQueue {
	static int QUEUE_SIZE = 0;
	Point5[] que;//배열로 객체원형 큐 구현
	int front, rear;
	static boolean isEmptyTag;
	//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String msg) {
			super(msg);
		}
	}

	//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException(String msg) {
			super(msg);
		}
	}
	
	public CircularQueue(int count) {
		front=rear=0;
		isEmptyTag=true;
		QUEUE_SIZE = count;
		
		try {
			que = new Point5 [QUEUE_SIZE];
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	void push(Point5 it) throws OverflowQueueException{
		if(!isFull()) {
		
		que[rear]=it;
		rear=(rear+1)%QUEUE_SIZE;
		isEmptyTag=false;
		}
	}

	Point5 pop() throws EmptyQueueException{
		Point5 p=null;
		if(!isEmpty()) {
			
		
		p=que[front];
		front=(front+1)%QUEUE_SIZE;
		
		if (rear==front)
			isEmptyTag=true;
		
		}
		return p;
	}

	 void clear() throws EmptyQueueException{
		if(!isEmpty()) {
				 
		front=rear=0;
		isEmptyTag=true;}
	}

	//--- 큐의 크기를 반환 ---//
		public int getCapacity() {
			return QUEUE_SIZE;
		}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
		public int size() {//front, rear를 사용하여 갯수를 size로 계산
			int queueSize = -1;
			if(isEmpty()==true) {
				queueSize = 0;
			}
			else {
			if (rear>front) queueSize = rear-front;
			else if (rear <front) queueSize = rear + (QUEUE_SIZE-front);
			else if (rear==front && isEmptyTag==false ) queueSize = QUEUE_SIZE;
			}
			return queueSize;
		}
		//--- 원형 큐가 비어있는가? --- 수정 필요//
		public boolean isEmpty() {
				if (rear==front && isEmptyTag==true ) return true;
				else  return false;
		}

	//--- 원형 큐가 가득 찼는가? --- 수정 필요//
		public boolean isFull() {
			if (rear==front && isEmptyTag==false ) return true;
			else  return true;
		}

		public void dump() throws EmptyQueueException{
			if (!isEmpty())
					
			{
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
		public  Point5 peek() throws EmptyQueueException {
			if (!isEmpty()) {
				
			return que[front];
			}
			return null;
		}
}



public class 실습4_5원형큐객체배열2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		CircularQueue oq = new CircularQueue(4); // 최대 4개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point5 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5) clear  (0)종료: ");
			int menu = stdIn.nextInt();
			if (menu == 0)
				break;
			switch (menu) {
			case 1: // 인큐

				rndx = random.nextInt(20);

				rndy = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
				p = new Point5(rndx,rndy);
				try {
					oq.push(p);
					System.out.println("push: size() = "+ oq.size());
				} catch(CircularQueue.OverflowQueueException e) {
					System.out.println("queue이 full입니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 디큐
				try {
					p = oq.pop();
					System.out.println("pop: size() = "+ oq.size());
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 4: // 덤프

				break;
			case 5: //clear
				
				break;
		}
		}
	}

}
