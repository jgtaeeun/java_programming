package com.ruby.java.ch08.innerclass;

public class GalaxyMessenger implements Messenger{

	public GalaxyMessenger() {
		// TODO Auto-generated constructor stub
	}
    
	public String getMessage() {
		 return "galaxy";
	}
	
	public void setMessage(String msg) {
		System.out.println("galaxy에서 메시지를 설정합니다.:" + msg);
	}
	
	public void changeKeyboard() {
		System.out.println("키보드 아이콘 터치 후 키보드를 변경합니다.");
	}
}
