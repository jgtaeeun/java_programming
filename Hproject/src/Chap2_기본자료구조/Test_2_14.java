package Chap2_기본자료구조;
//교재 67 - 실습 2-5
//2번 실습

import java.util.Arrays;

//import java.util.Arrays;
//import java.util.Random;


class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name=name;
		this.height=height;
		this.vision=vision;
	}
	
	@Override
	public String toString() {
		return name+" "+height+" "+vision;
	}
	@Override
	public int compareTo(PhyscData p) {
		return this.name.compareTo(p.name);
	}
	public boolean equals(PhyscData p) {
		return this.name.equals(p.name);
	}
}





public class Test_2_14 {

	public Test_2_14() {
		// TODO Auto-generated constructor stub
		
	}
	
	static void showData(String txt,PhyscData[] data) {
			for (int i=0 ; i<data.length ; i++) {
				//System.out.println( data[i].name + " " + data[i].height + " "+ data[i].vision);
				System.out.println(data[i].toString()); // 
			}
			System.out.println();
	}
	
	static PhyscData[] insertObject(PhyscData[] data, PhyscData p){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		PhyscData[] newData= new  PhyscData [data.length+1];
		
			if (data[data.length-1].name.compareTo(p.name) <0) {       //insert되는 것이 가장 큰 값일 때 
			     newData[data.length]=p;
			     for (int i=0 ; i<data.length ; i++) {
			    	 	newData[i]=data[i];
			     }     
			}
			else {   //insert되는 것이 중간에 삽입되어야 하는 경우
				 for (int i=0 ; i<data.length ; i++) {
			    	 if(data[i].name.compareTo(p.name) >0 ) {
			    		 PhyscData tm= data[i];
			    		 data[i]=p;
			    		 p=tm;
			    	 } 	 
			     } 
				 for (int i=0 ; i<data.length ; i++) {
			    	 	newData[i]=data[i];
			     } 
				 newData[data.length]=p;
			}
			
		
		return newData;
	}
	
	static void swap(PhyscData[] data, int i, int j) {
		PhyscData tmp = data[i];
		data[i] =data[j];
		data[j]=tmp;
	}
	
	static void sortData(PhyscData[] data) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		for (int i=0 ; i<data.length ; i++) {
			for(int j=i+1 ; j<data.length ;j++) {
				if(data[i].name.compareTo(data[j].name)==0) {    //이름이 같은 경우
					// 이름이 같으면 키 값을 정렬
					if(data[i].height ==data[j].height) {  // 키 값이 같으면
						if (data[i].vision > data[j].vision) {    //시력으로 정렬 
							swap(data, i, j); 
						}
					}
					else if( data[i].height >data[j].height) {   // 키 값을 정렬
						swap(data, i, j);
					}
					
				}
				else if (data[i].name.compareTo(data[j].name)>0){  //이름순서대로 정렬
					swap(data, i, j);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길동", 162, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("이길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		PhyscData[] newData= insertObject(data, new PhyscData("이기자", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
		 
	}
	

}
