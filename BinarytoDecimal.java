import java.util.*;
public class BinarytoDecimal
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = 0;
		int p = 0;
		for(int i=s.length()-1;i>=0;i--) {
		    int val = Integer.parseInt(String.valueOf(s.charAt(i)));
		    ans = ans + val * (int)Math.pow(2,p);
		    p++;
		}
		System.out.print(ans);
	}
}