/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int addHelper(Node temp) {
        if(temp == null) return 1;
        int carry = addHelper(temp.next);
        temp.data += carry;
        if(temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }
    public Node addOne(Node head) {
        // code here.
        if(head.next == null) {
            head.data += 1;
            return head;
        }
        int carry = addHelper(head);
        if(carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
