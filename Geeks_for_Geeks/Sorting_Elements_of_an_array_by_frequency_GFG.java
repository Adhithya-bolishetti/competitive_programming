import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0) {
	        int n = sc.nextInt();
	        Integer[] arr = new Integer[n];
	        for(int i=0; i<n; i++) {
	            arr[i] = sc.nextInt();
	        }
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int val : arr) {
	            map.put(val, map.getOrDefault(val, 0)+1);
	        }
	        Arrays.sort(arr, new Comparator<Integer>() {
	            public int compare(Integer a, Integer b) {
	                if(map.get(a) != map.get(b)) {
	                    return map.get(b) - map.get(a);
	                }
	                else {
	                    return a - b;
	                }
	            }
	        });
	        
	        for(int val : arr) {
	            System.out.print(val+" ");
	        }
	        System.out.println();
	    }
	 }
}
// Time complexity : O(n logn)
// Space complexity : O(n)