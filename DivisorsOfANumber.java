import java.util.*;

public class DivisorsOfANumber {
	// Java program to print all divisors of a given number
	// Time Complexity: O(sqrt(n))
	// Space Complexity: O(1)
	// where n is the input number

	// Function to print all divisors of a given number n
	// using the method of trial division
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Divisors of a given number are");
		for(int i=1;i<=Math.sqrt(n);i++) {
		    if(n%i == 0) {
		        System.out.print(i+" ");
		        if(i != n/i) System.out.print(n/i+" ");
		    }
		}
	}
}