class Solution {
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        HAshMap<Integer, Integer> map=new HashMap();
        
        for(int i=0; i<n; i++){
            int val=arr[i];
            if( map.containsKey(val*2)){
                return true;
            }
            else if(val%2==0 && map.containsKey(val/2)){
                return true;
            }
            map.put(val, map.getOrDefault(val,0)+1);            
        }



        return false;
    }
}