class Solution {
    public boolean chechTrionic(int[] nums, int p, int q) {
        for(int i=1; i<=p; i++) {
            if(nums[i] > nums[i-1]) continue;
            else return false;
        }
        for(int i=p+1; i<=q; i++) {
            if(nums[i] < nums[i-1]) continue;
            else return false;
        }
        for(int i=q+1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) continue;
            else return false;
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        if(nums.length <= 3) return false;
        int p, q;
        for(p = 1; p<nums.length-2; p++) {
            for(q=p+1; q<nums.length-1; q++) {
                if(chechTrionic(nums, p, q)) return true;
            }
        }

        return false;
    }
}