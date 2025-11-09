class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> nge = new HashMap<>();

        for(int i=n2-1;i>=0;i--) {
            while(!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            nge.put(nums2[i], st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        int[] res = new int[n1];
        for(int i=0;i<n1;i++) {
            res[i] = nge.get(nums1[i]);
        }

        return res;
    }
}
//Time Complexity: O(n1 + n2)
//Space Complexity: O(n2)