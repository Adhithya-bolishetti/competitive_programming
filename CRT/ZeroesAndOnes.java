package programs;
import java.util.*;
public class ZeroesAndOnes {
	public static void printZeroesandOnes(int n, int ones, int zeroes, int maxz, StringBuilder sb) {
		if(sb.length() == n) {
			System.out.println(sb.toString());
			return;
		}
		
		sb.append("1");
		printZeroesandOnes(n, ones+1, zeroes, maxz, sb);
		sb.deleteCharAt(sb.length()-1);
		
		if(zeroes < maxz) {		
			sb.append("0");
			printZeroesandOnes(n, ones, zeroes+1, maxz, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		int maxz = 0;
		if(n % 2 == 0) {
			maxz = (n/2)-1;
		}
		else {
			maxz = n/2;
		}
		
		printZeroesandOnes(n, 0, 0, maxz, sb);
	}

}
