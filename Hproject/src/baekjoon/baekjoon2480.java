package baekjoon;

import java.util.Random;
import java.util.Scanner;

public class baekjoon2480 {

	public baekjoon2480() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Random rnd = new Random();
		int a = rnd.nextInt(1,7);
		int b= rnd.nextInt(1,7);
		int c = rnd.nextInt(1,7);
		int result = 0;
	    System.out.println(a);  System.out.println(b);  System.out.println(c);
		if (a==b && b==c) {                    //a=b=c
			System.out.println(10000+a*1000);
		}
		else if (a==b) {
			System.out.println(1000+a*100);
		}
		else if (b==c) {
			System.out.println(1000+b*100);
		}
		else if (a==c) {
			System.out.println(1000+a*100);
		}
		else {
			result = Math.max(a,  Math.max(b, c)) * 100;
		}

	}
}
