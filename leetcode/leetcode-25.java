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
    public ListNode getKthNode(ListNode temp,int k) {
        while(temp != null && k > 1) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) return head;
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp != null) {
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode == null) {
                if(prevLast != null) prevLast.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if(temp == head) {
                head = kthNode;
            }
            else {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
}