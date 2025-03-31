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
        //If list is empty return null
        if(head == null) return null;
        ListNode temp = head;
        ListNode newHead = null;
        ListNode prev = null;
        
        //Iterate through the list and reverse the links
        //by keeping track of the previous node and the next node
        while(temp != null) {
            //Store the next node in a temporary variable
            ListNode front = temp.next;
            //Reverse the link by pointing the current node to the previous node
            temp.next = prev;
            //Move the previous node to the current node
            prev = temp;
            //head of the new list is the last node we processed
            newHead = temp;
            //Move the current node to the next node
            temp = front;
        }
        return newHead;

    }
}