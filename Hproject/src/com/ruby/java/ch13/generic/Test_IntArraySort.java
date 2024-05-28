package com.ruby.java.ch13.generic;
import java.util.Arrays;
import java.util.Random;
public class Test_IntArraySort {

	public Test_IntArraySort() {
		// TODO Auto-generated constructor stub
	}
	static void showData(Object[]data) {   //Object클래스
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+ " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
	int [] data = new int[20];
	Integer[]data2 = new Integer[20];
	double []doubleData = new double[20];
	String [] stringData = {"apple","grape","blueberry","banana"};
	
	Random rnd =  new Random();
	for (int i = 0; i < data.length; i++) {data[i]=rnd.nextInt(); doubleData[i]=rnd.nextDouble();}
	
	
	//-----------------------------------

//정수->문자열 Integer.toString
//실수->문자열 Double.toString
	
	//-----------------------------------

	System.out.println("data[] 정렬전 :");
	for (int i = 0; i < data.length; i++) {System.out.print(data[i]+ " ");}
	Arrays.sort(data);
	for (int i = 0; i < data.length;i++)
		data2[i] = data[i];
	//Object [] intdata = new Object[20]; for (int j = 0; j < intdata.length; j++) {intdata[j]=data[j];}
	//String [] intsdata = new String [20]; for (int j = 0; j < intsdata.length; j++) {intsdata[j]=Integer.toString(data[j]);}
	System.out.println();
	showData(data2);
	
	
	
	System.out.println();
	//-----------------------------------
	
	System.out.println("doubleData[] 정렬전 :");
	for (int i = 0; i < doubleData.length; i++) {System.out.print(doubleData[i]+ " ");}
	
	Arrays.sort(doubleData);
	//Object [] doubleData2 = new Object[20]; for (int k = 0; k < doubleData2.length; k++) {doubleData2[k]=doubleData[k];}
	String [] doubleData2 = new String [20]; for (int j = 0; j < doubleData2.length; j++) {doubleData2[j]=Double.toString(doubleData[j]);}
	System.out.println();
	showData(doubleData2);
	
	//-----------------------------------
	System.out.println();
	
	System.out.println("stringData[] 정렬전 :");
	for (int i = 0; i < stringData.length; i++) {System.out.print(stringData[i]+ " ");}
	
	Arrays.sort(stringData);
	
	System.out.println();
	showData(stringData);
	//출력 
	}
}
