/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        if(head.next == null) return head;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        Node temp = head;
        while(temp != null) {
            // Count the number of 0s, 1s and 2s
            if(temp.data == 0) count0++;
            else if(temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            // Update the data of the nodes based on the counts
            if(count0 > 0) {
                temp.data = 0;
                count0--;
            }
            else if(count1 > 0) {
                temp.data = 1;
                count1--;
            }
            else {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }
}