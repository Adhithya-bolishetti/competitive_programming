class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int i=0;i<n;i++){
            int pro=nums[i];
            for(int j=i+1;j<n;j++){
                max=Math.max(pro,max);
                pro*=nums[j];
            }
            max=Math.max(pro,max);
        }
        return max;
    }
}