package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("3개의 숫자 입력하세요:");
		String sarray []=sc.nextLine().split(" ");
		int array [] = new int [3];
		for (int i= 0 ; i<sarray.length ; i++) {
			int n=Integer.parseInt(sarray[i]);
			array[i]=n;
		}

		if ((array[0]==array[1])&&(array[2]==array[1])&&(array[2]==array[0])) {
			System.out.println(10000+array[0]*1000);
		}
		else if ((array[0]==array[1])||(array[2]==array[1])||(array[2]==array[0])) {
			if(array[0]==array[1]) System.out.println(1000+array[0]*100);
			else if (array[2]==array[1]) System.out.println(1000+array[1]*100);
			else System.out.println(1000+array[2]*100);
			 
		}
		else if ((array[0]!=array[1])&&(array[2]!=array[1])&&(array[2]!=array[0])) {
			int max=0;
			for (int i=0 ; i<array.length ; i++) {
				if (max < array[i]) max=array[i];
			}
			System.out.println(max*100);
		}
	}

	

}
