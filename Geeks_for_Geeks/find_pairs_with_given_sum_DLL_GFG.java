class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node front = head;
        Node back = head;
        // Move back pointer to the last node
        while(back.next != null) {
            back = back.next;
        }
        // Traverse the list with two pointers
        // front starts from the beginning and back starts from the end
       while (front != null && back != null && front != back && back.next != front) {
            int sum = front.data + back.data;
            // If the sum is equal to the target, add the pair to the list
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(front.data);
                pair.add(back.data);
                list.add(pair);

                front = front.next;
                back = back.prev;
            } 
            // If the sum is greater than the target, move the back pointer backward
            else if (sum > target) {
                back = back.prev;
            } 
            // If the sum is less than the target, move the front pointer forward
            else {
                front = front.next;
            }
        }
        return list;
    }
}