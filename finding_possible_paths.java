import java.util.*;

public class Main
{
    public static void gen_ways(int n, int[] paths, int pos) {
        if(n == 0) {
            for(int i=0;i<pos;i++) {
                System.out.print(paths[i]+" ");
            }
            System.out.println();
            return;
        }
        if(n >= 1) {
            paths[pos] = 1;
            gen_ways(n-1,paths,pos+1);
        }
        if(n >= 2) {
            paths[pos] = 2;
            gen_ways(n-2,paths,pos+1);
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of stairs : ");
		int n = sc.nextInt();
		int[] paths = new int[n];
		int pos = 0;
		System.out.println("The possible ways are : ");
		gen_ways(n,paths,pos);
	}
}