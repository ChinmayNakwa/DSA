import java.util.*;

class Company {
	String company_name;
	Employee emp[];
	static int count = 0;
	static int c_id = 1;
	int id = 1;

	Company(String company_name) {
		this.company_name = company_name;
		System.out.println("Company ID: "+c_id);
		Counter();
	}
	
	class Employee {
		String name;
		int age;
		int emp_id;
	
		Employee(String name, int age){
			this.name = name;
			this.age = age;
			emp_id = id;
			System.out.println("Employee Id: "+emp_id);
			id++;
			counter();
		}
			
		void display() {
			System.out.println("-------------------------------------------------------");
			System.out.println("Name: "+name);
			System.out.println("Age: "+age); 
			System.out.println("-------------------------------------------------------");
		}
		
		static void counter(){
			count++;
		}

		static int[] Age_array (Employee Emp[]) {
			int l = Emp.length;
			int k[] = new int[l];
			int j=0;
			for(int i = 0; i < l; i++) {
				if(Emp[i].age > 20) {
					k[j++] = i;
				} 
			}
			int result[] = new int[j];
			System.arraycopy(k, 0, result, 0, j);
			return result;
		}
		
	}
	
	void accept_emp_details() {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		System.out.println("Enter number of employees");
		int no_of_employees = sc.nextInt();
		sc.nextLine();
		emp = new Employee[no_of_employees];
		for(int i = 0; i < no_of_employees; i++) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Enter employee name");
			name = sc.nextLine();
			System.out.println("Enter employee age");
			age = sc.nextInt();
			sc.nextLine();
			emp[i] = new Employee(name, age);
			System.out.println("------------------------------------------------------------------------------");
		} 
	}

	void emp_display() {
		System.out.println("Company Name" + company_name);
		for(int i = 0; i < 2; i++) {
			emp[i].display();
		}
	}

	static void Counter() {
		c_id++;
	}

	void greater_than_18(){
		int arr[] = Employee.Age_array(emp);
		int k=0;
		for (int i = 0; i < arr.length; i++) {
			emp[arr[k++]].display();
		}
	}

	static int factorial(int i){
		if(i == 1 || i == 0){
			return 1;
		} 
		return  i * factorial(i-1); 	
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of companies");
		int no_of_companies = sc.nextInt();
		sc.nextLine();
		Company cmp[] = new Company[no_of_companies];
		String c_n;
		for (int i = 0; i < no_of_companies; i++) {
			System.out.println("Enter company name: ");
			c_n = sc.nextLine();
			cmp[i] = new Company(c_n);
		}

		
		
		int c;
		do {
			System.out.println("=============================================================================================");
			System.out.println("Menu");
			System.out.println("Enter 1 to enter the details of the employees");
			System.out.println("Enter 2 to display the details of employees in a particular company");
			System.out.println("Enter 3 to find the age of employees greater than 20 in a given company");
			System.out.println("Enter 4 to get the total count of employees in all the companies");
			System.out.println("Enter 5 to get factorial of total count of employees in all the companies");
			System.out.println("Enter 6 to exit the program");
			System.out.println("Enter your option");
			c = sc.nextInt();
			System.out.println("=============================================================================================");

			switch(c){
				
				case 1:
					System.out.println("Enter employee details");
					for (int i = 0; i < no_of_companies; i++) {
						System.out.println("Company Name: " + cmp[i].company_name);
						cmp[i].accept_emp_details();
					}
					break;
	
				case 2:
					System.out.println("Enter the number given to the company for seeing employee details");
					int no = sc.nextInt();
					cmp[no-1].emp_display();
					break;
	
				case 3:
					System.out.println("Enter the number given to the company to see the details of employees having greater than 20");
					int no_1 = sc.nextInt();
					cmp[no_1-1].greater_than_18();
					break;
				
				case 4:
					System.out.println("total number of employees "+count);
					break;
					
				case 5:
					System.out.println("Factorial of total number of employees is " + factorial(count));
					break;
			
				case 6:
					System.out.println("Exiting the program");
					break;
				
				default:
					System.out.println("Wrong input");
					break;
			}
			
		} while(c!=6);		
		
	}
}	
	