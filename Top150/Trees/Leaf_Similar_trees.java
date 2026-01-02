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
    public void findNodes(List<TreeNode> list, TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null) list.add(root);
        if(root.left != null) findNodes(list, root.left);
        if(root.right != null) findNodes(list, root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        findNodes(list1, root1);
        findNodes(list2, root2);

        if(list1.size() != (list2.size())) return false;

        for(int i=0;i<list1.size();i++) {
            if(list1.get(i).val != list2.get(i).val) return false;
        }

        return true;
    }
}
//Time complexity: O(N + M) where N and M are number of nodes in both trees
//Space complexity: O(H1 + H2) where H1 and H2 are heights