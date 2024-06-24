package Chap6_Sorting;
import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize=sz;
		heap = new int [MaxSize+1];
	}
	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		int i;
		for ( i = 1; i <= n; i++)
			System.out.print(heap[i]+" ");

	
	}
	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		    n++; // 힙의 크기 증가
		    int i = n; // 마지막 노드의 인덱스

		    if (n == MaxSize) {
		        HeapFull(); // 힙이 가득 찬 경우 처리 (MaxSize는 힙의 최대 크기)
		        return;
		    }

		    while (i > 1 && x > heap[i / 2]) {
		        // 부모 노드보다 큰 값을 가진 노드를 위로 이동시킨다.
		        heap[i] = heap[i / 2];
		        i /= 2; // 부모 노드 인덱스로 이동
		    }

		    heap[i] = x; // 새로운 노드를 삽입
		
		
	}
	
	@Override
	public int DeleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다. 
		int x;
		int i, j;
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}
		
		x = heap[1]; 
		

		int k=heap[n];
		for (i = 1, j = 2; j <= n; )
		{
			if (j < n) if (heap[j] < heap[j + 1]) j++;
			// j points to the larger child
			if (k >= heap[j]) break;
			heap[i] = heap[j];
			i = j; j *= 2;
		}
		heap[i] = k;
		n--;
		
		return x;

	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class 실습6_16_1heap정렬 {
	 static void showData(int[] d) {
		 for(int i=1 ;  i<d.length ; i++)
			 System.out.print(d[i]+" ");
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    int []sorted = new int[count];//heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다
	    int deleteidx=0;
		do {
			 System.out.println();
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				for (int i=1 ;  i<=count ; i++) {
					x[i]=rnd.nextInt(0,10);
					heap.Insert(x[i]);
				}
			     showData(x);
			    
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
				sorted[deleteidx]=heap.DeleteMax();
				deleteidx++;
				if(deleteidx==count) {showData(sorted); break;}
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}