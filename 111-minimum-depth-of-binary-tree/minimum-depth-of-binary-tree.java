class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If one child is null, we must go down the other side
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        // If both children exist, take the minimum of the two depths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
