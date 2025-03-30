class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i<arr.length; i++){
            Node newNode =  new Node(arr[i]);
            newNode.prev = prev;
            newNode.next = null;
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }
}