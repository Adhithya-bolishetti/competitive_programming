/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class leetcode_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("#,");
            } else {
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode curr = q.poll();

            // Left
            if (!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                q.offer(left);
            }
            i++;

            // Right
            if (i < nodes.length && !nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                q.offer(right);
            }
            i++;
        }

        return root;
    }
}
//Time complexity: O(n)
//Space complexity: O(n)