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
		
		for (int j=0 ;  j <list.size() ; j++) {
			list.set(j, list2.get(j));
		}
    }
    
    static String[] removeDuplicateList(List<String> list) {
	    String cities[] = new String[0];
	    cities = list.toArray(cities);
	    //System.out.println(Arrays.toString(cities));
	    
	    for (int i = 1 ;  i<cities.length-1 ; i++) {
	    	cities=removeElement1(cities, cities[i]);
	    }
	   // System.out.println(Arrays.toString(cities));
	  //============================================================
    // [서울, , , 상해, 북경, , 방콕, 로마, 런던, 도쿄, , 뉴욕, LA] =>  [서울, 상해, 북경, 방콕, 로마, 런던, 도쿄, 뉴욕, LA] 
    	ArrayList<String> tmp_list = new ArrayList<>();
    	
    	for (String s :cities) {
    		if(s.equals("")) {}
    		else {
    			tmp_list.add(s);
    		}
    	}
    	
    	String new_cities[] = new String[0];
    	new_cities =tmp_list.toArray(new_cities);
    	
    	return new_cities;
    }
    
    
    public static String[] removeElement1(String[] arr, String item) {
    	
    	int count = 0;
    	for(int j=0 ;  j<arr.length ; j++) {
    		if (arr[j].equals(item)) {
    			count+=1;
    		}
    	}
    	//System.out.println(count);
    	
    	int idx []= new int [count];
    	int idx_count=0;    	
    	for(int j=0 ;  j<arr.length ; j++) {
    		if (arr[j].equals(item)) {
    			idx[idx_count]=j;
    			idx_count +=1;
    		}
    	}
    	//System.out.println(Arrays.toString(idx));
    	
    	if (idx.length >=2) {
    		for (int i = 1 ; i<idx.length ; i++) {
    			arr[idx[i]] = "";
    		}
    	}
    	
    	//System.out.println(Arrays.toString(arr));
    	
    	return arr;
    }

    
    public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		getList(list);
		showList("입력후", list);
		
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
	   //오름차순
		Collections.sort(list);
		System.out.println();
		showList("오름차순 정렬후", list);
		
		//내림차순
		sortList(list);
	    System.out.println();
	    showList("내림차순 정렬후", list);
	    
	    //배열에서 중복제거
	    System.out.println();
	    System.out.println("중복제거::");
	  
	    String[] cities = removeDuplicateList(list);
        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
	    showList("중복제거후", lst);
	}

}
