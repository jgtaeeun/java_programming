package com.ruby.java.ch13.generic;
import java.util.Arrays;
import java.util.Random;
public class Test_IntArraySort {

	public Test_IntArraySort() {
		// TODO Auto-generated constructor stub
	}
	static void showData(Object[]data) {
		System.out.println(data.getClass().getName() + " showData");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
	int [] data = new int[20];
	double []doubleData = new double[20];
	String [] stringData = {"apple","grape","blueberry","banana"};
	
	Random rnd =  new Random();
	for (int i = 0; i < data.length; i++) {data[i]=rnd.nextInt(); doubleData[i]=rnd.nextDouble();}
	
	Object [] intdata = new Object[20]; for (int j = 0; j < intdata.length; j++) {intdata[j]=data[j];}
	Object [] doubleData2 = new Object[20]; for (int k = 0; k < doubleData2.length; k++) {doubleData2[k]=doubleData[k];}
	
	Arrays.sort(intdata);
	showData(intdata);
	System.out.println();
	Arrays.sort(doubleData2);
	showData(doubleData2);
	System.out.println();
	Arrays.sort(stringData);
	showData(stringData);
	//출력 
	}
}
