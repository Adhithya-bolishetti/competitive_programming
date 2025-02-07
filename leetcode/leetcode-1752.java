class Solution {
    public boolean check(int[] nums) {
       List<Integer> list1=new ArrayList<>();
       List<Integer> list2=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        list1.add(nums[i]);
        list2.add(nums[i]);
       }
       Collections.sort(list2);
       int k=0;
       for(int i=0;i<nums.length;i++){
        if(k<=nums.length){
            list1.remove(0);
            list1.add(nums[i]);
            if(list1.equals(list2)){
                return true;
            }
        }
       }
       return false; 
    }
}