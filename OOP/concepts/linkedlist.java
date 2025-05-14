import java.util.*;
public class linkedlist {
 
    List<String> list;

    linkedlist() {
        this.list = new LinkedList<>();
    }

    void add(String word) {
        list.add(word);
    }

    void remove() {
        list.clear();
    }

    List<String> combine_two_list(linkedlist obj) {
        List<String> combined = new LinkedList<>(list);
        combined.addAll(obj.list);
        return combined;
    }

    void set(int index, String word) {
        try {
            list.set(index, word);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    boolean contain(String word) {
        return list.contains(word);
    }

    String get(int index) { 
        return list.get(index);
    }

    int size() {
        return list.size();
    }

    void display() {
        System.out.println("Elements : " + list);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        linkedlist obj = new linkedlist();
        linkedlist obj2 = new linkedlist();

        obj.add("Hello");
        obj.add("World");

        obj2.add("Hello2");
        obj2.add("World2");

        System.out.println();
        obj.display();
        obj2.display();

        System.out.println();
        List<String> combined = obj.combine_two_list(obj2);
        System.out.println("Combined" + combined);

        System.out.println();
        System.out.println("Size of list 1 " + obj.size());
        System.out.println("List 1");
        obj.display();

        System.out.println();
        obj.set(1, "World3");
        obj.display();


        System.out.println();
        System.out.println("At index 1 of list 1: " + obj.get(1));
        System.out.println("Contains list 1: " + obj.contain("Hello"));

        System.out.println();
        obj.remove();
        obj.display();

        sc.close();
    }
}
