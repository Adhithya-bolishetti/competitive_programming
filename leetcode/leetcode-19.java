/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);  // Dummy node to handle edge cases
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Move 'fast' n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move 'fast' to the end, keeping 'slow' behind
        // 'slow' will be at the node before the one we want to remove
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}