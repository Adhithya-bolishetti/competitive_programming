class Solution {

    public long continuousSubarrays(int[] nums) {
        // TreeMap to store frequency of elements in the current window
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        // Two pointers for the sliding window
        int i = 0, j = 0; 
        int n = nums.length; 
        
        // Variable to store the total count of valid subarrays
        long ans = 0;

        // Iterate through the array using the 'j' pointer
        while (j < n) {
            // Step 1: Include the current element into the window
            tmap.put(nums[j], tmap.getOrDefault(nums[j], 0) + 1);

            // Step 2: Ensure the current window is valid
            // A window is valid if the difference between the maximum and minimum element is ≤ 2
            while (tmap.lastEntry().getKey() - tmap.firstEntry().getKey() > 2) {
                // Decrement the frequency of the element at 'i'
                tmap.put(nums[i], tmap.get(nums[i]) - 1);
                // Remove the element from the map if its frequency becomes 0
                if (tmap.get(nums[i]) == 0) {
                    tmap.remove(nums[i]);
                }
                // Shrink the window by moving the 'i' pointer
                i++;
            }

            // Step 3: Count all valid subarrays ending at index 'j'
            // Each subarray starting from index 'i' to 'j' is valid
            ans += j - i + 1;

            // Expand the window by moving the 'j' pointer
            j++;
        }

        // Return the total count of valid subarrays
        return ans;
    }
}