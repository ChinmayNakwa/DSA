/*
Design a base class shape with two double type values and member functions to input the data 
and compute_area() for calculating area of figure, Derive two classes’ triangle and rectangle. 
Make compute_area() as abstract function and redefine this function in the derived class to suit their requirements. 
Write a program that accepts dimensions of triangle/rectangle and display calculated area. 
Implement dynamic binding for given cases.
 */

import java.util.*;

abstract class shapes {

    double base;
    double height;

    void accept(Scanner sc) {
        
        System.out.println("Enter base and height");
        try {
            this.base = sc.nextDouble();
            this.height = sc.nextDouble();
        } catch(InputMismatchException e) {
            System.out.println("Wrong input " + e);
            sc.nextLine();
        }
        
    }

    abstract void compute_area();
}

class triangle extends shapes {
    void compute_area() {
        System.out.println("Area of triangle: " + (base * height)/2);
    }
}

class rectangle extends shapes {
    
    void compute_area() {
        System.out.println("Area of reactangle: " + (base * height));
    }
}

public class Assignment_6{

    public static void main(String args[]) {
        System.out.println("Enter 1 for Triangle");
        System.out.println("Enter 2 for Rectangle");
        Scanner sc = new Scanner(System.in);
        
        try {
            int c = sc.nextInt();
            shapes shape = null;

        switch(c) {
            case 1:
                shape = new triangle();
                break;
            case 2:
                shape = new rectangle();
                break;
            default :
                System.out.println("Wrong option");
                break;
        }

        shape.accept(sc);
        shape.compute_area();
        } catch (InputMismatchException e) {
            System.out.println("Wrong Input " + e.getMessage());
        } finally {
            sc.close();
        }
    }   
}
