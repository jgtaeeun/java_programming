package javahong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javahong.Stack5.EmptyGenericStackException;

class Items {
	int x;
	int y;
	int dir;

	
	public Items(int x, int y,  int dir) {

		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	public String toString() {
		return "("+x+","+y+","+dir+")";
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
}




enum Directions {N, NE, E, SE, S, SW, W, NW ;}
	



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
		 if (top <= 0) {
		        throw new EmptyGenericStackException("pop: stack empty"); // 예외를 던지도록 수정
		 }

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
	
//	offsets moves[8];
	static int maze[][]=new int[14][17];
	static int mark[][]=new int[14][17];

	public static void show(String s, int[][] a) {
		System.out.println("<" +s+">");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void path(int maze[][], int mark[][], int m, int p) throws EmptyGenericStackException {
		Random random = new Random();
		int ix = 1, iy = 1, dir =2;// 행 ix, 열 iy
		Stack5 st = new Stack5(100); // 100개를 저장할 수 있는 스택을 만들고
		Items p1 ;
		
		p1 = new Items(ix, iy, dir);// 현 위치를 객체로 만들고
		st.push(p1);
		
		while (!st.isEmpty()) {

			p1 = st.pop();
			ix = p1.x; iy = p1.y; dir = p1.dir;
			mark[ix][iy] = 0;
			while (dir < 8) {
				int g = ix + moves[dir].a;
			    int h = iy + moves[dir].b;
			  //도착 위치 좌표일 경우,
			    if ((g == m) && (h == p))  { 
			    	mark[ix][iy] = 1; mark[g][h] = 1;  
			    	System.out.println("미로 탈출"); 
			    	st.clear(); break;}
			      // 미로 범위 안에 있고, 벽이 아니며 방문하지 않았다면
		        if ((maze[g][h] == 0 && mark[g][h] == 0)) {
		        	mark[ix][iy] =1;
		        	dir++;
		        	p1 = new Items(ix, iy, dir);
		        	st.push(p1);

		        	ix=g;
		        	iy=h;
		        	dir=0;//N
		        }
		        else {
			          dir++;
		        }
			}
			//mark[ix][iy]=0;
		}
		
		    

	}
	
	
	public static void main(String[] args) throws EmptyGenericStackException  {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		
		int input[][]= {

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
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },};
		
		

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

		
		int i =0;

				//maze를 input과 똑같이 
		for( i=0 ;i<maze.length;i++) {
				for (int j=0;j<maze[0].length;j++) {
					if (i == 0 || j == 0 || i == maze.length-1 || j == maze[0].length-1)
						maze[i][j] = 1;
					else
						maze[i][j]=input[i-1][j-1];
				}
				//System.out.println("test");
		}	

				//mark와 maze 똑같이
		for( i=0;i<14;i++) {
			for(int j=0;j<17;j++) {
					mark[i][j]=0;
					}

		}

		show("maze[14,17]::", maze);
		show("mark[14,17]::", mark);

		path(maze, mark, 12, 15);
		show("maze[14,17]::", maze);
		show("mark[14,17]::", mark);

		
		}	

}
