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
        // If the list is empty, return null
        if(head == null) return null;
        int count = 0;
        ListNode temp = head;
        // Traverse the list to count the number of nodes
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        // middle node is at count/2
        int mid = count/2;
        //
        temp = head;
        int c = 1;
        // Traverse the list again to find the middle node
        while(c <= mid) {
            c++;
            temp = temp.next;
        }
        return temp;
    }
}