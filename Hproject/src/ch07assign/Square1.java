package ch07assign;



public class Square1 extends Rectangle1 {                            //부모클래스 Rectangle 자식 클래스 Square
	int side;                                                 //필드 , 생성자, 메서드
	
	public Square1(int x1, int y1, int side) {
		super(x1, y1 , x1+side ,y1+side);
		this.side =side;
	}
	
	public double perimeter() {		
		return super.perimeter();
	}
	public float area() {
		return super.area();
	}
	
	

//	
	public String toString() {
		return super.toString() ;
	}
	
}
