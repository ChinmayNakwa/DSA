/*Design and Develop inheritance for a given case study, identify objects and relations and implement inheritance wherever applicable. 
Employee class with Emp_name, Emp_id, Address, Mail_id, and Mobile_no as members. 
Inherit the classes, Programmer, Assistant Professor, Associate Professor and Professor from employee class. 
Add Basic Pay (BP) as the member of all inherited classes with 97% of BP as DA, 10% of Bp as HRA, 12% of BP as PF, 0.1% of BP for staff club fund. 
Generate pay slips for the employees with their gross and net salary.*/

import java.util.*;

abstract class Employee {
	String emp_name, address, mail_id;
	int emp_id, mobile_no;
	double BP;
	
	Employee(String name, String add, String mail, int emp_id, int mob, double BP) {
		this.emp_name = name;
		this.address = add;
		this.mail_id = mail;
		this.emp_id = emp_id;
		this.mobile_no = mob;
		this.BP = BP;
	}
	
	void display() {
	System.out.println("Name: " + emp_name);
       	System.out.println("Mail: " + mail_id);
        System.out.println("Address: " + address);
        System.out.println("ID: " + emp_id);
        System.out.println("Mobile Number: " + mobile_no);
	}
	
	void paySlip() {
	System.out.println("DA: " + (BP * 0.97));
        System.out.println("HRA: " + (BP * 0.1));
        System.out.println("PF: " + (BP * 0.12));
        System.out.println("Staff Club Fund: " + (BP * 0.001));
        System.out.println("Gross Salary: " + ((BP * 0.97) + (BP * 0.1)));
        System.out.println("Net Salary: " + ((BP * 0.97) + (BP * 0.1) - (BP * 0.12) - (BP * 0.001)));
	}
}

class Programmer extends Employee{
	public Programmer(String name, String add, String mail, int emp_id, int mob, double BP) {
		super(name, add, mail, emp_id, mob, BP);
	}
}

class AssistantProfessor extends Employee{
	public AssistantProfessor(String name, String add, String mail, int emp_id, int mob, double BP) {
		super(name, add, mail, emp_id, mob, BP);
	}
}

class AssociateProfessor extends Employee{
	public AssociateProfessor(String name, String add, String mail, int emp_id, int mob, double BP) {
		super(name, add, mail, emp_id, mob, BP);
	}
}

class Professor extends Employee{
	public Professor(String name, String add, String mail, int emp_id, int mob, double BP) {
		super(name, add, mail, emp_id, mob, BP);
	}
}	

class College {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        String name, address, mail;
        int id, mobile_no;
        double BP;

        System.out.println("Enter Employee Details:");
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Mail: ");
        mail = sc.nextLine();
        System.out.print("Address: ");
        address = sc.nextLine();
        System.out.print("ID: ");
        id = sc.nextInt();
        System.out.print("Mobile Number: ");
        mobile_no = sc.nextInt();
        System.out.print("Basic Pay: ");
        BP = sc.nextDouble();

        System.out.println("Select Employee Type:");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Programmer programmer = new Programmer(name, mail, address, id, mobile_no, BP);
                programmer.display();
                programmer.paySlip();
                break;
            case 2:
                AssistantProfessor assistantProfessor = new AssistantProfessor(name, mail, address, id, mobile_no, BP);
                assistantProfessor.display();
                assistantProfessor.paySlip();
                break;
            case 3:
                AssociateProfessor assosciateProfessor = new AssociateProfessor(name, mail, address, id, mobile_no, BP);
                assosciateProfessor.display();
                assosciateProfessor.paySlip();
                break;
            case 4:
                Professor professor = new Professor(name, mail, address, id, mobile_no, BP);
                professor.display();
                professor.paySlip();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        sc.close();	
	}
}