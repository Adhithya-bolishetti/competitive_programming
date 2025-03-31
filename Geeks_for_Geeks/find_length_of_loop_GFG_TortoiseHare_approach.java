// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int findLength(Node slow, Node fast) {
        int count = 1;
        slow = slow.next;
        //until slow and fast meet again, we will keep moving slow pointer one step and count the number of steps taken.
        while(slow != fast) {
            slow = slow.next;
            count++;
        }
        return count;
    }
    public int countNodesinLoop(Node head) {
        // if the list is empty or has only one node, return 0
        // as there can't be a loop in such cases.
        if(head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        // we will move slow pointer one step and fast pointer two steps.
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            // if slow and fast meet, it means there is a loop.
            if(slow == fast) {
                // we will call the findLength function to find the length of the loop.
                return findLength(slow,fast);
            }
        }
        return 0;
    }
}