class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        if(head == null) return null;
        int count = 0;
        Node temp = head;
        while(temp != null) {
            if(count == p) break;
            count++;
            temp = temp.next;
        }
        Node newNode = new Node(x);
        
        newNode.next = temp.next;
        newNode.prev = temp;
        
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        
        temp.next = newNode;
        
        return head;
    }
}