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
     public int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int lh = maxDepth(node.left);
        if(lh == -1) return -1;
        int rh = maxDepth(node.right);
        if(rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return maxDepth(root) != -1;
    }
}
// Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
// Space Complexity: O(h) where h is the height of the tree. This is the space used by the recursion stack.