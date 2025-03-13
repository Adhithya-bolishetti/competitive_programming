class Solution {
    public int findKthPositive(int[] arr, int k) {
       ArrayList<Integer> l = new ArrayList<>();
       for(int i=0;i<arr.length;i++){
        l.add(arr[i]);
       }
        int i=0;
        while(k>0){
            i++;
            if(!l.contains(i)) k--;
        }
        return i;
    }
}