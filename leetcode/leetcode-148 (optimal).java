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
    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // Move temp forward
        }
        temp.next = (list1 != null) ? list1 : list2; // Append remaining nodes
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next; // This ensures correct splitting for even-length lists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node before splitting
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Get the middle node
        ListNode mid = middleNode(head);
        ListNode right = mid.next;
        mid.next = null; // Split the list

        // Recursively sort both halves
        ListNode left = sortList(head);
        right = sortList(right);

        // Merge the sorted halves
        return mergeLists(left, right);
    }
}
