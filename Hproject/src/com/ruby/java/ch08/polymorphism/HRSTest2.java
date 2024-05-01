package com.ruby.java.ch08.polymorphism;


public class HRSTest2 {

	public HRSTest2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void calcTax() {
	    	System.out.println("소득세를 계산합니다.");
	}
	  
    public static void calcTax(Employee e) {
    	if (e instanceof Salesman) {
    		Salesman s = (Salesman) e; //
    		s.annual_sales = 6500000;
    		System.out.println("Salesman입니다." + s.annual_sales);
    	}
    	else if (e instanceof Manager){
    		Manager m = (Manager) e; //
    		m.num_team = 5;
    		System.out.println("Manager입니다."+m.num_team);
    	}
    	else if (e instanceof Consultant){
    		Consultant c = (Consultant) e; //
    		c.num_project = 35;
    		System.out.println("Consultant입니다."+c.num_project);
    	}
    	else System.out.println("Employee입니다.");
    }
  
 
    
    public static void main(String [] args) {
    	Salesman s = new Salesman ();
    	Consultant c = new Consultant();
    	Manager m = new Manager();
    	
    	calcTax(s);
    	calcTax(m);
    	calcTax(c);
    
    	
    }
}

