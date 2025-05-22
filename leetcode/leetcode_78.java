class Solution {
    public void printSubsets(int[] nums,int index,int[] subsets,int subsetSize, List<List<Integer>> list,int n) {
        if(index == n) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<subsetSize; i++) {
                temp.add(subsets[i]);
            }
            list.add(temp);
            return;
        }
        printSubsets(nums,index+1,subsets,subsetSize,list,n);
        subsets[subsetSize] = nums[index];
        printSubsets(nums,index+1,subsets,subsetSize+1,list,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] subsets = new int[n];
        printSubsets(nums,0,subsets,0,list,n);
        return list;
    }
}
//Time complexity : O(n * 2 ^ n)
//Space complexity : O(n * 2 ^ n)