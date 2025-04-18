class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--) {
            int currVal = nums2[i];
            while(!st.isEmpty() && st.peek() <= currVal) {
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