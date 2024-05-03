package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MatrixCalc2 {

	public MatrixCalc2() {
		// TODO Auto-generated constructor stub
	}
	private static int [][] loadMatrix(String fname){
		int [][] ret = null;
		List<String> list = new ArrayList<>();
		String str;
		try(BufferedReader br = new BufferedReader(new FileReader(fname));){
			while((str=br.readLine())!=null) {
				list.add(str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		for (int i=0 ; i<list.size() ; i++) {   //행으로 묶어져 있는 상태   1 2 3 4       list.size=3
			String[]arr = list.get(i).split(" ");                    //i=0       arr[] 1234    5678
			if(ret == null) {
				ret=new int[list.size()][arr.length];   //ret[3][4]
			}
			for(int j=0; j<arr.length;j++) {                    
				ret[i][j]=Integer.parseInt(arr[j]);  //ret[0][0] ret[0][1] ret[0][2] ret[0][3]
			}
		}
		return ret;
	}
	
	private static void printMatrix(int[][] m) {
		for (int i=0 ; i<m.length; i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println("-".repeat(30));
	}
	
	private static int[][] caclMatrix(int[][]a, int[][]b){
		int[][]c=new int[a.length][a.length]; int sum=0;
		for(int i=0 ; i<a.length ; i++) {                     
			for (int k=0; k<a.length; k++){                       
				for(int j=0 ; j<a[0].length; j++)  {          //c[i][k] = a[i][j]*b[j][k]					
					sum=a[i][j]*b[j][k]+sum;    //c[0][0] = a[0][0]b[0][0]   +a[0][1]b[1][0]+a[0][2]b[2][0]+a[0][3]b[3][0] 
												//c[0][1] = a[0][0]b[0][1]   +a[0][1]b[1][1]+a[0][2]b[2][1]+a[0][3]b[3][1]
    		   }
				c[i][k]=sum;
				sum=0;
			}
		}
			
		return c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                   int[][]a=loadMatrix("m.txt");
                   if(a == null) return;
                   printMatrix(a);
                   
                   int[][]b=loadMatrix("n.txt");
                   if(b == null) return;
                   printMatrix(b);
                   
                   int[][]c=caclMatrix(a,b);
                   printMatrix(c);
                   
                  
		}
		
}


