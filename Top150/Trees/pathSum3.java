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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        dfs(root, (long) targetSum, path);
        return count;
    }

    public void dfs(TreeNode root, long targetSum, List<Integer> path) {
        if(root == null) return;

        path.add(root.val);

        long sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) count++;
        }

        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);

        path.remove(path.size() - 1);
    }
}
//Time complexity: O(N^2) in worst case (skewed tree) and O(N log N) in average case (balanced tree)
//Space complexity: O(H) where H is the height of the tree due to recursive stack