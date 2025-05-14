class pub {
    String title;
    int price, no_of_copies;

    void saleCopies() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}

class Book extends pub{
    String author;
    static int order=0;

    static void Copies() {
        order++;
    }
    
    Book(String author, String title, int price, int no_of_copies) {
        Copies();
    }

    

}

class Magzine extends  pub{

}

class publication {
    public static void main(String[] args) {
        
    }
}