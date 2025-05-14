import java.util.*;

class Common {
    String title;
    double price;
    int copies;

    Common(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    void saleCopy() {
        System.out.println("Total Sale of Publication: " + (price * copies));
    }
}

class Book extends Common {
    String author;
    int order_copies;

    Book(String title, double price, int copies, String author, int order_copies) {
        super(title, price, copies);
        this.author = author;
        this.order_copies = order_copies;
    } 

    void Copies() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Price: " + price);
        System.out.println("Book Copies: " + copies);
        System.out.println("Book Author: " + author);
        System.out.println("Book Order Copies: " + order_copies);
        super.saleCopy();
    }
}

class Magazine extends Common {
    int orderQty;
    int currentIssue;

    Magazine(String title, double price, int copies, int orderQty, int currentIssue) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    void recieveIssue() {
        System.out.println("Magazine Title: " + title);
        System.out.println("Magazine Price: " + price);
        System.out.println("Magazine Copies: " + copies);
        System.out.println("Magazine Order Quantity: " + orderQty);
        System.out.println("Magazine Current Issue: " + currentIssue);
        super.saleCopy();
    }
}

class Publication extends Common {
    String journal;

    Publication(String journal, String title, double price, int copies) {
        super(title, price, copies);
        this.journal = journal;
    }

    void publish() {
        System.out.println("Paper Title: " + title);
        System.out.println("Paper Price: " + price);
        System.out.println("Paper Copies: " + copies);
        System.out.println("Paper Journal: " + journal);
        super.saleCopy();
    }
}

public class Assignment_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter option");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. Publication");
        int option = sc.nextInt();
        sc.nextLine();
        
        switch(option) {
            case 1:
                System.out.println("Enter Book Title");
                String bookTitle = sc.nextLine();
                System.out.println("Enter Book Price");
                double bookPrice = sc.nextDouble();
                System.out.println("Enter Book Copies");
                int bookCopies = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Book Author");
                String bookAuthor = sc.nextLine();
                System.out.println("Enter Book Order Copies");
                int bookOrderCopies = sc.nextInt();
                Book book = new Book(bookTitle, bookPrice, bookCopies, bookAuthor, bookOrderCopies);
                book.Copies();
                break;
                
            case 2:
                System.out.println("Enter Magazine Title");
                String magazineTitle = sc.nextLine();
                System.out.println("Enter Magazine Price");
                double magazinePrice = sc.nextDouble();
                System.out.println("Enter Magazine Copies");
                int magazineCopies = sc.nextInt();
                System.out.println("Enter Magazine Order Quantity");
                int magazineOrderQty = sc.nextInt();
                System.out.println("Enter Magazine Current Issue");
                int magazineCurrentIssue = sc.nextInt();
                Magazine magazine = new Magazine(magazineTitle, magazinePrice, magazineCopies, magazineOrderQty, magazineCurrentIssue);
                magazine.recieveIssue();
                break;
                
            case 3:
                System.out.println("Enter Publication Title");
                String pubTitle = sc.nextLine();
                System.out.println("Enter Publication Price");
                double pubPrice = sc.nextDouble();
                System.out.println("Enter Publication Copies");
                int pubCopies = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Publication Journal");
                String pubJournal = sc.nextLine();
                Publication publication = new Publication(pubJournal, pubTitle, pubPrice, pubCopies);
                publication.publish();
                break;
                
            default:
                System.out.println("Invalid option selected.");
                break;
        }
        
        sc.close();
    }
}