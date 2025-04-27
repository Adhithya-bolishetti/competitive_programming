import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == 1) return nums;
        
        Deque<Integer> dq = new LinkedList<>(); // Store indices
        int[] ans = new int[n - k + 1];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.addLast(i); // Add current index
            
            // Start adding maximums to ans array once the first window is hit
            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        
        return ans;
    }
}
