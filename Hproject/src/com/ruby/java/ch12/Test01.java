package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {

	public Test01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fi = new FileInputStream("a1.txt");       //;으로 끝내줘야함
				FileOutputStream fo = new FileOutputStream("b.txt");){
			int c = 0;
			while((c=fi.read())!=-1) {
				fo.write(c);
				System.out.println(c + "\t" + Integer.toHexString(c) + "\t" + (char)c); //ASCII 16진수 문자형
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
