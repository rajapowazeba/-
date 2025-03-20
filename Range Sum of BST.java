class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumHelper(root, low, high);
    }

    private int rangeSumHelper(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if (node.val > low) {
            sum += rangeSumHelper(node.left, low, high);
        }

        if (node.val < high) {
            sum += rangeSumHelper(node.right, low, high);
        }

        return sum;
    }
}
