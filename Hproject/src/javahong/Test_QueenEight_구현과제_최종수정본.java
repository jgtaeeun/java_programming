package javahong;


import java.util.ArrayList;
import java.util.List;

import javahong.Stack4.EmptyGenericStackException;



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



public class Test_QueenEight_구현과제_최종수정본 {

public static void EightQueen(int[][] d) throws EmptyGenericStackException   {
		
	int count = 0;// 퀸 배치 갯수
	int numberSolutions = 0;
	int ix = 0, iy = 0;// 행 ix, 열 iy
	Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
	Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
	d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
	count++;
	ix++;
	st.push(p);
	
	while (true) {
		
	    if (st.isEmpty() && ix==0 && iy==8) {System.out.println("해: " + numberSolutions); break;}
	    	
	    else {
	    	int newY=nextMove(d, ix, iy); //1.0
	    	
	    	if (newY<0) {
	    		p=st.pop();
				ix=p.getix();
				iy=p.getiy();
				d[ix][iy]=0;
				count--;
				iy++;
				
				continue;
	    	}
	    	else {//넣을 수 있다
	    		d[ix][newY]=1;
	    		//System.out.println("next좌표"+ix+","+newY);
	    		count++;
	    		//iy=newY;
	    		st.push(new Point(ix, newY));
	    		ix++; iy=0;
	    		//st.dump();
	    		if (count == d.length) {
	    			numberSolutions++;
	    			p = st.pop();
	    			ix=p.getix();
					iy=p.getiy();
					count--;
					d[ix][iy] = 0;
					iy++;
				
					continue;
	    		}
	    	
	    	}
	    }
	}
	

		
	}
	
	public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		for (int i=0 ;i<8 ;i++) {
			   if (d[crow][i] == 1) 
				   return false; 
		}
		return true;
	}
	public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		for (int i=0 ;i<8 ;i++) {
			   if (d[i][ccol]==1) 
				   return false; 
		}
		return true;
	}
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
	    int x = cx, y = cy;

	    while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	        x++;
	        y--;
	        if (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	            if (d[x][y] == 1)
	                return false;
	        }
	    }

	    x = cx;
	    y = cy;
	    while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	        x--;
	        y++;
	        if (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	            if (d[x][y] == 1)
	                return false;
	        }
	    }

	    return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
	    int x = cx, y = cy;
	    while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	        x++;
	        y++;
	        if (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	            if (d[x][y] == 1)
	                return false;
	        }
	    }
	    x = cx;
	    y = cy;
	    while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	        x--;
	        y--;
	        if (x >= 0 && x < d.length && y >= 0 && y < d.length) {
	            if (d[x][y] == 1)
	                return false;
	        }
	    }
	    return true;
	}
	
	//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkCol(d,y)&&checkRow(d,x)&&checkDiagSW(d,x,y)&&checkDiagSE(d,x,y)) return true;
		return false;
//		
//		
//		if(!checkCol(d,x)) return false;
//		else if (!checkRow(d,x)) return false;
//		else if (checkDiagSW(d,x,y)) return false;
//		else if(checkDiagSE(d,x,y)) return false;
//		return true;
	}
	//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		int y = col;
		while (y < d.length) {
			if (checkMove(d,row, y))
				return y;
			y++;
		}
		return  -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i=0; i<8 ;i++) {
			for (int j=0; j<8 ;j++) {
				System.out.print(data[i][j]+ " ");}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws EmptyGenericStackException {

		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}

