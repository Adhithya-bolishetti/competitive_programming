/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Use Floyd's Tortoise and Hare algorithm to detect cycle
        // and find the start of the cycle.

        //if the list is empty or has only one node, return null
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // Move slow pointer by 1 step and fast pointer by 2 steps
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            // If slow and fast pointers meet, there is a cycle
            // Now we need to find the start of the cycle
            if(slow == fast) {
                // Move one pointer to the head of the list
                slow = head;
                // Move both pointers by 1 step until they meet again
                // The meeting point is the start of the cycle
                while(slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // Return the start of the cycle
                // The slow pointer is now at the start of the cycle
                return slow;
            }
        }
        return null;
    }
}