import java.io.*;
import java.util.*;

class Node {
    char c;
    Node left;
    Node right;

    public Node(char c) {
        this.c = c;
    }
}

public class Solution {

    static int maxSubtreeSize = 0;

    public static int dfs(Node node, boolean isRoot) {
        if (node == null) return 0;

        int leftSize = dfs(node.left, false);
        int rightSize = dfs(node.right, false);
        int totalSize = 1 + leftSize + rightSize;

        if (!isRoot) {
            maxSubtreeSize = Math.max(maxSubtreeSize, totalSize);
        }

        return totalSize;
    }

    public static Node buildTreePostIn(String inorder, int is, int ie,
                                       String postorder, int ps, int pe,
                                       HashMap<Character, Integer> hm) {
        if (is > ie || ps > pe) return null;

        Node root = new Node(postorder.charAt(pe));
        int inRoot = hm.get(postorder.charAt(pe));
        int numsLeft = inRoot - is;

        root.left = buildTreePostIn(inorder, is, inRoot - 1,
                                    postorder, ps, ps + numsLeft - 1, hm);
        root.right = buildTreePostIn(inorder, inRoot + 1, ie,
                                     postorder, ps + numsLeft, pe - 1, hm);
        return root;
    }

    public static Node buildTree(String inorder, String postorder) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length(); i++) {
            hm.put(inorder.charAt(i), i);
        }

        return buildTreePostIn(inorder, 0, inorder.length() - 1,
                               postorder, 0, postorder.length() - 1, hm);
    }

    public static int largestSubTree(Node root) {
        dfs(root, true); 
        return maxSubtreeSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inorder = sc.nextLine();
        String postorder = sc.nextLine();
        Node root = buildTree(inorder, postorder);
        int ans = largestSubTree(root);
        System.out.println(ans);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)