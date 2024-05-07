package edu;

interface Shape{                  
	public double perimeter();
	public float area();
	@Override
	String toString();         
}


class Triangle implements Shape {
	private int x1,y1,x2,y2,x3,y3;
	private double sum1_1=0 ,sum1_2=0 ,sum1_3=0 ; //선분의 길이
	 
	
	public Triangle(int x1,int y1,int  x2,int  y2,int  x3,int y3) {
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
	@Override
	public String toString() {
		return "("+x1+", "+y1+", "+x2+", "+y2+", "+x3+", "+y3+")";
	}
	
}
class Rectangle implements Shape {
	int x1,y1,x2,y2,x3,y3,x4,y4;
	int width=0, height = 0; //x축의 길이, y축의 길이
	public Rectangle(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4) {
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
		result1 = (double) 2 *width * height;
		return result1;
	}
	public float area() {
		float result2=0; //넓이
		
		calc();
		result2 = (float) width * height;
		return result2;
	}
	
	@Override
	public String toString() {
		return "("+x1+", "+y1+", "+x2+", "+y2+", "+x3+", "+y3+", "+x4+", "+y4+")";
	}
}


class Square extends Rectangle {

	int side;
	public Square(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4, int side) {
		super(x1, y1,  x2,  y2, x3, y3, x4, y4);
		this.side = side;
	}
	
	
}


class Pentagon implements Shape {
	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5;
	
	
	public  Pentagon(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4,int x5, int y5) {
		this.x1 = x1;  this.y1 = y1;
		this.x2 = x2;  this.y2 = y2;
		this.x3 = x3;  this.y3 = y3;
		this.x4 = x4;  this.y4 = y4;
		this.x5 = x5;  this.y5 = y5;
		
   }
	
  
	
   public double perimeter() {
	    double sum1=0;
	    double sum1_1=0 ,sum1_2=0 ,sum1_3=0, sum1_4=0,sum1_5=0 ; //선분의 길이
	    sum1_1= Math.sqrt(Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
		sum1_2=	Math.sqrt(Math.pow((x1-x3),2) +Math.pow((y1-y3),2));
		sum1_3= Math.sqrt(Math.pow((x2-x4),2) + Math.pow((y2-y4),2));
		sum1_4= Math.sqrt(Math.pow((x4-x5),2) + Math.pow((y4-y5),2));
		sum1_5= Math.sqrt(Math.pow((x5-x3),2) + Math.pow((y5-y3),2));
	   
	    sum1= sum1_1+sum1_2+sum1_3+sum1_4+sum1_5;
	    return sum1;
   }
   public float area(){
	   
	   float sum2=0.f;
	   //삼각형넓이
	   double tri1= Math.sqrt(Math.pow((x5-x3),2) + Math.pow((y5-y3),2));
	   double tri2= Math.sqrt(Math.pow((x5-x4),2) + Math.pow((y5-y4),2));
	   double tri3= Math.sqrt(Math.pow((x3-x4),2) + Math.pow((y3-y4),2));
	   
	   double sub1 = ( tri1 +  tri2+  tri3)/2 ;
		
	   float sum2_1 =   (float)( Math.sqrt(  sub1 * Math.abs(sub1-tri1 ) *Math.abs(sub1-tri2) * Math.abs(sub1-tri3)   ) );
	   
	   //삼각형넓이
	   double tri4= Math.sqrt(Math.pow((x1-x3),2) + Math.pow((y1-y3),2));
	   double tri5= Math.sqrt(Math.pow((x1-x4),2) + Math.pow((y1-y4),2));
	   double tri6= Math.sqrt(Math.pow((x3-x4),2) + Math.pow((y3-y4),2));
	   
	   double sub2 = ( tri4 +  tri5+  tri6)/2 ;
	   
	   float sum2_2 =  (float) ( Math.sqrt(  sub2 * Math.abs(sub2-tri4 ) *Math.abs(sub2-tri5) * Math.abs(sub2-tri6)   ) );
	   
	   //삼각형넓이
	   
	   double tri7= Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
	   double tri8= Math.sqrt(Math.pow((x1-x4),2) + Math.pow((y1-y4),2));
	   double tri9= Math.sqrt(Math.pow((x2-x4),2) + Math.pow((y2-y4),2));
	   
	   double sub3 = ( tri7 +  tri8+  tri9)/2 ;
	   
	   float sum2_3 =  (float) ( Math.sqrt(  sub3 * Math.abs(sub3-tri7 ) *Math.abs(sub3-tri8) * Math.abs(sub3-tri9)   ) );
	   
	   sum2 = sum2_1 + sum2_2+ + sum2_3;
	   return sum2;
	   
   }
	@Override
	public String toString() {
		return "("+x1+", "+y1+", "+x2+", "+y2+", "+x3+", "+y3+", "+x4+", "+y4+", " +x5+", "+y5+")";
	}
}


public class Shape_Interface {

	public Shape_Interface() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String arg[]) {
	
	Shape[]arr = new Shape[4];
	arr[0] = new Triangle(1,2,3,4,5,6);
	arr[1] = new Rectangle(1,2,3,2, 1,5,3,5);
	arr[2] = new Square(1,2,3,2,1,4,3,4,2);
	arr[3] = new Pentagon(5,1, 8,1,3,5,10,5,6,12);
	
	for(Object p : arr) {
		System.out.println(p.toString());
	}
	
	System.out.println("삼각형 둘레 길이 = " + arr[0].perimeter());
	System.out.println("삼각형 면적 = " + arr[0].area());
	System.out.println("사각형 둘레 길이 = " + arr[1].perimeter());
	System.out.println("사각형 면적 = " + arr[1].area());
	}
}
