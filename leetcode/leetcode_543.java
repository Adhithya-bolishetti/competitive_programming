/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];  // mutable container to hold max value
        max[0] = 0;
        depth(root, max);
        return max[0];
    }

    private int depth(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = depth(node.left, max);
        int right = depth(node.right, max);
        max[0] = Math.max(max[0], left + right);  // update max diameter
        return 1 + Math.max(left, right);         // return depth
    }
}
//Time Complexity: O(n), where n is the number of nodes in the tree. We visit each node once.
//Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack space used during the depth-first traversal.