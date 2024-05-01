package edu;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [][]a = new int [3][4];
        int [][]b = new int [3][4];
        int [][]c = new int [3][4];
        
		Random rnd = new Random();
		//랜덤으로 배열 a,b  생성
		for (int i = 0 ; i <a.length ; i++) {
			for (int j=0 ; j<a[0].length; j++) {
				
				 a[i][j]=  rnd.nextInt(100);
				 System.out.print(a[i][j]+ " ");
		}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0 ; i <b.length ; i++) {
			for (int j=0 ; j<b[0].length ; j++) {
				
				 b[i][j]=  rnd.nextInt(100);
				 System.out.print(b[i][j]+ " ");
		}
			System.out.println();
		}
       
		//배열 a,b 더한 배열 c 출력
		System.out.println();
		for (int i = 0 ; i <b.length ; i++) {
			for (int j=0 ; j<b[0].length ; j++) {
				
				 c[i][j]= a[i][j]+b[i][j];
				 System.out.print(c[i][j]+ " ");
		}
			System.out.println();
		}
       
		
		
		
	}

}
