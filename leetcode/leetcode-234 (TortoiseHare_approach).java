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
    // This is a recursive solution to reverse the linked list.
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
    public boolean isPalindrome(ListNode head) {
        //if the list is empty or has only one element, it is a palindrome.
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        //Using the fast and slow pointer technique to find the middle of the linked list.
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //method to reverse the second half of the linked list.
        ListNode newHead = reverseList(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        //Comparing the first half and the second half of the linked list.
        while(second!=null) {
            //If the values of the first half and the second half are not equal, it is not a palindrome.
            if(first.val != second.val) {
                //If the values are not equal, we reverse the second half back to its original order.
                //This is done to maintain the original structure of the linked list.
                reverseList(newHead);
                return false;
            } 
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }
}