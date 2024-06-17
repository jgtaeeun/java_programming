package javahong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javahong.Stack5.EmptyGenericStackException;

enum Directions {N, NE, E, SE, S, SW, W, NW};

class Items {
	int x;
	int y;
	int dir;

	public Items (int x, int y, int  dir) {
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	public String toString() {
		return "("+x+","+y+","+dir+")";
	}
	
	public boolean equals(Object p) {
		return this.equals(p);
	}

}
	

class Offsets {
	 int a;
	 int b;
	
	
		
	public Offsets (int a, int b) {
			this.a=a;
			this.b=b;
	}
	public String toString() {
			return "("+a+","+b+")";
	}
		
	
	public boolean equals(Object p) {
			return this.equals(p);
	}
}

class Stack5 {
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

	private List<Items> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack5(int capacity) {
		this.capacity=capacity;
		top=0;
		
		try {
			data=new ArrayList<Items>();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Items x) throws OverflowGenericStackException {
		if (top >= capacity) // 스택이 가득 참
			System.out.println("push: stack overflow"); 
		data.add(x);
		top++; // Increment top after adding an element
		return true; 

	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items pop() throws EmptyGenericStackException {
		if (top <= 0) // 스택이 비어있음
			System.out.println("pop: stack empty");
		top--;
		return data.remove(top); 
	}
	
	public Items peek() throws EmptyGenericStackException {
		if (top <= 0) // 스택이 비어있음
			System.out.println("pop: stack empty");
		return data.get(top-1) ;
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Items x) {
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
public class Test_실습_미로찾기문제 {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
	
	
	public static void show(String s, int[][] a) {
		System.out.println("<" +s+">");
		for(int i=1;i<13;i++) {
			for(int j=1;j<16;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	

	static void path(int maze[][], int mark[][], int m, int p) throws EmptyGenericStackException {
		 
		  
		int ix = 1, iy = 1, dir =2;// 행 ix, 열 iy
		Stack5 st = new Stack5(100); // 100개를 저장할 수 있는 스택을 만들고
		Items p1 ;
		int g=0 ;int h=0 ;
		while (true) {
			p1 = new Items(ix, iy, dir);// 현 위치를 객체로 만들고
			st.push(p1);
			
			
		    
			//도착 위치 좌표일 경우,
		    if ((g == m) && (h == p))  { mark[g][h] = 1; System.out.println("미로 탈출"); break;}
		    
		    mark[g][h] = 1;
		    
		    
		    for (Directions direction : Directions.values()) {
	           g = ix + moves[direction.ordinal()].a;
	           h = iy+ moves[direction.ordinal()].b;

	            // 미로 범위 안에 있고, 벽이 아니며 방문하지 않았다면
	           if (!(maze[g][h] == 0 && mark[g][h] == 0)) {
	        	   p1=st.pop();
	        	   
	            }
	        }
		    

		}
	}
	
	
	  
	

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
		

//Directions {N, NE, E, SE, S, SW, W, NW}
//             0  1  2  3   4   5  6   7		
		for (int i=0;i<14;i=i+13)
			for(int j=0;j<17;j++) {
				maze[i][j]=1;
		}
		for (int i=0;i<17;i=i+16)
			for(int j=0;j<14;j++) {
				maze[j][i]=1;
		}
		//maze를 input과 똑같이 
		for(int i=1 ;i<13;i++) {
			for (int j=1;j<16;j++) {
				maze[i][j]=input[i-1][j-1];
			}
			
		}
		//mark와 maze 똑같이
		for(int i=0;i<14;i++) {
			for(int j=0;j<17;j++) {
				mark[i][j]=maze[i][j];
			}
		}
		

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);


	}
}
