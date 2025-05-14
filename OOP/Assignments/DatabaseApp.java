/*
Using all concepts of Object-Oriented programming develop a solution for any application 
contains following operations such as  
a) Creation of database 
b) Addition of data 
c) Deletion of data 
d) Updation of data 
e) Display of data 
*/

import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class RecordNotFoundException extends Exception {
    public RecordNotFoundException(String message) {
        super(message);
    }
}

class Record {
    int id;
    String name;
    String description;

    public Record(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description);
    }
}

class Database {
    private ArrayList<Record> records;

    public Database() {
        records = new ArrayList<>();
    }

    public void addRecord(int id, String name, String description) {
        Record newRecord = new Record(id, name, description);
        records.add(newRecord);
        System.out.println("Record added successfully.");
    }

    public void deleteRecord(int id) throws RecordNotFoundException {
        for (Record record : records) {
            if (record.id == id) {
                records.remove(record);
                System.out.println("Record deleted successfully.");
                return;
            }
        }
        throw new RecordNotFoundException("Record with ID " + id + " not found.");
    }

    public void updateRecord(int id, String newName, String newDescription) {
        for (Record record : records) {
            if (record.id == id) {
                record.name = newName;
                record.description = newDescription;
                System.out.println("Record updated successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public void displayRecords() {
        if (records.isEmpty()) {
            System.out.println("No records to display.");
        } else {
            for (Record record : records) {
                record.display();
            }
        }
    }
}

public class DatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create Database");
            System.out.println("2. Add Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Update Data");
            System.out.println("5. Display Data");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    db = new Database();
                    System.out.println("Database created successfully.");
                    break;

                case 2:
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Description:");
                    String description = scanner.nextLine();
                    db.addRecord(id, name, description);
                    break;

                case 3:
                    System.out.println("Enter ID of record to delete:");
                    int deleteId = scanner.nextInt();
                    try {
                        db.deleteRecord(deleteId);
                    } catch (RecordNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Enter ID of record to update:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new Name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new Description:");
                    String newDescription = scanner.nextLine();
                    db.updateRecord(updateId, newName, newDescription);
                    break;

                case 5:
                    db.displayRecords();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
