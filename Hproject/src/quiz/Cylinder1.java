package quiz;

import java.util.Scanner;

public class Cylinder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
     
     System.out.print("반지름 : ");
     int r = sc.nextInt();
     System.out.print("높이 : ");
     int h = sc.nextInt();
     
     Cylinder2 cy = new Cylinder2() ;
     
//     cy.getVolume(r,h);
     System.out.println("원기둥의 부피 : " + cy.getVolume(r,h));
//     cy.getArea(r, h);
     System.out.println("원기둥의 겉넓이 : " + cy.getArea(r, h));
	}

}
