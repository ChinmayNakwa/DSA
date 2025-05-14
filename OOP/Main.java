import java.util.*;

class Student {
    // Static data
    static String schoolName = "ABC High School";

    // Instance variables
    private String name;
    private int age;

    // Constructors
    public Student() {
        // Default constructor
        this.name = "Unknown";
        this.age = 0;
    }

    public Student(String name, int age) {
        // Parameterized constructor
        this.name = name;
        this.age = age;
    }

    // Overloading Constructors
    public Student(String name) {
        this.name = name;
        this.age = 18; // Default age
    }

    // Getter and Setter Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Static Method
    public static void printSchoolName() {
        System.out.println("School: " + schoolName);
    }

    // Non-static Method with Parameters
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Overloading Methods
    public void displayDetails(String additionalInfo) {
        System.out.println("Name: " + name + " (" + additionalInfo + ")");
        System.out.println("Age: " + age);
    }

    // Using 'this' keyword
    public void updateDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Returning Objects
    public Student getStudentCopy() {
        return new Student(this.name, this.age);
    }

    // finalize() Method
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called for: " + this.name);
    }

    // Inner Class
    class Address {
        private String city;
        private String state;

        public Address(String city, String state) {
            this.city = city;
            this.state = state;
        }

        public void displayAddress() {
            System.out.println("City: " + city + ", State: " + state);
        }
    }

    // Recursion Example
    public int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}

// Command Line Argument Example
public class Main {
    public static void main(String[] args) {
        // Creating an Object
        Student student1 = new Student("John", 16);

        // Accessing Methods
        student1.displayDetails();
        student1.updateDetails("Johnny", 17);
        student1.displayDetails("Updated Info");

        // Static Method Call
        Student.printSchoolName();

        // Returning Objects
        Student studentCopy = student1.getStudentCopy();
        System.out.println("Copied Student Name: " + studentCopy.getName());

        // Using Inner Class
        Student.Address address = student1.new Address("Pune", "Maharashtra");
        address.displayAddress();

        // Recursion Example
        int num = 5;
        System.out.println("Factorial of " + num + ": " + student1.factorial(num));

        // Command Line Argument
        if (args.length > 0) {
            System.out.println("Command Line Argument: " + args[0]);
        } else {
            System.out.println("No Command Line Arguments passed.");
        }

        // finalize() Demonstration
        student1 = null; // Eligible for garbage collection
        System.gc(); // Requesting Garbage Collection
    }
}
