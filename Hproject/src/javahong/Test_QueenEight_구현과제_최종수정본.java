package javahong;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javahong.Stack4.EmptyGenericStackException;

class Point {
	private int ix;
	private int iy;

=======
class Point {
	private int ix;
	private int iy;

>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
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
<<<<<<< HEAD
=======
	
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
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
		return data.get(--top) ;
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
<<<<<<< HEAD
	public static void EightQueen(int[][] d) throws EmptyGenericStackException  {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(1000); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
	//	iy++;
		st.push(p);// 스택에 현 위치 객체를 push
		int origianl_ix= 0;
		int original_iy=0;
		int i=ix;//--------------------------------------------------------------------------------------------------
		int j=iy;//--------------------------------------------------------------------------------------------------
		while (!st.isEmpty()) // stack not empty
		{	
			
			
			i++; j = 0;
			
			if (i<8) {
			int newY = nextMove(d, i, j);
			
			if (newY == -1) {
				st.pop();
				
				for (int x=0; x<8 ;x++) {
					for (int y=0; y<8 ;y++) {
						d[x][y]=0;
					}
				}
				System.out.println();
			
			
				if ((origianl_ix>7)&&(original_iy>7) )  {break;}
				if (original_iy==7) {original_iy =0 ; origianl_ix++;}
				else original_iy++;
				d[origianl_ix][original_iy]=1; i=origianl_ix; j=original_iy;
			}
			else {
				//현재 위치를 스택에 저장, (g,h)는 다음 위치
				int g = i;
				int h = newY;
				Point tmp = new Point(g, h);
				d[g][h]=1;
				st.push(tmp);
				count++;
				i=g;  //--------------------------------------------------------------------------------------------------
			}
			
			if(count==8)  {
				numberSolutions +=1; 
				count=1; 
				showQueens(d);
				
				for (int x=0; x<8 ;x++) {
					for (int y=0; y<8 ;y++) {
						d[x][y]=0;
					}
				}
				System.out.println();
				
				if ((origianl_ix>=7)&&(original_iy>=7) )  {break;}
				if (original_iy>=7) {original_iy =0 ; origianl_ix++;}
				else original_iy++;
				d[origianl_ix][original_iy]=1; i=origianl_ix; j=original_iy;
				}
			
			}
		}
		System.out.println(numberSolutions);
=======
	public static void EightQueen(int[][] d)  {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[7-ix][7-iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		iy++;
		st.push(p);// 스택에 현 위치 객체를 push
		
		while (true) {
				if (count<64) {
					Point p1 = new Point(ix, iy);
					count++;
					st.push(p1);
					iy++;
					if (iy >=8) {iy=0; ix++;}
					continue;
				}

				if (st.isEmpty()==false){
				
					try {
						Point p_current=st.peek();
						ix=p_current.getix();
						iy=p_current.getiy();
						
						d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
						count=1;
//						
						st.pop();
						iy--;
						while (true) {
//						//iy가 0이 될 경우 , ix--해야함
							if (iy<0) {ix--; iy=7;}
							if (ix<0) break;
//							
							if (nextMove(d, ix, iy)!=-1) {
								d[ix][iy]=1;
								count++;
							}
							if (count==8) {numberSolutions+=1;}
							iy--;
						}
//						
//						
					} catch (EmptyGenericStackException e) {
//						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
					
				}	
			
				System.out.println(numberSolutions);
				
				break;
				
		}
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
	}
	
	public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		for (int i=0 ;i<8 ;i++) {
<<<<<<< HEAD
			   if (d[crow][i] == 1) 
=======
			   if (d[crow][i]!=0) 
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
				   return false; 
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
<<<<<<< HEAD
		
		for (int i=0 ;i<8 ;i++) {
			   if (d[i][ccol]==1) 
=======
		for (int i=0 ;i<8 ;i++) {
			   if (d[i][ccol]!=0) 
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
				   return false; 
		}
		return true;
	}
	//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
<<<<<<< HEAD
		int x = cx, y = cy;
		while (x>=0 && x <d.length && y>=0 && y <d.length) {
			x++;y--;
			if  (x>=0 && x <d.length && y>=0 && y <d.length) 
				if (d[x][y] == 1)
					return false;
		}
		x = cx;
		y = cy;
		while (x>=0 && x <d.length && y>=0 && y <d.length) {
			x--;y++;
			if  (x>=0 && x <d.length && y>=0 && y <d.length) 
				if (d[x][y] == 1)
					return false;
		}
		return true;
	}
		
	public static boolean checkDiagSE(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx, y = cy;
		while (x>=0 && x <d.length && y>=0 && y <d.length) {
			x++;y++;
			if (x>=0 && x <d.length && y>=0 && y <d.length)
				if (d[x][y] == 1)
					return false;
		}
		x = cx;
		y = cy;
		while (x>=0 && x <d.length && y>=0 && y <d.length) {
			x--;y--;
			if (x>=0 && x <d.length && y>=0 && y <d.length)
				if (d[x][y] == 1)
					return false;
		}
=======
		if (cx+cy==7)
			for(int x=0;x<8;x++){
				if  (d[x][7-x]!=0) return false;}
		else if (cy+cx==6)	
			for(int x=0;x<7;x++){
				if  (d[x][6-x]!=0) return false;}
		else if (cy+cx==5)	
			for(int x=0;x<6;x++){
				if  (d[x][5-x]!=0) return false;}
		else if (cy+cx==4)	
			for(int x=0;x<5;x++){
				if  (d[x][4-x]!=0) return false;}
		else if (cy+cx==3)	
			for(int x=0;x<4;x++){
				if  (d[x][3-x]!=0) return false;}
		else if (cy+cx==2)	
			for(int x=0;x<3;x++){
				if  (d[x][2-x]!=0) return false;}
		else if (cy+cx==1)	
			for(int x=0;x<2;x++){
				if  (d[x][1-x]!=0) return false;}
		else if (cy+cx==8)	
			for(int x=1;x<8;x++){
				if  (d[x][8-x]!=0) return false;}
		else if (cy+cx==9)	
			for(int x=2;x<8;x++){
				if  (d[x][9-x]!=0) return false;}
		else if (cy+cx==10)	
			for(int x=3;x<8;x++){
				if  (d[x][10-x]!=0) return false;}
		else if (cy+cx==11)	
			for(int x=4;x<8;x++){
				if  (d[x][11-x]!=0) return false;}
		else if (cy+cx==12)	
			for(int x=5;x<8;x++){
				if  (d[x][12-x]!=0) return false;}
		else if (cy+cx==13)	
			for(int x=6;x<8;x++){
				if  (d[x][13-x]!=0) return false;}
		else if ((cx+cy==0)||(cx+cy==14))return false;
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
		return true;
	}

	//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
<<<<<<< HEAD
	
=======
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		if (cx==cy)
			for(int x=0;x<8;x++){
				if ( d[x][x]!=0) return false;}
		else if (cx-cy==1)
			  for(int x=0;x<7;x++){
			   if     (d[x+1][x]!=0) return false;}
		else if (cy-cx==1)
			  for(int x=0;x<7;x++){
			   if (d[x][x+1]!=0) return false;}
		else if (cx-cy==2)
			  for(int x=0;x<6;x++){
			   if     (d[x+2][x]!=0) return false;}
		else if (cy-cx==2)
			  for(int x=0;x<6;x++){
			   if (d[x][x+2]!=0) return false;}
		else if (cx-cy==3)
			  for(int x=0;x<5;x++){
			   if     (d[x+3][x]!=0) return false;}
		else if (cy-cx==3)
			  for(int x=0;x<5;x++){
			   if (d[x][x+3]!=0) return false;}
		else if (cx-cy==4)
			  for(int x=0;x<4;x++){
			   if     (d[x+4][x]!=0) return false;}
		else if (cy-cx==4)
			  for(int x=0;x<4;x++){
			   if (d[x][x+4]!=0) return false;}
		else if (cx-cy==5)
			  for(int x=0;x<3;x++){
			   if     (d[x+5][x]!=0) return false;}
		else if (cy-cx==5)
			  for(int x=0;x<3;x++){
			   if (d[x][x+5]!=0) return false;}
		else if (cx-cy==6)
			  for(int x=0;x<2;x++){
			   if     (d[x+6][x]!=0) return false;}
		else if (cy-cx==6)
			  for(int x=0;x<2;x++){
			   if (d[x][x+6]!=0) return false;}
		else if ((cx-cy==7) || (cy-cx==7)) return false;
		return true;
	}
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
	//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkCol(d,x)&&checkRow(d,y)&&checkDiagSW(d,x,y)&&checkDiagSE(d,x,y)) return true;
		return false;
	}
	//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
<<<<<<< HEAD
		int y = col;
		while (y < d.length) {
			if (checkMove(d,row, y))
				return y;
			y++;
		}
=======
		if (checkMove(d,row, col))
			return col;
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
		return  -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i=0; i<8 ;i++) {
			for (int j=0; j<8 ;j++) {
				System.out.print(data[i][j]+ " ");}
			System.out.println();
		}
	}
	
<<<<<<< HEAD
	public static void main(String[] args) throws EmptyGenericStackException {
=======
	public static void main(String[] args) {
>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}



<<<<<<< HEAD
}
=======
}

>>>>>>> 9a7204ff4f07964c06dab7c76dc59cf5164edcb8
