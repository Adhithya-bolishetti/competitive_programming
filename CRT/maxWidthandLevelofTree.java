import java.io.*;
import java.util.*;

class TreeNode {
    char c;
    TreeNode left, right;

    public TreeNode(char c) {
        this.c = c;
    }
}
public class MaxWidthandLevelofTree {
    public static int[] getMaxWidthAndLevel(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        int maxLevel = 1;
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > maxWidth) {
                maxWidth = size;
                maxLevel = level;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }

        return new int[]{maxLevel, maxWidth};
    }
    public static TreeNode buildTreePostIn(String inorder, int is, int ie, String postorder, int ps, int pe, HashMap<Character, Integer> hm) {
        if (is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder.charAt(pe));
        int inRoot = hm.get(postorder.charAt(pe));
        int numsLeft = inRoot - is;

        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);

        return root;
    }
    public static TreeNode buildTree(String inorder, String postorder) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length(); i++) {
            hm.put(inorder.charAt(i), i);
        }
        return buildTreePostIn(inorder, 0, inorder.length() - 1, postorder, 0, postorder.length() - 1, hm);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inorder = sc.nextLine().trim();
        String postorder = sc.nextLine().trim();
        TreeNode root = buildTree(inorder, postorder);
        int[] res = getMaxWidthAndLevel(root);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}











// Given two strings Inorder and Postorder of binary tree, you need to find out level with maximum width and also return value of maximum width. Maximum width of binary tree is the maximum number of nodes present in a level. If more than one level has same maximum number of nodes then consider lowest level number. Each character in a string represents a node in binary tree. Time complexity – O(N) String lengths > 0 Hint – use level order traversal to keep track of number of nodes at each level. Maintain a queue to keep of nodes at each level.

// TEST CASE 1

// INPUT

// HDIBJEKALFMCNGO

// HIDJKEBLMFNOGCA

// OUTPUT

// 4

// 8

// TEST CASE 2

// INPUT

// DCBA

// DCBA

// OUTPUT

// 1

// 1

// TEST CASE 3

// INPUT

// DBGEACHF

// DGEBHFCA

// OUTPUT

// 3

// 3

// Input Format

// first two lines are strings

// Constraints

// string lengths should be > 0

// Output Format

// two lines , first line represents level number and second line is maximum width