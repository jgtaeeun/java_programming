package Chap3_검색알고리즘;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test_중복없는리스트합병 {
	public static void showData(String txt, String[] sarray) {
		System.out.print(txt);
		System.out.println(Arrays.toString(sarray));
	}
	
	public static void showList(String txt, List<String>list1) {
		System.out.print(txt);
		for (int i=0 ; i<list1.size() ; i++) {
			System.out.print(list1.get(i)+",");
			
		}
		System.out.println();
	//	System.out.println(list1.size());
		
		
	}
	
	static void trimSpace(String[]arr) {
		/*
		 * string.trim() 사용으로 좌우 빈공백 제거
		 */
		for (int i = 0; i <arr.length; i++) {
			arr[i] = arr[i].trim();
		}
	}
	
	static void makeList(String[] sarray1, List<String>list1) {
		/*
		 * 배열을 list로 만드는 함수 구현 lst.add() 호출
		 */
		for (String temp : sarray1) {
			list1.add(temp);
		}
	}
	
	static ArrayList<String> removeDuplicate(ArrayList<String> al) {//중복 제거
		/*
		 * 구현할 부분 : 리스트에서 중복을 제거한다 - 배열로 변환하여 구현하는 것이 아님 
		 * 리스트를 정렬한후에 이 함수가 호출된다
		*/
		
		ArrayList<String> list1 = new ArrayList<>();
		for (String s : al) {
			if (list1.contains(s)==false) {
				list1.add(s);
			}
		}

		return list1;
	}

 
	static List<String> mergeList(List<String> list1, List<String> list2) {
		/*
		 * list3 = merge(list1, list2);으로서 새로운 리스트에 정렬 값 순서로 merge하는 알고리즘 구현 
		 */
		ArrayList<String> list3 = new ArrayList<>();
		// ------- ArrayList의 get()을 사용한 merge
		for (int i = 0 ; i< list1.size() ; i++) {
			list3.add(list1.get(i));
		}
		
		for( int i = 0 ; i< list2.size() ; i++) {
			list3.add(list2.get(i));
		}
		
		Collections.sort(list3);
		list3=removeDuplicate(list3);
		
		
		return list3;			
	}
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
		for (int i=0; i < n ;i++) {
			if (s[i].equals(key)) {
				return 1; 
			}
		}
	    return -1;
		
	}
	
	static void writeFile(List<String> list3, ByteBuffer buffer) {
		String b = " ";
		for (String sx : list3) {
			//System.out.println(" " + sx);
			buffer.put(sx.getBytes());
			buffer.put(b.getBytes());
		}
		buffer.flip();
	}
	
	
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("b1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			//readAllBytes: 파일의 모든 바이트를 읽어오는 메서드입니다. 
			//이 메서드는 파일을 열고 파일의 크기만큼 바이트를 읽어서 바이트 배열로 반환합니다.
		//	System.out.println("b1.txt bytes[]의 길이 = "+bytes1.length);
			Path input2 = Paths.get("b2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);
		//	System.out.println("b2.txt bytes[]의 길이 = "+bytes2.length);
			
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);
		//	System.out.println("입력 스트링: s1 = " + s1);
		//	System.out.println("입력 스트링: s2 = " + s2);
			
			String[] sarray1 = s1.split(",");// [,\\s]+\r\n은 쉼표나 공백이 하나 이상 나오고 이어서 캐리지 리턴과 개행 문자가 있는 패턴
			String[] sarray2 = s2.split(",");//file에서 enter키는 \r\n으로 해야 분리됨
		//	showData("스트링 배열 sarray1", sarray1); System.out.println(sarray1.length);
		//	showData("스트링 배열 sarray2", sarray2); System.out.println(sarray2.length);
			
			trimSpace(sarray1);
			trimSpace(sarray2);
			
		//	showData("trimSpace() 실행후 :스트링 배열 sarray1", sarray1) ;  System.out.println(sarray1.length);
		//	showData("trimSpace() 실행후 :스트링 배열 sarray2", sarray2); System.out.println(sarray2.length);
		//	System.out.println("+++++++\n");
			
			// 방법1
			ArrayList<String> list1 = new ArrayList<>();
			makeList(sarray1, list1);
		//	showList("리스트1: ", list1);
			
			// 방법2
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));
		//	showList("리스트2: ", list2);
			
		//	System.out.println("+++++++ collection.sort()::");
			Collections.sort(list1);
		//	showList("정렬후 리스트1: ", list1);
			
			//Arrays.sort(list2, null);//에러 발생 확인하고 이유는?  list는 Collection이다. cf)배열은 Array 이다.
			
			Collections.sort(list2);
		//	showList("정렬후 리스트2: ", list2);
			
			//정렬된 list에서 중복 제거 코드
			list1 = removeDuplicate(list1);
			list2 = removeDuplicate(list2);
		//	showList("중복 제거후 리스트1: ", list1);	
		//	showList("중복 제거후 리스트1: ", list2);	
			
			
			
			List<String> list3 = new ArrayList<>();
			// 방법3:
			list3 = mergeList(list1, list2);
			showList("merge후 합병리스트: ", list3);	
			
			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			System.out.println(Arrays.toString(st));
			
			// binary search 구현
			binSearch(st, st.length, "key");
			//System.out.println(binSearch(st, st.length, "key"));
			
			// 정렬된 list3을 file에 출력하는 코드 완성
			System.out.println("\n" + "file에 출력:");
			int bufferSize = 10240;
						
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			writeFile(list3, buffer);
			
			FileOutputStream file = new FileOutputStream("c.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
		
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
