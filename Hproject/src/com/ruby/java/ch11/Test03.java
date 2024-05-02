package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test03 {

	public Test03() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
	
		try(FileInputStream fi = new FileInputStream("a.txt")){
			int c =fi.read();
			System.out.println((char)c);
		}	catch(IOException e) {
			e.printStackTrace();
		}
	
		FileInputStream fi = null;
		
		try{
			fi = new FileInputStream("a.txt");
			int c =fi.read();
			System.out.println((char)c);
		}	catch(IOException e) {
			e.printStackTrace();
			return;
		}	finally {
			try {
				fi.close();//add throws문 또는 try-catch문으로 감싸기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	
		
		
		
	}
}
