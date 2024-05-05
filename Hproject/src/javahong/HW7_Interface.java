package javahong;

interface Shape1 {
	public double perimeter();
	public float area();
}

class Triangle1 implements Shape1 {
	private int x1,y1,x2,y2,x3,y3;
	private double sum1_1=0 ,sum1_2=0 ,sum1_3=0 ; //선분의 길이
	 
	
	public Triangle1(int x1,int y1,int  x2,int  y2,int  x3,int y3) {
		this.x1=x1;  this.y1=x1;
		this.x2=x2;  this.y2=y2;
		this.x3=x3;  this.y3=y3;
	}
	
    private void calc() {
		
		
		sum1_1= Math.sqrt(Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
		sum1_2=	Math.sqrt(Math.pow((x2-x3),2) +Math.pow((y2-y3),2));
		sum1_3= Math.sqrt(Math.pow((x3-x1),2) + Math.pow((y3-y1),2));
		
		
	}
	
	@Override
	public double perimeter() { //구글링으로 계산식 찾아서 구현
		double sum1 = 0.; 
		calc() ;

		sum1 =sum1_1 +sum1_2 +sum1_3;
		return sum1;}
	
	@Override
	public float area() {
		float sum2 = 0.f; // 둘레와 넓이
        calc() ;
		
		
		double sub = (sum1_1 + sum1_2 + sum1_3)/2 ;
		
		sum2 = (float) ( Math.sqrt(  sub * Math.abs(sub-sum1_1) *Math.abs(sub-sum1_2) * Math.abs(sub-sum1_3)   ) );
		return sum2;
	}
}


class Rectangle1 implements Shape1 {
	int x1,y1,x2,y2,x3,y3,x4,y4;
	int width=0, height = 0; //x축의 길이, y축의 길이
	public Rectangle1(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4) {
		this.x1 = x1;  this.y1 = y1;
		this.x2 = x2;  this.y2 = y2;
		this.x3 = x3;  this.y3 = y3;
		this.x4 = x4;  this.y4 = y4;
		
   }
	private void calc() { //사각형의 선분의 길이 x축y축
		width= Math.abs(x2-x1);
		height= Math.abs(y4-y2);
	}
	public double perimeter() {
		double result1=0; //선분의 길이
		
		calc();
		result1 = (double) 2 *(width + height);
		return result1;
	}
	public float area() {
		float result2=0; //넓이
		
		calc();
		result2 = (float) width * height;
		return result2;
	}
}
class Square1 extends Rectangle1 {

	int side;
	public Square1(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4, int side) {
		super(x1, y1,  x2,  y2, x3, y3, x4, y4);
		this.side = side;
	}
}




public class HW7_Interface {

	public HW7_Interface() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape1 t = new Triangle1(1,2,3,4,5,6);
		Shape1 r = new Rectangle1(1,2,3,2,1,5,3,5);
		Shape1 s = new Square1(1,2,3,2,1,5,3,5,3);
		System.out.println("삼각형 둘레 길이 = " + t.perimeter());
		System.out.println("삼각형 면적 = " + t.area());
		System.out.println("사각형 둘레 길이 = " + r.perimeter());
		System.out.println("사각형 면적 = " + r.area());
	}

}
