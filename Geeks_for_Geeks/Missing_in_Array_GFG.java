class Solution {
    int missingNum(int arr[]) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr) {
            set.add(val);
        }
        
        for(int i=1; i<=arr.length+1; i++) {
            if(!set.contains(i)) return i; 
        }
        
        return -1;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)