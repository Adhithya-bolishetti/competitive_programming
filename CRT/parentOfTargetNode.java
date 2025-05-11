import java.util.*;

class TreeNode {
    char c;
    TreeNode left, right;

    public TreeNode(char c) {
        this.c = c;
    }
}

public class parentOfTargetNode {
    public static Character findParent(TreeNode node, char target, TreeNode parent) {
        if (node == null) return null;
        if (node.c == target) {
            return parent != null ? parent.c : null;
        }
        Character left = findParent(node.left, target, node);
        if (left != null) return left;
        return findParent(node.right, target, node);
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
    public static boolean exists(TreeNode node, char target) {
        if (node == null) return false;
        if (node.c == target) return true;
        return exists(node.left, target) || exists(node.right, target);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inorder = sc.nextLine().trim();
        String postorder = sc.nextLine().trim();
        char key = sc.nextLine().trim().charAt(0);
        TreeNode root = buildTree(inorder, postorder);
        if (!exists(root, key)) {
            System.out.println(-1);
        } else {
            Character parent = findParent(root, key, null);
            if(parent == null) System.out.println("-1");
            else System.out.print(parent);
        }
    }
}










// Given two strings Inorder, Postorder and a search key element of binary tree, you need to find out parent of search key element.
//  If search key is not there or If there is no parent for search key element then return the whole answer or output as -1. 
//  Each character in a string represents node of binary tree.
// TEST CASE 1

// INPUT

// HDIBJEKALFMCNGO

// HIDJKEBLMFNOGCA

// F

// OUTPUT

// C
