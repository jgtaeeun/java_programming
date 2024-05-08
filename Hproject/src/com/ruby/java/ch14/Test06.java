package com.ruby.java.ch14;

interface MyFunc<T> {
	T modify(T t);
}

public class Test06 {

	public static void main(String[] args) {

		MyFunc<String> mf1 = (str) -> str.toUpperCase() + ":" + str.length();
		System.out.println(mf1.modify("java"));
		System.out.println(mf1.modify("java programming"));

		MyFunc<Integer> mf2 = (n) -> n * 2;
		System.out.println(mf2.modify(23));
	//	System.out.println(mf2.modify(23.2));//Integer modify(Integer t)이기에 double형은 에러난다.
		System.out.println(mf2.modify(42));
	}
}