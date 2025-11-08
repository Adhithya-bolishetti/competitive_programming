class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && k == 1) return nums;
        
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for(int i=0;i<n;i++) {
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k -1) {
                res[index++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(k)