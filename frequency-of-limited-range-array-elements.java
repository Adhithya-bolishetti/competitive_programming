class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        List<Integer> li=new ArrayList<>();
        for(int i=1;i<=arr.length;i++){
            li.add(hm.getOrDefault(i,0));
        }
        return li;
    }
}
