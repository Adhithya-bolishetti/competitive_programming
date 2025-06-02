import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSum(int[] arr, int index, int k) {
        if(k == 0) return true;
        if(index == 0) return arr[index] == k;

        boolean notPick = subsetSum(arr, index-1, k);
        boolean pick = false;
        if(k >= arr[index]) pick = subsetSum(arr, index-1, k-arr[index]);

        return notPick || pick ? true : false;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return subsetSum(arr, n-1, k);
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)