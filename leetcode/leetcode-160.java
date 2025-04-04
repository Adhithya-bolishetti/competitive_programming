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
        HashMap <ListNode,Integer> hm = new HashMap<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null) {
            hm.put(tempA,1);
            tempA = tempA.next;
        }
        while(tempB != null) {
            if(hm.containsKey(tempB)) {
                return tempB;
            }
            hm.put(tempB,1);
            tempB = tempB.next;
        }
        return null;
    }
}