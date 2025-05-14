import java.util.*;
class string_functions {
	public static void main(String args[]) {
		String str = new String("Hello");
		System.out.println("Uppercase: "+str.toUpperCase());
		str = new String("	Hello Java");
		System.out.println("Trimed String: "+str.trim());
		str = "Hello";
		System.out.println("Is Hello equal to hello: " + str.equals("hello"));
		System.out.println("Is Hello equal to hello after ignoring case: " + str.equalsIgnoreCase("hello"));
		System.out.println("Length of Hello: "+str.length());
		System.out.println("Char at 3: "+str.charAt(3));
		System.out.println("Replaced string: "+str.replace('H','C'));
		System.out.println("Concatenated String: "+str.concat("Java"));
		System.out.println("Index of l with parameter 1: "+str.indexOf('l'));
		System.out.println("Index of 2 with parameter 1: "+str.indexOf('l',2));
		System.out.println("Substring with 1 parameter: "+str.substring(2));
		System.out.println("Substring with 2 parameter: "+str.substring(2,4));			if(str.compareTo("hello")>0) {
			System.out.println("Hello is greater than hello"); }
		else if(str.compareTo("hello")<0) {
			System.out.println("hello is greater than Hello"); }
		else {
			System.out.println("Both are equal"); }
	}
}