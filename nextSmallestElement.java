import java.util.*;

class NextSmallestElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n1 :");
		int n1 = sc.nextInt();
		int[] nums1 = new int[n1];
		System.out.println("Enter nums1");
		for(int i=0;i<n1;i++) {
		    nums1[i] = sc.nextInt();
		}
		System.out.println("Enter n2");
		int n2 = sc.nextInt();
		int[] nums2 = new int[n2];
		System.out.println("Enter nums2");
		for(int i=0;i<n2;i++) {
		    nums2[i] = sc.nextInt();
		}
		Solution sol = new Solution();
		int[] ans = sol.nextGreaterElement(nums1,nums2);
		System.out.println("result");
		System.out.print("[");
		for(int i=0;i<ans.length;i++) {
		    System.out.print(ans[i]+" ");
		}
		System.out.print("]");
	}
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--) {
            int currVal = nums2[i];
            while(!st.isEmpty() && st.peek() >= currVal) {
                st.pop();
            }
            if(st.isEmpty()) {
                hm.put(currVal,-1);
            }
            else {
                hm.put(currVal,st.peek());
            }
            st.push(currVal);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<ans.length;i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}