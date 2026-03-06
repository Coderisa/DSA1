//o(n^2) , o(h)
class Solution {
    // Helper function to calculate height of a tree
    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH, rightH) + 1;
    }

    // Main function to check if tree is balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
/*
OPTIMAL APPROACH - O(N), O(h)

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
*/