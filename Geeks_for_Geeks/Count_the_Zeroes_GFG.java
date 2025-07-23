// User function Template for Java

class Solution {
    int countZeroes(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr) {
            map.put(val, map.getOrDefault(val, 0) +1);
        }
        
        return map.get(0);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)