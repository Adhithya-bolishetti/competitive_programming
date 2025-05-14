/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findPath(TreeNode node, int target, List<TreeNode> list) {
        if(node == null) return false;
        list.add(node);
        if(node.val == target) return true;
        if(findPath(node.left,target,list) || findPath(node.right,target,list)) {
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        findPath(root,p.val,l1);
        findPath(root,q.val,l2);
        int size = Math.min(l1.size(),l2.size());
         TreeNode lca = null;
        for (int i = 0; i < size; i++) {
            if (l1.get(i).val == l2.get(i).val) {
                lca = l1.get(i); 
            } else {
                break; 
            }
        }
        return lca;
    }
}
// Time complexity: O(n)
// Space complexity: O(n)