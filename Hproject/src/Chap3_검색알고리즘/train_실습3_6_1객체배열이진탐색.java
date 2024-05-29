package Chap3_검색알고리즘;
import java.util.Arrays;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
    
	
	public PhyscData2 (String name, int height, double vision) {
			this.name=name;
			this.height=height;
			this.vision=vision;
    }
	
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return "[" +name + "," + height + "," + vision +"]" ;
	}
	
	@Override
	public int compareTo(PhyscData2 p) {
		return this.name.compareTo(p.name);
	}

}


public class train_실습3_6_1객체배열이진탐색 {

	public train_실습3_6_1객체배열이진탐색() {
		// TODO Auto-generated constructor stub
	}
	static void showData(String txt,PhyscData2[] data ) {
		for(PhyscData2 d : data) {
			System.out.println( d.toString());
			//System.out.println( "[" +d.name + " ," +  d.height + " ,"+ d.vision +"]");
		}
	}
	
	static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 d = data[i];
		data[i]=data[j];
		data[j]=d;
	}
	static void sortData(PhyscData2[] data ) {  //단순 삽입 정렬 
		for (int i=0 ; i<data.length ; i++) {
			int min=i;
			for (int j=i+1 ; j<data.length ; j++) {
				if (data[j].name.compareTo(data[min].name) <0 ) {
					min=j;
				}
			}
			swap(data, i, min);
		}
		//name이 같을 때 height로 정렬
		for (int i=0 ; i<data.length ; i++) {
			int height_min=i;
			for (int j=i+1 ; j<data.length ; j++) {
				if (data[j].name.compareTo(data[i].name) ==0 ) {
				    if(data[height_min].height >data[j].height) {
				    	height_min=j;
				    }
				    else {break;}
				}
				else {break;}
			}
			swap(data,i, height_min );
			
		}
		
	}
	static void reverse(PhyscData2[] data ) {
		PhyscData2[] newdata = new PhyscData2[data.length];
		
		for (int i=0;  i<data.length ; i++) {
			newdata[data.length-1-i]=data[i];
		}
		//System.out.println(Arrays.toString(newdata));

		for(int j = 0 ; j <data.length ; j++) {
			data[j]=newdata[j];
		}
		//System.out.println(Arrays.toString(data));
	}
	
	
	static int  linearSearch(PhyscData2[] data , PhyscData2 key) {         //선형검색
		   
    	int idx=0;
    	while(true) {
    		if (idx==data.length) {
    			return -1;
    		}
    		if (data[idx].name.equals(key.name) && (data[idx].height)==(key.height) && (data[idx].vision)==(key.vision)) {
    			return idx;
    		}
    		idx++;
    	}
    }
	
	 static int  binarySearch(PhyscData2[] data , PhyscData2 key) {  //binarysearch
	    	int pl = 0 ; //검색범위의 첫 인덱스
	    	int pr = data.length-1 ; //검색범위의 끝 인덱스
	    	
	    	do {
	    	int pc = (pl +pr) /2 ;   //중앙 인덱스
	    	if (data[pc].name.equals(key.name) && (data[pc].height)==(key.height) && (data[pc].vision)==(key.vision)) {return pc;}
	    	else if (data[pc].name.compareTo(key.name)>0) {pr=pc-1;}
	    	else {pl=pc+1;}
	    	}while(pl<=pr);
	    	
	    	return -1;
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		
		showData("정렬전", data);
		sortData(data);//6장 실습 06-4 단순 선택 정렬 
		System.out.println();
		showData("정렬후", data);
		System.out.println();
		
		reverse(data);
		showData("역순 재배치후", data);
		
		System.out.println();
	//	Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 
	//	showData("Arrays.sort() 정렬후", data);
		
	//	PhyscData2 key = new PhyscData2("길동", 167, 0.5);   //객체 그 자체가 찾고자 하는 키이다.
	//	int resultIndex = linearSearch(data, key);
	//	System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
		
	//	key = new PhyscData2("박동", 167, 0.6);
	//	resultIndex = binarySearch(data, key);//comparable를 사용
	//	System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		
		//교재 115 Arrays.binarySearch에 의한 검색
	//	key = new PhyscData2("나동", 164, 0.6);
	//	resultIndex = Arrays.binarySearch(data, key);//comparable를 사용
	//	System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}

}
