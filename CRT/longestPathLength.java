import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class Solution {

    static int maxLength = 0;

    // Recursive function to find longest path with target sum
    public static void findLongestPath(Node node, int targetSum, int currentSum, int length) {
        if (node == null) return;

        currentSum += node.val;
        length++;

        if (currentSum == targetSum) {
            maxLength = Math.max(maxLength, length);
        }

        findLongestPath(node.left, targetSum, currentSum, length);
        findLongestPath(node.right, targetSum, currentSum, length);
    }

    public static int longestTargetPathLength(Node root, int targetSum) {
        maxLength = 0;
        findLongestPath(root, targetSum, 0, 0);
        return maxLength;
    }

    public static Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if (is > ie || ps > pe) return null;

        Node root = new Node(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - is;

        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);
        return root;
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }
        int targetSum = sc.nextInt();

        Node root = buildTree(inorder, postorder);
        int ans = longestTargetPathLength(root, targetSum);
        System.out.println(ans);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)