
/*
Design a class ‘Complex’ with data members for real and imaginary part. Provide default and 
Parameterized constructors. Write a program to perform arithmetic operations of two 
complex numbers. 
 */

import java.util.*;
public class Assignment_3 {
    double real;
    double imag;

    public Assignment_3(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    Assignment_3 add(Assignment_3 complex){
        return new Assignment_3(this.real + complex.real, this.imag + complex.imag);
    }

    Assignment_3 substract(Assignment_3 complex){
        return new Assignment_3(this.real - complex.real, this.imag - complex.imag);
    }

    Assignment_3 multiply(Assignment_3 complex) {
        double real_part = (this.real * complex.real) - (this.imag * complex.imag);
        double imag_part = (this.real * complex.imag) + (this.imag * complex.real);
        return new Assignment_3(real_part, imag_part);
    }

    void display() {
        if (this.imag < 0 ) {
            System.out.println(this.real + " - " + Math.abs(this.imag) + "i");
        } else if (this.imag > 0) {
            System.out.println(this.real + " + " + this.imag + "i");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter real and imaginary part of 1st number:");
        double real_1 = sc.nextDouble();
        double imag_1 = sc.nextDouble();

        System.out.println("Enter real and imaginary part of 3rd number:");
        double real_2 = sc.nextDouble();
        double imag_2 = sc.nextDouble();

        Assignment_3 complex_1 = new Assignment_3(real_1, imag_1);
        Assignment_3 complex_2 = new Assignment_3(real_2, imag_2);

        Assignment_3 sum = complex_1.add(complex_2);
        Assignment_3 diff = complex_1.substract(complex_2);
        Assignment_3 product = complex_1.multiply(complex_2);

        System.out.println("Sum of complex numbers:");
        sum.display();
        System.out.println("Difference of complex numbers:");
        diff.display();
        System.out.println("Product of complex numbers:");
        product.display();
        sc.close();
    }
}
