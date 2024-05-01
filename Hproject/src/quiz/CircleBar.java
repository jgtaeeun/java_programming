package quiz;

import java.util.Scanner;

public class CircleBar {

	static int r = 5;
	static int h = 10;
	
	static double getVolume() {
		return Math.PI * r * r *  h;
	}
	static double getArea() {
		return Math.PI * r * r *  2 + (2 * Math.PI * r) * h;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 
		 while(true) {
			 System.out.print("반지름 : "); r = sc.nextInt();
			 if (r==0) {
				 break;
			 }
			 System.out.print("높이 : "); h = sc.nextInt();
			 
			 System.out.println("원기둥의 부피 : " + (int)getVolume());
			 System.out.println("원기둥의 겉넓이 : " + (int)getArea());
		 }
		 System.out.println("Done");
		 sc.close();
	}

}
