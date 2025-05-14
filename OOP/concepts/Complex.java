/*
Design a class ‘Complex’ with data members for real and imaginary part. 
Provide default and Parameterized constructors. 
Write a program to perform arithmetic operations of two complex numbers. 
*/

import java.util.*;

class Complex {
	double a, b;
	Complex() {
		a=0.0;
		b=0.0;
	}	
	
	Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	double add(Complex b) {	
		return this.a + b.a;	
	}
	
	double sub(Complex b)	{
		System.out.println(this.b);
		System.out.println(b.b);
		return this.b - b.b;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		Complex obj = new Complex();
		try {
			System.out.println("Enter real and imaginary numbers of equation1");
			double real1 = sc.nextDouble();
			double imag1 = sc.nextDouble();
			Complex obj1 = new Complex(real1, imag1);
			sc.nextLine();
			System.out.println("Enter real and imaginary numbers of equation2");
			double real2 = sc.nextDouble();
			double imag2 = sc.nextDouble();
			sc.nextLine();
			Complex obj2 = new Complex(real2, imag2); 
			System.out.println("Add: " + obj1.add(obj2) + " + " + obj1.add(obj2) + "i");
			System.out.println("Sub: " + obj1.sub(obj2) + " + " + obj1.sub(obj2) + "i");
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
		
		
		
	}	
	
}