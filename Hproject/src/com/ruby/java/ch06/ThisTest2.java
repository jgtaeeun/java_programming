package com.ruby.java.ch06;

//class Student {
//	String name;       //default 선언>현 자바 파일에서 접근 가능, 외부에서는 private
//	private int age;
//	private String getName() {
//		return name;
//	}
//}



public class ThisTest2 {

	

	
		private String name;
		
		public ThisTest2() {}        //기본생성자
		
		public ThisTest2(String name) {           //생성자 오버로딩
			this.name=name;
		}

		public void setName(String name) {
			this.name = name;      //this.name은 ThisTest2의 필드 name
		}

		public String getName() {
			return name;
		}

		public static void main(String[] args) {
			ThisTest2 exam = new ThisTest2("hong");    //new는 heap에 공간 할당, 참조변수 주소 반환
			exam.setName("Hong");
			
//			Student s= new Student();
//			s.name = "g";
			//s.getName(); 
			// s.age=11;
		}
}
