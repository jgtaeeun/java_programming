package com.ruby.java.ch07.abstraction;

public class GalaxyMessenger implements Messneger, WorkFile{

	public GalaxyMessenger() {
		// TODO Auto-generated constructor stub
	}
	public  String getMessage() {
		return "galaxyphone";
	}
	

	public void setMessage(String msg) {
		System.out.println("Galaxy에서 메시지를 설정합니다.: " +msg);
	}
	@Override
	public void fileUpload() {
		// TODO Auto-generated method stub
		System.out.println("fileUpload");
	}
	@Override
	public void fileDownload() {
		// TODO Auto-generated method stub
		System.out.println("fileDownload");
	}
	
}
