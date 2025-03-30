class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        // code here
        if(head==null){
            return new Node(x);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newnode=new Node(x);
        temp.next=newnode;
        return head;
    }
}
