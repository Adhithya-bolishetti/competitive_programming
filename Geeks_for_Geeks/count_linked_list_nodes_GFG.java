class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        
        if(head == null) return 0;
        
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}