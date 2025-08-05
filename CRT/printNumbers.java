package programs;
import java.util.*;
public class Numbers {
	public static void printNumbers(int t, int n, StringBuilder sb) {
		if(sb.length() == n) {
			System.out.println(sb.toString());
			return;
		}
		for(int i=t+1; i<=9; i++) {
			sb.append(String.valueOf(i));
			printNumbers(i, n, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		printNumbers(0,n,sb);
	}

}
