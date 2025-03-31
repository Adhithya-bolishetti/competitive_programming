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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        // The fast pointer moves two steps at a time while the slow pointer moves one step at a time.
        // If there is a cycle, the fast pointer will eventually meet the slow pointer.
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            // If the fast pointer meets the slow pointer, it means there is a cycle.
            if(slow == fast) return true;
        }
        return false;
    }
}