/*
Implement a program for maintaining a student records database using File Handling. 
Student has Student_id, name, Roll_no, Class, marks andaddress. Display the data for five students.  
a) Create Databases 
b) Display Database 
c) Clear Records 
d) Modify Records 
e) Search Records  
*/

import java.io.*;
import java.util.*;

public class Assignment_10 {
    int id, roll_no;
    String name, className;
    float marks;

    static final String FILE_PATH = "students.txt";

    Assignment_10(int id, int roll_no, String name, String className, float marks) {
        this.id = id;
        this.roll_no = roll_no;
        this.name = name;
        this.className = className;
        this.marks = marks;
    }
    
    public String toString() {
        return id + "," + name + "," + roll_no + "," + className + "," + marks;
    }

    void createDatabase(Assignment_10 student) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH, true);
        fw.write(student.toString() + "\n");
        fw.close();
    }

    static void displayDatabase() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        System.out.println("Student Records:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    static void clearRecords() throws IOException {
        new PrintWriter(FILE_PATH).close();
    }

    static void modifyRecords(int roll_no, String newName) throws IOException {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp.txt");

        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new PrintWriter(new FileWriter(tempFile));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        String line;

        while ((line = reader.readLine()) != null ) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[2]) == roll_no) {
                data[1] = newName;
                writer.println(String.join(",", data));
            } else {
                writer.println(line);
            }
        }

        reader.close();
        writer.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    static void searchRecord(int roll_no) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        
        String line;

        while((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if(Integer.parseInt(data[2]) == roll_no) {
                System.out.println("Found");
                System.out.println("Name: " + data[1]);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean exit = false;

        do {
            System.out.println("\n===== STUDENT DATABASE MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Clear Records");
            System.out.println("4. Modify Records");
            System.out.println("5. Search Records");
            System.out.println("6. Add Single Record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.println("\n--- CREATE DATABASE ---");
                    System.out.println("Enter number of students: ");
                    int no_of_students = sc.nextInt();
                    for(int i = 0; i < no_of_students; i++) {
                        System.out.println("Enter id:");
                        int id = sc.nextInt();
                        System.out.println("Enter roll no");
                        int roll_no = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter name");
                        String name = sc.nextLine();
                        System.out.println("Enter className");
                        String className = sc.nextLine();
                        System.out.println("Enter marks");
                        float marks = sc.nextFloat();
                        Assignment_10 student = new Assignment_10(id, roll_no, name, className, marks);
                        try {
                            student.createDatabase(student);
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- DISPLAY DATABASE ---");
                    try {
                        displayDatabase();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    break;
                    
                case 3:
                    System.out.println("\n--- CLEAR RECORDS ---");
                    try {
                        clearRecords();
                        System.out.println("All records deleted successfully!");
                    } catch(IOException ioe) {
                        ioe.printStackTrace();
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- MODIFY RECORDS ---");
                    try {
                        System.out.println("Enter roll no of student to modify:");
                        int rno = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new name:");
                        String newName = sc.nextLine();
                        modifyRecords(rno, newName);
                        System.out.println("Record modified successfully!");
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    }
                    break;
                    
                case 5:
                    System.out.println("\n--- SEARCH RECORDS ---");
                    try {
                        System.out.println("Enter roll no to be searched:");
                        int rno = sc.nextInt();
                        searchRecord(rno);
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    }
                    break;
                    
                case 6:
                    System.out.println("\n--- ADD RECORD ---");
                    System.out.println("Enter id:");
                    int id = sc.nextInt();
                    System.out.println("Enter roll no");
                    int roll_no = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    System.out.println("Enter className");
                    String className = sc.nextLine();
                    System.out.println("Enter marks");
                    float marks = sc.nextFloat();
                    Assignment_10 student = new Assignment_10(id, roll_no, name, className, marks);
                    try {
                        student.createDatabase(student);
                        System.out.println("Record added successfully!");
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
        } while (!exit);
        
        sc.close();
    }
}