class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0;i<ans.length;i++) {
            ans[i] = -1;
        }
        for(int i=0;i<nums1.length;i++) {
            for(int j=nums2.length-1;j>=0;j--) {
                if(nums2[j] == nums1[i]) break;
                if(nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                }
            }
        }
        return ans;
    }
}