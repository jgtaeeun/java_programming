package ch07assign;


public class ch07Hwtest {

	public ch07Hwtest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape1 t = new Triangle1(1,2,3,4,5,6);
		Shape1 r = new Rectangle1(1,2,3,4);
		Shape1 s = new Square1(1,2,3);
		
		
		System.out.println("삼각형 둘레 길이 = " + t.perimeter());
		System.out.println("삼각형 면적 = " + t.area());
		System.out.println("사각형 둘레 길이 = " + r.perimeter());
		System.out.println("사각형 면적 = " + r.area());
		System.out.println("정사각형 둘레 길이 = " + s.perimeter());
		System.out.println("정사각형 면적 = " + s.area());
		
		
		System.out.println(t.toString());
		System.out.println(r.toString());
		System.out.println(s.toString());
	}

}
