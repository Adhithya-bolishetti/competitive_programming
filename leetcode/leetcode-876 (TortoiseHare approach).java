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
    public ListNode middleNode(ListNode head) {
        // This is the slow and fast pointer approach.

        //if the list is empty, return null
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        //move the fast pointer two steps and slow pointer one step
        //when fast pointer reaches the end, slow pointer will be at the middle
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}