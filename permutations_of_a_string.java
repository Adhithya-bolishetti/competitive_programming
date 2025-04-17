import java.util.*;

public class Main
{
    public static void swap(char[] arr, int k, int i) {
        char temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
        return;
    }
    public static void permutations(char[] arr, int k, int n) {
        if(k == n-1) {
            for(int i=0; i<arr.length;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i=k;i<n;i++) {
            swap(arr, k, i);
            permutations(arr, k+1, n);
            swap(arr, k, i);
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String s = sc.next();
		char[] arr = s.toCharArray();
		int n = arr.length;
		int k = 0;
		System.out.println("Permutations of given string is :");
		permutations(arr,k,n);
	}
}