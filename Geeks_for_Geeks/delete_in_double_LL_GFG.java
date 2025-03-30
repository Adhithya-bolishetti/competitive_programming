class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(head == null) return null;
        Node temp = head;
        int count = 0;
        while(temp.next != null) {
            count++;
            if(count == x) break;
            temp = temp.next;
        }
        Node back = temp.prev;
        Node front = temp.next;
        if(back == null && front == null) {
            return null;
        }
        else if(back == null) {
            temp.next = null;
            head = front;
            front.prev = null;
        }
        else if(front == null){
            temp.prev = null;
            back.next = null;
        }
        else{
            back.next = front;
            front.prev = back;
            back = null;
            front = null;
        }
        return head;
    }
}
