class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> nge = new HashMap<>();

        for(int i=0;i<n2;i++) {
            int j= i + 1;
            while(j < n2 && nums2[j] < nums2[i]) j++;
            nge.put(nums2[i], (j >= n2) ? -1 : nums2[j]);
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