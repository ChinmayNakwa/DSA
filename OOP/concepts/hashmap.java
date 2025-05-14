import java.util.*;

public class hashmap {
    Map<Integer, String> map;

    hashmap() {
        map = new HashMap<>();
    }

    void add(int index, String word) {
        map.put(index, word);
    }

    void update(int index, String word) {
        map.put(index, word);
    }

    void remove(int index) {
        map.remove(index);
    }

    void removeAll() {
        map.clear();
    }

    int size() {
        return map.size();
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    String get(int key) {
        return map.get(key);
    }

    void traverse() {
        for(Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + "Value: " + e.getValue());
        } 
    }
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        hashmap obj = new hashmap();
        
        // Add initial sample data
        obj.add(1, "One");
        obj.add(2, "Two");
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\nHashMap Operations Menu:");
            System.out.println("1. Add element");
            System.out.println("2. Update element");
            System.out.println("3. Remove element");
            System.out.println("4. Get element");
            System.out.println("5. Display all elements");
            System.out.println("6. Check size");
            System.out.println("7. Check if empty");
            System.out.println("8. Clear all elements");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter value (string): ");
                    String value = sc.nextLine();
                    obj.add(key, value);
                    System.out.println("Element added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter key to update: ");
                    int updateKey = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (obj.get(updateKey) != null) {
                        System.out.print("Enter new value: ");
                        String newValue = sc.nextLine();
                        obj.update(updateKey, newValue);
                        System.out.println("Element updated successfully!");
                    } else {
                        System.out.println("Key not found! Cannot update.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = sc.nextInt();
                    if (obj.get(removeKey) != null) {
                        obj.remove(removeKey);
                        System.out.println("Element removed successfully!");
                    } else {
                        System.out.println("Key not found! Cannot remove.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter key to get value: ");
                    int getKey = sc.nextInt();
                    String result = obj.get(getKey);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found!");
                    }
                    break;
                    
                case 5:
                    if (obj.isEmpty()) {
                        System.out.println("HashMap is empty!");
                    } else {
                        System.out.println("HashMap elements:");
                        obj.traverse();
                    }
                    break;
                    
                case 6:
                    System.out.println("HashMap size: " + obj.size());
                    break;
                    
                case 7:
                    if (obj.isEmpty()) {
                        System.out.println("HashMap is empty!");
                    } else {
                        System.out.println("HashMap is not empty. Size: " + obj.size());
                    }
                    break;
                    
                case 8:
                    obj.removeAll();
                    System.out.println("HashMap cleared successfully!");
                    break;
                    
                case 9:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }

}
