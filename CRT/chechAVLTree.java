import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main
{
    public static int checkAVL(TreeNode root, boolean avl) {
        if(avl ==  false) return -1;
        if(root == null) return 0;
        int left = checkAVL(root.left, avl);
        int right = checkAVL(root.right, avl);
        int val = left - right;
        if(val > 1 || val < 1) {
            avl = false;
            return -1;
        }
        return 1 + Math.max(left, right);
    }
    public static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm) {
        if(is>ie || ps>pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - is;
        root.left = buildTreePostIn(inorder, is, inRoot-1, postorder, ps, ps+numsLeft-1, hm);
        root.right = buildTreePostIn(inorder, inRoot+1, ie, postorder, ps+numsLeft, pe-1, hm);
        return root;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            hm.put(inorder[i],i);
        }
        return buildTreePostIn(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] inorder = new int[n];
		for(int i=0; i<n; i++) {
		    inorder[i] = sc.nextInt();
		}
		int[] postorder = new int[n];
		for(int i=0; i<n; i++) {
		    postorder[i] = sc.nextInt();
		}
		TreeNode root = buildTree(inorder, postorder);
		
		if(root.left == null && root.right == null) System.out.print("True");
		else {
		    int ans = checkAVL(root, true);
		    System.out.print(ans == - 1 ? "False" : "True");
	    }
	}
}