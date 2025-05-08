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
    public int maxSum(TreeNode node,int[] max) {
        if(node == null) return 0;
        int leftSum = Math.max(0,maxSum(node.left,max));
        int rightSum = Math.max(0,maxSum(node.right,max));
        max[0] = Math.max(max[0],leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSum(root,max);
        return max[0];
    }
}
// Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
// Space Complexity: O(h) where h is the height of the tree. This is the space used by the recursion stack.