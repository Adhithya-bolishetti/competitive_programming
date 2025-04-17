import java.util.*;

public class subsetOfSizeK
{
    public static void generateSubsets(int[] arr,int n,int index,int[] subsets,int ssize,int k) {
        if(index == n) {
            if(ssize == ) {
                System.out.print("[ ");
                for(int i=0;i<ssize;i++) {
                    System.out.print(subsets[i]+" ");
                }
                System.out.println("]");
            }
            return;
        }
        generateSubsets(arr,n,index+1,subsets,ssize,k);
        subsets[ssize] = arr[index];
        generateSubsets(arr,n,index+1,subsets,ssize+1,k);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		System.out.println("Enter array :");
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		System.out.println("Enter subset size :");
		int k = sc.nextInt();
		int index = 0;
		int[] subsets = new int[(int)Math.pow(2,n)];
		int ssize = 0;
		System.out.println("Subsets for given array are :");
		generateSubsets(arr,n,index,subsets,ssize,k);
	}
}