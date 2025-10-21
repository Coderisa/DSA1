class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);  // Ignore negative paths
        int rightGain = Math.max(maxGain(node.right), 0);

        // Path sum including both children and current node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max if current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain to parent (only one side can be chosen)
        return node.val + Math.max(leftGain, rightGain);
    }
}
