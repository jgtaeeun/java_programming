package javahong;

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수
	
    public Polynomial(double coef, int exp) {
    	this.coef=coef;
    	this.exp=exp;
    }
    @Override
	public int compareTo(Polynomial o) {
		
    	return this.exp-o.exp ;
	}
    public String toString() {
    	return "("+coef +"X" + exp+")";
    }

}
public class Test_다항식merge연산 {
		static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {
			Polynomial temp[] = new Polynomial[30];
			int ix = 0;
			int p = lefta, q = leftb;
			while (p <= righta && q <= rightb) {
				if (a[p].exp < a[q].exp) temp[ix++] = a[p++];
				else if (a[p].exp > a[q].exp) temp[ix++] = a[q++];
				else {
					temp[ix++] = a[p++];temp[ix++] = a[q++];
				}
			}
			while (p > righta && q <= rightb) temp[ix++] = a[q++];
			while (q > rightb && p <= righta) temp[ix++] = a[p++];
			System.out.println();
			for (int j = 0; j < ix; j++) {
				a[lefta+ j] = temp[j];
				System.out.print(" "+ a[lefta+j]);
			}
				System.out.println();
		}
	// --- 퀵 정렬(비재귀 버전)---//
		static void MergeSort(Polynomial[] a, int left, int right) {
			int mid = (left+right)/2;
			if (left == right) return;
			MergeSort(a, left, mid);
			MergeSort(a, mid+1, right);
			merge(a, left, mid, mid+1, right);
			return;
		}
		
		static void ShowPolynomial(Polynomial[] x ) {
			for (Polynomial p : x) {
				if (p ==null) break;
				System.out.println(p.toString());
			}
		}

		
		static void AddPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
			// TODO Auto-generated method stub
			for (int i=0 ; i<y.length ; i++ ) {
			
				if (y[i].exp==x[i].exp) {
					z[i]= new Polynomial(y[i].coef+x[i].coef,y[i].exp);
				}
				else if (x[i].exp - y[i].exp >0) {
					z[i]= new Polynomial(y[i].coef,y[i].exp);
					z[i+1]= new Polynomial(x[i].coef,x[i].exp);
				}
				else {
					z[i]= new Polynomial(x[i].coef,x[i].exp);
					z[i+1]= new Polynomial(y[i].coef,y[i].exp);
				}
			}
		}
		
		static void MultiplyPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
			// TODO Auto-generated method stub
			
	
			 

			    // Initialize the result array with Polynomial objects
			 for (int i = 0; i < x[6].exp+y[6].exp+1; i++) {
			        z[i] = new Polynomial(0.0, i); // Initialize all coefficients to 0
			 }

			    // Perform polynomial multiplication
			 for (int i = 0; i < x.length; i++) {
			        for (int j = 0; j < y.length; j++) {
			            int exp = x[i].exp + y[j].exp;
			            double coef = x[i].coef * y[j].coef;
			            z[exp] = new Polynomial(z[exp].coef + coef, exp);
			        }
			  }
		}
		
		static int EvaluatePolynomial(Polynomial[] x, int c) {
			// TODO Auto-generated method stub
			int sum=0;
			for (int i=0; i<x.length ; i++) {
				if (x[i]==null) break;
				sum = (int) (sum + x[i].coef * Math.pow(c, x[i].exp));
			}
			return sum;
		}
		
		public static void main(String[] args) {
			Polynomial[] x = {
			         new Polynomial(1.5, 3),
			         new Polynomial(2.5, 7),
			         new Polynomial(3.3, 2),
			         new Polynomial(4.0, 1),
			         new Polynomial(2.2, 0),
			         new Polynomial(3.1, 4),
			         new Polynomial(3.8, 5),
			     };
			Polynomial[] y = {
			         new Polynomial(1.5, 1),
			         new Polynomial(2.5, 2),
			         new Polynomial(3.3, 3),
			         new Polynomial(4.0, 0),
			         new Polynomial(2.2, 4),
			         new Polynomial(3.1, 5),
			         new Polynomial(3.8, 6),
			     };
			int nx = x.length;

			System.out.println("정렬 전");
			ShowPolynomial(x);
			System.out.println();
			ShowPolynomial(y);
			MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
			MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
			System.out.println("정렬 후");
			ShowPolynomial(x);
			System.out.println();
			ShowPolynomial(y);
			
			Polynomial[] z = new Polynomial[20];
			AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
			System.out.println("다항식 덧셈 후");
			ShowPolynomial(z);
			System.out.println();
		//	ShowPolynomial(y);
			MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
			System.out.println("다항식 곱셈 후");
			ShowPolynomial(z);
			int result = EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
			System.out.println(" result = " + result );
		}
		
}

