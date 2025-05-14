import java.util.*;
 
class College { 
    String department;
    int numberOfStudents;
    Students[] student;
    static int count = 0; // Static variable         
    int rollCounter = 1; // Department-wise roll number counter 

    // Inner class 
    class Students { 
        String name;
        int age, id, rollNumber;

        // Without return type and parameters
        void accept() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name");
            name = sc.nextLine();
            System.out.println("Enter age");
            age = sc.nextInt();
            System.out.println("Enter ID");
            id = sc.nextInt();
            counter();
            rollNumber = rollCounter++; // Assign roll number department-wise
            System.out.println("Roll Number alloted: " + rollNumber);
            System.out.println("");
        }

        // Static method
        static void counter() {
            count++;
        }

        // Without return type and parameters
        void display() {
            System.out.println("-----------------------------------");
            System.out.println("NAME: " + name);
            System.out.println("AGE: " + age);
            System.out.println("ID: " + id);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("-----------------------------------");
        }

        // With return type and parameters
        static int[] age_greater_than(Students arr[]) {
            int ar[] = new int[arr.length];
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].age > 18) {
                    ar[k] = i;
                    k++;
                }
            }
            int[] result = new int[k];
            System.arraycopy(ar, 0, result, 0, k);
            return result;
        }
    }

    void Department() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department");
        department = sc.nextLine();
        System.out.println("Enter number of students");
        numberOfStudents = sc.nextInt();
        student = new Students[numberOfStudents];
        System.out.println("Enter student details");

        for (int i = 0; i < numberOfStudents; i++) {
            student[i] = new Students();
            student[i].accept();
        }
    }

    void listOfStudents() {
        int arr[] = Students.age_greater_than(student);
        if (arr.length == 0) {
            System.out.println("No students older than 18 found.");
        } else {
            System.out.println("Students older than 18:");
            for (int index : arr) {
                student[index].display();
            }
        }
    }

    void display() {
        System.out.println(department);
        System.out.println("Number of Students: " + numberOfStudents);
        for (int i = 0; i < numberOfStudents; i++) {
            student[i].display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of departments");
        int no = sc.nextInt();
        College college[] = new College[no];
        for (int i = 0; i < no; i++) {
            college[i] = new College();
            college[i].Department();
        }
        int c;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all departments");
            System.out.println("2. List students older than 18 in a department");
            System.out.println("3. Print total number of students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("\nDisplaying Details of All Departments:");
                    for (int i = 0; i < no; i++) {
                        college[i].display();
                    }
                    break;
                case 2:
                    System.out.println("Enter Department id (1 to " + no + ")");
                    int did = sc.nextInt();
                    if (did >= 1 && did <= no) {
                        System.out.println("Printing all the details of students greater than the age of 18");
                        college[did - 1].listOfStudents();
                    } else {
                        System.out.println("Invalid department id.");
                    }
                    break;
                case 3:
                    System.out.println("Printing total number of students...");
                    System.out.println(count);
                    break;
            }
        } while (c != 5);
    }
}
