/*
Design a class for student entity and consider relevant abstract data. 
Accept and display the data for 5 objects using array of objects. 
*/
import java.util.*;

class Students {
	String name;
	int age, roll_no;
	Students(String name, int age, int roll_no) throws IllegalArgumentException {

		if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        if (roll_no <= 0) {
            throw new IllegalArgumentException("Invalid roll number: " + roll_no);
        }

		this.name = name;
		this.age = age;
		this.roll_no = roll_no;
	}
	
	void update_name(String new_name) {
		this.name = new_name;
	}
	
	int age() {
		return this.age;
	}
	
	void display() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Roll No: "  + this.roll_no);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of students");
		int no = sc.nextInt();
		sc.nextLine();
		Students[] obj = new Students[no];
		try {
			for(int i = 0; i < no; i++) {
				System.out.println("Enter name, age");
				String name = sc.nextLine();	
				int age = sc.nextInt();
				sc.nextLine();
				obj[i] = new Students(name, age, i+1);		
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
		
		
		
		int choice = 0;
		
		do {
				
				System.out.println("1. To display Students");
				System.out.println("2. To Update Name");
				System.out.println("3. To get age of a student");
				System.out.println("4. Exit");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
					
					case 1:
					System.out.println("Displaying Students");
					for(int i = 0; i < no; i++) {
						obj[i].display();
					}
					break;
					
					case 2:
					try {
						System.out.println("Enter roll no of the person");
						int rno = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter name to be updated");
						String new_name = sc.nextLine();
						obj[rno-1].update_name(new_name);
					} catch (InputMismatchException e) {
						System.out.println(e);
					}
					break;
					
					case 3:
					try {
						System.out.println("Enter roll no of the person");
						int rno = sc.nextInt();
						sc.nextLine();
						System.out.println("Age: " + obj[rno-1].age());
					} catch (InputMismatchException e) {
						System.out.println(e);
					}
					break;
					
					case 4: 
					System.out.println("Exiting...");
					System.exit(0);
					break;
					
					default: 
					System.out.println("Wrong input");
					break;
				}
		}while(choice != 4);
		
		sc.close();
	}
}


