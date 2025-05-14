/*Implement a generic program using any collections class to count the number of elements in 
a collection that have a specific property such as even numbers , odd number, prime number 
and palindromes.  */
import java.util.*;
import java.util.function.Predicate;


public class Assignment_9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(121, 34, 67, 89, 22, 131, 44, 97, 101);

        System.out.println("Even Numbers:" + countByCondition(numbers, Assignment_9::isEven));
        System.out.println("Odd Numbers:" + countByCondition(numbers, Assignment_9::isOdd));
        System.out.println("Prime Numbers:" + countByCondition(numbers, Assignment_9::isPrime));
        System.out.println("Palindromes: " + countByCondition(numbers, Assignment_9::isPalindrome));
    }

    public static long countByCondition(List<Integer> list, Predicate<Integer> condition) {
        return list.stream().filter(condition).count();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) { return false; }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
} 