class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int temp=nums.length/3;
        Map<Integer,Integer> hm=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int key:hm.keySet()){
            if(hm.get(key)>temp){
                list.add(key);
            }
        }
        return list;
    }
}