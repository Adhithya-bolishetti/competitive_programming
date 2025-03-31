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
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node, return it as is.
        if(head == null || head.next == null) {
            return head;
        }
        // Recursive case: reverse the rest of the list and set the next node's next pointer to the current node.
        // Then set the current node's next pointer to null to avoid cycles.
        ListNode newHead = reverseList(head.next);
        // The next node after the current head is now the front of the reversed list.
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}