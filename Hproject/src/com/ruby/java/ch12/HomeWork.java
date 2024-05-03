package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class HomeWork {

	public HomeWork() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(BufferedReader br = new BufferedReader(new FileReader("m.txt"));){
			
			String s ;
			while((s=br.readLine())!=null) {
				String [] arr= s.split(" ");
				for(int i=0;i<arr.length;i++) {
					System.out.print(Integer.parseInt(arr[i])+" ");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}