package javahong;

 interface Shape {                                         //인터페이스 Shape의 추상메서드 
	public double perimeter();
	public float area();
}


//삼각형    --------------------------------
class Triangle implements Shape {                            //인터페이스 Shape > 클래스 Triangle (메소드 오버라이딩 필요)
	private int x1,y1,x2,y2,x3,y3;                            //클래스 Triangle 필드
	private double sum1_1=0 ,sum1_2=0 ,sum1_3=0 ;
	private double sum1 = 0.; float sum2 = 0.f;
	
	public Triangle(int x1,int y1,int  x2,int  y2,int  x3,int y3) {
		this.x1=x1;  this.y1=x1;
		this.x2=x2;  this.y2=y2;
		this.x3=x3;  this.y3=y3;
	}
	
	
	public void calc() {
		
		
		sum1_1= Math.sqrt(Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
		sum1_2=	Math.sqrt(Math.pow((x2-x3),2) +Math.pow((y2-y3),2));
		sum1_3= Math.sqrt(Math.pow((x3-x1),2) + Math.pow((y3-y1),2));
		
		
	}
	
	
	@Override
	public double perimeter() { //구글링으로 계산식 찾아서 구현           //클래스 Triangle 메서드 오버라이딩
		
		
		calc() ;

		sum1 =sum1_1 +sum1_2 +sum1_3;
		return sum1;
	}
	
	
	@Override
	public float area() {
		
		
		calc() ;
		
		
		double sub = (sum1_1 + sum1_2 + sum1_3)/2 ;
		
		sum2 = (float) ( Math.sqrt(  sub * Math.abs(sub-sum1_1) *Math.abs(sub-sum1_2) * Math.abs(sub-sum1_3)   ) );
		
		
		
		return sum2;
	}
	
	public String toString() {
		return "삼각형 둘레 길이 = " + sum1 + "삼각형 면적 = " + sum2 ;
	}
}

//직사각형    --------------------------------

class Rectangle implements Shape {
	private int x1,y1,x2,y2;
	private int sum1=0,sum2=0;
	
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 =x1;    this.y1 =y1;
		this.x2 =x2;    this.y2 =y2;
	}
	
	public double perimeter() {
		int sum1 = 0;
		
		sum1 = 2 * (Math.abs(x2-x1) + Math.abs(y2-y1));
		return sum1;
		
	}
	public float area() {
		
         int sum2 = 0;
         sum2 = Math.abs(x2-x1) * Math.abs(y2-y1);
		
		return sum2;
		
	}
	
	public String toString() {
		return "직사각형 둘레 길이 = " + sum1 + "직사각형 면적 = " + sum2 ;
	}
	
}

//정사각형    --------------------------------

class Square extends Rectangle {                            //부모클래스 Rectangle 자식 클래스 Square
	int side;                                                 //필드 , 생성자, 메서드
	
	public Square(int x1, int y1, int side) {
		super(x1, y1 , x1+side ,y1+side);
		this.side =side;
	}
	
	
	public double perimeter() {
		int sum1 = 0;
		
		sum1 = side * 4;
		return sum1;
		
	}
	public float area() {
		
         double sum2 = 0;
         sum2 = Math.pow(side ,2);
		
		return (int)sum2;
		
	}
	
	public String toString() {
		return super.toString() ;
	}
	
}



public class Ch07_interface {

	public Ch07_interface() {
		// TODO Auto-generated constructor stub
	}
	
	Shape t = new Triangle(1,2,3,4,5,6);
	Shape r = new Rectangle(1,2,3,4);
	Shape s = new Square(1,2,3);
	
//	
//	System.out.println("삼각형 둘레 길이 = " + t.perimeter());
//	System.out.println("삼각형 면적 = " + t.area());
//	System.out.println("사각형 둘레 길이 = " + r.perimeter());
//	System.out.println("사각형 면적 = " + r.area());
}
