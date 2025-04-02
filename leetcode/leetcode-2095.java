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
    public ListNode deleteMiddle(ListNode head) {
        // if the list is empty or has only one node, return null
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // use fast and slow pointers to find the middle node
        fast = fast.next.next;
        // if the list has an even number of nodes, slow will point to the node before the middle
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // delete the middle node
        slow.next = slow.next.next;
        return head;
    }
}