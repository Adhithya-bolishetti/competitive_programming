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
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1) {
                one.next = temp;
                one = temp;
            }
            else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        Node newHead = zeroHead.next;
        return newHead;
    }
}