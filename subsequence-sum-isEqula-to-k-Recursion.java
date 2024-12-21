import java.util.*;
public class Main {
    public static void printF(int ind, List<Integer> ds, int[] arr, int k,int sum,int n) {
        if (ind == n) {
            // Check if the sum of the current subsequence equals the target
            if (sum == k) {
                        System.out.println(ds);
            }
            return;
        }
        // Take or pick the particular index into the subsequence
        ds.add(arr[ind]);
        printF(ind + 1, ds,arr, k,sum+arr[ind],n);
        ds.remove(ds.size() - 1);

        // Not pick, or not take condition, this element is not added to your subsequence
        printF(ind + 1, ds, arr, k,sum,n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        s=s.replaceAll("\\[|\\]","");
        String[] input=s.split(",");
        int[] arr=new int[input.length];
        for(int i=0;i<input.length;i++){
            arr[i]=Integer.parseInt(input[i]);
        }
        int n=arr.length;
        List<Integer> ds = new ArrayList<>();
        int k=2;
        int sum=0;
        printF(0, ds, arr,k,sum,n);
    }
}
