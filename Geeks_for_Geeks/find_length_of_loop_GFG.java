/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        //if the list is empty or has only one node, return 0
        // as there can't be a loop in such cases.
        if(head == null || head.next == null) return 0;
        // Create a HashMap to store the nodes and their corresponding indices.
        // The key is the node and the value is the index of the node in the linked list.
        HashMap<Node,Integer> hm = new HashMap<>();
        Node temp = head;
        int timer = 0;
        // Traverse the linked list and check if the node is already present in the map.
        while(temp!=null) {
            timer++;
            // If the node is already present in the map, it means we have a loop.
            // In that case, we return the difference between the current index and the index of the node in the map.
            if(hm.containsKey(temp)) {
                return timer-hm.get(temp);
            }
            // If the node is not present in the map, we add it to the map with its index.
            hm.put(temp,timer);
            // Move to the next node.
            temp = temp.next;
        }
        return 0;
    }
}