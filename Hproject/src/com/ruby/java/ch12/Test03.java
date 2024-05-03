package com.ruby.java.ch12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test03 {

	public Test03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("이름 입력");
			String name=br.readLine();
			System.out.println("HELLO" +name);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
