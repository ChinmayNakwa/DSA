
import java.util.Scanner;

class Students {
    String name, department;
    int age, id;

    static int count = 0;
    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        name = sc.nextLine();
        System.out.println("Enter Department");
        department = sc.nextLine();
        System.out.println("Enter age");
        age = sc.nextInt();
        System.out.println("Enter ID");
        id = sc.nextInt();
        counter();
        System.out.println("Roll Number alloted: "+count);
        System.out.println("");
    }

    static void counter() {
        count++;
    }

    void update_name(String name){
        this.name = name;
    }

    String NAME() {
        return name;
    }

    static int[] age_greater_than(Students arr[]) {
        int ar[] = new int[arr.length];
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].age > 18){
                ar[k] = i;
                k++;
            }
        }
        int[] result = new int[k];
        System.arraycopy(ar, 0, result, 0, k);
        return result;
    }

    void display() {
        System.out.println("-----------------------------------");
        System.out.println("NAME: "+name);
        System.out.println("AGE: "+age);
        System.out.println("DEPARTMENT "+department);
        System.out.println("ID "+id);
        System.out.println("-----------------------------------");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students"); 
        int no = sc.nextInt();
        Students obj[] = new Students[no];
        for(int i = 0; i < no; i ++) {
            obj[i] = new Students();
            obj[i].accept();
        }
        //for(int i=0; i<5; i++) {
        //    obj[i].display();
        //}
        int c;
        do { 
            System.out.println("\nMenu:");
            System.out.println("1. Update Name");
            System.out.println("2. Display Student Details");
            System.out.println("3. List Students Older Than 18");
            System.out.println("4. Get Name of a Student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            c = sc.nextInt();
            switch(c){
                case 1:
                    System.out.println("Enter roll number of the student to update:");
                    int roll = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (roll > 0 && roll <= no) {
                        System.out.println("Enter new name:");
                        String newName = sc.nextLine();
                        obj[roll - 1].update_name(newName);
                        System.out.println("Name updated successfully!");
                    } else {
                        System.out.println("Invalid roll number!");
                    }
                    break;
                    
                case 2:
                   System.out.println("Enter roll number of the student to display:");
                    int rn = sc.nextInt();
                    if (rn > 0 && rn <= no) {
                        obj[rn - 1].display();
                    } else {
                        System.out.println("Invalid roll number!");
                    }
                    break;
                    
                case 3:
                    System.out.println("List of students greater than the age of 18");
                    int array[] = age_greater_than(obj);
                    for(int idx : array){
                        obj[array[idx]].display();
                    }
                    break;

                case 4:
                    System.out.println("Enter roll number of student");
                    int rno = sc.nextInt();
                    if (rno > 0 && rno <= no) {
                        System.out.println("Name of Student: " + obj[rno - 1].NAME());
                    } else {
                        System.out.println("Invalid roll number!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Wrong Input");
                    break;
            
            }
        } while (c != 5);
    }
}