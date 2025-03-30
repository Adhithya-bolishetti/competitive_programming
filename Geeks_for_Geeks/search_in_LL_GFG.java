class Solution {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        if(head == null) return false;
        Node temp = head;
        while(temp != null){
            if(key == temp.data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}