class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        for(int i = 0 ; i <arr.length; i++){
            
            sum+=arr[i];
            
            if(sum == k){
                max = Math.max(max , i+1);
            }
            if(!map.containsKey(sum)){
             map.put(sum,i);   
            }
            if(map.containsKey(sum-k)){
             int index = map.get(sum-k);
             max = Math.max(max, i - index );
            }
        }
        return max;
    }
}