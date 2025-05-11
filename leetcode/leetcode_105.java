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
    public TreeNode buildTreePreIn(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer,Integer> hm) {
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int inRoot = hm.get(preorder[ps]);
        int numsLeft = inRoot - is;
        root.left = buildTreePreIn(preorder,ps+1,ps+numsLeft,inorder,is,inRoot-1,hm);
        root.right = buildTreePreIn(preorder,ps+numsLeft+1,pe,inorder,inRoot+1,ie,hm);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            hm.put(inorder[i],i);
        }
        return buildTreePreIn(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)