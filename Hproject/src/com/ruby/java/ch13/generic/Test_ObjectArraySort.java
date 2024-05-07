package com.ruby.java.ch13.generic;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Student{
	String sno;
	String sname;
	public Student(String sno, String sname) {
		// TODO Auto-generated constructor stub
		this.sno=sno;
		this.sname=sname;
	}
	public String toString() {
		return sno  + ", "+sname ;
		
	}
	

}
class SnoComparator implements Comparator<Student> {    //Comparator<T>
   @Override
   public int compare(Student s1, Student s2) {           // public int compare(Student s1, Student s2);추상메소드 구현
       // 학번을 기준으로 비교
	   
       return s1.sno.compareTo(s2.sno);
   }
}
public class Test_ObjectArraySort {

	static void showData(String msg, Object[]data) {
		System.out.print(msg + ": ");
		for(int i=0 ; i<data.length ; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String [] stringData = {"apple","grape","blueberry","banana"};   //String타입 배열
		Student [] data = {                                              //Student 객체 타입 배열
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍")
		};
		
		
		showData("정렬전", stringData);
		Arrays.sort(stringData);
		showData("정렬후", stringData);
		System.out.println();
		
		showData("정렬전", data);
		
		
		Arrays.sort(data, new SnoComparator());
		showData("정렬후", data);
	}

}

