package Chap2_기본자료구조;
import java.util.Arrays;
import java.util.Random;

public class train_ch2_6 {

	public train_ch2_6() {
		// TODO Auto-generated constructor stub
	}
	static void inputData(double [int row][int col] data) {//double 난수 0.0 ~ 1.0 생성
		Random rand=new Random();
		for (int r = 0 ;  r<row ; r++){
		   for (int c = 0 ;  c<col ; c++){
			data[r][c]=rand.nextDouble()
		   }
		}
	}
	static void showData(string txt, double [int row][int col] data ) {//주어진 문자열을 출력하고 배열을 2차원 형태로 출력
		System.out.print(txt);
		
		for (int r = 0 ;  r<row ; r++){
		   for (int c = 0 ;  c<col ; c++){
			System.out.print(data[r][c])
		   }
		   System.out.println()
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [][]A = new double[2][3];
		double [][]B = new double[3][4];
		double [][]C = new double[2][4];

		inputData(A);
		inputData(B);

		double [][]D = A.clone();//교재83 - 배열 복제
		
		showData("A[2][3] = ",A);
		showData("D[2][3] = ",D);
		showData("B[3][4] = ",B);

		double [][]E = addMatrix(A,D);//행렬 덧셈
		showData("E[2][3] = ",E);

		C = multiplyMatrix(A,B);//행렬 곱셈
		showData("C[2][4] = ",C);

		double [][]F = transposeMatrix(A);//전치 행렬
		showData("F[3][2] = ",F);

		boolean result = equals(A, D);//행렬 동등 비교
		System.out.println(" equals(A,D) = " + result);
		
		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}

}
