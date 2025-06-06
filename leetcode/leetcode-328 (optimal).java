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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even!=null && even.next!=null) {
            odd.next = even.next;    // link odd to the next odd node
            odd = odd.next;          // move odd forward
            even.next = odd.next;    // link even to the next even node
            even = even.next; 
        }
        odd.next = evenHead;
        return head;
    }
}