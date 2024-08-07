package com.ruby.java.ch08.innerclass;


public class MessengerTest {

	public MessengerTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//인터페이스에서 상속받은 일반클래스 GalaxyMessenger를 통해 인스턴스 객체를 통해 함.
//       GalaxyMessenger galaxy =  new GalaxyMessenger();
//       galaxy.getMessage();
//       galaxy.setMessage("hi");
//       galaxy.changeKeyboard();
		
		
		//일회용이기에 익명클래스를 사용해서 함.
		Messenger m = new Messenger() {

			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "galaxy";
			}

			@Override
			public void setMessage(String msg) {
				// TODO Auto-generated method stub
				System.out.println("galaxy에서 메시지를 설정합니다.  : " + msg);
			}
			
		
			
		};
		
		System.out.println(m.getMessage());
		m.setMessage("have a nice day");
	}

}
