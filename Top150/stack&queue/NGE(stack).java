import java.util.*;
class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		Solution sol = new Solution();
		int[] res = sol.nextLargerElement(arr);
		
		for(int i=0;i<n;i++) {
		    System.out.print(res[i]+" ");
		}
	}
}
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)