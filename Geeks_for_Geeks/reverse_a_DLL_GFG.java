class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        DLLNode temp = head;
        DLLNode newHead = null;
        while(temp != null) {
            // Swap next and prev pointers
            // for the current node
            DLLNode prevNode = temp.prev;
            temp.prev = temp.next;
            temp.next = prevNode;
            //assign newHead to the last node
            // of the original list
            newHead = temp;
            // Move to the next node in the original list
            temp = temp.prev;
        }
        return newHead;
    }
}