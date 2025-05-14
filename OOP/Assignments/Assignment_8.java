/* Implement a program to handle Arithmetic exception, Array Index Out of Bounds. 
The user enters two numbers Num1 and Num2. The division of Num1 and Num2 is displayed. 
If Num1 and Num2 were not integers, the program would throw a Number Format Exception. 
If Num2 were zero, the program would throw an Arithmetic Exception. Display the exception. . */

import java.util.*;

/* How to check for the last error exception  */

public class Assignment_8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[2];

        try {
            System.out.println("Enter the index you want the enter the value first");
            int index = sc.nextInt();
            System.out.println("Enter first number: ");
            numbers[index] = sc.nextInt();
            if (index == 0) {
                System.out.println("Enter second number: ");
                numbers[1] = sc.nextInt();
            } else {
                System.out.println("Enter second number: ");
                numbers[0] = sc.nextInt();
            }

            int result = numbers[0]/numbers[1];
            System.out.println("Result of division: "+result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds.");
        }   finally {
            sc.close();
        }
    }
}


