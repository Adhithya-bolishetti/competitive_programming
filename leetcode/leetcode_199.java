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
    public void sideView(TreeNode node, int level,List<Integer> list) {
        if(node == null) return;
        if(level == list.size()) {
            list.add(node.val);
        }
        sideView(node.right,level+1,list);
        sideView(node.left,level+1,list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sideView(root,0,list);
        return list;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)