package com.ruby.java.ch11;

public class Test05 {
	int battery = 0;
	
	public Test05() {
		// TODO Auto-generated constructor stub
	}

	public void charge(int time) throws Exception {
		if (time < 0) {
			    
				throw new NegativeNumberException();
			
		}
		battery += time;
		System.out.println("현재 배터리: "+battery);
	}
	
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		Test05 test=new Test05();
		try {
			test.charge(30);
			test.charge(20);
			test.charge(-10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
