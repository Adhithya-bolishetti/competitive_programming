class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        DLLNode temp = head;
        DLLNode newHead = null;
        while(temp != null) {
            DLLNode prevNode = temp.prev;
            temp.prev = temp.next;
            temp.next = prevNode;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }
}