package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test04 {

	public Test04() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		FileInputStream fi = new FileInputStream("a.txt");//throws FileNotFoundException
		int c =fi.read();//throws IOException 
		System.out.println((char)c);
	}

}
