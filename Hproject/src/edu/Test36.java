package edu;

public class Test36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int [5][5];
		
	   
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=0 ; j<arr.length ; j++) {
				arr[i][j]= 5*i +j + 1;
			}
		}
//		방법 1
		for (int []n : arr) {
			for (int k : n) {
			System.out.print(" " + k + " ");
		}
			System.out.println();
		}
		System.out.println();
//	방법2
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=0 ; j<arr.length ; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		//표로 나타내기
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=0 ; j<arr.length ; j++) {
				if (i==0) {
					System.out.print(" " +arr[i][j]+ " ");
				}else if((i==1) && (j!=arr.length-1)) {
					System.out.print(" " +arr[i][j]+ " ");
				}else {
				System.out.print(arr[i][j]+ " ");}
				
			}
			System.out.println();
		}
		
		//대각선 합 출력하기
		int sum=0;
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=0 ; j<arr.length ; j++) {
				if (i==j) {
					
					sum+=arr[i][j];
				}
			}
		}
		System.out.println("대각선 합 :" + sum);
		int lefttri=0;
		//왼쪽 삼각형 순회
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=0 ; j<=i; j++) {
				lefttri=lefttri+arr[i][j];
				}
			}
		System.out.println("lefttri 합 :" + lefttri);
		
		
		//오른쪽 삼각형 순회
		int righttri=0;
		//왼쪽 삼각형 순회
		for (int i=0 ; i <arr.length ; i++) {
			for (int j=arr.length-1;j>=i; j--) {
				 righttri= righttri+arr[i][j];
				}
			}
		System.out.println("righttri 합 :" +  righttri);
		
		
	}
}
