import java.util.*;

public class queueLinkedList {
    Queue<String> queue;
    
    queueLinkedList() {
        queue = new LinkedList<>();
    }
    
    // Add element to the end of the queue
    void add(String element) {
        queue.add(element);
    }
    
    // Add element to the end of the queue, returns boolean
    boolean offer(String element) {
        return queue.offer(element);
    }
    
    // Remove and return the head of the queue
    String remove() {
        try {
            return queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Error: Queue is empty");
            return null;
        }
    }
    
    // Remove and return the head of the queue, or null if empty
    String poll() {
        return queue.poll();
    }
    
    // Return but do not remove the head of the queue
    String element() {
        try {
            return queue.element();
        } catch (NoSuchElementException e) {
            System.out.println("Error: Queue is empty");
            return null;
        }
    }
    
    // Return but do not remove the head of the queue, or null if empty
    String peek() {
        return queue.peek();
    }
    
    // Returns true if the queue contains the specified element
    boolean contains(String element) {
        return queue.contains(element);
    }
    
    // Returns the size of the queue
    int size() {
        return queue.size();
    }
    
    // Returns true if the queue is empty
    boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // Removes all elements from the queue
    void clear() {
        queue.clear();
    }
    
    // Convert queue to array
    Object[] toArray() {
        return queue.toArray();
    }
    
    // Display all elements in the queue
    void display() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Elements: " + queue);
    }
    
    public static void main(String args[]) {
        queueLinkedList q = new queueLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        System.out.println("Queue Operations Demo (Using LinkedList)");
        System.out.println("--------------------------------------");
        
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add element (add)");
            System.out.println("2. Add element (offer)");
            System.out.println("3. Remove element (remove)");
            System.out.println("4. Remove element (poll)");
            System.out.println("5. View first element (element)");
            System.out.println("6. View first element (peek)");
            System.out.println("7. Check if queue contains element");
            System.out.println("8. Get queue size");
            System.out.println("9. Check if queue is empty");
            System.out.println("10. Clear queue");
            System.out.println("11. Convert queue to array");
            System.out.println("12. Display queue");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            String element;
            boolean result;
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    element = scanner.nextLine();
                    q.add(element);
                    System.out.println("Element added!");
                    break;
                    
                case 2:
                    System.out.print("Enter element to offer: ");
                    element = scanner.nextLine();
                    result = q.offer(element);
                    System.out.println("Element offered: " + (result ? "Success" : "Failed"));
                    break;
                    
                case 3:
                    element = q.remove();
                    if (element != null) {
                        System.out.println("Removed element: " + element);
                    }
                    break;
                    
                case 4:
                    element = q.poll();
                    if (element != null) {
                        System.out.println("Polled element: " + element);
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                    
                case 5:
                    element = q.element();
                    if (element != null) {
                        System.out.println("First element: " + element);
                    }
                    break;
                    
                case 6:
                    element = q.peek();
                    if (element != null) {
                        System.out.println("First element: " + element);
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                    
                case 7:
                    System.out.print("Enter element to check: ");
                    element = scanner.nextLine();
                    System.out.println("Contains '" + element + "': " + q.contains(element));
                    break;
                    
                case 8:
                    System.out.println("Queue size: " + q.size());
                    break;
                    
                case 9:
                    System.out.println("Is queue empty: " + q.isEmpty());
                    break;
                    
                case 10:
                    q.clear();
                    System.out.println("Queue cleared!");
                    break;
                    
                case 11:
                    Object[] arr = q.toArray();
                    System.out.print("Queue as array: ");
                    if (arr.length == 0) {
                        System.out.println("[]");
                    } else {
                        System.out.print("[ ");
                        for (Object obj : arr) {
                            System.out.print(obj + " ");
                        }
                        System.out.println("]");
                    }
                    break;
                    
                case 12:
                    q.display();
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