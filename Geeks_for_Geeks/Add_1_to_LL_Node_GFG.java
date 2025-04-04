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
    public Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        if(head.next == null) {
            head.data += 1;
            return head;
        }
        Node newHead = reverseList(head);
        Node temp = newHead;
        int carry = 1;
        while(temp != null) {
            temp.data += carry;
            if(temp.data < 10) {
                carry = 0;
                break;
            }
            else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        reverseList(newHead);
        if(carry == 1) {
            Node newNode = new Node(1);
            reverseList(newHead);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
}