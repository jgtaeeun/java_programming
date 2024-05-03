package quiz;

import java.util.ArrayList;

abstract class Geometry {
    int[] xArr;
    int[] yArr;
    
	public Geometry() {
		// TODO Auto-generated constructor stub
	}

	abstract double getArea();
	abstract double getLength();
	
}

class Point extends Geometry{
	 int[] xArr = new int[1];
	 int[] yArr = new int[1];
	
	public  Point(int x, int y) {
	   xArr[0] = x;
	   yArr[0] = y;
	    
	}
	
	double getArea() {
		return 0;
	}
	double getLength() {
		return 0;
	}
}

class Line extends Geometry{
	 int[] xArr = new int[2];
	 int[] yArr = new int[2];
	
	public  Line(int[] xArr, int[] yArr) {
		 this.xArr[0] = xArr[0]; this.yArr[0] = yArr[0];
	     this.xArr[1] = xArr[1]; this.yArr[1] = yArr[1];
	    
	}
	
	double getArea() {
		return 0;
	}
	double getLength() {
		return getLengthcalc(xArr[0],xArr[1],yArr[0],yArr[1]);
	}
	static double getLengthcalc(int x1, int x2, int y1, int y2) {
		return Math.sqrt(Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
	}
}


class Polyline extends Geometry{
	ArrayList<Integer> xlist = new ArrayList<Integer>();
	ArrayList<Integer> ylist = new ArrayList<Integer>();
	 
	public   Polyline(int[] xArr,int [] yArr) {
	     for (int i =0 ; i<xArr.length ; i++) {
	    	 xlist.add(xArr[i]);
	    	 ylist.add(yArr[i]);
	     }
	}
	
	double getArea() {
		return 0;
	}
	double getLength() {
		double sum=0;
		for(int k=0 ; k<=xlist.size()/2;k++) {
			sum= Line.getLengthcalc(xlist.get(k), xlist.get(k+1), ylist.get(k), ylist.get(k+1))+sum;
		}
	    return sum;	
	}
}





class TriAngle extends Geometry{
	int [] xArr =new int[3];
	int [] yArr =new int[3];
	
	public   TriAngle(int[] xArr,int [] yArr ) {
	      this.xArr[0] = xArr[0]; this.yArr[0] = yArr[0];
	      this.xArr[1] = xArr[1]; this.yArr[1] = yArr[1];
	      this.xArr[2] = xArr[2]; this.yArr[2] = yArr[2];
	      
	}
	
	double getArea() {
		double sum1_1=0,sum1_2=0,sum1_3=0,sum2=0,sub=0;
		sum1_1=Line.getLengthcalc(xArr[0],xArr[1],yArr[0],yArr[1]);   //static은 인스턴스객체 안 만들고 클래스명.메서드로 함
		sum1_2=Line.getLengthcalc(xArr[1],xArr[2],yArr[1],yArr[2]);
		sum1_3= Line.getLengthcalc(xArr[2],xArr[0],yArr[2],yArr[0]);
		
		sub = (sum1_1 + sum1_2 + sum1_3)/2 ;
		
		sum2 =  ( Math.sqrt(  sub * Math.abs(sub-sum1_1) *Math.abs(sub-sum1_2) * Math.abs(sub-sum1_3)   ) );
		
		
		
		return sum2;
		
	}
	double getLength() {
		double sum1_1=0,sum1_2=0,sum1_3=0,sum1=0;
		sum1_1=Line.getLengthcalc(xArr[0],xArr[1],yArr[0],yArr[1]);
		sum1_2=Line.getLengthcalc(xArr[1],xArr[2],yArr[1],yArr[2]);
		sum1_3= Line.getLengthcalc(xArr[2],xArr[0],yArr[2],yArr[0]);
		
		sum1 =sum1_1 +sum1_2 +sum1_3;
		return sum1;
	}
}

class Rectagle extends Geometry{
	int [] xArr =new int[4];
	int [] yArr =new int[4];
	
	
	   
	public Rectagle(int[] xArr,int [] yArr ) {
		this.xArr[0] = xArr[0]; this.yArr[0] = yArr[0];
	    this.xArr[1] = xArr[1]; this.yArr[1] = yArr[1];
	    this.xArr[2] = xArr[2]; this.yArr[2] = yArr[2];
	    this.xArr[3] = xArr[3]; this.yArr[3] = yArr[3];
	}
	
	double getArea() {
		double sum1 = 0;

		sum1 = AbsLength(xArr[0],xArr[1], xArr[2],xArr[3],yArr[0],yArr[1], yArr[2],yArr[3])  *AbsLength(xArr[0],xArr[1], xArr[2],xArr[3],yArr[0],yArr[1], yArr[2],yArr[3]);
		return sum1;
	}
	double getLength() {
		double sum1 = 0;
		
		sum1 =2 * AbsLength(xArr[0],xArr[1], xArr[2],xArr[3],yArr[0],yArr[1], yArr[2],yArr[3]) ;
		return sum1;
	}
	
	static double AbsLength(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
		double sum=0;
		if ((x1!=x2)&& (y1==y2) )sum =(double)Math.abs(x1-x2);
		else if ((x1!=x3)&& (y1==y3) )sum =(double)Math.abs(x3-x1);
		else sum =(double)Math.abs(x4-x1);
		return sum;
	}
}




public class Geometry_Test {

	public Geometry_Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Point point = new Point(0,0);
		
		int x_line[]= {1,2}; int y_line[]= {3,4};
		Line line = new Line(x_line, y_line);
		
		
		
		int x_tri[]= {0,1,0}; int y_tri[]= {0,0,1};
		TriAngle triangle = new TriAngle( x_tri, y_tri);
		
		int x_rec[]= {3,3,0,0}; int y_rec[]= {0,1,1,0};
		Rectagle rectagle = new Rectagle(x_rec, y_rec);
		
	
		Polyline polyline2 = new Polyline(x_tri, y_tri);   //점 3개=>선2개
		Polyline polyline1 = new Polyline(x_rec, x_rec);  //점 4개=>선3개
		
		System.out.println("line의 length: " + line.getLength());
		System.out.println("polyline(점3개)의 length: " + polyline2.getLength());
		System.out.println("polyline(점4개)의 length: " + polyline1.getLength());
		
		System.out.println("triangle의 length: " + triangle.getLength() + " triangle의 area: " + triangle.getArea());
		System.out.println("retangle의 length: " + rectagle.getLength() + " retangle의 area: " + rectagle.getArea());
	}

}
