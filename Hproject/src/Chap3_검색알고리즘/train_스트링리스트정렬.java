package Chap3_검색알고리즘;
//리스트를 배열로 변환후 중복제거후 다시 리스트 만들기 등 실습

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class train_스트링리스트정렬 {
	static void getList(List<String> list) {
		list.add("서울");	list.add("북경");
		list.add("상해");	list.add("서울");
		list.add("도쿄");	list.add("뉴욕");


		list.add("런던");	list.add("로마");
		list.add("방콕");	list.add("북경");
		list.add("도쿄");	list.add("서울");

		list.add(1, "LA");
	}

	static void showList(String topic, List<String> list) {
		System.out.print(topic+") ");
		for (int i=0 ; i< list.size() ;i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}	

	static void sortList(List<String> list) {
		List<String> list2 = new ArrayList<>();

		for (int i=0 ; i<list.size();i++) {
			list2.add(i, list.get(list.size()-1-i));
		}
		//System.out.println(list2);
    
		for (int j=0 ;  j <list.size() ; j++) {
			list.set(j, list2.get(j));
		}
		//System.out.println(list);
	}

	static String[] removeDuplicateList(List<String> list) {
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("중복제거 전 배열 " +Arrays.toString(cities)) ;// 중복제거하기 전 배열
		
		for (int i=0; i<cities.length-1 ;i++) {
			for(int j=i+1 ; j<cities.length ; j++) {
				if ((cities[i]!="") && (cities[i].equals(cities[j])) ) {
					cities=removeElement1(cities, cities[i]); 	
					break;
				}
			
			}
    	
		}
		System.out.println("중복제거 후 배열 "+Arrays.toString(cities));
		return cities;
		
	}
	
	static String[] removeElement1(String[] arr, String item) {
		int idx [] = new int [arr.length];      //중복되는 문자열이 있는 인덱스를 저장한다.
		int count=0;
		for (int k =0 ; k<arr.length ; k++) {
	             if(arr[k]==item) {
	            	 idx[count]=k;
	            	 count=count+1;
	             }
		}
		
		for (int t =1; t<idx.length; t++) {
			arr[idx[t]]="";
		}
		return arr;
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		getList(list);
		showList("입력후", list);
	
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
		Collections.sort(list);  //오름차순으로 정렬
		showList("오름차순 정렬", list);
	
		sortList(list);  //내림차순으로 정렬
		showList("내림차순 정렬", list);
	
		System.out.println("중복제거::");
		String[] cities = removeDuplicateList(list); //중복제거하고 배열로 반환
        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));  //중복제거한 배열을  리스트로 변환
	    showList("중복제거후", lst);
	  
	}

}
