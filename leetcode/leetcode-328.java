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
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        // Traverse the odd indexed nodes and add them to the list
        while(temp!=null) {
            list.add(temp.val);
            // Check if the next node is null to avoid NullPointerException
            if(temp.next == null) break;
            temp = temp.next.next;
        }
        // Traverse the even indexed nodes and add them to the list
        temp = head.next;
         while(temp.next!=null) {
            list.add(temp.val);
            // Check if the next node is null to avoid NullPointerException
            if(temp.next.next == null) break;
            temp = temp.next.next;
        }
        temp = head;
        // Reassign the values of the original list with the values from the list
        for(int i=0;i<list.size();i++) {
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
}