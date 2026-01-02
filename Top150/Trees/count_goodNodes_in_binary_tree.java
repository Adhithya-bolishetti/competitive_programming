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
    public int dfs(TreeNode root, int max) {
        if(root == null) return 0;

        int count = 0;

        if(root.val >= max) count = 1;

        int newMax = Math.max(max, root.val);

        count += dfs(root.left, newMax);
        count += dfs(root.right, newMax);

        return count;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
//Time complexity: O(N)
//Space complexity: O(H) where H is the height of the tree due to recursive stack