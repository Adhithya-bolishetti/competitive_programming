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
    public void markParents(TreeNode node, Map<TreeNode,TreeNode> parentTrack) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                parentTrack.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right != null) {
                parentTrack.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentTrack = new HashMap<>();
        markParents(root,parentTrack);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int currLevel = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(currLevel == k) break;
            currLevel++;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parentTrack.get(curr) != null && visited.get(parentTrack.get(curr)) == null) {
                    q.offer(parentTrack.get(curr));
                    visited.put(parentTrack.get(curr),true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(q.poll().val);
        }
        return list;
    }
}
// Time Complexity: O(N)
// Space Complexity: O(N)