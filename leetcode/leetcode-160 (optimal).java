/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA = 0;
        int countB = 0;
        while(tempA != null) {
            countA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            countB++;
            tempB = tempB.next;
        }
        int diff = countA-countB;
        tempA = headA;
        tempB = headB;
        if(diff > 0) {
            while(diff > 0) {
                diff--;
                tempA = tempA.next;
            }
        }
        else if(diff < 0) {
            while(diff < 0) {
                diff++;
                tempB = tempB.next;
            }
        }
        while(tempA != null && tempB != null) {
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}