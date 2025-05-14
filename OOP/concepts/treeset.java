import java.util.*;

public class treeset {
    Set<String> ts1;
    
    treeset() {
        ts1 = new TreeSet<>();
    }

    void add(String word) { 
        ts1.add(word);
    }

    void remove(String word) {
        ts1.remove(word);
    }

    int size() {
        return ts1.size();
    }

    boolean isEmpty() {
        return ts1.isEmpty();
    }

    boolean contains(String word) {
        return ts1.contains(word);
    }

    void clear() {
        ts1.clear();
    }

    void display() {
        System.out.println("Elements: " + ts1);
    }
    
    // Returns the first (lowest) element in the TreeSet
    String firstpoll() {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).first();
    }
    
    // Returns the last (highest) element in the TreeSet
    String lastpoll() {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).last();
    }
    
    // Returns the least element greater than or equal to the given element
    String ceil(String element) {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).ceiling(element);
    }
    
    // Returns the greatest element less than or equal to the given element
    String floor(String element) {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).floor(element);
    }
    
    // Returns the least element strictly greater than the given element
    String higher(String element) {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).higher(element);
    }
    
    // Returns the greatest element strictly less than the given element
    String lower(String element) {
        if (ts1.isEmpty()) {
            return null;
        }
        return ((TreeSet<String>) ts1).lower(element);
    }

    public static void main(String args[]) {
        treeset set = new treeset();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        System.out.println("TreeSet Operations Demo");
        System.out.println("----------------------");
        
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Check if set contains element");
            System.out.println("4. Get size");
            System.out.println("5. Check if set is empty");
            System.out.println("6. Clear set");
            System.out.println("7. Display elements");
            System.out.println("8. Get first element");
            System.out.println("9. Get last element");
            System.out.println("10. Get ceiling of element");
            System.out.println("11. Get floor of element");
            System.out.println("12. Get higher element");
            System.out.println("13. Get lower element");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            String element;
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    element = scanner.nextLine();
                    set.add(element);
                    System.out.println("Element added!");
                    break;
                    
                case 2:
                    System.out.print("Enter element to remove: ");
                    element = scanner.nextLine();
                    set.remove(element);
                    System.out.println("Element removed!");
                    break;
                    
                case 3:
                    System.out.print("Enter element to check: ");
                    element = scanner.nextLine();
                    System.out.println("Contains '" + element + "': " + set.contains(element));
                    break;
                    
                case 4:
                    System.out.println("Size: " + set.size());
                    break;
                    
                case 5:
                    System.out.println("Is empty: " + set.isEmpty());
                    break;
                    
                case 6:
                    set.clear();
                    System.out.println("Set cleared!");
                    break;
                    
                case 7:
                    set.display();
                    break;
                    
                case 8:
                    System.out.println("First element: " + set.firstpoll());
                    break;
                    
                case 9:
                    System.out.println("Last element: " + set.lastpoll());
                    break;
                    
                case 10:
                    System.out.print("Enter element for ceiling: ");
                    element = scanner.nextLine();
                    System.out.println("Ceiling of '" + element + "': " + set.ceil(element));
                    break;
                    
                case 11:
                    System.out.print("Enter element for floor: ");
                    element = scanner.nextLine();
                    System.out.println("Floor of '" + element + "': " + set.floor(element));
                    break;
                    
                case 12:
                    System.out.print("Enter element for higher: ");
                    element = scanner.nextLine();
                    System.out.println("Higher than '" + element + "': " + set.higher(element));
                    break;
                    
                case 13:
                    System.out.print("Enter element for lower: ");
                    element = scanner.nextLine();
                    System.out.println("Lower than '" + element + "': " + set.lower(element));
                    break;
                    
                case 0:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}