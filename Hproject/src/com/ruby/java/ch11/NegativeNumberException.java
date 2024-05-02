package com.ruby.java.ch11;

import java.io.IOException;

public class NegativeNumberException extends Exception{

	public NegativeNumberException() {
		// TODO Auto-generated constructor stub
		super("음수는 허용되지 않습니다.");
	}
	
}
