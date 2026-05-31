/*
 class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recurse on left and right subtrees with reduced target
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
         // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
    return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum- root.val);
    }
}