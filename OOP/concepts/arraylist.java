import java.util.*;

//for linked list
//List<Integer> list = new LinkedList<>();

//for hashset
//Set<Integer> set = new HashSet<>();

public class arraylist {
    ArrayList<Integer> list; 
    arraylist() {
        this.list = new ArrayList<>();
    }
    
    void add(int x) {
        list.add(x);
    }
    
    ArrayList<Integer> combine_two_list(arraylist obj2) {
        ArrayList<Integer> list_1 = new ArrayList<>(list);
        list_1.addAll(obj2.list);
        return list_1;
    }
    
    int size() {
        return list.size();
    }
    
    void remove(){
        list.clear();
    }
    
    int[] to_array() {
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    } 
    
    void display() {
        System.out.println("Elements:" + list);
    }
    
    void set(int index, int value) {
        if(index >= 0 && index < list.size()) {
            list.set(index, value);
        } else {
            System.out.println("Error: out of bounds");
        }
    }
    
    int get(int index) {
        if(index >= 0 && index < list.size()) {
            int value = list.get(index);
            return value;
        } else {
            System.out.println("Error: out of bounds");
        }
        return -1;
    }
    
    boolean Contains(int value) {
        if(list.contains(value)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        arraylist obj = new arraylist();
        
        obj.add(2);
        obj.add(3);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\nArrayList Operations Menu:");
            System.out.println("1. Add element");
            System.out.println("2. Display elements");
            System.out.println("3. Get size");
            System.out.println("4. Clear all elements");
            System.out.println("5. Combine with another list");
            System.out.println("6. Convert to array");
            System.out.println("7. Set element at index");
            System.out.println("8. Get element at index");
            System.out.println("9. Check if element exists");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                System.out.print("Enter element to add: ");
                int element = sc.nextInt();
                obj.add(element);
                System.out.println("Element added successfully!");
                break;
                case 2:
                System.out.println("Displaying Elements");
                obj.display();
                break;
                case 3:
                System.out.println("Size: " + obj.size());
                break;
                case 4:
                obj.remove();
                System.out.println("Arraylist cleared successfully");
                break;
                case 5:
                arraylist obj2 = new arraylist();
                System.out.println("Enter number of elements to add in second list: ");
                int n = sc.nextInt();
                for(int i = 0; i < n; i++) {
                    obj2.add(sc.nextInt());
                }
                ArrayList<Integer> Combined = obj.combine_two_list(obj2);
                System.out.println("Combined List: " + Combined);
                break;

                case 6:
                int[] arr = obj.to_array();
                System.out.println("Array Elements");
                for(int i = 0; i < arr.length; i++) {//what is wrong here
                    System.out.print(arr[i] + " " );
                }
                System.out.println();
                break;

                case 7:
                if(obj.size() == 0) {
                    System.out.println("List is empty! Add elements first.");
                } else {
                    System.out.println("Current list: ");
                    obj.display();
                    System.out.print("Enter index (0 to " + (obj.size() - 1) + "): ");
                    int index = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    obj.set(index, newValue);
                    System.out.println("Element updated successfully!");
                }
                break;

                case 8:
                if (obj.size() == 0) {
                    System.out.println("List is empty! Add elements first.");
                } else {
                    System.out.println("Current list: ");
                    obj.display();
                    System.out.print("Enter index (0 to " + (obj.size() - 1) + "): ");
                    int getIndex = sc.nextInt();
                    int value = obj.get(getIndex);
                    if (value != -1) {
                        System.out.println("Element at index " + getIndex + ": " + value);
                    }
                }
                break;

                case 9:
                System.out.print("Enter element to search: ");
                int searchValue = sc.nextInt();
                if (obj.Contains(searchValue)) {
                    System.out.println("Element " + searchValue + " exists in the list!");
                } else {
                    System.out.println("Element " + searchValue + " does NOT exist in the list!");
                }
                break;

                case 10:
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
