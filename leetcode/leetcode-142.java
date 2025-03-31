/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //define a HashMap to store the nodes and their values
       HashMap <ListNode, Integer> hm = new HashMap<>();
       ListNode temp = head;
         //traverse the linked list and check if the node is already present in the map
        while(temp!=null) {
        //if the node is already present in the map, it means we have a cycle
        //and we return the node
        if(hm.containsKey(temp)) return temp;
        //if the node is not present in the map, we add it to the map
        hm.put(temp,1);
        //move to the next node
        temp = temp.next;
       }
        return null;
    }
}