package com.ruby.java.ch07.abstraction;

public  interface Messneger {

	//인터페이스 필드
	 int MIN_SIZE = 1;
	 int MAX_SIZE = 104857600;

	//인터페이스 메서드
	public abstract String getMessage();

	public abstract void setMessage(String msg);

	public default void setLogin(boolean login) {
		log();
		if (login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다");
		}
	}

	public static void getConnection() {
		System.out.println("network에 연결합니다.");
	}

	private void log() {
		System.out.println("start job!");
	}
}

