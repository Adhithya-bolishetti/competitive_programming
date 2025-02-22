class Solution {
    int maxLen(int arr[]) {
        // code here
        int n=arr.length;
        int sum=0;
        int max=0;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }
            else{
                if(hm.containsKey(sum)){
                    max=Math.max(max,i-hm.get(sum));
                }
                else{
                    hm.put(sum,i);
                }
            }
        }
        return max;
    }
}