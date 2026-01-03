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
    public void bfs(TreeNode root, int level, List<Integer> list) {
        if(root == null) return;

        if(level == list.size()) {
            list.add(root.val);
        }

        bfs(root.right, level+1, list);
        bfs(root.left, level+1, list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bfs(root, 0, list);
        return list;
    }
}
//Time complexity: O(N) where N is the number of nodes in the tree
//Space complexity: O(H) where H is the height of the tree due to recursive stack