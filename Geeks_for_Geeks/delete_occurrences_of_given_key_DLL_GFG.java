
/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node temp = head;
        while(temp != null) {
            if(temp.data == x) {
                // If the node to be deleted is the head node
                // then we need to update the head pointer
                if(temp == head) {
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                // If the node to be deleted is the last node
                // then we need to update the last pointer
                if(nextNode != null) nextNode.prev = prevNode;
                // If the node to be deleted is the first node
                // then we need to update the first pointer
                if(prevNode != null) prevNode.next = nextNode;
                temp = nextNode;
            }
            else temp = temp.next;
        }
        return head;
    }
}