import java.util.*;

class Solution {
    int minOperations(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int val : arr) {
            pq.add(val);
        }
        
        int count = 0;
        
        while (pq.size() >= 2 && pq.peek() < k) {
            int first = pq.poll();     // smallest
            int second = pq.poll();    // second smallest
            int combined = first + second;
            pq.add(combined);
            count++;
        }
        
        // After the loop, check if the smallest is still < k
        if (pq.peek() < k) return -1;
        
        return count;
    }
}
// Time complexity : O(nlogn)
// Space complexity : O(n)