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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
}
//Time Complexity: O(n) where n is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree. In the worst case, the height of the tree is n, so the space complexity is O(n). In the best case, the height of the tree is log(n), so the space complexity is O(log(n)).