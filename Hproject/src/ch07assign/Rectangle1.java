package ch07assign;

public class Rectangle1 implements Shape1{

	private int x1,y1,x2,y2;
	private int sum1=0,sum2=0;
	
	public Rectangle1(int x1, int y1, int x2, int y2) {
		this.x1 =x1;    this.y1 =y1;
		this.x2 =x2;    this.y2 =y2;
	}
	
	public double perimeter() {
		
		
		sum1 = 2 * (Math.abs(x2-x1) + Math.abs(y2-y1));
		return sum1;
		
	}
	public float area() {
		
        
         sum2 = Math.abs(x2-x1) * Math.abs(y2-y1);
		
		return sum2;
		
	}
	
	public String toString() {
		return "직사각형 둘레 길이 = " + sum1 + "직사각형 면적 = " + sum2 ;
	}
	
}
