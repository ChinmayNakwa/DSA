
abstract class Subject {
    public Subject() {
        System.out.println("Learning syllabus");
    }
    
    abstract void syllabus();
    
    void learn() {
        System.out.println("Preparing right now!");
    }
}

class IT extends Subject {
    void syllabus() {
        System.out.println("C, C++, Java");
    }
}

class abstract_impl {
    public static void main(String[] args) {
        Subject obj = new IT();
        obj.syllabus();
        obj.learn();
    }
}