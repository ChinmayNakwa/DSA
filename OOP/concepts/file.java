import java.io.*;
import java.util.Scanner;

class students {

    String name, address, className;
    int id, rno, marks;

    static final String FILE_PATH = "students.txt";

    students(String n, String a, String c, int id, int rno, int marks) {
        this.name = n;
        this.address = a;
        this.className = c;
        this.id = id;
        this.rno = rno;
        this.marks = marks;
    }

    public String toString() {
        return id + "," + name + "," + rno + "," + className + "," + address + "," + marks;
    }

    void create_database(students student) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH, true);
            fw.write(student.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if (fw != null) fw.close();
        }
    }

    static void display() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            System.out.println("Student Records: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if (br != null) br.close();
        }
    }

    static void clearData() throws IOException {
        new PrintWriter(FILE_PATH).close();
    }

    static void modifyData(int roll_no, String newname) throws IOException {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[2]) == roll_no) {
                data[1] = newname;
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

    static void search(int rno) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[2]) == rno) {
                System.out.println("Found");
                System.out.println("Name: " + data[1]);
            }
        }
        reader.close();
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

            switch (choice) {

                case 1:
                    System.out.println("\n--- CREATE DATABASE ---");
                    System.out.println("Enter number of students: ");
                    int no_of_students = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < no_of_students; i++) {
                        System.out.println("Enter id:");
                        int id = sc.nextInt();
                        System.out.println("Enter roll no:");
                        int roll_no = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter className:");
                        String className = sc.nextLine();
                        System.out.println("Enter marks:");
                        int marks = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter address:");
                        String address = sc.nextLine();

                        students student = new students(name, address, className, id, roll_no, marks);
                        try {
                            student.create_database(student);
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- DISPLAY DATABASE ---");
                    try {
                        display();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("\n--- CLEAR RECORDS ---");
                    try {
                        clearData();
                        System.out.println("All records deleted successfully!");
                    } catch (IOException ioe) {
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
                        modifyData(rno, newName);
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
                        search(rno);
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\n--- ADD RECORD ---");
                    System.out.println("Enter id:");
                    int id = sc.nextInt();
                    System.out.println("Enter roll no:");
                    int roll_no = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter className:");
                    String className = sc.nextLine();
                    System.out.println("Enter marks:");
                    int marks = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter address:");
                    String address = sc.nextLine();

                    students student = new students(name, address, className, id, roll_no, marks);
                    try {
                        student.create_database(student);
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
