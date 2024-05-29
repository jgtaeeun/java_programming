package Chap2_기본자료구조;

import java.util.Arrays;

public class train_실습3_6_0스트링배열정렬이진탐색 {

	public train_실습3_6_0스트링배열정렬이진탐색() {
		// TODO Auto-generated constructor stub
	}
	
	
	static void showData(String txt, String [] data) {
		System.out.println(Arrays.toString(data));
	}
	
	static void swap(String []data, int i, int j) {
		String tmp= data[i];
		data[i]=data[j];
		data[j]=tmp;
	}
	static void sortData(String [] data) {
		//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		for (int i=0 ;  i<data.length ; i++) {
			int min=i;
			for (int j=i+1 ; j<data.length ; j++) {
				if(data[j].compareTo(data[min])<0) {
					min=j;
				}
			}	
		    swap(data, i, min);	
		}
	}	
	static int  linearSearch(String [] data, String key) {         //선형검색
		   
    	int idx=0;
    	while(true) {
    		if (idx==data.length) {
    			return -1;
    		}
    		if (data[idx].equals(key)) {
    			return idx;
    		}
    		idx++;
    	}
    }
	
	 static int  binarySearch(String [] data, String key) {  //binarysearch
	    	int pl = 0 ; //검색범위의 첫 인덱스
	    	int pr = data.length-1 ; //검색범위의 끝 인덱스
	    	
	    	do {
	    	int pc = (pl +pr) /2 ;   //중앙 인덱스
	    	if (data[pc].equals(key)) {return pc;}
	    	else if (data[pc].compareTo(key)>0) {pr=pc-1;}
	    	else {pl=pc+1;}
	    	}while(pl<=pr);
	    	
	    	return -1;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);
		
		
		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);
		
		
		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		
		//* 교재 115 Arrays.binarySearch에 의한 검색
		key = "산딸기";
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
		
		key = "배";
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(배): key = " + key + ", result = " + resultIndex);
	}

}
