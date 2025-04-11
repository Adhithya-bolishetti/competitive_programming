import java.util.*;
public class XOR_of_nums_in_range
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print("XOR of numbers between given range : ");
		if(n%4 == 1) System.out.println(1);
		else if(n%4 == 2) System.out.println(n+1);
		else if(n%4 == 3) System.out.println(0);
		else if(n%4 == 0) System.out.println(n);
	}
}