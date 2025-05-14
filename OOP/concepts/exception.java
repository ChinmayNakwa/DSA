/*
Implement a program to handle Arithmetic exception, Array Index Out of Bounds. 
The user enters two numbers Num1 and Num2. 
The division of Num1 and Num2 is displayed. 
If Num1 and Num2 were not integers, the program would throw a Number Format Exception. 
If Num2 were zero, the program would throw an Arithmetic Exception. Display the exception.
*/

import java.util.*;

class exp {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numbers[] = new int[2];

		try {
			numbers[0] = sc.nextInt();
			numbers[1] = sc.nextInt();
			sc.nextLine();
			
			int result = numbers[0]/ numbers[1];
		} catch(ArithmeticException e) {
			System.out.println("Error: Division by zero not allowed.");
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid input. Please enter valid integers.");
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Error: Array index out of bounds.");
		} catch (Exception e) {
			System.out.println(e);
		}  
		finally {
			sc.close();
		}
		
	}
}