class Solution {
    public int houseRob(int[] nums, int index) {
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        int pick = nums[index] + houseRob(nums,index - 2);
        int notPick = 0 + houseRob(nums,index - 1);
        return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        int a = 0;
        int b = 0;
        for(int i=0;i<nums.length;i++) {
            if(i != 0) arr1[a++] = nums[i];
            if(i != nums.length-1) arr2[b++] = nums[i];
        }
        return Math.max(houseRob(arr1,arr1.length-1),houseRob(arr2,arr2.length-1));
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)