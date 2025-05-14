/*
Design a class for student entity and consider relevant abstract data. Accept and display the 
data for 5 objects using array of objects.  
*/
import java.util.*;
public class Assignment_2 {
    int emp_id;
    String emp_name;
    String emp_company;

    public Assignment_2(int id, String name, String company) {
        emp_id = id;
        emp_name = name;
        emp_company = company;
    }

    public void display () {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Company: " + emp_company);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine();
        Assignment_2[] emp = new Assignment_2[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter Employee ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Emloyee Name:");
            String name = sc.nextLine();
            System.out.println("Enter Employee Company:");
            String company =sc.nextLine();
            emp[i] = new Assignment_2(id, name, company);
        }
        System.out.println("===============================");
        for (int i = 0; i < n; i++) {
            emp[i].display();
        }
        sc.close();
    }
}
