package com.ruby.java.ch14.lamda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;




/* 과제목표 : 제네릭, 람다식으로 Comparator, compare 만들어서 정렬하기
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 *       
 *       
 *       
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
  //interface Comparator, interface Comparable은 자바에 내장되어있으므로 따로 선언할 필요없다. import하면 된다.
//interface Comparator =>compare(T 01, T 02)
// interface Comparable=>compareTo(T o)

class Student  {
	String sno;
	String sname;
	
	public Student(String sno, String sname) {
		// TODO Auto-generated constructor stub
		this.sno=sno;
		this.sname=sname;
	}
	public String toString() {
		return"(" +sno  + ", "+sname +")";
		
	}
	 
}


public class ObjectSort_lamda {
	
	
	static void sortStudents(Student[] Array) {
				
		}

	
	static void showStudents(String msg, Object[] data) {
		System.out.print(msg + ": ");
		for(int i=0 ; i<data.length ; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();

	}
	
	static void showStudents(String msg, List<Student> list) {
		System.out.print(msg + ": ");
		
		System.out.print(list);
		
		System.out.println();

	}
	
	
	
	public static void main(String[] args) {
		
		
		Comparator<Student> snameComp = new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					return s1.sname.compareTo(s2.sname);    //문자열은 .compareTo() 메서드 쓴다.
				}
			
		};
		
		//문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
		Comparator<Student> compSno = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return Integer.parseInt(s1.sno)-Integer.parseInt(s2.sno);
			}
		};
		
		Comparator<Student> compSno2 = (s1,  s2) ->Integer.parseInt(s1.sno)-Integer.parseInt(s2.sno);
		
        Student[] sArray = new Student[5];
        
        // Student 객체 생성 및 배열에 할당
        sArray[0] = new Student("121", "Alice");
        sArray[1] = new Student("33", "Bob");
        sArray[2] = new Student("9", "Charlie");
        sArray[3] = new Student("2", "John");
        sArray[4] = new Student("39", "Bobby");
        // ArrayList로 변환
        ArrayList<Student> sList = new ArrayList<>();
        for (Student student : sArray) {
            sList.add(student);
        }
        showStudents("sno 정렬전", sArray);
        //문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
        Arrays.sort (sArray, compSno);
        showStudents("sno 정렬후", sArray);
        
        
        
        showStudents("sname 정렬전", sArray);
        //문제2: Arrays.sort()를 사용한 sArray 정렬 - sname 사용, 익명 객체 사용
     
        Arrays.sort (sArray,snameComp);
        showStudents("sname 정렬후", sArray);
       
        
        
        showStudents("sno 정렬전", sList);
        //문제3: Collections.sort()를 사용한 sList 정렬 - sno 사용, 람다식 사용
        Collections.sort(sList,compSno2);
        showStudents("sno 정렬후", sList);
       
        
        
        showStudents("sname 정렬전", sList);
        //문제4: Collections.sort()를 사용한 sList 정렬 - sname 사용
        Collections.sort(sList,snameComp);
        showStudents("sname 정렬후", sList);
        
       
        
        showStudents("sno 정렬전", sArray);
        //문제5: sortStudents()를 사용한 sArray 정렬 - sno 사용
       // sortStudents(sArray);
        //showStudents("sno 정렬후", sArray);
	}

}