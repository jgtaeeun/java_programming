package Chap2_기본자료구조;
import java.util.Arrays;
import java.util.Random;

public class train_ch2_6 {

	public train_ch2_6() {
		// TODO Auto-generated constructor stub
	}
	static void inputData(double[][] data) {//double 난수 0.0 ~ 1.0 생성
		Random rand =new Random();
		for (int r =0 ; r <data.length ;r ++) {
			for (int c =0 ; c <data[0].length ;c ++) {
				data[r][c]=rand.nextDouble();
			}
		}

	}
	static void showData(String txt,double[][] data) {//주어진 문자열을 출력하고 배열을 2차원 형태로 출력
		System.out.println(txt);
		for (int r =0 ; r <data.length ;r ++) {
			for (int c =0 ; c <data[0].length ;c ++) {
				System.out.print(data[r][c]);
				System.out.print(" ");
			}
		     System.out.println();
		}
	}
	
	


	//}
	static double [][] addMatrix(double [][] data1,double [][] data2) {//행렬 덧셈 결과를 리턴
		
		double[][] add_data=new double [data1.length][data1[0].length];
		for (int r =0 ; r <data1.length ;r ++) {
			for (int c =0 ; c <data1[0].length ;c ++) {
				add_data[r][c]=data1[r][c]+data2[r][c];
			}
		}
		return add_data;
		
	}
	static double [][] multiplyMatrix(double [][] data1,double [][] data2) {//행렬 곱셈 결과를 리턴
		double[][] multi_data=new double [data1.length][data2[0].length];
		
		for (int r =0 ; r <data1.length ;r ++) {
			for(int k=0 ; k<data2[0].length;k++) {
				for (int c =0 ; c <data2.length ;c ++) {
				multi_data[r][k]=data1[r][c]+data2[c][k];
				}
			}
		}
		
		return multi_data;
	}
		
	static double [][] transposeMatrix(double [][] data) {//전치 행렬을 리턴
		double[][] trans_data=new double [data[0].length][data.length];
		for (int c =0 ; c <data[0].length ;c ++) {
			for (int r =0 ; r <data.length ;r ++) {
						trans_data[c][r]=data[r][c];
			}
		}
		return trans_data;
	}

	static boolean equals(double [][] data1,double [][] data2) {//두 행렬의 사이즈가 같고 값도 모두 같아야 행렬 2개는 equals을 true로 리턴
		boolean b=true;
		
		if (data1.length !=data2.length) {
			b=false;
		}
		else {	
			for (int r =0 ; r <data1.length ;r ++) {
					for (int c =0 ; c <data1[0].length ;c ++) {
						if (data1[r][c]!=data2[r][c]) {
							b=false;
							break;
						}
					}
			}
		}
		
	return b;
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
