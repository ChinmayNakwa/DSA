import java.util.*;

class Student{
	public int age;
	public String name;

	void display() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
	}
}


class Department extends Student{
	
	String department;

	void accept_dep() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Enter age");
		age = sc.nextInt();
		sc.nextLine();		System.out.println("Enter department");
		department = sc.nextLine();
		
	}
	
	void print(){
		System.out.println("Department"+ department);
	}

	public static void main(String args[]) {
		Department obj = new Department();
		obj.accept_dep();
		obj.display();
		obj.print();
	}
}









/*
class Student{
	public int age;
	public String name;

	Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	void display() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
	}
}

class Department extends Student{
	
	String department;

	Department(int age, String name, String department){
		super(age, name);
		this.department = department;
	}
	
	void print(){
		System.out.println("Department"+ department);
	}

	public static void main(String args[]) {
		Department obj = new Department(18, "Ashish", "IT");
		obj.display();
		obj.print();
	}
}
*/