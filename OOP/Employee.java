import java.util.*;
class Employee 
{
	String name;
	double bp, ta, hra, salary;
	static int count;
	
	static void count(){
		count++;
	}

	void accept() {
		count();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		name = sc.nextLine();
		System.out.println("Enter Salary");
		bp = sc.nextDouble();
	}		

	void calculate(){
		hra = bp * 0.1;
		ta = bp * 0.05;
		salary = bp + hra + ta;
	}
	void display() {
		System.out.println("Name: "+name);
		System.out.println("Salary: "+salary);
		System.out.println("BP: "+bp);
		System.out.println("TA: "+ta);
		System.out.println("HRA: "+hra);
	}
	
	public static void main(String args[]) {
		count = 0;
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		emp1.accept();
		emp1.calculate();
		emp1.display();
		emp2.accept();
		emp2.calculate();
		emp2.display();
		System.out.println("Number of Employees "+count);
	}
}