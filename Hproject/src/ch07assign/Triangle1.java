package ch07assign;

public class Triangle1 implements Shape1{

	private int x1,y1,x2,y2,x3,y3;                            //클래스 Triangle 필드
	private double sum1_1=0 ,sum1_2=0 ,sum1_3=0 ;
	private double sum1 = 0.; float sum2 = 0.f;
	
	public Triangle1(int x1,int y1,int  x2,int  y2,int  x3,int y3) {
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