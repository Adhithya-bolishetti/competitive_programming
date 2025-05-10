class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size]; // For inserting at specific index
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(Arrays.asList(level));
            leftToRight = !leftToRight;
        }
        return res;
    }
}
//Time Complexity: O(n), where n is the number of nodes in the tree. Each node is processed once.
//Space Complexity: O(n), where n is the number of nodes in the tree. The queue can hold up to n/2 nodes at a time in the worst case.