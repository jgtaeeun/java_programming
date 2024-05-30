package Chap3_검색알고리즘;
import java.util.Arrays;
import java.util.Comparator;

class PhyscData3 {
	private String name;            //name은 private로 선언했기에 같은 클래스 내에서만 쓸 수 있으므로 다른 클래스에서 쓸 수 있도록 getName()함수 생성
	int height;
	double vision;
	
	
	public PhyscData3 (String name, int height, double vision) {
		this.name=name;
		this.height=height;
		this.vision=vision;
	}
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return "[" +name + "," + height + "," + vision +"]" ;
	}
	public String getName() {
		return this.name;
	}
}

class NameOrder implements Comparator<PhyscData3>{
	public int compare(PhyscData3 p1, PhyscData3 p2) {
		return p1.getName().compareTo(p2.getName()) ;
	}
}
class HeightOrder implements Comparator<PhyscData3>{

		public int compare(PhyscData3 p1, PhyscData3 p2) {
			
			return p1.height-p2.height;
		}
}
class VisionOrder implements Comparator<PhyscData3>{
	public int compare(PhyscData3 p1, PhyscData3 p2) {
		int result=0;
		if( p1.vision > p2.vision)result=1;
		else if  (p1.vision == p2.vision)result= 0;
		else if (p1.vision < p2.vision)  result= -1;
		return result;
	}
}





public class train실습3_8객체비교연산자 {

	public train실습3_8객체비교연산자() {
		// TODO Auto-generated constructor stub
	}
	static final Comparator<PhyscData3> HEIGHT_ORDER = new HeightOrder();
	
	static void showData(String txt,PhyscData3[] data ) {
		for(PhyscData3 d : data) {
			System.out.println( d.toString());
			//System.out.println( "[" +d.name + " ," +  d.height + " ,"+ d.vision +"]");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("나가자", 164, 1.3),
				new PhyscData3("다정해", 152, 0.7),
				new PhyscData3("소주다", 172, 0.4),
				new PhyscData3("사이다", 182, 0.6),
				new PhyscData3("신정신", 166, 1.2),
				new PhyscData3("이기자", 167, 1.5),
		};
		
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER); //Arrays.sort(T[] a , Comparator <? super T> c)
		showData("height로 정렬후 객체 배열", data); 
		
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);   //height가 167인 것의 인덱스 출력 
		System.out.println("\nArrays.binarySearch(): result = " + idx);
		
		Arrays.sort(data, new VisionOrder());
		showData("vision로 정렬후 객체 배열", data);
		
		
		//익명클래스 선언, name 기준으로 정렬
		Arrays.sort(data, new Comparator<PhyscData3>() {
			@Override
			public int compare(PhyscData3 a1, PhyscData3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("name로 정렬후 객체 배열", data);
		
	}

}
