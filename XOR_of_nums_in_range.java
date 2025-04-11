import java.util.*;
public class xor_of_nums_in_range
{
    public static int xor(int n) {
        if(n%4 == 1) return 1;
		if(n%4 == 2) return n+1;;
		if(n%4 == 3) return 0;
		if(n%4 == 0) return n;
		return -1;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.print("XOR of numbers between given range : ");
		int ans = xor(l-1) ^ xor(r);
		System.out.print(ans);
	}
}