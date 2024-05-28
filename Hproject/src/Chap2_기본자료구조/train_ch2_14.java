package Chap2_기본자료구조;

public class train_ch2_14 {

	public train_ch2_14() {
		// TODO Auto-generated constructor stub
	}
	static void showData(String txt,String []data) {//확장된 for 문으로 출력 
		System.out.print(txt+' '+'[');
		for(String s : data) {
			System.out.print(s);
			System.out.print(',');
		}
		System.out.print(']');
		System.out.println();
	}
	
	static void swap(String []data, int n1, int n2) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String tmp = data[n2];
		data[n2]=data[n1];
		data[n1]=tmp;
		
	}
	
	static void sortData(String []data) {//올림차순으로 정렬
		for (int i = 0 ; i<=data.length-2 ; i++) {
			for (int j = data.length-1 ; j>i ; j--) {
				if (data[j-1].compareTo(data[j])>0) {
					swap(data, j-1, j);
				}
			}
		}
	}
	
	
	
	
	static String [] insertString(String []data, String s){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		
		String[] newString=new String[data.length+1];
		
	//	System.out.println(Arrays.toString(newString));
		
		if (data[data.length-1].compareTo(s) <=0 ) {
			newString[data.length]=s;
			for (int i=0 ; i <data.length ;i++) {
				newString[i]=data[i];
			}
		}
		else {  //1개씩 이동
			for (int i=0 ; i <data.length ;i++) {
				if (data[i].compareTo(s) >0 ) {
					String tmp = data[i];
					data[i]=s;;
					s=tmp;
				}	
			}
			for  (int i=0 ; i <data.length ;i++) {
				newString[i]=data[i];
			}
			newString[data.length]=s;
		}
		return newString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후", newData);
	}

}
