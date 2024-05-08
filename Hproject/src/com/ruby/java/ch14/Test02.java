package com.ruby.java.ch14;
@FunctionalInterface     //인터페이스 추상메소드가 2개이상일 때 에러알린다.
interface Multiply {
	double getValue();//인터페이스의 추상메소드 1개일 때 =함수 인터페이스
	//void setValue();     //인터페이스의 추상메소드 2개일 때, 람다식에서 ()가 무엇을 가리키는 것인지 모른다. 
}

public class Test02 {

	public static void main(String[] args) {

		Multiply m;
		m = () -> 3.14 * 2;
		System.out.println(m.getValue());

		m = () -> 10 * 3;
		System.out.println(m.getValue());
	}
}