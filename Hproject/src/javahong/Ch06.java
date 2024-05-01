package javahong;

//6장 실습 구현 - this 사용 생성자 구현 

class Employee {
	protected int pid;
	protected String name;
	protected int age;
	protected int eno;
	protected String dept;
	protected float salary;
	
	public Employee() {		
	}
	
	public Employee(int pid, String name) {		
//            this.pid=pid;
//            this.name=name;
		      this(pid, name, 0, 0);
	}
	
	public Employee(int pid, String name, int age, int eno) {		
//        this.pid=pid;
//        this.name=name;
//        this.age=age;
//        this.eno =eno;
		  this(pid, name,age, eno, null, 0.0f);
   }
	
	public Employee(int pid, String name, int age, int eno, String dept, float salary) {		
        this.pid=pid;
        this.name=name;
        this.age=age;
        this.eno =eno;
        this.dept=dept;
        this.salary=salary;
   }
	@Override
	
	//해당값이 없어도 초기값으로 출력하고 싶을 때
	public String toString() {
        return pid + ", " + name + ", " + age + ", " + eno + ", " + dept + ", " + salary;
	}
    
	//해당값만 선택해서 출력하고 싶을 때
	public int getPid() {return pid;}
	public String getName() {return name;}
	
	public String getResult() { return pid+name;}
	
}

public class Ch06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Employee[]arr = new Employee[6];
	  arr[0] = new Employee();
	  arr[1] = new Employee(3, "Park");
	  arr[2] = new Employee(3, "Park", 30, 2001);
      arr[3] = new Employee(4, "Choi", 35, 2002, "Engineering", 4000);
      arr[4] = new Employee(5, "Kang", 22, 1003, "Physics", 4);
      arr[5] = new Student(5, "Kang", 22, 1003, "Physics", 4);
		for(Employee p : arr) {
			System.out.println(p.toString());
		}
     Employee s = new Employee (3, "Park") ;
     System.out.println( s.getPid()+s.getName());
     System.out.println( s.getResult());
	}

}
