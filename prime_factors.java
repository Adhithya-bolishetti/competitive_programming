import java.util.*;
public class prime_factors
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
		    if(n%i == 0) {
		        int count = 0;
		        if(i>=2) {
		            for(int j=1;j<=i;j++) {
		                if(i%j == 0) count++;
		            }
		        }
		        if(count == 2) System.out.print(i+" ");
		    }
		}
	}
}