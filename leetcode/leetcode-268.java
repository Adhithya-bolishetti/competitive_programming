class Solution {
    public int missingNumber(int[] nums) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int val:nums){
        hm.put(val,hm.getOrDefault(val,0)+1);
       }
       for(int i=1;i<=nums.length;i++){
        if(!hm.containsKey(i)){
            return i;
        }
       }
       return 0;
    }
}