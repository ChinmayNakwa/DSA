
class ABC {
    int r;
    final double pi = 3.14;

    ABC(int r) {
        this.r = r;
    }

    final double cal() {
        return 2*pi*r;
    }

    void print() {
        System.out.println("The circuference of circle is: "+cal());
    }
}

final class final_impl extends ABC{

    public final_impl(int r) {
        super(r);
    }
    
    public static void main(String[] args) {
        int r = 10;
        final_impl obj = new final_impl(r);
        obj.print();
    }
}