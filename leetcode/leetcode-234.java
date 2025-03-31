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
    public boolean isPalindrome(ListNode head) {
        // This is a stack based approach to check if the linked list is palindrome or not.
       Stack<Integer> st = new Stack<>();
       ListNode temp = head;
         // Traverse the linked list and push all the elements into the stack.
       while(temp != null) {
        st.push(temp.val);
        temp = temp.next;
       }
        // Now traverse the linked list again and check if the elements are same as the elements popped from the stack.
        temp = head;
        while(temp != null) {
            // If the element at the current node is not equal to the element popped from the stack, return false.
            if(temp.val != st.peek()) return false;
            // If the element is equal, pop the element from the stack.
            // Move to the next node in the linked list.
            temp = temp.next;
            st.pop();
        }
        return true;
    }
}