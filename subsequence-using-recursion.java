import java.util.*;
public class Main {
    public static void printF(int ind, List<Integer> ds, int[] arr, int n) {
        if (ind == n) {
            if (ds.isEmpty()) {
                System.out.print("{}");
            } else {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
            }
            System.out.println();
            return;
        }

        // Take or pick the particular index into the subsequence
        ds.add(arr[ind]);
        printF(ind + 1, ds, arr, n);
        ds.remove(ds.size() - 1);

        // Not pick, or not take condition, this element is not added to your subsequence
        printF(ind + 1, ds, arr, n);
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
        printF(0, ds, arr, n);
    }
}
